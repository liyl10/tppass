/*************** 版权声明***************
*
* Copyright (C) 2012 西安辉盛科技发展有限责任公司.
*
********************************************
*/
package com.hopsun.tppas.api.expert.dao.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.hopsun.framework.base.bean.Finder;
import com.hopsun.framework.base.bean.Pager;
import com.hopsun.framework.base.dao.impl.BaseDaoImpl;
import com.hopsun.scenter.api.util.Constant;
import com.hopsun.tppas.api.expert.dao.TexpertScoreDao;
import com.hopsun.tppas.common.CommonTool;
import com.hopsun.tppas.entity.TexpertScore;

/**
 * @comments 专家评分
 * @author wanglw
 * @date 2013-9-12 @time 下午3:51:11
 * @Version 1.0
 */
@Repository
public class TexpertScoreDaoImpl extends BaseDaoImpl<TexpertScore, String> implements TexpertScoreDao {
	
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
		
		//创建Finder查询对象
		String hql = this.createHql(param);
		
		Finder f = Finder.create(hql);
		
		//排序条件
		f.append(" order by t.createTime desc");
		
		return super.find(f, pageNo, pageSize);
	}
	
	
	/**
	 * @comments 生成hql
	 * @param param
	 * @return
	 * @Version 1.0
	 */
	private String createHql(Map<String, Object> param){
		StringBuffer hql = new StringBuffer();
		
		// 生成hql
		hql.append(" from TexpertScore t ");
		
		hql.append(" where 1=1 ");
		
		// 项目Id
	    String projectId = (String) param.get("projectId");
	    if (!isNullString(projectId)) {
			hql.append(" and t.tprojectApplication.projectId ='" + projectId.trim() + "'");
		}
		
		// 专家名称
	    String expertName = (String) param.get("expertName");
	    if (!isNullString(expertName)) {
			hql.append(" and t.texpert.expertName like '%" + expertName.trim() + "%'");
		}
	    
	    // 擅长专业
	    String goodProfess = (String) param.get("goodProfess");
	    if (!isNullString(goodProfess)) {
	    	hql.append(" and t.texpert.expertMajor1 = '" + goodProfess.trim() + "'");
	    	hql.append(" or t.texpert.expertMajor2 = '" + goodProfess.trim() + "'");
	    	hql.append(" or t.texpert.expertMajor3 = '" + goodProfess.trim() + "'");
	    }
	    
	    // 信誉度级别
	    String credibyLevel = (String) param.get("credibyLevel");
	    if (!isNullString(credibyLevel)) {
	    	hql.append(" and t.texpert.expertPrestige = '" + credibyLevel.trim() + "'");
	    }
	    	
	    hql.append(" and t.deleteFlag = '"+ Constant.DELETE_STATE_FALSE +"'");
		return hql.toString();
	}
	
	
	
	
	/**
	 * @comments 取得已选择的专家信息
	 * @param param
	 * @param pageNo
	 * @param pageSize
	 * @return
	 * @Version 1.0
	 */
	public Pager getBatchSelectedExpertList(Map<String, Object> param, int pageNo, int pageSize){
		
		//创建Finder查询对象
		String hql = this.createBatchHql(param);
		
		Finder f = Finder.create(hql);
		
		//排序条件
		f.append(" order by t.createTime desc");
		
		return super.find(f, pageNo, pageSize);
	}
	
	
	
	/**
	 * @comments 生成hql
	 * @param param
	 * @return
	 * @Version 1.0
	 */
	private String createBatchHql(Map<String, Object> param){
		StringBuffer hql = new StringBuffer();
		
		// 生成hql
		hql.append(" from TexpertScore t ");
		
		hql.append(" where 1=1 ");
		
		// 项目Id
	    String projectId = (String) param.get("projectId");
	    if (!isNullString(projectId)) {
	    	// 取得项目Id数组
	    	String projectIds [] = projectId.split(",");
	    	if(projectIds != null && projectIds.length > 0){
	    		
	    		if(!isNullString(projectIds[0])){
	    			hql.append(" and t.tprojectApplication.projectId = '" +projectIds[0]+"' ");
	    		}
	    	}
		}
		
		// 专家名称
	    String expertName = (String) param.get("expertName");
	    if (!isNullString(expertName)) {
			hql.append(" and t.texpert.expertName like '%" + expertName.trim() + "%'");
		}
	    
	    // 擅长专业
	    String goodProfess = (String) param.get("goodProfess");
	    if (!isNullString(goodProfess)) {
	    	hql.append(" and t.texpert.expertMajor1 = '" + goodProfess.trim() + "'");
	    	hql.append(" or t.texpert.expertMajor2 = '" + goodProfess.trim() + "'");
	    	hql.append(" or t.texpert.expertMajor3 = '" + goodProfess.trim() + "'");
	    }
	    
	    // 信誉度级别
	    String credibyLevel = (String) param.get("credibyLevel");
	    if (!isNullString(credibyLevel)) {
	    	hql.append(" and t.texpert.expertPrestige = '" + credibyLevel.trim() + "'");
	    }
	    	
	    hql.append(" and t.deleteFlag = '"+ Constant.DELETE_STATE_FALSE +"'");
		return hql.toString();
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
		
		//创建Finder查询对象
		String hql = this.createProgressHql(param);
		
		Finder f = Finder.create(hql);
		
		//排序条件
		f.append(" order by t.createTime desc");
		
		return super.find(f, pageNo, pageSize);
	}
	
	
	/**
	 * @comments 生成hql
	 * @param param
	 * @return
	 * @Version 1.0
	 */
	private String createProgressHql(Map<String, Object> param){
		StringBuffer hql = new StringBuffer();
		
		// 生成hql
		hql.append(" from TexpertScore t ");
		
		hql.append(" where 1=1 ");
		
		// 项目Id
	    String projectId = (String) param.get("projectId");
	    if (!isNullString(projectId)) {
			hql.append(" and t.tprojectApplication.projectId ='" + projectId.trim() + "'");
		}
		
		// 专家名称
	    String expertName = (String) param.get("expertName");
	    if (!isNullString(expertName)) {
			hql.append(" and t.texpert.expertName like '%" + expertName.trim() + "%'");
		}
	    
	    // 擅长专业
	    String goodProfess = (String) param.get("goodProfess");
	    if (!isNullString(goodProfess)) {
	    	hql.append(" and t.texpert.expertMajor1 = '" + goodProfess.trim() + "'");
	    	hql.append(" or t.texpert.expertMajor2 = '" + goodProfess.trim() + "'");
	    	hql.append(" or t.texpert.expertMajor3 = '" + goodProfess.trim() + "'");
	    }
	    
	    // 信誉度级别
	    String credibyLevel = (String) param.get("credibyLevel");
	    if (!isNullString(credibyLevel)) {
	    	hql.append(" and t.texpert.expertPrestige = '" + credibyLevel.trim() + "'");
	    }
	    	
	    hql.append(" and t.deleteFlag = '"+ Constant.DELETE_STATE_FALSE +"'");
		return hql.toString();
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
	 * @comments 根据项目Id、专家ID取得专家评分信息 
	 * @param expertId
	 * @param projectId
	 * @return
	 * @Version 1.0
	 */
	public TexpertScore getTexpertScore(String expertId, String projectId){
		
		StringBuffer hql = new StringBuffer();
		hql.append(" from TexpertScore t ");
		hql.append(" where t.tprojectApplication.projectId =? ");
		hql.append(" and t.texpert.expertId =? ");
		
		TexpertScore texpertScore = 
				super.createQueryObj(hql.toString(), new String[]{projectId, expertId});
		
		return texpertScore;
	}
	
	/**
	 * @comments 取得专家评审数
	 * @param param
	 * @return
	 * @Version 1.0
	 */
	public int getExpertAuditCount(Map<String, Object> param){
		
		//创建Finder查询对象
		String hql = this.createExpertAuditCountHql(param);
		
		Finder f = Finder.create(hql);
		
		return super.countQueryResult(f);
	}
	
	/**
	 * @comments 生成hql
	 * @param param
	 * @return
	 * @Version 1.0
	 */
	private String createExpertAuditCountHql(Map<String, Object> param){
		StringBuffer hql = new StringBuffer();
		
		// 生成hql
		hql.append(" from TexpertScore t ");
		
		hql.append(" where 1=1 ");
		
		// 项目Id
	    String expertId = (String) param.get("expertId");
	    if (!isNullString(expertId)) {
			hql.append(" and t.texpert.expertId ='" + expertId.trim() + "'");
		}

	    // 信誉度级别
	    String auditFlag = (String) param.get("auditFlag");
	    if (!isNullString(auditFlag)) {
	    	hql.append(" and t.auditFlag = '" + auditFlag.trim() + "'");
	    }
		return hql.toString();
	}
	
	/**
	 * @comments 根据项目ID取得专家评分List
	 * @param projectId
	 * @return
	 * @Version 1.0
	 */
	public List<TexpertScore> getTexpertScoreList(String projectId){
		
		StringBuffer hql = new StringBuffer();
		
		// 生成hql
		hql.append(" from TexpertScore t ");
		
		hql.append(" where t.tprojectApplication.projectId = ? ");
		
		hql.append(" order by t.texpert.expertType asc");
		
		return super.createQueryList(hql.toString(), new String[]{projectId});
	}
	
	/**
	 * 通过组打印专家评审数据
	 * @comments 
	 * @param valueMap
	 * @return
	 * @version 1.0
	 */
	@SuppressWarnings("unchecked")
	public List<Object[]> printExpertScoreByGroup(String groupId) {
		List<Object[]> all = new ArrayList<Object[]>();
		if(CommonTool.IsNotEmpty(groupId)){
			String hql = "select p.projectId,p.projectName,e.expertType,e.expertName,s.companyStatusScore," +
					"s.projectTechnologyScore,s.projectBaseScore,s.projectMarketScore,s.projectBenefitScore,s.complexScore," +
					"s.complexAverage,s.finalResult,e.expertId,p.expertAuditRecommend from TexpertScore s, Texpert e, TprojectApplication p where s.texpert.expertId = e.expertId " +
					"and s.tprojectApplication.projectId = p.projectId and p.tprojectGroup.groupId = '"+groupId+"' order by p.expertAuditRecommend asc,p.projectId desc,e.expertType asc,s.texpert.expertId desc";
			Finder  f = Finder.create(hql);
			all = super.find(f);
		}
		return all;
	}
	
	// wanglw End
	
	public Pager getAuditList(Map<String, Object> param, int pageNo,int pageSize) {
		StringBuffer hql = new StringBuffer("from TexpertScore s where 1=1");
		
		String expertId = (String) param.get("expertId");
		if(CommonTool.IsNotEmpty(expertId)){
			hql.append(" and s.texpert.expertId='"+expertId+"'");
		}
		String projectName = (String) param.get("projectName");
		if(CommonTool.IsNotEmpty(projectName)){
			hql.append(" and s.tprojectApplication.projectName like '%"+projectName+"%'");
		}
		String applicationUnit = (String) param.get("applicationUnit");
		if(CommonTool.IsNotEmpty(applicationUnit)){
			hql.append(" and s.tprojectApplication.applicationUnit like '%"+applicationUnit+"%'");
		}
		
		Finder f = Finder.create(hql.toString());
		Pager pager = super.find(f, pageNo, pageSize);
		return pager;
	}

}
