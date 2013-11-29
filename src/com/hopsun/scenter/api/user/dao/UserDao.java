/************************* 版权声明 *********************************
 *
 * Copyright (C) 2012 西安辉盛科技发展有限责任公司.
 *
 ******************************************************************
 */

package com.hopsun.scenter.api.user.dao;

import java.util.List;
import java.util.Map;

import com.hopsun.framework.base.bean.Pager;
import com.hopsun.framework.base.dao.BaseDao;
import com.hopsun.scenter.entity.ScUsers;

/**
 * @Comments:   dao接口- 部门管理
 * @author yanqiang(yanqiang@hopsun.cn)
 * @date 2012-11-10 上午08:55:32
 * @version 1.0
 *
 */
public interface UserDao extends BaseDao<ScUsers, String> {

	/**
	 * 根据用户名判断此用户是否存在（不区分大小写）
	 * @param username
	 * @return boolean
	 *
	 */
	public boolean isExistByUsername(String username);

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
	public Pager find(ScUsers user,ScUsers optUser,Map<String,Object> condition,int pageNo, int pageSize);
	
	/**
	 * 查询用户信息
	 * @param dept
	 * @return
	 */
	public List<ScUsers> findUser(ScUsers user);
	
 
	/**
	 * 根据条件查询用户列表
	 * @param condition
	 * @return
	 */
	public List<ScUsers> queryUserList(ScUsers user);
	
	/**
	 * 根据条件查询用户列表,根据condition
	 * @param condition
	 * @return
	 */
	public List<ScUsers> queryUserList(ScUsers user,Map<String,Object> condition);
	
	/**
	 * 根据userID取得user对象
	 * @param userId
	 * @return
	 */
	public ScUsers getUsersByUserId(String userId);

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