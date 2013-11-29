package com.hopsun.tppas.api.superadmin.action;

import java.util.List;
import javax.annotation.Resource;
import com.hopsun.framework.base.action.BaseAction;
import com.hopsun.scenter.entity.ScUsers;
import com.hopsun.tppas.api.superadmin.service.TmessageReceiveService;
import com.hopsun.tppas.entity.TmessageReceive;

public class TmessageReceiveAction extends BaseAction{
  
	private static final long serialVersionUID = 3305137415242200460L;
	@Resource
	private TmessageReceiveService tmessageReceiveService;
	  
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

	private  String  jsonResult;
	
	/**
	 * 跳转到修改页面
	 * @return String
	 */
	public String modify(){
		return "modify";
	}
	/**
	 * ajax操作提示消息
	 */
	public String ajaxMessageNotice(){
		ScUsers user = (ScUsers)getSession().get("sysUser");
		if(user.getScDept()!=null){
			List<TmessageReceive> listResult=tmessageReceiveService.queryTMessageReceiverByReceiverId(user.getScDept().getDeptId());
			
			if(listResult!=null&&listResult.size()>0){
				String arrayResult1="";
				for(int i=0;i<listResult.size();i++){
					TmessageReceive  messageReceiver=listResult.get(i);
					arrayResult1+=messageReceiver.getTmessageSend().getSendTitle()+"}";
				}
				jsonResult=arrayResult1.substring(0,arrayResult1.length()-1);
			}
			else{
				jsonResult="";;
			}
		}
		this.ajaxJson(jsonResult);
	
		return null;
	}

	

	
	
}
