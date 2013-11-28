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
import com.hopsun.tppas.api.report.dao.TgroupExpertRealtionDao;
import com.hopsun.tppas.api.report.dao.TprojectApplicationJointDao;
import com.hopsun.tppas.api.report.service.TprojectApplicationJointService;
import com.hopsun.tppas.api.superadmin.dao.MitemDao;
import com.hopsun.tppas.api.superadmin.dao.TexpertReviewCommentsDao;
import com.hopsun.tppas.common.Constants;
import com.hopsun.tppas.entity.TexpertReviewComments;
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
public class TprojectApplicationJointServiceImpl extends BaseServiceImpl<TprojectApplication,String> implements TprojectApplicationJointService{

	@Resource
	private TprojectApplicationJointDao tprojectApplicationJointDao;
	@Resource
	private TgroupExpertRealtionDao tgroupExpertRealtionDao;
	/**专家评估模板DAO*/
	@Resource
	private TexpertReviewCommentsDao texpertReviewCommentsDao;
	@Resource
	public void setBaseDao(TprojectApplicationJointDao tprojectApplicationJointDao) {
		super.setBaseDao(tprojectApplicationJointDao);
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
	public Pager getJointAuditList(Map<String, Object> param, int pageNo, int pageSize){
		
		Pager p = tprojectApplicationJointDao.getJointAuditList(param, pageNo, pageSize);
		
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
				
				// 项目分类
				valueMap.put("typeId", t1.getTprojectType().getTypeId());
				
				/*// 计划类别
				String planFlag ="";
				if (!isNullString(t1.getPlanFlag())){
					planFlag = mitemDao.getItemName(t1.getPlanFlag());
				}
				valueMap.put("planFlagName", planFlag);
				valueMap.put("planFlag", t1.getPlanFlag());*/
				
				// 项目分组
				valueMap.put("groupId", t1.getTprojectGroup().getGroupId());
				
				// 项目信息表
				VprojectInfo v1 = (VprojectInfo) obj[1];
				
				// 单位性质
				/*String unitProperties ="";
				if (!isNullString(v1.getUnitProperties())){
					unitProperties = mitemDao.getItemName(v1.getUnitProperties());
				}
				valueMap.put("unitProperties", unitProperties);*/
				// 项目负责人
				if(!isNullString(v1.getProjectPerson())){
					valueMap.put("projectPerson", v1.getProjectPerson());
				}
				
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
					// 判断组下面有没有评估模板
					groupMap.put("texpertReviewCommentsFlag", gettexpertReviewCommentsBygroup(t1.getTprojectGroup().getTypeId()));
					groupMap.put("texpertReviewCommentsExpert", gettexpertReviewCommentsByExpert(t1.getTprojectGroup().getGroupId(),t1.getTprojectGroup().getTypeId()));
					
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
							// 判断组下面有没有评估模板
							groupMap.put("texpertReviewCommentsFlag", gettexpertReviewCommentsBygroup(t1.getTprojectGroup().getTypeId()));
							groupMap.put("texpertReviewCommentsExpert", gettexpertReviewCommentsByExpert(t1.getTprojectGroup().getGroupId(),t1.getTprojectGroup().getTypeId()));
							
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
	 * 
	 * @comments 判断组下面有没有专家评估模板
	 * @param typeId
	 * @return
	 * @version 1.0
	 */
	public boolean gettexpertReviewCommentsBygroup(String typeId){
		List<TexpertReviewComments> list = texpertReviewCommentsDao.getexpertReviewList(typeId);
		if(list != null && list.size()>0){
			return true;
		}else{
			return false;
		}
	}
	/**
	 * 
	 * @comments 分别判断技术和投资专家有没有对应的技术和投资模板
	 * @param groupId
	 * @param typeId
	 * @return
	 * @version 1.0
	 */
	public boolean gettexpertReviewCommentsByExpert(String groupId,String typeId){
		List<TgroupExpertRealtion> ExpertList = tgroupExpertRealtionDao.getTgList(groupId);
		if(ExpertList != null && ExpertList.size()>0){
			for(int n=0;n<ExpertList.size(); n++){
				TgroupExpertRealtion Tg = ExpertList.get(n);
				List<TexpertReviewComments> list = texpertReviewCommentsDao.gettexpertReviewCommentsByExpert(Tg.getTexpert().getExpertType(),typeId);
				if(list != null && list.size()>0){
					return true;
				}else{
					return false;
				}
			}
		}
		return false;
	}
	// weina end
	/**
	 * @comments 联席会审核中
	 * @param projectId
	 * @Version 1.0
	 */
	public void updateApplyStatus(String projectId, String userId){
		TprojectApplication tprojectApplication = tprojectApplicationJointDao.get(projectId);
		
		if(Constants.PROJECT_REPORT_BEFOREREVIEW_PASS.equals(tprojectApplication.getApplyStatus())){
			
			// 申报状态（联席会审核中）
			tprojectApplication.setApplyStatus(Constants.PROJECT_REPORT_JOINT_ING);
			
			// 流程状态
			// tprojectApplication.setFlowStatus("");
			
			// 操作者
			tprojectApplication.setOptUser(userId);
			
			// 更新者 
			tprojectApplication.setUpdateUser(userId);
			// 更新时间
			tprojectApplication.setUpdateTime(new java.sql.Timestamp(new java.util.Date().getTime()));
			// 更新
			tprojectApplicationJointDao.update(tprojectApplication);
		}
	}
	
	/**
	 * @comments 联席会审核结果
	 * @param tprojectApplication
	 * @param projectApplyStatus
	 * @Version 1.0
	 */
	public void updateApplyStatus(TprojectApplication tprojectApplication, 
			String projectApplyStatus, String userId){
		
		// 根据项目Id取得项目信息
		TprojectApplication tpTemp = tprojectApplicationJointDao.get(tprojectApplication.getProjectId());
		
		// 联席会意见 
		//tpTemp.setMeetingOpinion(tprojectApplication.getMeetingOpinion());
		
		// 处长意见
		//tpTemp.setCommissionerOpinion(tprojectApplication.getCommissionerOpinion());
		
		// 联席会审核结果
		//tpTemp.setApplyStatus(projectApplyStatus);
		tpTemp.setJointStatus(projectApplyStatus);
		
		// 流程状态
		//tpTemp.setFlowStatus("");
		
		// 操作者
		tpTemp.setOptUser(userId);
		
		// 更新者
		tpTemp.setUpdateUser(userId);
		
		// 更新时间
		tpTemp.setUpdateTime(new java.sql.Timestamp(new java.util.Date().getTime()));
		
		tprojectApplicationJointDao.evict(tprojectApplication);
		// 更新		
		tprojectApplicationJointDao.update(tpTemp);
	}
	
	/**
	 * @comments 联席会批量审核结果 
	 * @param projectId
	 * @param commissionerOpinion
	 * @param meetingOpinion
	 * @param projectApplyStatus
	 * @Version 1.0
	 */
	public void updateBatchApplyStatus(String projectId, String commissionerOpinion,
			String meetingOpinion, String projectApplyStatus, String userId){
		String [] projectIds = projectId.split(",");
		
		for(int i=0; i< projectIds.length; i++){
			// 根据项目Id取得项目信息
			TprojectApplication tpTemp = tprojectApplicationJointDao.get(projectIds[i]);
			
			// 联席会意见 
			//tpTemp.setMeetingOpinion(meetingOpinion);
			
			// 处长意见
			//tpTemp.setCommissionerOpinion(commissionerOpinion);
			
			// 联席会审核结果
			// tpTemp.setApplyStatus(projectApplyStatus);
			tpTemp.setJointStatus(projectApplyStatus);
			
			// 流程状态 TODO
			//tpTemp.setFlowStatus("");
			
			// 操作者
			tpTemp.setOptUser(userId);
			
			// 更新者
			tpTemp.setUpdateUser(userId);
			
			// 更新时间
			tpTemp.setUpdateTime(new java.sql.Timestamp(new java.util.Date().getTime()));
			
			// 更新		
			tprojectApplicationJointDao.update(tpTemp);
		}
		
	}
	
	/**
	 * @comments 根据分组Id取得项目List
	 * @param groupId
	 * @return
	 * @Version 1.0
	 */
	public List<TprojectApplication> getProjectListByGroupId(String groupId){
		
		List<TprojectApplication> tpList = 
				tprojectApplicationJointDao.getList("tprojectGroup.groupId", groupId);
		
		// 封装数据
		if(tpList != null && tpList.size() > 0){
			for (TprojectApplication tp : tpList) {
				
				// 技术专家推荐意见
				if(!isNullString(tp.getExpertTecRecommend())){
					tp.setExpertTecRecommend(mitemDao.getItemName(tp.getExpertTecRecommend()));
				}
				
				// 投资专家推荐意见
				if(!isNullString(tp.getExpertInvRecommend())){
					tp.setExpertInvRecommend(mitemDao.getItemName(tp.getExpertInvRecommend()));
				}
				
				// 业务处室综合意见
				if(!isNullString(tp.getExpertAuditRecommend())){
					tp.setExpertAuditRecommend(mitemDao.getItemName(tp.getExpertAuditRecommend()));
				}
			}
		}
		
		return tpList;
	}
	
	/**
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

