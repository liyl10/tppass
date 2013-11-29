package com.hopsun.tppas.api.contract.service;

import java.util.List;

import com.hopsun.tppas.entity.TarrangementB;
import com.hopsun.tppas.entity.TcontractContentsB;
import com.hopsun.tppas.entity.TeconomicIndicatorsB;
import com.hopsun.tppas.entity.TprojectLeaderB;
import com.hopsun.framework.base.service.BaseService;

public interface TcontractContentsBService extends BaseService<TcontractContentsB, String> {
	/**
	 * 更新合同说明信息
	 * @comments 
	 * @param tcontractContentsB
	 * @param tcontractId
	 * @version 1.0
	 */
	public void updatetObligation(TcontractContentsB tcontractContentsB,String tcontractId);
	
	/**
	 * 更新项目总体情况及主要内容信息
	 * @comments 
	 * @param tcontractContentsB
	 * @param tprojectLeaderBList
	 * @param teconomicIndicatorsBList
	 * @param tarrangementBList
	 * @param tcontractId
	 * @version 1.0
	 */
	public void updatetContents(TcontractContentsB tcontractContentsB, 
			List<TprojectLeaderB> tprojectLeaderBList,
			TeconomicIndicatorsB teconomicIndicatorsB,
			List<TarrangementB> tarrangementBList,
			String tcontractId);
}
