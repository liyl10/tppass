/************************* 版权声明 *********************************
 *
 * Copyright (C) 2012 西安辉盛科技发展有限责任公司.
 *
 ******************************************************************
 */
package com.hopsun.tppas.api.supervisor.service.impl;

import java.sql.Timestamp;
import java.util.Date;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.hopsun.framework.base.bean.Pager;
import com.hopsun.framework.base.service.impl.BaseServiceImpl;
import com.hopsun.scenter.entity.ScUsers;
import com.hopsun.tppas.api.supervisor.dao.TsupervisorReportDao;
import com.hopsun.tppas.api.supervisor.service.TsupervisorReportService;
import com.hopsun.tppas.entity.Tsupervisor;
import com.hopsun.tppas.entity.TsupervisorReport;

/**
 * @comments 项目监理报告
 * @author wangxiaodong
 * @date 2013-9-17
 * @version 1.0
 */
@Service
public class TsupervisorReportServiceImpl extends BaseServiceImpl<TsupervisorReport,String> implements TsupervisorReportService{
	
	@Resource
	private TsupervisorReportDao tsupervisorReportDao;
	
	@Resource
	public void setBaseDao(TsupervisorReportDao tsupervisorReportDao) {
		super.setBaseDao(tsupervisorReportDao);
	}
	
	/**
	 * 得到监理下的监理报告
	 * @comments 
	 * @return
	 * @version 1.0
	 */
	public Pager getReportList(String supervisorId, Integer pageNumber,Integer pageSize) {
		Pager pager = tsupervisorReportDao.getReportList(supervisorId, pageNumber, pageSize);
		return pager;
	}

	/**
	 * 添加监理报告
	 * @comments 
	 * @param supervisorId
	 * @param supervisorReport
	 * @version 1.0
	 */
	public void saveReport(String supervisorId,TsupervisorReport supervisorReport) {
		//监理信息
		Tsupervisor supervisor = new Tsupervisor();
		supervisor.setSupervisorId(supervisorId);
		supervisorReport.setTsupervisor(supervisor);
		//报告类型  0-自由报告   1-监理点报告
		supervisorReport.setReportType("0");
		//提交时间--submit_time
		supervisorReport.setSubmitTime(new java.sql.Timestamp(new java.util.Date().getTime()));
		//审批状态--CHECK_STATE
		supervisorReport.setCheckState("0");
		//删除区分--DELETE_FLAG
		supervisorReport.setDeleteFlag(0);
		//创建时间--CREATE_TIME
		supervisorReport.setCreateTime(new java.sql.Timestamp(new java.util.Date().getTime()));
		tsupervisorReportDao.save(supervisorReport);	
	}

	/**
	 * 修改监理报告
	 * @comments 
	 * @param supervisorId
	 * @param supervisorReport
	 * @version 1.0
	 */
	public void updateReport(String supervisorId,TsupervisorReport supervisorReport) {
		//监理信息
		Tsupervisor supervisor = new Tsupervisor();
		supervisor.setSupervisorId(supervisorId);
		supervisorReport.setTsupervisor(supervisor);
		
		//更新时间--UPDATE_DATE
		supervisorReport.setUpdateDate(new Timestamp(new Date().getTime()));
		tsupervisorReportDao.update(supervisorReport);
	}

	/**
	 * 审查监理报告
	 * @comments 
	 * @param supervisorId
	 * @param supervisorReport
	 * @version 1.0
	 */
	public void auditReport(Map<String,Object> valueMap) {
		//监理报告ID
		String reportId = (String)valueMap.get("reportId");
		//操作类型  0-保存    1-提交
		String optType = (String)valueMap.get("optType");
		//审查意见
		String checkInfo = (String)valueMap.get("checkInfo");
		//操作用户
		ScUsers user = (ScUsers)valueMap.get("user");
		
		TsupervisorReport tsupervisorReport = tsupervisorReportDao.get(reportId);
		tsupervisorReport.setCheckInfo(checkInfo);
		if(optType!=null&&optType.length()>0){
			//如果审查提交
			if("1".equals(optType)){
				tsupervisorReport.setCheckTime(new Timestamp(new Date().getTime()) );
				tsupervisorReport.setCheckState("2");
			}
		}
		tsupervisorReport.setUpdateDate(new Timestamp(new Date().getTime()) );
		tsupervisorReport.setUpdateUser(user.getUserId());
	}
}
