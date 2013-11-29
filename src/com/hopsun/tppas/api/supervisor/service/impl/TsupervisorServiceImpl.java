/*************** 版权声明***************
 *
 * Copyright (C) 2012 西安辉盛科技发展有限责任公司.
 *
 ********************************************
 */
package com.hopsun.tppas.api.supervisor.service.impl;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.hopsun.framework.base.bean.Pager;
import com.hopsun.framework.base.service.impl.BaseServiceImpl;
import com.hopsun.scenter.entity.ScUsers;
import com.hopsun.tppas.api.acceptance.dao.TacceptanceDao;
import com.hopsun.tppas.api.report.dao.TprojectApplicationDao;
import com.hopsun.tppas.api.report.dao.TprojectRecordDao;
import com.hopsun.tppas.api.superadmin.dao.MitemDao;
import com.hopsun.tppas.api.superadmin.dao.TprojectTypeDao;
import com.hopsun.tppas.api.supervisor.dao.TcompanyDevelopInfoDao;
import com.hopsun.tppas.api.supervisor.dao.TprojectAchievementInfoDao;
import com.hopsun.tppas.api.supervisor.dao.TprojectCompleteInfoDao;
import com.hopsun.tppas.api.supervisor.dao.TprojectIndustrializationDao;
import com.hopsun.tppas.api.supervisor.dao.TprojectManagementInfoDao;
import com.hopsun.tppas.api.supervisor.dao.TsupervisorDao;
import com.hopsun.tppas.api.supervisor.dao.TsupervisorFundADao;
import com.hopsun.tppas.api.supervisor.dao.TsupervisorFundBDao;
import com.hopsun.tppas.api.supervisor.dao.TsupervisorInfoADao;
import com.hopsun.tppas.api.supervisor.dao.TtechnicalCompleteInfoDao;
import com.hopsun.tppas.api.supervisor.service.TsupervisorService;
import com.hopsun.tppas.common.CommonTool;
import com.hopsun.tppas.common.Constants;
import com.hopsun.tppas.entity.Mitem;
import com.hopsun.tppas.entity.Tacceptance;
import com.hopsun.tppas.entity.TcompanyDevelopInfo;
import com.hopsun.tppas.entity.Tcontract;
import com.hopsun.tppas.entity.TcontractContentsB;
import com.hopsun.tppas.entity.TcontractCoverA;
import com.hopsun.tppas.entity.TprojectAchievementInfo;
import com.hopsun.tppas.entity.TprojectApplication;
import com.hopsun.tppas.entity.TprojectCompleteInfo;
import com.hopsun.tppas.entity.TprojectIndustrialization;
import com.hopsun.tppas.entity.TprojectInfoB;
import com.hopsun.tppas.entity.TprojectManagementInfo;
import com.hopsun.tppas.entity.TprojectRecord;
import com.hopsun.tppas.entity.TprojectType;
import com.hopsun.tppas.entity.Tsupervisor;
import com.hopsun.tppas.entity.TsupervisorFundA;
import com.hopsun.tppas.entity.TsupervisorFundB;
import com.hopsun.tppas.entity.TsupervisorInfoA;
import com.hopsun.tppas.entity.TtechnicalCompleteInfo;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.AcroFields;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfCopy;
import com.itextpdf.text.pdf.PdfGState;
import com.itextpdf.text.pdf.PdfImportedPage;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfStamper;

/**
 * 项目监理
 * 
 * @comments
 * @author wxd
 * @date 2013-9-17
 * @version 1.0
 */
@Service
public class TsupervisorServiceImpl extends BaseServiceImpl<Tsupervisor, String> implements TsupervisorService {

	public final static Logger logger = Logger.getLogger(TsupervisorServiceImpl.class.getName());

	// 项目监理Dao
	@Resource
	private TsupervisorDao tsupervisorDao;

	// 项目申报Dao
	@Resource
	private TprojectApplicationDao tprojectApplicationDao;

	// 项目申请履历Dao
	@Resource
	private TprojectRecordDao tprojectRecordDao;

	// 监理资金表BDao
	@Resource
	private TsupervisorFundBDao tsupervisorFundBDao;

	// 监理基本信息表ADao
	@Resource
	private TsupervisorInfoADao tsupervisorInfoADao;

	// 监理资金表ADao
	@Resource
	private TsupervisorFundADao tsupervisorFundADao;

	// 对照合同项目任务完成情况Dao
	@Resource
	private TprojectCompleteInfoDao tprojectCompleteInfoDao;

	// 技术指标完成情况Dao
	@Resource
	private TtechnicalCompleteInfoDao ttechnicalCompleteInfoDao;

	// 项目取得成果情况Dao
	@Resource
	private TprojectAchievementInfoDao tprojectAchievementInfoDao;

	// 项目产业化进展情况Dao
	@Resource
	private TprojectIndustrializationDao tprojectIndustrializationDao;

	// 项目实施管理情况Dao
	@Resource
	private TprojectManagementInfoDao tprojectManagementInfoDao;

	// 企业发展情况Dao
	@Resource
	private TcompanyDevelopInfoDao tcompanyDevelopInfoDao;

	// 附件Dao
	//@Resource
	//private TattachmentDao tattachmentDao;

	// 码表Dao
	@Resource
	private MitemDao mitemDao;

	// 项目分类
	@Resource
	private TprojectTypeDao tprojectTypeDao;
	
	//验收Dao
	@Resource
	private TacceptanceDao tacceptanceDao;

	@Resource
	public void setBaseDao(TsupervisorDao tsupervisorDao) {
		super.setBaseDao(tsupervisorDao);
	}

	/**
	 * 查询待监理项目
	 * 
	 * @param supervisorState
	 * @return
	 */
	public List<Tsupervisor> queryTsupervisorByState(String supervisorState) {

		return tsupervisorDao.queryTsupervisorByState(supervisorState);
	}

	/**
	 * 项目监理列表
	 * 
	 * @comments
	 * @param param
	 * @param pageNo
	 * @param pageSize
	 * @return
	 * @version 1.0
	 */
	@SuppressWarnings("unchecked")
	public Pager supervisorList(Map<String, Object> param, int pageNo, int pageSize) {
		Pager pager = tsupervisorDao.supervisorList(param, pageNo, pageSize);
		List<Tsupervisor> all = pager.getList();
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		if (all != null && all.size() > 0) {
			for (int i = 0; i < all.size(); i++) {
				Tsupervisor supervisor = all.get(i);
				if (supervisor != null) {
					Map<String, Object> valueMap = new HashMap<String, Object>();
					TprojectApplication projectApplication = supervisor.getTprojectApplication();
					if (projectApplication != null) {
						// 项目编号
						valueMap.put("projectNumber", projectApplication.getProjectNumber());
						// 项目名称
						valueMap.put("projectName", projectApplication.getProjectName());
						// 申报单位
						valueMap.put("applicationUnit", projectApplication.getApplicationUnit());
						// 项目分类
						valueMap.put("typeName", projectApplication.getPlanFlagName() + Constants.STRING_LINK + projectApplication.getTypeName());
						// 申报时间
						valueMap.put("reportTime", projectApplication.getCreateTime());
						// 监理状态
						if (CommonTool.IsNotEmpty(supervisor.getSupervisorState())) {
							// 状态ID
							valueMap.put("supervisorState", supervisor.getSupervisorState());
							// 状态名称
							valueMap.put("supervisorStateName", mitemDao.getItemName(supervisor.getSupervisorState()));
						}
						// 监理ID
						valueMap.put("supervisorId", supervisor.getSupervisorId());
						// 项目申报ID
						valueMap.put("projectId", projectApplication.getProjectId());
						// 项目分类ID一级
						valueMap.put("planFlag", projectApplication.getPlanFlag());
						// 项目分类ID二级
						valueMap.put("typeId", projectApplication.getTprojectType().getTypeId());

						list.add(valueMap);
					}
				}
			}
		}

		pager.setList(list);
		return pager;
	}

	/**
	 * 
	 * @comments 得到其他项目监理提交信息列表
	 * @param supervisorId
	 * @return
	 * @version 1.0
	 */
	public List<Map<String, Object>> getOtherSubmitInfoList(String supervisorId) {
		List<Map<String, Object>> all = new ArrayList<Map<String, Object>>();
		// 项目监理信息
		Tsupervisor tsupervisor = tsupervisorDao.get(supervisorId);

		// 监理封面
		Map<String, Object> valueMap = new HashMap<String, Object>();
		valueMap.put("name", mitemDao.getItemName(Constants.TSUPERVISOR_OTHER_MENU1));
		valueMap.put("isExist", "是");
		valueMap.put("isPass", "1");
		all.add(valueMap);

		// 填表说明
		valueMap = new HashMap<String, Object>();
		valueMap.put("name", mitemDao.getItemName(Constants.TSUPERVISOR_OTHER_MENU2));
		valueMap.put("name", "填表说明");
		valueMap.put("isExist", "是");
		valueMap.put("isPass", "1");
		all.add(valueMap);

		// 资金情况
		valueMap = new HashMap<String, Object>();
		valueMap.put("name", mitemDao.getItemName(Constants.TSUPERVISOR_OTHER_MENU3));
		if (tsupervisor.getTsupervisorFundBs() != null && tsupervisor.getTsupervisorFundBs().size() > 0) {
			valueMap.put("isExist", "是");
			valueMap.put("isPass", "1");
		} else {
			valueMap.put("isExist", "否");
			valueMap.put("isPass", "0");
		}
		all.add(valueMap);

		// 对照合同项目任务完成情况
		valueMap = new HashMap<String, Object>();
		valueMap.put("name", mitemDao.getItemName(Constants.TSUPERVISOR_OTHER_MENU4));
		if (tsupervisor.getTprojectCompleteInfos() != null && tsupervisor.getTprojectCompleteInfos().size() > 0) {
			valueMap.put("isExist", "是");
			valueMap.put("isPass", "1");
		} else {
			valueMap.put("isExist", "否");
			valueMap.put("isPass", "0");
		}
		all.add(valueMap);

		// 项目取得成果情况
		valueMap = new HashMap<String, Object>();
		valueMap.put("name", mitemDao.getItemName(Constants.TSUPERVISOR_OTHER_MENU5));
		if (tsupervisor.getTprojectAchievementInfos() != null && tsupervisor.getTprojectAchievementInfos().size() > 0) {
			valueMap.put("isExist", "是");
			valueMap.put("isPass", "1");
		} else {
			valueMap.put("isExist", "否");
			valueMap.put("isPass", "0");
		}
		all.add(valueMap);

		// 项目产业化进展情况
		valueMap = new HashMap<String, Object>();
		valueMap.put("name", mitemDao.getItemName(Constants.TSUPERVISOR_OTHER_MENU6));
		if (tsupervisor.getTprojectIndustrializations() != null && tsupervisor.getTprojectIndustrializations().size() > 0) {
			valueMap.put("isExist", "是");
			valueMap.put("isPass", "1");
		} else {
			valueMap.put("isExist", "否");
			valueMap.put("isPass", "0");
		}
		all.add(valueMap);

		// 项目实施管理情况
		valueMap = new HashMap<String, Object>();
		valueMap.put("name", mitemDao.getItemName(Constants.TSUPERVISOR_OTHER_MENU7));
		if (tsupervisor.getTprojectManagementInfos() != null && tsupervisor.getTprojectManagementInfos().size() > 0) {
			valueMap.put("isExist", "是");
			valueMap.put("isPass", "1");
		} else {
			valueMap.put("isExist", "否");
			valueMap.put("isPass", "0");
		}
		all.add(valueMap);

		// 企业发展情况
		valueMap = new HashMap<String, Object>();
		valueMap.put("name", mitemDao.getItemName(Constants.TSUPERVISOR_OTHER_MENU8));
		if (tsupervisor.getTcompanyDevelopInfos() != null && tsupervisor.getTcompanyDevelopInfos().size() > 0) {
			valueMap.put("isExist", "是");
			valueMap.put("isPass", "1");
		} else {
			valueMap.put("isExist", "否");
			valueMap.put("isPass", "0");
		}
		all.add(valueMap);

		// 项目承担单位真实性承诺
		valueMap = new HashMap<String, Object>();
		valueMap.put("name", mitemDao.getItemName(Constants.TSUPERVISOR_OTHER_MENU9));
		valueMap.put("isExist", "是");
		valueMap.put("isPass", "1");
		all.add(valueMap);

		// 附件清单
		/*Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("key1", supervisorId);
		paramMap.put("tableName", Tsupervisor.class);
		List<Tattachment> attList = tattachmentDao.getAttachmentsByForeignKey(paramMap);
		valueMap = new HashMap<String, Object>();
		valueMap.put("name", mitemDao.getItemName(Constants.TSUPERVISOR_OTHER_MENU10));
		if (attList != null && attList.size() > 0) {
			valueMap.put("isExist", "是");
			valueMap.put("isPass", "1");
		} else {
			valueMap.put("isExist", "否");
			valueMap.put("isPass", "0");
		}
		all.add(valueMap);*/

		return all;
	}

	/**
	 * 其它类监理申请提交
	 * 
	 * @comments
	 * @param pdfInputPath
	 * @param pdfOutputPath
	 * @param supervisorId
	 * @param companyId
	 * @version 1.0
	 */
	public void saveOtherSupervisor(String pdfInputPath, String pdfOutputPath, String supervisorId, String companyId) {
		Tsupervisor tsupervisor = tsupervisorDao.get(supervisorId);
		// 生成PDf
		String tempUrl = generateOtherPdf(pdfInputPath, pdfOutputPath, supervisorId);
		String realUrl = pdfOutputPath + supervisorId + "supervisor-other.pdf";
		// 添加页码
		addPage(tempUrl, realUrl);
		// 删除临时文件
		List<String> fileList = new ArrayList<String>();
		fileList.add(tempUrl);
		deletePdf(fileList);

		// 修改监理信息状态
		tsupervisor.setIsLastApply("1");
		tsupervisor.setSupervisorState(Constants.SUPERVISOR_STATE_APPLY);
		tsupervisor.setOperateTime(new Timestamp(new java.util.Date().getTime()));
		tsupervisor.setUpdateTime(new Timestamp(new java.util.Date().getTime()));
		tsupervisor.setPdfUrl(supervisorId + "supervisor-other.pdf");
		tsupervisorDao.update(tsupervisor);
		// 修改项目申报状态
		TprojectApplication tprojectApplication = tsupervisor.getTprojectApplication();
		tprojectApplication.setFlowStatus(Constants.FLOW_STATUS_SUPERVISION);
		tprojectApplicationDao.update(tprojectApplication);
		// 添加履历信息
		TprojectRecord tprojectRecord = new TprojectRecord();
		tprojectRecord.setTprojectApplication(tprojectApplication);
		tprojectRecord.setOptStepType(Constants.PROJECT_RECORD_TYPE3);
		tprojectRecord.setOptType(Constants.PROJECT_RECORD_COMPANY_COMIT_APPLY);
		tprojectRecord.setOptTime(new Timestamp(new java.util.Date().getTime()));
		tprojectRecord.setOptUser(companyId);
		tprojectRecord.setOptResult(Constants.SUPERVISOR_STATE_APPLY);
		tprojectRecordDao.save(tprojectRecord);
	}

	private String generateOtherPdf(String pdfInputPath, String pdfOutputPath, String supervisorId) {
		String tempUrl = "";
		try {
			PdfReader reader = new PdfReader(pdfInputPath + "supervisor-other.pdf");
			ByteArrayOutputStream bos = new ByteArrayOutputStream();
			PdfStamper ps = new PdfStamper(reader, bos);
			BaseFont bf = BaseFont.createFont("STSong-Light", "UniGB-UCS2-H", BaseFont.NOT_EMBEDDED);
			AcroFields s = ps.getAcroFields();
			s.addSubstitutionFont(bf);

			// 项目监理信息
			Tsupervisor supervisor = tsupervisorDao.get(supervisorId);
			// 得到项目申报信息
			TprojectApplication tprojectApplication = supervisor.getTprojectApplication();

			// 封面信息
			// 年度
			s.setField("reportYear", tprojectApplication.getReportYear());
			// 项目名称
			s.setField("projectName", tprojectApplication.getProjectName());
			// 项目编号
			s.setField("projectNumber", tprojectApplication.getPlanNumber());
			// 项目执行期
			s.setField("executionTime",
					new SimpleDateFormat("yyyy年MM月dd日").format(tprojectApplication.getStartTime()) + "-" + new SimpleDateFormat("yyyy年MM月dd日").format(tprojectApplication.getEndTime()));
			// 封装项目计划类别
			String planFlag = tprojectApplication.getPlanFlag();
			if (planFlag != null && planFlag.length() > 0) {
				TprojectType tprojectType = tprojectTypeDao.get(planFlag);
				// 项目计划类别
				s.setField("panType", tprojectType.getTypeShowName());
			}
			// 封装归口管理单位
			String gkdw = tprojectApplication.getCentralizedType();
			if (gkdw != null && gkdw.length() > 0) {
				Mitem mitem = mitemDao.get(gkdw);
				if (mitem != null) {
					// 归口管理单位
					s.setField("centralizedType", mitem.getItemName());
				}
			}

			// 项目基本信息B
			List<TprojectInfoB> projectInfoBList = tprojectApplication.getTprojectInfoBs();
			if (projectInfoBList != null && projectInfoBList.size() > 0) {
				TprojectInfoB tprojectInfoB = projectInfoBList.get(0);
				if (tprojectInfoB != null) {
					Mitem mitem = new Mitem();
					StringBuffer addressStr = new StringBuffer();
					if (tprojectInfoB.getRegionId1() != null && tprojectInfoB.getRegionId1().length() > 0) {
						mitem = mitemDao.get(tprojectInfoB.getRegionId1());
						addressStr.append(mitem.getItemName());
						if (tprojectInfoB.getRegionId2() != null && tprojectInfoB.getRegionId2().length() > 0) {
							mitem = mitemDao.get(tprojectInfoB.getRegionId2());
							addressStr.append(mitem.getItemName());
							if (tprojectInfoB.getRegionId3() != null && tprojectInfoB.getRegionId3().length() > 0) {
								mitem = mitemDao.get(tprojectInfoB.getRegionId3());
								addressStr.append(mitem.getItemName());
							}
						}
					}
					addressStr.append(tprojectInfoB.getUnitAddress());
					// 详细地址
					s.setField("unitAddress", addressStr.toString());
					// 项目负责人
					s.setField("projectPerson", tprojectInfoB.getProjectPerson());
					//合作单位 
	    			s.setField("cooperationDept",tprojectInfoB.getAssistUnit());
				}
			}
	    	//合同相关数据
	    	List<Tcontract> tcontractList = tprojectApplication.getTcontracts();
	    	if(tcontractList!=null&&tcontractList.size()>0){
	    		Tcontract tcontract = tcontractList.get(0);
	    		//合同封面
	    		List<TcontractCoverA> tcontractCoverAList = tcontract.getTcontractCoverAs();
	    		if(tcontractCoverAList!=null&&tcontractCoverAList.size()>0){
	    			TcontractCoverA tcontractCoverA = tcontractCoverAList.get(0);
	    			if(tcontractCoverA!=null){
	    				//项目负责人-电话  
		    			s.setField("personTel",tcontractCoverA.getChargePhone1());
		    			//项目负责人-手机      
		    			s.setField("projectPersonPhone",tcontractCoverA.getChargePhone2());
	    			}
	    		}
	    		//合同内容
	    		List<TcontractContentsB> TcontractContentsBList = tcontract.getTcontractContentsBs();
	    		if(TcontractContentsBList!=null&&TcontractContentsBList.size()>0){
	    			TcontractContentsB tcontractContentsB = TcontractContentsBList.get(0);
	    			if(tcontractContentsB!=null){
	    				//资助金额 
	    				s.setField("subsidizeMoney",String.valueOf(tcontractContentsB.getResearchFunding()));
	    			}
	    		}
	    	}
			// 承担单位
			s.setField("applicationUnit", tprojectApplication.getApplicationUnit());
			//填报人
			s.setField("writePerson",supervisor.getWritePerson());
			//电话
			s.setField("writePersonTel",supervisor.getWriteTel());
			//手机       
			s.setField("writePersonPhone",supervisor.getWriteMobile());
			// 填报时间
			s.setField("writeReportTime", new SimpleDateFormat("yyyy年MM月dd日").format(tprojectApplication.getWriteReportTime()));
			// 西安市科学技术局制表
			s.setField("compilationDept", tprojectApplication.getCompilationDept());

			// 资金情况-tsupervisorFundBDao
			TsupervisorFundB tsupervisorFundB = tsupervisorFundBDao.getTsupervisorFundBBysupervisorId(supervisorId);
			// 计划投资总额
			s.setField("planTotal", bigDecimalFormate(tsupervisorFundB.getPlanTotal()));
			// 计划市拨经费
			s.setField("planCity", bigDecimalFormate(tsupervisorFundB.getPlanCity()));
			// 计划企业自筹
			s.setField("planCompany", bigDecimalFormate(tsupervisorFundB.getPlanCompany()));
			// 计划银行贷款
			s.setField("planBank", bigDecimalFormate(tsupervisorFundB.getPlanBank()));
			// 计划其他
			s.setField("planOther", bigDecimalFormate(tsupervisorFundB.getPlanOther()));
			// 实际投资总额
			s.setField("realTotal", bigDecimalFormate(tsupervisorFundB.getRealTotal()));
			// 实际市拨经费
			s.setField("realCity", bigDecimalFormate(tsupervisorFundB.getRealCity()));
			// 实际企业自筹
			s.setField("realCompany", bigDecimalFormate(tsupervisorFundB.getRealCompany()));
			// 实际银行贷款
			s.setField("realBank", bigDecimalFormate(tsupervisorFundB.getRealBank()));
			// 实际其他
			s.setField("realOther", bigDecimalFormate(tsupervisorFundB.getRealOther()));
			// 人员费_总经费使用情况
			s.setField("personnelTotalCost", bigDecimalFormate(tsupervisorFundB.getPersonnelTotalCost()));
			// 设备费_总经费使用情况
			s.setField("equipmentTotalCost", bigDecimalFormate(tsupervisorFundB.getEquipmentTotalCost()));
			// 能源材料费_总经费使用情况
			s.setField("energyTotalCost", bigDecimalFormate(tsupervisorFundB.getEnergyTotalCost()));
			// 试验及外协费_总经费使用情况
			s.setField("testTotalCost", bigDecimalFormate(tsupervisorFundB.getTestTotalCost()));
			// 差旅费_总经费使用情况
			s.setField("travelTotalCost", bigDecimalFormate(tsupervisorFundB.getTravelTotalCost()));
			// 调研费_总经费使用情况
			s.setField("surveyTotalCost", bigDecimalFormate(tsupervisorFundB.getSurveyTotalCost()));
			// 会议费_总经费使用情况
			s.setField("meetingTotalCost", bigDecimalFormate(tsupervisorFundB.getMeetingTotalCost()));
			// 管理费_总经费使用情况
			s.setField("managerTotalCost", bigDecimalFormate(tsupervisorFundB.getManagerTotalCost()));
			// 其它费用_总经费使用情况
			s.setField("otherTotalCost", bigDecimalFormate(tsupervisorFundB.getOtherTotalCost()));
			// 人员费_市拨经费使用情况
			s.setField("personnelCityCost", bigDecimalFormate(tsupervisorFundB.getPersonnelCityCost()));
			// 设备费_市拨经费使用情况
			s.setField("equipmentCityCost", bigDecimalFormate(tsupervisorFundB.getEquipmentCityCost()));
			// 能源材料费_市拨经费使用情况
			s.setField("energyCityCost", bigDecimalFormate(tsupervisorFundB.getEnergyCityCost()));
			// 试验及外协费_市拨经费使用情况
			s.setField("testCityCost", bigDecimalFormate(tsupervisorFundB.getTestCityCost()));
			// 差旅费_市拨经费使用情况
			s.setField("travelCityCost", bigDecimalFormate(tsupervisorFundB.getTravelCityCost()));
			// 调研费_市拨经费使用情况
			s.setField("surveyCityCost", bigDecimalFormate(tsupervisorFundB.getSurveyCityCost()));
			// 会议费_市拨经费使用情况
			s.setField("meetingCityCost", bigDecimalFormate(tsupervisorFundB.getMeetingCityCost()));
			// 管理费_市拨经费使用情况
			s.setField("managerCityCost", bigDecimalFormate(tsupervisorFundB.getManagerCityCost()));
			// 其它费用_市拨经费使用情况
			s.setField("otherCityCost", bigDecimalFormate(tsupervisorFundB.getOtherCityCost()));
			// 说 明
			s.setField("commentInfo1", tsupervisorFundB.getCommentInfo());

			// 对照合同项目任务完成情况-tprojectCompleteInfoDao
			TprojectCompleteInfo tprojectCompleteInfo = tprojectCompleteInfoDao.getProjectCompleteInfoBySupervisorId(supervisorId);
			// 项目进展情况
			String projectSchedule = tprojectCompleteInfo.getProjectSchedule();
			if (Constants.TSUPERVISOR_OTHER_SCHEDULE_1.equals(projectSchedule)) {
				s.setField("projectSchedule1", "On");
			} else if (Constants.TSUPERVISOR_OTHER_SCHEDULE_2.equals(projectSchedule)) {
				s.setField("projectSchedule2", "On");
			} else if (Constants.TSUPERVISOR_OTHER_SCHEDULE_3.equals(projectSchedule)) {
				s.setField("projectSchedule3", "On");
			} else if (Constants.TSUPERVISOR_OTHER_SCHEDULE_4.equals(projectSchedule)) {
				s.setField("projectSchedule4", "On");
			} else if (Constants.TSUPERVISOR_OTHER_SCHEDULE_5.equals(projectSchedule)) {
				s.setField("projectSchedule5", "On");
			}
			// 影响项目进展原因
			String projectReason = tprojectCompleteInfo.getProjectReason();
			String[] obj = projectReason.split(",");
			if (obj != null && obj.length > 0) {
				for (int i = 0; i < obj.length; i++) {
					String objValue = obj[i];
					if ((Constants.TSUPERVISOR_OTHER_STOP_REASON_1).equals(objValue)) {
						s.setField("projectReason1", "On");
					} else if ((Constants.TSUPERVISOR_OTHER_STOP_REASON_2).equals(objValue)) {
						s.setField("projectReason2", "On");
					} else if ((Constants.TSUPERVISOR_OTHER_STOP_REASON_3).equals(objValue)) {
						s.setField("projectReason3", "On");
					} else if ((Constants.TSUPERVISOR_OTHER_STOP_REASON_4).equals(objValue)) {
						s.setField("projectReason4", "On");
					} else if ((Constants.TSUPERVISOR_OTHER_STOP_REASON_5).equals(objValue)) {
						s.setField("projectReason5", "On");
					} else if ((Constants.TSUPERVISOR_OTHER_STOP_REASON_6).equals(objValue)) {
						s.setField("projectReason6", "On");
					} else if ((Constants.TSUPERVISOR_OTHER_STOP_REASON_7).equals(objValue)) {
						s.setField("projectReason7", "On");
					} else if ((Constants.TSUPERVISOR_OTHER_STOP_REASON_8).equals(objValue)) {
						s.setField("projectReason8", "On");
					}
				}
			}
			// 销售收入_合同
			s.setField("sellContract", bigDecimalFormate(tprojectCompleteInfo.getSellContract()));
			// 销售收入_实际
			s.setField("sellReal", bigDecimalFormate(tprojectCompleteInfo.getSellReal()));
			// 利润总额_合同
			s.setField("profitContract", bigDecimalFormate(tprojectCompleteInfo.getProfitContract()));
			// 利润总额_实际
			s.setField("profitReal", bigDecimalFormate(tprojectCompleteInfo.getProfitReal()));
			// 税收总额_合同
			s.setField("taxContract", bigDecimalFormate(tprojectCompleteInfo.getTaxContract()));
			// 税收总额_实际
			s.setField("taxReal", bigDecimalFormate(tprojectCompleteInfo.getTaxReal()));
			// 创汇_合同
			s.setField("exportContract", bigDecimalFormate(tprojectCompleteInfo.getExportContract()));
			// 创汇_实际
			s.setField("exportReal", bigDecimalFormate(tprojectCompleteInfo.getExportReal()));
			// 说明
			s.setField("commentInfo2", tprojectCompleteInfo.getCommentInfo());

			// 技术指标完成情况-ttechnicalCompleteInfoDao
			List<TtechnicalCompleteInfo> all = ttechnicalCompleteInfoDao.getTechnicalCompleteInfoBySupervisorId(supervisorId);
			if (all != null && all.size() > 0) {
				for (int i = 0; i < all.size(); i++) {
					TtechnicalCompleteInfo ttechnicalCompleteInfo = all.get(i);
					s.setField("technicalContractRequire" + i, ttechnicalCompleteInfo.getTechnicalContractRequire());
					s.setField("realCompleteInfo" + i, ttechnicalCompleteInfo.getRealCompleteInfo());
				}
			}
			// 项目取得成果情况 -tprojectAchievementInfoDao
			TprojectAchievementInfo tprojectAchievementInfo = tprojectAchievementInfoDao.getProjectAchievementInfoBySupervisorId(supervisorId);
			// 已获得知识产权数量
			s.setField("awardedIntellectualPropertyCount", tprojectAchievementInfo.getAwardedIntellectualCount().toString());
			// 已申请知识产权数量
			s.setField("appliedIntellectualPropertyCount", tprojectAchievementInfo.getAppliedIntellectualCount().toString());
			// 其他成果类别
			s.setField("otherAchievementType", tprojectAchievementInfo.getCompanyDevelopComment());

			// 项目产业化进展情况 -tprojectIndustrializationDao
			TprojectIndustrialization tprojectIndustrialization = tprojectIndustrializationDao.getProjectIndustrializationBySupervisorId(supervisorId);
			s.setField("industrializationComment", tprojectIndustrialization.getIndustrializationComment());

			// 项目实施管理情况-tprojectManagementInfoDao
			TprojectManagementInfo tprojectManagementInfo = tprojectManagementInfoDao.getProjectManagementInfoBySupervisorId(supervisorId);
			s.setField("projectManagementComment", tprojectManagementInfo.getProjectManagementComment());

			// 企业发展情况-tcompanyDevelopInfoDao
			TcompanyDevelopInfo tcompanyDevelopInfo = tcompanyDevelopInfoDao.getCompanyDevelopInfoBySupervisorId(supervisorId);
			// 产值
			s.setField("companyOutput", bigDecimalFormate(tcompanyDevelopInfo.getCompanyOutput()));
			// 销售收入
			s.setField("companySell", bigDecimalFormate(tcompanyDevelopInfo.getCompanySell()));
			// 净利润总额
			s.setField("companyProfit", bigDecimalFormate(tcompanyDevelopInfo.getCompanyProfit()));
			// 企业缴税总额
			s.setField("companyTax", bigDecimalFormate(tcompanyDevelopInfo.getCompanyTax()));
			// 创汇（万美元）
			s.setField("companyExport", bigDecimalFormate(tcompanyDevelopInfo.getCompanyExport()));
			// 其他成果类别
			s.setField("companyDevelopComment", tcompanyDevelopInfo.getCompanyDevelopComment());

			ps.setFormFlattening(true);
			ps.close();
			FileOutputStream fos = new FileOutputStream(pdfOutputPath + supervisorId + "supervisor-other-temp.pdf");
			reader.close();
			fos.write(bos.toByteArray());
			fos.close();
			tempUrl = pdfOutputPath + supervisorId + "supervisor-other-temp.pdf";
		} catch (IOException e) {
			logger.error("IOException", e);
		} catch (DocumentException e) {
			logger.error("DocumentException", e);
		}

		return tempUrl;
	}

	/**
	 * @comments BigDecimal转换成字符窜
	 * @param num
	 * @return String
	 * @version 1.0
	 */
	private String bigDecimalFormate(BigDecimal num) {
		return String.valueOf(num);
	}

	/**
	 * @comments 增加页码的方法
	 * @param inputPfdFilePath
	 * @param outputPdfFilePath
	 * @Version 1.0
	 */
	private void addPage(String inputPfdFilePath, String outputPdfFilePath) {
		try {
			PdfReader reader = new PdfReader(inputPfdFilePath);
			PdfStamper stamper = new PdfStamper(reader, new FileOutputStream(outputPdfFilePath));
			int cnt = 0;
			int total = reader.getNumberOfPages() + 1;
			BaseFont base = BaseFont.createFont("STSong-Light", "UniGB-UCS2-H", BaseFont.NOT_EMBEDDED);
			PdfContentByte under = null;
			for (int k = 2; k < total; k++) {
				cnt++;
				float width = reader.getPageSizeWithRotation(k).getWidth();
				PdfGState gs = new PdfGState();
				gs.setFillOpacity(1f);
				under = stamper.getUnderContent(k);
				under.beginText();
				under.setGState(gs);
				under.setColorFill(BaseColor.BLACK);
				under.setFontAndSize(base, 10);
				under.showTextAligned(PdfContentByte.ALIGN_CENTER, "第" + cnt + "页/共" + (total - 2) + "页", width / 2, 20, 0);
				under.endText();
			}

			stamper.close();
			reader.close();
		} catch (IOException e) {
			logger.error("IOException", e);
		} catch (DocumentException e) {
			logger.error("DocumentException", e);
		}
	}

	/**
	 * @comments 删除临时的pdf文件
	 * @param pdfList
	 * @version 1.0
	 */
	private void deletePdf(List<String> pdfList) {
		for (int i = 0; i < pdfList.size(); i++) {
			File file = new File(pdfList.get(i));

			// 判断文件是否存在
			if (file.exists()) {
				file.delete();
			}
		}
	}

	/**
	 * 项目监理申请审批
	 * 
	 * @comments
	 * @param valueMap
	 * @version 1.0
	 */
	public void saveSupervisorAudit(Map<String, Object> valueMap) {
		// 监理ID
		String supervisorId = (String) valueMap.get("supervisorId");
		// 监理意见
		String tsupervisorInfo = (String) valueMap.get("tsupervisorInfo");
		// 监理状态
		String supervisorState = (String) valueMap.get("supervisorState");
		// 操作用户
		ScUsers user = (ScUsers) valueMap.get("user");

		Tsupervisor supervisor = tsupervisorDao.get(supervisorId);
		if (supervisor != null) {
			supervisor.setCheckInfo(tsupervisorInfo);
			supervisor.setCheckTime(new Timestamp(new java.util.Date().getTime()));
			supervisor.setOperateTime(new Timestamp(new java.util.Date().getTime()));
			supervisor.setOperateUser(user.getUserId());
			supervisor.setUpdateTime(new Timestamp(new java.util.Date().getTime()));
			supervisor.setUpdateUser(user.getUserId());
			if (CommonTool.IsNotEmpty(supervisorState)) {
				supervisor.setSupervisorState(supervisorState);

				// 如果是监理通过状态需要修改项目申报中的流程状态、修改该项目对应的验收信息数据状态
				if (Constants.SUPERVISOR_STATE_PASS.equals(supervisorState)) {
					TprojectApplication tprojectApplication = supervisor.getTprojectApplication();
					tprojectApplication.setFlowStatus(Constants.FLOW_STATUS_ACCEPTANCE);
					tprojectApplicationDao.update(tprojectApplication);
					
					//修改对应的验收数据状态
					List<Tacceptance> tacceptances = tprojectApplication.getTacceptances();
					if(tacceptances!=null&&tacceptances.size()>0){
						for(int i=0;i<tacceptances.size();i++){
							Tacceptance tacceptance = tacceptances.get(0);
							if(tacceptance!=null){
								tacceptance.setDeleteFlag(Constants.COMMON_STATE_NOTDELETE);
								tacceptance.setAcceptanceStatus(Constants.ACCEPTANCE_APPLY);
								tacceptanceDao.update(tacceptance);
							}
						}
					}
				}

				// 添加履历信息
				TprojectRecord tprojectRecord = new TprojectRecord();
				tprojectRecord.setTprojectApplication(supervisor.getTprojectApplication());
				tprojectRecord.setOptStepType(Constants.PROJECT_RECORD_TYPE3);
				tprojectRecord.setOptType(Constants.PROJECT_RECORD_SUPERVISOR_AUDIT);
				tprojectRecord.setOptTime(new Timestamp(new java.util.Date().getTime()));
				tprojectRecord.setOptUser(user.getUserId());
				tprojectRecord.setOptResult(supervisorState);
				tprojectRecord.setOptInfo1(tsupervisorInfo);
				tprojectRecord.setOptUserType(Constants.PROJECT_RECORD_USER_TYPE2);
				tprojectRecordDao.save(tprojectRecord);
			}
		}

	}

	/**
	 * 高新处监理pdf生成
	 * 
	 * @comments
	 * @param valueMap
	 * @version 1.0
	 */
	public String creatPdf(String templatePath, String storagePath, String supervisorId) {
		// 生成PDF============START

		// 根据supervisorId取得项目监理情报
		Tsupervisor tsupervisor = tsupervisorDao.get(supervisorId);
		List<String> pdfList = new ArrayList<String>();
		// 合同类型 0-项目 1-平台
		String modeType = tsupervisor.getModelType();
		String modeTypeStr = "";
		if (Constants.COMMON_TYPE_PROJECT.equals(modeType)) {
			modeTypeStr = "pro";
		} else {
			modeTypeStr = "pal";
		}

		templatePath = templatePath + "supervisor-" + modeTypeStr;
		storagePath = storagePath + "supervisor-" + modeTypeStr + tsupervisor.getSupervisorId();
		// 生成项目监理封皮PDF
		pdfList = generatePdf(templatePath + "-01.pdf", storagePath + "-01.pdf", tsupervisor, pdfList, 1);
		// 生成填表说明
		pdfList = generatePdf(templatePath + "-02.pdf", storagePath + "-02.pdf", tsupervisor, pdfList, 2);
		// 生成基本信息
		pdfList = generatePdf(templatePath + "-03.pdf", storagePath + "-03.pdf", tsupervisor, pdfList, 3);
		// 生成资金信息
		pdfList = generatePdf(templatePath + "-04.pdf", storagePath + "-04.pdf", tsupervisor, pdfList, 4);

		// 合并PDF
		mergerPdf(pdfList, storagePath);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
		String createTime = sdf.format(new Date());
		// 添加页码处理
		addPage(storagePath + ".pdf", storagePath + "_" + createTime + ".pdf");
		pdfList.add(storagePath + ".pdf");
		// 删除临时PDF
		deletePdf(pdfList);

		// 更新项目申报信息中PDF路径
		String pdfUrl = "supervisor-" + modeTypeStr + tsupervisor.getSupervisorId() + "_" + createTime + ".pdf";

		return pdfUrl;
		// 生成PDF============END
	}

	/**
	 * 
	 * @comments
	 * @param templatePath
	 * @param storagePath
	 * @param tsupervisor
	 * @param pdfList
	 * @param flag
	 * @return
	 * @version 1.0
	 */
	private List<String> generatePdf(String templatePath, String storagePath, Tsupervisor tsupervisor, List<String> pdfList, int flag) {
		try {
			PdfReader reader = new PdfReader(templatePath);
			ByteArrayOutputStream bos = new ByteArrayOutputStream();
			PdfStamper ps = new PdfStamper(reader, bos);
			BaseFont bf = BaseFont.createFont("STSong-Light", "UniGB-UCS2-H", BaseFont.NOT_EMBEDDED);
			AcroFields s = ps.getAcroFields();
			s.addSubstitutionFont(bf);

			switch (flag) {
			case 1:
				setFirstPageInfo(tsupervisor, s);
				break;
			case 2:
				break;
			case 3:
				setBaseInfo(tsupervisor, s);
				break;
			case 4:
				setFundInfo(tsupervisor, s);
				break;
			default:
				break;
			}

			ps.setFormFlattening(true);
			ps.close();
			FileOutputStream fos = new FileOutputStream(storagePath);
			reader.close();
			fos.write(bos.toByteArray());
			bos.close();
			fos.close();
			pdfList.add(storagePath);
		} catch (IOException e) {
			logger.error("IOException", e);
		} catch (DocumentException e) {
			logger.error("DocumentException", e);
		}
		return pdfList;
	}

	/**
	 * 
	 * @comments 作成第一页（封皮）信息
	 * @param tsupervisor
	 * @param s
	 * @throws IOException
	 * @throws DocumentException
	 * @version 1.0
	 */
	private void setFirstPageInfo(Tsupervisor tsupervisor, AcroFields s) throws IOException, DocumentException {
		if (tsupervisor != null) {

			TprojectApplication projectApplication = tsupervisor.getTprojectApplication();
			// 项目名称
			s.setField("projectName", projectApplication.getProjectName());

			// 委 托 单 位 （甲方）-西安市科技局
			// 承 担 单 位 （乙方）
			s.setField("applicationUnit", projectApplication.getApplicationUnit());

			// 归口管理单位（丙方）
			String gkdw = projectApplication.getCentralizedType();
			if (gkdw != null && gkdw.length() > 0) {
				s.setField("centralizedBranch", mitemDao.getItemName(gkdw));
			}

			// 监理封皮信息
			s.setField("supervisorComment", tsupervisor.getCompilationDept());
		}
	}

	/**
	 * 
	 * @comments 作成基本信息
	 * @param tsupervisor
	 * @param s
	 * @version 1.0
	 * @throws DocumentException
	 * @throws IOException
	 */
	private void setBaseInfo(Tsupervisor tsupervisor, AcroFields s) throws IOException, DocumentException {
		if (tsupervisor != null) {
			// 根据supervisorID取得资金情报
			TsupervisorInfoA tsupervisorInfo = tsupervisorInfoADao.get("tsupervisor.supervisorId", tsupervisor.getSupervisorId());
			if (tsupervisorInfo == null) {
				return;
			}
			// 取得项目申请
			TprojectApplication projectApplication = tsupervisor.getTprojectApplication();
			if (projectApplication == null) {
				return;
			}

			// 合同类型 0-项目 1-平台
			String modeType = tsupervisor.getModelType();

			// 项目名称
			s.setField("projectName", projectApplication.getProjectName());
			// 项目编号
			s.setField("projectNumber", projectApplication.getProjectNumber());
			// 承担单位
			s.setField("applicationunit", projectApplication.getApplicationUnit());
			// 项目所属领域
			String fieldItem = tsupervisorInfo.getField();
			if (Constants.PROJECT_FIELD_1.equals(fieldItem)) {
				s.setField("field1", "On");
			} else if (Constants.PROJECT_FIELD_2.equals(fieldItem)) {
				s.setField("field2", "On");
			} else if (Constants.PROJECT_FIELD_3.equals(fieldItem)) {
				s.setField("field3", "On");
			} else if (Constants.PROJECT_FIELD_4.equals(fieldItem)) {
				s.setField("field4", "On");
			} else if (Constants.PROJECT_FIELD_5.equals(fieldItem)) {
				s.setField("field5", "On");
			} else if (Constants.PROJECT_FIELD_6.equals(fieldItem)) {
				s.setField("field6", "On");
			} else if (Constants.PROJECT_FIELD_7.equals(fieldItem)) {
				s.setField("field7", "On");
			}
			s.setField("field", mitemDao.getItemName(tsupervisorInfo.getField()));
			// 其他项目所属领域
			s.setField("otherField", tsupervisorInfo.getOtherField());
			// 项目负责人姓名
			s.setField("projectPersonName", tsupervisorInfo.getProjectPersonName());

			// 平台类的时候下面三项不需要
			if (Constants.COMMON_TYPE_PROJECT.equals(modeType)) {
				// 项目负责人学历
				String educationItem = tsupervisorInfo.getProjectPersonEducation();
				if (Constants.PROJECT_PERSON_EDUCATION_1.equals(educationItem)) {
					s.setField("projectPersonEducation1", "On");
				} else if (Constants.PROJECT_PERSON_EDUCATION_2.equals(educationItem)) {
					s.setField("projectPersonEducation2", "On");
				} else if (Constants.PROJECT_PERSON_EDUCATION_3.equals(educationItem)) {
					s.setField("projectPersonEducation3", "On");
				} else if (Constants.PROJECT_PERSON_EDUCATION_4.equals(educationItem)) {
					s.setField("projectPersonEducation4", "On");
				}

				// 项目负责人职称
				String titleItem = tsupervisorInfo.getProjectPersonTitle();
				if (Constants.PROJECT_PERSON_TITLE_1.equals(titleItem)) {
					s.setField("projectPersonTitle1", "On");
				} else if (Constants.PROJECT_PERSON_TITLE_2.equals(titleItem)) {
					s.setField("projectPersonTitle2", "On");
				} else if (Constants.PROJECT_PERSON_TITLE_3.equals(titleItem)) {
					s.setField("projectPersonTitle3", "On");
				} else if (Constants.PROJECT_PERSON_TITLE_4.equals(titleItem)) {
					s.setField("projectPersonTitle4", "On");
				} else if (Constants.PROJECT_PERSON_TITLE_5.equals(titleItem)) {
					s.setField("projectPersonTitle5", "On");
				}

				// 项目联系人姓名
				s.setField("linkPersonName", tsupervisorInfo.getLinkPersonName());
			}
			// 项目联系人电话
			s.setField("linkPersonTel", tsupervisorInfo.getLinkPersonTel());
			// 项目联系人手机
			s.setField("linkPersonMobile", tsupervisorInfo.getLinkPersonMobile());
			// 项目实施进展情况
			String scheduleItem = tsupervisorInfo.getProjectSchedule();
			if (Constants.PROJECT_SCHEDULE_1.equals(scheduleItem)) {
				s.setField("projectSchedule1", "On");
			} else if (Constants.PROJECT_SCHEDULE_2.equals(scheduleItem)) {
				s.setField("projectSchedule2", "On");
			} else if (Constants.PROJECT_SCHEDULE_3.equals(scheduleItem)) {
				s.setField("projectSchedule3", "On");
			} else if (Constants.PROJECT_SCHEDULE_4.equals(scheduleItem)) {
				s.setField("projectSchedule4", "On");
			} else if (Constants.PROJECT_SCHEDULE_5.equals(scheduleItem)) {
				s.setField("projectSchedule5", "On");
			}

			// 项目未按计划进行的原因
			String[] projectReasonItem = null;
			if (tsupervisorInfo.getProjectReason() != null) {
				projectReasonItem = tsupervisorInfo.getProjectReason().split(",");
			}
			for (int i = 0; projectReasonItem != null && i < projectReasonItem.length; i++) {
				if (Constants.PROJECT_STOP_REASON_1.equals(projectReasonItem[i])) {
					s.setField("projectReason1", "On");
				} else if (Constants.PROJECT_STOP_REASON_2.equals(projectReasonItem[i])) {
					s.setField("projectReason2", "On");
				} else if (Constants.PROJECT_STOP_REASON_3.equals(projectReasonItem[i])) {
					s.setField("projectReason3", "On");
				} else if (Constants.PROJECT_STOP_REASON_4.equals(projectReasonItem[i])) {
					s.setField("projectReason4", "On");
				} else if (Constants.PROJECT_STOP_REASON_5.equals(projectReasonItem[i])) {
					s.setField("projectReason5", "On");
				} else if (Constants.PROJECT_STOP_REASON_6.equals(projectReasonItem[i])) {
					s.setField("projectReason6", "On");
				} else if (Constants.PROJECT_STOP_REASON_7.equals(projectReasonItem[i])) {
					s.setField("projectReason7", "On");
				} else if (Constants.PROJECT_STOP_REASON_8.equals(projectReasonItem[i])) {
					s.setField("projectReason8", "On");
				}
			}
			// 项目未按计划进行的其它原因的说明
			s.setField("projectReasonOtherComment", tsupervisorInfo.getProjectReasonCommand());

			// 项目类的时候显示下面的项目
			if (Constants.COMMON_TYPE_PROJECT.equals(modeType)) {
				// 申报年度
				int reportYear = Integer.parseInt(projectApplication.getReportYear());
				s.setField("lastThreeYear", String.valueOf(reportYear - 3));
				s.setField("lastTwoYear", String.valueOf(reportYear - 2));
				s.setField("lastOneYear", String.valueOf(reportYear - 1));
				// 目前公司资产
				s.setField("companyAssets", String.valueOf(tsupervisorInfo.getCompanyAssets()));
				// 企业产值近三年（万元）
				s.setField("companyOutputThree", String.valueOf(tsupervisorInfo.getCompanyOutputThree()));
				// 企业产值近二年（万元）
				s.setField("companyOutputTwo", String.valueOf(tsupervisorInfo.getCompanyOutputTwo()));
				// 企业产值近一年（万元）
				s.setField("companyOutputOne", String.valueOf(tsupervisorInfo.getCompanyOutputOne()));
				// 项目产值近三年（万元）
				s.setField("projectOutputThree", String.valueOf(tsupervisorInfo.getProjectOutputThree()));
				// 项目产值近二年（万元）
				s.setField("projectOutputTwo", String.valueOf(tsupervisorInfo.getProjectOutputTwo()));
				// 项目产值近一年（万元）
				s.setField("projectOutputOne", String.valueOf(tsupervisorInfo.getProjectOutputOne()));
				// 企业销售收入近三年（万元）
				s.setField("companySellThree", String.valueOf(tsupervisorInfo.getCompanySellThree()));
				// 企业销售收入近二年（万元）
				s.setField("companySellTwo", String.valueOf(tsupervisorInfo.getCompanySellTwo()));
				// 企业销售收入近一年（万元）
				s.setField("companySellOne", String.valueOf(tsupervisorInfo.getCompanySellOne()));
				// 项目销售收入近三年（万元）
				s.setField("projectSellThree", String.valueOf(tsupervisorInfo.getProjectSellThree()));
				// 项目销售收入近二年（万元）
				s.setField("projectSellTwo", String.valueOf(tsupervisorInfo.getProjectSellTwo()));
				// 项目销售收入近一年（万元）
				s.setField("projectSellOne", String.valueOf(tsupervisorInfo.getProjectSellOne()));
				// 企业净利润总额近三年（万元）
				s.setField("companyProfitThree", String.valueOf(tsupervisorInfo.getCompanyProfitThree()));
				// 企业净利润总额近二年（万元）
				s.setField("companyProfitTwo", String.valueOf(tsupervisorInfo.getCompanyProfitTwo()));
				// 企业净利润总额近一年（万元）
				s.setField("companyProfitOne", String.valueOf(tsupervisorInfo.getCompanyProfitOne()));
				// 项目净利润总额近三年（万元）
				s.setField("projectProfitThree", String.valueOf(tsupervisorInfo.getProjectProfitThree()));
				// 项目净利润总额近二年（万元）
				s.setField("projectProfitTwo", String.valueOf(tsupervisorInfo.getProjectProfitTwo()));
				// 项目净利润总额近一年（万元）
				s.setField("projectProfitOne", String.valueOf(tsupervisorInfo.getProjectProfitOne()));
				// 企业交税总额近三年（万元）
				s.setField("companyTaxThree", String.valueOf(tsupervisorInfo.getCompanyTaxThree()));
				// 企业交税总额近二年（万元）
				s.setField("companyTaxTwo", String.valueOf(tsupervisorInfo.getCompanyTaxTwo()));
				// 企业交税总额近一年（万元）
				s.setField("companyTaxOne", String.valueOf(tsupervisorInfo.getCompanyTaxOne()));
				// 项目交税总额近三年（万元）
				s.setField("projectTaxThree", String.valueOf(tsupervisorInfo.getProjectTaxThree()));
				// 项目交税总额近二年（万元）
				s.setField("projectTaxTwo", String.valueOf(tsupervisorInfo.getProjectTaxTwo()));
				// 项目交税总额近一年（万元）
				s.setField("projectTaxOne", String.valueOf(tsupervisorInfo.getProjectTaxOne()));
				// 企业出口创汇近三年（万美元）
				s.setField("companyExportThree", String.valueOf(tsupervisorInfo.getCompanyExportThree()));
				// 企业出口创汇近二年（万美元）
				s.setField("companyExportTwo", String.valueOf(tsupervisorInfo.getCompanyExportTwo()));
				// 企业出口创汇近一年（万美元）
				s.setField("companyExportOne", String.valueOf(tsupervisorInfo.getCompanyExportOne()));
				// 项目出口创汇近三年（万美元）
				s.setField("projectExportThree", String.valueOf(tsupervisorInfo.getProjectExportThree()));
				// 项目出口创汇近二年（万美元）
				s.setField("projectExportTwo", String.valueOf(tsupervisorInfo.getProjectExportTwo()));
				// 项目出口创汇近一年（万美元）
				s.setField("projectExportOne", String.valueOf(tsupervisorInfo.getProjectExportOne()));
			}
			// 平台类的时候显示下面的项目
			else {
				// 硬件设施面积(平方米)
				s.setField("hardwareArea", String.valueOf(tsupervisorInfo.getHardwareArea()));
				// 设备总值(万元)
				s.setField("equipmentTotal", String.valueOf(tsupervisorInfo.getEquipmentTotal()));
				// 硬件设备总数（提供清单）
				s.setField("hardwareTotal", String.valueOf(tsupervisorInfo.getHardwareTotal()));
				// 新增加设备数（提供清单）
				s.setField("newHardwareTotal", String.valueOf(tsupervisorInfo.getNewHardwareTotal()));
				// 员工总数(人)
				s.setField("staffTotal", String.valueOf(tsupervisorInfo.getStaffTotal()));
				// 本科以上(人)
				s.setField("undergraduateTotal", String.valueOf(tsupervisorInfo.getUndergraduateTotal()));
				// 为企业培训人数(人)
				s.setField("trainTotal", String.valueOf(tsupervisorInfo.getTrainTotal()));
				// 技术服务的企业数(提供企业名单)
				s.setField("serviceTotal", String.valueOf(tsupervisorInfo.getServiceTotal()));
			}
		}
	}

	/**
	 * 
	 * @comments 生成资金情况信息
	 * @param tsupervisor
	 * @param s
	 * @version 1.0
	 * @throws DocumentException
	 * @throws IOException
	 */
	private void setFundInfo(Tsupervisor tsupervisor, AcroFields s) throws IOException, DocumentException {

		if (tsupervisor != null) {
			// 根据supervisorID取得资金情报
			TsupervisorFundA tsupervisorFund = tsupervisorFundADao.get("tsupervisor.supervisorId", tsupervisor.getSupervisorId());
			if (tsupervisorFund == null) {
				return;
			}

			// 合同指标(万元)
			s.setField("contractIndex", String.valueOf(tsupervisorFund.getContractIndex()));
			// 实际完成(万元)
			s.setField("realComplete", String.valueOf(tsupervisorFund.getRealComplete()));
			// 计划投资总额
			s.setField("planInvestment", String.valueOf(tsupervisorFund.getPlanInvestment()));
			// 目前已完成投资
			s.setField("completeInvestment", String.valueOf(tsupervisorFund.getCompleteInvestment()));
			// 合同指标其中:企业自筹
			s.setField("contractSelf", String.valueOf(tsupervisorFund.getContractSelf()));
			// 实际完成其中:企业自筹
			s.setField("realSelf", String.valueOf(tsupervisorFund.getRealSelf()));
			// 合同指标贷款
			s.setField("contractLoan", String.valueOf(tsupervisorFund.getContractLoan()));
			// 实际完成贷款
			s.setField("realLoan", String.valueOf(tsupervisorFund.getRealLoan()));
			// 合同指标财政资金
			s.setField("realFinancial", String.valueOf(tsupervisorFund.getRealFinancial()));
			// 实际完成财政资金
			s.setField("contractFinancial", String.valueOf(tsupervisorFund.getContractFinancial()));
			// 合同指标配套资金
			s.setField("contractSupporting", String.valueOf(tsupervisorFund.getContractSupporting()));
			// 实际完成配套资金
			s.setField("realSupporting", String.valueOf(tsupervisorFund.getRealSupporting()));
			// 合同指标其它(注明来源)
			s.setField("contractOther", String.valueOf(tsupervisorFund.getContractOther()));
			// 实际完成其它(注明来源)
			s.setField("realOther", String.valueOf(tsupervisorFund.getRealOther()));
			// 人员费
			s.setField("personnelCost", String.valueOf(tsupervisorFund.getPersonnelCost()));
			// 设备费
			s.setField("equipmentCost", String.valueOf(tsupervisorFund.getEquipmentCost()));
			// 能源材料费
			s.setField("energyCost", String.valueOf(tsupervisorFund.getEnergyCost()));
			// 试验及外协费
			s.setField("testCost", String.valueOf(tsupervisorFund.getTestCost()));
			// 差旅费
			s.setField("travelCost", String.valueOf(tsupervisorFund.getTravelCost()));
			// 会议费
			s.setField("meetingCost", String.valueOf(tsupervisorFund.getMeetingCost()));
			// 管理费
			s.setField("managerCost", String.valueOf(tsupervisorFund.getManagerCost()));
			// 其它费用
			s.setField("otherCost", String.valueOf(tsupervisorFund.getOtherCost()));
			// 合计
			DecimalFormat df1 = new DecimalFormat("#0.00");
			s.setField("totalCost", String.valueOf(df1.format(tsupervisorFund.getTotalCost())));
			// 项目及企业情况
			String projectSituation = tsupervisorFund.getProjectSituation();
			s.setField("projectSituation", projectSituation == null ? "" : projectSituation);

		}
	}

	/**
	 * 
	 * @comments PDF合成
	 * @param pdfList
	 * @param pdfOutputPath
	 * @version 1.0
	 */
	private void mergerPdf(List<String> pdfList, String pdfOutputPath) {

		String[] files = (String[]) pdfList.toArray(new String[pdfList.size()]);
		try {
			PdfReader firstPage = new PdfReader(files[0]);
			Document document = new Document(firstPage.getPageSize(1));
			String pdfName = pdfOutputPath + ".pdf";
			FileOutputStream copyDocument = new FileOutputStream(pdfName);
			PdfCopy copy = new PdfCopy(document, copyDocument);
			document.open();
			for (int i = 0; i < files.length; i++) {
				PdfReader reader1 = new PdfReader(files[i]);
				int n = reader1.getNumberOfPages();
				for (int j = 1; j <= n; j++) {
					document.newPage();
					PdfImportedPage page = copy.getImportedPage(reader1, j);
					copy.addPage(page);
				}
				reader1.close();
			}
			copy.close();
			copyDocument.close();
			document.close();
			firstPage.close();
		} catch (IOException e) {
			logger.error("IOException", e);
		} catch (DocumentException e) {
			logger.error("DocumentException", e);
		}
	}
}
