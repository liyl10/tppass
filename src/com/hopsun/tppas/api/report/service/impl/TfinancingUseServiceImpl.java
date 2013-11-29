package com.hopsun.tppas.api.report.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.hopsun.framework.base.service.impl.BaseServiceImpl;
import com.hopsun.tppas.api.report.dao.TfinancingUseDao;
import com.hopsun.tppas.api.report.service.TfinancingUseService;
import com.hopsun.tppas.entity.TfinancingUse;

@Service
public class TfinancingUseServiceImpl extends BaseServiceImpl<TfinancingUse,String> implements TfinancingUseService{
	
	@Resource
	private TfinancingUseDao tfinancingUseDao;
	
	@Resource
	public void setBaseDao(TfinancingUseDao tfinancingUseDao) {
		super.setBaseDao(tfinancingUseDao);
	}
}
