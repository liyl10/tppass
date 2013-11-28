/************************* 版权声明 *********************************
 *
 * Copyright (C) 2012 西安辉盛科技发展有限责任公司.
 *
 ******************************************************************
 */
package com.hopsun.scenter.webservice.service.impl;

import java.util.List;

import javax.jws.WebService;

import org.apache.xbean.spring.context.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import com.hopsun.scenter.api.auth.dao.AuthDao;
import com.hopsun.scenter.entity.ScAuth;
import com.hopsun.scenter.webservice.service.SCenterService;

/**
 * scenter 提供的 webservice 接口实现
 *@comments
 *@author dulei(dulei@hospun.com)
 *@date Jan 6, 2013
 *@version 1.0
 */
@Service
@WebService(serviceName = "SCenterService", endpointInterface = "com.hopsun.scenter.webservice.service.SCenterService")
public class SCenterServiceImpl  implements SCenterService {
	
	public static AuthDao authDao = null ;
	
	public AuthDao getAauthDao() {
		if(null == authDao){
			authDao = (AuthDao)new ClassPathXmlApplicationContext("applicationContext.xml").getBean("authDao");
		}
		
		return authDao;
	}
	
	/**
	 * webservice根据权限code返回权限（仅包含code，id，上级id）。
	 *@param authcode
	 *@return ScAuth
	 *
	 */
	public ScAuth getAuthByCode(String authcode) {
		return getAauthDao().getAuthByCode(authcode);
	}

	/**
	 * webservice根据权限code返回该条权限及子权限。
	 *@param authcode
	 *@return List<ScAuth>
	 *
	 */
	public List<ScAuth> getAuthChildByCode(String authcode) {
		
		return getAauthDao().getAuthChildByCode(authcode);
	}
	
	/**
	 * webservice根据用户id返回权限。（包含权限所有信息）
	 *@param userid
	 *@return List<ScAuth>
	 *
	 */
	public List<ScAuth> getAuthsByUserid(String userid) {
		
		return getAauthDao().getAuthsByUserid(userid);
	}
	
	/**
	 * webservice根据用户id及权限code，判断该用户是否具有改权限。返回是否。
	 *@param userid authcode
	 *@return boolean
	 *
	 */
	public boolean haveThisCode(String userid, String authcode) {
		
		return getAauthDao().haveThisCode(userid, authcode);
	}

}
