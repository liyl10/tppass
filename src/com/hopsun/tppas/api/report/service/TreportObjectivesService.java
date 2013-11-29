/*************** 版权声明***************
*
* Copyright (C) 2012 西安辉盛科技发展有限责任公司.
*
********************************************
*/
package com.hopsun.tppas.api.report.service;


import com.hopsun.framework.base.service.BaseService;
import com.hopsun.tppas.entity.TreportObjectives;

/**
 * @comments 项目实施目标
 * @author weina
 * @date 2013-9-28 @time 下午6:28:47
 * @Version 1.0
 */
public interface TreportObjectivesService extends BaseService<TreportObjectives, String> {
	/**
	 * 
	 * @comments 保存 
	 * @param treportObjectives
	 * @param userId
	 * @version 1.0
	 */
	public void saveTreportObjectives(TreportObjectives treportObjectives,String projectId,String userId);
}
