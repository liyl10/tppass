package com.hopsun.tppas.api.acceptance.service;

import com.hopsun.tppas.entity.TacceptanceAccA;
import com.hopsun.framework.base.bean.Pager;
import com.hopsun.framework.base.service.BaseService;

public interface TacceptanceAccAService extends BaseService<TacceptanceAccA, String> {
	/**
	 * 分页查询
	 *@param pageNumber pageSize acceptanceId
	 *@return Pager
	 */
	public Pager find(Integer pageNumber, Integer pageSize, String acceptanceId);
}
