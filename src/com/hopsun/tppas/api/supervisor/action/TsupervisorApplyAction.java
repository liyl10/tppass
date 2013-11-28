/************************* 版权声明 *********************************
 *
 * Copyright (C) 2012 西安辉盛科技发展有限责任公司.
 *
 ******************************************************************
 */
package com.hopsun.tppas.api.supervisor.action;

import java.sql.Timestamp;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import com.hopsun.framework.base.action.BaseAction;
import com.hopsun.framework.base.bean.Pager;
import com.hopsun.scenter.entity.ScUsers;
import com.hopsun.tppas.common.Constants;
import com.hopsun.tppas.entity.Mitem;
import com.hopsun.tppas.entity.Tattachment;
import com.hopsun.tppas.entity.TprojectApplication;
import com.hopsun.tppas.entity.TprojectRecord;
import com.hopsun.tppas.entity.Tsupervisor;
import com.hopsun.tppas.entity.TsupervisorFundA;
import com.hopsun.tppas.entity.TsupervisorInfoA;
import com.hopsun.tppas.api.report.service.TprojectApplicationService;
import com.hopsun.tppas.api.report.service.TprojectRecordService;
import com.hopsun.tppas.api.superadmin.service.MitemService;
import com.hopsun.tppas.api.superadmin.service.TattachmentService;
import com.hopsun.tppas.api.supervisor.service.TsupervisorApplyService;
import com.hopsun.tppas.api.supervisor.service.TsupervisorFundAService;
import com.hopsun.tppas.api.supervisor.service.TsupervisorService;

/**
 * @comments  监理申请
 * @author wangxiaodong
 * @date 2013-9-27
 * @version 1.0
 */
public class TsupervisorApplyAction extends BaseAction {

	/**序列化ID */
	private static final long serialVersionUID = 5414556348084495190L;

	/** 监理申请service*/
	@Resource
	private TsupervisorApplyService tsupervisorApplyService;

	/** 项目申报service */
	@Resource
	private TprojectApplicationService tprojectApplicationService;

	/** 项目履历service */
	@Resource
	private TprojectRecordService tprojectRecordService;
	
	/** 项目监理service */
	@Resource
	private TsupervisorService tsupervisorService;

	/** 码表service*/
	@Resource
	private MitemService mitemService;

	/** 监理资金service*/
	@Resource
	private TsupervisorFundAService tsupervisorFundService;

	/** 附件service */
	@Resource
	private TattachmentService tattachmentService;

	/** 监理资金情报*/
	private TsupervisorFundA tsupervisorFund;

	/** 附件情报 */
	private Tattachment Tattachment;

	/**项目ID*/
	private String projectId;

	/** 项目编号*/
	private String projectNumber;

	/**项目名称*/
	private String projectName;

	/**承担单位*/
	private String applicationUnit;

	/** 归口管理单位*/
	private String centralizedBranch;

	/**跳转路径*/
	private String retUrl;

	/**支持类别*/
	private String supportFlag;

	/** 监理基本信息*/
	private TsupervisorInfoA tsupervisorInfo;

	/**项目所属领域 */
	private List<Mitem> projectField;

	/** 学历*/
	private List<Mitem> eduBackground;

	/**职称*/
	private List<Mitem> personTitle;

	/**项目实施进展情况*/
	private List<Mitem> projectProgress;

	/**项目未按计划进行的原因*/
	private List<Mitem> projectStopReason;

	/**选择的未按计划进行的原因 */
	private String[] selectedProjectStopReason;

	/**跳转页面massage */
	private String retMsg;

	/** 监理ID*/
	private String supervisorId;

	/** 近一年的年份*/
	private String lastOneYear;

	/**近两年的年份*/
	private String lastTwoYear;

	/** 近三年的年份*/
	private String lastThreeYear;

	/**下一步按钮按下flag*/
	private String nextBtnFlag;

	/**基本信息存在区分*/
	private String infoExistFlag;

	/**
	 * 资金信息存在区分
	 */
	private String fundExistFlag;

	/**附件存在区分*/
	private String attachExistFlag;

	/**
	 * 是否已最终申请
	 */
	private String isLastApply;

	/**跳转页码*/
	private int pageNo;

	/**
	 * Table名称
	 */
	private String tableName;

	/**文件类型*/
	private String fileType;

	/** 附件顺序*/
	private String sequence;

	/** 菜单List */ 
	private List<Mitem> menuList;
	
	/**监理备注信息：西安市加快高新技术产业发展领导小组办公室*/
	private String supervisorComment;
	
	/** 附件id */
	private String attachmentId;
	
	/**监理对象*/
	private Tsupervisor tsupervisor;
	
	/**监理状态*/
	private String supervisorState;
	
	/**审查意见*/
	private String checkInfo;
	
	/**
	 * @comments 显示监理申请管理菜单
	 * @return
	 * @version 1.0
	 */
	public String showApplyManager() {

		// 取得登录用户的信息
		HttpSession session = this.getRequest().getSession();
		ScUsers user = (ScUsers) session.getAttribute("sysUser");
		// 如果用户为空或者企业为空，退出系统
		if (user == null || ("").equals(user.getUserId())) {
			return "LogOut";
		}

    	this.menuList = mitemService.getListByTypeId(Constants.TSUPERVISOR_TYPE_ADMIN);
    	
		// 跳转到页面
		return "showApplyManager";
	}

	/**
	 * @comments 显示监理申请封面
	 * @return
	 * @version 1.0
	 */
	public String showApplyFirstPage() {

		// 判断项目ID
		if (this.projectId == null || ("").equals(this.projectId)) {
			return "LogOut";
		}

		// 根据项目ID取得项目申报相关情报
		getProjectSupervisorInfoByProjectId(this.projectId);

		// 从session中取得supervisorId
		// 将projectId保存到session中
		HttpSession session = this.getRequest().getSession();
		session.setAttribute("projectId", this.projectId);
		// 将supervisorId保存到session中
		session.setAttribute("supervisorId", this.supervisorId);

		this.supervisorComment = tsupervisorService.get(this.supervisorId).getCompilationDept(); 
		// 跳转到页面
		return "showApplyFirstPage";
	}

	/**
	 * @comments 根据项目ID取得项目申报相关情报
	 * @param projectId
	 * @version 1.0
	 */
	private void getProjectSupervisorInfoByProjectId(String projectId) {

		// 根据项目ID取得项目申报情报
		TprojectApplication tprojectApplication = tprojectApplicationService.get(projectId);
		// 项目名称
		this.projectName = tprojectApplication.getProjectName();
		// 项目编号
		this.projectNumber = tprojectApplication.getProjectNumber();
		// 申请单位
		this.applicationUnit = tprojectApplication.getApplicationUnit();
		// 支持类别
		this.supportFlag = Constants.PROJECT_TYPE_04.equals(tprojectApplication.getSupportFlag()) ? "0" : "1";
		// 申报年度
		int reportYear = Integer.parseInt(tprojectApplication.getReportYear());
		this.lastOneYear = String.valueOf(reportYear - 1);
		this.lastTwoYear = String.valueOf(reportYear - 2);
		this.lastThreeYear = String.valueOf(reportYear-3);
		// 归口管理部门
		this.centralizedBranch = mitemService.get(tprojectApplication.getCentralizedType()).getItemName();
	}

	/**
	 * @comments 显示监理申请 填表说明画面
	 * @return
	 * @version 1.0
	 */
	public String showApplyInstruction() {

		// 跳转到页面
		return "showApplyInstruction";
	}

	/**
	 * @comments 显示监理申请 基本信息画面
	 * @return
	 * @version 1.0
	 * @throws Exception
	 */
	public String showApplyInfo() throws Exception {

		// 从session中取得projectId
		HttpSession session = this.getRequest().getSession();
		this.projectId = session.getAttribute("projectId").toString();
		this.supervisorId = session.getAttribute("supervisorId").toString();

		// 设置令牌
		session.setAttribute(Constants.SESSION_CMDKEY, "TsupervisorApplyInfo");

		// 从码表中取得radio和check中的值
		radioAndCheckDataPrepare();

		// 根据项目ID取得项目申报相关情报
		this.getProjectSupervisorInfoByProjectId(this.projectId);

		// 取得监理基本信息
		this.tsupervisorInfo = tsupervisorApplyService.get("tsupervisor.supervisorId", supervisorId);

		this.setTsupervisorInfo(tsupervisorInfo);

		// 默认选中的未按计划进行的原因
		if (this.tsupervisorInfo != null&& this.tsupervisorInfo.getProjectReason() != null) {
			this.selectedProjectStopReason = this.tsupervisorInfo.getProjectReason().split(",");
		}

		// 是否已最终申请
		resetIsLastApply();

		// 跳转到页面
		return "showApplyInfo";
	}

	/**
	 * 
	 * @comments 设置 是否已最终申请flag
	 * @version 1.0
	 */
	private void resetIsLastApply() {
		/*if (Constants.IS_LAST_APPLY_YES.equals(tsupervisorService.get(this.supervisorId).getIsLastApply())) {
			this.isLastApply = "true";
		} else {
			this.isLastApply = "false";
		}*/
		String supervisorState = tsupervisorService.get(this.supervisorId).getSupervisorState();
		if (Constants.SUPERVISOR_STATE_APPLY.equals(supervisorState) || Constants.SUPERVISOR_STATE_NOTPASS_NOEDIT.equals(supervisorState) || Constants.SUPERVISOR_STATE_PASS.equals(supervisorState)) {
			this.isLastApply = "true";
		} else {
			this.isLastApply = "false";
		}
	}

	/**
	 * 
	 * @comments Radio和CheckBox数据准备
	 * @throws Exception
	 * @version 1.0
	 */
	public void radioAndCheckDataPrepare() throws Exception {
		// 项目所属领域radio作成
		this.projectField = mitemService.getListByTypeId(Constants.TYPE_PROJECT_FIELD);
		this.setProjectField(this.projectField);

		// 学历radio作成
		this.eduBackground = mitemService.getListByTypeId(Constants.TYPE_PROJECT_PERSON_EDUCATION);
		this.setEduBackground(eduBackground);

		// 职称radio作成
		this.personTitle = mitemService.getListByTypeId(Constants.TYPE_PROJECT_PERSON_TITLE);
		this.setPersonTitle(personTitle);

		// 项目实施进展情况radio作成
		this.projectProgress = mitemService.getListByTypeId(Constants.TYPE_PROJECT_SCHEDULE);
		this.setProjectProgress(projectProgress);

		// 项目未按计划进行的原因checkBoxList作成
		this.projectStopReason = mitemService.getListByTypeId(Constants.TYPE_PROJECT_STOP_REASON);
		this.setProjectStopReason(projectStopReason);

	}

	/**
	 * 
	 * @comments 项目监理管理：基本信息画面保存处理
	 * @return
	 * @version 1.0
	 */
	public String insertApplyInfo() {

		// 从session中取得projectId
		HttpSession session = this.getRequest().getSession();
		this.projectId = session.getAttribute("projectId").toString();
		this.supervisorId = session.getAttribute("supervisorId").toString();

		ScUsers user = (ScUsers) session.getAttribute("sysUser");
		// 取得令牌信息
		String cmdkey = (String) session.getAttribute(Constants.SESSION_CMDKEY);
		if (user == null || cmdkey == null || ("").equals(user.getUserId())|| !"TsupervisorApplyInfo".equals(cmdkey)) {
			return "LogOut";
		}

		// 取得监理基本信息
		TsupervisorInfoA tsupervisorInfoBak = tsupervisorApplyService.get("tsupervisor.supervisorId", supervisorId);

		// 追加
		if (tsupervisorInfoBak == null) {
			// 设定项目监理情报
			tsupervisorInfoBak = new TsupervisorInfoA();
			tsupervisorInfoBak = this.getTsupervisorInfo();
			Tsupervisor tsupervisor = new Tsupervisor();
			tsupervisor.setSupervisorId(this.supervisorId);
			tsupervisorInfoBak.setTsupervisor(tsupervisor);
			// 删除区分
			tsupervisorInfoBak.setDeleteFlag("0");
			// 作成项目未按计划进行的原因(最多选三项)
			StringBuffer tempSelectReason = new StringBuffer();
			for (int i = 0; i < this.selectedProjectStopReason.length; i++) {
				if (i != 0) {
					tempSelectReason.append(',');
				}
				tempSelectReason.append(selectedProjectStopReason[i]);
			}
			tsupervisorInfoBak.setProjectReason(tempSelectReason.toString());
			tsupervisorInfoBak.setWriteTime(new java.sql.Timestamp(
					new java.util.Date().getTime()));
			// 创建者
			//tsupervisorInfoBak.setCreateUser(companyInfoBean.getPkUoiId());
			// 创建时间
			tsupervisorInfoBak.setCreateTime(new java.sql.Timestamp(new java.util.Date().getTime()));
			tsupervisorApplyService.save(tsupervisorInfoBak);
		}
		// 更新
		else {
			// this.tsupervisorInfo = this.getTsupervisorInfo();
			tsupervisorApplyService.evict(tsupervisorInfoBak);
			this.tsupervisorInfo.setInfoId(tsupervisorInfoBak.getInfoId());
			Tsupervisor tsupervisor = new Tsupervisor();
			tsupervisor.setSupervisorId(this.supervisorId);
			this.tsupervisorInfo.setTsupervisor(tsupervisor);
			// 作成项目未按计划进行的原因(最多选三项)
			StringBuffer tempSelectReason = new StringBuffer();
			for (int i = 0; i < this.selectedProjectStopReason.length; i++) {
				if (i != 0) {
					tempSelectReason.append(',');
				}
				tempSelectReason.append(selectedProjectStopReason[i]);
			}
			this.tsupervisorInfo.setProjectReason(tempSelectReason.toString());
			this.tsupervisorInfo.setWriteTime(new java.sql.Timestamp(new java.util.Date().getTime()));
			// 更新者
			//this.tsupervisorInfo.setUpdateUser(companyInfoBean.getPkUoiId());
			// 更新时间
			this.tsupervisorInfo.setUpdateDate(new java.sql.Timestamp(new java.util.Date().getTime()));
			// 项目监理情报保存处理
			tsupervisorApplyService.update(this.tsupervisorInfo);
		}
		this.setRetMsg(this.getText("opt_save_suc"));
		if (this.nextBtnFlag != null && ("true").equals(this.nextBtnFlag)) {
			this.setRetUrl(super.getRequest().getContextPath()
					+ "/server/supervisor/tsupervisorApply!showApplyFund.action?&now="
					+ new Date().getTime());
			return "systemInfoNext";
		} else {
			this.setRetUrl(super.getRequest().getContextPath()
					+ "/server/supervisor/tsupervisorApply!showApplyInfo.action?&now="
					+ new Date().getTime());
		}

		return "systemInfo";
	}

	/**
	 * @comments 显示监理申请 资金情况画面
	 * @return
	 * @version 1.0
	 */
	public String showApplyFund() {

		// 从session中取得projectId
		HttpSession session = this.getRequest().getSession();
		// 设置令牌
		session.setAttribute(Constants.SESSION_CMDKEY, "TsupervisorApplyFund");
		
		this.projectId = session.getAttribute("projectId").toString();
		this.supervisorId = session.getAttribute("supervisorId").toString();

		// 根据项目ID取得项目申报相关情报
		this.getProjectSupervisorInfoByProjectId(this.projectId);

		// 取得监理基本信息
		this.tsupervisorFund = tsupervisorFundService.get("tsupervisor.supervisorId", supervisorId);

		// 是否已最终申请
		resetIsLastApply();

		// 跳转到页面
		return "showApplyFund";
	}

	/**
	 * 
	 * @comments 项目监理管理：项目资金情况画面保存处理
	 * @return
	 * @version 1.0
	 */
	public String insertFundInfo() {

		// 监理情报
		// 从session中取得supervisorId
		HttpSession session = this.getRequest().getSession();
		// 取得登录用户的信息		
		ScUsers user = (ScUsers) session.getAttribute("sysUser");
		// 取得令牌信息
		String cmdkey = (String) session.getAttribute(Constants.SESSION_CMDKEY);
		if (user == null || cmdkey == null || ("").equals(user.getUserId())|| !"TsupervisorApplyFund".equals(cmdkey)) {
			return "LogOut";
		}
		
		this.supervisorId = session.getAttribute("supervisorId").toString();

		// 取得监理资金信息
		TsupervisorFundA tsupervisorFundBak = tsupervisorFundService.get("tsupervisor.supervisorId", supervisorId);

		// 追加
		if (tsupervisorFundBak == null) {

			// 设定项目监理资金
			tsupervisorFundBak = new TsupervisorFundA();
			tsupervisorFundBak = this.getTsupervisorFund();
			Tsupervisor tsupervisor = new Tsupervisor();
			tsupervisor.setSupervisorId(this.supervisorId);
			tsupervisorFundBak.setTsupervisor(tsupervisor);
			tsupervisorFundBak.setDeleteFlag("0");
			tsupervisorFundBak.setWriteTime(new java.sql.Timestamp(new java.util.Date().getTime()));
			// 创建者
			//tsupervisorFundBak.setCreateUser(companyInfoBean.getPkUoiId());
			// 创建时间
			tsupervisorFundBak.setCreateTime(new java.sql.Timestamp(new java.util.Date().getTime()));
			tsupervisorFundService.save(tsupervisorFundBak);
		}
		// 更新
		else {
			//this.tsupervisorInfo = this.getTsupervisorInfo();
			tsupervisorFundService.evict(tsupervisorFundBak);
			this.tsupervisorFund.setFundId(tsupervisorFundBak.getFundId());
			Tsupervisor tsupervisor = new Tsupervisor();
			tsupervisor.setSupervisorId(this.supervisorId);
			this.tsupervisorFund.setTsupervisor(tsupervisor);
			// 删除区分
			this.tsupervisorFund.setDeleteFlag("0");
			this.tsupervisorFund.setWriteTime(new java.sql.Timestamp(new java.util.Date().getTime()));
			// 更新者
			//this.tsupervisorFund.setUpdateUser(companyInfoBean.getPkUoiId());
			// 更新时间
			this.tsupervisorFund.setUpdateDate(new java.sql.Timestamp(new java.util.Date().getTime()));
			// 项目监理资金保存处理
			tsupervisorFundService.update(this.tsupervisorFund);
		}

		this.setRetMsg(this.getText("opt_save_suc"));
		if (this.nextBtnFlag != null && ("true").equals(this.nextBtnFlag)) {
			this.setRetUrl(super.getRequest().getContextPath()
					+ "/server/supervisor/tsupervisorApply!showApplySubmit.action?&now="
					+ new Date().getTime());
			return "systemInfoNext";
		} else {
			this.setRetUrl(super.getRequest().getContextPath()
					+ "/server/supervisor/tsupervisorApply!showApplyFund.action?&now="
					+ new Date().getTime());
		}

		return "systemInfo";
	}

	/**
	 * @comments 显示监理申请 附件一览画面
	 * @return
	 * @version 1.0
	 */
	public String showApplyAttachment() {

		// 从session中取得supervisorId
		HttpSession session = this.getRequest().getSession();
		this.supervisorId = session.getAttribute("supervisorId").toString();
		// 取得登录用户的信息
		ScUsers user = (ScUsers) session.getAttribute("sysUser");
		if (user == null || ("").equals(user.getUserId())) {
			return "LogOut";
		}

		// 设置分页参数
		if (pager == null && this.getPageNo() == 0) {
			pager = new Pager();
		} else {
			pager = new Pager();
			pager.setPageNumber(this.getPageNo());
		}

		// 取得表名
		this.tableName = tattachmentService.getTableName(Tsupervisor.class);
		// 取得附件一览信息
		pager = tattachmentService.find(tableName, supervisorId,pager.getPageNumber(), pager.getPageSize());

		// 是否已最终申请
		resetIsLastApply();

		// 跳转到页面
		return "showApplyAttachment";
	}

	/**
	 * 
	 * @comments 显示附件新增画面
	 * @return
	 * @version 1.0
	 */
	public String showAttachmentInsert() {
		// 从session中取得supervisorId
		HttpSession session = this.getRequest().getSession();
		this.supervisorId = session.getAttribute("supervisorId").toString();
		Mitem mitem = mitemService.get(Constants.FILE_UPLOAD_TYPE);
		if (mitem != null) {
			this.fileType = mitem.getItemDesc();
		}

		// 取得表名
		this.tableName = tattachmentService.getTableName(Tsupervisor.class);
		this.sequence = tattachmentService.getMaxSequence(tableName,supervisorId);

		return "showAttachmentInsert";
	}

	/**
	 * 
	 * @comments 附件上传页面修改画面
	 * @return
	 * @version 1.0
	 */
	public String showIndexUpdate(){
		// 从session中取得supervisorId
		HttpSession session = this.getRequest().getSession();
		this.supervisorId = session.getAttribute("supervisorId").toString();
		// 取得表名
		this.tableName = tattachmentService.getTableName(Tsupervisor.class);
		attachmentId = this.getAttachmentId();
		this.Tattachment = tattachmentService.get(attachmentId);
		return "showIndexUpdate";
	}
	
	/**
	 * @comments 监理申请 提交画面
	 * @return
	 * @version 1.0
	 */
	public String showApplySubmit() {
		// 监理情报
		// 从session中取得supervisorId
		HttpSession session = this.getRequest().getSession();
		// 设置令牌
		session.setAttribute(Constants.SESSION_CMDKEY, "TsupervisorApplySubmit");
		
		this.supervisorId = session.getAttribute("supervisorId").toString();
		
		tsupervisor = tsupervisorService.get(supervisorId);

		// 取得监理信息情报
		TsupervisorInfoA tsupervisorInfoBak = tsupervisorApplyService.get("tsupervisor.supervisorId", supervisorId);
		if (tsupervisorInfoBak != null) {
			this.infoExistFlag = Constants.SUPERVISOR_INFO_EXIST;
		} else {
			this.infoExistFlag = Constants.SUPERVISOR_INFO_UNEXIST;
		}

		// 取得监理资金信息
		TsupervisorFundA tsupervisorFundBak = tsupervisorFundService.get("tsupervisor.supervisorId", supervisorId);
		if (tsupervisorFundBak != null) {
			this.fundExistFlag = Constants.SUPERVISOR_INFO_EXIST;
		} else {
			this.fundExistFlag = Constants.SUPERVISOR_INFO_UNEXIST;
		}

		// 取得表名
		this.tableName = tattachmentService.getTableName(Tsupervisor.class);

		// 取得附件信息
		List<Tattachment> attachmentList = tattachmentService.getList("tableName", this.tableName);
		int attachCount = 0;
		for (Tattachment tattachment : attachmentList) {
			if(tattachment.getKey1().equals(supervisorId)){
				attachCount = attachCount +1;
			}
		}
		if (attachCount==0) {
			this.attachExistFlag = Constants.SUPERVISOR_INFO_UNEXIST;
		} else {
			this.attachExistFlag = Constants.SUPERVISOR_INFO_EXIST;
		}

		// 是否已最终申请
		resetIsLastApply();

		// 跳转到页面
		return "showApplySubmit";
	}

	/**
	 * 
	 * @comments 提交监理报告
	 * @return
	 * @version 1.0
	 */
	public String updateTsupervisor() {

		// 监理情报
		// 
		HttpSession session = this.getRequest().getSession();
		ScUsers user = (ScUsers) session.getAttribute("sysUser");
		// 取得令牌信息
		String cmdkey = (String) session.getAttribute(Constants.SESSION_CMDKEY);
		if (user == null || cmdkey == null || ("").equals(user.getUserId())|| !"TsupervisorApplySubmit".equals(cmdkey)) {
			return "LogOut";
		}
		// 从session中取得supervisorId
		this.supervisorId = session.getAttribute("supervisorId").toString();
		// 根据supervisorId取得项目监理情报
		Tsupervisor tsupervisor = tsupervisorService.get(this.supervisorId);
		// 监理状态-已申请监理审核
		tsupervisor.setSupervisorState(Constants.SUPERVISOR_STATE_APPLY);
		// 是否已最终申请 1：是
		tsupervisor.setIsLastApply(Constants.IS_LAST_APPLY_YES);
		// 更新者
		//tsupervisor.setUpdateUser(companyInfoBean.getPkUoiId());
		// 更新时间
		tsupervisor.setUpdateTime(new java.sql.Timestamp(new java.util.Date().getTime()));
		
		// 作成PDF ===START
		String pdfInputPath = mitemService.get(Constants.PDF_TEMPLATE_PATH).getItemDesc();
		String pdfOutputPath = mitemService.get(Constants.PDF_STORAGE_PATH).getItemDesc();
		String len = pdfInputPath.substring(pdfInputPath.length() - 1,pdfInputPath.length());

		// 判断目录是否完整
		if (!"/".equals(len)) {
			pdfInputPath = pdfInputPath + "/";
		}
		len = pdfOutputPath.substring(pdfOutputPath.length() - 1,
				pdfOutputPath.length());

		// 判断目录是否完整
		if (!"/".equals(len)) {
			pdfOutputPath = pdfOutputPath + "/";
		}

		// 更新项目监理表
		String ptdUrl = tsupervisorService.creatPdf(pdfInputPath,pdfOutputPath, supervisorId);
		// 作成PDF ===END
		
		tsupervisor.setPdfUrl(ptdUrl);
		// 更新项目监理表
		tsupervisorService.update(tsupervisor);

		// 更新履历表
		// 添加履历信息
		TprojectRecord tprojectRecord = new TprojectRecord();
		tprojectRecord.setTprojectApplication(tsupervisor.getTprojectApplication());
		// 监理阶段
		tprojectRecord.setOptStepType(3);
		// 企业用户提交监理申请
		tprojectRecord.setOptType(Constants.PROJECT_RECORD_COMPANY_COMIT_APPLY);
		// 操作时间
		tprojectRecord
				.setOptTime(new Timestamp(new java.util.Date().getTime()));
		// 操作者
		//tprojectRecord.setOptUser(companyInfoBean.getPkUoiId());
		// 操作结果
		tprojectRecord.setOptResult(Constants.SUPERVISOR_STATE_APPLY);
		tprojectRecordService.save(tprojectRecord);
				
		this.setRetMsg(this.getText("opt_save_suc"));
		this.setRetUrl(super.getRequest().getContextPath()
				+ "/server/supervisor/supervisorAction!list.action?&now="
				+ new Date().getTime());
		// 页面跳转 to：中期监理一览画面
		return "systemInfoMain";
	}
	
	/**
	 * 其他处室项目监理审核
	 * @comments 
	 * @return
	 * @version 1.0
	 */
	public String auditSupervisor(){
		// 取得登录用户的信息
    	HttpSession session = this.getRequest().getSession();
    	ScUsers user = (ScUsers) session.getAttribute("sysUser");
		// 如果用户为空或者企业为空，退出系统
		if (user == null || ("").equals(user.getUserId())) {
			return "LogOut";
		}
    	
		Map<String,Object> valueMap = new HashMap<String,Object>();
		valueMap.put("supervisorId",supervisorId);
		valueMap.put("tsupervisorInfo",checkInfo);
		valueMap.put("supervisorState",supervisorState);
		valueMap.put("user",user);
		tsupervisorService.saveSupervisorAudit(valueMap);
		
		this.setRetMsg(String.valueOf(this.getText("opt_save_suc")));
		this.setRetUrl(this.getRequest().getContextPath()
				+ "/api/supervisor/tsupervisorAction!supervisorManager.action?now=" + new Date().getTime());
		
		return "systemInfoMain";
	}

	public String getProjectId() {
		return projectId;
	}

	public void setProjectId(String projectId) {
		this.projectId = projectId;
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

	public String getCentralizedBranch() {
		return centralizedBranch;
	}

	public void setCentralizedBranch(String centralizedBranch) {
		this.centralizedBranch = centralizedBranch;
	}

	public String getRetUrl() {
		return retUrl;
	}

	public void setRetUrl(String retUrl) {
		this.retUrl = retUrl;
	}

	public String getSupportFlag() {
		return supportFlag;
	}

	public void setSupportFlag(String supportFlag) {
		this.supportFlag = supportFlag;
	}

	public String getRetMsg() {
		return retMsg;
	}

	public void setRetMsg(String retMsg) {
		this.retMsg = retMsg;
	}

	public TsupervisorInfoA getTsupervisorInfo() {
		return tsupervisorInfo;
	}

	public void setTsupervisorInfo(TsupervisorInfoA tsupervisorInfo) {
		this.tsupervisorInfo = tsupervisorInfo;
	}

	public List<Mitem> getProjectField() {
		return projectField;
	}

	public void setProjectField(List<Mitem> projectField) {
		this.projectField = projectField;
	}

	public List<Mitem> getEduBackground() {
		return eduBackground;
	}

	public void setEduBackground(List<Mitem> eduBackground) {
		this.eduBackground = eduBackground;
	}

	public List<Mitem> getPersonTitle() {
		return personTitle;
	}

	public void setPersonTitle(List<Mitem> personTitle) {
		this.personTitle = personTitle;
	}

	public List<Mitem> getProjectProgress() {
		return projectProgress;
	}

	public void setProjectProgress(List<Mitem> projectProgress) {
		this.projectProgress = projectProgress;
	}

	public List<Mitem> getProjectStopReason() {
		return projectStopReason;
	}

	public void setProjectStopReason(List<Mitem> projectStopReason) {
		this.projectStopReason = projectStopReason;
	}

	public TsupervisorFundA getTsupervisorFund() {
		return tsupervisorFund;
	}

	public void setTsupervisorFund(TsupervisorFundA tsupervisorFund) {
		this.tsupervisorFund = tsupervisorFund;
	}

	public String getProjectNumber() {
		return projectNumber;
	}

	public void setProjectNumber(String projectNumber) {
		this.projectNumber = projectNumber;
	}

	public String[] getSelectedProjectStopReason() {
		return selectedProjectStopReason;
	}

	public void setSelectedProjectStopReason(String[] selectedProjectStopReason) {
		this.selectedProjectStopReason = selectedProjectStopReason;
	}

	public String getSupervisorId() {
		return supervisorId;
	}

	public void setSupervisorId(String supervisorId) {
		this.supervisorId = supervisorId;
	}

	public String getLastOneYear() {
		return lastOneYear;
	}

	public void setLastOneYear(String lastOneYear) {
		this.lastOneYear = lastOneYear;
	}

	public String getLastTwoYear() {
		return lastTwoYear;
	}

	public void setLastTwoYear(String lastTwoYear) {
		this.lastTwoYear = lastTwoYear;
	}

	public String getLastThreeYear() {
		return lastThreeYear;
	}

	public void setLastThreeYear(String lastThreeYear) {
		this.lastThreeYear = lastThreeYear;
	}

	public String getNextBtnFlag() {
		return nextBtnFlag;
	}

	public void setNextBtnFlag(String nextBtnFlag) {
		this.nextBtnFlag = nextBtnFlag;
	}

	public String getInfoExistFlag() {
		return infoExistFlag;
	}

	public void setInfoExistFlag(String infoExistFlag) {
		this.infoExistFlag = infoExistFlag;
	}

	public String getFundExistFlag() {
		return fundExistFlag;
	}

	public void setFundExistFlag(String fundExistFlag) {
		this.fundExistFlag = fundExistFlag;
	}

	public String getAttachExistFlag() {
		return attachExistFlag;
	}

	public void setAttachExistFlag(String attachExistFlag) {
		this.attachExistFlag = attachExistFlag;
	}

	public String getIsLastApply() {
		return isLastApply;
	}

	public void setIsLastApply(String isLastApply) {
		this.isLastApply = isLastApply;
	}

	public Tattachment getTattachment() {
		return Tattachment;
	}

	public void setTattachment(Tattachment tattachment) {
		Tattachment = tattachment;
	}

	public int getPageNo() {
		return pageNo;
	}

	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}

	public String getTableName() {
		return tableName;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

	public String getFileType() {
		return fileType;
	}

	public void setFileType(String fileType) {
		this.fileType = fileType;
	}

	public String getSequence() {
		return sequence;
	}

	public void setSequence(String sequence) {
		this.sequence = sequence;
	}

	public List<Mitem> getMenuList() {
		return menuList;
	}

	public void setMenuList(List<Mitem> menuList) {
		this.menuList = menuList;
	}

	public String getSupervisorComment() {
		return supervisorComment;
	}

	public void setSupervisorComment(String supervisorComment) {
		this.supervisorComment = supervisorComment;
	}

	public TattachmentService getTattachmentService() {
		return tattachmentService;
	}

	public void setTattachmentService(TattachmentService tattachmentService) {
		this.tattachmentService = tattachmentService;
	}

	public String getAttachmentId() {
		return attachmentId;
	}

	public void setAttachmentId(String attachmentId) {
		this.attachmentId = attachmentId;
	}

	public Tsupervisor getTsupervisor() {
		return tsupervisor;
	}

	public void setTsupervisor(Tsupervisor tsupervisor) {
		this.tsupervisor = tsupervisor;
	}

	public String getSupervisorState() {
		return supervisorState;
	}

	public void setSupervisorState(String supervisorState) {
		this.supervisorState = supervisorState;
	}

	public String getCheckInfo() {
		return checkInfo;
	}

	public void setCheckInfo(String checkInfo) {
		this.checkInfo = checkInfo;
	}
}