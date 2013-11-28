package com.hopsun.tppas.api.acceptance.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.hopsun.framework.base.service.impl.BaseServiceImpl;
import com.hopsun.tppas.api.acceptance.dao.TacceptanceCompleteADao;
import com.hopsun.tppas.api.acceptance.service.TacceptanceCompleteAService;
import com.hopsun.tppas.entity.TacceptanceCompleteA;

@Service
public class TacceptanceCompleteAServiceImpl extends BaseServiceImpl<TacceptanceCompleteA,String> implements TacceptanceCompleteAService{
	
	@Resource
	private TacceptanceCompleteADao tacceptanceCompleteADao;
	
	@Resource
	public void setBaseDao(TacceptanceCompleteADao tacceptanceCompleteADao) {
		super.setBaseDao(tacceptanceCompleteADao);
	}
}
