/*************** 版权声明***************
*
* Copyright (C) 2012 西安辉盛科技发展有限责任公司.
*
********************************************
*/
package com.hopsun.tppas.api.report.action;

import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jxl.Workbook;
import jxl.format.Alignment;
import jxl.format.Border;
import jxl.format.BorderLineStyle;
import jxl.format.VerticalAlignment;
import jxl.write.Label;
import jxl.write.NumberFormat;
import jxl.write.WritableCellFormat;
import jxl.write.WritableFont;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;

import com.hopsun.framework.base.action.BaseAction;
import com.hopsun.framework.base.bean.Pager;
import com.hopsun.scenter.entity.ScUsers;
import com.hopsun.tppas.api.expert.service.TexpertScoreService;
import com.hopsun.tppas.api.expert.service.TexpertService;
import com.hopsun.tppas.api.report.service.TcompanyInfoService;
import com.hopsun.tppas.api.report.service.TgroupExpertRealtionService;
import com.hopsun.tppas.api.report.service.TprojectApplicationJointService;
import com.hopsun.tppas.api.report.service.TprojectGroupService;
import com.hopsun.tppas.api.superadmin.service.MitemService;
import com.hopsun.tppas.api.superadmin.service.TprojectTypeManagerService;
import com.hopsun.tppas.api.superadmin.service.TprojectTypeService;
import com.hopsun.tppas.common.CommonTool;
import com.hopsun.tppas.common.Constants;
import com.hopsun.tppas.common.Message;
import com.hopsun.tppas.common.MessageSend;
import com.hopsun.tppas.entity.Mitem;
import com.hopsun.tppas.entity.TcompanyInfo;
import com.hopsun.tppas.entity.Texpert;
import com.hopsun.tppas.entity.TexpertScore;
import com.hopsun.tppas.entity.TgroupExpertRealtion;
import com.hopsun.tppas.entity.TprojectApplication;
import com.hopsun.tppas.entity.TprojectGroup;
import com.hopsun.tppas.entity.TprojectType;
import com.hopsun.tppas.view.VprojectInfo;

/**
 * @comments 联席会审核
 * @author wanglw
 * @date 2013-9-16 @time 下午1:56:33
 * @Version 1.0
 */
public class TprojectApplicationJointAction extends BaseAction{

	private static final long serialVersionUID = -4759011727465629864L;
	
	@Resource
	private TprojectApplicationJointService tprojectApplicationJointService;
	
	@Resource
	private TprojectTypeManagerService tprojectTypeManagerService;
	
	@Resource
	private MitemService mitemService;
	
	@Resource
	private TprojectGroupService tprojectGroupService;
	
	@Resource
	private TexpertScoreService texpertScoreService;
	
	@Resource
	private TgroupExpertRealtionService tgroupExpertRealtionService;
	
	@Resource
	private TexpertService texpertService;
	
	@Resource
	private TprojectTypeService tprojectTypeService;
	
	@Resource
	private TcompanyInfoService tcompanyInfoService;

	/** 翻页*/
    private int pageNo;
    
    /** 跳转路径*/
	private String retUrl;
	
	/** 跳转页面massage */
	private String retMsg;
	
	 /** 单位性质 */
	private List<Mitem> companyTypeList;
	
	/** 计划类别 */
	private List<Mitem> projectTypeList;
	
	/** 计划类别 */
	private List<TprojectType> projectTypeList1;
	
	/** 项目分类 */
	private List<TprojectType> projectTypeList2;
	
	/** 项目分组 */
	private List<TprojectGroup> projectGroupList;
	
	/** 审核状态 */
	private List<Mitem> auditStatusList;
	
	/** 单位性质 */
	private String companyType;

	/** 计划类别 */
	private String projectType;
	
	/** 计划类别 */
	private String projectType1;
	
	/** 项目分类 */
	private String projectType2;
	
	/** 项目分组 */
	private String projectGroup;
	
	/** 项目分组(弹出页面) */
	private String projectGroupSon;

	/** 审核状态 */
	private String auditStatus;
	
	/** 项目名称 */
	private String projectName;
	
	/** 申报单位 */
	private String applyCompany;
	
	/** 选择的项目信息List */
	private List<Map<String, Object>> projectSelectList;
	
	/** 分组名称*/
	private String groupName;
	
	/** 分组ID*/
	private String groupId;
	
	/** 数据是否显示 */
	private String groupDateFlag;
	
	/** 擅长专业 */
	private List<Mitem> goodProfessList;
	
	/** 信誉度等级 */
	private List<Mitem> credibyLevelList;
	
	/** 项目ID */
	private String projectId;
	
	/** 专家姓名 */
	private String expertName;
	
	/** 擅长专业 */
	private String goodProfess;
	
	/** 信誉度等级 */
	private String credibyLevel;
	
	/** 专家List */
	private List<Texpert> exList;
	
	/** 性别List */
	private List<Mitem> sexList;
	
	/** 毕业院校List */
	private List<Map<String, Object>> graduatedList;
	
	/** 出生年份List */
	private List<Mitem> birthdayYearList;
	
	/** 学历List */
	private List<Mitem> schoolingTypeList;
	
	/** 技术职称List */
	private List<Mitem> skilljobTypeList;
	
	/** 专业List */
	private List<Map<String, Object>> expertmajorTypeList;
	
	/** 性别 */
	private String sex;
	
	/** 毕业院校 */
	private String graduatedName;
	
	/** 出生年份 */
	private String birthdayYear;
	
	/** 学历 */
	private String schoolingType;
	
	/** 技术职称 */
	private String skilljobType;
	
	/** 专业 */
	private String expertmajorType; 
	
	/** 选择的专家ID */
	private String selectedExpertIds;
	
	/** 专家ID */
	private String expertId;
	
	/** 选择的专家评分ID */
	private String selectedScoreIds;
	
	/** 专家评分ID */
	private String scoreId;
	
	/** 专家对象 */
	private Texpert expert;
	
	/** 选择的项目ID */
	private String selectedProjectIds;
	
	/** 专家评审列表 */
	private List<TexpertScore> texpertScoreList;
	
	/** 申报项目对象 */
	private TprojectApplication tprojectApplication;
	
	/** 申报项目信息 */
	private VprojectInfo vprojectInfo;
	
	/**擅长专业1集合*/
	private List<Mitem> expertMajor1List;
	
	/**信用等级集合*/
	private List<Mitem> expertPrestigeList;
	
	/**擅长专业1*/
	private String expertMajor1;

	/**信用等级*/
	private String expertPrestige;
	
	/**专家对象*/
	private  Texpert  texpert;
	
	/**学历集合*/
	private List<Mitem> schoolingList;
	
	/**学位集合*/
	private List<Mitem> expertdegreeList;
	
	/**行政职务集合*/
	private List<Mitem> expertjobList;
	
	/**技术职务集合*/
	private List<Mitem> skilljobList;
	
	/**擅长专业2集合*/
	private List<Mitem> expertMajor2List;
	
	/**擅长专业3集合*/
	private List<Mitem> expertMajor3List;
	
	/**信誉等级集合*/
	private List<Mitem> expertprestigeList;
	
	/**单位性质集合*/
	private List<Mitem> depttypeList;
	
	/** 处长意见 */
	private String commissionerOpinion;
	
	/** 联席会意见 */
	private String meetingOpinion;
	
	/** 联席会很合结果 */
	private String projectApplyStatus;
	
	/** 联席会审核页面编辑Flag */
	private String jointEditFlag;
	
	/** 联席会意见list */
	private List<Mitem> jointStatusList;
	
	/** 联席会意见 */
	private String jointStatus;
	
	/** 项目list */
	private List<TprojectApplication> projectList;
	
	/**发送时间*/
	private String sendTime;
	
	/**发送地址*/
	private String sendAddress;
	
	/**专家集合*/
	private List<Texpert> texpertList = new ArrayList<Texpert>();
	
	/**信息内容*/
	private String infoContent;
	
	/** 高端人才 */
	private String highEnd; 
	
	/**
	 * @comments 显示联席会审核
	 * @return
	 * @Version 1.0
	 */
	public String showJointAuditManage(){
		
		// 取得登录用户的信息
		HttpSession session = this.getRequest().getSession();
	    session.setAttribute(Constants.SESSION_CMDKEY, "jointAudit");
	    
	    ScUsers user = (ScUsers) session.getAttribute("sysUser");
	    
		// 如果用户为空或者企业为空，退出系统
		if (user == null || ("").equals(user.getUserId())) {
			return "LogOut";
		}
		
		// 初始化计划类别
		this.projectTypeList1 = new ArrayList<TprojectType>();
		this.projectTypeList1 = tprojectTypeManagerService.getProjectTypeListByUser(user);
				
		
		// 初始化项目分类
		this.projectTypeList2 = new ArrayList<TprojectType>();
		
		// 初始化审核状态
		this.auditStatusList = new ArrayList<Mitem>();
		this.auditStatusList = mitemService.getMitemListByPId("");
		
		// 初始化项目分组
		this.projectGroupList = new ArrayList<TprojectGroup>();
		this.projectGroupList = tprojectGroupService.getProjectGroupListByDeptId(
				user.getScDept().getDeptId());
		
		return "showJointAuditManage";
	}
	
	/**
	 * @comments 取得联席会审核项目列表
	 * @return
	 * @Version 1.0
	 */
	public String getJointAuditList(){
		
		// 取得登录用户的信息
		HttpSession session = this.getRequest().getSession();
		String cmdkey = (String)session.getAttribute(Constants.SESSION_CMDKEY);
	    
	    ScUsers user = (ScUsers) session.getAttribute("sysUser");
		// 如果用户为空或者企业为空，退出系统
		if (user == null || ("").equals(user.getUserId())
				|| !"jointAudit".equals(cmdkey)) {
			return "LogOut";
		}
		
    	// 翻页
    	if (pager == null && this.getPageNo() == 0) {
			pager = new Pager();
			pager.setPageSize(Constants.PAGE_SIZE);
		}
    	else{
    		pager = new Pager();
    		pager.setPageNumber(this.getPageNo());
    		pager.setPageSize(Constants.PAGE_SIZE);
    	}
		
    	Map<String, Object> param = new HashMap<String, Object>();
		
		// 封装查询条件
    	// 部门ID
    	param.put("departmentId", user.getScDept().getDeptId());
    	
		// 项目名称
		param.put("projectName", projectName);
		
		// 申报单位
		param.put("applyCompany", applyCompany);
		
		// 计划类别
		String projectTypeString = tprojectTypeManagerService.getProjectTypeStrByUser(user);
		param.put("projectTypeString", projectTypeString);
		
		// 计划类别
		param.put("projectType1", projectType1);
		
		// 项目分类
		param.put("projectType2", projectType2);
		
		// 审核状态
		param.put("auditStatus", auditStatus);
		
		// 项目分组
		param.put("projectGroup", projectGroup);
		
		// 用户Id
		param.put("userId", user.getUserId());
		
				
		// 取得项目一览信息
		pager = tprojectApplicationJointService.getJointAuditList(
				param, pager.getPageNumber(), pager.getPageSize());
		
		return "getJointAuditList";
	}
	
	/**
	 * @comments 批量联席会审核
	 * @return
	 * @Version 1.0
	 */
	public String showBatchJointAudit(){
		// 取得登录用户的信息
		HttpSession session = this.getRequest().getSession();
		String cmdkey = (String)session.getAttribute(Constants.SESSION_CMDKEY);
	    
	    ScUsers user = (ScUsers) session.getAttribute("sysUser");
		// 如果用户为空或者企业为空，退出系统
		if (user == null || ("").equals(user.getUserId())
				|| !"jointAudit".equals(cmdkey)) {
			return "LogOut";
		}
		
		// 取得选择的项目Id
		this.selectedProjectIds = this.getSelectedProjectIds();
		
		this.projectId = selectedProjectIds;
		
		// 联席会意见list
		this.jointStatusList = new ArrayList<Mitem>();
		Mitem m1 = new Mitem();
		m1.setItemName("同意");
		m1.setItemId(Constants.PROJECT_REPORT_JOINT_PASS);
		
		Mitem m2 = new Mitem();
		m2.setItemName("不同意");
		m2.setItemId(Constants.PROJECT_REPORT_JOINT_NOPASS);
		
		jointStatusList.add(m1);
		jointStatusList.add(m2);
		
		return "showBatchJointAudit";
	}
	
	
	/**
	 * @comments 联席会审核
	 * @return
	 * @Version 1.0
	 */
	public String showJointAudit(){
		
		// 取得登录用户的信息
		HttpSession session = this.getRequest().getSession();
		String cmdkey = (String)session.getAttribute(Constants.SESSION_CMDKEY);
	    
	    ScUsers user = (ScUsers) session.getAttribute("sysUser");
		// 如果用户为空或者企业为空，退出系统
		if (user == null || ("").equals(user.getUserId())
				|| !"jointAudit".equals(cmdkey)) {
			return "LogOut";
		}
		
		// 取得项目Id
		this.projectId = this.getProjectId();
		
		// 更新项目申报状态
		// tprojectApplicationJointService.updateApplyStatus(projectId, user.getUserId());
		
		// 取得项目申报信息
		this.tprojectApplication = tprojectApplicationJointService.get(projectId);
		
		// 状态判断 
		if(tprojectApplication.getJointStatus() != null && !"".equals(tprojectApplication.getJointStatus())){
			this.jointEditFlag = "0";
		}else{
			this.jointEditFlag = "1";
		}
		/*if(!user.getUserId().equals(tprojectApplication.getOptUser()) 
				|| Constants.PROJECT_REPORT_JOINT_PASS.equals(tprojectApplication.getApplyStatus()) || 
				Constants.PROJECT_REPORT_JOINT_NOPASS.equals(tprojectApplication.getApplyStatus())){
			
			this.jointEditFlag = "0";
		}else{
			this.jointEditFlag = "1";
		}*/
		
		// 联席会意见list
		this.jointStatusList = new ArrayList<Mitem>();
		Mitem m1 = new Mitem();
		m1.setItemName("同意");
		m1.setItemId(Constants.PROJECT_REPORT_JOINT_PASS);
		
		Mitem m2 = new Mitem();
		m2.setItemName("不同意");
		m2.setItemId(Constants.PROJECT_REPORT_JOINT_NOPASS);
		
		jointStatusList.add(m1);
		jointStatusList.add(m2);
		
		return "showJointAudit";
	}
	
	/**
	 * @comments 联席会批量审核 
	 * @return
	 * @Version 1.0
	 */
	public String batchSaveJointAudit(){
		// 取得登录用户的信息
		HttpSession session = this.getRequest().getSession();
		String cmdkey = (String)session.getAttribute(Constants.SESSION_CMDKEY);
	    
	    ScUsers user = (ScUsers) session.getAttribute("sysUser");
		// 如果用户为空或者企业为空，退出系统
		if (user == null || ("").equals(user.getUserId())
				|| !"jointAudit".equals(cmdkey)) {
			return "LogOut";
		}
		// 取得选择的项目Id
		this.projectId = this.getProjectId();
		
		// 取得联席会意见
		this.meetingOpinion = this.getMeetingOpinion();
		
		// 取得处长意见
		this.commissionerOpinion = this.getCommissionerOpinion();
		
		// 取得联席会审核结果
		this.projectApplyStatus = this.getJointStatus();
		
		// 保存联席会审核意见
		tprojectApplicationJointService.updateBatchApplyStatus(projectId, 
				commissionerOpinion, meetingOpinion, 
				projectApplyStatus, user.getUserId());
		
		// 设置提示信息
		this.setRetMsg(this.getText("opt_save_suc"));
		
		// 设置actionUrl
		this.setRetUrl(super.getRequest().getContextPath()
				+ "/api/audit/projectApplicationJoint!showJointAuditManage.action?"
				+ "&now=" + new Date().getTime());
		
		return "systemInfoMain";
	}
	
	/**
	 * @comments 联席会审核 
	 * @return
	 * @Version 1.0
	 */
	public String saveJointAudit(){
		// 取得登录用户的信息
		HttpSession session = this.getRequest().getSession();
		String cmdkey = (String)session.getAttribute(Constants.SESSION_CMDKEY);
	    
	    ScUsers user = (ScUsers) session.getAttribute("sysUser");
		// 如果用户为空或者企业为空，退出系统
		if (user == null || ("").equals(user.getUserId())
				|| !"jointAudit".equals(cmdkey)) {
			return "LogOut";
		}
		
		// 取得联席会意见
		this.tprojectApplication = this.getTprojectApplication();
		
		// 取得联席会审核结果
		this.projectApplyStatus = this.getJointStatus();
		
		// 保存联席会审核意见
		tprojectApplicationJointService.updateApplyStatus(tprojectApplication, 
				projectApplyStatus, user.getUserId());
		
		// 设置提示信息
		this.setRetMsg(this.getText("opt_save_suc"));
		
		// 设置actionUrl
		this.setRetUrl(super.getRequest().getContextPath()
				+ "/api/audit/projectApplicationJoint!showJointAuditManage.action?"
				+ "&now=" + new Date().getTime());
		
		return "systemInfoMain";
	}
	
	/**
	 * @comments 
	 * @return
	 * @Version 1.0
	 */
	public String showSendMessage(){
		
		// 取得登录用户的信息
		HttpSession session = this.getRequest().getSession();
		String cmdkey = (String)session.getAttribute(Constants.SESSION_CMDKEY);
	    
	    ScUsers user = (ScUsers) session.getAttribute("sysUser");
		// 如果用户为空或者企业为空，退出系统
		if (user == null || ("").equals(user.getUserId())
				|| !"auditExpertSelect".equals(cmdkey)) {
			return "LogOut";
		}
		
		// 项目Id
 		this.projectId = this.getProjectId();
		
 		// 初始化擅长专业
  		this.goodProfessList = new ArrayList<Mitem>();
  		// 添加擅长专业1
  		this.goodProfessList = mitemService.getListByTypeId(Constants.EXPERTMAJOR1_TYPE);
  		// 添加擅长专业2
  		this.goodProfessList.addAll(mitemService.getListByTypeId(Constants.EXPERTMAJOR2_TYPE));
  		// 添加擅长专业3
  		this.goodProfessList.addAll(mitemService.getListByTypeId(Constants.EXPERTMAJOR3_TYPE));
  		
  		// 初始化信誉等级
  		this.credibyLevelList = new ArrayList<Mitem>();
  		this.credibyLevelList = mitemService.getListByTypeId(Constants.EXPERTPRESTIGE_TYPE);
		
		return "showSendMessage";
	}
	
	/**
	 * @comments 取得已选择的专家信息
	 * @return
	 * @Version 1.0
	 */
	public String getSelectedList(){
		
		// 取得登录用户的信息
		HttpSession session = this.getRequest().getSession();
		String cmdkey = (String)session.getAttribute(Constants.SESSION_CMDKEY);
	    
	    ScUsers user = (ScUsers) session.getAttribute("sysUser");
		// 如果用户为空或者企业为空，退出系统
		if (user == null || ("").equals(user.getUserId())
				|| !"jointAudit".equals(cmdkey)) {
			return "LogOut";
		}
	    
    	// 翻页
    	if (pager == null && this.getPageNo() == 0) {
			pager = new Pager();
		}
    	else{
    		pager = new Pager();
    		pager.setPageNumber(this.getPageNo());
    	}
		
    	// 取得项目编号
    	this.projectId = this.getProjectId();
    	
    	
    	// 查询条件
    	Map<String, Object> param = new HashMap<String, Object>();
		
    	// 封装查询条件
    	if(!"".equals(projectId) && projectId != null){
    		
    		// 批量选择专家时的查询
    		if(projectId.contains(",")){
    			String projectIds = projectId.split(",")[0];
    			// 项目ID
    			param.put("projectId", projectIds);
    		}
    		else{
    			// 项目ID
    			param.put("projectId", projectId);
    		}
    	}
    	
		// 专家名称
		param.put("expertName", expertName);
		
		// 擅长专业
		param.put("goodProfess", goodProfess);
		
		// 信誉度等级
		param.put("credibyLevel", credibyLevel);
		
		// 取得的已选专家一览
		pager = texpertScoreService.getJointSelectedExpertList(param, pager.getPageNumber(), pager.getPageSize());
				
		return "getSelectedList";
	}
	
	
	/**
	 * @comments 批量发送通知 
	 * @return
	 * @Version 1.0
	 */
	public String batchSendMessage(){
		
		// 取得登录用户的信息
		HttpSession session = this.getRequest().getSession();
		String cmdkey = (String)session.getAttribute(Constants.SESSION_CMDKEY);
	    
	    ScUsers user = (ScUsers) session.getAttribute("sysUser");
		// 如果用户为空或者企业为空，退出系统
		if (user == null || ("").equals(user.getUserId())
				|| !"auditExpertSelect".equals(cmdkey)) {
			return "LogOut";
		}
		
		// 取得组ID
		this.groupId = this.getGroupId();
		//得到组下的所有专家
		List<TgroupExpertRealtion> tgroupExpertRealtions = tgroupExpertRealtionService.getList("tprojectGroup.groupId",groupId);
		if(tgroupExpertRealtions!=null&&tgroupExpertRealtions.size()>0){
			for(TgroupExpertRealtion tgroupExpertRealtion : tgroupExpertRealtions){
				if(tgroupExpertRealtion!=null){
					Texpert expert = tgroupExpertRealtion.getTexpert();
					if(expert!=null){
						texpertList.add(expert);
					}
				}
			}
		}
		
		return "showSendMessasePage";
	}
	
	/**
	 * 填写完发送信息内容后，点击完成
	 * @comments 
	 * @return
	 * @version 1.0
	 */
	public String sendEnd(){
		// 取得登录用户的信息
		HttpSession session = this.getRequest().getSession();
		String cmdkey = (String)session.getAttribute(Constants.SESSION_CMDKEY);
	    
	    ScUsers user = (ScUsers) session.getAttribute("sysUser");
		// 如果用户为空或者企业为空，退出系统
		if (user == null || ("").equals(user.getUserId()) || !"auditExpertSelect".equals(cmdkey)) {
			return "LogOut";
		}
		
		//专家ID
		String expertId = this.getParameter("expertId");
		//评审时间
		String sendTime = this.getParameter("sendTime");
		//评审地址
		String sendAddress = this.getParameter("sendAddress");
		//评审会议室
		String sendMeeting = this.getParameter("sendMeeting");
		//评审会期
		String sendDay = this.getParameter("sendDay");
		
		/********************专家信息***********************/
		StringBuffer expertInfo = new StringBuffer();
		Texpert expert = texpertService.get(expertId);
		if(expert!=null){
			expertInfo.append(expert.getExpertName());
			//专家职称
			if(CommonTool.IsNotEmpty(expert.getSkillJob())){
				Mitem mitem = mitemService.get(expert.getSkillJob());
				if(mitem!=null){
					expertInfo.append("（");
					expertInfo.append(mitem.getItemName());
					expertInfo.append("）");
				}
			}else{
				//专家职务
				String expertJob = expert.getExpertJob();
				if(CommonTool.IsNotEmpty(expertJob)){
					expertInfo.append("（");
					expertInfo.append(expertJob);
					expertInfo.append("）");
				}
				
			}	
		}
		
		/*******************组信息**************************/
		//组名称
		String groupName = "";
		//计划类别-项目分类
		String typeName = "";
		TprojectGroup projectGroup = tprojectGroupService.get(groupId);
		if(projectGroup!=null){
			groupName = projectGroup.getGroupName();
			typeName = tprojectTypeService.getProjectTypeShowName(projectGroup.getTypeId());
		}
		
		this.infoContent = this.getText("send_info_content",new String[]{expertInfo.toString(),typeName,sendTime,sendAddress+sendMeeting,sendDay,groupName});
		
		return "infoContent";
	}
	
	/**
	 * @comments 发送短信
	 * @return
	 * @Version 1.0
	 */
	public String sendByMessage(){
		// 取得登录用户的信息
		HttpSession session = this.getRequest().getSession();
		String cmdkey = (String)session.getAttribute(Constants.SESSION_CMDKEY);
	    
	    ScUsers user = (ScUsers) session.getAttribute("sysUser");
		// 如果用户为空或者企业为空，退出系统
		if (user == null || ("").equals(user.getUserId())
				|| !"auditExpertSelect".equals(cmdkey)) {
			return "LogOut";
		}
		
		// 取得专家手机号码
		//String sendNumber = this.getExpertPhone(groupId);
		Texpert expert = texpertService.get(expertId);
		String sendNumber = expert.getPhone();
		//得到组信息
		TprojectGroup group = tprojectGroupService.get(groupId);
		
		if(sendNumber != null && !"".equals(sendNumber)){
		
			Message message = new Message();
			
			// 主题 TODO
			message.setMessageTheme(this.getText("send_info_title", new String[]{group.getGroupName()}));
			// 内容
			//message.setMessageContent(this.getText("send_info_content", new String[]{sendTime,sendAddress}));
			message.setMessageContent(infoContent);
			// 发送对象
			message.setSendNumber(sendNumber);
			
			// 发送
			MessageSend.smsSend(message);
		}
		
		
		// 设置提示信息
		this.setRetMsg(this.getText("message_send_suc"));
		
		// 设置actionUrl   
		//this.setRetUrl(super.getRequest().getContextPath()+"/api/audit/projectApplication!showAuditExpertManage.action?now=" + new Date().getTime());
		this.setRetUrl(super.getRequest().getContextPath()+"/api/audit/projectApplicationJoint!batchSendMessage.action?groupId="+groupId+"&now=" + new Date().getTime());

		return "systemInfoMain";
	}
	
	/**
	 * @comments 发送E-mail
	 * @return
	 * @Version 1.0
	 */
	public String sendByEmail(){
		// 取得登录用户的信息
		HttpSession session = this.getRequest().getSession();
		String cmdkey = (String)session.getAttribute(Constants.SESSION_CMDKEY);
	    
	    ScUsers user = (ScUsers) session.getAttribute("sysUser");
		// 如果用户为空或者企业为空，退出系统
		if (user == null || ("").equals(user.getUserId())
				|| !"auditExpertSelect".equals(cmdkey)) {
			return "LogOut";
		}
		
		// 取得专家Email
		//String sendNumber = this.getExpertEmail(groupId);
		Texpert expert = texpertService.get(expertId);
		String sendNumber = expert.getEmail();
		//得到组信息
		TprojectGroup group = tprojectGroupService.get(groupId);
		
		if(sendNumber != null && !"".equals(sendNumber)){
			
			Message message = new Message();
			
			// 主题 TODO
			message.setMessageTheme(this.getText("send_info_title", new String[]{group.getGroupName()}));
			// 内容
			//message.setMessageContent(this.getText("send_info_content", new String[]{sendTime,sendAddress}));
			message.setMessageContent(infoContent);
			// 发送对象
			message.setSendNumber(sendNumber);
			
			// 发送
			MessageSend.emailSend(message);
		}
		
		// 设置提示信息
		this.setRetMsg(this.getText("message_send_suc"));
		
		// 设置actionUrl
		//this.setRetUrl(super.getRequest().getContextPath()+"/api/audit/projectApplication!showAuditExpertManage.action?now=" + new Date().getTime());
		this.setRetUrl(super.getRequest().getContextPath()+"/api/audit/projectApplicationJoint!batchSendMessage.action?groupId="+groupId+"&now=" + new Date().getTime());

		return "systemInfoMain";
	}
	
	/**
	 * @throws IOException 
	 * @throws WriteException 
	 * @comments 打印专家意见
	 * @Version 1.0
	 */
	public void printExpertOpinions() throws IOException, WriteException{
		
		// 取得登录用户的信息
		HttpSession session = this.getRequest().getSession();
		String cmdkey = (String)session.getAttribute(Constants.SESSION_CMDKEY);
	    
	    ScUsers user = (ScUsers) session.getAttribute("sysUser");
		// 如果用户为空或者企业为空，退出系统
		if (user == null || ("").equals(user.getUserId())
				|| !"jointAudit".equals(cmdkey)) {
			return;
		}
		
		this.groupId = this.getGroupId();
		
		this.projectList = 
				tprojectApplicationJointService.getProjectListByGroupId(groupId);
		
		// 取得文件名称
		String excelFileName = this.getText("expert_opinions_file_name");
		
		this.exportData(excelFileName, projectList);
	}
	
	/**
	 * @comments 
	 * @param excelFileName 导出数据
	 * @param tpLsit
	 * @throws IOException 
	 * @throws WriteException 
	 * @Version 1.0
	 */
	private void exportData(String excelFileName, List<TprojectApplication> tpLsit) throws IOException, WriteException{
		HttpServletResponse response = this.getResponse();
		
		OutputStream out = null;
		WritableWorkbook workbook = null;
		try {
			// 清空输出流
			response.reset();
			// 设定输出文件头
			response.setHeader("Content-Disposition", "attachment; filename=\"" + new String(excelFileName.getBytes("GB2312"), "ISO_8859_1") + ".xls\"");
			// 定义输出类型
			response.setContentType("application/vnd.ms-excel");
			// 取得输出流
			out = response.getOutputStream();
			// 建立excel文件
			workbook = Workbook.createWorkbook(out);
			
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
			//headerCf.setBackground(Colour.ICE_BLUE);
			// 设置自动换行
			headerCf.setWrap(true);
			headerCf.setFont(wf2);
			// 水平居中显示
			headerCf.setAlignment(Alignment.CENTRE);

			// 百分比格式
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

			// 计划类别名称格式
			WritableCellFormat typeCf = new WritableCellFormat();
			// 设置边框
			typeCf.setBorder(Border.ALL, BorderLineStyle.THIN);
			// 垂直居中显示
			typeCf.setVerticalAlignment(VerticalAlignment.CENTRE);
			// 水平居中显示
			typeCf.setAlignment(Alignment.LEFT);
			// 设置字体
			WritableFont wf3 = new WritableFont(WritableFont.createFont("宋体"), 10, WritableFont.NO_BOLD, false);
			typeCf.setFont(wf3);
			
			// 计划类别名称格式
			WritableCellFormat typeCf1 = new WritableCellFormat();
			// 设置边框
			typeCf1.setBorder(Border.ALL, BorderLineStyle.THIN);
			// 垂直居中显示
			typeCf1.setVerticalAlignment(VerticalAlignment.CENTRE);
			// 水平居中显示
			typeCf1.setAlignment(Alignment.CENTRE);
			typeCf1.setFont(wf3);
			
			WritableSheet sh = workbook.createSheet(excelFileName, 0);
			
			sh.addCell(new Label(0, 0, this.getText("expert_title_no"), headerCf));
			sh.setColumnView(0, 10);
			sh.setRowView(0, 500);
			sh.addCell(new Label(1, 0, this.getText("expert_title_project_name"), headerCf));
			sh.setColumnView(1, 30);
			sh.addCell(new Label(2, 0, this.getText("expert_title_app_unit"), headerCf));
			sh.setColumnView(2, 30);
			sh.addCell(new Label(3, 0, this.getText("expert_title_project_type"), headerCf));
			sh.setColumnView(3, 30);
			sh.addCell(new Label(4, 0, this.getText("expert_title_tec_opinions"), headerCf));
			sh.setColumnView(4, 60);
			//sh.addCell(new Label(7, 2, this.getText("expert_title_tec_recommend"), headerCf));
			sh.addCell(new Label(5, 0, this.getText("expert_title_inv_opinions"), headerCf));
			sh.setColumnView(5, 60);
			//sh.addCell(new Label(9, 2, this.getText("expert_title_inv_recommend"), headerCf));
			//sh.addCell(new Label(10, 2, this.getText("expert_title_audit_composite"), headerCf));
			//sh.addCell(new Label(11, 2, this.getText("expert_title_audit_recommend"), headerCf));
			
			
			for(int i=0; i<tpLsit.size(); i++){
				TprojectApplication tp = tpLsit.get(i);
				
				sh.addCell(new Label(0, i + 1, String.valueOf(i + 1), numberCf));
				sh.setRowView(i+1, 500);
				sh.addCell(new Label(1, i + 1, tp.getProjectName(), typeCf));
				sh.addCell(new Label(2, i + 1, tp.getApplicationUnit(), typeCf));
				sh.addCell(new Label(3, i + 1, tp.getPlanFlagName() + Constants.STRING_LINK + tp.getTypeName(), typeCf));
				sh.addCell(new Label(4, i + 1, tp.getExpertTecOpinion(), typeCf));
				//sh.addCell(new Label(7, i + 3, tp.getExpertTecRecommend(), typeCf1));
				sh.addCell(new Label(5, i + 1, tp.getExpertInvOpinion(), typeCf));
				//sh.addCell(new Label(9, i + 3, tp.getExpertInvRecommend(), typeCf1));
				//sh.addCell(new Label(10, i + 3, tp.getExpertAuditComposite(), typeCf));
				//sh.addCell(new Label(11, i + 3, tp.getExpertAuditRecommend(), typeCf1));
			}
			
			// ===========写入数据 end===========

			workbook.write();
			out.flush();
			response.flushBuffer();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			if (null != workbook) {
				workbook.close();
			}
			if (null != out) {
				out.close();
			}
		}
	}
	
	/**
	 * @comments 显示院所/高端人才录入
	 * @return
	 * @Version 1.0
	 */
	public String showHighEndInput(){
		
		// 取得登录用户的信息
		HttpSession session = this.getRequest().getSession();
		String cmdkey = (String)session.getAttribute(Constants.SESSION_CMDKEY);
	    
	    ScUsers user = (ScUsers) session.getAttribute("sysUser");
		// 如果用户为空或者企业为空，退出系统
		if (user == null || ("").equals(user.getUserId())
				|| !"jointAudit".equals(cmdkey)) {
			return "LogOut";
		}
		
		TcompanyInfo tc = tcompanyInfoService.get("tprojectApplication.projectId", projectId);
		if(tc != null){
			this.highEnd = tc.getInstitutesHighTalent();
		}
		
		return "showHighEndInput";
	}
	
	/**
	 * @throws UnsupportedEncodingException 
	 * @comments 保存院所/高端人才
	 * @Version 1.0
	 */
	public void updateHighEndInput() throws UnsupportedEncodingException{
		// 取得登录用户的信息
		HttpSession session = this.getRequest().getSession();
		String cmdkey = (String)session.getAttribute(Constants.SESSION_CMDKEY);
	    
	    ScUsers user = (ScUsers) session.getAttribute("sysUser");
		// 如果用户为空或者企业为空，退出系统
		if (user == null || ("").equals(user.getUserId())
				|| !"jointAudit".equals(cmdkey)) {
			return ;
		}
		
		tcompanyInfoService.updateHighEnd(projectId, new String(highEnd.getBytes("ISO-8859-1"), "UTF-8"));
	}
	
	/**
	 * @comments 发送通知 
	 * @return
	 * @Version 1.0
	 */
	public String sendMessage(){
		// 取得登录用户的信息
		HttpSession session = this.getRequest().getSession();
		String cmdkey = (String)session.getAttribute(Constants.SESSION_CMDKEY);
	    
	    ScUsers user = (ScUsers) session.getAttribute("sysUser");
		// 如果用户为空或者企业为空，退出系统
		if (user == null || ("").equals(user.getUserId())
				|| !"jointAudit".equals(cmdkey)) {
			return "LogOut";
		}
		
		// 取得项目Id
		this.projectId = this.getProjectId();
		
		// 设置专家Id
		this.expertId = this.getExpertId();
		
		return "showSendMessasePage";
	}
	
	
	/**
	 * @comments 封装专家手机信息
	 * @param groupId
	 * @return
	 * @Version 1.0
	 */
	/*private String getExpertPhone(String groupId){
		StringBuffer phoneStr = new StringBuffer();
		
		List<TgroupExpertRealtion> gerList = tgroupExpertRealtionService.getList("tprojectGroup.groupId", groupId);
		if(gerList != null && gerList.size() >0){
			for(int i=0; i< gerList.size(); i++){
				TgroupExpertRealtion groupExpertRealtion = gerList.get(i);
				if(groupExpertRealtion!=null){
					Texpert texpert = groupExpertRealtion.getTexpert();
					if(texpert!=null){
						String phone = texpert.getPhone();
						if(CommonTool.IsNotEmpty(phone)){
							phoneStr.append(phone);
							
							if(i < gerList.size() -1){
								phoneStr.append(",");
							}
						}
					}
				}
			}
		}
		
		return phoneStr.toString();
	}*/
	
	/**
	 * @comments 封装专家Email信息
	 * @param groupId
	 * @return
	 * @Version 1.0
	 */
	/*private String getExpertEmail(String groupId){
		StringBuffer emailStr = new StringBuffer();
		
		List<TgroupExpertRealtion> gerList = tgroupExpertRealtionService.getList("tprojectGroup.groupId", groupId);
		if(gerList != null && gerList.size() >0){
			for(int i=0; i< gerList.size(); i++){
				TgroupExpertRealtion groupExpertRealtion = gerList.get(i);
				if(groupExpertRealtion!=null){
					Texpert texpert = groupExpertRealtion.getTexpert();
					if(texpert!=null){
						String email = texpert.getEmail();
						if(CommonTool.IsNotEmpty(email)){
							emailStr.append(email);
							
							if(i < gerList.size() -1){
								emailStr.append(",");
							}
						}
					}
				}
			}
		}
		
		return emailStr.toString();
	}*/
	
	
	public int getPageNo() {
		return pageNo;
	}

	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
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

	public List<Mitem> getCompanyTypeList() {
		return companyTypeList;
	}

	public void setCompanyTypeList(List<Mitem> companyTypeList) {
		this.companyTypeList = companyTypeList;
	}

	public List<Mitem> getProjectTypeList() {
		return projectTypeList;
	}

	public void setProjectTypeList(List<Mitem> projectTypeList) {
		this.projectTypeList = projectTypeList;
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

	public List<TprojectGroup> getProjectGroupList() {
		return projectGroupList;
	}

	public void setProjectGroupList(List<TprojectGroup> projectGroupList) {
		this.projectGroupList = projectGroupList;
	}

	public List<Mitem> getAuditStatusList() {
		return auditStatusList;
	}

	public void setAuditStatusList(List<Mitem> auditStatusList) {
		this.auditStatusList = auditStatusList;
	}

	public String getCompanyType() {
		return companyType;
	}

	public void setCompanyType(String companyType) {
		this.companyType = companyType;
	}

	public String getProjectType() {
		return projectType;
	}

	public void setProjectType(String projectType) {
		this.projectType = projectType;
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

	public String getProjectGroup() {
		return projectGroup;
	}

	public void setProjectGroup(String projectGroup) {
		this.projectGroup = projectGroup;
	}

	public String getProjectGroupSon() {
		return projectGroupSon;
	}

	public void setProjectGroupSon(String projectGroupSon) {
		this.projectGroupSon = projectGroupSon;
	}

	public String getAuditStatus() {
		return auditStatus;
	}

	public void setAuditStatus(String auditStatus) {
		this.auditStatus = auditStatus;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public String getApplyCompany() {
		return applyCompany;
	}

	public void setApplyCompany(String applyCompany) {
		this.applyCompany = applyCompany;
	}

	public List<Map<String, Object>> getProjectSelectList() {
		return projectSelectList;
	}

	public void setProjectSelectList(List<Map<String, Object>> projectSelectList) {
		this.projectSelectList = projectSelectList;
	}

	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	public String getGroupId() {
		return groupId;
	}

	public void setGroupId(String groupId) {
		this.groupId = groupId;
	}

	public String getGroupDateFlag() {
		return groupDateFlag;
	}

	public void setGroupDateFlag(String groupDateFlag) {
		this.groupDateFlag = groupDateFlag;
	}

	public List<Mitem> getGoodProfessList() {
		return goodProfessList;
	}

	public void setGoodProfessList(List<Mitem> goodProfessList) {
		this.goodProfessList = goodProfessList;
	}


	public List<Mitem> getCredibyLevelList() {
		return credibyLevelList;
	}

	public void setCredibyLevelList(List<Mitem> credibyLevelList) {
		this.credibyLevelList = credibyLevelList;
	}

	public String getProjectId() {
		return projectId;
	}


	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}


	public String getExpertName() {
		return expertName;
	}


	public void setExpertName(String expertName) {
		this.expertName = expertName;
	}


	public String getGoodProfess() {
		return goodProfess;
	}


	public void setGoodProfess(String goodProfess) {
		this.goodProfess = goodProfess;
	}


	public String getCredibyLevel() {
		return credibyLevel;
	}


	public void setCredibyLevel(String credibyLevel) {
		this.credibyLevel = credibyLevel;
	}


	public List<Texpert> getExList() {
		return exList;
	}


	public void setExList(List<Texpert> exList) {
		this.exList = exList;
	}

	public List<Mitem> getSexList() {
		return sexList;
	}

	public void setSexList(List<Mitem> sexList) {
		this.sexList = sexList;
	}

	public List<Map<String, Object>> getGraduatedList() {
		return graduatedList;
	}

	public void setGraduatedList(List<Map<String, Object>> graduatedList) {
		this.graduatedList = graduatedList;
	}

	public List<Mitem> getBirthdayYearList() {
		return birthdayYearList;
	}


	public void setBirthdayYearList(List<Mitem> birthdayYearList) {
		this.birthdayYearList = birthdayYearList;
	}

	public List<Mitem> getSchoolingTypeList() {
		return schoolingTypeList;
	}

	public void setSchoolingTypeList(List<Mitem> schoolingTypeList) {
		this.schoolingTypeList = schoolingTypeList;
	}

	public List<Mitem> getSkilljobTypeList() {
		return skilljobTypeList;
	}

	public void setSkilljobTypeList(List<Mitem> skilljobTypeList) {
		this.skilljobTypeList = skilljobTypeList;
	}


	public List<Map<String, Object>> getExpertmajorTypeList() {
		return expertmajorTypeList;
	}


	public void setExpertmajorTypeList(List<Map<String, Object>> expertmajorTypeList) {
		this.expertmajorTypeList = expertmajorTypeList;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}


	public String getGraduatedName() {
		return graduatedName;
	}

	public void setGraduatedName(String graduatedName) {
		this.graduatedName = graduatedName;
	}

	public String getBirthdayYear() {
		return birthdayYear;
	}

	public void setBirthdayYear(String birthdayYear) {
		this.birthdayYear = birthdayYear;
	}


	public String getSchoolingType() {
		return schoolingType;
	}


	public void setSchoolingType(String schoolingType) {
		this.schoolingType = schoolingType;
	}

	public String getSkilljobType() {
		return skilljobType;
	}


	public void setSkilljobType(String skilljobType) {
		this.skilljobType = skilljobType;
	}

	public String getExpertmajorType() {
		return expertmajorType;
	}

	public void setExpertmajorType(String expertmajorType) {
		this.expertmajorType = expertmajorType;
	}

	public String getSelectedExpertIds() {
		return selectedExpertIds;
	}

	public void setSelectedExpertIds(String selectedExpertIds) {
		this.selectedExpertIds = selectedExpertIds;
	}

	public String getExpertId() {
		return expertId;
	}

	public void setExpertId(String expertId) {
		this.expertId = expertId;
	}

	public String getSelectedScoreIds() {
		return selectedScoreIds;
	}

	public void setSelectedScoreIds(String selectedScoreIds) {
		this.selectedScoreIds = selectedScoreIds;
	}


	public String getScoreId() {
		return scoreId;
	}

	public void setScoreId(String scoreId) {
		this.scoreId = scoreId;
	}


	public Texpert getExpert() {
		return expert;
	}

	public void setExpert(Texpert expert) {
		this.expert = expert;
	}

	public String getSelectedProjectIds() {
		return selectedProjectIds;
	}

	public void setSelectedProjectIds(String selectedProjectIds) {
		this.selectedProjectIds = selectedProjectIds;
	}


	public List<TexpertScore> getTexpertScoreList() {
		return texpertScoreList;
	}

	public void setTexpertScoreList(List<TexpertScore> texpertScoreList) {
		this.texpertScoreList = texpertScoreList;
	}


	public TprojectApplication getTprojectApplication() {
		return tprojectApplication;
	}


	public void setTprojectApplication(TprojectApplication tprojectApplication) {
		this.tprojectApplication = tprojectApplication;
	}

	public VprojectInfo getVprojectInfo() {
		return vprojectInfo;
	}

	public void setVprojectInfo(VprojectInfo vprojectInfo) {
		this.vprojectInfo = vprojectInfo;
	}

	public List<Mitem> getExpertMajor1List() {
		return expertMajor1List;
	}

	public void setExpertMajor1List(List<Mitem> expertMajor1List) {
		this.expertMajor1List = expertMajor1List;
	}

	public List<Mitem> getExpertPrestigeList() {
		return expertPrestigeList;
	}

	public void setExpertPrestigeList(List<Mitem> expertPrestigeList) {
		this.expertPrestigeList = expertPrestigeList;
	}

	public String getExpertMajor1() {
		return expertMajor1;
	}

	public void setExpertMajor1(String expertMajor1) {
		this.expertMajor1 = expertMajor1;
	}

	public String getExpertPrestige() {
		return expertPrestige;
	}

	public void setExpertPrestige(String expertPrestige) {
		this.expertPrestige = expertPrestige;
	}

	public Texpert getTexpert() {
		return texpert;
	}

	public void setTexpert(Texpert texpert) {
		this.texpert = texpert;
	}

	public List<Mitem> getSchoolingList() {
		return schoolingList;
	}

	public void setSchoolingList(List<Mitem> schoolingList) {
		this.schoolingList = schoolingList;
	}

	public List<Mitem> getExpertdegreeList() {
		return expertdegreeList;
	}

	public void setExpertdegreeList(List<Mitem> expertdegreeList) {
		this.expertdegreeList = expertdegreeList;
	}

	public List<Mitem> getExpertjobList() {
		return expertjobList;
	}

	public void setExpertjobList(List<Mitem> expertjobList) {
		this.expertjobList = expertjobList;
	}

	public List<Mitem> getSkilljobList() {
		return skilljobList;
	}

	public void setSkilljobList(List<Mitem> skilljobList) {
		this.skilljobList = skilljobList;
	}

	public List<Mitem> getExpertMajor2List() {
		return expertMajor2List;
	}

	public void setExpertMajor2List(List<Mitem> expertMajor2List) {
		this.expertMajor2List = expertMajor2List;
	}

	public List<Mitem> getExpertMajor3List() {
		return expertMajor3List;
	}

	public void setExpertMajor3List(List<Mitem> expertMajor3List) {
		this.expertMajor3List = expertMajor3List;
	}

	public List<Mitem> getExpertprestigeList() {
		return expertprestigeList;
	}

	public void setExpertprestigeList(List<Mitem> expertprestigeList) {
		this.expertprestigeList = expertprestigeList;
	}

	public List<Mitem> getDepttypeList() {
		return depttypeList;
	}

	public void setDepttypeList(List<Mitem> depttypeList) {
		this.depttypeList = depttypeList;
	}

	public String getCommissionerOpinion() {
		return commissionerOpinion;
	}

	public void setCommissionerOpinion(String commissionerOpinion) {
		this.commissionerOpinion = commissionerOpinion;
	}

	public String getMeetingOpinion() {
		return meetingOpinion;
	}

	public void setMeetingOpinion(String meetingOpinion) {
		this.meetingOpinion = meetingOpinion;
	}

	public String getProjectApplyStatus() {
		return projectApplyStatus;
	}

	public void setProjectApplyStatus(String projectApplyStatus) {
		this.projectApplyStatus = projectApplyStatus;
	}

	public String getJointEditFlag() {
		return jointEditFlag;
	}

	public void setJointEditFlag(String jointEditFlag) {
		this.jointEditFlag = jointEditFlag;
	}

	public List<Mitem> getJointStatusList() {
		return jointStatusList;
	}

	public void setJointStatusList(List<Mitem> jointStatusList) {
		this.jointStatusList = jointStatusList;
	}

	public String getJointStatus() {
		return jointStatus;
	}

	public void setJointStatus(String jointStatus) {
		this.jointStatus = jointStatus;
	}

	public List<TprojectApplication> getProjectList() {
		return projectList;
	}

	public void setProjectList(List<TprojectApplication> projectList) {
		this.projectList = projectList;
	}

	public String getSendTime() {
		return sendTime;
	}

	public void setSendTime(String sendTime) {
		this.sendTime = sendTime;
	}

	public String getSendAddress() {
		return sendAddress;
	}

	public void setSendAddress(String sendAddress) {
		this.sendAddress = sendAddress;
	}

	public List<Texpert> getTexpertList() {
		return texpertList;
	}

	public void setTexpertList(List<Texpert> texpertList) {
		this.texpertList = texpertList;
	}

	public String getInfoContent() {
		return infoContent;
	}

	public void setInfoContent(String infoContent) {
		this.infoContent = infoContent;
	}

	public String getHighEnd() {
		return highEnd;
	}

	public void setHighEnd(String highEnd) {
		this.highEnd = highEnd;
	}
	
	
}