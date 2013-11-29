package com.hopsun.tppas.api.report.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.hopsun.framework.base.service.impl.BaseServiceImpl;
import com.hopsun.tppas.api.report.dao.TreportAbstractBDao;
import com.hopsun.tppas.api.report.service.TreportAbstractBService;
import com.hopsun.tppas.entity.TreportAbstractB;

@Service
public class TreportAbstractBServiceImpl extends BaseServiceImpl<TreportAbstractB,String> implements TreportAbstractBService{
	
	@Resource
	private TreportAbstractBDao treportAbstractBDao;
	
	@Resource
	public void setBaseDao(TreportAbstractBDao treportAbstractBDao) {
		super.setBaseDao(treportAbstractBDao);
	}
}
