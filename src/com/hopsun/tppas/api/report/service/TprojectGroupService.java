/*************** 版权声明***************
*
* Copyright (C) 2012 西安辉盛科技发展有限责任公司.
*
********************************************
*/
package com.hopsun.tppas.api.report.service;

import java.util.List;

import com.hopsun.framework.base.service.BaseService;
import com.hopsun.tppas.entity.TprojectApplication;
import com.hopsun.tppas.entity.TprojectGroup;

/**
 * @comments 项目分组
 * @author wanglw
 * @date 2013-9-10 @time 下午4:23:53
 * @Version 1.0
 */
public interface TprojectGroupService extends BaseService<TprojectGroup, String> {
	
	/**
	 * @comments 根据本门Id取得项目分组List
	 * @param deptId
	 * @return
	 * @Version 1.0
	 */
	public List<TprojectGroup> getProjectGroupListByDeptId(String deptId);
	
	/**
	 * @comments 保存项目分组选择的项目信息
	 * @param projectIds
	 * @param groupName
	 * @param deptId
	 * @Version 1.0
	 */
	public String saveGroupSelectProject(String groupId, String projectIds, String groupName, String deptId,String projectType1,String projectType2,String userId);
	
	/**
	 * @comments 保存、更新项目分组
	 * @param groupId
	 * @param groupName
	 * @param deptId
	 * @Version 1.0
	 */
	public void saveOrUpdateGroup(String groupId, String groupName, String deptId);

	/**
	 * 
	 * @comments 删除分组
	 * @param groupId
	 * @param userId
	 * @version 1.0
	 */
	public void deleteGroup(String groupId, String userId);

	/**
	 * 
	 * @comments 从分组中删除项目 
	 * @param userId
	 * @param tprojectApplication
	 * @version 1.0
	 */
	public void deleteProjecFromGroup(String userId, TprojectApplication tprojectApplication);
	
	/**
	 * @comments 根据子分类取得项目分组List
	 * @param deptId
	 * @return
	 * @Version 1.0
	 */
	public List<TprojectGroup> getProjectGroupListByTypeId(String typeId);

	/**
	 * @comments 根据子分类(in)取得项目分组List
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
