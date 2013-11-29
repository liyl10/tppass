/*************** 版权声明***************
*
* Copyright (C) 2012 西安辉盛科技发展有限责任公司.
*
********************************************
*/
package com.hopsun.tppas.api.report.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.hopsun.framework.base.service.impl.BaseServiceImpl;
import com.hopsun.tppas.api.expert.dao.TexpertScoreDao;
import com.hopsun.tppas.api.report.dao.TcompanyInfoDao;
import com.hopsun.tppas.api.report.dao.TgroupExpertRealtionDao;
import com.hopsun.tppas.api.report.dao.TprojectApplicationDao;
import com.hopsun.tppas.api.report.dao.TprojectGroupDao;
import com.hopsun.tppas.api.report.service.TprojectGroupService;
import com.hopsun.tppas.common.Constants;
import com.hopsun.tppas.entity.TcompanyInfo;
import com.hopsun.tppas.entity.TexpertScore;
import com.hopsun.tppas.entity.TgroupExpertRealtion;
import com.hopsun.tppas.entity.TprojectApplication;
import com.hopsun.tppas.entity.TprojectGroup;

/**
 * @comments 项目分组
 * @author wanglw
 * @date 2013-9-10 @time 下午4:24:23
 * @Version 1.0
 */
@Service
public class TprojectGroupServiceImpl extends BaseServiceImpl<TprojectGroup,String> implements TprojectGroupService{
	
	@Resource
	private TprojectGroupDao tprojectGroupDao;
	
	@Resource
	public void setBaseDao(TprojectGroupDao tprojectGroupDao) {
		super.setBaseDao(tprojectGroupDao);
	}
	
	@Resource
	public TprojectApplicationDao tprojectApplicationDao;
	
	@Resource
	public TgroupExpertRealtionDao tgroupExpertRealtionDao;
	
	@Resource
	public TexpertScoreDao texpertScoreDao;
	
	@Resource
	public TcompanyInfoDao tcompanyInfoDao;
	/**
	 * @comments 根据本门Id取得项目分组List
	 * @param deptId
	 * @return
	 * @Version 1.0
	 */
	public List<TprojectGroup> getProjectGroupListByDeptId(String deptId){
		
		return tprojectGroupDao.getProjectGroupListByDeptId(deptId);
	}
	
	/**
	 * @comments 保存项目分组选择的项目信息
	 * @param projectIds
	 * @param groupName
	 * @param deptId
	 * @Version 1.0
	 */
	public String saveGroupSelectProject(String groupId, String projectIds, String groupName, String deptId,String projectType1,String projectType2,String userId){
		
		if(!"".equals(groupId) && groupId != null){
			
			// 取得项目分组信息
			TprojectGroup tprojectGroup = tprojectGroupDao.get(groupId);
			
			// 分组名称
			tprojectGroup.setGroupName(groupName);
			
			// 部门
			tprojectGroup.setDepartmentId(deptId);
			
			// 更新
			tprojectGroupDao.update(tprojectGroup);
			
			// 更新选择项目分组状态
			String projectId [] = projectIds.split(",");
			
			for(int i=0; i<projectId.length; i++){
				if(!"".equals(projectId[i])){
					TprojectApplication tp = tprojectApplicationDao.get(projectId[i]);
					// 设置分组
					tp.setTprojectGroup(tprojectGroup);
					// 更新
					tprojectApplicationDao.update(tp);
				}
			}
			
			return groupId;
		}
		else{
			// 新建分组对象
			TprojectGroup tprojectGroup = new TprojectGroup();
			// 分组名称
			tprojectGroup.setGroupName(groupName);
			// 部门Id
			tprojectGroup.setDepartmentId(deptId);
			// 项目分类
			tprojectGroup.setPlanFlag(projectType1);
			tprojectGroup.setTypeId(projectType2);
			// 创建时间
			tprojectGroup.setCreateTime(new java.sql.Timestamp(new java.util.Date().getTime()));
			// 创建者
			tprojectGroup.setCreateUser(userId);
			// 删除flag
			tprojectGroup.setDeleteFlag(Constants.COMMON_STATE_NOTDELETE);
			// 锁定区分
			tprojectGroup.setClockFlag("0");
			// 保存分组
			tprojectGroupDao.save(tprojectGroup);
			
			
			// 更新选择项目分组状态
			String projectId [] = projectIds.split(",");
			
			for(int i=0; i<projectId.length; i++){
				if(!"".equals(projectId[i])){
					TprojectApplication tp = tprojectApplicationDao.get(projectId[i]);
					// 设置分组
					tp.setTprojectGroup(tprojectGroup);
					// 更新
					tprojectApplicationDao.update(tp);
				}
			}
			
			return tprojectGroup.getGroupId();
		}
		
	}
	
	/**
	 * @comments 保存、更新项目分组
	 * @param groupId
	 * @param groupName
	 * @param deptId
	 * @Version 1.0
	 */
	public void saveOrUpdateGroup(String groupId, String groupName, String deptId){
		
		// 更新
		if(!"".equals(groupId) && groupId != null){
			
			// 取得项目分组信息
			TprojectGroup tprojectGroup = tprojectGroupDao.get(groupId);
			
			// 分组名称
			tprojectGroup.setGroupName(groupName);
			
			// 部门
			tprojectGroup.setDepartmentId(deptId);
			// 更新
			tprojectGroupDao.update(tprojectGroup);
		}
		// 新增
		else{
			
			// 新建分组对象
			TprojectGroup tprojectGroup = new TprojectGroup();
			// 分组名称
			tprojectGroup.setGroupName(groupName);
			// 部门Id
			tprojectGroup.setDepartmentId(deptId);
			// 创建时间
			tprojectGroup.setCreateTime(new java.sql.Timestamp(new java.util.Date().getTime()));
			// 删除flag
			tprojectGroup.setDeleteFlag(Constants.COMMON_STATE_NOTDELETE);
			// 锁定区分
			tprojectGroup.setClockFlag("0");
			// 保存分组
			tprojectGroupDao.save(tprojectGroup);
		}
	}

	/**
	 * 删除分组
	 */
	@Override
	public void deleteGroup(String groupId, String userId) {
		TprojectGroup tprojectGroup = tprojectGroupDao.get(groupId);
		if(tprojectGroup == null) return;
		
		
		// 删除组和专家关系表
		List<TgroupExpertRealtion> realtionList = tgroupExpertRealtionDao.getList("tprojectGroup.groupId", groupId);
		if(realtionList!=null && realtionList.size()>0){
			for (TgroupExpertRealtion tgroupExpertRealtion : realtionList) {
				tgroupExpertRealtionDao.delete(tgroupExpertRealtion);
			}
		}
		
		// 从项目中查询项目分组为该分组的项目，将项目分组设为空
		List<TprojectApplication> projectList = tprojectApplicationDao.getList("tprojectGroup.groupId", groupId);
		if(projectList!=null && projectList.size()>0){
			for (TprojectApplication tprojectApplication : projectList) {
				deleteProjecFromGroup(userId, tprojectApplication);
			}
		}
		// 删除项目分组
		tprojectGroupDao.delete(tprojectGroup);
	}

	/**
	 * 
	 * @comments 从分组中删除项目 
	 * @param userId
	 * @param tprojectApplication
	 * @version 1.0
	 */
	public void deleteProjecFromGroup(String userId, TprojectApplication tprojectApplication) {
		// 根据项目ID取得项目的所有打分记录
		List<TexpertScore>  scoreList = texpertScoreDao.getTexpertScoreList(tprojectApplication.getProjectId());
		if(scoreList!=null && scoreList.size()>0){
			for (TexpertScore texpertScore : scoreList) {
				texpertScoreDao.delete(texpertScore);
			}
		}
		// 更新企业项目基本信息中的（院所/高端人才）
		TcompanyInfo tcompanyInfo = tcompanyInfoDao.get("tprojectApplication.projectId", tprojectApplication.getProjectId());
		if(tcompanyInfo != null){
			tcompanyInfo.setInstitutesHighTalent(null);
			tcompanyInfoDao.update(tcompanyInfo);
		}
		
		tprojectApplication.setTprojectGroup(null);
		tprojectApplication.setUpdateTime(new java.sql.Timestamp(new java.util.Date().getTime()));
		tprojectApplication.setUpdateUser(userId);
		// 专家论证综合意见（其他意见）
		tprojectApplication.setExpertProofComposite("");
		// 技术专家意见
		tprojectApplication.setExpertTecOpinion("");
		// 投资专家意见
		tprojectApplication.setExpertInvOpinion("");
		// 专家意见状态
		tprojectApplication.setExpertOpinionStatus("");
		// 专家评审综合意见（局办公会意见）
		tprojectApplication.setExpertAuditComposite("");
		// 推荐意见
		tprojectApplication.setExpertAuditRecommend("");
		// 技术专家平均分
		tprojectApplication.setProjectTechnologyAverage(0.0);
		// 投资专家平均分
		tprojectApplication.setProjectInvestmentAverage(0.0);
		// 项目总平均分
		tprojectApplication.setProjectAverage(0.0);
		// 技术专家评审结果
		tprojectApplication.setProjectTechnologyResult(null);
		// 投资专家评审结果
		tprojectApplication.setProjectInvestmentResult(null);
		tprojectApplicationDao.update(tprojectApplication);
	}

	@Override
	public List<TprojectGroup> getProjectGroupListByTypeId(String typeId) {
		return tprojectGroupDao.getProjectGroupListByTypeId(typeId);
	}

	@Override
	public List<TprojectGroup> getProjectGroupListByTypeStr(String typeStr) {
		return tprojectGroupDao.getProjectGroupListByTypeStr(typeStr);
	}
	// weina start
	/**
	 * 
	 * @comments 根据子分类和锁定区分查询项目分组list
	 * @param typeStr
	 * @return
	 * @version 1.0
	 */
	@Override
	public List<TprojectGroup> getProjectGroupListByTypeStrClockFlag(
			String typeStr) {
		return tprojectGroupDao.getProjectGroupListByTypeStrClockFlag(typeStr);
	}
	// weina end
}
