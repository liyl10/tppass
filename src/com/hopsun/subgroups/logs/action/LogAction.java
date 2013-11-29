/**
 * @filename LogAction.java
 * @author zzze
 * @date Jan 5, 2013
 * @vsersion 1.0
 * Copyright (C) 2013 辉盛科技发展责任有限公司
 */
package com.hopsun.subgroups.logs.action;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;

import com.hopsun.framework.base.action.BaseAction;
import com.hopsun.framework.base.bean.Pager;
import com.hopsun.framework.util.StrutsUtil;
import com.hopsun.framework.util.Util;
import com.hopsun.subgroups.entity.UcLogs;
import com.hopsun.subgroups.logs.service.LogService;
import com.hopsun.subgroups.paramconfig.bean.ParamConfigBean;
import com.hopsun.subgroups.paramconfig.bean.ParamConfigDefaultBean;
/**
 *@comment 日志管理类 
 *@author zzze
 *@date Jan 5, 2013
 *@version 1.0
 */
@Scope("prototype")
public class LogAction extends BaseAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Resource
	public transient LogService logService;
	public UcLogs ucLogs;
	public List<ParamConfigDefaultBean> logObj = ((ParamConfigBean)StrutsUtil.getApplication().getAttribute("LOG_SWITCH_AND_CH_DESC")).getChildList();
	public List<ParamConfigDefaultBean> operaResult = ((ParamConfigBean)StrutsUtil.getApplication().getAttribute("OPERA_RESULT")).getChildList();
	public List<ParamConfigDefaultBean> logOpera = ((ParamConfigBean)StrutsUtil.getApplication().getAttribute("OPERATION_TYPE")).getChildList();
	public List<ParamConfigDefaultBean> logSource = ((ParamConfigBean)StrutsUtil.getApplication().getAttribute("SOURCE")).getChildList();
	/**
	 * @comment 获取配置清单 
	 * @return
	 * @version: 1.0
	 */
	@SuppressWarnings("unchecked")
	public String list(){
		if(Util.checkNull(pager)){
			pager = new Pager();
		}
		pager = logService.list(pager, ucLogs);
		this.setRedirectUrl(this.getRequest().getRequestURL().toString());
		return "list";
	}
	/**
	 * @comment 跳转到查看页 
	 * @return
	 * @version: 1.0
	 */
	public String goDetail(){
		ucLogs = logService.get(ucLogs.getLogId());
		return "goDetail";
	}
	public UcLogs getUcLogs() {
		return ucLogs;
	}
	public void setUcLogs(final UcLogs ucLogs) {
		this.ucLogs = ucLogs;
	}
	
}
