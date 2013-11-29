/************************* 版权声明 *********************************
 *
 * Copyright (C) 2012 西安辉盛科技发展有限责任公司.
 *
 ******************************************************************
 */
package com.hopsun.tppas.api.supervisor.action;

import java.util.Date;

import com.hopsun.scenter.entity.ScUsers;
import com.hopsun.tppas.api.supervisor.service.TcompanyDevelopInfoService;
import com.hopsun.tppas.entity.TcompanyDevelopInfo;
import com.hopsun.framework.base.action.BaseAction;
import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

/**
 * @comments 企业发展情况
 * @author wangxiaodong
 * @date 2013-9-22
 * @version 1.0
 */
public class TcompanyDevelopInfoAction extends BaseAction{
  
	private static final long serialVersionUID = -914992032849296876L;
	
	/**企业发展情况service**/
	@Resource
	private TcompanyDevelopInfoService tcompanyDevelopInfoService;
	  
	/**监理ID**/
	private String supervisorId;
	
	/**企业发展情况对象**/
	private TcompanyDevelopInfo tcompanyDevelopInfo;
	
	/** 跳转路径**/
	private String retUrl;

	/** 跳转页面massage**/
	private String retMsg;
	
	/**判断是修改还是查看*/
    private String isEdit;
    
	
	/**
	 * 通过监理ID查询该监理下的企业发展情况
	 * @comments 
	 * @return
	 * @version 1.0
	 */
	public String getCompanyDevelopInfo(){
		// 取得登录用户的信息
    	HttpSession session = this.getRequest().getSession();
    	ScUsers user = (ScUsers) session.getAttribute("sysUser");
		// 如果用户为空或者企业为空，退出系统
		if (user == null || ("").equals(user.getUserId())) {
			return "LogOut";
		}
		
    	//企业发展情况
    	tcompanyDevelopInfo = tcompanyDevelopInfoService.getCompanyDevelopInfoBySupervisorId(supervisorId);
		
		return "companyDevelopInfo";
	}
	
	/**
	 * 添加或修改企业发展情况
	 * @comments 
	 * @return
	 * @version 1.0
	 */
	public String saveOrNextCompanyDevelopInfo(){
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
    	if(tcompanyDevelopInfo.getCompanyDevelopInfoId()!=null&&tcompanyDevelopInfo.getCompanyDevelopInfoId().length()>0){
    		this.setRetMsg(this.getText("opt_update_suc"));
    	}else{
    		this.setRetMsg(this.getText("opt_save_suc"));
    	}
    	
    	//保存企业发展情况
    	tcompanyDevelopInfoService.saveOrUpdate(supervisorId, tcompanyDevelopInfo);
    	
    	if("0".equals(optType)){
    		this.setRetUrl(super.getRequest().getContextPath()+ "/server/supervisor/companyDevelopInfoAction!getCompanyDevelopInfo.action?supervisorId="
    				+ supervisorId+"&isEdit="+isEdit+"&now="+ new Date().getTime());
    		return "systemInfo";
    	}else{
    		this.setRetUrl(super.getRequest().getContextPath()+ "/server/supervisor/supervisorOtherAction!getPromise.action?supervisorId="
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

	public TcompanyDevelopInfo getTcompanyDevelopInfo() {
		return tcompanyDevelopInfo;
	}

	public void setTcompanyDevelopInfo(TcompanyDevelopInfo tcompanyDevelopInfo) {
		this.tcompanyDevelopInfo = tcompanyDevelopInfo;
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
