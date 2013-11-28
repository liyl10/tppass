package com.hopsun.tppas.api.contract.service.impl;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import com.hopsun.framework.base.service.impl.BaseServiceImpl;
import com.hopsun.tppas.entity.Tcontract;
import com.hopsun.tppas.api.contract.service.TcontractHighTechService;
import com.hopsun.tppas.api.contract.dao.TcontractCoverADao;
import com.hopsun.tppas.api.contract.dao.TcontractDao;
import com.hopsun.tppas.api.contract.dao.TfundsPlanADao;
import com.hopsun.tppas.api.contract.dao.TprojectLeaderBDao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.log4j.Logger;

import com.hopsun.tppas.common.CommonTool;
import com.hopsun.tppas.common.Constants;
import com.hopsun.tppas.entity.Tattachment;
import com.hopsun.tppas.entity.TcontractCoverA;
import com.hopsun.tppas.entity.TprojectApplication;
import com.hopsun.tppas.entity.Tsupervisor;
import com.hopsun.tppas.api.report.dao.TprojectApplicationDao;
import com.hopsun.tppas.api.report.dao.TprojectInfoBDao;
import com.hopsun.tppas.api.superadmin.dao.MitemDao;
import com.hopsun.tppas.api.superadmin.dao.TattachmentDao;
import com.hopsun.tppas.api.supervisor.dao.TsupervisorDao;


@Service
public class TcontractHighTechServiceImpl extends BaseServiceImpl<Tcontract,String> implements TcontractHighTechService{
	
	public final static Logger logger = Logger.getLogger(TcontractHighTechServiceImpl.class.getName());
	
	@Resource
	private TcontractDao tcontractDao;
	
	@Resource
	private TcontractCoverADao tcontractCoverADao;
	
	@Resource
	private TattachmentDao tattachmentDao;
	
	@Resource
	private TprojectLeaderBDao tprojectLeaderBDao;
	
	@Resource
	private MitemDao mitemDao;
	
	@Resource
	private TprojectApplicationDao tprojectApplicationDao;
	
	@Resource
	private TprojectInfoBDao tprojectInfoBDao;
	
	@Resource
	private TfundsPlanADao fundsPlanADao;
	
	@Resource
	private TsupervisorDao tsupervisorDao;
	
	@Resource
	public void setBaseDao(TcontractDao tcontractDao) {
		super.setBaseDao(tcontractDao);
	}
	
//	/**
//	 * 
//	 * @comments 更新合同状态
//	 * @param tcontractId
//	 * @return
//	 * @version 1.0
//	 */
//	public void updateStatus(String tcontractId){
//		Tcontract tcontract = tcontractDao.get(tcontractId);
//		if (tcontract != null) {
//			if (tcontract.getContractStatus() != null
//					&& !"".equals(tcontract.getContractStatus())) {
//				if (Constants.CONTRACT_STATE_ISSUED.equals(tcontract
//						.getContractStatus()) || 
//					Constants.CONTRACT_STATE_NOTPASS_MODIFI.equals(tcontract.getContractStatus())) {
//					tcontract.setContractStatus(Constants.CONTRACT_STATE_WRITE);
//					tcontract.setUpdateTime(new java.sql.Timestamp(
//							new java.util.Date().getTime()));
//					tcontractDao.update(tcontract);
//				}
//			}
//		}
//	}
	
	/**
	 * 
	 * @comments 根据合同id查询合同管理表
	 * @param tcontractId
	 * @return
	 * @version 1.0
	 */
	public TcontractCoverA getTcontractCover(String TcontractId){
		TcontractCoverA tcontract = tcontractCoverADao.get(TcontractId);
		
		
		if (tcontract != null){

			tcontract.setCentralizedManagement(mitemDao.getItemName(tcontract.getCentralizedManagement()));
		}
		return tcontract;
	}

	/**
	 * 
	 * @comments 取得合同管理表的信息
	 * @param TcontractId
	 * @return
	 * @version 1.0
	 */
	 public Tcontract getTcontract(String TcontractId){
		 Tcontract tcontract = new Tcontract();
		 if (CommonTool.IsNotEmpty(TcontractId)){
			 tcontract = tcontractDao.get(TcontractId);
		 }
		 return tcontract;
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
			valueMap.put("name",mitemDao.getItemName(Constants.CONTRACT_MENU_01));
			valueMap.put("msgKey","contract_cover_msg");
			if(tcontract.getTcontractCoverAs()!=null
					&&tcontract.getTcontractCoverAs().size()>0
					&& (tcontract.getTcontractCoverAs().get(0).getContractTime()!=null)){
				valueMap.put("isExist", "是");
				valueMap.put("isPass", "1");
			}else{
				valueMap.put("isExist", "否");
				valueMap.put("isPass", "0");
			}
			all.add(valueMap);
			
			//合同内容
			valueMap = new HashMap<String,Object>();
			valueMap.put("name", mitemDao.getItemName(Constants.CONTRACT_MENU_02));
			valueMap.put("msgKey","contract_content_msg");
			if(tcontract.getTcontractContentsAs()!=null&&tcontract.getTcontractContentsAs().size()>0
					&& "0".equals(tcontract.getTcontractContentsAs().get(0).getDeleteFlag())){
				valueMap.put("isExist", "是");
				valueMap.put("isPass", "1");
			}else{
				valueMap.put("isExist", "否");
				valueMap.put("isPass", "0");
			}
			all.add(valueMap);
			
			//项目经费使用
			valueMap = new HashMap<String,Object>();
			valueMap.put("name", mitemDao.getItemName(Constants.CONTRACT_MENU_03));
			valueMap.put("msgKey","contract_funds_msg");
			if(tcontract.getTfundUseAs()!=null&&tcontract.getTfundUseAs().size()>0){
				valueMap.put("isExist", "是");
				valueMap.put("isPass", "1");
			}else{
				valueMap.put("isExist", "否");
				valueMap.put("isPass", "0");
			}
			all.add(valueMap);
			
			//说明
			valueMap = new HashMap<String,Object>();
			valueMap.put("name",mitemDao.getItemName(Constants.CONTRACT_MENU_04));
			valueMap.put("isExist", "是");
			valueMap.put("isPass", "1");
			valueMap.put("msgKey","contract_explain_msg");
			all.add(valueMap);
			
			//附件清单
			Map<String,Object> paramMap = new HashMap<String,Object>();
			paramMap.put("tableName", Tcontract.class);
			paramMap.put("key1", contractId);
			List<Tattachment> attList = tattachmentDao.getAttachmentsByForeignKey(paramMap);
			valueMap = new HashMap<String,Object>();
			valueMap.put("name", mitemDao.getItemName(Constants.CONTRACT_MENU_05));
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
//				tcontract.setContractStatus(Constants.CONTRACT_STATE_VERIFY);
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
//				tcontract.setContractStatus(Constants.CONTRACT_STATE_SIGNED);
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
//				tcontract.setContractStatus(Constants.CONTRACT_STATE_NOTPASS_MODIFI);
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
//				tcontract.setContractStatus(Constants.CONTRACT_STATE_NOTPASS_NOMODIFY);
				tcontract.setUpdateTime(new java.sql.Timestamp(new java.util.Date().getTime()));
				tcontract.setOptUser(userId);
				tcontract.setApprovalOpinion(approvalOpinion);
				tcontractDao.update(tcontract);
			}
		}
		
}
