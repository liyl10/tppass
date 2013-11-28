/************************* 版权声明 *********************************
 *
 * Copyright (C) 2012 西安辉盛科技发展有限责任公司.
 *
 ******************************************************************
 */
package com.hopsun.tppas.api.supervisor.service;

import com.hopsun.tppas.entity.TprojectAchievementInfo;
import com.hopsun.framework.base.service.BaseService;

/**
 * @comments 项目取得成果情况
 * @author wangxiaodong
 * @date 2013-9-22
 * @version 1.0
 */
public interface TprojectAchievementInfoService extends BaseService<TprojectAchievementInfo, String> {
	/**
	 * 通过监理ID查询该监理下的项目取得成果情况
	 * @comments 
	 * @param supervisorId
	 * @return
	 * @version 1.0
	 */
	public TprojectAchievementInfo getProjectAchievementInfoBySupervisorId(String supervisorId);
	
	/**
	 * 保存或修改项目取得成果情况
	 * @comments 
	 * @param supervisorId
	 * @param tprojectAchievementInfo
	 * @version 1.0
	 */
	public void saveOrUpdate(String supervisorId,TprojectAchievementInfo tprojectAchievementInfo);
}
