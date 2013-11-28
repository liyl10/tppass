package com.hopsun.tppas.api.report.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.hopsun.framework.base.service.impl.BaseServiceImpl;
import com.hopsun.tppas.api.report.dao.TprojectOverviewADao;
import com.hopsun.tppas.api.report.service.TprojectOverviewAService;
import com.hopsun.tppas.entity.TprojectOverviewA;

@Service
public class TprojectOverviewAServiceImpl extends BaseServiceImpl<TprojectOverviewA,String> implements TprojectOverviewAService{
	
	@Resource
	private TprojectOverviewADao tprojectOverviewADao;
	
	@Resource
	public void setBaseDao(TprojectOverviewADao tprojectOverviewADao) {
		super.setBaseDao(tprojectOverviewADao);
	}
}
