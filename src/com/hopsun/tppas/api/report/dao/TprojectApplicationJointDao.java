/*************** 版权声明***************
*
* Copyright (C) 2012 西安辉盛科技发展有限责任公司.
*
********************************************
*/
package com.hopsun.tppas.api.report.dao;

import java.util.List;
import java.util.Map;

import com.hopsun.framework.base.bean.Pager;
import com.hopsun.framework.base.dao.BaseDao;
import com.hopsun.tppas.entity.TprojectApplication;

/**
 * @comments 联席会审核
 * @author wanglw
 * @date 2013-9-16 @time 下午2:13:45
 * @Version 1.0
 */
public interface TprojectApplicationJointDao extends BaseDao<TprojectApplication, String>{

	/**
	 * @comments 取得联席会审核项目List
	 * @param param
	 * @param pageNo
	 * @param pageSize
	 * @return
	 * @Version 1.0
	 */
	public Pager getJointAuditList(Map<String, Object> param, int pageNo, int pageSize);
	
	//wangxd start
	/**
	 * 通过条件打印专家评审结果
	 * @comments 
	 * @param paramMap
	 * @return
	 * @version 1.0
	 */
	public List<Object[]> printExpertScoreAll(Map<String,Object> paramMap);
	
	//wangxd end
}

