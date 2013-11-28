/*************** 版权声明***************
*
* Copyright (C) 2012 西安辉盛科技发展有限责任公司.
*
********************************************
*/
package com.hopsun.tppas.api.report.dao;

import java.util.List;
import com.hopsun.tppas.entity.TprojectGroup;
import com.hopsun.framework.base.dao.BaseDao;

/**
 * @comments 项目分组
 * @author wanglw
 * @date 2013-9-10 @time 下午4:24:38
 * @Version 1.0
 */
public interface TprojectGroupDao extends BaseDao<TprojectGroup, String>{
	
	/**
	 * @comments 根据本门Id取得项目分组List
	 * @param deptId
	 * @return
	 * @Version 1.0
	 */
	public List<TprojectGroup> getProjectGroupListByDeptId(String deptId);
	/**
	 * @comments 根据子分类ID取得项目分组List
	 * @param deptId
	 * @return
	 * @Version 1.0
	 */
	public List<TprojectGroup> getProjectGroupListByTypeId(String typeId);
	
	/**
	 * @comments 根据子分类ID取得项目分组List
	 * @param deptId
	 * @return
	 * @Version 1.0
	 */
	public List<TprojectGroup> getProjectGroupListByTypeStr(String typeStr);
	// weina start
	/**
	 * 
	 * @comments 根据子分类和锁定区分查询项目分组list
	 * @param typeStr
	 * @return
	 * @version 1.0
	 */
	public List<TprojectGroup> getProjectGroupListByTypeStrClockFlag(String typeStr);
	// weina end
}
