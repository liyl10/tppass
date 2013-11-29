package com.hopsun.tppas.api.supervisor.action;

import com.hopsun.tppas.api.supervisor.service.TsupervisorInfoAService;
import com.hopsun.framework.base.action.BaseAction;
import javax.annotation.Resource;

public class TsupervisorInfoAAction extends BaseAction{
  
	private static final long serialVersionUID = -1239375638676014538L;
	@Resource
	private TsupervisorInfoAService tsupervisorInfoAService;
	  
	public String list(){
		
		return "list";
	}
	
	/**
	 * 跳转到添加页面
	 * @return String
	 */
	public String insert(){
		
		return "insert";
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
		return "modify";
	}
}
