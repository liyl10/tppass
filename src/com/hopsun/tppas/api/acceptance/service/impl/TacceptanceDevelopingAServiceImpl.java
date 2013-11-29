package com.hopsun.tppas.api.acceptance.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.hopsun.framework.base.service.impl.BaseServiceImpl;
import com.hopsun.tppas.api.acceptance.dao.TacceptanceDevelopingADao;
import com.hopsun.tppas.api.acceptance.service.TacceptanceDevelopingAService;
import com.hopsun.tppas.entity.TacceptanceDevelopingA;

@Service
public class TacceptanceDevelopingAServiceImpl extends BaseServiceImpl<TacceptanceDevelopingA,String> implements TacceptanceDevelopingAService{
	
	@Resource
	private TacceptanceDevelopingADao tacceptanceDevelopingADao;
	
	@Resource
	public void setBaseDao(TacceptanceDevelopingADao tacceptanceDevelopingADao) {
		super.setBaseDao(tacceptanceDevelopingADao);
	}
}
