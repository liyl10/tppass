/************************* 版权声明 *********************************
 *
 * Copyright (C) 2012 西安辉盛科技发展有限责任公司.
 *
 ******************************************************************
 */
package com.hopsun.tppas.api.supervisor.dao;

import com.hopsun.tppas.entity.TsupervisorFundB;
import com.hopsun.framework.base.dao.BaseDao;

/**
 *@comments 监理资金表B
 *@author wangxiaodong
 *@date 2013-8-7
 *@version 1.0
 */
public interface TsupervisorFundBDao extends BaseDao<TsupervisorFundB, String>{
	
	/*
	 * 通过监理ID查询资金情况B
	 * @comments 
	 * @param supervisorId
	 * @return
	 * @version 1.0
	 */
	public TsupervisorFundB getTsupervisorFundBBysupervisorId(String supervisorId);
}
