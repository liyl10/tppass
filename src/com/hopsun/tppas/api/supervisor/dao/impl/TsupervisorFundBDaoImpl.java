/************************* 版权声明 *********************************
 *
 * Copyright (C) 2012 西安辉盛科技发展有限责任公司.
 *
 ******************************************************************
 */
package com.hopsun.tppas.api.supervisor.dao.impl;

import java.util.List;

import com.hopsun.tppas.api.supervisor.dao.TsupervisorFundBDao;
import com.hopsun.framework.base.bean.Finder;
import com.hopsun.framework.base.dao.impl.BaseDaoImpl;
import com.hopsun.tppas.entity.TsupervisorFundB;
import org.springframework.stereotype.Repository;

/**
 *@comments 监理资金表B
 *@author wangxiaodong
 *@date 2013-8-7
 *@version 1.0
 */
@Repository
public class TsupervisorFundBDaoImpl extends BaseDaoImpl<TsupervisorFundB, String> implements TsupervisorFundBDao {
	   
	/**
	 * 通过监理ID查询资金情况B
	 * @comments 
	 * @param supervisorId
	 * @return
	 * @version 1.0
	 */
	@SuppressWarnings("unchecked")
	public TsupervisorFundB getTsupervisorFundBBysupervisorId(String supervisorId) {
		Finder f = Finder.create("from TsupervisorFundB f where f.tsupervisor.supervisorId=:supervisorId and f.deleteFlag = 0 ");
		f.setParam("supervisorId", supervisorId);
		List<TsupervisorFundB> all =  super.find(f);
		if(all!=null&&all.size()>0){
			return all.get(0);
		}
		return new TsupervisorFundB();
	}
}
