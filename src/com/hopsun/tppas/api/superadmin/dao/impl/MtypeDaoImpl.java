/************************* 版权声明 *********************************
 *
 * Copyright (C) 2012 西安辉盛科技发展有限责任公司.
 *
 ******************************************************************
 */
package com.hopsun.tppas.api.superadmin.dao.impl;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.hopsun.framework.base.bean.Finder;
import com.hopsun.framework.base.bean.Pager;
import com.hopsun.framework.base.dao.impl.BaseDaoImpl;
import com.hopsun.tppas.api.superadmin.dao.MtypeDao;
import com.hopsun.tppas.common.Constants;
import com.hopsun.tppas.entity.Mtype;

/**
 * @comment 代码类型表DAO层实现类
 * @author liush
 * @DATE: 2013-5-29 @TIME: 上午11:12:29
 * @Vsersion: 1.0
 */
@Repository
public class MtypeDaoImpl extends BaseDaoImpl<Mtype, String> implements MtypeDao {
	
	/**
	 * 分页查询
	 *@param param pageNumber pageSize 
	 *@return Pager
	 */
	public Pager find(Map<String, Object> param, Integer pageNumber, Integer pageSize){
		
		//创建Finder查询对象
		Finder f = Finder.create(" from Mtype d where d.delFlg=:delFlg");
		// 代码类型
	    String masterType = (String) param.get("masterType");
	    if (!isNullString(masterType)) {
			f.append(" and d.typeId = '" + masterType.trim() + "'");
		}
		f.append(" order by d.typeName desc,d.createTime desc");
		
		f.setParam("delFlg", Constants.COMMON_STATE_NOTDELETE);
		
		return super.find(f, pageNumber, pageSize);
	}

	/**
	 * @Comments 取得有序的类型信息
	 * @return
	 * @Vsersion: 1.0
	 */
	public List<Mtype> getInfoList() {
		StringBuffer hql = new StringBuffer();
		hql.append(" from Mtype d where d.delFlg=0");
		hql.append(" order by d.typeName desc,d.createTime desc");
		List<Mtype> ret =super.createQueryList(hql.toString(), new String[]{});
		return ret;
	}
	
	/**
	 * @comments 类型判断
	 * @param valueStr
	 * @return
	 * @Version 1.0
	 */
	private boolean isNullString(String valueStr) {
		if (valueStr != null && valueStr.length() > 0) {
			return false;
		} else {
			return true;
		}
	}
}
