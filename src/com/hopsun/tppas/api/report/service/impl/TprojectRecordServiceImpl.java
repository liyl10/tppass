package com.hopsun.tppas.api.report.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.hopsun.framework.base.service.impl.BaseServiceImpl;
import com.hopsun.tppas.api.report.dao.TprojectRecordDao;
import com.hopsun.tppas.api.report.service.TprojectRecordService;
import com.hopsun.tppas.entity.TprojectRecord;

@Service
public class TprojectRecordServiceImpl extends BaseServiceImpl<TprojectRecord,String> implements TprojectRecordService{
	
	@Resource
	private TprojectRecordDao tprojectRecordDao;
	
	@Resource
	public void setBaseDao(TprojectRecordDao tprojectRecordDao) {
		super.setBaseDao(tprojectRecordDao);
	}
}
