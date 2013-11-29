/************************* 版权声明 *********************************
 *
 * Copyright (C) 2012 西安辉盛科技发展有限责任公司.
 *
 ******************************************************************
 */

package com.hopsun.scenter.api.dept.service;

import java.util.List;
import java.util.Map;

import com.hopsun.framework.base.bean.Pager;
import com.hopsun.framework.base.service.BaseService;
import com.hopsun.scenter.entity.ScDept;
import com.hopsun.scenter.entity.ScUsers;

/**
 * @Comments:   部门服务接口
 * @author dulei(dulei@hopsun.cn)
 * @date 2012-12-26 15:50:32
 * @version 1.0
 *
 */
public interface DeptService extends BaseService<ScDept, String> {

	/**
	 * 根据部门名称获取部门对象，若不存在，则返回null（不区分大小写）
	 *@param deptname deptid parentid
	 *@return ScDept
	 *
	 */
	public ScDept getDeptByDeptname(String deptname,String deptid,String parentid);
	
	/**
	 * 根据部门CODE获取部门对象，若不存在，则返回null（不区分大小写）
	 *@param deptcode deptid parentid
	 *@return ScDept
	 *
	 */
	public ScDept getDeptByDeptcode(String deptcode,String deptid,String parentid);
	
	/**
	 * 分页查询
	 *@param dept pageNo pageSize 
	 *@return Pager
	 *
	 */
	public Pager find(ScDept dept,int pageNo, int pageSize);
	
	/**
	 * 
	 * @comments 查询所有未删除、审核通过、启用的部门信息
	 * @param dept
	 * @return
	 * @version 1.0
	 */
	public List<ScDept> findDept(ScDept dept);
	
	
	/**
	 * 查询所有未删除、审核通过、启用的部门信息,返回json格式字符串
	 * @return
	 */
	public String getDeptListJson(ScUsers user,ScDept dept);
	/**
	 * 更新部门信息
	 * @return
	 */
	public Map<String,Object> updateDept(ScDept scDept);
	/**
	 * 修改启用状态
	 * @param scDept
	 * @return
	 */
	public Map<String,Object> updateDeptEnableState(String id,String enableState);
	
}