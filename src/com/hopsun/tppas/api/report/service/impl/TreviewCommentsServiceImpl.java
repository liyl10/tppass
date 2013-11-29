package com.hopsun.tppas.api.report.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.hopsun.framework.base.service.impl.BaseServiceImpl;
import com.hopsun.tppas.api.report.dao.TreviewCommentsDao;
import com.hopsun.tppas.api.report.service.TreviewCommentsService;
import com.hopsun.tppas.entity.TreviewComments;

@Service
public class TreviewCommentsServiceImpl extends BaseServiceImpl<TreviewComments,String> implements TreviewCommentsService{
	
	@Resource
	private TreviewCommentsDao treviewCommentsDao;
	
	@Resource
	public void setBaseDao(TreviewCommentsDao treviewCommentsDao) {
		super.setBaseDao(treviewCommentsDao);
	}
}
