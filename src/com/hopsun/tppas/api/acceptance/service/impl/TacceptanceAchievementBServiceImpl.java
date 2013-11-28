package com.hopsun.tppas.api.acceptance.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.hopsun.framework.base.service.impl.BaseServiceImpl;
import com.hopsun.tppas.api.acceptance.dao.TacceptanceAchievementBDao;
import com.hopsun.tppas.api.acceptance.service.TacceptanceAchievementBService;
import com.hopsun.tppas.entity.TacceptanceAchievementB;

@Service
public class TacceptanceAchievementBServiceImpl extends BaseServiceImpl<TacceptanceAchievementB,String> implements TacceptanceAchievementBService{
	
	@Resource
	private TacceptanceAchievementBDao tacceptanceAchievementBDao;
	
	@Resource
	public void setBaseDao(TacceptanceAchievementBDao tacceptanceAchievementBDao) {
		super.setBaseDao(tacceptanceAchievementBDao);
	}
}
