/************************* 版权声明 *********************************
 *
 * Copyright (C) 2012 西安辉盛科技发展有限责任公司.
 *
 ******************************************************************
 */
package com.hopsun.tppas.api.supervisor.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.hopsun.framework.base.service.impl.BaseServiceImpl;
import com.hopsun.tppas.entity.TsupervisorInfoA;
import com.hopsun.tppas.api.supervisor.dao.TsupervisorApplyDao;
import com.hopsun.tppas.api.supervisor.service.TsupervisorApplyService;

/**
 * 
 *@comments 监理申请Service实现类
 *@author wangxiaodong
 *@date 2013-9-27
 *@version 1.0
 */
@Service
public class TsupervisorApplyServiceImpl extends BaseServiceImpl<TsupervisorInfoA,String> implements TsupervisorApplyService{
	
	@Resource
	private TsupervisorApplyDao tsupervisorApplyDao;
	
	@Resource
	public void setBaseDao(TsupervisorApplyDao tsupervisorApplyDao) {
		super.setBaseDao(tsupervisorApplyDao);
	}
}
