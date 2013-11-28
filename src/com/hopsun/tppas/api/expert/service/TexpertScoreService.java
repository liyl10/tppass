/*************** 版权声明***************
*
* Copyright (C) 2012 西安辉盛科技发展有限责任公司.
*
********************************************
*/
package com.hopsun.tppas.api.expert.service;

import java.util.List;
import java.util.Map;

import com.hopsun.framework.base.bean.Pager;
import com.hopsun.framework.base.service.BaseService;
import com.hopsun.tppas.entity.TexpertScore;
import com.hopsun.tppas.entity.TprojectApplication;

/**
 * @comment 专家评审管理
 * @author wangxiaodong
 * @DATE: 2013-08-27 @TIME: 下午2:09:37
 * @Vsersion: 1.0
 */
public interface TexpertScoreService extends BaseService<TexpertScore, String> {
	
	// wanglw Start
	/**
	 * @comments 取得已选择的专家信息
	 * @param param
	 * @param pageNo
	 * @param pageSize
	 * @return
	 * @Version 1.0
	 */
	public Pager getSelectedExpertList(Map<String, Object> param, int pageNo, int pageSize);
	
	/**
	 * @comments 取得已选择的专家信息(发送通知)
	 * @param param
	 * @param pageNo
	 * @param pageSize
	 * @return
	 * @Version 1.0
	 */
	public Pager getJointSelectedExpertList(Map<String, Object> param, int pageNo, int pageSize);
	/**
	 * @comments 
	 * @param projectId 项目ID
	 * @param selectExpertId 选择的专家ID
	 * @param userId 创建者
	 * @Version 1.0
	 */
	public void saveTexpertScores(String projectId, String selectExpertId,String userId);
	
	
	/**
	 * @comments 批量取得已选择的专家信息
	 * @param param
	 * @param pageNo
	 * @param pageSize
	 * @return
	 * @Version 1.0
	 */
	public Pager getBatchSelectedExpertList(Map<String, Object> param, int pageNo, int pageSize);
	
	/**
	 * @comments 
	 * @param selectedProjectIds 选择的项目ID
	 * @param selectExpertId 选择的专家ID
	 * @Version 1.0
	 */
	public void saveBatchTexpertScores(String selectedProjectIds, String selectExpertId);
	
	
	/**
	 * @comments 取得已评审专家信息
	 * @param param
	 * @param pageNo
	 * @param pageSize
	 * @return
	 * @Version 1.0
	 */
	public Pager getProgressExpertList(Map<String, Object> param, int pageNo, int pageSize);
	
	/**
	 * @comments 取得专家评审列表
	 * @param projectId 项目Id
	 * @return
	 * @Version 1.0
	 */
	public List<TexpertScore> getExpertScoreList(String projectId);
	
	/**
	 * @comments 批量删除已选择专家
	 * @Version 1.0
	 */
	public void deleteBatchExpert(String expertIds, String projectId);
	
	/**
	 * @comments 删除已选择专家
	 * @Version 1.0
	 */
	public void deleteExpert(String expertId, String projectId);
	// wanglw End
	
	/**
	 * @comments 删除已选择专家
	 * @Version 1.0
	 */
	public void deleteExpert(String relateionId);
	
	/**
	 * @comments 批量删除已选择专家
	 * @Version 1.0
	 */
	public void deleteBatchExpert(String relationIds);
	
	/**
	 * @comments 专家评审列表
	 * @param param
	 * @param pageNo
	 * @param pageSize
	 * @return
	 * @Version 1.0
	 */
	public Pager getAuditList(Map<String, Object> param, int pageNo, int pageSize);
	
	//wangxd statr
	/**
	 * 查询已填写或者未填写的项目申报信息
	 * @comments 
	 * @param param 0-未填写   1-填写
	 * @return
	 * @version 1.0
	 */
	public List<TprojectApplication> getProjectsByWriteState(Map<String,Object> param);
	
	/**
	 * 查询项目申报下的专家评审记录
	 * @comments 
	 * @param projectId
	 * @return
	 * @version 1.0
	 */
	public Map<String,Object> getTexpertScoresByProjectId(String projectId);
	
	/**
	 * 保存或更新专家评审意见
	 * @comments 
	 * @param valueMap
	 * @version 1.0
	 */
	public void saveExpertScore(Map<String,Object> valueMap);
	
	/**
	 * 通过组打印专家评审数据
	 * @comments 
	 * @param groupId
	 * @return
	 * @version 1.0
	 */
	public Map<String,Object> printExpertScoreByGroup(String groupId);
	
	/**
	 * 通过组打印专家评审数据
	 * @comments 
	 * @param projectId
	 * @return
	 * @version 1.0
	 */
	public Map<String,Object> printExpertScoreByProject(String projectId);
	
	/**
	 * 通过查询条件打印专家评审数据
	 * @comments 
	 * @param paramMap
	 * @return
	 * @version 1.0
	 */
	public List<Map<String,Object>> printExpertScoreAll(Map<String,Object> paramMap);
	
	/**
	 * 通过条件查询该组下项目信息-分页
	 * @comments 
	 * @param param
	 * @param pageNo
	 * @param pageSize
	 * @return
	 * @version 1.0
	 */
	public Pager getProjecsByGroupId(Map<String, Object> param, int pageNo, int pageSize);
	
	/**
	 * 得到下一个项目的评审信息
	 * @comments 
	 * @param paramMap
	 * @return
	 * @version 1.0
	 */
	public Map<String,Object> getNextProjectScore(Map<String,Object> paramMap);
	
	//wangxd end

	/**
	 * 
	 * @comments 根据分组ID查询该分组选中的专家 
	 * @param groupId
	 * @return
	 * @version 1.0
	 */
	public List<Map<String, Object>> getSelectedExpertListByGroupId(String groupId);

}
