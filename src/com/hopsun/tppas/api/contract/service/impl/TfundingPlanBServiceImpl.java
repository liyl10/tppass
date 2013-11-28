package com.hopsun.tppas.api.contract.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.hopsun.framework.base.service.impl.BaseServiceImpl;
import com.hopsun.tppas.api.contract.dao.TcontractDao;
import com.hopsun.tppas.api.contract.dao.TfundingPlanBDao;
import com.hopsun.tppas.api.contract.service.TfundingPlanBService;
import com.hopsun.tppas.common.Constants;
import com.hopsun.tppas.entity.Tcontract;
import com.hopsun.tppas.entity.TfundingPlanB;

@Service
public class TfundingPlanBServiceImpl extends BaseServiceImpl<TfundingPlanB,String> implements TfundingPlanBService{
	
	@Resource
	private TfundingPlanBDao tfundingPlanBDao;
	@Resource
	private TcontractDao tcontractDao;
	
	@Resource
	public void setBaseDao(TfundingPlanBDao tfundingPlanBDao) {
		super.setBaseDao(tfundingPlanBDao);
	}
	
	/**
	 * 更新项目经费计划的信息
	 * @comments 
	 * @param tfundingPlanB
	 * @param tcontractId
	 * @return
	 * @version 1.0
	 */
	public void updatetfundingPlanB(TfundingPlanB tfundingPlanB,String tcontractId){
		//存在的情况下更新
		if (tfundingPlanB != null 
				&& !(tfundingPlanB.getFundingPlanBId() == null
				|| ("").equals(tfundingPlanB.getFundingPlanBId()))){
			TfundingPlanB tfundingPlanB1 = tfundingPlanBDao.get(tfundingPlanB.getFundingPlanBId());
			//总投资
			tfundingPlanB1.setTotalInvestment1(tfundingPlanB.getTotalInvestment1());
			tfundingPlanB1.setTotalInvestment2(tfundingPlanB.getTotalInvestment2());
			tfundingPlanB1.setTotalInvestment3(tfundingPlanB.getTotalInvestment3());
			//甲方拨款
			tfundingPlanB1.setPartyFunding1(tfundingPlanB.getPartyFunding1());
			tfundingPlanB1.setPartyFunding2(tfundingPlanB.getPartyFunding2());
			tfundingPlanB1.setPartyFunding3(tfundingPlanB.getPartyFunding3());
			//单位自筹
			tfundingPlanB1.setUnitRaised1(tfundingPlanB.getUnitRaised1());
			tfundingPlanB1.setUnitRaised2(tfundingPlanB.getUnitRaised2());
			tfundingPlanB1.setUnitRaised3(tfundingPlanB.getUnitRaised3());
			//其他经费
			tfundingPlanB1.setOtherFunds1(tfundingPlanB.getOtherFunds1());
			tfundingPlanB1.setOtherFunds2(tfundingPlanB.getOtherFunds2());
			tfundingPlanB1.setOtherFunds3(tfundingPlanB.getOtherFunds3());
			//银行贷款
			tfundingPlanB1.setBankLoans1(tfundingPlanB.getBankLoans1());
			tfundingPlanB1.setBankLoans2(tfundingPlanB.getBankLoans2());
			tfundingPlanB1.setBankLoans3(tfundingPlanB.getBankLoans3());
			//设备费
			tfundingPlanB1.setEquipmentCost1(tfundingPlanB.getEquipmentCost1());
			tfundingPlanB1.setEquipmentCost2(tfundingPlanB.getEquipmentCost2());
			tfundingPlanB1.setEquipmentCost3(tfundingPlanB.getEquipmentCost3());
			//材料费
			tfundingPlanB1.setMaterialFee1(tfundingPlanB.getMaterialFee1());
			tfundingPlanB1.setMaterialFee2(tfundingPlanB.getMaterialFee2());
			tfundingPlanB1.setMaterialFee3(tfundingPlanB.getMaterialFee3());
			//测试化工费
			tfundingPlanB1.setTestFee1(tfundingPlanB.getTestFee1());
			tfundingPlanB1.setTestFee2(tfundingPlanB.getTestFee2());
			tfundingPlanB1.setTestFee3(tfundingPlanB.getTestFee3());
			//燃料动力费
			tfundingPlanB1.setFuel1(tfundingPlanB.getFuel1());
			tfundingPlanB1.setFuel2(tfundingPlanB.getFuel2());
			tfundingPlanB1.setFuel3(tfundingPlanB.getFuel3());
			//差旅调研费
			tfundingPlanB1.setTravel1(tfundingPlanB.getTravel1());
			tfundingPlanB1.setTravel2(tfundingPlanB.getTravel2());
			tfundingPlanB1.setTravel3(tfundingPlanB.getTravel3());
			//会议交流费
			tfundingPlanB1.setConferenceFees1(tfundingPlanB.getConferenceFees1());
			tfundingPlanB1.setConferenceFees2(tfundingPlanB.getConferenceFees2());
			tfundingPlanB1.setConferenceFees3(tfundingPlanB.getConferenceFees3());
			//劳务咨询费
			tfundingPlanB1.setConsultancyServices1(tfundingPlanB.getConsultancyServices1());
			tfundingPlanB1.setConsultancyServices2(tfundingPlanB.getConsultancyServices2());
			tfundingPlanB1.setConsultancyServices3(tfundingPlanB.getConsultancyServices3());
			
			tfundingPlanB1.setNetAssets(tfundingPlanB.getNetAssets());
			tfundingPlanB1.setTotalAssets(tfundingPlanB.getTotalAssets());
			tfundingPlanB1.setBusinessNet(tfundingPlanB.getBusinessNet());
			tfundingPlanB1.setAnnualSalesRevenue(tfundingPlanB.getAnnualSalesRevenue());
			tfundingPlanB1.setTotalCorporateTax(tfundingPlanB.getTotalCorporateTax());
//			tfundingPlanB.setYear(year);
			tfundingPlanB1.setUpdateTime(new java.sql.Timestamp(new java.util.Date().getTime()));
			tfundingPlanB1.setUpdateUser("");
			tfundingPlanBDao.update(tfundingPlanB1);
		}
		else{
			if (tfundingPlanB != null){
				tfundingPlanB.setDeleteFlag(Constants.COMMON_STATE_NOTDELETE);
				tfundingPlanB.setCreateTime(new java.sql.Timestamp(new java.util.Date().getTime()));
				tfundingPlanB.setCreateUser("");
	//			tfundingPlanB.setYear(year);
				Tcontract tcontract1 = tcontractDao.get(tcontractId);
				tfundingPlanB.setTcontract(tcontract1);
				tfundingPlanBDao.save(tfundingPlanB);
			}
		}
	}
}
