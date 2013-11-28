/*************** 版权声明***************
*
* Copyright (C) 2012 西安辉盛科技发展有限责任公司.
*
********************************************
*/
package com.hopsun.tppas.api.superadmin.action;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.hopsun.framework.base.action.BaseAction;
import com.hopsun.framework.base.bean.Pager;
import com.hopsun.scenter.api.dept.service.DeptService;
import com.hopsun.scenter.entity.ScDept;
import com.hopsun.scenter.entity.ScUsers;
import com.hopsun.tppas.api.report.service.TprojectGroupService;
import com.hopsun.tppas.api.superadmin.service.MitemService;
import com.hopsun.tppas.api.superadmin.service.TprojectAcceptanceTemplateService;
import com.hopsun.tppas.api.superadmin.service.TprojectContractTemplateService;
import com.hopsun.tppas.api.superadmin.service.TprojectReportTemplateService;
import com.hopsun.tppas.api.superadmin.service.TprojectSupervisionTemplateService;
import com.hopsun.tppas.api.superadmin.service.TprojectTypeService;
import com.hopsun.tppas.common.CommonTool;
import com.hopsun.tppas.common.Constants;
import com.hopsun.tppas.entity.Mitem;
import com.hopsun.tppas.entity.TprojectAcceptanceTemplate;
import com.hopsun.tppas.entity.TprojectContractTemplate;
import com.hopsun.tppas.entity.TprojectGroup;
import com.hopsun.tppas.entity.TprojectReportTemplate;
import com.hopsun.tppas.entity.TprojectSupervisionTemplate;
import com.hopsun.tppas.entity.TprojectType;

/**
 * @comment 模板配置
 * @author liush
 * @DATE: 2013-8-29 @TIME: 上午9:49:55
 * @Vsersion: 1.0
 */
public class TprojectTypeAction extends BaseAction{
	public final static Logger LOGGER = Logger.getLogger(TprojectContractTemplateAction.class.getName());
	private static final long serialVersionUID = -8932925742940471767L;
	@Resource
	private TprojectTypeService tprojectTypeService;
	@Resource
	private TprojectAcceptanceTemplateService tprojectAcceptanceTemplate;
	@Resource
	private TprojectContractTemplateService tprojectContractTemplateService;
	@Resource
	private TprojectReportTemplateService tprojectReportTemplateService;
	@Resource
	private TprojectSupervisionTemplateService tprojectSupervisionTemplateService;
	@Resource
	private TprojectGroupService tprojectGroupService;
	@Resource
	private DeptService deptService;
	@Resource
	private MitemService mitemService;
	private List<ScDept> typeLst;
	private List<ScDept> type1List;
	private List<TprojectType> type2List;
	private String departmentId;
	private String isShow;
	private String realName;
	private String showName;
	private String retMsg;
	private String retUrl;
	private String typeId;
	private String typeId1;
	private String typeId2;
	private int pageNo;
	/** 下拉列表父级Id */
	private String pitemId;
	/** 下拉列表返回字符串 */
	private String backStr;
	private List<TprojectAcceptanceTemplate> acceptanceList;
	private List<TprojectContractTemplate> contractList;
	private List<TprojectReportTemplate> reportList;
	private List<TprojectSupervisionTemplate> supervisionList;
	private List<TprojectType> tprojectTypeList;
	private TprojectType tprojectType;
	private TprojectGroup tprojectGroup;
	private List<Mitem> timeList;
	  
	/**
	 * @Comments 列表初始化
	 * @return
	 * @Vsersion: 1.0
	 */
	public String list(){
		HttpSession session = this.getRequest().getSession();
		session.setAttribute(Constants.SESSION_CMDKEY, "typeModel_list");
		setPager(new Pager());
		pager = new Pager();
		
		// 翻页判断
    	if (this.getPageNo() != 0) {
    		pager.setPageNumber(this.getPageNo());
    	}
		pager = tprojectTypeService.find(realName,showName,departmentId,isShow,pager.getPageNumber(), pager.getPageSize());		
		return "list";
	}
	
	/**
	 * 跳转到添加页面
	 * @return String
	 */
	public String insert(){
		HttpSession session = this.getRequest().getSession();
		String cmdkey = (String) session.getAttribute(Constants.SESSION_CMDKEY);
		//判断令牌
		if (cmdkey == null
				|| !"typeModel_list".equals(cmdkey)) {
			LOGGER.error("令牌不正确");
			return "LogOut";
		}
		type1List = new ArrayList<ScDept>();
		type2List = new ArrayList<TprojectType>();
		
		ScDept dept = new ScDept();
		// lsh xiugai
		//dept.setDeptId(Constants.PLANNING_DEPARTMENT);
		dept.setDeptId("");
		type1List = deptService.findDept(dept);
		reportList = tprojectReportTemplateService.getList("deleteFlag", "0");
		contractList = tprojectContractTemplateService.getList("deleteFlag", "0");
		supervisionList = tprojectSupervisionTemplateService.getList("deleteFlag", "0");
		acceptanceList = tprojectAcceptanceTemplate.getList("deleteFlag", "0");
		tprojectTypeList = tprojectTypeService.getListExceptId(typeId);	
		timeList = mitemService.getListByTypeId(Constants.TYPE_TIME_AREA);
		// 判断是否为修正页面跳转
		if (CommonTool.IsNotEmpty(typeId)) {
			tprojectType = tprojectTypeService.get(typeId);
			typeId1 = tprojectType.getDepartmentId();
			// 判断是否有级联
			if (typeId1 != null && !"".equals(typeId1)) {
				type2List = tprojectTypeService.getListByIdAndDepartId(typeId1,typeId);
			}
		}
		return "insert";
	}
	
	/**
	 * @Comments 删除该信息
	 * @return
	 * @Vsersion: 1.0
	 */
	public String delete(){
		HttpSession session = this.getRequest().getSession();
		String cmdkey = (String) session.getAttribute(Constants.SESSION_CMDKEY);
		//判断令牌
		if (cmdkey == null
				|| !"typeModel_list".equals(cmdkey)) {
			LOGGER.error("令牌不正确");
			return "LogOut";
		}
		tprojectType = tprojectTypeService.get(typeId);
		tprojectType.setDeleteFlag("1");
		tprojectTypeService.update(tprojectType);
		//更新项目分类缓存
		tprojectTypeService.evict(tprojectType);
		tprojectTypeService.addProjectTypeCache(tprojectType.getTypeId(), "delete");
		
//		// 项目分组修改数据
//		if (CommonTool.IsEmpty(tprojectType.getParentTypeId())) {
//			tprojectGroup = tprojectGroupService.get("remark", tprojectType.getTypeId());
//			if (tprojectGroup != null) {
//				tprojectGroup.setDeleteFlag("0");
//				tprojectGroupService.update(tprojectGroup);
//			}
//		}
		this.setRetMsg(this.getText("opt_del_suc"));
		this.setRetUrl(super.getRequest().getContextPath()
				+ "/api/superadmin/typeModel!init.action?dd="
				+ new Date().getTime());
		return "systemInfoMain";		
	}
	
	/**
	 * 跳转到修改页面
	 * @return String
	 */
	public String modify(){
		HttpSession session = this.getRequest().getSession();
		String cmdkey = (String) session.getAttribute(Constants.SESSION_CMDKEY);
		ScUsers user = (ScUsers) session.getAttribute("sysUser");
		//判断令牌
		if (cmdkey == null
				|| !"typeModel_list".equals(cmdkey)) {
			LOGGER.error("令牌不正确");
			return "LogOut";
		}
		tprojectType.setDeleteFlag("0");
		tprojectType.setUpdateDate(new java.sql.Timestamp(new Date().getTime()));
		tprojectType.setUpdateUser(user.getUserName());
		
		// 判断修改还是增加
		if (CommonTool.IsEmpty(typeId)) {
			tprojectType.setTypeId(null);
			tprojectType.setCreateTime(new java.sql.Timestamp(new Date().getTime()));
			tprojectType.setCreateUser(user.getUserName());
			tprojectTypeService.save(tprojectType);
			//更新项目分类缓存
			tprojectTypeService.evict(tprojectType);
			tprojectTypeService.addProjectTypeCache(tprojectType.getTypeId(),"save");
			
//			// 项目分组新增数据
//			if (CommonTool.IsEmpty(tprojectType.getParentTypeId())) {
//				tprojectGroup = new TprojectGroup();
//				tprojectGroup.setDepartmentId(tprojectType.getDepartmentId());
//				tprojectGroup.setCreateTime(new java.sql.Timestamp(new Date().getTime()));
//				tprojectGroup.setGroupName(tprojectType.getTypeShowName());
//				tprojectGroup.setRemark(tprojectType.getTypeId());
//				tprojectGroup.setDeleteFlag("0");
//				tprojectGroupService.save(tprojectGroup);
//			}
			this.setRetMsg(this.getText("opt_save_suc"));
		} else {
			tprojectType.setTypeId(typeId);
			tprojectTypeService.update(tprojectType);
			//更新项目分类缓存
			tprojectTypeService.evict(tprojectType);
			tprojectTypeService.addProjectTypeCache(tprojectType.getTypeId(),"update");
			
//			// 项目分组修改数据
//			if (CommonTool.IsEmpty(tprojectType.getParentTypeId())) {
//				tprojectGroup = tprojectGroupService.get("remark", tprojectType.getTypeId());
//				if (tprojectGroup != null) {
//					tprojectGroup.setGroupName(tprojectType.getTypeShowName());
//					tprojectGroupService.update(tprojectGroup);
//				}
//			}
			
			this.setRetMsg(this.getText("opt_update_suc"));
		}


		this.setRetUrl(super.getRequest().getContextPath()
				+ "/api/superadmin/typeModel!init.action?dd="
				+ new Date().getTime());
		return "systemInfoMain";	

	}
	
	/**
	 * @Comments 页面初始化
	 * @return
	 * @Vsersion: 1.0
	 */
	public String init(){
		ScDept dept = new ScDept();
		// lsh xiugai
		//dept.setDeptId(Constants.PLANNING_DEPARTMENT);
		dept.setDeptId("");
		typeLst = deptService.findDept(dept);
		return "init";
	}

	/**
	 * @comments 项目分类下拉列表联动--部门选择
	 * @return
	 * @version 1.0
	 */
	public String getFatherTypeListData() throws Exception {
		try {
			// 取得联动下拉列表数据List
			List<TprojectType> dataList = tprojectTypeService.getFatherProjectTypeListByDeptId(pitemId);
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
		} catch (Exception e) {
			return "error";
		}
	}
	
	/**
	 * @comments 项目分类下拉列表联动--项目分类1选择
	 * @return
	 * @version 1.0
	 */
	public String getSonTypeListData() throws Exception {
		try {
			// 取得联动下拉列表数据List
			List<TprojectType> dataList = tprojectTypeService.getSonProjectTypeListByDeptId(pitemId);
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
		} catch (Exception e) {
			return "error";
		}
	}
	
	public TprojectTypeService getTprojectTypeService() {
		return tprojectTypeService;
	}

	public void setTprojectTypeService(TprojectTypeService tprojectTypeService) {
		this.tprojectTypeService = tprojectTypeService;
	}

	public MitemService getMitemService() {
		return mitemService;
	}

	public void setMitemService(MitemService mitemService) {
		this.mitemService = mitemService;
	}

	public String getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(String hiddendepartmentId) {
		this.departmentId = hiddendepartmentId;
	}

	public String getIsShow() {
		return isShow;
	}

	public void setIsShow(String hiddenisShow) {
		this.isShow = hiddenisShow;
	}

	public String getRealName() {
		return realName;
	}

	public void setRealName(String realName) {
		this.realName = realName;
	}

	public String getShowName() {
		return showName;
	}

	public void setShowName(String showName) {
		this.showName = showName;
	}

	public String getRetMsg() {
		return retMsg;
	}

	public void setRetMsg(String retMsg) {
		this.retMsg = retMsg;
	}

	public String getRetUrl() {
		return retUrl;
	}

	public void setRetUrl(String retUrl) {
		this.retUrl = retUrl;
	}

	public int getPageNo() {
		return pageNo;
	}

	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}

	public TprojectAcceptanceTemplateService getTprojectAcceptanceTemplate() {
		return tprojectAcceptanceTemplate;
	}

	public void setTprojectAcceptanceTemplate(
			TprojectAcceptanceTemplateService tprojectAcceptanceTemplate) {
		this.tprojectAcceptanceTemplate = tprojectAcceptanceTemplate;
	}

	public TprojectContractTemplateService getTprojectContractTemplateService() {
		return tprojectContractTemplateService;
	}

	public void setTprojectContractTemplateService(
			TprojectContractTemplateService tprojectContractTemplateService) {
		this.tprojectContractTemplateService = tprojectContractTemplateService;
	}

	public TprojectReportTemplateService getTprojectReportTemplateService() {
		return tprojectReportTemplateService;
	}

	public void setTprojectReportTemplateService(
			TprojectReportTemplateService tprojectReportTemplateService) {
		this.tprojectReportTemplateService = tprojectReportTemplateService;
	}

	public TprojectSupervisionTemplateService getTprojectSupervisionTemplateService() {
		return tprojectSupervisionTemplateService;
	}

	public void setTprojectSupervisionTemplateService(
			TprojectSupervisionTemplateService tprojectSupervisionTemplateService) {
		this.tprojectSupervisionTemplateService = tprojectSupervisionTemplateService;
	}

	public List<TprojectAcceptanceTemplate> getAcceptanceList() {
		return acceptanceList;
	}

	public void setAcceptanceList(List<TprojectAcceptanceTemplate> acceptanceList) {
		this.acceptanceList = acceptanceList;
	}

	public List<TprojectContractTemplate> getContractList() {
		return contractList;
	}

	public void setContractList(List<TprojectContractTemplate> contractList) {
		this.contractList = contractList;
	}

	public List<TprojectReportTemplate> getReportList() {
		return reportList;
	}

	public void setReportList(List<TprojectReportTemplate> reportList) {
		this.reportList = reportList;
	}

	public List<TprojectSupervisionTemplate> getSupervisionList() {
		return supervisionList;
	}

	public void setSupervisionList(List<TprojectSupervisionTemplate> supervisionList) {
		this.supervisionList = supervisionList;
	}

	public List<TprojectType> getTprojectTypeList() {
		return tprojectTypeList;
	}

	public void setTprojectTypeList(List<TprojectType> tprojectTypeList) {
		this.tprojectTypeList = tprojectTypeList;
	}

	public TprojectType getTprojectType() {
		return tprojectType;
	}

	public void setTprojectType(TprojectType tprojectType) {
		this.tprojectType = tprojectType;
	}

	public String getTypeId() {
		return typeId;
	}

	public void setTypeId(String typeId) {
		this.typeId = typeId;
	}

	public DeptService getDeptService() {
		return deptService;
	}

	public void setDeptService(DeptService deptService) {
		this.deptService = deptService;
	}

	public List<ScDept> getTypeLst() {
		return typeLst;
	}

	public void setTypeLst(List<ScDept> typeLst) {
		this.typeLst = typeLst;
	}

	/**
	 * @return the pitemId
	 */
	public String getPitemId() {
		return pitemId;
	}

	/**
	 * @param pitemId the pitemId to set
	 */
	public void setPitemId(String pitemId) {
		this.pitemId = pitemId;
	}

	/**
	 * @return the backStr
	 */
	public String getBackStr() {
		return backStr;
	}

	/**
	 * @param backStr the backStr to set
	 */
	public void setBackStr(String backStr) {
		this.backStr = backStr;
	}

	public TprojectGroupService getTprojectGroupService() {
		return tprojectGroupService;
	}

	public void setTprojectGroupService(TprojectGroupService tprojectGroupService) {
		this.tprojectGroupService = tprojectGroupService;
	}

	public TprojectGroup getTprojectGroup() {
		return tprojectGroup;
	}

	public void setTprojectGroup(TprojectGroup tprojectGroup) {
		this.tprojectGroup = tprojectGroup;
	}

	public List<ScDept> getType1List() {
		return type1List;
	}

	public void setType1List(List<ScDept> type1List) {
		this.type1List = type1List;
	}

	public List<TprojectType> getType2List() {
		return type2List;
	}

	public void setType2List(List<TprojectType> type2List) {
		this.type2List = type2List;
	}

	public String getTypeId1() {
		return typeId1;
	}

	public void setTypeId1(String typeId1) {
		this.typeId1 = typeId1;
	}

	public String getTypeId2() {
		return typeId2;
	}

	public void setTypeId2(String typeId2) {
		this.typeId2 = typeId2;
	}

	public List<Mitem> getTimeList() {
		return timeList;
	}

	public void setTimeList(List<Mitem> timeList) {
		this.timeList = timeList;
	}

}
