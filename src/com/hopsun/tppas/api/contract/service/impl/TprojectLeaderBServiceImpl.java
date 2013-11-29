package com.hopsun.tppas.api.contract.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.hopsun.framework.base.service.impl.BaseServiceImpl;
import com.hopsun.tppas.api.contract.dao.TprojectLeaderBDao;
import com.hopsun.tppas.api.contract.service.TprojectLeaderBService;
import com.hopsun.tppas.entity.TprojectLeaderB;

@Service
public class TprojectLeaderBServiceImpl extends BaseServiceImpl<TprojectLeaderB,String> implements TprojectLeaderBService{
	
	@Resource
	private TprojectLeaderBDao tprojectLeaderBDao;
	
	@Resource
	public void setBaseDao(TprojectLeaderBDao tprojectLeaderBDao) {
		super.setBaseDao(tprojectLeaderBDao);
	}
}
