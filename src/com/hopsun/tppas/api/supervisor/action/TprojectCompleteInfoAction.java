/************************* 版权声明 *********************************
 *
 * Copyright (C) 2012 西安辉盛科技发展有限责任公司.
 *
 ******************************************************************
 */
package com.hopsun.tppas.api.supervisor.action;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.hopsun.scenter.entity.ScUsers;
import com.hopsun.tppas.api.superadmin.service.MitemService;
import com.hopsun.tppas.api.supervisor.service.TprojectCompleteInfoService;
import com.hopsun.tppas.api.supervisor.service.TtechnicalCompleteInfoService;
import com.hopsun.tppas.common.Constants;
import com.hopsun.tppas.entity.Mitem;
import com.hopsun.tppas.entity.TprojectCompleteInfo;
import com.hopsun.tppas.entity.TtechnicalCompleteInfo;
import com.hopsun.framework.base.action.BaseAction;
import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

/**
 * @comments 对照合同项目任务完成情况
 * @author wangxiaodong
 * @date 2013-9-22
 * @version 1.0
 */
public class TprojectCompleteInfoAction extends BaseAction{
  
	private static final long serialVersionUID = 250617039579629681L;
	
	/**对照合同项目任务完成情况service*/
	@Resource
	private TprojectCompleteInfoService tprojectCompleteInfoService;
	
	/**技术指标完成情况service*/
	@Resource
	private TtechnicalCompleteInfoService ttechnicalCompleteInfoService;
	
	/**码表service*/
	@Resource
	private MitemService apiMitemService;
	  
	/**监理ID**/
	private String supervisorId;
	
	/**对照合同项目任务完成情况对象**/
	private TprojectCompleteInfo tprojectCompleteInfo;
	
	/** 跳转路径**/
	private String retUrl;

	/** 跳转页面massage**/
	private String retMsg;
	
	/** 项目实施进展情况*/
	private List<Mitem> projectProgress;
	
	/**项目未按计划进行的原因*/
	private List<Mitem> projectStopReason;

	/**选择的未按计划进行的原因*/
	private String[] selectedProjectStopReason;
	
	/** 资金用途List */
	private List<TtechnicalCompleteInfo> technicalList;
	
	/**判断是修改还是查看*/
    private String isEdit;
    
    
	
	/**
	 * 通过监理ID查询该监理下的对照合同项目任务完成情况
	 * @comments 
	 * @return
	 * @version 1.0
	 */
	public String getProjectCompleteInfo(){
		// 取得登录用户的信息
    	HttpSession session = this.getRequest().getSession();
    	ScUsers user = (ScUsers) session.getAttribute("sysUser");
		// 如果用户为空或者企业为空，退出系统
		if (user == null || ("").equals(user.getUserId())) {
			return "LogOut";
		}
		
    	//项目进展情况集合
    	projectProgress = apiMitemService.getListByTypeId(Constants.TSUPERVISOR_OTHER_SCHEDULE_TYPE);
    	// 项目未按计划进行的原因集合
		projectStopReason = apiMitemService.getListByTypeId(Constants.TSUPERVISOR_OTHER_STOP_REASON);
    	//得到对照合同项目任务完成情况
		tprojectCompleteInfo = tprojectCompleteInfoService.getProjectCompleteInfoBySupervisorId(supervisorId);
		// 默认选中的未按计划进行的原因
		if (tprojectCompleteInfo != null&&tprojectCompleteInfo.getProjectReason()!= null) {
			selectedProjectStopReason = tprojectCompleteInfo.getProjectReason().split(",");
		}
		
		// 取得资金用途的list
		technicalList = new ArrayList<TtechnicalCompleteInfo>();
		technicalList = ttechnicalCompleteInfoService.getTechnicalCompleteInfoBySupervisorId(supervisorId);
		if(technicalList.size() < 4){
			for(int i=technicalList.size(); i < 4; i++){
				TtechnicalCompleteInfo technicalCompleteInfo = new TtechnicalCompleteInfo();
				technicalList.add(technicalCompleteInfo);
			}
		}
		
		return "projectCompleteInfo";
	}
	
	/**
	 * 添加或修改对照合同项目任务完成情况
	 * @comments 
	 * @return
	 * @version 1.0
	 */
	public String saveOrNextProjectCompleteInfo(){
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
    	if(tprojectCompleteInfo.getProjectCompleteInfoId()!=null&&tprojectCompleteInfo.getProjectCompleteInfoId().length()>0){
    		this.setRetMsg(this.getText("opt_update_suc"));
    	}else{
    		this.setRetMsg(this.getText("opt_save_suc"));
    	}
    	
    	//保存对照合同项目任务完成情况
    	tprojectCompleteInfoService.saveOrUpdate(supervisorId, tprojectCompleteInfo,selectedProjectStopReason,technicalList);
    	
    	if("0".equals(optType)){
    		this.setRetUrl(super.getRequest().getContextPath()+ "/server/supervisor/projectCompleteInfoAction!getProjectCompleteInfo.action?supervisorId="
    				+ supervisorId+"&isEdit="+isEdit+"&now="+ new Date().getTime());
    		return "systemInfo";
    	}else{
    		this.setRetUrl(super.getRequest().getContextPath()+ "/server/supervisor/projectAchievementInfoAction!getProjectAchievementInfo.action?supervisorId="
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

	public TprojectCompleteInfo getTprojectCompleteInfo() {
		return tprojectCompleteInfo;
	}

	public void setTprojectCompleteInfo(TprojectCompleteInfo tprojectCompleteInfo) {
		this.tprojectCompleteInfo = tprojectCompleteInfo;
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

	public List<Mitem> getProjectProgress() {
		return projectProgress;
	}

	public void setProjectProgress(List<Mitem> projectProgress) {
		this.projectProgress = projectProgress;
	}

	public List<Mitem> getProjectStopReason() {
		return projectStopReason;
	}

	public void setProjectStopReason(List<Mitem> projectStopReason) {
		this.projectStopReason = projectStopReason;
	}

	public String[] getSelectedProjectStopReason() {
		return selectedProjectStopReason;
	}

	public void setSelectedProjectStopReason(String[] selectedProjectStopReason) {
		this.selectedProjectStopReason = selectedProjectStopReason;
	}

	public List<TtechnicalCompleteInfo> getTechnicalList() {
		return technicalList;
	}

	public void setTechnicalList(List<TtechnicalCompleteInfo> technicalList) {
		this.technicalList = technicalList;
	}

	public String getIsEdit() {
		return isEdit;
	}

	public void setIsEdit(String isEdit) {
		this.isEdit = isEdit;
	}
}
