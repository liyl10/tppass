/************************* 版权声明 *********************************
 *
 * Copyright (C) 2012 西安辉盛科技发展有限责任公司.
 *
 ******************************************************************
 */
package com.hopsun.scenter.webservice.service;

import java.util.List;

import javax.jws.WebService;

import com.hopsun.scenter.entity.ScAuth;

/**
 * 
 *@comments scenter 提供的 webservice 接口
 *@author dulei(dulei@hospun.com)
 *@date Jan 6, 2013
 *@version 1.0
 */
@WebService(targetNamespace="http://service.scenter.hopsun.com")
public interface SCenterService  {

	/**
	 * webservice根据用户id返回权限。（包含权限所有信息）
	 *@param userid
	 *@return List<ScAuth>
	 *
	 */
	public List<ScAuth> getAuthsByUserid(String userid);
	
	
	//webservice根据用户id返回权限树（仅包含code，id，上级id）。	
	
	
	/**
	 * webservice根据权限code返回权限（仅包含code，id，上级id）。
	 *@param authcode
	 *@return ScAuth
	 *
	 */
	public ScAuth getAuthByCode(String authcode);
	
	//webservice根据权限code返回单条权限信息。
	
	
	/**
	 * webservice根据权限code返回该条权限及子权限。
	 *@param authcode
	 *@return List<ScAuth>
	 *
	 */
	public List<ScAuth> getAuthChildByCode(String authcode);
	
	
	/**
	 * webservice根据用户id及权限code，判断该用户是否具有改权限。返回是否。
	 *@param userid authcode
	 *@return boolean
	 *
	 */
	public boolean haveThisCode(String userid,String authcode);
	
	
	
}
