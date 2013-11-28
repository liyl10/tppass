package com.hopsun.tppas.api.superadmin.action;

import java.util.Date;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.hopsun.framework.base.action.BaseAction;
import com.hopsun.framework.base.bean.Pager;
import com.hopsun.scenter.entity.ScUsers;
import com.hopsun.tppas.api.superadmin.service.TprojectAcceptanceTemplateService;
import com.hopsun.tppas.common.Constants;
import com.hopsun.tppas.entity.TprojectAcceptanceTemplate;

public class TprojectAcceptanceTemplateAction extends BaseAction{
	public final static Logger LOGGER = Logger.getLogger(TprojectAcceptanceTemplateAction.class.getName());
	private static final long serialVersionUID = 7067956339606306416L;
	@Resource
	private TprojectAcceptanceTemplateService tprojectAcceptanceTemplateService;
	/** 跳转页数 */
	private int pageNo;
	private String modelName;
	private String acceptanceTemplateId;
	private TprojectAcceptanceTemplate tprojectcceptanceTemplate;
	private String retMsg;
	private String retUrl;
	
	public String list(){
		HttpSession session = this.getRequest().getSession();
		session.setAttribute(Constants.SESSION_CMDKEY, "acceptance_list");
		setPager(new Pager());
		pager = new Pager();
    	if (this.getPageNo() != 0) {
    		pager.setPageNumber(this.getPageNo());
    	}
		pager = tprojectAcceptanceTemplateService.find(modelName,pager.getPageNumber(), pager.getPageSize());		
		return "list";
	}
	
	/**
	 * 跳转到添加页面
	 * @return String
	 */
	public String insert(){
		
		HttpSession session = this.getRequest().getSession();
		String cmdkey = (String) session.getAttribute(Constants.SESSION_CMDKEY);
		//判断令牌
		if (cmdkey == null
				|| !"acceptance_list".equals(cmdkey)) {
			LOGGER.error("令牌不正确");
			return "LogOut";
		}
		if (acceptanceTemplateId != null && !Constants.STRING_EMPTY.equals(acceptanceTemplateId)) {
			tprojectcceptanceTemplate = tprojectAcceptanceTemplateService.get(acceptanceTemplateId);
		}
		return "insert";
	}
	
	/**
	 * @Comments 删除该模板
	 * @return
	 * @Vsersion: 1.0
	 */
	public String delete(){
		HttpSession session = this.getRequest().getSession();
		String cmdkey = (String) session.getAttribute(Constants.SESSION_CMDKEY);
		//判断令牌
		if (cmdkey == null
				|| !"acceptance_list".equals(cmdkey)) {
			LOGGER.error("令牌不正确");
			return "LogOut";
		}
		tprojectcceptanceTemplate = tprojectAcceptanceTemplateService.get(acceptanceTemplateId);
		tprojectcceptanceTemplate.setDeleteFlag("1");
		tprojectAcceptanceTemplateService.update(tprojectcceptanceTemplate);
		this.setRetMsg(this.getText("opt_del_suc"));
		this.setRetUrl(super.getRequest().getContextPath()
				+ "/api/superadmin/acceptanceModel!init.action?dd="
				+ new Date().getTime());
		return "systemInfoMain";		
	}
	
	/**
	 * 修改信息
	 * @return String
	 */
	public String updateDept(){
		
		return SUCCESS;
			
	}
	
	/**
	 * 跳转到修改页面
	 * @return String
	 */
	public String modify(){
		HttpSession session = this.getRequest().getSession();
		String cmdkey = (String) session.getAttribute(Constants.SESSION_CMDKEY);
		ScUsers user = (ScUsers) session.getAttribute("sysUser");
		//判断令牌
		if (cmdkey == null
				|| !"acceptance_list".equals(cmdkey)) {
			LOGGER.error("令牌不正确");
			return "LogOut";
		}
		//追加代码值配置
		tprojectcceptanceTemplate.setDeleteFlag("0");
		tprojectcceptanceTemplate.setUpdateDate(new java.sql.Timestamp(new Date().getTime()));
		tprojectcceptanceTemplate.setUpdateUser(user.getUserName());
		if ("".equals(acceptanceTemplateId) || acceptanceTemplateId == null) {
			tprojectcceptanceTemplate.setAcceptanceTemplateId(null);
			tprojectcceptanceTemplate.setCreateTime(new java.sql.Timestamp(new Date().getTime()));
			tprojectcceptanceTemplate.setCreateUser(user.getUserName());
			this.setRetMsg(this.getText("opt_save_suc"));
		} else {
			tprojectcceptanceTemplate.setAcceptanceTemplateId(acceptanceTemplateId);
			this.setRetMsg(this.getText("opt_update_suc"));
		}
		tprojectAcceptanceTemplateService.saveOrUpdate(tprojectcceptanceTemplate);

		this.setRetUrl(super.getRequest().getContextPath()
				+ "/api/superadmin/acceptanceModel!init.action?dd="
				+ new Date().getTime());
		return "systemInfoMain";	
	}
	
	/**
	 * @Comments 页面初始化
	 * @return
	 * @Vsersion: 1.0
	 */
	public String init(){
		return "init";
	}

	public TprojectAcceptanceTemplateService getTprojectAcceptanceTemplateService() {
		return tprojectAcceptanceTemplateService;
	}

	public void setTprojectAcceptanceTemplateService(
			TprojectAcceptanceTemplateService tprojectAcceptanceTemplateService) {
		this.tprojectAcceptanceTemplateService = tprojectAcceptanceTemplateService;
	}

	public int getPageNo() {
		return pageNo;
	}

	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}

	public String getModelName() {
		return modelName;
	}

	public void setModelName(String modelName) {
		this.modelName = modelName;
	}

	public String getAcceptanceTemplateId() {
		return acceptanceTemplateId;
	}

	public void setAcceptanceTemplateId(String acceptanceTemplateId) {
		this.acceptanceTemplateId = acceptanceTemplateId;
	}

	public TprojectAcceptanceTemplate getTprojectcceptanceTemplate() {
		return tprojectcceptanceTemplate;
	}

	public void setTprojectcceptanceTemplate(
			TprojectAcceptanceTemplate tprojectcceptanceTemplate) {
		this.tprojectcceptanceTemplate = tprojectcceptanceTemplate;
	}

	public String getRetMsg() {
		return retMsg;
	}

	public void setRetMsg(String retMsg) {
		this.retMsg = retMsg;
	}

	public String getRetUrl() {
		return retUrl;
	}

	public void setRetUrl(String retUrl) {
		this.retUrl = retUrl;
	}
}
