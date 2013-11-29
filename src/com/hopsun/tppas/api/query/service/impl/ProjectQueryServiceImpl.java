package com.hopsun.tppas.api.query.service.impl;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.hopsun.framework.base.bean.Pager;
import com.hopsun.framework.base.service.impl.BaseServiceImpl;
import com.hopsun.tppas.api.query.dao.ProjectQueryDao;
import com.hopsun.tppas.api.query.service.ProjectQueryService;
import com.hopsun.tppas.api.superadmin.dao.MitemDao;
import com.hopsun.tppas.view.VprojectInfoAll;
/**
 * @Comments:   后台Service接口-主要用来实现项目申报操作的接口
 * @author  yk
 * @date 2013-08-01
 * @version 1.0
 *
 */
@Service
public class ProjectQueryServiceImpl extends BaseServiceImpl<VprojectInfoAll,String> implements ProjectQueryService{
	
	@Resource
	private ProjectQueryDao projectQueryDao;
	
	// 码表
	@Resource 
	private MitemDao mitemDao;
	
	@Resource
	public void setBaseDao(ProjectQueryDao projectQueryDao) {
		super.setBaseDao(projectQueryDao);
	}
	
	/**
	 * @comments 项目查询
	 * @param param
	 * @param pageNo
	 * @param pageSize
	 * @return
	 * @Version 1.0
	 */
	public Pager queryProjectInfo(Map<String, Object> param, int pageNo, int pageSize){
		Pager pager = projectQueryDao.queryProjectInfo(param, pageNo, pageSize);
		if (pager != null && pager.getList() != null && pager.getList().size() > 0) {
			for (int i = 0; i < pager.getList().size(); i++) {
				VprojectInfoAll vprojectInfoAll = (VprojectInfoAll) pager.getList().get(i);
				if (vprojectInfoAll != null) {
					// 所在区域
					if(vprojectInfoAll.getRegionId1() != null && !"".equals(vprojectInfoAll.getRegionId1())){
						vprojectInfoAll.setRegionIdName1(mitemDao.getItemName(vprojectInfoAll.getRegionId1()));
					} else {
						vprojectInfoAll.setRegionIdName1("");
					}
					if(vprojectInfoAll.getRegionId2() != null && !"".equals(vprojectInfoAll.getRegionId2())){
						vprojectInfoAll.setRegionIdName2(mitemDao.getItemName(vprojectInfoAll.getRegionId2()));
					} else {
						vprojectInfoAll.setRegionIdName2("");
					}
					if(vprojectInfoAll.getRegionId3() != null && !"".equals(vprojectInfoAll.getRegionId3())){
						vprojectInfoAll.setRegionIdName3(mitemDao.getItemName(vprojectInfoAll.getRegionId3()));
					} else {
						vprojectInfoAll.setRegionIdName3("");
					}
					
					// 行业领域
					if(vprojectInfoAll.getIndustries1() != null && !"".equals(vprojectInfoAll.getIndustries1())){
						vprojectInfoAll.setIndustriesName1(mitemDao.getItemName(vprojectInfoAll.getIndustries1()));
					} else {
						vprojectInfoAll.setIndustriesName1("");
					}
					if(vprojectInfoAll.getIndustries2() != null && !"".equals(vprojectInfoAll.getIndustries2())){
						vprojectInfoAll.setIndustriesName2(mitemDao.getItemName(vprojectInfoAll.getIndustries2()));
					} else {
						vprojectInfoAll.setIndustriesName2("");
					}
					if(vprojectInfoAll.getIndustries3() != null && !"".equals(vprojectInfoAll.getIndustries3())){
						vprojectInfoAll.setIndustriesName3(mitemDao.getItemName(vprojectInfoAll.getIndustries3()));
					} else {
						vprojectInfoAll.setIndustriesName3("");
					}
					if(vprojectInfoAll.getIndustries4() != null && !"".equals(vprojectInfoAll.getIndustries4())){
						vprojectInfoAll.setIndustriesName4(mitemDao.getItemName(vprojectInfoAll.getIndustries4()));
					} else {
						vprojectInfoAll.setIndustriesName4("");
					}
					// 归口管理部门
					if(vprojectInfoAll.getCentralizedType() != null && !"".equals(vprojectInfoAll.getCentralizedType())){
						vprojectInfoAll.setCentralizedTypeName(mitemDao.getItemName(vprojectInfoAll.getCentralizedType()));
					} else {
						vprojectInfoAll.setCentralizedTypeName("");
					}
				}
			}
		}
		return pager;
	}
	
}
