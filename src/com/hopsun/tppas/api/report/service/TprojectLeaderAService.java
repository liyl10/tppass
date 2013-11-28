/*************** 版权声明***************
*
* Copyright (C) 2012 西安辉盛科技发展有限责任公司.
*
********************************************
*/
package com.hopsun.tppas.api.report.service;

import com.hopsun.framework.base.bean.Pager;
import com.hopsun.framework.base.service.BaseService;
import com.hopsun.tppas.entity.TprojectLeaderA;

/**
 * @comment 项目负责人及主要人员
 * @author liush
 * @DATE: 2013-9-26 @TIME: 下午9:06:41
 * @Vsersion: 1.0
 */
public interface TprojectLeaderAService extends BaseService<TprojectLeaderA, String> {
	
	/**
	 * @Comments 分页查询
	 * @param projectId
	 * @param pageNo
	 * @param pageSize
	 * @return
	 * @Vsersion: 1.0
	 */
	public Pager find(String projectId, int pageNo, int pageSize);
}
