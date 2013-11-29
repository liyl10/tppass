package com.hopsun.tppas.api.report.service.impl;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.hopsun.framework.base.bean.Pager;
import com.hopsun.framework.base.service.impl.BaseServiceImpl;
import com.hopsun.tppas.api.contract.dao.TcontractContentsADao;
import com.hopsun.tppas.api.contract.dao.TcontractContentsBDao;
import com.hopsun.tppas.api.contract.dao.TcontractCoverADao;
import com.hopsun.tppas.api.contract.dao.TcontractDao;
import com.hopsun.tppas.api.contract.dao.TeconomicIndicatorsBDao;
import com.hopsun.tppas.api.contract.dao.TfundUseADao;
import com.hopsun.tppas.api.contract.dao.TfundingPlanBDao;
import com.hopsun.tppas.api.contract.dao.TfundsPlanADao;
import com.hopsun.tppas.api.contract.dao.TprojectLeaderBDao;
import com.hopsun.tppas.api.report.dao.TprojectApplicationDao;
import com.hopsun.tppas.api.report.dao.TprojectInfoADao;
import com.hopsun.tppas.api.report.dao.TprojectInfoBDao;
import com.hopsun.tppas.api.report.dao.TresearcherDao;
import com.hopsun.tppas.api.report.service.TprojectApplicationService;
import com.hopsun.tppas.api.superadmin.dao.MitemDao;
import com.hopsun.tppas.api.superadmin.dao.TexpertReviewCommentsDao;
import com.hopsun.tppas.api.superadmin.dao.TprojectTypeDao;
import com.hopsun.tppas.common.Constants;
import com.hopsun.tppas.entity.Tcontract;
import com.hopsun.tppas.entity.TcontractContentsA;
import com.hopsun.tppas.entity.TcontractContentsB;
import com.hopsun.tppas.entity.TcontractCoverA;
import com.hopsun.tppas.entity.TeconomicIndicatorA;
import com.hopsun.tppas.entity.TeconomicIndicatorB;
import com.hopsun.tppas.entity.TeconomicIndicatorsB;
import com.hopsun.tppas.entity.TexpertReviewComments;
import com.hopsun.tppas.entity.TfinancingUse;
import com.hopsun.tppas.entity.TfundPlanB;
import com.hopsun.tppas.entity.TfundUseA;
import com.hopsun.tppas.entity.TfundingPlanB;
import com.hopsun.tppas.entity.TfundingPlanReport;
import com.hopsun.tppas.entity.TfundsPlanA;
import com.hopsun.tppas.entity.TmoneyScheduleA;
import com.hopsun.tppas.entity.TmoneyScheduleB;
import com.hopsun.tppas.entity.TprojectApplication;
import com.hopsun.tppas.entity.TprojectInfoA;
import com.hopsun.tppas.entity.TprojectInfoB;
import com.hopsun.tppas.entity.TprojectLeaderB;
import com.hopsun.tppas.entity.TprojectType;
import com.hopsun.tppas.entity.TreportObjectives;
import com.hopsun.tppas.entity.Tresearcher;
import com.hopsun.tppas.view.VprojectInfo;
import com.hopsun.tppas.view.VprojectInfoAll;
/**
 * @Comments:   后台Service接口-主要用来实现项目申报操作的接口
 * @author  yk
 * @date 2013-08-01
 * @version 1.0
 *
 */
@Service
public class TprojectApplicationServiceImpl extends BaseServiceImpl<TprojectApplication,String> implements TprojectApplicationService{
	
	@Resource
	private TprojectApplicationDao tprojectApplicationDao;
	
	@Resource
	private TprojectTypeDao tprojectTypeDao;
	@Resource
	private TprojectInfoADao tprojectInfoADao;
	@Resource
	private TprojectInfoBDao tprojectInfoBDao;
	@Resource
	private TcontractDao tcontractDao;
	@Resource
	private TcontractCoverADao tcontractCoverADao;
	@Resource
	private TcontractContentsBDao tcontractContentsBDao;
	@Resource
	private TcontractContentsADao tcontractContentsADao;
	@Resource
	private TfundingPlanBDao tfundingPlanBDao;
	@Resource
	private TfundUseADao tfundUseADao;
	@Resource
	private TresearcherDao tresearcherDao;
	@Resource
	private TprojectLeaderBDao tprojectLeaderBDao;
	@Resource
	private TeconomicIndicatorsBDao teconomicIndicatorsBDao;
	@Resource
	private TexpertReviewCommentsDao texpertReviewCommentsDao;
	@Resource
	private TfundsPlanADao tfundsPlanADao;
	//码表
	@Resource 
	private MitemDao mitemDao;
	
	@Resource
	public void setBaseDao(TprojectApplicationDao tprojectApplicationDao) {
		super.setBaseDao(tprojectApplicationDao);
	}
	/**
	 * 查询待调配项目
	 * @param flowStatus
	 * @return
	 */
	public List<TprojectApplication>  queryProjectApplicationByApplyState(String applyState){
		return tprojectApplicationDao.queryProjectApplicationByApplyState(applyState);
	}
	
	/**
	 * 查询待归档项目
	 * @param flowStatus
	 * @return
	 */
	public List<TprojectApplication>  queryProjectApplicationByFlowState(String[] flowStatus){
		return tprojectApplicationDao.queryProjectApplicationByFlowState(flowStatus);
	}
	
	/**
	 * 查询初审项目
	 */
	@Override
	public Pager getBeforeReviewProject(Map<String, Object> param, int pageNo,
			int pageSize) {
		
		/*// 根据用户不同，取得不同的数据
	    String userDeptId = param.get("deptId").toString();
	    
	    // 判断用户是否为计划处用户，如果为计划处用户，则能取得所有业务部门的数据
	    // 如果为业务部用户，只能取得该业务部自己的数据
		if(!Constants.PLANNING_DEPARTMENT.equals(userDeptId)){
			// 取得该部门对应的计划类别id
			List<TprojectType> projectTypeList = tprojectTypeDao.getList(
					"departmentId", userDeptId);

			// 组成一个作为in查询的字符串【('111','222','333')】
			StringBuffer inStrb = new StringBuffer();
			for (TprojectType tprojectType : projectTypeList) {
				inStrb.append("'");
				inStrb.append(tprojectType.getTypeId());
				inStrb.append("'");
				inStrb.append(",");
			}
			
			String inStr = inStrb.toString();
			if (inStr != null && inStr.length() > 0) {
				inStr = inStr.substring(0, inStr.length() - 1);
				param.put("typeIdStr", inStr);
			}
		}*/

		return tprojectApplicationDao.queryBeforeReviewProject(param, pageNo, pageSize);
	}
	
	/**
	 * @comments 项目查询
	 * @param param
	 * @param pageNo
	 * @param pageSize
	 * @return
	 * @Version 1.0
	 */
	public Pager queryTprojectApplication(Map<String, Object> param, int pageNo, int pageSize){
		return tprojectApplicationDao.queryTprojectApplication(param, pageNo, pageSize);
	}
	
	/**
	 * 更新申报状态
	 */
	@Override
	public void updateApplyState(Map<String, Object> param) {
		String projectId = (String) param.get("projectId");
		TprojectApplication t = tprojectApplicationDao.get((String) param.get("projectId"));
		if(t != null){
			if(param.containsKey("applyStatus")){
				// 申报状态
				t.setApplyStatus(param.get("applyStatus").toString());
			}
			// 初审意见
			if(param.containsKey("beforeReviewComment")){
				t.setInitialAuditOpinion(param.get("beforeReviewComment").toString());
			}
			// 更新时间
			t.setUpdateTime(new java.sql.Timestamp(new java.util.Date().getTime()));
			// 更新者
			t.setUpdateUser(param.get("updateUser").toString());
			tprojectApplicationDao.update(t);
		}
		
		String status = "";
		if(param.containsKey("applyStatus")){
			status = param.get("applyStatus").toString();
		}
		if (Constants.PROJECT_REPORT_BEFOREREVIEW_PASS.equals(status)){
		   updateTcontract(projectId);
		}
	}
	
	/**
	 * 批量初审
	 */
	@Override
	public void updateApplyStateByList(Map<String, Object> param) {
		// 取得批量审批的项目ID
		String[] projectList = param.get("projectIdList").toString().split(",");
		
		TprojectApplication t = null;
		if(projectList != null && projectList.length > 0){
			// 循环处理项目
			for (String projectId : projectList) {
				t =  tprojectApplicationDao.get(projectId);
				if(t != null){
					// 申报状态
					t.setApplyStatus(param.get("applyStatus").toString());
					// 更新时间
					t.setUpdateTime(new java.sql.Timestamp(new java.util.Date().getTime()));
					// 更新者
					t.setUpdateUser(param.get("updateUser").toString());
					// 初审意见
					if(param.containsKey("beforeReviewComment")){
						t.setInitialAuditOpinion(param.get("beforeReviewComment").toString());
					}
					tprojectApplicationDao.update(t);
				}
			}
		}
	}
	
	/** 
	 * 
	 * @comments 获得封皮备注
	 * @return
	 * @version 1.0
	 */
	public TprojectApplication getprojectReport() {
		TprojectApplication projectApplication = new TprojectApplication();
		projectApplication.setProjectReportText(mitemDao.get(Constants.PROJECT_REPORT_TEXT).getItemDesc());
		projectApplication.setProjectReportTime(mitemDao.get(Constants.PROJECT_REPORT_TIME).getItemDesc());
		return projectApplication;
	}
	
	/**
	 * @comments 取得项目起止时间年度列表
	 * @param projectId
	 * @return
	 * @Version 1.0
	 */
	public List<Map<String,Object>> getStart2EndYear(String projectId){
		
		// 年度列表
		List<Map<String,Object>> yearList = new ArrayList<Map<String, Object>>();
		
		// 取得项目信息
		TprojectApplication tpTemp = tprojectApplicationDao.get(projectId);
		
		if(tpTemp !=null){
			
			// 开始时间
			int startTime = Integer.parseInt(tpTemp.getStartTime().toString().substring(0, 4));
			
			// 结束时间
			int endTime = Integer.parseInt(tpTemp.getEndTime().toString().substring(0, 4));
			
			// 封装年度列表
			for(int i=0; i< endTime - startTime + 1; i++){
				Map<String,Object> yearMap = new HashMap<String, Object>();
				int startTempTime= startTime + i;
				yearMap.put("year", startTempTime);
				yearList.add(yearMap);
				
			}
		}
		
		return yearList;
	}
	/**
	 * 根据项目id取得项目详细信息
	 */
	@Override
	public VprojectInfoAll getProjectInfoAll(String projectId) {
		return tprojectApplicationDao.queryProjectInfoAll(projectId);
	}
	
	/**
	 * 取得待调配项目List
	 */
	@Override
	public Pager getDeployProjectList(Map<String, Object> param,
			Integer pageNumber, Integer pageSize) {
		
		return tprojectApplicationDao.queryDeployProjectList(param,pageNumber,pageSize);
	}
	
	/**
	 * 项目调配更新处理
	 */
	@Override
	public void updateDeployProject(Map<String, Object> param) {
		String jumpFlag = param.get("jumpFlag").toString();
		TprojectApplication t = tprojectApplicationDao.get((String) param.get("projectId"));
		// 跨模板调配的情况
		if(null != jumpFlag && "true".equals(jumpFlag)){
			tprojectApplicationDao.delete(t);
			return;
		}
		// 非跨模板调配的情况
		if(t != null){
			// 调配意见
			if(param.containsKey("deployComment")){
				t.setDeployOpinion(param.get("deployComment").toString());
			}
			// 项目分类ID（一级）
			t.setPlanFlag(param.get("selectedProjectTypeFirst").toString());
			// 项目分类名称（一级）
			t.setTypeName(param.get("typeName").toString());
			// 项目分类ID（二级）
			t.setTprojectType(tprojectTypeDao.get(param.get("selectedProjectTypeSecond").toString()));
			//param.put("selectedProjectTypeSecond", selectedProjectTypeSecond);
			// 项目分类名称（二级）
			t.setPlanFlagName(param.get("planFlagName").toString());
			// 项目状态
			t.setApplyStatus(param.get("applyStatus").toString());
			// 更新时间
			t.setUpdateTime(new java.sql.Timestamp(new java.util.Date().getTime()));
			// 更新者
			t.setUpdateUser(param.get("updateUser").toString());
			tprojectApplicationDao.update(t);
		}
		
	}
	// weina start
	/**
	 * 
	 * @comments 归档管理 
	 * @param param
	 * @param pageNo
	 * @param pageSize
	 * @return
	 * @version 1.0
	 */
	@Override
	public Pager getArchivalList(Map<String, Object> param, int pageNo,
			int pageSize) {
		Pager p = tprojectApplicationDao.getArchivalList(param, pageNo, pageSize);
		if(p.getList() !=null && p.getList().size() > 0){
			List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
			for (int i = 0; i < p.getList().size(); i++) {
				Object[] obj = (Object[]) p.getList().get(i);
				// 列表信息Map
				Map<String, Object> valueMap = new HashMap<String, Object>();
				// 项目申报表
				TprojectApplication t1 = (TprojectApplication) obj[0];

				//TprojectApplication t1 = (TprojectApplication) p.getList().get(i);
				// 项目分类id
				valueMap.put("typeId", t1.getTprojectType().getTypeId());
				// 项目ID	
				valueMap.put("projectId", t1.getProjectId().trim());
				
				// 项目编号
				valueMap.put("projectNumber", t1.getProjectNumber());
				
				// 项目名称
				valueMap.put("projectName", t1.getProjectName());
				
				// 申报单位
				valueMap.put("applicationUnit", t1.getApplicationUnit());
				
				// 项目分类    
				valueMap.put("tprojectTypeName", t1.getPlanFlagName() + Constants.STRING_LINK + t1.getTypeName());
				// 项目信息表
				VprojectInfo v1 = (VprojectInfo) obj[1];
				// 技术领域
				String technicalFisld ="";
				if (!isNullString(v1.getTechnicalFisld())){
					technicalFisld = mitemDao.getItemName(v1.getTechnicalFisld());
				}
				valueMap.put("technicalFisld", technicalFisld);
				
				// 申报日期
				if(t1.getStartTime() != null){
					/*String startTime = new SimpleDateFormat("yyyyMMdd")
					.format(t1.getStartTime());*/
					valueMap.put("startTime", t1.getStartTime());
				}
				// 归档日期
				if(t1.getArchivalTime() != null){
					/*String archivalTime = new SimpleDateFormat("yyyyMMdd")
					.format((t1.getArchivalTime()));*/
					valueMap.put("archivalTime", t1.getArchivalTime());
				}
				
				// 归档状态
				if ("已归档".equals(t1.getIsArchival())){
					valueMap.put("isArchival", "已归档");
				}else{
					valueMap.put("isArchival", "未归档");
				}
				
				// 项目状态
				String applyStatus ="";
				if (!isNullString(t1.getApplyStatus())){
					applyStatus = mitemDao.getItemName(t1.getApplyStatus());
				}
				valueMap.put("applyStatus", applyStatus);
				
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
	/**
	 * 
	 * @comments 批量归档 
	 * @param param
	 * @version 1.0
	 */
	@Override
	public void updatearchivalStateByList(Map<String, Object> param) {

		// 取得批量归档的项目ID
		String[] projectList = param.get("projectIdList").toString().split(",");
		
		TprojectApplication t = null;
		if(projectList != null && projectList.length > 0){
			// 循环处理项目
			for (String projectId : projectList) {
				t =  tprojectApplicationDao.get(projectId);
				if(t != null){
					// 归档状态
					t.setIsArchival(param.get("isArchival").toString());
					t.setArchivalTime(new java.sql.Timestamp(new java.util.Date().getTime()));
					// 更新时间
					t.setUpdateTime(new java.sql.Timestamp(new java.util.Date().getTime()));
					// 更新者
					t.setUpdateUser(param.get("updateUser").toString());
					tprojectApplicationDao.update(t);
				}
			}
		}
	
		
	}
	/**
	 * 
	 * @comments 项目评审通过率统计
	 * @param param
	 * @param pageNo
	 * @param pageSize
	 * @return
	 * @version 1.0
	 */
	@Override
	public List<TprojectApplication> getProjectViewList(Map<String, Object> param) {
		List list = tprojectApplicationDao.getProjectViewList(param);
		List<TprojectApplication> pagerList = new ArrayList<TprojectApplication>();
		if(list!=null && list.size()>0){
			//List<String> ps = pager.getList();
			for(int i=0;i<list.size();i++){
				String year = (String) list.get(i);
				if(year!=null){
					TprojectApplication tp = new TprojectApplication();
					
					// 年度
					tp.setReportYear(year);
					// 项目总数
					int projectTotal = tprojectApplicationDao.getProjectTotalCount(year);
					tp.setProjectTotal(String.valueOf(projectTotal));
					// 未初审项目数
					int noViewProjectTotal = tprojectApplicationDao.getNoViewProjectTotalCount(year);
					tp.setNoViewProjectTotal(String.valueOf(noViewProjectTotal));
					
					// 未通过项目数
					int noPassProject = tprojectApplicationDao.getNoPassProjectCount(year);
					tp.setNoPassProject(String.valueOf(noPassProject));
					
					// 已通过初审未验收项目数
					//int noAcceptanceProject = tprojectApplicationDao.getNoAcceptanceProjectCount(year);
					//tp.setNoAcceptanceProject(String.valueOf(noAcceptanceProject));
					
					// 已通过已验收项目数
					int passAcceptanceProject = tprojectApplicationDao.getPassAcceptanceProjectCount(year);
					tp.setPassAcceptanceProject(String.valueOf(passAcceptanceProject));
					// 已通过初审未验收项目数
					int noAcceptanceProject = projectTotal-(noViewProjectTotal+noPassProject+passAcceptanceProject);
							tp.setNoAcceptanceProject(String.valueOf(noAcceptanceProject));
					pagerList.add(tp);
				}
			}
		}
		return pagerList;
	
	}
	/**
	 * 
	 * @comments 一个组下面的项目
	 * @param groupId
	 * @return
	 * @version 1.0
	 */
	public List<TprojectApplication> getProjectList(String groupId) {
		List<TprojectApplication>  list = tprojectApplicationDao.getProjectList(groupId);
		List<TprojectApplication> pagerList = new ArrayList<TprojectApplication>();
		if(list!=null && list.size()>0){
			for(int i=0;i<list.size();i++){
				//list.get(i).getTypeId()
					TprojectApplication tp = list.get(i);
					
					/*// 年度
					tp.setReportYear(tprojectApplication.getReportYear());
					// 计划类别
					tp.setReportYear(tprojectApplication.getPlanFlag());
					// 项目名称
					tp.setProjectName(tprojectApplication.getProjectName());
					// 单位名称
					tp.setApplicationUnit(tprojectApplication.getApplicationUnit());
					// 项目编号
					tp.setProjectNumber(tprojectApplication.getProjectNumber());*/
					
					pagerList.add(tp);
				}
			
		}
		return pagerList;
	}
	//weina end
	
	//zhangjiao start
	/**
	 * 
	 * @comments 合同数据
	 * @param param
	 * @version 1.0
	 */
	private void updateTcontract(String tprojectId) {

		Tcontract tcontract = tcontractDao.get("tprojectApplication.projectId", tprojectId);
		TprojectApplication tprojectApplication = tprojectApplicationDao.get(tprojectId);

		if (tcontract != null){
			//更新合同状态
			tcontract.setContractStatus(Constants.CONTRACT_STATE_NOISSUED);
			tcontract.setUpdateTime(new java.sql.Timestamp(new java.util.Date().getTime()));
			tcontract.setDeleteFlag(Constants.COMMON_STATE_NOTDELETE);
			tcontractDao.update(tcontract);
			
			
			
			//非产业处
			if ("0".equals(highOrOther(tprojectId))){
				
				//合同封皮
				TcontractCoverA tcontractCover = null;
				List<TcontractCoverA> tcontractCoverAList = tcontract.getTcontractCoverAs();
				if(tcontractCoverAList != null && tcontractCoverAList.size() > 0){
					tcontractCover = tcontractCoverAList.get(0);
				}else{
					tcontractCover = new TcontractCoverA();
				}
				//设置合同管理表
				tcontractCover.setTcontract(tcontract);
				//合同封皮下方时间
				tcontractCover.setContractTime(new java.sql.Timestamp(new java.util.Date().getTime()));
				//委托单位（甲方） 
				tcontractCover.setAuthorized(mitemDao.get(Constants.ENTRUSTMENT_COMPANY).getItemDesc());
				//承担单位 （乙方）
				tcontractCover.setCommitmentUnit(tprojectApplication.getApplicationUnit());
				//归口管理单位（丙方）
				tcontractCover.setCentralizedManagement(tprojectApplication.getCentralizedType());
				//完成年限（开始日期）
				tcontractCover.setStartDate(tprojectApplication.getStartTime());
				//完成年限（结束日期）
				tcontractCover.setEndDate(tprojectApplication.getEndTime());
				if(tprojectApplication.getTprojectInfoBs()!=null&&tprojectApplication.getTprojectInfoBs().size()>0){
					TprojectInfoB projectInfo = tprojectApplication.getTprojectInfoBs().get(0);
					//承 担 单 位 地 址
					tcontractCover.setAddress1(projectInfo.getRegionId1());
					tcontractCover.setAddress2(projectInfo.getRegionId2());
					tcontractCover.setAddress3(projectInfo.getRegionId3());
					tcontractCover.setAddress(projectInfo.getUnitAddress());
					//项目单位负责人
					tcontractCover.setUnitCharge(projectInfo.getLegalPerson());
					//办公电话
					tcontractCover.setUnitChargePhone1(projectInfo.getLegalTel());
//					//手机
//					tcontractCover.setUnitChargePhone2(projectInfo.getLegalTel());
					//项目负责人
					tcontractCover.setCharge(projectInfo.getProjectPerson());
					//办公电话  
					tcontractCover.setChargePhone1(projectInfo.getPersonTel());
//					//手机
					tcontractCover.setChargePhone2(projectInfo.getPersonPhone());
					//项目联系人  
					tcontractCover.setContact(projectInfo.getTouchPerson());
					//办公电话 
					tcontractCover.setContactPhone1(projectInfo.getTouchTel());
//					//手机 
					tcontractCover.setContactPhone2(projectInfo.getTouchPhone());
				}
				
				
				//合同封皮备注
				tcontractCover.setContractComment(mitemDao.get(Constants.CONTRACT_COMMENT).getItemDesc());
				// 删除区分 DELETE_FLAG
				tcontractCover.setDeleteFlag(Constants.COMMON_STATE_DEFAULT);
				tcontractCoverADao.saveOrUpdate(tcontractCover);
				
				// 添加合同内容信息 
				TcontractContentsB tcontractContents = null;
				List<TcontractContentsB> tcontractContentsList = tcontract.getTcontractContentsBs();
				if(tcontractContentsList != null && tcontractContentsList.size() > 0){
					tcontractContents = tcontractContentsList.get(0);
				}else{
					tcontractContents = new TcontractContentsB();
				}
				// 合同id T_CONTRACT_ID
				tcontractContents.setTcontract(tcontract);
				//年度
				tcontractContents.setYearValue(tprojectApplication.getReportYear());
				//计划类别
				TprojectType tprojectType = tprojectTypeDao.get(tprojectApplication.getTprojectType().getParentTypeId());
				tcontractContents.setPlanValue(tprojectType.getTypeShowName());
				//科研经费
				if (tprojectApplication.getTcostEstimateBs() != null && tprojectApplication.getTcostEstimateBs().size() > 0){
					tcontractContents.setResearchFunding(tprojectApplication.getTcostEstimateBs().get(0).getApplicationSpecial());
				}				
				//研究内容
				if (tprojectApplication.getTtechnicalContentAs() != null && tprojectApplication.getTtechnicalContentAs().size() > 0){
					tcontractContents.setResearch(tprojectApplication.getTtechnicalContentAs().get(0).getTechnicalContentText());
				}
				//拟达到的技术指标
				if (tprojectApplication.getTtechnicalIndexes() != null && tprojectApplication.getTtechnicalIndexes().size() > 0){
					tcontractContents.setTechnicalSpecifications(tprojectApplication.getTtechnicalIndexes().get(0).getTechnicalIndexes());
				}
				//项目实施阶段安排
				if (tprojectApplication.getTschedulingAs() != null && tprojectApplication.getTschedulingAs().size() > 0){
					tcontractContents.setArrangement(tprojectApplication.getTschedulingAs().get(0).getSchedulingText());
				}
				//项目预期成果形态
				if (tprojectApplication.getTexpectedResults() != null && tprojectApplication.getTexpectedResults().size() > 0){
					tcontractContents.setResultsForm(tprojectApplication.getTexpectedResults().get(0).getExpectedResults());
				}
				//日期
				tcontractContents.setSelectTime1(new java.sql.Timestamp(new java.util.Date().getTime()));
				tcontractContents.setSelectTime2(new java.sql.Timestamp(new java.util.Date().getTime()));
				tcontractContents.setSelectTime3(new java.sql.Timestamp(new java.util.Date().getTime()));
				//开户银行与行号   +  银行账号
				if (tprojectApplication.getTprojectInfoBs() != null && tprojectApplication.getTprojectInfoBs().size() > 0){
					String bank = tprojectApplication.getTprojectInfoBs().get(0).getAccountBank() 
									+ tprojectApplication.getTprojectInfoBs().get(0).getAccountBankNo();
					tcontractContents.setBank(bank);
					tcontractContents.setBankAccount(tprojectApplication.getTprojectInfoBs().get(0).getBankNo());
				}
				
				// 删除区分 DELETE_FLAG
				tcontractContents.setDeleteFlag(Constants.COMMON_STATE_NOTDELETE);
				tcontractContentsBDao.saveOrUpdate(tcontractContents);
			
				//添加项目负责人及主要研究人员
				List<Tresearcher> researcherList = tresearcherDao.getValidTresearchers(tprojectApplication.getProjectId());
				if (researcherList != null && researcherList.size() > 0){
					for (int i = 0;i < researcherList.size();i++){
					TprojectLeaderB tprojectLeaderB = new TprojectLeaderB();
					tprojectLeaderB.setTcontract(tcontract);
					tprojectLeaderB.setName(researcherList.get(i).getName());
					tprojectLeaderB.setAge(researcherList.get(i).getAge());
					tprojectLeaderB.setSex(researcherList.get(i).getSexFlag());
					tprojectLeaderB.setJobTitle(researcherList.get(i).getJob());
					tprojectLeaderB.setSpecialty(researcherList.get(i).getSpecialty());
					tprojectLeaderB.setTask(researcherList.get(i).getTask());
					tprojectLeaderB.setUnit(researcherList.get(i).getWorkUnit());
					tprojectLeaderB.setDeleteFlag(Constants.COMMON_STATE_NOTDELETE);
					tprojectLeaderB.setCreateTime(new java.sql.Timestamp(new java.util.Date().getTime()));
					tprojectLeaderBDao.save(tprojectLeaderB);
					}
				}
				
				//拟达到的经济指标
				if (tprojectApplication.getTeconomicIndicatorBs().size() > 0){
					TeconomicIndicatorB teconomicIndicatorB = tprojectApplication.getTeconomicIndicatorBs().get(0);
					TeconomicIndicatorsB teconomicB = new TeconomicIndicatorsB();
					teconomicB.setTcontract(tcontract);
					//新增销售收入
					teconomicB.setOutputValue(teconomicIndicatorB.getOutputValue());
					teconomicB.setOutputValue1(teconomicIndicatorB.getOutputValue1());
					teconomicB.setOutputValue2(teconomicIndicatorB.getOutputValue2());
					//新增税金
					teconomicB.setPayTaxes(teconomicIndicatorB.getPayTaxes());
					teconomicB.setPayTaxes1(teconomicIndicatorB.getPayTaxes1());
					teconomicB.setPayTaxes2(teconomicIndicatorB.getPayTaxes2());
					//新增利润
					teconomicB.setRetainedProfits(teconomicIndicatorB.getRetainedProfits());
					teconomicB.setRetainedProfits1(teconomicIndicatorB.getRetainedProfits1());
					teconomicB.setRetainedProfits2(teconomicIndicatorB.getRetainedProfits2());
					//创汇
					teconomicB.setEarnMoney(teconomicIndicatorB.getEarnMoney());
					teconomicB.setEarnMoney1(teconomicIndicatorB.getEarnMoney1());
					teconomicB.setEarnMoney2(teconomicIndicatorB.getEarnMoney2());
					//合计
					teconomicB.setTotalOutputValue(teconomicIndicatorB.getTotalOutputValue());
					teconomicB.setTotalPayTaxes(teconomicIndicatorB.getTotalPayTaxes());
					teconomicB.setTotalRetainedProfits(teconomicIndicatorB.getTotalRetainedProfits());
					teconomicB.setTotalEarnMoney(teconomicIndicatorB.getTotalEarnMoney());
					teconomicB.setCreateTime(new java.sql.Timestamp(new java.util.Date().getTime()));
					teconomicIndicatorsBDao.save(teconomicB);
				}
				
				TfundingPlanB tfundingPlanB = new TfundingPlanB();
				tfundingPlanB.setTcontract(tcontract);
				//项目投资计划
				if (tprojectApplication.getTfundPlanB().size() > 0){
					TfundPlanB tfundPlanB = tprojectApplication.getTfundPlanB().get(0);
					//总投资
					tfundingPlanB.setTotalInvestment1(tfundPlanB.getTotalInvestment3());
					tfundingPlanB.setTotalInvestment2(tfundPlanB.getTotalInvestment2());
					tfundingPlanB.setTotalInvestment3(tfundPlanB.getTotalInvestment1());
					//甲方拨款
					tfundingPlanB.setPartyFunding1(tfundPlanB.getPartyFunding3());
					tfundingPlanB.setPartyFunding2(tfundPlanB.getPartyFunding2());
					tfundingPlanB.setPartyFunding3(tfundPlanB.getPartyFunding1());
					//单位自筹
					tfundingPlanB.setUnitRaised1(tfundPlanB.getUnitRaised3());
					tfundingPlanB.setUnitRaised2(tfundPlanB.getUnitRaised2());
					tfundingPlanB.setUnitRaised3(tfundPlanB.getUnitRaised1());
					//其他经费
					tfundingPlanB.setOtherFunds1(tfundPlanB.getOtherFunds3());
					tfundingPlanB.setOtherFunds2(tfundPlanB.getOtherFunds2());
					tfundingPlanB.setOtherFunds3(tfundPlanB.getOtherFunds1());
					//银行贷款
					tfundingPlanB.setBankLoans1(tfundPlanB.getBankLoans3());
					tfundingPlanB.setBankLoans2(tfundPlanB.getBankLoans2());
					tfundingPlanB.setBankLoans3(tfundPlanB.getBankLoans1());
				}
				
				//经费支出预算
				if (tprojectApplication.getTfundingPlanReport().size() > 0){
					TfundingPlanReport tfundingPlanReport = tprojectApplication.getTfundingPlanReport().get(0);
					//设备费
					tfundingPlanB.setEquipmentCost1(tfundingPlanReport.getEquipmentCost1());
					tfundingPlanB.setEquipmentCost2(tfundingPlanReport.getEquipmentCost2());
					tfundingPlanB.setEquipmentCost3(tfundingPlanReport.getEquipmentCost3());
					//材料费
					tfundingPlanB.setMaterialFee1(tfundingPlanReport.getMaterialFee1());
					tfundingPlanB.setMaterialFee2(tfundingPlanReport.getMaterialFee2());
					tfundingPlanB.setMaterialFee3(tfundingPlanReport.getMaterialFee3());
					//测试化验加工费
					tfundingPlanB.setTestFee1(tfundingPlanReport.getTestFee1());
					tfundingPlanB.setTestFee2(tfundingPlanReport.getTestFee2());
					tfundingPlanB.setTestFee3(tfundingPlanReport.getTestFee3());
					//燃料动力费
					tfundingPlanB.setFuel1(tfundingPlanReport.getFuel1());
					tfundingPlanB.setFuel2(tfundingPlanReport.getFuel2());
					tfundingPlanB.setFuel3(tfundingPlanReport.getFuel3());
					//差旅调研费
					tfundingPlanB.setTravel1(tfundingPlanReport.getTravel1());
					tfundingPlanB.setTravel2(tfundingPlanReport.getTravel2());
					tfundingPlanB.setTravel3(tfundingPlanReport.getTravel3());
					//会议交流费
					tfundingPlanB.setConferenceFees1(tfundingPlanReport.getConferenceFees1());
					tfundingPlanB.setConferenceFees2(tfundingPlanReport.getConferenceFees2());
					tfundingPlanB.setConferenceFees3(tfundingPlanReport.getConferenceFees3());
					//劳务咨询费
					tfundingPlanB.setConsultancyServices1(tfundingPlanReport.getConsultancyServices1());
					tfundingPlanB.setConsultancyServices2(tfundingPlanReport.getConsultancyServices2());
					tfundingPlanB.setConsultancyServices3(tfundingPlanReport.getConsultancyServices3());
				}
				tfundingPlanB.setCreateTime(new java.sql.Timestamp(new java.util.Date().getTime()));
				tfundingPlanBDao.save(tfundingPlanB);
			//产业处
			}else{
				
				/**添加合同封皮信息*/
				TcontractCoverA tcontractCovera = null;
				List<TcontractCoverA> tcontractCoveraList = tcontract.getTcontractCoverAs();
				if(tcontractCoveraList != null && tcontractCoveraList.size() > 0){
					tcontractCovera = tcontractCoveraList.get(0);
				}else{
					tcontractCovera = new TcontractCoverA();
				}
				// 合同id T_CONTRACT_ID
				tcontractCovera.setTcontract(tcontract);
				// 委托单位（甲方） 
				tcontractCovera.setAuthorized(mitemDao.get(Constants.ENTRUSTMENT_COMPANY).getItemDesc());
				//合同封皮下方时间
				tcontractCovera.setContractTime(new java.sql.Timestamp(new java.util.Date().getTime()));
				//承担单位 （乙方）
				tcontractCovera.setCommitmentUnit(tprojectApplication.getApplicationUnit());
				//归口管理单位（丙方）
				tcontractCovera.setCentralizedManagement(tprojectApplication.getCentralizedType());
				//完成年限（开始日期）
				tcontractCovera.setStartDate(tprojectApplication.getStartTime());
				//完成年限（结束日期）
				tcontractCovera.setEndDate(tprojectApplication.getEndTime());
				if(tprojectApplication.getTprojectInfoAs()!=null&&tprojectApplication.getTprojectInfoAs().size()>0){
					TprojectInfoA tprojectInfoa = tprojectApplication.getTprojectInfoAs().get(0);
					//承 担 单 位 地 址
					tcontractCovera.setAddress1(tprojectInfoa.getRegionId1());
					tcontractCovera.setAddress2(tprojectInfoa.getRegionId2());
					tcontractCovera.setAddress3(tprojectInfoa.getRegionId3());
					tcontractCovera.setAddress(tprojectInfoa.getUnitAddress());
					//项目单位负责人
					tcontractCovera.setUnitCharge(tprojectInfoa.getLegalPerson());
					//办公电话
					tcontractCovera.setUnitChargePhone1(tprojectInfoa.getLegalTel());
					//手机
					tcontractCovera.setUnitChargePhone2(tprojectInfoa.getLegalPhone());
					//项目负责人
					tcontractCovera.setCharge(tprojectInfoa.getProjectPerson());
					//办公电话  
					tcontractCovera.setChargePhone1(tprojectInfoa.getPersonTel());
					//手机
					tcontractCovera.setChargePhone2(tprojectInfoa.getPersonPhone());
					//项目联系人  
					tcontractCovera.setContact(tprojectInfoa.getTouchPerson());
					//办公电话 
					tcontractCovera.setContactPhone1(tprojectInfoa.getTouchPhone());
					//手机 
					tcontractCovera.setContactPhone2(tprojectInfoa.getTouchIdcard());
				}

				//删除状态
				tcontractCovera.setDeleteFlag(Constants.COMMON_STATE_DEFAULT);
				// 合同封皮备注
				tcontractCovera.setContractComment(mitemDao.get(Constants.CONTRACT_COMMENT).getItemDesc());
				tcontractCoverADao.saveOrUpdate(tcontractCovera);
				
				// 添加合同内容信息 
				TcontractContentsA tcontractContents = null;
				List<TcontractContentsA> tcontractContentsAList = tcontract.getTcontractContentsAs();
				if(tcontractContentsAList != null && tcontractContentsAList.size() > 0){
					tcontractContents = tcontractContentsAList.get(0);
				}else{
					tcontractContents = new TcontractContentsA();
				}
				// 合同id T_CONTRACT_ID
				tcontractContents.setTcontract(tcontract);
				
				if (tprojectApplication.getTcostEstimateBs() != null && tprojectApplication.getTcostEstimateBs().size() > 0){
					//甲方计划资助乙方
					tcontractContents.setPartySubsidizePartyb(BigDecimal.valueOf(Double.valueOf(getFormatValue(tprojectApplication.getTcostEstimateBs().get(0).getApplicationSpecial()))));
					//丙方予以配套资助乙方
					tcontractContents.setPartycSubsidizePartyb(BigDecimal.valueOf(Double.valueOf(getFormatValue(tprojectApplication.getTcostEstimateBs().get(0).getSupportFunds()))));
					//拨款计划
					if (Double.valueOf(getFormatValue(tprojectApplication.getTcostEstimateBs().get(0).getSupportFunds())) != null){
						tcontractContents.setFundingSchemesYuan(BigDecimal.valueOf(Double.valueOf(getFormatValue(tprojectApplication.getTcostEstimateBs().get(0).getSupportFunds())) * 0.7));
						//验收合格后两个月内
						tcontractContents.setFundingSchemesQualified(BigDecimal.valueOf(Double.valueOf(getFormatValue(tprojectApplication.getTcostEstimateBs().get(0).getSupportFunds())) * 0.3));
						//验收基本合格后两个月内
						tcontractContents.setFundingSchemesBasic(BigDecimal.valueOf(Double.valueOf(getFormatValue(tprojectApplication.getTcostEstimateBs().get(0).getSupportFunds())) * 0.3 * 0.6));
					}
					}				
				//拨款计划
				tcontractContents.setFundingSchemesYear(BigDecimal.valueOf(
						Double.valueOf(changeDateType(new java.sql.Timestamp(new java.util.Date().getTime()), "yyyy")))
						);
				tcontractContents.setFundingSchemesMonth(BigDecimal.valueOf(
						Double.valueOf(changeDateType(new java.sql.Timestamp(new java.util.Date().getTime()), "MM")))
						);
				
				//企业指标
				if (tprojectApplication.getTeconomicIndicatorAs() != null && tprojectApplication.getTeconomicIndicatorAs().size() > 0){
					TeconomicIndicatorA teconomicIndicatorA = tprojectApplication.getTeconomicIndicatorAs().get(0);
					//累计新增投资
					Double newInvestCount = teconomicIndicatorA.getNewInvest()+
							teconomicIndicatorA.getNewInvest1()+
			  				teconomicIndicatorA.getNewInvest2();
					tcontractContents.setTotalInvestmentNewXm(BigDecimal.valueOf(Double.valueOf(getFormatValue(newInvestCount))));
					//累计完成销售收入(销售收入默认为0)
					//tcontractContents.setCumulativeSalesOverallXm(BigDecimal.valueOf(0));
					//乙方新增投资
					tcontractContents.setPartybNewInvestments(BigDecimal.valueOf(Double.valueOf(getFormatValue(newInvestCount))));
					//累计所交税金
					Double payTaxesCount = teconomicIndicatorA.getPayTaxes()+
											teconomicIndicatorA.getPayTaxes1()+
							  			   teconomicIndicatorA.getPayTaxes2();
					tcontractContents.setAccumulatedTaxOverallXm(BigDecimal.valueOf(Double.valueOf(getFormatValue(payTaxesCount))));
					//累计净利润
					Double retainedProfitsCount = teconomicIndicatorA.getRetainedProfits()+
							teconomicIndicatorA.getRetainedProfits1()+
			  				teconomicIndicatorA.getRetainedProfits2();
					tcontractContents.setAccumulatedProfitsOverallXm(BigDecimal.valueOf(Double.valueOf(getFormatValue(retainedProfitsCount))));
					//企业资产规模
					Double assetSizeCount = teconomicIndicatorA.getAssetSize()+
							teconomicIndicatorA.getAssetSize1()+
			  				teconomicIndicatorA.getAssetSize2();
					tcontractContents.setAssetSizeOverallXm(BigDecimal.valueOf(Double.valueOf(getFormatValue(assetSizeCount))));
					//累计新增就业人数
					int newEmploymentCount = teconomicIndicatorA.getNewEmployment()+
							teconomicIndicatorA.getNewEmployment1()+
			  				teconomicIndicatorA.getNewEmployment2();
					tcontractContents.setEmploymentNewOverallXm(BigDecimal.valueOf(newEmploymentCount));
				}
				
				//项目指标
				if (tprojectApplication.getTeconomicIndicatorBs() != null && tprojectApplication.getTeconomicIndicatorBs().size() > 0){
					TeconomicIndicatorB teconomicIndicatorB = tprojectApplication.getTeconomicIndicatorBs().get(0);
					//累计销售收入
					Double outputValueCount = teconomicIndicatorB.getProduction2()+
												teconomicIndicatorB.getProduction1()+
												teconomicIndicatorB.getProduction();
					tcontractContents.setCumulativeSalesEconomy(BigDecimal.valueOf(Double.valueOf(getFormatValue(outputValueCount))));
					//累计缴税
					Double payTaxesCount = teconomicIndicatorB.getPayTaxes()+
											teconomicIndicatorB.getPayTaxes1()+
							  			   	teconomicIndicatorB.getPayTaxes2();
					tcontractContents.setAccumulatedTaxEconomy(BigDecimal.valueOf(Double.valueOf(getFormatValue(payTaxesCount))));
					//累计新增净利润
					Double retainedProfitsCount = teconomicIndicatorB.getRetainedProfits()+
													teconomicIndicatorB.getRetainedProfits1()+
									  				teconomicIndicatorB.getRetainedProfits2();
					tcontractContents.setAccumulatedProfitsEconomy(BigDecimal.valueOf(Double.valueOf(getFormatValue(retainedProfitsCount))));
				}
				//技术指标
				if (tprojectApplication.getTtechnicalContentAs() != null && tprojectApplication.getTtechnicalContentAs().size() > 0){
					tcontractContents.setTechnicalSpecifications(tprojectApplication.getTtechnicalContentAs().get(0).getTechnicalContentText());
				}
				//项目实施目标
				if (tprojectApplication.getTreportObjectives() != null && tprojectApplication.getTreportObjectives().size() > 0){
					TreportObjectives treportObjectives = tprojectApplication.getTreportObjectives().get(0);
					//企业新获得质量认证体系证书
					tcontractContents.setQualityCertificationSystem(treportObjectives.getQualityCertificationSystem());
					//项目新获得国家相关行业许可证
					tcontractContents.setRelevantIndustryPermits(treportObjectives.getRelevantIndustryPermits());
					//项目新申请及授权专利（或著作权）证书
					tcontractContents.setApplication(treportObjectives.getAuthorize());
					tcontractContents.setAuthorize(treportObjectives.getApplication());
					//项目新获得技术、产品鉴定证书
					tcontractContents.setTechnologyProductCertificate(treportObjectives.getTechnologyProductCertificate());
				}
				
				//日期
				tcontractContents.setContractSelectDate1(new java.sql.Timestamp(new java.util.Date().getTime()));
				tcontractContents.setContractSelectDate2(new java.sql.Timestamp(new java.util.Date().getTime()));
				tcontractContents.setContractSelectDate3(new java.sql.Timestamp(new java.util.Date().getTime()));
				//开户银行与行号   +  银行账号
				if (tprojectApplication.getTprojectInfoAs() != null && tprojectApplication.getTprojectInfoAs().size() > 0){
					String bank = tprojectApplication.getTprojectInfoAs().get(0).getAccountBank() 
									+ tprojectApplication.getTprojectInfoAs().get(0).getAccountBankNo();
					tcontractContents.setBank(bank);
					tcontractContents.setBankAccount(tprojectApplication.getTprojectInfoAs().get(0).getBankNo());
				}
				
				// 删除区分 DELETE_FLAG
				tcontractContents.setDeleteFlag(Constants.COMMON_STATE_NOTDELETE);
				tcontractContents.setCreateTime(new java.sql.Timestamp(new java.util.Date().getTime()));
				tcontractContentsADao.saveOrUpdate(tcontractContents);
				
				//资金到位计划
				if (tprojectApplication.getTeconomicIndicatorAs() != null && tprojectApplication.getTeconomicIndicatorAs().size() > 0){
					TeconomicIndicatorA teconomicIndicatorA = tprojectApplication.getTeconomicIndicatorAs().get(0);
					String year1 = "";
					String year2 = "";
					String year3 = "";
					if (tcontract.getTprojectApplication() != null){
						if(tcontract.getTprojectApplication().getStartTime() != null 
								&& tcontract.getTprojectApplication().getEndTime() != null){
							String start = String.valueOf(tcontract.getTprojectApplication().getStartTime()).substring(0, 4);
							String end = String.valueOf(tcontract.getTprojectApplication().getEndTime()).substring(0, 4);

							int chazhi = Integer.valueOf(end) - Integer.valueOf(start);
							if (chazhi == 1){
								year1 = start;
								year2 = end;
								year3 = String.valueOf(Integer.valueOf(end) + 1);
							}
							else{
								year1 = start;
								year2 = String.valueOf(Integer.valueOf(start) + 1);
								year3 = end;
							}
						}
					}
					//资金到位计划
						TfundsPlanA tfundsPlanA = new TfundsPlanA();
						tfundsPlanA.setCreateTime(new java.sql.Timestamp(new java.util.Date().getTime()));
						tfundsPlanA.setTcontractContentsA(tcontractContents);
						tfundsPlanA.setFundsPlanYuan(BigDecimal.valueOf(teconomicIndicatorA.getNewInvest2()));
						tfundsPlanA.setFundsPlanYear(year1);
						tfundsPlanA.setFundsPlanMonth(changeDateType(new java.sql.Timestamp(new java.util.Date().getTime()), "MM"));
						tfundsPlanA.setDeleteFlag(Constants.COMMON_STATE_NOTDELETE);
						tfundsPlanADao.save(tfundsPlanA);
						
						TfundsPlanA tfundsPlanA1 = new TfundsPlanA();
						tfundsPlanA1.setCreateTime(new java.sql.Timestamp(new java.util.Date().getTime()));
						tfundsPlanA1.setTcontractContentsA(tcontractContents);
						tfundsPlanA1.setFundsPlanYuan(BigDecimal.valueOf(teconomicIndicatorA.getNewInvest1()));
						tfundsPlanA1.setFundsPlanYear(year2);
						tfundsPlanA1.setFundsPlanMonth(changeDateType(new java.sql.Timestamp(new java.util.Date().getTime()), "MM"));
						tfundsPlanA1.setDeleteFlag(Constants.COMMON_STATE_NOTDELETE);
						tfundsPlanADao.save(tfundsPlanA1);
						
						TfundsPlanA tfundsPlanA2 = new TfundsPlanA();
						tfundsPlanA2.setCreateTime(new java.sql.Timestamp(new java.util.Date().getTime()));
						tfundsPlanA2.setTcontractContentsA(tcontractContents);
						tfundsPlanA2.setFundsPlanYuan(BigDecimal.valueOf(teconomicIndicatorA.getNewInvest()));
						tfundsPlanA2.setFundsPlanYear(year3);
						tfundsPlanA2.setFundsPlanMonth(changeDateType(new java.sql.Timestamp(new java.util.Date().getTime()), "MM"));
						tfundsPlanA2.setDeleteFlag(Constants.COMMON_STATE_NOTDELETE);
						tfundsPlanADao.save(tfundsPlanA2);
				}
			
				if (tprojectApplication.getTfinancingUses() != null && tprojectApplication.getTfinancingUses().size() > 0){
					TfinancingUse tfinancingUse = tprojectApplication.getTfinancingUses().get(0);
					TfundUseA tfundUseA = new TfundUseA();
					tfundUseA.setTcontract(tcontract);
					//设备费
					tfundUseA.setEquipmentSpecial(BigDecimal.valueOf(tfinancingUse.getEquipmentSpecial()));
					tfundUseA.setEquipmentSupport(BigDecimal.valueOf(tfinancingUse.getEquipmentSupport()));
					//购置设备费
					tfundUseA.setPurchaseSpecial(BigDecimal.valueOf(tfinancingUse.getPurchaseSpecial()));
					tfundUseA.setPurchaseSupport(BigDecimal.valueOf(tfinancingUse.getPurchaseSupport()));
					//试制设备费
					tfundUseA.setTrialSpecial(BigDecimal.valueOf(tfinancingUse.getTrialSpecial()));
					tfundUseA.setTrialSupport(BigDecimal.valueOf(tfinancingUse.getTrialSupport()));
					//设备改造与租赁费
					tfundUseA.setRenovationSpecial(BigDecimal.valueOf(tfinancingUse.getRenovationSpecial()));
					tfundUseA.setRenovationSupport(BigDecimal.valueOf(tfinancingUse.getRenovationSupport()));
					//材料费
					tfundUseA.setMaterialSpecial(BigDecimal.valueOf(tfinancingUse.getMaterialSpecial()));
					tfundUseA.setMaterialSupport(BigDecimal.valueOf(tfinancingUse.getMaterialSupport()));
					//测试化验加工费
					tfundUseA.setTestSpecial(BigDecimal.valueOf(tfinancingUse.getTestSpecial()));
					tfundUseA.setTestSupport(BigDecimal.valueOf(tfinancingUse.getTestSupport()));
					//会议费
					tfundUseA.setMeetSpecial(BigDecimal.valueOf(tfinancingUse.getMeetSpecial()));
					tfundUseA.setMeetSupport(BigDecimal.valueOf(tfinancingUse.getMeetSupport()));
					//国际合作与交流费
					tfundUseA.setCooperationSpecial(BigDecimal.valueOf(tfinancingUse.getCooperationSpecial()));
					tfundUseA.setCooperationSupport(BigDecimal.valueOf(tfinancingUse.getCooperationSupport()));
					//出版/文献/信息传播/知识产权事务费
					tfundUseA.setPublishSpecial(BigDecimal.valueOf(tfinancingUse.getPublishSpecial()));
					tfundUseA.setPublishSupport(BigDecimal.valueOf(tfinancingUse.getPublishSupport()));
					//专家咨询费
					tfundUseA.setExpertSpecial(BigDecimal.valueOf(tfinancingUse.getExpertSpecial()));
					tfundUseA.setExpertSupport(BigDecimal.valueOf(tfinancingUse.getExpertSupport()));
					if (tprojectApplication.getTprojectInfoAs() != null && tprojectApplication.getTprojectInfoAs().size() > 0){
						//开户名称
						tfundUseA.setAccountName(tprojectApplication.getTprojectInfoAs().get(0).getAccountName());
						//开户银行
						tfundUseA.setBank(tprojectApplication.getTprojectInfoAs().get(0).getAccountBank());
						//账号
						tfundUseA.setAccount(tprojectApplication.getTprojectInfoAs().get(0).getBankNo());
					}
					tfundUseA.setSelectDate(new java.sql.Timestamp(new java.util.Date().getTime()));
					tfundUseA.setCreateTime(new java.sql.Timestamp(new java.util.Date().getTime()));
					tfundUseA.setDeleteFlag(Constants.COMMON_STATE_NOTDELETE);
					tfundUseADao.save(tfundUseA);
				}
			}
		}
	}
	
	/**
	 * Double数据转换成格式正确的字符
	 * @comments 
	 * @param dValue
	 * @return
	 * @version 1.0
	 */
	private String getFormatValue(Double dValue){
		String stringValue = BigDecimal.valueOf(dValue).toString().trim();
		if(stringValue.indexOf(".")>1){
			String[] temp = stringValue.split("\\.");
			if(temp[1].length()>4){
				stringValue = BigDecimal.valueOf(dValue).setScale(4, BigDecimal.ROUND_HALF_UP).toString();
			}
		}
		return stringValue;
	}
	
	/**
	 * 
	 * @comments 判断是高新的还是非高新的申报 
	 * @version 1.0
	 */
	private String highOrOther(String projectId){
		String highOrOtherFlag = null;
		if(projectId != null){
			TprojectApplication tprojectApplication = tprojectApplicationDao.get(projectId);
			TprojectType tprojectType = tprojectTypeDao.get(tprojectApplication.getTprojectType().getTypeId());
			
	    	if(Constants.HIGHTECH_DEPARTMENT.equals(tprojectType.getDepartmentId())){
				highOrOtherFlag = "1";
			}else{
				highOrOtherFlag = "0";
			}
		}
    	
		return highOrOtherFlag;
	}
	
	/**
	 * @comments 日期类型转换
	 * @param obj
	 * @param format
	 * @return
	 * @Version 1.0
	 */
	private String changeDateType(Object obj, String format) {
		String date = "";
		if (obj != null && !"".equals(obj)) {
			date = new SimpleDateFormat(format).format(obj);
		}
		return date;
	}
	//zhangjiao end

	//wangxd start
	/**
	 * 通过条件查询项目申报信息
	 * @comments 
	 * @param param
	 * @return
	 * @version 1.0
	 */
	public List<TprojectApplication> getProjectList(Map<String, Object> param) {
		
		return tprojectApplicationDao.getProjectList(param);
	}
	//wangxd end
	
}
