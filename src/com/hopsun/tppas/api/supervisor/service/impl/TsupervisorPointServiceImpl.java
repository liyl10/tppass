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
import com.hopsun.scenter.entity.ScUsers;
import com.hopsun.tppas.api.supervisor.dao.TsupervisorDao;
import com.hopsun.tppas.api.supervisor.dao.TsupervisorPointDao;
import com.hopsun.tppas.api.supervisor.dao.TsupervisorReportDao;
import com.hopsun.tppas.api.supervisor.service.TsupervisorPointService;
import com.hopsun.tppas.common.Constants;
import com.hopsun.tppas.entity.Tsupervisor;
import com.hopsun.tppas.entity.TsupervisorPoint;
import com.hopsun.tppas.entity.TsupervisorReport;

/**
 * 项目监理点
 *@comments
 *@author wangxiaodong
 *@date 2013-9-17
 *@version 1.0
 */
@Service
public class TsupervisorPointServiceImpl extends BaseServiceImpl<TsupervisorPoint,String> implements TsupervisorPointService{
	
	@Resource
	private TsupervisorPointDao tsupervisorPointDao;
	
	@Resource
	private TsupervisorDao tsupervisorDao;
	
	@Resource
	private TsupervisorReportDao tsupervisorReportDao;
	
	@Resource
	public void setBaseDao(TsupervisorPointDao tsupervisorPointDao) {
		super.setBaseDao(tsupervisorPointDao);
	}

	/**
	 * 保存监理点
	 * @comments 
	 * @param supervisorPoint
	 * @param supervisorId
	 * @param user
	 * @version 1.0
	 */
	public void saveSupervisorPoint(TsupervisorPoint supervisorPoint,String supervisorId, ScUsers user) {
		//保存监理点信息
		Tsupervisor tsupervisor = tsupervisorDao.get(supervisorId);
		supervisorPoint.setTsupervisor(tsupervisor);
		supervisorPoint.setWriteTime(new java.sql.Timestamp(new java.util.Date().getTime()));
		supervisorPoint.setDeleteFlag(Constants.COMMON_STATE_NOTDELETE);
		supervisorPoint.setCreateTime(new java.sql.Timestamp(new java.util.Date().getTime()));
		supervisorPoint.setCreateUser(user.getUserId());
		tsupervisorPointDao.save(supervisorPoint);
		
		//保存监理报告信息
		TsupervisorReport supervisorReport = new TsupervisorReport();
		supervisorReport.setTsupervisor(tsupervisor);
		supervisorReport.setTsupervisorPoint(supervisorPoint);
		//报告类型  0-自由报告   1-监理点报告
		supervisorReport.setReportType("1");
		//提交时间--submit_time
		//supervisorReport.setSubmitTime(new java.sql.Timestamp(new java.util.Date().getTime()));
		//审批状态--CHECK_STATE
		supervisorReport.setCheckState("0");
		//删除区分--DELETE_FLAG
		supervisorReport.setDeleteFlag(0);
		//创建时间--CREATE_TIME
		supervisorReport.setCreateTime(new java.sql.Timestamp(new java.util.Date().getTime()));
		tsupervisorReportDao.save(supervisorReport);	
	}

	/**
	 * 修改监理点
	 * @comments 
	 * @param supervisorPoint
	 * @param supervisorId
	 * @param user
	 * @version 1.0
	 */
	public void updateSupervisorPoint(TsupervisorPoint supervisorPoint,String supervisorId, ScUsers user) {
		Tsupervisor tsupervisor = tsupervisorDao.get(supervisorId);
		supervisorPoint.setTsupervisor(tsupervisor);
		supervisorPoint.setUpdateDate(new java.sql.Timestamp(new java.util.Date().getTime()));
		supervisorPoint.setUpdateUser(user.getUserId());
		tsupervisorPointDao.update(supervisorPoint);	
	}

	/**
	 * 删除监理点
	 * @comments 
	 * @param supervisorPoint
	 * @param supervisorId
	 * @param user
	 * @version 1.0
	 */
	public void deleteSupervisorPoint(String pointId) {
		TsupervisorPoint tsupervisorPoint = tsupervisorPointDao.get(pointId);
		if(tsupervisorPoint!=null){
			TsupervisorReport tsupervisorReport = tsupervisorPoint.getTsupervisorReport();
			//删除监理信息
			tsupervisorReportDao.delete(tsupervisorReport);
			//删除点信息
			tsupervisorPointDao.delete(tsupervisorPoint);
		}
	}
}
