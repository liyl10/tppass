/*************** 版权声明***************
*
* Copyright (C) 2012 西安辉盛科技发展有限责任公司.
*
********************************************
*/
package com.hopsun.tppas.api.report.dao;

import java.util.Map;

import com.hopsun.framework.base.bean.Pager;
import com.hopsun.framework.base.dao.BaseDao;
import com.hopsun.tppas.entity.TprojectApplication;

/**
 * @comments 局办公会意见
 * @author wanglw
 * @date 2013-11-21 @time 下午8:27:26
 * @Version 1.0
 */
public interface TprojectApplicationOfficeDao extends BaseDao<TprojectApplication, String>{

	/**
	 * @comments 局办公会意见
	 * @param param
	 * @param pageNo
	 * @param pageSize
	 * @return
	 * @Version 1.0
	 */
	public Pager getOfficeAuditList(Map<String, Object> param, int pageNo, int pageSize);
}

