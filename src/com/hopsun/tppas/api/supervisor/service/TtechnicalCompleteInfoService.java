/************************* 版权声明 *********************************
 *
 * Copyright (C) 2012 西安辉盛科技发展有限责任公司.
 *
 ******************************************************************
 */
package com.hopsun.tppas.api.supervisor.service;

import java.util.List;

import com.hopsun.tppas.entity.TtechnicalCompleteInfo;
import com.hopsun.framework.base.service.BaseService;

/**
 * @comments 技术指标完成情况
 * @author wangxiaodong
 * @date 2013-9-22
 * @version 1.0
 */
public interface TtechnicalCompleteInfoService extends BaseService<TtechnicalCompleteInfo, String> {
	/**
	 * @comments  通过监理ID查询该监理下的技术指标完成情况
	 * @param supervisorId
	 * @return
	 * @version 1.0
	 */
	public List<TtechnicalCompleteInfo> getTechnicalCompleteInfoBySupervisorId(String supervisorId);
}
