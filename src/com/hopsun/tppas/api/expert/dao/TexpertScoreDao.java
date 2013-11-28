/*************** 版权声明***************
*
* Copyright (C) 2012 西安辉盛科技发展有限责任公司.
*
********************************************
*/
package com.hopsun.tppas.api.expert.dao;

import java.util.List;
import java.util.Map;

import com.hopsun.framework.base.bean.Pager;
import com.hopsun.framework.base.dao.BaseDao;
import com.hopsun.tppas.entity.TexpertScore;

/**
 * @comments 专家评分
 * @author wanglw
 * @date 2013-9-12 @time 下午3:50:18
 * @Version 1.0
 */
public interface TexpertScoreDao extends BaseDao<TexpertScore, String>{
	
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
	 * @comments 取得已选择的专家信息
	 * @param param
	 * @param pageNo
	 * @param pageSize
	 * @return
	 * @Version 1.0
	 */
	public Pager getBatchSelectedExpertList(Map<String, Object> param, int pageNo, int pageSize);
	
	
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
	 * @comments 根据项目Id、专家ID取得专家评分信息 
	 * @param expertId
	 * @param projectId
	 * @return
	 * @Version 1.0
	 */
	public TexpertScore getTexpertScore(String expertId, String projectId);
	
	/**
	 * @comments 取得专家评审数
	 * @param param
	 * @return
	 * @Version 1.0
	 */
	public int getExpertAuditCount(Map<String, Object> param);
	
	/**
	 * @comments 根据项目ID取得专家评分List
	 * @param projectId
	 * @return
	 * @Version 1.0
	 */
	public List<TexpertScore> getTexpertScoreList(String projectId);
	
	/**
	 * 通过组打印专家评审数据
	 * @comments 
	 * @param valueMap
	 * @return
	 * @version 1.0
	 */
	public List<Object[]> printExpertScoreByGroup(String groupId);
	// wanglw End
	/**
	 * @comments 专家评审列表
	 * @param param
	 * @param pageNo
	 * @param pageSize
	 * @return
	 * @Version 1.0
	 */
	public Pager getAuditList(Map<String, Object> param, int pageNo, int pageSize);
	

	
}
