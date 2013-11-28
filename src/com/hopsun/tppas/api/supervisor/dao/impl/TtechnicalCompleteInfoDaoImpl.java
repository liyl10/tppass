/************************* 版权声明 *********************************
 *
 * Copyright (C) 2012 西安辉盛科技发展有限责任公司.
 *
 ******************************************************************
 */
package com.hopsun.tppas.api.supervisor.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.hopsun.framework.base.bean.Finder;
import com.hopsun.framework.base.dao.impl.BaseDaoImpl;
import com.hopsun.tppas.api.supervisor.dao.TtechnicalCompleteInfoDao;
import com.hopsun.tppas.entity.TtechnicalCompleteInfo;

/**
 * @comments 技术指标完成情况
 * @author wangxiaodong
 * @date 2013-9-22
 * @version 1.0
 */
@Repository
public class TtechnicalCompleteInfoDaoImpl extends BaseDaoImpl<TtechnicalCompleteInfo, String> implements TtechnicalCompleteInfoDao {
	  
	/**
	 * @comments  通过监理ID查询该监理下的技术指标完成情况
	 * @param supervisorId
	 * @return
	 * @version 1.0
	 */
	@SuppressWarnings("unchecked")
	public List<TtechnicalCompleteInfo> getTechnicalCompleteInfoBySupervisorId(String supervisorId) {
		Finder f = Finder.create("from TtechnicalCompleteInfo t where t.tsupervisor.supervisorId=:supervisorId and t.deleteFlag = 0 ");
		f.setParam("supervisorId", supervisorId);
		List<TtechnicalCompleteInfo> all =  super.find(f);
		return all;
	}
}
