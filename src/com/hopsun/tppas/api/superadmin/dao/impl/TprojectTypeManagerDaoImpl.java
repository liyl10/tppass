/************************* 版权声明 *********************************
 *
 * Copyright (C) 2012 西安辉盛科技发展有限责任公司.
 *
 ******************************************************************
 */
package com.hopsun.tppas.api.superadmin.dao.impl;

import java.util.List;
import java.util.Map;

import com.hopsun.tppas.api.superadmin.dao.TprojectTypeManagerDao;
import com.hopsun.tppas.common.CommonTool;
import com.hopsun.tppas.common.Constants;
import com.hopsun.framework.base.bean.Finder;
import com.hopsun.framework.base.dao.impl.BaseDaoImpl;
import com.hopsun.tppas.entity.TprojectTypeManager;
import org.springframework.stereotype.Repository;

/**
 * @comments 计划类别管理专员
 * @author wangxiaodong
 * @date 2013-10-23
 * @version 1.0
 */
@Repository
public class TprojectTypeManagerDaoImpl extends BaseDaoImpl<TprojectTypeManager, String> implements TprojectTypeManagerDao {

	/**
	 *通过条件查询计划类别管理专员
	 * @comments 
	 * @param valueMap
	 * @return
	 * @version 1.0
	 */
	@SuppressWarnings("unchecked")
	public List<TprojectTypeManager> getTprojectTypeManager(Map<String, Object> valueMap) {
		Finder f = Finder.create("from TprojectTypeManager t where t.deleteFlag='"+Constants.COMMON_STATE_NOTDELETE+"'");
		//计划类别ID
		String typeId = (String)valueMap.get("typeId");
		if(CommonTool.IsNotEmpty(typeId)){
			f.append(" and t.typeId=:typeId").setParam("typeId", typeId);
		}
		//用户ID
		String userId = (String)valueMap.get("userId");
		if(CommonTool.IsNotEmpty(userId)){
			f.append(" and t.userId=:userId").setParam("userId", userId);
		}
		
		return super.find(f);
	}
	   
	
}

