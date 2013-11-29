/*************** 版权声明***************
*
* Copyright (C) 2012 西安辉盛科技发展有限责任公司.
*
********************************************
*/
package com.hopsun.tppas.api.supervisor.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hopsun.scenter.entity.ScUsers;
import com.hopsun.tppas.api.superadmin.service.MitemService;
import com.hopsun.tppas.api.superadmin.service.TprojectTypeManagerService;
import com.hopsun.tppas.api.superadmin.service.TprojectTypeService;
import com.hopsun.tppas.api.supervisor.service.TsupervisorService;
import com.hopsun.tppas.common.Constants;
import com.hopsun.tppas.entity.Mitem;
import com.hopsun.tppas.entity.TprojectType;
import com.hopsun.framework.base.action.BaseAction;
import com.hopsun.framework.base.bean.Pager;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

/**
 * 项目监理
 *@comments
 *@author wxd
 *@date 2013-9-16
 *@version 1.0
 */
public class TsupervisorAction extends BaseAction{
  
	private static final long serialVersionUID = 2641026431030350948L;
	
	/**项目监理service*/
	@Resource
	private TsupervisorService tsupervisorService;
	
	/**项目分类service*/
	@Resource
	private TprojectTypeService tprojectTypeService;
	
	/**项目分类管理专员service*/
	@Resource
	private TprojectTypeManagerService tprojectTypeManagerService;
	
	/**码表service*/
	@Resource
	private MitemService apiMitemService;
	
	/**项目名称*/
	private String projectName;
	
	/**申报单位*/
	private String applicationUnit;
	
	/**项目分类一级*/
	private String planFlag;
	
	/**项目分类二级*/
	private String typeId;
	
	/**监理状态*/
	private String supervisorState;
	
	/**项目分类一级集合*/
	private List<TprojectType> projectTypeFirstList = new ArrayList<TprojectType>();
	
	/**项目分类二级集合*/
	private List<TprojectType> projectTypeSecondList = new ArrayList<TprojectType>();
	
	/**监理状态集合*/
	private List<Mitem> supervisorStateList = new ArrayList<Mitem>();
	
	/**json字符串*/
	private String backStr;
	
	/** 跳转路径*/
	private String retUrl;
	
	/** 跳转页面massage*/
	private String retMsg;
	
	/** 翻页 */
	private int pageNo;
	
	/**
	 * 项目监理查询初始
	 * @comments 
	 * @return
	 * @version 1.0
	 */
	public String supervisorManager(){
		// 取得登录用户的信息
		HttpSession session = this.getRequest().getSession();
		session.setAttribute(Constants.SESSION_CMDKEY,"tsupervisorAction");

		ScUsers user = (ScUsers) session.getAttribute("sysUser");
		// 如果用户为空或者企业为空，退出系统
		if (user == null || ("").equals(user.getUserId())) {
			return "LogOut";
		}
		
		// 计划类别
		//String deptId = user.getScDept().getDeptId();
		//this.projectTypeFirstList = tprojectTypeService.getFatherProjectTypeListByDeptId(deptId);
		
		// 初始化计划类别
		this.projectTypeFirstList = tprojectTypeManagerService.getProjectTypeListByUser(user);
		
		//项目监理状态
		this.supervisorStateList = apiMitemService.getListByTypeId(Constants.TYPE_SUPERVISOR_STATE);
		
		return "supervisorManager";
	}
	
	/**
	 * 项目监理列表
	 * @comments 
	 * @return
	 * @version 1.0
	 */
	public String supervisorList(){
		// 取得登录用户的信息
		HttpSession session = this.getRequest().getSession();
		ScUsers user = (ScUsers) session.getAttribute("sysUser");

		// 如果用户为空或者企业为空，退出系统
		if (user == null || ("").equals(user.getUserId())) {
			return "LogOut";
		}

		// 翻页
		if (pager == null && this.getPageNo() == 0) {
			pager = new Pager();
		} else {
			pager = new Pager();
			pager.setPageNumber(this.getPageNo());
		}

		Map<String, Object> param = new HashMap<String, Object>();

		// 封装查询条件
		// 项目名称
		param.put("projectName", projectName);
		// 申报单位
		param.put("applicationUnit", applicationUnit);
		// 项目分类一级
		param.put("planFlag", planFlag);
		//项目分类二级
		param.put("typeId", typeId);
		//监理状态
		param.put("supervisorState", supervisorState);
		// 用户所在部门
		//param.put("deptId", user.getScDept().getDeptId());
		// 计划类别（小分类）查询范围  in
		param.put("typeIdStr", tprojectTypeManagerService.getProjectTypeStrByUser(user));
		
		//查询项目监理列表
		pager = tsupervisorService.supervisorList(param,pager.getPageNumber(), pager.getPageSize());
		return "supervisorList";
	}
	
	/**
	 * @comments 下拉列表联动
	 * @return
	 * @throws Exception
	 * @Version 1.0
	 */
	public String getSecondData() throws Exception {

		// 取得联动下拉列表数据List
		List<TprojectType> dataList = tprojectTypeService.getSonProjectTypeListByDeptId(planFlag);
		StringBuffer dataStr = new StringBuffer();

		if (dataList != null) {
			// 遍历下拉列表List 组成json字符串
			for (int i = 0; i < dataList.size(); i++) {
				dataStr.append(dataList.get(i).getTypeId());
				dataStr.append(",");
				dataStr.append(dataList.get(i).getTypeShowName());
				if (i != dataList.size() - 1) {
					dataStr.append(",");
				}
			}
		}
		this.backStr = dataStr.toString();
		return "getDataSuccess";
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public String getApplicationUnit() {
		return applicationUnit;
	}

	public void setApplicationUnit(String applicationUnit) {
		this.applicationUnit = applicationUnit;
	}

	public String getTypeId() {
		return typeId;
	}

	public void setTypeId(String typeId) {
		this.typeId = typeId;
	}

	public String getSupervisorState() {
		return supervisorState;
	}

	public void setSupervisorState(String supervisorState) {
		this.supervisorState = supervisorState;
	}

	public List<TprojectType> getProjectTypeFirstList() {
		return projectTypeFirstList;
	}

	public void setProjectTypeFirstList(List<TprojectType> projectTypeFirstList) {
		this.projectTypeFirstList = projectTypeFirstList;
	}

	public List<TprojectType> getProjectTypeSecondList() {
		return projectTypeSecondList;
	}

	public void setProjectTypeSecondList(List<TprojectType> projectTypeSecondList) {
		this.projectTypeSecondList = projectTypeSecondList;
	}

	public List<Mitem> getSupervisorStateList() {
		return supervisorStateList;
	}

	public void setSupervisorStateList(List<Mitem> supervisorStateList) {
		this.supervisorStateList = supervisorStateList;
	}

	public String getPlanFlag() {
		return planFlag;
	}

	public void setPlanFlag(String planFlag) {
		this.planFlag = planFlag;
	}

	public String getBackStr() {
		return backStr;
	}

	public void setBackStr(String backStr) {
		this.backStr = backStr;
	}

	public String getRetUrl() {
		return retUrl;
	}

	public void setRetUrl(String retUrl) {
		this.retUrl = retUrl;
	}

	public String getRetMsg() {
		return retMsg;
	}

	public void setRetMsg(String retMsg) {
		this.retMsg = retMsg;
	}

	public int getPageNo() {
		return pageNo;
	}

	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}
	
}
