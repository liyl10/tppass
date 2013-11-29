package com.hopsun.tppas.api.acceptance.action;

import java.math.BigDecimal;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.hopsun.framework.base.action.BaseAction;
import com.hopsun.scenter.entity.ScUsers;
import com.hopsun.tppas.api.acceptance.service.TacceptanceAchievementBService;
import com.hopsun.tppas.common.Constants;
import com.hopsun.tppas.entity.Tacceptance;
import com.hopsun.tppas.entity.TacceptanceAchievementB;

public class TacceptanceAchievementBAction extends BaseAction{
	public final static Logger logger = Logger.getLogger(TacceptanceAchievementBAction.class.getName());
	private static final long serialVersionUID = 5202158541918712883L;

	@Resource
	private TacceptanceAchievementBService tacceptanceAchievementBService;
	/** 已获得知识产权数量 总数  */
	private double reportNumList1;
	/** 已申请知识产权数量 总数  */
	private double havaNumList1;
	private BigDecimal reportNumList;
	private BigDecimal havaNumList;
	/**验收*/
	private Tacceptance tacceptance;
	/** 项目验收ID*/
	private String acceptanceId;
	/** 验收状态*/
	private String acceptanceStatus;
	/** 项目取得成果情况*/
	private TacceptanceAchievementB tacceptanceAchievementB;
	/** 跳转路径 */ 
	private String retUrl;
	/** 跳转页面massage */  
	private String retMsg;
	
	/**
	 * 
	 * @comments 初始化页面 
	 * @return
	 * @version 1.0
	 */
	public String showAchievementB(){
		// 取得登录用户的信息
 		HttpSession session = this.getRequest().getSession();
 		ScUsers user = (ScUsers) session.getAttribute("sysUser");
     	session.setAttribute(Constants.SESSION_CMDKEY, "showAchievementB");
     	// 判断是否失效
     	if (user == null || ("").equals(user.getUserId())) {
     		logger.error("用户不存在！");
 			return "LogOut";
 		}

		this.acceptanceId = this.getAcceptanceId();
		this.acceptanceStatus = this.getAcceptanceStatus();
		tacceptanceAchievementB = tacceptanceAchievementBService.get("tacceptance.acceptanceId",acceptanceId);
		if(tacceptanceAchievementB!=null){
			if(tacceptanceAchievementB.getReceiveCopyrightNum() != null && tacceptanceAchievementB.getReceiveDesignsNum() != null
					&& tacceptanceAchievementB.getReceiveForeignNum() != null && tacceptanceAchievementB.getReceivePatentNum() != null
					&& tacceptanceAchievementB.getReceiveUtilityNum() != null && tacceptanceAchievementB.getApplyCopyrightNum() != null
					&& tacceptanceAchievementB.getApplyDesignsNum() != null && tacceptanceAchievementB.getApplyForeignNum() != null
					&& tacceptanceAchievementB.getApplyPatentNum() != null && tacceptanceAchievementB.getApplyUtilityNum() != null){
				// 已获得知识产权数量 总数
				reportNumList1 = tacceptanceAchievementB.getReceiveCopyrightNum().doubleValue()+
						tacceptanceAchievementB.getReceiveDesignsNum().doubleValue()+
						tacceptanceAchievementB.getReceiveForeignNum().doubleValue();
						tacceptanceAchievementB.getReceivePatentNum().doubleValue();
						tacceptanceAchievementB.getReceiveUtilityNum().doubleValue();
				reportNumList = new BigDecimal(reportNumList1);
				reportNumList =  reportNumList.setScale(4, BigDecimal.ROUND_HALF_UP);
				// 已申请知识产权数量 总数
				havaNumList1 = tacceptanceAchievementB.getApplyCopyrightNum().doubleValue()+
						tacceptanceAchievementB.getApplyDesignsNum().doubleValue()+
						tacceptanceAchievementB.getApplyForeignNum().doubleValue();
						tacceptanceAchievementB.getApplyPatentNum().doubleValue();
						tacceptanceAchievementB.getApplyUtilityNum().doubleValue();
				havaNumList = new BigDecimal(havaNumList1);
				havaNumList =  havaNumList.setScale(4, BigDecimal.ROUND_HALF_UP);

			}
		}
		return "ShowAchievementB";
	}

	/**
	 * @return the tacceptanceAchievementBService
	 */
	public TacceptanceAchievementBService getTacceptanceAchievementBService() {
		return tacceptanceAchievementBService;
	}

	/**
	 * @param tacceptanceAchievementBService the tacceptanceAchievementBService to set
	 */
	public void setTacceptanceAchievementBService(
			TacceptanceAchievementBService tacceptanceAchievementBService) {
		this.tacceptanceAchievementBService = tacceptanceAchievementBService;
	}

	/**
	 * @return the reportNumList1
	 */
	public double getReportNumList1() {
		return reportNumList1;
	}

	/**
	 * @param reportNumList1 the reportNumList1 to set
	 */
	public void setReportNumList1(double reportNumList1) {
		this.reportNumList1 = reportNumList1;
	}

	/**
	 * @return the havaNumList1
	 */
	public double getHavaNumList1() {
		return havaNumList1;
	}

	/**
	 * @param havaNumList1 the havaNumList1 to set
	 */
	public void setHavaNumList1(double havaNumList1) {
		this.havaNumList1 = havaNumList1;
	}

	/**
	 * @return the reportNumList
	 */
	public BigDecimal getReportNumList() {
		return reportNumList;
	}

	/**
	 * @param reportNumList the reportNumList to set
	 */
	public void setReportNumList(BigDecimal reportNumList) {
		this.reportNumList = reportNumList;
	}

	/**
	 * @return the havaNumList
	 */
	public BigDecimal getHavaNumList() {
		return havaNumList;
	}

	/**
	 * @param havaNumList the havaNumList to set
	 */
	public void setHavaNumList(BigDecimal havaNumList) {
		this.havaNumList = havaNumList;
	}

	/**
	 * @return the tacceptance
	 */
	public Tacceptance getTacceptance() {
		return tacceptance;
	}

	/**
	 * @param tacceptance the tacceptance to set
	 */
	public void setTacceptance(Tacceptance tacceptance) {
		this.tacceptance = tacceptance;
	}

	/**
	 * @return the acceptanceId
	 */
	public String getAcceptanceId() {
		return acceptanceId;
	}

	/**
	 * @param acceptanceId the acceptanceId to set
	 */
	public void setAcceptanceId(String acceptanceId) {
		this.acceptanceId = acceptanceId;
	}

	/**
	 * @return the acceptanceStatus
	 */
	public String getAcceptanceStatus() {
		return acceptanceStatus;
	}

	/**
	 * @param acceptanceStatus the acceptanceStatus to set
	 */
	public void setAcceptanceStatus(String acceptanceStatus) {
		this.acceptanceStatus = acceptanceStatus;
	}

	/**
	 * @return the tacceptanceAchievementB
	 */
	public TacceptanceAchievementB getTacceptanceAchievementB() {
		return tacceptanceAchievementB;
	}

	/**
	 * @param tacceptanceAchievementB the tacceptanceAchievementB to set
	 */
	public void setTacceptanceAchievementB(
			TacceptanceAchievementB tacceptanceAchievementB) {
		this.tacceptanceAchievementB = tacceptanceAchievementB;
	}

	/**
	 * @return the retUrl
	 */
	public String getRetUrl() {
		return retUrl;
	}

	/**
	 * @param retUrl the retUrl to set
	 */
	public void setRetUrl(String retUrl) {
		this.retUrl = retUrl;
	}

	/**
	 * @return the retMsg
	 */
	public String getRetMsg() {
		return retMsg;
	}

	/**
	 * @param retMsg the retMsg to set
	 */
	public void setRetMsg(String retMsg) {
		this.retMsg = retMsg;
	}
	
}
