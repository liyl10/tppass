/*************** 版权声明***************
*
* Copyright (C) 2012 西安辉盛科技发展有限责任公司.
*
********************************************
*/
package com.hopsun.tppas.api.expert.dao;

import java.util.Map;

import com.hopsun.framework.base.bean.Pager;
import com.hopsun.framework.base.dao.BaseDao;
import com.hopsun.tppas.entity.TtechnologyGain;
/**
 * @comment 后台dao实现类-主要用来定义专家的成果信息的接口
 * @author yank
 * @DATE: 2013-08-19 @TIME: 下午2:09:37
 * @Vsersion: 1.0
 */
public interface TtechnologyGainDao extends BaseDao<TtechnologyGain, String>{
	
	/**
	 * 查询专业技术研究成果
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	public Pager queryTechnologyGain(Map<String,String> map,int pageNo, int pageSize) ;
	
	
}
