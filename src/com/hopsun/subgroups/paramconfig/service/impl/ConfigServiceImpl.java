/**
 * @filename ConfigServiceImpl.java
 * @author zzze
 * @date Dec 27, 2012
 * @vsersion 1.0
 * Copyright (C) 2012 辉盛科技发展责任有限公司
 */
package com.hopsun.subgroups.paramconfig.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.hopsun.framework.base.bean.Pager;
import com.hopsun.framework.base.service.impl.BaseServiceImpl;
import com.hopsun.subgroups.entity.UcParamConfig;
import com.hopsun.subgroups.paramconfig.dao.ConfigDao;
import com.hopsun.subgroups.paramconfig.service.ConfigService;
/**
 *@comment 系统配置业务实现 
 *@author zzze
 *@date Dec 27, 2012
 *@version 1.0
 */
@Service("configService")
public class ConfigServiceImpl extends BaseServiceImpl<UcParamConfig, String> implements ConfigService{

	@Resource
	public transient ConfigDao configDao;
	@Resource
	public void setBaseDao(final ConfigDao configDao) {
		super.setBaseDao(configDao);
	}
	/**
	 * @comment 分页业务实现 
	 * @param pager
	 * @param config
	 * @return
	 * @version: 1.0
	 */
	public Pager list(final Pager pager, final UcParamConfig config) {
		return configDao.list(pager, config);
	}
}
