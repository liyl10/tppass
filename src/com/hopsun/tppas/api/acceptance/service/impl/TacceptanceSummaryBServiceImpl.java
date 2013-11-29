package com.hopsun.tppas.api.acceptance.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.hopsun.framework.base.service.impl.BaseServiceImpl;
import com.hopsun.tppas.api.acceptance.dao.TacceptanceSummaryBDao;
import com.hopsun.tppas.api.acceptance.service.TacceptanceSummaryBService;
import com.hopsun.tppas.entity.TacceptanceSummaryB;

@Service
public class TacceptanceSummaryBServiceImpl extends BaseServiceImpl<TacceptanceSummaryB,String> implements TacceptanceSummaryBService{
	
	@Resource
	private TacceptanceSummaryBDao tacceptanceSummaryBDao;
	
	@Resource
	public void setBaseDao(TacceptanceSummaryBDao tacceptanceSummaryBDao) {
		super.setBaseDao(tacceptanceSummaryBDao);
	}
}
