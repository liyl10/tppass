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
import com.hopsun.tppas.api.supervisor.dao.TprojectIndustrializationDao;
import com.hopsun.tppas.api.supervisor.service.TprojectIndustrializationService;
import com.hopsun.tppas.entity.TprojectIndustrialization;
import com.hopsun.tppas.entity.Tsupervisor;

/**
 * @comments 项目产业化进展情况
 * @author wangxiaodong
 * @date 2013-9-22
 * @version 1.0
 */
@Service
public class TprojectIndustrializationServiceImpl extends BaseServiceImpl<TprojectIndustrialization,String> implements TprojectIndustrializationService{
	
	@Resource
	private TprojectIndustrializationDao tprojectIndustrializationDao;
	
	@Resource
	public void setBaseDao(TprojectIndustrializationDao tprojectIndustrializationDao) {
		super.setBaseDao(tprojectIndustrializationDao);
	}
	
	/**
	 * 通过监理ID查询该监理下的项目产业化进展情况
	 * @comments 
	 * @param supervisorId
	 * @return
	 * @version 1.0
	 */
	public TprojectIndustrialization getProjectIndustrializationBySupervisorId(String supervisorId){
		
		return tprojectIndustrializationDao.getProjectIndustrializationBySupervisorId(supervisorId);
	}

	/**
	 * 保存或修改项目产业化进展情况
	 * @comments 
	 * @param supervisorId
	 * @param tprojectIndustrialization
	 * @version 1.0
	 */
	public void saveOrUpdate(String supervisorId,TprojectIndustrialization tprojectIndustrialization) {
		//监理信息
		Tsupervisor supervisor = new Tsupervisor();
		supervisor.setSupervisorId(supervisorId);
		tprojectIndustrialization.setTsupervisor(supervisor);
		
		//修改
		if(tprojectIndustrialization.getProjectIndustrializationId()!=null&&tprojectIndustrialization.getProjectIndustrializationId().length()>0){
			tprojectIndustrialization.setUpdateDate(new java.sql.Timestamp(new java.util.Date().getTime()));
			//tsupervisorFundB.setUpdateUser();
			tprojectIndustrializationDao.update(tprojectIndustrialization);
		}else{//添加
			tprojectIndustrialization.setDeleteFlag("0");
			tprojectIndustrialization.setCreateTime(new java.sql.Timestamp(new java.util.Date().getTime()));
			//tsupervisorFundB.setCreateUser();	
			tprojectIndustrializationDao.save(tprojectIndustrialization);
		}	
	}
}
