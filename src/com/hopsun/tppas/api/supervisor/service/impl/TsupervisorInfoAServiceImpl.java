package com.hopsun.tppas.api.supervisor.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.hopsun.framework.base.service.impl.BaseServiceImpl;
import com.hopsun.tppas.api.supervisor.dao.TsupervisorInfoADao;
import com.hopsun.tppas.api.supervisor.service.TsupervisorInfoAService;
import com.hopsun.tppas.entity.TsupervisorInfoA;

@Service
public class TsupervisorInfoAServiceImpl extends BaseServiceImpl<TsupervisorInfoA,String> implements TsupervisorInfoAService{
	
	@Resource
	private TsupervisorInfoADao tsupervisorInfoADao;
	
	@Resource
	public void setBaseDao(TsupervisorInfoADao tsupervisorInfoADao) {
		super.setBaseDao(tsupervisorInfoADao);
	}
}
