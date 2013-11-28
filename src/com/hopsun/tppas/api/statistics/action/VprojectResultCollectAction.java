/*************** 版权声明***************
 *
 * Copyright (C) 2012 西安辉盛科技发展有限责任公司.
 *
 ********************************************
 */
package com.hopsun.tppas.api.statistics.action;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jxl.CellView;
import jxl.Workbook;
import jxl.WorkbookSettings;
import jxl.format.Alignment;
import jxl.format.Border;
import jxl.format.BorderLineStyle;
import jxl.format.VerticalAlignment;
import jxl.read.biff.BiffException;
import jxl.write.Blank;
import jxl.write.Formula;
import jxl.write.Label;
import jxl.write.Number;
import jxl.write.NumberFormat;
import jxl.write.WritableCellFeatures;
import jxl.write.WritableCellFormat;
import jxl.write.WritableFont;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

import org.apache.struts2.ServletActionContext;

import com.hopsun.framework.base.action.BaseAction;
import com.hopsun.framework.base.bean.Pager;
import com.hopsun.scenter.api.dept.service.DeptService;
import com.hopsun.scenter.entity.ScDept;
import com.hopsun.scenter.entity.ScUsers;
import com.hopsun.tppas.api.statistics.service.VprojectResultCollectService;
import com.hopsun.tppas.api.superadmin.service.MitemService;
import com.hopsun.tppas.api.superadmin.service.TprojectTypeManagerService;
import com.hopsun.tppas.api.superadmin.service.TprojectTypeService;
import com.hopsun.tppas.common.CommonTool;
import com.hopsun.tppas.common.Constants;
import com.hopsun.tppas.entity.Mitem;
import com.hopsun.tppas.entity.TprojectType;
import com.hopsun.tppas.view.VprojectResultCollect;

/**
 * 
 * @comments 项目结果汇总
 * @author liyilin
 * @date 2013-8-22
 * @version 1.0
 */
public class VprojectResultCollectAction extends BaseAction {

	// public final static Logger LOGGER =
	// Logger.getLogger(ProjectResultCollectAction.class.getName());
	private static final long serialVersionUID = 1L;

	@Resource
	private VprojectResultCollectService vprojectResultCollectService;

	@Resource
	private MitemService mitemService;

	/** 项目分类service */
	@Resource
	private TprojectTypeService tprojectTypeService;

	@Resource
	private TprojectTypeManagerService tprojectTypeManagerService;

	/** 部门service */
	@Resource
	private DeptService deptService;

	/** 菜单List */
	private List<Mitem> menuList;

	/** 跳转页码 */
	private int pageNo;

	/** 申报年度List */
	private List<String> reportYearList = new ArrayList<String>();

	/** 检索条件中选中的申报年度 */
	private String selectedReportYear;

	/** 申报年度 */
	private String reportYear;

	/** 项目分类（一级） */
	private List<TprojectType> projectTypeFirstList = new ArrayList<TprojectType>();

	/** 项目分类（二级） */
	private List<TprojectType> projectTypeSecondList = new ArrayList<TprojectType>();

	/** 选中的项目分类（一级） */
	private String selectedProjectTypeFirst;

	/** 选中的项目分类（二级） */
	private String selectedProjectTypeSecond;

	/** 部门List */
	private List<ScDept> deptList = new ArrayList<ScDept>();

	/** 选中的部门 */
	private String selectedDept;

	/** 项目分类一级id */
	private String pitemId;

	/** 级联菜单返回值 */
	private String backStr;

	/** 计财处flag 是计财处的时候为true，否则为false */
	private Boolean isPlanningDept;

	/** 打印按钮表示flag */
	private Boolean printEnableFlag;

	/** 所属园区 */
	private List<Mitem> centralizedTypeList;

	/** 级联菜单flag */
	private String searchFlag;

	/** 项目名称 */
	private String projectName;

	/** 所属园区 */
	private String centralizedType;

	/** 承担单位 */
	private String applicationUnit;
	/** 画面跳转区分 */
	private String jumpFlag;

	/**
	 * 
	 * @comments 初期化项目结果汇总查询条件
	 * @return
	 * @version 1.0
	 */
	public String initSearch() {

		// 取得登录用户的信息
		HttpSession session = this.getRequest().getSession();
		ScUsers user = (ScUsers) session.getAttribute("sysUser");
		// 如果用户为空或者企业为空，退出系统
		if (user == null || ("").equals(user.getUserId())) {
			return "LogOut";
		}
		// 申报年度List
		reportYearList = vprojectResultCollectService.getReportYearList();
		// 检索条件中选中的申报年度（当前系统申报年度）
		selectedReportYear = mitemService.get(Constants.APPLY_YEAR).getItemDesc();
		// 判断当前系统申报年度是否在申报年度List中，如果在，则初期化选中该年度，如果不在,
		// 则默认选中最后一个申报年度
		if (reportYearList != null && reportYearList.size() > 0) {
			if (!reportYearList.contains(selectedReportYear)) {
				selectedReportYear = reportYearList.get(reportYearList.size() - 1);
			}
		} else {
			reportYearList = new ArrayList<String>();
			reportYearList.add(selectedReportYear);
		}

		// 取得用户的部门ID
		String deptId = user.getScDept().getDeptId();

		if (Constants.PLANNING_DEPARTMENT.equals(deptId)) {
			this.isPlanningDept = true;
			// 计财处的情况下，只能选择处室，处室list
			ScDept d = deptService.get(deptId);
			deptList = deptService.findDept(d);
		} else {
			// 计财处以外的部门，可以根据项目分类进行统计
			// 计财处以外的部门只能看到属于自己部门的项目分类
			// 项目分类List
			this.isPlanningDept = false;
			// projectTypeFirstList =
			// tprojectTypeService.getFatherProjectTypeListByDeptId(deptId);
			this.projectTypeFirstList = tprojectTypeManagerService.getProjectTypeListByUser(user);
		}

		// 所属园区
		centralizedTypeList = mitemService.getListByTypeId(Constants.TYPE_CENTRALIZED_TYPE);

		return "showProjectSearch";
	}

	/**
	 * @comments 分页查询
	 * @return
	 * @throws UnsupportedEncodingException
	 * @Version 1.0
	 */
	public String getList() throws UnsupportedEncodingException {

		// 取得登录用户的信息
		HttpSession session = this.getRequest().getSession();
		ScUsers user = (ScUsers) session.getAttribute("sysUser");
		// 如果用户为空或者企业为空，退出系统
		if (user == null || ("").equals(user.getUserId())) {
			return "LogOut";
		}
		// 用户所在部门ID
		String userDeptId = user.getScDept().getDeptId();
		// 查询条件
		Map<String, Object> params = this.getCondition();
		params.put("userDeptId", userDeptId);
		// 专员查询字符串
		String projectTypeStr = tprojectTypeManagerService.getProjectTypeStrByUser(user);
		params.put("projectTypeStr", projectTypeStr);
		// 将该作成的查询条件保存到Session中，在打印的时候从Session中取得查询条件
		session.setAttribute("SearchParam", params);

		// 设置分页参数
		if (pager == null && this.getPageNo() == 0) {
			pager = new Pager();
		} else {
			pager = new Pager();
			pager.setPageNumber(this.getPageNo());
		}

		// 取得项目一览信息
		pager = vprojectResultCollectService.find(params, pager.getPageNumber(), pager.getPageSize());

		if (pager.getList().size() > 0) {
			printEnableFlag = true;
		} else {
			printEnableFlag = false;
		}
		// 跳转到页面
		return "showProjectList";
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
	 * @comments 作成检索条件
	 * @return
	 * @version 1.0
	 */
	private Map<String, Object> getCondition() {

		Map<String, Object> param = new HashMap<String, Object>();
		// 申报年度
		param.put("reportYear", this.selectedReportYear);
		// 项目父分类（一级）
		param.put("parentProjectType", this.selectedProjectTypeFirst);
		// 项目子分类（二级）
		param.put("sonProjectType", this.selectedProjectTypeSecond);
		// 部门
		param.put("selectedDeptId", this.selectedDept);
		// 项目名称
		param.put("projectName", this.projectName);
		// 所属园区
		param.put("centralizedType", this.centralizedType);
		// 承担单位
		param.put("applicationUnit", this.applicationUnit);

		return param;
	}

	/**
	 * 
	 * @comments 取得可以导出的数据的数目，如果为0条以上，返回true，0条的时候返回false
	 * @return
	 * @version 1.0
	 */
	public String checkExportDataNum() {
		String checkRes = "false";
		// 取得登录用户的信息
		HttpSession session = this.getRequest().getSession();
		ScUsers user = (ScUsers) session.getAttribute("sysUser");
		String userDeptId = user.getScDept().getDeptId();
		// 取得查询条件
		Map<String, Object> params = new HashMap<String, Object>();

		params.put("userDeptId", userDeptId);
		params.put("reportYear", mitemService.get(Constants.APPLY_YEAR).getItemDesc());

		Map<String, List<VprojectResultCollect>> allResultData = vprojectResultCollectService.getAllResultData(params);
		if (allResultData == null || allResultData.size() <= 0) {
			checkRes = "true";
		}
		this.backStr = checkRes;
		return "checkExportDataNum";
	}

	/**
	 * @comments 导出excel文件
	 * @throws Exception
	 * @Version 1.0
	 */
	@SuppressWarnings("unchecked")
	public void exportDatas() throws Exception {

		// 取得登录用户的信息
		HttpSession session = this.getRequest().getSession();
		ScUsers user = (ScUsers) session.getAttribute("sysUser");
		String userDeptId = user.getScDept().getDeptId();
		// 取得查询条件
		Map<String, Object> params = new HashMap<String, Object>();
		if ("resultCollect".equals(jumpFlag)) {
			params = (Map<String, Object>) session.getAttribute("SearchParam");
		} else {
			params.put("userDeptId", userDeptId);
			params.put("reportYear", mitemService.get(Constants.APPLY_YEAR).getItemDesc());
		}
		// 取得分组数(如果查询条件中项目分类只选择一级分类，需要查询该一级分类下的子分类，每个子分类作为一个sheet输出)
		// 计财处登录的时候按照部门分组
		// 有多个子分类或者多个部门存在的时候需要输入统计信息
		List<String> groupInfo = null;

		// 登录用户为计财处时，以业务处室为单位统计，
		// 登录用户为业务处室时，以项目分类的子分类为单位统计
		Boolean isPlanningUser = false;
		isPlanningUser = Constants.PLANNING_DEPARTMENT.equals(userDeptId);
		// EXCEL文件名
		StringBuffer excelFileName = new StringBuffer();
		excelFileName.append(params.get("reportYear"));
		excelFileName.append("年");
		// 该flag用来区分在计财处用户登录时sheet的名字是取部门名还是取计划类别的名字
		// 如果为false，取部门名称，如果为true，取计划类别的名字
		Boolean planningUserTypeFlag = false;
		if (isPlanningUser) {
			// 选择了具体的处室,没有选择计划类别时，groupInfo就是当前选择的该处室下的计划类别
			// 没有选择的时候从视图中查询，以处室为单位
			if (params.containsKey("selectedDeptId") && params.get("selectedDeptId") != null && params.get("selectedDeptId").toString().length() > 0) {
				// ========2013/09/26 start=========
				groupInfo = new ArrayList<String>();
				if (params.containsKey("parentProjectType") && params.get("parentProjectType") != null && params.get("parentProjectType").toString().length() > 0) {
					groupInfo.add(params.get("parentProjectType").toString());
				} else {
					groupInfo = vprojectResultCollectService.getProjectTypeListByDeptId(params);
				}
				planningUserTypeFlag = true;
				// ========2013/09/26 end=========
				// groupInfo = new ArrayList<String>();
				// groupInfo.add(params.get("selectedDeptId").toString());
			} else {
				groupInfo = vprojectResultCollectService.getDeptList(params);
				planningUserTypeFlag = false;
			}
			// 作成文件名
			excelFileName.append("计财处申报项目");
		} else {
			// 选择了项目子分类时，groupInfo中的元素只有当前选择的子分类一个
			// 没有选择子分类时，groupInfo中的元素从视图中查询
			if (params.containsKey("sonProjectType") && params.get("sonProjectType") != null && params.get("sonProjectType").toString().length() > 0) {
				groupInfo = new ArrayList<String>();
				groupInfo.add(params.get("sonProjectType").toString());
				// 文件名 选择了二级分类时为 一级分类名+二级分类名
				excelFileName.append(tprojectTypeService.getProjectTypeName(params.get("parentProjectType").toString()));
				excelFileName.append(tprojectTypeService.getProjectTypeName(params.get("sonProjectType").toString()));
			} else {
				groupInfo = vprojectResultCollectService.getGroupInfo(params);
				if (params.containsKey("parentProjectType") && params.get("parentProjectType") != null && params.get("parentProjectType").toString().length() > 0) {
					// 文件名 没有选择二级分类时为一级分类名
					excelFileName.append(tprojectTypeService.getProjectTypeName(params.get("parentProjectType").toString()));
				} else {
					// 文件名 没有选择一级分类时为部门名称
					// 取得用户的部门ID
					String deptId = user.getScDept().getDeptId();
					excelFileName.append(deptService.get(deptId).getDeptName());
				}
			}
		}
		excelFileName.append("结果汇总");
		SimpleDateFormat sf = new SimpleDateFormat("(yyyyMMdd)");
		excelFileName.append(sf.format(new Date()));
		Map<String, List<VprojectResultCollect>> allResultData = vprojectResultCollectService.getAllResultData(params);

		// ==============合计 start============
		// 判断取得的分组信息，如果分组数大于1条（2条以上，包括2条）的时候，
		// 增加一个合计分组，用来统计所有分组的信息
		if (groupInfo != null && groupInfo.size() > 1) {
			groupInfo.add("heji");

			// 将所有的查询结果都放到合计中
			List<VprojectResultCollect> countData = new ArrayList<VprojectResultCollect>();
			for (String mapKey : allResultData.keySet()) {
				countData.addAll(allResultData.get(mapKey));
			}
			allResultData.put("heji", countData);
		}
		// ==============合计 end============

		// 生成excel
		this.createOutExcel(groupInfo, allResultData, isPlanningUser, excelFileName.toString(), planningUserTypeFlag, params);
		// 移除session中的查询条件
		session.removeAttribute("SearchParam");

	}

	/**
	 * 
	 * @comments 生成EXCEL
	 * @param groupInfo
	 * @param allResultData
	 * @param isPlanningUser
	 * @param fileName
	 * @param planningUserTypeFlag
	 * @param params
	 * @throws IOException
	 * @throws WriteException
	 * @version 1.0
	 */
	private void createOutExcel(List<String> groupInfo, Map<String, List<VprojectResultCollect>> allResultData, Boolean isPlanningUser, String fileName, Boolean planningUserTypeFlag,
			Map<String, Object> params) throws IOException, WriteException {
		// response
		HttpServletResponse response = ServletActionContext.getResponse();
		// 清空输出流
		response.reset();

		// 设定输出文件头
		response.setHeader("Content-Disposition", "attachment; filename=\"" + new String(fileName.getBytes("GB2312"), "8859_1") + ".xls\"");

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

		File fileModel = new File(modelInputPath + Constants.DATA_COUNT_MODEL_FILENAME);
		try {
			Workbook wk = Workbook.getWorkbook(fileModel);
			WorkbookSettings settings = new WorkbookSettings();
			settings.setWriteAccess(null);

			WritableWorkbook outWorkBook = Workbook.createWorkbook(out, wk);

			// ===========生成sheet start============
			// 根据子分类的个数拷贝sheet，只有一个的时候不用拷贝
			if (groupInfo != null && groupInfo.size() == 1) {
				// 设置第一个sheet的名称，目前是临时的名称，为子分类的ID
				outWorkBook.getSheets()[0].setName(groupInfo.get(0).substring(1));
			}
			// 当子分类的个数超过一个时，拷贝子分类个数个新的sheet，
			// 新sheet的名称为子分类ID
			if (groupInfo != null && groupInfo.size() > 1) {
				// 设置第一个sheet的名称，目前是临时的名称，为子分类的ID
				outWorkBook.getSheets()[0].setName(groupInfo.get(0).substring(1));
				for (int i = 1; i < groupInfo.size(); i++) {
					outWorkBook.copySheet(groupInfo.get(0).substring(1), groupInfo.get(i).substring(1), i);
				}
			}
			// ===========生成sheet end============

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

			// 数字格式，保留4位小数（9999999.9999）
			NumberFormat nf = new NumberFormat("0.0###");
			WritableCellFormat numcf = new WritableCellFormat(nf);
			// 设置边框
			numcf.setBorder(Border.ALL, BorderLineStyle.THIN);
			// 垂直居中显示
			numcf.setVerticalAlignment(VerticalAlignment.CENTRE);
			numcf.setFont(wf2);

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

			// 表头格式
			WritableCellFormat headerCf = new WritableCellFormat();
			// 设置边框
			headerCf.setBorder(Border.ALL, BorderLineStyle.THIN);
			// 垂直居中显示
			headerCf.setVerticalAlignment(VerticalAlignment.CENTRE);
			// 设置自动换行
			headerCf.setWrap(true);
			headerCf.setFont(wf2);
			// 水平居中显示
			headerCf.setAlignment(Alignment.CENTRE);

			// 百分比格式
			NumberFormat precentnf = new NumberFormat("0.00##%");
			WritableCellFormat precentCf = new WritableCellFormat(precentnf);
			// 设置边框
			precentCf.setBorder(Border.ALL, BorderLineStyle.THIN);
			// 垂直居中显示
			precentCf.setVerticalAlignment(VerticalAlignment.CENTRE);
			// 设置字体
			precentCf.setFont(wf2);

			// 计划类别名称格式
			WritableCellFormat typeCf = new WritableCellFormat();
			// 设置边框
			typeCf.setBorder(Border.ALL, BorderLineStyle.THIN);
			// 垂直居中显示
			typeCf.setVerticalAlignment(VerticalAlignment.CENTRE);
			// 水平居中显示
			typeCf.setAlignment(Alignment.CENTRE);
			// 设置字体
			WritableFont wf3 = new WritableFont(WritableFont.createFont("宋体"), 10, WritableFont.BOLD, false);
			typeCf.setFont(wf3);
			// ===========写入数据 Start===========

			for (int i = 0; i < groupInfo.size(); i++) {
				// 取得子类型id
				String typeId = groupInfo.get(i);
				// 根据子类型取得sheet
				WritableSheet sh = outWorkBook.getSheet(typeId.substring(1));
				// 根据子类型取得该sheet中的数据
				List<VprojectResultCollect> shData = allResultData.get(typeId);
				// ===========设定列宽度为======
				for (int k = 5; k < 40; k++) {
					sh.setColumnView(k, 13);
				}
				// 设置第2行39,40列的边框
				sh.addCell(new Label(39, 1, "近三年平均R&D", headerCf));
				Label commentLabel = new Label(40, 1, "专利\n申请专利数（发明项数）/授权专利数（发明项数）", headerCf);
				WritableCellFeatures cellFeatures = new WritableCellFeatures();
				// cellFeatures
				// .setComment("说明：\n假如专利中的值如下：10(1)/20(2)\n其中10为为申请专利数；\n1为申请专利数中的发明项数\n20为授权专利数；\n2为授权专利数中的发明项数");
				cellFeatures.setComment("说明：\n假如专利中的值如下：10(1)/20(2)\n其中10为为申请专利数；\n1为申请专利数中的发明项数\n20为授权专利数；\n2为授权专利数中的发明项数", 4, 5);
				// cellFeatures.setDataValidationRange(col1, row1, col2, row2)
				commentLabel.setCellFeatures(cellFeatures);
				sh.addCell(commentLabel);
				sh.addCell(new Label(41, 1, "院所/高端人才", headerCf));
				sh.addCell(new Label(42, 1, "推荐意见", headerCf));
				sh.addCell(new Label(43, 1, "投资专家平均分", headerCf));
				sh.addCell(new Label(44, 1, "技术专家平均分", headerCf));
				sh.addCell(new Label(45, 1, "投资专家", headerCf));
				sh.addCell(new Label(46, 1, "技术专家", headerCf));
				// 循环写入数据，在计财处且统计单位为业务部门的时候
				if (isPlanningUser && !planningUserTypeFlag) {
					// 取得该部门下的所有计划类别
					// 循环计划类别
					List<String> projectTypeList = new ArrayList<String>();
					if ("heji".equals(typeId)) {
						projectTypeList.add("heji");
					} else {
						Map<String, Object> newParams = new HashMap<String, Object>();
						newParams.putAll(params);
						newParams.put("selectedDeptId", typeId);
						projectTypeList = vprojectResultCollectService.getProjectTypeListByDeptId(newParams);
					}

					if (projectTypeList != null && projectTypeList.size() > 0) {
						// 用来写入的行号
						int rowNum = 4;
						// 用来记录项目的序列号
						int indexNum = 1;
						// 循环计划类别，将该部门下的项目按照计划类别分类
						List<VprojectResultCollect> subData = null;
						for (int m = 0; m < projectTypeList.size(); m++) {
							subData = new ArrayList<VprojectResultCollect>();
							String projectTypeName = "";
							if ("heji".equals(typeId)) {
								subData = shData;
							} else {
								// 按照计划类别id分类
								for (VprojectResultCollect vprojectResultCollect : shData) {
									if (vprojectResultCollect.getParentTypeId().equals(projectTypeList.get(m))) {
										subData.add(vprojectResultCollect);
									}
								}
								projectTypeName = tprojectTypeService.getProjectTypeName(projectTypeList.get(m));
								// 序列
								sh.addCell(new Label(0, rowNum, "", headerCf));
								// 计划类别
								sh.addCell(new Label(1, rowNum, projectTypeName, typeCf));
								sh.mergeCells(1, rowNum, 4, rowNum);
								// 将5--46列设置为空
								for (int n = 5; n < 47; n++) {
									sh.addCell(new Label(n, rowNum, "", cf));
								}
								// 设定行高度
								sh.setRowView(rowNum, 500);
								rowNum = rowNum + 1;
							}

							// 循环写入数据
							for (int j = 0; j < subData.size(); j++) {
								// 在写出第一条数据前先写excel中的公共字段
								// 近1年年度（预期效益）
								String expectStarStr = "项目预期经济效益（";
								String expectEndStr = "年）";
								String yearCompanyOperate = "年企业经营状况";

								// ================合计 start===================
								// 当分组数groupInfo.size大于两个的时候，最后一个为合计页
								if (i > 1 && i == groupInfo.size() - 1) {
									// 设置合计页的基本信息
									// Title
									sh.addCell(new Label(0, 0, "项目一览统计", titleCf));
									setHeaderData(headerCf, sh, subData, expectStarStr, expectEndStr, yearCompanyOperate);
									// 设定sheet名
									sh.setName("合计");
								}
								// ================合计 end===================
								else {
									// ============设置sheet中的标题和表头
									// start==========
									if (j == 0) {
										// Title
										StringBuffer title = new StringBuffer();
										title.append(subData.get(0).getReportYear());
										title.append("年");
										String deptName = "";
										if (isPlanningUser) {

											if (planningUserTypeFlag) {
												// true的时候以计划类别为单位导出excel
												title.append(deptService.get(subData.get(0).getDepartmentId()).getDeptName());
												title.append("——");
												title.append(subData.get(0).getParentTypeName());
											} else {
												deptName = deptService.get(typeId).getDeptName();
												title.append(deptName);
											}

											title.append("项目统计");
										} else {
											title.append(subData.get(0).getParentTypeName());
											title.append(subData.get(0).getTypeShowName());
										}

										sh.addCell(new Label(0, 0, title.toString(), titleCf));
										// 设定表头的两个近三年的数据
										setHeaderData(headerCf, sh, subData, expectStarStr, expectEndStr, yearCompanyOperate);
										// 设定sheet名
										if (isPlanningUser) {
											if (planningUserTypeFlag) {
												// 取计划类别的名称为sheet名
												sh.setName(subData.get(0).getParentTypeName());
											} else {
												// 取部门的名称为sheet名
												sh.setName(deptName);
											}

										} else {
											sh.setName(subData.get(0).getTypeShowName());
										}
									}
									// ============设置sheet中的标题和表头 end==========
								}
								writeProjectData(cf, numcf, precentCf, sh, rowNum, indexNum, subData, j);
								// 设定行高度
								sh.setRowView(rowNum, 500);
								rowNum = rowNum + 1;
								indexNum = indexNum + 1;
							}
						}
						// 设置合计行和平均值行
						if (subData != null && subData.size() > 0) {
							writeCountAndAverage(numcf, precentCf, sh, rowNum);
						}
					}
				} else {
					// 循环写入数据
					for (int j = 0; j < shData.size(); j++) {
						// 在写出第一条数据前先写excel中的公共字段
						// 近1年年度（预期效益）
						String expectStarStr = "项目预期经济效益（";
						String expectEndStr = "年）";
						String yearCompanyOperate = "年企业经营状况";

						// ================合计 start===================
						// 当分组数groupInfo.size大于两个的时候，最后一个为合计页
						if (i > 1 && i == groupInfo.size() - 1) {
							// 设置合计页的基本信息
							// Title
							sh.addCell(new Label(0, 0, "项目一览统计", titleCf));
							// 设定表头的两个近三年的数据
							setHeaderData(headerCf, sh, shData, expectStarStr, expectEndStr, yearCompanyOperate);
							// 设定sheet名
							sh.setName("合计");
						}
						// ================合计 end===================
						else {
							// ============设置sheet中的标题和表头 start==========
							if (j == 0) {
								// Title
								StringBuffer title = new StringBuffer();
								title.append(shData.get(0).getReportYear());
								title.append("年");
								String deptName = "";
								if (isPlanningUser) {

									if (planningUserTypeFlag) {
										// true的时候以计划类别为单位导出excel
										title.append(deptService.get(shData.get(0).getDepartmentId()).getDeptName());
										title.append("——");
										title.append(shData.get(0).getParentTypeName());
									} else {
										deptName = deptService.get(typeId).getDeptName();
										title.append(deptName);
									}

									title.append("项目统计");
								} else {
									title.append(shData.get(0).getParentTypeName());
									title.append(shData.get(0).getTypeShowName());
								}

								sh.addCell(new Label(0, 0, title.toString(), titleCf));
								// 设定表头的两个近三年的数据
								setHeaderData(headerCf, sh, shData, expectStarStr, expectEndStr, yearCompanyOperate);
								// 设定sheet名
								if (isPlanningUser) {
									if (planningUserTypeFlag) {
										// 取计划类别的名称为sheet名
										sh.setName(shData.get(0).getParentTypeName());
									} else {
										// 取部门的名称为sheet名
										sh.setName(deptName);
									}
								} else {
									sh.setName(shData.get(0).getTypeShowName());
								}
							}
							// ============设置sheet中的标题和表头 end==========
						}
						// 写入数据
						writeProjectData(cf, numcf, precentCf, sh, j + 4, j + 1, shData, j);

						// 设定行高度
						sh.setRowView(j + 4, 500);
					}

					// 设置合计行和平均值行
					if (shData != null && shData.size() > 0) {
						writeCountAndAverage(numcf, precentCf, sh, shData.size() + 4);
					}
				}
				// 将不需要的列隐藏起来
				CellView cv = new CellView();
				cv.setHidden(true);
				// 企业经营状况
				for (int k = 11; k <= 22; k++) {
					sh.setColumnView(k, cv);
				}
				// 项目预期经济效益
				for (int k = 32; k <= 37; k++) {
					sh.setColumnView(k, cv);
				}
			}
			// ===========写入数据 end===========

			outWorkBook.write();
			out.flush();
			outWorkBook.close();
			wk.close();
			response.flushBuffer();

		} catch (BiffException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 
	 * @comments 设定表头的两个近三年的数据
	 * @param headerCf
	 * @param sh
	 * @param subData
	 * @param expectStarStr
	 * @param expectEndStr
	 * @param yearCompanyOperate
	 * @throws WriteException
	 * @throws RowsExceededException
	 * @version 1.0
	 */
	private void setHeaderData(WritableCellFormat headerCf, WritableSheet sh, List<VprojectResultCollect> subData, String expectStarStr, String expectEndStr, String yearCompanyOperate)
			throws WriteException, RowsExceededException {
		// 近一年企业经营状况的年度
		sh.addCell(new Label(5, 1, subData.get(0).getYearOperate1().toString() + yearCompanyOperate, headerCf));
		// 近二年企业经营状况的年度
		sh.addCell(new Label(11, 1, subData.get(0).getYearOperate2().toString() + yearCompanyOperate, headerCf));
		// 近三年企业经营状况的年度
		sh.addCell(new Label(17, 1, subData.get(0).getYearOperate3().toString() + yearCompanyOperate, headerCf));

		sh.addCell(new Label(29, 1, expectStarStr + subData.get(0).getYearBenefit1() + expectEndStr, headerCf));
		// 近2年年度（预期效益）
		sh.addCell(new Label(32, 1, expectStarStr + subData.get(0).getYearBenefit2() + expectEndStr, headerCf));
		// 近3年年度（预期效益）
		sh.addCell(new Label(35, 1, expectStarStr + subData.get(0).getYearBenefit3() + expectEndStr, headerCf));
	}

	/**
	 * 
	 * @comments 写入合计行和平均值行
	 * @param numcf
	 * @param precentCf
	 * @param sh
	 * @param rowNum
	 * @throws WriteException
	 * @throws RowsExceededException
	 * @version 1.0
	 */
	private void writeCountAndAverage(WritableCellFormat numcf, WritableCellFormat precentCf, WritableSheet sh, int rowNum) throws WriteException, RowsExceededException {
		// int maxDataRow = shData.size() + 4;
		int maxDataRow = rowNum;
		// ======格式=========
		// 单元格边框格式
		WritableCellFormat countCf = new WritableCellFormat();
		// 设置边框
		countCf.setBorder(Border.ALL, BorderLineStyle.THIN);
		// 垂直居中显示
		countCf.setVerticalAlignment(VerticalAlignment.CENTRE);
		// 水平居中显示
		countCf.setAlignment(Alignment.CENTRE);

		// 合计行
		int sumRow = rowNum;
		// 设定合计行高度
		sh.setRowView(sumRow, 500);
		// 设定合计行
		setCountData(numcf, sh, sumRow, maxDataRow, countCf, "合计", "SUM", precentCf);
		// 平均值行
		int averageRow = rowNum + 1;
		// 设定合计行高度
		sh.setRowView(averageRow, 500);
		// 设定平均值行
		setCountData(numcf, sh, averageRow, maxDataRow, countCf, "平均", "AVERAGE", precentCf);
	}

	/**
	 * 
	 * @comments 写入一行数据
	 * @param cf
	 * @param numcf
	 * @param precentCf
	 * @param sh
	 * @param rowNum
	 * @param indexNum
	 * @param subData
	 * @param j
	 * @throws WriteException
	 * @throws RowsExceededException
	 * @version 1.0
	 */
	private void writeProjectData(WritableCellFormat cf, WritableCellFormat numcf, WritableCellFormat precentCf, WritableSheet sh, int rowNum, int indexNum, List<VprojectResultCollect> subData, int j)
			throws WriteException, RowsExceededException {
		// 序列
		sh.addCell(new Number(0, rowNum, indexNum, cf));
		// 项目单位
		sh.addCell(new Label(1, rowNum, subData.get(j).getApplicationUnit(), cf));
		// 项目名称
		sh.addCell(new Label(2, rowNum, subData.get(j).getProjectName(), cf));
		// 所属园区
		sh.addCell(new Label(3, rowNum, subData.get(j).getCentralizedTypeName(), cf));
		// 行业领域
		sh.addCell(new Label(4, rowNum, subData.get(j).getTechnicalFisldName(), cf));
		// 近一年企业经营状况
		// 销售收入
		sh.addCell(new Number(5, rowNum, subData.get(j).getSalesOperate1(), numcf));
		// 利润
		sh.addCell(new Number(6, rowNum, subData.get(j).getProfitOperate1(), numcf));
		// 缴税
		sh.addCell(new Number(7, rowNum, subData.get(j).getTaxOperate1(), numcf));
		// 利税率
		sh.addCell(new Number(8, rowNum, getDoubleValue(subData.get(j).getInterestRateOperate1()) / 100, precentCf));
		// R&D
		sh.addCell(new Number(9, rowNum, subData.get(j).getRdOperate1() / 100, precentCf));
		// 研发投入
		sh.addCell(new Number(10, rowNum, subData.get(j).getInvestmentOperate1(), numcf));

		// 近两年企业经营状况
		// 销售收入
		sh.addCell(new Number(11, rowNum, subData.get(j).getSalesOperate2(), numcf));
		// 利润
		sh.addCell(new Number(12, rowNum, subData.get(j).getProfitOperate2(), numcf));
		// 缴税
		sh.addCell(new Number(13, rowNum, subData.get(j).getTaxOperate2(), numcf));
		// 利税率
		sh.addCell(new Number(14, rowNum, getDoubleValue(subData.get(j).getInterestRateOperate2()) / 100, precentCf));
		// R&D
		sh.addCell(new Number(15, rowNum, subData.get(j).getRdOperate2() / 100, precentCf));
		// 研发投入
		sh.addCell(new Number(16, rowNum, subData.get(j).getInvestmentOperate2(), numcf));

		// 近三年企业经营状况
		// 销售收入
		sh.addCell(new Number(17, rowNum, subData.get(j).getSalesOperate3(), numcf));
		// 利润
		sh.addCell(new Number(18, rowNum, subData.get(j).getProfitOperate3(), numcf));
		// 缴税
		sh.addCell(new Number(19, rowNum, subData.get(j).getTaxOperate3(), numcf));
		// 利税率
		sh.addCell(new Number(20, rowNum, getDoubleValue(subData.get(j).getInterestRateOperate3()) / 100, precentCf));
		// R&D
		sh.addCell(new Number(21, rowNum, subData.get(j).getRdOperate3() / 100, precentCf));
		// 研发投入
		sh.addCell(new Number(22, rowNum, subData.get(j).getInvestmentOperate3(), numcf));

		// 执行期最后一年企业预期销售收入
		sh.addCell(new Number(23, rowNum, subData.get(j).getExpectedSales(), numcf));
		// 执行期最后一年企业预期税收
		sh.addCell(new Number(24, rowNum, subData.get(j).getExpectedTax(), numcf));
		// 执行期最后一年企业预期利润
		sh.addCell(new Number(25, rowNum, subData.get(j).getExpectedProfits(), numcf));
		// 近3年利税率
		sh.addCell(new Number(26, rowNum, getDoubleValue(subData.get(j).getInterestRateThreeYears()) / 100, precentCf));
		// 近3年平均增速
		sh.addCell(new Number(27, rowNum, getDoubleValue(subData.get(j).getAverageGrowthThreeYears()) / 100, precentCf));
		// 企业预期增速
		sh.addCell(new Number(28, rowNum, getDoubleValue(subData.get(j).getCompanyExpectedGrowth()) / 100, precentCf));

		// 项目预期经济效益（第一年）
		// 累计销售收入
		sh.addCell(new Number(29, rowNum, subData.get(j).getSalesBenefit3(), numcf));
		// 累计利润
		sh.addCell(new Number(30, rowNum, subData.get(j).getProfitBenefit3(), numcf));
		// 累计税收
		sh.addCell(new Number(31, rowNum, subData.get(j).getTaxBenefit3(), numcf));

		// 项目预期经济效益（第二年）
		// 累计销售收入
		sh.addCell(new Number(32, rowNum, subData.get(j).getSalesBenefit2(), numcf));
		// 累计利润
		sh.addCell(new Number(33, rowNum, subData.get(j).getProfitBenefit2(), numcf));
		// 累计税收
		sh.addCell(new Number(34, rowNum, subData.get(j).getTaxBenefit2(), numcf));

		// 项目预期经济效益（第三年）
		// 累计销售收入
		sh.addCell(new Number(35, rowNum, subData.get(j).getSalesBenefit1(), numcf));
		// 累计利润
		sh.addCell(new Number(36, rowNum, subData.get(j).getProfitBenefit1(), numcf));
		// 累计税收
		sh.addCell(new Number(37, rowNum, subData.get(j).getTaxBenefit1(), numcf));

		// 项目预期增速
		sh.addCell(new Number(38, rowNum, getDoubleValue(subData.get(j).getProjectExpectedGrowth()) / 100, precentCf));
		// 近三年平均R&D
		sh.addCell(new Number(39, rowNum, subData.get(j).getRdThreeYears() / 100, precentCf));
		// 专利
		sh.addCell(new Label(40, rowNum, subData.get(j).getPatent(), cf));

		// 院所/高端人才
		sh.addCell(new Label(41, rowNum, subData.get(j).getInstitutesHighTalent(), cf));
		// 推荐意见
		String comm = subData.get(j).getRecommendation();
		String outComm = "";
		if (CommonTool.IsNotEmpty(comm)) {
			outComm = mitemService.getMitemNameById(comm);
		}
		sh.addCell(new Label(42, rowNum, outComm, cf));
		// 投资专家平均分
		sh.addCell(new Number(43, rowNum, getDoubleValue(subData.get(j).getAverageInvestmentExperts()), cf));
		// 技术专家平均分
		sh.addCell(new Number(44, rowNum, getDoubleValue(subData.get(j).getAverageTechnicalExperts()), cf));
		// 投资专家
		sh.addCell(new Label(45, rowNum, subData.get(j).getInvestmentExperts(), cf));
		// 技术专家
		sh.addCell(new Label(46, rowNum, subData.get(j).getTechnicalExperts(), cf));

	}

	/**
	 * @comments 转换成doulbe型
	 * @param d
	 * @return
	 * @version 1.0
	 */
	private double getDoubleValue(String d) {
		if (null == d || "".equals(d)) {
			return 0;
		} else {
			return Double.parseDouble(d);
		}
	}

	/**
	 * 
	 * @comments 设定统计数据（合计值或者平均值）
	 * @param cf
	 * @param sh
	 * @param countRow
	 * @param sumCf
	 * @param countStr
	 * @param formula
	 * @param precentCf
	 * @throws WriteException
	 * @throws RowsExceededException
	 * @version 1.0
	 */
	private void setCountData(WritableCellFormat cf, WritableSheet sh, int countRow, int maxRow, WritableCellFormat sumCf, String countStr, String formula, WritableCellFormat precentCf)
			throws WriteException, RowsExceededException {
		// 合计
		sh.addCell(new Label(0, countRow, countStr, sumCf));
		// 合并单元格
		sh.mergeCells(0, countRow, 2, countRow);
		// 所属园区
		sh.addCell(new Blank(3, countRow, cf));
		// 行业领域
		sh.addCell(new Blank(4, countRow, cf));
		// 近一年企业经营状况
		// 销售收入
		sh.addCell(new Formula(5, countRow, getFormula(maxRow, formula, "F"), cf));
		// 利润
		sh.addCell(new Formula(6, countRow, getFormula(maxRow, formula, "G"), cf));
		// 缴税
		sh.addCell(new Formula(7, countRow, getFormula(maxRow, formula, "H"), cf));
		if ("SUM".equals(formula)) {
			// 利税率
			sh.addCell(new Blank(8, countRow, cf));
			// R&D
			sh.addCell(new Blank(9, countRow, cf));
		} else {
			// 利税率
			sh.addCell(new Formula(8, countRow, getFormula(maxRow, formula, "I"), precentCf));
			// R&D
			sh.addCell(new Formula(9, countRow, getFormula(maxRow, formula, "J"), precentCf));
		}

		// 研发投入
		sh.addCell(new Formula(10, countRow, getFormula(maxRow, formula, "K"), cf));

		// 近两年企业经营状况
		// 销售收入
		sh.addCell(new Formula(11, countRow, getFormula(maxRow, formula, "L"), cf));
		// 利润
		sh.addCell(new Formula(12, countRow, getFormula(maxRow, formula, "M"), cf));
		// 缴税
		sh.addCell(new Formula(13, countRow, getFormula(maxRow, formula, "N"), cf));
		if ("SUM".equals(formula)) {
			// 利税率
			sh.addCell(new Blank(14, countRow, cf));
			// R&D
			sh.addCell(new Blank(15, countRow, cf));
		} else {
			// 利税率
			sh.addCell(new Formula(14, countRow, getFormula(maxRow, formula, "O"), precentCf));
			// R&D
			sh.addCell(new Formula(15, countRow, getFormula(maxRow, formula, "P"), precentCf));
		}
		// 研发投入
		sh.addCell(new Formula(16, countRow, getFormula(maxRow, formula, "Q"), cf));

		// 近三年企业经营状况
		// 销售收入
		sh.addCell(new Formula(17, countRow, getFormula(maxRow, formula, "R"), cf));
		// 利润
		sh.addCell(new Formula(18, countRow, getFormula(maxRow, formula, "S"), cf));
		// 缴税
		sh.addCell(new Formula(19, countRow, getFormula(maxRow, formula, "T"), cf));
		if ("SUM".equals(formula)) {
			// 利税率
			sh.addCell(new Blank(20, countRow, cf));
			// R&D
			sh.addCell(new Blank(21, countRow, cf));
		} else {
			// 利税率
			sh.addCell(new Formula(20, countRow, getFormula(maxRow, formula, "U"), precentCf));
			// R&D
			sh.addCell(new Formula(21, countRow, getFormula(maxRow, formula, "V"), precentCf));
		}
		// 研发投入
		sh.addCell(new Formula(22, countRow, getFormula(maxRow, formula, "W"), cf));

		// 执行期最后一年企业预期销售收入
		sh.addCell(new Formula(23, countRow, getFormula(maxRow, formula, "X"), cf));
		// 执行期最后一年企业预期税收
		sh.addCell(new Formula(24, countRow, getFormula(maxRow, formula, "Y"), cf));
		// 执行期最后一年企业预期利润
		sh.addCell(new Formula(25, countRow, getFormula(maxRow, formula, "Z"), cf));
		if ("SUM".equals(formula)) {
			// 近3年利税率
			sh.addCell(new Blank(26, countRow, cf));
			// 近3年平均增速
			sh.addCell(new Blank(27, countRow, cf));
			// 企业预期增速
			sh.addCell(new Blank(28, countRow, cf));
		} else {
			// 近3年利税率
			sh.addCell(new Formula(26, countRow, getFormula(maxRow, formula, "AA"), precentCf));
			// 近3年平均增速
			sh.addCell(new Formula(27, countRow, getFormula(maxRow, formula, "AB"), precentCf));
			// 企业预期增速
			sh.addCell(new Formula(28, countRow, getFormula(maxRow, formula, "AC"), precentCf));
		}

		// 项目预期经济效益（第一年）
		// 累计销售收入
		sh.addCell(new Formula(29, countRow, getFormula(maxRow, formula, "AD"), cf));
		// 累计利润
		sh.addCell(new Formula(30, countRow, getFormula(maxRow, formula, "AE"), cf));
		// 累计税收
		sh.addCell(new Formula(31, countRow, getFormula(maxRow, formula, "AF"), cf));

		// 项目预期经济效益（第二年）
		// 累计销售收入
		sh.addCell(new Formula(32, countRow, getFormula(maxRow, formula, "AG"), cf));
		// 累计利润
		sh.addCell(new Formula(33, countRow, getFormula(maxRow, formula, "AH"), cf));
		// 累计税收
		sh.addCell(new Formula(34, countRow, getFormula(maxRow, formula, "AI"), cf));

		// 项目预期经济效益（第三年）
		// 累计销售收入
		sh.addCell(new Formula(35, countRow, getFormula(maxRow, formula, "AJ"), cf));
		// 累计利润
		sh.addCell(new Formula(36, countRow, getFormula(maxRow, formula, "AK"), cf));
		// 累计税收
		sh.addCell(new Formula(37, countRow, getFormula(maxRow, formula, "AL"), cf));

		if ("SUM".equals(formula)) {
			// 项目预期增速
			sh.addCell(new Blank(38, countRow, cf));
			// 近三年平均R&D
			sh.addCell(new Blank(39, countRow, cf));
		} else {
			// 项目预期增速
			sh.addCell(new Formula(38, countRow, getFormula(maxRow, formula, "AM"), precentCf));
			// 近三年平均R&D
			sh.addCell(new Formula(39, countRow, getFormula(maxRow, formula, "AN"), precentCf));
		}
		// 专利
		sh.addCell(new Blank(40, countRow, cf));
		// 院所/高端人才
		sh.addCell(new Blank(41, countRow, cf));
		// 推荐意见
		sh.addCell(new Blank(42, countRow, cf));
		// 投资专家平均分
		sh.addCell(new Blank(43, countRow, cf));
		// 技术专家平均分
		sh.addCell(new Blank(44, countRow, cf));
		// 投资专家
		sh.addCell(new Blank(45, countRow, cf));
		// 技术专家
		sh.addCell(new Blank(46, countRow, cf));

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
	private String getFormula(int maxDataRow, String formulaStr, String columnStr) {
		StringBuffer outStrBuf = new StringBuffer();
		outStrBuf.append(formulaStr);
		outStrBuf.append("(");
		outStrBuf.append(columnStr);
		outStrBuf.append("5:");
		outStrBuf.append(columnStr);
		outStrBuf.append(maxDataRow);
		outStrBuf.append(")");
		return outStrBuf.toString();
	}

	public List<Mitem> getMenuList() {
		return menuList;
	}

	public void setMenuList(List<Mitem> menuList) {
		this.menuList = menuList;
	}

	public int getPageNo() {
		return pageNo;
	}

	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}

	public List<String> getReportYearList() {
		return reportYearList;
	}

	public void setReportYearList(List<String> reportYearList) {
		this.reportYearList = reportYearList;
	}

	public String getSelectedReportYear() {
		return selectedReportYear;
	}

	public void setSelectedReportYear(String selectedReportYear) {
		this.selectedReportYear = selectedReportYear;
	}

	public String getReportYear() {
		return reportYear;
	}

	public void setReportYear(String reportYear) {
		this.reportYear = reportYear;
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

	public List<ScDept> getDeptList() {
		return deptList;
	}

	public void setDeptList(List<ScDept> deptList) {
		this.deptList = deptList;
	}

	public String getPitemId() {
		return pitemId;
	}

	public void setPitemId(String pitemId) {
		this.pitemId = pitemId;
	}

	public String getBackStr() {
		return backStr;
	}

	public void setBackStr(String backStr) {
		this.backStr = backStr;
	}

	public String getSelectedProjectTypeFirst() {
		return selectedProjectTypeFirst;
	}

	public void setSelectedProjectTypeFirst(String selectedProjectTypeFirst) {
		this.selectedProjectTypeFirst = selectedProjectTypeFirst;
	}

	public String getSelectedProjectTypeSecond() {
		return selectedProjectTypeSecond;
	}

	public void setSelectedProjectTypeSecond(String selectedProjectTypeSecond) {
		this.selectedProjectTypeSecond = selectedProjectTypeSecond;
	}

	public Boolean getIsPlanningDept() {
		return isPlanningDept;
	}

	public void setIsPlanningDept(Boolean isPlanningDept) {
		this.isPlanningDept = isPlanningDept;
	}

	public String getSelectedDept() {
		return selectedDept;
	}

	public void setSelectedDept(String selectedDept) {
		this.selectedDept = selectedDept;
	}

	public Boolean getPrintEnableFlag() {
		return printEnableFlag;
	}

	public void setPrintEnableFlag(Boolean printEnableFlag) {
		this.printEnableFlag = printEnableFlag;
	}

	public List<Mitem> getCentralizedTypeList() {
		return centralizedTypeList;
	}

	public void setCentralizedTypeList(List<Mitem> centralizedTypeList) {
		this.centralizedTypeList = centralizedTypeList;
	}

	public String getSearchFlag() {
		return searchFlag;
	}

	public void setSearchFlag(String searchFlag) {
		this.searchFlag = searchFlag;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public String getCentralizedType() {
		return centralizedType;
	}

	public void setCentralizedType(String centralizedType) {
		this.centralizedType = centralizedType;
	}

	public String getApplicationUnit() {
		return applicationUnit;
	}

	public void setApplicationUnit(String applicationUnit) {
		this.applicationUnit = applicationUnit;
	}

	public String getJumpFlag() {
		return jumpFlag;
	}

	public void setJumpFlag(String jumpFlag) {
		this.jumpFlag = jumpFlag;
	}
}