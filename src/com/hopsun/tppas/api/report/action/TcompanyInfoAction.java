package com.hopsun.tppas.api.report.action;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.hopsun.scenter.entity.ScUsers;
import com.hopsun.tppas.api.report.service.TcompanyInfoService;
import com.hopsun.tppas.api.report.service.TprojectApplicationService;
import com.hopsun.tppas.api.superadmin.service.MitemService;
import com.hopsun.tppas.api.superadmin.service.TprojectTypeService;
import com.hopsun.tppas.common.Constants;
import com.hopsun.tppas.entity.Mitem;
import com.hopsun.tppas.entity.TcompanyInfo;
import com.hopsun.tppas.entity.TprojectApplication;
import com.hopsun.tppas.entity.TprojectType;
import com.hopsun.framework.base.action.BaseAction;
import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

public class TcompanyInfoAction extends BaseAction {

	public final static Logger logger = Logger.getLogger(TcompanyInfoAction.class.getName());

	private static final long serialVersionUID = 3098382336493116807L;

	@Resource
	private TcompanyInfoService tcompanyInfoService;
	@Resource
	private TprojectApplicationService tprojectApplicationService;
	@Resource
	private TprojectTypeService tprojectTypeService;
	@Resource
	private MitemService mitemService;

	// 项目申报表
	private TprojectApplication tprojectApplication;
	// 企业项目基本信息表
	private TcompanyInfo tcompanyInfo;
	// 项目id
	private String projectId;
	// 项目状态
	private String applyStatus;
	// 年度
	private String yearValue;
	// 标题
	private String title;
	// 第三年度存在的标志
	private String year1Flag;
	private String retUrl;
	private String retMsg;

	private Integer yearBenefit1;
	private Integer yearBenefit2;
	private Integer yearBenefit3;
	private Integer yearOperate1;
	private Integer yearOperate2;
	private Integer yearOperate3;

	/** 推荐意见 */
	private List<Mitem> recommendationList;

	/**
	 * 企业项目基本信息表初期化
	 * 
	 * @return
	 */
	public String showCompanyInfo() {
		HttpSession session = this.getRequest().getSession();
		ScUsers user = (ScUsers) session.getAttribute("sysUser");
		// session.setAttribute(Constants.SESSION_CMDKEY, "companyInfo");

		// 判断是否失效
		if (user == null || ("").equals(user.getUserId())) {
			logger.error("用户不存在！");
			return "LogOut";
		}

		// 取得项目Id
		this.projectId = this.getProjectId();
		// 取得项目状态
		this.applyStatus = this.getApplyStatus();
		// 初始化推荐意见List
		this.recommendationList = new ArrayList<Mitem>();
		// 推荐意见
		this.recommendationList = mitemService.getListByTypeId(Constants.COMPANY_RECOMMENDATION);
		// 取得企业项目基本信息表
		this.tcompanyInfo = tcompanyInfoService.get("tprojectApplication.projectId", projectId);
		// 项目申报表
		this.tprojectApplication = tprojectApplicationService.get(projectId);
		if (this.tprojectApplication != null) {
			// 年份的计算
			Timestamp starttime = this.tprojectApplication.getStartTime();
			Timestamp endtime = this.tprojectApplication.getEndTime();
			if (endtime != null) {
				this.yearValue = endtime.toString().substring(0, 4);
			}
			if (starttime != null && endtime != null) {
				String startyear = starttime.toString().substring(0, 4);
				String endyear = endtime.toString().substring(0, 4);
				if (Integer.parseInt(endyear) - Integer.parseInt(startyear) > 1) {
					yearBenefit1 = Integer.parseInt(endyear);
					yearBenefit2 = Integer.parseInt(startyear) + 1;
					yearBenefit3 = Integer.parseInt(startyear);
					this.year1Flag = "1";
				} else if (Integer.parseInt(endyear) - Integer.parseInt(startyear) == 1) {
					yearBenefit2 = Integer.parseInt(endyear);
					yearBenefit3 = Integer.parseInt(startyear);
					yearBenefit1 = Integer.parseInt(endyear) + 1;
					this.year1Flag = "0";
				} else if (Integer.parseInt(endyear) - Integer.parseInt(startyear) == 0) {
					yearBenefit2 = null;
					yearBenefit3 = Integer.parseInt(endyear);
					yearBenefit1 = null;
				}
			}
			if (this.tprojectApplication.getReportYear() != null) {
				String reportYear = this.tprojectApplication.getReportYear();
				yearOperate1 = Integer.parseInt(reportYear) - 1;
				yearOperate2 = Integer.parseInt(reportYear) - 2;
				yearOperate3 = Integer.parseInt(reportYear) - 3;
			}
		}

		// 标题
		if (this.tprojectApplication != null) {
			TprojectType tprojectType = tprojectTypeService.get(tprojectApplication.getTprojectType().getParentTypeId());
			title = tprojectType.getTypeShowName() + Constants.STRING_LINK + tprojectApplication.getTprojectType().getTypeShowName();
		}

		return "showCompanyInfo";
	}

	/**
	 * 
	 * @comments 保存企业项目基本信息
	 * @return
	 * @throws Exception
	 * @version 1.0
	 */
	public String updateTcompanyInfo() throws Exception {
		// 取得登录用户的信息
		HttpSession session = this.getRequest().getSession();
		// String cmdkey = (String)
		// session.getAttribute(Constants.SESSION_CMDKEY);
		ScUsers user = (ScUsers) session.getAttribute("sysUser");
		// 判断是否失效
		if (user == null || ("").equals(user.getUserId())) {
			logger.error("用户不存在！");
			return "LogOut";
		}

		/*
		 * if (cmdkey == null || !"companyInfo".equals(cmdkey)) {
		 * logger.error("错误的令牌！"); return "LogOut"; }
		 */

		tcompanyInfoService.updateTcompanyInfo(this.tcompanyInfo, this.projectId, user.getUserId());
		this.setRetMsg(this.getText("opt_save_suc"));
		this.setRetUrl(super.getRequest().getContextPath() + "/api/report/tcompanyInfoAction!showCompanyInfo.action?projectId=" + this.projectId + "&applyStatus=" + this.applyStatus + "&now="
				+ new Date().getTime());
		return "systemInfo";
	}

	/**
	 * 
	 * @comments 下一步操作
	 * @return
	 * @throws Exception
	 * @version 1.0
	 */
	public String next() throws Exception {
		// 取得登录用户的信息
		HttpSession session = this.getRequest().getSession();
		// String cmdkey = (String)
		// session.getAttribute(Constants.SESSION_CMDKEY);
		ScUsers user = (ScUsers) session.getAttribute("sysUser");
		// 判断是否失效
		if (user == null || ("").equals(user.getUserId())) {
			logger.error("用户不存在！");
			return "LogOut";
		}

		/*
		 * if (cmdkey == null || !"companyInfo".equals(cmdkey)) {
		 * logger.error("错误的令牌！"); return "LogOut"; }
		 */

		tcompanyInfoService.updateTcompanyInfo(this.tcompanyInfo, this.projectId, user.getUserId());
		this.setRetMsg(this.getText("opt_save_suc"));
		this.setRetUrl(super.getRequest().getContextPath() + "/api/report/treviewCommentsAction!showTreviewCommentsNonTech.action?projectId=" + this.projectId + "&applyStatus=" + this.applyStatus
				+ "&now=" + new Date().getTime());
		return "systemInfoNext";
	}

	public TcompanyInfoService getTcompanyInfoService() {
		return tcompanyInfoService;
	}

	public void setTcompanyInfoService(TcompanyInfoService tcompanyInfoService) {
		this.tcompanyInfoService = tcompanyInfoService;
	}

	public TcompanyInfo getTcompanyInfo() {
		return tcompanyInfo;
	}

	public void setTcompanyInfo(TcompanyInfo tcompanyInfo) {
		this.tcompanyInfo = tcompanyInfo;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getProjectId() {
		return projectId;
	}

	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}

	public static Logger getLogger() {
		return logger;
	}

	public String getApplyStatus() {
		return applyStatus;
	}

	public void setApplyStatus(String applyStatus) {
		this.applyStatus = applyStatus;
	}

	public TprojectApplicationService getTprojectApplicationService() {
		return tprojectApplicationService;
	}

	public void setTprojectApplicationService(TprojectApplicationService tprojectApplicationService) {
		this.tprojectApplicationService = tprojectApplicationService;
	}

	public TprojectApplication getTprojectApplication() {
		return tprojectApplication;
	}

	public void setTprojectApplication(TprojectApplication tprojectApplication) {
		this.tprojectApplication = tprojectApplication;
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

	public String getYearValue() {
		return yearValue;
	}

	public void setYearValue(String yearValue) {
		this.yearValue = yearValue;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
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
	 * @return the yearBenefit1
	 */
	public Integer getYearBenefit1() {
		return yearBenefit1;
	}

	/**
	 * @param yearBenefit1
	 *            the yearBenefit1 to set
	 */
	public void setYearBenefit1(Integer yearBenefit1) {
		this.yearBenefit1 = yearBenefit1;
	}

	/**
	 * @return the yearBenefit2
	 */
	public Integer getYearBenefit2() {
		return yearBenefit2;
	}

	/**
	 * @param yearBenefit2
	 *            the yearBenefit2 to set
	 */
	public void setYearBenefit2(Integer yearBenefit2) {
		this.yearBenefit2 = yearBenefit2;
	}

	/**
	 * @return the yearBenefit3
	 */
	public Integer getYearBenefit3() {
		return yearBenefit3;
	}

	/**
	 * @param yearBenefit3
	 *            the yearBenefit3 to set
	 */
	public void setYearBenefit3(Integer yearBenefit3) {
		this.yearBenefit3 = yearBenefit3;
	}

	/**
	 * @return the yearOperate1
	 */
	public Integer getYearOperate1() {
		return yearOperate1;
	}

	/**
	 * @param yearOperate1
	 *            the yearOperate1 to set
	 */
	public void setYearOperate1(Integer yearOperate1) {
		this.yearOperate1 = yearOperate1;
	}

	/**
	 * @return the yearOperate2
	 */
	public Integer getYearOperate2() {
		return yearOperate2;
	}

	/**
	 * @param yearOperate2
	 *            the yearOperate2 to set
	 */
	public void setYearOperate2(Integer yearOperate2) {
		this.yearOperate2 = yearOperate2;
	}

	/**
	 * @return the yearOperate3
	 */
	public Integer getYearOperate3() {
		return yearOperate3;
	}

	/**
	 * @param yearOperate3
	 *            the yearOperate3 to set
	 */
	public void setYearOperate3(Integer yearOperate3) {
		this.yearOperate3 = yearOperate3;
	}

	/**
	 * @return the year1Flag
	 */
	public String getYear1Flag() {
		return year1Flag;
	}

	/**
	 * @param year1Flag
	 *            the year1Flag to set
	 */
	public void setYear1Flag(String year1Flag) {
		this.year1Flag = year1Flag;
	}

	/**
	 * @return the recommendationList
	 */
	public List<Mitem> getRecommendationList() {
		return recommendationList;
	}

	/**
	 * @param recommendationList
	 *            the recommendationList to set
	 */
	public void setRecommendationList(List<Mitem> recommendationList) {
		this.recommendationList = recommendationList;
	}

}
