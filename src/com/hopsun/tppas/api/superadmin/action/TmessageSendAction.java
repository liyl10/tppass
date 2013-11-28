package com.hopsun.tppas.api.superadmin.action;

import com.hopsun.tppas.api.superadmin.service.TmessageSendService;
import com.hopsun.framework.base.action.BaseAction;
import javax.annotation.Resource;

public class TmessageSendAction extends BaseAction{
  
	private static final long serialVersionUID = -1878409699736680892L;
	@Resource
	private TmessageSendService tmessageSendService;
	  
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
