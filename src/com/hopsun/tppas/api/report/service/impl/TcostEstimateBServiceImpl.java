package com.hopsun.tppas.api.report.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.hopsun.framework.base.service.impl.BaseServiceImpl;
import com.hopsun.tppas.api.report.dao.TcostEstimateBDao;
import com.hopsun.tppas.api.report.service.TcostEstimateBService;
import com.hopsun.tppas.entity.TcostEstimateB;

@Service
public class TcostEstimateBServiceImpl extends BaseServiceImpl<TcostEstimateB,String> implements TcostEstimateBService{
	
	@Resource
	private TcostEstimateBDao tcostEstimateBDao;
	
	@Resource
	public void setBaseDao(TcostEstimateBDao tcostEstimateBDao) {
		super.setBaseDao(tcostEstimateBDao);
	}
}
