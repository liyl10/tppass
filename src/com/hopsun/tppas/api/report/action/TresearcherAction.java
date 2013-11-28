package com.hopsun.tppas.api.report.action;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.hopsun.framework.base.action.BaseAction;
import com.hopsun.framework.base.bean.Pager;
import com.hopsun.scenter.entity.ScUsers;
import com.hopsun.tppas.api.report.service.TprojectApplicationService;
import com.hopsun.tppas.api.report.service.TresearcherService;
import com.hopsun.tppas.api.superadmin.service.MitemService;
import com.hopsun.tppas.common.Constants;
import com.hopsun.tppas.entity.Mitem;
import com.hopsun.tppas.entity.TprojectApplication;
import com.hopsun.tppas.entity.Tresearcher;

public class TresearcherAction extends BaseAction {
	public final static Logger LOGGER = Logger.getLogger(TresearcherAction.class.getName());

	private static final long serialVersionUID = 6179314880198826314L;
	@Resource
	private TresearcherService tresearcherService;
	@Resource
	private TprojectApplicationService tprojectApplicationService;
	@Resource
	private MitemService mitemService;
	private Tresearcher tresearcher;
	private String researcherId;
	/** 项目申报信息 */
	private TprojectApplication tprojectApplication;
	/** 翻页 */
	private int pageNo;
	/** 项目id */
	private String projectId;
	/** 项目状态 */
	private String applyStatus;
	/** 性别 */
	private List<String> sexFlagList;
	/** 职务职称 */
	private List<Mitem> jobList;

	/**
	 * @comments 根据研究人员ID分页查询
	 * @return
	 * @version 1.0
	 */
	public String list() {

		// 取得登录用户的信息
		HttpSession session = this.getRequest().getSession();
		ScUsers user = (ScUsers) session.getAttribute("sysUser");
		// session.setAttribute(Constants.SESSION_CMDKEY, "tresearcherAction");

		// 判断是否失效
		if (user == null || ("").equals(user.getUserId())) {
			LOGGER.error("用户不存在！");
			return "LogOut";
		}

		// 翻页
		if (pager == null && this.getPageNo() == 0) {
			pager = new Pager();
		} else {
			pager = new Pager();
			pager.setPageNumber(this.getPageNo());
		}
		if (projectId != null) {
			this.tprojectApplication = tprojectApplicationService.get(projectId);
			if (tprojectApplication != null) {
				if (Constants.PROJECT_REPORT_NOTPASS.equals(tprojectApplication.getApplyStatus()) || Constants.PROJECT_REPORT_WRITE.equals(tprojectApplication.getApplyStatus())) {
					this.applyStatus = "1";
				} else {
					this.applyStatus = "0";
				}
			}
		}
		// 获取项目申报的列表数据
		pager = tresearcherService.find(projectId, pager.getPageNumber(), pager.getPageSize());

		return "researcherlist";
	}

	/**
	 * 
	 * @comments 跳转到添加页面 初始化
	 * @return
	 * @version 1.0
	 */
	public String showResearcher() {

		/*
		 * HttpSession session = this.getRequest().getSession(); String cmdkey =
		 * (String) session.getAttribute(Constants.SESSION_CMDKEY); if (cmdkey
		 * == null || !"tresearcherAction".equals(cmdkey)) {
		 * LOGGER.error("错误的令牌！"); return "LogOut"; }
		 */

		// 性别
		this.sexFlagList = new ArrayList<String>();
		this.sexFlagList.add("男");
		this.sexFlagList.add("女");
		// 职务职称List
		this.jobList = new ArrayList<Mitem>();
		// 取得职务职称信息
		this.jobList = mitemService.getListByTypeId(Constants.TYPE_PROJECT_PERSON_TITLE);
		if (researcherId != null && !"".equals(researcherId)) {
			this.tresearcher = tresearcherService.get(researcherId);
		}
		return "showresearcher";
	}

	/**
	 * @return the tresearcherService
	 */
	public TresearcherService getTresearcherService() {
		return tresearcherService;
	}

	/**
	 * @param tresearcherService
	 *            the tresearcherService to set
	 */
	public void setTresearcherService(TresearcherService tresearcherService) {
		this.tresearcherService = tresearcherService;
	}

	/**
	 * @return the tprojectApplicationService
	 */
	public TprojectApplicationService getTprojectApplicationService() {
		return tprojectApplicationService;
	}

	/**
	 * @param tprojectApplicationService
	 *            the tprojectApplicationService to set
	 */
	public void setTprojectApplicationService(TprojectApplicationService tprojectApplicationService) {
		this.tprojectApplicationService = tprojectApplicationService;
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
	 * @return the pageNo
	 */
	public int getPageNo() {
		return pageNo;
	}

	/**
	 * @param pageNo
	 *            the pageNo to set
	 */
	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
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
	 * @return the applyStatus
	 */
	public String getApplyStatus() {
		return applyStatus;
	}

	/**
	 * @param applyStatus
	 *            the applyStatus to set
	 */
	public void setApplyStatus(String applyStatus) {
		this.applyStatus = applyStatus;
	}

	/**
	 * @return the mitemService
	 */
	public MitemService getMitemService() {
		return mitemService;
	}

	/**
	 * @param mitemService
	 *            the mitemService to set
	 */
	public void setMitemService(MitemService mitemService) {
		this.mitemService = mitemService;
	}

	/**
	 * @return the tresearcher
	 */
	public Tresearcher getTresearcher() {
		return tresearcher;
	}

	/**
	 * @param tresearcher
	 *            the tresearcher to set
	 */
	public void setTresearcher(Tresearcher tresearcher) {
		this.tresearcher = tresearcher;
	}

	/**
	 * @return the researcherId
	 */
	public String getResearcherId() {
		return researcherId;
	}

	/**
	 * @param researcherId
	 *            the researcherId to set
	 */
	public void setResearcherId(String researcherId) {
		this.researcherId = researcherId;
	}

	/**
	 * @return the sexFlagList
	 */
	public List<String> getSexFlagList() {
		return sexFlagList;
	}

	/**
	 * @param sexFlagList
	 *            the sexFlagList to set
	 */
	public void setSexFlagList(List<String> sexFlagList) {
		this.sexFlagList = sexFlagList;
	}

	/**
	 * @return the jobList
	 */
	public List<Mitem> getJobList() {
		return jobList;
	}

	/**
	 * @param jobList
	 *            the jobList to set
	 */
	public void setJobList(List<Mitem> jobList) {
		this.jobList = jobList;
	}

}
