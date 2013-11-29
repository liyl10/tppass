package com.hopsun.tppas.api.acceptance.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.hopsun.framework.base.bean.Pager;
import com.hopsun.framework.base.service.impl.BaseServiceImpl;
import com.hopsun.tppas.api.acceptance.dao.TacceptanceAccADao;
import com.hopsun.tppas.api.acceptance.service.TacceptanceAccAService;
import com.hopsun.tppas.entity.TacceptanceAccA;

@Service
public class TacceptanceAccAServiceImpl extends BaseServiceImpl<TacceptanceAccA,String> implements TacceptanceAccAService{
	
	@Resource
	private TacceptanceAccADao tacceptanceAccADao;
	
	@Resource
	public void setBaseDao(TacceptanceAccADao tacceptanceAccADao) {
		super.setBaseDao(tacceptanceAccADao);
	}
	
	/**
	 * 分页查询
	 *@param pageNumber pageSize acceptanceId
	 *@return Pager
	 */
	public Pager find(Integer pageNumber, Integer pageSize, String acceptanceId) {
			Pager pager = tacceptanceAccADao.findByPager(pageNumber, pageSize, acceptanceId);
			
			return pager;
	}
}
