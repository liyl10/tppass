/************************* 版权声明 *********************************
 *
 * Copyright (C) 2012 西安辉盛科技发展有限责任公司.
 *
 ******************************************************************/
package com.hopsun.tppas.api.supervisor.dao;

import com.hopsun.tppas.entity.TcompanyDevelopInfo;
import com.hopsun.framework.base.dao.BaseDao;

/**
 * @comments 企业发展情况
 * @author wangxiaodong
 * @date 2013-8-9
 * @version 1.0
 */
public interface TcompanyDevelopInfoDao extends BaseDao<TcompanyDevelopInfo, String>{
	
	/**
	 * 通过监理ID查询该监理下的企业发展情况
	 * @comments 
	 * @param supervisorId
	 * @return
	 * @version 1.0
	 */
	public TcompanyDevelopInfo getCompanyDevelopInfoBySupervisorId(String supervisorId);
}
