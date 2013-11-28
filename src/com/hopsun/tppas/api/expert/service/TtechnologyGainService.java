/*************** 版权声明***************
*
* Copyright (C) 2012 西安辉盛科技发展有限责任公司.
*
********************************************
*/
package com.hopsun.tppas.api.expert.service;

import java.util.Map;

import com.hopsun.framework.base.bean.Pager;
import com.hopsun.framework.base.service.BaseService;
import com.hopsun.tppas.entity.TtechnologyGain;
/**
 * @comment 后台service接口类-主要用来定义专家的成果信息的接口
 * @author yank
 * @DATE: 2013-08-19 @TIME: 下午2:09:37
 * @Vsersion: 1.0
 */
public interface TtechnologyGainService extends BaseService<TtechnologyGain, String> {
	/**
	 * 查询专家的成果信息
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	public Pager queryTechnologyGain(Map<String,String> map,int pageNo, int pageSize);
	
	/**
	 * 删除专家的成果信息
	 * @comments 
	 * @param gainId
	 * @version 1.0
	 */
	public void deleteTechnologyGain(String gainId);
	
}
