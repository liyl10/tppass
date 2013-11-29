/*************** 版权声明***************
*
* Copyright (C) 2012 西安辉盛科技发展有限责任公司.
*
********************************************
*/
package com.hopsun.tppas.api.report.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.hopsun.framework.base.bean.Pager;
import com.hopsun.framework.base.service.impl.BaseServiceImpl;
import com.hopsun.tppas.api.report.dao.ProjectApplicationProposalsDao;
import com.hopsun.tppas.api.report.dao.TgroupExpertRealtionDao;
import com.hopsun.tppas.api.report.dao.TprojectApplicationDao;
import com.hopsun.tppas.api.report.service.ProjectApplicationProposalsService;
import com.hopsun.tppas.api.superadmin.dao.MitemDao;
import com.hopsun.tppas.common.Constants;
import com.hopsun.tppas.entity.TgroupExpertRealtion;
import com.hopsun.tppas.entity.TprojectApplication;
import com.hopsun.tppas.view.VprojectInfo;

/**
 * @comments 联席会审核
 * @author wanglw
 * @date 2013-9-16 @time 下午2:08:54
 * @Version 1.0
 */
@Service
public class ProjectApplicationProposalsServiceImpl extends BaseServiceImpl<TprojectApplication,String> implements ProjectApplicationProposalsService{

	@Resource
	private ProjectApplicationProposalsDao projectApplicationProposalsDao;
	@Resource
	private TprojectApplicationDao tprojectApplicationDao;
	@Resource
	private TgroupExpertRealtionDao tgroupExpertRealtionDao;
	@Resource
	public void setBaseDao(ProjectApplicationProposalsDao projectApplicationProposalsDao) {
		super.setBaseDao(projectApplicationProposalsDao);
	}
	
	@Resource
	private MitemDao mitemDao;
	
	/**
	 * @comments 取得联席会审核的项目列表 
	 * @param param
	 * @param pageNo
	 * @param pageSize
	 * @return
	 * @Version 1.0
	 */
	public Pager getProposalsList(Map<String, Object> param, int pageNo, int pageSize){
		
		Pager p = projectApplicationProposalsDao.getProposalsList(param, pageNo, pageSize);
		
		if(p.getList() !=null && p.getList().size() > 0){
			List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
			
			Set<String> groupSet = new HashSet<String>();
			int num = 0;
			for (int i = 0; i < p.getList().size(); i++) {
				Object[] obj = (Object[]) p.getList().get(i);
				// 列表信息Map
				Map<String, Object> valueMap = new HashMap<String, Object>();
				
				// 项目申报表
				TprojectApplication t1 = (TprojectApplication) obj[0];
				
				// 项目ID	
				valueMap.put("projectId", t1.getProjectId().trim());
				
				// 判断是否已进行联系会审核
				// String userId = (String) param.get("userId");
				
				// 状态判断 
				/*if(Constants.PROJECT_REPORT_JOINT_PASS.equals(t1.getApplyStatus()) || 
						Constants.PROJECT_REPORT_JOINT_NOPASS.equals(t1.getApplyStatus()) ||
						(Constants.PROJECT_REPORT_JOINT_ING.equals(t1.getApplyStatus()) 
								&& !userId.equals(t1.getOptUser().trim()))){
					valueMap.put("selectedExpertFlag", "1");
				}
				else{
					valueMap.put("selectedExpertFlag", "0");
				}*/
				if(t1.getJointStatus() != null && !"".equals(t1.getJointStatus())){
					valueMap.put("selectedExpertFlag", "1");
				}
				else{
					valueMap.put("selectedExpertFlag", "0");
				}
				
				// 项目名称
				valueMap.put("projectName", t1.getProjectName());
				
				// 申报单位
				valueMap.put("applicationUnit", t1.getApplicationUnit());
				
				// 申请单位ID
				valueMap.put("userId", t1.getUserId());
				
				/*// 当前阶段
				String flowStatus = "";
				if (!isNullString(t1.getFlowStatus())){
					flowStatus = mitemDao.getItemName(t1.getFlowStatus());
				}
				valueMap.put("flowStatus", flowStatus);*/
				
				// 申报状态
				String applyStatus ="";
				if (!isNullString(t1.getApplyStatus())){
					applyStatus = mitemDao.getItemName(t1.getApplyStatus());
				}
				valueMap.put("applyStatus", applyStatus);
				
				// 项目类别
				valueMap.put("projectTypeName", t1.getPlanFlagName() + Constants.STRING_LINK + t1.getTypeName());
				
				//推荐意见
				if (!isNullString(t1.getExpertAuditRecommend())){
					String expertAuditRecommend = mitemDao.getItemName(t1.getExpertAuditRecommend());
					valueMap.put("expertAuditRecommend", expertAuditRecommend);
				}
				//意见状态
//				if (!isNullString(t1.getExpertAuditRecommend())){
//					valueMap.put("opinionStates", "已填写");
//				}
//				else{
//					valueMap.put("opinionStates", "未填写");
//				}
				if (!isNullString(t1.getExpertProofComposite())){
					if (!isNullString(t1.getExpertProofComposite().trim())){
						valueMap.put("opinionStates", "已填写");
					}
					else{
						valueMap.put("opinionStates", "未填写");
					}
				}
				else{
					valueMap.put("opinionStates", "未填写");
				}
				//技术专家平均分
				valueMap.put("projectTechnologyAverage", t1.getProjectTechnologyAverage());
				//投资专家平均分
				valueMap.put("projectInvestmentAverage", t1.getProjectInvestmentAverage());
				//技术专家推荐意见
				valueMap.put("projectTechnologyResult", t1.getProjectTechnologyResult());
				//投资专家推荐意见
				valueMap.put("projectInvestmentResult", t1.getProjectInvestmentResult());
				
				// 项目分类
				valueMap.put("typeId", t1.getTprojectType().getTypeId());
				
				
				// 项目分组
				valueMap.put("groupId", t1.getTprojectGroup().getGroupId());
				
				// 项目信息表
				VprojectInfo v1 = (VprojectInfo) obj[1];
				
				
				// 技术领域
				String technicalFisld ="";
				if (!isNullString(v1.getTechnicalFisld())){
					technicalFisld = mitemDao.getItemName(v1.getTechnicalFisld());
				}
				valueMap.put("technicalFisld", technicalFisld);
				// 第一个组
				if(i == 0){
					
					Map<String, Object> groupMap = new HashMap<String, Object>();
					// 计划类别
					// groupMap.put("groupId", t1.getTprojectGroup().getGroupId());
					
					// 计划类别名称
					groupMap.put("groupShowName", t1.getTprojectGroup().getGroupName());
					
					// 分组标识
					groupMap.put("groupName", "group" + i);
					
					num = i;
					
					groupMap.put("projectId", "");
					
					// 分组ID
					groupMap.put("groupId", t1.getTprojectGroup().getGroupId());
					
					// 判断组下面有没有专家
					groupMap.put("expertBygroup", getExpertBygroup(t1.getTprojectGroup().getGroupId()));
					
					list.add(groupMap);
					
					groupSet.add(t1.getTprojectGroup().getGroupId());
				}
				// 除过第一个组的其他组
				else{
					if(groupSet.size() > 0){
						if(!groupSet.contains(t1.getTprojectGroup().getGroupId())){
							
							Map<String, Object> groupMap = new HashMap<String, Object>();
							// 计划类别
							//groupMap.put("groupId", t1.getTprojectGroup().getGroupId());
							
							// 计划类别名称
							groupMap.put("groupShowName", t1.getTprojectGroup().getGroupName());
							
							// 分组标识
							groupMap.put("groupName", "group" + i);
							
							num = i;
							
							groupMap.put("projectId", "");
							
							// 分组ID
							groupMap.put("groupId", t1.getTprojectGroup().getGroupId());
							
							// 判断组下面有没有专家
							groupMap.put("expertBygroup", getExpertBygroup(t1.getTprojectGroup().getGroupId()));
							
							list.add(groupMap);
							
							groupSet.add(t1.getTprojectGroup().getGroupId());
						}
					}
				}
				// 分组标识
				valueMap.put("groupName", "group" + num);
				
				list.add(valueMap);
			}
			
			// 设定list集合
			p.setList(list);
		}
		
		return p;
	}
	// weina start
	/**
	 * 
	 * @comments 判断组下面有没有专家
	 * @param groupId
	 * @return
	 * @version 1.0
	 */
	public boolean getExpertBygroup(String groupId){
		List<TgroupExpertRealtion> ExpertList = tgroupExpertRealtionDao.getTgList(groupId);
		if(ExpertList != null && ExpertList.size()>0){
			return true;
		}else{
			return false;
		}
	}

	
	/**
	 * @comments 批量录入推荐意见
	 * @param projectId
	 * @param commissionerOpinion
	 * @param meetingOpinion
	 * @param projectApplyStatus
	 * @Version 1.0
	 */
	public void updateRecommendAtion(String projectId, String recommendAtion, String userId){
		String [] projectIds = projectId.split(",");
		
		for(int i=0; i< projectIds.length; i++){
			// 根据项目Id取得项目信息
			TprojectApplication tpTemp = projectApplicationProposalsDao.get(projectIds[i]);

			if (Constants.RECOMMENDATION_FAIL.equals(recommendAtion)){
				TprojectApplication tprojectApplication = new TprojectApplication();
				tprojectApplication = tprojectApplicationDao.get(projectIds[i]);
				if (tprojectApplication != null){
					tprojectApplication.setTplan(null);
				}
				tprojectApplicationDao.update(tprojectApplication);
			}
			
			//推荐意见
			tpTemp.setExpertAuditRecommend(recommendAtion);
			
			// 更新者
			tpTemp.setUpdateUser(userId);
			
			// 更新时间
			tpTemp.setUpdateTime(new java.sql.Timestamp(new java.util.Date().getTime()));
			
			// 更新		
			projectApplicationProposalsDao.update(tpTemp);
		}
		
	}
	
	/**
	 * @comments 更新其他意见
	 * @param projectId
	 * @param otherComments
	 * @Version 1.0
	 */
	public void updateOtherComments(String projectId, String otherComments, String userId){

		// 根据项目Id取得项目信息
		TprojectApplication tpTemp = projectApplicationProposalsDao.get(projectId);
		
		//其他意见
		tpTemp.setExpertProofComposite(otherComments);
		
		// 更新者
		tpTemp.setUpdateUser(userId);
		
		// 更新时间
		tpTemp.setUpdateTime(new java.sql.Timestamp(new java.util.Date().getTime()));
		
		// 更新		
		projectApplicationProposalsDao.update(tpTemp);
		
	}
	
	/**sheiga
	 * @comments 类型判断
	 * @param valueStr
	 * @return
	 * @Version 1.0
	 */
	private boolean isNullString(String valueStr) {
		if (valueStr != null && valueStr.length() > 0) {
			return false;
		} else {
			return true;
		}
	}
}

