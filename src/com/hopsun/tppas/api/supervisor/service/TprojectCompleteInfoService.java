/************************* 版权声明 *********************************
 *
 * Copyright (C) 2012 西安辉盛科技发展有限责任公司.
 *
 ******************************************************************
 */
package com.hopsun.tppas.api.supervisor.service;

import java.util.List;

import com.hopsun.tppas.entity.TprojectCompleteInfo;
import com.hopsun.tppas.entity.TtechnicalCompleteInfo;
import com.hopsun.framework.base.service.BaseService;

/**
 * @comments 对照合同项目任务完成情况
 * @author wangxiaodong
 * @date 2013-9-22
 * @version 1.0
 */
public interface TprojectCompleteInfoService extends BaseService<TprojectCompleteInfo, String> {
	/**
	 * 通过监理ID查询该监理下的对照合同项目任务完成情况
	 * @comments 
	 * @param supervisorId
	 * @return
	 * @version 1.0
	 */
	public TprojectCompleteInfo getProjectCompleteInfoBySupervisorId(String supervisorId);
	
	/**
	 * 保存或修改对照合同项目任务完成情况
	 * @comments 
	 * @param supervisorId
	 * @param tprojectCompleteInfo
	 * @version 1.0
	 */
	public void saveOrUpdate(String supervisorId,TprojectCompleteInfo tprojectCompleteInfo,String[] selectedProjectStopReason,List<TtechnicalCompleteInfo> technicalList);
}
