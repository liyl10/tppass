package com.hopsun.scenter.api.dept.dao;

import java.util.List;

import com.hopsun.framework.base.bean.Pager;
import com.hopsun.framework.base.dao.BaseDao;
import com.hopsun.scenter.entity.ScDept;

public interface DeptDao extends BaseDao<ScDept, String> {

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

}
