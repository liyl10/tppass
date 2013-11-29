package com.hopsun.tppas.api.contract.service;

import com.hopsun.tppas.entity.TcontractCoverA;
import com.hopsun.framework.base.service.BaseService;

public interface TcontractCoverAHighTechService extends BaseService<TcontractCoverA, String> {
	
	/**
	 * 获得封皮表的信息
	 * @comments 
	 * @param tcontractId
	 * @return
	 * @version 1.0
	 */
	public TcontractCoverA getTcontractCover(String tcontractId);
	
	/**
	 * 
	 * @comments 
	 * @param contractCover
	 * @param tcontractId
	 * @version 1.0
	 */
	public void updatecontractCover(TcontractCoverA contractCover,String tcontractId);
}
