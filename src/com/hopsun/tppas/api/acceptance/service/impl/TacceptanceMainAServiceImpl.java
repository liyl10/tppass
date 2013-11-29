package com.hopsun.tppas.api.acceptance.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.hopsun.framework.base.bean.Pager;
import com.hopsun.framework.base.service.impl.BaseServiceImpl;
import com.hopsun.tppas.api.acceptance.dao.TacceptanceMainADao;
import com.hopsun.tppas.api.acceptance.service.TacceptanceMainAService;
import com.hopsun.tppas.entity.TacceptanceMainA;

@Service
public class TacceptanceMainAServiceImpl extends BaseServiceImpl<TacceptanceMainA,String> implements TacceptanceMainAService{
	
	@Resource
	private TacceptanceMainADao tacceptanceMainADao;
	
	@Resource
	public void setBaseDao(TacceptanceMainADao tacceptanceMainADao) {
		super.setBaseDao(tacceptanceMainADao);
	}
	
	/**
	 * 分页查询
	 *@param pageNumber pageSize acceptanceId
	 *@return Pager
	 */
	public Pager find(Integer pageNumber, Integer pageSize, String acceptanceId) {
			Pager pager = tacceptanceMainADao.findByPager(pageNumber, pageSize, acceptanceId);
			
			return pager;
	}
}
