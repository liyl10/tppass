/*************** 版权声明***************
*
* Copyright (C) 2013 西安辉盛科技发展有限责任公司.
*
********************************************
*/
package com.hopsun.tppas.api.report.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.hopsun.framework.base.service.impl.BaseServiceImpl;
import com.hopsun.tppas.api.report.dao.TgroupExpertRealtionDao;
import com.hopsun.tppas.api.report.service.TgroupExpertRealtionService;
import com.hopsun.tppas.entity.TgroupExpertRealtion;

/**
 * @comments 组-专家关系表 
 * @author wanglw
 * @date 2013-10-30 @time 下午1:07:58
 * @Version 1.0
 */
@Service
public class TgroupExpertRealtionServiceImpl extends BaseServiceImpl<TgroupExpertRealtion,String> implements TgroupExpertRealtionService{

	@Resource
	public void setBaseDao(TgroupExpertRealtionDao tgroupExpertRealtionDao) {
		super.setBaseDao(tgroupExpertRealtionDao);
	}
	
	@Resource
	private TgroupExpertRealtionDao tgroupExpertRealtionDao;
}

