/*************** 版权声明***************
*
* Copyright (C) 2012 西安辉盛科技发展有限责任公司.
*
********************************************
*/
package com.hopsun.tppas.api.statistics.service.impl;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.hopsun.framework.base.bean.Pager;
import com.hopsun.framework.base.service.impl.BaseServiceImpl;
import com.hopsun.tppas.api.statistics.dao.FundsDao;
import com.hopsun.tppas.api.statistics.service.FundsService;
import com.hopsun.tppas.api.superadmin.dao.TprojectTypeDao;
import com.hopsun.tppas.api.superadmin.service.MitemService;
import com.hopsun.tppas.common.Constants;
import com.hopsun.tppas.entity.Mitem;
import com.hopsun.tppas.entity.TappropriationSingle;
import com.hopsun.tppas.entity.TprojectApplication;
import com.hopsun.tppas.entity.TprojectType;

/**
 * 
 *@comments 项目结果汇总service实现类
 *@author liyilin
 *@date 2013-8-22
 *@version 1.0
 */
@Service
public class FundsServiceImpl extends
		BaseServiceImpl<TappropriationSingle, String> implements
		FundsService {

	@Resource
	private FundsDao fundsDao;

	@Resource
	public void setBaseDao(FundsDao fundsDao) {
		super.setBaseDao(fundsDao);
	}

	@Resource
	private MitemService mitemService;
	
	@Resource
	private TprojectTypeDao tprojectTypeDao;

	/**
	 * @comments 分页查询
	 * @param param
	 * @param pageNo
	 * @param pageSize
	 * @return
	 * @Version 1.0
	 */
	public Pager find(Map<String, Object> param, int pageNo, int pageSize,String deptId,Boolean isPlanningDept) {

		// HQL
		StringBuilder hql = new StringBuilder(
				" from TappropriationSingle t1, Tcontract t2, ");
		hql.append(" TprojectApplication t3, TprojectType t4 ");
		hql.append(" where t2.TContractId = t1.tcontract.TContractId ");
		hql.append(" and t2.tprojectApplication.projectId =  t3.projectId ");
		hql.append(" and t3.tprojectType.typeId = t4.typeId ");
		hql.append(getConditionDate(param,deptId,isPlanningDept));
		hql.append(" and t1.deleteFlag = '" + Constants.COMMON_STATE_NOTDELETE + "'");
		hql.append(" order by t1.appropriationTime asc ");
		Pager p = fundsDao.find(hql.toString(), pageNo, pageSize);
		// 获取Mitem信息
		List<Mitem> mitemList = mitemService.getMitemListInfo();
		Map<String, String> itemMap = new HashMap<String, String>();
		if (mitemList != null && mitemList.size() > 0) {
			for (Mitem m : mitemList) {
				itemMap.put(m.getItemId(), m.getItemName());
			}
		}

		if (p.getList() != null && p.getList().size() != 0) {
			List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
			for (int i = 0; i < p.getList().size(); i++) {
				Object[] obj = (Object[]) p.getList().get(i);
				Map<String, Object> valueMap = new HashMap<String, Object>();

				// 拨款单
				TappropriationSingle t1 = (TappropriationSingle) obj[0];
				
				// 开户银行及行号
				valueMap.put("bank", t1.getBank());
				// 账号
				valueMap.put("bankAccount", t1.getAccount());
				// 本次拨款金额
				valueMap.put("amountFunding", t1.getAmountFunding());
				// 计划拨款金额
				valueMap.put("planFunding", t1.getPlanFunding());
				// 拨款时间
				valueMap.put("appropriationTime", t1.getAppropriationTime());
				// 备注
				valueMap.put("remark", t1.getRemark());
				// 项目申报表
				TprojectApplication t2 = (TprojectApplication) obj[2];
				// 项目名称
				valueMap.put("projectName", t2.getProjectName());
				// 承担单位
				valueMap.put("applicationUnit", t2.getApplicationUnit());
				list.add(valueMap);
			}
			p.setList(list);
		}

		return p;
	}

	/**
	 * @comments 查询条件
	 * @param param
	 * @return
	 * @Version 1.0
	 */
	private StringBuilder getConditionDate(Map<String, Object> param,String deptId,Boolean isPlanningDept) {
		StringBuilder hql = new StringBuilder();

		// 项目名称
		String projectName = (String) param.get("projectName");
		if (isNotNullOrEmpty(projectName)) {
			hql.append(" and t3.projectName like '%" + projectName + "%'");
		}
		// 承担单位
		String applicationUnit = (String) param.get("applicationUnit");
		if (isNotNullOrEmpty(applicationUnit)) {
			hql.append(" and t3.applicationUnit like '%" + applicationUnit
					+ "%'");
		}
		// 开户银行及行号
		String bank = (String) param.get("bank");
		if (isNotNullOrEmpty(bank)) {
			hql.append(" and t1.bank like '%" + bank + "%'");
		}
		// 账号
		String bankAccount = (String) param.get("bankAccount");
		if (isNotNullOrEmpty(bankAccount)) {
			hql.append(" and t1.account like '%" + bankAccount + "%'");
		}
		// 本次拨款金额Start
		String amountFundingStart = (String) param
				.get("amountFundingStart");
		if (isNotNullOrEmpty(amountFundingStart)) {
			hql.append(" and t1.amountFunding >= '"
					+ Double.valueOf(amountFundingStart)  + "'");
		}
		// 本次拨款金额End
		String amountFundingEnd = (String) param
				.get("amountFundingEnd");
		if (isNotNullOrEmpty(amountFundingEnd)) {
			hql.append(" and t1.amountFunding <= '"
					+ amountFundingEnd + "'");
		}
		// 计划拨款金额Start
		String planFundingStart = (String) param
				.get("planFundingStart");
		if (isNotNullOrEmpty(planFundingStart)) {
			hql.append(" and t1.planFunding >= '"
					+ planFundingStart + "'");
		}
		// 计划拨款金额End
		String planFundingEnd = (String) param
				.get("planFundingEnd");
		if (isNotNullOrEmpty(planFundingEnd)) {
			hql.append(" and t1.planFunding <= '"
					+ planFundingEnd + "'");
		}
		// 拨款时间Start
		String appropriationTimeStart = (String) param
				.get("appropriationTimeStart");
		if (isNotNullOrEmpty(appropriationTimeStart)) {
			appropriationTimeStart = appropriationTimeStart + " 00:00:00";
			hql.append(" and t1.appropriationTime >= TO_TIMESTAMP('"
						+ Timestamp.valueOf(appropriationTimeStart) +"','YYYY-MM-DD HH24:MI:SS:FF')");
		}
		// 拨款时间End
		String appropriationTimeEnd = (String) param
				.get("appropriationTimeEnd");
		if (isNotNullOrEmpty(appropriationTimeEnd)) {
			appropriationTimeEnd = appropriationTimeEnd + " 00:00:00";
			hql.append(" and t1.appropriationTime <= TO_TIMESTAMP('"
						+ Timestamp.valueOf(appropriationTimeEnd) +"','YYYY-MM-DD HH24:MI:SS:FF')");
		}
		
		//备注
		String remark = (String) param.get("remark");
		if (isNotNullOrEmpty(remark)) {
			hql.append(" and t1.remark like '%" + remark + "%'");
		}
		
		// 部门id
		String selectedDept = (String) param
				.get("selectedDeptId");
		if (isNotNullOrEmpty(selectedDept)) {
			hql.append(" and t4.departmentId = '"
					+ selectedDept + "'");
		}		
		// 项目分类1
		String typeId1 = (String) param
				.get("typeId1");
		if (isNotNullOrEmpty(typeId1)) {
			hql.append(" and t3.planFlag = '"
					+ typeId1 + "'");
		}
		
		// 项目分类2
		String typeId2 = (String) param
				.get("typeId2");
		if (isNotNullOrEmpty(typeId2)) {
			hql.append(" and t3.tprojectType.typeId = '"
					+ typeId2 + "'");
		}	
		
		String jhlb = (String) param
				.get("jhlb");
		if (isNotNullOrEmpty(jhlb)){
			hql.append(" and t3.tprojectType.typeId in ("
					+ jhlb + ")");
		}
		
		if (isPlanningDept == false){
			hql.append(" and t4.departmentId = '"
					+ deptId + "'");
		}
		return hql;
	}
	
	/**
	 * @comments 判断字符串是否为空
	 * @param obj
	 * @return
	 * @Version 1.0
	 */
	private Boolean isNotNullOrEmpty(Object obj) {

		if (!"".equals(obj) && obj != null) {
			return true;
		}
		return false;
	}
	
	/**
	 * @comments 取得导出数据
	 * @param param
	 * @return
	 * @Version 1.0
	 */
	public List<Object> getExportDatas(Map<String, Object> param,String deptId,Boolean isPlanningDept) {
		List<Object> list = new ArrayList<Object>();
		StringBuilder hql = new StringBuilder(
				" from TappropriationSingle t1, Tcontract t2, ");
		hql.append(" TprojectApplication t3, TprojectType t4 ");
		hql.append(" where t2.TContractId = t1.tcontract.TContractId ");
		hql.append(" and t2.tprojectApplication.projectId =  t3.projectId ");
		hql.append(" and t3.tprojectType.typeId = t4.typeId ");
		hql.append(getConditionDate(param,deptId,isPlanningDept));
		hql.append(" and t1.deleteFlag = '" + Constants.COMMON_STATE_NOTDELETE + "'");
		hql.append(" order by t1.appropriationTime asc ");
		list = fundsDao.queryListinfo(hql.toString());

		// 经济指标表(执行期经济指标表) T_ECONOMIC_INDICATOR t7
		// 经费概算表 T_APPROPRIATION_BUDGET t8
		// 用款计划表 T_MONEY_SCHEDULE t9

		return list;
	}
	
	/**
	 * @comments 取得表的属性
	 * @param tableName
	 * @return
	 * @Version 1.0
	 */
	public List<Object> getTableInfo(String[] tableName) {
		return fundsDao.queryInfoBySql(tableName);
	}
	
	
	/**
	 * 取得业务部门的部门下计划类别List
	 */
	@Override
	public List<String> getProjectTypeListByDeptId(Map<String, Object> params,String deptId) {
		
		List<String> jhlbList = new ArrayList<String>();
		List<Object> data = getExportDatas(params,deptId,true);
		if (data != null && data.size() != 0) {
			for (int i = 0; i < data.size(); i++) {
				Object[] obj = (Object[]) data.get(i);
				//申报表
				TprojectApplication t = (TprojectApplication) obj[2];
				if(!jhlbList.contains(t.getPlanFlag())){
					//把现有的计划类别（即项目分类第一层）列出来
					jhlbList.add(t.getPlanFlag());
				}
			}
		}
		return jhlbList;
	}
	
	/**
	 * 查询处室
	 */
	public List<String> getDeptList(Map<String, Object> params){
		List<String> List = new ArrayList<String>();
		List<Object> data = getExportDatas(params,"",true);
		if (data != null && data.size() != 0) {
			for (int i = 0; i < data.size(); i++) {
				Object[] obj = (Object[]) data.get(i);
				//申报表
				TprojectApplication t = (TprojectApplication) obj[2];
				TprojectType tprojectType = tprojectTypeDao.get(t.getTprojectType().getTypeId());
				if (tprojectType != null){
					if(!List.contains(tprojectType.getDepartmentId())){
						//把现有的部门出来
						List.add(tprojectType.getDepartmentId());
					}
				}
			}
		}
		return List;
	}
	
	/**
	 * 查询子分类
	 * @comments 
	 * @param params
	 * @return
	 * @version 1.0
	 */
	public List<String> getGroupInfo(Map<String, Object> params,String deptId){
		List<String> List = new ArrayList<String>();
		List<Object> data = getExportDatas(params,"",true);
		if (data != null && data.size() != 0) {
			for (int i = 0; i < data.size(); i++) {
				Object[] obj = (Object[]) data.get(i);
				//申报表
				TprojectApplication t = (TprojectApplication) obj[2];
				TprojectType tprojectType = tprojectTypeDao.get(t.getTprojectType().getTypeId());
				if (tprojectType != null){
					if (i == 0){
						List.add(tprojectType.getTypeId());
					}
					else{
						String flag = "";
						for (int j = 0; j < List.size(); j++){
							if (List.get(j).equals(tprojectType.getTypeId())){
								flag = "1";
							}
						}
						if (flag == ""){
							//把现有的子分类列出来
							List.add(tprojectType.getTypeId());
						}
					}
				}
			}
		}
		return List;
	}
	
	 /**
	  * 根据检索条件取得所有的查询结果
	  */
	 @Override
	 public Map<String, List<TappropriationSingle>> getAllResultData(Map<String,Object> param,String deptId,Boolean isPlanningDept) {
	  Map<String, List<TappropriationSingle>> allResultData = new HashMap<String,List<TappropriationSingle>>();
	  Map<String, Object> params = new HashMap<String, Object>();
	  params.putAll(param);
	  // 用户所在部门ID
	//  String userDeptId = params.get("userDeptId").toString();
	  // 是否为计财处用户
	//  Boolean isPlanningDept = Constants.PLANNING_DEPARTMENT.equals(deptId);
	  // 计财处用户登录时，以业务部门为单位进行统计
	  if(isPlanningDept){
	   // 判断参数中的"selectedDeptId",选择了部门的时候，
	   // 先查询该部门下的计划类别，以计划类别为单位导出
	   if (params.containsKey("selectedDeptId")
	     && null != params.get("selectedDeptId").toString()
	     && !"".equals(params.get("selectedDeptId").toString())){
	    // ========2013/09/26 start=========
	    List<TprojectType> projectTypeList = tprojectTypeDao
	      .getFatherProjectTypeListByDeptId(params.get(
	        "selectedDeptId").toString());
	    if (projectTypeList != null && projectTypeList.size() > 0) {
	     for (TprojectType tprojectType : projectTypeList) {
	      params.put("typeId1",
	        tprojectType.getTypeId());
	      List<TappropriationSingle> list = this.getAllResultDataList(params,deptId,isPlanningDept);
	      allResultData.put(tprojectType.getTypeId(), list);
	     }
	    }
	    
	    // ========2013/09/26 end=========
	    //List<VprojectResultCollect> list = vprojectResultCollectDao.getAllResultData(params);
	    //allResultData.put(params.get("selectedDeptId").toString(), list);
	   }
	   // 没有选择部门的时候，先取得所有的部门，再根据部门分别取得各个部门下的项目
	   else {
	    List<String> deptList = this.getDeptList(params);
	    for (int i = 0; i < deptList.size(); i++) {
		     List<TappropriationSingle> list = new ArrayList<TappropriationSingle>();
		     params.put("selectedDeptId", deptList.get(i).toString());
		     list = this.getAllResultDataList(params,deptId,isPlanningDept);
		     // 一览数据
		     allResultData.put(deptList.get(i).toString(), list);
	    }
	   }
	  }
	  // 业务部门的用户登录时，以子分类为单位进行统计
	  else{
	   // 取得二级分类
	   String typeId2 = null;
	   if(params.containsKey("typeId2") && null != params.get("typeId2")){
	    typeId2 = params.get("typeId2").toString();
	   }
	   
	   // 项目分类第二级没有选择的时候，先查询出第一级包含的二级分类，
	   // 然后遍历二级分类，查询每个二级分类下的项目
	   if(!isNotNullOrEmpty(typeId2)){
	    List<String>  groupInfo = this.getGroupInfo(params,deptId);
	    
	    for (int i = 0; i < groupInfo.size(); i++) {
	     List<TappropriationSingle> list = new ArrayList<TappropriationSingle>();
	     params.put("typeId2", groupInfo.get(i).toString());
	     list = this.getAllResultDataList(params,deptId,isPlanningDept);
	     // 一览数据
	     allResultData.put(groupInfo.get(i).toString(), list);
	    }
	   }
	   // 项目分类第二级已经选择的时候，直接查询该二级分类下的项目
	   // 然后遍历二级分类，查询每个二级分类下的项目
	   else{
	    List<TappropriationSingle> list = this.getAllResultDataList(params,deptId,isPlanningDept);
	    allResultData.put(params.get("typeId2").toString(), list);
	   }
	  }

	  return allResultData;
	 }
	 
	 public List<TappropriationSingle> getAllResultDataList(Map<String,Object> param,String deptId,Boolean isPlanningDept){
		 List<Object> list = getExportDatas(param,deptId,isPlanningDept);
		 List<TappropriationSingle> list1 = new ArrayList<TappropriationSingle>();
		 if (list != null && list.size() > 0){
			 for (int i = 0;i< list.size();i++){
				 Object[] obj = (Object[]) list.get(i);
				// 拨款单
				TappropriationSingle t1 = (TappropriationSingle) obj[0];
				// 项目申报
				TprojectApplication t2 = (TprojectApplication) obj[2];	
				t1.setTasksEntrusted(t2.getProjectName());
				t1.setUndertaker(t2.getApplicationUnit());
				t1.setProjectNumber(t2.getProjectNumber());
				t1.setTypeId1(t2.getPlanFlag());
				list1.add(t1);
			 }
		 }
		 return list1;
	 }
	 
}
