/************************* 版权声明 *********************************
 *
 * Copyright (C) 2012 西安辉盛科技发展有限责任公司.
 *
 ******************************************************************
 */
package com.hopsun.scenter.api.shortcut.action;

import javax.annotation.Resource;

import net.sf.json.JSONArray;

import com.hopsun.framework.base.action.BaseAction;
import com.hopsun.framework.base.bean.Pager;
import com.hopsun.scenter.api.auth.service.AuthService;
import com.hopsun.scenter.api.shortcut.service.ShortcutService;
import com.hopsun.scenter.entity.ScAuth;
import com.hopsun.scenter.entity.ScShortcut;
import com.hopsun.scenter.entity.ScUsers;

/**
 * 
 *@comments 后台快捷方式Action类 - 主要用来做用户权限快捷方式管理
 *@author dulei(dulei@hospun.com)
 *@date Jan 5, 2013
 *@version 1.0
 *
 */
@SuppressWarnings("unchecked")
public class ShortcutAction extends BaseAction {

	private static final long serialVersionUID = -8364865725218653483L;
	
	//权限集合
	private JSONArray authList; 
	//快捷方式
	private ScShortcut scShortcut; 
	//添加或修改
	private boolean isinsert; 
	//快捷方式排序
	private Long shorOrder;
	//权限服务接口类
	@Resource
	private AuthService authService;
	//快捷方式服务接口类
	@Resource
	private ShortcutService shortcutService;
	private String url;
	/**
	 * 跳转到用户快捷方式管理列表页面（当前系统登录管理员的权限快捷方式）
	 * @return
	 * @version 1.0
	 */
	public String list(){
		//page信息
		if(null == pager){
			setPager(new Pager());
		}
		//当前登录用户
		ScUsers user = (ScUsers)getSession().get("sysUser");
		//分页查询快捷方式信息
		pager = shortcutService.find(scShortcut, user, pager.getPageNumber(), pager.getPageSize());
		
		return "list";
	}
	
	/**
	 * 跳转到用户快捷方式添加页面（模块、页面级的）
	 * @return
	 * @version 1.0
	 */
	public String insert(){
		
		//当前登录用户
		ScUsers user = (ScUsers)getSession().get("sysUser");
		//用户拥有的所有权限（模块、页面级的）
		authList = authService.getAuthsByUser(user);
		
		return "insert";
	}
	
	/**
	 * 删除用户快捷方式信息
	 * @return
	 * @version 1.0
	 */
	public String deleteShortcut(){
		
		//删除后返回地址
		//this.redirectUrl = redirectUrl;
		
		if(null == ids){
			//提示信息
			addActionMessage("请选择要删除的数据!");
			return ERROR;
		}else {
			//物理删除
			shortcutService.delete(ids);
			//提示信息
			addActionMessage("删除成功!");
			return SUCCESS;
		}
	}
	
	/**
	 * 添加用户快捷方式信息（根据isinsert值判断，true:添加  false：删除）
	 * @return
	 * @version 1.0
	 */
	public void insertOrDeleteShortcut(){
		//当前系统登录用户
		ScUsers user = (ScUsers)getSession().get("sysUser");
		//判断权限id 登录用户
		if(null != ids && ids.length>0 && null != user){
			//是否为添加
			if(isinsert){
				//添加快捷方式
				if(!shortcutService.getShortcutByUserAuthid(user,ids[0])){
					//创建快捷方式
					ScShortcut scShortcut = new ScShortcut();
					//查询权限信息
					ScAuth auth = authService.load(ids[0]);
					//设置权限信息
					scShortcut.setScAuth(auth);
					//设置用户信息
					scShortcut.setScUsers(user);
					//设置排序默认
					scShortcut.setShorOrder(Long.parseLong("10"));
					//保存快捷方式
					shortcutService.save(scShortcut);
				}
			}else {
				//物理删除
				ScShortcut scShortcut = shortcutService.getShortcutByUserAndAuthid(user, ids[0]);
				if(null != scShortcut){
					shortcutService.delete(scShortcut);
				}
			}
		}
	}
	
	/**
	 * 更新用户快捷方式排序（根据快捷方式ID和快捷方式排序更新）
	 * @return
	 * @version 1.0
	 */
	public void updateShortcut(){
		//异步更新快捷方式排序
		if(null != ids && ids.length>0){
			ScShortcut shortcut = shortcutService.load(ids[0]);
			shortcut.setShorOrder(shorOrder);
			shortcutService.update(shortcut);
		}
		
	}
	
	public JSONArray getAuthList() {
		return authList;
	}

	public ScShortcut getScShortcut() {
		return scShortcut;
	}

	public void setScShortcut(ScShortcut scShortcut) {
		this.scShortcut = scShortcut;
	}

	public void setIsinsert(boolean isinsert) {
		this.isinsert = isinsert;
	}

	public void setShorOrder(Long shorOrder) {
		this.shorOrder = shorOrder;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
	
}
