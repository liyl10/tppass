/**
 * @filename ConfigService.java
 * @author zzze
 * @date Dec 27, 2012
 * @vsersion 1.0
 * Copyright (C) 2012 辉盛科技发展责任有限公司
 */
package com.hopsun.subgroups.paramconfig.service;

import com.hopsun.framework.base.bean.Pager;
import com.hopsun.framework.base.service.BaseService;
import com.hopsun.subgroups.entity.UcParamConfig;

/**
 *@comment 系统配置业务接口 
 *@author zzze
 *@date Dec 27, 2012
 *@version 1.0
 */
public interface ConfigService extends BaseService<UcParamConfig, String>{
	/**
	 * @comment 业务层分页方法 
	 * @param pager
	 * @param config
	 * @return
	 * @version: 1.0
	 */
	Pager list(Pager pager, UcParamConfig config);
}
