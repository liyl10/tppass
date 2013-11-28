package com.hopsun.tppas.api.report.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.hopsun.framework.base.service.impl.BaseServiceImpl;
import com.hopsun.tppas.api.report.dao.TcompanyNeedBDao;
import com.hopsun.tppas.api.report.service.TcompanyNeedBService;
import com.hopsun.tppas.entity.TcompanyNeedB;

@Service
public class TcompanyNeedBServiceImpl extends BaseServiceImpl<TcompanyNeedB,String> implements TcompanyNeedBService{
	
	@Resource
	private TcompanyNeedBDao tcompanyNeedBDao;
	
	@Resource
	public void setBaseDao(TcompanyNeedBDao tcompanyNeedBDao) {
		super.setBaseDao(tcompanyNeedBDao);
	}
}
