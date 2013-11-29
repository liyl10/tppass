package com.hopsun.tppas.api.contract.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.hopsun.framework.base.service.impl.BaseServiceImpl;
import com.hopsun.tppas.api.contract.dao.TcontractContentsADao;
import com.hopsun.tppas.api.contract.dao.TcontractDao;
import com.hopsun.tppas.api.contract.dao.TfundsPlanADao;
import com.hopsun.tppas.api.contract.service.TcontractContentsAService;
import com.hopsun.tppas.common.Constants;
import com.hopsun.tppas.entity.Tcontract;
import com.hopsun.tppas.entity.TcontractContentsA;
import com.hopsun.tppas.entity.TfundsPlanA;

@Service
public class TcontractContentsAServiceImpl extends BaseServiceImpl<TcontractContentsA,String> implements TcontractContentsAService{
	
	@Resource
	private TcontractContentsADao tcontractContentsADao;
	@Resource
	private TfundsPlanADao tfundsPlanADao;
	@Resource
	private TcontractDao tcontractDao;
	
	@Resource
	public void setBaseDao(TcontractContentsADao tcontractContentsADao) {
		super.setBaseDao(tcontractContentsADao);
	}
	
	/**
	 * 
	 * @comments 保存合同内容信息和资金到位计划
	 * @param tcontractContents
	 * @param tcontractId
	 * @param fundsplanList
	 * @return
	 * @version 1.0
	 */
	public void updatecontractContentsA(TcontractContentsA tcontractContentsA,String tcontractId,List<TfundsPlanA> fundsplanAList){
		// 更新
		if(!Constants.COMMON_STATE_DEFAULT.equals(tcontractContentsA.getDeleteFlag())){
			TcontractContentsA contents = tcontractContentsADao.get("contractContentsId",tcontractContentsA.getContractContentsId());
	    	if(contents != null)
	    	{
		    	tcontractContentsA.setCreateTime(contents.getCreateTime());
	    	}
	    	tcontractContentsA.setUpdateTime(new java.sql.Timestamp(new java.util.Date().getTime()));
	    	tcontractContentsA.setUpdateUser("");
	    	tcontractContentsA.setDeleteFlag(Constants.COMMON_STATE_NOTDELETE);
	    	//清除session
	    	tcontractContentsADao.evict(contents);
	    	//
	        Tcontract tcontract = tcontractDao.get(tcontractId);
	    	tcontractContentsA.setTcontract(tcontract);
	    	//更新合同内容表
	    	tcontractContentsADao.update(tcontractContentsA);
	    	
	    	//更新资金到位计划
	    	if (fundsplanAList != null)
			{
				for (int i = 0 ;i < fundsplanAList.size();i++)
				{
					TfundsPlanA tfunds = fundsplanAList.get(i);
					tfunds.setDeleteFlag(Constants.COMMON_STATE_NOTDELETE);
					tfunds.setTcontractContentsA(tcontractContentsA);
					tfunds.setUpdateTime(new java.sql.Timestamp(new java.util.Date().getTime()));
					tfundsPlanADao.update(tfunds);
				}
			}
		}
		//新增
	    else
    	{
	    	TcontractContentsA contents = tcontractContentsADao.get("contractContentsId",tcontractContentsA.getContractContentsId());
	    	if(contents != null)
	    	{
		    	tcontractContentsA.setCreateTime(contents.getCreateTime());
	    	}
	    	//清除session
	    	tcontractContentsADao.evict(contents);
	    	
	    	tcontractContentsA.setCreateTime(new java.sql.Timestamp(new java.util.Date().getTime()));
	    	tcontractContentsA.setCreateUser("");
	    	tcontractContentsA.setDeleteFlag(Constants.COMMON_STATE_NOTDELETE);
	    	//
	        Tcontract tcontract = tcontractDao.get(tcontractId);
	    	tcontractContentsA.setTcontract(tcontract);
	    	//更新合同内容表
	    	tcontractContentsADao.update(tcontractContentsA);
	    	List<TfundsPlanA> list = new ArrayList<TfundsPlanA>();
	    	list = tfundsPlanADao.getList("tcontractContentsA.contractContentsId", tcontractContentsA.getContractContentsId());
	    	if (list.size() > 0){
		    	//更新资金到位计划
		    	if (fundsplanAList != null)
				{
					for (int i = 0 ;i < fundsplanAList.size();i++)
					{
						TfundsPlanA tfunds = fundsplanAList.get(i);
						tfunds.setDeleteFlag(Constants.COMMON_STATE_NOTDELETE);
						tfunds.setTcontractContentsA(tcontractContentsA);
						tfunds.setUpdateTime(new java.sql.Timestamp(new java.util.Date().getTime()));
						tfundsPlanADao.update(tfunds);
					}
				}
	    	}
	    	else{
	    		//新增资金到位计划
		    	if (fundsplanAList != null)
				{
					for (int i = 0 ;i < fundsplanAList.size();i++)
					{
						TfundsPlanA tfunds = fundsplanAList.get(i);
						tfunds.setDeleteFlag(Constants.COMMON_STATE_NOTDELETE);
						tfunds.setTcontractContentsA(tcontractContentsA);
						tfunds.setCreateTime(new java.sql.Timestamp(new java.util.Date().getTime()));
						tfundsPlanADao.save(tfunds);
					}
				}
	    	}
	    	
    	}
	}
}
