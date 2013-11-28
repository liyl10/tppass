package com.hopsun.tppas.api.superadmin.action;

import java.util.Date;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.hopsun.framework.base.action.BaseAction;
import com.hopsun.framework.base.bean.Pager;
import com.hopsun.scenter.entity.ScUsers;
import com.hopsun.tppas.api.superadmin.service.TprojectSupervisionTemplateService;
import com.hopsun.tppas.common.Constants;
import com.hopsun.tppas.entity.TprojectSupervisionTemplate;

public class TprojectSupervisionTemplateAction extends BaseAction{
	public final static Logger LOGGER = Logger.getLogger(TprojectSupervisionTemplateAction.class.getName());
	private static final long serialVersionUID = -6690280902410779273L;
	/** 跳转页数 */
	private int pageNo;
	private String modelName;
	private String supervisorTemplateId;
	private TprojectSupervisionTemplate tprojectSupervisionTemplate;
	private String retMsg;
	private String retUrl;
	@Resource
	private TprojectSupervisionTemplateService tprojectSupervisionTemplateService;
	  
	public String list(){
		HttpSession session = this.getRequest().getSession();
		session.setAttribute(Constants.SESSION_CMDKEY, "supervisor_list");
		setPager(new Pager());
		pager = new Pager();
    	if (this.getPageNo() != 0) {
    		pager.setPageNumber(this.getPageNo());
    	}
		pager = tprojectSupervisionTemplateService.find(modelName,pager.getPageNumber(), pager.getPageSize());		

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
				|| !"supervisor_list".equals(cmdkey)) {
			LOGGER.error("令牌不正确");
			return "LogOut";
		}
		if (supervisorTemplateId != null && !Constants.STRING_EMPTY.equals(supervisorTemplateId)) {
			tprojectSupervisionTemplate = tprojectSupervisionTemplateService.get(supervisorTemplateId);
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
				|| !"supervisor_list".equals(cmdkey)) {
			LOGGER.error("令牌不正确");
			return "LogOut";
		}
		tprojectSupervisionTemplate = tprojectSupervisionTemplateService.get(supervisorTemplateId);
		tprojectSupervisionTemplate.setDeleteFlag("1");
		tprojectSupervisionTemplateService.update(tprojectSupervisionTemplate);
		this.setRetMsg(this.getText("opt_del_suc"));
		this.setRetUrl(super.getRequest().getContextPath()
				+ "/api/superadmin/supervisorModel!init.action?dd="
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
				|| !"supervisor_list".equals(cmdkey)) {
			LOGGER.error("令牌不正确");
			return "LogOut";
		}
		//追加代码值配置
		tprojectSupervisionTemplate.setDeleteFlag("0");
		tprojectSupervisionTemplate.setUpdateDate(new java.sql.Timestamp(new Date().getTime()));
		tprojectSupervisionTemplate.setUpdateUser(user.getUserName());
		if ("".equals(supervisorTemplateId) || supervisorTemplateId == null) {
			tprojectSupervisionTemplate.setSupervisionTemplateId(null);
			tprojectSupervisionTemplate.setCreateTime(new java.sql.Timestamp(new Date().getTime()));
			tprojectSupervisionTemplate.setCreateUser(user.getUserName());
			this.setRetMsg(this.getText("opt_save_suc"));
		} else {
			tprojectSupervisionTemplate.setSupervisionTemplateId(supervisorTemplateId);
			this.setRetMsg(this.getText("opt_update_suc"));
		}
		tprojectSupervisionTemplateService.saveOrUpdate(tprojectSupervisionTemplate);

		this.setRetUrl(super.getRequest().getContextPath()
				+ "/api/superadmin/supervisorModel!init.action?dd="
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

	public String getSupervisorTemplateId() {
		return supervisorTemplateId;
	}

	public void setSupervisorTemplateId(String supervisorTemplateId) {
		this.supervisorTemplateId = supervisorTemplateId;
	}

	public TprojectSupervisionTemplate getTprojectSupervisionTemplate() {
		return tprojectSupervisionTemplate;
	}

	public void setTprojectSupervisionTemplate(
			TprojectSupervisionTemplate tprojectSupervisionTemplate) {
		this.tprojectSupervisionTemplate = tprojectSupervisionTemplate;
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

	public TprojectSupervisionTemplateService getTprojectSupervisionTemplateService() {
		return tprojectSupervisionTemplateService;
	}

	public void setTprojectSupervisionTemplateService(
			TprojectSupervisionTemplateService tprojectSupervisionTemplateService) {
		this.tprojectSupervisionTemplateService = tprojectSupervisionTemplateService;
	}
}
