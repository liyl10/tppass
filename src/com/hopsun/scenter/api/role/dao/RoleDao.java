/************************* 版权声明 *********************************
 *
 * Copyright (C) 2012 西安辉盛科技发展有限责任公司.
 *
 ******************************************************************
 */
package com.hopsun.scenter.api.role.dao;

import java.util.List;
import java.util.Map;

import com.hopsun.framework.base.bean.Pager;
import com.hopsun.framework.base.dao.BaseDao;
import com.hopsun.scenter.entity.ScRole;

 
/**
 * @comments  角色管理Dao层接口
 * @author yinxy
 * @date Dec 26, 2012
 * @version 1.0
 */

public interface RoleDao extends BaseDao<ScRole, String> {
	/**
	 * 获取角色列表
	 * @return
	 */
	public List<ScRole> getRoleList();
 
	//	/**
	//	 * 根据角色id获取权限
	//	 * @return
	//	 */
	//public List getAuthListByRoleId(String roleId);
	/**
	 * 根据条件查询角色列表
	 * @param condition
	 * @return
	 */
	public List<ScRole> queryRoleList(Map<String,Object> condition);
	/**
	 * 根据条件查询角色分页
	 * @param condition
	 * @return
	 */
	public Pager queryRoleList(Map<String,Object> condition,int pageNo, int pageSize);
	/**
	 * 根据条件查询角色分页,后跟权限验证sql
	 * @param condition
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	public Pager queryRoleListWithSql(Map<String,Object> condition,int pageNo, int pageSize);
}
