package com.hopsun.tppas.api.superadmin.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.hopsun.framework.base.bean.Pager;
import com.hopsun.framework.base.service.impl.BaseServiceImpl;
import com.hopsun.tppas.api.superadmin.dao.TprojectReportTemplateDao;
import com.hopsun.tppas.api.superadmin.service.TprojectReportTemplateService;
import com.hopsun.tppas.entity.TprojectReportTemplate;

@Service
public class TprojectReportTemplateServiceImpl extends BaseServiceImpl<TprojectReportTemplate,String> implements TprojectReportTemplateService{
	
	@Resource
	private TprojectReportTemplateDao tprojectReportTemplateDao;
	
	@Resource
	public void setBaseDao(TprojectReportTemplateDao tprojectReportTemplateDao) {
		super.setBaseDao(tprojectReportTemplateDao);
	}
	
	/**
	 * 分页查询
	 *@param pageNumber pageSize 
	 *@return Pager
	 */
	public Pager find(String name, Integer pageNumber, Integer pageSize) {
		return tprojectReportTemplateDao.findByPager(name, pageNumber, pageSize);
	}
}
