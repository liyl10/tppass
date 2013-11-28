/************************* 版权声明 *********************************
 *
 * Copyright (C) 2012 西安辉盛科技发展有限责任公司.
 *
 ******************************************************************
 */
package com.hopsun.tppas.api.supervisor.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.hopsun.framework.base.service.impl.BaseServiceImpl;
import com.hopsun.tppas.api.supervisor.dao.TprojectAchievementInfoDao;
import com.hopsun.tppas.api.supervisor.service.TprojectAchievementInfoService;
import com.hopsun.tppas.entity.TprojectAchievementInfo;
import com.hopsun.tppas.entity.Tsupervisor;

/**
 * @comments 项目取得成果情况
 * @author wangxiaodong
 * @date 2013-9-22
 * @version 1.0
 */
@Service
public class TprojectAchievementInfoServiceImpl extends BaseServiceImpl<TprojectAchievementInfo,String> implements TprojectAchievementInfoService{
	
	@Resource
	private TprojectAchievementInfoDao tprojectAchievementInfoDao;
	
	@Resource
	public void setBaseDao(TprojectAchievementInfoDao tprojectAchievementInfoDao) {
		super.setBaseDao(tprojectAchievementInfoDao);
	}
	
	/**
	 * 通过监理ID查询该监理下的项目取得成果情况
	 * @comments 
	 * @param supervisorId
	 * @return
	 * @version 1.0
	 */
	public TprojectAchievementInfo getProjectAchievementInfoBySupervisorId(String supervisorId) {
		
		return tprojectAchievementInfoDao.getProjectAchievementInfoBySupervisorId(supervisorId);
	}

	/**
	 * 保存或修改项目取得成果情况
	 * @comments 
	 * @param supervisorId
	 * @param tprojectAchievementInfo
	 * @version 1.0
	 */
	public void saveOrUpdate(String supervisorId,TprojectAchievementInfo tprojectAchievementInfo) {
		//监理信息
		Tsupervisor supervisor = new Tsupervisor();
		supervisor.setSupervisorId(supervisorId);
		tprojectAchievementInfo.setTsupervisor(supervisor);
		
		//修改
		if(tprojectAchievementInfo.getProjectAchievementInfoId()!=null&&tprojectAchievementInfo.getProjectAchievementInfoId().length()>0){
			tprojectAchievementInfo.setUpdateDate(new java.sql.Timestamp(new java.util.Date().getTime()));
			//tsupervisorFundB.setUpdateUser();
			tprojectAchievementInfoDao.update(tprojectAchievementInfo);
		}else{//添加
			tprojectAchievementInfo.setDeleteFlag("0");
			tprojectAchievementInfo.setCreateTime(new java.sql.Timestamp(new java.util.Date().getTime()));
			//tsupervisorFundB.setCreateUser();	
			tprojectAchievementInfoDao.save(tprojectAchievementInfo);
		}
		
	}
}
