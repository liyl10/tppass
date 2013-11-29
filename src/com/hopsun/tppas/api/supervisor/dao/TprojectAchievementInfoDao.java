/************************* 版权声明 *********************************
 *
 * Copyright (C) 2012 西安辉盛科技发展有限责任公司.
 *
 ******************************************************************
 */
package com.hopsun.tppas.api.supervisor.dao;

import com.hopsun.tppas.entity.TprojectAchievementInfo;
import com.hopsun.framework.base.dao.BaseDao;

/**
 * @comments 项目取得成果情况
 * @author wangxiaodong
 * @date 2013-9-22
 * @version 1.0
 */
public interface TprojectAchievementInfoDao extends BaseDao<TprojectAchievementInfo, String>{
	
	/**
	 * 通过监理ID查询该监理下的项目取得成果情况
	 * @comments 
	 * @param supervisorId
	 * @return
	 * @version 1.0
	 */
	public TprojectAchievementInfo getProjectAchievementInfoBySupervisorId(String supervisorId);
}
