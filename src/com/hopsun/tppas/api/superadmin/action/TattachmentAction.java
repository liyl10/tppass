package com.hopsun.tppas.api.superadmin.action;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.hopsun.framework.base.action.BaseAction;
import com.hopsun.scenter.entity.ScUsers;
import com.hopsun.tppas.api.superadmin.service.MitemService;
import com.hopsun.tppas.api.superadmin.service.TattachmentService;
import com.hopsun.tppas.common.Constants;
import com.hopsun.tppas.common.FileDownLoad;
import com.hopsun.tppas.entity.Mitem;
import com.hopsun.tppas.entity.Tattachment;

/**
 * @comments 附件管理
 * @author wanglw
 * @date 2013-5-17 @time 下午5:08:38
 * @Version 1.0
 */
public class TattachmentAction extends BaseAction{
  
	private static final long serialVersionUID = 7412009618397246175L;
	
	@Resource
	private TattachmentService tattachmentService;
	
	@Resource
	private MitemService mitemService;
	
	/** 跳转路径*/
	private String retUrl;
	/** 跳转路径*/
	private String retUrlTemp;
	/** 跳转页面massage */
	private String retMsg;
	/** Tattachment对象 */
	private Tattachment tattachment;
	/** 上传文件对象 */
	private File uploadfile;
	/** 上传附件后缀名 */
	private String upLoadfileName;
	/** 业务数据ID */
	private String dataId;
	/** 表名 */
	private String tableName;
	/** 附件名称 */
	private String attachmentName;
	/** 附件ID */
	private String attachmentId;
	/** 主表表名 */
	private String projectTableName;
	/** 排序flag */
	private String orderFlag;
	/** 附件大小flag */
	private String sizeFlag;
	/** 附件顺序*/
	private int sequence;
	/** 附件说明 */
	private String explanation;
	/** 备注1 */
	private String comment1;
	/** 备注2 */
	private String comment2;
	/** 备注3 */
	private String comment3;
	/** 提交状态 */
	private String status;
	/** 下一步操作 */
	private String nextFileHidden;
	/** pdf路径 */
	private String pdfPath;
	/** pdf名称 */
	private String pdfNameType;
	
	
	/**
	 * 附件上传
	 * @return
	 * @throws IOException 
	 */
	public String execute() throws IOException{

		
		// 取得登录用户的信息
    	HttpSession session = this.getRequest().getSession();
    	ScUsers user = (ScUsers) session.getAttribute("sysUser");
    	
    	if (user == null || ("").equals(user.getUserId())) {
			return "LogOut";
		}

    	if(nextFileHidden != null && !"".equals(nextFileHidden)){
    		this.retUrlTemp = retUrlTemp + "nextFileHidden=" + nextFileHidden +"&";
    	}
    	
		boolean jsonFlag = false;
		FileInputStream fis = null;
		FileOutputStream fos = null;
		String fileAdress = null;

		// 取得附件上传路径
		String filePath = "D:\\upload";
		
		// 取得配置的附件上传路径
		Mitem mitem = mitemService.get(Constants.FILE_UPLOAD_PATH);
		
		if(mitem !=null){
			filePath = mitem.getItemDesc();
		}
		try {
			
			boolean checkFlag = false;
			
			// 取得最大上传size数
			Mitem sizemitem = mitemService.get(Constants.FILE_UPLOAD_SIZE);
			
			int size = 10;
			// 取得最大上传为空的话 给默认值
			if (sizemitem == null) {
				size = 10;
			} else {
				if(sizemitem.getItemDesc() != null && !"".equals(sizemitem.getItemDesc())){
					try {
						size = Integer.parseInt(sizemitem.getItemDesc());
					}
					catch(Exception e){
						size = 10;
					}
				}
				else{
					size = 10;
				}
			}

			// 检查最大上传size数
			if (uploadfile.length() > (long)(1024 * 1024 * size)) {
				this.sizeFlag ="true";
				checkFlag = true;
			}
			
			// 附件顺序是否存在
			sequence = this.getSequence();
			if(sequence !=0){
				Tattachment tattachmentTemp = tattachmentService.getTattachment(tableName, dataId, sequence);
				if(tattachmentTemp !=null){
					this.orderFlag ="true";
					checkFlag = true;
				}
			}
			
			if(checkFlag){
				return "checkFileSize";
			}
			
			
			// 文件后缀名
			String extensionname = upLoadfileName;
			// 文件名称
			String fileName = String.valueOf(new java.util.Date().getTime());
			fis = new FileInputStream(uploadfile);

			File file = new File(filePath + File.separator
					+ user.getUserId());
			// 文件夹是不是存在
			if (!file.exists()) {
				// 做成文件夹失败
				if (!file.mkdirs()) {
					
					this.setRetMsg(this.getText("opt_file_create_err"));
					this.setRetUrl(this.retUrlTemp);
					return "uploadSuccess";
				}
			}
			
			// 文件相对路径
			fileAdress = File.separator + user.getUserId()
					+ File.separator + fileName + extensionname;
			// 文件绝对路径
			filePath = filePath + fileAdress;
			fos = new FileOutputStream(filePath);

			byte[] bs = new byte[1024];
			int len = 0;

			while ((len = fis.read(bs)) != -1) {
				fos.write(bs, 0, len);
			}
			jsonFlag = true;

		} catch (Exception e) {
			
			this.setRetMsg(this.getText("opt_file_upload_err"));
			this.setRetUrl(this.retUrlTemp);
			return "uploadSuccess";
		} finally {
			if (fis != null) {
				fis.close();
			}
			if (fos != null) {
				fos.flush();
				fos.close();
			}
		}

		try {
			// 文件上传成功
			if (jsonFlag){
				
				tattachmentService.updateTattachmentAndOtherTable(tableName, dataId, attachmentName, 
						user.getUserId(), projectTableName, sequence, explanation, fileAdress, comment1, comment2, comment3, status);
				
				this.setRetMsg(this.getText("opt_save_suc"));
				this.setRetUrl(this.retUrlTemp);
			}

		} catch (Exception e) {

			this.setRetMsg(this.getText("opt_save_err"));
		}
		
		return "uploadSuccess";
	}
	
	/**
	 * @comments 上传后跳转画面处理
	 * @return
	 * @throws Exception
	 * @Version 1.0
	 */
	public String targetUpload() throws Exception {
		retMsg = new String(retMsg.getBytes("ISO8859-1"), "UTF-8");
		this.setRetMsg(retMsg);
		this.setRetUrl(retUrl);
		
		return "systemInfoIframe";
	}
	
	/**
	 * 附件下载处理
	 * @return
	 * @throws IOException 
	 */
	public void downLoadFile() throws Exception {
		// 取得登录用户的信息
    	HttpSession session = this.getRequest().getSession();
    	ScUsers user = (ScUsers) session.getAttribute("sysUser");
    	if(user !=null && user.getUserId() !=null && !"".equals(user.getUserId())){
			OutputStream outStream = null;
			InputStream inStream = null;
			try {
				
				attachmentId = this.getAttachmentId();
				
				tattachment = tattachmentService.get(attachmentId);

				String filePath = tattachment.getAttachmentAddress();

				// 取得配置的附件上传路径
				Mitem mitem = mitemService.get(Constants.FILE_UPLOAD_PATH);
				
				if(mitem !=null){
					filePath = mitem.getItemDesc() + filePath;
				}
				
				HttpServletResponse response = ServletActionContext
						.getResponse();
				File file = new File(filePath);
				String fileName = file.getName();
				if(fileName.indexOf(".") > 0){
					fileName = fileName.substring(fileName.indexOf("."));
				}
				fileName = tattachment.getAttachmentName() + fileName;
				FileDownLoad fileDownLoad = new FileDownLoad();
				fileDownLoad.writeDownloadStream(response, filePath, fileName);

			} catch (Exception ex) {
				
				this.setRetMsg(this.getText("opt_file_down_err"));
			} finally {
				if (inStream != null) {
					inStream.close();
				}
				if (outStream != null) {
					outStream.close();
				}
			}
		} 
	}
	
	/**
	 * @comments PDF下载处理
	 * @return
	 * @throws Exception
	 * @Version 1.0
	 */
	public void downLoadPdf() throws Exception{
		OutputStream outStream = null;
		InputStream inStream = null;
		try {
			
			// 取得配置的附件上传路径
			Mitem mitem = mitemService.get(Constants.PDF_STORAGE_PATH);
			
			String filePath="";
			if(mitem !=null){
				filePath = mitem.getItemDesc() + pdfPath;
			}
			
			HttpServletResponse response = ServletActionContext
					.getResponse();
			File file = new File(filePath);
			String fileName = file.getName();
			if(fileName.indexOf(".") > 0){
				fileName = fileName.substring(fileName.indexOf("."));
			}
			// 项目申报
			if("1".equals(pdfNameType)){
				fileName = this.getText("report_pdf_name") + fileName;
			}
			// 合同填报
			else if("2".equals(pdfNameType)){
				fileName = this.getText("contract_pdf_name") + fileName;
			}
			// 中期监理
			else if("3".equals(pdfNameType)){
				fileName = this.getText("supervisor_pdf_name") + fileName;
			}
			// 项目验收
			else if("4".equals(pdfNameType)){
				fileName = this.getText("acceptance_pdf_name") + fileName;
			}
			
			FileDownLoad fileDownLoad = new FileDownLoad();
			fileDownLoad.writeDownloadStream(response, filePath, fileName);

		} catch (Exception ex) {
			
			this.setRetMsg(this.getText("opt_file_down_err"));
		} finally {
			if (inStream != null) {
				inStream.close();
			}
			if (outStream != null) {
				outStream.close();
			}
		}
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


	public File getUploadfile() {
		return uploadfile;
	}


	public void setUploadfile(File uploadfile) {
		this.uploadfile = uploadfile;
	}


	public String getUpLoadfileName() {
		return upLoadfileName;
	}


	public void setUpLoadfileName(String upLoadfileName) {
		this.upLoadfileName = upLoadfileName;
	}


	public String getDataId() {
		return dataId;
	}


	public void setDataId(String dataId) {
		this.dataId = dataId;
	}


	public String getTableName() {
		return tableName;
	}


	public void setTableName(String tableName) {
		this.tableName = tableName;
	}


	public Tattachment getTattachment() {
		return tattachment;
	}


	public void setTattachment(Tattachment tattachment) {
		this.tattachment = tattachment;
	}


	public String getRetUrlTemp() {
		return retUrlTemp;
	}


	public void setRetUrlTemp(String retUrlTemp) {
		this.retUrlTemp = retUrlTemp;
	}

	public String getAttachmentName() {
		return attachmentName;
	}

	public void setAttachmentName(String attachmentName) {
		this.attachmentName = attachmentName;
	}


	public String getAttachmentId() {
		return attachmentId;
	}


	public void setAttachmentId(String attachmentId) {
		this.attachmentId = attachmentId;
	}


	public String getOrderFlag() {
		return orderFlag;
	}


	public void setOrderFlag(String orderFlag) {
		this.orderFlag = orderFlag;
	}


	public int getSequence() {
		return sequence;
	}


	public void setSequence(int sequence) {
		this.sequence = sequence;
	}


	public String getExplanation() {
		return explanation;
	}


	public void setExplanation(String explanation) {
		this.explanation = explanation;
	}


	public String getSizeFlag() {
		return sizeFlag;
	}


	public void setSizeFlag(String sizeFlag) {
		this.sizeFlag = sizeFlag;
	}


	public String getProjectTableName() {
		return projectTableName;
	}


	public void setProjectTableName(String projectTableName) {
		this.projectTableName = projectTableName;
	}


	public String getComment1() {
		return comment1;
	}


	public void setComment1(String comment1) {
		this.comment1 = comment1;
	}


	public String getComment2() {
		return comment2;
	}


	public void setComment2(String comment2) {
		this.comment2 = comment2;
	}

	
	public String getComment3() {
		return comment3;
	}

	public void setComment3(String comment3) {
		this.comment3 = comment3;
	}

	public String getNextFileHidden() {
		return nextFileHidden;
	}


	public void setNextFileHidden(String nextFileHidden) {
		this.nextFileHidden = nextFileHidden;
	}

	public String getPdfPath() {
		return pdfPath;
	}

	public void setPdfPath(String pdfPath) {
		this.pdfPath = pdfPath;
	}

	public String getPdfNameType() {
		return pdfNameType;
	}

	public void setPdfNameType(String pdfNameType) {
		this.pdfNameType = pdfNameType;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
}
