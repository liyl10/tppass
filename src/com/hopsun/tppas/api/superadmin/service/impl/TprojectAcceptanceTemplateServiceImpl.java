package com.hopsun.tppas.api.superadmin.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.hopsun.framework.base.bean.Pager;
import com.hopsun.framework.base.service.impl.BaseServiceImpl;
import com.hopsun.tppas.api.superadmin.dao.TprojectAcceptanceTemplateDao;
import com.hopsun.tppas.api.superadmin.service.TprojectAcceptanceTemplateService;
import com.hopsun.tppas.entity.TprojectAcceptanceTemplate;

@Service
public class TprojectAcceptanceTemplateServiceImpl extends BaseServiceImpl<TprojectAcceptanceTemplate,String> implements TprojectAcceptanceTemplateService{
	
	@Resource
	private TprojectAcceptanceTemplateDao tprojectAcceptanceTemplateDao;
	
	@Resource
	public void setBaseDao(TprojectAcceptanceTemplateDao tprojectAcceptanceTemplateDao) {
		super.setBaseDao(tprojectAcceptanceTemplateDao);
	}
	
	/**
	 * 分页查询
	 *@param pageNumber pageSize 
	 *@return Pager
	 */
	public Pager find(String name, Integer pageNumber, Integer pageSize) {
		return tprojectAcceptanceTemplateDao.findByPager(name, pageNumber, pageSize);
	}
}
