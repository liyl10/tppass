package com.hopsun.tppas.api.acceptance.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.hopsun.framework.base.service.impl.BaseServiceImpl;
import com.hopsun.tppas.api.acceptance.dao.TacceptanceOpinionADao;
import com.hopsun.tppas.api.acceptance.service.TacceptanceOpinionAService;
import com.hopsun.tppas.entity.TacceptanceOpinionA;

@Service
public class TacceptanceOpinionAServiceImpl extends BaseServiceImpl<TacceptanceOpinionA,String> implements TacceptanceOpinionAService{
	
	@Resource
	private TacceptanceOpinionADao tacceptanceOpinionADao;
	
	@Resource
	public void setBaseDao(TacceptanceOpinionADao tacceptanceOpinionADao) {
		super.setBaseDao(tacceptanceOpinionADao);
	}
}
