package com.hopsun.tppas.api.contract.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.hopsun.framework.base.bean.Pager;
import com.hopsun.framework.base.service.impl.BaseServiceImpl;
import com.hopsun.scenter.api.user.dao.UserDao;
import com.hopsun.scenter.entity.ScUsers;
import com.hopsun.tppas.api.contract.dao.TcontractDao;
import com.hopsun.tppas.api.contract.service.TcontractService;
import com.hopsun.tppas.api.report.dao.TprojectApplicationDao;
import com.hopsun.tppas.api.superadmin.dao.MitemDao;
import com.hopsun.tppas.api.superadmin.dao.TattachmentDao;
import com.hopsun.tppas.api.superadmin.dao.TprojectTypeDao;
import com.hopsun.tppas.api.supervisor.dao.TsupervisorDao;
import com.hopsun.tppas.entity.Tcontract;
import com.hopsun.tppas.entity.TprojectType;
import com.hopsun.tppas.common.Constants;
import com.hopsun.tppas.entity.Mitem;
import com.hopsun.tppas.entity.Tattachment;
import com.hopsun.tppas.entity.TprojectApplication;
import com.hopsun.tppas.entity.Tsupervisor;

@Service
public class TcontractServiceImpl extends BaseServiceImpl<Tcontract,String> implements TcontractService{
	
	@Resource
	private TcontractDao tcontractDao;
	
	@Resource
	private UserDao userDao;
	
	@Resource
	private MitemDao mitemDao;
	
	@Resource
	private TprojectTypeDao tprojectTypeDao;
	
	@Resource
	private TprojectApplicationDao tprojectApplicationDao;
	
	@Resource
	private TsupervisorDao tsupervisorDao;
	
	@Resource
	private TattachmentDao tattachmentDao;
	
	@Resource
	public void setBaseDao(TcontractDao tcontractDao) {
		super.setBaseDao(tcontractDao);
	}
	/**
	 * 查询待审核合同
	 * @param acceptanceStatus
	 * @return
	 */
	@Override
	public List<Tcontract> queryTacceptanceByState(String acceptanceStatus) {
		
		return tcontractDao.queryTContractListByState(acceptanceStatus);
	}
	
	/**
	 * 
	 * @comments 分页查询
	 * @param param
	 * @param pageNo
	 * @param pageSize
	 * @version 1.0
	 */
	public Pager find(Map<String,Object> param, int pageNo, int pageSize) {
		
		Pager p = tcontractDao.find(param, pageNo, pageSize);
		if (p.getList() != null && p.getList().size() != 0) {
			List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
			for (int i = 0; i < p.getList().size(); i++) {
				
				//合同管理表
				Tcontract t =(Tcontract) p.getList().get(i);
				Map<String, Object> valueMap = new HashMap<String, Object>();
				//合同id
				valueMap.put("tcontractId", t.getTContractId());
				//项目编号
				if (t.getTprojectApplication() != null){
					valueMap.put("projectNumber", t.getTprojectApplication().getProjectNumber());
				}
				// 项目名称
				valueMap.put("projectName", t.getTprojectApplication().getProjectName());
				//合同状态
				String ContractStatus = t.getContractStatus();
				if(isNotNullOrEmpty(ContractStatus)){
					if(Constants.CONTRACT_STATE_ISSUED.equals(ContractStatus)){
						ContractStatus = getMitemName(Constants.CONTRACT_STATE_ISSUED);
					}else if(Constants.CONTRACT_STATE_NOISSUED.equals(ContractStatus)){
						ContractStatus = getMitemName(Constants.CONTRACT_STATE_NOISSUED);
//					}else if(Constants.CONTRACT_STATE_SUBMIT.equals(ContractStatus)){
//						ContractStatus = getMitemName(Constants.CONTRACT_STATE_SUBMIT);
//					}else if(Constants.CONTRACT_STATE_VERIFY.equals(ContractStatus)){
//						ContractStatus = getMitemName(Constants.CONTRACT_STATE_VERIFY);
//					}else if (Constants.CONTRACT_STATE_NOTPASS_NOMODIFY.equals(ContractStatus)){	
//						ContractStatus = getMitemName(Constants.CONTRACT_STATE_NOTPASS_NOMODIFY);
					}
				}
				valueMap.put("contractStatus", ContractStatus);
				valueMap.put("contractStatus1", t.getContractStatus());
				// 申报单位
				valueMap.put("applicationUnit", t.getTprojectApplication().getApplicationUnit());
				// 合同提交时间
				valueMap.put("contractDate", t.getContractDate());
				// 项目分类
				TprojectType tprojectType = tprojectTypeDao.get(t.getTprojectApplication().getTprojectType().getParentTypeId());
				valueMap.put("tprojectTypeName", tprojectType.getTypeShowName() 
						+ Constants.STRING_LINK 
						+ t.getTprojectApplication().getTprojectType().getTypeShowName());
//				//操作时间
//				valueMap.put("updateDate", t.getUpdateDate());
//				//操作人员
//				valueMap.put("optUser", getUserName(t.getOptUser()));

				//PDF路径
				valueMap.put("pdfUrl", t.getPdfUrl());
				//小分类
				valueMap.put("typeId", t.getTprojectApplication().getTprojectType().getTypeId());
				valueMap.put("type", highOrOther(t.getTprojectApplication().getProjectId()));
				list.add(valueMap);
			}
			p.setList(list);
		}

		return p;
	}
	/**
	 * 
	 * @comments 非空判断
	 * @param value
	 * @return
	 * @version 1.0
	 */
	public boolean isNotNullOrEmpty(String value){
		if (!"".equals(value) && value != null) {
			return true;
		}
		return false;
	}
	
	/**
	 * 
	 * @comments 取得用户名字
	 * @param userId
	 * @return
	 * @version 1.0
	 */
	public String getUserName(String userId)
	{
		String userName = "";
		ScUsers scUsers = userDao.getUsersByUserId(userId);
		if (scUsers != null){
			userName = scUsers.getUserRealname();
		}
		return userName;
	}
	
	/**
	 * 
	 * @comments 取得码表里的名字
	 * @param itemId
	 * @return
	 * @version 1.0
	 */
	public String getMitemName(String itemId){
		String mitemName = "";
		Mitem mitem = mitemDao.get(itemId);
		if (mitem != null){
			mitemName = mitem.getItemName();
		}
		return mitemName;
	}

	/**
	 * 
	 * @comments 更新合同状态
	 * @param tcontractId
	 * @param userId
	 * @version 1.0
	 */
	public void updateStatus(String tcontractId, String userId){
		Tcontract tcontract = tcontractDao.get(tcontractId);
		//更新合同状态
		if (tcontract != null){
//			tcontract.setContractStatus(Constants.CONTRACT_STATE_VERIFY);
			tcontract.setUpdateTime(new java.sql.Timestamp(new java.util.Date().getTime()));
			tcontract.setOptUser(userId);
			tcontractDao.update(tcontract);

			//更新流程状态
			TprojectApplication tprojectApplication = tcontract.getTprojectApplication();
			if (tprojectApplication != null){
				tprojectApplication.setFlowStatus(Constants.FLOW_STATUS_CONTRACT_VERIFY);
				tprojectApplication.setHandleTime(new java.sql.Timestamp(new java.util.Date().getTime()));
				tprojectApplicationDao.update(tprojectApplication);
			}			
		}

	}
	
	/**
	 * 
	 * @comments 合同审核通过（合同签订）
	 * @param tcontractId
	 * @param userId
	 * @param approvalOpinion
	 * @version 1.0
	 */
	public void updateStatusOk(String tcontractId,String userId,String approvalOpinion){
		Tcontract tcontract = tcontractDao.get(tcontractId);
		if (tcontract != null){
//			tcontract.setContractStatus(Constants.CONTRACT_STATE_SIGNED);
			tcontract.setUpdateTime(new java.sql.Timestamp(new java.util.Date().getTime()));
			tcontract.setOptUser(userId);
			tcontract.setApprovalOpinion(approvalOpinion);
			tcontractDao.update(tcontract);
			//更新流程状态
			TprojectApplication tprojectApplication = tcontract.getTprojectApplication();
			if (tprojectApplication != null){
				tprojectApplication.setFlowStatus(Constants.FLOW_STATUS_SUPERVISION);
				tprojectApplication.setHandleTime(new java.sql.Timestamp(new java.util.Date().getTime()));
				tprojectApplicationDao.update(tprojectApplication);
				
				//更新监理状态
				Tsupervisor tsupervisor = tsupervisorDao.get("tprojectApplication.projectId",tprojectApplication.getProjectId());
				if (tsupervisor != null){
					tsupervisor.setDeleteFlag(Constants.COMMON_STATE_NOTDELETE);
					tsupervisor.setSupervisorState(Constants.SUPERVISOR_STATE_REPORT);
					tsupervisorDao.update(tsupervisor);
				}
			}			
		}

	}
	
	/**
	 * 
	 * @comments 合同审核不通过（可修改）
	 * @param tcontractId
	 * @param userId
	 * @param approvalOpinion
	 * @version 1.0
	 */
	public void updateStatusNo(String tcontractId,String userId,String approvalOpinion){
		Tcontract tcontract = tcontractDao.get(tcontractId);
		if (tcontract != null){
//			tcontract.setContractStatus(Constants.CONTRACT_STATE_NOTPASS_MODIFI);
			tcontract.setUpdateTime(new java.sql.Timestamp(new java.util.Date().getTime()));
			tcontract.setOptUser(userId);
			tcontract.setApprovalOpinion(approvalOpinion);
			tcontractDao.update(tcontract);
		}
	}
	
	/**
	 * 
	 * @comments 合同审核不通过（可修改）
	 * @param tcontractId
	 * @param userId
	 * @param approvalOpinion
	 * @version 1.0
	 */
	public void updateStatusNoModify(String tcontractId,String userId,String approvalOpinion){
		Tcontract tcontract = tcontractDao.get(tcontractId);
		if (tcontract != null){
//			tcontract.setContractStatus(Constants.CONTRACT_STATE_NOTPASS_NOMODIFY);
			tcontract.setUpdateTime(new java.sql.Timestamp(new java.util.Date().getTime()));
			tcontract.setOptUser(userId);
			tcontract.setApprovalOpinion(approvalOpinion);
			tcontractDao.update(tcontract);
		}
	}
	
	/**
	 * 
	 * @comments 合同下发
	 * @param tcontractId
	 * @param userId
	 * @param approvalOpinion
	 * @version 1.0
	 */
	public void updateIssuedContract(String tcontractId,String userId,String contractType){
		Tcontract tcontract = tcontractDao.get(tcontractId);
		if (tcontract != null){
//			tcontract.setContractStatus(Constants.CONTRACT_STATE_NOTPASS_NOMODIFY);
			tcontract.setUpdateTime(new java.sql.Timestamp(new java.util.Date().getTime()));
			tcontract.setContractDate(new java.sql.Timestamp(new java.util.Date().getTime()));
			tcontract.setOptUser(userId);
			tcontract.setContractType(contractType);
			tcontract.setContractStatus(Constants.CONTRACT_STATE_ISSUED);
			tcontractDao.update(tcontract);
		}
	}	
	
	/**
	 * 
	 * @comments 合同类型变更
	 * @param tcontractId
	 * @param userId
	 * @param approvalOpinion
	 * @version 1.0
	 */
	public void updateType(String tcontractId,String userId,String contractType){
		Tcontract tcontract = tcontractDao.get(tcontractId);
		if (tcontract != null){
			tcontract.setUpdateTime(new java.sql.Timestamp(new java.util.Date().getTime()));
			tcontract.setContractType(contractType);
			tcontractDao.update(tcontract);
		}
	}	
	
	
	/**
	 * 
	 * @comments 判断是高新的还是非高新的申报 
	 * @version 1.0
	 */
	public String highOrOther(String projectId){
		String highOrOtherFlag = "";
		if(projectId != null){
			TprojectApplication tprojectApplication = tprojectApplicationDao.get(projectId);
			TprojectType tprojectType = tprojectTypeDao.get(tprojectApplication.getTprojectType().getTypeId());
			
	    	if(Constants.HIGHTECH_DEPARTMENT.equals(tprojectType.getDepartmentId())){
				highOrOtherFlag = "1";
			}else{
				highOrOtherFlag = "0";
			}
		}
    	
		return highOrOtherFlag;
	}
	
	/**
	 * 
	 * @comments 合同提交时得到材料列表
	 * @param contractId
	 * @return
	 * @version 1.0
	 */
	public List<Map<String, Object>> getSubmitInfo(String contractId) {
		List<Map<String,Object>> all = new ArrayList<Map<String,Object>>();
		//合同管理信息
		Tcontract tcontract = tcontractDao.get(contractId);
		
		//合同封皮
		Map<String,Object> valueMap = new HashMap<String,Object>();
		valueMap.put("name","合同封皮");
		valueMap.put("msgKey","contract_cover_msg");
		if(tcontract.getTcontractCoverAs()!=null
				&&tcontract.getTcontractCoverAs().size()>0){
			if (tcontract.getTcontractCoverAs().get(0).getContractTime() != null){
				valueMap.put("isExist", "是");
				valueMap.put("isPass", "1");
			}
			else{
				valueMap.put("isExist", "否");
				valueMap.put("isPass", "0");
			}
		}else{
			valueMap.put("isExist", "否");
			valueMap.put("isPass", "0");
		}
		all.add(valueMap);
		
		//项目总体情况及主要内容
		valueMap = new HashMap<String,Object>();
		valueMap.put("name", "项目总体情况及主要内容");
		valueMap.put("msgKey","contract_content_msg_b");
		if(tcontract.getTcontractContentsBs()!=null
				&&tcontract.getTcontractContentsBs().size()>0){
			if (tcontract.getTcontractContentsBs().get(0).getYearValue() != null){
				valueMap.put("isExist", "是");
				valueMap.put("isPass", "1");
			}
			else{
				valueMap.put("isExist", "否");
				valueMap.put("isPass", "0");
			}
		}else{
			valueMap.put("isExist", "否");
			valueMap.put("isPass", "0");
		}
		all.add(valueMap);
		
		//项目经费计划
		valueMap = new HashMap<String,Object>();
		valueMap.put("name", "项目经费计划");
		valueMap.put("msgKey","contract_fundplan_msg");
		if(tcontract.getTfundingPlanBs()!=null&&tcontract.getTfundingPlanBs().size()>0){
			valueMap.put("isExist", "是");
			valueMap.put("isPass", "1");
		}else{
			valueMap.put("isExist", "否");
			valueMap.put("isPass", "0");
		}
		all.add(valueMap);
		
		//合同说明
		valueMap = new HashMap<String,Object>();
		valueMap.put("name", "合同说明");
		valueMap.put("msgKey","contract_fundplan_msg");
		if(tcontract.getTcontractContentsBs()!=null
				&&tcontract.getTcontractContentsBs().size()>0){
			if (tcontract.getTcontractContentsBs().get(0).getSelectTime1() != null){
				valueMap.put("isExist", "是");
				valueMap.put("isPass", "1");
			}
			else{
				valueMap.put("isExist", "否");
				valueMap.put("isPass", "0");
			}
		}else{
			valueMap.put("isExist", "否");
			valueMap.put("isPass", "0");
		}
		all.add(valueMap);
		
		//填表说明
		valueMap = new HashMap<String,Object>();
		valueMap.put("name","填表说明");
		valueMap.put("isExist", "是");
		valueMap.put("isPass", "1");
		valueMap.put("msgKey","contract_know_msg");
		all.add(valueMap);
		
		//附件清单
		Map<String,Object> paramMap = new HashMap<String,Object>();
		paramMap.put("tableName", Tcontract.class);
		paramMap.put("key1", contractId);
		List<Tattachment> attList = tattachmentDao.getAttachmentsByForeignKey(paramMap);
		valueMap = new HashMap<String,Object>();
		valueMap.put("name", "附件清单");
		valueMap.put("msgKey","contract_tattachment_msg");
		if(attList!=null&&attList.size()>0){
			valueMap.put("isExist", "是");
			valueMap.put("isPass", "1");
		}else{
			valueMap.put("isExist", "否");
			valueMap.put("isPass", "1");
		}
		all.add(valueMap);
		
		return all;
	}
}
