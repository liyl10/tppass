/*************** 版权声明***************
*
* Copyright (C) 2012 西安辉盛科技发展有限责任公司.
*
********************************************
*/
package com.hopsun.tppas.api.expert.dao.impl;

import java.util.Map;

import org.springframework.stereotype.Repository;

import com.hopsun.framework.base.bean.Finder;
import com.hopsun.framework.base.bean.Pager;
import com.hopsun.framework.base.dao.impl.BaseDaoImpl;
import com.hopsun.tppas.api.expert.dao.TtechnologyGainDao;
import com.hopsun.tppas.entity.TtechnologyGain;
/**
 * @comment 后台dao实现类-主要用来实现专家的成果信息的接口
 * @author yank
 * @DATE: 2013-08-19 @TIME: 下午2:09:37
 * @Vsersion: 1.0
 */
@Repository
public class TtechnologyGainDaoImpl extends BaseDaoImpl<TtechnologyGain, String> implements TtechnologyGainDao {
	
	/**
	 * 查询分页数据
	 * 
	 * @param int pageNo
	 * @param int pageSize
	 */
	public Pager queryTechnologyGain(Map<String,String> map,int pageNo, int pageSize) {
		String expertId = map.get("expertId");
		Finder f = Finder.create("from TtechnologyGain t where t.expertId = :expertId and t.deleteFlag = 0");
		// 排序条件
		f.append(" order by t.createTime desc");
		f.setParam("expertId", expertId);
		// 查询、返回
		Pager p = super.find(f, pageNo, pageSize);
		
		return p;
	}
}
