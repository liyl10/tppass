package com.hopsun.tppas.api.contract.service.impl;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import com.hopsun.framework.base.service.impl.BaseServiceImpl;
import com.hopsun.tppas.entity.TarrangementB;
import com.hopsun.tppas.api.contract.service.TarrangementBService;
import com.hopsun.tppas.api.contract.dao.TarrangementBDao;

@Service
public class TarrangementBServiceImpl extends BaseServiceImpl<TarrangementB,String> implements TarrangementBService{
	
	@Resource
	private TarrangementBDao tarrangementBDao;
	
	@Resource
	public void setBaseDao(TarrangementBDao tarrangementBDao) {
		super.setBaseDao(tarrangementBDao);
	}
}
