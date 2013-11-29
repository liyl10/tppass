/*************** 版权声明***************
 *
 * Copyright (C) 2012 西安辉盛科技发展有限责任公司.
 *
 ********************************************
 */
package com.hopsun.tppas.api.report.action;

import java.io.File;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jxl.Workbook;
import jxl.WorkbookSettings;
import jxl.format.Alignment;
import jxl.format.Border;
import jxl.format.BorderLineStyle;
import jxl.format.Colour;
import jxl.format.VerticalAlignment;
import jxl.write.Label;
import jxl.write.NumberFormat;
import jxl.write.WritableCellFormat;
import jxl.write.WritableFont;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;

import com.hopsun.framework.base.action.BaseAction;
import com.hopsun.framework.base.bean.Pager;
import com.hopsun.scenter.entity.ScUsers;
import com.hopsun.tppas.api.report.service.TprojectApplicationService;
import com.hopsun.tppas.api.report.service.TprojectInfoAService;
import com.hopsun.tppas.api.report.service.TprojectInfoBService;
import com.hopsun.tppas.api.superadmin.service.MitemService;
import com.hopsun.tppas.api.superadmin.service.TattachmentService;
import com.hopsun.tppas.api.superadmin.service.TprojectTypeService;
import com.hopsun.tppas.common.Constants;
import com.hopsun.tppas.entity.Mitem;
import com.hopsun.tppas.entity.TprojectApplication;
import com.hopsun.tppas.entity.TprojectInfoA;
import com.hopsun.tppas.entity.TprojectInfoB;
import com.hopsun.tppas.entity.TprojectType;

/**
 * @comment 项目申报
 * @author liush
 * @DATE: 2013-8-28 @TIME: 下午2:42:40
 * @Vsersion: 1.0
 */
public class TprojectApplicationAction extends BaseAction {
	public final static Logger logger = Logger.getLogger(TprojectApplicationAction.class.getName());
	private static final long serialVersionUID = -1979934962468943400L;
	@Resource
	private TprojectApplicationService tprojectApplicationService;
	@Resource
	private MitemService mitemService;
	@Resource
	private TprojectInfoBService tprojectInfoBService;
	@Resource
	private TprojectTypeService tprojectTypeService;
	/** 附件上传service */
	@Resource
	private TattachmentService tattachmentService;
	@Resource
	private TprojectInfoAService tprojectInfoAService;
	// 翻页
	private int pageNo;
	/** 跳转路径 */
	private String retUrl;
	/** 跳转页面massage */
	private String retMsg;
	/** 项目ID */
	private String projectId;
	/** 临时项目申报书备注 */
	private String projectReportText;
	/** 临时项目申报书时间 */
	private String projectReportTime;
	/** 小分类id */
	private String projectTypeId;
	/** 计划类别ID */
	private String projectPaTypeId;
	/** 项目基本信息（非高新） */
	private TprojectInfoB tprojectInfoB;
	/** 项目基本信息（非高新） */
	private TprojectInfoA tprojectInfoA;
	/** 项目申报 */
	private TprojectApplication tprojectApplication;
	/** 项目申报菜单（非高新） */
	private List<Mitem> reportNonTechMenuList;
	/** 支持方式 */
	private List<Mitem> supportfunctionList;
	/** 支持类别 */
	private List<Mitem> supportFlagList;
	/** 归口管理部门 */
	private List<Mitem> centralizedBranchList;
	/** 菜单List */
	private List<Mitem> menuList;
	/** 计划类别名称 */
	private String projectPaTypeName;
	/** 项目分类名称 */
	private String projectTypeName;
	/** 表名 */
	private String tableName;
	/** 是高新还是非高新的 */
	private String highOrOtherFlag;
	// weina start

	/** 项目分类id */
	private String typeId;
	/** 项目名称 */
	private String projectName;
	/** 申报单位 */
	private String applicationUnit;
	/** 归档状态list */
	private List<String> archivalStatusList;
	/** 归档状态 */
	private String isArchival;
	/** 技术领域 */
	private String technicalFisld;
	/** 项目状态 */
	private String applyStatus;
	/** 计划类别 */
	private List<TprojectType> projectTypeList1;
	/** 项目分类 */
	private List<TprojectType> projectTypeList2;
	/** 计划类别 */
	private String projectType1;
	/** 项目分类 */
	private String projectType2;
	/** 项目IDList */
	private String projectIdList;
	/** 显示类型 */
	private String projectViewType;
	/** 显示类型list */
	private List<Mitem> projectViewTypeList;
	/** 项目总数 */
	private String projectTotal;
	/** 未初审项目数 */
	private String noViewProjectTotal;
	/** 未通过项目数 */
	private String noPassProject;
	/** 已通过初审未验收项目数 */
	private String noAcceptanceProject;
	/** 已通过已验收项目数 */
	private String passAcceptanceProject;
	/** 申报年度 */
	private String reportYear;
	/** 项目评审通过率统计开始时间 */
	private String projectViewTypeStartTime;
	/** 项目评审通过率统计结束时间 */
	private String projectViewTypeEndTime;
	/** 返回数据list */
	private List<TprojectApplication> projectList;
	/** 判断查询条件的开始年度和结束年度是否相等 */
	private String yearEquals;

	/**
	 * 
	 * @comments 归档管理查询条件
	 * @return
	 * @version 1.0
	 */
	public String showArchivalManage() {
		// 取得登录用户的信息
		HttpSession session = this.getRequest().getSession();
		// session.setAttribute(Constants.SESSION_CMDKEY, "showArchivalManage");

		ScUsers user = (ScUsers) session.getAttribute("sysUser");
		// 如果用户为空或者企业为空，退出系统
		if (user == null || ("").equals(user.getUserId())) {
			return "LogOut";
		}
		// 归档状态
		this.archivalStatusList = new ArrayList<String>();
		this.archivalStatusList.add("未归档");
		this.archivalStatusList.add("已归档");

		/*
		 * // 初始化计划类别 this.projectTypeList1 = new ArrayList<TprojectType>();
		 * this.projectTypeList1 =
		 * tprojectTypeService.getFatherProjectTypeListByDeptId(
		 * user.getScDept().getDeptId());
		 */
		// 计划类别
		String deptId = user.getScDept().getDeptId();
		// 部门id为计财处的时候，显示所有的计划类别
		// 非计财处的时候，只显示本部门的计划类别
		if (Constants.PLANNING_DEPARTMENT.equals(deptId)) {
			this.projectTypeList1 = tprojectTypeService.getListExceptId(null);
		} else {
			this.projectTypeList1 = tprojectTypeService.getFatherProjectTypeListByDeptId(deptId);
		}
		// 初始化项目分类
		this.projectTypeList2 = new ArrayList<TprojectType>();

		return "showArchivalManage";

	}

	/**
	 * @comments 显示说明须知页面
	 * @return
	 * @Version 1.0
	 */
	public String showReportNotice() {

		// 取得登录用户的信息
		HttpSession session = this.getRequest().getSession();
		// session.setAttribute(Constants.SESSION_CMDKEY, "showReportNotice");

		ScUsers user = (ScUsers) session.getAttribute("sysUser");
		// 如果用户为空或者企业为空，退出系统
		if (user == null || ("").equals(user.getUserId())) {
			return "LogOut";
		}
		return "showReportNotice";
	}

	/**
	 * 
	 * @comments 归档管理列表
	 * @return
	 * @version 1.0
	 */
	public String getArchivalList() {
		// 取得登录用户的信息
		HttpSession session = this.getRequest().getSession();
		// String cmdkey =
		// (String)session.getAttribute(Constants.SESSION_CMDKEY);

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
		// 项目id
		param.put("projectId", projectId);
		// 项目名称
		param.put("projectName", projectName);

		// 申报单位
		param.put("applicationUnit", applicationUnit);

		// 归档状态
		param.put("isArchival", isArchival);

		// 计划类别
		param.put("projectType1", projectType1);

		// 项目分类
		param.put("projectType2", projectType2);

		// 取得项目一览信息
		pager = tprojectApplicationService.getArchivalList(param, pager.getPageNumber(), pager.getPageSize());

		return "getarchivallist";

	}

	/**
	 * 
	 * @comments 改变归档状态
	 * @return
	 * @version 1.0
	 */
	public String archivalReportList() {
		// 取得登录用户的信息
		HttpSession session = this.getRequest().getSession();
		// String cmdkey =
		// (String)session.getAttribute(Constants.SESSION_CMDKEY);

		ScUsers user = (ScUsers) session.getAttribute("sysUser");
		// 如果用户为空或者企业为空，退出系统
		if (user == null || ("").equals(user.getUserId())) {
			return "LogOut";
		}
		// 封装条件
		Map<String, Object> param = new HashMap<String, Object>();
		// 项目ID
		param.put("projectIdList", projectIdList);
		// 归档状态-已归档
		param.put("isArchival", "已归档");
		// 更新用户
		param.put("updateUser", user.getUserId());

		tprojectApplicationService.updatearchivalStateByList(param);

		this.setRetMsg(this.getText("opt_save_suc"));
		this.setRetUrl(super.getRequest().getContextPath() + "/api/report/tprojectApplicationAction!showArchivalManage.action?now=" + new Date().getTime());

		return "systemInfoMain";
	}

	/**
	 * 
	 * @comments 项目评审通过率统计查询条件
	 * @return
	 * @version 1.0
	 */
	public String showProjectViewManage() {
		// 取得登录用户的信息
		HttpSession session = this.getRequest().getSession();
		// session.setAttribute(Constants.SESSION_CMDKEY,
		// "showProjectViewManage");

		ScUsers user = (ScUsers) session.getAttribute("sysUser");
		// 如果用户为空或者企业为空，退出系统
		if (user == null || ("").equals(user.getUserId())) {
			return "LogOut";
		}
		// 显示类型list
		this.projectViewTypeList = new ArrayList<Mitem>();
		// 初始化显示类型
		this.projectViewTypeList = mitemService.getListByTypeId(Constants.PROJECT_VIEW_TYPE_STATE);

		return "showprojectviewmanage";

	}

	/**
	 * 
	 * @comments 项目评审通过率统计列表
	 * @return
	 * @version 1.0
	 */
	public String getProjectViewList() {

		// 取得登录用户的信息
		HttpSession session = this.getRequest().getSession();
		// String cmdkey =
		// (String)session.getAttribute(Constants.SESSION_CMDKEY);

		ScUsers user = (ScUsers) session.getAttribute("sysUser");
		// 如果用户为空或者企业为空，退出系统
		if (user == null || ("").equals(user.getUserId())) {
			return "LogOut";
		}

		Map<String, Object> param = new HashMap<String, Object>();

		// 封装查询条件

		// 项目评审通过率统计开始时间
		param.put("projectViewTypeStartTime", projectViewTypeStartTime);
		// 项目评审通过率统计结束时间
		param.put("projectViewTypeEndTime", projectViewTypeEndTime);
		/*
		 * // 显示类型 param.put("projectViewType", projectViewType);
		 */
		// 设置查询条件
		session.setAttribute("SearchParam", param);
		// 取得项目一览信息
		projectList = tprojectApplicationService.getProjectViewList(param);
		// 查询的开始年度=结束年度。用饼图统计。开始年度 ！= 结束年度，用柱图统计
		if (projectViewTypeStartTime != null && !"".equals(projectViewTypeStartTime)) {
			if (projectViewTypeEndTime != null && !"".equals(projectViewTypeEndTime)) {
				if (projectViewTypeStartTime.equals(projectViewTypeEndTime)) {
					this.yearEquals = "1";
				}

			}

		}
		/*
		 * pager = tprojectApplicationService.getProjectViewList( param,
		 * pager.getPageNumber(), pager.getPageSize());
		 */
		return "projectviewlist";

	}

	/**
	 * @throws Exception
	 * @comments 打印统计结果
	 * @Version 1.0
	 */
	@SuppressWarnings("unchecked")
	public void exportDatas() throws Exception {

		HttpSession session = this.getRequest().getSession();
		// String cmdStr = (String)
		// session.getAttribute(Constants.SESSION_CMDKEY);
		ScUsers user = (ScUsers) session.getAttribute("sysUser");
		// 如果用户为空或者企业为空，退出系统
		if (user == null || ("").equals(user.getUserId())) {
			return;
		}

		// 取得文件名称
		String excelFileName = this.getText(Constants.PROJECT_PASS_NAME);

		// 取得查询条件
		Map<String, Object> params = (Map<String, Object>) session.getAttribute("SearchParam");

		// 取得打印数据
		List<TprojectApplication> projectList = tprojectApplicationService.getProjectViewList(params);
		// List<Texpert> expertList =
		// texpertService.getExpertExportList(params);

		this.createOutExcel(excelFileName, projectList);
	}

	/**
	 * @comments 生成excel
	 * @param excelFileName
	 * @param expertList
	 * @throws Exception
	 * @Version 1.0
	 */
	private void createOutExcel(String excelFileName, List<TprojectApplication> projectList) throws Exception {
		// response
		HttpServletResponse response = ServletActionContext.getResponse();
		// 清空输出流
		response.reset();

		// 设定输出文件头
		response.setHeader("Content-Disposition", "attachment; filename=\"" + new String(excelFileName.getBytes("GB2312"), "8859_1") + ".xls\"");

		// 定义输出类型
		response.setContentType("application/vnd.ms-excel");

		OutputStream out = null;
		// 取得输出流
		out = response.getOutputStream();
		// 工作簿从usr tppasc input中拷贝模板：项目评审通过率统计模板.xls 模板路径
		String modelInputPath = mitemService.get(Constants.PDF_TEMPLATE_PATH).getItemDesc();
		String len = modelInputPath.substring(modelInputPath.length() - 1, modelInputPath.length());
		// 判断目录是否完整
		if (!"/".equals(len)) {
			modelInputPath = modelInputPath + "/";
		}
		// 模板的名字
		File fileModel = new File(modelInputPath + Constants.REPORT_PASS_FILENAME);

		try {
			Workbook wk = Workbook.getWorkbook(fileModel);
			WorkbookSettings settings = new WorkbookSettings();
			settings.setWriteAccess(null);

			WritableWorkbook outWorkBook = Workbook.createWorkbook(out, wk);
			// 设置sheet的名称
			outWorkBook.getSheets()[0].setName(excelFileName);

			// 单元格边框格式
			WritableCellFormat cf = new WritableCellFormat();
			// 设置边框
			cf.setBorder(Border.ALL, BorderLineStyle.THIN);
			// 垂直居中显示
			cf.setVerticalAlignment(VerticalAlignment.CENTRE);
			WritableFont wf2 = new WritableFont(WritableFont.createFont("宋体"), 10, WritableFont.NO_BOLD, false);
			cf.setFont(wf2);
			// 换行显示
			cf.setWrap(true);

			// 表头格式
			WritableCellFormat headerCf = new WritableCellFormat();
			// 设置边框
			headerCf.setBorder(Border.ALL, BorderLineStyle.THIN);
			// 垂直居中显示
			headerCf.setVerticalAlignment(VerticalAlignment.CENTRE);
			headerCf.setBackground(Colour.ICE_BLUE);
			// 设置自动换行
			headerCf.setWrap(true);
			headerCf.setFont(wf2);
			// 水平居中显示
			headerCf.setAlignment(Alignment.CENTRE);

			// 整数格式
			NumberFormat nf = new NumberFormat("0");
			WritableCellFormat numberCf = new WritableCellFormat(nf);
			// 设置边框
			numberCf.setBorder(Border.ALL, BorderLineStyle.THIN);
			// 垂直居中显示
			numberCf.setVerticalAlignment(VerticalAlignment.CENTRE);
			// 水平居中显示
			numberCf.setAlignment(Alignment.RIGHT);
			// 设置字体
			numberCf.setFont(wf2);

			/*
			 * // 计划类别名称格式 WritableCellFormat typeCf = new WritableCellFormat();
			 * // 设置边框 typeCf.setBorder(Border.ALL, BorderLineStyle.THIN); //
			 * 垂直居中显示 typeCf.setVerticalAlignment(VerticalAlignment.CENTRE); //
			 * 水平居中显示 typeCf.setAlignment(Alignment.CENTRE); // 设置字体
			 * WritableFont wf3 = new
			 * WritableFont(WritableFont.createFont("宋体"), 10,
			 * WritableFont.NO_BOLD, false); typeCf.setFont(wf3);
			 */

			WritableSheet sh = outWorkBook.getSheet(0);

			sh.addCell(new Label(0, 0, "序号", headerCf));
			sh.addCell(new Label(1, 0, "年度", headerCf));
			sh.addCell(new Label(2, 0, "项目总数", headerCf));
			sh.addCell(new Label(3, 0, "未初审项目数量", headerCf));
			sh.addCell(new Label(4, 0, "未通过项目数量", headerCf));
			sh.addCell(new Label(5, 0, "已通过初审未验项目数量", headerCf));
			sh.addCell(new Label(6, 0, "已通过已验收项目数量", headerCf));

			for (int i = 0; i < projectList.size(); i++) {
				TprojectApplication tp = projectList.get(i);

				sh.addCell(new Label(0, i + 1, String.valueOf(i + 1), numberCf));
				sh.addCell(new Label(1, i + 1, tp.getReportYear(), numberCf));
				sh.addCell(new Label(2, i + 1, tp.getProjectTotal(), numberCf));
				sh.addCell(new Label(3, i + 1, tp.getNoViewProjectTotal(), numberCf));
				sh.addCell(new Label(4, i + 1, tp.getNoPassProject(), numberCf));
				sh.addCell(new Label(5, i + 1, tp.getNoAcceptanceProject(), numberCf));
				sh.addCell(new Label(6, i + 1, tp.getPassAcceptanceProject(), numberCf));
			}

			// ===========写入数据 end===========

			outWorkBook.write();
			out.flush();
			outWorkBook.close();
			wk.close();
			response.flushBuffer();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// weina end

	/**
	 * @comments 初始化非高新菜单
	 * @return
	 * @Version 1.0
	 */
	public String showNonTechManage() {

		// 初始化申报菜单
		this.reportNonTechMenuList = new ArrayList<Mitem>();

		// 取得申报菜单数据
		if (tprojectTypeService.getIsWrite(projectId)) {
			this.reportNonTechMenuList = mitemService.getListByTypeId(Constants.API_REPORT_NONTECT_MENU_TYPE);
		} else {
			this.reportNonTechMenuList = mitemService.getListByTypeId(Constants.API_REPORT_NONTECT_MENU_TYPE, Constants.API_REPORT_NONTECT_MENU_16);
		}

		return "showNonTechManage";
	}

	/**
	 * @comments 显示非高新封皮页面
	 * @return
	 * @Version 1.0
	 */
	public String showUpdateNonTechCover() {

		// 取得登录用户的信息
		HttpSession session = this.getRequest().getSession();
		// 取得登录用户的信息
		ScUsers user = (ScUsers) session.getAttribute("sysUser");
		// session.setAttribute(Constants.SESSION_CMDKEY,
		// "showUpdateNonTechCover");
		// 判断是否失效
		if (user == null || ("").equals(user.getUserId())) {
			logger.error("用户不存在！");
			return "LogOut";
		}

		// 取得项目申报信息
		tprojectApplication = tprojectApplicationService.get(this.projectId);

		// 取得项目申报基本信息
		tprojectInfoB = tprojectInfoBService.get("tprojectApplication.projectId", projectId);

		// 计划类别
		this.projectPaTypeName = tprojectTypeService.getProjectTypeName(tprojectApplication.getPlanFlag());

		this.projectTypeName = tprojectTypeService.getProjectTypeShowName(tprojectApplication.getTprojectType().getTypeId());

		// 取得归口管理部门
		this.centralizedBranchList = new ArrayList<Mitem>();

		this.centralizedBranchList = mitemService.getListByTypeId(Constants.TYPE_CENTRALIZED_TYPE);

		return "showUpdateNonTechCover";
	}

	/**
	 * @comments 显示说明须知页面
	 * @return
	 * @Version 1.0
	 */
	public String showReportNonTechKnow() {
		// 取得登录用户的信息
		HttpSession session = this.getRequest().getSession();
		// 取得登录用户的信息
		ScUsers user = (ScUsers) session.getAttribute("sysUser");
		// session.setAttribute(Constants.SESSION_CMDKEY,
		// "showReportNonTechKnow");
		// 判断是否失效
		if (user == null || ("").equals(user.getUserId())) {
			logger.error("用户不存在！");
			return "LogOut";
		}
		// 取得项目Id
		this.projectId = this.getProjectId();
		return "showReportNonTechKnow";
	}

	/**
	 * 
	 * @comments 高新处项目申报页面初始化
	 * @return
	 * @throws Exception
	 * @version 1.0
	 */
	public String showUpdateHighTechProject() throws Exception {
		// 取得登录用户的信息
		HttpSession session = this.getRequest().getSession();
		// 取得登录用户的信息
		ScUsers user = (ScUsers) session.getAttribute("sysUser");
		// session.setAttribute(Constants.SESSION_CMDKEY,
		// "showUpdateHighTechProject");
		// 判断是否失效
		if (user == null || ("").equals(user.getUserId())) {
			logger.error("用户不存在！");
			return "LogOut";
		}
		// Radio数据准备
		radioAndCheckDataPrepare();
		tprojectApplication = tprojectApplicationService.get(this.projectId);
		// 取得项目基本信息
		this.tprojectInfoA = tprojectInfoAService.get("tprojectApplication.projectId", projectId);

		// 计划类别
		this.projectPaTypeName = tprojectTypeService.getProjectTypeName(tprojectApplication.getPlanFlag());

		this.projectTypeName = tprojectTypeService.getProjectTypeShowName(tprojectApplication.getTprojectType().getTypeId());
		// 归口
		this.centralizedBranchList = new ArrayList<Mitem>();

		if (tprojectTypeService.getIsWrite(projectId)) {
			// 菜单列表
			this.menuList = mitemService.getListByTypeId(Constants.API_PROJECT_REPORT_MENU_TYPE);
		} else {
			// 菜单列表
			this.menuList = mitemService.getListByTypeId(Constants.API_PROJECT_REPORT_MENU_TYPE, Constants.API_PROJECT_REPORT_MENU_15);
		}

		return "showhightech";
	}

	/**
	 * 
	 * @comments Radio数据准备
	 * @throws Exception
	 * @version 1.0
	 */
	public void radioAndCheckDataPrepare() throws Exception {
		/** 支持方式radio作成 */
		this.supportfunctionList = mitemService.getListByTypeId(Constants.SUPPORT_FUNCTION);
		this.setSupportfunctionList(this.supportfunctionList);
		/** 支持类别radio作成 */
		this.supportFlagList = mitemService.getListByTypeId(Constants.TYPE_PROJECT_TYPE);
		this.setSupportFlagList(this.supportFlagList);
	}

	/**
	 * 
	 * @comments 列表画面到申报详细画面
	 * @return
	 * @throws Exception
	 * @version 1.0
	 */
	public String showUpdateHighTech() throws Exception {
		// 取得登录用户的信息
		HttpSession session = this.getRequest().getSession();
		// 取得登录用户的信息
		ScUsers user = (ScUsers) session.getAttribute("sysUser");
		// session.setAttribute(Constants.SESSION_CMDKEY, "showUpdateHighTech");
		// 判断是否失效
		if (user == null || ("").equals(user.getUserId())) {
			logger.error("用户不存在！");
			return "LogOut";
		}
		radioAndCheckDataPrepare();
		tprojectApplication = tprojectApplicationService.getprojectReport();
		this.projectReportText = tprojectApplication.getProjectReportText();
		this.projectReportTime = tprojectApplication.getProjectReportTime();

		// 归口部门
		this.centralizedBranchList = new ArrayList<Mitem>();
		this.projectId = this.getProjectId();
		this.tprojectApplication = tprojectApplicationService.get(projectId);
		if(tprojectApplication != null){
			// 项目分类Id
			this.projectTypeId = tprojectApplication.getTprojectType().getTypeId();
			// 计划类别
			this.projectPaTypeId = tprojectApplication.getPlanFlag();
			// 计划类别名字
			this.projectPaTypeName = tprojectTypeService.getProjectTypeName(tprojectApplication.getPlanFlag());
	
			// 取得项目基本信息
			this.tprojectInfoA = tprojectInfoAService.get("tprojectApplication.projectId", projectId);
	
			this.projectTypeName = tprojectTypeService.getProjectTypeShowName(tprojectApplication.getTprojectType().getTypeId());
			
			// 取得归口部门信息
			this.centralizedBranchList = mitemService.getListByTypeId(Constants.TYPE_CENTRALIZED_TYPE);
		}
		return "showtupdatehightech";
	}

	/**
	 * 
	 * @comments 附件列表
	 * @return
	 * @version 1.0
	 */
	public String showIndexList() {
		// 取得登录用户的信息
		HttpSession session = this.getRequest().getSession();
		ScUsers user = (ScUsers) session.getAttribute("sysUser");
		// session.setAttribute(Constants.SESSION_CMDKEY, "showIndexList");

		// 判断是否失效
		if (user == null || ("").equals(user.getUserId())) {
			logger.error("用户不存在！");
			return "LogOut";
		}
		// 设置分页参数
		if (pager == null && this.getPageNo() == 0) {
			pager = new Pager();
		} else {
			pager = new Pager();
			pager.setPageNumber(this.getPageNo());
		}

		// 取得项目ID
		this.projectId = this.getProjectId();

		// 取得表名
		this.tableName = tattachmentService.getTableName(TprojectApplication.class);
		// 取得附件一览信息
		pager = tattachmentService.find(tableName, projectId, pager.getPageNumber(), pager.getPageSize());
		highOrOther();
		return "showIndexList";
	}

	/**
	 * 
	 * @comments 判断是高新的还是非高新的申报
	 * @version 1.0
	 */
	public String highOrOther() {
		HttpSession session = this.getRequest().getSession();
		// 取得登录用户的信息
		ScUsers user = (ScUsers) session.getAttribute("sysUser");
		if (Constants.HIGHTECH_DEPARTMENT.equals(user.getScDept().getDeptId())) {
			this.highOrOtherFlag = "1";
		} else {
			this.highOrOtherFlag = "0";
		}
		return "highOrOtherFlag";
	}

	/**
	 * 
	 * @comments 取得项目须知画面的初始化
	 * @return
	 * @version 1.0
	 */
	public String showReportKnow() {

		return "showreportknow";
	}

	/**
	 * 
	 * @comments 取得项目流程表画面的初始化 (产业处)
	 * @return
	 * @version 1.0
	 */
	public String showReportFlow() {

		return "showReportFlow";
	}

	/**
	 * 
	 * @comments 取得项目流程表画面的初始化 (非产业处)
	 * @return
	 * @version 1.0
	 */
	public String showReportFlowOther() {

		return "showReportFlowOther";
	}

	// ===========================
	// ====此分割线以下为get/set方法
	// ===========================
	public int getPageNo() {
		return pageNo;
	}

	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}

	public TprojectApplicationService getTprojectApplicationService() {
		return tprojectApplicationService;
	}

	public void setTprojectApplicationService(TprojectApplicationService tprojectApplicationService) {
		this.tprojectApplicationService = tprojectApplicationService;
	}

	public MitemService getMitemService() {
		return mitemService;
	}

	public void setMitemService(MitemService mitemService) {
		this.mitemService = mitemService;
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

	public TprojectInfoB getTprojectInfoB() {
		return tprojectInfoB;
	}

	public void setTprojectInfoB(TprojectInfoB tprojectInfoB) {
		this.tprojectInfoB = tprojectInfoB;
	}

	public List<Mitem> getReportNonTechMenuList() {
		return reportNonTechMenuList;
	}

	public void setReportNonTechMenuList(List<Mitem> reportNonTechMenuList) {
		this.reportNonTechMenuList = reportNonTechMenuList;
	}

	/**
	 * @return the projectId
	 */
	public String getProjectId() {
		return projectId;
	}

	/**
	 * @param projectId
	 *            the projectId to set
	 */
	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}

	/**
	 * @return the projectReportText
	 */
	public String getProjectReportText() {
		return projectReportText;
	}

	/**
	 * @param projectReportText
	 *            the projectReportText to set
	 */
	public void setProjectReportText(String projectReportText) {
		this.projectReportText = projectReportText;
	}

	/**
	 * @return the projectReportTime
	 */
	public String getProjectReportTime() {
		return projectReportTime;
	}

	/**
	 * @param projectReportTime
	 *            the projectReportTime to set
	 */
	public void setProjectReportTime(String projectReportTime) {
		this.projectReportTime = projectReportTime;
	}

	/**
	 * @return the tprojectApplication
	 */
	public TprojectApplication getTprojectApplication() {
		return tprojectApplication;
	}

	/**
	 * @param tprojectApplication
	 *            the tprojectApplication to set
	 */
	public void setTprojectApplication(TprojectApplication tprojectApplication) {
		this.tprojectApplication = tprojectApplication;
	}

	/**
	 * @return the supportfunctionList
	 */
	public List<Mitem> getSupportfunctionList() {
		return supportfunctionList;
	}

	/**
	 * @param supportfunctionList
	 *            the supportfunctionList to set
	 */
	public void setSupportfunctionList(List<Mitem> supportfunctionList) {
		this.supportfunctionList = supportfunctionList;
	}

	/**
	 * @return the supportFlagList
	 */
	public List<Mitem> getSupportFlagList() {
		return supportFlagList;
	}

	/**
	 * @param supportFlagList
	 *            the supportFlagList to set
	 */
	public void setSupportFlagList(List<Mitem> supportFlagList) {
		this.supportFlagList = supportFlagList;
	}

	/**
	 * @return the centralizedBranchList
	 */
	public List<Mitem> getCentralizedBranchList() {
		return centralizedBranchList;
	}

	/**
	 * @param centralizedBranchList
	 *            the centralizedBranchList to set
	 */
	public void setCentralizedBranchList(List<Mitem> centralizedBranchList) {
		this.centralizedBranchList = centralizedBranchList;
	}

	/**
	 * @return the menuList
	 */
	public List<Mitem> getMenuList() {
		return menuList;
	}

	/**
	 * @param menuList
	 *            the menuList to set
	 */
	public void setMenuList(List<Mitem> menuList) {
		this.menuList = menuList;
	}

	/**
	 * @return the projectTypeId
	 */
	public String getProjectTypeId() {
		return projectTypeId;
	}

	/**
	 * @param projectTypeId
	 *            the projectTypeId to set
	 */
	public void setProjectTypeId(String projectTypeId) {
		this.projectTypeId = projectTypeId;
	}

	/**
	 * @return the projectPaTypeId
	 */
	public String getProjectPaTypeId() {
		return projectPaTypeId;
	}

	/**
	 * @param projectPaTypeId
	 *            the projectPaTypeId to set
	 */
	public void setProjectPaTypeId(String projectPaTypeId) {
		this.projectPaTypeId = projectPaTypeId;
	}

	public TprojectInfoBService getTprojectInfoBService() {
		return tprojectInfoBService;
	}

	public void setTprojectInfoBService(TprojectInfoBService tprojectInfoBService) {
		this.tprojectInfoBService = tprojectInfoBService;
	}

	public TprojectTypeService getTprojectTypeService() {
		return tprojectTypeService;
	}

	public void setTprojectTypeService(TprojectTypeService tprojectTypeService) {
		this.tprojectTypeService = tprojectTypeService;
	}

	public String getProjectPaTypeName() {
		return projectPaTypeName;
	}

	public void setProjectPaTypeName(String projectPaTypeName) {
		this.projectPaTypeName = projectPaTypeName;
	}

	public String getProjectTypeName() {
		return projectTypeName;
	}

	public void setProjectTypeName(String projectTypeName) {
		this.projectTypeName = projectTypeName;
	}

	/**
	 * @return the tattachmentService
	 */
	public TattachmentService getTattachmentService() {
		return tattachmentService;
	}

	/**
	 * @param tattachmentService
	 *            the tattachmentService to set
	 */
	public void setTattachmentService(TattachmentService tattachmentService) {
		this.tattachmentService = tattachmentService;
	}

	/**
	 * @return the tableName
	 */
	public String getTableName() {
		return tableName;
	}

	/**
	 * @param tableName
	 *            the tableName to set
	 */
	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

	/**
	 * @return the highOrOtherFlag
	 */
	public String getHighOrOtherFlag() {
		return highOrOtherFlag;
	}

	/**
	 * @param highOrOtherFlag
	 *            the highOrOtherFlag to set
	 */
	public void setHighOrOtherFlag(String highOrOtherFlag) {
		this.highOrOtherFlag = highOrOtherFlag;
	}

	// weina start

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

	public List<TprojectType> getProjectTypeList1() {
		return projectTypeList1;
	}

	public void setProjectTypeList1(List<TprojectType> projectTypeList1) {
		this.projectTypeList1 = projectTypeList1;
	}

	public List<TprojectType> getProjectTypeList2() {
		return projectTypeList2;
	}

	public void setProjectTypeList2(List<TprojectType> projectTypeList2) {
		this.projectTypeList2 = projectTypeList2;
	}

	public String getProjectType1() {
		return projectType1;
	}

	public void setProjectType1(String projectType1) {
		this.projectType1 = projectType1;
	}

	public String getProjectType2() {
		return projectType2;
	}

	public void setProjectType2(String projectType2) {
		this.projectType2 = projectType2;
	}

	public String getTechnicalFisld() {
		return technicalFisld;
	}

	public void setTechnicalFisld(String technicalFisld) {
		this.technicalFisld = technicalFisld;
	}

	public String getApplyStatus() {
		return applyStatus;
	}

	public void setApplyStatus(String applyStatus) {
		this.applyStatus = applyStatus;
	}

	public List<String> getArchivalStatusList() {
		return archivalStatusList;
	}

	public void setArchivalStatusList(List<String> archivalStatusList) {
		this.archivalStatusList = archivalStatusList;
	}

	public String getIsArchival() {
		return isArchival;
	}

	public void setIsArchival(String isArchival) {
		this.isArchival = isArchival;
	}

	public String getTypeId() {
		return typeId;
	}

	public void setTypeId(String typeId) {
		this.typeId = typeId;
	}

	public String getProjectIdList() {
		return projectIdList;
	}

	public void setProjectIdList(String projectIdList) {
		this.projectIdList = projectIdList;
	}

	public TprojectInfoAService getTprojectInfoAService() {
		return tprojectInfoAService;
	}

	public void setTprojectInfoAService(TprojectInfoAService tprojectInfoAService) {
		this.tprojectInfoAService = tprojectInfoAService;
	}

	public TprojectInfoA getTprojectInfoA() {
		return tprojectInfoA;
	}

	public void setTprojectInfoA(TprojectInfoA tprojectInfoA) {
		this.tprojectInfoA = tprojectInfoA;
	}

	public String getProjectViewType() {
		return projectViewType;
	}

	public void setProjectViewType(String projectViewType) {
		this.projectViewType = projectViewType;
	}

	public List<Mitem> getProjectViewTypeList() {
		return projectViewTypeList;
	}

	public void setProjectViewTypeList(List<Mitem> projectViewTypeList) {
		this.projectViewTypeList = projectViewTypeList;
	}

	public String getProjectTotal() {
		return projectTotal;
	}

	public void setProjectTotal(String projectTotal) {
		this.projectTotal = projectTotal;
	}

	public String getNoPassProject() {
		return noPassProject;
	}

	public void setNoPassProject(String noPassProject) {
		this.noPassProject = noPassProject;
	}

	public String getNoAcceptanceProject() {
		return noAcceptanceProject;
	}

	public void setNoAcceptanceProject(String noAcceptanceProject) {
		this.noAcceptanceProject = noAcceptanceProject;
	}

	public String getPassAcceptanceProject() {
		return passAcceptanceProject;
	}

	public void setPassAcceptanceProject(String passAcceptanceProject) {
		this.passAcceptanceProject = passAcceptanceProject;
	}

	public String getReportYear() {
		return reportYear;
	}

	public void setReportYear(String reportYear) {
		this.reportYear = reportYear;
	}

	public String getProjectViewTypeStartTime() {
		return projectViewTypeStartTime;
	}

	public void setProjectViewTypeStartTime(String projectViewTypeStartTime) {
		this.projectViewTypeStartTime = projectViewTypeStartTime;
	}

	public String getProjectViewTypeEndTime() {
		return projectViewTypeEndTime;
	}

	public void setProjectViewTypeEndTime(String projectViewTypeEndTime) {
		this.projectViewTypeEndTime = projectViewTypeEndTime;
	}

	public List<TprojectApplication> getProjectList() {
		return projectList;
	}

	public void setProjectList(List<TprojectApplication> projectList) {
		this.projectList = projectList;
	}

	public String getYearEquals() {
		return yearEquals;
	}

	public void setYearEquals(String yearEquals) {
		this.yearEquals = yearEquals;
	}

	public String getNoViewProjectTotal() {
		return noViewProjectTotal;
	}

	public void setNoViewProjectTotal(String noViewProjectTotal) {
		this.noViewProjectTotal = noViewProjectTotal;
	}

	// weina end
}
