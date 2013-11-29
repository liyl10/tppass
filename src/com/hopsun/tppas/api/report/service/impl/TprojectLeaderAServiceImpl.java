/*************** 版权声明***************
*
* Copyright (C) 2012 西安辉盛科技发展有限责任公司.
*
********************************************
*/
package com.hopsun.tppas.api.report.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.hopsun.framework.base.bean.Pager;
import com.hopsun.framework.base.service.impl.BaseServiceImpl;
import com.hopsun.tppas.api.report.dao.TprojectLeaderADao;
import com.hopsun.tppas.api.report.service.TprojectLeaderAService;
import com.hopsun.tppas.entity.TprojectLeaderA;

/**
 * @comment 项目负责人及参加人员
 * @author liush
 * @DATE: 2013-9-26 @TIME: 下午9:16:17
 * @Vsersion: 1.0
 */
@Service
public class TprojectLeaderAServiceImpl extends BaseServiceImpl<TprojectLeaderA,String> implements TprojectLeaderAService{
	
	@Resource
	private TprojectLeaderADao tprojectLeaderADao;
	
	@Resource
	public void setBaseDao(TprojectLeaderADao tprojectLeaderADao) {
		super.setBaseDao(tprojectLeaderADao);
	}
	
	/**
	 * @Comments 分页查询
	 * @param projectId
	 * @param pageNo
	 * @param pageSize
	 * @return
	 * @Vsersion: 1.0
	 */
	public Pager find(String projectId, int pageNo, int pageSize) {
		Pager pager = tprojectLeaderADao.find(projectId, pageNo, pageSize);
		return pager;
		
	}
}	
