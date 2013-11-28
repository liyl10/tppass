/*************** 版权声明***************
 *
 * Copyright (C) 2012 西安辉盛科技发展有限责任公司.
 *
 ********************************************
 */
package com.hopsun.tppas.api.report.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.hopsun.framework.base.action.BaseAction;
import com.hopsun.scenter.entity.ScUsers;
import com.hopsun.tppas.api.report.service.TcostEstimateBService;
import com.hopsun.tppas.api.report.service.TfinancingUseService;
import com.hopsun.tppas.api.report.service.TmoneyScheduleAService;
import com.hopsun.tppas.api.report.service.TprojectApplicationService;
import com.hopsun.tppas.api.superadmin.service.TprojectTypeService;
import com.hopsun.tppas.entity.TcostEstimateB;
import com.hopsun.tppas.entity.TfinancingUse;
import com.hopsun.tppas.entity.TmoneyScheduleA;

/**
 * @comments 资金用途及用款计划
 * @author wanglw
 * @date 2013-8-26 @time 下午2:10:57
 * @Version 1.0
 */
public class TfinancingUseAction extends BaseAction {

	public final static Logger logger = Logger.getLogger(TfinancingUseAction.class.getName());
	private static final long serialVersionUID = 29961074582406245L;

	@Resource
	private TfinancingUseService tfinancingUseService;
	@Resource
	private TmoneyScheduleAService tmoneyScheduleAService;
	@Resource
	private TprojectApplicationService tprojectApplicationService;
	@Resource
	private TcostEstimateBService tcostEstimateBService;
	@Resource
	private TprojectTypeService tprojectTypeService;

	/** 项目状态 */
	private String applyStatus;
	/** 项目ID */
	private String projectId;
	/** 资金用途 */
	private TfinancingUse tfinancingUse;
	/** 用款计划 */
	private TmoneyScheduleA tmoneyScheduleA;
	/** 跳转路径 */
	private String retUrl;
	/** 跳转页面massage */
	private String retMsg;
	/** 初期年度 */
	private List<Map<String, Object>> yearList;
	/** 临时列表 */
	private List<Map<String, Object>> tempList;
	/** 资金用途列表 */
	private List<TfinancingUse> capitalList;
	/** 删除的资金用途ID */
	private List<String> delCapitalIdList;
	/** 自筹资金合计 */
	private double selfRaisedFundsList;
	/** 专项资金合计 */
	private double specialAmountList;
	/** 第三年存在区分 */
	private String year3Flag;
	/** 经费概算 */
	private TcostEstimateB tcostEstimateB;
	/** 企业信息显示Flag */
	private String isWriteFlag;

	/**
	 * @comments 显示资金用途及用款计划（产业处）
	 * @return
	 * @Version 1.0
	 */
	public String showTfinancingUse() {

		HttpSession session = this.getRequest().getSession();
		// 取得登录用户的信息
		ScUsers user = (ScUsers) session.getAttribute("sysUser");
		// session.setAttribute(Constants.SESSION_CMDKEY,
		// "showTexpectedResults");

		// 判断是否失效
		if (user == null || ("").equals(user.getUserId())) {
			logger.error("用户不存在！");
			return "LogOut";
		}

		// 取得资金用途列表
		// this.capitalList =
		// tfinancingUseService.getList("tprojectApplication.projectId",
		// projectId);
		this.tfinancingUse = tfinancingUseService.get("tprojectApplication.projectId", projectId);

		// 经费概算
		this.tcostEstimateB = tcostEstimateBService.get("tprojectApplication.projectId", projectId);
		if (tcostEstimateB == null) {
			this.tcostEstimateB = new TcostEstimateB();
		}

		// 取得年度列表
		this.yearList = tprojectApplicationService.getStart2EndYear(projectId);

		if (yearList != null) {

			if (yearList.size() == 2) {
				Map<String, Object> tempMap = new HashMap<String, Object>();
				tempMap.put("year", Integer.parseInt(String.valueOf(yearList.get(1).get("year"))) + 1);
				yearList.add(tempMap);

				year3Flag = "1";
			} else {
				year3Flag = "0";
			}
		}

		// 取得用款计划
		this.tmoneyScheduleA = tmoneyScheduleAService.get("tprojectApplication.projectId", projectId);

		// 是否存在企业信息
		if (tprojectTypeService.getIsWrite(projectId)) {
			this.isWriteFlag = "1";
		} else {
			this.isWriteFlag = "0";
		}

		return "showTfinancingUse";
	}

	/*	*//**
	 * @comments 下一步（产业处）
	 * @return
	 * @Version 1.0
	 */
	/*
	 * public String nextTfinancingUse(){ HttpSession session =
	 * this.getRequest().getSession(); CompanyInfoBean company =
	 * (CompanyInfoBean) session.getAttribute(Constants.SESSION_COMPANYINFO);
	 * String cmdkey = (String) session.getAttribute(Constants.SESSION_CMDKEY);
	 * // 取得令牌信息 if (cmdkey == null || !"financingUse".equals(cmdkey)) {
	 * logger.error("错误的令牌！"); return "LogOut"; }
	 * 
	 * // 取得项目Id this.projectId = this.getProjectId();
	 * 
	 * // 取得项目状态 this.applyStatus = this.getApplyStatus();
	 * 
	 * // 取得资金用途列表 this.capitalList = this.getCapitalList();
	 * 
	 * // 取得自筹资金合计 this.selfRaisedFundsList = this.getSelfRaisedFundsList();
	 * 
	 * // 取得专项资金合计 this.specialAmountList = this.getSpecialAmountList();
	 * 
	 * // 取得已删除的资金用途ID this.delCapitalIdList = this.getDelCapitalIdList();
	 * 
	 * // 取得用款计划 this.tmoneyScheduleA = this.getTmoneyScheduleA();
	 * 
	 * // 保存/更新 tfinancingUseService.saveTfinancingUse(capitalList,
	 * selfRaisedFundsList, specialAmountList, tmoneyScheduleA,
	 * delCapitalIdList, company.getPkUoaiId(), projectId);
	 * 
	 * // 设置提示信息 this.setRetMsg(this.getText("opt_save_suc"));
	 * 
	 * // 是否存在企业信息 if(tprojectTypeService.getIsWrite(projectId)){ // 企业项目信息
	 * this.setRetUrl(super.getRequest().getContextPath() +
	 * "/server/report/tcompanyInfoAction!showCompanyInfo.action?projectId=" +
	 * this.projectId + "&applyStatus=" + this.getApplyStatus() + "&now=" + new
	 * Date().getTime()); } else { // 审查意见
	 * this.setRetUrl(super.getRequest().getContextPath() +
	 * "/server/report/treviewCommentsAction!showTreviewCommentsNonTech.action?projectId="
	 * + this.projectId + "&applyStatus=" + this.getApplyStatus() + "&now=" +
	 * new Date().getTime()); }
	 * 
	 * return "systemInfoNext"; }
	 */
	/**
	 * @comments 显示资金用途及用款计划
	 * @return
	 * @Version 1.0
	 */
	public String showTfinancingUseNontech() {

		HttpSession session = this.getRequest().getSession();
		// 取得登录用户的信息
		ScUsers user = (ScUsers) session.getAttribute("sysUser");
		// session.setAttribute(Constants.SESSION_CMDKEY,
		// "showTexpectedResults");

		// 判断是否失效
		if (user == null || ("").equals(user.getUserId())) {
			logger.error("用户不存在！");
			return "LogOut";
		}

		// 取得项目Id
		this.projectId = this.getProjectId();

		// 取得项目状态
		this.applyStatus = this.getApplyStatus();

		// 取得资金用途
		this.tfinancingUse = tfinancingUseService.get("tprojectApplication.projectId", projectId);

		this.yearList = tprojectApplicationService.getStart2EndYear(projectId);

		if (yearList != null) {

			if (yearList.size() == 2) {
				Map<String, Object> tempMap = new HashMap<String, Object>();
				tempMap.put("year", Integer.parseInt(String.valueOf(yearList.get(1).get("year"))) + 1);
				yearList.add(tempMap);

				year3Flag = "1";
			} else {
				year3Flag = "0";
			}
		}
		// 取得用款计划
		this.tmoneyScheduleA = tmoneyScheduleAService.get("tprojectApplication.projectId", projectId);

		return "showTfinancingUseNontech";
	}

	/*	*//**
	 * @comments 保存资金用途、用款计划
	 * @return
	 * @Version 1.0
	 */
	/*
	 * public String saveTfinancingUseNontech(){
	 * 
	 * HttpSession session = this.getRequest().getSession(); CompanyInfoBean
	 * company = (CompanyInfoBean)
	 * session.getAttribute(Constants.SESSION_COMPANYINFO); String cmdkey =
	 * (String) session.getAttribute(Constants.SESSION_CMDKEY); // 取得令牌信息 if
	 * (cmdkey == null || !"financingUseNontech".equals(cmdkey)) {
	 * logger.error("错误的令牌！"); return "LogOut"; }
	 * 
	 * // 取得资金用途 this.tfinancingUse = this.getTfinancingUse();
	 * 
	 * // 取得用款计划 this.tmoneyScheduleA = this.getTmoneyScheduleA();
	 * 
	 * // 保存资金用途和用款计划
	 * tfinancingUseService.saveTfinancingUseNonTech(tfinancingUse,
	 * tmoneyScheduleA, company.getPkUoiId());
	 * 
	 * // 设置提示信息 this.setRetMsg(this.getText("opt_save_suc"));
	 * 
	 * // 设置actionUrl this.setRetUrl(super.getRequest().getContextPath() +
	 * "/server/report/tfinancingUseAction!showTfinancingUseNontech.action?projectId="
	 * + this.projectId + "&applyStatus=" + this.getApplyStatus() + "&now=" +
	 * new Date().getTime());
	 * 
	 * return "systemInfo";
	 * 
	 * }
	 */

	/*	*//**
	 * @comments 下一步
	 * @return
	 * @Version 1.0
	 */
	/*
	 * public String nextTfinancingUseNontech(){
	 * 
	 * HttpSession session = this.getRequest().getSession(); CompanyInfoBean
	 * company = (CompanyInfoBean)
	 * session.getAttribute(Constants.SESSION_COMPANYINFO); String cmdkey =
	 * (String) session.getAttribute(Constants.SESSION_CMDKEY); // 取得令牌信息 if
	 * (cmdkey == null || !"financingUseNontech".equals(cmdkey)) {
	 * logger.error("错误的令牌！"); return "LogOut"; }
	 * 
	 * // 取得资金用途 this.tfinancingUse = this.getTfinancingUse();
	 * 
	 * // 取得用款计划 this.tmoneyScheduleA = this.getTmoneyScheduleA();
	 * 
	 * // 保存资金用途和用款计划
	 * tfinancingUseService.saveTfinancingUseNonTech(tfinancingUse,
	 * tmoneyScheduleA, company.getPkUoiId());
	 * 
	 * // 设置提示信息 this.setRetMsg(this.getText("opt_save_suc"));
	 * 
	 * // 设置actionUrl this.setRetUrl(super.getRequest().getContextPath() +
	 * "/server/report/treviewCommentsAction!showTreviewCommentsNonTech.action?projectId="
	 * + this.projectId + "&applyStatus=" + this.getApplyStatus() + "&now=" +
	 * new Date().getTime());
	 * 
	 * return "systemInfoNext";
	 * 
	 * }
	 */

	public String getApplyStatus() {
		return applyStatus;
	}

	public void setApplyStatus(String applyStatus) {
		this.applyStatus = applyStatus;
	}

	public String getProjectId() {
		return projectId;
	}

	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}

	public TfinancingUse getTfinancingUse() {
		return tfinancingUse;
	}

	public void setTfinancingUse(TfinancingUse tfinancingUse) {
		this.tfinancingUse = tfinancingUse;
	}

	public TmoneyScheduleA getTmoneyScheduleA() {
		return tmoneyScheduleA;
	}

	public void setTmoneyScheduleA(TmoneyScheduleA tmoneyScheduleA) {
		this.tmoneyScheduleA = tmoneyScheduleA;
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

	public List<Map<String, Object>> getYearList() {
		return yearList;
	}

	public void setYearList(List<Map<String, Object>> yearList) {
		this.yearList = yearList;
	}

	public List<Map<String, Object>> getTempList() {
		return tempList;
	}

	public void setTempList(List<Map<String, Object>> tempList) {
		this.tempList = tempList;
	}

	public List<TfinancingUse> getCapitalList() {
		return capitalList;
	}

	public void setCapitalList(List<TfinancingUse> capitalList) {
		this.capitalList = capitalList;
	}

	public List<String> getDelCapitalIdList() {
		return delCapitalIdList;
	}

	public void setDelCapitalIdList(List<String> delCapitalIdList) {
		this.delCapitalIdList = delCapitalIdList;
	}

	public double getSelfRaisedFundsList() {
		return selfRaisedFundsList;
	}

	public void setSelfRaisedFundsList(double selfRaisedFundsList) {
		this.selfRaisedFundsList = selfRaisedFundsList;
	}

	public double getSpecialAmountList() {
		return specialAmountList;
	}

	public void setSpecialAmountList(double specialAmountList) {
		this.specialAmountList = specialAmountList;
	}

	public String getYear3Flag() {
		return year3Flag;
	}

	public void setYear3Flag(String year3Flag) {
		this.year3Flag = year3Flag;
	}

	public TcostEstimateB getTcostEstimateB() {
		return tcostEstimateB;
	}

	public void setTcostEstimateB(TcostEstimateB tcostEstimateB) {
		this.tcostEstimateB = tcostEstimateB;
	}

	/**
	 * @return the tfinancingUseService
	 */
	public TfinancingUseService getTfinancingUseService() {
		return tfinancingUseService;
	}

	/**
	 * @param tfinancingUseService
	 *            the tfinancingUseService to set
	 */
	public void setTfinancingUseService(TfinancingUseService tfinancingUseService) {
		this.tfinancingUseService = tfinancingUseService;
	}

	/**
	 * @return the tmoneyScheduleAService
	 */
	public TmoneyScheduleAService getTmoneyScheduleAService() {
		return tmoneyScheduleAService;
	}

	/**
	 * @param tmoneyScheduleAService
	 *            the tmoneyScheduleAService to set
	 */
	public void setTmoneyScheduleAService(TmoneyScheduleAService tmoneyScheduleAService) {
		this.tmoneyScheduleAService = tmoneyScheduleAService;
	}

	/**
	 * @return the tprojectApplicationService
	 */
	public TprojectApplicationService getTprojectApplicationService() {
		return tprojectApplicationService;
	}

	/**
	 * @param tprojectApplicationService
	 *            the tprojectApplicationService to set
	 */
	public void setTprojectApplicationService(TprojectApplicationService tprojectApplicationService) {
		this.tprojectApplicationService = tprojectApplicationService;
	}

	/**
	 * @return the tcostEstimateBService
	 */
	public TcostEstimateBService getTcostEstimateBService() {
		return tcostEstimateBService;
	}

	/**
	 * @param tcostEstimateBService
	 *            the tcostEstimateBService to set
	 */
	public void setTcostEstimateBService(TcostEstimateBService tcostEstimateBService) {
		this.tcostEstimateBService = tcostEstimateBService;
	}

	/**
	 * @return the tprojectTypeService
	 */
	public TprojectTypeService getTprojectTypeService() {
		return tprojectTypeService;
	}

	/**
	 * @param tprojectTypeService
	 *            the tprojectTypeService to set
	 */
	public void setTprojectTypeService(TprojectTypeService tprojectTypeService) {
		this.tprojectTypeService = tprojectTypeService;
	}

	/**
	 * @return the isWriteFlag
	 */
	public String getIsWriteFlag() {
		return isWriteFlag;
	}

	/**
	 * @param isWriteFlag
	 *            the isWriteFlag to set
	 */
	public void setIsWriteFlag(String isWriteFlag) {
		this.isWriteFlag = isWriteFlag;
	}

}
