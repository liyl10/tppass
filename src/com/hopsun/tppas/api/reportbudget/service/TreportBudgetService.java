/*************** 版权声明***************
*
* Copyright (C) 2013 西安辉盛科技发展有限责任公司.
*
********************************************
*/
package com.hopsun.tppas.api.reportbudget.service;

import java.util.List;

import com.hopsun.framework.base.service.BaseService;
import com.hopsun.tppas.entity.TreportBudget;

/**
 * 
 * @comment 项目预申报
 * @author liush
 * @DATE: 2013-9-23 @TIME: 下午5:28:18
 * @Vsersion: 1.0
 */
public interface TreportBudgetService extends BaseService<TreportBudget, String> {
	
	/**
	 * @Comments 取得预申报信息
	 * @return
	 * @Vsersion: 1.0
	 */
	public List<TreportBudget> getListByUser(String userId);

}
