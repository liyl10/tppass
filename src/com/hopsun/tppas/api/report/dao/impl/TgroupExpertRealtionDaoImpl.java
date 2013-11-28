/*************** 版权声明***************
*
* Copyright (C) 2013 西安辉盛科技发展有限责任公司.
*
********************************************
*/
package com.hopsun.tppas.api.report.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.hopsun.framework.base.dao.impl.BaseDaoImpl;
import com.hopsun.tppas.api.report.dao.TgroupExpertRealtionDao;
import com.hopsun.tppas.entity.TgroupExpertRealtion;

/**
 * @comments 组-专家关系表
 * @author wanglw
 * @date 2013-10-30 @time 上午11:40:09
 * @Version 1.0
 */
@Repository
public class TgroupExpertRealtionDaoImpl extends BaseDaoImpl<TgroupExpertRealtion, String> implements
		TgroupExpertRealtionDao {

	/**
	 * @comments 取得组-专家list
	 * @param groupId
	 * @return
	 * @Version 1.0
	 */
	public List<TgroupExpertRealtion> getTgList(String groupId){
		
		StringBuffer hql = new StringBuffer();
		
		// 生成hql
		hql.append(" from TgroupExpertRealtion t ");
		
		hql.append(" where t.tprojectGroup.groupId = ?");
		
		hql.append(" order by t.texpert.expertType asc");
		
		return super.createQueryList(hql.toString(), new String[]{groupId});
	}

}

