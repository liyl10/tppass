package com.hopsun.tppas.api.report.action;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.sql.Timestamp;
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
import jxl.format.VerticalAlignment;
import jxl.read.biff.BiffException;
import jxl.write.Formula;
import jxl.write.Label;
import jxl.write.Number;
import jxl.write.NumberFormat;
import jxl.write.WritableCellFormat;
import jxl.write.WritableFont;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;

import org.apache.struts2.ServletActionContext;

import com.hopsun.framework.base.action.BaseAction;
import com.hopsun.framework.base.bean.Pager;
import com.hopsun.scenter.api.dept.service.DeptService;
import com.hopsun.scenter.entity.ScDept;
import com.hopsun.scenter.entity.ScUsers;
import com.hopsun.tppas.api.report.service.TplanCollectService;
import com.hopsun.tppas.api.report.service.TplanService;
import com.hopsun.tppas.api.superadmin.service.MitemService;
import com.hopsun.tppas.api.superadmin.service.TprojectTypeService;
import com.hopsun.tppas.common.Constants;
import com.hopsun.tppas.entity.Mitem;
import com.hopsun.tppas.entity.Tplan;
import com.hopsun.tppas.entity.TplanCollect;
import com.hopsun.tppas.entity.TprojectType;

public class TplanCollectAction extends BaseAction {

	private static final long serialVersionUID = 6749558671359639478L;
	@Resource
	private TplanCollectService tplanCollectService;
	@Resource
	private TplanService tplanService;
	@Resource
	private TprojectTypeService tprojectTypeService;
	@Resource
	private MitemService mitemService;
	@Resource
	private DeptService deptService;

	/** 计划汇总 */
	private TplanCollect tplanCollect;
	/** 计划汇总ID */
	private String planCollectId;
	/** 计划批次 */
	private List<Mitem> planBatchList;
	/** 翻页 */
	private int pageNo;
	/** 汇总计划名称 */
	private String planCollectionName;
	/** 计划年度 */
	private String planYear;
	/** 批次 */
	private String planBatch;
	/** 级联菜单返回值 */
	private String backStr;
	/** 跳转路径 */
	private String retUrl;
	/** 跳转页面massage */
	private String retMsg;
	/** 分计划名称 */
	private String planName;
	/** 业务处室List */
	private List<ScDept> deptList;
	/** 选择的业务处室 */
	private String selectedDeptId;
	/** 项目分类一级 */
	private String projectType1;
	/** 项目分类二级 */
	private String projectType2;
	/** 级联菜单flag */
	private String searchFlag;
	/** 级联菜单父级id */
	private String pitemId;
	/** 分计划List */
	private List<Tplan> selectPlanList;
	/** 项目分类一级 */
	private List<TprojectType> projectTypeList1 = new ArrayList<TprojectType>();
	/** 项目分类二级 */
	private List<TprojectType> projectTypeList2 = new ArrayList<TprojectType>();
	/** 分计划id */
	private String planId;
	/** 返回按钮flag */
	private String backFlag;
	/** 计划类别ID */
	private String planFlag;
	/** 选择分计划时组成的字符串 planId,planId2,planId3, */
	private String planIdStr;

	/**
	 * 
	 * @comments 初始化检索条件
	 * @return
	 * @version 1.0
	 */
	public String initSearch() {
		// 取得登录用户的信息
		HttpSession session = this.getRequest().getSession();
		session.setAttribute(Constants.SESSION_CMDKEY, "showPlanManage");

		ScUsers user = (ScUsers) session.getAttribute("sysUser");
		// 如果用户为空或者企业为空，退出系统
		if (user == null || ("").equals(user.getUserId())) {
			return "LogOut";
		}

		// 当前计划年度
		this.planYear = mitemService.get(Constants.APPLY_YEAR).getItemDesc();

		// 计划批次
		this.planBatchList = new ArrayList<Mitem>();
		this.planBatchList = mitemService.getListByTypeId(Constants.TYPE_PLANBATCH_STATUS);

		return "initSearch";
	}

	/**
	 * 查询计划汇总一览
	 * 
	 * @return String
	 */
	public String getPlanColectionList() {
		// 取得登录用户的信息
		HttpSession session = this.getRequest().getSession();
		String cmdkey = (String) session.getAttribute(Constants.SESSION_CMDKEY);

		ScUsers user = (ScUsers) session.getAttribute("sysUser");
		// 如果用户为空或者企业为空，退出系统
		if (user == null || ("").equals(user.getUserId()) || !"showPlanManage".equals(cmdkey)) {
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
		// 计划汇总id
		// param.put("planCollectionId", planCollectionId);
		// 计划汇总名称
		param.put("planCollectionName", planCollectionName);
		// 计划年度
		param.put("planYear", planYear);
		// 批次
		param.put("planBatch", planBatch);

		// 取得计划汇总一览信息
		pager = tplanCollectService.getPlanList(param, pager.getPageNumber(), pager.getPageSize());

		return "getList";
	}

	/**
	 * 跳转到添加页面
	 * 
	 * @return String
	 */
	public String toAddNewPlanColection() {
		// 取得登录用户的信息
		HttpSession session = this.getRequest().getSession();
		String cmdkey = (String) session.getAttribute(Constants.SESSION_CMDKEY);

		ScUsers user = (ScUsers) session.getAttribute("sysUser");
		// 如果用户为空或者企业为空，退出系统
		if (user == null || ("").equals(user.getUserId()) || !"showPlanManage".equals(cmdkey)) {
			return "LogOut";
		}

		// 当前计划年度
		this.planYear = mitemService.get(Constants.APPLY_YEAR).getItemDesc();

		// 计划批次
		this.planBatchList = new ArrayList<Mitem>();
		this.planBatchList = mitemService.getListByTypeId(Constants.TYPE_PLANBATCH_STATUS);

		return "addNewPlan";
	}

	/**
	 * 
	 * @comments 查询条件
	 * @return
	 * @version 1.0
	 */
	public String showSelectPlanSearch() {
		// 取得登录用户的信息
		HttpSession session = this.getRequest().getSession();
		session.setAttribute(Constants.SESSION_CMDKEY, "showPlanManage");

		ScUsers user = (ScUsers) session.getAttribute("sysUser");
		// 如果用户为空或者企业为空，退出系统
		if (user == null || ("").equals(user.getUserId())) {
			return "LogOut";
		}
		// 当前计划年度
		this.planYear = mitemService.get(Constants.APPLY_YEAR).getItemDesc();

		// 业务处室
		this.deptList = deptService.findDept(user.getScDept());

		/*
		 * // 初始化计划类别 this.projectTypeList1 = new ArrayList<TprojectType>();
		 * this.projectTypeList1 =
		 * tprojectTypeService.getFatherProjectTypeListByDeptId(
		 * user.getScDept().getDeptId());
		 * 
		 * // 初始化项目分类 this.projectTypeList2 = new ArrayList<TprojectType>();
		 */

		// 分计划状态
		// this.planStateList = new ArrayList<Mitem>();
		// this.planStateList =
		// mitemService.getListByTypeId(Constants.TYPE_PLAN_STATUS);

		// 计划批次
		this.planBatchList = new ArrayList<Mitem>();
		this.planBatchList = mitemService.getListByTypeId(Constants.TYPE_PLANBATCH_STATUS);

		return "showSelectPlanSearch";

	}

	/**
	 * @comments 分计划列表
	 * @return
	 * @Version 1.0
	 */
	public String getPlanList() {

		// 取得登录用户的信息
		HttpSession session = this.getRequest().getSession();
		String cmdkey = (String) session.getAttribute(Constants.SESSION_CMDKEY);

		ScUsers user = (ScUsers) session.getAttribute("sysUser");
		// 如果用户为空或者企业为空，退出系统
		if (user == null || ("").equals(user.getUserId()) || !"showPlanManage".equals(cmdkey)) {
			return "LogOut";
		}

		Map<String, Object> param = new HashMap<String, Object>();

		// 封装查询条件
		// 分计划名称
		param.put("planName", planName);
		// 计划年度
		param.put("planYear", planYear);
		// 业务处室
		param.put("selectedDeptId", selectedDeptId);
		// 计划类别
		param.put("projectType1", projectType1);
		// 项目分类
		param.put("projectType2", projectType2);
		// 批次
		param.put("planBatch", planBatch);
		// 取得项目一览信息
		this.selectPlanList = tplanService.getPlanList(param);

		return "getPlanList";
	}

	/**
	 * @comments 下拉列表联动
	 * @return
	 * @throws Exception
	 * @Version 1.0
	 */
	public String getSecondData() throws Exception {

		StringBuffer dataStr = new StringBuffer();
		List<TprojectType> dataList = null;
		if ("dept".equals(searchFlag)) {
			// 根据部门id取得一级项目分类
			dataList = tprojectTypeService.getFatherProjectTypeListByDeptId(pitemId);
		} else {
			// 取得联动下拉列表数据List
			dataList = tprojectTypeService.getSonProjectTypeListByDeptId(pitemId);
		}

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

	/**
	 * 
	 * @comments 保存计划汇总
	 * @return
	 * @version 1.0
	 */
	public String savePlanColection() {
		// 取得登录用户的信息
		HttpSession session = this.getRequest().getSession();
		String cmdkey = (String) session.getAttribute(Constants.SESSION_CMDKEY);

		ScUsers user = (ScUsers) session.getAttribute("sysUser");
		// 如果用户为空或者企业为空，退出系统
		if (user == null || ("").equals(user.getUserId()) || !"showPlanManage".equals(cmdkey)) {
			return "LogOut";
		}

		TplanCollect tplanCollect = new TplanCollect();
		// 计划汇总名称
		tplanCollect.setPlanCollectName(planCollectionName);
		// 计划年度
		tplanCollect.setPlanCollectYear(planYear);
		// 批次
		tplanCollect.setPlanCollectBatch(planBatch);
		// 创建者
		tplanCollect.setCreateUser(user.getUserId());
		// 创建时间
		tplanCollect.setCreateTime(new Timestamp(System.currentTimeMillis()));
		// 删除区分
		tplanCollect.setDeleteFlag("0");

		// 新增计划汇总

		planCollectId = tplanCollectService.save(tplanCollect);

		// message
		this.setRetMsg(this.getText("opt_save_suc"));
		// 画面跳转
		this.setRetUrl(super.getRequest().getContextPath() + "/api/planCollect/tplanCollectAction!showSelectPlanSearch.action?planCollectId=" + this.planCollectId + "&backFlag=" + "add" + "&now="
				+ new Date().getTime());

		return "systemInfoMain";
	}

	/**
	 * 修改汇总分计划信息
	 * 
	 * @return String
	 */
	public String updatePlanColection() {

		// 取得登录用户的信息
		HttpSession session = this.getRequest().getSession();
		String cmdkey = (String) session.getAttribute(Constants.SESSION_CMDKEY);

		ScUsers user = (ScUsers) session.getAttribute("sysUser");
		// 如果用户为空或者企业为空，退出系统
		if (user == null || ("").equals(user.getUserId()) || !"showPlanManage".equals(cmdkey)) {
			return "LogOut";
		}

		TplanCollect tplanCollect = tplanCollectService.get(this.planCollectId);
		if (tplanCollect != null) {
			// 计划汇总名称
			tplanCollect.setPlanCollectName(planCollectionName);
			// 计划年度
			tplanCollect.setPlanCollectYear(planYear);
			// 批次
			tplanCollect.setPlanCollectBatch(planBatch);
			// 更新者
			tplanCollect.setUpdateUser(user.getUserId());
			// 更新时间
			tplanCollect.setUpdateDate(new Timestamp(System.currentTimeMillis()));

			// 更新计划汇总
			tplanCollectService.update(tplanCollect);
		}
		// message
		this.setRetMsg(this.getText("opt_update_suc"));
		// 画面跳转
		this.setRetUrl(super.getRequest().getContextPath() + "/api/planCollect/tplanCollectAction!initSearch.action?now=" + new Date().getTime());

		return "systemInfoMain";
	}

	/**
	 * 删除分计划
	 * 
	 * @return String
	 */
	public String deletePlan() {

		// 取得登录用户的信息
		HttpSession session = this.getRequest().getSession();

		ScUsers user = (ScUsers) session.getAttribute("sysUser");
		// 如果用户为空或者企业为空，退出系统
		if (user == null || ("").equals(user.getUserId())) {
			return "LogOut";
		}
		// 封装条件
		Map<String, Object> param = new HashMap<String, Object>();
		// 分计划ID
		param.put("planId", this.planId);
		// 更新用户
		param.put("updateUser", user.getUserId());

		tplanService.deletePlanFromCollect(param);

		this.setRetMsg(this.getText("opt_del_suc"));
		this.setRetUrl(super.getRequest().getContextPath() + "/api/planCollect/tplanCollectAction!toUpdataPage.action?planCollectId=" + this.planCollectId + "&now=" + new Date().getTime());

		return "systemInfoMain";
	}

	/**
	 * 通过计划类别删除分计划 将会从汇总计划中删除所有属于该计划类别的分计划
	 * 
	 * @return String
	 */
	public String deletePlanByType() {

		// 取得登录用户的信息
		HttpSession session = this.getRequest().getSession();

		ScUsers user = (ScUsers) session.getAttribute("sysUser");
		// 如果用户为空或者企业为空，退出系统
		if (user == null || ("").equals(user.getUserId())) {
			return "LogOut";
		}
		// 封装条件
		Map<String, Object> param = new HashMap<String, Object>();
		// 分计划ID
		param.put("planCollectId", this.planCollectId);
		// 计划类别ID
		param.put("planFlag", this.planFlag);
		// 更新用户
		param.put("updateUser", user.getUserId());

		tplanService.deletePlanFromCollectByType(param);

		this.setRetMsg(this.getText("opt_del_suc"));
		this.setRetUrl(super.getRequest().getContextPath() + "/api/planCollect/tplanCollectAction!toUpdataPage.action?planCollectId=" + this.planCollectId + "&now=" + new Date().getTime());

		return "systemInfoMain";
	}

	/**
	 * 跳转到修改页面
	 * 
	 * @return String
	 */
	public String toUpdataPage() {
		// 取得登录用户的信息
		HttpSession session = this.getRequest().getSession();
		String cmdkey = (String) session.getAttribute(Constants.SESSION_CMDKEY);

		ScUsers user = (ScUsers) session.getAttribute("sysUser");
		// 如果用户为空或者企业为空，退出系统
		if (user == null || ("").equals(user.getUserId()) || !"showPlanManage".equals(cmdkey)) {
			return "LogOut";
		}
		// 计划批次
		this.planBatchList = new ArrayList<Mitem>();
		this.planBatchList = mitemService.getListByTypeId(Constants.TYPE_PLANBATCH_STATUS);
		// 取得计划汇总详细
		this.tplanCollect = tplanCollectService.get(this.planCollectId);
		// 批次
		this.planBatch = tplanCollect.getPlanCollectBatch();
		// 计划类别List
		List<String> groupInfo = tplanService.getGroupInfo(planCollectId);
		// 取得该计划汇总下的分计划一览
		// this.selectPlanList =
		// tplanService.getList("tplanCollect.planCollectId", planCollectId);
		this.selectPlanList = tplanService.getListByGroupInfo(planCollectId, groupInfo);

		return "planCollectEdit";
	}

	/**
	 * 跳转到详细页面
	 * 
	 * @return String
	 */
	public String showPlanDetail() {
		// 取得登录用户的信息
		HttpSession session = this.getRequest().getSession();
		String cmdkey = (String) session.getAttribute(Constants.SESSION_CMDKEY);

		ScUsers user = (ScUsers) session.getAttribute("sysUser");
		// 如果用户为空或者企业为空，退出系统
		if (user == null || ("").equals(user.getUserId()) || !"showPlanManage".equals(cmdkey)) {
			return "LogOut";
		}
		// 取得计划汇总详细
		this.tplanCollect = tplanCollectService.get(this.planCollectId);
		// 批次
		this.planBatch = mitemService.getMitemNameById(tplanCollect.getPlanCollectBatch());
		// 计划类别List
		List<String> groupInfo = tplanService.getGroupInfo(planCollectId);
		// 取得该计划汇总下的分计划一览
		// this.selectPlanList =
		// tplanService.getList("tplanCollect.planCollectId", planCollectId);
		this.selectPlanList = tplanService.getListByGroupInfo(planCollectId, groupInfo);

		return "planCollectDetail";
	}

	/**
	 * 提交选择的分计划
	 * 
	 * @return String
	 */
	public String selectPlanSubmit() {
		// 取得登录用户的信息
		HttpSession session = this.getRequest().getSession();
		String cmdkey = (String) session.getAttribute(Constants.SESSION_CMDKEY);

		ScUsers user = (ScUsers) session.getAttribute("sysUser");
		// 如果用户为空或者企业为空，退出系统
		if (user == null || ("").equals(user.getUserId()) || !"showPlanManage".equals(cmdkey)) {
			return "LogOut";
		}
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("planCollectId", this.planCollectId);
		param.put("planIdStr", this.planIdStr);
		param.put("updateUser", user.getUserId());
		tplanCollectService.updateSelectedPlan(param);
		// message
		this.setRetMsg(this.getText("opt_update_suc"));
		// 画面跳转
		this.setRetUrl(super.getRequest().getContextPath() + "/api/planCollect/tplanCollectAction!showPlanDetail.action?planCollectId=" + this.planCollectId + "&now=" + new Date().getTime());

		return "systemInfoMain";
	}

	/**
	 * 
	 * @comments 打印按钮按下的处理
	 * @version 1.0
	 * @throws IOException
	 */
	public void printPlanDetail() throws IOException {
		// 取得登录用户的信息
		// HttpSession session = this.getRequest().getSession();
		// ScUsers user = (ScUsers) session.getAttribute("sysUser");
		// 根据汇总计划id取得汇总计划
		this.tplanCollect = tplanCollectService.get(this.planCollectId);
		// excel文件名
		String excelFileName = tplanCollect.getPlanCollectYear() + "年" + mitemService.getMitemNameById(tplanCollect.getPlanCollectBatch()) + tplanCollect.getPlanCollectName() + "汇总表";
		// 计划类别List
		List<String> groupInfo = tplanService.getGroupInfo(planCollectId);
		// 取得该汇总计划下的所有分计划
		List<Tplan> allResultData = tplanService.getList("tplanCollect.planCollectId", planCollectId);
		// 生成excel
		this.createOutExcel(groupInfo, allResultData, excelFileName);
	}

	/**
	 * @comments 导出数据到excel
	 * @param groupInfo
	 * @param allResultData
	 * @param excelFileName
	 * @version 1.0
	 * @throws IOException
	 */
	private void createOutExcel(List<String> groupInfo, List<Tplan> allResultData, String excelFileName) throws IOException {
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

		// 工作簿从usr tppasc input中拷贝模板：项目结果汇总模板(业务处).xls
		String modelInputPath = mitemService.get(Constants.PDF_TEMPLATE_PATH).getItemDesc();
		String len = modelInputPath.substring(modelInputPath.length() - 1, modelInputPath.length());
		// 判断目录是否完整
		if (!"/".equals(len)) {
			modelInputPath = modelInputPath + "/";
		}

		File fileModel = new File(modelInputPath + Constants.EXPERT_PLAN_COLLECT_FILENAME);
		try {
			Workbook wk = Workbook.getWorkbook(fileModel);
			WorkbookSettings settings = new WorkbookSettings();
			settings.setWriteAccess(null);

			WritableWorkbook outWorkBook = Workbook.createWorkbook(out, wk);
			// 取得汇总表sheet
			WritableSheet sh = outWorkBook.getSheet("汇总表");
			// ===========写入标题 start===========
			// 标题格式
			WritableCellFormat titleCf = new WritableCellFormat();
			// 设置边框
			titleCf.setBorder(Border.ALL, BorderLineStyle.THIN);
			// 垂直居中显示
			titleCf.setVerticalAlignment(VerticalAlignment.CENTRE);
			// 水平居中显示
			titleCf.setAlignment(Alignment.CENTRE);
			// 设置字体
			WritableFont wf = new WritableFont(WritableFont.createFont("宋体"), 18, WritableFont.BOLD, false);
			titleCf.setFont(wf);
			sh.addCell(new Label(0, 0, excelFileName, titleCf));
			// ===========写入标题 end ===========

			// ===========写入数据 start===========
			// 单元格边框格式（计划类别行文字）
			WritableCellFormat typeCf = new WritableCellFormat();
			// 设置边框
			typeCf.setBorder(Border.ALL, BorderLineStyle.THIN);
			// 垂直居中显示
			typeCf.setVerticalAlignment(VerticalAlignment.CENTRE);
			// 水平居中显示
			typeCf.setAlignment(Alignment.CENTRE);
			WritableFont wf2 = new WritableFont(WritableFont.createFont("宋体"), 10, WritableFont.BOLD, false);
			typeCf.setFont(wf2);
			// 换行显示
			typeCf.setWrap(true);

			// 单元格边框格式（计划类别行整数）
			NumberFormat nf = new NumberFormat("#0");
			WritableCellFormat typeNumcf = new WritableCellFormat(nf);
			// 设置边框
			typeNumcf.setBorder(Border.ALL, BorderLineStyle.THIN);
			// 垂直居中显示
			typeNumcf.setVerticalAlignment(VerticalAlignment.CENTRE);
			typeNumcf.setFont(wf2);
			// 换行显示
			typeNumcf.setWrap(true);
			// 单元格边框格式（计划类别行小数）
			NumberFormat nf2 = new NumberFormat("#0.0###");
			WritableCellFormat typeDoublecf = new WritableCellFormat(nf2);
			// 设置边框
			typeDoublecf.setBorder(Border.ALL, BorderLineStyle.THIN);
			// 垂直居中显示
			typeDoublecf.setVerticalAlignment(VerticalAlignment.CENTRE);
			typeDoublecf.setFont(wf2);
			// 换行显示
			typeDoublecf.setWrap(true);

			// 单元格边框格式（正文文字）
			WritableCellFormat cf = new WritableCellFormat();
			// 设置边框
			cf.setBorder(Border.ALL, BorderLineStyle.THIN);
			// 垂直居中显示
			cf.setVerticalAlignment(VerticalAlignment.CENTRE);
			WritableFont wf3 = new WritableFont(WritableFont.createFont("宋体"), 10, WritableFont.NO_BOLD, false);
			cf.setFont(wf3);
			// 换行显示
			cf.setWrap(true);

			// 单元格边框格式（正文文字）
			WritableCellFormat indexCf = new WritableCellFormat();
			// 设置边框
			indexCf.setBorder(Border.ALL, BorderLineStyle.THIN);
			// 垂直居中显示
			indexCf.setVerticalAlignment(VerticalAlignment.CENTRE);
			// 水平居中显示
			indexCf.setAlignment(Alignment.CENTRE);
			indexCf.setFont(wf3);
			// 换行显示
			indexCf.setWrap(true);

			// 单元格边框格式（正文小数）
			WritableCellFormat doublecf = new WritableCellFormat(nf2);
			// 设置边框
			doublecf.setBorder(Border.ALL, BorderLineStyle.THIN);
			// 垂直居中显示
			doublecf.setVerticalAlignment(VerticalAlignment.CENTRE);
			doublecf.setFont(wf3);
			// 换行显示
			doublecf.setWrap(true);

			// 没有分计划的时候输出：该汇总计划目前没有数据。
			if (groupInfo == null || groupInfo.size() < 1) {
				// 计划类别名称
				sh.addCell(new Label(0, 2, "该汇总计划目前没有数据。", typeCf));
				sh.mergeCells(0, 2, 8, 2);
				outWorkBook.write();
				out.flush();
				outWorkBook.close();
				wk.close();
				response.flushBuffer();
				return;
			}

			// 这个list用来记录写入计划类别的行目
			List<Integer> projectTypeRow = new ArrayList<Integer>();
			// 开始写入数据的行目数
			int rowNum = 2;
			// 序列
			int indexNum = 1;
			// 计划类别序列
			int typeIndexNum = 1;
			for (int i = 0; i < groupInfo.size(); i++) {
				String projectTypeId = groupInfo.get(i);
				// 取得计划类别名称
				String porjectTypeName = tprojectTypeService.getProjectTypeName(projectTypeId);

				// 从allResultData中取得projectTypeId对应的数据
				List<Tplan> typeList = new ArrayList<Tplan>();
				for (int j = 0; j < allResultData.size(); j++) {
					if (projectTypeId.equals(allResultData.get(j).getPlanFlag())) {
						typeList.add(allResultData.get(j));
					}
				}
				// 该计划类别下分计划的个数
				int typeListCount = typeList.size();

				// 将该计划类别写入excel
				// 序列
				sh.addCell(new Label(0, rowNum, toHanStr(String.valueOf(typeIndexNum)), typeCf));
				// 计划类别名称
				sh.addCell(new Label(1, rowNum, porjectTypeName, typeCf));
				// 项目数
				sh.addCell(new Formula(2, rowNum, getFormula(rowNum + 2, rowNum + typeListCount + 1, "SUM", "C"), typeNumcf));
				// 科研资金
				sh.addCell(new Formula(3, rowNum, getFormula(rowNum + 2, rowNum + typeListCount + 1, "SUM", "D"), typeDoublecf));
				// 总投入
				sh.addCell(new Formula(4, rowNum, getFormula(rowNum + 2, rowNum + typeListCount + 1, "SUM", "E"), typeDoublecf));
				// 项目预计产值
				sh.addCell(new Formula(5, rowNum, getFormula(rowNum + 2, rowNum + typeListCount + 1, "SUM", "F"), typeDoublecf));
				// 项目预计利税
				sh.addCell(new Formula(6, rowNum, getFormula(rowNum + 2, rowNum + typeListCount + 1, "SUM", "G"), typeDoublecf));
				// 企业预计产值
				sh.addCell(new Formula(7, rowNum, getFormula(rowNum + 2, rowNum + typeListCount + 1, "SUM", "H"), typeDoublecf));
				// 企业预计利税
				sh.addCell(new Formula(8, rowNum, getFormula(rowNum + 2, rowNum + typeListCount + 1, "SUM", "I"), typeDoublecf));

				// 将项目分类所在行写入projectTypeRow中，用来计算最后的合计
				projectTypeRow.add(rowNum + 1);
				rowNum = rowNum + 1;
				typeIndexNum = typeIndexNum + 1;

				// 写出该计划类别下的分计划
				for (int j = 0; j < typeListCount; j++) {
					// 序列
					sh.addCell(new Number(0, rowNum, indexNum, indexCf));
					// 计划类别名称
					sh.addCell(new Label(1, rowNum, typeList.get(j).getPlanName(), cf));
					// 项目数
					sh.addCell(new Number(2, rowNum, typeList.get(j).getProjectCount(), cf));
					// 科研资金
					sh.addCell(new Number(3, rowNum, typeList.get(j).getResearchFunds(), doublecf));
					// 总投入
					sh.addCell(new Number(4, rowNum, typeList.get(j).getInputTotal(), doublecf));
					// 项目预计产值
					sh.addCell(new Number(5, rowNum, typeList.get(j).getProjectExpectOutput(), doublecf));
					// 项目预计利税
					sh.addCell(new Number(6, rowNum, typeList.get(j).getProjectExpectProfitTax(), doublecf));
					// 企业预计产值
					sh.addCell(new Number(7, rowNum, typeList.get(j).getCompanyExpectOutput(), doublecf));
					// 企业预计利税
					sh.addCell(new Number(8, rowNum, typeList.get(j).getCompanyExpectProfitTax(), doublecf));

					rowNum = rowNum + 1;
					indexNum = indexNum + 1;
				}

				// rowNum = rowNum + typeListCount;
			}

			// 合计行
			// 序列
			// sh.addCell(new Label(0, rowNum, "", typeCf));
			// 计划类别名称
			sh.mergeCells(0, rowNum, 1, rowNum);
			sh.addCell(new Label(0, rowNum, "合计", typeCf));

			// 项目数
			sh.addCell(new Formula(2, rowNum, getCountFormula(projectTypeRow, "SUM", "C"), typeNumcf));
			// 科研资金
			sh.addCell(new Formula(3, rowNum, getCountFormula(projectTypeRow, "SUM", "D"), typeDoublecf));
			// 总投入
			sh.addCell(new Formula(4, rowNum, getCountFormula(projectTypeRow, "SUM", "E"), typeDoublecf));
			// 项目预计产值
			sh.addCell(new Formula(5, rowNum, getCountFormula(projectTypeRow, "SUM", "F"), typeDoublecf));
			// 项目预计利税
			sh.addCell(new Formula(6, rowNum, getCountFormula(projectTypeRow, "SUM", "G"), typeDoublecf));
			// 企业预计产值
			sh.addCell(new Formula(7, rowNum, getCountFormula(projectTypeRow, "SUM", "H"), typeDoublecf));
			// 企业预计利税
			sh.addCell(new Formula(8, rowNum, getCountFormula(projectTypeRow, "SUM", "I"), typeDoublecf));

			// ===========写入数据 end ===========
			outWorkBook.write();
			out.flush();
			outWorkBook.close();
			wk.close();
			response.flushBuffer();

		} catch (BiffException e) {
			e.printStackTrace();
		} catch (WriteException e) {
			e.printStackTrace();
		}

	}

	/**
	 * 
	 * @comments 合计行公式生成
	 * @param projectTypeRow
	 * @param string
	 * @param string2
	 * @return
	 * @version 1.0
	 */
	private String getCountFormula(List<Integer> projectTypeRow, String formula, String columnStr) {
		StringBuffer outStrBuf = new StringBuffer();
		outStrBuf.append(formula);
		outStrBuf.append("(");

		StringBuffer formulaRes = new StringBuffer();
		for (int i = 0; i < projectTypeRow.size(); i++) {

			if (i > 0) {
				formulaRes.append(",");
				formulaRes.append(columnStr);
				formulaRes.append(projectTypeRow.get(i).toString());
			} else {
				formulaRes.append(columnStr);
				formulaRes.append(projectTypeRow.get(i).toString());
			}
		}
		outStrBuf.append(formulaRes.toString());
		outStrBuf.append(")");
		return outStrBuf.toString();
	}

	/**
	 * 
	 * @comments 生成公式
	 * @param maxDataRow
	 * @param formulaStr
	 * @param columnStr
	 * @return
	 * @version 1.0
	 */
	private String getFormula(int startRow, int endRow, String formulaStr, String columnStr) {
		StringBuffer outStrBuf = new StringBuffer();
		outStrBuf.append(formulaStr);
		outStrBuf.append("(");
		outStrBuf.append(columnStr);
		outStrBuf.append(startRow);
		outStrBuf.append(":");
		outStrBuf.append(columnStr);
		outStrBuf.append(endRow);
		outStrBuf.append(")");
		return outStrBuf.toString();
	}

	/**
	 * 删除汇总计划
	 * 
	 * @return String
	 */
	public String deletePlanColection() {
		// 取得登录用户的信息
		HttpSession session = this.getRequest().getSession();
		session.setAttribute(Constants.SESSION_CMDKEY, "showPlanManage");

		ScUsers user = (ScUsers) session.getAttribute("sysUser");
		// 如果用户为空或者企业为空，退出系统
		if (user == null || ("").equals(user.getUserId())) {
			return "LogOut";
		}
		// 封装条件
		Map<String, Object> param = new HashMap<String, Object>();
		// 计划汇总ID
		param.put("planCollectId", this.planCollectId);
		// 将删除区分设定为1
		param.put("deleteFlag", "1");
		// 更新用户
		param.put("updateUser", user.getUserId());

		tplanCollectService.deletePlanCollect(param);

		this.setRetMsg(this.getText("opt_del_suc"));
		this.setRetUrl(super.getRequest().getContextPath() + "/api/planCollect/tplanCollectAction!initSearch.action?now=" + new Date().getTime());

		return "systemInfoMain";
	}

	/**
	 * 
	 * @comments 将数字转换成汉字
	 * @param numStr
	 * @return
	 * @version 1.0
	 */
	private String toHanStr(String numStr) {
		String[] hanArr = { "零", "一", "二", "三", "四", "五", "六", "七", "八", "九" };
		String[] unitArr = { "十", "百", "千", "万", "十", "百", "千", "亿", "十", "百", "千" };

		String result = "";
		int numLen = numStr.length();
		for (int i = 0; i < numLen; i++) {
			int num = numStr.charAt(i) - 48;
			if (i != numLen - 1 && num != 0) {
				result += hanArr[num] + unitArr[numLen - 2 - i];
			} else {
				result += hanArr[num];
			}
		}
		if (result.endsWith("零")) {
			result = result.substring(0, result.length() - 1);
		}
		return result;
	}

	// ==============以下为get/set方法===================
	public TplanCollect getTplanCollect() {
		return tplanCollect;
	}

	public void setTplanCollect(TplanCollect tplanCollect) {
		this.tplanCollect = tplanCollect;
	}

	public String getPlanCollectId() {
		return planCollectId;
	}

	public void setPlanCollectId(String planCollectId) {
		this.planCollectId = planCollectId;
	}

	public List<Mitem> getPlanBatchList() {
		return planBatchList;
	}

	public void setPlanBatchList(List<Mitem> planBatchList) {
		this.planBatchList = planBatchList;
	}

	public int getPageNo() {
		return pageNo;
	}

	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}

	public String getPlanCollectionName() {
		return planCollectionName;
	}

	public void setPlanCollectionName(String planCollectionName) {
		this.planCollectionName = planCollectionName;
	}

	public String getPlanYear() {
		return planYear;
	}

	public void setPlanYear(String planYear) {
		this.planYear = planYear;
	}

	public String getPlanBatch() {
		return planBatch;
	}

	public void setPlanBatch(String planBatch) {
		this.planBatch = planBatch;
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

	public String getPlanName() {
		return planName;
	}

	public void setPlanName(String planName) {
		this.planName = planName;
	}

	public List<ScDept> getDeptList() {
		return deptList;
	}

	public void setDeptList(List<ScDept> deptList) {
		this.deptList = deptList;
	}

	public String getSelectedDeptId() {
		return selectedDeptId;
	}

	public void setSelectedDeptId(String selectedDeptId) {
		this.selectedDeptId = selectedDeptId;
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

	public String getSearchFlag() {
		return searchFlag;
	}

	public void setSearchFlag(String searchFlag) {
		this.searchFlag = searchFlag;
	}

	public String getPitemId() {
		return pitemId;
	}

	public void setPitemId(String pitemId) {
		this.pitemId = pitemId;
	}

	public List<Tplan> getSelectPlanList() {
		return selectPlanList;
	}

	public void setSelectPlanList(List<Tplan> selectPlanList) {
		this.selectPlanList = selectPlanList;
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

	public String getPlanId() {
		return planId;
	}

	public void setPlanId(String planId) {
		this.planId = planId;
	}

	public String getBackFlag() {
		return backFlag;
	}

	public void setBackFlag(String backFlag) {
		this.backFlag = backFlag;
	}

	public String getPlanFlag() {
		return planFlag;
	}

	public void setPlanFlag(String planFlag) {
		this.planFlag = planFlag;
	}

	public String getPlanIdStr() {
		return planIdStr;
	}

	public void setPlanIdStr(String planIdStr) {
		this.planIdStr = planIdStr;
	}
}
