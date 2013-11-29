package com.hopsun.tppas.api.report.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.hopsun.framework.base.service.impl.BaseServiceImpl;
import com.hopsun.tppas.api.report.dao.TcompanyFoundationBDao;
import com.hopsun.tppas.api.report.service.TcompanyFoundationBService;
import com.hopsun.tppas.entity.TcompanyFoundationB;

@Service
public class TcompanyFoundationBServiceImpl extends BaseServiceImpl<TcompanyFoundationB,String> implements TcompanyFoundationBService{
	
	@Resource
	private TcompanyFoundationBDao tcompanyFoundationBDao;
	
	@Resource
	public void setBaseDao(TcompanyFoundationBDao tcompanyFoundationBDao) {
		super.setBaseDao(tcompanyFoundationBDao);
	}
}
