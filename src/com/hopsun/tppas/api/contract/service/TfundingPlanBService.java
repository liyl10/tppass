package com.hopsun.tppas.api.contract.service;

import com.hopsun.tppas.entity.TfundingPlanB;
import com.hopsun.framework.base.service.BaseService;

public interface TfundingPlanBService extends BaseService<TfundingPlanB, String> {
	
	/**
	 * 更新项目经费计划表
	 * @comments 
	 * @param tfundingPlanB
	 * @param tcontractId
	 * @version 1.0
	 */
	public void updatetfundingPlanB(TfundingPlanB tfundingPlanB,String tcontractId);
}
