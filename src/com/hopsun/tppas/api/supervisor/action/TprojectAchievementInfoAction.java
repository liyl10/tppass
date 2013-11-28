/************************* 版权声明 *********************************
 *
 * Copyright (C) 2012 西安辉盛科技发展有限责任公司.
 *
 ******************************************************************
 */
package com.hopsun.tppas.api.supervisor.action;

import java.util.Date;

import com.hopsun.scenter.entity.ScUsers;
import com.hopsun.tppas.api.supervisor.service.TprojectAchievementInfoService;
import com.hopsun.tppas.entity.TprojectAchievementInfo;
import com.hopsun.framework.base.action.BaseAction;
import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

/**
 * @comments 项目取得成果情况
 * @author wangxiaodong
 * @date 2013-9-22
 * @version 1.0
 */
public class TprojectAchievementInfoAction extends BaseAction{
  
	private static final long serialVersionUID = -2505595239945997631L;
	
	/**项目取得成果情况service**/
	@Resource
	private TprojectAchievementInfoService tprojectAchievementInfoService;
	  
	/**监理ID**/
	private String supervisorId;
	
	/**项目取得成果情况对象**/
	private TprojectAchievementInfo tprojectAchievementInfo;
	
	/** 跳转路径**/
	private String retUrl;

	/** 跳转页面massage**/
	private String retMsg;
	
	/**判断是修改还是查看*/
    private String isEdit;
    
    
	
	/**
	 * 通过监理ID查询该监理下的项目取得成果情况
	 * @comments 
	 * @return
	 * @version 1.0
	 */
	public String getProjectAchievementInfo(){
		// 取得登录用户的信息
    	HttpSession session = this.getRequest().getSession();
    	ScUsers user = (ScUsers) session.getAttribute("sysUser");
		// 如果用户为空或者企业为空，退出系统
		if (user == null || ("").equals(user.getUserId())) {
			return "LogOut";
		}
		
    	//项目取得成果情况
    	tprojectAchievementInfo = tprojectAchievementInfoService.getProjectAchievementInfoBySupervisorId(supervisorId);
		
		return "projectAchievementInfo";
	}
	
	/**
	 * 添加或修改项目取得成果情况
	 * @comments 
	 * @return
	 * @version 1.0
	 */
	public String saveOrNextProjectAchievementInfo(){
		// 取得登录用户的信息
    	HttpSession session = this.getRequest().getSession();
    	ScUsers user = (ScUsers) session.getAttribute("sysUser");
		// 如果用户为空或者企业为空，退出系统
		if (user == null || ("").equals(user.getUserId())) {
			return "LogOut";
		}
    	
    	//是保存还是下一步 0-保存   1-下一步
    	String optType = this.getParameter("optType");
    	
    	//判断提示信息是保存还是修改
    	if(tprojectAchievementInfo.getProjectAchievementInfoId()!=null&&tprojectAchievementInfo.getProjectAchievementInfoId().length()>0){
    		this.setRetMsg(this.getText("opt_update_suc"));
    	}else{
    		this.setRetMsg(this.getText("opt_save_suc"));
    	}
    	
    	//保存项目取得成果情况
    	tprojectAchievementInfoService.saveOrUpdate(supervisorId, tprojectAchievementInfo);
    	
    	if("0".equals(optType)){
    		this.setRetUrl(super.getRequest().getContextPath()+ "/server/supervisor/projectAchievementInfoAction!getProjectAchievementInfo.action?supervisorId="
    				+ supervisorId+"&isEdit="+isEdit+"&now="+ new Date().getTime());
    		return "systemInfo";
    	}else{
    		this.setRetUrl(super.getRequest().getContextPath()+ "/server/supervisor/projectIndustrializationAction!getProjectIndustrialization.action?supervisorId="
    				+ supervisorId+"&isEdit="+isEdit+"&now="+ new Date().getTime());
    	}
    	
		return "systemInfoNext";
	}

	public String getSupervisorId() {
		return supervisorId;
	}

	public void setSupervisorId(String supervisorId) {
		this.supervisorId = supervisorId;
	}

	public TprojectAchievementInfo getTprojectAchievementInfo() {
		return tprojectAchievementInfo;
	}

	public void setTprojectAchievementInfo(
			TprojectAchievementInfo tprojectAchievementInfo) {
		this.tprojectAchievementInfo = tprojectAchievementInfo;
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

	public String getIsEdit() {
		return isEdit;
	}

	public void setIsEdit(String isEdit) {
		this.isEdit = isEdit;
	}
}
