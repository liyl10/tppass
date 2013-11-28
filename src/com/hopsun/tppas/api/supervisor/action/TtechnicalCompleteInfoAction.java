package com.hopsun.tppas.api.supervisor.action;

import javax.annotation.Resource;

import com.hopsun.framework.base.action.BaseAction;
import com.hopsun.tppas.api.supervisor.service.TtechnicalCompleteInfoService;

public class TtechnicalCompleteInfoAction extends BaseAction{
  
	private static final long serialVersionUID = -8963299983618553650L;
	@Resource
	private TtechnicalCompleteInfoService ttechnicalCompleteInfoService;
	  
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
