package com.hopsun.tppas.api.report.action;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.hopsun.framework.base.action.BaseAction;
import com.hopsun.scenter.entity.ScUsers;
import com.hopsun.tppas.api.report.service.TprojectApplicationService;
import com.hopsun.tppas.api.report.service.TreviewCommentsService;
import com.hopsun.tppas.api.superadmin.service.MitemService;
import com.hopsun.tppas.api.superadmin.service.TattachmentService;
import com.hopsun.tppas.api.superadmin.service.TprojectTypeService;
import com.hopsun.tppas.common.Constants;
import com.hopsun.tppas.entity.Mitem;
import com.hopsun.tppas.entity.Tattachment;
import com.hopsun.tppas.entity.TprojectApplication;
import com.hopsun.tppas.entity.TreviewComments;

public class TreviewCommentsAction extends BaseAction {
	public final static Logger logger = Logger.getLogger(TreviewCommentsAction.class.getName());

	private static final long serialVersionUID = 4496274418704463215L;
	@Resource
	private TreviewCommentsService treviewCommentsService;
	@Resource
	private TprojectApplicationService tprojectApplicationService;
	@Resource
	private TattachmentService tattachmentService;
	@Resource
	private MitemService mitemService;
	@Resource
	private TprojectTypeService tprojectTypeService;

	/** 项目申报信息 */
	private TprojectApplication tprojectApplication;
	/** 附件对象 */
	private Tattachment tattachment;
	/** 项目状态 */
	private String applyStatus;
	/** 项目ID */
	private String projectId;
	/** 审查意见 */
	private TreviewComments treviewComments;
	/** 文件类型 */
	private String fileType;
	/** 附件ID */
	private String attachmentId;
	/** 附件存在区分 */
	private String fileFlag;
	/** 文件名 */
	private String namesuffix;
	/** 企业信息显示Flag */
	private String isWriteFlag;
	/** 产业处Flag */
	private String highTechFlg;

	/**
	 * @comments 显示审查意见（非高新）
	 * @return
	 * @Version 1.0
	 */
	public String showTreviewCommentsNonTech() {

		HttpSession session = this.getRequest().getSession();
		// 取得登录用户的信息
		ScUsers user = (ScUsers) session.getAttribute("sysUser");
		// session.setAttribute(Constants.SESSION_CMDKEY,
		// "treviewCommentsNonTech");

		// 判断是否失效
		if (user == null || ("").equals(user.getUserId())) {
			logger.error("用户不存在！");
			return "LogOut";
		}

		// 取得审查意见
		this.treviewComments = treviewCommentsService.get("tprojectApplication.projectId", projectId);

		// 取得附件类型
		Mitem mitem = mitemService.get(Constants.FILE_UPLOAD_TYPE);
		if (mitem != null) {
			this.fileType = mitem.getItemDesc();
		}

		tattachment = tattachmentService.getTattachmentByPTN("T_REVIEW_COMMENTS", projectId, "T_PROJECT_APPLICATION");
		if (tattachment != null) {
			this.attachmentId = tattachment.getAttachmentId();
			this.namesuffix = tattachment.getAttachmentAddress().substring(tattachment.getAttachmentAddress().lastIndexOf("."));
			this.fileFlag = "1";
		}

		// 判断是否为产业处
		tprojectApplication = tprojectApplicationService.get(projectId);
		if (tprojectApplication != null && tprojectApplication.getTprojectType() != null) {
			// 产业处
			if (Constants.HIGHTECH_DEPARTMENT.equals(tprojectApplication.getTprojectType().getDepartmentId())) {
				highTechFlg = "1";
			} else {
				highTechFlg = "0";
			}
		}

		// if(tprojectTypeService.getIsWrite(projectId)){
		// this.isWriteFlag = "1";
		// } else{
		// this.isWriteFlag = "0";
		// }

		return "showTreviewCommentsNonTech";
	}

	/**
	 * @return the treviewCommentsService
	 */
	public TreviewCommentsService getTreviewCommentsService() {
		return treviewCommentsService;
	}

	/**
	 * @param treviewCommentsService
	 *            the treviewCommentsService to set
	 */
	public void setTreviewCommentsService(TreviewCommentsService treviewCommentsService) {
		this.treviewCommentsService = treviewCommentsService;
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
	 * @return the tattachment
	 */
	public Tattachment getTattachment() {
		return tattachment;
	}

	/**
	 * @param tattachment
	 *            the tattachment to set
	 */
	public void setTattachment(Tattachment tattachment) {
		this.tattachment = tattachment;
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
	 * @return the treviewComments
	 */
	public TreviewComments getTreviewComments() {
		return treviewComments;
	}

	/**
	 * @param treviewComments
	 *            the treviewComments to set
	 */
	public void setTreviewComments(TreviewComments treviewComments) {
		this.treviewComments = treviewComments;
	}

	/**
	 * @return the fileType
	 */
	public String getFileType() {
		return fileType;
	}

	/**
	 * @param fileType
	 *            the fileType to set
	 */
	public void setFileType(String fileType) {
		this.fileType = fileType;
	}

	/**
	 * @return the attachmentId
	 */
	public String getAttachmentId() {
		return attachmentId;
	}

	/**
	 * @param attachmentId
	 *            the attachmentId to set
	 */
	public void setAttachmentId(String attachmentId) {
		this.attachmentId = attachmentId;
	}

	/**
	 * @return the fileFlag
	 */
	public String getFileFlag() {
		return fileFlag;
	}

	/**
	 * @param fileFlag
	 *            the fileFlag to set
	 */
	public void setFileFlag(String fileFlag) {
		this.fileFlag = fileFlag;
	}

	/**
	 * @return the namesuffix
	 */
	public String getNamesuffix() {
		return namesuffix;
	}

	/**
	 * @param namesuffix
	 *            the namesuffix to set
	 */
	public void setNamesuffix(String namesuffix) {
		this.namesuffix = namesuffix;
	}

	public String getIsWriteFlag() {
		return isWriteFlag;
	}

	public void setIsWriteFlag(String isWriteFlag) {
		this.isWriteFlag = isWriteFlag;
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
	 * @return the tprojectTypeService
	 */
	public TprojectTypeService getTprojectTypeService() {
		return tprojectTypeService;
	}

	/**
	 * @param tprojectTypeService
	 *            the tprojectTypeService to set
	 */
	public void setTprojectTypeService(TprojectTypeService tprojectTypeService) {
		this.tprojectTypeService = tprojectTypeService;
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
	 * @return the highTechFlg
	 */
	public String getHighTechFlg() {
		return highTechFlg;
	}

	/**
	 * @param highTechFlg
	 *            the highTechFlg to set
	 */
	public void setHighTechFlg(String highTechFlg) {
		this.highTechFlg = highTechFlg;
	}

}
