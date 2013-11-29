/*************** 版权声明***************
*
* Copyright (C) 2012 西安辉盛科技发展有限责任公司.
*
********************************************
*/
package com.hopsun.tppas.api.report.action;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import com.hopsun.framework.base.action.BaseAction;
import com.hopsun.framework.base.bean.Pager;
import com.hopsun.scenter.entity.ScUsers;
import com.hopsun.tppas.api.report.service.TprojectApplicationOfficeService;
import com.hopsun.tppas.api.superadmin.service.MitemService;
import com.hopsun.tppas.api.superadmin.service.TprojectTypeManagerService;
import com.hopsun.tppas.common.Constants;
import com.hopsun.tppas.entity.Mitem;
import com.hopsun.tppas.entity.TprojectApplication;
import com.hopsun.tppas.entity.TprojectType;

/**
 * @comments 
 * @author wanglw
 * @date 2013-11-21 @time 下午8:26:11
 * @Version 1.0
 */
public class TprojectApplicationOfficeAction extends BaseAction{

	private static final long serialVersionUID = -1818147357910851910L;
	
	@Resource
	private TprojectApplicationOfficeService tprojectApplicationOfficeService;
	
	@Resource
	private TprojectTypeManagerService tprojectTypeManagerService;
	
	@Resource
	private MitemService mitemService;
	
	/** 翻页*/
    private int pageNo;
    
    /** 跳转路径*/
	private String retUrl;
	
	/** 跳转页面massage */
	private String retMsg;
	
	/** 计划类别 */
	private List<TprojectType> projectTypeList1;
	
	/** 项目分类 */
	private List<TprojectType> projectTypeList2;
	
	/** 计划类别 */
	private String projectType1;
	
	/** 项目分类 */
	private String projectType2;
	
	/** 项目名称 */
	private String projectName;
	
	/** 申报单位 */
	private String applyCompany;
	
	/** 项目ID */
	private String projectId;
	
	/** 选择的项目ID */
	private String selectedProjectIds;
	
	/** 局办公会意见集合 */
	private List<Mitem> officeStatusList;
	
	/** 局办公会意见 */
	private String officeStatus;
	
	private TprojectApplication tprojectApplication;
	
	/**
	 * @comments 显示局办公会意见
	 * @return
	 * @Version 1.0
	 */
	public String showOfficeAuditManage(){
		
		// 取得登录用户的信息
		HttpSession session = this.getRequest().getSession();
	    session.setAttribute(Constants.SESSION_CMDKEY, "officeAudit");
	    
	    ScUsers user = (ScUsers) session.getAttribute("sysUser");
	    
		// 如果用户为空或者企业为空，退出系统
		if (user == null || ("").equals(user.getUserId())) {
			return "LogOut";
		}
		
		// 初始化计划类别
		this.projectTypeList1 = new ArrayList<TprojectType>();
		this.projectTypeList1 = tprojectTypeManagerService.getProjectTypeListByUser(user);
				
		
		// 初始化项目分类
		this.projectTypeList2 = new ArrayList<TprojectType>();
		
		
		return "showOfficeAuditManage";
	}
	
	/**
	 * @comments 局办公会意见项目列表
	 * @return
	 * @Version 1.0
	 */
	public String getOfficeAuditList(){
		
		// 取得登录用户的信息
		HttpSession session = this.getRequest().getSession();
		String cmdkey = (String)session.getAttribute(Constants.SESSION_CMDKEY);
	    
	    ScUsers user = (ScUsers) session.getAttribute("sysUser");
		// 如果用户为空或者企业为空，退出系统
		if (user == null || ("").equals(user.getUserId())
				|| !"officeAudit".equals(cmdkey)) {
			return "LogOut";
		}
		
    	// 翻页
    	if (pager == null && this.getPageNo() == 0) {
			pager = new Pager();
			pager.setPageSize(Constants.PAGE_SIZE);
		}
    	else{
    		pager = new Pager();
    		pager.setPageNumber(this.getPageNo());
    		pager.setPageSize(Constants.PAGE_SIZE);
    	}
		
    	Map<String, Object> param = new HashMap<String, Object>();
		
		// 封装查询条件
    	// 部门ID
    	param.put("departmentId", user.getScDept().getDeptId());
    	
		// 项目名称
		param.put("projectName", projectName);
		
		// 申报单位
		param.put("applyCompany", applyCompany);
		
		// 计划类别
		String projectTypeString = tprojectTypeManagerService.getProjectTypeStrByUser(user);
		param.put("projectTypeString", projectTypeString);
		
		// 计划类别
		param.put("projectType1", projectType1);
		
		// 项目分类
		param.put("projectType2", projectType2);
		
				
		// 取得项目一览信息
		pager = tprojectApplicationOfficeService.getOfficeAuditList(
				param, pager.getPageNumber(), pager.getPageSize());
		
		return "getOfficeAuditList";
	}
	
	/**
	 * @comments 批量填写局办公会意见
	 * @return
	 * @Version 1.0
	 */
	public String showBatchOfficeAudit(){
		// 取得登录用户的信息
		HttpSession session = this.getRequest().getSession();
		String cmdkey = (String)session.getAttribute(Constants.SESSION_CMDKEY);
	    
	    ScUsers user = (ScUsers) session.getAttribute("sysUser");
		// 如果用户为空或者企业为空，退出系统
		if (user == null || ("").equals(user.getUserId())
				|| !"officeAudit".equals(cmdkey)) {
			return "LogOut";
		}
		
		// 取得选择的项目Id
		this.selectedProjectIds = this.getSelectedProjectIds();
		
		this.projectId = selectedProjectIds;
		
		this.tprojectApplication = new TprojectApplication();
		tprojectApplication.setExpertAuditComposite(this.setOfficeSelectStatus(projectId));
		
		
		// 局办公会意见list
		this.officeStatusList = new ArrayList<Mitem>();
		this.officeStatusList = mitemService.getListByTypeId(Constants.OFFICE_TYPE);
		
		return "showBatchOfficeAudit";
	}
	
	/**
	 * @comments 局办公会意见批量审核 
	 * @return
	 * @Version 1.0
	 */
	public String batchSaveOfficeAudit(){
		// 取得登录用户的信息
		HttpSession session = this.getRequest().getSession();
		String cmdkey = (String)session.getAttribute(Constants.SESSION_CMDKEY);
	    
	    ScUsers user = (ScUsers) session.getAttribute("sysUser");
		// 如果用户为空或者企业为空，退出系统
		if (user == null || ("").equals(user.getUserId())
				|| !"officeAudit".equals(cmdkey)) {
			return "LogOut";
		}
		// 取得选择的项目Id
		this.projectId = this.getProjectId();
		
		
		// 取得局办公会意见
		this.officeStatus = this.getOfficeStatus();
		
		// 保存局办公会意见
		tprojectApplicationOfficeService.updateBatchOfficeStatus(projectId, 
				officeStatus);
		
		// 设置提示信息
		this.setRetMsg(this.getText("opt_save_suc"));
		
		// 设置actionUrl
		this.setRetUrl(super.getRequest().getContextPath()
				+ "/api/audit/projectApplicationOffice!showOfficeAuditManage.action?"
				+ "&now=" + new Date().getTime());
		
		return "systemInfoMain";
	}
	
	/**
	 * @comments 查看处室意见
	 * @return
	 * @Version 1.0
	 */
	public String showDetail(){
		// 取得登录用户的信息
		HttpSession session = this.getRequest().getSession();
		String cmdkey = (String)session.getAttribute(Constants.SESSION_CMDKEY);
	    
	    ScUsers user = (ScUsers) session.getAttribute("sysUser");
		// 如果用户为空或者企业为空，退出系统
		if (user == null || ("").equals(user.getUserId())
				|| !"officeAudit".equals(cmdkey)) {
			return "LogOut";
		}
		// 取得选择的项目Id
		this.projectId = this.getProjectId();
		
		this.tprojectApplication = tprojectApplicationOfficeService.get(projectId);
		return "showDetail";
	}

	/**
	 * @comments 设置局办公会初始选择状态
	 * @param projectIds
	 * @return
	 * @Version 1.0
	 */
	private String setOfficeSelectStatus(String projectIds){
		
		String [] ids = projectIds.split(",");
		boolean flag = true;
		for(int i=0; i<ids.length; i++){
			TprojectApplication tp = tprojectApplicationOfficeService.get(ids[i]);
			if(tp!=null && tp.getExpertAuditComposite() !=null){
				if(Constants.OFFICE_NOPASS.equals(tp.getExpertAuditComposite())){
					flag = false;
				}
				else if(Constants.OFFICE_PASS.equals(tp.getExpertAuditComposite())){
					return Constants.OFFICE_PASS;
				}
			}
		}
		if(flag){
			return "";
		}
		else{
			return Constants.OFFICE_NOPASS;
		}
	}
	
	public int getPageNo() {
		return pageNo;
	}

	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
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

	public List<TprojectType> getProjectTypeList1() {
		return projectTypeList1;
	}

	public void setProjectTypeList1(List<TprojectType> projectTypeList1) {
		this.projectTypeList1 = projectTypeList1;
	}

	public List<TprojectType> getProjectTypeList2() {
		return projectTypeList2;
	}

	public void setProjectTypeList2(List<TprojectType> projectTypeList2) {
		this.projectTypeList2 = projectTypeList2;
	}

	public String getProjectType1() {
		return projectType1;
	}

	public void setProjectType1(String projectType1) {
		this.projectType1 = projectType1;
	}

	public String getProjectType2() {
		return projectType2;
	}

	public void setProjectType2(String projectType2) {
		this.projectType2 = projectType2;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public String getApplyCompany() {
		return applyCompany;
	}

	public void setApplyCompany(String applyCompany) {
		this.applyCompany = applyCompany;
	}

	public String getProjectId() {
		return projectId;
	}

	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}

	public String getSelectedProjectIds() {
		return selectedProjectIds;
	}

	public void setSelectedProjectIds(String selectedProjectIds) {
		this.selectedProjectIds = selectedProjectIds;
	}

	public List<Mitem> getOfficeStatusList() {
		return officeStatusList;
	}

	public void setOfficeStatusList(List<Mitem> officeStatusList) {
		this.officeStatusList = officeStatusList;
	}

	public String getOfficeStatus() {
		return officeStatus;
	}

	public void setOfficeStatus(String officeStatus) {
		this.officeStatus = officeStatus;
	}

	public TprojectApplication getTprojectApplication() {
		return tprojectApplication;
	}

	public void setTprojectApplication(TprojectApplication tprojectApplication) {
		this.tprojectApplication = tprojectApplication;
	}
	
}

