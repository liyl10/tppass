/************************* 版权声明 *********************************
 *
 * Copyright (C) 2012 西安辉盛科技发展有限责任公司.
 *
 ******************************************************************
 */
package com.hopsun.tppas.api.supervisor.service;

import com.hopsun.tppas.entity.TsupervisorFundB;
import com.hopsun.framework.base.service.BaseService;

/**
 *@comments 监理资金表B
 *@author wangxiaodong
 *@date 2013-9-22
 *@version 1.0
 */
public interface TsupervisorFundBService extends BaseService<TsupervisorFundB, String> {
	/**
	 * 通过监理ID查询资金情况B
	 * @comments 
	 * @param supervisorId
	 * @return
	 * @version 1.0
	 */
	public TsupervisorFundB getTsupervisorFundBBysupervisorId(String supervisorId);
	
	/**
	 * 保存或修改资金情况B
	 * @comments 
	 * @param supervisorId
	 * @param tsupervisorFundB
	 * @version 1.0
	 */
	public void saveOrUpdate(String supervisorId,TsupervisorFundB tsupervisorFundB);
}
