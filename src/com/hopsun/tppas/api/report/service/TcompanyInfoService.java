package com.hopsun.tppas.api.report.service;

import com.hopsun.tppas.entity.TcompanyInfo;
import com.hopsun.framework.base.service.BaseService;

public interface TcompanyInfoService extends BaseService<TcompanyInfo, String> {

	/**
	 * 更新企业项目基本信息表
	 * @comments 
	 * @param tcompanyInfo
	 * @param projectId
	 * @param userId
	 * @version 1.0
	 */
	public void updateTcompanyInfo(TcompanyInfo tcompanyInfo,String projectId,String userId);
	
	/**
	 * @comments 保存院所/高端人才
	 * @param projectId
	 * @param highEnd
	 * @Version 1.0
	 */
	public void updateHighEnd(String projectId, String highEnd);
	
}
