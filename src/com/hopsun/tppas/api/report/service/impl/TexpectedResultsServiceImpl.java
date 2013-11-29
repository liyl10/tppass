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
import com.hopsun.tppas.api.report.dao.TexpectedResultsDao;
import com.hopsun.tppas.api.report.service.TexpectedResultsService;
import com.hopsun.tppas.common.Constants;
import com.hopsun.tppas.entity.TexpectedResults;

/**
 * @comments 预期成果（非高新）
 * @author weina
 * @date 2013-9-26 @time 下午21:20:37
 * @Version 1.0
 */
@Service
public class TexpectedResultsServiceImpl extends BaseServiceImpl<TexpectedResults,String> implements TexpectedResultsService{
	
	@Resource
	private TexpectedResultsDao texpectedResultsDao;
	
	@Resource
	public void setBaseDao(TexpectedResultsDao texpectedResultsDao) {
		super.setBaseDao(texpectedResultsDao);
	}
	
	/**
	 * @comments 
	 * @param texpectedResults
	 * @param userId
	 * @Version 1.0
	 */
	public void saveTexpectedResults(TexpectedResults texpectedResults, String userId){
		
		// 更新
		if(texpectedResults.getExpectedResultsId() != null
				&& !"".equals(texpectedResults.getExpectedResultsId())){
			
			// 取得预期成果
			TexpectedResults trTemp = texpectedResultsDao.get(texpectedResults.getExpectedResultsId());
			
			// 预期成果
			trTemp.setExpectedResults(texpectedResults.getExpectedResults());
			
			// 更新时间
			trTemp.setUpdateTime(new java.sql.Timestamp(new java.util.Date().getTime()));
			// 更新者
			trTemp.setUpdateUser(userId);
			
			texpectedResultsDao.evict(texpectedResults);
			
			// 更新摘要说明
			texpectedResultsDao.update(trTemp);
		}
		// 新增
		else{
			
			// 创建时间
			texpectedResults.setCreateTime(new java.sql.Timestamp(new java.util.Date().getTime()));
			// 创建者
			texpectedResults.setUpdateUser(userId);
			// 删除区分
			texpectedResults.setDeleteFlag(Constants.COMMON_STATE_NOTDELETE);
			// 新增预期成果
			texpectedResultsDao.save(texpectedResults);
		}
	}
}
