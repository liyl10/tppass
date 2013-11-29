/************************* 版权声明 *********************************
 *
 * Copyright (C) 2012 西安辉盛科技发展有限责任公司.
 *
 ******************************************************************
 */
package com.hopsun.tppas.api.supervisor.dao;

import com.hopsun.tppas.entity.TsupervisorReport;
import com.hopsun.framework.base.bean.Pager;
import com.hopsun.framework.base.dao.BaseDao;

/**
 * @comments 项目监理报告
 * @author wangxiaodong
 * @date 2013-9-17
 * @version 1.0
 */
public interface TsupervisorReportDao extends BaseDao<TsupervisorReport, String>{
	
	/**
	 * 得到监理下的监理报告
	 * @comments 
	 * @return
	 * @version 1.0
	 */
	public Pager getReportList(String supervisorId,Integer pageNumber, Integer pageSize);
}
