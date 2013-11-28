/*************** 版权声明***************
*
* Copyright (C) 2012 西安辉盛科技发展有限责任公司.
*
********************************************
*/
package com.hopsun.tppas.api.report.dao;

import java.util.List;
import java.util.Map;

import com.hopsun.framework.base.bean.Pager;
import com.hopsun.framework.base.dao.BaseDao;
import com.hopsun.tppas.entity.TprojectApplication;

/**
 * @comments 项目评审
 * @author wanglw
 * @date 2013-9-10 @time 下午4:27:57
 * @Version 1.0
 */
public interface TprojectApplicationAuditDao extends BaseDao<TprojectApplication, String>{
	
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
	public List<Object> getGroupSelectProjectList(Map<String, Object> param);
	
	
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
	 * @param ProjectId
	 * @return
	 * @Version 1.0
	 */
	public List<Object[]> getProjectInfo(String projectId);
	
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
	public List<Object> getPlanUpdateList(String planId);
	
	/**
	 * @comments 取得为选择的项目list
	 * @param param
	 * @return
	 * @Version 1.0
	 */
	public List<Object> getUnselectProjectList(Map<String, Object> param);

	/**
	 * 
	 * @comments 取得属于某个分组的所有项目
	 * @param param
	 * @param pageNumber
	 * @param pageSize
	 * @return
	 * @version 1.0
	 */
	public Pager getGroupProjectList(Map<String, Object> param, Integer pageNumber, Integer pageSize);
	/**
	 * @comments 取得为选择的项目list
	 * @param param
	 * @return
	 * @Version 1.0
	 */
	public Pager getGroupSelectProjectPager(Map<String, Object> param,Integer pageNumber, Integer pageSize);
}
