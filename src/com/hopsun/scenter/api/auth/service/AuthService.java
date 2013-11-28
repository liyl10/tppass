/************************* 版权声明 *********************************
 *
 * Copyright (C) 2012 西安辉盛科技发展有限责任公司.
 *
 ******************************************************************
 */
package com.hopsun.scenter.api.auth.service;

import java.io.File;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONArray;

import com.hopsun.framework.base.service.BaseService;
import com.hopsun.scenter.entity.ScAuth;
import com.hopsun.scenter.entity.ScUsers;

/**
 * @comments  权限服务接口
 * @author yinxy
 * @date Dec 26, 2012
 * @version 1.0
 */

public interface AuthService extends BaseService<ScAuth, String> {
	/**
	 * 根据上级id查询下级列表
	 * 
	 * @param pid
	 * @return
	 */
	public String authDataTree(String pid);
	/**
	 * 查询可用的系统权限列表
	 * @return
	 */
	public List<ScAuth> getAuthListAllUsed();

	/**
	 * 添加权限
	 * 
	 * @param authId
	 * @param authName
	 * @param authParentId
	 * @param authCode
	 * @param authUrl
	 * @param authType
	 * @param authIcon
	 * @param authDesc
	 * @param authOrder
	 * @param rootState
	 * @param enableState
	 * @param verifyState
	 * @param deleteState
	 * @param createUserName
	 * @param createDate
	 * @param modifyUserName
	 * @param modifyDate
	 * @param roleType
	 * @return
	 */
	public Map<String, Object> saveAuth(String authId, String authName, String authParentId, String authCode, String authUrl, String authType, String authIcon, String authDesc, String authOrder, String rootState, String enableState, String verifyState, String deleteState, String createUserName, String createDate, String modifyUserName, String modifyDate, String roleType,String opentypeState);

	/**
	 * 根据权限id查询权限信息,返回带有json。
	 * 
	 * @param id
	 * @return
	 */
	public Map<String, Object> queryAuthById(String id);
	/**
	 * 根据权限id查询权限信息。
	 * 
	 * @param id
	 * @return
	 */
	public Map<String, Object> queryAuthByIdObj(String id);

	/**
	 * 根据id查询权限及子权限
	 * 
	 * @param id
	 * @return
	 */
	public Map<String, Object> queryAuthCollectById(String id);

	/**
	 * 更新权限信息
	 * 
	 * @param authId
	 * @param authName
	 * @param authParentId
	 * @param authCode
	 * @param authUrl
	 * @param authType
	 * @param authIcon
	 * @param authDesc
	 * @param authOrder
	 * @param rootState
	 * @param enableState
	 * @param verifyState
	 * @param deleteState
	 * @param createUserName
	 * @param createDate
	 * @param modifyUserName
	 * @param modifyDate
	 * @param roleType
	 * @return
	 */
	public Map<String, Object> updateAuth(String authId, String authName, String authParentId, String authCode, String authUrl, String authType, String authIcon, String authDesc, String authOrder, String rootState, String enableState, String verifyState, String deleteState, String createUserName, String createDate, String modifyUserName, String modifyDate, String roleType,String opentypeState);

	/**
	 * 删除权限
	 * 
	 * @param id
	 * @return
	 */
	public Map<String, Object> deleteAuthById(String id);

	/**
	 * 移动权限
	 * 
	 * @param selectedId
	 * @param tagertId
	 * @return
	 */
	public Map<String, Object> updateMoveAuthById(String selectedId, String tagertId);

	// 杜雷修改 start
	/**
	 * 根据用户查询权限跟节点信息
	 * 
	 * @return
	 */
	public List<ScAuth> getAuthByUser(ScUsers user);

	/**
	 * 根据用户查询用户所有权限信息
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
	 * 根据用户，权限CODE查询该权限url
	 * 
	 * @return
	 */
	public String getUrlByCodeAndUser(ScUsers user, String code);
	// 杜雷修改 end
	
	/**
	  * 方法描述：上传图片
	  * @param: 
	  * @return: 
	  * @version: Dec 31, 2012 4:56:49 PM
	 */
	public String upload(String file,File fi,String fileName,String userName,String userId);
}
