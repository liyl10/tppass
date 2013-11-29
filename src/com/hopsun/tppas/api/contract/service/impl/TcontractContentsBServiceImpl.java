package com.hopsun.tppas.api.contract.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.hopsun.framework.base.service.impl.BaseServiceImpl;
import com.hopsun.tppas.api.contract.dao.TcontractContentsBDao;
import com.hopsun.tppas.api.contract.dao.TcontractDao;
import com.hopsun.tppas.api.contract.dao.TeconomicIndicatorsBDao;
import com.hopsun.tppas.api.contract.dao.TprojectLeaderBDao;
import com.hopsun.tppas.api.contract.service.TcontractContentsBService;
import com.hopsun.tppas.common.Constants;
import com.hopsun.tppas.entity.TarrangementB;
import com.hopsun.tppas.entity.Tcontract;
import com.hopsun.tppas.entity.TcontractContentsB;
import com.hopsun.tppas.entity.TeconomicIndicatorsB;
import com.hopsun.tppas.entity.TprojectLeaderB;

@Service
public class TcontractContentsBServiceImpl extends BaseServiceImpl<TcontractContentsB,String> implements TcontractContentsBService{
	
	@Resource
	private TcontractContentsBDao tcontractContentsBDao;
	
	@Resource
	private TcontractDao tcontractDao;
	@Resource
	private TprojectLeaderBDao tprojectLeaderBDao;
	@Resource
	private TeconomicIndicatorsBDao teconomicIndicatorsBDao;
	
	
	@Resource
	public void setBaseDao(TcontractContentsBDao tcontractContentsBDao) {
		super.setBaseDao(tcontractContentsBDao);
	}
	
	/**
	 * 更新合同说明信息
	 * @comments 
	 * @param tcontractContentsB
	 * @param tcontractId
	 * @version 1.0
	 */
	public void updatetObligation(TcontractContentsB tcontractContentsB,String tcontractId){
		//存在的情况下更新
		if (tcontractContentsB != null 
				&& !(tcontractContentsB.getContractContentsBId()== null
				|| ("").equals(tcontractContentsB.getContractContentsBId()))){
			TcontractContentsB tcontractContentsB1 = tcontractContentsBDao.get(tcontractContentsB.getContractContentsBId());
			tcontractContentsB1.setBank(tcontractContentsB.getBank());
			tcontractContentsB1.setBankAccount(tcontractContentsB.getBankAccount());
			tcontractContentsB1.setSelectTime1(tcontractContentsB.getSelectTime1());
			tcontractContentsB1.setSelectTime2(tcontractContentsB.getSelectTime2());
			tcontractContentsB1.setSelectTime3(tcontractContentsB.getSelectTime3());
			tcontractContentsB1.setUpdateTime(new java.sql.Timestamp(new java.util.Date().getTime()));
			tcontractContentsB1.setUpdateUser("");
			tcontractContentsBDao.update(tcontractContentsB1);
		}
		else{
			if (tcontractContentsB != null){
				tcontractContentsB.setDeleteFlag(Constants.COMMON_STATE_NOTDELETE);
				tcontractContentsB.setCreateTime(new java.sql.Timestamp(new java.util.Date().getTime()));
				tcontractContentsB.setCreateUser("");
				Tcontract tcontract1 = tcontractDao.get(tcontractId);
				tcontractContentsB.setTcontract(tcontract1);
				tcontractContentsBDao.save(tcontractContentsB);
			}
		}
	}
	
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
			String tcontractId){
		//合同内容存在的情况下更新
		if (tcontractContentsB != null 
				&& !(tcontractContentsB.getContractContentsBId()== null
				|| ("").equals(tcontractContentsB.getContractContentsBId()))){
			TcontractContentsB tcontractContentsB1 = tcontractContentsBDao.get(tcontractContentsB.getContractContentsBId());
//			//年度
//			tcontractContentsB1.setYearValue(tcontractContentsB.getYearValue());
//			//计划
//			tcontractContentsB1.setPlanValue(tcontractContentsB.getPlanValue());
			//科研经费
			tcontractContentsB1.setResearchFunding(tcontractContentsB.getResearchFunding());
			//主要协作单位
			tcontractContentsB1.setCollaborationUnit(tcontractContentsB.getCollaborationUnit());
			//研究内容
			tcontractContentsB1.setResearch(tcontractContentsB.getResearch());
			//拟达到的技术指标
			tcontractContentsB1.setTechnicalSpecifications(tcontractContentsB.getTechnicalSpecifications());
			//社会效益
			tcontractContentsB1.setSocial(tcontractContentsB.getSocial());
			//项目新申请及授权专利（或著作权）证书   申请
			tcontractContentsB1.setCertificateApplication(tcontractContentsB.getCertificateApplication());
			//项目新申请及授权专利（或著作权）证书   授权
			tcontractContentsB1.setCertificateAuthorize(tcontractContentsB.getCertificateAuthorize());
			//样机（系统）
			tcontractContentsB1.setPrototype(tcontractContentsB.getPrototype());
			//论文
			tcontractContentsB1.setThesis(tcontractContentsB.getThesis());
			//项目新获得技术、产品鉴定证书 
			tcontractContentsB1.setCertificateAuthenticity(tcontractContentsB.getCertificateAuthenticity());
			//科技成果登记 
			tcontractContentsB1.setResultsRegistration(tcontractContentsB.getResultsRegistration());
			//其他
			tcontractContentsB1.setOther(tcontractContentsB.getOther());
			//项目实施阶段安排
			tcontractContentsB1.setArrangement(tcontractContentsB.getArrangement());
			//项目预期成果形态
			tcontractContentsB1.setResultsForm(tcontractContentsB.getResultsForm());
			tcontractContentsB1.setUpdateTime(new java.sql.Timestamp(new java.util.Date().getTime()));
			tcontractContentsB1.setUpdateUser("");
			tcontractContentsBDao.update(tcontractContentsB1);
		}
		//不存在的情况下新增
		else{
			if (tcontractContentsB != null){
				tcontractContentsB.setDeleteFlag(Constants.COMMON_STATE_NOTDELETE);
				tcontractContentsB.setCreateTime(new java.sql.Timestamp(new java.util.Date().getTime()));
				tcontractContentsB.setCreateUser("");
				Tcontract tcontract1 = tcontractDao.get(tcontractId);
				tcontractContentsB.setTcontract(tcontract1);
				tcontractContentsBDao.save(tcontractContentsB);
			}
		}		
		
		//更新项目负责人及主要人员
		if(tprojectLeaderBList !=null && tprojectLeaderBList.size() >0){
			for(TprojectLeaderB tprojectLeaderB : tprojectLeaderBList){
				
				if(tprojectLeaderB != null){
					// 更新
					if(tprojectLeaderB.getProjectLeaderBId() != null && !"".equals(tprojectLeaderB.getProjectLeaderBId())){
						
						if(tprojectLeaderB.getName() !=null && !"".equals(tprojectLeaderB.getName())){
						
							TprojectLeaderB tprojectLeaderBTemp = tprojectLeaderBDao.get(tprojectLeaderB.getProjectLeaderBId());
							// 名称
							tprojectLeaderBTemp.setName(tprojectLeaderB.getName());
							// 性别
							tprojectLeaderBTemp.setSex(tprojectLeaderB.getSex());
							// 年龄
							tprojectLeaderBTemp.setAge(tprojectLeaderB.getAge());
							//职务职称
							tprojectLeaderBTemp.setJobTitle(tprojectLeaderB.getJobTitle());
							//从事专业
							tprojectLeaderBTemp.setSpecialty(tprojectLeaderB.getSpecialty());
							//承担任务
							tprojectLeaderBTemp.setTask(tprojectLeaderB.getTask());
							//所在单位
							tprojectLeaderBTemp.setUnit(tprojectLeaderB.getUnit());
							// 更新时间
							tprojectLeaderBTemp.setUpdateTime(new java.sql.Timestamp(new java.util.Date().getTime()));
							tprojectLeaderBTemp.setUpdateUser("");
							tprojectLeaderBDao.update(tprojectLeaderBTemp);
						}
						else{
							tprojectLeaderBDao.delete(tprojectLeaderB.getProjectLeaderBId());
						}
					}
					// 新增
					else{
						if(tprojectLeaderB.getName() !=null && !"".equals(tprojectLeaderB.getName())){
							Tcontract tcontract = tcontractDao.get(tcontractId);
							// 设置外键关联关系
							tprojectLeaderB.setTcontract(tcontract);
							// 创建时间
							tprojectLeaderB.setCreateTime(new java.sql.Timestamp(new java.util.Date().getTime()));
							// 更新时间
							tprojectLeaderB.setCreateUser("");
							// 删除区分
							tprojectLeaderB.setDeleteFlag(Constants.COMMON_STATE_NOTDELETE);
							tprojectLeaderBDao.save(tprojectLeaderB);
						}
					}
				}
			}
		}
		
		// 删除动态的项目主要人员情况
//		if(tprojectLeaderBList != null && delCapitalIdList.size() >0){
//			for(String capitalId : delCapitalIdList){
//				if(capitalId !=null){
//					tcapitalExpendituresXmDao.delete(capitalId);
//				}
//			}
//		}
		//更新拟达到的经济指标
		if (teconomicIndicatorsB != null 
				&& !(teconomicIndicatorsB.getEconomicIndicatorsBId()== null
				|| ("").equals(teconomicIndicatorsB.getEconomicIndicatorsBId()))){
			TeconomicIndicatorsB teconomicIndicatorsB1 = teconomicIndicatorsBDao.get(teconomicIndicatorsB.getEconomicIndicatorsBId());
			//销售收入
			teconomicIndicatorsB1.setOutputValue(teconomicIndicatorsB.getOutputValue());
			teconomicIndicatorsB1.setOutputValue1(teconomicIndicatorsB.getOutputValue1());
			teconomicIndicatorsB1.setOutputValue2(teconomicIndicatorsB.getOutputValue2());
			//新增税金
			teconomicIndicatorsB1.setPayTaxes(teconomicIndicatorsB.getPayTaxes());
			teconomicIndicatorsB1.setPayTaxes1(teconomicIndicatorsB.getPayTaxes1());
			teconomicIndicatorsB1.setPayTaxes2(teconomicIndicatorsB.getPayTaxes2());
			//新增利润
			teconomicIndicatorsB1.setRetainedProfits(teconomicIndicatorsB.getRetainedProfits());
			teconomicIndicatorsB1.setRetainedProfits1(teconomicIndicatorsB.getRetainedProfits1());
			teconomicIndicatorsB1.setRetainedProfits2(teconomicIndicatorsB.getRetainedProfits2());
			//创汇
			teconomicIndicatorsB1.setEarnMoney(teconomicIndicatorsB.getEarnMoney());
			teconomicIndicatorsB1.setEarnMoney1(teconomicIndicatorsB.getEarnMoney1());
			teconomicIndicatorsB1.setEarnMoney2(teconomicIndicatorsB.getEarnMoney2());
			//合计
			teconomicIndicatorsB1.setTotalOutputValue(teconomicIndicatorsB.getTotalOutputValue());
			teconomicIndicatorsB1.setTotalPayTaxes(teconomicIndicatorsB.getTotalPayTaxes());
			teconomicIndicatorsB1.setTotalRetainedProfits(teconomicIndicatorsB.getTotalRetainedProfits());
			teconomicIndicatorsB1.setTotalEarnMoney(teconomicIndicatorsB.getTotalEarnMoney());
			teconomicIndicatorsB1.setUpdateTime(new java.sql.Timestamp(new java.util.Date().getTime()));
			teconomicIndicatorsB1.setUpdateUser("");
			teconomicIndicatorsBDao.update(teconomicIndicatorsB1);
		}
		//不存在的情况下新增
		else{
			tcontractContentsB.setDeleteFlag(Constants.COMMON_STATE_NOTDELETE);
			tcontractContentsB.setCreateTime(new java.sql.Timestamp(new java.util.Date().getTime()));
			tcontractContentsB.setCreateUser("");
			Tcontract tcontract1 = tcontractDao.get(tcontractId);
			tcontractContentsB.setTcontract(tcontract1);
			tcontractContentsBDao.save(tcontractContentsB);
		}		
		
	}
}
