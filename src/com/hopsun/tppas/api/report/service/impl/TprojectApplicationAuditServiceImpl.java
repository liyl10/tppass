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
import com.hopsun.tppas.api.expert.dao.TexpertScoreDao;
import com.hopsun.tppas.api.report.dao.TgroupExpertRealtionDao;
import com.hopsun.tppas.api.report.dao.TprojectApplicationAuditDao;
import com.hopsun.tppas.api.report.dao.TprojectApplicationDao;
import com.hopsun.tppas.api.report.dao.TprojectGroupDao;
import com.hopsun.tppas.api.report.service.TprojectApplicationAuditService;
import com.hopsun.tppas.api.superadmin.dao.MitemDao;
import com.hopsun.tppas.common.Constants;
import com.hopsun.tppas.entity.Mitem;
import com.hopsun.tppas.entity.TcompanyInfo;
import com.hopsun.tppas.entity.TcostEstimateB;
import com.hopsun.tppas.entity.TeconomicIndicatorB;
import com.hopsun.tppas.entity.TexpertScore;
import com.hopsun.tppas.entity.TgroupExpertRealtion;
import com.hopsun.tppas.entity.Tplan;
import com.hopsun.tppas.entity.TprojectApplication;
import com.hopsun.tppas.entity.TprojectGroup;
import com.hopsun.tppas.view.VmainContent;
import com.hopsun.tppas.view.VprojectInfo;

/**
 * @comments 项目评审
 * @author wanglw
 * @date 2013-9-10 @time 下午4:27:26
 * @Version 1.0
 */
@Service
public class TprojectApplicationAuditServiceImpl extends BaseServiceImpl<TprojectApplication,String> implements TprojectApplicationAuditService{
	
	@Resource
	private TprojectApplicationAuditDao tprojectApplicationAuditDao;
	
	@Resource
	private TprojectApplicationDao tprojectApplicationDao;
	
	@Resource
	private TgroupExpertRealtionDao tgroupExpertRealtionDao;
	
	@Resource
	public void setBaseDao(TprojectApplicationAuditDao tprojectApplicationAuditDao) {
		super.setBaseDao(tprojectApplicationAuditDao);
	}
	
	@Resource
	private MitemDao mitemDao;
	
	@Resource
	private TexpertScoreDao texpertScoreDao;
	
	@Resource
	private TprojectGroupDao tprojectGroupDao;
	
	/**
	 * @comments 取得项目审核数据
	 * @param param
	 * @param pageNo
	 * @param pageSize
	 * @return
	 * @Version 1.0
	 */
	public Pager getAuditExpertList(Map<String, Object> param, int pageNo, int pageSize){
		
		Pager p = tprojectApplicationAuditDao.getAuditExpertList(param, pageNo, pageSize);
		
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
				
				// 判断是否已选择专家
				if(!isNullString(t1.getProjectId())){
					
					List<TexpertScore> esList = texpertScoreDao.getList("tprojectApplication.projectId", t1.getProjectId().trim());
					if(esList != null && esList.size() > 0){
						valueMap.put("selectedExpertFlag", "1");
					}
					else{
						valueMap.put("selectedExpertFlag", "0");
					}
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
				String unitProperties ="";
				if (!isNullString(v1.getUnitProperties())){
					unitProperties = mitemDao.getItemName(v1.getUnitProperties());
				}
				valueMap.put("unitProperties", unitProperties);
				
				// 技术领域
				String technicalFisld ="";
				if (!isNullString(v1.getTechnicalFisld())){
					technicalFisld = mitemDao.getItemName(v1.getTechnicalFisld());
				}
				valueMap.put("technicalFisld", technicalFisld);
				
				if(i == 0){
					
					Map<String, Object> groupMap = new HashMap<String, Object>();
					// 计划类别
					// groupMap.put("groupId", t1.getTprojectGroup().getGroupId());
					
					// 计划类别名称
					groupMap.put("groupShowName", t1.getTprojectGroup().getGroupName());
					
					// 分组标识
					groupMap.put("groupName", "group" + i);
					// 分组id
					groupMap.put("groupId",  t1.getTprojectGroup().getGroupId());
					num = i;
					
					groupMap.put("projectId", "");
					
					list.add(groupMap);
					
					groupSet.add(t1.getTprojectGroup().getGroupId());
				}
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
							// 分组id
							groupMap.put("groupId",  t1.getTprojectGroup().getGroupId());
							num = i;
							
							groupMap.put("projectId", "");
							
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
	
	/**
	 * @comments 取得创建分组时取得的项目List
	 * @param param
	 * @return
	 * @Version 1.0
	 */
	public List<Map<String, Object>> getGroupSelectProjectList(Map<String, Object> param){
		
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		
		// 取得项目List
		List<Object> objList = tprojectApplicationAuditDao.getGroupSelectProjectList(param);
		
		if(objList !=null && objList.size() >0){
			// 遍历集合
			for(int i=0; i<objList.size(); i++){
				// 封装数据
				Object[] obj = (Object[]) objList.get(i);
				
				// 列表信息Map
				Map<String, Object> valueMap = new HashMap<String, Object>();
				
				// 项目申报表
				TprojectApplication t1 = (TprojectApplication) obj[0];
				
				// 项目ID	
				valueMap.put("projectId", t1.getProjectId().trim());
				
				// 项目名称
				valueMap.put("projectName", t1.getProjectName());
				
				// 申报单位
				valueMap.put("applicationUnit", t1.getApplicationUnit());
				
				// 申请单位ID
				valueMap.put("userId", t1.getUserId());
				
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
				
				// 项目信息表
				VprojectInfo v1 = (VprojectInfo) obj[1];
				
				// 单位性质
				String unitProperties ="";
				if (!isNullString(v1.getUnitProperties())){
					unitProperties = mitemDao.getItemName(v1.getUnitProperties());
				}
				valueMap.put("unitProperties", unitProperties);
				
				// 技术领域
				String technicalFisld ="";
				if (!isNullString(v1.getTechnicalFisld())){
					technicalFisld = mitemDao.getItemName(v1.getTechnicalFisld());
				}
				valueMap.put("technicalFisld", technicalFisld);
				
				list.add(valueMap);
			}
		}
		
		return list;
	}
	
	/**
	 * @comments 取得创建分组时取得的项目List
	 * @param param
	 * @return
	 * @Version 1.0
	 */
	public Pager getGroupSelectProjectPager(Map<String, Object> param,Integer pageNumber, Integer pageSize){
		
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		
		// 取得项目List
		Pager p = tprojectApplicationAuditDao.getGroupSelectProjectPager(param, pageNumber, pageSize);
		
		if(p.getList() !=null && p.getList().size() >0){
			// 遍历集合
			for(int i=0; i<p.getList().size(); i++){
				// 封装数据
				Object[] obj = (Object[]) p.getList().get(i);
				
				// 列表信息Map
				Map<String, Object> valueMap = new HashMap<String, Object>();
				
				// 项目申报表
				TprojectApplication t1 = (TprojectApplication) obj[0];
				
				// 项目ID	
				valueMap.put("projectId", t1.getProjectId().trim());
				
				// 项目名称
				valueMap.put("projectName", t1.getProjectName());
				
				// 申报单位
				valueMap.put("applicationUnit", t1.getApplicationUnit());
				
				// 申请单位ID
				valueMap.put("userId", t1.getUserId());
				
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
				
				// 项目信息表
				VprojectInfo v1 = (VprojectInfo) obj[1];
				
				// 单位性质
				String unitProperties ="";
				if (!isNullString(v1.getUnitProperties())){
					unitProperties = mitemDao.getItemName(v1.getUnitProperties());
				}
				valueMap.put("unitProperties", unitProperties);
				
				// 技术领域
				String technicalFisld ="";
				if (!isNullString(v1.getTechnicalFisld())){
					technicalFisld = mitemDao.getItemName(v1.getTechnicalFisld());
				}
				valueMap.put("technicalFisld", technicalFisld);
				
				list.add(valueMap);
			}
			p.setList(list);
		}
		
		return p;
	}
	
	/**
	 * @comments 取得新建项目分组选择的项目list
	 * @param groupId
	 * @param pageNo
	 * @param pageSize
	 * @return
	 * @Version 1.0
	 */
	public Pager getGroupSelectedProjectList(String groupId, int pageNo, int pageSize){
		
		Pager p = tprojectApplicationAuditDao.getGroupSelectedProjectList(groupId, pageNo, pageSize);
		
		if(p.getList() !=null && p.getList().size() > 0){
			List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
			
			for (int i = 0; i < p.getList().size(); i++) {
				Object[] obj = (Object[]) p.getList().get(i);
				// 列表信息Map
				Map<String, Object> valueMap = new HashMap<String, Object>();
				
				// 项目申报表
				TprojectApplication t1 = (TprojectApplication) obj[0];
				
				// 项目ID	
				valueMap.put("projectId", t1.getProjectId().trim());
				
				// 项目名称
				valueMap.put("projectName", t1.getProjectName());
				
				// 申报单位
				valueMap.put("applicationUnit", t1.getApplicationUnit());
				
				// 申请单位ID
				valueMap.put("userId", t1.getUserId());
				
				// 申报状态
				String applyStatus ="";
				if (!isNullString(t1.getApplyStatus())){
					applyStatus = mitemDao.getItemName(t1.getApplyStatus());
				}
				valueMap.put("applyStatus", applyStatus);
				
				// 项目类别
				valueMap.put("projectTypeName", t1.getPlanFlagName() + Constants.STRING_LINK + t1.getTypeName());
				
				// 项目信息表
				VprojectInfo v1 = (VprojectInfo) obj[1];
				
				// 单位性质
				String unitProperties ="";
				if (!isNullString(v1.getUnitProperties())){
					unitProperties = mitemDao.getItemName(v1.getUnitProperties());
				}
				valueMap.put("unitProperties", unitProperties);
				
				// 技术领域
				String technicalFisld ="";
				if (!isNullString(v1.getTechnicalFisld())){
					technicalFisld = mitemDao.getItemName(v1.getTechnicalFisld());
				}
				valueMap.put("technicalFisld", technicalFisld);
				
				// 项目分组id
				
				list.add(valueMap);
			}
			
			// 设定list集合
			p.setList(list);
		}
		
		return p;
	}
	
	/**
	 * @comments 批量更新项目分组
	 * @param selectedProjectIds
	 * @Version 1.0
	 */
	public void updateBatchProjectGroup(String selectedProjectIds){
		
		// 取得批量更新的项目Id数组
		String projectIds [] = selectedProjectIds.split(",");
		
		for(int i=0; i< projectIds.length; i++){
			
			if(!"".equals(projectIds[i])){
				// 取得项目信息
				TprojectApplication tp = tprojectApplicationAuditDao.get(projectIds[i]);
				
				// 创建项目分组关联对象
				TprojectGroup tpg = tprojectGroupDao.get("remark", tp.getPlanFlag());
				
				// 设置项目分组
				tp.setTprojectGroup(tpg);
				
				// 更新项目分组
				tprojectApplicationAuditDao.update(tp);
			}
		}
	}
	
	
	/**
	 * @comments 更新项目分组
	 * @param projectId
	 * @Version 1.0
	 */
	public void updateProjectGroup(String projectId){
		
		// 取得项目信息
		TprojectApplication tp = tprojectApplicationAuditDao.get(projectId);
		
		// 创建项目分组关联对象
		TprojectGroup tpg = tprojectGroupDao.get("remark", tp.getPlanFlag());
		
		// 设置项目分组
		tp.setTprojectGroup(tpg);
		
		// 更新项目分组
		tprojectApplicationAuditDao.update(tp);
	}
	
	/**
	 * @comments 改变项目分组
	 * @param projectId
	 * @param groupId
	 * @param oldGroupId
	 * @Version 1.0
	 */
	public void updateProjectGroup(String projectId, String groupId,String oldGroupId){
		
		// 取得项目信息
		TprojectApplication tp = tprojectApplicationDao.get(projectId);
		
		if(!"".equals(groupId) && groupId !=null){
			TprojectGroup tpg = tprojectGroupDao.get(groupId);
			tp.setTprojectGroup(tpg);
			
			// 取得原来分组中项目个数，如果项目个数为0 ，将该分组删除
			int projectNum = tprojectApplicationDao.getList("tprojectGroup.groupId", oldGroupId).size();
			if(projectNum <= 0){
				// 删除组和专家关系表
				List<TgroupExpertRealtion> realtionList = tgroupExpertRealtionDao.getList("tprojectGroup.groupId", oldGroupId);
				if(realtionList!=null && realtionList.size()>0){
					for (TgroupExpertRealtion tgroupExpertRealtion : realtionList) {
						tgroupExpertRealtionDao.delete(tgroupExpertRealtion);
					}
				}
				tprojectGroupDao.delete(oldGroupId);
			}
		}
		
		tprojectApplicationAuditDao.update(tp);
	}
	
	
	/**
	 * @comments 取得项目审核数据
	 * @param param
	 * @param pageNo
	 * @param pageSize
	 * @return
	 * @Version 1.0
	 */
	public Pager getProjectAuditList(Map<String, Object> param, int pageNo, int pageSize){
		
		Pager p = tprojectApplicationAuditDao.getProjectAuditList(param, pageNo, pageSize);
		
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
				
				// 判断是否已选择专家
				if(!isNullString(t1.getProjectId())){
					
					List<TexpertScore> esList = texpertScoreDao.getList("tprojectApplication.projectId", t1.getProjectId().trim());
					if(esList != null && esList.size() > 0){
						valueMap.put("selectedExpertFlag", "1");
					}
					else{
						valueMap.put("selectedExpertFlag", "0");
					}
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
				String unitProperties ="";
				if (!isNullString(v1.getUnitProperties())){
					unitProperties = mitemDao.getItemName(v1.getUnitProperties());
				}
				valueMap.put("unitProperties", unitProperties);
				
				// 技术领域
				String technicalFisld ="";
				if (!isNullString(v1.getTechnicalFisld())){
					technicalFisld = mitemDao.getItemName(v1.getTechnicalFisld());
				}
				valueMap.put("technicalFisld", technicalFisld);
				
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
					
					list.add(groupMap);
					
					groupSet.add(t1.getTprojectGroup().getGroupId());
				}
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
	
	
	/**
	 * @comments 取得项目申报信息 
	 * @param projectId 项目Id
	 * @return
	 * @Version 1.0
	 */
	public TprojectApplication getProjectAppliaction(String projectId){
		
		// 取得项目申报信息
		TprojectApplication tp = tprojectApplicationAuditDao.get(projectId);
		
		// 取得项目基本信息
		List<Object[]> tpList = tprojectApplicationAuditDao.getProjectInfo(projectId);
		
		// 封装取得的项目基本信息
		if(tpList != null && tpList.size() >0){
			Object[] obj = (Object[]) tpList.get(0);
			
			// 项目申报表
			// TprojectApplication t1 = (TprojectApplication) obj[0];
			
			// 项目基本信息
			VprojectInfo vp = (VprojectInfo) obj[1];
			
			// 项目负责人
			tp.setInitialAuditOpinion(vp.getProjectPerson());
			
			// 所属技术领域
			String technicaFisld = mitemDao.getItemName(vp.getTechnicalFisld());
			tp.setDeployOpinion(technicaFisld);
		}
		
		return tp;
	}
	
	/**
	 * @comments 保存评审意见 
	 * @param texpertScoreList
	 * @param tprojectApplication
	 * @param userId
	 * @Version 1.0
	 */
	public void saveAuditOpinions(List<TexpertScore> texpertScoreList, 
			TprojectApplication tprojectApplication, String userId){
		
		if(texpertScoreList != null && texpertScoreList.size() > 0){
			
			for (TexpertScore texpertScore : texpertScoreList) {
				if(texpertScore != null){
					
					if(texpertScore.getScoreId() !=null && !"".equals(texpertScore.getScoreId())){
					
						// 根据评分ID取得评分信息
						TexpertScore texTemp = texpertScoreDao.get(texpertScore.getScoreId());
						// 综合得分
						// texTemp.setComplexScore(texpertScore.getComplexScore());
						// 综合意见
						texTemp.setComplexOpinion(texpertScore.getComplexOpinion());
						// 更新者
						texTemp.setUpdateUser(userId);
						// 更新时间
						texTemp.setUpdateDate(new java.sql.Timestamp(new java.util.Date().getTime()));
						texpertScoreDao.evict(texpertScore);
						// 更新
						texpertScoreDao.update(texTemp);
					}
					else{
						texpertScore.setTprojectApplication(tprojectApplication);
						texpertScoreDao.save(texpertScore);
					}
				}
			}
		}
		
		// 根据项目Id取得项目信息
		TprojectApplication tpTemp = tprojectApplicationAuditDao.get(tprojectApplication.getProjectId());
		
		// 技术专家意见
		tpTemp.setExpertTecOpinion(tprojectApplication.getExpertTecOpinion());
		// 技术专家推荐意见
		//tpTemp.setExpertTecRecommend(tprojectApplication.getExpertTecRecommend());
		// 投资专家意见
		tpTemp.setExpertInvOpinion(tprojectApplication.getExpertInvOpinion());
		// 投资专家推荐意见
		//tpTemp.setExpertInvRecommend(tprojectApplication.getExpertInvRecommend());
		// 业务处室推荐意见
		//tpTemp.setExpertAuditRecommend(tprojectApplication.getExpertAuditRecommend());
		// 业务处室综合意见
		//tpTemp.setExpertAuditComposite(tprojectApplication.getExpertAuditComposite());
		
		// 专家意见状态
		tpTemp.setExpertOpinionStatus("1");
		
		// 更新时间
		tpTemp.setUpdateTime(new java.sql.Timestamp(new java.util.Date().getTime()));
		// 操作者
		tpTemp.setOptUser(userId);
		
		tprojectApplicationAuditDao.evict(tprojectApplication);
		// 更新
		tprojectApplicationAuditDao.update(tpTemp);
	}
	
	/**
	 * @comments 提交评审意见 
	 * @param texpertScoreList
	 * @param tprojectApplication
	 * @param userId
	 * @Version 1.0
	 */
	public void saveAndSubmitAuditOpinions(List<TexpertScore> texpertScoreList, 
			TprojectApplication tprojectApplication, String userId){
		
		if(texpertScoreList != null && texpertScoreList.size() > 0){
			
			for (TexpertScore texpertScore : texpertScoreList) {
				if(texpertScore != null){
					
					if(texpertScore.getScoreId()!= null && !"".equals(texpertScore.getScoreId())){
						// 根据评分ID取得评分信息
						TexpertScore texTemp = texpertScoreDao.get(texpertScore.getScoreId());
						// 综合得分
						texTemp.setComplexScore(texpertScore.getComplexScore());
						// 综合意见
						texTemp.setComplexOpinion(texpertScore.getComplexOpinion());
						// 更新者
						texTemp.setUpdateUser(userId);
						// 更新时间
						texTemp.setUpdateDate(new java.sql.Timestamp(new java.util.Date().getTime()));
						texpertScoreDao.evict(texpertScore);
						// 更新
						texpertScoreDao.update(texTemp);
					}
					else{
						texpertScore.setTprojectApplication(tprojectApplication);
						texpertScoreDao.save(texpertScore);
					}
					
				}
				
			}
		}
		
		// 根据项目Id取得项目信息
		TprojectApplication tpTemp = tprojectApplicationAuditDao.get(tprojectApplication.getProjectId());
		
		// 技术专家意见
		tpTemp.setExpertTecOpinion(tprojectApplication.getExpertTecOpinion());
		// 技术专家推荐意见
		//tpTemp.setExpertTecRecommend(tprojectApplication.getExpertTecRecommend());
		// 投资专家意见
		tpTemp.setExpertInvOpinion(tprojectApplication.getExpertInvOpinion());
		// 投资专家推荐意见
		//tpTemp.setExpertInvRecommend(tprojectApplication.getExpertInvRecommend());
		// 业务处室推荐意见
		//tpTemp.setExpertAuditRecommend(tprojectApplication.getExpertAuditRecommend());
		// 业务处室综合意见
		//tpTemp.setExpertAuditComposite(tprojectApplication.getExpertAuditComposite());
		
		// 申报状态 TODO
		//tpTemp.setApplyStatus("");
		// 流程状态
		//tpTemp.setFlowStatus("");
		// 专家意见状态
		tpTemp.setExpertOpinionStatus("0");
		
		// 更新时间
		tpTemp.setUpdateTime(new java.sql.Timestamp(new java.util.Date().getTime()));
		// 操作者
		tpTemp.setOptUser(userId);
		
		tprojectApplicationAuditDao.evict(tprojectApplication);
		// 更新
		tprojectApplicationAuditDao.update(tpTemp);
	}
	
	/**
	 * @comments 取得分计划选择项目
	 * @param param
	 * @param pageNo
	 * @param pageSize
	 * @return
	 * @Version 1.0
	 */
	public Pager getBatchProjectList(Map<String, Object> param, int pageNo, int pageSize){
		
		Pager p = tprojectApplicationAuditDao.getBatchProjectList(param, pageNo, pageSize);
		
		if(p.getList() !=null && p.getList().size() > 0){
			List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
			
			for (int i = 0; i < p.getList().size(); i++) {
				Object[] obj = (Object[]) p.getList().get(i);
				// 列表信息Map
				Map<String, Object> valueMap = new HashMap<String, Object>();
				
				// 项目申报表
				TprojectApplication t1 = (TprojectApplication) obj[0];
				
				// 项目ID	
				valueMap.put("projectId", t1.getProjectId().trim());
				
				
				if(!isNullString(t1.getProjectNumber())){
					// 项目编号
					valueMap.put("projectNumber", t1.getProjectNumber().trim());
				}
				
				// 项目名称
				valueMap.put("projectName", t1.getProjectName());
				
				// 申报单位
				valueMap.put("applicationUnit", t1.getApplicationUnit());
				
				// 申请单位ID
				valueMap.put("userId", t1.getUserId());
				
				// 项目类别
				valueMap.put("projectTypeName", t1.getPlanFlagName() + Constants.STRING_LINK + t1.getTypeName());
				
				// 项目分类
				valueMap.put("typeId", t1.getTprojectType().getTypeId());
				
				// 项目信息表
				VprojectInfo v1 = (VprojectInfo) obj[1];
				
				// 单位性质
				String unitProperties ="";
				if (!isNullString(v1.getUnitProperties())){
					unitProperties = mitemDao.getItemName(v1.getUnitProperties());
				}
				valueMap.put("unitProperties", unitProperties);
				
				// 技术领域
				String technicalFisld ="";
				if (!isNullString(v1.getTechnicalFisld())){
					technicalFisld = mitemDao.getItemName(v1.getTechnicalFisld()) 
							+ Constants.STRING_LINK 
							+ mitemDao.getItemName(v1.getTechnicalFisld()) 
							+ Constants.STRING_LINK 
							+ mitemDao.getItemName(v1.getTechnicalFisld());
				}
				valueMap.put("technicalFisld", technicalFisld);
				
				list.add(valueMap);
			}
			
			// 设定list集合
			p.setList(list);
		}
		
		return p;
	}
	
	
	/**
	 * @comments 取得分计划选择的项目
	 * @param planId
	 * @return
	 * @Version 1.0
	 */
	public List<TprojectApplication> getPlanUpdateList(String planId){
		
		List<Object> objList = tprojectApplicationAuditDao.getPlanUpdateList(planId);
		List<TprojectApplication> proList = new ArrayList<TprojectApplication>();
		
		// 合计
		TprojectApplication tpTotal = new TprojectApplication();
		// 封装数据
		if(objList != null && objList.size() > 0){
			for(int i=0; i<objList.size(); i++){
				Object[] obj = (Object[]) objList.get(i);
				TprojectApplication tp = (TprojectApplication)obj[0];
				
				// 归口管理部门
				tp.setCentralizedTypeName(mitemDao.getItemName(tp.getCentralizedType()));
				
				VprojectInfo v = (VprojectInfo)obj[1];
				
				// 项目负责人
				tp.setRemark(v.getProjectPerson());
				
				// 设置金额
				// 关联金额表
				TcostEstimateB tc = (TcostEstimateB)obj[2];
				
				// 科研资金
				tp.setResearchFunds(tc.getApplicationSpecial());
				tpTotal.setResearchFunds(tpTotal.getResearchFunds() + tc.getApplicationSpecial());
				
				// 自筹
				tp.setSelfFinancing(tc.getSelfRaisedFunds());
				tpTotal.setSelfFinancing(tpTotal.getSelfFinancing() + tc.getSelfRaisedFunds());
				
				// 合计
				tp.setInputTotal(tc.getApplicationSpecial() + tc.getSelfRaisedFunds());
				tpTotal.setInputTotal(tpTotal.getInputTotal() + tp.getInputTotal());
				
				TeconomicIndicatorB te = (TeconomicIndicatorB)obj[3];
				Mitem mitem = mitemDao.get(tp.getTprojectType().getTimeArea());
				if(mitem != null){
					if("2".equals(mitem.getItemDesc())){
						// 销售收入
						tp.setProjectExpectOutput(te.getProduction1());
						tpTotal.setProjectExpectOutput(tpTotal.getProjectExpectOutput() + te.getProduction1());
						
						// 利税
						tp.setProjectExpectProfitTax(te.getPayTaxes1());
						tpTotal.setProjectExpectProfitTax(tpTotal.getProjectExpectProfitTax() + te.getPayTaxes1());
					}
					else if("3".equals(mitem.getItemDesc())){
						// 销售收入
						tp.setProjectExpectOutput(te.getProduction());
						tpTotal.setProjectExpectOutput(tpTotal.getProjectExpectOutput() + te.getProduction());
						
						// 利税
						tp.setProjectExpectProfitTax(te.getPayTaxes());
						tpTotal.setProjectExpectProfitTax(tpTotal.getProjectExpectProfitTax() + te.getPayTaxes());
					}
				}
				
				TcompanyInfo to = (TcompanyInfo)obj[4];
				if(to !=null){
					
					// 企业产值
					tp.setCompanyExpectOutput(to.getExpectedSales());
					tpTotal.setCompanyExpectOutput(tpTotal.getCompanyExpectOutput() + to.getExpectedSales());
					
;					// 企业利税
					tp.setCompanyExpectProfitTax(to.getExpectedTax());
					tpTotal.setCompanyExpectProfitTax(tpTotal.getCompanyExpectProfitTax() + to.getExpectedTax());
				}
				
				VmainContent tr = (VmainContent)obj[5];
				if(tr !=null){
					// 主要内容
					tp.setExpertAuditResearch(tr.getMainContent());
				}
				// 计算合计
				proList.add(tp);
			}
			tpTotal.setProjectId("");
			proList.add(tpTotal);
		}
		
		return proList;
	}
	
	/**
	 * @comments 更新项目的分计划选择状态
	 * @param projectId
	 * @Version 1.0
	 */
	public void updateProSelectStatus(String projectId){
		Tplan tp = new Tplan();
		tp.setPlanId("");
		if(projectId.contains(",")){
			String ids[] = projectId.split(",");
			for(int i=0;i<ids.length; i++){
				TprojectApplication tpr = tprojectApplicationAuditDao.get(ids[i]);
				// 分计划
				tpr.setTplan(tp);
				// 选择状态
				tpr.setExpertProofResearch("");
				// 更新
				tprojectApplicationAuditDao.update(tpr);
			}
			
		}else{
			TprojectApplication tpr = tprojectApplicationAuditDao.get(projectId);
			// 分计划
			tpr.setTplan(tp);
			// 选择状态
			tpr.setExpertProofResearch("");
			// 更新
			tprojectApplicationAuditDao.update(tpr);
		}
	}
	
	/**
	 * @comments 取得的项目List
	 * @param param
	 * @return
	 * @Version 1.0
	 */
	public List<Map<String, Object>> getSelectProjectList(Map<String, Object> param){
		
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		
		// 取得项目List
		List<Object> objList = tprojectApplicationAuditDao.getUnselectProjectList(param);
		
		if(objList !=null && objList.size() >0){
			// 遍历集合
			for(int i=0; i<objList.size(); i++){
				Object[] obj = (Object[]) objList.get(i);
				// 列表信息Map
				Map<String, Object> valueMap = new HashMap<String, Object>();
				
				// 项目申报表
				TprojectApplication t1 = (TprojectApplication) obj[0];
				
				// 项目ID	
				valueMap.put("projectId", t1.getProjectId().trim());
				
				
				if(!isNullString(t1.getProjectNumber())){
					// 项目编号
					valueMap.put("projectNumber", t1.getProjectNumber().trim());
				}
				
				// 项目名称
				valueMap.put("projectName", t1.getProjectName());
				
				// 申报单位
				valueMap.put("applicationUnit", t1.getApplicationUnit());
				
				// 申请单位ID
				valueMap.put("userId", t1.getUserId());
				
				// 项目类别
				valueMap.put("projectTypeName", t1.getPlanFlagName() + Constants.STRING_LINK + t1.getTypeName());
				
				// 项目分类
				valueMap.put("typeId", t1.getTprojectType().getTypeId());
				
				// 项目信息表
				VprojectInfo v1 = (VprojectInfo) obj[1];
				
				// 单位性质
				String unitProperties ="";
				if (!isNullString(v1.getUnitProperties())){
					unitProperties = mitemDao.getItemName(v1.getUnitProperties());
				}
				valueMap.put("unitProperties", unitProperties);
				
				// 技术领域
				String technicalFisld ="";
				if (!isNullString(v1.getTechnicalFisld())){
					technicalFisld = mitemDao.getItemName(v1.getTechnicalFisld()) 
							+ Constants.STRING_LINK 
							+ mitemDao.getItemName(v1.getTechnicalFisld()) 
							+ Constants.STRING_LINK 
							+ mitemDao.getItemName(v1.getTechnicalFisld());
				}
				valueMap.put("technicalFisld", technicalFisld);
				
				list.add(valueMap);
			}
		}
		
		return list;
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

	/**
	 * 取得属于某个分组的项目
	 */
	@Override
	public Pager getGroupProjectList(Map<String, Object> param, Integer pageNumber, Integer pageSize) {
		
		Pager p = tprojectApplicationAuditDao.getGroupProjectList(param, pageNumber, pageSize);

		if (p.getList() != null && p.getList().size() > 0) {
			List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();

			for (int i = 0; i < p.getList().size(); i++) {
				Object[] obj = (Object[]) p.getList().get(i);
				// 列表信息Map
				Map<String, Object> valueMap = new HashMap<String, Object>();

				// 项目申报表
				TprojectApplication t1 = (TprojectApplication) obj[0];

				// 项目ID
				valueMap.put("projectId", t1.getProjectId().trim());

				if (!isNullString(t1.getProjectNumber())) {
					// 项目编号
					valueMap.put("projectNumber", t1.getProjectNumber().trim());
				}

				// 项目名称
				valueMap.put("projectName", t1.getProjectName());

				// 申报单位
				valueMap.put("applicationUnit", t1.getApplicationUnit());

				// 申请单位ID
				valueMap.put("userId", t1.getUserId());

				// 项目类别
				valueMap.put("projectTypeName", t1.getPlanFlagName() + Constants.STRING_LINK + t1.getTypeName());

				// 项目分类
				valueMap.put("typeId", t1.getTprojectType().getTypeId());

				// 项目信息表
				VprojectInfo v1 = (VprojectInfo) obj[1];

				// 单位性质
				String unitProperties = "";
				if (!isNullString(v1.getUnitProperties())) {
					unitProperties = mitemDao.getItemName(v1.getUnitProperties());
				}
				valueMap.put("unitProperties", unitProperties);

				// 技术领域
				String technicalFisld = "";
				if (!isNullString(v1.getTechnicalFisld())) {
					/*technicalFisld = mitemDao.getItemName(v1.getTechnicalFisld()) + Constants.STRING_LINK
							+ mitemDao.getItemName(v1.getTechnicalFisld()) + Constants.STRING_LINK
							+ mitemDao.getItemName(v1.getTechnicalFisld());*/
					technicalFisld = mitemDao.getItemName(v1.getTechnicalFisld());
				}
				valueMap.put("technicalFisld", technicalFisld);

				list.add(valueMap);
			}

			// 设定list集合
			p.setList(list);
		}
		return p;
	}
}
