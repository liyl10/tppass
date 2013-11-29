package com.hopsun.tppas.api.statistics.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.hopsun.framework.base.bean.Pager;
import com.hopsun.framework.base.service.impl.BaseServiceImpl;
import com.hopsun.tppas.api.contract.dao.TcontractDao;
import com.hopsun.tppas.api.statistics.dao.StatisticsProjectDao;
import com.hopsun.tppas.api.statistics.service.StatisticsProjectService;
import com.hopsun.tppas.api.superadmin.dao.MitemDao;
import com.hopsun.tppas.entity.Tcontract;
import com.hopsun.tppas.view.VprojectInfoAll;
/**
 * @Comments:   后台Service接口-主要用来实现项目统计操作的接口
 * @author  lihf
 * @date 2013-08-01
 * @version 1.0
 *
 */
@Service
public class StatisticsProjectServiceImpl extends BaseServiceImpl<VprojectInfoAll,String> implements StatisticsProjectService{
	
	@Resource
	private StatisticsProjectDao statisticsProjectDao;
	@Resource
	private TcontractDao tcontractDao;
	
	// 码表
	@Resource 
	private MitemDao mitemDao;
	
	@Resource
	public void setBaseDao(StatisticsProjectDao statisticsProjectDao) {
		super.setBaseDao(statisticsProjectDao);
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
		Pager pager = statisticsProjectDao.queryProjectInfo(param, pageNo, pageSize);
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
					//申报状态
					if(vprojectInfoAll.getApplyStatus() != null && !"".equals(vprojectInfoAll.getApplyStatus())){
						vprojectInfoAll.setApplyStatus(mitemDao.getItemName(vprojectInfoAll.getApplyStatus()));
					} else {
						vprojectInfoAll.setApplyStatus("");
					}
					//合同状态
					if(vprojectInfoAll.getProjectId() != null && !"".equals(vprojectInfoAll.getProjectId())){
						Tcontract tcontract = tcontractDao.get("tprojectApplication.projectId",vprojectInfoAll.getProjectId());
						if (tcontract != null && tcontract.getContractStatus() != null){
							vprojectInfoAll.setContractStatus(mitemDao.getItemName(tcontract.getContractStatus()));
						}
						else{
							vprojectInfoAll.setContractStatus("未审核");
						}
					} else {
						vprojectInfoAll.setContractStatus("");
					}
				}
			}
		}
		return pager;
	}
	
	/**
	 * @comments 取得表的属性
	 * @param tableName
	 * @return
	 * @Version 1.0
	 */
	public List<Object> getTableInfo(String[] tableName) {
		return statisticsProjectDao.getTableInfo(tableName);
	}
	
	/**
	 * @comments 取得导出数据
	 * @param param
	 * @return
	 * @Version 1.0
	 */
	public List<Object> getExportDatas(Map<String, Object> param) {
		List<Object> list = new ArrayList<Object>();
		// HQL

		list = statisticsProjectDao.queryListinfo(param);

		// 经济指标表(执行期经济指标表) T_ECONOMIC_INDICATOR t7
		// 经费概算表 T_APPROPRIATION_BUDGET t8
		// 用款计划表 T_MONEY_SCHEDULE t9

		return list;
	}
	

	
	/**
	 * @comments 判断字符串是否为空
	 * @param obj
	 * @return
	 * @Version 1.0
	 */
	/*private Boolean isNotNullOrEmpty(Object obj) {

		if (!"".equals(obj) && obj != null) {
			return true;
		}
		return false;
	}*/
}
