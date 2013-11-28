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
import com.hopsun.tppas.api.supervisor.dao.TsupervisorFundBDao;
import com.hopsun.tppas.api.supervisor.service.TsupervisorFundBService;
import com.hopsun.tppas.entity.Tsupervisor;
import com.hopsun.tppas.entity.TsupervisorFundB;

/**
 *@comments 监理资金表B
 *@author wangxiaodong
 *@date 2013-9-22
 *@version 1.0
 */
@Service
public class TsupervisorFundBServiceImpl extends BaseServiceImpl<TsupervisorFundB,String> implements TsupervisorFundBService{
	
	@Resource
	private TsupervisorFundBDao tsupervisorFundBDao;
	
	@Resource
	public void setBaseDao(TsupervisorFundBDao tsupervisorFundBDao) {
		super.setBaseDao(tsupervisorFundBDao);
	}
	
	/**
	 * 通过监理ID查询资金情况B
	 * @comments 
	 * @param supervisorId
	 * @return
	 * @version 1.0
	 */
	public TsupervisorFundB getTsupervisorFundBBysupervisorId(String supervisorId) {
		
		return tsupervisorFundBDao.getTsupervisorFundBBysupervisorId(supervisorId);
	}

	/**
	 * 保存或修改资金情况B
	 * @comments 
	 * @param supervisorId
	 * @param tsupervisorFundB
	 * @version 1.0
	 */
	public void saveOrUpdate(String supervisorId,TsupervisorFundB tsupervisorFundB) {
		
		//监理信息
		Tsupervisor supervisor = new Tsupervisor();
		supervisor.setSupervisorId(supervisorId);
		tsupervisorFundB.setTsupervisor(supervisor);
		
		//修改
		if(tsupervisorFundB.getFundBId()!=null&&tsupervisorFundB.getFundBId().length()>0){
			tsupervisorFundB.setUpdateDate(new java.sql.Timestamp(new java.util.Date().getTime()));
			//tsupervisorFundB.setUpdateUser();
			tsupervisorFundBDao.update(tsupervisorFundB);
		}else{//添加
			tsupervisorFundB.setDeleteFlag("0");
			tsupervisorFundB.setCreateTime(new java.sql.Timestamp(new java.util.Date().getTime()));
			//tsupervisorFundB.setCreateUser();	
			tsupervisorFundBDao.save(tsupervisorFundB);
		}
	}
}
