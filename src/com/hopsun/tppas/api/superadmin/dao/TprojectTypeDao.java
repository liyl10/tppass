package com.hopsun.tppas.api.superadmin.dao;

import java.util.List;

import com.hopsun.tppas.entity.TprojectType;
import com.hopsun.framework.base.bean.Pager;
import com.hopsun.framework.base.dao.BaseDao;

public interface TprojectTypeDao extends BaseDao<TprojectType, String>{
	
	/**
	 * @Comments 分页查询
	 * @param sql
	 * @param pageNumber
	 * @param pageSize
	 * @return
	 * @Vsersion: 1.0
	 */
	public Pager find(String sql, Integer pageNumber, Integer pageSize);
	
	/**
	 * @Comments 取得除过id的信息
	 * @param sql
	 * @return
	 * @Vsersion: 1.0
	 */
	public List<TprojectType> getListExceptId(String sql);

	/**
	 * 
	 * @comments 根据部门id取得属于该部门的项目父分类
	 * @param deptId
	 * @return
	 * @version 1.0
	 */
	public List<TprojectType> getFatherProjectTypeListByDeptId(String deptId);

	/**
	 * 
	 * @comments 根据父类型id取得项目子分类
	 * @param parentTypeId
	 * @return
	 * @version 1.0
	 */
	public List<TprojectType> getSonProjectTypeListByDeptId(String parentTypeId);

	/**
	 * @comments 取得项目分类显示名称   父类名称-分类名称
	 * @param projectTypeId
	 * @return
	 * @Version 1.0
	 */
	public String getProjectTypeAllName(String projectTypeId);
	
	
	//wangxd start
	/**
	 * @comments 得到所有未删除的项目分类
	 * @return
	 * @Version 1.0
	 */
	public List<TprojectType> getAllProjectType();
	
	/**
	 * @comments 得到所有未删除的所有计划类别
	 * @return
	 * @Version 1.0
	 */
	public List<TprojectType> getAllProjectTypeFirst();
	
	//wangxd end
}
