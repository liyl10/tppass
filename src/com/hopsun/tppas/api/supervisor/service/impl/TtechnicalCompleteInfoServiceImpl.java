/************************* 版权声明 *********************************
 *
 * Copyright (C) 2012 西安辉盛科技发展有限责任公司.
 *
 ******************************************************************
 */
package com.hopsun.tppas.api.supervisor.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.hopsun.framework.base.service.impl.BaseServiceImpl;
import com.hopsun.tppas.api.supervisor.dao.TtechnicalCompleteInfoDao;
import com.hopsun.tppas.api.supervisor.service.TtechnicalCompleteInfoService;
import com.hopsun.tppas.entity.TtechnicalCompleteInfo;

/**
 * @comments 技术指标完成情况
 * @author wangxiaodong
 * @date 2013-9-22
 * @version 1.0
 */
@Service
public class TtechnicalCompleteInfoServiceImpl extends BaseServiceImpl<TtechnicalCompleteInfo,String> implements TtechnicalCompleteInfoService{
	
	@Resource
	private TtechnicalCompleteInfoDao ttechnicalCompleteInfoDao;
	
	@Resource
	public void setBaseDao(TtechnicalCompleteInfoDao ttechnicalCompleteInfoDao) {
		super.setBaseDao(ttechnicalCompleteInfoDao);
	}
	
	/**
	 * @comments  通过监理ID查询该监理下的技术指标完成情况
	 * @param supervisorId
	 * @return
	 * @version 1.0
	 */
	public List<TtechnicalCompleteInfo> getTechnicalCompleteInfoBySupervisorId(String supervisorId) {
		
		return ttechnicalCompleteInfoDao.getTechnicalCompleteInfoBySupervisorId(supervisorId);
	}
}
