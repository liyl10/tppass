/**
 * @filename ConfigDaoImal.java
 * @author zzze
 * @date Dec 27, 2012
 * @vsersion 1.0
 * Copyright (C) 2012 辉盛科技发展责任有限公司
 */
package com.hopsun.subgroups.paramconfig.dao.impl;

import org.springframework.stereotype.Repository;

import com.hopsun.framework.base.bean.Finder;
import com.hopsun.framework.base.bean.Pager;
import com.hopsun.framework.base.dao.impl.BaseDaoImpl;
import com.hopsun.framework.util.Util;
import com.hopsun.subgroups.entity.UcParamConfig;
import com.hopsun.subgroups.paramconfig.dao.ConfigDao;
/**
 *@comment 持久层实现类 
 *@author zzze
 *@date Dec 27, 2012
 *@version 1.0
 */
@Repository
public class ConfigDaoImpl extends BaseDaoImpl<UcParamConfig, String> implements ConfigDao{
	
	/* (non-Javadoc)
	 * @see com.hopsun.Scenter.config.dao.impl.Test#list(com.hopsun.framework.base.bean.Pager, com.hopsun.ucenter.entity.UcParamConfig)
	 */
	public Pager list(final Pager pager, final UcParamConfig config) {
		final StringBuilder builder = new StringBuilder("from UcParamConfig t where 1=1 ");
		if(Util.checkNotNull(config)){
			if(Util.checkNotNull(config.getParamName())){
				builder.append(" and paramName like '%"+config.getParamName()+"%' ");
			}
			if(Util.checkNotNull(config.getParamCode())){
				builder.append(" and paramCode like '%"+config.getParamCode()+"%' ");
			}
			if(Util.checkNotNull(config.getParamUseage())){
				builder.append(" and paramUseage like '%"+config.getParamUseage()+"%' ");
			}
		}
		final Pager result = this.find(Finder.create(builder.toString()), pager.getPageNumber(), pager.getPageSize());
		pager.setList(result.getList());
		if(pager.getTotalCount()==0){
			pager.setTotalCount(result.getTotalCount());
			pager.setKeyword(result.getKeyword());
			pager.setOrderBy(result.getOrderBy());
			pager.setOrderType(result.getOrderType());
			pager.setPageCount(result.getPageCount());
			pager.setPageNumber(result.getPageNumber());
			pager.setPageSize(result.getPageSize());
			pager.setProperty(result.getProperty());
		}
		return pager;
	}
}
