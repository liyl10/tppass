/*************** 版权声明***************
 *
 * Copyright (C) 2012 西安辉盛科技发展有限责任公司.
 *
 ********************************************
 */
package com.hopsun.tppas.api.superadmin.action;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
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
import jxl.write.NumberFormat;
import jxl.write.WritableCellFormat;
import jxl.write.WritableFont;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;

import org.apache.poi.hwpf.HWPFDocument;
import org.apache.poi.hwpf.model.FieldsDocumentPart;
import org.apache.poi.hwpf.usermodel.Field;
import org.apache.poi.hwpf.usermodel.Fields;
import org.apache.poi.hwpf.usermodel.Range;
import org.apache.struts2.ServletActionContext;

import com.hopsun.framework.base.action.BaseAction;
import com.hopsun.scenter.entity.ScUsers;
import com.hopsun.tppas.api.expert.service.TexpertService;
import com.hopsun.tppas.api.report.service.TgroupExpertRealtionService;
import com.hopsun.tppas.api.report.service.TprojectApplicationService;
import com.hopsun.tppas.api.report.service.TprojectGroupService;
import com.hopsun.tppas.api.superadmin.service.MitemService;
import com.hopsun.tppas.api.superadmin.service.TexpertReviewCommentsService;
import com.hopsun.tppas.api.superadmin.service.TprojectTypeManagerService;
import com.hopsun.tppas.common.Constants;
import com.hopsun.tppas.common.FileDownLoad;
import com.hopsun.tppas.entity.Mitem;
import com.hopsun.tppas.entity.Texpert;
import com.hopsun.tppas.entity.TexpertReviewComments;
import com.hopsun.tppas.entity.TgroupExpertRealtion;
import com.hopsun.tppas.entity.TprojectApplication;
import com.hopsun.tppas.entity.TprojectGroup;

/**
 * @comments word文件下载
 * @author wanglw
 * @date 2013-9-25 @time 上午10:55:17
 * @Version 1.0
 */
public class WorddocDownloadAction extends BaseAction {

	private static final long serialVersionUID = 7396106283239831382L;

	@Resource
	private MitemService mitemService;
	
	@Resource
	private TprojectGroupService tprojectGroupService;
	
	@Resource
	private TprojectApplicationService tprojectApplicationService;
	@Resource
	private TprojectTypeManagerService tprojectTypeManagerService;
	@Resource
	private TexpertReviewCommentsService texpertReviewCommentsService;
	@Resource
	private TgroupExpertRealtionService tgroupExpertRealtionService;
	@Resource
	private TexpertService texpertService;
	
	/** 项目ID */
	private String projectId;
	/** 分组id */
	private String groupId;

	/**
	 * @comments 评审意见表下载
	 * @throws ServletException
	 * @throws IOException
	 * @Version 1.0
	 */
	public void downloadWord() throws ServletException, IOException {

		// 取得登录用户的信息
		HttpSession session = this.getRequest().getSession();
		ScUsers user = (ScUsers) session.getAttribute("sysUser");
		if (user != null && user.getUserId() != null && !"".equals(user.getUserId())) {
			try {

				HttpServletResponse response = ServletActionContext.getResponse();

				// 取得配置的文件下载路径
				Mitem mitem = mitemService.get(Constants.WORD_DOWNLOAD_PATH);

				// 读取word模板文件
				String fileDir = mitem.getItemDesc();
				FileInputStream in = new FileInputStream(new File(fileDir + this.getText("word_download_name")));

				// SequenceInputStream ss = new SequenceInputStream(in, in);

				HWPFDocument hdt = new HWPFDocument(in);

				FileInputStream in1 = new FileInputStream(new File(fileDir + this.getText("word_download_name")));

				// SequenceInputStream ss = new SequenceInputStream(in, in);

				HWPFDocument hdt1 = new HWPFDocument(in1);

				Fields fields = hdt.getFields();

				Iterator<Field> it = fields.getFields(FieldsDocumentPart.MAIN).iterator();
				while (it.hasNext()) {
					System.out.println(it.next().getType());
				}

				// 替换读取到的word模板内容的指定字段
				Range range = hdt.getRange();
				Map<String, String> map = new HashMap<String, String>();

				if (projectId != null && !"".equals(projectId)) {

					// 取得项目基本信息
					TprojectApplication tprojectApplication = tprojectApplicationService.get(projectId);

					String planType = tprojectApplication.getPlanFlagName();

					if (planType != null && !"".equals(planType)) {
						// 计划类别
						map.put("planType", planType);
					} else {
						map.put("planType", "");
					}

					String projectName = tprojectApplication.getProjectName();
					if (projectName != null && !"".equals(projectName)) {
						// 项目名称
						map.put("projectName", projectName);
					} else {

						map.put("projectName", "");
					}

					String applicationUnit = tprojectApplication.getApplicationUnit();
					if (applicationUnit != null && !"".equals(applicationUnit)) {
						// 申请单位
						map.put("applicationUnit", applicationUnit);
					} else {
						map.put("applicationUnit", "");
					}

					String projectNumber = tprojectApplication.getProjectNumber();
					if (projectNumber != null && !"".equals(projectNumber)) {
						// 项目编号
						map.put("projectNumber", projectNumber);
					} else {
						map.put("projectNumber", "");
					}

				} else {
					// 计划类别
					map.put("planType", "");
					// 项目名称
					map.put("projectName", "");
					// 申请单位
					map.put("applicationUnit", "");
					// 项目编号
					map.put("projectNumber", "");
				}

				for (Map.Entry<String, String> entry : map.entrySet()) {
					range.replaceText(entry.getKey(), entry.getValue());
				}

				// 输出word内容文件流，提供下载
				response.reset();
				response.setContentType("application/x-msdownload");
				// 文件名称
				String fileName = new String(this.getText("word_download_name").getBytes("GB2312"), "ISO8859_1");
				response.addHeader("Content-Disposition", "attachment; filename=" + fileName);

				ByteArrayOutputStream ostream = new ByteArrayOutputStream();
				ByteArrayOutputStream ostream1 = new ByteArrayOutputStream();
				ServletOutputStream servletOS = response.getOutputStream();

				hdt.write(ostream);
				hdt1.write(ostream);
				servletOS.write(ostream.toByteArray());

				servletOS.write(ostream1.toByteArray());
				servletOS.flush();
				servletOS.close();

			} catch (IOException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			} finally {

			}
		}
	}

	// weina start
	
	/**
	 * 
	 * @comments 下载专家签到和费用领取表及各自的空白模板
	 * @version 1.0
	 */
	public void downExpertScoreAndFeeCollection(){
		// response
		HttpServletResponse response = this.getResponse();
		// 取得登录用户的信息
		HttpSession session = this.getRequest().getSession();
		ScUsers user = (ScUsers) session.getAttribute("sysUser");
		if (user != null && user.getUserId() != null && !"".equals(user.getUserId())) {
			try {
				// 封装要压缩的file
				List<File> fileList = new ArrayList<File>();
				// 要删除的file
				List<File> delfileList = new ArrayList<File>();
				
				// 设置路径
				String modelInputPath = mitemService.get(Constants.PDF_TEMPLATE_PATH).getItemDesc();
				String len = modelInputPath.substring(modelInputPath.length() - 1, modelInputPath.length());
				// 判断目录是否完整
				if (!"/".equals(len)) {
					modelInputPath = modelInputPath + "/";
				}
				// 压缩文件的名字
				String fileName1 = this.getText("expertScore_feeCollection");
				// 压缩之后的zip名字
				File zipFileName = new File(modelInputPath + fileName1+ System.currentTimeMillis()+".zip");
				// 计划类别字符串  
				String typeStr = tprojectTypeManagerService.getProjectTypeStrByUser(user);
				if(!"".equals(typeStr)){
					// 项目分组list 
					List<TprojectGroup> projectGroupList = tprojectGroupService.getProjectGroupListByTypeStrClockFlag(typeStr);
					// 判断项目分组list不为空
					if(projectGroupList != null && projectGroupList.size() > 0){
						// 生excel，专家签到表和费用领取表
						for(int i = 0;i < 2; i++){
							// 生成excel。返回excel文件名字
							String filename = this.createTexpertOutExcel(i,projectGroupList,user.getUserId());
							// 封装要压缩的excel文件
							File file1 = new File(modelInputPath + filename);
							fileList.add(file1);
							// 删除只删除生成的excel，不删除空白模板
							delfileList.add(file1);
						}
						// 专家签到表空白模板
						File file2 = new File(modelInputPath + this.getText("expertScoreModel"));
						// 费用领取表空白模板
						File file3 = new File(modelInputPath + this.getText("feeCollectionModel"));
						// 封装专家签到表空白模板
						fileList.add(file2);
						// 封装费用领取表空白模板
						fileList.add(file3);
						
						// 压缩文件
						WorddocDownloadAction.ExpertScoreAndFeeCollectionZipFiles(fileList, zipFileName);
						
						// 删除生成的excel文件
						deleteFile(delfileList);
					}
					
					// 下载压缩包
					FileDownLoad fileDownLoad = new FileDownLoad();
					fileDownLoad.writeDownloadStream(response,zipFileName.toString(), fileName1+".zip");
					
					// 删除压缩包
					if (zipFileName.isFile() && zipFileName.exists()) {
						zipFileName.delete();
					} 
				}
				
			} catch (IOException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			} finally {

			}
		}

	}
	/**
	 * 
	 * @comments 生成excel  
	 * @param projectGroupList
	 * @param texpertIdList
	 * @return
	 * @throws IOException
	 * @throws WriteException
	 * @version 1.0
	 */
	private String createTexpertOutExcel(int flag,List<TprojectGroup> projectGroupList,String userId) throws IOException, WriteException {
		// 工作簿从usr tppasc input中拷贝模板
		String modelInputPath = mitemService.get(Constants.PDF_TEMPLATE_PATH).getItemDesc();
		String len = modelInputPath.substring(modelInputPath.length() - 1, modelInputPath.length());
		// 生成的专家签到表excel文件名字
		String fileName1 = null;
		if(flag == 0){
			// 专家签到表
			fileName1 = this.getText("experts_in_table");
		}else{
			// 费用领取表
			fileName1 = this.getText("fees_will_receive");
		}
		// 生成的费用领取excel文件名字
		String expertfileName = fileName1 + userId + System.currentTimeMillis()+".xls";
		// 区分签到表和费用领取表 i
		
		// 判断目录是否完整
		if (!"/".equals(len)) {
			modelInputPath = modelInputPath + "/";
			File fileModel = null;
			if(flag == 0){
				// 专家签到表模板
				fileModel = new File(modelInputPath + Constants.EXPERT_FILENAME);
			}else{
				// 费用领取表模板
				fileModel = new File(modelInputPath + Constants.FEECOLLECTION_FILENAME);
			}
			try {
				Workbook wk = Workbook.getWorkbook(fileModel);
				WorkbookSettings settings = new WorkbookSettings();
				settings.setWriteAccess(null);
				
				WritableWorkbook wwb = Workbook.createWorkbook(new File(modelInputPath + expertfileName), wk);

				// ===========生成sheet start============
				// 当组个数超过一个时，拷贝个新的sheet，
				if(projectGroupList!=null && projectGroupList.size()>0){
					for(int i = 0; i<projectGroupList.size(); i++){
						// 取得sheet名字
						String sheetName = getTexpertSheetName(i, projectGroupList);
						// 复制sheet
						wwb.importSheet(sheetName, i, wk.getSheet(0));
					}
					// 删除最后一个sheet
					wwb.removeSheet(projectGroupList.size());
				}
				// ===========生成sheet end============
				// 单元格边框格式
				WritableCellFormat cf = new WritableCellFormat();
				// 设置边框
				cf.setBorder(Border.ALL, BorderLineStyle.THIN);
				// 垂直居中显示
				cf.setVerticalAlignment(VerticalAlignment.CENTRE);
				WritableFont wf2 = new WritableFont(WritableFont.createFont("宋体"), 16, WritableFont.NO_BOLD, false);
				cf.setFont(wf2);
				// 换行显示
				cf.setWrap(true);

				// 序号和职务格式
				WritableCellFormat numCf = new WritableCellFormat();
				// 设置边框
				numCf.setBorder(Border.ALL, BorderLineStyle.THIN);
				// 垂直居中显示
				numCf.setVerticalAlignment(VerticalAlignment.CENTRE);
				// 水平居中显示
				numCf.setAlignment(Alignment.CENTRE);
				// 设置字体
				WritableFont wf = new WritableFont(WritableFont.createFont("宋体"), 16, WritableFont.NO_BOLD, false);
				numCf.setFont(wf);
				// 换行显示
				numCf.setWrap(true);
				// ===========写入数据 Start===========
				if(projectGroupList!=null && projectGroupList.size()>0){
					for (int m = 0; m < projectGroupList.size(); m++) {
						// 通过组id查专家
						// 根据项目分组id查询每个分组里面的专家list
						 List<TgroupExpertRealtion> texpertIdList = tgroupExpertRealtionService.getList("tprojectGroup.groupId", projectGroupList.get(m).getGroupId());
						// 根据申报年度取得sheet
						WritableSheet sh = wwb.getSheet(getTexpertSheetName(m, projectGroupList));
						// 判断专家list不为空
						if(texpertIdList != null && texpertIdList.size() > 0){
							// 循环专家列表
							for(int n = 0;n<texpertIdList.size();n++){
								// 取得每个专家信息
								Texpert texpert = texpertIdList.get(n).getTexpert();
								// 序号
								sh.addCell(new Label(0, 2+n, String.valueOf(n+1), numCf));
								// 评审组职务
								sh.addCell(new Label(1, 2+n, "评 委", numCf));
								// 姓名
								if(texpert.getExpertName() != null && !"".equals(texpert.getExpertName())){
									sh.addCell(new Label(2, 2+n, texpert.getExpertName(), numCf));
								}
								// 工作单位
								if(texpert.getExpertWork() != null && !"".equals(texpert.getExpertWork())){
									sh.addCell(new Label(3, 2+n, texpert.getExpertWork(), cf));
								}
								// 职称不为空
								if(texpert.getSkillJob() != null && !"".equals(texpert.getSkillJob())){
									// 职务不为空
									if(texpert.getExpertJob() != null && !"".equals(texpert.getExpertJob())){
										String job = mitemService.getMitemNameById(texpert.getSkillJob()) + "/" + texpert.getExpertJob();
										sh.addCell(new Label(4, 2+n, job, numCf));
									}
									// 职务为空
									else{
										sh.addCell(new Label(4, 2+n, mitemService.getMitemNameById(texpert.getSkillJob()), numCf));
									}
								}
								// 职称为空
								else{
									// 职务不为空
									if(texpert.getExpertJob() != null && !"".equals(texpert.getExpertJob())){
										sh.addCell(new Label(4, 2+n, texpert.getExpertJob(), numCf));
									}
									// 职务为空
									else{
										sh.addCell(new Label(4, 2+n, "", numCf));
									}
								}	
								// 擅长专业1
								if(texpert.getExpertMajor1() != null && !"".equals(texpert.getExpertMajor1())){
									sh.addCell(new Label(5, 2+n, mitemService.getMitemNameById(texpert.getExpertMajor1()), numCf));
								}
								// 联系方式
								if(texpert.getPhone() != null && !"".equals(texpert.getPhone())){
									sh.addCell(new Label(6, 2+n, texpert.getPhone(), numCf));
								}
								}
						}
					}
				}
				// ===========写入数据 end===========
				wwb.write();
				wwb.close();
				wk.close();

			} catch (BiffException e) {
				e.printStackTrace();
			}
		}
		return expertfileName;
	}
	
	/**
	 * 
	 * @comments 设置专家签到表和费用领取表sheetname
	 * @param i
	 * @param projectList
	 * @return
	 * @version 1.0
	 */
	public String getTexpertSheetName(int i, List<TprojectGroup> projectGroupList) {
		String sheetname = null;
		// 如果项目名称长度大于29个字。截取29个字 ，追加循环数字i
		List<TprojectApplication> tpList = tprojectApplicationService.getList("tprojectType.typeId",projectGroupList.get(i).getTypeId());
		// sheet名字是组名-项目分类加数字排序
		String name = projectGroupList.get(i).getGroupName()+"-"+tpList.get(0).getTypeName();
		if (name.length() > 29) {
			sheetname = name.substring(0, 29) + (i + 1);
		} else {
			sheetname = name + (i + 1);
		}
		return sheetname;
	}
	
	/**
	 * 
	 * @comments 下载专家空白模板
	 * @version 1.0
	 */
	public void downExpertScore(){
		// response
		HttpServletResponse response = this.getResponse();
		// 设置路径
		String modelInputPath = mitemService.get(Constants.PDF_TEMPLATE_PATH).getItemDesc();
		String len = modelInputPath.substring(modelInputPath.length() - 1, modelInputPath.length());
		// 判断目录是否完整
		if (!"/".equals(len)) {
			modelInputPath = modelInputPath + "/";
		}
		// 下载压缩包
		FileDownLoad fileDownLoad = new FileDownLoad();
		String fileName;
		try {
			//fileName = new String(this.getText("down_exper_model_name").getBytes("GB2312"), "ISO8859_1");
			// 取得要下载的文件名字
			fileName = this.getText("down_exper_model_name");
		    // 文件的全路径
 			String strFileFullPath = modelInputPath + fileName;
			// 下载
			fileDownLoad.writeDownloadStream(response,strFileFullPath, fileName);
		} catch (Exception e) {
			e.printStackTrace();
		}
	
	}
	/**
	 * @comments 下载专家评估表的excel压缩包文件
	 * @throws Exception
	 * @Version 1.0
	 */
	public void downloadExpertScoreByGroup() throws Exception {
		// response
		HttpServletResponse response = this.getResponse();
		// 取得登录用户的信息
		HttpSession session = this.getRequest().getSession();
		ScUsers user = (ScUsers) session.getAttribute("sysUser");
		if (user != null && user.getUserId() != null && !"".equals(user.getUserId())) {
			try {
				// 专家模板
				TexpertReviewComments te = null;
				// 取得生成excel的全路径
				
				// 封装file
				List<File> fileList = new ArrayList<File>();
				// 设置路径
				String modelInputPath = mitemService.get(Constants.PDF_TEMPLATE_PATH).getItemDesc();
				String len = modelInputPath.substring(modelInputPath.length() - 1, modelInputPath.length());
				// 判断目录是否完整
				if (!"/".equals(len)) {
					modelInputPath = modelInputPath + "/";
				}
				String fileName1 = this.getText("exper_comment_name");
				// 压缩之后的zip名字
				File zipFileName = new File(modelInputPath + fileName1+ System.currentTimeMillis()+".zip");
				// 分组id
				this.groupId = this.getGroupId();
				// 分组id取得打印的项目数据
				List<TprojectApplication> projectList = tprojectApplicationService.getProjectList(groupId);
				// 项目数据不为空
				if (projectList != null && projectList.size() > 0) {
					TprojectApplication tp = projectList.get(0);
					// 取得项目分类id
					if (tp.getTprojectType().getTypeId() != null && !"".equals(tp.getTprojectType().getTypeId())) {
						// 取得模板信息By 项目分类ID
						List<TexpertReviewComments> list = texpertReviewCommentsService.getexpertReview(tp.getTprojectType().getTypeId());
						if (list != null && list.size() > 0) {
							for (int i = 0; i < list.size(); i++) {
								te = list.get(i);
								// 生成excel
								String filename = this.createOutExcel(projectList, te ,user.getUserId(),groupId);
								File file1 = new File(modelInputPath+filename);
								fileList.add(file1);
							}
							// 压缩文件
							WorddocDownloadAction.ExpertReviewZipFiles(fileList, zipFileName);
							
							// 删除生成的excel文件
							deleteFile(fileList);
						
							// 下载压缩包
							FileDownLoad fileDownLoad = new FileDownLoad();
							fileDownLoad.writeDownloadStream(response,zipFileName.toString(), fileName1+".zip");
							
							// 删除压缩包
							if (zipFileName.isFile() && zipFileName.exists()) {
								zipFileName.delete();
							} 
						
						}
					}
				}

			} catch (IOException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			} finally {

			}
		}

	}

	/**
	 * 
	 * @comments 删除文件
	 * @param fileName
	 * @return
	 * @version 1.0
	 */
	public static boolean deleteFile(List<File> fileList) {
		// 判断
		if(fileList != null && fileList.size()>0){
			for(File file : fileList){
				if (file.isFile() && file.exists()) {
					file.delete();
					//return true;
				} 
			}
		}else{
			return true;
		}
		return false;
	}

	/**
	 * 压缩文件
	 * 
	 * @param srcfile
	 *            File[] 需要压缩的文件列表
	 * @param zipfile
	 *            File 压缩后的文件
	 */
	public static void ExpertReviewZipFiles(List<File> srcfile, java.io.File zipfile) {
		byte[] buf = new byte[1024];
		try {
			// 创建一个压缩文件
			ZipOutputStream out = new ZipOutputStream(new FileOutputStream(zipfile));
			for (int i = 0; i < srcfile.size(); i++) {
				File file = srcfile.get(i);
				FileInputStream in = new FileInputStream(file);
				if(i == 0){
					// 技术专家
					out.putNextEntry(new ZipEntry(Constants.TECHNICAL_EXPER_NAME));
				}else if(i == 1){
					// 投资专家
					out.putNextEntry(new ZipEntry(Constants.INVESTMENT_EXPER_NAME));
				}
				int len;
				while ((len = in.read(buf)) > 0) {
					out.write(buf, 0, len);
				}
				out.closeEntry();
				in.close();
			}
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	/**
	 * 压缩文件
	 * 
	 * @param srcfile
	 *            File[] 需要压缩的文件列表
	 * @param zipfile
	 *            File 压缩后的文件
	 */
	public static void ExpertScoreAndFeeCollectionZipFiles(List<File> srcfile, java.io.File zipfile) {
		byte[] buf = new byte[1024];
		try {
			// 创建一个压缩文件
			ZipOutputStream out = new ZipOutputStream(new FileOutputStream(zipfile));
			for (int i = 0; i < srcfile.size(); i++) {
				File file = srcfile.get(i);
				FileInputStream in = new FileInputStream(file);
				if(i == 0){
					// 专家签到表
					out.putNextEntry(new ZipEntry(Constants.EXPERT_IN_TABLE));
				}else if(i == 1){
					// 费用领取表
					out.putNextEntry(new ZipEntry(Constants.FEES_WILL_RECEIVE));
				}else{
					out.putNextEntry(new ZipEntry(file.getName()));
					
				}
				int len;
				while ((len = in.read(buf)) > 0) {
					out.write(buf, 0, len);
				}
				out.closeEntry();
				in.close();
			}
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 
	 * @comments 设置专家评估表的sheetname
	 * @param i
	 * @param projectList
	 * @return
	 * @version 1.0
	 */
	public String getsheetName(int i, List<TprojectApplication> projectList) {
		String sheetname = null;
		// 如果项目名称长度大于29个字。截取29个字 ，追加循环数字i
		if ((projectList.get(i).getProjectName()).length() > 29) {
			sheetname = (projectList.get(i).getProjectName()).substring(0, 29) + (i + 1);
		} else {
			sheetname = projectList.get(i).getProjectName() + (i + 1);
		}
		return sheetname;
	}

	/**
	 * 
	 * @comments 生成专家评估表excel
	 * @param projectList
	 * @param te
	 * @param fileName
	 * @throws IOException
	 * @throws WriteException
	 * @version 1.0
	 */
	private String createOutExcel(List<TprojectApplication> projectList, TexpertReviewComments te,String userId,String groupId) throws IOException, WriteException {

		// 工作簿从usr tppasc input中拷贝模板
		String modelInputPath = mitemService.get(Constants.PDF_TEMPLATE_PATH).getItemDesc();
		String len = modelInputPath.substring(modelInputPath.length() - 1, modelInputPath.length());
		// 生成的excel文件名字
		String fileName1 = null;
		if(te != null){
			// excel的标题
			if(Constants.EXPERT_TYPE1.equals(te.getExpertType())){
				fileName1 = this.getText("technical_exper_name");
				
			}else if(Constants.EXPERT_TYPE2.equals(te.getExpertType())){
				fileName1 = this.getText("investment_exper_name");
			}
		}
		String fileName = fileName1 + userId + System.currentTimeMillis()+".xls";
		// 判断目录是否完整
		if (!"/".equals(len)) {
			modelInputPath = modelInputPath + "/";

			File fileModel = new File(modelInputPath + Constants.EXPERT_REVIEW_FILENAME);
			try {
				Workbook wk = Workbook.getWorkbook(fileModel);
				WorkbookSettings settings = new WorkbookSettings();
				settings.setWriteAccess(null);
				
				WritableWorkbook wwb = Workbook.createWorkbook(new File(modelInputPath + fileName), wk);

				// ===========生成sheet start============
				// 当组下面的项目个数超过一个时，拷贝个新的sheet，
				if (projectList != null && projectList.size() > 0) {
					for (int i = 0; i < projectList.size(); i++) {
						// 取得sheet名字
						String sheetName = getsheetName(i, projectList);
						// 复制sheet
						wwb.importSheet(sheetName, i, wk.getSheet(0));
					}
					// 删除最后一个sheet
					wwb.removeSheet(projectList.size());
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

				// 整数格式
				NumberFormat nf = new NumberFormat("0");
				WritableCellFormat numberCf = new WritableCellFormat(nf);
				// 设置边框
				numberCf.setBorder(Border.ALL, BorderLineStyle.THIN);
				// 垂直居中显示
				numberCf.setVerticalAlignment(VerticalAlignment.CENTRE);
				// 水平居中显示
				numberCf.setAlignment(Alignment.CENTRE);
				// 设置字体
				numberCf.setFont(wf2);

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
				// 计划类别名称格式
				WritableCellFormat typeCf = new WritableCellFormat();
				// 设置边框
				typeCf.setBorder(Border.ALL, BorderLineStyle.THIN);
				// 垂直居中显示
				typeCf.setVerticalAlignment(VerticalAlignment.CENTRE);
				// 水平居中显示
				typeCf.setAlignment(Alignment.CENTRE);
				// 设置字体
				WritableFont wf3 = new WritableFont(WritableFont.createFont("宋体"), 11, WritableFont.BOLD, false);
				typeCf.setFont(wf3);

				// 设置注意格式
				WritableCellFormat remarkCf = new WritableCellFormat();
				// 设置边框
				remarkCf.setBorder(Border.ALL, BorderLineStyle.THIN);
				// 垂直居中显示
				remarkCf.setVerticalAlignment(VerticalAlignment.CENTRE);
				// 水平居中显示
				remarkCf.setAlignment(Alignment.LEFT);
				// 设置字体
				WritableFont wf4 = new WritableFont(WritableFont.createFont("宋体"), 10, WritableFont.BOLD, false);
				remarkCf.setFont(wf4);
				// ===========写入数据 Start===========
				if (projectList != null && projectList.size() > 0) {
					for (int m = 0; m < projectList.size(); m++) {
						String title = null;
						// 根据申报年度取得sheet
						WritableSheet sh = wwb.getSheet(getsheetName(m, projectList));
						// 计划类别
						String projectTypeName = "(" + projectList.get(m).getPlanFlagName() + ")";
						// 分组名称
						String groupName = tprojectGroupService.get(groupId).getGroupName();
						// 小分类+分组名称
						String projectNumber = null;
						if(m>8){
							projectNumber = projectList.get(m).getTypeName()+groupName+"0"+(m+1);
						}else if(m>98){
							projectNumber = projectList.get(m).getTypeName()+groupName+""+(m+1);
						}else{
							projectNumber = projectList.get(m).getTypeName()+groupName+"00"+(m+1);
						}
						if (te != null) {
							// excel的标题
							if(Constants.EXPERT_TYPE1.equals(te.getExpertType())){
								title = projectList.get(m).getReportYear() + "年企业技术创新项目技术专家评估表";
								
							}else if(Constants.EXPERT_TYPE2.equals(te.getExpertType())){
								title = projectList.get(m).getReportYear() + "年企业技术创新项目投资专家评估表";
							}
						}
						// 标题
						sh.addCell(new Label(0, 0, title, titleCf));
						// 计划类别
						sh.addCell(new Label(0, 2, projectTypeName, typeCf));
						// 项目名称
						sh.addCell(new Label(2, 3, projectList.get(m).getProjectName(), cf));
						// 单位名称
						sh.addCell(new Label(2, 4, projectList.get(m).getApplicationUnit(), cf));
						// 项目编号
						sh.addCell(new Label(8, 4, projectNumber, cf));
						// 支持方向
						sh.addCell(new Label(2, 7, "", cf));
						// 支持条件
						sh.addCell(new Label(2, 8, "", cf));
						// 评审表信息
						if (te != null) {
							// 评审指标1
							sh.addCell(new Label(1, 10, te.getEvaluationIndex1(), cf));
							// 评审指标说明1
							sh.addCell(new Label(2, 10, te.getEvaluationShows1(), cf));
							// 分值1
							sh.addCell(new Label(6, 10, te.getScore1().toString(), numberCf));
							// 评分标准1
							sh.addCell(new Label(7, 10, te.getCodePoints1(), cf));
							// 评分标准2
							sh.addCell(new Label(7, 11, te.getCodePoints2(), cf));
							// 评分标准3
							sh.addCell(new Label(7, 12, te.getCodePoints3(), cf));
	
							// 评审指标2
							sh.addCell(new Label(1, 13, te.getEvaluationIndex2(), cf));
							// 评审指标说明2
							sh.addCell(new Label(2, 13, te.getEvaluationShows2(), cf));
							// 分值2
							sh.addCell(new Label(6, 13, te.getScore2().toString(), numberCf));
							// 评分标准4
							sh.addCell(new Label(7, 13, te.getCodePoints4(), cf));
							// 评分标准5
							sh.addCell(new Label(7, 14, te.getCodePoints5(), cf));
							// 评分标准6
							sh.addCell(new Label(7, 15, te.getCodePoints6(), cf));
	
							// 评审指标3
							sh.addCell(new Label(1, 16, te.getEvaluationIndex3(), cf));
							// 评审指标说明3
							sh.addCell(new Label(2, 16, te.getEvaluationShows3(), cf));
							// 分值3
							sh.addCell(new Label(6, 16, te.getScore3().toString(), numberCf));
							// 评分标准7
							sh.addCell(new Label(7, 16, te.getCodePoints7(), cf));
							// 评分标准8
							sh.addCell(new Label(7, 17, te.getCodePoints8(), cf));
							// 评分标准9
							sh.addCell(new Label(7, 18, te.getCodePoints9(), cf));
	
							// 评审指标4
							sh.addCell(new Label(1, 19, te.getEvaluationIndex4(), cf));
							// 评审指标说明4
							sh.addCell(new Label(2, 19, te.getEvaluationShows4(), cf));
							// 分值4
							sh.addCell(new Label(6, 19, te.getScore4().toString(), numberCf));
							// 评分标准10
							sh.addCell(new Label(7, 19, te.getCodePoints10(), cf));
							// 评分标准11
							sh.addCell(new Label(7, 20, te.getCodePoints11(), cf));
							// 评分标准12
							sh.addCell(new Label(7, 21, te.getCodePoints12(), cf));
	
							// 评审指标5
							sh.addCell(new Label(1, 22, te.getEvaluationIndex5(), cf));
							// 评审指标说明5
							sh.addCell(new Label(2, 22, te.getEvaluationShows5(), cf));
							// 分值5
							sh.addCell(new Label(6, 22, te.getScore5().toString(), numberCf));
							// 评分标准13
							sh.addCell(new Label(7, 22, te.getCodePoints13(), cf));
							// 评分标准14
							sh.addCell(new Label(7, 23, te.getCodePoints14(), cf));
							// 评分标准15
							sh.addCell(new Label(7, 24, te.getCodePoints15(), cf));
	
							String remarksScore = "注：" + te.getRemarksScore1().toString() + "分以上为重点推荐；" + te.getRemarksScore2().toString() + "-" + te.getRemarksScore3().toString() + "分为推荐；"
									+ te.getRemarksScore4().toString() + "-" + te.getRemarksScore5().toString() + "分为备选；" + te.getRemarksScore6().toString() + "分以下为落选";
							// 备注分数
							sh.addCell(new Label(0, 27, remarksScore, remarkCf));
						}else {
							sh.addCell(new Label(0, 27, "", remarkCf));
						}
					}
				}
				// ===========写入数据 end===========
				wwb.write();
				wwb.close();
				wk.close();

			} catch (BiffException e) {
				e.printStackTrace();
			}
		}
		return fileName;
	}

	// weina end
	public String getProjectId() {
		return projectId;
	}

	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}

	public String getGroupId() {
		return groupId;
	}

	public void setGroupId(String groupId) {
		this.groupId = groupId;
	}

}
