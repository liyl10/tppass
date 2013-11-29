package com.hopsun.tppas.api.report.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.hopsun.framework.base.service.impl.BaseServiceImpl;
import com.hopsun.tppas.api.report.dao.TschedulingADao;
import com.hopsun.tppas.api.report.service.TschedulingAService;
import com.hopsun.tppas.entity.TschedulingA;

@Service
public class TschedulingAServiceImpl extends BaseServiceImpl<TschedulingA,String> implements TschedulingAService{
	
	@Resource
	private TschedulingADao tschedulingADao;
	
	@Resource
	public void setBaseDao(TschedulingADao tschedulingADao) {
		super.setBaseDao(tschedulingADao);
	}
}
