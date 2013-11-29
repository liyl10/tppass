/************************* 版权声明 *********************************
 *
 * Copyright (C) 2012 西安辉盛科技发展有限责任公司.
 *
 ******************************************************************
 */
package com.hopsun.tppas.api.superadmin.service;

import java.util.List;
import java.util.Map;

import com.hopsun.framework.base.service.BaseService;
import com.hopsun.scenter.entity.ScUsers;
import com.hopsun.tppas.entity.TprojectType;
import com.hopsun.tppas.entity.TprojectTypeManager;

/**
 * @comments 计划类别管理专员
 * @author wangxiaodong
 * @date 2013-10-23
 * @version 1.0
 */
public interface TprojectTypeManagerService extends BaseService<TprojectTypeManager, String> {
	
	/**
	 *通过条件查询计划类别管理专员
	 * @comments 
	 * @param valueMap
	 * @return
	 * @version 1.0
	 */
	public TprojectTypeManager getTprojectTypeManager(Map<String,Object> valueMap);
	
	/**
	 * 保存计划类别管理专员信息
	 * @comments 
	 * @param user
	 * @param tprojectTypeManager
	 * @version 1.0
	 */
	public void saveTprojectTypeManager(ScUsers user,TprojectTypeManager tprojectTypeManager);
	
	/**
	 * 通过用户得到用户对应的计划类别字符串  例如：1,2,3
	 * @comments 
	 * @param user
	 * @return
	 * @version 1.0
	 */
	public String getProjectTypeStrByUser(ScUsers user);
	
	/**
	 * 通过用户得到用户对应的计划类别集合
	 * @comments 
	 * @param user
	 * @return
	 * @version 1.0
	 */
	public List<TprojectType> getProjectTypeListByUser(ScUsers user);
	
	/**
	 * 判断用户是项目分类专员还是部门管理员
	 * @comments 
	 * @param user
	 * @return
	 * @version 1.0
	 */
	public boolean getManagerPurview(ScUsers user);
	
	/**
	 * 得到专员用户管理的项目分类对象
	 * @comments 
	 * @param user
	 * @return
	 * @version 1.0
	 */
	public TprojectType getTprojectTypeByUser(ScUsers user);
	
}
