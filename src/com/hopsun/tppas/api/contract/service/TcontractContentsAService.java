package com.hopsun.tppas.api.contract.service;

import java.util.List;

import com.hopsun.tppas.entity.TcontractContentsA;
import com.hopsun.tppas.entity.TfundsPlanA;
import com.hopsun.framework.base.service.BaseService;

public interface TcontractContentsAService extends BaseService<TcontractContentsA, String> {
	/**
	 * 更新合同说明信息
	 * @comments 
	 * @param tcontractContentsA
	 * @param tcontractId
	 * @param fundsplanAList
	 * @version 1.0
	 */
	public void updatecontractContentsA(TcontractContentsA tcontractContentsA,String tcontractId,List<TfundsPlanA> fundsplanAList);
}
