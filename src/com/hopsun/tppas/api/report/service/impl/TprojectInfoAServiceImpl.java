package com.hopsun.tppas.api.report.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.hopsun.framework.base.service.impl.BaseServiceImpl;
import com.hopsun.tppas.api.report.dao.TprojectInfoADao;
import com.hopsun.tppas.api.report.service.TprojectInfoAService;
import com.hopsun.tppas.api.superadmin.dao.MitemDao;
import com.hopsun.tppas.entity.TprojectInfoA;

@Service
public class TprojectInfoAServiceImpl extends BaseServiceImpl<TprojectInfoA,String> implements TprojectInfoAService{
	
	@Resource
	private TprojectInfoADao tprojectInfoADao;
	//码表
	@Resource 
	private MitemDao mitemDao;
	
	@Resource
	public void setBaseDao(TprojectInfoADao tprojectInfoADao) {
		super.setBaseDao(tprojectInfoADao);
	}
	
	/**
	 * 根据项目ID查询项目基本信息表表
	 *@param projectId
	 *@return List
	 */
	public List<TprojectInfoA> getTprojectInfoAById(String projectId){
		List<TprojectInfoA> tprojectInfoAList = new ArrayList<TprojectInfoA>();
		tprojectInfoAList = tprojectInfoADao.getList("tprojectApplication.projectId", projectId);
		for(int i=0; i<tprojectInfoAList.size(); i++){
			TprojectInfoA tprojectInfoA = tprojectInfoAList.get(i);
			if(tprojectInfoA != null){
				tprojectInfoA.setUnitPropertiesName(mitemDao.getItemName(tprojectInfoA.getUnitProperties()));
			}
		}
		return tprojectInfoAList;
	}
}
