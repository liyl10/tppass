/*************** 版权声明***************
*
* Copyright (C) 2012 西安辉盛科技发展有限责任公司.
*
********************************************
*/
package com.hopsun.tppas.api.superadmin.action;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import org.apache.log4j.Logger;
import com.hopsun.framework.base.action.BaseAction;
import com.hopsun.scenter.api.user.service.UserService;
import com.hopsun.scenter.entity.ScUsers;
import com.hopsun.tppas.api.superadmin.service.TprojectTypeManagerService;
import com.hopsun.tppas.api.superadmin.service.TprojectTypeService;
import com.hopsun.tppas.entity.TprojectType;
import com.hopsun.tppas.entity.TprojectTypeManager;

/**
 * @comments 计划类别管理专员
 * @author wangxiaodong
 * @date 2013-10-23
 * @version 1.0
 */
public class TprojectTypeManagerAction extends BaseAction{
	
	private static final long serialVersionUID = -665652262693283637L;

	public final static Logger LOGGER = Logger.getLogger(TprojectTypeManagerAction.class.getName());
	
	/**计划类别管理专员service*/
	@Resource
	private TprojectTypeManagerService tprojectTypeManagerService;
	
	/**计划类别service*/
	@Resource
	private TprojectTypeService tprojectTypeService;
	
	/**用户service*/
	@Resource
	private UserService userService;
	
	/**用户集合*/
	private List<ScUsers> userList;
	
	/**计划类别**/
	private TprojectType tprojectType;
	
	/**计划类别专管员信息**/
	private TprojectTypeManager tprojectTypeManager;
	
	/**计划类别ID*/
	private String typeId;
	
	/**消息提示*/
	private String retMsg;
	
	/**跳转路径*/
	private String retUrl;
	
	/**
	 * 计划类别分配管理专员初始
	 * @comments 
	 * @return
	 * @version 1.0
	 */
	public String getManagerInfo(){
		HttpSession session = this.getRequest().getSession();
		ScUsers user = (ScUsers) session.getAttribute("sysUser");
		//判断登录用户
		if (user == null|| user.getUserId().equals("")) {
			
			return "LogOut";
		}
		
		//计划类别
		tprojectType = tprojectTypeService.get(typeId);
		
		Map<String,Object> valueMap = new HashMap<String,Object>();
		valueMap.put("deptId", tprojectType.getDepartmentId());
		valueMap.put("typeId", typeId);
		
		//计划类别专管员信息
		tprojectTypeManager = tprojectTypeManagerService.getTprojectTypeManager(valueMap);
		
		//用户集合
		userList = userService.getUserList(valueMap);
		
		return "typeAssign";	

	}
	
	/**
	 * 计划类别分配管理专员初始
	 * @comments 
	 * @return
	 * @version 1.0
	 */
	public String saveManagerInfo(){
		HttpSession session = this.getRequest().getSession();
		ScUsers user = (ScUsers) session.getAttribute("sysUser");
		//判断登录用户
		if (user == null|| user.getUserId().equals("")) {
			
			return "LogOut";
		}
    	
    	//判断提示信息是保存还是修改
    	if(tprojectTypeManager.getTypeManagerId()!=null&&tprojectTypeManager.getTypeManagerId().length()>0){
    		this.setRetMsg(this.getText("opt_update_suc"));
    	}else{
    		this.setRetMsg(this.getText("opt_save_suc"));
    	}
    	
    	//保存计划类别管理专员
    	tprojectTypeManagerService.saveTprojectTypeManager(user, tprojectTypeManager);
    	
    	
    	this.setRetUrl(super.getRequest().getContextPath()+ "/api/superadmin/typeModel!init.action?now="+ new Date().getTime());
    	
		return "systemInfoMain";	

	}
	

	public List<ScUsers> getUserList() {
		return userList;
	}

	public void setUserList(List<ScUsers> userList) {
		this.userList = userList;
	}

	public TprojectType getTprojectType() {
		return tprojectType;
	}

	public void setTprojectType(TprojectType tprojectType) {
		this.tprojectType = tprojectType;
	}

	public String getTypeId() {
		return typeId;
	}

	public void setTypeId(String typeId) {
		this.typeId = typeId;
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


	public TprojectTypeManager getTprojectTypeManager() {
		return tprojectTypeManager;
	}


	public void setTprojectTypeManager(TprojectTypeManager tprojectTypeManager) {
		this.tprojectTypeManager = tprojectTypeManager;
	}
}
