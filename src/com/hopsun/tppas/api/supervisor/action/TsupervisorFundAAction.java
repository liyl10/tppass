package com.hopsun.tppas.api.supervisor.action;

import com.hopsun.tppas.api.supervisor.service.TsupervisorFundAService;
import com.hopsun.framework.base.action.BaseAction;
import javax.annotation.Resource;

public class TsupervisorFundAAction extends BaseAction{
  
	private static final long serialVersionUID = -2009908349216414675L;
	@Resource
	private TsupervisorFundAService tsupervisorFundAService;
	  
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
