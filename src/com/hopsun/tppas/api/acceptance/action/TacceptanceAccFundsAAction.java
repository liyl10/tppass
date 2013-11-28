package com.hopsun.tppas.api.acceptance.action;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.hopsun.framework.base.action.BaseAction;
import com.hopsun.scenter.entity.ScUsers;
import com.hopsun.tppas.api.acceptance.service.TacceptanceAccFundsAService;
import com.hopsun.tppas.api.acceptance.service.TacceptanceService;
import com.hopsun.tppas.api.report.service.TprojectInfoAService;
import com.hopsun.tppas.common.Constants;
import com.hopsun.tppas.entity.Tacceptance;
import com.hopsun.tppas.entity.TacceptanceAccFundsA;
import com.hopsun.tppas.entity.TprojectInfoA;

public class TacceptanceAccFundsAAction extends BaseAction{
	public final static Logger logger = Logger.getLogger(TacceptanceAccFundsAAction.class.getName());
	private static final long serialVersionUID = 8401329001595402623L;

	@Resource
	private TacceptanceAccFundsAService tacceptanceAccFundsAService;
	/** TacceptanceService 对象的实例 */
	@Resource
	private TacceptanceService tacceptanceService;
	/** TprojectInfoAService 对象的实例 */
	@Resource
	private TprojectInfoAService tprojectInfoAService;
	
	/** 验收管理 */
	private Tacceptance tacceptance;
	/** 项目基本信息 */
	private TprojectInfoA tprojectInfoA;
	/** 项目验收经费登记表 */
	private TacceptanceAccFundsA tacceptanceAccFundsA;
	/** 验收ID */
	private String acceptanceId;
	/** 验收状态 */
	private String acceptanceStatus;
	/** 跳转路径 */
	private String retUrl;
	/** 跳转页面massage */
	private String retMsg;
	
	/**
	 * 项目验收经费登记表初始化
	 * @return
	 * @Vsersion: 1.0
	 */
	public String accFundsInit(){
		// 取得登录用户的信息
		HttpSession session = this.getRequest().getSession();
		ScUsers user = (ScUsers) session.getAttribute("sysUser");
    	session.setAttribute(Constants.SESSION_CMDKEY, "tacceptanceAccFundsA");
		
    	// 判断是否失效
    	if (user == null || ("").equals(user.getUserId())) {
    		logger.error("用户不存在！");
			return "LogOut";
		}

		// 根据验收ID查询项目验收管理信息
		tacceptance = tacceptanceService.getTacceptanceById(acceptanceId);
		// 根据项目ID查询项目基本信息
		if(tacceptance.getTprojectApplication() != null){
			List<TprojectInfoA> tprojectInfoAList = new ArrayList<TprojectInfoA>();
			tprojectInfoAList = tprojectInfoAService.getList("tprojectApplication.projectId", tacceptance.getTprojectApplication().getProjectId());
			if(tprojectInfoAList != null && tprojectInfoAList.size() > 0){
				tprojectInfoA = tprojectInfoAList.get(0);
			}
		}
		// 根据验收ID查询项目验收经费登记情况
		List<TacceptanceAccFundsA> accFundsAList = new ArrayList<TacceptanceAccFundsA>();
		accFundsAList = tacceptanceAccFundsAService.getList("tacceptance.acceptanceId", acceptanceId);
		if(accFundsAList != null && accFundsAList.size() > 0){
			tacceptanceAccFundsA = accFundsAList.get(0);
		}
	
		return "accFundsInit";
	}

	/**
	 * @return the tacceptanceAccFundsAService
	 */
	public TacceptanceAccFundsAService getTacceptanceAccFundsAService() {
		return tacceptanceAccFundsAService;
	}

	/**
	 * @param tacceptanceAccFundsAService the tacceptanceAccFundsAService to set
	 */
	public void setTacceptanceAccFundsAService(
			TacceptanceAccFundsAService tacceptanceAccFundsAService) {
		this.tacceptanceAccFundsAService = tacceptanceAccFundsAService;
	}

	/**
	 * @return the tacceptanceService
	 */
	public TacceptanceService getTacceptanceService() {
		return tacceptanceService;
	}

	/**
	 * @param tacceptanceService the tacceptanceService to set
	 */
	public void setTacceptanceService(TacceptanceService tacceptanceService) {
		this.tacceptanceService = tacceptanceService;
	}

	/**
	 * @return the tprojectInfoAService
	 */
	public TprojectInfoAService getTprojectInfoAService() {
		return tprojectInfoAService;
	}

	/**
	 * @param tprojectInfoAService the tprojectInfoAService to set
	 */
	public void setTprojectInfoAService(TprojectInfoAService tprojectInfoAService) {
		this.tprojectInfoAService = tprojectInfoAService;
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
	 * @return the tprojectInfoA
	 */
	public TprojectInfoA getTprojectInfoA() {
		return tprojectInfoA;
	}

	/**
	 * @param tprojectInfoA the tprojectInfoA to set
	 */
	public void setTprojectInfoA(TprojectInfoA tprojectInfoA) {
		this.tprojectInfoA = tprojectInfoA;
	}

	/**
	 * @return the tacceptanceAccFundsA
	 */
	public TacceptanceAccFundsA getTacceptanceAccFundsA() {
		return tacceptanceAccFundsA;
	}

	/**
	 * @param tacceptanceAccFundsA the tacceptanceAccFundsA to set
	 */
	public void setTacceptanceAccFundsA(TacceptanceAccFundsA tacceptanceAccFundsA) {
		this.tacceptanceAccFundsA = tacceptanceAccFundsA;
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
