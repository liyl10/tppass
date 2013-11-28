package com.hopsun.tppas.api.report.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.hopsun.framework.base.bean.Pager;
import com.hopsun.framework.base.service.impl.BaseServiceImpl;
import com.hopsun.tppas.api.report.dao.TresearcherDao;
import com.hopsun.tppas.api.report.service.TresearcherService;
import com.hopsun.tppas.entity.Tresearcher;

@Service
public class TresearcherServiceImpl extends BaseServiceImpl<Tresearcher,String> implements TresearcherService{
	
	@Resource
	private TresearcherDao tresearcherDao;
	
	@Resource
	public void setBaseDao(TresearcherDao tresearcherDao) {
		super.setBaseDao(tresearcherDao);
	}
	
	/**
	 * @Comments 分页查询
	 * @param projectId
	 * @param pageNo
	 * @param pageSize
	 * @return
	 * @Vsersion: 1.0
	 */
	public Pager find(String projectId, int pageNo, int pageSize) {
		Pager pager = tresearcherDao.find(projectId, pageNo, pageSize);
		return pager;
	}
}
