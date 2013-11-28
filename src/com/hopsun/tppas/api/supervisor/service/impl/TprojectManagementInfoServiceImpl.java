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
import com.hopsun.tppas.api.supervisor.dao.TprojectManagementInfoDao;
import com.hopsun.tppas.api.supervisor.service.TprojectManagementInfoService;
import com.hopsun.tppas.entity.TprojectManagementInfo;
import com.hopsun.tppas.entity.Tsupervisor;

/**
 * @comments 项目实施管理情况
 * @author wangxiaodong
 * @date 2013-9-22
 * @version 1.0
 */
@Service
public class TprojectManagementInfoServiceImpl extends BaseServiceImpl<TprojectManagementInfo,String> implements TprojectManagementInfoService{
	
	@Resource
	private TprojectManagementInfoDao tprojectManagementInfoDao;
	
	@Resource
	public void setBaseDao(TprojectManagementInfoDao tprojectManagementInfoDao) {
		super.setBaseDao(tprojectManagementInfoDao);
	}
	
	/**
	 * 通过监理ID查询该监理下的项目实施管理情况
	 * @comments 
	 * @param supervisorId
	 * @return
	 * @version 1.0
	 */
	public TprojectManagementInfo getProjectManagementInfoBySupervisorId(String supervisorId) {
		
		return tprojectManagementInfoDao.getProjectManagementInfoBySupervisorId(supervisorId);
	}

	/**
	 * 保存或修改项目实施管理情况
	 * @comments 
	 * @param supervisorId
	 * @param tprojectManagementInfo
	 * @version 1.0
	 */
	public void saveOrUpdate(String supervisorId,TprojectManagementInfo tprojectManagementInfo) {
		//监理信息
		Tsupervisor supervisor = new Tsupervisor();
		supervisor.setSupervisorId(supervisorId);
		tprojectManagementInfo.setTsupervisor(supervisor);
		
		//修改
		if(tprojectManagementInfo.getProjectManagementInfoId()!=null&&tprojectManagementInfo.getProjectManagementInfoId().length()>0){
			tprojectManagementInfo.setUpdateDate(new java.sql.Timestamp(new java.util.Date().getTime()));
			//tsupervisorFundB.setUpdateUser();
			tprojectManagementInfoDao.update(tprojectManagementInfo);
		}else{//添加
			tprojectManagementInfo.setDeleteFlag("0");
			tprojectManagementInfo.setCreateTime(new java.sql.Timestamp(new java.util.Date().getTime()));
			//tsupervisorFundB.setCreateUser();	
			tprojectManagementInfoDao.save(tprojectManagementInfo);
		}	
	}
}
