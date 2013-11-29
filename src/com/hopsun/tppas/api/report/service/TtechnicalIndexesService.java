/*************** 版权声明***************
*
* Copyright (C) 2012 西安辉盛科技发展有限责任公司.
*
********************************************
*/
package com.hopsun.tppas.api.report.service;

import com.hopsun.framework.base.service.BaseService;
import com.hopsun.tppas.entity.TtechnicalIndexes;

/**
 * @comments 项目达到的主要技术指标（非高新）
 * @author weina
 * @date 2013-9-26 @time 下午21:41:04
 * @Version 1.0
 */
public interface TtechnicalIndexesService extends BaseService<TtechnicalIndexes, String> {
	
	/**
	 * 
	 * @comments 
	 * @param ttechnicalIndexes
	 * @param userId
	 * @version 1.0
	 */
	public void saveTtechnicalIndexes(TtechnicalIndexes ttechnicalIndexes, String userId);
}
