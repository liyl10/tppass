/************************* 版权声明 *********************************
 *
 * Copyright (C) 2012 西安辉盛科技发展有限责任公司.
 *
 ******************************************************************
 */
package com.hopsun.tppas.api.supervisor.action;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.hopsun.scenter.entity.ScUsers;
import com.hopsun.tppas.api.report.service.TprojectApplicationService;
import com.hopsun.tppas.api.supervisor.service.TsupervisorReportService;
import com.hopsun.tppas.common.Constants;
import com.hopsun.tppas.entity.TprojectApplication;
import com.hopsun.tppas.entity.TsupervisorReport;
import com.hopsun.framework.base.action.BaseAction;
import com.hopsun.framework.base.bean.Pager;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

/**
 * 项目监理报告
 *@comments
 *@author wangxiaodong
 *@date 2013-9-17
 *@version 1.0
 */
public class TsupervisorReportAction extends BaseAction{
  
	private static final long serialVersionUID = -4763639758159176861L;
	
	/**监理报告service*/
	@Resource
	private TsupervisorReportService tsupervisorReportService;
	
	/**项目申报service*/
	@Resource
	private TprojectApplicationService tprojectApplicationService;
	
	/**监理ID**/
	private String supervisorId;
	
	/**监理报告ID**/
	private String reportId;
	
	/**项目ID**/
	private String projectId;
	
	/** 跳转页码 */
	private int pageNo;
	
	/**监理报告**/
	private TsupervisorReport supervisorReport;
	
	/**项目信息**/
	private TprojectApplication projectApplication;
	
	/** 跳转路径**/
	private String retUrl;

	/** 跳转页面massage**/
	private String retMsg;
	
	/**审查操作类型*/
	private String optType;
	
	/**审查意见*/
	private String checkInfo;
	  
	/**
	 * 得到监理的监理报告
	 * @comments 
	 * @return
	 * @version 1.0
	 */
	public String getReportList(){
		// 取得登录用户的信息
    	HttpSession session = this.getRequest().getSession();
    	session.setAttribute(Constants.SESSION_CMDKEY,"tsupervisorReportAction");
    	ScUsers user = (ScUsers) session.getAttribute("sysUser");

		// 如果用户为空或者企业为空，退出系统
		if (user == null || ("").equals(user.getUserId())) {
			return "LogOut";
		}
    	
		// 设置分页参数
    	if (pager == null && this.getPageNo() == 0) {
			pager = new Pager();
		}
    	else{
    		pager = new Pager();
    		pager.setPageNumber(this.getPageNo());
    	}
    	//得到监理报告列表
    	pager = tsupervisorReportService.getReportList(supervisorId,pager.getPageNumber(), pager.getPageSize());
		//项目信息
    	projectApplication = tprojectApplicationService.get(projectId);
    	
    	return "reportList";
	}
	
	/**
	 * 监理报告添加页面
	 * @comments
	 * @return
	 * @version 1.0
	 */
	public String showReportInsert() {
		// 设置令牌
		this.getRequest().getSession().setAttribute(Constants.SESSION_CMDKEY,"TsupervisorReportInsert");
		// 跳转到页面
		return "showReportInsert";
	}
	
	/**
	 * 添加监理报告
	 * @comments 
	 * @return
	 * @version 1.0
	 */
	public String saveReport(){
		// 取得登录用户的信息
		HttpSession session = this.getRequest().getSession();
		ScUsers user = (ScUsers) session.getAttribute("sysUser");
		// 取得令牌信息
		String cmdkey = (String) session.getAttribute(Constants.SESSION_CMDKEY);
		if (user == null || cmdkey == null || ("").equals(user.getUserId())|| !"TsupervisorReportInsert".equals(cmdkey)) {
			return "LogOut";
		}
		
		//添加监理报告
		tsupervisorReportService.saveReport(supervisorId, supervisorReport);
		
		//提示操作信息
		this.setRetMsg(this.getText("opt_save_suc"));
		//跳转到监理报告列表页面
		this.setRetUrl(super.getRequest().getContextPath()+ "/api/supervisor/supervisorReportAction!getReportList.action?supervisorId="
				+ supervisorId+"&projectId="+projectId+"&now="+ new Date().getTime());

		return "systemInfoMain";
	}
	
	/**
	 * 修改监理报告页面
	 * @comments 
	 * @return
	 * @version 1.0
	 */
	public String showReportModify() {
		// 设置令牌
		this.getRequest().getSession().setAttribute(Constants.SESSION_CMDKEY,"TsupervisorReportUpdate");
		// 取得监理报告详细信息
		supervisorReport = tsupervisorReportService.get(reportId);
		// 跳转到页面
		return "showReportModify";
	}
	
	/**
	 * 修改监理报告
	 * @comments 
	 * @return
	 * @version 1.0
	 */
	public String updateReport() {
		
		// 取得登录用户的信息
		HttpSession session = this.getRequest().getSession();
		ScUsers user = (ScUsers) session.getAttribute("sysUser");
		// 取得令牌信息
		String cmdkey = (String) session.getAttribute(Constants.SESSION_CMDKEY);
		if (user == null || cmdkey == null || ("").equals(user.getUserId())|| !"TsupervisorReportUpdate".equals(cmdkey)) {
			return "LogOut";
		}
		
		//修改监理报告
		tsupervisorReportService.updateReport(supervisorId, supervisorReport);
		//操作提示信息
		this.setRetMsg(this.getText("opt_update_suc"));
		//跳转到监理报告列表页面
		this.setRetUrl(super.getRequest().getContextPath()+ "/api/supervisor/supervisorReportAction!getReportList.action?supervisorId="
				+ supervisorId+"&projectId="+projectId+"&now="+ new Date().getTime());

		return "systemInfoMain";
	}
	
	/**
	 * 查看监理报告
	 * @comments 
	 * @return
	 * @version 1.0
	 */
	public String showReportDetail() {
		// 取得登录用户的信息
		HttpSession session = this.getRequest().getSession();
		ScUsers user = (ScUsers) session.getAttribute("sysUser");
		if (user == null ||  ("").equals(user.getUserId())) {
			return "LogOut";
		}

		// 取得监理报告详细信息
		supervisorReport = tsupervisorReportService.get(reportId);
		// 跳转到页面
		return "showReportDetail";
	}
	
	/**
	 * 监理报告审查页面初始
	 * @comments 
	 * @return
	 * @version 1.0
	 */
	public String showReportAudit() {
		// 取得登录用户的信息
		HttpSession session = this.getRequest().getSession();
		ScUsers user = (ScUsers) session.getAttribute("sysUser");
		// 设置令牌
		this.getRequest().getSession().setAttribute(Constants.SESSION_CMDKEY,"TsupervisorReportAudit");
		if (user == null ||  ("").equals(user.getUserId())) {
			return "LogOut";
		}

		// 取得监理报告详细信息
		supervisorReport = tsupervisorReportService.get(reportId);
		// 跳转到页面
		return "showReportAudit";
	}
	
	/**
	 * 审查监理报告
	 * @comments 
	 * @return
	 * @version 1.0
	 */
	public String auditReport() {
		
		// 取得登录用户的信息
		HttpSession session = this.getRequest().getSession();
		ScUsers user = (ScUsers) session.getAttribute("sysUser");
		// 取得令牌信息
		String cmdkey = (String) session.getAttribute(Constants.SESSION_CMDKEY);
		if (user == null || cmdkey == null || ("").equals(user.getUserId())|| !"TsupervisorReportAudit".equals(cmdkey)) {
			return "LogOut";
		}
		
		Map<String,Object> valueMap = new HashMap<String,Object>();
		//监理报告ID
		valueMap.put("reportId",reportId);
		//操作类型  0-保存    1-提交
		valueMap.put("optType",optType);
		//审查意见
		valueMap.put("checkInfo",checkInfo);
		//操作用户
		valueMap.put("user",user);
		//审查监理报告
		tsupervisorReportService.auditReport(valueMap);
		//操作提示信息
		if(optType.equals("0")){
			this.setRetMsg(this.getText("opt_save_suc"));
		}else{
			this.setRetMsg(this.getText("opt_submit_suc"));
		}
		//跳转到监理报告列表页面
		this.setRetUrl(super.getRequest().getContextPath()+ "/api/supervisor/supervisorReportAction!getReportList.action?supervisorId="
				+ supervisorId+"&projectId="+projectId+"&now="+ new Date().getTime());

		return "systemInfoMain";
	}

	public String getSupervisorId() {
		return supervisorId;
	}

	public void setSupervisorId(String supervisorId) {
		this.supervisorId = supervisorId;
	}

	public String getReportId() {
		return reportId;
	}

	public void setReportId(String reportId) {
		this.reportId = reportId;
	}

	public String getProjectId() {
		return projectId;
	}

	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}

	public int getPageNo() {
		return pageNo;
	}

	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}

	public TsupervisorReport getSupervisorReport() {
		return supervisorReport;
	}

	public void setSupervisorReport(TsupervisorReport supervisorReport) {
		this.supervisorReport = supervisorReport;
	}

	public TprojectApplication getProjectApplication() {
		return projectApplication;
	}

	public void setProjectApplication(TprojectApplication projectApplication) {
		this.projectApplication = projectApplication;
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

	public String getOptType() {
		return optType;
	}

	public void setOptType(String optType) {
		this.optType = optType;
	}

	public String getCheckInfo() {
		return checkInfo;
	}

	public void setCheckInfo(String checkInfo) {
		this.checkInfo = checkInfo;
	}
	
}
