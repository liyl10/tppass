/*************** 版权声明***************
*
* Copyright (C) 2013 西安辉盛科技发展有限责任公司.
*
********************************************
*/
package com.hopsun.tppas.api.reportbudget.dao;

import java.util.List;

import com.hopsun.framework.base.dao.BaseDao;
import com.hopsun.tppas.entity.TreportBudget;

/**
 * @comment 项目预申报
 * @author liush
 * @DATE: 2013-9-23 @TIME: 下午5:27:57
 * @Vsersion: 1.0
 */
public interface TreportBudgetDao extends BaseDao<TreportBudget, String>{

	/**
	 * @Comments 根据登录用户取得预申报信息
	 * @return
	 * @Vsersion: 1.0
	 */
	public List<TreportBudget> getListByUser(String userId);

}
