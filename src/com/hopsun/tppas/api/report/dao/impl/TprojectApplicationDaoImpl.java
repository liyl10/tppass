package com.hopsun.tppas.api.report.dao.impl;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.hopsun.framework.base.bean.Finder;
import com.hopsun.framework.base.bean.Pager;
import com.hopsun.framework.base.dao.impl.BaseDaoImpl;
import com.hopsun.tppas.api.report.dao.TprojectApplicationDao;
import com.hopsun.tppas.common.CommonTool;
import com.hopsun.tppas.common.Constants;
import com.hopsun.tppas.entity.TprojectApplication;
import com.hopsun.tppas.view.VprojectInfoAll;

/**
 * @Comments: 后台Dao实现类-主要用来实现项目申报操作的接口
 * @author yk
 * @date 2013-08-01
 * @version 1.0
 * 
 */
@Repository
public class TprojectApplicationDaoImpl extends BaseDaoImpl<TprojectApplication, String> implements TprojectApplicationDao {

	/**
	 * 查询待调配项目
	 * 
	 * @param applyState
	 * @return
	 */
	@Override
	public List<TprojectApplication> queryProjectApplicationByApplyState(String applyState) {
		String hql = " FROM TprojectApplication AS projectApplication LEFT JOIN FETCH  projectApplication.tprojectInfoAs  LEFT JOIN FETCH projectApplication.tprojectType WHERE  projectApplication.applyStatus=? ";
		return createQueryList(hql, new String[] { applyState });
	}

	/**
	 * 查询待归档项目
	 * 
	 * @param applyState
	 * @return
	 */
	@Override
	public List<TprojectApplication> queryProjectApplicationByFlowState(String[] flowStatus) {
		String hql = "select distinct projectApplication  FROM TprojectApplication AS projectApplication inner JOIN   projectApplication.tprojectInfoAs  inner JOIN  projectApplication.tprojectType inner join  projectApplication.tacceptances tacceptances WHERE (tacceptances.acceptanceStatus in('结题','验收基本合格','验收合格') or  projectApplication.flowStatus in('处长审核不通过','联席会审核不通过') )";
		return createQueryList(hql);
	}

	/**
	 * 查询带初审项目
	 */
	@Override
	public Pager queryBeforeReviewProject(Map<String, Object> param, int pageNo, int pageSize) {
		// 创建Finder查询对象
		String hql = this.createHql(param);
		Finder f = Finder.create(hql);

		// 排序条件
		f.append(" order by t.createTime desc");

		// 查询、返回
		Pager p = super.find(f, pageNo, pageSize);
		return p;
	}

	/**
	 * @comments 生成hql
	 * @param param
	 * @return
	 * @Version 1.0
	 */
	private String createHql(Map<String, Object> param) {
		StringBuffer hql = new StringBuffer();

		// 生成hql
		hql.append(" from VprojectInfoAll t ");
		hql.append(" where 1=1  ");
		// 项目名称
		String projectName = (String) param.get("projectName");
		if (!isNullString(projectName)) {
			hql.append(" and t.projectName like '%" + projectName.trim() + "%'");
		}

		// 申报单位
		String applicationUnit = (String) param.get("applicationUnit");
		if (!isNullString(applicationUnit)) {
			hql.append(" and t.applicationUnit like '%" + applicationUnit.trim() + "%'");
		}

		// 单位性质
		String companyType = (String) param.get("companyType");
		if (!isNullString(companyType)) {
			hql.append(" and t.unitProperties = '" + companyType.trim() + "'");
		}

		// 计划类别
		// 一级分类
		String selectedProjectTypeFirst = (String) param.get("selectedProjectTypeFirst");
		if (!isNullString(selectedProjectTypeFirst)) {
			hql.append(" and t.planFlag = '" + selectedProjectTypeFirst.trim() + "'");
		} else {
			// 根据用户不同，取得不同的数据
			String userDeptId = param.get("deptId").toString();

			// 判断用户是否为计划处用户，如果为计划处用户，则能取得所有业务部门的数据
			// 如果为业务部用户，只能取得该业务部自己的数据
			if (!Constants.PLANNING_DEPARTMENT.equals(userDeptId)) {
				// 计划类别
				if (param.containsKey("projectTypeStr")) {
					String typeIdStr = (String) param.get("projectTypeStr");
					if (!isNullString(typeIdStr)) {
						hql.append(" and t.typeId in (" + typeIdStr.trim() + ")");
					}
				}
			}
		}
		// 二级分类
		String selectedProjectTypeSecond = (String) param.get("selectedProjectTypeSecond");
		if (!isNullString(selectedProjectTypeSecond)) {
			hql.append(" and t.typeId = '" + selectedProjectTypeSecond.trim() + "'");
		} else {

		}

		// 审核状态
		String auditStatus = (String) param.get("auditStatus");
		String auditStatus2 = (String) param.get("auditStatus2");
		if (!isNullString(auditStatus)) {
			hql.append(" and (t.applyStatus = '" + auditStatus.trim() + "'");
			hql.append(" or t.applyStatus = '" + auditStatus2.trim() + "')");
		}

		return hql.toString();
	}

	/**
	 * @comments 项目查询
	 * @param param
	 * @param pageNo
	 * @param pageSize
	 * @return
	 * @Version 1.0
	 */
	public Pager queryTprojectApplication(Map<String, Object> param, int pageNo, int pageSize) {
		// 创建Finder查询对象
		Finder f = Finder.create(" from TprojectApplication ta where ta.deleteFlag=:deleteFlag");
		// 项目名称
		String projectName = (String) param.get("projectName");
		if (!isNullString(projectName)) {
			f.append(" and ta.projectName like '%" + projectName.trim() + "%'");
		}
		// 承担单位
		String applicationUnit = (String) param.get("applicationUnit");
		if (!isNullString(applicationUnit)) {
			f.append(" and ta.applicationUnit like '%" + applicationUnit.trim() + "%'");
		}
		// 归口管理部门
		String centralizedType = (String) param.get("centralizedType");
		if (!isNullString(centralizedType)) {
			f.append(" and ta.centralizedType = '" + centralizedType.trim() + "'");
		}
		f.append(" order by ta.createTime desc");

		f.setParam("deleteFlag", Constants.COMMON_STATE_NOTDELETE);

		return super.find(f, pageNo, pageSize);
	}

	/**
	 * 根据项目id取得项目详细信息
	 */
	@Override
	public VprojectInfoAll queryProjectInfoAll(String projectId) {
		StringBuffer hql = new StringBuffer();

		// 生成hql
		hql.append(" from VprojectInfoAll t ");
		hql.append(" where 1=1  ");
		// 项目ID
		if (!isNullString(projectId)) {
			hql.append(" and t.projectId ='" + projectId.trim() + "'");
		}
		Finder f = Finder.create(hql.toString());

		return (VprojectInfoAll) super.find(f).get(0);
	}

	/**
	 * 取得待调配项目List
	 */
	@Override
	public Pager queryDeployProjectList(Map<String, Object> param, Integer pageNumber, Integer pageSize) {
		StringBuffer hql = new StringBuffer();

		// 生成hql
		hql.append(" from VprojectInfoAll t ");
		hql.append(" where 1=1  ");
		// 项目名称
		String projectName = (String) param.get("projectName");
		if (!isNullString(projectName)) {
			hql.append(" and t.projectName like '%" + projectName.trim() + "%'");
		}

		// 单位性质
		String companyType = (String) param.get("companyType");
		if (!isNullString(companyType)) {
			hql.append(" and t.unitProperties = '" + companyType.trim() + "'");
		}

		// 部门id
		String selectedDeptId = (String) param.get("selectedDeptId");
		if (!isNullString(selectedDeptId)) {
			hql.append(" and t.deptId = '" + selectedDeptId.trim() + "'");
		}

		// 计划类别
		// 一级分类
		String selectedProjectTypeFirst = (String) param.get("selectedProjectTypeFirst");
		if (!isNullString(selectedProjectTypeFirst)) {
			hql.append(" and t.planFlag = '" + selectedProjectTypeFirst.trim() + "'");
		}
		// 二级分类
		String selectedProjectTypeSecond = (String) param.get("selectedProjectTypeSecond");
		if (!isNullString(selectedProjectTypeSecond)) {
			hql.append(" and t.typeId = '" + selectedProjectTypeSecond.trim() + "'");
		}

		// 审核状态
		String auditStatus = (String) param.get("auditStatus");
		if (!isNullString(auditStatus)) {
			hql.append(" and t.applyStatus = '" + auditStatus.trim() + "'");
		}

		Finder f = Finder.create(hql.toString());

		// 排序条件
		f.append(" order by t.createTime desc");

		// 查询、返回
		Pager p = super.find(f, pageNumber, pageSize);
		return p;
	}

	// weina start
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
		// 创建Finder查询对象
		Finder f = Finder.create("from TprojectApplication p where p.tplan.planId =:planId and p.deleteFlag = " + Constants.COMMON_STATE_NOTDELETE);
		// 根据用户id,未删除 deleteFlag=0
		f.setParam("planId", planId);
		f.append(" order by p.createTime desc");
		return super.find(f, pageNo, pageSize);
	}

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
	public Pager getArchivalList(Map<String, Object> param, int pageNo, int pageSize) {
		// 创建Finder查询对象
		String hql = this.createArchivalHql(param);

		Finder f = Finder.create(hql);

		// 排序条件
		f.append(" order by t.createTime desc");

		Pager p = super.find(f, pageNo, pageSize);

		// 查询、返回
		return p;
	}

	/**
	 * @comments 生成分计划sql
	 * @param param
	 * @return
	 * @Version 1.0
	 */
	private String createArchivalHql(Map<String, Object> param) {
		StringBuffer hql = new StringBuffer();

		// 生成hql
		hql.append(" from TprojectApplication t, VprojectInfo v, Tacceptance t1");
		hql.append(" where t.projectId = v.projectId and t.projectId = t1.tprojectApplication.projectId and t.deleteFlag = " + Constants.COMMON_STATE_NOTDELETE + " and t1.acceptanceStatus in('"
				+ Constants.ACCEPTANCE_END + "','" + Constants.ACCEPTANCE_BASIC_PASS + "','" + Constants.ACCEPTANCE_PASS + "')");
		// 项目ID
		String projectId = (String) param.get("projectId");
		if (!isNullString(projectId)) {
			hql.append(" and t.projectId = '" + projectId.trim() + "'");
		}
		// 项目编号
		String projectNumber = (String) param.get("projectNumber");
		if (!isNullString(projectNumber)) {
			hql.append(" and t.projectNumber = '" + projectNumber.trim() + "'");
		}
		// 项目名称
		String projectName = (String) param.get("projectName");
		if (!isNullString(projectName)) {
			hql.append(" and t.projectName like '%" + projectName.trim() + "%'");
		}

		// 申报单位
		String applicationUnit = (String) param.get("applicationUnit");
		if (!isNullString(applicationUnit)) {
			hql.append(" and t.applicationUnit like '%" + applicationUnit.trim() + "%'");
		}

		// 项目类别
		String projectType1 = (String) param.get("projectType1");
		if (!isNullString(projectType1)) {
			hql.append(" and t.planFlag = '" + projectType1.trim() + "'");
		}

		// 计划类别
		String projectType2 = (String) param.get("projectType2");
		if (!isNullString(projectType2)) {
			hql.append(" and t.tprojectType.typeId = '" + projectType2.trim() + "'");
		}

		// 技术领域
		String technicalFisld = (String) param.get("technicalFisld");
		if (!isNullString(technicalFisld)) {
			hql.append(" and t.technicalFisld = '" + technicalFisld.trim() + "'");
		}

		// 申报日期
		String startTime = (String) param.get("startTime");
		if (!isNullString(startTime)) {
			hql.append(" and t.startTime = '" + startTime.trim() + "'");
		}
		// 归档日期
		String archivalTime = (String) param.get("archivalTime");
		if (!isNullString(archivalTime)) {
			hql.append(" and t.archivalTime = '" + archivalTime.trim() + "'");
		}
		// 归档状态
		String isArchival = (String) param.get("isArchival");
		if (!isNullString(isArchival)) {
			hql.append(" and t.isArchival = '" + isArchival.trim() + "'");
		}
		// 项目状态
		String applyStatus = (String) param.get("applyStatus");
		if (!isNullString(applyStatus)) {
			hql.append(" and t.applyStatus = '" + applyStatus.trim() + "'");
		}
		return hql.toString();
	}

	/**
	 * 
	 * @comments 查询一个组下面的项目
	 * @param groupId
	 * @return
	 * @version 1.0
	 */
	public List<TprojectApplication> getProjectList(String groupId) {
		StringBuffer hql = new StringBuffer();
		hql.append(" from TprojectApplication t where t.deleteFlag=" + Constants.COMMON_STATE_NOTDELETE);
		hql.append(" and t.tprojectGroup.groupId = ? ");
		return super.createQueryList(hql.toString(), new String[] { groupId });
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
	public List getProjectViewList(Map<String, Object> param) {
		// Finder f = Finder.create(createProjectHql(param));

		// 排序条件
		// f.append(" order by t.createTime desc");

		return super.createQueryList(createProjectHql(param), new String[] {});

	}

	/**
	 * @comments 生成sql
	 * @param param
	 * @return
	 * @Version 1.0
	 */
	private String createProjectHql(Map<String, Object> param) {
		StringBuffer hql = new StringBuffer();
		hql.append(" select t.reportYear from TprojectApplication t where t.deleteFlag=" + Constants.COMMON_STATE_NOTDELETE);
		// Start年度
		String projectViewTypeStartTime = (String) param.get("projectViewTypeStartTime");
		if (!isNullString(projectViewTypeStartTime)) {
			hql.append(" and t.reportYear >= '" + projectViewTypeStartTime.trim() + "'");
		}
		// End年度
		String projectViewTypeEndTime = (String) param.get("projectViewTypeEndTime");
		if (!isNullString(projectViewTypeEndTime)) {
			hql.append(" and t.reportYear <= '" + projectViewTypeEndTime.trim() + "'");
		}
		hql.append(" group by t.reportYear order by t.reportYear ");
		return hql.toString();
	}

	/**
	 * @comments 查询年度
	 * @param valueStr
	 * @return
	 * @Version 1.0
	 */
	public List getProjectYear(Map<String, Object> param) {
		// 创建Finder查询对象
		String hql = this.createProjectYearHql(param);

		Finder f = Finder.create(hql);

		return super.find(f);
	}

	/**
	 * @comments 生成年度sql
	 * @param param
	 * @return
	 * @Version 1.0
	 */
	private String createProjectYearHql(Map<String, Object> param) {
		StringBuffer hql = new StringBuffer();

		hql.append(" select t.reportYear from TprojectApplication t where t.deleteFlag = " + Constants.COMMON_STATE_NOTDELETE + " group by t.reportYear");

		return hql.toString();
	}

	/**
	 * @comments 项目总数sql
	 * @param param
	 * @return
	 * @Version 1.0
	 */
	public int getProjectTotalCount(String year) {
		// 创建Finder查询对象
		String hql = this.createProjectTotalHql(year);

		Finder f = Finder.create(hql);

		return super.countQueryResult(f);
	}

	/**
	 * @comments 生成项目总数sql
	 * @param param
	 * @return
	 * @Version 1.0
	 */
	private String createProjectTotalHql(String year) {
		StringBuffer hql = new StringBuffer();

		hql.append(" from TprojectApplication t where t.deleteFlag = " + Constants.COMMON_STATE_NOTDELETE + " and t.reportYear = '" + year + "'");

		return hql.toString();
	}

	/**
	 * @comments 未初审项目数sql
	 * @param param
	 * @return
	 * @Version 1.0
	 */
	public int getNoViewProjectTotalCount(String year) {
		// 创建Finder查询对象
		String hql = this.createNoViewProjectHql(year);

		Finder f = Finder.create(hql);

		return super.countQueryResult(f);
	}

	/**
	 * @comments 未初审项目数sql
	 * @param param
	 * @return
	 * @Version 1.0
	 */
	private String createNoViewProjectHql(String year) {

		StringBuffer hql = new StringBuffer();

		// 生成hql
		hql.append(" from TprojectApplication t ");
		hql.append(" where t.deleteFlag = " + Constants.COMMON_STATE_NOTDELETE + " and t.reportYear = '" + year + "'");
		hql.append(" and t.applyStatus in('" + Constants.PROJECT_REPORT_WRITE + "','" + Constants.PROJECT_REPORT_SUBMIT + "','" + Constants.PROJECT_REPORT_BEFOREREIEW_ING + "','"
				+ Constants.PROJECT_REPORT_REDISTRIBUTE + "','" + Constants.PROJECT_REPORT_NOTPASS + "') ");

		return hql.toString();
	}

	/**
	 * @comments 未通过项目数sql
	 * @param param
	 * @return
	 * @Version 1.0
	 */

	public int getNoPassProjectCount(String year) {
		// 创建Finder查询对象
		String hql = this.createNoPassProjectHql(year);

		Finder f = Finder.create(hql);

		return super.countQueryResult(f);
	}

	/**
	 * @comments 生成未通过项目总数sql -- 初审不通过不可修改 and 验收不合格
	 * @param param
	 * @return
	 * @Version 1.0
	 */
	private String createNoPassProjectHql(String year) {
		StringBuffer hql = new StringBuffer();

		hql.append(" from TprojectApplication t, Tacceptance t1 ");
		hql.append(" where t.projectId = t1.tprojectApplication.projectId and t.deleteFlag = " + Constants.COMMON_STATE_NOTDELETE + " and t.reportYear = '" + year + "'");
		hql.append(" and t.applyStatus = '" + Constants.PROJECT_REPORT_BEFOREREVIEW_NOPASS_N + "' and t1.acceptanceStatus = '" + Constants.ACCEPTANCE_NOPASS + "' ");

		return hql.toString();
	}

	/**
	 * @comments 已通过初审未验收项目数sql
	 * @param param
	 * @return
	 * @Version 1.0
	 */
	public int getNoAcceptanceProjectCount(String year) {
		// 创建Finder查询对象
		String hql = this.createNoAcceptanceProject(year);

		Finder f = Finder.create(hql);

		return super.countQueryResult(f);
	}

	/**
	 * @comments 已通过初审未验收项目数sql
	 * @param param
	 * @return
	 * @Version 1.0
	 */
	private String createNoAcceptanceProject(String year) {
		StringBuffer hql = new StringBuffer();

		// 生成hql
		hql.append(" from TprojectApplication t, Tacceptance t1");
		hql.append(" where t.projectId = t1.tprojectApplication.projectId and t.deleteFlag = " + Constants.COMMON_STATE_NOTDELETE + " and t.reportYear = '" + year + "'");
		hql.append(" and t.applyStatus not in('" + Constants.PROJECT_REPORT_WRITE + "','" + Constants.PROJECT_REPORT_SUBMIT + "','" + Constants.PROJECT_REPORT_BEFOREREIEW_ING + "','"
				+ Constants.PROJECT_REPORT_REDISTRIBUTE + "','" + Constants.PROJECT_REPORT_BEFOREREVIEW_NOPASS_N + "','" + Constants.PROJECT_REPORT_BEFOREREVIEW_NOPASS
				+ "') and t1.acceptanceStatus not in('" + Constants.ACCEPTANCE_NOPASS + "','" + Constants.ACCEPTANCE_PASS + "','" + Constants.ACCEPTANCE_BASIC_PASS + "','" + Constants.ACCEPTANCE_END
				+ "') ");

		return hql.toString();
	}

	/**
	 * @comments 已通过已验收项目数sql
	 * @param param
	 * @return
	 * @Version 1.0
	 */
	public int getPassAcceptanceProjectCount(String year) {
		// 创建Finder查询对象
		String hql = this.createPassAcceptanceProject(year);

		Finder f = Finder.create(hql);

		return super.countQueryResult(f);
	}

	/**
	 * @comments 已通过已验收项目数sql --结题and 验收基本合格 and 验收合格
	 * @param param
	 * @return
	 * @Version 1.0
	 */
	private String createPassAcceptanceProject(String year) {
		StringBuffer hql = new StringBuffer();

		// 生成hql
		hql.append(" from TprojectApplication t, Tacceptance t1");
		hql.append(" where t.projectId = t1.tprojectApplication.projectId and t.deleteFlag = " + Constants.COMMON_STATE_NOTDELETE + " and t.reportYear = '" + year + "'");
		hql.append(" and t1.acceptanceStatus in('" + Constants.ACCEPTANCE_PASS + "','" + Constants.ACCEPTANCE_BASIC_PASS + "','" + Constants.ACCEPTANCE_END + "') ");

		return hql.toString();
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

	// weina end

	// wangxd start
	/**
	 * 通过条件查询项目申报信息
	 * 
	 * @comments
	 * @param param
	 * @return
	 * @version 1.0
	 */
	public List<TprojectApplication> getProjectList(Map<String, Object> param) {
		/*StringBuffer hql = new StringBuffer(" from TprojectApplication t where t.deleteFlag=" + Constants.COMMON_STATE_NOTDELETE);

		// 组ID
		String groupId = (String) param.get("groupId");
		if (CommonTool.IsNotEmpty(groupId)) {
			hql.append(" and t.tprojectGroup.groupId='" + groupId + "'");
		}*/
		return super.createQueryList(this.projecsByGroupId(param), new String[] {});
	}

	/**
	 * 通过条件查询该组下项目信息-分页
	 * 
	 * @comments
	 * @param param
	 * @param pageNo
	 * @param pageSize
	 * @return
	 * @version 1.0
	 */
	public Pager getProjecsByGroupId(Map<String, Object> param, int pageNo, int pageSize) {
		String hql = this.projecsByGroupId(param);
		Finder f = Finder.create(hql);
		Pager p = super.find(f, pageNo, pageSize);

		return p;
	}
	
	private String projecsByGroupId(Map<String, Object> param){
		StringBuffer hql = new StringBuffer("from TprojectApplication t where t.deleteFlag=" + Constants.COMMON_STATE_NOTDELETE);
		// 组ID
		String groupId = (String) param.get("groupId");
		if (CommonTool.IsNotEmpty(groupId)) {
			hql.append(" and t.tprojectGroup.groupId='" + groupId + "'");
		}
		//组名称
		String projectName = (String)param.get("projectName");
		if(CommonTool.IsNotEmpty(projectName)){
			hql.append(" and t.projectName like '%" + projectName + "%'");
		}
		
		//是否选择
		String isWrite = (String)param.get("isWrite");
		if(CommonTool.IsNotEmpty(isWrite)){
			if("0".equals(isWrite)){
				hql.append(" and (t.projectTechnologyResult is null or t.projectInvestmentResult!='')");
				hql.append(" and (t.projectInvestmentResult is null or t.projectTechnologyResult!='')");
			}else if("1".equals(isWrite)){
				hql.append(" and (t.projectTechnologyResult is not null or t.projectInvestmentResult is not null )");
			}
		}
		hql.append(" order by t.createTime desc");
		
		return hql.toString();
	}
	// wangxd end

}
