/*************** 版权声明***************
*
* Copyright (C) 2013 西安辉盛科技发展有限责任公司.
*
********************************************
*/
package com.hopsun.tppas.api.reportbudget.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.hopsun.framework.base.service.impl.BaseServiceImpl;
import com.hopsun.tppas.api.reportbudget.dao.TreportBudgetDao;
import com.hopsun.tppas.api.reportbudget.service.TreportBudgetService;
import com.hopsun.tppas.entity.TreportBudget;

/**
 * @comment 项目预申报
 * @author liush
 * @DATE: 2013-9-23 @TIME: 下午5:28:36
 * @Vsersion: 1.0
 */
@Service
public class TreportBudgetServiceImpl extends BaseServiceImpl<TreportBudget,String> implements TreportBudgetService{
	
	@Resource
	private TreportBudgetDao treportBudgetDao;
	@Resource
	public void setBaseDao(TreportBudgetDao treportBudgetDao) {
		super.setBaseDao(treportBudgetDao);
	}

	/**
	 * @Comments 取得没有关联过的预申报信息
	 * @return
	 * @Vsersion: 1.0
	 */
	public List<TreportBudget> getListByUser(String userId) {
		List<TreportBudget> retList = treportBudgetDao.getListByUser(userId);
		return retList;
	}

}
