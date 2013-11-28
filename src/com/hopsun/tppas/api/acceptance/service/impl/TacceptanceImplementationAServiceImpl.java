package com.hopsun.tppas.api.acceptance.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.hopsun.framework.base.service.impl.BaseServiceImpl;
import com.hopsun.tppas.api.acceptance.dao.TacceptanceImplementationADao;
import com.hopsun.tppas.api.acceptance.service.TacceptanceImplementationAService;
import com.hopsun.tppas.entity.TacceptanceImplementationA;

@Service
public class TacceptanceImplementationAServiceImpl extends BaseServiceImpl<TacceptanceImplementationA,String> implements TacceptanceImplementationAService{
	
	@Resource
	private TacceptanceImplementationADao tacceptanceImplementationADao;
	
	@Resource
	public void setBaseDao(TacceptanceImplementationADao tacceptanceImplementationADao) {
		super.setBaseDao(tacceptanceImplementationADao);
	}
}
