/*************** 版权声明***************
*
* Copyright (C) 2012 西安辉盛科技发展有限责任公司.
*
********************************************
*/
package com.hopsun.tppas.api.report.dao;

import java.util.List;

import com.hopsun.framework.base.bean.Pager;
import com.hopsun.framework.base.dao.BaseDao;
import com.hopsun.tppas.entity.TprojectLeaderA;

/**
 * @comment 项目负责人及主要人员
 * @author liush
 * @DATE: 2013-9-26 @TIME: 下午9:11:15
 * @Vsersion: 1.0
 */
public interface TprojectLeaderADao extends BaseDao<TprojectLeaderA, String>{
	
	/**
	 * @Comments 分页查询
	 * @param projectId
	 * @param pageNo
	 * @param pageSize
	 * @return
	 * @Vsersion: 1.0
	 */
	public Pager find(String projectId,int pageNo, int pageSize);
	
	/**
	 * @comments 查询有效研究人员
	 * @param projectId
	 * @return
	 * @version 1.0
	 */
	public List<TprojectLeaderA> getValidLeaderA(String projectId);
}
