/*************** 版权声明***************
*
* Copyright (C) 2012 西安辉盛科技发展有限责任公司.
*
********************************************
*/
package com.hopsun.tppas.api.report.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.hopsun.framework.base.service.impl.BaseServiceImpl;
import com.hopsun.tppas.api.report.dao.TtechnicalIndexesDao;
import com.hopsun.tppas.api.report.service.TtechnicalIndexesService;
import com.hopsun.tppas.common.Constants;
import com.hopsun.tppas.entity.TtechnicalIndexes;

/**
 * @comments 项目达到的主要技术指标（非高新）
 * @author weina
 * @date 2013-9-26 @time 下午21:20:37
 * @Version 1.0
 */
@Service
public class TtechnicalIndexesServiceImpl extends BaseServiceImpl<TtechnicalIndexes,String> implements TtechnicalIndexesService{
	
	@Resource
	private TtechnicalIndexesDao ttechnicalIndexesDao;
	
	@Resource
	public void setBaseDao(TtechnicalIndexesDao ttechnicalIndexesDao) {
		super.setBaseDao(ttechnicalIndexesDao);
	}
	
	/**
	 * @comments 
	 * @param ttechnicalIndexes
	 * @param userId
	 * @Version 1.0
	 */
	public void saveTtechnicalIndexes(TtechnicalIndexes ttechnicalIndexes, String userId){
		
		// 更新
		if(ttechnicalIndexes.getTechnicalIndexesId() != null
				&& !"".equals(ttechnicalIndexes.getTechnicalIndexesId())){
			
			// 取得项目达到的主要技术指标
			TtechnicalIndexes trTemp = ttechnicalIndexesDao.get(ttechnicalIndexes.getTechnicalIndexesId());
			
			// 项目达到的主要技术指标
			trTemp.setTechnicalIndexes(ttechnicalIndexes.getTechnicalIndexes());
			
			// 更新时间
			trTemp.setUpdateTime(new java.sql.Timestamp(new java.util.Date().getTime()));
			// 更新者
			trTemp.setUpdateUser(userId);
			
			ttechnicalIndexesDao.evict(ttechnicalIndexes);
			
			// 更新项目达到的主要技术指标
			ttechnicalIndexesDao.update(trTemp);
		}
		// 新增
		else{
			
			// 创建时间
			ttechnicalIndexes.setCreateTime(new java.sql.Timestamp(new java.util.Date().getTime()));
			// 创建者
			ttechnicalIndexes.setUpdateUser(userId);
			// 删除区分
			ttechnicalIndexes.setDeleteFlag(Constants.COMMON_STATE_NOTDELETE);
			// 新增项目达到的主要技术指标
			ttechnicalIndexesDao.save(ttechnicalIndexes);
		}
	}
}
