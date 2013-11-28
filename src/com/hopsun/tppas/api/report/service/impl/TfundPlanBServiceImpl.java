/*************** 版权声明***************
*
* Copyright (C) 2013 西安辉盛科技发展有限责任公司.
*
********************************************
*/
package com.hopsun.tppas.api.report.service.impl;


import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.hopsun.framework.base.service.impl.BaseServiceImpl;
import com.hopsun.tppas.api.report.dao.TfundPlanBDao;
import com.hopsun.tppas.api.report.service.TfundPlanBService;
import com.hopsun.tppas.entity.TfundPlanB;

/**
 * @comments 项目投资计划
 * @author weina
 * @date 2013-9-26 @time 下午5:28:13
 * @Version 1.0
 */
@Service
public class TfundPlanBServiceImpl extends BaseServiceImpl<TfundPlanB,String> implements TfundPlanBService{
	
	
	@Resource
	public void setBaseDao(TfundPlanBDao tfundPlanBDao) {
		super.setBaseDao(tfundPlanBDao);
	}
	
	@Resource
	private TfundPlanBDao tfundPlanBDao;

	
	
	
}
