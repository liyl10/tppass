/************************* 版权声明 *********************************
 *
 * Copyright (C) 2012 西安辉盛科技发展有限责任公司.
 *
 ******************************************************************
 */

package com.hopsun.scenter.api.user.service;

import java.util.List;
import java.util.Map;

import com.hopsun.framework.base.bean.Pager;
import com.hopsun.framework.base.service.BaseService;
import com.hopsun.scenter.entity.ScRole;
import com.hopsun.scenter.entity.ScUsers;

/**
 * @Comments:   用户服务接口
 * @author dulei(dulei@hopsun.cn)
 * @date 2012-12-26 15:51:32
 * @version 1.0
 *
 */
public interface UserService extends BaseService<ScUsers, String> {

	/**
	 * 根据用户名获取管理员对象，若管理员不存在，则返回null（不区分大小写）
	 * @param username
	 * @return ScUsers
	 *
	 */
	public ScUsers getUserByUsername(String username);
	/**
	 * 根据用户名获取管理员对象，若管理员不存在，则返回null（未删除）
	 * @param username
	 * @return ScUsers
	 *
	 */
	public ScUsers getUserByUsername2(String username);
	
	/**
	 * 分页查询
	 *@param user pageNo pageSize
	 *@return Pager
	 *
	 */
	public Pager find(ScUsers user,String optuserid,int pageNo, int pageSize);
	
	/**
	 * 查询用户信息
	 * @param dept
	 * @return
	 */
	public List<ScUsers> findUser(ScUsers user);
	
	/**
	 * 根据用户信息查询可用的角色list
	 * @param userId
	 * @return
	 */
	public List<ScRole> getRoleListByUserId(String userId);
	
	/**
	 * 根据用户id查询可用的上级用户id
	 * @param userId
	 * @return
	 */
	public List<ScUsers> getSupUserListByUserId(ScUsers user);
	
	public String  getSupUserListJsonByUserId(String userId ,String targetUserId);
	
	/**
	 * 获取可用角色列表，并带有是否选中属性
	 * @param userId
	 * @param targetUserId
	 * @return
	 */
	public List<ScRole> getRoleListWithSelected(String userId,String targetUserId);
	/**
	 * 更新用户信息
	 * @param user
	 * @return
	 */
	public Map<String, Object> updateUsers(ScUsers user);
	
	
	/**
	 * 删除用户信息
	 * @param user
	 * @return
	 */
	public Map<String, Object> deleteUser(String optUserId);
	/**
	 * 更新用户审核状态
	 * @param user
	 * @return
	 */
	public Map<String, Object> updateVerifyState(ScUsers user);
	
	/**
	 * 更新用户启用状态
	 * @param user
	 * @return
	 */
	public Map<String, Object> updateEnableState(ScUsers user);
	
	/**
	 * 查询可用用户列表
	 */
	public List<ScUsers> getList();
	
	/**
	 * 根据条件查询用户信息
	 * @comments 
	 * @param valueMap
	 * @return
	 * @version 1.0
	 */
	public List<ScUsers> getUserList(Map<String,Object> valueMap);
}