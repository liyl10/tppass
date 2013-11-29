package com.hopsun.tppas.api.report.action;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.hopsun.framework.base.action.BaseAction;
import com.hopsun.scenter.entity.ScUsers;
import com.hopsun.tppas.api.report.service.TeconomicIndicatorBService;
import com.hopsun.tppas.api.report.service.TprojectApplicationService;
import com.hopsun.tppas.entity.TeconomicIndicatorB;
import com.hopsun.tppas.entity.TprojectApplication;

/**
 * @comment 执行期内项目完成的经济指标
 * @author liush
 * @DATE: 2013-9-2 @TIME: 下午3:40:27
 * @Vsersion: 1.0
 */
public class TeconomicIndicatorBAction extends BaseAction {
	public final static Logger LOGGER = Logger.getLogger(TeconomicIndicatorBAction.class.getName());

	private static final long serialVersionUID = 4612170206867243184L;
	@Resource
	private TeconomicIndicatorBService teconomicIndicatorBService;
	@Resource
	private TprojectApplicationService tprojectApplicationService;
	/** 项目申报信息 */
	private TprojectApplication tprojectApplication;
	private TeconomicIndicatorB teconomicIndicator;
	/** 项目id */
	private String projectId;
	/** 项目状态 */
	private String applyStatus;
	/** 当前年 */
	private int nowYear;
	/** 产值累计 */
	private double outputValueList1;
	/** 所交税金累计 */
	private double payTaxesList1;
	/** 净利润 累计 */
	private double petainedList1;
	/** 创汇(万美元)累计 */
	private double earnMoneyList1;
	private String projectTime;
	private String year1;
	private String year2;
	private String year3;
	private BigDecimal outputValueList;
	private BigDecimal payTaxesList;
	private BigDecimal petainedList;
	private BigDecimal earnMoneyList;

	/**
	 * @comments 产业处页面初始化
	 * @return
	 * @version 1.0
	 */
	public String initHighTech() {
		// 取得登录用户的信息
		HttpSession session = this.getRequest().getSession();
		ScUsers user = (ScUsers) session.getAttribute("sysUser");
		// session.setAttribute(Constants.SESSION_CMDKEY,
		// "projectQuotaHighTech");

		// 判断是否失效
		if (user == null || ("").equals(user.getUserId())) {
			LOGGER.error("用户不存在！");
			return "LogOut";
		}

		this.tprojectApplication = tprojectApplicationService.get(projectId);

		this.projectTime = tprojectApplication.getReportYear();
		this.teconomicIndicator = teconomicIndicatorBService.get("tprojectApplication.projectId", projectId);
		int beingYear = Integer.valueOf(new SimpleDateFormat("yyyy").format(tprojectApplication.getStartTime()));
		int endYear = Integer.valueOf(new SimpleDateFormat("yyyy").format(tprojectApplication.getEndTime()));

		// 判断执行期限
		if (endYear - beingYear == 2) {
			year1 = String.valueOf(beingYear);
			year2 = String.valueOf(beingYear + 1);
			year3 = String.valueOf(endYear);
		} else if (endYear - beingYear == 1) {
			year1 = String.valueOf(beingYear);
			year2 = String.valueOf(endYear);
		} else if (endYear - beingYear == 0) {
			year1 = String.valueOf(beingYear);
		}
		// 判断是否为新增
		if (teconomicIndicator != null) {
			/** 产值累计 */
			outputValueList1 = teconomicIndicator.getOutputValue2() + teconomicIndicator.getOutputValue1() + teconomicIndicator.getOutputValue();
			outputValueList = new BigDecimal(outputValueList1);
			outputValueList = outputValueList.setScale(4, BigDecimal.ROUND_HALF_UP);

			/** 所交税金累计 */
			payTaxesList1 = teconomicIndicator.getPayTaxes2() + teconomicIndicator.getPayTaxes1() + teconomicIndicator.getPayTaxes();
			payTaxesList = new BigDecimal(payTaxesList1);
			payTaxesList = payTaxesList.setScale(4, BigDecimal.ROUND_HALF_UP);
			/** 净利润 累计 */
			petainedList1 = teconomicIndicator.getRetainedProfits2() + teconomicIndicator.getRetainedProfits1() + teconomicIndicator.getRetainedProfits();
			petainedList = new BigDecimal(petainedList1);
			petainedList = petainedList.setScale(4, BigDecimal.ROUND_HALF_UP);
			/** 创汇(万美元)累计 */
			earnMoneyList1 = teconomicIndicator.getEarnMoney2() + teconomicIndicator.getEarnMoney1() + teconomicIndicator.getEarnMoney();
			earnMoneyList = new BigDecimal(earnMoneyList1);
			earnMoneyList = earnMoneyList.setScale(4, BigDecimal.ROUND_HALF_UP);

		}
		return "initHighTech";
	}

	/**
	 * @comments 非产业处页面初始化
	 * @return
	 * @version 1.0
	 */
	public String initOther() {
		// 取得登录用户的信息
		HttpSession session = this.getRequest().getSession();
		ScUsers user = (ScUsers) session.getAttribute("sysUser");
		// session.setAttribute(Constants.SESSION_CMDKEY, "projectQuotaOther");

		// 判断是否失效
		if (user == null || ("").equals(user.getUserId())) {
			LOGGER.error("用户不存在！");
			return "LogOut";
		}

		this.tprojectApplication = tprojectApplicationService.get(projectId);

		this.projectTime = tprojectApplication.getReportYear();
		this.teconomicIndicator = teconomicIndicatorBService.get("tprojectApplication.projectId", projectId);
		int beingYear = Integer.valueOf(new SimpleDateFormat("yyyy").format(tprojectApplication.getStartTime()));
		int endYear = Integer.valueOf(new SimpleDateFormat("yyyy").format(tprojectApplication.getEndTime()));

		// 判断执行期限
		if (endYear - beingYear == 2) {
			year1 = String.valueOf(beingYear);
			year2 = String.valueOf(beingYear + 1);
			year3 = String.valueOf(endYear);
		} else if (endYear - beingYear == 1) {
			year1 = String.valueOf(beingYear);
			year2 = String.valueOf(endYear);
		} else if (endYear - beingYear == 0) {
			year1 = String.valueOf(beingYear);
		}
		// 判断是否为新增
		if (teconomicIndicator != null) {
			/** 产值累计 */
			outputValueList1 = teconomicIndicator.getOutputValue2() + teconomicIndicator.getOutputValue1() + teconomicIndicator.getOutputValue();
			outputValueList = new BigDecimal(outputValueList1);
			outputValueList = outputValueList.setScale(4, BigDecimal.ROUND_HALF_UP);

			/** 所交税金累计 */
			payTaxesList1 = teconomicIndicator.getPayTaxes2() + teconomicIndicator.getPayTaxes1() + teconomicIndicator.getPayTaxes();
			payTaxesList = new BigDecimal(payTaxesList1);
			payTaxesList = payTaxesList.setScale(4, BigDecimal.ROUND_HALF_UP);
			/** 净利润 累计 */
			petainedList1 = teconomicIndicator.getRetainedProfits2() + teconomicIndicator.getRetainedProfits1() + teconomicIndicator.getRetainedProfits();
			petainedList = new BigDecimal(petainedList1);
			petainedList = petainedList.setScale(4, BigDecimal.ROUND_HALF_UP);
			/** 创汇(万美元)累计 */
			earnMoneyList1 = teconomicIndicator.getEarnMoney2() + teconomicIndicator.getEarnMoney1() + teconomicIndicator.getEarnMoney();
			earnMoneyList = new BigDecimal(earnMoneyList1);
			earnMoneyList = earnMoneyList.setScale(4, BigDecimal.ROUND_HALF_UP);

		}
		return "initOther";
	}

	/**
	 * @return the teconomicIndicatorBService
	 */
	public TeconomicIndicatorBService getTeconomicIndicatorBService() {
		return teconomicIndicatorBService;
	}

	/**
	 * @param teconomicIndicatorBService
	 *            the teconomicIndicatorBService to set
	 */
	public void setTeconomicIndicatorBService(TeconomicIndicatorBService teconomicIndicatorBService) {
		this.teconomicIndicatorBService = teconomicIndicatorBService;
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
	 * @return the tprojectApplication
	 */
	public TprojectApplication getTprojectApplication() {
		return tprojectApplication;
	}

	/**
	 * @param tprojectApplication
	 *            the tprojectApplication to set
	 */
	public void setTprojectApplication(TprojectApplication tprojectApplication) {
		this.tprojectApplication = tprojectApplication;
	}

	/**
	 * @return the teconomicIndicator
	 */
	public TeconomicIndicatorB getTeconomicIndicator() {
		return teconomicIndicator;
	}

	/**
	 * @param teconomicIndicator
	 *            the teconomicIndicator to set
	 */
	public void setTeconomicIndicator(TeconomicIndicatorB teconomicIndicator) {
		this.teconomicIndicator = teconomicIndicator;
	}

	/**
	 * @return the projectId
	 */
	public String getProjectId() {
		return projectId;
	}

	/**
	 * @param projectId
	 *            the projectId to set
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
	 * @param applyStatus
	 *            the applyStatus to set
	 */
	public void setApplyStatus(String applyStatus) {
		this.applyStatus = applyStatus;
	}

	/**
	 * @return the nowYear
	 */
	public int getNowYear() {
		return nowYear;
	}

	/**
	 * @param nowYear
	 *            the nowYear to set
	 */
	public void setNowYear(int nowYear) {
		this.nowYear = nowYear;
	}

	/**
	 * @return the outputValueList1
	 */
	public double getOutputValueList1() {
		return outputValueList1;
	}

	/**
	 * @param outputValueList1
	 *            the outputValueList1 to set
	 */
	public void setOutputValueList1(double outputValueList1) {
		this.outputValueList1 = outputValueList1;
	}

	/**
	 * @return the payTaxesList1
	 */
	public double getPayTaxesList1() {
		return payTaxesList1;
	}

	/**
	 * @param payTaxesList1
	 *            the payTaxesList1 to set
	 */
	public void setPayTaxesList1(double payTaxesList1) {
		this.payTaxesList1 = payTaxesList1;
	}

	/**
	 * @return the petainedList1
	 */
	public double getPetainedList1() {
		return petainedList1;
	}

	/**
	 * @param petainedList1
	 *            the petainedList1 to set
	 */
	public void setPetainedList1(double petainedList1) {
		this.petainedList1 = petainedList1;
	}

	/**
	 * @return the earnMoneyList1
	 */
	public double getEarnMoneyList1() {
		return earnMoneyList1;
	}

	/**
	 * @param earnMoneyList1
	 *            the earnMoneyList1 to set
	 */
	public void setEarnMoneyList1(double earnMoneyList1) {
		this.earnMoneyList1 = earnMoneyList1;
	}

	/**
	 * @return the projectTime
	 */
	public String getProjectTime() {
		return projectTime;
	}

	/**
	 * @param projectTime
	 *            the projectTime to set
	 */
	public void setProjectTime(String projectTime) {
		this.projectTime = projectTime;
	}

	/**
	 * @return the year1
	 */
	public String getYear1() {
		return year1;
	}

	/**
	 * @param year1
	 *            the year1 to set
	 */
	public void setYear1(String year1) {
		this.year1 = year1;
	}

	/**
	 * @return the year2
	 */
	public String getYear2() {
		return year2;
	}

	/**
	 * @param year2
	 *            the year2 to set
	 */
	public void setYear2(String year2) {
		this.year2 = year2;
	}

	/**
	 * @return the year3
	 */
	public String getYear3() {
		return year3;
	}

	/**
	 * @param year3
	 *            the year3 to set
	 */
	public void setYear3(String year3) {
		this.year3 = year3;
	}

	/**
	 * @return the outputValueList
	 */
	public BigDecimal getOutputValueList() {
		return outputValueList;
	}

	/**
	 * @param outputValueList
	 *            the outputValueList to set
	 */
	public void setOutputValueList(BigDecimal outputValueList) {
		this.outputValueList = outputValueList;
	}

	/**
	 * @return the payTaxesList
	 */
	public BigDecimal getPayTaxesList() {
		return payTaxesList;
	}

	/**
	 * @param payTaxesList
	 *            the payTaxesList to set
	 */
	public void setPayTaxesList(BigDecimal payTaxesList) {
		this.payTaxesList = payTaxesList;
	}

	/**
	 * @return the petainedList
	 */
	public BigDecimal getPetainedList() {
		return petainedList;
	}

	/**
	 * @param petainedList
	 *            the petainedList to set
	 */
	public void setPetainedList(BigDecimal petainedList) {
		this.petainedList = petainedList;
	}

	/**
	 * @return the earnMoneyList
	 */
	public BigDecimal getEarnMoneyList() {
		return earnMoneyList;
	}

	/**
	 * @param earnMoneyList
	 *            the earnMoneyList to set
	 */
	public void setEarnMoneyList(BigDecimal earnMoneyList) {
		this.earnMoneyList = earnMoneyList;
	}

}
