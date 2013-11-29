/************************* 版权声明 *********************************
 *
 * Copyright (C) 2012 西安辉盛科技发展有限责任公司.
 *
 ******************************************************************
 */
package com.hopsun.tppas.api.supervisor.dao;

import com.hopsun.tppas.entity.TprojectCompleteInfo;
import com.hopsun.framework.base.dao.BaseDao;

/**
 * @comments 对照合同项目任务完成情况
 * @author wangxiaodong
 * @date 2013-8-8
 * @version 1.0
 */
public interface TprojectCompleteInfoDao extends BaseDao<TprojectCompleteInfo, String>{
	
	/**
	 * 通过监理ID查询该监理下的对照合同项目任务完成情况
	 * @comments 
	 * @param supervisorId
	 * @return
	 * @version 1.0
	 */
	public TprojectCompleteInfo getProjectCompleteInfoBySupervisorId(String supervisorId);
}
