/************************* 版权声明 *********************************
 *
 * Copyright (C) 2012 西安辉盛科技发展有限责任公司.
 *
 ******************************************************************
 */
package com.hopsun.tppas.api.supervisor.dao;

import com.hopsun.tppas.entity.TprojectManagementInfo;
import com.hopsun.framework.base.dao.BaseDao;

/**
 * @comments 项目实施管理情况
 * @author wangxiaodong
 * @date 2013-9-21
 * @version 1.0
 */
public interface TprojectManagementInfoDao extends BaseDao<TprojectManagementInfo, String>{
	
	/**
	 * 通过监理ID查询该监理下的项目实施管理情况
	 * @comments 
	 * @param supervisorId
	 * @return
	 * @version 1.0
	 */
	public TprojectManagementInfo getProjectManagementInfoBySupervisorId(String supervisorId);
}
