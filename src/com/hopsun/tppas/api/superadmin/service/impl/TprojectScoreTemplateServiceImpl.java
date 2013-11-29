package com.hopsun.tppas.api.superadmin.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.hopsun.framework.base.service.impl.BaseServiceImpl;
import com.hopsun.tppas.api.superadmin.dao.TprojectScoreTemplateDao;
import com.hopsun.tppas.api.superadmin.service.TprojectScoreTemplateService;
import com.hopsun.tppas.entity.TprojectScoreTemplate;

@Service
public class TprojectScoreTemplateServiceImpl extends BaseServiceImpl<TprojectScoreTemplate,String> implements TprojectScoreTemplateService{
	
	@Resource
	private TprojectScoreTemplateDao tprojectScoreTemplateDao;
	
	@Resource
	public void setBaseDao(TprojectScoreTemplateDao tprojectScoreTemplateDao) {
		super.setBaseDao(tprojectScoreTemplateDao);
	}
}
