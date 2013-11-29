/*************** 版权声明***************
*
* Copyright (C) 2012 西安辉盛科技发展有限责任公司.
*
********************************************
*/
package com.hopsun.tppas.api.expert.service.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.hopsun.framework.base.bean.Pager;
import com.hopsun.framework.base.service.impl.BaseServiceImpl;
import com.hopsun.scenter.api.util.Constant;
import com.hopsun.scenter.entity.ScUsers;
import com.hopsun.tppas.api.expert.dao.TexpertScoreDao;
import com.hopsun.tppas.api.expert.service.TexpertScoreService;
import com.hopsun.tppas.api.report.dao.TgroupExpertRealtionDao;
import com.hopsun.tppas.api.report.dao.TprojectApplicationDao;
import com.hopsun.tppas.api.report.dao.TprojectApplicationJointDao;
import com.hopsun.tppas.api.superadmin.dao.MitemDao;
import com.hopsun.tppas.api.superadmin.dao.TprojectTypeDao;
import com.hopsun.tppas.common.CommonTool;
import com.hopsun.tppas.common.Constants;
import com.hopsun.tppas.entity.Texpert;
import com.hopsun.tppas.entity.TexpertReviewComments;
import com.hopsun.tppas.entity.TexpertScore;
import com.hopsun.tppas.entity.TgroupExpertRealtion;
import com.hopsun.tppas.entity.TprojectApplication;
import com.hopsun.tppas.entity.TprojectGroup;
import com.hopsun.tppas.entity.TprojectInfoA;
import com.hopsun.tppas.entity.TprojectInfoB;
import com.hopsun.tppas.entity.TprojectType;

/**
 * @comment 专家评审管理
 * @author wangxiaodong
 * @DATE: 2013-08-27 @TIME: 下午2:09:37
 * @Vsersion: 1.0
 */
@Service
public class TexpertScoreServiceImpl extends BaseServiceImpl<TexpertScore,String> implements TexpertScoreService{
	
	@Resource
	private TexpertScoreDao texpertScoreDao;
	
	@Resource
	private TprojectTypeDao tprojectTypeDao;
	
	@Resource
	private MitemDao mitemDao;
	
	@Resource
	private TgroupExpertRealtionDao tgroupExpertRealtionDao;
	
	/**项目申报DAO*/
	@Resource
	private TprojectApplicationDao tprojectApplicationDao;
	
	@Resource
	private TprojectApplicationJointDao tprojectApplicationJointDao;
	
	@Resource
	public void setBaseDao(TexpertScoreDao texpertScoreDao) {
		super.setBaseDao(texpertScoreDao);
	}
	
	// wanglw Start
	
	/**
	 * @comments 取得已选择的专家信息
	 * @param param
	 * @param pageNo
	 * @param pageSize
	 * @return
	 * @Version 1.0
	 */
	public Pager getSelectedExpertList(Map<String, Object> param, int pageNo, int pageSize){
		
		// 取得已选择的专家信息
		Pager p = texpertScoreDao.getSelectedExpertList(param, pageNo, pageSize);
		
		if(p != null && p.getList() != null && p.getList().size() >0){
			
			List<TexpertScore> list = new ArrayList<TexpertScore>();
			for(int i=0; i < p.getList().size(); i++){
				TexpertScore texpertScore = (TexpertScore)p.getList().get(i);
				
				Texpert texpert = texpertScore.getTexpert();
				
				if(texpert != null){
					
					// 设置擅长专业1
					if(!"".equals(texpert.getExpertMajor1()) 
							&& texpert.getExpertMajor1() != null){
						// 取得擅长专业1
						String expertMajor1 = mitemDao.getItemName(texpert.getExpertMajor1());
						// 设置擅长专业1
						texpert.setExpertMajor1(expertMajor1);
					}
					
					// 设置擅长专业2
					if(!"".equals(texpert.getExpertMajor2()) 
							&& texpert.getExpertMajor2() != null){
						// 取得擅长专业2
						String expertMajor2 = mitemDao.getItemName(texpert.getExpertMajor2());
						// 设置擅长专业2
						texpert.setExpertMajor2(expertMajor2);
					}
					
					// 设置擅长专业3
					if(!"".equals(texpert.getExpertMajor3()) 
							&& texpert.getExpertMajor3() != null){
						// 取得擅长专业3
						String expertMajor3 = mitemDao.getItemName(texpert.getExpertMajor3());
						// 设置擅长专业3
						texpert.setExpertMajor3(expertMajor3);
					}
					
					// 设置信誉度等级
					if(!"".equals(texpert.getExpertPrestige()) 
							&& texpert.getExpertPrestige() != null){
						// 取得信誉度等级
						String expertPrestige = mitemDao.getItemName(texpert.getExpertPrestige());
						// 设置信誉度等级
						texpert.setExpertPrestige(expertPrestige);
					}
				}
				texpertScore.setTexpert(texpert);
				
				list.add(texpertScore);
			}
			p.setList(list);
		}
		
		return p;
	}
	
	/**
	 * @comments 取得已选择的专家信息
	 * @param param
	 * @param pageNo
	 * @param pageSize
	 * @return
	 * @Version 1.0
	 */
	public Pager getJointSelectedExpertList(Map<String, Object> param, int pageNo, int pageSize){
		
		// 取得已选择的专家信息
		Pager p = texpertScoreDao.getSelectedExpertList(param, pageNo, pageSize);
		
		if(p != null && p.getList() != null && p.getList().size() >0){
			
			List<TexpertScore> list = new ArrayList<TexpertScore>();
			for(int i=0; i < p.getList().size(); i++){
				TexpertScore texpertScore = (TexpertScore)p.getList().get(i);
				
				Texpert texpert = texpertScore.getTexpert();
				
				if(texpert != null){
					
					// 设置擅长专业1
					if(!"".equals(texpert.getExpertMajor1()) 
							&& texpert.getExpertMajor1() != null){
						// 取得擅长专业1
						String expertMajor1 = mitemDao.getItemName(texpert.getExpertMajor1());
						// 设置擅长专业1
						texpert.setExpertMajor1(expertMajor1);
					}
					
					// 设置擅长专业2
					if(!"".equals(texpert.getExpertMajor2()) 
							&& texpert.getExpertMajor2() != null){
						// 取得擅长专业2
						String expertMajor2 = mitemDao.getItemName(texpert.getExpertMajor2());
						// 设置擅长专业2
						texpert.setExpertMajor2(expertMajor2);
					}
					
					// 设置擅长专业3
					if(!"".equals(texpert.getExpertMajor3()) 
							&& texpert.getExpertMajor3() != null){
						// 取得擅长专业3
						String expertMajor3 = mitemDao.getItemName(texpert.getExpertMajor3());
						// 设置擅长专业3
						texpert.setExpertMajor3(expertMajor3);
					}
					
					// 设置信誉度等级
					if(!"".equals(texpert.getExpertPrestige()) 
							&& texpert.getExpertPrestige() != null){
						// 取得信誉度等级
						String expertPrestige = mitemDao.getItemName(texpert.getExpertPrestige());
						// 设置信誉度等级
						texpert.setExpertPrestige(expertPrestige);
					}
					
					// 已发送通知的专家判断
					// TODO
				}
				texpertScore.setTexpert(texpert);
				
				list.add(texpertScore);
			}
			p.setList(list);
		}
		
		return p;
	}
	
	/**
	 * @comments 
	 * @param projectId 项目ID
	 * @param selectExpertId 选择的专家ID
	 * @Version 1.0
	 */
	public void saveTexpertScores(String groupId, String selectExpertId,String userId){
		
		// 取得选择的专家ID数组
		String [] expertIds = selectExpertId.split(",");
		if(expertIds.length > 0){
			// 创建分组对象
			TprojectGroup tp = new TprojectGroup();
			
			// 设置项目ID
			tp.setGroupId(groupId);
			// 遍历专家ID数组
			for (int i = 0; i < expertIds.length; i++) {
				if (!"".equals(expertIds[i])) {

					// 创建专家评分对象
					TgroupExpertRealtion es = new TgroupExpertRealtion();

					// 设置组外键关联
					es.setTprojectGroup(tp);

					// 创建专家对象
					Texpert te = new Texpert();

					// 设置专家ID
					te.setExpertId(expertIds[i]);

					// 设置专家外键关联
					es.setTexpert(te);

					// 设置创建时间
					es.setCreateTime(new java.sql.Timestamp(new java.util.Date().getTime()));

					// 设置删除区分
					es.setDeleteFlag(Constant.DELETE_STATE_FALSE);

					// 设置创建者
					es.setCreateUser(userId);

					// 保存分组专家关系
					tgroupExpertRealtionDao.save(es);
				}
			}
		}
	}
	
	/**
	 * @comments 批量取得已选择的专家信息
	 * @param param
	 * @param pageNo
	 * @param pageSize
	 * @return
	 * @Version 1.0
	 */
	public Pager getBatchSelectedExpertList(Map<String, Object> param, int pageNo, int pageSize){
		// 取得已选择的专家信息
		Pager p = texpertScoreDao.getBatchSelectedExpertList(param, pageNo, pageSize);
		
		return p;
	}
	
	
	/**
	 * @comments 
	 * @param selectedProjectIds 选择的项目ID
	 * @param selectExpertId 选择的专家ID
	 * @Version 1.0
	 */
	public void saveBatchTexpertScores(String selectedProjectIds, String selectExpertId){
		
		// 取得选择的项目ID数组
		String [] projectIds = selectedProjectIds.split(",");
		
		// 取得选择的专家ID数组
		String [] expertIds = selectExpertId.split(",");
		
		// 遍历项目ID数组
		if(projectIds.length > 0){
			for(int j=0; j<projectIds.length; j++){
				if(!"".equals(projectIds[j])){
					
					if(expertIds.length > 0){
						
						// 遍历专家ID数组
						for(int i = 0; i< expertIds.length; i++){
							if(!"".equals(expertIds[i])){
								
								// 创建专家评分对象
								TexpertScore es = new TexpertScore();
								
								// 创建项目对象
								TprojectApplication tp = new TprojectApplication();
								
								// 设置项目ID
								tp.setProjectId(projectIds[j]);
								
								// 设置项目外键关联
								es.setTprojectApplication(tp);
								
								// 创建专家对象
								Texpert te = new Texpert();
								
								// 设置专家ID
								te.setExpertId(expertIds[i]);
								
								// 设置专家外键关联
								es.setTexpert(te);
								
								// 设置创建时间
								es.setCreateTime(new java.sql.Timestamp(new java.util.Date().getTime()));
								
								// 设置删除区分
								es.setDeleteFlag(Constant.DELETE_STATE_FALSE);
								
								// 保存专家评分对象
								texpertScoreDao.save(es);
							}
						}
					}
				}
			}
		}
	}
	
	/**
	 * @comments 取得已评审专家信息
	 * @param param
	 * @param pageNo
	 * @param pageSize
	 * @return
	 * @Version 1.0
	 */
	public Pager getProgressExpertList(Map<String, Object> param, int pageNo, int pageSize){
		// 取得已选择的专家信息
		Pager p = texpertScoreDao.getProgressExpertList(param, pageNo, pageSize);
		if(p != null && p.getList() != null && p.getList().size() >0){
			
			List<TexpertScore> list = new ArrayList<TexpertScore>();
			for(int i=0; i < p.getList().size(); i++){
				TexpertScore texpertScore = (TexpertScore)p.getList().get(i);
				
				Texpert texpert = texpertScore.getTexpert();
				
				if(texpert != null){
					
					// 设置擅长专业1
					if(!"".equals(texpert.getExpertMajor1()) 
							&& texpert.getExpertMajor1() != null){
						// 取得擅长专业1
						String expertMajor1 = mitemDao.getItemName(texpert.getExpertMajor1());
						// 设置擅长专业1
						texpert.setExpertMajor1(expertMajor1);
					}
					
					// 设置擅长专业2
					if(!"".equals(texpert.getExpertMajor2()) 
							&& texpert.getExpertMajor2() != null){
						// 取得擅长专业2
						String expertMajor2 = mitemDao.getItemName(texpert.getExpertMajor2());
						// 设置擅长专业2
						texpert.setExpertMajor2(expertMajor2);
					}
					
					// 设置擅长专业3
					if(!"".equals(texpert.getExpertMajor3()) 
							&& texpert.getExpertMajor3() != null){
						// 取得擅长专业3
						String expertMajor3 = mitemDao.getItemName(texpert.getExpertMajor3());
						// 设置擅长专业3
						texpert.setExpertMajor3(expertMajor3);
					}
					
					// 设置信誉度等级
					if(!"".equals(texpert.getExpertPrestige()) 
							&& texpert.getExpertPrestige() != null){
						// 取得信誉度等级
						String expertPrestige = mitemDao.getItemName(texpert.getExpertPrestige());
						// 设置信誉度等级
						texpert.setExpertPrestige(expertPrestige);
					}
					
					// 已发送通知的专家判断
					// TODO
				}
				texpertScore.setTexpert(texpert);
				
				list.add(texpertScore);
			}
			p.setList(list);
		}
		return p;
	}
	
	/**
	 * @comments 取得专家评审列表
	 * @param projectId 项目Id
	 * @return
	 * @Version 1.0
	 */
	public List<TexpertScore> getExpertScoreList(String projectId){
		
		// 取得专家评审列表
		List<TexpertScore> exList = texpertScoreDao.getTexpertScoreList(projectId);
		int tecCount = 1;
		int invCount = 1;
		// 封装转换数据
		if(exList != null && exList.size() > 0){
			for (TexpertScore texpertScore : exList) {
				
				// 专家信誉度
				if(texpertScore.getTexpert().getExpertPrestige() !=null 
						&& !"".equals(texpertScore.getTexpert().getExpertPrestige())){
					String expertPrestige = mitemDao.getItemName(texpertScore.getTexpert().getExpertPrestige());
					texpertScore.getTexpert().setExpertPrestige(expertPrestige);
				}
				
				// 专家类型
				if(texpertScore.getTexpert().getExpertType() !=null 
						&& !"".equals(texpertScore.getTexpert().getExpertType())){
					
					// 技术专家
					if(Constants.EXPERT_TYPE1.equals(texpertScore.getTexpert().getExpertType())){
						texpertScore.setResultFlag("0");
						texpertScore.setIndex(tecCount);
						tecCount ++ ;
					}
					else{
						// 投资专家
						texpertScore.setResultFlag("1");
						texpertScore.setIndex(invCount);
						invCount ++;
					}
					
					String expertType = mitemDao.getItemName(texpertScore.getTexpert().getExpertType());
					texpertScore.getTexpert().setExpertType(expertType);
					
					
				}
			}
		}
		else{
			TprojectApplication tp = tprojectApplicationDao.get(projectId);
			if(tp !=null){
				TprojectGroup tg = tp.getTprojectGroup();
				if(tg != null && tg.getGroupId() != null && !"".equals(tg.getGroupId())){
					List<TgroupExpertRealtion> tgList = tgroupExpertRealtionDao.getTgList(tg.getGroupId());
					if(tgList != null && tgList.size() > 0){
						for (TgroupExpertRealtion tgr : tgList) {
							
							TexpertScore tex = new TexpertScore();
							
							Texpert te = new Texpert();
							
							// 专家姓名
							te.setExpertName(tgr.getTexpert().getExpertName());
							
							// 专家ID
							te.setExpertId(tgr.getTexpert().getExpertId());
							
							// 专家信誉度
							if(tgr.getTexpert().getExpertPrestige() !=null 
									&& !"".equals(tgr.getTexpert().getExpertPrestige())){
								String expertPrestige = mitemDao.getItemName(tgr.getTexpert().getExpertPrestige());
								te.setExpertPrestige(expertPrestige);
							}
							
							// 专家类型
							if(tgr.getTexpert().getExpertType() !=null 
									&& !"".equals(tgr.getTexpert().getExpertType())){
								
								// 技术专家
								if(Constants.EXPERT_TYPE1.equals(tgr.getTexpert().getExpertType())){
									tex.setResultFlag("0");
									tex.setIndex(tecCount);
									tecCount ++ ;
								}
								else{
									// 投资专家
									tex.setResultFlag("1");
									tex.setIndex(invCount);
									invCount ++;
								}
								
								String expertType = mitemDao.getItemName(tgr.getTexpert().getExpertType());
								te.setExpertType(expertType);
							}
							
							tex.setTexpert(te);
							exList.add(tex);
						}
					}
				}
			}
		}
		return exList;
	}

	/**
	 * @comments 批量删除已选择专家
	 * @Version 1.0
	 */
	public void deleteBatchExpert(String expertIds, String projectId){
		
		// 专家Id数组
		String expertId[] = expertIds.split(",");
		// 项目Id数组
		String projectIds[] = projectId.split(",");
		
		for (String pro : projectIds) {
			for (String ex : expertId) {
				
				// 取得专家评分
				TexpertScore texpertScore = texpertScoreDao.getTexpertScore(ex, pro);
				
				if(texpertScore != null){
					// 删除专家评分
					texpertScoreDao.delete(texpertScore);
				}
			}
		}
		
	}
	
	/**
	 * @comments 删除已选择专家
	 * @Version 1.0
	 */
	public void deleteExpert(String expertId, String projectId){
		// 项目Id数组
		String projectIds [] = projectId.split(",");
		
		for (String string : projectIds) {
			// 取得专家评分
			TexpertScore texpertScore = texpertScoreDao.getTexpertScore(expertId, string);
			
			if(texpertScore != null){
				// 删除专家评分
				texpertScoreDao.delete(texpertScore);
			}
		}
	}

	// wanglw End

	/**
	 * @comments 删除已选择专家
	 * @Version 1.0
	 */
	public void deleteExpert(String relateionId){

		// 取得分组专家关联数据
		if(!"".equals(relateionId) && null != relateionId){
			TgroupExpertRealtion tge = tgroupExpertRealtionDao.get(relateionId);
			if(tge != null){
				tgroupExpertRealtionDao.delete(tge);
			}
		}
	}
	
	/**
	 * @comments 批量删除已选择专家
	 * @Version 1.0
	 */
	public void deleteBatchExpert(String relationIds){
		
		// 分组专家关联id
		String relationId[] = relationIds.split(",");
		
		for (String pro : relationId) {

			// 取得分组专家关联实体
			TgroupExpertRealtion relate = tgroupExpertRealtionDao.get(pro);
			if(relate!=null){
				tgroupExpertRealtionDao.delete(relate);
			}
		}
	}
	
	/**
	 * @comments 专家评审列表
	 * @param param
	 * @param pageNo
	 * @param pageSize
	 * @return
	 * @Version 1.0
	 */
	@SuppressWarnings("unchecked")
	public Pager getAuditList(Map<String, Object> param, int pageNo,int pageSize) {
		Pager pager = texpertScoreDao.getAuditList(param, pageNo, pageSize);
		List<Map<String,Object>> pagerList = new ArrayList<Map<String,Object>>();
		List<TexpertScore> all = pager.getList();
		if(all!=null&&all.size()>0){
			for(int i=0;i<all.size();i++){
				TexpertScore texpertScore = all.get(i);
				Map<String,Object> valueMap = new HashMap<String,Object>();
				//专家评审ID
				valueMap.put("scoreId", texpertScore.getScoreId());
				
				//项目信息
				TprojectApplication tprojectApplication = texpertScore.getTprojectApplication();
				//项目分类信息
				TprojectType tprojectType = tprojectApplication.getTprojectType();
				//项目ID
				valueMap.put("projectId", tprojectApplication.getProjectId());
				//项目名称
				valueMap.put("projectName", tprojectApplication.getProjectName());
				//申报单位 
				valueMap.put("applicationUnit", tprojectApplication.getApplicationUnit());
				//当前阶段
				valueMap.put("flowStatus", mitemDao.getItemName(tprojectApplication.getFlowStatus()));
				//项目分类
				valueMap.put("projectTypeId", tprojectType.getTypeId());
				//项目分类名称
				valueMap.put("projectTypeName", tprojectTypeDao.getProjectTypeAllName(tprojectType.getTypeId()));
				//状态 
				valueMap.put("applyStatus", mitemDao.getItemName(tprojectApplication.getApplyStatus()));
				
				if(tprojectApplication.getTprojectInfoAs()!=null&&tprojectApplication.getTprojectInfoAs().size()>0){
					TprojectInfoA tprojectInfoA = tprojectApplication.getTprojectInfoAs().get(0);
					//技术领域 TECHNICAL_FISLD
					valueMap.put("technicalFisld", mitemDao.getItemName(tprojectInfoA.getTechnicalFisld3()));
					//单位性质UNIT_PROPERTIES
					valueMap.put("unitProperties",  mitemDao.getItemName(tprojectInfoA.getUnitProperties()));
				}else{
					TprojectInfoB tprojectInfoB = tprojectApplication.getTprojectInfoBs().get(0);
					//技术领域 
					valueMap.put("technicalFisld", mitemDao.getItemName(tprojectInfoB.getTechnicalFisld3()));
					//单位性质
					valueMap.put("unitProperties",  mitemDao.getItemName(tprojectInfoB.getUnitProperties()));
				}
				pagerList.add(valueMap);
			}
		}
		pager.setList(pagerList);
		return pager;
	}
	
	//wangxd statr
	/**
	 * 查询已填写或者未填写的项目申报信息
	 * @comments 
	 * @param isWtite 0-未填写   1-填写
	 * @return
	 * @version 1.0
	 */
	public List<TprojectApplication> getProjectsByWriteState(Map<String,Object> param){
		List<TprojectApplication> projectList = new ArrayList<TprojectApplication>();
		//是否填写 0-未填写   1-填写
		String isWrite = (String)param.get("isWrite");
		List<TprojectApplication> projects = tprojectApplicationDao.getProjectList(param);
		if(projects!=null&&projects.size()>0){
			if(CommonTool.IsNotEmpty(isWrite)){
				for(TprojectApplication projectApplication : projects){
					//未填写
					if("0".equals(isWrite)){
						if(projectApplication.getTexpertScores()==null || projectApplication.getTexpertScores().size()==0){
							projectList.add(projectApplication);
						}
					}else{//已填写
						if(projectApplication.getTexpertScores()!=null&&projectApplication.getTexpertScores().size()>0){
							projectList.add(projectApplication);
						}
					}	
				}
			}else{
				projectList.addAll(projects);
			}
		}
		return projectList;
	}
	
	/**
	 * 查询项目申报下的专家评审记录
	 * @comments 
	 * @param projectId
	 * @return
	 * @version 1.0
	 */
	public Map<String,Object> getTexpertScoresByProjectId(String projectId) {
		Map<String,Object> valueMap = new HashMap<String,Object>();
		//技术专家评审集合
		List<TexpertScore> technologyList = new ArrayList<TexpertScore>();
		//投资专家评审集合
		List<TexpertScore> investmentList = new ArrayList<TexpertScore>();
		
		//项目申报信息
		TprojectApplication tprojectApplication = tprojectApplicationDao.get(projectId);
		if(tprojectApplication!=null){
			//项目专家评审集合
			List<TexpertScore> texpertScores = tprojectApplication.getTexpertScores();
			//如果项目有专家评审记录
			if(texpertScores!=null&&texpertScores.size()>0){
				for(TexpertScore texpertScore : texpertScores){
					if(texpertScore!=null){
						Texpert texpert = texpertScore.getTexpert();
						if(texpert!=null){
							if(Constants.EXPERT_TYPE1.equals(texpert.getExpertType())){
								technologyList.add(texpertScore);
							}else if(Constants.EXPERT_TYPE2.equals(texpert.getExpertType())){
								investmentList.add(texpertScore);
							}
						}
					}
				}
			}else{
				//如果没有项目有专家评审记录
				//项目对应的组信息
				TprojectGroup tprojectGroup = tprojectApplication.getTprojectGroup();
				if(tprojectGroup!=null){
					//组和专家对应关系
					List<TgroupExpertRealtion> tgroupExpertRealtions = tprojectGroup.getTgroupExpertRealtions();
					if(tgroupExpertRealtions!=null&&tgroupExpertRealtions.size()>0){
						for(TgroupExpertRealtion tgroupExpertRealtion : tgroupExpertRealtions){
							if(tgroupExpertRealtion!=null){
								//专家信息
								Texpert texpert = tgroupExpertRealtion.getTexpert();
								if(texpert!=null){
									TexpertScore texpertScore = new TexpertScore();
									texpertScore.setTprojectApplication(tprojectApplication);
									texpertScore.setTexpert(texpert);
									if(Constants.EXPERT_TYPE1.equals(texpert.getExpertType())){
										technologyList.add(texpertScore);
									}else if(Constants.EXPERT_TYPE2.equals(texpert.getExpertType())){
										investmentList.add(texpertScore);
									}
								}
							}
						}
					}
				}
			}
			
			//得到项目分类
			TprojectType tprojectType = tprojectApplication.getTprojectType();
			if(tprojectType!=null){
				List<TexpertReviewComments> texpertReviewCommentList = tprojectType.getTexpertReviewComments();
				if(texpertReviewCommentList!=null&&texpertReviewCommentList.size()>0){
					for(TexpertReviewComments texpertReviewComments : texpertReviewCommentList){
						if(texpertReviewComments!=null){
							if(Constants.COMMON_STATE_NOTDELETE.equals(texpertReviewComments.getDeleteFlag())){
								// 技术专家模板
								if(Constants.EXPERT_TYPE1.equals(texpertReviewComments.getExpertType())){
									valueMap.put("technologyReviewComments",texpertReviewComments);
								}else if(Constants.EXPERT_TYPE2.equals(texpertReviewComments.getExpertType())){
									// 投资专家模板
									valueMap.put("investmentReviewComments",texpertReviewComments);
								}
							}	
						}
					}
				}
			}
		}
		
		valueMap.put("technologyList",technologyList);
		valueMap.put("investmentList",investmentList);
		
		return valueMap;
	}

	@SuppressWarnings("unchecked")
	public void saveExpertScore(Map<String,Object> valueMap){
		//项目ID
		String projectId = (String) valueMap.get("projectId");
		//技术专家评审集合
		List<TexpertScore> technologyList = (List<TexpertScore>) valueMap.get("technologyList");
		//投资专家评审集合
		List<TexpertScore> investmentList = (List<TexpertScore>) valueMap.get("investmentList");
		//项目技术专家平均分
		double projectTechnologyAverage = (Double) valueMap.get("projectTechnologyAverage");
		//项目投资专家平均分
		double projectInvestmentAverage = (Double) valueMap.get("projectInvestmentAverage");
		//操作用户
		ScUsers user = (ScUsers) valueMap.get("user");
		
		//技术专家评审结果集合
		List<String> technologyResultList = new ArrayList<String>();
		//投资专家评审结果集合
		List<String> investmentResultList = new ArrayList<String>();
		
		TprojectApplication tprojectApplication = tprojectApplicationDao.get(projectId);
		
		//循环保存技术专家意见
		if(technologyList!=null&&technologyList.size()>0){
			for(TexpertScore texpertScore : technologyList){
				if(texpertScore!=null){
					if(tprojectApplication!=null){
						texpertScore.setTprojectApplication(tprojectApplication);
						//修改
						if(CommonTool.IsNotEmpty(texpertScore.getScoreId())){
							texpertScore.setUpdateDate(new java.sql.Timestamp(new java.util.Date().getTime()));
							texpertScore.setUpdateUser(user.getUserId());
							texpertScoreDao.update(texpertScore);
						}else{
							//保存
							texpertScore.setDeleteFlag(Constants.COMMON_STATE_NOTDELETE);
							texpertScore.setCreateTime(new java.sql.Timestamp(new java.util.Date().getTime()));
							texpertScore.setCreateUser(user.getUserId());
							texpertScoreDao.save(texpertScore);
						}
						technologyResultList.add(texpertScore.getFinalResult());
					}
				}
			}
		}
		
		//循环保存投资专家意见
		if(investmentList!=null&&investmentList.size()>0){
			for(TexpertScore texpertScore : investmentList){
				if(texpertScore!=null){
					if(tprojectApplication!=null){
						texpertScore.setTprojectApplication(tprojectApplication);
						//修改
						if(CommonTool.IsNotEmpty(texpertScore.getScoreId())){
							texpertScore.setUpdateDate(new java.sql.Timestamp(new java.util.Date().getTime()));
							texpertScore.setUpdateUser(user.getUserId());
							texpertScoreDao.update(texpertScore);
						}else{
							//保存
							texpertScore.setDeleteFlag(Constants.COMMON_STATE_NOTDELETE);
							texpertScore.setCreateTime(new java.sql.Timestamp(new java.util.Date().getTime()));
							texpertScore.setCreateUser(user.getUserId());
							texpertScoreDao.save(texpertScore);
						}
						investmentResultList.add(texpertScore.getFinalResult());
					}
				}
			}
		}
		
		/********更新项目信息************/
		//技术专家平均分
		tprojectApplication.setProjectTechnologyAverage(projectTechnologyAverage);
		//投资专家平均分
		tprojectApplication.setProjectInvestmentAverage(projectInvestmentAverage);
		//项目总平均分
		tprojectApplication.setProjectAverage((projectTechnologyAverage+projectInvestmentAverage)/2);
		//技术专家评审结果
		tprojectApplication.setProjectTechnologyResult(resultSort(technologyResultList));
		//投资专家评审结果
		tprojectApplication.setProjectInvestmentResult(resultSort(investmentResultList));
		//tprojectApplicationDao.update(tprojectApplication);
	}
	
	/**
	 * 通过组打印专家评审数据
	 * @comments 
	 * @param valueMap
	 * @return
	 * @version 1.0
	 */
	public Map<String,Object> printExpertScoreByGroup(String groupId) {
		Map<String,Object> resultMap = new HashMap<String,Object>();
		List<List<Object>> resultList = new ArrayList<List<Object>>();
		
		//专家集合
		List<Object[]> expertList = new ArrayList<Object[]>();
		List<Object[]> all = texpertScoreDao.printExpertScoreByGroup(groupId);
		if(all!=null&&all.size()>0){
			String projectId = "";
			//一个项目的所有专家评审集合
			List<Object> list = new ArrayList<Object>();
			//技术专家平均分	
			//double technologyComplexAverage = 0.0;
			//投资专家平均分	
			//double investmentComplexAverage = 0.0;
			//技术专家推荐意见	
			//StringBuffer technologyFinalResult = new StringBuffer();
			//投资专家推荐意见
			//StringBuffer investmentFinalResult = new StringBuffer();
			//项目技术专家个数
			//int technologyExpertCount = 0;
			//项目投资专家个数
			//int investmentExpertCount = 0;
			TprojectApplication tprojectApplication = new TprojectApplication();
			for(int i=0;i<all.size();i++){
				Object[] objs = all.get(i);
				if(objs!=null&&objs.length>0){
					//专家
					String expertId = String.valueOf(objs[12]==null?"":objs[12]);
					String expertName = String.valueOf(objs[3]==null?"":objs[3]);
					if(addList(expertList,expertId)){
						Object[] datas = new Object[]{expertId,expertName};
						expertList.add(datas);
					}
					//第一次循环
					if(i==0){
						projectId = String.valueOf(objs[0]);
						//项目名称
						list.add(objs[1]);
					}
					//判断是否同一个项目
					if(!projectId.equals(objs[0])){
						tprojectApplication = tprojectApplicationDao.get(projectId);
						//技术专家平均分
						/*if(technologyExpertCount==0){
							list.add(formatDouble(technologyComplexAverage));
						}else{
							list.add(formatDouble(technologyComplexAverage/technologyExpertCount));
						}*/
						list.add(tprojectApplication.getProjectTechnologyAverage());
						//投资专家平均分
						/*if(investmentExpertCount==0){
							list.add(formatDouble(investmentComplexAverage));
						}else{
							list.add(formatDouble(investmentComplexAverage/investmentExpertCount));
						}*/
						list.add(tprojectApplication.getProjectInvestmentAverage());
						//技术专家推荐意见	
						//list.add(technologyFinalResult.toString());
						list.add(tprojectApplication.getProjectTechnologyResult()==null?"":tprojectApplication.getProjectTechnologyResult());
						//投资专家推荐意见	
						//list.add(investmentFinalResult.toString());
						list.add(tprojectApplication.getProjectInvestmentResult()==null?"":tprojectApplication.getProjectInvestmentResult());
						resultList.add(list);
						
						/****************新项目所有专家评审数据开始*******************/
						list = new ArrayList<Object>();
						//技术专家平均分	
						//technologyComplexAverage = 0.0;
						//投资专家平均分	
						//investmentComplexAverage = 0.0;
						//技术专家推荐意见	
						//technologyFinalResult = new StringBuffer();
						//投资专家推荐意见
						//investmentFinalResult = new StringBuffer();
						//项目技术专家个数
						//technologyExpertCount = 0;
						//项目投资专家个数
						//investmentExpertCount = 0;
						projectId = String.valueOf(objs[0]);
						//项目名称
						list.add(objs[1]);
					}
					
					//分项1
					list.add(objs[4]==null?0:objs[4]);
					//分项2
					list.add(objs[5]==null?0:objs[5]);
					//分项3
					list.add(objs[6]==null?0:objs[6]);
					//分项4
					list.add(objs[7]==null?0:objs[7]);
					//分项5
					list.add(objs[8]==null?0:objs[8]);
					//平均分
					//list.add(objs[9]==null?0.0:objs[9]);
					//总分
					list.add(objs[9]==null?0:objs[9]);
					//推荐等级
					list.add(objs[11]==null?"":objs[11]);
					
					/***********判断专家类型：技术专家    投资专家*************/
					/*String expertType = String.valueOf(objs[2]==null?"":objs[2]);
					if(CommonTool.IsNotEmpty(expertType)){
						double complexAverage = (Double) (objs[10]==null?0.0:objs[10]);
						String finalResult = String.valueOf(objs[11]==null?"":objs[11]);
						//技术专家
						if(Constants.EXPERT_TYPE1.equals(expertType)){
							technologyExpertCount = technologyExpertCount + 1;
							technologyComplexAverage = technologyComplexAverage + Double.valueOf(complexAverage);
							if(CommonTool.IsNotEmpty(finalResult)){
								technologyFinalResult.append(finalResult.toUpperCase());
							}	
						}else if(Constants.EXPERT_TYPE2.equals(expertType)){
							//投资专家
							investmentExpertCount = investmentExpertCount + 1;
							investmentComplexAverage = investmentComplexAverage + Double.valueOf(complexAverage);
							if(CommonTool.IsNotEmpty(finalResult)){
								investmentFinalResult.append(finalResult.toUpperCase());
							}
						}
					}*/
				}
				//最后一条记录加入list
				if(i==all.size()-1){
					tprojectApplication = tprojectApplicationDao.get(String.valueOf(objs[0]));
					//技术专家平均分
					/*if(technologyExpertCount==0){
						list.add(formatDouble(technologyComplexAverage));
					}else{
						list.add(formatDouble(technologyComplexAverage/technologyExpertCount));
					}*/
					list.add(tprojectApplication.getProjectTechnologyAverage());
					//投资专家平均分
					/*if(investmentExpertCount==0){
						list.add(formatDouble(investmentComplexAverage));
					}else{
						list.add(formatDouble(investmentComplexAverage/investmentExpertCount));
					}*/
					list.add(tprojectApplication.getProjectInvestmentAverage());
					//技术专家推荐意见	
					//list.add(technologyFinalResult.toString());
					list.add(tprojectApplication.getProjectTechnologyResult()==null?"":tprojectApplication.getProjectTechnologyResult());
					//投资专家推荐意见	
					//list.add(investmentFinalResult.toString());
					list.add(tprojectApplication.getProjectInvestmentResult()==null?"":tprojectApplication.getProjectInvestmentResult());
					resultList.add(list);
				}
			}
		}
		
		resultMap.put("expertList", expertList);
		resultMap.put("resultList", resultList);
		
		return resultMap;
	}
	
	/**
	 * 通过项目打印专家评审数据
	 * @comments 
	 * @param projectId
	 * @return
	 * @version 1.0
	 */
	public Map<String,Object> printExpertScoreByProject(String projectId){
		Map<String,Object> resultMap = new HashMap<String,Object>();
		List<List<Object>> resultList = new ArrayList<List<Object>>();
		
		//专家集合
		List<String> expertList = new ArrayList<String>();
		List<TexpertScore> all = texpertScoreDao.getTexpertScoreList(projectId);
		TprojectApplication tprojectApplication = tprojectApplicationDao.get(projectId);
		if(all!=null&&all.size()>0){
			//一个项目的所有专家评审集合
			List<Object> list = new ArrayList<Object>();
			//技术专家平均分	
			//double technologyComplexAverage = 0.0;
			//投资专家平均分	
			//double investmentComplexAverage = 0.0;
			//技术专家推荐意见	
			//StringBuffer technologyFinalResult = new StringBuffer();
			//投资专家推荐意见
			//StringBuffer investmentFinalResult = new StringBuffer();
			//项目技术专家个数
			//int technologyExpertCount = 0;
			//项目投资专家个数
			//int investmentExpertCount = 0;
			
			for(int i=0;i<all.size();i++){
				TexpertScore texpertScore = all.get(i);
				if(texpertScore!=null){
					Texpert texpert = texpertScore.getTexpert();
					if(texpert!=null){
						expertList.add(texpert.getExpertName());
					}
					//项目名称
					if(i==0){
						list.add(texpertScore.getTprojectApplication().getProjectName());
					}
					//分项1
					list.add(texpertScore.getCompanyStatusScore());
					//分项2
					list.add(texpertScore.getProjectTechnologyScore());
					//分项3
					list.add(texpertScore.getProjectBaseScore());
					//分项4
					list.add(texpertScore.getProjectMarketScore());
					//分项5
					list.add(texpertScore.getProjectBenefitScore());
					//平均分
					//list.add(texpertScore.getComplexAverage());
					//总分
					list.add(texpertScore.getComplexScore());
					//推荐等级
					list.add(texpertScore.getFinalResult());
					
					/***********判断专家类型：技术专家    投资专家*************/
					/*if(texpert!=null){
						String expertType = texpert.getExpertType();
						if(CommonTool.IsNotEmpty(expertType)){
							double complexAverage = texpertScore.getComplexAverage();
							String finalResult = texpertScore.getFinalResult();
							//技术专家
							if(Constants.EXPERT_TYPE1.equals(expertType)){
								technologyExpertCount = technologyExpertCount + 1;
								technologyComplexAverage = technologyComplexAverage + Double.valueOf(complexAverage);
								if(CommonTool.IsNotEmpty(finalResult)){
									technologyFinalResult.append(finalResult.toUpperCase());
								}	
							}else if(Constants.EXPERT_TYPE2.equals(expertType)){
								//投资专家
								investmentExpertCount = investmentExpertCount + 1;
								investmentComplexAverage = investmentComplexAverage + Double.valueOf(complexAverage);
								if(CommonTool.IsNotEmpty(finalResult)){
									investmentFinalResult.append(finalResult.toUpperCase());
								}
							}
						}
					}*/
				}
				
			}
			//技术专家平均分
			/*if(technologyExpertCount==0){
				list.add(formatDouble(technologyComplexAverage));
			}else{
				list.add(formatDouble(technologyComplexAverage/technologyExpertCount));
			}*/
			list.add(tprojectApplication.getProjectTechnologyAverage());
			//投资专家平均分
			/*if(investmentExpertCount==0){
				list.add(formatDouble(investmentComplexAverage));
			}else{
				list.add(formatDouble(investmentComplexAverage/investmentExpertCount));
			}*/
			list.add(tprojectApplication.getProjectInvestmentAverage());
			//技术专家推荐意见	
			//list.add(technologyFinalResult.toString());
			list.add(tprojectApplication.getProjectTechnologyResult()==null?"":tprojectApplication.getProjectTechnologyResult());
			//投资专家推荐意见	
			//list.add(investmentFinalResult.toString());
			list.add(tprojectApplication.getProjectInvestmentResult()==null?"":tprojectApplication.getProjectInvestmentResult());
			resultList.add(list);
		}
		
		resultMap.put("expertList", expertList);
		resultMap.put("resultList", resultList);
		
		return resultMap;
	}
	
	/**
	 * 通过查询条件打印专家评审数据
	 * @comments 
	 * @param paramMap
	 * @return
	 * @version 1.0
	 */
	public List<Map<String,Object>> printExpertScoreAll(Map<String,Object> paramMap){
		List<Map<String,Object>> resultList = new ArrayList<Map<String,Object>>();
		List<Object[]> all = tprojectApplicationJointDao.printExpertScoreAll(paramMap);
		//以组为单位封装专家评审结果
		Map<String,Object> groupMap = new HashMap<String,Object>();
		
		
		if(all!=null&&all.size()>0){
			String groupId = "";
			String projectId = "";
			//封装每个项目的专家评审结果
			List<Object> projectList = new ArrayList<Object>();
			//一个项目的所有专家评审集合
			List<Object> list = new ArrayList<Object>();
			//专家集合
			List<Object[]> expertList = new ArrayList<Object[]>();
			
			for(int i=0;i<all.size();i++){
				Object[] objs = all.get(i);
				if(objs!=null&&objs.length>0){
					//第一次循环
					if(i==0){
						groupId = String.valueOf(objs[0]);
						projectId = String.valueOf(objs[2]);
						//组名称
						groupMap.put("groupName", String.valueOf(objs[1]));
						//项目名称
						list.add(objs[3]);
					}
					
					//判断是否同一组
					if(!groupId.equals(objs[0])){
						TprojectApplication tprojectApplication = tprojectApplicationDao.get(projectId);
						//技术专家平均分
						list.add(tprojectApplication.getProjectTechnologyAverage());
						//投资专家平均分
						list.add(tprojectApplication.getProjectInvestmentAverage());
						//技术专家推荐意见	
						list.add(tprojectApplication.getProjectTechnologyResult()==null?"":tprojectApplication.getProjectTechnologyResult());
						//投资专家推荐意见	
						list.add(tprojectApplication.getProjectInvestmentResult()==null?"":tprojectApplication.getProjectInvestmentResult());
						projectList.add(list);
						
						//专家
						groupMap.put("expertList",expertList);
						//封装后组下所有的项目专家评审结果
						groupMap.put("projectList",projectList);
						resultList.add(groupMap);
						
						/****************新组所有专家评审数据开始*******************/
						groupMap = new HashMap<String,Object>();
						projectList = new ArrayList<Object>();
						expertList = new ArrayList<Object[]>();
						list = new ArrayList<Object>();
						groupId = String.valueOf(objs[0]);
						projectId = String.valueOf(objs[2]);
						
						//组名称
						groupMap.put("groupName", String.valueOf(objs[1]));
						//项目名称
						list.add(objs[3]);	
						
					}else{
						//判断是否同一个项目
						if(!projectId.equals(objs[2])){
							TprojectApplication tprojectApplication = tprojectApplicationDao.get(projectId);
							//技术专家平均分
							list.add(tprojectApplication.getProjectTechnologyAverage());
							//投资专家平均分
							list.add(tprojectApplication.getProjectInvestmentAverage());
							//技术专家推荐意见	
							list.add(tprojectApplication.getProjectTechnologyResult()==null?"":tprojectApplication.getProjectTechnologyResult());
							//投资专家推荐意见	
							list.add(tprojectApplication.getProjectInvestmentResult()==null?"":tprojectApplication.getProjectInvestmentResult());
							projectList.add(list);
							
							/****************新项目所有专家评审数据开始*******************/
							list = new ArrayList<Object>();
							//expertList = new ArrayList<Object[]>();
							projectId = String.valueOf(objs[2]);
							//项目名称
							list.add(objs[3]);
						}
					}
					
					//分项1
					list.add(objs[6]==null?0:objs[6]);
					//分项2
					list.add(objs[7]==null?0:objs[7]);
					//分项3
					list.add(objs[8]==null?0:objs[8]);
					//分项4
					list.add(objs[9]==null?0:objs[9]);
					//分项5
					list.add(objs[10]==null?0:objs[10]);
					//平均分
					//list.add(objs[11]==null?0.0:objs[11]);
					//总分
					list.add(objs[11]==null?0:objs[11]);
					//推荐等级
					list.add(objs[13]==null?"":objs[13]);
					
					//专家
					String expertId = String.valueOf(objs[14]==null?"":objs[14]);
					String expertName = String.valueOf(objs[4]==null?"":objs[4]);
					if(addList(expertList,expertId)){
						Object[] datas = new Object[]{expertId,expertName};
						expertList.add(datas);
					}
				}
				
				//最后一条记录加入list
				if(i==all.size()-1){
					TprojectApplication tprojectApplication = tprojectApplicationDao.get(String.valueOf(objs[2]));
					//技术专家平均分
					list.add(tprojectApplication.getProjectTechnologyAverage());
					//投资专家平均分
					list.add(tprojectApplication.getProjectInvestmentAverage());
					//技术专家推荐意见	
					list.add(tprojectApplication.getProjectTechnologyResult()==null?"":tprojectApplication.getProjectTechnologyResult());
					//投资专家推荐意见	
					list.add(tprojectApplication.getProjectInvestmentResult()==null?"":tprojectApplication.getProjectInvestmentResult());
					projectList.add(list);
					
					//专家
					groupMap.put("expertList",expertList);
					groupMap.put("projectList",projectList);
					resultList.add(groupMap);
				}
			}
		}
		return resultList;
	}
	
	/*private double formatDouble(double doubleValue){
		BigDecimal b = new BigDecimal(doubleValue);
		return b.setScale(2,BigDecimal.ROUND_HALF_UP).doubleValue();
	}*/
	
	private boolean addList(List<Object[]> list,String expertId){
		boolean flag = true;
		if(list!=null&&list.size()>0){
			for(int i=0;i<list.size();i++){
				Object[] obj = list.get(i);
				if(obj!=null&&obj.length>0){
					String eId = String.valueOf(obj[0]==null?"":obj[0]);
					if(eId.equals(expertId)){
						flag = false;
					}
				}
			}
		}
		return flag;
	}
	
	/**
	 * 通过条件查询该组下项目信息-分页
	 * @comments 
	 * @param param
	 * @param pageNo
	 * @param pageSize
	 * @return
	 * @version 1.0
	 */
	@SuppressWarnings("unchecked")
	public Pager getProjecsByGroupId(Map<String, Object> param, int pageNo, int pageSize) {
		
		Pager pager = tprojectApplicationDao.getProjecsByGroupId(param, pageNo, pageSize);
		List<TprojectApplication> all = pager.getList();
		if(all!=null&&all.size()>0){
			List<Map<String,Object>> resultList = new ArrayList<Map<String,Object>>();
			for(int i=0;i<all.size();i++){
				TprojectApplication tprojectApplication = (TprojectApplication) all.get(i);
				if(tprojectApplication!=null){
					Map<String,Object> valueMap = new HashMap<String,Object>();
					//项目ID
					valueMap.put("projectId", tprojectApplication.getProjectId());
					//项目名称
					valueMap.put("projectName", tprojectApplication.getProjectName());
					//申报单位
					valueMap.put("applicationUnit", tprojectApplication.getApplicationUnit());
					//项目分类
					valueMap.put("typeId", tprojectApplication.getTprojectType().getTypeId());
					//项目分类名称
					valueMap.put("projectTypeName", tprojectApplication.getPlanFlagName() + Constants.STRING_LINK + tprojectApplication.getTypeName());
					//项目负责人
					List<TprojectInfoA> tprojectInfoAs = tprojectApplication.getTprojectInfoAs();
					if(tprojectInfoAs!=null&&tprojectInfoAs.size()>0){
						TprojectInfoA tprojectInfoA = tprojectInfoAs.get(0);
						valueMap.put("projectPerson", tprojectInfoA.getProjectPerson());
					}else{
						List<TprojectInfoB> tprojectInfoBs = tprojectApplication.getTprojectInfoBs();
						if(tprojectInfoBs!=null&&tprojectInfoBs.size()>0){
							TprojectInfoB tprojectInfoB = tprojectInfoBs.get(0);
							valueMap.put("projectPerson", tprojectInfoB.getProjectPerson());
						}
					}
					//填写状态
					List<TexpertScore> texpertScores = tprojectApplication.getTexpertScores();
					if(texpertScores!=null&&texpertScores.size()>0){
						valueMap.put("isWrite", "1");
					}else{
						valueMap.put("isWrite", "0");
					}
					
					resultList.add(valueMap);
				}
			}
			pager.setList(resultList);
		}
		return pager;
	}
	
	/**
	 * 评审结果排序  例如：AABCC
	 * @comments 
	 * @param resultList
	 * @return
	 * @version 1.0
	 */
	private String resultSort(List<String> resultList){
		StringBuffer resultStr = new StringBuffer();
		if(resultList!=null&&resultList.size()>0){
			 Collections.sort(resultList);
			 for(String result : resultList){
				 resultStr.append(result);
			 }
		}
		return resultStr.toString();
	}
	
	/**
	 * 得到下一个项目的评审信息
	 * @comments 
	 * @param paramMap
	 * @return
	 * @version 1.0
	 */
	public Map<String,Object> getNextProjectScore(Map<String,Object> paramMap){
		Map<String,Object> valueMap = new HashMap<String,Object>();
		//当前项目ID
		String projectId = (String) paramMap.get("projectId");
		//当前项目的索引下标
		String projectIndex = (String) paramMap.get("projectIndex");
		//组ID
		String groupId = (String) paramMap.get("groupId");
		
		List<TprojectApplication> tprojectApplications = tprojectApplicationDao.getProjectList(paramMap);
		if(tprojectApplications!=null&&tprojectApplications.size()>0){
			if(CommonTool.IsNotEmpty(projectIndex)){
				int indexValue = Integer.parseInt(projectIndex);
				int nowIndex = indexValue + 1;
				if(nowIndex<tprojectApplications.size()){
					TprojectApplication tprojectApplication = tprojectApplications.get(nowIndex);
					if(tprojectApplication!=null){
						valueMap.put("projectId", tprojectApplication.getProjectId());
						valueMap.put("projectIndex", nowIndex);
					}
				}else{
					valueMap.put("projectId", projectId);
					valueMap.put("projectIndex", projectIndex);
					valueMap.put("retMsg", "no");
				}
			}
		}
		valueMap.put("groupId", groupId);
		
		return valueMap;
	}
	
	//wangxd end
	
	/**
	 * 根据分组ID查询该分组选中的专家 
	 */
	@Override
	public List<Map<String, Object>> getSelectedExpertListByGroupId(String groupId) {
		List<Map<String, Object>> selectedExpertList = new ArrayList<Map<String,Object>>();
		
		List<TgroupExpertRealtion> tgList = tgroupExpertRealtionDao.getTgList(groupId);
		if(tgList != null && tgList.size() > 0){
			for (TgroupExpertRealtion tgr : tgList) {
				
				Map<String,Object> valueMap = new HashMap<String,Object>();
				//分组专家关联ID
				valueMap.put("relationId", tgr.getRelationId());
				// 专家姓名
				valueMap.put("expertName", tgr.getTexpert().getExpertName());
				// 擅长专业1
				if(CommonTool.IsNotEmpty(tgr.getTexpert().getExpertMajor1())){
					valueMap.put("expertMajor1", mitemDao.getItemName(tgr.getTexpert().getExpertMajor1()));
				}
				// 擅长专业2
				if (CommonTool.IsNotEmpty(tgr.getTexpert().getExpertMajor2()) ) {
					valueMap.put("expertMajor2", mitemDao.getItemName(tgr.getTexpert().getExpertMajor2()));
				}
				// 擅长专业3
				if (CommonTool.IsNotEmpty(tgr.getTexpert().getExpertMajor3()) ) {
					valueMap.put("expertMajor3", mitemDao.getItemName(tgr.getTexpert().getExpertMajor3()));
				}
				// 工作单位
				valueMap.put("expertWork", tgr.getTexpert().getExpertWork());
				// 专家类型
				valueMap.put("expertType", mitemDao.getItemName(tgr.getTexpert().getExpertType()));
				// 信誉度
				if (CommonTool.IsNotEmpty(tgr.getTexpert().getExpertPrestige()) ) {
					valueMap.put("expertPrestige", mitemDao.getItemName(tgr.getTexpert().getExpertPrestige()));
				}
				// 联系电话
				valueMap.put("phone", tgr.getTexpert().getPhone());
				
				selectedExpertList.add(valueMap);
			}
			
		}
		return selectedExpertList;
	}
}