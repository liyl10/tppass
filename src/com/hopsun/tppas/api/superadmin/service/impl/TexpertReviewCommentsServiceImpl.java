/************************* 版权声明 *********************************
 *
 * Copyright (C) 2012 西安辉盛科技发展有限责任公司.
 *
 ******************************************************************
 */
package com.hopsun.tppas.api.superadmin.service.impl;


import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.hopsun.framework.base.bean.Pager;
import com.hopsun.framework.base.service.impl.BaseServiceImpl;
import com.hopsun.tppas.api.superadmin.dao.MitemDao;
import com.hopsun.tppas.api.superadmin.dao.TexpertReviewCommentsDao;
import com.hopsun.tppas.api.superadmin.dao.TprojectTypeDao;
import com.hopsun.tppas.api.superadmin.service.TexpertReviewCommentsService;
import com.hopsun.tppas.common.Constants;
import com.hopsun.tppas.entity.TexpertReviewComments;
import com.hopsun.tppas.entity.TprojectType;

/**
 * @Comments 专家评估模板
 * @author weina
 * @date 2013-10-28 上午10:55:32
 * @version 1.0
 *
 */
@Service("texpertReviewCommentsService")
public class TexpertReviewCommentsServiceImpl extends BaseServiceImpl<TexpertReviewComments,String> implements TexpertReviewCommentsService{
	
	/**项目分类DAO*/
	@Resource
	private TprojectTypeDao tprojectTypeDao;
	
	/**专家评估模板DAO*/
	@Resource
	private TexpertReviewCommentsDao texpertReviewCommentsDao;
	
	/**码表DAO*/
	@Resource
	private MitemDao mitemDao;
	
	@Resource
	public void setBaseDao(TexpertReviewCommentsDao texpertReviewCommentsDao) {
		super.setBaseDao(texpertReviewCommentsDao);
	}
	
	/**
	 * 
	 * @comments 分页查询 
	 * @param typeId
	 * @param pageNumber
	 * @param pageSize
	 * @return
	 * @version 1.0
	 */
	public Pager find(String typeShowName1,String typeId,Integer pageNumber, Integer pageSize){
		Pager pager = texpertReviewCommentsDao.find(typeId, pageNumber, pageSize);
		// 设计列表中的其他信息
		for (int i=0; i<pager.getList().size(); i++) {
			TexpertReviewComments texpertReviewComments = (TexpertReviewComments) pager.getList().get(i);
			texpertReviewComments.setTypeShowName1(typeShowName1);
			// 列表上显示模板类型
			if (Constants.EXPERT_TYPE1.equals(texpertReviewComments.getExpertType())) {
				texpertReviewComments.setExpertReviewCommentsName(mitemDao.getItemName(Constants.EXPERT_TYPE1)); 
			} else {
				texpertReviewComments.setExpertReviewCommentsName(mitemDao.getItemName(Constants.EXPERT_TYPE2)); 
			}
		
		}
		return pager;
	}

	/**
	 * 
	 * @comments 新增、修改 
	 * @param userid
	 * @param texpertReviewComments
	 * @param typeId
	 * @version 1.0
	 */
	public void updateTexpertReview(String userid,
			TexpertReviewComments texpertReviewComments, String typeId) {

		// 修改
		if(texpertReviewComments.getExpertReviewCommentsId() != null && !"".equals(texpertReviewComments.getExpertReviewCommentsId())){
			
			TexpertReviewComments teTemp = texpertReviewCommentsDao.get(texpertReviewComments.getExpertReviewCommentsId());
	    	if(teTemp != null)
	    	{
	    		texpertReviewComments.setCreateTime(teTemp.getCreateTime());
	    		texpertReviewComments.setCreateUser(teTemp.getCreateUser());
	    		texpertReviewComments.setDeleteFlag(Constants.COMMON_STATE_NOTDELETE);
	    		texpertReviewComments.setExpertType(teTemp.getExpertType());
	    	}
			
	    	TprojectType tprojectType = tprojectTypeDao.get(typeId);
			
			texpertReviewComments.setTprojectType(tprojectType);
			
			texpertReviewComments.setUpdateDate(new java.sql.Timestamp(new Date().getTime()));
			
			texpertReviewComments.setUpdateUser(userid);
			
			texpertReviewCommentsDao.evict(teTemp);
			texpertReviewCommentsDao.update(texpertReviewComments);
			
		}
		// 新增
		else{
			texpertReviewComments.setDeleteFlag(Constants.COMMON_STATE_NOTDELETE);
			
			TprojectType tprojectType = tprojectTypeDao.get(typeId);
			
			texpertReviewComments.setTprojectType(tprojectType);
			
			texpertReviewComments.setCreateUser(userid);
			
			texpertReviewComments.setCreateTime(new java.sql.Timestamp(new java.util.Date().getTime()));
		
			texpertReviewCommentsDao.save(texpertReviewComments);	
		}
	
	}
	/**
	 * 
	 * @comments 专家类型列表
	 * @param typeId
	 * @return
	 * @version 1.0
	 */
	@Override
	public TexpertReviewComments getexpertReviewList(String typeId) {
		TexpertReviewComments texpertReviewComments = null;
		List<TexpertReviewComments> list = texpertReviewCommentsDao.getexpertReviewList(typeId);
		if(list!=null&&list.size()>0){
			texpertReviewComments = list.get(0);
		}
		return texpertReviewComments;
	}
	/**
	 *
	 * @comments 获得技术专家评估表
	 * @param typeId
	 * @return
	 * @version 1.0
	 */
	@Override
	public List<TexpertReviewComments> getexpertReview(String typeId) {
		List<TexpertReviewComments> list = texpertReviewCommentsDao.getexpertReviewList(typeId);
		return list;
	}

	/**
	 * 
	 * @comments 取得要copy的项目分类列表 
	 * @return
	 * @version 1.0
	 */
	public List<String> getCopyExpertReviewList(String typeId) {
		return texpertReviewCommentsDao.getCopyExpertReviewList(typeId);
	}

	/**
	 * 
	 * @comments 取得要copy的专家评估模板
	 * @param typeId
	 * @return
	 * @version 1.0
	 */
	public List<TexpertReviewComments> getCopyModelList(String typeId) {
		return texpertReviewCommentsDao.getexpertReviewList(typeId);
	}

	/**
	 * 
	 * @comments 被COPY的信息 
	 * @param typeId
	 * @param expertType
	 * @return
	 * @version 1.0
	 */
	public TexpertReviewComments getCopyTexpertReviewCommen(String typeId,
			String expertType) {
		TexpertReviewComments texpertReviewComments = null;
		List<TexpertReviewComments> list = texpertReviewCommentsDao.getCopyTexpertReviewCommen(typeId,expertType);
		if(list!=null&&list.size()>0){
			texpertReviewComments = list.get(0);
		}
		return texpertReviewComments;
	}

	/**
	 * 
	 * @comments 新增copy的信息
	 * @param userid
	 * @param texpertReviewComments
	 * @param typeId
	 * @version 1.0
	 */
	public void saveCopy(String userid,
			TexpertReviewComments texpertReviewComments, String typeId) {
		TexpertReviewComments temp = new TexpertReviewComments();
		
		temp.setDeleteFlag(Constants.COMMON_STATE_NOTDELETE);
		TprojectType tprojectType = tprojectTypeDao.get(typeId);
		temp.setTprojectType(tprojectType);
		temp.setTypeId(typeId);
		temp.setCreateUser(userid);
		temp.setCreateTime(new java.sql.Timestamp(new java.util.Date().getTime()));
		temp.setExpertType(texpertReviewComments.getExpertType());
		temp.setTypeShowName1(texpertReviewComments.getTypeShowName1());
		temp.setCodePoints1(texpertReviewComments.getCodePoints1());
		temp.setCodePoints2(texpertReviewComments.getCodePoints2());
		temp.setCodePoints3(texpertReviewComments.getCodePoints3());
		temp.setCodePoints4(texpertReviewComments.getCodePoints4());
		temp.setCodePoints5(texpertReviewComments.getCodePoints5());
		temp.setCodePoints6(texpertReviewComments.getCodePoints6());
		temp.setCodePoints7(texpertReviewComments.getCodePoints7());
		temp.setCodePoints8(texpertReviewComments.getCodePoints8());
		temp.setCodePoints9(texpertReviewComments.getCodePoints9());
		temp.setCodePoints10(texpertReviewComments.getCodePoints10());
		temp.setCodePoints11(texpertReviewComments.getCodePoints11());
		temp.setCodePoints12(texpertReviewComments.getCodePoints12());
		temp.setCodePoints13(texpertReviewComments.getCodePoints13());
		temp.setCodePoints14(texpertReviewComments.getCodePoints14());
		temp.setCodePoints15(texpertReviewComments.getCodePoints15());
		temp.setEvaluationIndex1(texpertReviewComments.getEvaluationIndex1());
		temp.setEvaluationIndex2(texpertReviewComments.getEvaluationIndex2());
		temp.setEvaluationIndex3(texpertReviewComments.getEvaluationIndex3());
		temp.setEvaluationIndex4(texpertReviewComments.getEvaluationIndex4());
		temp.setEvaluationIndex5(texpertReviewComments.getEvaluationIndex5());
		temp.setEvaluationShows1(texpertReviewComments.getEvaluationShows1());
		temp.setEvaluationShows2(texpertReviewComments.getEvaluationShows2());
		temp.setEvaluationShows3(texpertReviewComments.getEvaluationShows3());
		temp.setEvaluationShows4(texpertReviewComments.getEvaluationShows4());
		temp.setEvaluationShows5(texpertReviewComments.getEvaluationShows5());
		temp.setScore1(texpertReviewComments.getScore1());
		temp.setScore2(texpertReviewComments.getScore2());
		temp.setScore3(texpertReviewComments.getScore3());
		temp.setScore4(texpertReviewComments.getScore4());
		temp.setScore5(texpertReviewComments.getScore5());
		temp.setRemarksScore1(texpertReviewComments.getRemarksScore1());
		temp.setRemarksScore2(texpertReviewComments.getRemarksScore2());
		temp.setRemarksScore3(texpertReviewComments.getRemarksScore3());
		temp.setRemarksScore4(texpertReviewComments.getRemarksScore4());
		temp.setRemarksScore5(texpertReviewComments.getRemarksScore5());
		temp.setRemarksScore6(texpertReviewComments.getRemarksScore6());
		
		texpertReviewCommentsDao.save(temp);
	}

	/**
	 * 
	 * @comments 专家评估列表
	 * @param typeId
	 * @return
	 * @version 1.0
	 */
	public List<TexpertReviewComments> getExpertModelList(String typeId) {
		List<TexpertReviewComments> list = texpertReviewCommentsDao.getexpertReviewList(typeId);
		return list;
	}



}
