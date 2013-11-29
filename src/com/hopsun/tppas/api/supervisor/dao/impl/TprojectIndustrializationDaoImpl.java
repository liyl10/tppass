/************************* 版权声明 *********************************
 *
 * Copyright (C) 2012 西安辉盛科技发展有限责任公司.
 *
 ******************************************************************
 */
package com.hopsun.tppas.api.supervisor.dao.impl;

import java.util.List;

import com.hopsun.tppas.api.supervisor.dao.TprojectIndustrializationDao;
import com.hopsun.framework.base.bean.Finder;
import com.hopsun.framework.base.dao.impl.BaseDaoImpl;
import com.hopsun.tppas.entity.TprojectIndustrialization;
import org.springframework.stereotype.Repository;

/**
 * @comments 项目产业化进展情况
 * @author wangxiaodong
 * @date 2013-9-22
 * @version 1.0
 */
@Repository
public class TprojectIndustrializationDaoImpl extends BaseDaoImpl<TprojectIndustrialization, String> implements TprojectIndustrializationDao {

	/**
	 * 通过监理ID查询该监理下的项目产业化进展情况
	 * @comments 
	 * @param supervisorId
	 * @return
	 * @version 1.0
	 */
	@SuppressWarnings("unchecked")
	public TprojectIndustrialization getProjectIndustrializationBySupervisorId(String supervisorId) {
		Finder f = Finder.create("from TprojectIndustrialization i where i.tsupervisor.supervisorId=:supervisorId and i.deleteFlag = 0 ");
		f.setParam("supervisorId", supervisorId);
		List<TprojectIndustrialization> all =  super.find(f);
		if(all!=null&&all.size()>0){
			return all.get(0);
		}
		return new TprojectIndustrialization();
	}
	   
}
