package com.hopsun.tppas.api.report.dao;

import java.util.List;
import java.util.Map;

import com.hopsun.framework.base.bean.Pager;
import com.hopsun.framework.base.dao.BaseDao;
import com.hopsun.tppas.entity.TprojectApplication;
import com.hopsun.tppas.view.VprojectInfoAll;
/**
 * @Comments:   后台Dao接口-主要用来定义项目申报操作的接口
 * @author  yk
 * @date 2013-08-01
 * @version 1.0
 *
 */

public interface TprojectApplicationDao extends BaseDao<TprojectApplication, String>{
	/**
	 * 查询待调配项目
	 * @param applyState
	 * @return
	 */
	public List<TprojectApplication>  queryProjectApplicationByApplyState(String applyState);
	
	/**
	 * 查询待归档项目
	 * @param applyState
	 * @return
	 */
	public List<TprojectApplication>  queryProjectApplicationByFlowState(String[] flowStatus);
	
	/**
	 * 
	 * @comments 查询初审项目
	 * @param param
	 * @param pageNo
	 * @param pageSize
	 * @return
	 * @version 1.0
	 */
	public Pager  queryBeforeReviewProject(Map<String, Object> param, int pageNo, int pageSize);
	
	/**
	 * @comments 项目查询
	 * @param param
	 * @param pageNo
	 * @param pageSize
	 * @return
	 * @Version 1.0
	 */
	public Pager queryTprojectApplication(Map<String, Object> param, int pageNo, int pageSize);

	/**
	 * 
	 * @comments 根据项目ID取得项目详细信息 
	 * @param projectId
	 * @return
	 * @version 1.0
	 */
	public VprojectInfoAll queryProjectInfoAll(String projectId);

	/**
	 * 
	 * @comments 取得待调配项目List 
	 * @param param
	 * @param pageNumber
	 * @param pageSize
	 * @return
	 * @version 1.0
	 */
	public Pager queryDeployProjectList(Map<String, Object> param,
			Integer pageNumber, Integer pageSize);
	//weina start
	/**
	 * 
	 * @comments 查看分计划 
	 * @param planId
	 * @param pageNo
	 * @param pageSize
	 * @return
	 * @version 1.0
	 */
	public Pager find(String planId,int pageNo, int pageSize);
	/**
	 * 
	 * @comments 归档管理
	 * @param param
	 * @param pageNo
	 * @param pageSize
	 * @return
	 * @version 1.0
	 */
	public Pager getArchivalList(Map<String, Object> param, int pageNo, int pageSize);
	/***
	 * 
	 * @comments 项目评审通过率统计 
	 * @param param
	 * @param pageNo
	 * @param pageSize
	 * @return
	 * @version 1.0
	 */
	public List getProjectViewList(Map<String, Object> param);
	/**
	 * 
	 * @comments 查一个组下面的项目 
	 * @return
	 * @version 1.0
	 */
	public List<TprojectApplication> getProjectList(String groupId);
	/**
	 * @comments 取得年度
	 * @param param
	 * @return
	 * @Version 1.0
	 */
	public List getProjectYear(Map<String, Object> param);
	/**
	 * @comments 取得项目总数
	 * @param param
	 * @return
	 * @Version 1.0
	 */
	public int getProjectTotalCount(String year);
	/**
	 * @comments 未初审项目数
	 * @param param
	 * @return
	 * @Version 1.0
	 */
	public int getNoViewProjectTotalCount(String year);
	/**
	 * @comments 未通过项目总数
	 * @param param
	 * @return
	 * @Version 1.0
	 */
	public int getNoPassProjectCount(String year);
	/**
	 * @comments 通过为验收项目总数
	 * @param param
	 * @return
	 * @Version 1.0
	 */
	public int getNoAcceptanceProjectCount(String year);
	/**
	 * @comments 已通过已验收项目总数
	 * @param param
	 * @return
	 * @Version 1.0
	 */
	public int getPassAcceptanceProjectCount(String year);
	//weina end
	
	//wangxd start
	/**
	 * 通过条件查询项目申报信息
	 * @comments 
	 * @param param
	 * @return
	 * @version 1.0
	 */
	public List<TprojectApplication> getProjectList(Map<String, Object> param);
	
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
	//wangxd end
}
