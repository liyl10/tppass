package com.hopsun.tppas.api.acceptance.action;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.hopsun.framework.base.action.BaseAction;
import com.hopsun.scenter.entity.ScUsers;
import com.hopsun.tppas.api.acceptance.service.TacceptanceOpinionAService;
import com.hopsun.tppas.common.Constants;
import com.hopsun.tppas.entity.TacceptanceOpinionA;

public class TacceptanceOpinionAAction extends BaseAction{
	public final static Logger logger = Logger.getLogger(TacceptanceOpinionAAction.class.getName());
	private static final long serialVersionUID = -5965585684788907405L;

	@Resource
	private TacceptanceOpinionAService tacceptanceOpinionAService;
	
	/** 验收阶段意见 */
	private TacceptanceOpinionA tacceptanceOpinionA;
	/** 验收ID */
	private String acceptanceId;
	/** 验收状态 */
	private String acceptanceStatus;
	/** 跳转路径 */
	private String retUrl;
	/** 跳转页面massage */
	private String retMsg;
	
	/**
	 * @Comments 验收意见画面初期化处理
	 * @return
	 * @Vsersion: 1.0
	 */
	public String accOpinionInit(){
		// 取得登录用户的信息
 		HttpSession session = this.getRequest().getSession();
 		ScUsers user = (ScUsers) session.getAttribute("sysUser");
     	session.setAttribute(Constants.SESSION_CMDKEY, "accOpinionA");
 		
     	// 判断是否失效
     	if (user == null || ("").equals(user.getUserId())) {
     		logger.error("用户不存在！");
 			return "LogOut";
 		}
		// 根据验收ID查询对照合同项目任务完成情况
		List<TacceptanceOpinionA> opinionAList = new ArrayList<TacceptanceOpinionA>();
		opinionAList = tacceptanceOpinionAService.getList("tacceptance.acceptanceId", acceptanceId);
		if(opinionAList != null && opinionAList.size() > 0){
			tacceptanceOpinionA = opinionAList.get(0);
		}
		
		return "accOpinionInit";
	}
	
	/**
	 * @Comments 单位意见画面初期化处理
	 * @return
	 * @Vsersion: 1.0
	 */
	public String deptOpinionInit(){
		// 取得登录用户的信息
 		HttpSession session = this.getRequest().getSession();
 		ScUsers user = (ScUsers) session.getAttribute("sysUser");
     	session.setAttribute(Constants.SESSION_CMDKEY, "deptOpinionA");
 		
     	// 判断是否失效
     	if (user == null || ("").equals(user.getUserId())) {
     		logger.error("用户不存在！");
 			return "LogOut";
 		}
		// 根据验收ID查询对照合同项目任务完成情况
		List<TacceptanceOpinionA> opinionAList = new ArrayList<TacceptanceOpinionA>();
		opinionAList = tacceptanceOpinionAService.getList("tacceptance.acceptanceId", acceptanceId);
		if(opinionAList != null && opinionAList.size() > 0){
			tacceptanceOpinionA = opinionAList.get(0);
		}
		
		return "deptOpinionInit";
	}

	/**
	 * @return the tacceptanceOpinionAService
	 */
	public TacceptanceOpinionAService getTacceptanceOpinionAService() {
		return tacceptanceOpinionAService;
	}

	/**
	 * @param tacceptanceOpinionAService the tacceptanceOpinionAService to set
	 */
	public void setTacceptanceOpinionAService(
			TacceptanceOpinionAService tacceptanceOpinionAService) {
		this.tacceptanceOpinionAService = tacceptanceOpinionAService;
	}

	/**
	 * @return the tacceptanceOpinionA
	 */
	public TacceptanceOpinionA getTacceptanceOpinionA() {
		return tacceptanceOpinionA;
	}

	/**
	 * @param tacceptanceOpinionA the tacceptanceOpinionA to set
	 */
	public void setTacceptanceOpinionA(TacceptanceOpinionA tacceptanceOpinionA) {
		this.tacceptanceOpinionA = tacceptanceOpinionA;
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
