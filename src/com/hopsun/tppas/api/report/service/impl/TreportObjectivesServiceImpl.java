/*************** 版权声明***************
*
* Copyright (C) 2013 西安辉盛科技发展有限责任公司.
*
********************************************
*/
package com.hopsun.tppas.api.report.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.hopsun.framework.base.service.impl.BaseServiceImpl;
import com.hopsun.tppas.api.report.dao.TprojectApplicationDao;
import com.hopsun.tppas.api.report.dao.TreportObjectivesDao;
import com.hopsun.tppas.api.report.service.TreportObjectivesService;
import com.hopsun.tppas.common.Constants;
import com.hopsun.tppas.entity.TprojectApplication;
import com.hopsun.tppas.entity.TreportObjectives;

/**
 * @comments 项目实施目标
 * @author weina
 * @date 2013-9-28 @time 下午6:28:13
 * @Version 1.0
 */
@Service
public class TreportObjectivesServiceImpl extends BaseServiceImpl<TreportObjectives,String> implements TreportObjectivesService{
	
	
	@Resource
	public void setBaseDao(TreportObjectivesDao treportObjectivesDao) {
		super.setBaseDao(treportObjectivesDao);
	}
	
	@Resource
	private TreportObjectivesDao treportObjectivesDao;
	@Resource
	private TprojectApplicationDao tprojectApplicationDao;
	/**
	 * 
	 * @comments 保存 项目实施目标
	 * @param treportObjectives
	 * @param userId
	 * @version 1.0
	 */
	@Override
	public void saveTreportObjectives(TreportObjectives treportObjectives,
			String projectId,String userId) {
		// 更新
		if(treportObjectives.getObjectivesId() != null
				&& !"".equals(treportObjectives.getObjectivesId())){
			//取得项目实施目标
			TreportObjectives trTemp = treportObjectivesDao.get(treportObjectives.getObjectivesId());
			TprojectApplication tprojectApplication = tprojectApplicationDao.get(projectId);
			trTemp.setTprojectApplication(tprojectApplication);
			//企业新获得质量认证体系证书
			trTemp.setQualityCertificationSystem(treportObjectives.getQualityCertificationSystem());
			//项目新获得国家相关行业许可证
			trTemp.setRelevantIndustryPermits(treportObjectives.getRelevantIndustryPermits());
			//项目新申请及授权专利（或著作权）证书授权
			trTemp.setApplication(treportObjectives.getApplication());
			//项目新获得技术、产品鉴定证书
			trTemp.setTechnologyProductCertificate(treportObjectives.getTechnologyProductCertificate());
			//项目新申请及授权专利（或著作权）证书申请
			trTemp.setAuthorize(treportObjectives.getAuthorize());
			// 更新时间
			trTemp.setUpdateTime(new java.sql.Timestamp(new java.util.Date().getTime()));
			// 更新者
			trTemp.setUpdateUser(userId);
			// 更新项目实施目标
			treportObjectivesDao.update(trTemp);
		}
		// 新增项目实施目标
		else{
			TprojectApplication tprojectApplication = tprojectApplicationDao.get(projectId);
			treportObjectives.setTprojectApplication(tprojectApplication);
			// 创建时间
			treportObjectives.setCreateTime(new java.sql.Timestamp(new java.util.Date().getTime()));
			// 创建者
			treportObjectives.setUpdateUser(userId);
			// 删除区分
			treportObjectives.setDeleteFlag(Constants.COMMON_STATE_NOTDELETE);
			// 新增项目实施目标
			treportObjectivesDao.save(treportObjectives);
		}
	
		
	}

	
	
	
}
