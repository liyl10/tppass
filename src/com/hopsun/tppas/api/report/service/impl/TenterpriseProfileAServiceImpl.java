package com.hopsun.tppas.api.report.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.hopsun.framework.base.service.impl.BaseServiceImpl;
import com.hopsun.tppas.api.report.dao.TenterpriseProfileADao;
import com.hopsun.tppas.api.report.service.TenterpriseProfileAService;
import com.hopsun.tppas.entity.TenterpriseProfileA;

@Service
public class TenterpriseProfileAServiceImpl extends BaseServiceImpl<TenterpriseProfileA,String> implements TenterpriseProfileAService{
	
	@Resource
	private TenterpriseProfileADao tenterpriseProfileADao;
	
	@Resource
	public void setBaseDao(TenterpriseProfileADao tenterpriseProfileADao) {
		super.setBaseDao(tenterpriseProfileADao);
	}
}
