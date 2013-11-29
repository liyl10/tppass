/************************* 版权声明 *********************************
 *
 * Copyright (C) 2012 西安辉盛科技发展有限责任公司.
 *
 ******************************************************************
 */
package com.hopsun.scenter.api.role.service;

import java.util.Map;
import java.util.Set;

import com.hopsun.framework.base.bean.Pager;
import com.hopsun.framework.base.service.BaseService;
import com.hopsun.scenter.entity.ScRole;
 
/**
 * @comments  角色服务接口
 * @author yinxy
 * @date Dec 26, 2012
 * @version 1.0
 */
public interface RoleService extends BaseService<ScRole, String> {
	/**
	 * 添加角色
	 * 
	 * @param roleId
	 * @param roleName
	 * @param roleDesc
 
	 * @param enableState
	 * @param verifyState
	 * @param deleteState
	 * @param roleOrder
	 * @param createUserName
	 * @param createDate
	 * @param modifyUserName
	 * @param modifyDate
	 * @return
	 */
	public Map<String, Object> saveRole(String roleId, String roleName, String roleDesc,   String enableState, String verifyState, String deleteState, String roleOrder, String createUserName, String createDate, String modifyUserName, String modifyDate,String userId);

	/**
	 * 更新角色
	 * 
	 * @param roleId
	 * @param roleName
	 * @param roleDesc
 
	 * @param enableState
	 * @param verifyState
	 * @param deleteState
	 * @param roleOrder
	 * @param createUserName
	 * @param createDate
	 * @param modifyUserName
	 * @param modifyDate
	 * @return
	 */
	public Map<String, Object> updateRole(String roleId, String roleName, String roleDesc,  String enableState, String verifyState, String deleteState, String roleOrder, String createUserName, String createDate, String modifyUserName, String modifyDate);

	/**
	 * 获取角色列表
	 * 
	 * @return
	 */
	public Map<String, Object> getRoleList();

	/**
	 * 根据条件查询角色列表
	 * 
	 * @param condition
	 * @return
	 */
	public Map<String, Object> queryRoleList(Map<String,Object> condition);

	/**
	 * 删除角色
	 * 
	 * @param roleId
	 * @return
	 */
	public Map<String, Object> deleteRole(String roleId);

	/**
	 * 根据条件分页查询角色
	 * @param condition
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	 
	public Pager find(Map<String,Object> condition ,int pageNo, int pageSize);

	/**
	 * 根据id查询角色信息
	 * @param roleId
	 * @return
	 */
	public Map<String, Object> queryRoleById(String roleId);

	/**
	 * 跳转至角色权限分配页
	 * @param roleId
	 * @return
	 */
	public Map<String, Object> goAuthor(String roleId,String userId);
	/**
	 * 跳转至角色权限查看页
	 * @param roleId
	 * @return
	 */
	public Map<String, Object> goViewAuthor(String roleId);

	/**
	 * 更新角色的权限信息
	 * 
	 * @param roleId
	 * @return
	 */
	public Map<String, Object> updateRoleAuthMap(String roleId, String[] authIds);
	/**
	 * 更新审核状态
	 * @param roleId
	 * @param verifyState
	 * @return
	 */
	public Map<String, Object> updateVerifyState(String userName, String roleId, String verifyState);
	/**
	 * 更新审核状态,确认用户不属于该角色
	 * @param roleId
	 * @param verifyState
	 * @return
	 */
	public Map<String,Object>updateVerifyState(String userName,String roleId, String verifyState,String verifyNote,String userId);
	/**
	 * 根据roleid数组，返回role的set集合
	 * @param roleIds
	 * @return
	 */
	public Set<ScRole> getRoleSetById(String[] roleIds);
	/**
	 * 更改启用状态
	 * @return
	 */
	public Map<String,Object> updateRoleEnableState(String roleId, String enableState);
	/**
	 * 更改启用状态，确认该用户不属于改角色
	 * @return
	 */
	public Map<String,Object> updateRoleEnableState(String roleId, String enableState,String userId);
	/**
	 *  删除一个角色。并且用户自己不在这个角色中
	 * @param roleId
	 * @param userId
	 * @return
	 */
	public Map<String,Object> deleteRole(String roleId,String userId);
	/**
	 * 判断角色名称是否重复
	 * 
	 * @return
	 */
	public boolean isExistName(String roleName, String roleId);

}
