package com.hopsun.tppas.api.superadmin.action;

import java.util.Date;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.hopsun.framework.base.action.BaseAction;
import com.hopsun.framework.base.bean.Pager;
import com.hopsun.scenter.entity.ScUsers;
import com.hopsun.tppas.api.superadmin.service.TprojectReportTemplateService;
import com.hopsun.tppas.common.Constants;
import com.hopsun.tppas.entity.TprojectReportTemplate;

public class TprojectReportTemplateAction extends BaseAction{
	public final static Logger LOGGER = Logger.getLogger(TprojectReportTemplateAction.class.getName());
	private static final long serialVersionUID = -6807722572320509114L;
	@Resource
	private TprojectReportTemplateService tprojectReportTemplateService;
	
	/** 跳转页数 */
	private int pageNo;
	private String modelName;
	private String reportTemplateId;
	private TprojectReportTemplate tprojectReportTemplate;
	private String retMsg;
	private String retUrl;

	/**
	 * @Comments 列表初始化
	 * @return
	 * @Vsersion: 1.0
	 */
	public String list(){
		HttpSession session = this.getRequest().getSession();
		session.setAttribute(Constants.SESSION_CMDKEY, "report_list");
		setPager(new Pager());
		pager = new Pager();
    	if (this.getPageNo() != 0) {
    		pager.setPageNumber(this.getPageNo());
    	}
		pager = tprojectReportTemplateService.find(modelName,pager.getPageNumber(), pager.getPageSize());		
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
				|| !"report_list".equals(cmdkey)) {
			LOGGER.error("令牌不正确");
			return "LogOut";
		}
		if (reportTemplateId != null && !Constants.STRING_EMPTY.equals(reportTemplateId)) {
			tprojectReportTemplate = tprojectReportTemplateService.get(reportTemplateId);
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
				|| !"report_list".equals(cmdkey)) {
			LOGGER.error("令牌不正确");
			return "LogOut";
		}
		tprojectReportTemplate = tprojectReportTemplateService.get(reportTemplateId);
		tprojectReportTemplate.setDeleteFlag("1");
		tprojectReportTemplateService.update(tprojectReportTemplate);
		this.setRetMsg(this.getText("opt_del_suc"));
		this.setRetUrl(super.getRequest().getContextPath()
				+ "/api/superadmin/reportModel!init.action?dd="
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
				|| !"report_list".equals(cmdkey)) {
			LOGGER.error("令牌不正确");
			return "LogOut";
		}
		//追加代码值配置
		tprojectReportTemplate.setDeleteFlag("0");
		tprojectReportTemplate.setUpdateDate(new java.sql.Timestamp(new Date().getTime()));
		tprojectReportTemplate.setUpdateUser(user.getUserName());
		if ("".equals(reportTemplateId) || reportTemplateId == null) {
			tprojectReportTemplate.setReportTemplateId(null);
			tprojectReportTemplate.setCreateTime(new java.sql.Timestamp(new Date().getTime()));
			tprojectReportTemplate.setCreateUser(user.getUserName());
			this.setRetMsg(this.getText("opt_save_suc"));
		} else {
			tprojectReportTemplate.setReportTemplateId(reportTemplateId);
			this.setRetMsg(this.getText("opt_update_suc"));
		}
		tprojectReportTemplateService.saveOrUpdate(tprojectReportTemplate);

		this.setRetUrl(super.getRequest().getContextPath()
				+ "/api/superadmin/reportModel!init.action?dd="
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

	public TprojectReportTemplateService getTprojectReportTemplateService() {
		return tprojectReportTemplateService;
	}

	public void setTprojectReportTemplateService(
			TprojectReportTemplateService tprojectReportTemplateService) {
		this.tprojectReportTemplateService = tprojectReportTemplateService;
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

	public TprojectReportTemplate getTprojectReportTemplate() {
		return tprojectReportTemplate;
	}

	public void setTprojectReportTemplate(
			TprojectReportTemplate tprojectReportTemplate) {
		this.tprojectReportTemplate = tprojectReportTemplate;
	}

	public String getReportTemplateId() {
		return reportTemplateId;
	}

	public void setReportTemplateId(String reportTemplateId) {
		this.reportTemplateId = reportTemplateId;
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
