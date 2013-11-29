/*************** 版权声明***************
*
* Copyright (C) 2013 西安辉盛科技发展有限责任公司.
*
********************************************
*/
package com.hopsun.tppas.api.reportbudget.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.hopsun.framework.base.dao.impl.BaseDaoImpl;
import com.hopsun.tppas.api.reportbudget.dao.TreportBudgetDao;
import com.hopsun.tppas.entity.TreportBudget;

/**
 * @comment 项目预申报
 * @author liush
 * @DATE: 2013-9-23 @TIME: 下午5:30:12
 * @Vsersion: 1.0
 */
@Repository
public class TreportBudgetDaoImpl extends BaseDaoImpl<TreportBudget, String> implements TreportBudgetDao {
	   
	/**
	 * @Comments 根据登录用户取得预申报信息
	 * @return
	 * @Vsersion: 1.0
	 */
	public List<TreportBudget> getListByUser(String userId) {
		String str = "from TreportBudget t where t.userId =:userId and t.deleteFlag = 0";
		return createQueryList(str, new String[]{userId});
	}

}
