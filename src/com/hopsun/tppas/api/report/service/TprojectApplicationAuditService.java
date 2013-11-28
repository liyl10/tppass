/*************** 版权声明***************
*
* Copyright (C) 2012 西安辉盛科技发展有限责任公司.
*
********************************************
*/
package com.hopsun.tppas.api.report.service;

import java.util.List;
import java.util.Map;

import com.hopsun.framework.base.bean.Pager;
import com.hopsun.framework.base.service.BaseService;
import com.hopsun.tppas.entity.TexpertScore;
import com.hopsun.tppas.entity.TprojectApplication;
/**
 * @comments 项目评审
 * @author wanglw
 * @date 2013-9-10 @time 下午4:27:03
 * @Version 1.0
 */
public interface TprojectApplicationAuditService extends BaseService<TprojectApplication, String> {
	
	/**
	 * @comments 取得项目审核数据
	 * @param param
	 * @param pageNo
	 * @param pageSize
	 * @return
	 * @Version 1.0
	 */
	public Pager getAuditExpertList(Map<String, Object> param, int pageNo, int pageSize);
	
	/**
	 * @comments 取得创建分组时取得的项目List
	 * @param param
	 * @return
	 * @Version 1.0
	 */
	public List<Map<String, Object>> getGroupSelectProjectList(Map<String, Object> param);
	
	/**
	 * @comments 取得新建项目分组选择的项目list
	 * @param groupId
	 * @param pageNo
	 * @param pageSize
	 * @return
	 * @Version 1.0
	 */
	public Pager getGroupSelectedProjectList(String groupId, int pageNo, int pageSize);
	
	/**
	 * @comments 批量更新项目分组
	 * @param selectedProjectIds
	 * @Version 1.0
	 */
	public void updateBatchProjectGroup(String selectedProjectIds);
	
	/**
	 * @comments 更新项目分组
	 * @param projectId
	 * @Version 1.0
	 */
	public void updateProjectGroup(String projectId);
	
	/**
	 * @comments 改变项目分组
	 * @param projectId
	 * @param groupId
	 * @param oldGroupId
	 * @Version 1.0
	 */
	public void updateProjectGroup(String projectId, String groupId,String oldGroupId);
	/**
	 * @comments 取得项目审核数据
	 * @param param
	 * @param pageNo
	 * @param pageSize
	 * @return
	 * @Version 1.0
	 */
	public Pager getProjectAuditList(Map<String, Object> param, int pageNo, int pageSize);
	
	/**
	 * @comments 取得项目申报信息 
	 * @param projectId 项目Id
	 * @return
	 * @Version 1.0
	 */
	public TprojectApplication getProjectAppliaction(String projectId);
	
	/**
	 * @comments 保存评审意见 
	 * @param texpertScoreList
	 * @param tprojectApplication
	 * @param userId
	 * @Version 1.0
	 */
	public void saveAuditOpinions(List<TexpertScore> texpertScoreList, 
			TprojectApplication tprojectApplication, String userId);
	
	/**
	 * @comments 提交评审意见 
	 * @param texpertScoreList
	 * @param tprojectApplication
	 * @param userId
	 * @Version 1.0
	 */
	public void saveAndSubmitAuditOpinions(List<TexpertScore> texpertScoreList, 
			TprojectApplication tprojectApplication, String userId);
	
	/**
	 * @comments 取得分计划选择项目
	 * @param param
	 * @param pageNo
	 * @param pageSize
	 * @return
	 * @Version 1.0
	 */
	public Pager getBatchProjectList(Map<String, Object> param, int pageNo, int pageSize);
	
	/**
	 * @comments 取得分计划选择的项目
	 * @param planId
	 * @return
	 * @Version 1.0
	 */
	public List<TprojectApplication> getPlanUpdateList(String planId);
	
	/**
	 * @comments 更新项目的分计划选择状态
	 * @param projectId
	 * @Version 1.0
	 */
	public void updateProSelectStatus(String projectId);
	
	/**
	 * @comments 取得的项目List
	 * @param param
	 * @return
	 * @Version 1.0
	 */
	public List<Map<String, Object>> getSelectProjectList(Map<String, Object> param);

	/**
	 * 
	 * @comments 根据分组id查询属于该分组的项目 
	 * @param param
	 * @param pageNumber
	 * @param pageSize
	 * @return
	 * @version 1.0
	 */
	public Pager getGroupProjectList(Map<String, Object> param, Integer pageNumber, Integer pageSize);
	
	/**
	 * @comments 取得创建分组时取得的项目List
	 * @param param
	 * @return
	 * @Version 1.0
	 */
	public Pager getGroupSelectProjectPager(Map<String, Object> param,Integer pageNumber, Integer pageSize);
}
