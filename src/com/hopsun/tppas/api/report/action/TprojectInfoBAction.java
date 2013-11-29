package com.hopsun.tppas.api.report.action;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.hopsun.framework.base.action.BaseAction;
import com.hopsun.scenter.entity.ScUsers;
import com.hopsun.tppas.api.report.service.TprojectApplicationService;
import com.hopsun.tppas.api.report.service.TprojectInfoBService;
import com.hopsun.tppas.api.superadmin.service.MitemService;
import com.hopsun.tppas.api.superadmin.service.TprojectTypeService;
import com.hopsun.tppas.common.Constants;
import com.hopsun.tppas.entity.Mitem;
import com.hopsun.tppas.entity.TprojectApplication;
import com.hopsun.tppas.entity.TprojectInfoB;

public class TprojectInfoBAction extends BaseAction {
	public final static Logger logger = Logger.getLogger(TprojectInfoBAction.class.getName());
	private static final long serialVersionUID = -1242514307374509044L;
	@Resource
	private TprojectInfoBService tprojectInfoBService;

	@Resource
	private TprojectApplicationService tprojectApplicationService;

	@Resource
	private TprojectTypeService tprojectTypeService;

	@Resource
	private MitemService mitemService;

	/** 项目基本信息 */
	private TprojectInfoB tprojectInfoB;
	/** 项目信息 */
	private TprojectApplication tprojectApplication;
	/** 项目Id */
	private String projectId;
	/** 归口管理部门 */
	private List<Mitem> centralizedBranchList;
	/** 所在区域（省） */
	private List<Mitem> regionIdList1;
	/** 所在区域（市） */
	private List<Mitem> regionIdList2;
	/** 所在区域（区） */
	private List<Mitem> regionIdList3;
	/** 行业领域1 */
	private List<Mitem> industriesList1;
	/** 行业领域2 */
	private List<Mitem> industriesList2;
	/** 行业领域3 */
	private List<Mitem> industriesList3;
	/** 行业领域4 */
	private List<Mitem> industriesList4;
	/** 单位性质 */
	private List<Mitem> unitPropertiesList;
	/** 项目所属技术领域1集合 */
	private List<Mitem> technicalFisldList1;
	/** 项目所属技术领域2集合 */
	private List<Mitem> technicalFisldList2;
	/** 项目所属技术领域3集合 */
	private List<Mitem> technicalFisldList3;
	/** 知识产权状况 */
	private List<Mitem> intellectualPropertyList;
	/** 技术来源 */
	private List<Mitem> technologySourceList;
	/** 项目分类 */
	private String projectTypeName;
	/** 下拉列表父级Id */
	private String pitemId;
	/** 下拉列表返回字符串 */
	private String backStr;
	/** 跳转路径 */
	private String retUrl;
	/** 跳转页面massage */
	private String retMsg;

	/**
	 * @comments 显示项目基本信息
	 * @return
	 * @Version 1.0
	 */
	public String showProjectInfoB() {

		HttpSession session = this.getRequest().getSession();
		// 取得登录用户的信息
		ScUsers user = (ScUsers) session.getAttribute("sysUser");
		// session.setAttribute(Constants.SESSION_CMDKEY, "projectInfoB");

		// 判断是否失效
		if (user == null || ("").equals(user.getUserId())) {
			logger.error("用户不存在！");
			return "LogOut";
		}
		// 取得项目信息
		this.tprojectApplication = tprojectApplicationService.get(projectId);

		// 取得项目基本信息
		this.tprojectInfoB = tprojectInfoBService.get("tprojectApplication.projectId", projectId);
		// 非空判断
		if (tprojectInfoB == null) {
			tprojectInfoB = new TprojectInfoB();
		}

		// 项目分类
		this.projectTypeName = tprojectTypeService.getProjectTypeShowName(tprojectApplication.getTprojectType().getTypeId());

		// 初始化归口管理部门
		this.centralizedBranchList = new ArrayList<Mitem>();
		this.centralizedBranchList = mitemService.getListByTypeId(Constants.TYPE_CENTRALIZED_TYPE);

		// 初始化所在区域（省）
		this.regionIdList1 = new ArrayList<Mitem>();
		// 初始化所在区域（市）
		this.regionIdList2 = new ArrayList<Mitem>();
		// 初始化所在区域（区）
		this.regionIdList3 = new ArrayList<Mitem>();

		// 取得所在区域（省）
		this.regionIdList1 = mitemService.getListByTypeId(Constants.TYPE_REGION_1);

		if (tprojectInfoB.getRegionId1() != null && !"".equals(tprojectInfoB.getRegionId1())) {

			// 取得所在区域（市）
			this.regionIdList2 = mitemService.getMitemListByPId(tprojectInfoB.getRegionId1());
			// 取得所在区域（区）
			this.regionIdList3 = mitemService.getMitemListByPId(tprojectInfoB.getRegionId2());
		} else {
			// 取得所在区域（市）
			this.regionIdList2 = mitemService.getMitemListByPId(Constants.SHANNXI);
			// 设置默认选择陕西省
			tprojectInfoB.setRegionId1(Constants.SHANNXI);
			// 取得所在区域（区）
			this.regionIdList3 = mitemService.getMitemListByPId(Constants.XIAN);
			// 设置默认选择西安市
			tprojectInfoB.setRegionId2(Constants.XIAN);
		}

		// 初始化行业领域1
		this.industriesList1 = new ArrayList<Mitem>();
		// 初始化行业领域2
		this.industriesList2 = new ArrayList<Mitem>();
		// 初始化行业领域3
		this.industriesList3 = new ArrayList<Mitem>();
		// 初始化行业领域4
		this.industriesList4 = new ArrayList<Mitem>();

		// 取得行业领域1
		this.industriesList1 = mitemService.getListByTypeId(Constants.TYPE_INDUSTRIES1);

		if (tprojectInfoB.getIndustries1() != null && !"".equals(tprojectInfoB.getIndustries1())) {
			// 取得行业领域1
			this.industriesList2 = mitemService.getMitemListByPId(tprojectInfoB.getIndustries1());
			// 取得行业领域2
			this.industriesList3 = mitemService.getMitemListByPId(tprojectInfoB.getIndustries2());
			// 取得行业领域3
			this.industriesList4 = mitemService.getMitemListByPId(tprojectInfoB.getIndustries3());
		}

		// 单位性质
		this.unitPropertiesList = new ArrayList<Mitem>();
		this.unitPropertiesList = mitemService.getListByTypeId(Constants.TYPE_COMPANY_RETY);

		// **********项目所属技术领域***************/
		this.technicalFisldList1 = new ArrayList<Mitem>();
		this.technicalFisldList2 = new ArrayList<Mitem>();
		this.technicalFisldList3 = new ArrayList<Mitem>();
		this.technicalFisldList1 = mitemService.getListByTypeId(Constants.TYPE_PROJECTINFO_FIELD1);
		// 项目所属技术领域1
		String technicalFisld1 = tprojectInfoB.getTechnicalFisld1();
		if (technicalFisld1 != null && technicalFisld1.length() > 0) {
			this.technicalFisldList2 = mitemService.getMitemListByPId(technicalFisld1);
		}
		// 项目所属技术领域2
		String technicalFisld2 = tprojectInfoB.getTechnicalFisld2();
		if (technicalFisld2 != null && technicalFisld2.length() > 0) {
			this.technicalFisldList3 = mitemService.getMitemListByPId(technicalFisld2);
		}

		// 知识产权
		this.intellectualPropertyList = new ArrayList<Mitem>();
		this.intellectualPropertyList = mitemService.getListByTypeId(Constants.TYPE_INTELLECTUAL);

		// 技术来源
		this.technologySourceList = new ArrayList<Mitem>();
		this.technologySourceList = mitemService.getListByTypeId(Constants.TYPE_TECHNOLOGY);

		// 归口管理部门
		if (tprojectApplication.getCentralizedType() != null && !"".equals(tprojectApplication.getCentralizedType())) {

			// 取得归口管理部门
			Mitem mitem = mitemService.get(tprojectApplication.getCentralizedType());

			if (mitem != null && mitem.getItemName() != null) {
				// 设置归口管理部门
				tprojectApplication.setCentralizedTypeName(mitem.getItemName());
			}
		}

		return "showProjectInfoB";
	}

	public TprojectInfoBService getTprojectInfoBService() {
		return tprojectInfoBService;
	}

	public void setTprojectInfoBService(TprojectInfoBService tprojectInfoBService) {
		this.tprojectInfoBService = tprojectInfoBService;
	}

	public TprojectApplicationService getTprojectApplicationService() {
		return tprojectApplicationService;
	}

	public void setTprojectApplicationService(TprojectApplicationService tprojectApplicationService) {
		this.tprojectApplicationService = tprojectApplicationService;
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

	public TprojectInfoB getTprojectInfoB() {
		return tprojectInfoB;
	}

	public void setTprojectInfoB(TprojectInfoB tprojectInfoB) {
		this.tprojectInfoB = tprojectInfoB;
	}

	public TprojectApplication getTprojectApplication() {
		return tprojectApplication;
	}

	public void setTprojectApplication(TprojectApplication tprojectApplication) {
		this.tprojectApplication = tprojectApplication;
	}

	public String getProjectId() {
		return projectId;
	}

	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}

	public List<Mitem> getCentralizedBranchList() {
		return centralizedBranchList;
	}

	public void setCentralizedBranchList(List<Mitem> centralizedBranchList) {
		this.centralizedBranchList = centralizedBranchList;
	}

	public List<Mitem> getRegionIdList1() {
		return regionIdList1;
	}

	public void setRegionIdList1(List<Mitem> regionIdList1) {
		this.regionIdList1 = regionIdList1;
	}

	public List<Mitem> getRegionIdList2() {
		return regionIdList2;
	}

	public void setRegionIdList2(List<Mitem> regionIdList2) {
		this.regionIdList2 = regionIdList2;
	}

	public List<Mitem> getRegionIdList3() {
		return regionIdList3;
	}

	public void setRegionIdList3(List<Mitem> regionIdList3) {
		this.regionIdList3 = regionIdList3;
	}

	public List<Mitem> getIndustriesList1() {
		return industriesList1;
	}

	public void setIndustriesList1(List<Mitem> industriesList1) {
		this.industriesList1 = industriesList1;
	}

	public List<Mitem> getIndustriesList2() {
		return industriesList2;
	}

	public void setIndustriesList2(List<Mitem> industriesList2) {
		this.industriesList2 = industriesList2;
	}

	public List<Mitem> getIndustriesList3() {
		return industriesList3;
	}

	public void setIndustriesList3(List<Mitem> industriesList3) {
		this.industriesList3 = industriesList3;
	}

	public List<Mitem> getIndustriesList4() {
		return industriesList4;
	}

	public void setIndustriesList4(List<Mitem> industriesList4) {
		this.industriesList4 = industriesList4;
	}

	public List<Mitem> getUnitPropertiesList() {
		return unitPropertiesList;
	}

	public void setUnitPropertiesList(List<Mitem> unitPropertiesList) {
		this.unitPropertiesList = unitPropertiesList;
	}

	public List<Mitem> getTechnicalFisldList1() {
		return technicalFisldList1;
	}

	public void setTechnicalFisldList1(List<Mitem> technicalFisldList1) {
		this.technicalFisldList1 = technicalFisldList1;
	}

	public List<Mitem> getTechnicalFisldList2() {
		return technicalFisldList2;
	}

	public void setTechnicalFisldList2(List<Mitem> technicalFisldList2) {
		this.technicalFisldList2 = technicalFisldList2;
	}

	public List<Mitem> getTechnicalFisldList3() {
		return technicalFisldList3;
	}

	public void setTechnicalFisldList3(List<Mitem> technicalFisldList3) {
		this.technicalFisldList3 = technicalFisldList3;
	}

	public List<Mitem> getIntellectualPropertyList() {
		return intellectualPropertyList;
	}

	public void setIntellectualPropertyList(List<Mitem> intellectualPropertyList) {
		this.intellectualPropertyList = intellectualPropertyList;
	}

	public List<Mitem> getTechnologySourceList() {
		return technologySourceList;
	}

	public void setTechnologySourceList(List<Mitem> technologySourceList) {
		this.technologySourceList = technologySourceList;
	}

	public String getProjectTypeName() {
		return projectTypeName;
	}

	public void setProjectTypeName(String projectTypeName) {
		this.projectTypeName = projectTypeName;
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
}
