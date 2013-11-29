package com.hopsun.tppas.api.superadmin.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.hopsun.framework.base.bean.Pager;
import com.hopsun.framework.base.service.impl.BaseServiceImpl;
import com.hopsun.tppas.api.superadmin.dao.TprojectContractTemplateDao;
import com.hopsun.tppas.api.superadmin.service.TprojectContractTemplateService;
import com.hopsun.tppas.entity.TprojectContractTemplate;

@Service
public class TprojectContractTemplateServiceImpl extends BaseServiceImpl<TprojectContractTemplate,String> implements TprojectContractTemplateService{
	
	@Resource
	private TprojectContractTemplateDao tprojectContractTemplateDao;
	
	@Resource
	public void setBaseDao(TprojectContractTemplateDao tprojectContractTemplateDao) {
		super.setBaseDao(tprojectContractTemplateDao);
	}
	
	/**
	 * 分页查询
	 *@param pageNumber pageSize 
	 *@return Pager
	 */
	public Pager find(String name, Integer pageNumber, Integer pageSize) {
		return tprojectContractTemplateDao.findByPager(name, pageNumber, pageSize);
	}
}
