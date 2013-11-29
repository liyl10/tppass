/************************* 版权声明 *********************************
 *
 * Copyright (C) 2012 西安辉盛科技发展有限责任公司.
 *
 ******************************************************************
 */
package com.hopsun.tppas.api.supervisor.service;

import com.hopsun.framework.base.service.BaseService;
import com.hopsun.tppas.entity.TcompanyDevelopInfo;

/**
 * @comments 企业发展情况
 * @author wangxiaodong
 * @date 2013-9-22
 * @version 1.0
 */
public interface TcompanyDevelopInfoService extends BaseService<TcompanyDevelopInfo, String> {
	/**
	 * 通过监理ID查询该监理下的企业发展情况
	 * @comments 
	 * @param supervisorId
	 * @return
	 * @version 1.0
	 */
	public TcompanyDevelopInfo getCompanyDevelopInfoBySupervisorId(String supervisorId);
	
	/**
	 * 保存或修改企业发展情况
	 * @comments 
	 * @param supervisorId
	 * @param tcompanyDevelopInfo
	 * @version 1.0
	 */
	public void saveOrUpdate(String supervisorId,TcompanyDevelopInfo tcompanyDevelopInfo);
}
