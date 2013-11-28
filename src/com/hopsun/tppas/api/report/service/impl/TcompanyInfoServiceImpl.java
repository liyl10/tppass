package com.hopsun.tppas.api.report.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.hopsun.framework.base.service.impl.BaseServiceImpl;
import com.hopsun.tppas.api.report.dao.TcompanyInfoDao;
import com.hopsun.tppas.api.report.dao.TprojectApplicationDao;
import com.hopsun.tppas.api.report.service.TcompanyInfoService;
import com.hopsun.tppas.common.Constants;
import com.hopsun.tppas.entity.TcompanyInfo;
import com.hopsun.tppas.entity.TprojectApplication;

@Service
public class TcompanyInfoServiceImpl extends BaseServiceImpl<TcompanyInfo,String> implements TcompanyInfoService{
	
	@Resource
	private TcompanyInfoDao tcompanyInfoDao;
	
	@Resource
	private TprojectApplicationDao tprojectApplicationDao;
	
	@Resource
	public void setBaseDao(TcompanyInfoDao tcompanyInfoDao) {
		super.setBaseDao(tcompanyInfoDao);
	}
	
	/**
	 * 更新企业项目基本信息表
	 * @comments 
	 * @param tcompanyInfo
	 * @param projectId
	 * @param userId
	 * @version 1.0
	 */
	public void updateTcompanyInfo(TcompanyInfo tcompanyInfo,String projectId,String userId){
		// 存在的情况下更新
		if (tcompanyInfo != null && tcompanyInfo.getCompanyInfoId() != null
				&& !("").equals(tcompanyInfo.getCompanyInfoId())){
			TcompanyInfo tcompanyInfo1 = tcompanyInfoDao.get(tcompanyInfo.getCompanyInfoId());
			// 院所/高端人才
			tcompanyInfo1.setInstitutesHighTalent(tcompanyInfo.getInstitutesHighTalent());
			// 推荐意见
			tcompanyInfo1.setRecommendation(tcompanyInfo.getRecommendation());
			// 投资专家平均分
			tcompanyInfo1.setAverageInvestmentExperts(tcompanyInfo.getAverageInvestmentExperts());
			// 技术专家平均分
			tcompanyInfo1.setAverageTechnicalExperts(tcompanyInfo.getAverageTechnicalExperts());
			// 投资专家
			tcompanyInfo1.setInvestmentExperts(tcompanyInfo.getInvestmentExperts());
			// 技术专家
			tcompanyInfo1.setTechnicalExperts(tcompanyInfo.getTechnicalExperts());
			tcompanyInfo1.setUpdateTime(new java.sql.Timestamp(new java.util.Date().getTime()));
			tcompanyInfo1.setUpdateUser(userId);
			
			tcompanyInfoDao.update(tcompanyInfo1);
		} else{
			TprojectApplication tprojectApplication = tprojectApplicationDao.get(projectId);
			if (tcompanyInfo != null){
				tcompanyInfo.setTprojectApplication(tprojectApplication);
				tcompanyInfo.setDeleteFlag(Constants.COMMON_STATE_NOTDELETE);
				tcompanyInfo.setCreateTime(new java.sql.Timestamp(new java.util.Date().getTime()));
				tcompanyInfo.setCreateUser(userId);
				tcompanyInfoDao.save(tcompanyInfo);
			}
		}
	}
	/**
	 * @comments 保存院所/高端人才
	 * @param projectId
	 * @param highEnd
	 * @Version 1.0
	 */
	public void updateHighEnd(String projectId, String highEnd){
		TcompanyInfo tc = tcompanyInfoDao.get("tprojectApplication.projectId",projectId);
		if(tc != null){
			tc.setInstitutesHighTalent(highEnd);
		}
		tcompanyInfoDao.update(tc);
	}
}
