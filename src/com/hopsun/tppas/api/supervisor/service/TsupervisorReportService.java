/************************* 版权声明 *********************************
 *
 * Copyright (C) 2012 西安辉盛科技发展有限责任公司.
 *
 ******************************************************************
 */
package com.hopsun.tppas.api.supervisor.service;

import java.util.Map;

import com.hopsun.tppas.entity.TsupervisorReport;
import com.hopsun.framework.base.bean.Pager;
import com.hopsun.framework.base.service.BaseService;

/**
 * @comments 项目监理报告
 * @author wangxiaodong
 * @date 2013-9-17
 * @version 1.0
 */
public interface TsupervisorReportService extends BaseService<TsupervisorReport, String> {
	
	/**
	 * 得到监理下的监理报告
	 * @comments 
	 * @return
	 * @version 1.0
	 */
	public Pager getReportList(String supervisorId,Integer pageNumber, Integer pageSize);
	
	/**
	 * 添加监理报告
	 * @comments 
	 * @param supervisorId
	 * @param supervisorReport
	 * @version 1.0
	 */
	public void saveReport(String supervisorId,TsupervisorReport supervisorReport);
	
	/**
	 * 修改监理报告
	 * @comments 
	 * @param supervisorId
	 * @param supervisorReport
	 * @version 1.0
	 */
	public void updateReport(String supervisorId,TsupervisorReport supervisorReport);
	
	/**
	 * 审查监理报告
	 * @comments 
	 * @param supervisorId
	 * @param supervisorReport
	 * @version 1.0
	 */
	public void auditReport(Map<String,Object> valueMap);
	
}
