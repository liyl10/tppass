package com.hopsun.tppas.api.superadmin.action;

import com.hopsun.tppas.api.superadmin.service.TprojectScoreTemplateService;
import com.hopsun.framework.base.action.BaseAction;
import javax.annotation.Resource;

public class TprojectScoreTemplateAction extends BaseAction{
  
	private static final long serialVersionUID = 7045139161096861950L;
	@Resource
	private TprojectScoreTemplateService tprojectScoreTemplateService;
	  
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
