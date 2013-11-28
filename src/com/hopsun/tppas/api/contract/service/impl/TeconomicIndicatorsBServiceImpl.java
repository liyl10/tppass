package com.hopsun.tppas.api.contract.service.impl;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import com.hopsun.framework.base.service.impl.BaseServiceImpl;
import com.hopsun.tppas.entity.TeconomicIndicatorsB;
import com.hopsun.tppas.api.contract.service.TeconomicIndicatorsBService;
import com.hopsun.tppas.api.contract.dao.TeconomicIndicatorsBDao;

@Service
public class TeconomicIndicatorsBServiceImpl extends BaseServiceImpl<TeconomicIndicatorsB,String> implements TeconomicIndicatorsBService{
	
	@Resource
	private TeconomicIndicatorsBDao teconomicIndicatorsBDao;
	
	@Resource
	public void setBaseDao(TeconomicIndicatorsBDao teconomicIndicatorsBDao) {
		super.setBaseDao(teconomicIndicatorsBDao);
	}
}
