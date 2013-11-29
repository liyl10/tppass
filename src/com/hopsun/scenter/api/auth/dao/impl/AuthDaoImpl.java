/************************* 版权声明 *********************************
 *
 * Copyright (C) 2012 西安辉盛科技发展有限责任公司.
 *
 ******************************************************************
 */
package com.hopsun.scenter.api.auth.dao.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.springframework.stereotype.Repository;

import com.hopsun.framework.base.bean.Finder;
import com.hopsun.framework.base.dao.impl.BaseDaoImpl;
import com.hopsun.framework.util.StrutsUtil;
import com.hopsun.scenter.api.auth.dao.AuthDao;
import com.hopsun.scenter.api.shortcut.dao.ShortcutDao;
import com.hopsun.scenter.api.shortcut.service.ShortcutService;
import com.hopsun.scenter.api.util.Constant;
import com.hopsun.scenter.entity.ScAuth;
import com.hopsun.scenter.entity.ScUsers;
import com.hopsun.subgroups.paramconfig.bean.ParamConfigBean;
import com.hopsun.subgroups.paramconfig.service.ConfigService;
import com.hopsun.subgroups.paramconfig.util.ParamConfigUtil;

/**
 * @comments  权限管理dao实现类
 * @author yinxy
 * @date Dec 26, 2012
 * @version 1.0
 */

@Repository("authDao")
@SuppressWarnings("unchecked")
public class AuthDaoImpl extends BaseDaoImpl<ScAuth, String> implements AuthDao {
	
	@Resource
	public ConfigService configService;
	private Map<String, ParamConfigBean> configMap ;
	
	/**
	 * 根据权限上级id查询列表
	 * @param id
	 * @return
	 */
	 
	public List queryAuthListByParent(String id ) {
		String hql=null;
		if(id==null || "".equals(id)){
			 hql = "select auth from ScAuth auth where auth.scAuth.authId is null and auth.deleteState=? order by auth.authOrder desc";
			 return this.createQueryList(hql, Constant.DELETE_STATE_FALSE);
		}else{
			 hql = "select auth from ScAuth auth where auth.scAuth.authId =? and auth.deleteState=? order by auth.authOrder desc";
			 return this.createQueryList(hql, id, Constant.DELETE_STATE_FALSE);
		}
	}
	/**
	 * 根据条件查询权限列表
	 * @param condition
	 * @return
	 */
	public List queryAuthList(Map condition) {
		Finder finder = Finder.create("from ScAuth sc_auth where sc_auth.deleteState=:dele");
		finder.setParam("dele",  ((ParamConfigBean) StrutsUtil.getApplication().getAttribute("DEL_STATE")).getBeansByCode("enable").getValue());
		if (condition != null && condition.size() > 0) {
			if (condition.get("enableState") != null) {
				finder.append(" and sc_auth.enableState=:enableState");
				finder.setParam("enableState", condition.get("enableState").toString());
			}
			if (condition.get("authCode") != null) {
				finder.append(" and sc_auth.authCode=:authCode");
				finder.setParam("authCode", condition.get("authCode").toString());
			}
			 
		}
		finder.append(" order by sc_auth.authOrder desc");
		return super.find(finder);
	}
	/**
	 * 查询根权限
	 * @return
	 */
	public List queryAuthRoot() {
		String hql=null;
		hql = "select auth from ScAuth auth where auth.scAuth.authId is null and auth.deleteState=?";
		return this.createQueryList(hql, Constant.DELETE_STATE_FALSE);
		 
	}
	/**
	 * 查询所有权限
	 * @return
	 */
	public List queryAllAuth() {
		String hql=null;
		hql = "select auth from ScAuth auth where  auth.deleteState=?  order by auth.authOrder desc";
		return this.createQueryList(hql, Constant.DELETE_STATE_FALSE);
	}
	
	/**
	 * 
	 * @comments 获取跟权限Id
	 * @return String rootAuthId
	 * @version 1.0
	 */
	private String getRootAuthId(){
		
		//启用
		String enableState = ((ParamConfigBean)StrutsUtil.getApplication().getAttribute("CONFIG_STATE")).getValueByCode("enable");
		//未删除
		String deleteState = ((ParamConfigBean)StrutsUtil.getApplication().getAttribute("DEL_STATE")).getValueByCode("enable");
		//审核通过
		String verifyState = ((ParamConfigBean)StrutsUtil.getApplication().getAttribute("VERIFY_STATE")).getValueByCode("verifypass");
		//跟权限无上级Id
		String hql = "select a from ScAuth a where a.scAuth is null ";
		hql += " and a.deleteState=? and a.enableState=? and a.verifyState=? order by a.authOrder desc a.createDate desc";
		
		List<ScAuth> list = this.createQueryList(hql, deleteState, enableState, verifyState);
		
		return list.size()>0?list.get(0).getAuthId():"";
	}

	
	/**
	 * 根据用户ID获取管理一级权限
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<ScAuth> getAuthByUser(ScUsers user){
		
		//启用
		String enableState = ((ParamConfigBean)StrutsUtil.getApplication().getAttribute("CONFIG_STATE")).getValueByCode("enable");
		//未删除
		String deleteState = ((ParamConfigBean)StrutsUtil.getApplication().getAttribute("DEL_STATE")).getValueByCode("enable");
		//审核通过
		String verifyState = ((ParamConfigBean)StrutsUtil.getApplication().getAttribute("VERIFY_STATE")).getValueByCode("verifypass");
		
		String hql = "";
		
		if(null != user.getScUsersesForParentUserId() && user.getScUsersesForParentUserId().size()>0){ //非超级管理员
			hql += "select a from ScRole as r left join r.scAuths as a left join r.scUserses as u where a.scAuth.authId=? and u.userId=? ";
		}else { //超级管理员
			hql += "select a from ScAuth a where a.scAuth.authId=? ";
		}
		
		hql = "select a from ScAuth a where a.authId in ("+ hql +") ";
		hql += " and a.deleteState=? and a.enableState=? and a.verifyState=? order by a.authOrder desc a.createDate desc";
		
		//跟权限ID
		String rootAuthId = this.getRootAuthId();
		
		List<ScAuth> list = new ArrayList<ScAuth>();
		if(null != user.getScUsersesForParentUserId() && user.getScUsersesForParentUserId().size()>0){ //非超级管理员
			list = this.createQueryList(hql, rootAuthId, user.getUserId(), deleteState, enableState, verifyState);
		}else { //超级管理员
			list = this.createQueryList(hql, rootAuthId, deleteState, enableState, verifyState);
		}
		
		return list;
	}
	
	/**
	 * 根据用户，权限信息查询权限子节点信息，模块
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<ScAuth> getAuths(ScUsers user, String authid) {
		
		List<ScAuth> list = new ArrayList<ScAuth>();
		
		//启用
		String enableState = ((ParamConfigBean)StrutsUtil.getApplication().getAttribute("CONFIG_STATE")).getValueByCode("enable");
		//未删除
		String deleteState = ((ParamConfigBean)StrutsUtil.getApplication().getAttribute("DEL_STATE")).getValueByCode("enable");
		//审核通过
		String verifyState = ((ParamConfigBean)StrutsUtil.getApplication().getAttribute("VERIFY_STATE")).getValueByCode("verifypass");
		//权限类型（模块，页面）
		String authType_module = ((ParamConfigBean)StrutsUtil.getApplication().getAttribute("AUTH_TYPE")).getValueByCode("module");
		String authType_page = ((ParamConfigBean)StrutsUtil.getApplication().getAttribute("AUTH_TYPE")).getValueByCode("page");
		
		//跟权限
		if(null!=authid && !("").equals(authid)){
			String hql = "";
			if(null != user.getScUsersesForParentUserId() && user.getScUsersesForParentUserId().size()>0){
				hql += "select a from ScRole as r left join r.scAuths as a left join r.scUserses as u where a.scAuth.authId=? and u.userId=? ";
			}else {
				hql += "select a from ScAuth a where a.scAuth.authId=? ";
			}
			
			hql = "select a from ScAuth a where a.authId in ("+ hql +") ";
			hql += " and a.enableState=? and a.deleteState=? and a.verifyState=? and a.authType in (?,?) order by a.authOrder desc a.createDate desc";
			
			if(null != user.getScUsersesForParentUserId() && user.getScUsersesForParentUserId().size()>0){
				list = this.createQueryList(hql, authid, user.getUserId(), enableState, deleteState, verifyState, authType_module, authType_page);
			}else {
				list = this.createQueryList(hql, authid, enableState,deleteState, verifyState, authType_module, authType_page);
			}
			
		//快捷方式
		}else {
			//普通用户
			if(null != user.getScUsersesForParentUserId() && user.getScUsersesForParentUserId().size()>0){
				//查询出用户的所有权限
				String hql = "select a from ScUsers as u left join u.scRoles as r left join r.scAuths as a " +
				"where u.userId=? and r.deleteState=? and r.enableState=? and r.verifyState=? " +
				"and a.deleteState=? and a.enableState=? and a.verifyState=?";
				
				//查询所有有效的快捷方式
				hql = "select a from ScAuth as a left join a.scShortcuts as s where s.scUsers.userId=? and a.authId in ("+hql+") order by s.shorOrder desc";
				list = this.createQueryList(hql, user.getUserId(), user.getUserId(), deleteState, enableState, verifyState, deleteState, enableState, verifyState);
			//超级管理员
			}else{
				//查询出用户的所有快捷方式
				String hql = "select a from ScAuth as a left join a.scShortcuts as s where s.scUsers.userId=? and a.deleteState=? and a.enableState=? and a.verifyState=? order by s.shorOrder desc";;
				list = this.createQueryList(hql, user.getUserId(), deleteState, enableState, verifyState);
			}
			
		}
		
		return list;
	}
	@Resource
	public ShortcutService shortcutService;
	
	/**
	 * 根据用户查询用户的所有权限（模块/页面）
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<ScAuth> getAuthListByUser(ScUsers user) {
		
		List<ScAuth> list = new ArrayList<ScAuth>();
		
		//启用
		String enableState = ((ParamConfigBean)StrutsUtil.getApplication().getAttribute("CONFIG_STATE")).getValueByCode("enable");
		//未删除
		String deleteState = ((ParamConfigBean)StrutsUtil.getApplication().getAttribute("DEL_STATE")).getValueByCode("enable");
		//审核通过
		String verifyState = ((ParamConfigBean)StrutsUtil.getApplication().getAttribute("VERIFY_STATE")).getValueByCode("verifypass");
		//权限类型（模块，页面）
		String authType_module = ((ParamConfigBean)StrutsUtil.getApplication().getAttribute("AUTH_TYPE")).getValueByCode("module");
		String authType_page = ((ParamConfigBean)StrutsUtil.getApplication().getAttribute("AUTH_TYPE")).getValueByCode("page");
		
		//跟权限
		String hql = "";
		if(null != user.getScUsersesForParentUserId() && user.getScUsersesForParentUserId().size()>0){
			hql += "select a from ScRole as r left join r.scAuths as a left join r.scUserses as u where u.userId=? ";
		}else {
			hql += "select a from ScAuth a where 1=1 ";
		}
		
		hql = "select a from ScAuth a where a.authId in ("+ hql +") ";
		hql += " and a.enableState=? and a.deleteState=? and a.verifyState=? and a.authType in (?,?) order by a.authOrder desc a.createDate desc";
		
		if(null != user.getScUsersesForParentUserId() && user.getScUsersesForParentUserId().size()>0){
			list = this.createQueryList(hql,  user.getUserId(), enableState, deleteState, verifyState, authType_module, authType_page);
		}else {
			list = this.createQueryList(hql, enableState,deleteState, verifyState, authType_module, authType_page);
		}
		
		return list;
	}
	
	/**
	 * 根据用户查询用户的所有权限（模块/页面）
	 * @param user
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public JSONArray getAuthsByUser(ScUsers user) {
		
		List<ScAuth> list = new ArrayList<ScAuth>();
		
		//启用
		String enableState = ((ParamConfigBean)StrutsUtil.getApplication().getAttribute("CONFIG_STATE")).getValueByCode("enable");
		//未删除
		String deleteState = ((ParamConfigBean)StrutsUtil.getApplication().getAttribute("DEL_STATE")).getValueByCode("enable");
		//审核通过
		String verifyState = ((ParamConfigBean)StrutsUtil.getApplication().getAttribute("VERIFY_STATE")).getValueByCode("verifypass");
		//权限类型（模块，页面）
		String authType_module = ((ParamConfigBean)StrutsUtil.getApplication().getAttribute("AUTH_TYPE")).getValueByCode("module");
		String authType_page = ((ParamConfigBean)StrutsUtil.getApplication().getAttribute("AUTH_TYPE")).getValueByCode("page");
		
		//跟权限
		String hql = "";
		if(null != user.getScUsersesForParentUserId() && user.getScUsersesForParentUserId().size()>0){
			hql += "select a from ScRole as r left join r.scAuths as a left join r.scUserses as u where u.userId=? ";
		}else {
			hql += "select a from ScAuth a where 1=1 ";
		}
		
		hql = "select a from ScAuth a where a.authId in ("+ hql +") ";
		hql += " and a.enableState=? and a.deleteState=? and a.verifyState=? and a.authType in (?,?) order by a.authOrder desc a.createDate desc";
		
		if(null != user.getScUsersesForParentUserId() && user.getScUsersesForParentUserId().size()>0){
			list = this.createQueryList(hql,  user.getUserId(), enableState, deleteState, verifyState, authType_module, authType_page);
		}else {
			list = this.createQueryList(hql, enableState,deleteState, verifyState, authType_module, authType_page);
		}
		
		return this.getAllList(user, list);
	}
	
	@Resource
	private ShortcutDao shortcutDao;
	
	/**
	 * 封装所有子权限
	 * 
	 * @param authList
	 * @param jsonAuthList
	 * @return
	 */
	private JSONArray getAllList(ScUsers user,List<ScAuth> authList) {
		
		// 存放已封装的权限
		JSONArray jsonArray = new JSONArray();
		//权限类型（模块，页面）
		//String authType_module = ((ParamConfigBean)StrutsUtil.getApplication().getAttribute("AUTH_TYPE")).getValueByCode("module");
		// 循环父级目录
		for (ScAuth auth : authList) {
			JSONObject childnode = new JSONObject();
			
			// 树结构文件名称
			childnode.put("name", auth.getAuthName());
			// 树结构唯一标示
			childnode.put("id", auth.getAuthId());
			// 树结构父级ID
			if(null != auth.getScAuth()){
				childnode.put("pId", auth.getScAuth().getAuthId());
			}else {
				childnode.put("pId", 0);
				childnode.put("open", true);
			}
			// 树结构权限链接
			childnode.put("checked", shortcutDao.getShortcutByUserAuthid(user, auth.getAuthId()));
			// 树结构权限是否为父节点
			List<ScAuth> list = this.getAuths(user,auth.getAuthId());
			childnode.put("isParent", list.size()>0?true:false);
			//System.out.println(auth.getOpentypeState());
			childnode.put("doCheck", list.size()>0?false:true);
			
			jsonArray.add(childnode);
		}
		return jsonArray;
	}
	
	/**
	 * webservice根据权限code返回权限树（仅包含code，id，上级id）。
	 * @param authcode
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public ScAuth getAuthByCode(String authcode) {
		
		configMap = ParamConfigUtil.loadConfigs(configService.getAll());
		
		//启用
		String enableState = (configMap.get("CONFIG_STATE")).getValueByCode("enable");
		//未删除
		String deleteState = (configMap.get("DEL_STATE")).getValueByCode("enable");
		//审核通过
		String verifyState = (configMap.get("VERIFY_STATE")).getValueByCode("verifypass");
		
		String hql = "select a from ScAuth a where a.authCode =? ";
		hql += " and a.enableState=? and a.deleteState=? and a.verifyState=? order by a.authOrder desc a.createDate desc";
		
		List<ScAuth> list = new ArrayList<ScAuth>();
		list = this.createQueryList(hql, authcode, enableState, deleteState, verifyState);
		
		ScAuth auth = null;
		ScAuth auth2 = new ScAuth();
		if(list.size()>0){
			auth = list.get(0);
			auth2.setAuthCode(auth.getAuthCode());
			auth2.setAuthName(auth.getAuthName());
			auth2.setAuthId(auth.getAuthId());
			auth2.setAuthUrl(auth.getAuthUrl());
		}
		
		return auth2;
	}

	/**
	 * webservice根据权限code返回该条权限及子权限。
	 * @param authcode
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<ScAuth> getAuthChildByCode(String authcode) {
		
		configMap = ParamConfigUtil.loadConfigs(configService.getAll());
		
		//启用
		String enableState = (configMap.get("CONFIG_STATE")).getValueByCode("enable");
		//未删除
		String deleteState = (configMap.get("DEL_STATE")).getValueByCode("enable");
		//审核通过
		String verifyState = (configMap.get("VERIFY_STATE")).getValueByCode("verifypass");
		
		String hql = "select a from ScAuth a where a.scAuth.authCode =? ";
		hql += " and a.deleteState=? and a.enableState=? and a.verifyState=? order by a.authOrder desc a.createDate desc";
		
		List<ScAuth> list = new ArrayList<ScAuth>();
		list = this.createQueryList(hql, authcode, deleteState, enableState, verifyState);
		
		List<ScAuth> authlist = new ArrayList<ScAuth>();
		for (ScAuth auth : list) {
			ScAuth auth2 = new ScAuth();
			auth2.setAuthCode(auth.getAuthCode());
			auth2.setAuthName(auth.getAuthName());
			auth2.setAuthId(auth.getAuthId());
			auth2.setAuthUrl(auth.getAuthUrl());
			authlist.add(auth2);
		}
		
		return authlist;
	}
	
	/**
	 * webservice根据用户id返回权限。（包含权限所有信息）
	 * @param userid
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<ScAuth> getAuthsByUserid(String userid) {
		
		configMap = ParamConfigUtil.loadConfigs(configService.getAll());
		
		List<ScAuth> list = new ArrayList<ScAuth>();
		
		//启用
		String enableState = (configMap.get("CONFIG_STATE")).getValueByCode("enable");
		//未删除
		String deleteState = (configMap.get("DEL_STATE")).getValueByCode("enable");
		//审核通过
		String verifyState = (configMap.get("VERIFY_STATE")).getValueByCode("verifypass");
		//权限类型（模块）
		//String authType = (configMap.get("AUTH_TYPE")).getValueByCode("module");
		
		//跟权限
		String hql = "";
		if(userid.equals("1")){
			hql = "select a from ScAuth a where 1=1 ";
			hql += " and a.enableState=? and a.deleteState=? and a.verifyState=? order by a.authOrder desc, a.createDate desc";
			list = this.createQueryList(hql, enableState, deleteState, verifyState);
		}else {
			hql = "select a from ScRole as r left join r.scAuths as a left join r.scUserses as u where u.userId=? ";
			hql = "select a from ScAuth a where a.authId in ("+ hql +") ";
			hql += " and a.enableState=? and a.deleteState=? and a.verifyState=? order by a.authOrder desc, a.createDate desc";
			list = this.createQueryList(hql,  userid, enableState, deleteState, verifyState);
		}
		
		List<ScAuth> authlist = new ArrayList<ScAuth>();
		for (ScAuth auth : list) {
			ScAuth auth2 = new ScAuth();
			auth2.setAuthCode(auth.getAuthCode());
			auth2.setAuthName(auth.getAuthName());
			auth2.setAuthId(auth.getAuthId());
			auth2.setAuthUrl(auth.getAuthUrl());
			authlist.add(auth2);
		}
		
		return authlist;
	}
	
	/**
	 * webservice根据用户id及权限code，判断该用户是否具有该权限。返回是否。
	 * @param userid
	 * @param authcode
	 * @return
	 */
	public boolean haveThisCode(String userid, String authcode) {
		
		configMap = ParamConfigUtil.loadConfigs(configService.getAll());
		
		List<ScAuth> list = new ArrayList<ScAuth>();
		
		//启用
		String enableState = (configMap.get("CONFIG_STATE")).getValueByCode("enable");
		//未删除
		String deleteState = (configMap.get("DEL_STATE")).getValueByCode("enable");
		//审核通过
		String verifyState = (configMap.get("VERIFY_STATE")).getValueByCode("verifypass");
		//权限类型（模块）
		//String authType = (configMap.get("AUTH_TYPE")).getValueByCode("module");
		
		//跟权限
		String hql = "select a from ScRole as r left join r.scAuths as a left join r.scUserses as u where u.userId=? and a.authCode=? ";
		
		hql = "select a from ScAuth a where a.authId in ("+ hql +") ";
		hql += " and a.enableState=? and a.deleteState=? and a.verifyState=? order by a.authOrder desc a.createDate desc";
		
		list = this.createQueryList(hql, userid, authcode, enableState, deleteState, verifyState);
		
		return list.size()>0?true:false;
	}
	
	/**
	 * 根据用户，权限CODE查询该权限url
	 * 
	 * @return
	 */
	public String getUrlByCodeAndUser(ScUsers user, String authId){
		
		List<ScAuth> list = new ArrayList<ScAuth>();
		
		//启用
		String enableState = ((ParamConfigBean)StrutsUtil.getApplication().getAttribute("CONFIG_STATE")).getValueByCode("enable");
		//未删除
		String deleteState = ((ParamConfigBean)StrutsUtil.getApplication().getAttribute("DEL_STATE")).getValueByCode("enable");
		//审核通过
		String verifyState = ((ParamConfigBean)StrutsUtil.getApplication().getAttribute("VERIFY_STATE")).getValueByCode("verifypass");
		
		//跟权限
		String hql = "";
		
		if(null != user.getScUsersesForParentUserId() && user.getScUsersesForParentUserId().size()>0){
			hql = "select a from ScRole as r left join r.scAuths as a left join r.scUserses as u where u.userId=? and a.authId=? ";
			hql += " and a.enableState=? and a.deleteState=? and a.verifyState=? order by a.authOrder desc a.createDate desc";
			list = this.createQueryList(hql, user.getUserId(), authId, enableState, deleteState, verifyState);
		}else{
			hql = "select a from ScAuth as a where a.authId=? and a.enableState=? and a.deleteState=? and a.verifyState=? ";
			list = this.createQueryList(hql, authId, enableState, deleteState, verifyState);
		}
		
		ScAuth auth = new ScAuth();
		
		if(list.size()>0){
			auth = list.get(0);
		}
		
		return null!=auth?auth.getAuthUrl():"";
	}

	
	/**
	 * 根据条件查询所有权限
	 * @return
	 */
	public List<ScAuth> queryAllAuth(Map<String,Object> condition) {
		Finder finder = Finder.create("from ScAuth auth where auth.deleteState=:dele");
		finder.setParam("dele", ((ParamConfigBean) StrutsUtil.getApplication().getAttribute("DEL_STATE")).getBeansByCode("enable").getValue());
		if(condition!=null){
			if (condition.get("enableState") != null) {
				finder.append(" and auth.enableState=:enableState");
				finder.setParam("enableState", condition.get("enableState").toString());
			}
		}
		finder.append(" order by auth.authOrder desc");
		return super.find(finder);
	}
}
