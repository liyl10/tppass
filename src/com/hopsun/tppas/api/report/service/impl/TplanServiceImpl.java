package com.hopsun.tppas.api.report.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.hopsun.framework.base.bean.Pager;
import com.hopsun.framework.base.service.impl.BaseServiceImpl;
import com.hopsun.tppas.api.report.dao.TplanDao;
import com.hopsun.tppas.api.report.dao.TprojectApplicationDao;
import com.hopsun.tppas.api.report.dao.TprojectInfoADao;
import com.hopsun.tppas.api.report.dao.TprojectInfoBDao;
import com.hopsun.tppas.api.report.service.TplanService;
import com.hopsun.tppas.api.superadmin.dao.MitemDao;
import com.hopsun.tppas.api.superadmin.dao.TprojectTypeDao;
import com.hopsun.tppas.common.Constants;
import com.hopsun.tppas.entity.Tplan;
import com.hopsun.tppas.entity.TprojectApplication;
import com.hopsun.tppas.entity.TprojectInfoA;
import com.hopsun.tppas.entity.TprojectInfoB;
import com.hopsun.tppas.entity.TprojectType;
/**
 * @Comments: 后台Service实现类-主要用来实现分计划操作的接口
 * @author  yk
 * @date 2013-08-01
 * @version 1.0
 *
 */
@Service
public class TplanServiceImpl extends BaseServiceImpl<Tplan,String> implements TplanService{
	
	@Resource
	private TplanDao tplanDao;
	@Resource
	private MitemDao mitemDao;
	@Resource
	private TprojectApplicationDao tprojectApplicationDao;
	@Resource
	private TprojectInfoADao tprojectInfoADao;
	@Resource
	private TprojectInfoBDao tprojectInfoBDao;
	@Resource
	private TprojectTypeDao tprojectTypeDao;
	@Resource
	public void setBaseDao(TplanDao tplanDao) {
		super.setBaseDao(tplanDao);
	}

	@Override
	public List<Tplan> queryTPlanByPlanState(String planState) {
		
		return tplanDao.queryTPlanByPlanState(planState);
	}	
	/**
	 * @comments 取得分计划数据    
	 * @param param
	 * @param pageNo
	 * @param pageSize
	 * @return
	 * @Version 1.0
	 */

	@Override
	public Pager getPlanList(Map<String, Object> param, int pageNo, int pageSize) {
		Pager p = tplanDao.getPlanList(param, pageNo, pageSize);
		if(p.getList() !=null && p.getList().size() > 0){
			List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
			for (int i = 0; i < p.getList().size(); i++) {
				Tplan t1 = (Tplan) p.getList().get(i);
				// 列表信息Map
				Map<String, Object> valueMap = new HashMap<String, Object>();
				
				// 分计划ID	
				valueMap.put("planId", t1.getPlanId().trim());
				// 分计划名称
				valueMap.put("planName", t1.getPlanName());
				// 年度
				/*String planYear = new SimpleDateFormat("yyyyMMdd")
						.format(t1.getPlanYear());
				valueMap.put("planYear", planYear.substring(0, 4));*/
				valueMap.put("planYear", t1.getPlanYear());	
				// 申报状态   
				String planState ="";
				if (!isNullString(t1.getPlanState())){
					planState = mitemDao.getItemName(t1.getPlanState());
				}
				valueMap.put("planState", planState);
				// 项目类别    
				// 取得项目申报的信息
				/*List<TprojectApplication> projectList = tprojectApplicationDao.getList("tplan.planId", t1.getPlanId().trim());
				if(projectList != null && projectList.size() > 0){
					for (int a = 0; a < projectList.size(); a++) {
						TprojectApplication t2 = projectList.get(a);
						valueMap.put("projectTypeName", t2.getPlanFlagName() + Constants.STRING_LINK + t2.getTypeName());
					}
				}*/
				
				// 批次
				String planBatch ="";
				if (!isNullString(t1.getPlanBatch())){
					planBatch = mitemDao.getItemName(t1.getPlanBatch());
				}
				valueMap.put("planBatch", planBatch);
				
				list.add(valueMap);
			}
			
			// 设定list集合
			p.setList(list);
		}
		
		return p;
	
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
	/***
	 * 
	 * @comments 查看分计划 
	 * @param planId
	 * @param pageNo
	 * @param pageSize
	 * @return
	 * @version 1.0
	 */
	@Override
	public Pager find(String planId, int pageNo, int pageSize) {
		Pager pager = tprojectApplicationDao.find(planId, pageNo, pageSize);
		if(pager !=null && pager.getList() !=null && pager.getList().size() >0){
			for(int i=0; i< pager.getList().size(); i++){
				TprojectApplication tprojectApplication = (TprojectApplication)pager.getList().get(i);
			    	
				if(tprojectApplication!=null){
					// 项目名称 
					tprojectApplication.setProjectName(tprojectApplication.getProjectName());
		    		// 申报单位  
					tprojectApplication.setApplicationUnit(tprojectApplication.getApplicationUnit());
		    		// 项目分类
					tprojectApplication.setTprojectTypeName(tprojectApplication.getPlanFlagName() + 
							Constants.STRING_LINK + tprojectApplication.getTypeName());
		    		// 项目状态
					tprojectApplication.setApplyStatusString(mitemDao.getItemName(tprojectApplication.getApplyStatus()));
		    		// 取得项目基本信息
		    		TprojectInfoA tprojectInfoA = tprojectInfoADao.get("tprojectApplication.projectId",tprojectApplication.getProjectId());
		    		TprojectInfoB tprojectInfoB = tprojectInfoBDao.get("tprojectApplication.projectId",tprojectApplication.getProjectId());
		    		if(tprojectInfoA != null){
		    			// 单位性质
		    			tprojectApplication.setUnitProperties(mitemDao.getItemName(tprojectInfoA.getUnitProperties()));
		    		}else if(tprojectInfoB != null){
		    			// 单位性质
		    			tprojectApplication.setUnitProperties(mitemDao.getItemName(tprojectInfoB.getUnitProperties()));
		    			
		    		}
		    		// 项目分类id
		    		tprojectApplication.setTypeId(tprojectApplication.getTprojectType().getTypeId());
				}
			}
		}
	
		return pager;
	}

	/**
	 * 取得分计划数据    
	 */
	@Override
	public List<Tplan> getPlanList(Map<String, Object> param) {
		// 业务部门
	    String selectedDeptId = (String) param.get("selectedDeptId");
	    if (!isNullString(selectedDeptId)) {
	    	// 计划类别
		    String projectType1 = (String) param.get("projectType1");
		    if (isNullString(projectType1)) {
		    	// 取得该业务部门下所有的分计划
		    	StringBuffer planFlagQueryStr = new StringBuffer();
		    	List<TprojectType> projectTypeList = tprojectTypeDao.getFatherProjectTypeListByDeptId(selectedDeptId);
		    	if(projectTypeList!=null && projectTypeList.size()>0){
		    		for (TprojectType tprojectType : projectTypeList) {
		    			planFlagQueryStr.append("'");
			    		planFlagQueryStr.append(tprojectType.getTypeId());
			    		planFlagQueryStr.append("',");
					}
		    		param.put("typeInStr", planFlagQueryStr.toString().substring(0, planFlagQueryStr.toString().length()-1));
		    	}
		    }
	    }

		List<Tplan> planList = tplanDao.getPlanList(param);

		if(planList !=null && planList.size() > 0){
			for (int i = 0; i < planList.size(); i++) {
				Tplan t1 = (Tplan) planList.get(i);
				// 分计划状态
				String planState ="";
				if (!isNullString(t1.getPlanState())){
					planState = mitemDao.getItemName(t1.getPlanState());
				}
				t1.setPlanState(planState);
				// 项目类别    
				t1.setProjectTypeName(t1.getPlanFlagName() + "-" + t1.getTypeName());
				// 批次
				String planBatch ="";
				if (!isNullString(t1.getPlanBatch())){
					planBatch = mitemDao.getItemName(t1.getPlanBatch());
				}
				t1.setPlanBatch(planBatch);
			}
		}
		return planList;
	}

	/**
	 * 取得该汇总计划下存在的不重复的计划类别
	 */
	@Override
	public List<String> getGroupInfo(String planCollectId) {
		List<String> groupInfoList = new ArrayList<String>();
		groupInfoList = tplanDao.getGroupInfoList(planCollectId);
		return groupInfoList;
	}

	/**
	 * 根据计划类别取得详细的分计划信息
	 */
	@Override
	public List<Tplan> getListByGroupInfo(String planCollectId, List<String> groupInfo) {
		// 最后作成的分计划一览
		List<Tplan> outPlanList = new ArrayList<Tplan>();
		// 循环计划类别，先取得该计划类别下分计划的合计信息，将这个合计信息追加到outPlanList中
		// 然后将该计划类别下的分计划追加到outPlanList中
		List<Tplan> allPlanList = tplanDao.getList("tplanCollect.planCollectId", planCollectId);
		// 总合计
		//项目数合计
		int totalProjectCount = 0;
		//科研资金合计
		double totalResearchFunds = 0;
		//总投入合计
		double totalInputTotal = 0;
		//项目预计产值合计
		double totalProjectExpectOutput = 0;
		//项目预计利税合计
		double totalProjectExpectProfitTax = 0;
		//企业预计产值合计
		double totalCompanyExpectOutput = 0;
		//企业预计利税合计
		double totalCompanyExpectProfitTax = 0;
		
		int planIndex = 1;
		if(groupInfo != null && groupInfo.size()>0){
			
		
		for (int i = 0; i < groupInfo.size(); i++) {
			Tplan projectTypePlan = new Tplan();
			//项目数合计
			int projectCount = 0;
			//科研资金合计
			double researchFunds = 0;
			//总投入合计
			double inputTotal = 0;
			//项目预计产值合计
			double projectExpectOutput = 0;
			//项目预计利税合计
			double projectExpectProfitTax = 0;
			//企业预计产值合计
			double companyExpectOutput = 0;
			//企业预计利税合计
			double companyExpectProfitTax = 0;
			
			// 计划类别ID
			projectTypePlan.setPlanFlag(groupInfo.get(i));
			// 一个计划类别对应一个该list，该list里包括该计划类别下的分计划
			List<Tplan> typePlanList = new ArrayList<Tplan>();
				for(int j=0;j<allPlanList.size();j++){
					
					if(groupInfo.get(i).equals(allPlanList.get(j).getPlanFlag())){
						// 设置分计划对应行的数据
						if (typePlanList.size()==0) {
							// 序列
							projectTypePlan.setIndex(toHanStr(String.valueOf(i+1)));
							// 分计划id
							projectTypePlan.setPlanId("");
							// 汇总分计划ID
							projectTypePlan.setTplanCollect(allPlanList.get(j).getTplanCollect());
							// 分计划名称
							projectTypePlan.setPlanName(allPlanList.get(j).getPlanFlagName());
							// 计划类别ID
							projectTypePlan.setPlanFlag(allPlanList.get(j).getPlanFlag());
						}
						// 设置每个分计划的序列
						Tplan tempTplan = allPlanList.get(j);
						tempTplan.setIndex(String.valueOf(planIndex));
						planIndex = planIndex + 1;
						// 将设置过序列的分计划添加到
						typePlanList.add(tempTplan);
						// 项目数
						projectCount = projectCount + allPlanList.get(j).getProjectCount();
						// 科研资金合计
						researchFunds = researchFunds + allPlanList.get(j).getResearchFunds();
						// 总投入合计
						inputTotal = inputTotal + allPlanList.get(j).getInputTotal();
						// 项目预计产值合计
						projectExpectOutput = projectExpectOutput + allPlanList.get(j).getProjectExpectOutput();
						// 项目预计利税合计
						projectExpectProfitTax = projectExpectProfitTax + allPlanList.get(j).getProjectExpectProfitTax();
						// 企业预计产值合计
						companyExpectOutput = companyExpectOutput + allPlanList.get(j).getCompanyExpectOutput();
						// 企业预计利税合计
						companyExpectProfitTax = companyExpectProfitTax + allPlanList.get(j).getCompanyExpectProfitTax();
					}
				}
				// 项目数
				projectTypePlan.setProjectCount(projectCount);
				// 科研资金合计
				projectTypePlan.setResearchFunds(researchFunds);
				// 总投入合计
				projectTypePlan.setInputTotal(inputTotal);
				// 项目预计产值合计
				projectTypePlan.setProjectExpectOutput(projectExpectOutput);
				// 项目预计利税合计
				projectTypePlan.setProjectExpectProfitTax(projectExpectProfitTax);
				// 企业预计产值合计
				projectTypePlan.setCompanyExpectOutput(companyExpectOutput);
				// 企业预计利税合计
				projectTypePlan.setCompanyExpectProfitTax(companyExpectProfitTax);
				
				// 总合计计算
				//项目数合计
				totalProjectCount = totalProjectCount + projectCount;
				//科研资金合计
				totalResearchFunds = totalResearchFunds + researchFunds;
				//总投入合计
				totalInputTotal = totalInputTotal + inputTotal;
				//项目预计产值合计
				totalProjectExpectOutput = totalProjectExpectOutput + projectExpectOutput;
				//项目预计利税合计
				totalProjectExpectProfitTax = totalProjectExpectProfitTax + projectExpectProfitTax;
				//企业预计产值合计
				totalCompanyExpectOutput = totalCompanyExpectOutput + companyExpectOutput;
				//企业预计利税合计
				totalCompanyExpectProfitTax = totalCompanyExpectProfitTax + companyExpectProfitTax;
				
				// 计划类别合计行
				outPlanList.add(projectTypePlan);
				// 计划
				outPlanList.addAll(typePlanList);
			}
		}
		if(groupInfo != null && groupInfo.size()>0){
			Tplan totalPlan = new Tplan();
			totalPlan.setPlanId("");
			totalPlan.setIndex("");
			totalPlan.setPlanName("合计");
			totalPlan.setProjectCount(totalProjectCount);
			// 科研资金合计
			totalPlan.setResearchFunds(totalResearchFunds);
			// 总投入合计
			totalPlan.setInputTotal(totalInputTotal);
			// 项目预计产值合计
			totalPlan.setProjectExpectOutput(totalProjectExpectOutput);
			// 项目预计利税合计
			totalPlan.setProjectExpectProfitTax(totalProjectExpectProfitTax);
			// 企业预计产值合计
			totalPlan.setCompanyExpectOutput(totalCompanyExpectOutput);
			// 企业预计利税合计
			totalPlan.setCompanyExpectProfitTax(totalCompanyExpectProfitTax);
			// 追加总合计行
			outPlanList.add(totalPlan);
		}
		
		return outPlanList;
	}
	
	/**
	 * 
	 * @comments 将数字转换成汉字 
	 * @param numStr
	 * @return
	 * @version 1.0
	 */
	private String toHanStr(String numStr)
	{
		String[] hanArr = { "零", "一", "二", "三", "四", "五", "六", "七", "八", "九" };
		String[] unitArr = { "十", "百", "千", "万", "十", "百", "千", "亿", "十", "百", "千" };
		
		String result = "";
		int numLen = numStr.length();
		for (int i = 0; i < numLen; i++)
		{
			int num = numStr.charAt(i) - 48;
			if (i != numLen - 1 && num != 0)
			{
				result += hanArr[num] + unitArr[numLen - 2 - i];
			}
			else
			{
				result += hanArr[num];
			}
		}
		if(result.endsWith("零")){
			result = result.substring(0, result.length()-1);
		}
		return result;
	}

	/**
	 * 将该分计划从汇总分计划中删除
	 */
	@Override
	public void deletePlanFromCollect(Map<String, Object> param) {
		Tplan t = tplanDao.get((String) param.get("planId"));
		if(t != null){
			// 将汇总分计划id设为空
			t.setTplanCollect(null);
			// 更新时间
			t.setUpdateDate((new java.sql.Timestamp(new java.util.Date().getTime())));
			// 更新者
			t.setUpdateUser(param.get("updateUser").toString());
			tplanDao.update(t);
		}
		
	}

	/**
	 * 根据计划类别删除分计划，删除该汇总计划中所有属于该计划类别的分计划
	 */
	@Override
	public void deletePlanFromCollectByType(Map<String, Object> param) {

		List<Tplan> planList = tplanDao.getPlanListByPlanType(param);
		
		if(planList != null && planList.size()>0){
			String userName = param.get("updateUser").toString();
			for (Tplan tplan : planList) {
				tplan.setTplanCollect(null);
				tplan.setUpdateUser(userName);
				tplan.setUpdateDate((new java.sql.Timestamp(new java.util.Date().getTime())));
				tplanDao.update(tplan);
			}
		}
	}
}
