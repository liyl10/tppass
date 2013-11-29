package com.hopsun.tppas.api.supervisor.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.hopsun.framework.base.service.impl.BaseServiceImpl;
import com.hopsun.tppas.api.supervisor.dao.TsupervisorFundADao;
import com.hopsun.tppas.api.supervisor.service.TsupervisorFundAService;
import com.hopsun.tppas.entity.TsupervisorFundA;

@Service
public class TsupervisorFundAServiceImpl extends BaseServiceImpl<TsupervisorFundA,String> implements TsupervisorFundAService{
	
	@Resource
	private TsupervisorFundADao tsupervisorFundADao;
	
	@Resource
	public void setBaseDao(TsupervisorFundADao tsupervisorFundADao) {
		super.setBaseDao(tsupervisorFundADao);
	}
}
