/************************* 版权声明 *********************************
 *
 * Copyright (C) 2012 西安辉盛科技发展有限责任公司.
 *
 ******************************************************************
 */
package com.hopsun.tppas.api.superadmin.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.hopsun.framework.base.bean.Pager;
import com.hopsun.framework.base.service.impl.BaseServiceImpl;
import com.hopsun.tppas.api.superadmin.dao.MtypeDao;
import com.hopsun.tppas.api.superadmin.service.MtypeService;
import com.hopsun.tppas.entity.Mtype;

/**
 * @comment 代码类型表实现类
 * @author liush
 * @DATE: 2013-5-29 @TIME: 上午11:08:11
 * @Vsersion: 1.0
 */
@Service("apiMtypeService")
public class MtypeServiceImpl extends BaseServiceImpl<Mtype,String> implements MtypeService{
	
	@Resource
	private MtypeDao mtypeDao;
	
	@Resource
	public void setBaseDao(MtypeDao mtypeDao) {
		super.setBaseDao(mtypeDao);
	}
	
	/**
	 * 分页查询
	 *@param param pageNumber pageSize 
	 *@return Pager
	 */
	public Pager find(Map<String, Object> param, Integer pageNumber, Integer pageSize) {
		return mtypeDao.find(param, pageNumber, pageSize);
	}

	/**
	 * @Comments 取得有序的类型信息
	 * @return
	 * @Vsersion: 1.0
	 */
	public List<Mtype> getInfoList() {
		// TODO Auto-generated method stub
		return mtypeDao.getInfoList();
	}
}
