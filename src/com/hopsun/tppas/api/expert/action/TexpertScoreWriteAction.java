/*************** 版权声明***************
*
* Copyright (C) 2012 西安辉盛科技发展有限责任公司.
*
********************************************
*/
package com.hopsun.tppas.api.expert.action;

import java.io.OutputStream;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import jxl.Workbook;
import jxl.format.Alignment;
import jxl.format.Border;
import jxl.format.BorderLineStyle;
import jxl.format.VerticalAlignment;
import jxl.write.Label;
import jxl.write.WritableCellFormat;
import jxl.write.WritableFont;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import com.hopsun.framework.base.action.BaseAction;
import com.hopsun.framework.base.bean.Pager;
import com.hopsun.scenter.entity.ScUsers;
import com.hopsun.tppas.api.expert.service.TexpertScoreService;
import com.hopsun.tppas.common.CommonTool;
import com.hopsun.tppas.common.Constants;
import com.hopsun.tppas.entity.TexpertReviewComments;
import com.hopsun.tppas.entity.TexpertScore;
import com.hopsun.tppas.entity.TprojectApplication;
import com.hopsun.tppas.api.report.service.TprojectApplicationService;
import com.hopsun.tppas.api.superadmin.service.TprojectTypeManagerService;

/**
 * @comment 专家评审意见填写
 * @author wangxiaodong
 * @DATE: 2013-10-29 @TIME: 下午4:09:37
 * @Vsersion: 1.0
 */
public class TexpertScoreWriteAction extends BaseAction{
  
	private static final long serialVersionUID = -3911463822877009343L;

	/**专家评审管理service*/
	@Resource
	private TexpertScoreService texpertScoreService;
	
	/**项目申报service*/
	@Resource
	private TprojectApplicationService tprojectApplicationService;
	
	/**项目分类管理专员service*/
	@Resource
	private TprojectTypeManagerService tprojectTypeManagerService;
	
	/**组ID*/
	private String groupId;
	
	/**项目ID*/
	private String projectId;
	
	/**是否填写*/
	private String isWrite;
	
	/**项目集合*/
	private List<TprojectApplication> projectList;
	
	/**技术专家评审集合*/
	private List<TexpertScore> technologyList;
	
	/**投资专家评审集合*/
	private List<TexpertScore> investmentList;
	
	/** 专家评分对象 */
	private TexpertScore texpertScore;
	
	/**专家评审模板-技术模板*/
	private TexpertReviewComments technologyReviewComments;
	
	/**专家评审模板-投资模板*/
	private TexpertReviewComments investmentReviewComments;
	
	/**项目对象*/
	private TprojectApplication tprojectApplication;
	
	/** 翻页 */
	private int pageNo;
	
	/**信息提示*/
	private String retMsg;
	
	/**跳转地址*/
	private String retUrl;
	
	/**项目集合json*/
	private String projectListStr;
	
	/**项目名称*/
	private String projectName;
	
	/**申报单位*/
	private String applyCompany;
	
	/**计划类别*/
	private String projectType1;
	
	/**项目分类*/
	private String projectType2;
	
	/**审核状态*/
	private String auditStatus;
	
	/**项目分组*/
	private String projectGroup;
	
	/**项目技术专家平均分*/
	private double projectTechnologyAverage;
	
	/**项目投资专家平均分*/
	private double projectInvestmentAverage;
	
	/**一组下项目的索引下标*/
	private String projectIndex;
	
	/**操作类型 0-保存   1-下一个*/
	private String optType;
	
	/**
	 * 通过组ID查询该组下的所有项目列表
	 * @comments 
	 * @return
	 * @version 1.0
	 */
	public String projectListManager(){
		HttpSession session = this.getRequest().getSession();
		ScUsers user = (ScUsers) session.getAttribute("sysUser");
		// 如果用户为空或者企业为空，退出系统
		if (user == null || ("").equals(user.getUserId())) {
			return "LogOut";
		}
		
		return "projectManager";
	}
	
	/**
	 * 通过组ID查询该组下的所有项目列表
	 * @comments 
	 * @return
	 * @version 1.0
	 */
	public String getProjectListByGroupId(){
		HttpSession session = this.getRequest().getSession();
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
		param.put("groupId", groupId);
		param.put("isWrite", isWrite);
		param.put("projectName", projectName);
		
		pager = texpertScoreService.getProjecsByGroupId(param, pager.getPageNumber(), pager.getPageSize());

		return "projectList";
	}
	
	/**
	 * 通过组ID查询该组下的所有项目
	 * @comments 
	 * @return
	 * @version 1.0
	 */
	public String getProjectsByGroupId(){
		HttpSession session = this.getRequest().getSession();
		ScUsers user = (ScUsers) session.getAttribute("sysUser");
		// 如果用户为空或者企业为空，退出系统
		if (user == null || ("").equals(user.getUserId())) {
			return "LogOut";
		}
		
		Map<String,Object> param = new HashMap<String,Object>();
		param.put("groupId", groupId);
		if(CommonTool.IsNotEmpty(isWrite)){
			param.put("isWrite", isWrite);
			projectList = texpertScoreService.getProjectsByWriteState(param);
		}else{
			projectList = tprojectApplicationService.getProjectList(param);
		}
		this.projectId = this.getProjectId();
		
		return "initScoreWrite";
	}
	
	/**
	 * 通过选择填写状态查询对应的项目
	 * @comments 
	 * @return
	 * @version 1.0
	 */
	public String getProjectsByWriteState(){
		HttpSession session = this.getRequest().getSession();
		ScUsers user = (ScUsers) session.getAttribute("sysUser");
		// 如果用户为空或者企业为空，退出系统
		if (user == null || ("").equals(user.getUserId())) {
			return "LogOut";
		}
		
		Map<String,Object> param = new HashMap<String,Object>();
		param.put("groupId", groupId);
		param.put("isWrite", isWrite);
		projectList = texpertScoreService.getProjectsByWriteState(param);
		
		StringBuffer dataStr = new StringBuffer();
		if (projectList != null) {
			for (int i = 0; i < projectList.size(); i++) {
				dataStr.append(projectList.get(i).getProjectId());
				dataStr.append(",");
				dataStr.append(projectList.get(i).getProjectName());
				if (i != projectList.size() - 1) {
					dataStr.append(",");
				}
			}
		}
		this.projectListStr = dataStr.toString();
		
		return "auditProjectList";
	}
	
	
	
	/**
	 * 通过项目ID查询项目评分记录
	 * @comments 
	 * @return
	 * @version 1.0
	 */
	@SuppressWarnings("unchecked")
	public String getScoreByProjectId(){
		HttpSession session = this.getRequest().getSession();
		ScUsers user = (ScUsers) session.getAttribute("sysUser");
		session.setAttribute(Constants.SESSION_CMDKEY, "TexpertScoreWriteAction");
		// 如果用户为空或者企业为空，退出系统
		if (user == null || ("").equals(user.getUserId())) {
			return "LogOut";
		}
		
		tprojectApplication = tprojectApplicationService.get(projectId);
		Map<String,Object> valueMap = texpertScoreService.getTexpertScoresByProjectId(projectId);
		//技术专家评审集合
		technologyList = (List<TexpertScore>) valueMap.get("technologyList");
		//投资专家评审集合
		investmentList = (List<TexpertScore>) valueMap.get("investmentList");
		//技术专家评审模板
		technologyReviewComments = (TexpertReviewComments) (valueMap.get("technologyReviewComments")==null?new TexpertReviewComments():valueMap.get("technologyReviewComments"));
		//投资专家评审模板
		investmentReviewComments = (TexpertReviewComments) (valueMap.get("investmentReviewComments")==null?new TexpertReviewComments():valueMap.get("investmentReviewComments"));
		
		return "expertScoreForm";
	}
	
	/**
	 * 通过项目ID查询项目评分记录
	 * @comments 
	 * @return
	 * @version 1.0
	 */
	@SuppressWarnings("unchecked")
	public String getNextProjectScore(){
		HttpSession session = this.getRequest().getSession();
		ScUsers user = (ScUsers) session.getAttribute("sysUser");
		// 如果用户为空或者企业为空，退出系统
		if (user == null || ("").equals(user.getUserId())) {
			return "LogOut";
		}
		
		Map<String,Object> paramValue = new HashMap<String,Object>();
		//当前项目ID
		paramValue.put("projectId",projectId);
		//组ID
		paramValue.put("projectIndex",projectIndex);
		//当前项目索引下标
		paramValue.put("groupId",groupId);
		
		Map<String,Object> map = texpertScoreService.getNextProjectScore(paramValue);
		
		this.groupId = (String) map.get("groupId");
		this.projectId = (String) map.get("projectId");
		this.projectIndex = String.valueOf(map.get("projectIndex"));
		String isMsg = (String) map.get("retMsg");
		if(CommonTool.IsNotEmpty(isMsg)){
			if("no".equals(isMsg)){
				this.retMsg = this.getText("next_project_no__info");
			}
		}
		
		tprojectApplication = tprojectApplicationService.get(projectId);
		Map<String,Object> valueMap = texpertScoreService.getTexpertScoresByProjectId(projectId);
		//技术专家评审集合
		technologyList = (List<TexpertScore>) valueMap.get("technologyList");
		//投资专家评审集合
		investmentList = (List<TexpertScore>) valueMap.get("investmentList");
		//技术专家评审模板
		technologyReviewComments = (TexpertReviewComments) (valueMap.get("technologyReviewComments")==null?new TexpertReviewComments():valueMap.get("technologyReviewComments"));
		//投资专家评审模板
		investmentReviewComments = (TexpertReviewComments) (valueMap.get("investmentReviewComments")==null?new TexpertReviewComments():valueMap.get("investmentReviewComments"));
		
		return "expertScoreForm";
	}
	
	/**
	 * 通过项目ID查询项目评分记录
	 * @comments 
	 * @return
	 * @version 1.0
	 */
	public String saveExpertScore(){
		HttpSession session = this.getRequest().getSession();
		ScUsers user = (ScUsers) session.getAttribute("sysUser");
		session.setAttribute(Constants.SESSION_CMDKEY, "TexpertScoreWriteAction");
		// 如果用户为空或者企业为空，退出系统
		if (user == null || ("").equals(user.getUserId())) {
			return "LogOut";
		}
		
		Map<String,Object> valueMap = new HashMap<String,Object>();
		//技术专家评审集合
		valueMap.put("technologyList",this.getTechnologyList());
		//投资专家评审集合
		valueMap.put("investmentList",this.getInvestmentList());
		//项目ID
		valueMap.put("projectId", projectId);
		//项目技术专家平均分
		valueMap.put("projectTechnologyAverage", projectTechnologyAverage);
		//项目投资专家平均分
		valueMap.put("projectInvestmentAverage", projectInvestmentAverage);
		//操作用户
		valueMap.put("user", user);
		
		texpertScoreService.saveExpertScore(valueMap);
		//保存
		if("0".equals(optType)){
			this.setRetMsg(this.getText("opt_save_suc"));
			this.setRetUrl(super.getRequest().getContextPath()+ "/api/expert/texpertScoreWriteAction!getScoreByProjectId.action?groupId="+groupId+"&projectId="+projectId+"&projectIndex="+projectIndex+"&now="+ new Date().getTime());
		}else{
			//下一个
			this.setRetMsg(this.getText("opt_save_suc"));
			this.setRetUrl(super.getRequest().getContextPath()+ "/api/expert/texpertScoreWriteAction!getNextProjectScore.action?projectId="+projectId+"&projectIndex="+projectIndex+"&groupId="+groupId+"&now="+ new Date().getTime());
		}
		
		return "systemInfoMain";
	}
	
	/**
	 * 以组为单位打印专家评审记录
	 * @comments 
	 * @version 1.0
	 * @throws Exception 
	 */
	@SuppressWarnings("unchecked")
	public void printExpertScoreByGroup() throws Exception{
		HttpSession session = this.getRequest().getSession();
		HttpServletResponse response = this.getResponse();
		ScUsers user = (ScUsers) session.getAttribute("sysUser");
		// 如果用户为空或者企业为空，退出系统
		if (user == null || ("").equals(user.getUserId())) {
			
		}
		
		//得到需要打印的专家评审记录
		Map<String,Object> resultMap = texpertScoreService.printExpertScoreByGroup(groupId);
		//专家集合
		List<Object[]> expertList = (List<Object[]>) resultMap.get("expertList");
		//项目打分集合
		List<List<Object>> resultList = (List<List<Object>>) resultMap.get("resultList");
		//专家个数
		//int expertCount = (Integer) resultMap.get("expertCount");
		String exportFileName = this.getText("expert_audit_file_name");
		
		OutputStream out = null;
    	WritableWorkbook workbook = null;
        try {
        	// 清空输出流   
            response.reset();
            // 设定输出文件头   
            response.setHeader("Content-Disposition", "attachment; filename=\"" + new String(exportFileName.getBytes("GB2312"),"ISO-8859-1") + ".xls\"");
            // 定义输出类型 
            response.setContentType("application/vnd.ms-excel");
        	// 取得输出流   
        	out = response.getOutputStream();
            // 建立excel文件 
            workbook = Workbook.createWorkbook(out);  
           // for (int i = 0; i < sheetNames.length; i++) {
        	//outSheet.mergeCells(1, 1, 1, 5); //合并单元格，参数格式（开始列，开始行，结束列，结束行）
        	 // 写入页名
            WritableSheet ws = workbook.createSheet(this.getText("expert_audit_file_name"), 0);
            // 设置单元格的文字格式
            WritableFont wf = new WritableFont(WritableFont.createFont("宋体"), 10, WritableFont.BOLD, false);
            WritableCellFormat wcf = new WritableCellFormat(wf);
            // 设置边框
            wcf.setBorder(Border.ALL, BorderLineStyle.THIN);//垂直居中显示
            wcf.setVerticalAlignment(VerticalAlignment.CENTRE); // 垂直对齐
            wcf.setAlignment(Alignment.CENTRE); // 水平对齐
            wcf.setWrap(false); // 是否换行
            wcf.setFont(wf);
            ws.setRowView(0, 450);
            ws.setColumnView(0,8);
            ws.setColumnView(1,50);
            
            //数据单元格格式
            WritableFont dataFont = new WritableFont(WritableFont.createFont("宋体"), 10, WritableFont.NO_BOLD, false);
            WritableCellFormat dataFormat = new WritableCellFormat(dataFont);
            // 设置边框
            dataFormat.setBorder(Border.ALL, BorderLineStyle.THIN);//垂直居中显示
            dataFormat.setVerticalAlignment(VerticalAlignment.CENTRE); // 垂直对齐
            dataFormat.setAlignment(Alignment.CENTRE); // 水平对齐
            dataFormat.setWrap(false); // 是否换行
            dataFormat.setFont(dataFont);
            
            // 写入内容
            int rowNum = 0;
            
            //合并开始列
    		int startRow = 2;
    		
            if(expertList!=null&&expertList.size()>0){
            	 /****************第一行写入专家**************************/
                //序号
                Label cell1 = new Label(0, rowNum, this.getText("expert_audit_xh"),wcf);
        		ws.addCell(cell1);
        		//项目名称
        		Label cell2 = new Label(1, rowNum, this.getText("expert_audit_project_name"),wcf);
        		ws.addCell(cell2);
        		
            	for(int t=0;t<expertList.size();t++){
            		ws.mergeCells(startRow, 0, startRow+6, 0);//合并单元格，参数格式（开始列，开始行，结束列，结束行）
            		Object[] obj = expertList.get(t);
            		Label cell = new Label(startRow, rowNum, String.valueOf(obj[1]==null?"":obj[1]),wcf);
            		ws.addCell(cell);
            		startRow = startRow+7;
            	}
            	
            	//技术专家平均分
                Label cell3 = new Label(startRow, rowNum, this.getText("expert_audit_technology_complexAverage"),wcf);
        		ws.addCell(cell3);
        		//投资专家平均分
        		Label cell4 = new Label(startRow+1, rowNum, this.getText("expert_audit_investment_complexAverage"),wcf);
        		ws.addCell(cell4);
        		//技术专家评审意见
                Label cell5 = new Label(startRow+2, rowNum, this.getText("expert_audit_technology_finalResult"),wcf);
        		ws.addCell(cell5);
        		//投资专家评审意见
        		Label cell6 = new Label(startRow+3, rowNum, this.getText("expert_audit_investment_finalResult"),wcf);
        		ws.addCell(cell6);
        		
            	rowNum++;
            }
        
            /*****************写入项目评审记录***********************************/
            // 循环着把数据写入Excel文件中
            if(resultList!=null&&resultList.size()>0){
            	for(int j = 0; j < resultList.size(); j++) {
            		 ws.setRowView(rowNum, 400);
                	//每一行数据。
                    List<Object> cells = resultList.get(j);
                    // 写第一列内容
                    Label cell11 = new Label(0, rowNum, String.valueOf(j+1),dataFormat);
                    ws.addCell(cell11);
                    //后面列循环写入
                    for(int n = 0; n < cells.size(); n++) {
                    	 Label cell = new Label(n+1, rowNum, String.valueOf(cells.get(n)),dataFormat);
                         ws.addCell(cell);
                    }
                    rowNum++;
                }
            	
            	/**********************写入备注********************************************/
                //综合评审意见：A:重点推荐  B:推荐  C:备选  D:落选         
                //注：90分以上为重点推荐； 80－89分为推荐； 60-79分为备选； 60分以下为落选  
                //数据单元格格式
                WritableFont remarkFont = new WritableFont(WritableFont.createFont("宋体"), 10, WritableFont.BOLD, false);
                WritableCellFormat remarkFormat = new WritableCellFormat(dataFont);
                // 设置边框
                remarkFormat.setBorder(Border.ALL, BorderLineStyle.NONE);//垂直居中显示
                remarkFormat.setVerticalAlignment(VerticalAlignment.CENTRE); // 垂直对齐
                remarkFormat.setAlignment(Alignment.LEFT); // 水平对齐
                //remarkFormat.setWrap(false); // 是否换行
                remarkFormat.setFont(remarkFont);

                ws.setRowView(rowNum, 400);
                Label cell11 = new Label(0, rowNum, this.getText("expert_audit_remark1"),remarkFormat);
                ws.addCell(cell11);
                ws.mergeCells(0, rowNum, startRow+3, rowNum);//合并单元格，参数格式（开始列，开始行，结束列，结束行）
                ws.setRowView(rowNum+1, 400);
                Label cell22 = new Label(0, rowNum+1, this.getText("expert_audit_remark2"),remarkFormat);
                ws.addCell(cell22);
                ws.mergeCells(0, rowNum+1, startRow+3, rowNum+1);//合并单元格，参数格式（开始列，开始行，结束列，结束行）
            }
            //}

            workbook.write();           
            out.flush();
            response.flushBuffer(); 
        } catch (Exception e) {
            // 异常发生的场合，抛出异常。
            throw e;
        } finally {
        	if(null != workbook) {
                workbook.close();
        	}
        	if(null != out) {
                out.close();
        	}
        }
		
	}
	
	/**
	 * 以项目为单位打印专家评审记录
	 * @comments 
	 * @version 1.0
	 * @throws Exception 
	 */
	@SuppressWarnings("unchecked")
	public void printExpertScoreByProject() throws Exception{
		HttpSession session = this.getRequest().getSession();
		HttpServletResponse response = this.getResponse();
		ScUsers user = (ScUsers) session.getAttribute("sysUser");
		// 如果用户为空或者企业为空，退出系统
		if (user == null || ("").equals(user.getUserId())) {
			
		}
		
		//得到需要打印的专家评审记录
		Map<String,Object> resultMap = texpertScoreService.printExpertScoreByProject(projectId);
		//专家集合
		List<String> expertList = (List<String>) resultMap.get("expertList");
		//项目打分集合
		List<List<Object>> resultList = (List<List<Object>>) resultMap.get("resultList");
		
		String exportFileName = this.getText("expert_audit_file_name");
		
		OutputStream out = null;
    	WritableWorkbook workbook = null;
        try {
        	// 清空输出流   
            response.reset();
            // 设定输出文件头   
            response.setHeader("Content-Disposition", "attachment; filename=\"" + new String(exportFileName.getBytes("GB2312"),"ISO-8859-1") + ".xls\"");
            // 定义输出类型 
            response.setContentType("application/vnd.ms-excel");
        	// 取得输出流   
        	out = response.getOutputStream();
            // 建立excel文件 
            workbook = Workbook.createWorkbook(out);  
           // for (int i = 0; i < sheetNames.length; i++) {
        	//outSheet.mergeCells(1, 1, 1, 5); //合并单元格，参数格式（开始列，开始行，结束列，结束行）
        	 // 写入页名
            WritableSheet ws = workbook.createSheet(this.getText("expert_audit_file_name"), 0);
            // 设置单元格的文字格式
            WritableFont wf = new WritableFont(WritableFont.createFont("宋体"), 10, WritableFont.BOLD, false);
            WritableCellFormat wcf = new WritableCellFormat(wf);
            // 设置边框
            wcf.setBorder(Border.ALL, BorderLineStyle.THIN);//垂直居中显示
            wcf.setVerticalAlignment(VerticalAlignment.CENTRE); // 垂直对齐
            wcf.setAlignment(Alignment.CENTRE); // 水平对齐
            wcf.setWrap(false); // 是否换行
            wcf.setFont(wf);
            ws.setRowView(0, 450);
            ws.setColumnView(0,8);
            ws.setColumnView(1,50);
            
            //数据单元格格式
            WritableFont dataFont = new WritableFont(WritableFont.createFont("宋体"), 10, WritableFont.NO_BOLD, false);
            WritableCellFormat dataFormat = new WritableCellFormat(dataFont);
            // 设置边框
            dataFormat.setBorder(Border.ALL, BorderLineStyle.THIN);//垂直居中显示
            dataFormat.setVerticalAlignment(VerticalAlignment.CENTRE); // 垂直对齐
            dataFormat.setAlignment(Alignment.CENTRE); // 水平对齐
            dataFormat.setWrap(false); // 是否换行
            dataFormat.setFont(dataFont);
            
            // 写入内容
            int rowNum = 0;
    		
    		//合并开始列
    		int startRow = 2;
    		
            if(expertList!=null&&expertList.size()>0){
            	/****************第一行写入专家**************************/
                //序号
                Label cell1 = new Label(0, rowNum,this.getText("expert_audit_xh"),wcf);
        		ws.addCell(cell1);
        		//项目名称
        		Label cell2 = new Label(1, rowNum, this.getText("expert_audit_project_name"),wcf);
        		ws.addCell(cell2);
        		
            	for(int t=0;t<expertList.size();t++){
            		ws.mergeCells(startRow, 0, startRow+6, 0);//合并单元格，参数格式（开始列，开始行，结束列，结束行）
            		Label cell = new Label(startRow, rowNum, expertList.get(t),wcf);
            		ws.addCell(cell);
            		startRow = startRow+7;
            	}
            	
            	//技术专家平均分
                Label cell3 = new Label(startRow, rowNum, this.getText("expert_audit_technology_complexAverage"),wcf);
        		ws.addCell(cell3);
        		//投资专家平均分
        		Label cell4 = new Label(startRow+1, rowNum, this.getText("expert_audit_investment_complexAverage"),wcf);
        		ws.addCell(cell4);
        		//技术专家评审意见
                Label cell5 = new Label(startRow+2, rowNum, this.getText("expert_audit_technology_finalResult"),wcf);
        		ws.addCell(cell5);
        		//投资专家评审意见
        		Label cell6 = new Label(startRow+3, rowNum, this.getText("expert_audit_investment_finalResult"),wcf);
        		ws.addCell(cell6);
        		
            	rowNum++;
            }
        
            /*****************写入项目评审记录***********************************/
            // 循环着把数据写入Excel文件中
            if(resultList!=null&&resultList.size()>0){
            	for(int j = 0; j < resultList.size(); j++) {
            		 ws.setRowView(rowNum, 400);
                	//每一行数据。
                    List<Object> cells = resultList.get(j);
                    // 写第一列内容
                    Label cell11 = new Label(0, rowNum, String.valueOf(j+1),dataFormat);
                    ws.addCell(cell11);
                    //后面列循环写入
                    for(int n = 0; n < cells.size(); n++) {
                    	 Label cell = new Label(n+1, rowNum, String.valueOf(cells.get(n)),dataFormat);
                         ws.addCell(cell);
                    }
                    rowNum++;
                }
            	
            	 /**********************写入备注********************************************/
                //综合评审意见：A:重点推荐  B:推荐  C:备选  D:落选         
                //注：90分以上为重点推荐； 80－89分为推荐； 60-79分为备选； 60分以下为落选  
                //数据单元格格式
                WritableFont remarkFont = new WritableFont(WritableFont.createFont("宋体"), 10, WritableFont.BOLD, false);
                WritableCellFormat remarkFormat = new WritableCellFormat(dataFont);
                // 设置边框
                remarkFormat.setBorder(Border.ALL, BorderLineStyle.NONE);//垂直居中显示
                remarkFormat.setVerticalAlignment(VerticalAlignment.CENTRE); // 垂直对齐
                remarkFormat.setAlignment(Alignment.LEFT); // 水平对齐
                //remarkFormat.setWrap(false); // 是否换行
                remarkFormat.setFont(remarkFont);

                ws.setRowView(rowNum, 400);
                Label cell11 = new Label(0, rowNum,this.getText("expert_audit_remark1"),remarkFormat);
                ws.addCell(cell11);
                ws.mergeCells(0, rowNum, startRow+3, rowNum);//合并单元格，参数格式（开始列，开始行，结束列，结束行）
                ws.setRowView(rowNum+1, 400);
                Label cell22 = new Label(0, rowNum+1,this.getText("expert_audit_remark2"),remarkFormat);
                ws.addCell(cell22);
                ws.mergeCells(0, rowNum+1, startRow+3, rowNum+1);//合并单元格，参数格式（开始列，开始行，结束列，结束行）
            }
            //}

            workbook.write();           
            out.flush();
            response.flushBuffer(); 
        } catch (Exception e) {
            // 异常发生的场合，抛出异常。
            throw e;
        } finally {
        	if(null != workbook) {
                workbook.close();
        	}
        	if(null != out) {
                out.close();
        	}
        }
		
	}
	
	/**
	 * 根据查询条件以组为单位打印专家评审记录
	 * @comments 
	 * @version 1.0
	 * @throws Exception 
	 */
	@SuppressWarnings("unchecked")
	public void printExpertScoreAll() throws Exception {
		HttpServletRequest request = this.getRequest();
		HttpSession session = request.getSession();
		HttpServletResponse response = this.getResponse();
		ScUsers user = (ScUsers) session.getAttribute("sysUser");
		// 如果用户为空或者企业为空，退出系统
		if (user == null || ("").equals(user.getUserId())) {

		}

		Map<String, Object> paramMap = new HashMap<String, Object>();

		// 封装查询条件
		// 部门ID
		// paramMap.put("departmentId", user.getScDept().getDeptId());

		// 项目名称
		paramMap.put("projectName", new String(request.getParameter("projectName").getBytes("ISO-8859-1"), "UTF-8"));

		// 申报单位
		paramMap.put("applyCompany", new String(request.getParameter("applyCompany").getBytes("ISO-8859-1"), "UTF-8"));

		// 计划类别
		String projectTypeString = tprojectTypeManagerService.getProjectTypeStrByUser(user);
		paramMap.put("projectTypeString", projectTypeString);

		// 计划类别
		paramMap.put("projectType1", projectType1);

		// 项目分类
		paramMap.put("projectType2", projectType2);

		// 审核状态
		// paramMap.put("auditStatus", auditStatus);

		// 项目分组
		paramMap.put("projectGroup", projectGroup);

		// 查询hql区分
		paramMap.put("isAssociate", "isAssociate");

		// 用户Id
		// paramMap.put("userId", user.getUserId());

		// 得到需要打印的专家评审记录
		List<Map<String, Object>> resultList = texpertScoreService.printExpertScoreAll(paramMap);

		String exportFileName = this.getText("expert_audit_file_name");

		OutputStream out = null;
		WritableWorkbook workbook = null;
		try {
			// 清空输出流
			response.reset();
			// 设定输出文件头
			response.setHeader("Content-Disposition", "attachment; filename=\"" + new String(exportFileName.getBytes("GB2312"), "ISO-8859-1") + ".xls\"");
			// 定义输出类型
			response.setContentType("application/vnd.ms-excel");
			// 取得输出流
			out = response.getOutputStream();
			// 建立excel文件
			workbook = Workbook.createWorkbook(out);
			if (resultList != null && resultList.size() > 0) {
				for (int i = 0; i < resultList.size(); i++) {
					// outSheet.mergeCells(1, 1, 1, 5);
					// //合并单元格，参数格式（开始列，开始行，结束列，结束行）
					Map<String, Object> valueMap = resultList.get(i);
					// sheet名称
					String sheetName = (String) valueMap.get("groupName");
					// 专家集合
					List<Object[]> expertList = (List<Object[]>) valueMap.get("expertList");
					// 项目专家评审集合
					List<Map<String, Object>> allResult = (List<Map<String, Object>>) valueMap.get("projectList");
					// 写入页名
					WritableSheet ws = workbook.createSheet(sheetName, i);
					// 设置单元格的文字格式
					WritableFont wf = new WritableFont(WritableFont.createFont("宋体"), 10, WritableFont.BOLD, false);
					WritableCellFormat wcf = new WritableCellFormat(wf);
					// 设置边框
					wcf.setBorder(Border.ALL, BorderLineStyle.THIN);// 垂直居中显示
					wcf.setVerticalAlignment(VerticalAlignment.CENTRE); // 垂直对齐
					wcf.setAlignment(Alignment.CENTRE); // 水平对齐
					wcf.setWrap(false); // 是否换行
					wcf.setFont(wf);
					ws.setRowView(0, 450);
					ws.setColumnView(0, 8);
					ws.setColumnView(1, 50);

					// 数据单元格格式
					WritableFont dataFont = new WritableFont(WritableFont.createFont("宋体"), 10, WritableFont.NO_BOLD, false);
					WritableCellFormat dataFormat = new WritableCellFormat(dataFont);
					// 设置边框
					dataFormat.setBorder(Border.ALL, BorderLineStyle.THIN);// 垂直居中显示
					dataFormat.setVerticalAlignment(VerticalAlignment.CENTRE); // 垂直对齐
					dataFormat.setAlignment(Alignment.CENTRE); // 水平对齐
					dataFormat.setWrap(false); // 是否换行
					dataFormat.setFont(dataFont);

					// 写入内容
					int rowNum = 0;

					// 合并开始列
					int startRow = 2;

					if (expertList != null && expertList.size() > 0) {
						/**************** 第一行写入专家 **************************/
						// 序号
						Label cell1 = new Label(0, rowNum, this.getText("expert_audit_xh"), wcf);
						ws.addCell(cell1);
						// 项目名称
						Label cell2 = new Label(1, rowNum, this.getText("expert_audit_project_name"), wcf);
						ws.addCell(cell2);

						for (int t = 0; t < expertList.size(); t++) {
							ws.mergeCells(startRow, 0, startRow + 6, 0);// 合并单元格，参数格式（开始列，开始行，结束列，结束行）
							Object[] obj = expertList.get(t);
							Label cell = new Label(startRow, rowNum, String.valueOf(obj[1] == null ? "" : obj[1]), wcf);
							ws.addCell(cell);
							startRow = startRow + 7;
						}

						//技术专家平均分
						Label cell3 = new Label(startRow, rowNum, this.getText("expert_audit_technology_complexAverage"), wcf);
						ws.addCell(cell3);
						//投资专家平均分
						Label cell4 = new Label(startRow + 1, rowNum, this.getText("expert_audit_investment_complexAverage"), wcf);
						ws.addCell(cell4);
						//技术专家评审意见
						Label cell5 = new Label(startRow + 2, rowNum, this.getText("expert_audit_technology_finalResult"), wcf);
						ws.addCell(cell5);
						//投资专家评审意见
						Label cell6 = new Label(startRow + 3, rowNum, this.getText("expert_audit_investment_finalResult"), wcf);
						ws.addCell(cell6);

						rowNum++;
					}

					/***************** 写入项目评审记录 ***********************************/
					// 循环着把数据写入Excel文件中
					if (allResult != null && allResult.size() > 0) {
						for (int j = 0; j < allResult.size(); j++) {
							ws.setRowView(rowNum, 400);
							// 每一行数据。
							List<List<Object>> cells = (List<List<Object>>) allResult.get(j);
							// 写第一列内容
							Label cell11 = new Label(0, rowNum, String.valueOf(j + 1), dataFormat);
							ws.addCell(cell11);
							// 后面列循环写入
							for (int n = 0; n < cells.size(); n++) {
								Label cell = new Label(n + 1, rowNum, String.valueOf(cells.get(n)), dataFormat);
								ws.addCell(cell);
							}
							rowNum++;
						}

						/********************** 写入备注 ********************************************/
						// 综合评审意见：A:重点推荐 B:推荐 C:备选 D:落选
						// 注：90分以上为重点推荐； 80－89分为推荐； 60-79分为备选； 60分以下为落选
						// 数据单元格格式
						WritableFont remarkFont = new WritableFont(WritableFont.createFont("宋体"), 10, WritableFont.BOLD, false);
						WritableCellFormat remarkFormat = new WritableCellFormat(dataFont);
						// 设置边框
						remarkFormat.setBorder(Border.ALL, BorderLineStyle.NONE);// 垂直居中显示
						remarkFormat.setVerticalAlignment(VerticalAlignment.CENTRE); // 垂直对齐
						remarkFormat.setAlignment(Alignment.LEFT); // 水平对齐
						// remarkFormat.setWrap(false); // 是否换行
						remarkFormat.setFont(remarkFont);

						ws.setRowView(rowNum, 400);
						Label cell11 = new Label(0, rowNum, this.getText("expert_audit_remark1"), remarkFormat);
						ws.addCell(cell11);
						ws.mergeCells(0, rowNum, startRow + 3, rowNum);// 合并单元格，参数格式（开始列，开始行，结束列，结束行）
						ws.setRowView(rowNum + 1, 400);
						Label cell22 = new Label(0, rowNum + 1, this.getText("expert_audit_remark2"), remarkFormat);
						ws.addCell(cell22);
						ws.mergeCells(0, rowNum + 1, startRow + 3, rowNum + 1);// 合并单元格，参数格式（开始列，开始行，结束列，结束行）
					}
				}
			}else{
				// 写入页名
				WritableSheet ws = workbook.createSheet(this.getText("expert_audit_file_name"), 0);
				// 设置单元格的文字格式
				WritableFont wf = new WritableFont(WritableFont.createFont("宋体"), 10, WritableFont.BOLD, false);
				WritableCellFormat wcf = new WritableCellFormat(wf);
				// 设置边框
				wcf.setBorder(Border.ALL, BorderLineStyle.THIN);// 垂直居中显示
				wcf.setVerticalAlignment(VerticalAlignment.CENTRE); // 垂直对齐
				wcf.setAlignment(Alignment.CENTRE); // 水平对齐
				wcf.setWrap(false); // 是否换行
				wcf.setFont(wf);
				ws.setRowView(0, 450);
				ws.setColumnView(0, 8);
				ws.setColumnView(1, 50);

			}
			workbook.write();
			out.flush();
			response.flushBuffer();
		} catch (Exception e) {
			// 异常发生的场合，抛出异常。
			throw e;
		} finally {
			if (null != workbook) {
				workbook.close();
			}
			if (null != out) {
				out.close();
			}
		}

	}

	public TexpertScore getTexpertScore() {
		return texpertScore;
	}

	public void setTexpertScore(TexpertScore texpertScore) {
		this.texpertScore = texpertScore;
	}

	public TexpertReviewComments getTechnologyReviewComments() {
		return technologyReviewComments;
	}

	public void setTechnologyReviewComments(TexpertReviewComments technologyReviewComments) {
		this.technologyReviewComments = technologyReviewComments;
	}

	public TexpertReviewComments getInvestmentReviewComments() {
		return investmentReviewComments;
	}

	public void setInvestmentReviewComments(TexpertReviewComments investmentReviewComments) {
		this.investmentReviewComments = investmentReviewComments;
	}

	public String getGroupId() {
		return groupId;
	}

	public void setGroupId(String groupId) {
		this.groupId = groupId;
	}

	public String getProjectId() {
		return projectId;
	}

	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}

	public String getIsWrite() {
		return isWrite;
	}

	public void setIsWrite(String isWrite) {
		this.isWrite = isWrite;
	}

	public List<TprojectApplication> getProjectList() {
		return projectList;
	}

	public void setProjectList(List<TprojectApplication> projectList) {
		this.projectList = projectList;
	}

	public List<TexpertScore> getTechnologyList() {
		return technologyList;
	}

	public void setTechnologyList(List<TexpertScore> technologyList) {
		this.technologyList = technologyList;
	}

	public List<TexpertScore> getInvestmentList() {
		return investmentList;
	}

	public void setInvestmentList(List<TexpertScore> investmentList) {
		this.investmentList = investmentList;
	}

	public int getPageNo() {
		return pageNo;
	}

	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}

	public String getRetMsg() {
		return retMsg;
	}

	public void setRetMsg(String retMsg) {
		this.retMsg = retMsg;
	}

	public String getProjectListStr() {
		return projectListStr;
	}

	public void setProjectListStr(String projectListStr) {
		this.projectListStr = projectListStr;
	}

	public String getRetUrl() {
		return retUrl;
	}

	public void setRetUrl(String retUrl) {
		this.retUrl = retUrl;
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

	public String getAuditStatus() {
		return auditStatus;
	}

	public void setAuditStatus(String auditStatus) {
		this.auditStatus = auditStatus;
	}

	public String getProjectGroup() {
		return projectGroup;
	}

	public void setProjectGroup(String projectGroup) {
		this.projectGroup = projectGroup;
	}

	public TprojectApplication getTprojectApplication() {
		return tprojectApplication;
	}

	public void setTprojectApplication(TprojectApplication tprojectApplication) {
		this.tprojectApplication = tprojectApplication;
	}

	public double getProjectTechnologyAverage() {
		return projectTechnologyAverage;
	}

	public void setProjectTechnologyAverage(double projectTechnologyAverage) {
		this.projectTechnologyAverage = projectTechnologyAverage;
	}

	public double getProjectInvestmentAverage() {
		return projectInvestmentAverage;
	}

	public void setProjectInvestmentAverage(double projectInvestmentAverage) {
		this.projectInvestmentAverage = projectInvestmentAverage;
	}

	public String getProjectIndex() {
		return projectIndex;
	}

	public void setProjectIndex(String projectIndex) {
		this.projectIndex = projectIndex;
	}

	public String getOptType() {
		return optType;
	}

	public void setOptType(String optType) {
		this.optType = optType;
	}
}