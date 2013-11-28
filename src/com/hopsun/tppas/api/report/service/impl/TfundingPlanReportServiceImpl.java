package com.hopsun.tppas.api.report.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.hopsun.framework.base.service.impl.BaseServiceImpl;
import com.hopsun.tppas.entity.TfundingPlanReport;
import com.hopsun.tppas.api.contract.dao.TcontractDao;
import com.hopsun.tppas.api.report.dao.TfundingPlanReportDao;
import com.hopsun.tppas.api.report.service.TfundingPlanReportService;

@Service
public class TfundingPlanReportServiceImpl extends BaseServiceImpl<TfundingPlanReport,String> implements TfundingPlanReportService{
	
	@Resource
	private TfundingPlanReportDao tfundingPlanReportDao;
	
	@Resource
	private TcontractDao tcontractDao;
	
	@Resource
	public void setBaseDao(TfundingPlanReportDao tfundingPlanReportDao) {
		super.setBaseDao(tfundingPlanReportDao);
	}

}
