/************************* 版权声明 *********************************
 *
 * Copyright (C) 2012 西安辉盛科技发展有限责任公司.
 *
 ******************************************************************
 */
package com.hopsun.tppas.api.supervisor.action;

import java.util.Date;

import com.hopsun.scenter.entity.ScUsers;
import com.hopsun.tppas.api.supervisor.service.TsupervisorFundBService;
import com.hopsun.tppas.entity.TsupervisorFundB;
import com.hopsun.framework.base.action.BaseAction;
import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

/**
 *@comments 监理资金表B
 *@author wangxiaodong
 *@date 2013-9-22
 *@version 1.0
 */
public class TsupervisorFundBAction extends BaseAction{
  
	private static final long serialVersionUID = 523122891637567120L;
	
	/**监理资金B service**/
	@Resource
	private TsupervisorFundBService tsupervisorFundBService;
	
	/**监理ID**/
	private String supervisorId;
	
	/**监理资金B对象**/
	private TsupervisorFundB tsupervisorFundB;
	
	/** 跳转路径**/
	private String retUrl;

	/** 跳转页面massage**/
	private String retMsg;
	
	/**判断是修改还是查看*/
    private String isEdit;
    
    
	/**
	 * 得到资金情况B信息
	 * @comments 
	 * @return
	 * @version 1.0
	 */
	public String getFundBInfo(){
		// 取得登录用户的信息
    	HttpSession session = this.getRequest().getSession();
    	ScUsers user = (ScUsers) session.getAttribute("sysUser");
		// 如果用户为空或者企业为空，退出系统
		if (user == null || ("").equals(user.getUserId())) {
			return "LogOut";
		}
		
    	//得到资金情况B信息
    	tsupervisorFundB = tsupervisorFundBService.getTsupervisorFundBBysupervisorId(supervisorId);
    	
		return "fundBInfo";
	}
	/**
	 * 添加或修改资金情况B信息
	 * @comments 
	 * @return
	 * @version 1.0
	 */
	public String saveOrNextFundB(){
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
    	if(tsupervisorFundB.getFundBId()!=null&&tsupervisorFundB.getFundBId().length()>0){
    		this.setRetMsg(this.getText("opt_update_suc"));
    	}else{
    		this.setRetMsg(this.getText("opt_save_suc"));
    	}
    	
    	//保存资金情况B
    	tsupervisorFundBService.saveOrUpdate(supervisorId, tsupervisorFundB);
    	
    	if("0".equals(optType)){
    		this.setRetUrl(super.getRequest().getContextPath()+ "/api/supervisor/supervisorFundBAction!getFundBInfo.action?supervisorId="
    				+ supervisorId+"&isEdit="+isEdit+"&now="+ new Date().getTime());
    		return "systemInfo";
    	}else{
    		this.setRetUrl(super.getRequest().getContextPath()+ "/api/supervisor/projectCompleteInfoAction!getProjectCompleteInfo.action?supervisorId="
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

	public TsupervisorFundB getTsupervisorFundB() {
		return tsupervisorFundB;
	}

	public void setTsupervisorFundB(TsupervisorFundB tsupervisorFundB) {
		this.tsupervisorFundB = tsupervisorFundB;
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
