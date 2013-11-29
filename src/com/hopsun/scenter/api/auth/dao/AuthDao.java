/************************* 版权声明 *********************************
 *
 * Copyright (C) 2012 西安辉盛科技发展有限责任公司.
 *
 ******************************************************************
 */
package com.hopsun.scenter.api.auth.dao;

import java.util.List;
import java.util.Map;

import net.sf.json.JSONArray;

import com.hopsun.framework.base.dao.BaseDao;
import com.hopsun.scenter.entity.ScAuth;
import com.hopsun.scenter.entity.ScUsers;

/**
 * @comments 权限服务Dao层接口
 * @author yinxy
 * @date Dec 26, 2012
 * @version 1.0
 */
public interface AuthDao extends BaseDao<ScAuth, String> {

	/**
	 * 根据上级权限id，查询权限列表
	 * 
	 * @param id
	 * @return
	 */
	 
	public List<ScAuth> queryAuthListByParent(String pid);

	/**
	 * 查询权限跟节点
	 * 
	 * @return
	 */
	public List<ScAuth>  queryAuthRoot();

	/**
	 * 查询所有权限
	 * 
	 * @return
	 */
	public List<ScAuth>  queryAllAuth();
	/**
	 * 根据条件查询所有权限
	 * @return
	 */
	public List<ScAuth> queryAllAuth(Map<String,Object> condition) ;

	/**
	 * 根据条件Map，查询权限列表
	 */
	public List<ScAuth>  queryAuthList(Map<String,Object> condition);

	/**
	 * 根据用户查询权限跟节点信息
	 * 
	 * @return
	 */
	public List<ScAuth> getAuthByUser(ScUsers user);

	/**
	 * 根据用户查询用户所有权限信息
	 * 
	 * @return
	 */
	public JSONArray getAuthsByUser(ScUsers user);

	/**
	 * 根据用户，权限信息查询权限子节点信息
	 * 
	 * @return
	 */
	public List<ScAuth> getAuths(ScUsers user, String authid);
	
	/**
	 * webservice根据用户id返回权限。（包含权限所有信息）
	 * @param userid
	 * @return
	 */
	public List<ScAuth> getAuthsByUserid(String userid);
	/**
	 * webservice根据权限code返回权限（仅包含code，id，上级id）。
	 * @param authcode
	 * @return
	 */
	public ScAuth getAuthByCode(String authcode);
	/**
	 *  webservice根据权限code返回该条权限及子权限。
	 * @param authcode
	 * @return
	 */
	public List<ScAuth> getAuthChildByCode(String authcode);
	/**
	 * webservice根据用户id及权限code，判断该用户是否具有改权限。返回是否。
	 * @param userid
	 * @param authcode
	 * @return
	 */
	public boolean haveThisCode(String userid, String authcode);
	
	/**
	 * 根据用户，权限CODE查询该权限url
	 * 
	 * @return
	 */
	public String getUrlByCodeAndUser(ScUsers user, String code);

}
