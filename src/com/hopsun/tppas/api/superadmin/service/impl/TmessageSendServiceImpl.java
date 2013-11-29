package com.hopsun.tppas.api.superadmin.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.hopsun.framework.base.service.impl.BaseServiceImpl;
import com.hopsun.tppas.api.superadmin.dao.TmessageSendDao;
import com.hopsun.tppas.api.superadmin.service.TmessageSendService;
import com.hopsun.tppas.entity.TmessageSend;

@Service
public class TmessageSendServiceImpl extends BaseServiceImpl<TmessageSend,String> implements TmessageSendService{
	
	@Resource
	private TmessageSendDao tmessageSendDao;
	
	@Resource
	public void setBaseDao(TmessageSendDao tmessageSendDao) {
		super.setBaseDao(tmessageSendDao);
	}
}
