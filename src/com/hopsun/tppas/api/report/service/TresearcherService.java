package com.hopsun.tppas.api.report.service;

import com.hopsun.tppas.entity.Tresearcher;
import com.hopsun.framework.base.bean.Pager;
import com.hopsun.framework.base.service.BaseService;

public interface TresearcherService extends BaseService<Tresearcher, String> {
	/**
	 * @Comments 分页查询
	 * @param projectId
	 * @param pageNo
	 * @param pageSize
	 * @return
	 * @Vsersion: 1.0
	 */
	public Pager find(String projectId, int pageNo, int pageSize);
}
