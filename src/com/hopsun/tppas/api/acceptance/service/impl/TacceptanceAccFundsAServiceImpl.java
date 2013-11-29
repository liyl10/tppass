package com.hopsun.tppas.api.acceptance.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.hopsun.framework.base.service.impl.BaseServiceImpl;
import com.hopsun.tppas.api.acceptance.dao.TacceptanceAccFundsADao;
import com.hopsun.tppas.api.acceptance.service.TacceptanceAccFundsAService;
import com.hopsun.tppas.entity.TacceptanceAccFundsA;

@Service
public class TacceptanceAccFundsAServiceImpl extends BaseServiceImpl<TacceptanceAccFundsA,String> implements TacceptanceAccFundsAService{
	
	@Resource
	private TacceptanceAccFundsADao tacceptanceAccFundsADao;
	
	@Resource
	public void setBaseDao(TacceptanceAccFundsADao tacceptanceAccFundsADao) {
		super.setBaseDao(tacceptanceAccFundsADao);
	}
}
