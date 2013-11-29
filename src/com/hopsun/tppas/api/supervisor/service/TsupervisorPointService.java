/************************* 版权声明 *********************************
 *
 * Copyright (C) 2012 西安辉盛科技发展有限责任公司.
 *
 ******************************************************************
 */
package com.hopsun.tppas.api.supervisor.service;

import com.hopsun.scenter.entity.ScUsers;
import com.hopsun.tppas.entity.TsupervisorPoint;
import com.hopsun.framework.base.service.BaseService;

/**
 * 项目监理点
 *@comments
 *@author wangxiaodong
 *@date 2013-9-17
 *@version 1.0
 */
public interface TsupervisorPointService extends BaseService<TsupervisorPoint, String> {
	
	/**
	 * 保存监理点
	 * @comments 
	 * @param supervisorPoint
	 * @param supervisorId
	 * @param user
	 * @version 1.0
	 */
	public void saveSupervisorPoint(TsupervisorPoint supervisorPoint,String supervisorId,ScUsers user);
	
	/**
	 * 修改监理点
	 * @comments 
	 * @param supervisorPoint
	 * @param supervisorId
	 * @param user
	 * @version 1.0
	 */
	public void updateSupervisorPoint(TsupervisorPoint supervisorPoint,String supervisorId,ScUsers user);
	
	/**
	 * 删除监理点
	 * @comments 
	 * @param supervisorPoint
	 * @param supervisorId
	 * @param user
	 * @version 1.0
	 */
	public void deleteSupervisorPoint(String pointId);
	
}
