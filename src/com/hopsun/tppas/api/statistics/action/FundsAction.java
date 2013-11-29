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
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
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
import com.hopsun.tppas.api.statistics.service.FundsService;
import com.hopsun.tppas.api.superadmin.service.MitemService;
import com.hopsun.tppas.api.superadmin.service.TprojectTypeManagerService;
import com.hopsun.tppas.api.superadmin.service.TprojectTypeService;
import com.hopsun.tppas.common.Constants;
import com.hopsun.tppas.entity.Mitem;
import com.hopsun.tppas.entity.TappropriationSingle;
import com.hopsun.tppas.entity.TprojectType;

/**
 * 
 * @comments 拨款单统计
 * @author liyilin
 * @date 2013-8-22
 * @version 1.0
 */
public class FundsAction extends BaseAction {

	private static final long serialVersionUID = 1745189142341202314L;

	// public final static Logger LOGGER =
	// Logger.getLogger(ProjectResultCollectAction.class.getName());

	@Resource
	private FundsService fundsService;

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

	/** 检索条件中选中的项目名称 */
	private String projectName;

	/** 选中的部门 */
	private String selectedDept;

	/** 选中的项目分类（一级） */
	private String typeId1;

	/** 选中的项目分类（二级） */
	private String typeId2;

	/** 检索条件中选中的承担单位 */
	private String applicationUnit;
	/** 检索条件中选中的开户银行及行号 */
	private String bank;
	/** 检索条件中选中的本次拨款金额(开始) */
	private String amountFundingStart;
	/** 检索条件中选中的本次拨款金额(结束) */
	private String amountFundingEnd;
	/** 检索条件中选中的计划拨款金额(开始) */
	private String planFundingStart;
	/** 检索条件中选中的计划拨款金额 (结束) */
	private String planFundingEnd;
	/** 检索条件中选中的账号 */
	private String bankAccount;
	/** 检索条件中选中的拨款日期(开始) */
	private String appropriationTimeStart;
	/** 检索条件中选中的拨款日期 (结束) */
	private String appropriationTimeEnd;
	/** 检索条件中选中的备注 */
	private String remark;

	/** 项目分类（一级） */
	private List<TprojectType> typeId1List = new ArrayList<TprojectType>();

	/** 项目分类（二级） */
	private List<TprojectType> typeId2List = new ArrayList<TprojectType>();

	/** 部门List */
	private List<ScDept> deptList = new ArrayList<ScDept>();

	/** 项目分类一级id */
	private String pitemId;

	/** 级联菜单返回值 */
	private String backStr;

	/** 计财处flag 是计财处的时候为true，否则为false */
	private Boolean isPlanningDept;

	/** 打印按钮表示flag */
	private Boolean printEnableFlag;

	/** 导出页面的字段 */
	private List<Object> mapList = new ArrayList<Object>();

	/**
	 * 
	 * @comments 初期化项目结果汇总查询条件
	 * @return
	 * @version 1.0
	 */
	public String init() {

		// 取得登录用户的信息
		HttpSession session = this.getRequest().getSession();
		ScUsers user = (ScUsers) session.getAttribute("sysUser");
		// 如果用户为空或者企业为空，退出系统
		if (user == null || ("").equals(user.getUserId())) {
			return "LogOut";
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
			typeId1List = tprojectTypeManagerService.getProjectTypeListByUser(user);
		}

		return "init";
	}

	/**
	 * @comments 分页查询
	 * @return
	 * @throws UnsupportedEncodingException
	 * @Version 1.0
	 */
	public String queryList() throws UnsupportedEncodingException {

		// 查询条件
		Map<String, Object> params = this.getCondition();

		// 设置分页参数
		if (pager == null && this.getPageNo() == 0) {
			pager = new Pager();
		} else {
			pager = new Pager();
			pager.setPageNumber(this.getPageNo());
		}
		// 取得登录用户的信息
		HttpSession session = this.getRequest().getSession();
		ScUsers user = (ScUsers) session.getAttribute("sysUser");
		// 如果用户为空或者企业为空，退出系统
		if (user == null || ("").equals(user.getUserId())) {
			return "LogOut";
		}
		// 取得用户的部门ID
		String deptId = user.getScDept().getDeptId();

		// 取得项目验收一览信息
		pager = fundsService.find(params, pager.getPageNumber(), pager.getPageSize(), deptId, isPlanningDept);

		if (pager.getList().size() > 0) {
			printEnableFlag = true;
		} else {
			printEnableFlag = false;
		}
		// 跳转到页面
		return "list";
	}

	/**
	 * @comments 页面查询条件
	 * @return
	 * @throws UnsupportedEncodingException
	 * @throws Exception
	 * @Version 1.0
	 */
	private Map<String, Object> getCondition() throws UnsupportedEncodingException {
		// 取得登录用户的信息
		HttpSession session = this.getRequest().getSession();
		ScUsers user = (ScUsers) session.getAttribute("sysUser");

		Map<String, Object> param = new HashMap<String, Object>();
		param.put("projectName", projectName);
		param.put("applicationUnit", applicationUnit);
		param.put("bank", bank);
		param.put("bankAccount", this.bankAccount);
		param.put("amountFundingStart", this.amountFundingStart);
		param.put("amountFundingEnd", amountFundingEnd);
		param.put("planFundingStart", this.planFundingStart);
		param.put("planFundingEnd", planFundingEnd);
		param.put("appropriationTimeStart", this.appropriationTimeStart);
		param.put("appropriationTimeEnd", appropriationTimeEnd);
		param.put("remark", this.remark);
		if (this.isPlanningDept.equals(true)) {
			param.put("selectedDeptId", this.selectedDept);
		}
		param.put("jhlb", tprojectTypeManagerService.getProjectTypeStrByUser(user));
		param.put("typeId1", this.typeId1);
		param.put("typeId2", this.typeId2);
		return param;
	}

	/**
	 * @comments 页面查询条件
	 * @return
	 * @throws UnsupportedEncodingException
	 * @throws Exception
	 * @Version 1.0
	 */
	private Map<String, Object> getCondition2() throws UnsupportedEncodingException {
		// 取得登录用户的信息
		HttpSession session = this.getRequest().getSession();
		ScUsers user = (ScUsers) session.getAttribute("sysUser");

		Map<String, Object> param = new HashMap<String, Object>();
		param.put("projectName", new String(projectName.getBytes("ISO-8859-1"), "UTF-8"));
		param.put("applicationUnit", new String(applicationUnit.getBytes("ISO-8859-1"), "UTF-8"));
		param.put("bank", new String(bank.getBytes("ISO-8859-1"), "UTF-8"));
		param.put("bankAccount", new String(this.bankAccount.getBytes("ISO-8859-1"), "UTF-8"));
		param.put("amountFundingStart", this.amountFundingStart);
		param.put("amountFundingEnd", amountFundingEnd);
		param.put("planFundingStart", this.planFundingStart);
		param.put("planFundingEnd", planFundingEnd);
		param.put("appropriationTimeStart", this.appropriationTimeStart);
		param.put("appropriationTimeEnd", appropriationTimeEnd);
		param.put("remark", new String(this.remark.getBytes("ISO-8859-1"), "UTF-8"));
		if (this.isPlanningDept == true) {
			param.put("selectedDeptId", this.selectedDept);
		}
		param.put("jhlb", tprojectTypeManagerService.getProjectTypeStrByUser(user));
		param.put("typeId1", this.typeId1);
		param.put("typeId2", this.typeId2);

		return param;
	}

	/**
	 * @comments 导出excel文件
	 * @throws Exception
	 * @Version 1.0
	 */
	public void exportDatas() throws Exception {

		// 取得登录用户的信息
		HttpSession session = this.getRequest().getSession();
		ScUsers user = (ScUsers) session.getAttribute("sysUser");
		// 取得查询条件
		Map<String, Object> params = getCondition2();

		// 取得分组数(如果查询条件中项目分类只选择一级分类，需要查询该一级分类下的子分类，每个子分类作为一个sheet输出)
		// 计财处登录的时候按照部门分组
		// 有多个子分类或者多个部门存在的时候需要输入统计信息
		List<String> groupInfo = null;

		// 登录用户为计财处时，以业务处室为单位统计，
		// 登录用户为业务处室时，以项目分类的子分类为单位统计
		Boolean isPlanningUser = false;
		isPlanningUser = Constants.PLANNING_DEPARTMENT.equals(user.getScDept().getDeptId());
		// EXCEL文件名
		StringBuffer excelFileName = new StringBuffer();
		// 该flag用来区分在计财处用户登录时sheet的名字是取部门名还是取计划类别的名字
		// 如果为false，取部门名称，如果为true，取计划类别的名字
		Boolean planningUserTypeFlag = false;
		if (isPlanningUser) {
			// 选择了具体的处室,没有选择计划类别时，groupInfo就是当前选择的该处室下的计划类别
			// 没有选择的时候从视图中查询，以处室为单位
			if (params.containsKey("selectedDeptId") && params.get("selectedDeptId") != null && params.get("selectedDeptId").toString().length() > 0) {
				// ========2013/09/26 start=========
				groupInfo = new ArrayList<String>();
				if (params.containsKey("typeId1") && params.get("typeId1") != null && params.get("typeId1").toString().length() > 0) {
					groupInfo.add(params.get("typeId1").toString());
				} else {
					groupInfo = fundsService.getProjectTypeListByDeptId(params, params.get("selectedDeptId").toString());
				}
				planningUserTypeFlag = true;
				// ========2013/09/26 end=========
				// groupInfo = new ArrayList<String>();
				// groupInfo.add(params.get("selectedDeptId").toString());
			} else {
				groupInfo = fundsService.getDeptList(params);
				planningUserTypeFlag = false;
			}
		} else {
			// 选择了项目子分类时，groupInfo中的元素只有当前选择的子分类一个
			// 没有选择子分类时，groupInfo中的元素从视图中查询
			if (params.containsKey("typeId2") && params.get("typeId2") != null && params.get("typeId2").toString().length() > 0) {
				groupInfo = new ArrayList<String>();
				groupInfo.add(params.get("typeId2").toString());
				// 文件名 选择了二级分类时为 一级分类名+二级分类名
				// excelFileName.append(tprojectTypeService
				// .getProjectTypeName(params.get("typeId1")
				// .toString()));
				// excelFileName.append(tprojectTypeService
				// .getProjectTypeName(params.get("typeId2")
				// .toString()));
			} else {
				groupInfo = fundsService.getGroupInfo(params, user.getScDept().getDeptId());
				if (params.containsKey("typeId1") && params.get("typeId1") != null && params.get("typeId1").toString().length() > 0) {
					// 文件名 没有选择二级分类时为一级分类名
					// excelFileName.append(tprojectTypeService
					// .getProjectTypeName(params.get("typeId1")
					// .toString()));
				} else {
					// 文件名 没有选择一级分类时为部门名称
					// 取得用户的部门ID
					//String deptId = user.getScDept().getDeptId();
					// excelFileName.append(deptService.get(deptId).getDeptName());
				}
			}
		}
		excelFileName.append(this.getText("tappropriationSingle"));
		SimpleDateFormat sf = new SimpleDateFormat("(yyyyMMdd)");
		excelFileName.append(sf.format(new Date()));
		Map<String, List<TappropriationSingle>> datas = fundsService.getAllResultData(params, user.getScDept().getDeptId(), isPlanningUser);

		// ==============合计 start============
		// 判断取得的分组信息，如果分组数大于1条（2条以上，包括2条）的时候，
		// 增加一个合计分组，用来统计所有分组的信息
		if (groupInfo != null && groupInfo.size() > 1) {
			groupInfo.add("heji");

			// 将所有的查询结果都放到合计中
			List<TappropriationSingle> countData = new ArrayList<TappropriationSingle>();
			Map<String, List<TappropriationSingle>> ss = new HashMap<String, List<TappropriationSingle>>();
			ss.putAll(datas);
			for (String mapKey : ss.keySet()) {
				for (int i = 0; i < ss.get(mapKey).size(); i++) {
					countData.add(ss.get(mapKey).get(i));
				}
			}
			datas.put("heji", countData);
		}
		// ==============合计 end============

		// 生成excel
		this.createOutExcel(groupInfo, datas, isPlanningUser, excelFileName.toString(), planningUserTypeFlag, params);

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
	private void createOutExcel(List<String> groupInfo, Map<String, List<TappropriationSingle>> allResultData, Boolean isPlanningUser, String fileName, Boolean planningUserTypeFlag,
			Map<String, Object> params) throws IOException, WriteException {
		// 取得登录用户的信息
		HttpSession session = this.getRequest().getSession();
		ScUsers user = (ScUsers) session.getAttribute("sysUser");
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

		File fileModel = new File(modelInputPath + Constants.DATA_COUNT_MODEL_FUNDS);
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
			// WritableFont wf = new
			// WritableFont(WritableFont.createFont("宋体"),40);
			WritableFont wf = new WritableFont(WritableFont.createFont("宋体"), 18, WritableFont.BOLD, false);
			titleCf.setFont(wf);

			// 表头格式
			WritableCellFormat headerCf = new WritableCellFormat();
			// 设置边框
			headerCf.setBorder(Border.ALL, BorderLineStyle.THIN);
			// 垂直居中显示
			headerCf.setVerticalAlignment(VerticalAlignment.CENTRE);

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
				List<TappropriationSingle> shData = allResultData.get(typeId);
				// ===========设定列宽度为======
				for (int k = 5; k < 40; k++) {
					sh.setColumnView(k, 13);
				}
				// 循环写入数据，在计财处且统计单位为业务部门的时候
				if (isPlanningUser && !planningUserTypeFlag) {

					BigDecimal amountFundingTotal = null;
					BigDecimal planFundingTotal = null;

					// 取得该部门下的所有计划类别
					// 循环计划类别
					List<String> projectTypeList = new ArrayList<String>();
					if ("heji".equals(typeId)) {
						projectTypeList.add("heji");
					} else {
						Map<String, Object> newParams = new HashMap<String, Object>();
						newParams.putAll(params);
						newParams.put("selectedDeptId", typeId);
						projectTypeList = fundsService.getProjectTypeListByDeptId(newParams, user.getScDept().getDeptId());
					}

					// 记录项目项目
					int projectNum = 0;
					if (projectTypeList != null && projectTypeList.size() > 0) {
						// 用来写入的行号
						int rowNum = 3;
						// 用来记录项目的序列号
						int indexNum = 1;

						// 循环计划类别，将该部门下的项目按照计划类别分类
						List<TappropriationSingle> subData = null;
						for (int m = 0; m < projectTypeList.size(); m++) {
							subData = new ArrayList<TappropriationSingle>();
							String projectTypeName = "";
							if ("heji".equals(typeId)) {
								subData = shData;
							} else {
								// 按照计划类别id分类
								for (TappropriationSingle tappropriationSingle : shData) {
									if (tappropriationSingle.getTypeId1().equals(projectTypeList.get(m))) {
										subData.add(tappropriationSingle);
									}
								}
								projectTypeName = tprojectTypeService.getProjectTypeName(projectTypeList.get(m));
								// 序列
								sh.addCell(new Label(0, rowNum, "", headerCf));
								// 计划类别
								sh.addCell(new Label(1, rowNum, projectTypeName, typeCf));
								sh.mergeCells(1, rowNum, 4, rowNum);
								// 将5--40列设置为空
								for (int n = 5; n < 10; n++) {
									sh.addCell(new Label(n, rowNum, "", cf));
								}
								// 设定行高度
								sh.setRowView(rowNum, 500);
								rowNum = rowNum + 1;
							}

							// 循环写入数据
							for (int j = 0; j < subData.size(); j++) {
								// 在写出第一条数据前先写excel中的公共字段
								// ================合计 start===================
								// 当分组数groupInfo.size大于两个的时候，最后一个为合计页
								if (i > 1 && i == groupInfo.size() - 1) {
									// 设置合计页的基本信息
									// 处室
									sh.addCell(new Label(0, 0, "处室：计划财务处", headerCf));
									// 标题
									sh.addCell(new Label(0, 1, "西安市科技计划委托管理项目拨款明细表", titleCf));
									// 设定sheet名
									sh.setName("合计");
								}
								// ================合计 end===================
								else {
									// ============设置sheet中的标题和表头
									// start==========
									if (j == 0) {

										// 标题
										sh.addCell(new Label(0, 1, "西安市科技计划委托管理项目拨款明细表", titleCf));
										List<TprojectType> typeList = tprojectTypeService.getList("parentTypeId", subData.get(0).getTypeId1());
										if (typeList != null && typeList.size() > 0) {
											ScDept dept = deptService.get(typeList.get(0).getDepartmentId());
											if (dept != null) {
												sh.addCell(new Label(0, 0, "处室：" + dept.getDeptName(), headerCf));
												sh.setName(dept.getDeptName());
											}
										}
									}
									// ============设置sheet中的标题和表头 end==========
								}
								if (i > 1 && i == groupInfo.size() - 1) {
									if (subData.get(j).getSumFlag() != "1") {
										int linshiRow = rowNum;
										for (int n = 0; n < subData.size(); n++) {
											if (subData.get(n).getTasksEntrusted() == subData.get(j).getTasksEntrusted()) {
												// 序列
												sh.addCell(new Number(0, rowNum, indexNum, cf));
												// 项目编号
												sh.addCell(new Label(1, rowNum, subData.get(n).getProjectNumber(), cf));
												// 项目名称
												sh.addCell(new Label(2, rowNum, subData.get(n).getTasksEntrusted(), cf));
												// 项目承担
												sh.addCell(new Label(3, rowNum, subData.get(n).getUndertaker(), cf));
												//
												// 开户银行及行号
												sh.addCell(new Label(4, rowNum, subData.get(n).getBank(), cf));
												// 账号
												sh.addCell(new Label(5, rowNum, subData.get(n).getAccount(), cf));
												// 本次拨款金额
												sh.addCell(new Number(6, rowNum, subData.get(n).getAmountFunding(), numcf));
												// 计划拨款金额
												sh.addCell(new Number(7, rowNum, subData.get(n).getPlanFunding(), numcf));

												// 拨款时间
												sh.addCell(new Label(8, rowNum, new SimpleDateFormat("yyyy-MM-dd").format(subData.get(n).getAppropriationTime()), cf));
												// 备注
												sh.addCell(new Label(9, rowNum, subData.get(n).getRemark(), cf));
												subData.get(n).setSumFlag("1");
												rowNum = rowNum + 1;
												indexNum = indexNum + 1;
											}
										}
										sh.mergeCells(2, linshiRow, 2, rowNum - 1);
										projectNum = projectNum + 1;
									}
								} else {
									if (subData.get(j).getFlag() != "1") {
										int linshiRow = rowNum;
										for (int n = 0; n < subData.size(); n++) {
											if (subData.get(n).getTasksEntrusted() == subData.get(j).getTasksEntrusted()) {
												// 序列
												sh.addCell(new Number(0, rowNum, indexNum, cf));
												// 项目编号
												sh.addCell(new Label(1, rowNum, subData.get(n).getProjectNumber(), cf));
												// 项目名称
												sh.addCell(new Label(2, rowNum, subData.get(n).getTasksEntrusted(), cf));
												// 项目承担
												sh.addCell(new Label(3, rowNum, subData.get(n).getUndertaker(), cf));
												//
												// 开户银行及行号
												sh.addCell(new Label(4, rowNum, subData.get(n).getBank(), cf));
												// 账号
												sh.addCell(new Label(5, rowNum, subData.get(n).getAccount(), cf));
												// 本次拨款金额
												sh.addCell(new Number(6, rowNum, subData.get(n).getAmountFunding(), numcf));
												// 计划拨款金额
												sh.addCell(new Number(7, rowNum, subData.get(n).getPlanFunding(), numcf));

												// 拨款时间
												sh.addCell(new Label(8, rowNum, new SimpleDateFormat("yyyy-MM-dd").format(subData.get(n).getAppropriationTime()), cf));
												// 备注
												sh.addCell(new Label(9, rowNum, subData.get(n).getRemark(), cf));
												subData.get(n).setFlag("1");
												rowNum = rowNum + 1;
												indexNum = indexNum + 1;
											}
										}
										sh.mergeCells(2, linshiRow, 2, rowNum - 1);
										projectNum = projectNum + 1;
									}
								}

								// 设定行高度
								sh.setRowView(rowNum, 500);

								if (amountFundingTotal == null) {
									amountFundingTotal = BigDecimal.valueOf(subData.get(j).getAmountFunding());
								} else {
									amountFundingTotal = amountFundingTotal.add(BigDecimal.valueOf(subData.get(j).getAmountFunding()));
								}

								if (planFundingTotal == null) {
									planFundingTotal = BigDecimal.valueOf(subData.get(j).getPlanFunding());
								} else {
									planFundingTotal = planFundingTotal.add(BigDecimal.valueOf(subData.get(j).getPlanFunding()));
								}
							}

						}
						sh.mergeCells(0, rowNum, 1, rowNum);
						sh.addCell(new Label(0, rowNum, "项目数合计：", cf));
						sh.addCell(new Number(2, rowNum, projectNum, cf));
						sh.addCell(new Label(5, rowNum, "项目资金合计：", cf));
						if (amountFundingTotal != null) {
							sh.addCell(new Number(6, rowNum, amountFundingTotal.doubleValue(), numcf));
						}
						if (planFundingTotal != null) {
							sh.addCell(new Number(7, rowNum, planFundingTotal.doubleValue(), numcf));
						}
						sh.addCell(new Label(8, rowNum, "", cf));
						sh.addCell(new Label(9, rowNum, "", cf));
						sh.mergeCells(0, rowNum + 1, 1, rowNum + 1);
						sh.mergeCells(6, rowNum + 1, 7, rowNum + 1);
						sh.addCell(new Label(0, rowNum + 1, "财务负责人：", cf));
						sh.addCell(new Label(3, rowNum + 1, "财务经办人：", cf));
						sh.addCell(new Label(5, rowNum + 1, "业务处负责人：", cf));
						sh.addCell(new Label(8, rowNum + 1, "业务处经办人：", cf));
						sh.addCell(new Label(2, rowNum + 1, " ", cf));
						sh.addCell(new Label(4, rowNum + 1, " ", cf));
						sh.addCell(new Label(6, rowNum + 1, " ", cf));
						sh.addCell(new Label(9, rowNum + 1, " ", cf));
					}
				} else {
					// 循环写入数据
					// 行数
					// 用来写入的行号
					int rowNum = 3;
					// 用来记录项目的序列号
					int indexNum = 1;

					// 记录项目项目
					int projectNum = 0;

					BigDecimal amountFundingTotal = null;
					BigDecimal planFundingTotal = null;
					for (int j = 0; j < shData.size(); j++) {

						// 在写出第一条数据前先写excel中的公共字段

						// ================合计 start===================
						// 当分组数groupInfo.size大于两个的时候，最后一个为合计页
						if (i > 1 && i == groupInfo.size() - 1) {
							// 设置合计页的基本信息
							// Title
							sh.addCell(new Label(0, 1, "西安市科技计划委托管理项目拨款明细表", titleCf));
							List<TprojectType> typeList = tprojectTypeService.getList("parentTypeId", shData.get(0).getTypeId1());
							if (typeList != null && typeList.size() > 0) {
								// 处室
								ScDept dept = deptService.get(typeList.get(0).getDepartmentId());
								if (dept != null) {
									sh.addCell(new Label(0, 0, "处室：" + dept.getDeptName(), headerCf));
								}
							}
							sh.setName("合计");
						}
						// ================合计 end===================
						else {
							// ============设置sheet中的标题和表头 start==========
							if (j == 0) {
								// Title
								StringBuffer title = new StringBuffer();
								title.append("年");
								String deptName = "";
								if (isPlanningUser) {
									// 设置合计页的基本信息

									// sh.addCell(new Label(0, 0, "处室：计划财务处",
									// headerCf));
									// 标题
									sh.addCell(new Label(0, 1, "西安市科技计划委托管理项目拨款明细表", titleCf));
									List<TprojectType> typeList = tprojectTypeService.getList("parentTypeId", shData.get(0).getTypeId1());
									if (typeList != null && typeList.size() > 0) {
										// 处室
										ScDept dept = deptService.get(typeList.get(0).getDepartmentId());
										if (dept != null) {
											sh.addCell(new Label(0, 0, "处室：" + dept.getDeptName(), headerCf));
										}
									}

								} else {
									List<TprojectType> typeList = tprojectTypeService.getList("parentTypeId", shData.get(0).getTypeId1());
									if (typeList != null && typeList.size() > 0) {
										// 处室
										ScDept dept = deptService.get(typeList.get(0).getDepartmentId());
										if (dept != null) {
											sh.addCell(new Label(0, 0, "处室：" + dept.getDeptName(), headerCf));
										}
									}
									// 标题
									sh.addCell(new Label(0, 1, "西安市科技计划委托管理项目拨款明细表", titleCf));
								}
								//
								// sh.addCell(new Label(0, 0, title.toString(),
								// titleCf));

								// 设定sheet名
								if (isPlanningUser) {
									if (planningUserTypeFlag) {
										// 取计划类别的名称为sheet名
										TprojectType type = tprojectTypeService.get(shData.get(0).getTypeId1());
										if (type != null) {
											sh.setName(type.getTypeShowName());
										}
									} else {
										// 取部门的名称为sheet名
										sh.setName(deptName);
									}

								} else {
									// 以子分类做sheet名字
									List<TprojectType> typeList = tprojectTypeService.getList("parentTypeId", shData.get(0).getTypeId1());
									if (typeList != null && typeList.size() > 0) {
										sh.setName(typeList.get(0).getTypeShowName());
									}
								}
							}
							// ============设置sheet中的标题和表头 end==========
						}
						// 如果是合计的情况
						if (i > 1 && i == groupInfo.size() - 1) {
							if (shData.get(j).getSumFlag() != "1") {
								int linshiRow = rowNum;
								for (int n = 0; n < shData.size(); n++) {
									if (shData.get(n).getTasksEntrusted() == shData.get(j).getTasksEntrusted()) {
										// 序列
										sh.addCell(new Number(0, rowNum, indexNum, cf));
										// 项目编号
										sh.addCell(new Label(1, rowNum, shData.get(n).getProjectNumber(), cf));
										// 项目名称
										sh.addCell(new Label(2, rowNum, shData.get(n).getTasksEntrusted(), cf));
										// 项目承担
										sh.addCell(new Label(3, rowNum, shData.get(n).getUndertaker(), cf));
										//
										// 开户银行及行号
										sh.addCell(new Label(4, rowNum, shData.get(n).getBank(), cf));
										// 账号
										sh.addCell(new Label(5, rowNum, shData.get(n).getAccount(), cf));
										// 本次拨款金额
										sh.addCell(new Number(6, rowNum, shData.get(n).getAmountFunding(), numcf));
										// 计划拨款金额
										sh.addCell(new Number(7, rowNum, shData.get(n).getPlanFunding(), numcf));

										// 拨款时间
										sh.addCell(new Label(8, rowNum, new SimpleDateFormat("yyyy-MM-dd").format(shData.get(n).getAppropriationTime()), cf));
										// 备注
										sh.addCell(new Label(9, rowNum, shData.get(n).getRemark(), cf));
										shData.get(n).setSumFlag("1");
										rowNum = rowNum + 1;
										indexNum = indexNum + 1;
									}
								}
								sh.mergeCells(2, linshiRow, 2, rowNum - 1);
								projectNum = projectNum + 1;
							}
						} else {
							// 不是合计的情况
							if (shData.get(j).getFlag() != "1") {
								int linshiRow = rowNum;
								for (int n = 0; n < shData.size(); n++) {
									if (shData.get(n).getTasksEntrusted() == shData.get(j).getTasksEntrusted()) {
										// 序列
										sh.addCell(new Number(0, rowNum, indexNum, cf));
										// 项目编号
										sh.addCell(new Label(1, rowNum, shData.get(n).getProjectNumber(), cf));
										// 项目名称
										sh.addCell(new Label(2, rowNum, shData.get(n).getTasksEntrusted(), cf));
										// 项目承担
										sh.addCell(new Label(3, rowNum, shData.get(n).getUndertaker(), cf));
										//
										// 开户银行及行号
										sh.addCell(new Label(4, rowNum, shData.get(n).getBank(), cf));
										// 账号
										sh.addCell(new Label(5, rowNum, shData.get(n).getAccount(), cf));
										// 本次拨款金额
										sh.addCell(new Number(6, rowNum, shData.get(n).getAmountFunding(), numcf));
										// 计划拨款金额
										sh.addCell(new Number(7, rowNum, shData.get(n).getPlanFunding(), numcf));

										// 拨款时间
										sh.addCell(new Label(8, rowNum, new SimpleDateFormat("yyyy-MM-dd").format(shData.get(n).getAppropriationTime()), cf));
										// 备注
										sh.addCell(new Label(9, rowNum, shData.get(n).getRemark(), cf));
										shData.get(n).setFlag("1");
										rowNum = rowNum + 1;
										indexNum = indexNum + 1;
									}
								}
								sh.mergeCells(2, linshiRow, 2, rowNum - 1);
								projectNum = projectNum + 1;
							}
						}
						// 设定行高度
						sh.setRowView(j + 4, 500);
						if (amountFundingTotal == null) {
							amountFundingTotal = BigDecimal.valueOf(shData.get(j).getAmountFunding());
						} else {
							amountFundingTotal = amountFundingTotal.add(BigDecimal.valueOf(shData.get(j).getAmountFunding()));
						}

						if (planFundingTotal == null) {
							planFundingTotal = BigDecimal.valueOf(shData.get(j).getPlanFunding());
						} else {
							planFundingTotal = planFundingTotal.add(BigDecimal.valueOf(shData.get(j).getPlanFunding()));
						}

					}
					sh.mergeCells(0, shData.size() + 3, 1, shData.size() + 3);
					sh.addCell(new Label(0, shData.size() + 3, "项目数合计：", cf));
					sh.addCell(new Number(2, rowNum, projectNum, cf));
					sh.addCell(new Label(5, shData.size() + 3, "项目资金合计：", cf));
					if (amountFundingTotal != null) {
						sh.addCell(new Number(6, shData.size() + 3, amountFundingTotal.doubleValue(), numcf));
					}
					if (planFundingTotal != null) {
						sh.addCell(new Number(7, shData.size() + 3, planFundingTotal.doubleValue(), numcf));
					}
					sh.addCell(new Label(8, shData.size() + 3, "", cf));
					sh.addCell(new Label(9, shData.size() + 3, "", cf));
					sh.addCell(new Label(8, shData.size() + 3, "", cf));
					sh.addCell(new Label(9, shData.size() + 3, "", cf));
					sh.mergeCells(0, shData.size() + 4, 1, rowNum + 1);
					sh.mergeCells(6, shData.size() + 4, 7, rowNum + 1);
					sh.addCell(new Label(0, shData.size() + 4, "财务负责人：", cf));
					sh.addCell(new Label(3, shData.size() + 4, "财务经办人：", cf));
					sh.addCell(new Label(5, shData.size() + 4, "业务处负责人：", cf));
					sh.addCell(new Label(8, shData.size() + 4, "业务处经办人：", cf));
					sh.addCell(new Label(2, shData.size() + 4, "", cf));
					sh.addCell(new Label(4, shData.size() + 4, "", cf));
					sh.addCell(new Label(6, shData.size() + 4, "", cf));
					sh.addCell(new Label(9, shData.size() + 4, "", cf));
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
	/*private void setCountData(WritableCellFormat cf, WritableSheet sh, int countRow, int maxRow, WritableCellFormat sumCf, String countStr, String formula, WritableCellFormat precentCf)
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
		
		 * // 院所/高端人才 sh.addCell(new Blank(41, countRow,cf)); // 推荐意见
		 * sh.addCell(new Blank(42, countRow,cf)); // 投资专家平均分 sh.addCell(new
		 * Blank(43, countRow,cf)); // 技术专家平均分 sh.addCell(new Blank(44,
		 * countRow,cf)); // 投资专家 sh.addCell(new Blank(45, countRow,cf)); //
		 * 技术专家 sh.addCell(new Blank(46, countRow,cf));
		 
	}*/

	/**
	 * 
	 * @comments 生成公式
	 * @param maxDataRow
	 * @param formulaStr
	 * @param columnStr
	 * @return
	 * @version 1.0
	 */
	/*private String getFormula(int maxDataRow, String formulaStr, String columnStr) {
		StringBuffer outStrBuf = new StringBuffer();
		outStrBuf.append(formulaStr);
		outStrBuf.append("(");
		outStrBuf.append(columnStr);
		outStrBuf.append("5:");
		outStrBuf.append(columnStr);
		outStrBuf.append(maxDataRow);
		outStrBuf.append(")");
		return outStrBuf.toString();
	}*/

	// /**
	// *
	// * @comments 生成公式
	// * @param maxDataRow
	// * @param formulaStr
	// * @param columnStr
	// * @return
	// * @version 1.0
	// */
	// private String getFormula(int maxDataRow, String formulaStr,
	// String columnStr) {
	// StringBuffer outStrBuf = new StringBuffer();
	// outStrBuf.append(formulaStr);
	// outStrBuf.append("(");
	// outStrBuf.append(columnStr);
	// outStrBuf.append("5:");
	// outStrBuf.append(columnStr);
	// outStrBuf.append(maxDataRow);
	// outStrBuf.append(")");
	// return outStrBuf.toString();
	// }

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

	public FundsService getFundsService() {
		return fundsService;
	}

	public void setFundsService(FundsService fundsService) {
		this.fundsService = fundsService;
	}

	public MitemService getMitemService() {
		return mitemService;
	}

	public void setMitemService(MitemService mitemService) {
		this.mitemService = mitemService;
	}

	public TprojectTypeService getTprojectTypeService() {
		return tprojectTypeService;
	}

	public void setTprojectTypeService(TprojectTypeService tprojectTypeService) {
		this.tprojectTypeService = tprojectTypeService;
	}

	public DeptService getDeptService() {
		return deptService;
	}

	public void setDeptService(DeptService deptService) {
		this.deptService = deptService;
	}

	public List<TprojectType> getTypeId1List() {
		return typeId1List;
	}

	public void setTypeId1List(List<TprojectType> typeId1List) {
		this.typeId1List = typeId1List;
	}

	public List<TprojectType> getTypeId2List() {
		return typeId2List;
	}

	public void setTypeId2List(List<TprojectType> typeId2List) {
		this.typeId2List = typeId2List;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
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

	public String getBank() {
		return bank;
	}

	public void setBank(String bank) {
		this.bank = bank;
	}

	public String getAmountFundingStart() {
		return amountFundingStart;
	}

	public void setAmountFundingStart(String amountFundingStart) {
		this.amountFundingStart = amountFundingStart;
	}

	public String getPlanFundingStart() {
		return planFundingStart;
	}

	public void setPlanFundingStart(String planFundingStart) {
		this.planFundingStart = planFundingStart;
	}

	public String getBankAccount() {
		return bankAccount;
	}

	public void setBankAccount(String bankAccount) {
		this.bankAccount = bankAccount;
	}

	public String getAppropriationTimeStart() {
		return appropriationTimeStart;
	}

	public void setAppropriationTimeStart(String appropriationTimeStart) {
		this.appropriationTimeStart = appropriationTimeStart;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getAmountFundingEnd() {
		return amountFundingEnd;
	}

	public void setAmountFundingEnd(String amountFundingEnd) {
		this.amountFundingEnd = amountFundingEnd;
	}

	public String getPlanFundingEnd() {
		return planFundingEnd;
	}

	public void setPlanFundingEnd(String planFundingEnd) {
		this.planFundingEnd = planFundingEnd;
	}

	public String getAppropriationTimeEnd() {
		return appropriationTimeEnd;
	}

	public void setAppropriationTimeEnd(String appropriationTimeEnd) {
		this.appropriationTimeEnd = appropriationTimeEnd;
	}

	public List<Object> getMapList() {
		return mapList;
	}

	public void setMapList(List<Object> mapList) {
		this.mapList = mapList;
	}

	public Boolean getPrintEnableFlag() {
		return printEnableFlag;
	}

	public void setPrintEnableFlag(Boolean printEnableFlag) {
		this.printEnableFlag = printEnableFlag;
	}

	public TprojectTypeManagerService getTprojectTypeManagerService() {
		return tprojectTypeManagerService;
	}

	public void setTprojectTypeManagerService(
			TprojectTypeManagerService tprojectTypeManagerService) {
		this.tprojectTypeManagerService = tprojectTypeManagerService;
	}

}