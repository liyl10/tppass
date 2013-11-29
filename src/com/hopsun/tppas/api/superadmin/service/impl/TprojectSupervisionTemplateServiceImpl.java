package com.hopsun.tppas.api.superadmin.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.hopsun.framework.base.bean.Pager;
import com.hopsun.framework.base.service.impl.BaseServiceImpl;
import com.hopsun.tppas.api.superadmin.dao.TprojectSupervisionTemplateDao;
import com.hopsun.tppas.api.superadmin.service.TprojectSupervisionTemplateService;
import com.hopsun.tppas.entity.TprojectSupervisionTemplate;

@Service
public class TprojectSupervisionTemplateServiceImpl extends BaseServiceImpl<TprojectSupervisionTemplate,String> implements TprojectSupervisionTemplateService{
	
	@Resource
	private TprojectSupervisionTemplateDao tprojectSupervisionTemplateDao;
	
	@Resource
	public void setBaseDao(TprojectSupervisionTemplateDao tprojectSupervisionTemplateDao) {
		super.setBaseDao(tprojectSupervisionTemplateDao);
	}
	
	/**
	 * 分页查询
	 *@param pageNumber pageSize 
	 *@return Pager
	 */
	public Pager find(String name, Integer pageNumber, Integer pageSize) {
		return tprojectSupervisionTemplateDao.findByPager(name, pageNumber, pageSize);
	}
}
