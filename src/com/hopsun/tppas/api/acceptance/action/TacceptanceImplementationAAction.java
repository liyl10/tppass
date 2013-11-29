package com.hopsun.tppas.api.acceptance.action;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.hopsun.framework.base.action.BaseAction;
import com.hopsun.scenter.entity.ScUsers;
import com.hopsun.tppas.api.acceptance.service.TacceptanceImplementationAService;
import com.hopsun.tppas.api.acceptance.service.TacceptanceService;
import com.hopsun.tppas.api.report.service.TprojectInfoAService;
import com.hopsun.tppas.api.superadmin.service.TprojectTypeService;
import com.hopsun.tppas.common.Constants;
import com.hopsun.tppas.entity.Tacceptance;
import com.hopsun.tppas.entity.TacceptanceImplementationA;
import com.hopsun.tppas.entity.TprojectInfoA;

public class TacceptanceImplementationAAction extends BaseAction{
	public final static Logger logger = Logger.getLogger(TacceptanceImplementationAAction.class.getName());
	private static final long serialVersionUID = 7980720550219392154L;

	@Resource
	private TacceptanceImplementationAService tacceptanceImplementationAService;
	/** TacceptanceService 对象的实例 */
	@Resource
	private TacceptanceService tacceptanceService;
	/** TprojectInfoAService 对象的实例 */
	@Resource
	private TprojectInfoAService tprojectInfoAService;
	/** 项目分类service*/
	@Resource
	private TprojectTypeService tprojectTypeService;
	
	/** 验收管理 */
	private Tacceptance tacceptance;
	/** 项目基本信息 */
	private TprojectInfoA tprojectInfoA;
	/** 项目经费落实和使用情况 */
	private TacceptanceImplementationA tacceptanceImplementationA;
	/** 验收ID */
	private String acceptanceId;
	/** 验收状态 */
	private String acceptanceStatus;
	/** 计划类别 */
	private String planFlagName;
	/** 跳转路径 */
	private String retUrl;
	/** 跳转页面massage */
	private String retMsg;
	
	/**
	 * @Comments 项目经费落实和使用情况画面初期化处理
	 * @return
	 * @Vsersion: 1.0
	 */
	public String infoInit(){
		// 取得登录用户的信息
		HttpSession session = this.getRequest().getSession();
		ScUsers user = (ScUsers) session.getAttribute("sysUser");
    	session.setAttribute(Constants.SESSION_CMDKEY, "tacceptanceImplementationA");
		
    	// 判断是否失效
    	if (user == null || ("").equals(user.getUserId())) {
    		logger.error("用户不存在！");
			return "LogOut";
		}

		// 根据验收ID查询项目验收管理信息
		tacceptance = tacceptanceService.getTacceptanceById(acceptanceId);
		// 根据项目ID查询项目基本信息
		if(tacceptance != null && tacceptance.getTprojectApplication() != null){
			// 根据项目ID查询项目基本信息
			List<TprojectInfoA> tprojectInfoAList = new ArrayList<TprojectInfoA>();
			tprojectInfoAList = tprojectInfoAService.getTprojectInfoAById(tacceptance.getTprojectApplication().getProjectId());
			if(tprojectInfoAList != null && tprojectInfoAList.size() > 0){
				tprojectInfoA = tprojectInfoAList.get(0);
			}
		}
		// 根据验收ID查询项目经费落实和使用情况
		List<TacceptanceImplementationA> implementationAList = new ArrayList<TacceptanceImplementationA>();
		implementationAList = tacceptanceImplementationAService.getList("tacceptance.acceptanceId", acceptanceId);
		if(implementationAList != null && implementationAList.size() > 0){
			tacceptanceImplementationA = implementationAList.get(0);
		}
		return "infoInit";
	}

	/**
	 * @return the tacceptanceImplementationAService
	 */
	public TacceptanceImplementationAService getTacceptanceImplementationAService() {
		return tacceptanceImplementationAService;
	}

	/**
	 * @param tacceptanceImplementationAService the tacceptanceImplementationAService to set
	 */
	public void setTacceptanceImplementationAService(
			TacceptanceImplementationAService tacceptanceImplementationAService) {
		this.tacceptanceImplementationAService = tacceptanceImplementationAService;
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
	 * @return the tprojectTypeService
	 */
	public TprojectTypeService getTprojectTypeService() {
		return tprojectTypeService;
	}

	/**
	 * @param tprojectTypeService the tprojectTypeService to set
	 */
	public void setTprojectTypeService(TprojectTypeService tprojectTypeService) {
		this.tprojectTypeService = tprojectTypeService;
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
	 * @return the tacceptanceImplementationA
	 */
	public TacceptanceImplementationA getTacceptanceImplementationA() {
		return tacceptanceImplementationA;
	}

	/**
	 * @param tacceptanceImplementationA the tacceptanceImplementationA to set
	 */
	public void setTacceptanceImplementationA(
			TacceptanceImplementationA tacceptanceImplementationA) {
		this.tacceptanceImplementationA = tacceptanceImplementationA;
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
	 * @return the planFlagName
	 */
	public String getPlanFlagName() {
		return planFlagName;
	}

	/**
	 * @param planFlagName the planFlagName to set
	 */
	public void setPlanFlagName(String planFlagName) {
		this.planFlagName = planFlagName;
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
