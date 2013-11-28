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
import com.hopsun.tppas.entity.TprojectApplication;

/**
 * @comments 联席会审核
 * @author wanglw
 * @date 2013-9-16 @time 下午2:01:51
 * @Version 1.0
 */
public interface TprojectApplicationJointService extends BaseService<TprojectApplication, String> {

	/**
	 * @comments 取得联席会审核的项目列表 
	 * @param param
	 * @param pageNo
	 * @param pageSize
	 * @return
	 * @Version 1.0
	 */
	public Pager getJointAuditList(Map<String, Object> param, int pageNo, int pageSize);
	
	
	/**
	 * @comments 联席会审核中
	 * @param projectId
	 * @Version 1.0
	 */
	public void updateApplyStatus(String projectId, String userId);
	
	/**
	 * @comments 联席会审核结果
	 * @param tprojectApplication
	 * @param projectApplyStatus
	 * @Version 1.0
	 */
	public void updateApplyStatus(TprojectApplication tprojectApplication, 
			String projectApplyStatus, String userId);
	
	/**
	 * @comments 联席会批量审核结果 
	 * @param projectId
	 * @param commissionerOpinion
	 * @param meetingOpinion
	 * @param projectApplyStatus
	 * @Version 1.0
	 */
	public void updateBatchApplyStatus(String projectId, String commissionerOpinion,
			String meetingOpinion, String projectApplyStatus, String userId);
	
	/**
	 * @comments 根据分组Id取得项目List
	 * @param groupId
	 * @return
	 * @Version 1.0
	 */
	public List<TprojectApplication> getProjectListByGroupId(String groupId);
}

