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
import com.hopsun.tppas.api.supervisor.dao.TcompanyDevelopInfoDao;
import com.hopsun.tppas.api.supervisor.service.TcompanyDevelopInfoService;
import com.hopsun.tppas.entity.TcompanyDevelopInfo;
import com.hopsun.tppas.entity.Tsupervisor;

/**
 * @comments 企业发展情况
 * @author wangxiaodong
 * @date 2013-9-22
 * @version 1.0
 */
@Service
public class TcompanyDevelopInfoServiceImpl extends BaseServiceImpl<TcompanyDevelopInfo,String> implements TcompanyDevelopInfoService{
	
	@Resource
	private TcompanyDevelopInfoDao tcompanyDevelopInfoDao;
	
	@Resource
	public void setBaseDao(TcompanyDevelopInfoDao tcompanyDevelopInfoDao) {
		super.setBaseDao(tcompanyDevelopInfoDao);
	}
	
	/**
	 * 通过监理ID查询该监理下的企业发展情况
	 * @comments 
	 * @param supervisorId
	 * @return
	 * @version 1.0
	 */
	public TcompanyDevelopInfo getCompanyDevelopInfoBySupervisorId(String supervisorId) {
		
		return tcompanyDevelopInfoDao.getCompanyDevelopInfoBySupervisorId(supervisorId);
	}

	/**
	 * 保存或修企业发展情况
	 * @comments 
	 * @param supervisorId
	 * @param tcompanyDevelopInfo
	 * @version 1.0
	 */
	public void saveOrUpdate(String supervisorId,TcompanyDevelopInfo tcompanyDevelopInfo) {
		//监理信息
		Tsupervisor supervisor = new Tsupervisor();
		supervisor.setSupervisorId(supervisorId);
		tcompanyDevelopInfo.setTsupervisor(supervisor);
		
		//修改
		if(tcompanyDevelopInfo.getCompanyDevelopInfoId()!=null&&tcompanyDevelopInfo.getCompanyDevelopInfoId().length()>0){
			tcompanyDevelopInfo.setUpdateDate(new java.sql.Timestamp(new java.util.Date().getTime()));
			//tsupervisorFundB.setUpdateUser();
			tcompanyDevelopInfoDao.update(tcompanyDevelopInfo);
		}else{//添加
			tcompanyDevelopInfo.setDeleteFlag("0");
			tcompanyDevelopInfo.setCreateTime(new java.sql.Timestamp(new java.util.Date().getTime()));
			//tsupervisorFundB.setCreateUser();	
			tcompanyDevelopInfoDao.save(tcompanyDevelopInfo);
		}		
	}
}
