package com.hopsun.tppas.api.report.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.hopsun.framework.base.service.impl.BaseServiceImpl;
import com.hopsun.tppas.api.report.dao.TeconomicIndicatorADao;
import com.hopsun.tppas.api.report.service.TeconomicIndicatorAService;
import com.hopsun.tppas.entity.TeconomicIndicatorA;

@Service
public class TeconomicIndicatorAServiceImpl extends BaseServiceImpl<TeconomicIndicatorA,String> implements TeconomicIndicatorAService{
	
	@Resource
	private TeconomicIndicatorADao teconomicIndicatorADao;
	
	@Resource
	public void setBaseDao(TeconomicIndicatorADao teconomicIndicatorADao) {
		super.setBaseDao(teconomicIndicatorADao);
	}
}
