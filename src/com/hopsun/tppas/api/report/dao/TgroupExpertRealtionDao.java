/*************** 版权声明***************
*
* Copyright (C) 2013 西安辉盛科技发展有限责任公司.
*
********************************************
*/
package com.hopsun.tppas.api.report.dao;

import java.util.List;

import com.hopsun.framework.base.dao.BaseDao;
import com.hopsun.tppas.entity.TgroupExpertRealtion;

/**
 * @comments 组-专家关系表
 * @author wanglw
 * @date 2013-10-30 @time 上午11:40:09
 * @Version 1.0
 */
public interface TgroupExpertRealtionDao extends BaseDao<TgroupExpertRealtion, String> {
	
	/**
	 * @comments 取得组-专家list
	 * @param groupId
	 * @return
	 * @Version 1.0
	 */
	public List<TgroupExpertRealtion> getTgList(String groupId);

}

