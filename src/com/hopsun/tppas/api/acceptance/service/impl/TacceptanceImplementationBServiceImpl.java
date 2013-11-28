package com.hopsun.tppas.api.acceptance.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.hopsun.framework.base.service.impl.BaseServiceImpl;
import com.hopsun.tppas.api.acceptance.dao.TacceptanceImplementationBDao;
import com.hopsun.tppas.api.acceptance.service.TacceptanceImplementationBService;
import com.hopsun.tppas.entity.TacceptanceImplementationB;

@Service
public class TacceptanceImplementationBServiceImpl extends BaseServiceImpl<TacceptanceImplementationB,String> implements TacceptanceImplementationBService{
	
	@Resource
	private TacceptanceImplementationBDao tacceptanceImplementationBDao;
	
	@Resource
	public void setBaseDao(TacceptanceImplementationBDao tacceptanceImplementationBDao) {
		super.setBaseDao(tacceptanceImplementationBDao);
	}
}
