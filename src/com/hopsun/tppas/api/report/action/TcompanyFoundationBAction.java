package com.hopsun.tppas.api.report.action;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.hopsun.framework.base.action.BaseAction;
import com.hopsun.scenter.entity.ScUsers;
import com.hopsun.tppas.api.report.service.TcompanyFoundationBService;
import com.hopsun.tppas.entity.TcompanyFoundationB;

public class TcompanyFoundationBAction extends BaseAction{
	public final static Logger logger = Logger.getLogger(TcompanyFoundationBAction.class.getName());
	
	private static final long serialVersionUID = 6425629748796542597L;
	@Resource
	private TcompanyFoundationBService tcompanyFoundationBService;
	/** 主要技术内容与技术创新点*/
	private TcompanyFoundationB tcompanyFoundation;
	/** 项目id*/
	private String projectId;
	/** 项目状态*/
	private String applyStatus;
	
	/**
	 * 
	 * @comments 高新画面初始化
	 * @return
	 * @version 1.0
	 */
	public String showHignFileInsert(){
		// 取得登录用户的信息
    	HttpSession session = this.getRequest().getSession();
    	ScUsers user = (ScUsers) session.getAttribute("sysUser");
    	//session.setAttribute(Constants.SESSION_CMDKEY, "tcompanyFoundation");
		
    	// 判断是否失效
    	if (user == null || ("").equals(user.getUserId())) {
    		logger.error("用户不存在！");
			return "LogOut";
		}
    	
		this.projectId = this.getProjectId();
		this.applyStatus = this.getApplyStatus();
		this.tcompanyFoundation = tcompanyFoundationBService.get("tprojectApplication.projectId",projectId);
	
		return "showhignfileInsert";
	}
	
	/**
	 * @comments 显示前期基础及现有条件和优势（非高新）
	 * @return
	 * @Version 1.0
	 */
	public String showCompanyFoundationNonTech(){
		// 取得登录用户的信息
    	HttpSession session = this.getRequest().getSession();
    	ScUsers user = (ScUsers) session.getAttribute("sysUser");
    	//session.setAttribute(Constants.SESSION_CMDKEY, "showCompanyFoundationNonTech");
		
    	// 判断是否失效
    	if (user == null || ("").equals(user.getUserId())) {
    		logger.error("用户不存在！");
			return "LogOut";
		}
		
		// 取得项目Id
		this.projectId = this.getProjectId();
		
		// 取得项目状态
		this.applyStatus = this.getApplyStatus();
		
		tcompanyFoundation = tcompanyFoundationBService.get("tprojectApplication.projectId", projectId);
		
		return "showCompanyFoundationNonTech";
	}

	/**
	 * @return the tcompanyFoundationBService
	 */
	public TcompanyFoundationBService getTcompanyFoundationBService() {
		return tcompanyFoundationBService;
	}

	/**
	 * @param tcompanyFoundationBService the tcompanyFoundationBService to set
	 */
	public void setTcompanyFoundationBService(
			TcompanyFoundationBService tcompanyFoundationBService) {
		this.tcompanyFoundationBService = tcompanyFoundationBService;
	}

	/**
	 * @return the tcompanyFoundation
	 */
	public TcompanyFoundationB getTcompanyFoundation() {
		return tcompanyFoundation;
	}

	/**
	 * @param tcompanyFoundation the tcompanyFoundation to set
	 */
	public void setTcompanyFoundation(TcompanyFoundationB tcompanyFoundation) {
		this.tcompanyFoundation = tcompanyFoundation;
	}

	/**
	 * @return the projectId
	 */
	public String getProjectId() {
		return projectId;
	}

	/**
	 * @param projectId the projectId to set
	 */
	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}

	/**
	 * @return the applyStatus
	 */
	public String getApplyStatus() {
		return applyStatus;
	}

	/**
	 * @param applyStatus the applyStatus to set
	 */
	public void setApplyStatus(String applyStatus) {
		this.applyStatus = applyStatus;
	}
	
}
