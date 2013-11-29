package com.hopsun.tppas.api.contract.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.hopsun.framework.base.service.impl.BaseServiceImpl;
import com.hopsun.tppas.api.contract.dao.TcontractDao;
import com.hopsun.tppas.api.contract.dao.TfundUseADao;
import com.hopsun.tppas.api.contract.service.TfundUseAService;
import com.hopsun.tppas.common.Constants;
import com.hopsun.tppas.entity.Tcontract;
import com.hopsun.tppas.entity.TfundUseA;

@Service
public class TfundUseAServiceImpl extends BaseServiceImpl<TfundUseA,String> implements TfundUseAService{
	
	@Resource
	private TfundUseADao tfundUseADao;
	@Resource
	private TcontractDao tcontractDao;
	
	@Resource
	public void setBaseDao(TfundUseADao tfundUseADao) {
		super.setBaseDao(tfundUseADao);
	}
	
	/**
	 * 
	 * @comments 保存项目经费使用表的信息
	 * @param tfunduse
	 * @param TcontractId
	 * @version 1.0
	 */
	public void updatefundUse(TfundUseA tfunduse ,String TContractId){
		// 更新
		if(tfunduse.getFundUseId() !=null && !"".equals(tfunduse.getFundUseId())){
			TfundUseA tfunduse1 = tfundUseADao.get(tfunduse.getFundUseId());
			if (tfunduse1 != null)
			{
				tfunduse.setCreateTime(tfunduse1.getCreateTime());
			}
			tfundUseADao.evict(tfunduse1);
			tfunduse.setDeleteFlag(Constants.COMMON_STATE_NOTDELETE);
			Tcontract tcontract = tcontractDao.get(TContractId);
			tfunduse.setTcontract(tcontract);
			tfunduse.setUpdateTime(new java.sql.Timestamp(new java.util.Date().getTime()));
			tfunduse.setUpdateUser("");
			tfundUseADao.update(tfunduse);
		}
		else
		{
			tfunduse.setDeleteFlag(Constants.COMMON_STATE_NOTDELETE);
			Tcontract tcontract = tcontractDao.get(TContractId);
			tfunduse.setTcontract(tcontract);
			tfunduse.setCreateTime(new java.sql.Timestamp(new java.util.Date().getTime()));
			tfunduse.setCreateUser("");
			tfundUseADao.save(tfunduse);		
		}
	}
}
