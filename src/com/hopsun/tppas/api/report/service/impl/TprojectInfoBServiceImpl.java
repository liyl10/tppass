package com.hopsun.tppas.api.report.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.hopsun.framework.base.service.impl.BaseServiceImpl;
import com.hopsun.tppas.api.report.dao.TprojectInfoBDao;
import com.hopsun.tppas.api.report.service.TprojectInfoBService;
import com.hopsun.tppas.entity.TprojectInfoB;

@Service
public class TprojectInfoBServiceImpl extends BaseServiceImpl<TprojectInfoB,String> implements TprojectInfoBService{
	
	@Resource
	private TprojectInfoBDao tprojectInfoBDao;
	
	@Resource
	public void setBaseDao(TprojectInfoBDao tprojectInfoBDao) {
		super.setBaseDao(tprojectInfoBDao);
	}
}
