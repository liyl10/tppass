package com.hopsun.tppas.api.superadmin.action;

import java.util.Date;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.hopsun.framework.base.action.BaseAction;
import com.hopsun.framework.base.bean.Pager;
import com.hopsun.scenter.entity.ScUsers;
import com.hopsun.tppas.api.superadmin.service.TprojectContractTemplateService;
import com.hopsun.tppas.common.Constants;
import com.hopsun.tppas.entity.TprojectContractTemplate;

public class TprojectContractTemplateAction extends BaseAction{
	public final static Logger LOGGER = Logger.getLogger(TprojectContractTemplateAction.class.getName());
	private static final long serialVersionUID = -4928306483413188763L;
	@Resource
	private TprojectContractTemplateService tprojectContractTemplateService;
	/** 跳转页数 */
	private int pageNo;
	private String modelName;
	private String contractTemplateId;
	private TprojectContractTemplate tprojectContractTemplate;
	private String retMsg;
	private String retUrl;
	
	
	public String list(){
		HttpSession session = this.getRequest().getSession();
		session.setAttribute(Constants.SESSION_CMDKEY, "contract_list");
		setPager(new Pager());
		pager = new Pager();
    	if (this.getPageNo() != 0) {
    		pager.setPageNumber(this.getPageNo());
    	}
		pager = tprojectContractTemplateService.find(modelName,pager.getPageNumber(), pager.getPageSize());		
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
				|| !"contract_list".equals(cmdkey)) {
			LOGGER.error("令牌不正确");
			return "LogOut";
		}
		if (contractTemplateId != null && !Constants.STRING_EMPTY.equals(contractTemplateId)) {
			tprojectContractTemplate = tprojectContractTemplateService.get(contractTemplateId);
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
				|| !"contract_list".equals(cmdkey)) {
			LOGGER.error("令牌不正确");
			return "LogOut";
		}
		tprojectContractTemplate = tprojectContractTemplateService.get(contractTemplateId);
		tprojectContractTemplate.setDeleteFlag("1");
		tprojectContractTemplateService.update(tprojectContractTemplate);
		this.setRetMsg(this.getText("opt_del_suc"));
		this.setRetUrl(super.getRequest().getContextPath()
				+ "/api/superadmin/contractModel!init.action?dd="
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
				|| !"contract_list".equals(cmdkey)) {
			LOGGER.error("令牌不正确");
			return "LogOut";
		}
		//追加代码值配置
		tprojectContractTemplate.setDeleteFlag("0");
		tprojectContractTemplate.setUpdateDate(new java.sql.Timestamp(new Date().getTime()));
		tprojectContractTemplate.setUpdateUser(user.getUserName());
		if ("".equals(contractTemplateId) || contractTemplateId == null) {
			tprojectContractTemplate.setContractTemplateId(null);
			tprojectContractTemplate.setCreateTime(new java.sql.Timestamp(new Date().getTime()));
			tprojectContractTemplate.setCreateUser(user.getUserName());
			this.setRetMsg(this.getText("opt_save_suc"));
		} else {
			tprojectContractTemplate.setContractTemplateId(contractTemplateId);
			this.setRetMsg(this.getText("opt_update_suc"));
		}
		tprojectContractTemplateService.saveOrUpdate(tprojectContractTemplate);

		this.setRetUrl(super.getRequest().getContextPath()
				+ "/api/superadmin/contractModel!init.action?dd="
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
	
	public TprojectContractTemplateService getTprojectContractTemplateService() {
		return tprojectContractTemplateService;
	}

	public void setTprojectContractTemplateService(
			TprojectContractTemplateService tprojectContractTemplateService) {
		this.tprojectContractTemplateService = tprojectContractTemplateService;
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

	public String getContractTemplateId() {
		return contractTemplateId;
	}

	public void setContractTemplateId(String contractTemplateId) {
		this.contractTemplateId = contractTemplateId;
	}

	public TprojectContractTemplate getTprojectContractTemplate() {
		return tprojectContractTemplate;
	}

	public void setTprojectContractTemplate(
			TprojectContractTemplate tprojectContractTemplate) {
		this.tprojectContractTemplate = tprojectContractTemplate;
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
