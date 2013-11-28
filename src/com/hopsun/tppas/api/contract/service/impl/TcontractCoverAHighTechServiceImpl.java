package com.hopsun.tppas.api.contract.service.impl;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;
import com.hopsun.framework.base.service.impl.BaseServiceImpl;
import com.hopsun.tppas.common.Constants;
import com.hopsun.tppas.entity.CompanyInfoBean;
import com.hopsun.tppas.entity.TcontractCoverA;
import com.hopsun.tppas.api.contract.service.TcontractCoverAHighTechService;
import com.hopsun.tppas.api.contract.service.TcontractCoverAService;
import com.hopsun.tppas.api.contract.dao.TcontractCoverADao;
import com.hopsun.tppas.api.contract.dao.TcontractDao;
import com.hopsun.tppas.entity.Tcontract;

@Service
public class TcontractCoverAHighTechServiceImpl extends BaseServiceImpl<TcontractCoverA,String> implements TcontractCoverAHighTechService{
	
	@Resource
	private TcontractCoverADao tcontractCoverADao;
	
	@Resource
	private TcontractDao tcontractDao;
	
	@Resource
	public void setBaseDao(TcontractCoverADao tcontractCoverADao) {
		super.setBaseDao(tcontractCoverADao);
	}
	
	/**
	 * 获得封皮表的信息
	 * @comments 
	 * @param tcontractId
	 * @return
	 * @version 1.0
	 */
	public TcontractCoverA getTcontractCover(String tcontractId){
		TcontractCoverA cover = new TcontractCoverA();
		if (tcontractId != null){
			cover = tcontractCoverADao.get("tcontract.TContractId", tcontractId);
		}
		return cover;
	}
	
	/**
	 * 更新封皮表的信息
	 * @comments 
	 * @param tcontractCover
	 * @param tcontractId
	 * @return
	 * @version 1.0
	 */
	public void updatecontractCover(TcontractCoverA tcontractCover,String tcontractId){
		//存在的情况下更新
		if (tcontractCover != null 
				&& !(tcontractCover.getContractCoverId()== null
				|| ("").equals(tcontractCover.getContractCoverId()))){
			TcontractCoverA tcontractCoverA1 = tcontractCoverADao.get(tcontractCover.getContractCoverId());
			tcontractCoverA1.setAddress1(tcontractCover.getAddress1());
			tcontractCoverA1.setAddress2(tcontractCover.getAddress2());
			tcontractCoverA1.setAddress3(tcontractCover.getAddress3());
			tcontractCoverA1.setAddress(tcontractCover.getAddress());
			tcontractCoverA1.setUnitCharge(tcontractCover.getUnitCharge());
			tcontractCoverA1.setUnitChargePhone1(tcontractCover.getUnitChargePhone1());
			tcontractCoverA1.setUnitChargePhone2(tcontractCover.getUnitChargePhone2());
			tcontractCoverA1.setCharge(tcontractCover.getCharge());
			tcontractCoverA1.setChargePhone1(tcontractCover.getChargePhone1());
			tcontractCoverA1.setChargePhone2(tcontractCover.getChargePhone2());
			tcontractCoverA1.setContact(tcontractCover.getContact());
			tcontractCoverA1.setContactPhone1(tcontractCover.getContactPhone1());
			tcontractCoverA1.setContactPhone2(tcontractCover.getContactPhone2());
			tcontractCoverA1.setContractTime(tcontractCover.getContractTime());
			tcontractCoverA1.setUpdateTime(new java.sql.Timestamp(new java.util.Date().getTime()));
			tcontractCoverA1.setUpdateUser("");
			tcontractCoverADao.update(tcontractCoverA1);
		}
		else{
			if (tcontractCover != null){
				tcontractCover.setDeleteFlag(Constants.COMMON_STATE_NOTDELETE);
				tcontractCover.setCreateTime(new java.sql.Timestamp(new java.util.Date().getTime()));
				tcontractCover.setCreateUser("");
				Tcontract tcontract1 = tcontractDao.get(tcontractId);
				tcontractCover.setTcontract(tcontract1);
				tcontractCoverADao.save(tcontractCover);
			}
		}
	}
}
