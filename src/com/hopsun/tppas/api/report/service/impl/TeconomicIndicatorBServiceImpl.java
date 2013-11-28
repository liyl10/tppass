package com.hopsun.tppas.api.report.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.hopsun.framework.base.service.impl.BaseServiceImpl;
import com.hopsun.tppas.api.report.dao.TeconomicIndicatorBDao;
import com.hopsun.tppas.api.report.service.TeconomicIndicatorBService;
import com.hopsun.tppas.entity.TeconomicIndicatorB;

@Service
public class TeconomicIndicatorBServiceImpl extends BaseServiceImpl<TeconomicIndicatorB,String> implements TeconomicIndicatorBService{
	
	@Resource
	private TeconomicIndicatorBDao teconomicIndicatorBDao;
	
	@Resource
	public void setBaseDao(TeconomicIndicatorBDao teconomicIndicatorBDao) {
		super.setBaseDao(teconomicIndicatorBDao);
	}
}
