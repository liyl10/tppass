/************************* 版权声明 *********************************
 *
 * Copyright (C) 2012 西安辉盛科技发展有限责任公司.
 *
 ******************************************************************
 */
package com.hopsun.tppas.api.supervisor.dao.impl;

import com.hopsun.tppas.api.supervisor.dao.TsupervisorReportDao;
import com.hopsun.framework.base.bean.Finder;
import com.hopsun.framework.base.bean.Pager;
import com.hopsun.framework.base.dao.impl.BaseDaoImpl;
import com.hopsun.tppas.entity.TsupervisorReport;
import org.springframework.stereotype.Repository;

/** 
 * @comments 项目监理报告
 * @author wangxiaodong
 * @date 2013-9-17
 * @version 1.0
 */
@Repository
public class TsupervisorReportDaoImpl extends BaseDaoImpl<TsupervisorReport, String> implements TsupervisorReportDao {
	   
	/**
	 * 得到监理下的监理报告
	 * @comments 
	 * @return
	 * @version 1.0
	 */
	public Pager getReportList(String supervisorId,Integer pageNumber, Integer pageSize) {
		Finder f = Finder.create("from TsupervisorReport r where r.tsupervisor.supervisorId=:supervisorId and r.deleteFlag = 0 order by r.submitTime desc");
		f.setParam("supervisorId", supervisorId);
		return super.find(f, pageNumber, pageSize);
	}
}
