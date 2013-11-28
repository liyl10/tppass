package com.hopsun.tppas.api.contract.service.impl;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import com.hopsun.framework.base.service.impl.BaseServiceImpl;
import com.hopsun.tppas.entity.TfundsPlanA;
import com.hopsun.tppas.api.contract.service.TfundsPlanAService;
import com.hopsun.tppas.api.contract.dao.TfundsPlanADao;

@Service
public class TfundsPlanAServiceImpl extends BaseServiceImpl<TfundsPlanA,String> implements TfundsPlanAService{
	
	@Resource
	private TfundsPlanADao tfundsPlanADao;
	
	@Resource
	public void setBaseDao(TfundsPlanADao tfundsPlanADao) {
		super.setBaseDao(tfundsPlanADao);
	}
}
