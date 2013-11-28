/*************** 版权声明***************
*
* Copyright (C) 2012 西安辉盛科技发展有限责任公司.
*
********************************************
*/
package com.hopsun.tppas.api.report.service;

import com.hopsun.tppas.entity.TexpectedResults;
import com.hopsun.framework.base.service.BaseService;

/**
 * @comments 预期成果（非高新）
 * @author weina
 * @date 2013-9-26 @time 下午21:41:04
 * @Version 1.0
 */
public interface TexpectedResultsService extends BaseService<TexpectedResults, String> {
	
	/**
	 * 
	 * @comments 
	 * @param texpectedResults
	 * @param userId
	 * @version 1.0
	 */
	public void saveTexpectedResults(TexpectedResults texpectedResults, String userId);
}
