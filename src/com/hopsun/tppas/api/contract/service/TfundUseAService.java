package com.hopsun.tppas.api.contract.service;

import com.hopsun.tppas.entity.TfundUseA;
import com.hopsun.framework.base.service.BaseService;

public interface TfundUseAService extends BaseService<TfundUseA, String> {
	/**
	 * 
	 * @comments 保存项目经费使用表的信息
	 * @param tfunduse
	 * @param TcontractId
	 * @version 1.0
	 */
	public void updatefundUse(TfundUseA tfunduseA,String TcontractId);
}
