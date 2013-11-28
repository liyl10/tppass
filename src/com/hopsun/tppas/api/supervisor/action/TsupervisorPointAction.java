/************************* 版权声明 *********************************
 *
 * Copyright (C) 2012 西安辉盛科技发展有限责任公司.
 *
 ******************************************************************
 */
package com.hopsun.tppas.api.supervisor.action;

import java.util.Date;

import com.hopsun.scenter.entity.ScUsers;
import com.hopsun.tppas.api.supervisor.service.TsupervisorPointService;
import com.hopsun.tppas.common.Constants;
import com.hopsun.tppas.entity.TsupervisorPoint;
import com.hopsun.framework.base.action.BaseAction;
import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

/**
 * 项目监理点
 *@comments
 *@author wangxiaodong
 *@date 2013-9-17
 *@version 1.0
 */
public class TsupervisorPointAction extends BaseAction{
  
	private static final long serialVersionUID = 5944526644724595303L;
	
	@Resource
	private TsupervisorPointService tsupervisorPointService;
	
	/**监理点对象*/
	private TsupervisorPoint supervisorPoint;
	
	/**监理ID*/
	private String supervisorId;
	
	/**项目ID*/
	private String projectId;
	
	/**监理点ID*/
	private String pointId;
	
	/** 跳转路径**/
	private String retUrl;

	/** 跳转页面massage**/
	private String retMsg;
	
	/**
	 * 监理点新增初始页面
	 * @comments 
	 * @return
	 * @version 1.0
	 */
	public String forwardInsert(){
		// 取得登录用户的信息
    	HttpSession session = this.getRequest().getSession();
    	session.setAttribute(Constants.SESSION_CMDKEY,"tsupervisorReportAction");
    	ScUsers user = (ScUsers) session.getAttribute("sysUser");
		// 如果用户为空或者企业为空，退出系统
		if (user == null || ("").equals(user.getUserId())) {
			return "LogOut";
		}
		
		return "forwardInsert";
	}

	/**
	 * 监理点新增
	 * @comments 
	 * @return
	 * @version 1.0
	 */
	public String savePoint(){
		// 取得登录用户的信息
    	HttpSession session = this.getRequest().getSession();
    	session.setAttribute(Constants.SESSION_CMDKEY,"tsupervisorReportAction");
    	ScUsers user = (ScUsers) session.getAttribute("sysUser");
		// 如果用户为空或者企业为空，退出系统
		if (user == null || ("").equals(user.getUserId())) {
			return "LogOut";
		}
		
		tsupervisorPointService.saveSupervisorPoint(supervisorPoint, supervisorId, user);
		//提示操作信息
		this.setRetMsg(this.getText("opt_save_suc"));
		//跳转到监理报告列表页面
		this.setRetUrl(super.getRequest().getContextPath()+ "/api/supervisor/supervisorReportAction!getReportList.action?supervisorId="
				+ supervisorId+"&projectId="+projectId+"&now="+ new Date().getTime());

		return "systemInfoMain";
	}
	
	/**
	 * 监理点修改初始页面
	 * @comments 
	 * @return
	 * @version 1.0
	 */
	public String forwardUpdate(){
		// 取得登录用户的信息
    	HttpSession session = this.getRequest().getSession();
    	session.setAttribute(Constants.SESSION_CMDKEY,"tsupervisorReportAction");
    	ScUsers user = (ScUsers) session.getAttribute("sysUser");
		// 如果用户为空或者企业为空，退出系统
		if (user == null || ("").equals(user.getUserId())) {
			return "LogOut";
		}
		
		supervisorPoint = tsupervisorPointService.get(pointId);
		return "forwardUpdate";
	}
	
	/**
	 * 监理点新增
	 * @comments 
	 * @return
	 * @version 1.0
	 */
	public String updatePoint(){
		// 取得登录用户的信息
    	HttpSession session = this.getRequest().getSession();
    	session.setAttribute(Constants.SESSION_CMDKEY,"tsupervisorReportAction");
    	ScUsers user = (ScUsers) session.getAttribute("sysUser");
		// 如果用户为空或者企业为空，退出系统
		if (user == null || ("").equals(user.getUserId())) {
			return "LogOut";
		}
		
		tsupervisorPointService.updateSupervisorPoint(supervisorPoint, supervisorId, user);
		//提示操作信息
		this.setRetMsg(this.getText("opt_update_suc"));
		//跳转到监理报告列表页面
		this.setRetUrl(super.getRequest().getContextPath()+ "/api/supervisor/supervisorReportAction!getReportList.action?supervisorId="
				+ supervisorId+"&projectId="+projectId+"&now="+ new Date().getTime());

		return "systemInfoMain";
	}
	  
	/**
	 * 监理点删除
	 * @comments 
	 * @return
	 * @version 1.0
	 */
	public String deletePoint(){
		// 取得登录用户的信息
    	HttpSession session = this.getRequest().getSession();
    	session.setAttribute(Constants.SESSION_CMDKEY,"tsupervisorReportAction");
    	ScUsers user = (ScUsers) session.getAttribute("sysUser");
		// 如果用户为空或者企业为空，退出系统
		if (user == null || ("").equals(user.getUserId())) {
			return "LogOut";
		}
		
		tsupervisorPointService.deleteSupervisorPoint(pointId);
		//提示操作信息
		this.setRetMsg(this.getText("opt_del_suc"));
		//跳转到监理报告列表页面
		this.setRetUrl(super.getRequest().getContextPath()+ "/api/supervisor/supervisorReportAction!getReportList.action?supervisorId="
				+ supervisorId+"&projectId="+projectId+"&now="+ new Date().getTime());

		return "systemInfoMain";
	}

	public TsupervisorPoint getSupervisorPoint() {
		return supervisorPoint;
	}

	public void setSupervisorPoint(TsupervisorPoint supervisorPoint) {
		this.supervisorPoint = supervisorPoint;
	}

	public String getSupervisorId() {
		return supervisorId;
	}

	public void setSupervisorId(String supervisorId) {
		this.supervisorId = supervisorId;
	}

	public String getProjectId() {
		return projectId;
	}

	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}

	public String getPointId() {
		return pointId;
	}

	public void setPointId(String pointId) {
		this.pointId = pointId;
	}

	public String getRetUrl() {
		return retUrl;
	}

	public void setRetUrl(String retUrl) {
		this.retUrl = retUrl;
	}

	public String getRetMsg() {
		return retMsg;
	}

	public void setRetMsg(String retMsg) {
		this.retMsg = retMsg;
	}
}