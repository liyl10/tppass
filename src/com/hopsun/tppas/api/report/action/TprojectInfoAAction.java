package com.hopsun.tppas.api.report.action;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.hopsun.framework.base.action.BaseAction;
import com.hopsun.scenter.entity.ScUsers;
import com.hopsun.tppas.api.report.service.TprojectApplicationService;
import com.hopsun.tppas.api.report.service.TprojectInfoAService;
import com.hopsun.tppas.api.superadmin.service.MitemService;
import com.hopsun.tppas.common.Constants;
import com.hopsun.tppas.entity.Mitem;
import com.hopsun.tppas.entity.TprojectApplication;
import com.hopsun.tppas.entity.TprojectInfoA;

public class TprojectInfoAAction extends BaseAction {
	public final static Logger logger = Logger.getLogger(TprojectApplicationAction.class.getName());

	private static final long serialVersionUID = 8498551103731166873L;
	@Resource
	private TprojectInfoAService tprojectInfoAService;
	@Resource
	private TprojectApplicationService tprojectApplicationService;
	@Resource
	private MitemService mitemService;
	// 高新基本信息
	private TprojectInfoA tprojectInfoa;
	// 码表
	private Mitem mitem;
	// 项目id
	private String projectId;
	// 项目申报
	private TprojectApplication tprojectApplication;
	// 备注的年
	String newYear;
	// 当年前
	String projectTime;
	// 企业资产与经营状况 年
	int zcjyYear;
	// 归口管理部
	private String centralizedType;
	// 技术领域
	private String technicalFisld;
	// 单位地址
	private String unitAddress;
	// 邮政编码
	private String zipcode;
	// 单位性质
	private String unitProperties;
	// 法定代表人
	private String legalPerson;
	// 所在区域List
	private List<Mitem> regionId1List;
	private List<Mitem> regionId2List;
	private List<Mitem> regionId3List;
	// 行业领域List
	private List<Mitem> industries1List;
	private List<Mitem> industries2List;
	private List<Mitem> industries3List;
	private List<Mitem> industries4List;
	// 单位性质List
	private List<Mitem> unitPropertiesList;
	/** 项目所属技术领域1集合 */
	private List<Mitem> technicalFisldList1;
	/** 项目所属技术领域2集合 */
	private List<Mitem> technicalFisldList2;
	/** 项目所属技术领域3集合 */
	private List<Mitem> technicalFisldList3;
	// 知识产权状况List
	private List<Mitem> intellectualPropertyList;
	// 技术来源List
	private List<Mitem> technologySourceList;

	/** 下拉列表联动返回字符串 */
	private String backStr;
	private String pitemId;
	private String tempValue;
	private String retyld;

	/**
	 * 
	 * @comments 项目基本信息初始化
	 * @return
	 * @version 1.0
	 */
	public String showProjectInfo() {
		HttpSession session = this.getRequest().getSession();
		// 取得登录用户的信息
		ScUsers user = (ScUsers) session.getAttribute("sysUser");
		// session.setAttribute(Constants.SESSION_CMDKEY, "projectInfo");
		// 判断是否失效
		if (user == null || ("").equals(user.getUserId())) {
			logger.error("用户不存在！");
			return "LogOut";
		}
		tprojectApplication = tprojectApplicationService.get(this.projectId);
		if (tprojectApplication == null) {
			tprojectApplication = new TprojectApplication();
		}
		// 备注的年 是项目执行期第一年（起止年限-开始时间）
		this.newYear = new SimpleDateFormat("yyyy").format(tprojectApplication.getStartTime());
		/*
		 * if(tprojectApplication.getStartTime()!=null){ this.newYear = new
		 * SimpleDateFormat("yyyy") .format(tprojectApplication.getStartTime());
		 * }
		 */
		// 企业资产与经营状况 年 是当前年的前一年
		if (tprojectApplication.getReportYear() != null) {
			this.projectTime = tprojectApplication.getReportYear();
			this.zcjyYear = Integer.valueOf(projectTime) - 1;
		}
		// 初始化所在区域List
		this.regionId1List = new ArrayList<Mitem>();
		this.regionId2List = new ArrayList<Mitem>();
		this.regionId3List = new ArrayList<Mitem>();
		// 初始化行业领域List
		this.industries1List = new ArrayList<Mitem>();
		this.industries2List = new ArrayList<Mitem>();
		this.industries3List = new ArrayList<Mitem>();
		this.industries4List = new ArrayList<Mitem>();
		// 单位性质List
		this.unitPropertiesList = new ArrayList<Mitem>();
		// 项目所属技术领域1集合
		this.technicalFisldList1 = new ArrayList<Mitem>();
		// 项目所属技术领域2集合
		this.technicalFisldList2 = new ArrayList<Mitem>();
		// 项目所属技术领域3集合
		this.technicalFisldList3 = new ArrayList<Mitem>();
		// 知识产权List
		this.intellectualPropertyList = new ArrayList<Mitem>();
		// 技术来源List
		this.technologySourceList = new ArrayList<Mitem>();
		if (projectId != null) {
			// 取得归口管理部信息
			if (tprojectApplication.getCentralizedType() != null) {
				Mitem centralized = mitemService.get(tprojectApplicationService.get(projectId).getCentralizedType());
				this.centralizedType = centralized.getItemName();
			}

			this.tprojectInfoa = tprojectInfoAService.get("tprojectApplication.projectId", projectId);
			if (tprojectInfoa != null) {
				this.unitAddress = tprojectInfoa.getUnitAddress();
				this.zipcode = tprojectInfoa.getZipcode();
				this.legalPerson = tprojectInfoa.getLegalPerson();

				// 取得行业领域省级信息
				this.regionId1List = mitemService.getListByTypeId(Constants.TYPE_REGION_1);
				if (tprojectInfoa.getRegionId1() != null && !"".equals(tprojectInfoa.getRegionId1())) {
					this.regionId2List = mitemService.getMitemListByPId(tprojectInfoa.getRegionId1());
					this.regionId3List = mitemService.getMitemListByPId(tprojectInfoa.getRegionId2());
				} else {
					// 初始化选择陕西省西安市
					tprojectInfoa.setRegionId1(Constants.SHANNXI);
					tprojectInfoa.setRegionId2(Constants.XIAN);
					this.regionId2List = mitemService.getMitemListByPId(tprojectInfoa.getRegionId1());
					this.regionId3List = mitemService.getMitemListByPId(tprojectInfoa.getRegionId2());
				}

				// 取得行业领域信息单位行业领域1
				this.industries1List = mitemService.getListByTypeId(Constants.TYPE_INDUSTRIES1);
				if (tprojectInfoa.getIndustries1() != null && !"".equals(tprojectInfoa.getIndustries1())) {
					this.industries2List = mitemService.getMitemListByPId(tprojectInfoa.getIndustries1());
				}
				if (tprojectInfoa.getIndustries2() != null && !"".equals(tprojectInfoa.getIndustries2())) {
					this.industries3List = mitemService.getMitemListByPId(tprojectInfoa.getIndustries2());
				}
				if (tprojectInfoa.getIndustries3() != null && !"".equals(tprojectInfoa.getIndustries3())) {
					this.industries4List = mitemService.getMitemListByPId(tprojectInfoa.getIndustries3());
				}
				this.unitPropertiesList = mitemService.getListByTypeId(Constants.TYPE_COMPANY_RETY);
				// **********项目所属技术领域***************/
				this.technicalFisldList1 = mitemService.getListByTypeId(Constants.TYPE_PROJECTINFO_FIELD1);
				// 项目所属技术领域1
				String technicalFisld1 = tprojectInfoa.getTechnicalFisld1();
				if (technicalFisld1 != null && technicalFisld1.length() > 0) {
					this.technicalFisldList2 = mitemService.getMitemListByPId(technicalFisld1);
				}
				// 项目所属技术领域2
				String technicalFisld2 = tprojectInfoa.getTechnicalFisld2();
				if (technicalFisld2 != null && technicalFisld2.length() > 0) {
					this.technicalFisldList3 = mitemService.getMitemListByPId(technicalFisld2);
				}
				// 取得知识产权信息
				this.intellectualPropertyList = mitemService.getListByTypeId(Constants.TYPE_INTELLECTUAL);
				// 取得技术来源信息
				this.technologySourceList = mitemService.getListByTypeId(Constants.TYPE_TECHNOLOGY);
			}
		}
		return "showprojectinfo";
	}

	/**
	 * @return the tprojectInfoAService
	 */
	public TprojectInfoAService getTprojectInfoAService() {
		return tprojectInfoAService;
	}

	/**
	 * @param tprojectInfoAService
	 *            the tprojectInfoAService to set
	 */
	public void setTprojectInfoAService(TprojectInfoAService tprojectInfoAService) {
		this.tprojectInfoAService = tprojectInfoAService;
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
	 * @return the tprojectInfoa
	 */
	public TprojectInfoA getTprojectInfoa() {
		return tprojectInfoa;
	}

	/**
	 * @param tprojectInfoa
	 *            the tprojectInfoa to set
	 */
	public void setTprojectInfoa(TprojectInfoA tprojectInfoa) {
		this.tprojectInfoa = tprojectInfoa;
	}

	/**
	 * @return the mitem
	 */
	public Mitem getMitem() {
		return mitem;
	}

	/**
	 * @param mitem
	 *            the mitem to set
	 */
	public void setMitem(Mitem mitem) {
		this.mitem = mitem;
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
	 * @return the newYear
	 */
	public String getNewYear() {
		return newYear;
	}

	/**
	 * @param newYear
	 *            the newYear to set
	 */
	public void setNewYear(String newYear) {
		this.newYear = newYear;
	}

	/**
	 * @return the projectTime
	 */
	public String getProjectTime() {
		return projectTime;
	}

	/**
	 * @param projectTime
	 *            the projectTime to set
	 */
	public void setProjectTime(String projectTime) {
		this.projectTime = projectTime;
	}

	/**
	 * @return the zcjyYear
	 */
	public int getZcjyYear() {
		return zcjyYear;
	}

	/**
	 * @param zcjyYear
	 *            the zcjyYear to set
	 */
	public void setZcjyYear(int zcjyYear) {
		this.zcjyYear = zcjyYear;
	}

	/**
	 * @return the centralizedType
	 */
	public String getCentralizedType() {
		return centralizedType;
	}

	/**
	 * @param centralizedType
	 *            the centralizedType to set
	 */
	public void setCentralizedType(String centralizedType) {
		this.centralizedType = centralizedType;
	}

	/**
	 * @return the technicalFisld
	 */
	public String getTechnicalFisld() {
		return technicalFisld;
	}

	/**
	 * @param technicalFisld
	 *            the technicalFisld to set
	 */
	public void setTechnicalFisld(String technicalFisld) {
		this.technicalFisld = technicalFisld;
	}

	/**
	 * @return the unitAddress
	 */
	public String getUnitAddress() {
		return unitAddress;
	}

	/**
	 * @param unitAddress
	 *            the unitAddress to set
	 */
	public void setUnitAddress(String unitAddress) {
		this.unitAddress = unitAddress;
	}

	/**
	 * @return the zipcode
	 */
	public String getZipcode() {
		return zipcode;
	}

	/**
	 * @param zipcode
	 *            the zipcode to set
	 */
	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	/**
	 * @return the unitProperties
	 */
	public String getUnitProperties() {
		return unitProperties;
	}

	/**
	 * @param unitProperties
	 *            the unitProperties to set
	 */
	public void setUnitProperties(String unitProperties) {
		this.unitProperties = unitProperties;
	}

	/**
	 * @return the legalPerson
	 */
	public String getLegalPerson() {
		return legalPerson;
	}

	/**
	 * @param legalPerson
	 *            the legalPerson to set
	 */
	public void setLegalPerson(String legalPerson) {
		this.legalPerson = legalPerson;
	}

	/**
	 * @return the regionId1List
	 */
	public List<Mitem> getRegionId1List() {
		return regionId1List;
	}

	/**
	 * @param regionId1List
	 *            the regionId1List to set
	 */
	public void setRegionId1List(List<Mitem> regionId1List) {
		this.regionId1List = regionId1List;
	}

	/**
	 * @return the regionId2List
	 */
	public List<Mitem> getRegionId2List() {
		return regionId2List;
	}

	/**
	 * @param regionId2List
	 *            the regionId2List to set
	 */
	public void setRegionId2List(List<Mitem> regionId2List) {
		this.regionId2List = regionId2List;
	}

	/**
	 * @return the regionId3List
	 */
	public List<Mitem> getRegionId3List() {
		return regionId3List;
	}

	/**
	 * @param regionId3List
	 *            the regionId3List to set
	 */
	public void setRegionId3List(List<Mitem> regionId3List) {
		this.regionId3List = regionId3List;
	}

	/**
	 * @return the industries1List
	 */
	public List<Mitem> getIndustries1List() {
		return industries1List;
	}

	/**
	 * @param industries1List
	 *            the industries1List to set
	 */
	public void setIndustries1List(List<Mitem> industries1List) {
		this.industries1List = industries1List;
	}

	/**
	 * @return the industries2List
	 */
	public List<Mitem> getIndustries2List() {
		return industries2List;
	}

	/**
	 * @param industries2List
	 *            the industries2List to set
	 */
	public void setIndustries2List(List<Mitem> industries2List) {
		this.industries2List = industries2List;
	}

	/**
	 * @return the industries3List
	 */
	public List<Mitem> getIndustries3List() {
		return industries3List;
	}

	/**
	 * @param industries3List
	 *            the industries3List to set
	 */
	public void setIndustries3List(List<Mitem> industries3List) {
		this.industries3List = industries3List;
	}

	/**
	 * @return the industries4List
	 */
	public List<Mitem> getIndustries4List() {
		return industries4List;
	}

	/**
	 * @param industries4List
	 *            the industries4List to set
	 */
	public void setIndustries4List(List<Mitem> industries4List) {
		this.industries4List = industries4List;
	}

	/**
	 * @return the unitPropertiesList
	 */
	public List<Mitem> getUnitPropertiesList() {
		return unitPropertiesList;
	}

	/**
	 * @param unitPropertiesList
	 *            the unitPropertiesList to set
	 */
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

	/**
	 * @return the intellectualPropertyList
	 */
	public List<Mitem> getIntellectualPropertyList() {
		return intellectualPropertyList;
	}

	/**
	 * @param intellectualPropertyList
	 *            the intellectualPropertyList to set
	 */
	public void setIntellectualPropertyList(List<Mitem> intellectualPropertyList) {
		this.intellectualPropertyList = intellectualPropertyList;
	}

	/**
	 * @return the technologySourceList
	 */
	public List<Mitem> getTechnologySourceList() {
		return technologySourceList;
	}

	/**
	 * @param technologySourceList
	 *            the technologySourceList to set
	 */
	public void setTechnologySourceList(List<Mitem> technologySourceList) {
		this.technologySourceList = technologySourceList;
	}

	/**
	 * @return the backStr
	 */
	public String getBackStr() {
		return backStr;
	}

	/**
	 * @param backStr
	 *            the backStr to set
	 */
	public void setBackStr(String backStr) {
		this.backStr = backStr;
	}

	/**
	 * @return the pitemId
	 */
	public String getPitemId() {
		return pitemId;
	}

	/**
	 * @param pitemId
	 *            the pitemId to set
	 */
	public void setPitemId(String pitemId) {
		this.pitemId = pitemId;
	}

	/**
	 * @return the tempValue
	 */
	public String getTempValue() {
		return tempValue;
	}

	/**
	 * @param tempValue
	 *            the tempValue to set
	 */
	public void setTempValue(String tempValue) {
		this.tempValue = tempValue;
	}

	/**
	 * @return the retyld
	 */
	public String getRetyld() {
		return retyld;
	}

	/**
	 * @param retyld
	 *            the retyld to set
	 */
	public void setRetyld(String retyld) {
		this.retyld = retyld;
	}

}
