/************************* 版权声明 *********************************
 *
 * Copyright (C) 2012 西安辉盛科技发展有限责任公司.
 *
 ******************************************************************
 */
package com.hopsun.tppas.api.acceptance.service.impl;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.sql.Timestamp;
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
import com.hopsun.tppas.api.acceptance.dao.TacceptanceAccADao;
import com.hopsun.tppas.api.acceptance.dao.TacceptanceAccFundsADao;
import com.hopsun.tppas.api.acceptance.dao.TacceptanceAchievementBDao;
import com.hopsun.tppas.api.acceptance.dao.TacceptanceCompleteADao;
import com.hopsun.tppas.api.acceptance.dao.TacceptanceDao;
import com.hopsun.tppas.api.acceptance.dao.TacceptanceDevelopingADao;
import com.hopsun.tppas.api.acceptance.dao.TacceptanceFundsADao;
import com.hopsun.tppas.api.acceptance.dao.TacceptanceImplementationADao;
import com.hopsun.tppas.api.acceptance.dao.TacceptanceImplementationBDao;
import com.hopsun.tppas.api.acceptance.dao.TacceptanceMainADao;
import com.hopsun.tppas.api.acceptance.dao.TacceptanceOpinionADao;
import com.hopsun.tppas.api.acceptance.dao.TacceptanceSummaryBDao;
import com.hopsun.tppas.api.acceptance.service.TacceptanceService;
import com.hopsun.tppas.api.report.dao.TprojectInfoADao;
import com.hopsun.tppas.api.report.dao.TprojectInfoBDao;
import com.hopsun.tppas.api.report.dao.TreviewCommentsDao;
import com.hopsun.tppas.api.superadmin.dao.MitemDao;
import com.hopsun.tppas.api.superadmin.dao.TattachmentDao;
import com.hopsun.tppas.common.Constants;
import com.hopsun.tppas.entity.Tacceptance;
import com.hopsun.tppas.entity.TacceptanceAccA;
import com.hopsun.tppas.entity.TacceptanceAccFundsA;
import com.hopsun.tppas.entity.TacceptanceAchievementB;
import com.hopsun.tppas.entity.TacceptanceCompleteA;
import com.hopsun.tppas.entity.TacceptanceDevelopingA;
import com.hopsun.tppas.entity.TacceptanceFundsA;
import com.hopsun.tppas.entity.TacceptanceImplementationA;
import com.hopsun.tppas.entity.TacceptanceImplementationB;
import com.hopsun.tppas.entity.TacceptanceMainA;
import com.hopsun.tppas.entity.TacceptanceOpinionA;
import com.hopsun.tppas.entity.TacceptanceSummaryB;
import com.hopsun.tppas.entity.Tattachment;
import com.hopsun.tppas.entity.TprojectApplication;
import com.hopsun.tppas.entity.TprojectInfoA;
import com.hopsun.tppas.entity.TprojectInfoB;
import com.hopsun.tppas.entity.TreviewComments;
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
 * 
 *@comments 验收service实现类
 *@author liyilin
 *@date 2013-8-9
 *@version 1.0
 */
@Service
public class TacceptanceServiceImpl extends BaseServiceImpl<Tacceptance,String> implements TacceptanceService{
	public final static Logger logger = Logger.getLogger(TacceptanceServiceImpl.class.getName());
	
	/** 验收*/
	@Resource
	private TacceptanceDao acceptanceDao;
	/** 项目经费落实和使用情况B*/
	@Resource
	private TacceptanceImplementationBDao tacceptanceImplementationBDao;
	/** 项目取得成果情况*/
	@Resource
	private TacceptanceAchievementBDao tacceptanceAchievementBDao;
	/** 项目总结说明*/
	@Resource
	private TacceptanceSummaryBDao tacceptanceSummaryBDao;
	/** 附件*/
	@Resource
	private TattachmentDao tattachmentDao;
	/** 非高新项目基本信息*/
	@Resource
	private TprojectInfoBDao tprojectInfoBDao;
	/** 非高新项目意见*/
	@Resource
	private TreviewCommentsDao treviewCommentsDao;
	/** 码表 */
	@Resource 
	private MitemDao mitemDao;
	/** 项目基本信息表 */
	@Resource
	private TprojectInfoADao tprojectInfoADao;
	/** 项目经费落实和使用情况A */
	@Resource
	private TacceptanceImplementationADao tacceptanceImplementationADao;
	/** 对照合同项目任务完成情况A */
	@Resource
	private TacceptanceCompleteADao tacceptanceCompleteADao;
	/** 企业获得资金支持情况A */
	@Resource
	private TacceptanceFundsADao tacceptanceFundsADao;
	/** 企业发展情况A */
	@Resource
	private TacceptanceDevelopingADao tacceptanceDevelopingADao;
	/** 验收阶段意见A */
	@Resource
	private TacceptanceOpinionADao tacceptanceOpinionADao;
	/** 项目主要参加人员信息A */
	@Resource
	private TacceptanceMainADao tacceptanceMainADao;
	/** 验收小组人员信息A */
	@Resource
	private TacceptanceAccADao tacceptanceAccADao;
	/** 项目验收经费登记表A */
	@Resource
	private TacceptanceAccFundsADao tacceptanceAccFundsADao;
	
	@Resource
	public void setBaseDao(TacceptanceDao tacceptanceDao) {
		super.setBaseDao(tacceptanceDao);
	}
	
	/**
	 * 分页查询验收项目列表
	 */
	@Override
	public Pager find(Map<String, Object> param, Integer pageNumber, Integer pageSize) {
		Pager pager = acceptanceDao.find(param, pageNumber, pageSize);
		if(pager != null && pager.getList() != null && pager.getList().size() > 0){
			for(int i=0; i< pager.getList().size(); i++){
				Tacceptance tacceptance = (Tacceptance)pager.getList().get(i);
				if(tacceptance !=null){
					// 验收状态
					if(tacceptance.getAcceptanceStatus() != null && !"".equals(tacceptance.getAcceptanceStatus())){
						tacceptance.setAcceptanceStatusName(mitemDao.getItemName(tacceptance.getAcceptanceStatus()));
					} else {
						tacceptance.setAcceptanceStatusName("");
					}
				}
			}
		}
		return pager;
	}
	
	/**
	 * 查询待验收项目
	 * @param acceptanceStatus
	 * @return
	 */
	@Override
	public List<Tacceptance> queryTacceptanceByState(String acceptanceStatus) {
		return acceptanceDao.queryTacceptanceByState(acceptanceStatus);
	}
	
	/**
	 * 根据项目ID查询项目验收管理信息
	 *@param acceptanceId
	 *@return Tacceptance
	 */
	public Tacceptance getTacceptanceById(String acceptanceId){
		Tacceptance tacceptance = acceptanceDao.getTacceptanceById(acceptanceId);
		if(tacceptance != null && tacceptance.getTprojectApplication() != null){
			tacceptance.getTprojectApplication().setCentralizedTypeName(mitemDao.getItemName(tacceptance.getTprojectApplication().getCentralizedType()));
		}
		return tacceptance;
	}
	
	/**
	 * @comments 高新处验收提交材料集合
	 * @param acceptanceId
	 * @return
	 * @Version 1.0
	 */
	public List<Map<String, Object>> getSubmitHighTechAcceptanceList(String acceptanceId) {
		List<Map<String, Object>> submitHighTechAcceptanceList = new ArrayList<Map<String, Object>>();
		Map<String, Object> valueMap = null;
		Tacceptance tacceptance = acceptanceDao.getTacceptanceById(acceptanceId);
		/* 1项目验收申请表封皮 */
		valueMap = new HashMap<String, Object>();
		valueMap.put("name", "项目验收申请表封皮");
		if (tacceptance != null) {
			valueMap.put("isExist", "是");
			valueMap.put("isKey", "1");
		} else {
			valueMap.put("isExist", "否");
			valueMap.put("isKey", "0");
		}
		submitHighTechAcceptanceList.add(valueMap);
		
		/* 2项目经费落实和使用情况 */
		valueMap = new HashMap<String, Object>();
		valueMap.put("name", "项目经费落实和使用情况");
		List<TacceptanceImplementationA> implementationAList = new ArrayList<TacceptanceImplementationA>();
		implementationAList = tacceptanceImplementationADao.getTacceptanceImplementationAById(acceptanceId);
		if (implementationAList != null && implementationAList.size() > 0) {
			valueMap.put("isExist", "是");
			valueMap.put("isKey", "1");
		} else {
			valueMap.put("isExist", "否");
			valueMap.put("isKey", "0");
		}
		submitHighTechAcceptanceList.add(valueMap);
		
		/* 3对照合同项目任务完成情况 */
		valueMap = new HashMap<String, Object>();
		valueMap.put("name", "对照合同项目任务完成情况");
		List<TacceptanceCompleteA> completeAList = new ArrayList<TacceptanceCompleteA>();
		completeAList = tacceptanceCompleteADao.getTacceptanceCompleteAById(acceptanceId);
		if (completeAList != null && completeAList.size() > 0) {
			valueMap.put("isExist", "是");
			valueMap.put("isKey", "1");
		} else {
			valueMap.put("isExist", "否");
			valueMap.put("isKey", "0");
		}
		submitHighTechAcceptanceList.add(valueMap);
		
		/* 4企业获得资金支持情况 */
		valueMap = new HashMap<String, Object>();
		valueMap.put("name", "企业获得资金支持情况");
		List<TacceptanceFundsA> fundsAList = new ArrayList<TacceptanceFundsA>();
		fundsAList = tacceptanceFundsADao.getTacceptanceFundsAById(acceptanceId);
		if (fundsAList != null && fundsAList.size() > 0) {
			valueMap.put("isExist", "是");
			valueMap.put("isKey", "1");
		} else {
			valueMap.put("isExist", "否");
			valueMap.put("isKey", "0");
		}
		submitHighTechAcceptanceList.add(valueMap);
		
		/* 5企业发展情况 */
		valueMap = new HashMap<String, Object>();
		valueMap.put("name", "企业发展情况");
		List<TacceptanceDevelopingA> developingAList = new ArrayList<TacceptanceDevelopingA>();
		developingAList = tacceptanceDevelopingADao.getTacceptanceDevelopingAById(acceptanceId);
		if (developingAList != null && developingAList.size() > 0) {
			valueMap.put("isExist", "是");
			valueMap.put("isKey", "1");
		} else {
			valueMap.put("isExist", "否");
			valueMap.put("isKey", "0");
		}
		submitHighTechAcceptanceList.add(valueMap);
		
		/* 6验收意见 */
		valueMap = new HashMap<String, Object>();
		valueMap.put("name", "验收意见");
		List<TacceptanceOpinionA> opinionAList = new ArrayList<TacceptanceOpinionA>();
		opinionAList = tacceptanceOpinionADao.getTacceptanceOpinionAById(acceptanceId);
		if (opinionAList != null && opinionAList.size() > 0 && !"".equals(opinionAList.get(0).getAcceptanceOpinion())) {
			valueMap.put("isExist", "是");
			valueMap.put("isKey", "1");
		} else {
			valueMap.put("isExist", "否");
			valueMap.put("isKey", "0");
		}
		submitHighTechAcceptanceList.add(valueMap);
		
		/* 7单位意见 */
		valueMap = new HashMap<String, Object>();
		valueMap.put("name", "单位意见");
		if (opinionAList != null && opinionAList.size() > 0 && !"".equals(opinionAList.get(0).getPresideOpinion())) {
			valueMap.put("isExist", "是");
			valueMap.put("isKey", "1");
		} else {
			valueMap.put("isExist", "否");
			valueMap.put("isKey", "0");
		}
		submitHighTechAcceptanceList.add(valueMap);
		
		/* 8项目主要参加人员名单 */
		valueMap = new HashMap<String, Object>();
		valueMap.put("name", "项目主要参加人员名单");
		List<TacceptanceMainA> mainAList = new ArrayList<TacceptanceMainA>();
		mainAList = tacceptanceMainADao.getTacceptanceMainAById(acceptanceId);
		if (mainAList != null && mainAList.size() > 0) {
			valueMap.put("isExist", "是");
			valueMap.put("isKey", "1");
		} else {
			valueMap.put("isExist", "否");
			valueMap.put("isKey", "0");
		}
		submitHighTechAcceptanceList.add(valueMap);
		
		/* 9验收小组名单 */
		valueMap = new HashMap<String, Object>();
		valueMap.put("name", "验收小组名单");
		List<TacceptanceAccA> accAList = new ArrayList<TacceptanceAccA>();
		accAList = tacceptanceAccADao.getTacceptanceAccAById(acceptanceId);
		if (accAList != null && accAList.size() > 0) {
			valueMap.put("isExist", "是");
			valueMap.put("isKey", "1");
		} else {
			valueMap.put("isExist", "否");
			valueMap.put("isKey", "0");
		}
		submitHighTechAcceptanceList.add(valueMap);
		
		/* 10项目验收经费登记表 */
		valueMap = new HashMap<String, Object>();
		valueMap.put("name", "项目验收经费登记表");
		List<TacceptanceAccFundsA> accFundsAList = new ArrayList<TacceptanceAccFundsA>();
		accFundsAList = tacceptanceAccFundsADao.getTacceptanceAccFundsAById(acceptanceId);
		if (accFundsAList != null && accFundsAList.size() > 0) {
			valueMap.put("isExist", "是");
			valueMap.put("isKey", "1");
		} else {
			valueMap.put("isExist", "否");
			valueMap.put("isKey", "0");
		}
		submitHighTechAcceptanceList.add(valueMap);
		
		/* 11附件清单 */
		valueMap = new HashMap<String, Object>();
		valueMap.put("name", "附件清单");
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("tableName", Tacceptance.class);
		paramMap.put("key1", acceptanceId);
		List<Tattachment> attList = tattachmentDao.getAttachmentsByForeignKey(paramMap);
		if (attList != null && attList.size() > 0) {
			valueMap.put("isExist", "是");
			valueMap.put("isKey", "1");
		} else {
			valueMap.put("isExist", "否");
			valueMap.put("isKey", "0");
		}
		submitHighTechAcceptanceList.add(valueMap);
		
		return submitHighTechAcceptanceList;
	}
	
	/**
	 * @comments 提交高新处验收
	 * @param templatePath
	 * @param outputPath 
	 * @param acceptanceId
	 * @Version 1.0
	 */
	public void saveSubmitHighTechAcceptance(String submitFlag, String acceptanceId) {
		Tacceptance tacceptance = acceptanceDao.getTacceptanceById(acceptanceId);

		// 更新验收表的内容
		// 验收状态
		if("1".equals(submitFlag)){
			// 验收合格
			tacceptance.setAcceptanceStatus(Constants.ACCEPTANCE_PASS);
		} else if("2".equals(submitFlag)) {
			// 验收基本合格
			tacceptance.setAcceptanceStatus(Constants.ACCEPTANCE_BASIC_PASS);
		} else if("3".equals(submitFlag)) {
			// 验收不合格
			tacceptance.setAcceptanceStatus(Constants.ACCEPTANCE_NOPASS);
		} else {
			// 结题
			tacceptance.setAcceptanceStatus(Constants.ACCEPTANCE_END);
		}
		// 更新日期
		Date nowDate = new Date();
		tacceptance.setUpdateDate(new Timestamp(nowDate.getTime()));
		// 提交时间
		tacceptance.setAcceptanceDate(new Timestamp(nowDate.getTime()));

		acceptanceDao.update(tacceptance);
	}
	
	/**
	 * @comments 打印高新处验收
	 * @param templatePath
	 * @param outputPath 
	 * @param acceptanceId
	 * @Version 1.0
	 */
	public String printHighTechAcceptance(String templatePath, String outputPath, String acceptanceId) {
		Tacceptance tacceptance = acceptanceDao.getTacceptanceById(acceptanceId);
		String dd = String.valueOf(System.currentTimeMillis());
		List<String> pdfList = new ArrayList<String>();

		templatePath = templatePath + "acceptance-hightech";
		pdfList = this.createHighTechCoverPdf(templatePath + "-01.pdf", outputPath, tacceptance, pdfList);
		pdfList = this.createImplementationAPdf(templatePath + "-02.pdf", outputPath, tacceptance, pdfList);
		pdfList = this.createCompleteAPdf(templatePath + "-03.pdf", outputPath, tacceptance, pdfList);
		pdfList = this.createFundsAPdf(templatePath + "-04.pdf", outputPath, tacceptance, pdfList);
		pdfList = this.createDevelopingAPdf(templatePath + "-05.pdf", outputPath, tacceptance, pdfList);
		pdfList = this.createAccOpinionAPdf(templatePath + "-06.pdf", outputPath, tacceptance, pdfList);
		pdfList = this.createDeptOpinionAPdf(templatePath + "-07.pdf", outputPath, tacceptance, pdfList);
		pdfList = this.createMainAPdf(templatePath + "-08.pdf", outputPath, tacceptance, pdfList);
		pdfList = this.createAccAPdf(templatePath + "-09.pdf", outputPath, tacceptance, pdfList);
		pdfList = this.createAccFundsAPdf(templatePath + "-10.pdf", outputPath, tacceptance, pdfList);
		templatePath = templatePath + "hightech" + acceptanceId + ".pdf";
		outputPath = outputPath + "hightech" + acceptanceId + dd + ".pdf";
		
		this.mergerPdf(pdfList, templatePath);
		this.addPage(templatePath, outputPath);
		this.deleteTempPdf(pdfList);
		
		return outputPath;
	}
	
	/**
	 * @comments 1项目验收申请表封皮PDF
	 * @param templatePath
	 * @param outputPath
	 * @param tacceptance
	 * @param pdfList
	 * @return
	 * @Version 1.0
	 */
	private List<String> createHighTechCoverPdf(String templatePath, String outputPath, Tacceptance tacceptance, List<String> pdfList) {
		try {
			PdfReader reader = new PdfReader(templatePath);
			ByteArrayOutputStream bos = new ByteArrayOutputStream();
			PdfStamper ps = new PdfStamper(reader, bos);
			BaseFont bf = BaseFont.createFont("STSong-Light", "UniGB-UCS2-H", BaseFont.NOT_EMBEDDED);
			AcroFields s = ps.getAcroFields();
			s.addSubstitutionFont(bf);

			if (tacceptance != null) {
				TprojectInfoA tprojectInfoA = new TprojectInfoA();
				// 根据项目ID查询项目基本信息
				List<TprojectInfoA> tprojectInfoAList = new ArrayList<TprojectInfoA>();
				tprojectInfoAList = tprojectInfoADao.getList("tprojectApplication.projectId", tacceptance.getTprojectApplication().getProjectId());
				if(tprojectInfoAList != null && tprojectInfoAList.size() > 0){
					tprojectInfoA = tprojectInfoAList.get(0);
				}
				
				// 项目编号
				s.setField("projectNumber", tacceptance.getTprojectApplication().getProjectNumber());
				// 计划类别
				s.setField("planFlag", tacceptance.getTprojectApplication().getPlanFlagName());
				// 项目名称
				s.setField("projectName", tacceptance.getTprojectApplication().getProjectName());
				// 项目承担单位
				s.setField("applicationUnit", tacceptance.getTprojectApplication().getApplicationUnit());
				// 项目协作单位
				s.setField("assistUnit", tprojectInfoA.getAssistUnit());
				// 项目负责人
				s.setField("projectPerson", tprojectInfoA.getProjectPerson());
				// 电话
				s.setField("personTel", tprojectInfoA.getPersonTel());
				// 项目联系人
				s.setField("touchPerson", tprojectInfoA.getTouchPerson());
				// 电话
				s.setField("touchPhone", tprojectInfoA.getTouchPhone());
			}
			
			ps.setFormFlattening(true);
			ps.close();
			FileOutputStream fos = new FileOutputStream(outputPath + "firstPage.pdf");
			reader.close();
			fos.write(bos.toByteArray());
			fos.close();
			pdfList.add(outputPath + "firstPage.pdf");

		} catch (IOException e) {
			logger.error("IOException", e);
		} catch (DocumentException e) {
			logger.error("DocumentException", e);
		}
		return pdfList;
	}
	
	/**
	 * @comments 2项目经费落实和使用情况PDF
	 * @param templatePath
	 * @param outputPath
	 * @param tacceptance
	 * @param pdfList
	 * @return
	 * @Version 1.0
	 */
	private List<String> createImplementationAPdf(String templatePath, String outputPath, Tacceptance tacceptance, List<String> pdfList) {
		try {
			PdfReader reader = new PdfReader(templatePath);
			ByteArrayOutputStream bos = new ByteArrayOutputStream();
			PdfStamper ps = new PdfStamper(reader, bos);
			BaseFont bf = BaseFont.createFont("STSong-Light", "UniGB-UCS2-H", BaseFont.NOT_EMBEDDED);
			AcroFields s = ps.getAcroFields();
			s.addSubstitutionFont(bf);

			if (tacceptance != null) {
				TprojectInfoA tprojectInfoA = new TprojectInfoA();
				// 根据项目ID查询项目基本信息
				List<TprojectInfoA> tprojectInfoAList = new ArrayList<TprojectInfoA>();
				tprojectInfoAList = tprojectInfoADao.getList("tprojectApplication.projectId", tacceptance.getTprojectApplication().getProjectId());
				if(tprojectInfoAList != null && tprojectInfoAList.size() > 0){
					tprojectInfoA = tprojectInfoAList.get(0);
				}
				
				// 项目名称
				s.setField("projectName", tacceptance.getTprojectApplication().getProjectName());
				// 项目编号
				s.setField("projectNumber", tacceptance.getTprojectApplication().getProjectNumber());
				// 计划类别
				s.setField("planFlag", tacceptance.getTprojectApplication().getPlanFlagName());
				// 项目负责人
				s.setField("projectPerson", tprojectInfoA.getProjectPerson());
				// 电话
				s.setField("personTel", tprojectInfoA.getPersonTel());
				// 项目开始时间
				s.setField("startTime", changeDateType(tacceptance.getTprojectApplication().getStartTime(), "yyyy年MM月dd日"));
				// 完成时间
				s.setField("endTime", changeDateType(tacceptance.getTprojectApplication().getEndTime(), "yyyy年MM月dd日"));
				// 项目承担单位
				s.setField("applicationUnit", tacceptance.getTprojectApplication().getApplicationUnit());
				// 单位性质
				s.setField("unitProperties", tprojectInfoA.getUnitProperties());
				// 隶属关系
				String centralizedType = tacceptance.getTprojectApplication().getCentralizedType();
				if(centralizedType != null && centralizedType.length() > 0){
					s.setField("centralizedType", mitemDao.getItemName(centralizedType));
				}
				// 单位地址
				s.setField("unitAddress", tprojectInfoA.getUnitAddress());
				// 联系电话
				s.setField("legalTel", tprojectInfoA.getLegalTel());
				// 邮政编码
				s.setField("zipcode", tprojectInfoA.getZipcode());
				
				List<TacceptanceImplementationA> implementationAList = new ArrayList<TacceptanceImplementationA>();
				implementationAList = tacceptanceImplementationADao.getTacceptanceImplementationAById(tacceptance.getAcceptanceId());
				if (implementationAList != null && implementationAList.size() > 0) {
					TacceptanceImplementationA implementationA = implementationAList.get(0);
					// 项目总经费-计划数
					s.setField("planFundsTotalNum", changeType(implementationA.getPlanFundsTotalNum()));
					// 项目总经费-实际数
					s.setField("actualFundsTotalNum", changeType(implementationA.getActualFundsTotalNum()));
					// 使用总额-总经费使用情况
					s.setField("totalTotalCosts", changeType(implementationA.getTotalTotalCosts()));
					// 使用总额-市拨经费使用情况
					s.setField("cityTotalCosts", changeType(implementationA.getCityTotalCosts()));
					// 市拨经费-计划数
					s.setField("planFundsCityNum", changeType(implementationA.getPlanFundsCityNum()));
					// 市拨经费-实际数
					s.setField("actualFundsCityNum", changeType(implementationA.getActualFundsCityNum()));
					// 人员费-总经费使用情况
					s.setField("totalStaffCosts", changeType(implementationA.getTotalStaffCosts()));
					// 人员费-市拨经费使用情况
					s.setField("cityStaffCosts", changeType(implementationA.getCityStaffCosts()));
					// 企业自筹-计划数
					s.setField("planRaisedNum", changeType(implementationA.getPlanRaisedNum()));
					// 企业自筹-实际数
					s.setField("actualRaisedNum", changeType(implementationA.getActualRaisedNum()));
					// 设备费-总经费使用情况
					s.setField("totalDeviceCosts", changeType(implementationA.getTotalDeviceCosts()));
					// 设备费-市拨经费使用情况
					s.setField("cityDeviceCosts", changeType(implementationA.getCityDeviceCosts()));
					// 银行贷款-计划数
					s.setField("planBankNum", changeType(implementationA.getPlanBankNum()));
					// 银行贷款-实际数
					s.setField("actualBankNum", changeType(implementationA.getActualBankNum()));
					// 能源材料费-总经费使用情况
					s.setField("totalEnergyCosts", changeType(implementationA.getTotalEnergyCosts()));
					// 能源材料费-市拨经费使用情况
					s.setField("cityEnergyCosts", changeType(implementationA.getCityEnergyCosts()));
					// 贷款贴息-计划数
					s.setField("planLoanInterestNum", changeType(implementationA.getPlanLoanInterestNum()));
					// 贷款贴息-实际数
					s.setField("actualLoanInterestNum", changeType(implementationA.getActualLoanInterestNum()));
					// 试验外协费-总经费使用情况
					s.setField("totalExperimentCosts", changeType(implementationA.getTotalExperimentCosts()));
					// 试验外协费-市拨经费使用情况
					s.setField("cityExperimentCosts", changeType(implementationA.getCityExperimentCosts()));
					// 其他拨款-计划数
					s.setField("planOtherNum", changeType(implementationA.getPlanOtherNum()));
					// 其他拨款-实际数
					s.setField("actualOtherNum", changeType(implementationA.getActualOtherNum()));
					// 调研费-总经费使用情况
					s.setField("totalResearchCosts", changeType(implementationA.getTotalResearchCosts()));
					// 调研费-市拨经费使用情况
					s.setField("cityResearchCosts", changeType(implementationA.getCityResearchCosts()));
					// 差旅费-总经费使用情况
					s.setField("totalTravelCosts", changeType(implementationA.getTotalTravelCosts()));
					// 差旅费-市拨经费使用情况
					s.setField("cityTravelCosts", changeType(implementationA.getCityTravelCosts()));
					// 会议费-总经费使用情况
					s.setField("totalMeetingCosts", changeType(implementationA.getTotalMeetingCosts()));
					// 会议费-市拨经费使用情况
					s.setField("cityMeetingCosts", changeType(implementationA.getCityMeetingCosts()));
					// 管理费-总经费使用情况
					s.setField("totalManageCosts", changeType(implementationA.getTotalManageCosts()));
					// 管理费-市拨经费使用情况
					s.setField("cityManageCosts", changeType(implementationA.getCityManageCosts()));
					// 其它-总经费使用情况
					s.setField("totalOtherCosts", changeType(implementationA.getTotalOtherCosts()));
					// 其它-市拨经费使用情况
					s.setField("cityOtherCosts", changeType(implementationA.getCityOtherCosts()));
					// 其中研发经费支出-总经费使用情况
					s.setField("totalRdCosts", changeType(implementationA.getTotalRdCosts()));
					// 其中研发经费支出-市拨经费使用情况
					s.setField("cityRdCosts", changeType(implementationA.getCityRdCosts()));
				}
			}
			
			ps.setFormFlattening(true);
			ps.close();
			FileOutputStream fos = new FileOutputStream(outputPath + "secondPage.pdf");
			reader.close();
			fos.write(bos.toByteArray());
			fos.close();
			pdfList.add(outputPath + "secondPage.pdf");

		} catch (IOException e) {
			logger.error("IOException", e);
		} catch (DocumentException e) {
			logger.error("DocumentException", e);
		}
		return pdfList;
	}
	
	/**
	 * @comments 3对照合同项目任务完成情况PDF
	 * @param templatePath
	 * @param outputPath
	 * @param tacceptance
	 * @param pdfList
	 * @return
	 * @Version 1.0
	 */
	private List<String> createCompleteAPdf(String templatePath, String outputPath, Tacceptance tacceptance, List<String> pdfList) {
		try {
			PdfReader reader = new PdfReader(templatePath);
			ByteArrayOutputStream bos = new ByteArrayOutputStream();
			PdfStamper ps = new PdfStamper(reader, bos);
			BaseFont bf = BaseFont.createFont("STSong-Light", "UniGB-UCS2-H", BaseFont.NOT_EMBEDDED);
			AcroFields s = ps.getAcroFields();
			s.addSubstitutionFont(bf);

			if (tacceptance != null) {
				List<TacceptanceCompleteA> completeAList = new ArrayList<TacceptanceCompleteA>();
				completeAList = tacceptanceCompleteADao.getTacceptanceCompleteAById(tacceptance.getAcceptanceId());
				if (completeAList != null && completeAList.size() > 0) {
					TacceptanceCompleteA completeA = completeAList.get(0);
					// 合同要求1
					s.setField("contractRequire1", completeA.getContractRequire1());
					// 合同要求2
					s.setField("contractRequire2", completeA.getContractRequire2());
					// 合同要求3
					s.setField("contractRequire3", completeA.getContractRequire3());
					// 合同要求4
					s.setField("contractRequire4", completeA.getContractRequire4());
					// 实际达到情况1
					s.setField("actuallyAchieved1", completeA.getActuallyAchieved1());
					// 实际达到情况2
					s.setField("actuallyAchieved2", completeA.getActuallyAchieved2());
					// 实际达到情况3
					s.setField("actuallyAchieved3", completeA.getActuallyAchieved3());
					// 实际达到情况4
					s.setField("actuallyAchieved4", completeA.getActuallyAchieved4());
					// 合同约定_销售收入
					s.setField("conventionsSales", changeType(completeA.getConventionsSales()));
					// 合同约定_利润总额
					s.setField("conventionsProfitTotal", changeType(completeA.getConventionsProfitTotal()));
					// 合同约定_税收总额
					s.setField("conventionsTaxTotal", changeType(completeA.getConventionsTaxTotal()));
					// 合同约定_创汇
					s.setField("conventionsForeignExchange", changeType(completeA.getConventionsForeignExchange()));
					// 实际完成_销售收入
					s.setField("completeSales", changeType(completeA.getCompleteSales()));
					// 实际完成_利润总额
					s.setField("completeProfitTotal", changeType(completeA.getCompleteProfitTotal()));
					// 实际完成_税收总额
					s.setField("completeTaxTotal", changeType(completeA.getCompleteTaxTotal()));
					// 实际完成_创汇
					s.setField("completeForeignExchange", changeType(completeA.getCompleteForeignExchange()));
					// 已获得_发明专利数
					s.setField("receivePatentNum", changeType(completeA.getReceivePatentNum()));
					// 已获得_实用新型数
					s.setField("receiveUtilityNum", changeType(completeA.getReceiveUtilityNum()));
					// 已获得_外观设计数
					s.setField("receiveDesignsNum", changeType(completeA.getReceiveDesignsNum()));
					// 已获得_国外专利数
					s.setField("receiveForeignNum", changeType(completeA.getReceiveForeignNum()));
					// 已获得_软件著作权数
					s.setField("receiveCopyrightNum", changeType(completeA.getReceiveCopyrightNum()));
					// 已申请_发明专利数
					s.setField("applyPatentNum", changeType(completeA.getApplyPatentNum()));
					// 已申请_实用新型数
					s.setField("applyUtilityNum", changeType(completeA.getApplyUtilityNum()));
					// 已申请_外观设计数
					s.setField("applyDesignsNum", changeType(completeA.getApplyDesignsNum()));
					// 已申请_国外专利数
					s.setField("applyForeignNum", changeType(completeA.getApplyForeignNum()));
					// 已申请_软件著作权数
					s.setField("applyCopyrightNum", changeType(completeA.getApplyCopyrightNum()));
					// 其他成果
					s.setField("otherOutcomes", changeType(completeA.getOtherOutcomes()));
				}
			}
			
			ps.setFormFlattening(true);
			ps.close();
			FileOutputStream fos = new FileOutputStream(outputPath + "thirdPage.pdf");
			reader.close();
			fos.write(bos.toByteArray());
			fos.close();
			pdfList.add(outputPath + "thirdPage.pdf");

		} catch (IOException e) {
			logger.error("IOException", e);
		} catch (DocumentException e) {
			logger.error("DocumentException", e);
		}
		return pdfList;
	}
	
	/**
	 * @comments 4企业获得资金支持情况PDF
	 * @param templatePath
	 * @param outputPath
	 * @param tacceptance
	 * @param pdfList
	 * @return
	 * @Version 1.0
	 */
	private List<String> createFundsAPdf(String templatePath, String outputPath, Tacceptance tacceptance, List<String> pdfList) {
		try {
			PdfReader reader = new PdfReader(templatePath);
			ByteArrayOutputStream bos = new ByteArrayOutputStream();
			PdfStamper ps = new PdfStamper(reader, bos);
			BaseFont bf = BaseFont.createFont("STSong-Light", "UniGB-UCS2-H", BaseFont.NOT_EMBEDDED);
			AcroFields s = ps.getAcroFields();
			s.addSubstitutionFont(bf);

			if (tacceptance != null) {
				List<TacceptanceFundsA> fundsAList = new ArrayList<TacceptanceFundsA>();
				fundsAList = tacceptanceFundsADao.getTacceptanceFundsAById(tacceptance.getAcceptanceId());
				if (fundsAList != null && fundsAList.size() > 0) {
					TacceptanceFundsA fundsA = fundsAList.get(0);
					// 年度1
					s.setField("fundsYear1", fundsA.getFundsYear1());
					// 年度2
					s.setField("fundsYear2", fundsA.getFundsYear2());
					// 年度3
					s.setField("fundsYear3", fundsA.getFundsYear3());
					// 年度4
					s.setField("fundsYear4", fundsA.getFundsYear4());
					// 计划或专项名称1
					s.setField("fundsPlanname1", fundsA.getFundsPlanname1());
					// 计划或专项名称2
					s.setField("fundsPlanname2", fundsA.getFundsPlanname2());
					// 计划或专项名称3
					s.setField("fundsPlanname3", fundsA.getFundsPlanname3());
					// 计划或专项名称4
					s.setField("fundsPlanname4", fundsA.getFundsPlanname4());
					// 资金额度1
					s.setField("fundsAmount1", changeType(fundsA.getFundsAmount1()));
					// 资金额度2
					s.setField("fundsAmount2", changeType(fundsA.getFundsAmount2()));
					// 资金额度3
					s.setField("fundsAmount3", changeType(fundsA.getFundsAmount3()));
					// 资金额度4
					s.setField("fundsAmount4", changeType(fundsA.getFundsAmount4()));
					// 项目产业化进展情况
					s.setField("transformationCase", fundsA.getTransformationCase());
					// 项目实施管理、团队培养情况
					s.setField("teamTrainingSituation", fundsA.getTeamTrainingSituation());
					// 项目社会效益说明
					s.setField("socialBenefitsDescription", fundsA.getSocialBenefitsDescription());
				}
			}
			
			ps.setFormFlattening(true);
			ps.close();
			FileOutputStream fos = new FileOutputStream(outputPath + "fourthPage.pdf");
			reader.close();
			fos.write(bos.toByteArray());
			fos.close();
			pdfList.add(outputPath + "fourthPage.pdf");

		} catch (IOException e) {
			logger.error("IOException", e);
		} catch (DocumentException e) {
			logger.error("DocumentException", e);
		}
		return pdfList;
	}
	
	/**
	 * @comments 5企业发展情况PDF
	 * @param templatePath
	 * @param outputPath
	 * @param tacceptance
	 * @param pdfList
	 * @return
	 * @Version 1.0
	 */
	private List<String> createDevelopingAPdf(String templatePath, String outputPath, Tacceptance tacceptance, List<String> pdfList) {
		try {
			PdfReader reader = new PdfReader(templatePath);
			ByteArrayOutputStream bos = new ByteArrayOutputStream();
			PdfStamper ps = new PdfStamper(reader, bos);
			BaseFont bf = BaseFont.createFont("STSong-Light", "UniGB-UCS2-H", BaseFont.NOT_EMBEDDED);
			AcroFields s = ps.getAcroFields();
			s.addSubstitutionFont(bf);

			if (tacceptance != null) {
				List<TacceptanceDevelopingA> developingAList = new ArrayList<TacceptanceDevelopingA>();
				developingAList = tacceptanceDevelopingADao.getTacceptanceDevelopingAById(tacceptance.getAcceptanceId());
				if (developingAList != null && developingAList.size() > 0) {
					TacceptanceDevelopingA developingA = developingAList.get(0);
					// 立项时_总资产
					s.setField("projectTotal", changeType(developingA.getProjectTotal()));
					// 立项时_企业净利润
					s.setField("projectNet", changeType(developingA.getProjectNet()));
					// 立项时_其中出口创汇
					s.setField("projectExport", changeType(developingA.getProjectExport()));
					// 立项时_企业年总收入
					s.setField("projectSales", changeType(developingA.getProjectSales()));
					// 立项时_企业缴税额
					s.setField("projectTaxableTotal", changeType(developingA.getProjectTaxableTotal()));
					// 立项时_企业年度研发投入
					s.setField("projectRdInvestment", changeType(developingA.getProjectRdInvestment()));
					// 验收时_总资产
					s.setField("acceptanceTotal", changeType(developingA.getAcceptanceTotal()));
					// 验收时_企业净利润
					s.setField("acceptanceNet", changeType(developingA.getAcceptanceNet()));
					// 验收时_其中出口创汇
					s.setField("acceptanceExport", changeType(developingA.getAcceptanceExport()));
					// 验收时_企业年总收入
					s.setField("acceptanceSales", changeType(developingA.getAcceptanceSales()));
					// 验收时_企业缴税额
					s.setField("acceptanceTaxableTotal", changeType(developingA.getAcceptanceTaxableTotal()));
					// 验收时_企业年度研发投入
					s.setField("acceptanceRdInvestment", changeType(developingA.getAcceptanceRdInvestment()));
					
					// 盖章时间
					String stampTime = changeDateType(developingA.getStampTime(), "yyyyMMdd");
					// 盖章时间_年
					s.setField("stampTimeYear", stampTime.substring(0, 4));
					// 盖章时间_月
					s.setField("stampTimeMonth", stampTime.substring(4, 6));
					// 盖章时间_日
					s.setField("stampTimeDay", stampTime.substring(6, 8));
				}
			}
			
			ps.setFormFlattening(true);
			ps.close();
			FileOutputStream fos = new FileOutputStream(outputPath + "fifthPage.pdf");
			reader.close();
			fos.write(bos.toByteArray());
			fos.close();
			pdfList.add(outputPath + "fifthPage.pdf");

		} catch (IOException e) {
			logger.error("IOException", e);
		} catch (DocumentException e) {
			logger.error("DocumentException", e);
		}
		return pdfList;
	}
	
	/**
	 * @comments 6验收意见PDF
	 * @param templatePath
	 * @param outputPath
	 * @param tacceptance
	 * @param pdfList
	 * @return
	 * @Version 1.0
	 */
	private List<String> createAccOpinionAPdf(String templatePath, String outputPath, Tacceptance tacceptance, List<String> pdfList) {
		try {
			PdfReader reader = new PdfReader(templatePath);
			ByteArrayOutputStream bos = new ByteArrayOutputStream();
			PdfStamper ps = new PdfStamper(reader, bos);
			BaseFont bf = BaseFont.createFont("STSong-Light", "UniGB-UCS2-H", BaseFont.NOT_EMBEDDED);
			AcroFields s = ps.getAcroFields();
			s.addSubstitutionFont(bf);

			if (tacceptance != null) {
				List<TacceptanceOpinionA> opinionAList = new ArrayList<TacceptanceOpinionA>();
				opinionAList = tacceptanceOpinionADao.getTacceptanceOpinionAById(tacceptance.getAcceptanceId());
				if (opinionAList != null && opinionAList.size() > 0) {
					TacceptanceOpinionA opinionA = opinionAList.get(0);
					// 验收意见
					s.setField("acceptanceOpinion", opinionA.getAcceptanceOpinion());
					// 验收小组组长
					s.setField("acceptanceLeader", opinionA.getAcceptanceLeader());
					// 验收小组副组长1
					s.setField("acceptanceDeputyLeader1", opinionA.getAcceptanceDeputyLeader1());
					// 验收小组副组长2
					s.setField("acceptanceDeputyLeader2", opinionA.getAcceptanceDeputyLeader2());
					
					// 验收时间
					String acceptanceTime = changeDateType(opinionA.getAcceptanceTime(), "yyyyMMdd");
					// 验收时间_年
					s.setField("acceptanceTimeYear", acceptanceTime.substring(0, 4));
					// 验收时间_月
					s.setField("acceptanceTimeMonth", acceptanceTime.substring(4, 6));
					// 验收时间_日
					s.setField("acceptanceTimeDay", acceptanceTime.substring(6, 8));
				}
			}
			
			ps.setFormFlattening(true);
			ps.close();
			FileOutputStream fos = new FileOutputStream(outputPath + "sixthPage.pdf");
			reader.close();
			fos.write(bos.toByteArray());
			fos.close();
			pdfList.add(outputPath + "sixthPage.pdf");

		} catch (IOException e) {
			logger.error("IOException", e);
		} catch (DocumentException e) {
			logger.error("DocumentException", e);
		}
		return pdfList;
	}
	
	/**
	 * @comments 7单位意见PDF
	 * @param templatePath
	 * @param outputPath
	 * @param tacceptance
	 * @param pdfList
	 * @return
	 * @Version 1.0
	 */
	private List<String> createDeptOpinionAPdf(String templatePath, String outputPath, Tacceptance tacceptance, List<String> pdfList) {
		try {
			PdfReader reader = new PdfReader(templatePath);
			ByteArrayOutputStream bos = new ByteArrayOutputStream();
			PdfStamper ps = new PdfStamper(reader, bos);
			BaseFont bf = BaseFont.createFont("STSong-Light", "UniGB-UCS2-H", BaseFont.NOT_EMBEDDED);
			AcroFields s = ps.getAcroFields();
			s.addSubstitutionFont(bf);

			if (tacceptance != null) {
				List<TacceptanceOpinionA> opinionAList = new ArrayList<TacceptanceOpinionA>();
				opinionAList = tacceptanceOpinionADao.getTacceptanceOpinionAById(tacceptance.getAcceptanceId());
				if (opinionAList != null && opinionAList.size() > 0) {
					TacceptanceOpinionA opinionA = opinionAList.get(0);
					// 主持验收单位意见
					s.setField("presideOpinion", opinionA.getPresideOpinion());
					// 主持领导签字
					s.setField("presideLeader", opinionA.getPresideLeader());
					// 组织验收单位意见
					s.setField("organizeOpinion", opinionA.getOrganizeOpinion());
					// 组织领导签字
					s.setField("organizeLeader", opinionA.getOrganizeLeader());
					
					// 主持意见填写时间
					String presideTime = changeDateType(opinionA.getPresideTime(), "yyyyMMdd");
					// 主持意见填写时间_年
					s.setField("presideTimeYear", presideTime.substring(0, 4));
					// 主持意见填写时间_月
					s.setField("presideTimeMonth", presideTime.substring(4, 6));
					// 主持意见填写时间_日
					s.setField("presideTimeDay", presideTime.substring(6, 8));
					// 组织意见填写时间
					String organizeTime = changeDateType(opinionA.getOrganizeTime(), "yyyyMMdd");
					// 组织意见填写时间_年
					s.setField("organizeTimeYear", organizeTime.substring(0, 4));
					// 组织意见填写时间_月
					s.setField("organizeTimeMonth", organizeTime.substring(4, 6));
					// 组织意见填写时间_日
					s.setField("organizeTimeDay", organizeTime.substring(6, 8));
				}
			}
			
			ps.setFormFlattening(true);
			ps.close();
			FileOutputStream fos = new FileOutputStream(outputPath + "seventhPage.pdf");
			reader.close();
			fos.write(bos.toByteArray());
			fos.close();
			pdfList.add(outputPath + "seventhPage.pdf");

		} catch (IOException e) {
			logger.error("IOException", e);
		} catch (DocumentException e) {
			logger.error("DocumentException", e);
		}
		return pdfList;
	}
	
	/**
	 * @comments 8项目主要参加人员名单PDF
	 * @param templatePath
	 * @param outputPath
	 * @param tacceptance
	 * @param pdfList
	 * @return
	 * @Version 1.0
	 */
	private List<String> createMainAPdf(String templatePath, String outputPath, Tacceptance tacceptance, List<String> pdfList) {
		// 每页行数
		int pageSize = 13;
		try {
			if (tacceptance != null) {
				List<TacceptanceMainA> mainAList = new ArrayList<TacceptanceMainA>();
				mainAList = tacceptanceMainADao.getTacceptanceMainAById(tacceptance.getAcceptanceId());
				if (mainAList != null && mainAList.size() > 0) {
					// 总循环数
					int maxPage = getMaxPage(mainAList.size(), pageSize);
					for(int i=0; i<maxPage; i++){
						PdfReader reader = new PdfReader(templatePath);
						ByteArrayOutputStream bos = new ByteArrayOutputStream();
						PdfStamper ps = new PdfStamper(reader, bos);
						BaseFont bf = BaseFont.createFont("STSong-Light", "UniGB-UCS2-H", BaseFont.NOT_EMBEDDED);
						AcroFields s = ps.getAcroFields();
						s.addSubstitutionFont(bf);
						
						// 每页记录数
						int maxSize = 0;
						// 最后一页的场合
						if(i == maxPage - 1){
							maxSize = mainAList.size() - i * pageSize;
						} else {
							maxSize = pageSize;
						}
						// 填充每页数据
						for(int j=0; j<maxSize; j++){
							TacceptanceMainA mainA = mainAList.get(i * pageSize + j);
							// 序号
							s.setField("mainNo_" + j, changeType(i * pageSize + j + 1));
							// 姓名
							s.setField("name_" + j, mainA.getName());
							// 性别
							if("1".equals(mainA.getSex())){
								s.setField("sex_" + j, "男");
							} else if("2".equals(mainA.getSex())){
								s.setField("sex_" + j, "女");
							}
							// 出生年月
							s.setField("birthday_" + j, changeDateType(mainA.getBirthday(), "yyyy-MM"));
							// 技术职称
							s.setField("technicalTitles_" + j, mainA.getTechnicalTitles());
							// 文化程度
							s.setField("educationLevel_" + j, mainA.getEducationLevel());
							// 工作单位
							s.setField("workUnits_" + j, mainA.getWorkUnits());
							// 在项目中完成的主要工作
							s.setField("mainDuties_" + j, mainA.getMainDuties());
						}
						
						ps.setFormFlattening(true);
						ps.close();
						FileOutputStream fos = new FileOutputStream(outputPath + "eighthPage_" + i + ".pdf");
						reader.close();
						fos.write(bos.toByteArray());
						fos.close();
						pdfList.add(outputPath + "eighthPage_" + i + ".pdf");
					}
				}
			} else {
				PdfReader reader = new PdfReader(templatePath);
				ByteArrayOutputStream bos = new ByteArrayOutputStream();
				PdfStamper ps = new PdfStamper(reader, bos);
				BaseFont bf = BaseFont.createFont("STSong-Light", "UniGB-UCS2-H", BaseFont.NOT_EMBEDDED);
				AcroFields s = ps.getAcroFields();
				s.addSubstitutionFont(bf);

				ps.setFormFlattening(true);
				ps.close();
				FileOutputStream fos = new FileOutputStream(outputPath + "eighthPage.pdf");
				reader.close();
				fos.write(bos.toByteArray());
				fos.close();
				pdfList.add(outputPath + "eighthPage.pdf");
			}

		} catch (IOException e) {
			logger.error("IOException", e);
		} catch (DocumentException e) {
			logger.error("DocumentException", e);
		}
		return pdfList;
	}
	
	/**
	 * @comments 9验收小组名单PDF
	 * @param templatePath
	 * @param outputPath
	 * @param tacceptance
	 * @param pdfList
	 * @return
	 * @Version 1.0
	 */
	private List<String> createAccAPdf(String templatePath, String outputPath, Tacceptance tacceptance, List<String> pdfList) {
		// 每页行数
		int pageSize = 13;
		try {
			if (tacceptance != null) {
				List<TacceptanceAccA> accAList = new ArrayList<TacceptanceAccA>();
				accAList = tacceptanceAccADao.getTacceptanceAccAById(tacceptance.getAcceptanceId());
				if (accAList != null && accAList.size() > 0) {
					// 总循环数
					int maxPage = getMaxPage(accAList.size(), pageSize);
					for(int i=0; i<maxPage; i++){
						PdfReader reader = new PdfReader(templatePath);
						ByteArrayOutputStream bos = new ByteArrayOutputStream();
						PdfStamper ps = new PdfStamper(reader, bos);
						BaseFont bf = BaseFont.createFont("STSong-Light", "UniGB-UCS2-H", BaseFont.NOT_EMBEDDED);
						AcroFields s = ps.getAcroFields();
						s.addSubstitutionFont(bf);
						
						// 每页记录数
						int maxSize = 0;
						// 最后一页的场合
						if(i == maxPage - 1){
							maxSize = accAList.size() - i * pageSize;
						} else {
							maxSize = pageSize;
						}
						// 填充每页数据
						for(int j=0; j<maxSize; j++){
							TacceptanceAccA accA = accAList.get(i * pageSize + j);
							// 序号
							s.setField("accNo_" + j, changeType(i * pageSize + j + 1));
							// 姓名
							s.setField("name_" + j, accA.getName());
							// 性别
							if("1".equals(accA.getSex())){
								s.setField("sex_" + j, "男");
							} else if("2".equals(accA.getSex())){
								s.setField("sex_" + j, "女");
							}
							// 出生年月
							s.setField("birthday_" + j, changeDateType(accA.getBirthday(), "yyyy-MM"));
							// 技术职称
							s.setField("technicalTitles_" + j, accA.getTechnicalTitles());
							// 文化程度
							s.setField("educationLevel_" + j, accA.getEducationLevel());
							// 工作单位
							s.setField("workUnits_" + j, accA.getWorkUnits());
							// 在项目中完成的主要工作
							s.setField("mainDuties_" + j, accA.getMainDuties());
						}
						
						ps.setFormFlattening(true);
						ps.close();
						FileOutputStream fos = new FileOutputStream(outputPath + "ninthPage_" + i + ".pdf");
						reader.close();
						fos.write(bos.toByteArray());
						fos.close();
						pdfList.add(outputPath + "ninthPage_" + i + ".pdf");
					}
				}
			} else {
				PdfReader reader = new PdfReader(templatePath);
				ByteArrayOutputStream bos = new ByteArrayOutputStream();
				PdfStamper ps = new PdfStamper(reader, bos);
				BaseFont bf = BaseFont.createFont("STSong-Light", "UniGB-UCS2-H", BaseFont.NOT_EMBEDDED);
				AcroFields s = ps.getAcroFields();
				s.addSubstitutionFont(bf);
				
				ps.setFormFlattening(true);
				ps.close();
				FileOutputStream fos = new FileOutputStream(outputPath + "ninthPage.pdf");
				reader.close();
				fos.write(bos.toByteArray());
				fos.close();
				pdfList.add(outputPath + "ninthPage.pdf");
			}

		} catch (IOException e) {
			logger.error("IOException", e);
		} catch (DocumentException e) {
			logger.error("DocumentException", e);
		}
		return pdfList;
	}
	
	/**
	 * @comments 10项目验收经费登记表PDF
	 * @param templatePath
	 * @param outputPath
	 * @param tacceptance
	 * @param pdfList
	 * @return
	 * @Version 1.0
	 */
	private List<String> createAccFundsAPdf(String templatePath, String outputPath, Tacceptance tacceptance, List<String> pdfList) {
		try {
			PdfReader reader = new PdfReader(templatePath);
			ByteArrayOutputStream bos = new ByteArrayOutputStream();
			PdfStamper ps = new PdfStamper(reader, bos);
			BaseFont bf = BaseFont.createFont("STSong-Light", "UniGB-UCS2-H", BaseFont.NOT_EMBEDDED);
			AcroFields s = ps.getAcroFields();
			s.addSubstitutionFont(bf);

			if (tacceptance != null) {
				TprojectInfoA tprojectInfoA = new TprojectInfoA();
				// 根据项目ID查询项目基本信息
				List<TprojectInfoA> tprojectInfoAList = new ArrayList<TprojectInfoA>();
				tprojectInfoAList = tprojectInfoADao.getList("tprojectApplication.projectId", tacceptance.getTprojectApplication().getProjectId());
				if(tprojectInfoAList != null && tprojectInfoAList.size() > 0){
					tprojectInfoA = tprojectInfoAList.get(0);
				}
				
				// 项目名称
				s.setField("projectName", tacceptance.getTprojectApplication().getProjectName());
				// 项目编号
				s.setField("projectNumber", tacceptance.getTprojectApplication().getProjectNumber());
				// 完成年限
				s.setField("fill_52", "完成年限");
				// 承担单位地址
				s.setField("unitAddress", tprojectInfoA.getUnitAddress());
				// 单位负责人
				s.setField("legalPerson", tprojectInfoA.getLegalPerson());
				// 办公电话
				s.setField("legalTel", tprojectInfoA.getLegalTel());
				// 手机
				s.setField("legalPhone", tprojectInfoA.getLegalPhone());
				// 项目负责人
				s.setField("projectPerson", tprojectInfoA.getProjectPerson());
				// 办公电话
				s.setField("personTel", tprojectInfoA.getPersonTel());
				// 手机
				s.setField("personPhone", tprojectInfoA.getPersonPhone());
				
				List<TacceptanceAccFundsA> accFundsAList = new ArrayList<TacceptanceAccFundsA>();
				accFundsAList = tacceptanceAccFundsADao.getTacceptanceAccFundsAById(tacceptance.getAcceptanceId());
				if (accFundsAList != null && accFundsAList.size() > 0) {
					TacceptanceAccFundsA accFundsA = accFundsAList.get(0);
					// 备注1
					s.setField("remark1", accFundsA.getRemark1());
					// 备注2
					s.setField("remark2", accFundsA.getRemark2());
					// 备注3
					s.setField("remark3", accFundsA.getRemark3());
					// 备注4
					s.setField("remark4", accFundsA.getRemark4());
					// 项目总投资_预算
					s.setField("gudgetTotalInvestment", changeType(accFundsA.getGudgetTotalInvestment()));
					// 项目总投资_决算
					s.setField("accountsTotalInvestment", changeType(accFundsA.getAccountsTotalInvestment()));
					// 甲方拨款_预算
					s.setField("gudgetPartyFunding", changeType(accFundsA.getGudgetPartyFunding()));
					// 甲方拨款_决算
					s.setField("accountsPartyFunding", changeType(accFundsA.getAccountsPartyFunding()));
					// 其他经费_预算
					s.setField("gudgetOther", changeType(accFundsA.getGudgetOther()));
					// 其他经费_决算
					s.setField("accountsOther", changeType(accFundsA.getAccountsOther()));
					// 单位自筹_预算
					s.setField("gudgetRaised", changeType(accFundsA.getGudgetRaised()));
					// 单位自筹_决算
					s.setField("accountsRaised", changeType(accFundsA.getAccountsRaised()));
					// 银行贷款_预算
					s.setField("gudgetBank", changeType(accFundsA.getGudgetBank()));
					// 银行贷款_决算
					s.setField("accountsBank", changeType(accFundsA.getAccountsBank()));
					// 年度1
					s.setField("year1", accFundsA.getYear1());
					// 年度2
					s.setField("year2", accFundsA.getYear2());
					// 年度3
					s.setField("year3", accFundsA.getYear3());
					// 人员费1
					s.setField("staffCosts1", changeType(accFundsA.getStaffCosts1()));
					// 人员费2
					s.setField("staffCosts2", changeType(accFundsA.getStaffCosts2()));
					// 人员费3
					s.setField("staffCosts3", changeType(accFundsA.getStaffCosts3()));
					// 人员费_合计
					s.setField("staffCostsTotal", changeType(accFundsA.getStaffCostsTotal()));
					// 设备费1
					s.setField("deviceCosts1", changeType(accFundsA.getDeviceCosts1()));
					// 设备费2
					s.setField("deviceCosts2", changeType(accFundsA.getDeviceCosts2()));
					// 设备费3
					s.setField("deviceCosts3", changeType(accFundsA.getDeviceCosts3()));
					// 设备费_合计
					s.setField("deviceCostsTotal", changeType(accFundsA.getDeviceCostsTotal()));
					// 能源材料费1
					s.setField("energyCosts1", changeType(accFundsA.getEnergyCosts1()));
					// 能源材料费2
					s.setField("energyCosts2", changeType(accFundsA.getEnergyCosts2()));
					// 能源材料费3
					s.setField("energyCosts3", changeType(accFundsA.getEnergyCosts3()));
					// 能源材料费_合计
					s.setField("energyCostsTotal", changeType(accFundsA.getEnergyCostsTotal()));
					// 试验外协费1
					s.setField("experimentCosts1", changeType(accFundsA.getExperimentCosts1()));
					// 试验外协费2
					s.setField("experimentCosts2", changeType(accFundsA.getExperimentCosts2()));
					// 试验外协费3
					s.setField("experimentCosts3", changeType(accFundsA.getExperimentCosts3()));
					// 试验外协费_合计
					s.setField("experimentCostsTotal", changeType(accFundsA.getExperimentCostsTotal()));
					// 调研费1
					s.setField("researchCosts1", changeType(accFundsA.getResearchCosts1()));
					// 调研费2
					s.setField("researchCosts2", changeType(accFundsA.getResearchCosts2()));
					// 调研费3
					s.setField("researchCosts3", changeType(accFundsA.getResearchCosts3()));
					// 调研费_合计
					s.setField("researchCostsTotal", changeType(accFundsA.getResearchCostsTotal()));
					// 差旅费1
					s.setField("travelCosts1", changeType(accFundsA.getTravelCosts1()));
					// 差旅费2
					s.setField("travelCosts2", changeType(accFundsA.getTravelCosts2()));
					// 差旅费3
					s.setField("travelCosts3", changeType(accFundsA.getTravelCosts3()));
					// 差旅费_合计
					s.setField("travelCostsTotal", changeType(accFundsA.getTravelCostsTotal()));
					// 会议费1
					s.setField("meetingCosts1", changeType(accFundsA.getMeetingCosts1()));
					// 会议费2
					s.setField("meetingCosts2", changeType(accFundsA.getMeetingCosts2()));
					// 会议费3
					s.setField("meetingCosts3", changeType(accFundsA.getMeetingCosts3()));
					// 会议费_合计
					s.setField("meetingCostsTotal", changeType(accFundsA.getMeetingCostsTotal()));
					// 管理费1
					s.setField("manageCosts1", changeType(accFundsA.getManageCosts1()));
					// 管理费2
					s.setField("manageCosts2", changeType(accFundsA.getManageCosts2()));
					// 管理费3
					s.setField("manageCosts3", changeType(accFundsA.getManageCosts3()));
					// 管理费_合计
					s.setField("manageCostsTotal", changeType(accFundsA.getManageCostsTotal()));
					// 项目负责人签字
					s.setField("projectManager", accFundsA.getProjectManager());
					// 项目单位负责人签字
					s.setField("unitManager", accFundsA.getUnitManager());
					// 项目验收时间
					s.setField("acceptanceTime", changeDateType(accFundsA.getAcceptanceTime(), "yyyy年MM月dd日"));
					// 验收形式
					s.setField("acceptanceStyle", accFundsA.getAcceptanceStyle());
					// 验收结果
					s.setField("acceptanceResult", accFundsA.getAcceptanceResult());
					// 项目验收部门签字
					s.setField("acceptanceDepartment", accFundsA.getAcceptanceDepartment());
				}
			}
			
			ps.setFormFlattening(true);
			ps.close();
			FileOutputStream fos = new FileOutputStream(outputPath + "tenthPage.pdf");
			reader.close();
			fos.write(bos.toByteArray());
			fos.close();
			pdfList.add(outputPath + "tenthPage.pdf");

		} catch (IOException e) {
			logger.error("IOException", e);
		} catch (DocumentException e) {
			logger.error("DocumentException", e);
		}
		return pdfList;
	}
	
	/**
	 * @comments 非高新验收提交材料集合
	 * @param acceptanceId
	 * @return
	 * @Version 1.0
	 */
	public List<Map<String, Object>> getSubmitOtherAcceptanceList(String acceptanceId) {
		List<Map<String, Object>> submitOtherAcceptanceList = new ArrayList<Map<String, Object>>();
		Map<String, Object> valueMap = null;
		Tacceptance tacceptance = acceptanceDao.get(acceptanceId);
		/* 1非高新 项目验收申请表封皮 */
		valueMap = new HashMap<String, Object>();
		valueMap.put("name", mitemDao.getItemName(Constants.ACCEPTANCE_XM_01));
		if (tacceptance != null) {
			valueMap.put("isExist", "是");
			valueMap.put("isKey", "1");
		} else {
			valueMap.put("isExist", "否");
			valueMap.put("isKey", "0");
		}
		submitOtherAcceptanceList.add(valueMap);
		
		/* 2项目经费落实和使用情况 */
		valueMap = new HashMap<String, Object>();
		valueMap.put("name", mitemDao.getItemName(Constants.ACCEPTANCE_XM_02));
		TacceptanceImplementationB tacceptanceImplementationB = tacceptanceImplementationBDao.get(
				"tacceptance.acceptanceId", acceptanceId);
		if (tacceptanceImplementationB != null) {
			valueMap.put("isExist", "是");
			valueMap.put("isKey", "1");
		} else {
			valueMap.put("isExist", "否");
			valueMap.put("isKey", "0");
		}
		submitOtherAcceptanceList.add(valueMap);
		
		/* 3项目取得成果情况 */
		valueMap = new HashMap<String, Object>();
		valueMap.put("name", mitemDao.getItemName(Constants.ACCEPTANCE_XM_03));
		TacceptanceAchievementB tacceptanceAchievementB = tacceptanceAchievementBDao.get(
				"tacceptance.acceptanceId", acceptanceId);
		if (tacceptanceAchievementB != null) {
			valueMap.put("isExist", "是");
			valueMap.put("isKey", "1");
		} else {
			valueMap.put("isExist", "否");
			valueMap.put("isKey", "0");
		}
		submitOtherAcceptanceList.add(valueMap);
		
		/* 4项目总结说明 */
		valueMap = new HashMap<String, Object>();
		valueMap.put("name", mitemDao.getItemName(Constants.ACCEPTANCE_XM_04));
		TacceptanceSummaryB tacceptanceSummaryB = tacceptanceSummaryBDao.get(
				"tacceptance.acceptanceId", acceptanceId);
		if (tacceptanceSummaryB != null) {
			valueMap.put("isExist", "是");
			valueMap.put("isKey", "1");
		} else {
			valueMap.put("isExist", "否");
			valueMap.put("isKey", "0");
		}
		submitOtherAcceptanceList.add(valueMap);
		
		/* 5附件清单 */
		valueMap = new HashMap<String, Object>();
		valueMap.put("name", mitemDao.getItemName(Constants.ACCEPTANCE_XM_05));
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("tableName", Tacceptance.class);
		paramMap.put("key1", acceptanceId);
		List<Tattachment> attList = tattachmentDao
				.getAttachmentsByForeignKey(paramMap);
		if (attList != null && attList.size() > 0) {
			valueMap.put("isExist", "是");
			valueMap.put("isKey", "1");
		} else {
			valueMap.put("isExist", "否");
			valueMap.put("isKey", "0");
		}
		submitOtherAcceptanceList.add(valueMap);
		
		return submitOtherAcceptanceList;
	}
	
	/**
	 * @comments 提交非高新验收
	 * @param templatePath
	 * @param outputPath 
	 * @param acceptanceId
	 * @Version 1.0
	 */
	public void saveSubmitOtherAcceptance(String submitFlag, String acceptanceId) {
		Tacceptance tacceptance = acceptanceDao.get(acceptanceId);

		// 更新验收表的内容
		// 验收状态
		if("1".equals(submitFlag)){
			// 验收合格
			tacceptance.setAcceptanceStatus(Constants.ACCEPTANCE_PASS);
		} else if("2".equals(submitFlag)) {
			// 验收基本合格
			tacceptance.setAcceptanceStatus(Constants.ACCEPTANCE_BASIC_PASS);
		} else if("3".equals(submitFlag)) {
			// 验收不合格
			tacceptance.setAcceptanceStatus(Constants.ACCEPTANCE_NOPASS);
		} else {
			// 结题
			tacceptance.setAcceptanceStatus(Constants.ACCEPTANCE_END);
		}
		// 更新日期
		Date nowDate = new Date();
		tacceptance.setUpdateDate(new Timestamp(nowDate.getTime()));
		// 提交时间
		tacceptance.setAcceptanceDate(new Timestamp(nowDate.getTime()));

		acceptanceDao.update(tacceptance);
	}
	
	/**
	 * @comments 打印非高新验收
	 * @param inputPath
	 * @param outputPash 
	 * @param acceptanceId
	 * @Version 1.0
	 */
	public String printOtherAcceptance(String templatePath, String outputPath,
			String acceptanceId) {
		Tacceptance tacceptance = acceptanceDao.get(acceptanceId);
		String dd = String.valueOf(System.currentTimeMillis());
		List<String> pdfList = new ArrayList<String>();

		templatePath = templatePath + "acceptance-pro";
		pdfList = this.createAcceptancePdf(templatePath + "-01.pdf",
				outputPath, tacceptance, pdfList);
		pdfList = this.createImplementationB(templatePath + "-02.pdf",
				outputPath, tacceptance, pdfList);
		pdfList = this.createAchievementB(templatePath + "-03.pdf", 
				outputPath,tacceptance, pdfList);
		pdfList = this.createSummaryB1(templatePath + "-04.pdf", 
				outputPath,tacceptance, pdfList);
		pdfList = this.createSummaryB2(templatePath + "-05.pdf", 
				outputPath,tacceptance, pdfList);
		pdfList = this.createSummaryB3(templatePath + "-06.pdf", 
				outputPath,tacceptance, pdfList);
		pdfList = this.createSummaryB4(templatePath + "-07.pdf", 
				outputPath,tacceptance, pdfList);
		templatePath = templatePath + "PRO" + acceptanceId + ".pdf";
		outputPath = outputPath + "PRO" + acceptanceId + dd + ".pdf";
		
		this.mergerPdf(pdfList, templatePath);
		this.addPage(templatePath, outputPath);
		this.deleteTempPdf(pdfList);
		return outputPath;
	}
	/**
	 * @comments 1项目验收申请表封皮PDF
	 * @param templatePath
	 * @param outputPath
	 * @param tacceptance
	 * @param pdfList
	 * @return
	 * @Version 1.0
	 */
	private List<String> createAcceptancePdf(String templatePath,
			String outputPath, Tacceptance tacceptance, List<String> pdfList) {
		try {
			PdfReader reader = new PdfReader(templatePath);
			ByteArrayOutputStream bos = new ByteArrayOutputStream();
			PdfStamper ps = new PdfStamper(reader, bos);
			BaseFont bf = BaseFont.createFont("STSong-Light", "UniGB-UCS2-H",
					BaseFont.NOT_EMBEDDED);
			AcroFields s = ps.getAcroFields();
			s.addSubstitutionFont(bf);

			if (tacceptance != null) {
				// 验收信息
				// 资助金额
				s.setField("funding", 
						tacceptance.getFunding());
				// 原定完成时间
				if(tacceptance.getScheduledTime()!=null){
					String scheduledTime = new SimpleDateFormat("yyyyMMdd")
					.format(tacceptance.getScheduledTime());
					s.setField("scheduledTimeYear", scheduledTime.substring(0, 4));
					s.setField("scheduledTimeMonth", scheduledTime.substring(4, 6));
					s.setField("scheduledTimeDay", scheduledTime.substring(6, 8));
				}
				// 实际完成时间
				if(tacceptance.getScheduledTime()!=null){
					String actualTime = new SimpleDateFormat("yyyyMMdd")
					.format(tacceptance.getScheduledTime());
					s.setField("actualTimeYear", actualTime.substring(0, 4));
					s.setField("actualTimeMonth", actualTime.substring(4, 6));
					s.setField("actualTimeDay", actualTime.substring(6, 8));
				}
				// 项目负责人 -单位
				s.setField("responsibleUnit", 
						tacceptance.getResponsibleUnit());
				// 项目负责人 -职称/职务
				s.setField("responsibleJob", 
						tacceptance.getResponsibleJob());
			
				// 项目联系人 -单位
				s.setField("touchUnit", 
						tacceptance.getTouchUnit());
				// 项目联系人 -职称/职务
				s.setField("touchJob", 
						tacceptance.getTouchJob());
				
				// 项目信息
				TprojectApplication tprojectApplication = tacceptance.getTprojectApplication();
				if(tprojectApplication != null){
					
				// 项目名称
				s.setField("projectName", tprojectApplication.getProjectName());
				// 项目编号
				s.setField("projectNumber", tprojectApplication.getProjectNumber());
				
				// 计划类别
				s.setField("planFlag", tprojectApplication.getPlanFlagName());
				// 项目承担单位
				s.setField("applicationUnit", tprojectApplication.getApplicationUnit());
			
				// 归口管理单位
				String centralizedType = tprojectApplication.getCentralizedType();
				if(centralizedType!=null&&centralizedType.length()>0){
					s.setField("centralizedType", mitemDao.getItemName(centralizedType));
				}
				/*s.setField("centralizedType",
						tprojectApplication.getCentralizedType());*/
				// 项目起始时间
				if(tprojectApplication.getStartTime()!=null){
					String startTime = new SimpleDateFormat("yyyyMMdd")
					.format(tprojectApplication.getStartTime());
					s.setField("startTimeYear", startTime.substring(0, 4));
					s.setField("startTimeMonth", startTime.substring(4, 6));
					}
				}
				// 基本信息
				TprojectInfoB tprojectInfoB = tprojectInfoBDao.get("tprojectApplication.projectId",tacceptance.getTprojectApplication().getProjectId()); 	
				if(tprojectInfoB != null){	
					
					// 协作单位
					s.setField("assistUnit",
							tprojectInfoB.getAssistUnit());
					// 项目负责人 -姓名
					s.setField("projectPerson", 
							tprojectInfoB.getProjectPerson());
				
					// 项目负责人 -电话
					s.setField("personTel",
							tprojectInfoB.getPersonTel());
					// 项目联系人 -姓名
					s.setField("touchPerson", 
							tprojectInfoB.getTouchPerson());
					
					// 项目联系人 -电话
					s.setField("touchPerson", 
							tprojectInfoB.getTouchPerson());
				}
				TreviewComments treviewComments = treviewCommentsDao.get("tprojectApplication.projectId",tacceptance.getTprojectApplication().getProjectId());
				if(treviewComments != null){
				// 项目承担单位意见
				s.setField("reportingUnits", 
						treviewComments.getReportingUnits());
				// 协作单位意见
				s.setField("cooperativeUnits", 
						treviewComments.getCooperativeUnits());
				// 项目归口管理部门意见
				s.setField("centralizedUnits", 
						treviewComments.getCentralizedUnits());
				// 市科技局项目主管处室意见
				s.setField("scienceUnits", 
						treviewComments.getScienceUnits());
				}
			}
				
		
			ps.setFormFlattening(true);
			ps.close();
			FileOutputStream fos = new FileOutputStream(outputPath
					+ "firstPage.pdf");
			reader.close();
			fos.write(bos.toByteArray());
			fos.close();
			pdfList.add(outputPath + "firstPage.pdf");

		} catch (IOException e) {
			logger.error("IOException", e);
		} catch (DocumentException e) {
			logger.error("DocumentException", e);
		}
		return pdfList;
	}
	/**
	 * @comments 2项目经费落实和使用情况
	 * @param template
	 * @param outputPath
	 * @param tacceptance
	 * @param pdfList
	 * @return
	 * @Version 1.0
	 */
	private List<String> createImplementationB(String templatePath,
			String outputPath, Tacceptance tacceptance, List<String> pdfList) {

		try {
			PdfReader reader = new PdfReader(templatePath);
			ByteArrayOutputStream bos = new ByteArrayOutputStream();
			PdfStamper ps = new PdfStamper(reader, bos);
			BaseFont bf = BaseFont.createFont("STSong-Light", "UniGB-UCS2-H",
					BaseFont.NOT_EMBEDDED);
			AcroFields s = ps.getAcroFields();
			s.addSubstitutionFont(bf);

			if (tacceptance != null) {
				TacceptanceImplementationB timplementationB = tacceptanceImplementationBDao.get(
						"tacceptance.acceptanceId",tacceptance.getAcceptanceId());
				if (timplementationB != null) {
					// 计划数-项目总经费
					s.setField("planFundsTotalNum",
							changeType(timplementationB.getPlanFundsTotalNum()));
					// 实际数-项目总经费
					s.setField("actualFundsTotalNum",
							changeType(timplementationB.getActualFundsTotalNum()));
					// 总经费使用情况-人员费
					s.setField("totalStaffCosts",
							changeType(timplementationB.getTotalStaffCosts()));
					// 市拨经费使用情况-人员费
					s.setField("cityTotalStaffCosts",
							changeType(timplementationB.getCityTotalStaffCosts()));
					// 计划数-市拨经费
					s.setField("planFundsCityNum",
							changeType(timplementationB.getPlanFundsCityNum()));
					// 实际数-市拨经费
					s.setField("actualFundsCityNum",
							changeType(timplementationB.getActualFundsCityNum()));
					// 总经费使用情况-设备费
					s.setField("totalDeviceCosts",
							changeType(timplementationB.getTotalDeviceCosts()));
					// 市拨经费使用情况-设备费
					s.setField("cityDeviceCosts",
							changeType(timplementationB.getCityDeviceCosts()));
					// 计划数-企业自筹
					s.setField("planRaisedNum",
							changeType(timplementationB.getPlanRaisedNum()));
					// 实际数-企业自筹
					s.setField("actualRaisedNum",
							changeType(timplementationB.getActualRaisedNum()));
					// 总经费使用情况-能源材料费
					s.setField("totalEnergyCosts",
							changeType(timplementationB.getTotalEnergyCosts()));
					// 市拨经费使用情况-能源材料费
					s.setField("cityEnergyCosts",
							changeType(timplementationB.getCityEnergyCosts()));
					// 计划数-银行贷款
					s.setField("planBankNum",
							changeType(timplementationB.getPlanBankNum()));
					// 实际数-银行贷款
					s.setField("actualBankNum",
							changeType(timplementationB.getActualBankNum()));
					// 总经费使用情况-试验外协费
					s.setField("totalExperimentCosts",
							changeType(timplementationB.getTotalExperimentCosts()));
					// 市拨经费使用情况-试验外协费
					s.setField("cityExperimentCosts",
							changeType(timplementationB.getCityExperimentCosts()));
					// 计划数-贷款贴息
					s.setField("planLoanInterestNum",
							changeType(timplementationB.getPlanLoanInterestNum()));
					// 实际数-贷款贴息
					s.setField("actualLoanInterestNum",
							changeType(timplementationB.getActualLoanInterestNum()));
					// 总经费使用情况-调研费
					s.setField("totalResearchCosts",
							changeType(timplementationB.getTotalResearchCosts()));
					// 市拨经费使用情况-调研费
					s.setField("cityResearchCosts",
							changeType(timplementationB.getCityResearchCosts()));
					// 计划数-其他拨款
					s.setField("planOtherNum",
							changeType(timplementationB.getPlanOtherNum()));
					// 实际数-其他拨款
					s.setField("actualOtherNum",
							changeType(timplementationB.getActualOtherNum()));
					// 总经费使用情况-差旅费
					s.setField("totalTravelCosts",
							changeType(timplementationB.getTotalTravelCosts()));
					// 市拨经费使用情况-差旅费
					s.setField("cityTravelCosts",
							changeType(timplementationB.getCityTravelCosts()));
					
					// 总经费使用情况-会议费
					s.setField("totalMeetingCosts",
							changeType(timplementationB.getTotalMeetingCosts()));
					// 市拨经费使用情况-会议费
					s.setField("cityMeetingCosts",
							changeType(timplementationB.getCityMeetingCosts()));
					
					// 总经费使用情况-管理费
					s.setField("totalManageCosts",
							changeType(timplementationB.getTotalManageCosts()));
					// 市拨经费使用情况-管理费
					s.setField("cityManageCosts",
							changeType(timplementationB.getCityManageCosts()));
					
					// 总经费使用情况-其它
					s.setField("totalOtherCosts",
							changeType(timplementationB.getTotalOtherCosts()));
					// 市拨经费使用情况-其它
					s.setField("cityOtherCosts",
							changeType(timplementationB.getCityOtherCosts()));
					
					// 总经费使用情况-合计
					s.setField("totalTotalCosts",
							getFormatValue(timplementationB.getTotalTotalCosts()));
					// 市拨经费使用情况-合计
					s.setField("cityTotalCosts",
							getFormatValue(timplementationB.getCityTotalCosts()));
					
					// 合同要求1
					s.setField("contractRequire1",
							changeType(timplementationB.getContractRequire1()));
					// 实际达到情况1
					s.setField("actuallyAchieved1",
							changeType(timplementationB.getActuallyAchieved1()));
					// 合同要求2
					s.setField("contractRequire2",
							changeType(timplementationB.getContractRequire2()));
					// 实际达到情况2
					s.setField("actuallyAchieved2",
							changeType(timplementationB.getActuallyAchieved2()));
					// 合同要求3
					s.setField("contractRequire3",
							changeType(timplementationB.getContractRequire3()));
					// 实际达到情况3
					s.setField("actuallyAchieved3",
							changeType(timplementationB.getActuallyAchieved3()));
					// 合同要求4
					s.setField("contractRequire4",
							changeType(timplementationB.getContractRequire4()));
					// 实际达到情况4
					s.setField("actuallyAchieved4",
							changeType(timplementationB.getActuallyAchieved4()));
					// 合同约定额度-销售收入
					s.setField("conventionsSales",
							changeType(timplementationB.getConventionsSales()));
					// 实际完成额度-销售收入
					s.setField("completeSales",
							changeType(timplementationB.getCompleteSales()));
					
					// 合同约定额度-利润总额
					s.setField("conventionsProfitTotal",
							changeType(timplementationB.getConventionsProfitTotal()));
					// 实际完成额度-利润总额
					s.setField("completeProfitTotal",
							changeType(timplementationB.getCompleteProfitTotal()));
					// 合同约定额度-税收总额
					s.setField("conventionsTaxTotal",
							changeType(timplementationB.getConventionsTaxTotal()));
					// 实际完成额度-税收总额
					s.setField("completeTaxTotal",
							changeType(timplementationB.getCompleteTaxTotal()));
					// 合同约定额度-创汇
					s.setField("conventionsForeignExchange",
							changeType(timplementationB.getConventionsForeignExchange()));
					// 实际完成额度-创汇
					s.setField("completeForeignExchange",
							changeType(timplementationB.getCompleteForeignExchange()));
				}
				ps.setFormFlattening(true);
				ps.close();
				FileOutputStream fos = new FileOutputStream(outputPath
						+ "secondPage.pdf");
				reader.close();
				fos.write(bos.toByteArray());
				fos.close();
				pdfList.add(outputPath + "secondPage.pdf");
			}
		} catch (IOException e) {
			logger.error("IOException", e);
			e.printStackTrace();
		} catch (DocumentException e) {
			logger.error("DocumentException", e);
		}

		return pdfList;
	}
	/**
	 * @comments 3项目取得成果情况 
	 * @param templatePath
	 * @param outputPath
	 * @param tacceptance
	 * @param pdfList
	 * @return
	 * @Version 1.0
	 */
	private List<String> createAchievementB(String templatePath,
			String outputPath, Tacceptance tacceptance, List<String> pdfList) {
		try {
			PdfReader reader = new PdfReader(templatePath);
			ByteArrayOutputStream bos = new ByteArrayOutputStream();
			PdfStamper ps = new PdfStamper(reader, bos);
			BaseFont bf = BaseFont.createFont("STSong-Light", "UniGB-UCS2-H",
					BaseFont.NOT_EMBEDDED);
			AcroFields s = ps.getAcroFields();
			s.addSubstitutionFont(bf);

			if (tacceptance != null) {
				TacceptanceAchievementB tachievementB = tacceptanceAchievementBDao.get(
						"tacceptance.acceptanceId",tacceptance.getAcceptanceId());
				if (tachievementB != null) {
					// 已获得知识产权数量 总数 
					Double havaNumList = tachievementB.getReceiveCopyrightNum().doubleValue()+
										 tachievementB.getReceiveDesignsNum().doubleValue()+
										 tachievementB.getReceiveForeignNum().doubleValue()+
										 tachievementB.getReceivePatentNum().doubleValue()+
										 tachievementB.getReceiveUtilityNum().doubleValue();
					s.setField("havaNumList", getFormatValue(havaNumList));
					// 已申请知识产权数量 总数 
					Double reportNumList = tachievementB.getApplyCopyrightNum().doubleValue()+
										   tachievementB.getApplyDesignsNum().doubleValue()+
										   tachievementB.getApplyForeignNum().doubleValue()+
										   tachievementB.getApplyPatentNum().doubleValue()+
										   tachievementB.getApplyUtilityNum().doubleValue();
					s.setField("reportNumList", getFormatValue(reportNumList));
					// 已获得知识产权数量-发明专利数
					s.setField("receivePatentNum",
							changeType(tachievementB.getReceivePatentNum()));
					// 已申请知识产权数量-发明专利数
					s.setField("applyPatentNum",
							changeType(tachievementB.getApplyPatentNum()));
					// 已获得知识产权数量-实用新型数
					s.setField("receiveUtilityNum",
							changeType(tachievementB.getReceiveUtilityNum()));
					// 已申请知识产权数量-实用新型数
					s.setField("applyUtilityNum",
							changeType(tachievementB.getApplyUtilityNum()));
					// 已获得知识产权数量-外观设计数
					s.setField("receiveDesignsNum",
							changeType(tachievementB.getReceiveDesignsNum()));
					// 已申请知识产权数量-外观设计数
					s.setField("applyDesignsNum",
							changeType(tachievementB.getApplyDesignsNum()));
					// 已获得知识产权数量-软件著作权数
					s.setField("receiveCopyrightNum",
							changeType(tachievementB.getReceiveCopyrightNum()));
					// 已申请知识产权数量-软件著作权数
					s.setField("applyCopyrightNum",
							changeType(tachievementB.getApplyCopyrightNum()));
					// 已获得知识产权数量-国外专利数
					s.setField("receiveForeignNum",
							changeType(tachievementB.getReceiveForeignNum()));
					// 已申请知识产权数量-国外专利数
					s.setField("applyForeignNum",
							changeType(tachievementB.getApplyForeignNum()));
					// 其他成果
					s.setField("otherOutcomes",
							changeType(tachievementB.getOtherOutcomes()));
					// 企业获得国家或省市其他资金支持情况-年度1
					s.setField("fundsYear1",
							changeType(tachievementB.getFundsYear1()));
					// 企业获得国家或省市其他资金支持情况-计划或专项名称1
					s.setField("fundsPlanname1",
							changeType(tachievementB.getFundsPlanname1()));
					// 企业获得国家或省市其他资金支持情况-资金额度1
					s.setField("fundsAmount1",
							changeType(tachievementB.getFundsAmount1()));
					// 企业获得国家或省市其他资金支持情况-年度2
					s.setField("fundsYear2",
							changeType(tachievementB.getFundsYear2()));
					// 企业获得国家或省市其他资金支持情况-计划或专项名称2
					s.setField("fundsPlanname2",
							changeType(tachievementB.getFundsPlanname2()));
					// 企业获得国家或省市其他资金支持情况-资金额度2
					s.setField("fundsAmount2",
							changeType(tachievementB.getFundsAmount2()));
					// 企业融资情况-年度1
					s.setField("companyYear1",
							changeType(tachievementB.getCompanyYear1()));
					// 企业融资情况-融资方1
					s.setField("companyFinanciers1",
							changeType(tachievementB.getCompanyFinanciers1()));
					// 企业融资情况-资金额1
					s.setField("companyAmount1",
							changeType(tachievementB.getCompanyAmount1()));
					// 企业融资情况-年度2
					s.setField("companyYear2",
							changeType(tachievementB.getCompanyYear2()));
					// 企业融资情况-融资方2
					s.setField("companyFinanciers2",
							changeType(tachievementB.getCompanyFinanciers2()));
					// 企业融资情况-资金额2
					s.setField("companyAmount2",
							changeType(tachievementB.getCompanyAmount2()));
					// 立项时-总资产
					s.setField("projectTotal",
							changeType(tachievementB.getProjectTotal()));
					// 验收时-总资产
					s.setField("acceptanceTotal",
							changeType(tachievementB.getAcceptanceTotal()));
					// 立项时-企业年销售收入
					s.setField("projectSales",
							changeType(tachievementB.getProjectSales()));
					// 验收时-企业年销售收入
					s.setField("acceptanceSales",
							changeType(tachievementB.getAcceptanceSales()));
					// 立项时-净资产
					s.setField("projectNet",
							changeType(tachievementB.getProjectNet()));
					// 验收时-净资产
					s.setField("acceptanceNet",
							changeType(tachievementB.getAcceptanceNet()));
					
					// 立项时-企业年主营收入
					s.setField("projectMainIncome",
							changeType(tachievementB.getProjectMainIncome()));
					// 验收时-企业年主营收入
					s.setField("acceptanceMainIncome",
							changeType(tachievementB.getAcceptanceMainIncome()));
					
					// 立项时-企业净利润
					s.setField("projectBusinessNet",
							changeType(tachievementB.getProjectBusinessNet()));
					// 验收时-企业净利润
					s.setField("acceptanceBusinessNet",
							changeType(tachievementB.getAcceptanceBusinessNet()));
					
					// 立项时-企业应纳税总额
					s.setField("projectTaxableTotal",
							changeType(tachievementB.getProjectTaxableTotal()));
					// 验收时-企业应纳税总额
					s.setField("acceptanceTaxableTotal",
							changeType(tachievementB.getAcceptanceTaxableTotal()));
					
					// 立项时-其中出口创汇
					s.setField("projectExport",
							changeType(tachievementB.getProjectExport()));
					// 验收时-其中出口创汇
					s.setField("acceptanceExport",
							changeType(tachievementB.getAcceptanceExport()));
					
					// 立项时-企业实际纳税总额
					s.setField("projectActualTaxTotal",
							changeType(tachievementB.getProjectActualTaxTotal()));
					// 验收时-企业实际纳税总额
					s.setField("acceptanceActualTaxTotal",
							changeType(tachievementB.getAcceptanceActualTaxTotal()));
					// 立项时-企业年度研发投入
					s.setField("projectRdInvestment",
							changeType(tachievementB.getProjectRdInvestment()));
					// 验收时-企业年度研发投入
					s.setField("acceptanceRdInvestment",
							changeType(tachievementB.getAcceptanceRdInvestment()));
					
				}
				ps.setFormFlattening(true);
				ps.close();
				FileOutputStream fos = new FileOutputStream(outputPath
						+ "thirdPage.pdf");
				reader.close();
				fos.write(bos.toByteArray());
				fos.close();
				pdfList.add(outputPath + "thirdPage.pdf");
			}
		} catch (IOException e) {
			logger.error("IOException", e);
			e.printStackTrace();
		} catch (DocumentException e) {
			logger.error("DocumentException", e);
		}

		return pdfList;
	}
	/**
	 * 
	 * @comments 4项目总结说明 -产业化、成果转化情况
	 * @param templatePath
	 * @param outputPath
	 * @param tacceptance
	 * @param pdfList
	 * @return
	 * @version 1.0
	 */
	public List<String> createSummaryB1(String templatePath,
			String outputPath, Tacceptance tacceptance, List<String> pdfList){
		try {
			PdfReader reader = new PdfReader(templatePath);
			ByteArrayOutputStream bos = new ByteArrayOutputStream();
			PdfStamper ps = new PdfStamper(reader, bos);
			BaseFont bf = BaseFont.createFont("STSong-Light", "UniGB-UCS2-H",
					BaseFont.NOT_EMBEDDED);
			AcroFields s = ps.getAcroFields();
			s.addSubstitutionFont(bf);

			if (tacceptance != null) {
				TacceptanceSummaryB tSummaryB = tacceptanceSummaryBDao.get(
						"tacceptance.acceptanceId",tacceptance.getAcceptanceId());
				if (tSummaryB != null) {
					
					// 产业化、成果转化情况-说明
					s.setField("transformationCase",
							changeType(tSummaryB.getTransformationCase()));
				}
				ps.setFormFlattening(true);
				ps.close();
				FileOutputStream fos = new FileOutputStream(outputPath
						+ "forthPage.pdf");
				reader.close();
				fos.write(bos.toByteArray());
				fos.close();
				pdfList.add(outputPath + "forthPage.pdf");
			}
		} catch (IOException e) {
			logger.error("IOException", e);
			e.printStackTrace();
		} catch (DocumentException e) {
			logger.error("DocumentException", e);
		}

		return pdfList;
	}
	/**
	 * 
	 * @comments 5项目总结说明 -项目实施管理、团队培养情况
	 * @param templatePath
	 * @param outputPath
	 * @param tacceptance
	 * @param pdfList
	 * @return
	 * @version 1.0
	 */
	public List<String> createSummaryB2(String templatePath,
			String outputPath, Tacceptance tacceptance, List<String> pdfList){
		try {
			PdfReader reader = new PdfReader(templatePath);
			ByteArrayOutputStream bos = new ByteArrayOutputStream();
			PdfStamper ps = new PdfStamper(reader, bos);
			BaseFont bf = BaseFont.createFont("STSong-Light", "UniGB-UCS2-H",
					BaseFont.NOT_EMBEDDED);
			AcroFields s = ps.getAcroFields();
			s.addSubstitutionFont(bf);

			if (tacceptance != null) {
				TacceptanceSummaryB tSummaryB = tacceptanceSummaryBDao.get(
						"tacceptance.acceptanceId",tacceptance.getAcceptanceId());
				if (tSummaryB != null) {
					
					// 项目实施管理、团队培养情况-说明
					s.setField("teamTrainingSituation",
							changeType(tSummaryB.getTeamTrainingSituation()));
				}
				ps.setFormFlattening(true);
				ps.close();
				FileOutputStream fos = new FileOutputStream(outputPath
						+ "fivePage.pdf");
				reader.close();
				fos.write(bos.toByteArray());
				fos.close();
				pdfList.add(outputPath + "fivePage.pdf");
			}
		} catch (IOException e) {
			logger.error("IOException", e);
			e.printStackTrace();
		} catch (DocumentException e) {
			logger.error("DocumentException", e);
		}

		return pdfList;
	}
	/**
	 * 
	 * @comments 6项目总结说明 -项目社会效益说明
	 * @param templatePath
	 * @param outputPath
	 * @param tacceptance
	 * @param pdfList
	 * @return
	 * @version 1.0
	 */
	public List<String> createSummaryB3(String templatePath,
			String outputPath, Tacceptance tacceptance, List<String> pdfList){
		try {
			PdfReader reader = new PdfReader(templatePath);
			ByteArrayOutputStream bos = new ByteArrayOutputStream();
			PdfStamper ps = new PdfStamper(reader, bos);
			BaseFont bf = BaseFont.createFont("STSong-Light", "UniGB-UCS2-H",
					BaseFont.NOT_EMBEDDED);
			AcroFields s = ps.getAcroFields();
			s.addSubstitutionFont(bf);

			if (tacceptance != null) {
				TacceptanceSummaryB tSummaryB = tacceptanceSummaryBDao.get(
						"tacceptance.acceptanceId",tacceptance.getAcceptanceId());
				if (tSummaryB != null) {
					
					// 项目社会效益说明-说明
					s.setField("socialBenefitsDescription",
							changeType(tSummaryB.getSocialBenefitsDescription()));
				}
				ps.setFormFlattening(true);
				ps.close();
				FileOutputStream fos = new FileOutputStream(outputPath
						+ "sixPage.pdf");
				reader.close();
				fos.write(bos.toByteArray());
				fos.close();
				pdfList.add(outputPath + "sixPage.pdf");
			}
		} catch (IOException e) {
			logger.error("IOException", e);
			e.printStackTrace();
		} catch (DocumentException e) {
			logger.error("DocumentException", e);
		}

		return pdfList;
	}
	/**
	 * 
	 * @comments 7项目总结说明 -项目承担单位真实性承诺
	 * @param templatePath
	 * @param outputPath
	 * @param tacceptance
	 * @param pdfList
	 * @return
	 * @version 1.0
	 */
	public List<String> createSummaryB4(String templatePath,
			String outputPath, Tacceptance tacceptance, List<String> pdfList){
		try {
			PdfReader reader = new PdfReader(templatePath);
			ByteArrayOutputStream bos = new ByteArrayOutputStream();
			PdfStamper ps = new PdfStamper(reader, bos);
			BaseFont bf = BaseFont.createFont("STSong-Light", "UniGB-UCS2-H",
					BaseFont.NOT_EMBEDDED);
			AcroFields s = ps.getAcroFields();
			s.addSubstitutionFont(bf);

			if (tacceptance != null) {
				TacceptanceSummaryB tSummaryB = tacceptanceSummaryBDao.get(
						"tacceptance.acceptanceId",tacceptance.getAcceptanceId());
				if (tSummaryB != null) {
					
					// 项目承担单位真实性承诺-时间
					s.setField("stampTime",
							this.changeDateType(tSummaryB.getStampTime(), "yyyy年MM月dd日"));
					
					
				}
				ps.setFormFlattening(true);
				ps.close();
				FileOutputStream fos = new FileOutputStream(outputPath
						+ "sevenPage.pdf");
				reader.close();
				fos.write(bos.toByteArray());
				fos.close();
				pdfList.add(outputPath + "sevenPage.pdf");
			}
		} catch (IOException e) {
			logger.error("IOException", e);
			e.printStackTrace();
		} catch (DocumentException e) {
			logger.error("DocumentException", e);
		}

		return pdfList;
	}
	/**
	 * @comments PDF合成
	 * @param pdfList
	 * @param outputPath
	 * @return
	 * @Version 1.0
	 */
	private List<String> mergerPdf(List<String> pdfList, String outputPath) {
		String[] files = (String[]) pdfList.toArray(new String[pdfList.size()]);
		try {
			Document document = new Document(
					new PdfReader(files[0]).getPageSize(1));

			FileOutputStream os = new FileOutputStream(outputPath);
			PdfCopy copy = new PdfCopy(document, os);

			document.open();

			for (int i = 0; i < files.length; i++) {
				PdfReader reader = new PdfReader(files[i]);
				int n = reader.getNumberOfPages();
				for (int j = 1; j <= n; j++) {
					document.newPage();
					PdfImportedPage page = copy.getImportedPage(reader, j);
					copy.addPage(page);
				}
				reader.close();
			}

			copy.close();
			document.close();
			pdfList.add(outputPath);
		} catch (IOException e) {
			logger.error("IOException", e);
		} catch (DocumentException e) {
			logger.error("DocumentException", e);
		}
		return pdfList;
	}

	/**
	 * @comments 改变数据类型
	 * @param obj
	 * @return
	 */
	private String changeType(Object obj) {
		String str = "";
		if (obj != null && !"".equals(obj)) {
			str = obj.toString();
		}
		return str;
	}
	/**
	 * @comments 日期类型转换
	 * @param obj
	 * @param format
	 * @return
	 * @Version 1.0
	 */
	private String changeDateType(Object obj, String format) {
		String date = "";
		if (obj != null && !"".equals(obj)) {
			date = new SimpleDateFormat(format).format(obj);
		}
		return date;
	}

	/**
	 * @comments 删除临时PDF
	 * @param pdfList
	 * @param outputPath
	 */
	private void deleteTempPdf(List<String> pdfList) {
		for (int i = 0; i < pdfList.size(); i++) {
			File file = new File(pdfList.get(i));

			// 判断文件是否存在
			if (file.exists()) {
				file.delete();
			}
		}
	}
	
	/**
	 * @comments 增加页码的方法
	 * @param watermark
	 * @param inputPfdFilePath
	 * @param outputPdfFilePath
	 * @Version 1.0
	 */
	private void addPage(String inputPfdFilePath, String outputPdfFilePath) {
		try {
			PdfReader reader = new PdfReader(inputPfdFilePath);
			PdfStamper stamper = new PdfStamper(reader, new FileOutputStream(
					outputPdfFilePath));
			int cnt = 0;
			int total = reader.getNumberOfPages() + 1;
			BaseFont base = BaseFont.createFont("STSong-Light", "UniGB-UCS2-H",
					BaseFont.NOT_EMBEDDED);
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
				under.showTextAligned(PdfContentByte.ALIGN_CENTER, "第" + cnt
						+ "页/共" + (total - 2) + "页", width / 2, 20, 0);
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
	 * @comments 取得循环最大次数
	 * @param size
	 * @param cnt
	 * @return int
	 * @version 1.0
	 */
	private int getMaxPage(int size, int cnt) {
		int num = 0;
		// 判断总行数是否大于一页最大的行数
		if (size == 0) {
			num = 0;
		} else if (size < cnt){
			num = 1;
		} else {
			// 判断总行数是否等于一页最大的行数的倍数
			if (size % cnt == 0) {
				num = size / cnt;
			} else {
				num = (size / cnt) + 1;
			}
		}
		return num;
	}
	
	/**
	 * Double数据转换成格式正确的字符
	 * @comments 
	 * @param dValue
	 * @return
	 * @version 1.0
	 */
	private String getFormatValue(Double dValue){
		String stringValue = BigDecimal.valueOf(dValue).toString().trim();
		if(stringValue.indexOf(".")>1){
			String[] temp = stringValue.split("\\.");
			if(temp[1].length()>2){
				stringValue = BigDecimal.valueOf(dValue).setScale(2, BigDecimal.ROUND_HALF_UP).toString();
			}
		}
		return stringValue;
	}

	/**
	 * 
	 * @comments 非高新验收封皮保存 
	 * @param tacceptance
	 * @version 1.0
	 */
	public void saveOtherAcceptance(Tacceptance tacceptance) {
		Tacceptance tacceptancetemp = new Tacceptance();
		tacceptancetemp.setFunding(tacceptance.getFunding());
		tacceptancetemp.setScheduledTime(tacceptance.getScheduledTime());
		tacceptancetemp.setActualTime(tacceptance.getActualTime());
		tacceptancetemp.setTouchUnit(tacceptance.getTouchUnit());
		tacceptancetemp.setTouchJob(tacceptance.getTouchJob());
		tacceptancetemp.setResponsibleUnit(tacceptance.getResponsibleUnit());
		tacceptancetemp.setResponsibleJob(tacceptance.getResponsibleJob());
		tacceptancetemp.setCreateTime(new java.sql.Timestamp(new java.util.Date().getTime()));
		//tacceptancetemp.setCreateUser();
		tacceptancetemp.setAcceptanceStatus(Constants.ACCEPTANCE_WRITE);
		acceptanceDao.save(tacceptancetemp);
		
		
	}

	/**
	 * 
	 * @comments 非高新验收封皮修改
	 * @param tacceptance
	 * @version 1.0
	 */
	public void updateOtherAcceptance(Tacceptance tacceptance) {
		Tacceptance tacceptancetemp = acceptanceDao.get(tacceptance.getAcceptanceId());
		tacceptancetemp.setFunding(tacceptance.getFunding());
		tacceptancetemp.setScheduledTime(tacceptance.getScheduledTime());
		tacceptancetemp.setActualTime(tacceptance.getActualTime());
		tacceptancetemp.setTouchUnit(tacceptance.getTouchUnit());
		tacceptancetemp.setTouchJob(tacceptance.getTouchJob());
		tacceptancetemp.setResponsibleUnit(tacceptance.getResponsibleUnit());
		tacceptancetemp.setResponsibleJob(tacceptance.getResponsibleJob());
		tacceptancetemp.setUpdateDate(new java.sql.Timestamp(new java.util.Date().getTime()));
		//tacceptancetemp.setUpdateUser();
		tacceptancetemp.setAcceptanceStatus(Constants.ACCEPTANCE_WRITE);
		
		acceptanceDao.update(tacceptancetemp);
	}
}
