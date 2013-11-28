/**
 * @filename ConfigDao.java
 * @author zzze
 * @date Dec 27, 2012
 * @vsersion 1.0
 * Copyright (C) 2012 辉盛科技发展责任有限公司
 */
package com.hopsun.subgroups.paramconfig.dao;

import com.hopsun.framework.base.bean.Pager;
import com.hopsun.framework.base.dao.BaseDao;
import com.hopsun.subgroups.entity.UcParamConfig;

public interface ConfigDao extends BaseDao<UcParamConfig, String>{
	/**
	 * @comment 分页方法
	 * @param pager
	 * @param config
	 * @return
	 * @version: 1.0
	 */
	Pager list(Pager pager, UcParamConfig config);
}
