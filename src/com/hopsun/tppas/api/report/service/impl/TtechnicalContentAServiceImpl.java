package com.hopsun.tppas.api.report.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.hopsun.framework.base.service.impl.BaseServiceImpl;
import com.hopsun.tppas.api.report.dao.TtechnicalContentADao;
import com.hopsun.tppas.api.report.service.TtechnicalContentAService;
import com.hopsun.tppas.entity.TtechnicalContentA;

@Service
public class TtechnicalContentAServiceImpl extends BaseServiceImpl<TtechnicalContentA,String> implements TtechnicalContentAService{
	
	@Resource
	private TtechnicalContentADao ttechnicalContentADao;
	
	@Resource
	public void setBaseDao(TtechnicalContentADao ttechnicalContentADao) {
		super.setBaseDao(ttechnicalContentADao);
	}
}
