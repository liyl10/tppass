package com.hopsun.tppas.api.superadmin.service;

import com.hopsun.tppas.entity.TprojectContractTemplate;
import com.hopsun.framework.base.bean.Pager;
import com.hopsun.framework.base.service.BaseService;

public interface TprojectContractTemplateService extends BaseService<TprojectContractTemplate, String> {
	/**
	 * 分页查询
	 *@param pageNumber pageSize 
	 *@return Pager
	 */
	public Pager find(String name, Integer pageNumber, Integer pageSize);
}
