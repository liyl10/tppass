package com.hopsun.tppas.api.report.service;

import java.util.List;
import java.util.Map;

import com.hopsun.tppas.entity.TprojectApplication;
import com.hopsun.tppas.view.VprojectInfoAll;
import com.hopsun.framework.base.bean.Pager;
import com.hopsun.framework.base.service.BaseService;
/**
 * @Comments:   后台Service接口-主要用来定义项目申报操作的接口
 * @author  yk
 * @date 2013-08-01
 * @version 1.0
 *
 */
public interface TprojectApplicationService extends BaseService<TprojectApplication, String> {
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
	 * @comments 取得项目初审数据
	 * @param param
	 * @param pageNo
	 * @param pageSize
	 * @return
	 * @Version 1.0
	 */
	public Pager getBeforeReviewProject(Map<String, Object> param, int pageNo, int pageSize);
	
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
	 * @comments 申请调配处理
	 * @param param
	 * @version 1.0
	 */
	public void updateApplyState(Map<String, Object> param);

	/**
	 * 
	 * @comments 批量初审 
	 * @param param
	 * @version 1.0
	 */
	public void updateApplyStateByList(Map<String, Object> param);
	
	
	/**
	 * 
	 * @comments 获得封皮备注
	 * @return
	 * @version 1.0
	 */
	public TprojectApplication getprojectReport();
	
	/**
	 * @comments 取得项目起止时间年度列表
	 * @param projectId
	 * @return
	 * @Version 1.0
	 */
	public List<Map<String,Object>> getStart2EndYear(String projectId);
	
	/**
	 * 
	 * @comments 根据项目ID取得项目详细信息
	 * @param projectId
	 * @return
	 * @version 1.0
	 */
	public VprojectInfoAll getProjectInfoAll(String projectId);

	/**
	 * 
	 * @comments 取得待调配项目list 
	 * @param param
	 * @param pageNumber
	 * @param pageSize
	 * @return
	 * @version 1.0
	 */
	public Pager getDeployProjectList(Map<String, Object> param,
			Integer pageNumber, Integer pageSize);

	/**
	 * 
	 * @comments 项目调配处理 
	 * @param param
	 * @version 1.0
	 */
	public void updateDeployProject(Map<String, Object> param);
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
	/**
	 * 
	 * @comments 项目评审通过率统计
	 * @param param
	 * @param pageNo
	 * @param pageSize
	 * @return
	 * @version 1.0
	 */
	public List<TprojectApplication> getProjectViewList(Map<String, Object> param);
	/**
	 * 
	 * @comments 查一个组里面的项目
	 * @param groupId
	 * @return
	 * @version 1.0
	 */
	public List<TprojectApplication> getProjectList(String groupId);
	/**
	 * 
	 * @comments 批量归档 
	 * @param param
	 * @version 1.0
	 */
	public void updatearchivalStateByList(Map<String, Object> param);
	
	/**
	 * 通过条件查询项目申报信息
	 * @comments 
	 * @param param
	 * @return
	 * @version 1.0
	 */
	public List<TprojectApplication> getProjectList(Map<String, Object> param);
}
