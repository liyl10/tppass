package com.hopsun.tppas.api.acceptance.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.hopsun.framework.base.service.impl.BaseServiceImpl;
import com.hopsun.tppas.api.acceptance.dao.TacceptanceFundsADao;
import com.hopsun.tppas.api.acceptance.service.TacceptanceFundsAService;
import com.hopsun.tppas.entity.TacceptanceFundsA;

@Service
public class TacceptanceFundsAServiceImpl extends BaseServiceImpl<TacceptanceFundsA,String> implements TacceptanceFundsAService{
	
	@Resource
	private TacceptanceFundsADao tacceptanceFundsADao;
	
	@Resource
	public void setBaseDao(TacceptanceFundsADao tacceptanceFundsADao) {
		super.setBaseDao(tacceptanceFundsADao);
	}
}
