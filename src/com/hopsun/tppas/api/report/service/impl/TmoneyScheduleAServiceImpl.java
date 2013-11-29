package com.hopsun.tppas.api.report.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.hopsun.framework.base.service.impl.BaseServiceImpl;
import com.hopsun.tppas.api.report.dao.TmoneyScheduleADao;
import com.hopsun.tppas.api.report.service.TmoneyScheduleAService;
import com.hopsun.tppas.entity.TmoneyScheduleA;

@Service
public class TmoneyScheduleAServiceImpl extends BaseServiceImpl<TmoneyScheduleA,String> implements TmoneyScheduleAService{
	
	@Resource
	private TmoneyScheduleADao tmoneyScheduleADao;
	
	@Resource
	public void setBaseDao(TmoneyScheduleADao tmoneyScheduleADao) {
		super.setBaseDao(tmoneyScheduleADao);
	}
}
