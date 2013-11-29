/*************** 版权声明***************
*
* Copyright (C) 2012 西安辉盛科技发展有限责任公司.
*
********************************************
*/
package com.hopsun.tppas.api.report.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.hopsun.framework.base.bean.Pager;
import com.hopsun.framework.base.service.impl.BaseServiceImpl;
import com.hopsun.tppas.api.report.dao.TprojectApplicationOfficeDao;
import com.hopsun.tppas.api.report.service.TprojectApplicationOfficeService;
import com.hopsun.tppas.api.superadmin.dao.MitemDao;
import com.hopsun.tppas.common.Constants;
import com.hopsun.tppas.entity.TprojectApplication;

/**
 * @comments 局办公会意见
 * @author wanglw
 * @date 2013-11-21 @time 下午8:28:29
 * @Version 1.0
 */
@Service
public class TprojectApplicationOfficeServiceImpl extends BaseServiceImpl<TprojectApplication,String> implements TprojectApplicationOfficeService{
	
	@Resource
	private TprojectApplicationOfficeDao tprojectApplicationOfficeDao;
	
	@Resource
	public void setBaseDao(TprojectApplicationOfficeDao tprojectApplicationOfficeDao) {
		super.setBaseDao(tprojectApplicationOfficeDao);
	}
	
	@Resource
	private MitemDao mitemDao;
	/**
	 * @comments 局办公会意见
	 * @param param
	 * @param pageNo
	 * @param pageSize
	 * @return
	 * @Version 1.0
	 */
	public Pager getOfficeAuditList(Map<String, Object> param, int pageNo, int pageSize){
		Pager p = tprojectApplicationOfficeDao.getOfficeAuditList(param, pageNo, pageSize);
		
		if(p.getList() !=null && p.getList().size() > 0){
			List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
			
			Set<String> groupSet = new HashSet<String>();
			int num = 0;
			for (int i = 0; i < p.getList().size(); i++) {
				
				// 列表信息Map
				Map<String, Object> valueMap = new HashMap<String, Object>();
				
				// 项目申报表
				TprojectApplication t1 = (TprojectApplication) p.getList().get(i);;
				
				// 项目ID	
				valueMap.put("projectId", t1.getProjectId().trim());
				
				if(t1.getExpertAuditComposite() != null && !"".equals(t1.getExpertAuditComposite())){
					valueMap.put("selectedExpertFlag", "1");
				}
				else{
					valueMap.put("selectedExpertFlag", "0");
				}
				
				// 项目名称
				valueMap.put("projectName", t1.getProjectName());
				
				// 申报单位
				valueMap.put("applicationUnit", t1.getApplicationUnit());
				
				// 申请单位ID
				valueMap.put("userId", t1.getUserId());
				
				// 项目类别
				valueMap.put("projectTypeName", t1.getPlanFlagName() + Constants.STRING_LINK + t1.getTypeName());
				
				// 项目分类
				valueMap.put("typeId", t1.getTprojectType().getTypeId());
								
				// 项目分组
				valueMap.put("groupId", t1.getTprojectGroup().getGroupId());
				
				String expertAuditRecommend ="";
				if (!isNullString(t1.getExpertAuditRecommend())){
					
					expertAuditRecommend = mitemDao.getItemName(t1.getExpertAuditRecommend());
					valueMap.put("expertAuditRecommend", expertAuditRecommend);
				}
				
				valueMap.put("projectTechnologyAverage", t1.getProjectTechnologyAverage());
				valueMap.put("projectTechnologyResult", t1.getProjectTechnologyResult());
				valueMap.put("projectInvestmentAverage", t1.getProjectInvestmentAverage());
				valueMap.put("projectInvestmentResult", t1.getProjectInvestmentResult());
								
				String expertAuditComposite ="";
				if(Constants.RECOMMENDATION_RECOMMEND.equals(t1.getExpertAuditRecommend())){
					expertAuditComposite = mitemDao.getItemName(Constants.OFFICE_PASS);
				}
				else if(Constants.RECOMMENDATION_ALTERNATIVE.equals(t1.getExpertAuditRecommend())
						|| Constants.RECOMMENDATION_RECOMMEND.equals(t1.getExpertAuditRecommend())){
					if(Constants.OFFICE_PASS.equals(t1.getExpertAuditComposite())){
						expertAuditComposite = mitemDao.getItemName(Constants.OFFICE_PASS);
					}
					else{
						expertAuditComposite = mitemDao.getItemName(Constants.OFFICE_NOPASS);
					}
				}
				else{
					if(Constants.OFFICE_PASS.equals(t1.getExpertAuditComposite())){
						expertAuditComposite = mitemDao.getItemName(Constants.OFFICE_PASS);
					}
					else if(Constants.OFFICE_NOPASS.equals(t1.getExpertAuditComposite())){
						expertAuditComposite = mitemDao.getItemName(Constants.OFFICE_NOPASS);
					}
				}
				
				if(!isNullString(t1.getExpertAuditComposite())){
					if(Constants.OFFICE_PASS.equals(t1.getExpertAuditComposite())){
						expertAuditComposite = mitemDao.getItemName(Constants.OFFICE_PASS);
					}
					else if(Constants.OFFICE_NOPASS.equals(t1.getExpertAuditComposite())){
						expertAuditComposite = mitemDao.getItemName(Constants.OFFICE_NOPASS);
					}
				}
				
				valueMap.put("expertAuditComposite", expertAuditComposite);
				
				// 第一个组
				if(i == 0){
					
					Map<String, Object> groupMap = new HashMap<String, Object>();
					// 计划类别
					// groupMap.put("groupId", t1.getTprojectGroup().getGroupId());
					
					// 计划类别名称
					groupMap.put("groupShowName", t1.getTprojectGroup().getGroupName());
					
					// 分组标识
					groupMap.put("groupName", "group" + i);
					
					num = i;
					
					groupMap.put("projectId", "");
					
					// 分组ID
					groupMap.put("groupId", t1.getTprojectGroup().getGroupId());
					
					// 判断组下面有没有专家
					//groupMap.put("expertBygroup", getExpertBygroup(t1.getTprojectGroup().getGroupId()));
					
					list.add(groupMap);
					
					groupSet.add(t1.getTprojectGroup().getGroupId());
				}
				// 除过第一个组的其他组
				else{
					if(groupSet.size() > 0){
						if(!groupSet.contains(t1.getTprojectGroup().getGroupId())){
							
							Map<String, Object> groupMap = new HashMap<String, Object>();
							// 计划类别
							//groupMap.put("groupId", t1.getTprojectGroup().getGroupId());
							
							// 计划类别名称
							groupMap.put("groupShowName", t1.getTprojectGroup().getGroupName());
							
							// 分组标识
							groupMap.put("groupName", "group" + i);
							
							num = i;
							
							groupMap.put("projectId", "");
							
							// 分组ID
							groupMap.put("groupId", t1.getTprojectGroup().getGroupId());
							
							// 判断组下面有没有专家
							//groupMap.put("expertBygroup", getExpertBygroup(t1.getTprojectGroup().getGroupId()));
							
							list.add(groupMap);
							
							groupSet.add(t1.getTprojectGroup().getGroupId());
						}
					}
				}
				// 分组标识
				valueMap.put("groupName", "group" + num);
				
				list.add(valueMap);
			}
			
			// 设定list集合
			p.setList(list);
		}
		
		return p;
	}
	
	/**
	 * @comments 批量保存局办公会意见
	 * @param projectId
	 * @param officeStatus
	 * @Version 1.0
	 */
	public void updateBatchOfficeStatus(String projectId, String officeStatus){
		String [] projectIds = projectId.split(",");
		
		for(int i=0; i< projectIds.length; i++){
			// 根据项目Id取得项目信息
			TprojectApplication tpTemp = tprojectApplicationOfficeDao.get(projectIds[i]);
			
			// 清除分计划信息
			if(tpTemp != null && tpTemp.getTplan() != null){
				if(Constants.OFFICE_NOPASS.equals(officeStatus)){
					tpTemp.setTplan(null);
				}
			}
			
			// 联席会审核结果
			tpTemp.setExpertAuditComposite(officeStatus);
			
			// 更新时间
			tpTemp.setUpdateTime(new java.sql.Timestamp(new java.util.Date().getTime()));
			
			// 更新		
			tprojectApplicationOfficeDao.update(tpTemp);
		}
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

