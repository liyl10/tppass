package com.hopsun.tppas.api.acceptance.action;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.hopsun.framework.base.action.BaseAction;
import com.hopsun.scenter.entity.ScUsers;
import com.hopsun.tppas.api.acceptance.service.TacceptanceCompleteAService;
import com.hopsun.tppas.common.Constants;
import com.hopsun.tppas.entity.TacceptanceCompleteA;

public class TacceptanceCompleteAAction extends BaseAction{
	public final static Logger logger = Logger.getLogger(TacceptanceCompleteAAction.class.getName());
	private static final long serialVersionUID = 6996667995832968029L;

	@Resource
	private TacceptanceCompleteAService tacceptanceCompleteAService;
	
	/** 对照合同项目任务完成情况 */
	private TacceptanceCompleteA tacceptanceCompleteA;
	/** 验收ID */
	private String acceptanceId;
	/** 验收状态 */
	private String acceptanceStatus;
	/** 跳转路径 */ 
	private String retUrl;
	/** 跳转页面massage */
	private String retMsg;
	
	/**
	 * @Comments 对照合同项目任务完成情况画面初期化处理
	 * @return
	 * @Vsersion: 1.0
	 */
	public String completeInit(){
        // 取得登录用户的信息
 		HttpSession session = this.getRequest().getSession();
 		ScUsers user = (ScUsers) session.getAttribute("sysUser");
     	session.setAttribute(Constants.SESSION_CMDKEY, "tacceptanceCompleteA");
 		
     	// 判断是否失效
     	if (user == null || ("").equals(user.getUserId())) {
     		logger.error("用户不存在！");
 			return "LogOut";
 		}
		// 根据验收ID查询对照合同项目任务完成情况
		List<TacceptanceCompleteA> completeAList = new ArrayList<TacceptanceCompleteA>();
		completeAList = tacceptanceCompleteAService.getList("tacceptance.acceptanceId", acceptanceId);
		if(completeAList != null && completeAList.size() > 0){
			tacceptanceCompleteA = completeAList.get(0);
		}
		
		return "completeInit";
	}

	/**
	 * @return the tacceptanceCompleteAService
	 */
	public TacceptanceCompleteAService getTacceptanceCompleteAService() {
		return tacceptanceCompleteAService;
	}

	/**
	 * @param tacceptanceCompleteAService the tacceptanceCompleteAService to set
	 */
	public void setTacceptanceCompleteAService(
			TacceptanceCompleteAService tacceptanceCompleteAService) {
		this.tacceptanceCompleteAService = tacceptanceCompleteAService;
	}

	/**
	 * @return the tacceptanceCompleteA
	 */
	public TacceptanceCompleteA getTacceptanceCompleteA() {
		return tacceptanceCompleteA;
	}

	/**
	 * @param tacceptanceCompleteA the tacceptanceCompleteA to set
	 */
	public void setTacceptanceCompleteA(TacceptanceCompleteA tacceptanceCompleteA) {
		this.tacceptanceCompleteA = tacceptanceCompleteA;
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
