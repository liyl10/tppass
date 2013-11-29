package com.hopsun.tppas.api.acceptance.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.hopsun.framework.base.service.impl.BaseServiceImpl;
import com.hopsun.tppas.api.acceptance.dao.TacceptanceExpertAuditDao;
import com.hopsun.tppas.api.acceptance.service.TacceptanceExpertAuditService;
import com.hopsun.tppas.entity.TacceptanceExpertAudit;

@Service
public class TacceptanceExpertAuditServiceImpl extends BaseServiceImpl<TacceptanceExpertAudit,String> implements TacceptanceExpertAuditService{
	
	@Resource
	private TacceptanceExpertAuditDao tacceptanceExpertAuditDao;
	
	@Resource
	public void setBaseDao(TacceptanceExpertAuditDao tacceptanceExpertAuditDao) {
		super.setBaseDao(tacceptanceExpertAuditDao);
	}
}
