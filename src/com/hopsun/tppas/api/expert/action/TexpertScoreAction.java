/*************** 版权声明***************
*
* Copyright (C) 2012 西安辉盛科技发展有限责任公司.
*
********************************************
*/
package com.hopsun.tppas.api.expert.action;

import java.io.File;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.struts2.ServletActionContext;
import com.hopsun.framework.base.action.BaseAction;
import com.hopsun.framework.base.bean.Pager;
import com.hopsun.scenter.entity.ScUsers;
import com.hopsun.tppas.api.expert.service.TexpertScoreService;
import com.hopsun.tppas.api.superadmin.service.MitemService;
import com.hopsun.tppas.api.superadmin.service.TattachmentService;
import com.hopsun.tppas.api.superadmin.service.TprojectTypeService;
import com.hopsun.tppas.common.Constants;
import com.hopsun.tppas.common.FileDownLoad;
import com.hopsun.tppas.entity.Mitem;
import com.hopsun.tppas.entity.Tattachment;
import com.hopsun.tppas.entity.TexpertScore;

/**
 * @comment 专家评审管理
 * @author wangxiaodong
 * @DATE: 2013-08-27 @TIME: 下午2:09:37
 * @Vsersion: 1.0
 */
public class TexpertScoreAction extends BaseAction{
  
	private static final long serialVersionUID = -4696972132687985776L;
	
	/**专家评审管理service*/
	@Resource
	private TexpertScoreService texpertScoreService;
	
	/**项目分类service*/
	@Resource
	private TprojectTypeService tprojectTypeService;
	
	/**码表service*/
	@Resource
	private MitemService apiMitemService;
	
	/**附件service*/
	@Resource
	private TattachmentService apiTattachmentService;
	
	/** 专家评分对象 */
	private TexpertScore texpertScore;
	
	/** 专家评分ID */
	private String scoreId;
	
	/**项目名称*/
	private String projectName;
	
	/**申报单位*/
	private String applicationUnit;
	
	/**项目ID*/
	private String projectId;
	
	/** 翻页 */
	private int pageNo;
	
	/**项目详细信息左边菜单*/
	private List<Mitem> menuList;
	
	/**查看项目状态*/
	private String applyStatus = "0";
	
	/**附件清单*/
	private Tattachment tattachment;
	
	/**信息提示*/
	private String retMsg;
	
	/**评审附件ID*/
	private String attachmentId;
	
	/**
	 * 得到专家评审列表
	 * @comments 
	 * @return
	 * @version 1.0
	 */
	public String auditManager(){
		HttpSession session = this.getRequest().getSession();
		ScUsers user = (ScUsers) session.getAttribute("sysUser");
		// 如果用户为空或者企业为空，退出系统
		if (user == null || ("").equals(user.getUserId())) {
			return "LogOut";
		}
		
		return "auditManager";
	}
	
	/**
	 * 得到专家评审列表
	 * @comments 
	 * @return
	 * @version 1.0
	 */
	public String getAuditList(){
		HttpSession session = this.getRequest().getSession();
		session.setAttribute(Constants.SESSION_CMDKEY, "texpertScoreAction");
		ScUsers user = (ScUsers) session.getAttribute("sysUser");
		// 如果用户为空或者企业为空，退出系统
		if (user == null || ("").equals(user.getUserId())) {
			return "LogOut";
		}
		
		// 翻页
		if (pager == null && this.getPageNo() == 0) {
			pager = new Pager();
		} else {
			pager = new Pager();
			pager.setPageNumber(this.getPageNo());
		}
		Map<String,Object> param = new HashMap<String,Object>();
		param.put("expertId", "402881d341b4a7110141b4e5d4580000");
		param.put("projectName", projectName);
		param.put("applicationUnit", applicationUnit);
		
		pager=texpertScoreService.getAuditList(param, pager.getPageNumber(), pager.getPageSize());
		
		return "auditList";
	}
	
	/**
	 * @comments  显示更新专家评分
	 * @return
	 * @Version 1.0
	 */
	public String updateExpertScore(){
		
		// 取得专家评分ID
		this.scoreId = this.getScoreId();
		
		// 取得专家评分内容
		this.texpertScore = texpertScoreService.get(scoreId);
		
		return "updateProgress";
	}
	
	/**
	 * 专家评审时项目详细信息查看--高新处
	 * @comments 
	 * @return
	 * @version 1.0
	 */
	public String auditHighTechProjectManager(){
		HttpSession session = this.getRequest().getSession();
		String cmdKey = (String) session.getAttribute(Constants.SESSION_CMDKEY);
		ScUsers user = (ScUsers) session.getAttribute("sysUser");
		// 如果用户为空或者企业为空，退出系统
		if (user == null || ("").equals(user.getUserId()) ||!"texpertScoreAction".equals(cmdKey)) {
			return "LogOut";
		}
		
		if(tprojectTypeService.getIsWrite(projectId)){
			// 菜单列表
			this.menuList = apiMitemService.getListByTypeId(Constants.API_PROJECT_REPORT_MENU_TYPE);
		}
		else{
			// 菜单列表
			this.menuList = apiMitemService.getListByTypeId(Constants.API_PROJECT_REPORT_MENU_TYPE, Constants.API_PROJECT_REPORT_MENU_14);
		}
		
		return "highTechManager";
	}
	
	/**
	 * 专家评审时项目详细信息查看--非高新处
	 * @comments 
	 * @return
	 * @version 1.0
	 */
	public String auditOtherProjectManager(){
		HttpSession session = this.getRequest().getSession();
		String cmdKey = (String) session.getAttribute(Constants.SESSION_CMDKEY);
		ScUsers user = (ScUsers) session.getAttribute("sysUser");
		// 如果用户为空或者企业为空，退出系统
		if (user == null || ("").equals(user.getUserId()) ||!"texpertScoreAction".equals(cmdKey)) {
			return "LogOut";
		}
		
		//非高新处菜单
		if(tprojectTypeService.getIsWrite(projectId)){
			this.menuList = apiMitemService.getListByTypeId(Constants.API_REPORT_NONTECT_MENU_TYPE);
		}else{
			this.menuList = apiMitemService.getListByTypeId(Constants.API_REPORT_NONTECT_MENU_TYPE, Constants.API_REPORT_NONTECT_MENU_16);
		}
		
		return "otherManager";
	}
	
	/**
	 * 专家评审初始画面
	 * @comments 
	 * @return
	 * @version 1.0
	 */
	public String initExpertAudit(){
		HttpSession session = this.getRequest().getSession();
		ScUsers user = (ScUsers) session.getAttribute("sysUser");
		// 如果用户为空或者企业为空，退出系统
		if (user == null || ("").equals(user.getUserId())) {
			return "LogOut";
		}
		
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("dataId", scoreId);
		map.put("tableName",apiTattachmentService.getTableName(TexpertScore.class) );
		tattachment = apiTattachmentService.getTattachmentByCondition(map);
		
		return "initExpertAudit";
	}
	
	/**
	 * 专家评审模板下载
	 * @comments 
	 * @throws Exception
	 * @version 1.0
	 */
	public void downLoadFile() throws Exception {
		// 取得登录用户的信息
    	HttpSession session = this.getRequest().getSession();
    	ScUsers user = (ScUsers) session.getAttribute("sysUser");
    	if(user !=null && user.getUserId() !=null && !"".equals(user.getUserId())){
			OutputStream outStream = null;
			InputStream inStream = null;
			try {
				// 取得配置的附件上传路径
				Mitem mitem = apiMitemService.get(Constants.PDF_TEMPLATE_PATH);
				String filePath = "";
				if(mitem !=null){
					String inputPath = mitem.getItemDesc();
					String lastStr  = inputPath.substring(inputPath.length() - 1 , inputPath.length());
					// 判断目录是否完整
					if (!"/".equals(lastStr)) {
						inputPath = inputPath + "/";
					}
					filePath =inputPath + this.getText("expert_audit_template_server_name");;
				}
				
				HttpServletResponse response = ServletActionContext.getResponse();
				//File file = new File(filePath);
				String fileName = this.getText("expert_audit_template_shwo_name")+".xls";
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
	 * 删除之前评审附件
	 * @comments 
	 * @return
	 * @throws Exception
	 * @version 1.0
	 */
	public void deleAuditFile() throws Exception {
		try {
			
			// 取得附件ID
			attachmentId = this.getAttachmentId();
			// 取得附件信息
			tattachment = apiTattachmentService.get(attachmentId);
			// 取得附件上传地址
			String filePath = tattachment.getAttachmentAddress();

			// 取得配置的附件上传路径
			Mitem mitem = apiMitemService.get(Constants.FILE_UPLOAD_PATH);
			
			if(mitem !=null){
				filePath = mitem.getItemDesc() + filePath;
			}

			File taccFile = new File(filePath);
			// 文件存在检查
			if (taccFile.exists()) {
				// 文件删除检查
				if (!taccFile.delete()) {
					// 删除失败
					this.setRetMsg(this.getText("opt_del_err"));
				}else{
					
					apiTattachmentService.delete(attachmentId);
					//texpertScoreService.delete(scoreId);
					this.setRetMsg(this.getText("opt_del_suc"));
				}
			}
		} catch (Exception ex) {
			this.setRetMsg(this.getText("opt_del_err"));
		}
	}

	public TexpertScore getTexpertScore() {
		return texpertScore;
	}

	public void setTexpertScore(TexpertScore texpertScore) {
		this.texpertScore = texpertScore;
	}

	public String getScoreId() {
		return scoreId;
	}

	public void setScoreId(String scoreId) {
		this.scoreId = scoreId;
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

	public int getPageNo() {
		return pageNo;
	}

	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}

	public List<Mitem> getMenuList() {
		return menuList;
	}

	public void setMenuList(List<Mitem> menuList) {
		this.menuList = menuList;
	}

	public String getProjectId() {
		return projectId;
	}

	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}

	public String getApplyStatus() {
		return applyStatus;
	}

	public void setApplyStatus(String applyStatus) {
		this.applyStatus = applyStatus;
	}

	public Tattachment getTattachment() {
		return tattachment;
	}

	public void setTattachment(Tattachment tattachment) {
		this.tattachment = tattachment;
	}

	public String getRetMsg() {
		return retMsg;
	}

	public void setRetMsg(String retMsg) {
		this.retMsg = retMsg;
	}

	public String getAttachmentId() {
		return attachmentId;
	}

	public void setAttachmentId(String attachmentId) {
		this.attachmentId = attachmentId;
	}
}
