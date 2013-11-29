/************************* 版权声明 *********************************
 *
 * Copyright (C) 2012 西安辉盛科技发展有限责任公司.
 *
 ******************************************************************
 */
package com.hopsun.tppas.api.supervisor.action;

import java.util.Date;

import com.hopsun.scenter.entity.ScUsers;
import com.hopsun.tppas.api.supervisor.service.TprojectManagementInfoService;
import com.hopsun.tppas.entity.TprojectManagementInfo;
import com.hopsun.framework.base.action.BaseAction;
import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

/**
 * @comments 项目实施管理情况
 * @author wangxiaodong
 * @date 2013-9-22
 * @version 1.0
 */
public class TprojectManagementInfoAction extends BaseAction{
  
	private static final long serialVersionUID = -864469983592653797L;
	
	/**项目实施管理情况service**/
	@Resource
	private TprojectManagementInfoService tprojectManagementInfoService;
	  
	/**监理ID**/
	private String supervisorId;
	
	/**项目实施管理情况对象**/
	private TprojectManagementInfo tprojectManagementInfo;
	
	/** 跳转路径**/
	private String retUrl;

	/** 跳转页面massage**/
	private String retMsg;
	
	/**判断是修改还是查看*/
    private String isEdit;
    
    

	/**
	 * 通过监理ID查询该监理下的项目实施管理情况
	 * @comments 
	 * @return
	 * @version 1.0
	 */
	public String getProjectManagementInfo(){
		// 取得登录用户的信息
    	HttpSession session = this.getRequest().getSession();
    	ScUsers user = (ScUsers) session.getAttribute("sysUser");
		// 如果用户为空或者企业为空，退出系统
		if (user == null || ("").equals(user.getUserId())) {
			return "LogOut";
		}
		
    	//项目取得成果情况
    	tprojectManagementInfo = tprojectManagementInfoService.getProjectManagementInfoBySupervisorId(supervisorId);
		
		return "projectManagementInfo";
	}
	
	/**
	 * 添加或修改项目实施管理情况
	 * @comments 
	 * @return
	 * @version 1.0
	 */
	public String saveOrNextProjectManagementInfo(){
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
    	if(tprojectManagementInfo.getProjectManagementInfoId()!=null&&tprojectManagementInfo.getProjectManagementInfoId().length()>0){
    		this.setRetMsg(this.getText("opt_update_suc"));
    	}else{
    		this.setRetMsg(this.getText("opt_save_suc"));
    	}
    	
    	//保存项目实施管理情况
    	tprojectManagementInfoService.saveOrUpdate(supervisorId, tprojectManagementInfo);
    	
    	if("0".equals(optType)){
    		this.setRetUrl(super.getRequest().getContextPath()+ "/server/supervisor/projectManagementInfoAction!getProjectManagementInfo.action?supervisorId="
    				+ supervisorId+"&isEdit="+isEdit+"&now="+ new Date().getTime());
    		return "systemInfo";
    	}else{
    		this.setRetUrl(super.getRequest().getContextPath()+ "/server/supervisor/companyDevelopInfoAction!getCompanyDevelopInfo.action?supervisorId="
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

	public TprojectManagementInfo getTprojectManagementInfo() {
		return tprojectManagementInfo;
	}

	public void setTprojectManagementInfo(
			TprojectManagementInfo tprojectManagementInfo) {
		this.tprojectManagementInfo = tprojectManagementInfo;
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
