/*************** 版权声明***************
*
* Copyright (C) 2012 西安辉盛科技发展有限责任公司.
*
********************************************
*/
package com.hopsun.tppas.api.report.service;

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
public interface ProjectApplicationProposalsService extends BaseService<TprojectApplication, String> {

	/**
	 * @comments 取得联席会审核的项目列表 
	 * @param param
	 * @param pageNo
	 * @param pageSize
	 * @return
	 * @Version 1.0
	 */
	public Pager getProposalsList(Map<String, Object> param, int pageNo, int pageSize);

	
	/**
	 * @comments 批量推荐
	 * @param projectId
	 * @param recommendAtion
	 * @Version 1.0
	 */
	public void updateRecommendAtion(String projectId, String recommendAtion, String userId);
	
	/**
	 * @comments 更新其他意见
	 * @param groupId
	 * @return
	 * @Version 1.0
	 */
	public void updateOtherComments(String projectId,String otherComments, String userId);
	
	
}

