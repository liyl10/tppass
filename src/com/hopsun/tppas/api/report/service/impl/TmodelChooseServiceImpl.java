package com.hopsun.tppas.api.report.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.hopsun.framework.base.service.impl.BaseServiceImpl;
import com.hopsun.tppas.api.report.dao.TmodelChooseDao;
import com.hopsun.tppas.api.report.service.TmodelChooseService;
import com.hopsun.tppas.entity.TmodelChoose;

@Service
public class TmodelChooseServiceImpl extends BaseServiceImpl<TmodelChoose,String> implements TmodelChooseService{
	
	@Resource
	private TmodelChooseDao tmodelChooseDao;
	
	@Resource
	public void setBaseDao(TmodelChooseDao tmodelChooseDao) {
		super.setBaseDao(tmodelChooseDao);
	}
}
