/*************** 版权声明***************
*
* Copyright (C) 2012 西安辉盛科技发展有限责任公司.
*
********************************************
*/
package com.hopsun.tppas.api.statistics.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.hopsun.framework.base.bean.Pager;
import com.hopsun.framework.base.service.impl.BaseServiceImpl;
import com.hopsun.tppas.api.statistics.dao.VprojectResultCollectDao;
import com.hopsun.tppas.api.statistics.service.VprojectResultCollectService;
import com.hopsun.tppas.api.superadmin.dao.TprojectTypeDao;
import com.hopsun.tppas.common.Constants;
import com.hopsun.tppas.entity.TprojectType;
import com.hopsun.tppas.view.VprojectResultCollect;

/**
 * 
 *@comments 项目结果汇总service实现类
 *@author liyilin
 *@date 2013-8-22
 *@version 1.0
 */
@Service
public class VprojectResultCollectServiceImpl extends
		BaseServiceImpl<VprojectResultCollect, String> implements
		VprojectResultCollectService {

	@Resource
	private VprojectResultCollectDao vprojectResultCollectDao;
	
	@Resource
	private TprojectTypeDao  tprojectTypeDao;

	@Resource
	public void setBaseDao(VprojectResultCollectDao vprojectResultCollectDao) {
		super.setBaseDao(vprojectResultCollectDao);
	}

	/**
	 * @comments 分页查询
	 * @param param
	 * @param pageNo
	 * @param pageSize
	 * @return
	 * @Version 1.0
	 */
	public Pager find(Map<String, Object> param, int pageNo, int pageSize) {

		Pager pager = vprojectResultCollectDao.find(param, pageNo, pageSize);

		return pager;
	}

	/**
	 * @comments 判断字符串是否为空
	 * @param obj
	 * @return
	 * @Version 1.0
	 */
	private Boolean isNullOrEmpty(Object obj) {
		if (obj == null  || "".equals(obj)) {
			return true;
		}
		return false;
	}

	/**
	 * @comments 取得导出数据
	 * @param param
	 * @return
	 * @Version 1.0
	 */
	public List<Object> getExportDatas(Map<String, Object> param) {
		List<Object> list = new ArrayList<Object>();
		
		return list;
	}

	@Override
	public List<Object> getTableInfo(String[] tableName) {
		return null;
	}

	/**
	 * 取得申报年度List
	 */
	@Override
	public List<String> getReportYearList() {
		List<String> reportYearList = new ArrayList<String>();
		reportYearList = vprojectResultCollectDao.getReportYearList();
		return reportYearList;
	}

	/**
	 * 根据检索条件取得所有的查询结果
	 */
	@Override
	public Map<String, List<VprojectResultCollect>> getAllResultData(Map<String, Object> inputParams) {
		Map<String, List<VprojectResultCollect>> allResultData = new HashMap<String,List<VprojectResultCollect>>();
		Map<String, Object> params = new HashMap<String, Object>();
		params.putAll(inputParams);
		// 用户所在部门ID
		String userDeptId = params.get("userDeptId").toString();
		// 是否为计财处用户
		Boolean isPlanningDept = Constants.PLANNING_DEPARTMENT.equals(userDeptId);
		// 计财处用户登录时，以业务部门为单位进行统计
		if(isPlanningDept){
			// 判断参数中的"selectedDeptId",选择了部门的时候，
			// 先查询该部门下的计划类别，以计划类别为单位导出
			if (params.containsKey("selectedDeptId")
					&& null != params.get("selectedDeptId").toString()
					&& !"".equals(params.get("selectedDeptId").toString())){
				// ========2013/09/26 start=========
				List<TprojectType> projectTypeList = tprojectTypeDao
						.getFatherProjectTypeListByDeptId(params.get(
								"selectedDeptId").toString());
				if (projectTypeList != null && projectTypeList.size() > 0) {
					for (TprojectType tprojectType : projectTypeList) {
						params.put("parentProjectType",
								tprojectType.getTypeId());
						List<VprojectResultCollect> list = vprojectResultCollectDao
								.getAllResultData(params);
						allResultData.put(tprojectType.getTypeId(), list);
					}
				}
				
				// ========2013/09/26 end=========
				//List<VprojectResultCollect> list = vprojectResultCollectDao.getAllResultData(params);
				//allResultData.put(params.get("selectedDeptId").toString(), list);
			}
			// 没有选择部门的时候，先取得所有的部门，再根据部门分别取得各个部门下的项目
			else {
				List<String> deptList = this.getDeptList(params);
				for (int i = 0; i < deptList.size(); i++) {
					List<VprojectResultCollect> list = new ArrayList<VprojectResultCollect>();
					params.put("selectedDeptId", deptList.get(i).toString());
					list = vprojectResultCollectDao.getAllResultData(params);
					// 一览数据
					allResultData.put(deptList.get(i).toString(), list);
				}
			}
		}
		// 业务部门的用户登录时，以子分类为单位进行统计
		else{
			// 取得二级分类
			String sonProjectType = null;
			if(params.containsKey("sonProjectType") && null != params.get("sonProjectType")){
				sonProjectType = params.get("sonProjectType").toString();
			}
			
			// 项目分类第二级没有选择的时候，先查询出第一级包含的二级分类，
			// 然后遍历二级分类，查询每个二级分类下的项目
			if(isNullOrEmpty(sonProjectType)){
				List<String>  groupInfo = this.getGroupInfo(params);
				
				for (int i = 0; i < groupInfo.size(); i++) {
					List<VprojectResultCollect> list = new ArrayList<VprojectResultCollect>();
					params.put("sonProjectType", groupInfo.get(i).toString());
					list = vprojectResultCollectDao.getAllResultData(params);
					// 一览数据
					allResultData.put(groupInfo.get(i).toString(), list);
				}
			}
			// 项目分类第二级已经选择的时候，直接查询该二级分类下的项目
			// 然后遍历二级分类，查询每个二级分类下的项目
			else{
				List<VprojectResultCollect> list = vprojectResultCollectDao.getAllResultData(params);
				allResultData.put(params.get("sonProjectType").toString(), list);
			}
		}

		return allResultData;
	}

	/**
	 * 
	 * @comments 取得业务部门的部门idList
	 * @param params
	 * @return
	 * @version 1.0
	 */
	@Override
	public List<String> getDeptList(Map<String, Object> params) {
		return vprojectResultCollectDao.getDeptList(params);
	}

	/**
	 * 查询条件只选择了一级项目分类时，查询该一级分类下的子分类个数 
	 */
	@Override
	public int getGroupCount(Map<String, Object> params) {
		return vprojectResultCollectDao.getGroupCount(params);
	}
	
	/**
	 * 查询子分类ID
	 */
	public List<String> getGroupInfo(Map<String, Object> params) {
		return vprojectResultCollectDao.getGroupInfo(params);
	}

	/**
	 * 取得业务部门的部门下计划类别List
	 */
	@Override
	public List<String> getProjectTypeListByDeptId(Map<String, Object> params) {

		return vprojectResultCollectDao.getProjectTypeListByDeptId(params);
	}



}
