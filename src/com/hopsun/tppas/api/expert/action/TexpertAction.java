/*************** 版权声明***************
*
* Copyright (C) 2012 西安辉盛科技发展有限责任公司.
*
********************************************
*/
package com.hopsun.tppas.api.expert.action;

import java.io.File;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jxl.Workbook;
import jxl.WorkbookSettings;
import jxl.format.Alignment;
import jxl.format.Border;
import jxl.format.BorderLineStyle;
import jxl.format.Colour;
import jxl.format.VerticalAlignment;
import jxl.write.Label;
import jxl.write.NumberFormat;
import jxl.write.WritableCellFormat;
import jxl.write.WritableFont;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

import org.apache.struts2.ServletActionContext;

import com.hopsun.framework.base.action.BaseAction;
import com.hopsun.framework.base.bean.Pager;
import com.hopsun.scenter.entity.ScUsers;
import com.hopsun.tppas.api.expert.service.TexpertService;
import com.hopsun.tppas.api.superadmin.service.MitemService;
import com.hopsun.tppas.common.CommonTool;
import com.hopsun.tppas.common.Constants;
import com.hopsun.tppas.entity.Mitem;
import com.hopsun.tppas.entity.Texpert;
/**
 * @comment 专家库管理类
 * @author yank
 * @DATE: 2013-08-19 @TIME: 下午2:09:37
 * @Vsersion: 1.0
 */
public class TexpertAction extends BaseAction {

	private static final long serialVersionUID = 1822328288611064511L;
	
	@Resource
	private TexpertService texpertService;
	
	@Resource
	private MitemService apiMitemService;
	

	/**专家姓名*/
	private String expertName;
	
	/**擅长专业集合*/
	private List<Mitem> expertMajorList = new ArrayList<Mitem>();
	
	/**擅长专业1集合*/
	private List<Mitem> expertMajor1List;
	
	/**信用等级集合*/
	private List<Mitem> expertPrestigeList;
	
	/**擅长专业1*/
	private String expertMajor1;

	/**信用等级*/
	private String expertPrestige;
	
	/**专家对象*/
	private  Texpert  texpert;
	
	/**专家对象ID*/
	private String expertId;
	
	/**学历集合*/
	private List<Mitem> schoolingList;
	
	/**学位集合*/
	private List<Mitem> expertdegreeList;
	
	/**行政职务集合*/
	private List<Mitem> expertjobList;
	
	/**技术职务集合*/
	private List<Mitem> skilljobList;
	
	/**擅长专业2集合*/
	private List<Mitem> expertMajor2List;
	
	/**擅长专业3集合*/
	private List<Mitem> expertMajor3List;
	
	/**信誉等级集合*/
	private List<Mitem> expertprestigeList;
	
	/**单位性质集合*/
	private List<Mitem> depttypeList;
	
	/**性别集合*/
	private List<Mitem> sexList;
	
	/**专家类型集合*/
	private List<Mitem> expertTypeList;
	
	/** 跳转路径**/
	private String retUrl;

	/** 翻页 */
	private int pageNo;
	
	/** 跳转页面massage**/
	private String retMsg;
	
	/**是否可以修改*/
	private String isEdit = "1";
	
	/**
	 * 专家查询
	 * @comments 
	 * @return
	 * @version 1.0
	 */
	public String experManager(){
		HttpSession session = this.getRequest().getSession();
		session.setAttribute(Constants.SESSION_CMDKEY, "texportAction");
		ScUsers user = (ScUsers) session.getAttribute("sysUser");
		// 如果用户为空或者企业为空，退出系统
		if (user == null || ("").equals(user.getUserId())) {
			return "LogOut";
		}
		
		//擅长专业
		List<Mitem> list1 = apiMitemService.getMitemListById(Constants.EXPERTMAJOR1_TYPE);
		expertMajorList.addAll(list1);
		List<Mitem> list2 = apiMitemService.getMitemListById(Constants.EXPERTMAJOR2_TYPE);
		expertMajorList.addAll(list2);
		List<Mitem> list3 = apiMitemService.getMitemListById(Constants.EXPERTMAJOR3_TYPE);
		expertMajorList.addAll(list3);
		//信用等级
		expertPrestigeList = apiMitemService.getMitemListById(Constants.EXPERTPRESTIGE_TYPE);
		
		return "experManager";
	}

	/**
	 * 专家信息列表
	 * @comments 
	 * @return
	 * @version 1.0
	 */
	public String list() {
		HttpSession session = this.getRequest().getSession();
		session.setAttribute(Constants.SESSION_CMDKEY, "texportAction");
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
		Map<String, Object> params=new HashMap<String, Object>();
		params.put("exportName", expertName);
		params.put("expertMajor1", expertMajor1);
		params.put("expertPrestige", expertPrestige);
		pager=texpertService.queryExportByParams(params, pager.getPageNumber(), pager.getPageSize());

		return "list";
	}

	/**
	 * 跳转到添加页面
	 * 
	 * @return String
	 */
	public String initInsert() {
		this.initDatas();
		return "insert";
	}
	
	/**
	 * 新增专家初始画面
	 * @comments 
	 * @return
	 * @version 1.0
	 */
	public String forwardInsert() {
		
		return "initmenu";
	}
	
	/**
	 * 保存修改专家基本信息
	 * @comments 
	 * @return
	 * @version 1.0
	 */
	public String saveOrUpdateExpert(){
		HttpSession session = this.getRequest().getSession();
		String cmdStr = (String) session.getAttribute(Constants.SESSION_CMDKEY);
		ScUsers user = (ScUsers) session.getAttribute("sysUser");
		// 如果用户为空或者企业为空，退出系统
		if (user == null || ("").equals(user.getUserId()) || !("texportAction").equals(cmdStr)) {
			return "LogOut";
		}
		
		//是保存还是下一步 0-保存   1-下一步
    	String optType = this.getParameter("optType");
    	
    	//判断提示信息是保存还是修改
    	if(texpert.getExpertId()!=null&&texpert.getExpertId().length()>0){
    		this.setRetMsg(this.getText("opt_update_suc"));
    	}else{
    		this.setRetMsg(this.getText("opt_save_suc"));
    	}
    	
    	//保存专家基本信息
    	texpertService.saveOrUpdate(texpert, user);
    	expertId=texpert.getExpertId();
    	
    	if("0".equals(optType)){
    		this.setRetUrl(super.getRequest().getContextPath()+ "/api/expert/texpertAction!forwardInsert.action?expertId="+expertId+"&isEdit="+isEdit+"&now="+ new Date().getTime());
    		return "systemInfoMain";
    	}else{
    		this.setRetUrl(super.getRequest().getContextPath()+ "/api/expert/ttechnologyGainAction!list.action?expertId="+expertId+"&isEdit="+isEdit+"&now="+ new Date().getTime());
    	}
    	
		return "systemInfoNext";
	}
	
	/**
	 * 通过专家ID得到专家基本信息
	 * @comments 
	 * @return
	 * @version 1.0
	 */
	public String getExpertInfo(){
		HttpSession session = this.getRequest().getSession();
		String cmdStr = (String) session.getAttribute(Constants.SESSION_CMDKEY);
		ScUsers user = (ScUsers) session.getAttribute("sysUser");
		// 如果用户为空或者企业为空，退出系统
		if (user == null || ("").equals(user.getUserId()) || !("texportAction").equals(cmdStr)) {
			return "LogOut";
		}
		
		this.initDatas();
		if(CommonTool.IsNotEmpty(expertId)){
			texpert = texpertService.get(expertId);
		}else{
			texpert = new Texpert();
		}
		return "insert";
	}

	/**
	 * 专家信息删除
	 * @comments 
	 * @return
	 * @version 1.0
	 */
	public String deleteExpert(){
		HttpSession session = this.getRequest().getSession();
		String cmdStr = (String) session.getAttribute(Constants.SESSION_CMDKEY);
		ScUsers user = (ScUsers) session.getAttribute("sysUser");
		// 如果用户为空或者企业为空，退出系统
		if (user == null || ("").equals(user.getUserId()) || !("texportAction").equals(cmdStr)) {
			return "LogOut";
		}
		
		if(CommonTool.IsNotEmpty(expertId)){
			texpertService.deleteExpert(expertId);
			this.setRetMsg(this.getText("opt_del_suc"));
		}else{
			this.setRetMsg(this.getText("opt_del_err"));
		}
		
    	this.setRetUrl(super.getRequest().getContextPath()+ "/api/expert/texpertAction!experManager.action?now="+ new Date().getTime());
    	
    	return "systemInfoMain";
	}

	/**
	 * 页面下拉列表初始化
	 * @comments 
	 * @version 1.0
	 */
	private void initDatas(){
		//性别SEX_TYPE
		sexList = apiMitemService.getMitemListById(Constants.SEX_TYPE);
		//学历-SCHOOLING_TYPE
		schoolingList = apiMitemService.getMitemListById(Constants.SCHOOLING_TYPE);
		//学位-EXPERTDEGREE_TYPE
		expertdegreeList = apiMitemService.getMitemListById(Constants.EXPERTDEGREE_TYPE);
		//行政职务-EXPERTJOB_TYPE
		expertjobList = apiMitemService.getMitemListById(Constants.EXPERTJOB_TYPE);
		//技术职务-SKILLJOB_TYPE
		skilljobList = apiMitemService.getMitemListById(Constants.SKILLJOB_TYPE);
		//擅长专业1-EXPERTMAJOR1_TYPE
		expertMajor1List = apiMitemService.getMitemListById(Constants.EXPERTMAJOR1_TYPE);
		//擅长专业2-EXPERTMAJOR2_TYPE
		expertMajor2List = apiMitemService.getMitemListById(Constants.EXPERTMAJOR2_TYPE);
		//擅长专业3-EXPERTMAJOR3_TYPE
		expertMajor3List = apiMitemService.getMitemListById(Constants.EXPERTMAJOR3_TYPE);
		//信誉等级-EXPERTPRESTIGE_TYPE
		expertprestigeList = apiMitemService.getMitemListById(Constants.EXPERTPRESTIGE_TYPE);
		//单位性质-DEPTTYPE_TYPE
		depttypeList = apiMitemService.getMitemListById(Constants.DEPTTYPE_TYPE);
		//专家类型-EXPERT_TYPE
		expertTypeList = apiMitemService.getMitemListById(Constants.EXPERT_TYPE);
	}
	
	
	// Start wanglw
	/**
	 * @comments 专家统计
	 * @return
	 * @Version 1.0
	 */
	public String showExpertStatistic(){
		HttpSession session = this.getRequest().getSession();
		session.setAttribute(Constants.SESSION_CMDKEY, "texportStatistic");
		ScUsers user = (ScUsers) session.getAttribute("sysUser");
		// 如果用户为空或者企业为空，退出系统
		if (user == null || ("").equals(user.getUserId())) {
			return "LogOut";
		}
		
		return "showExpertStatistic";
	}
	
	
	/**
	 * @comments 查询专家统计数据
	 * @return
	 * @Version 1.0
	 */
	public String getExpertStatisticList(){
		HttpSession session = this.getRequest().getSession();
		String cmdStr = (String) session.getAttribute(Constants.SESSION_CMDKEY);
		ScUsers user = (ScUsers) session.getAttribute("sysUser");
		// 如果用户为空或者企业为空，退出系统
		if (user == null || ("").equals(user.getUserId()) || !("texportStatistic").equals(cmdStr)) {
			return "LogOut";
		}
		
		// 翻页
		if (pager == null && this.getPageNo() == 0) {
			pager = new Pager();
		} else {
			pager = new Pager();
			pager.setPageNumber(this.getPageNo());
		}
		Map<String, Object> params=new HashMap<String, Object>();
		params.put("exportName", expertName);
		
		// 设置查询条件
		session.setAttribute("SearchParam", params);
		pager=texpertService.getExpertStatisticList(params, pager.getPageNumber(), pager.getPageSize());
		
		return "getExpertStatisticList";
	}
	
	
	/**
	 * @throws Exception 
	 * @comments 打印统计结果 
	 * @Version 1.0
	 */
	@SuppressWarnings("unchecked")
	public void exportDatas() throws Exception{
		
		HttpSession session = this.getRequest().getSession();
		String cmdStr = (String) session.getAttribute(Constants.SESSION_CMDKEY);
		ScUsers user = (ScUsers) session.getAttribute("sysUser");
		// 如果用户为空或者企业为空，退出系统
		if (user == null || ("").equals(user.getUserId()) || !("texportStatistic").equals(cmdStr)) {
			return ;
		}
		
		// 取得文件名称
		String excelFileName = this.getText(Constants.EXPERT_STATISTIC_NAME);
		
		// 取得查询条件
		Map<String, Object> params = (Map<String, Object>) session.getAttribute("SearchParam");
		
		// 取得打印数据
		List<Texpert> expertList = texpertService.getExpertExportList(params);
		
		this.createOutExcel(excelFileName, expertList);
	}
	
	/**
	 * @comments 生成excel
	 * @param excelFileName
	 * @param expertList
	 * @throws Exception 
	 * @Version 1.0
	 */
	private void createOutExcel(String excelFileName, List<Texpert> expertList) throws Exception{
		// response
		HttpServletResponse response = ServletActionContext.getResponse();
		// 清空输出流
		response.reset();

		// 设定输出文件头
		response.setHeader("Content-Disposition", "attachment; filename=\""
				+ new String(excelFileName.getBytes("GB2312"), "8859_1") + ".xls\"");

		// 定义输出类型
		response.setContentType("application/vnd.ms-excel");
		
		OutputStream out = null;
		// 取得输出流
		out = response.getOutputStream();
		// 工作簿从usr tppasc input中拷贝模板：专家评审统计模板.xls
		String modelInputPath = apiMitemService.get(Constants.PDF_TEMPLATE_PATH).getItemDesc();
		String len = modelInputPath.substring(modelInputPath.length() - 1, modelInputPath.length());
		// 判断目录是否完整
		if (!"/".equals(len)) {
			modelInputPath = modelInputPath + "/";
		}

		File fileModel = new File(modelInputPath + Constants.EXPERT_STATISTIC_FILENAME);
		
		try {
			Workbook wk = Workbook.getWorkbook(fileModel);
			WorkbookSettings settings = new WorkbookSettings();
			settings.setWriteAccess(null);

			WritableWorkbook outWorkBook = Workbook.createWorkbook(out, wk);
			// 设置sheet的名称
			outWorkBook.getSheets()[0].setName(excelFileName);
			
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

			// 表头格式
			WritableCellFormat headerCf = new WritableCellFormat();
			// 设置边框
			headerCf.setBorder(Border.ALL, BorderLineStyle.THIN);
			// 垂直居中显示
			headerCf.setVerticalAlignment(VerticalAlignment.CENTRE);
			headerCf.setBackground(Colour.ICE_BLUE);
			// 设置自动换行
			headerCf.setWrap(true);
			headerCf.setFont(wf2);
			// 水平居中显示
			headerCf.setAlignment(Alignment.CENTRE);

			// 百分比格式
			NumberFormat nf = new NumberFormat("0");
			WritableCellFormat numberCf = new WritableCellFormat(nf);
			// 设置边框
			numberCf.setBorder(Border.ALL, BorderLineStyle.THIN);
			// 垂直居中显示
			numberCf.setVerticalAlignment(VerticalAlignment.CENTRE);
			// 水平居中显示
			numberCf.setAlignment(Alignment.RIGHT);
			// 设置字体
			numberCf.setFont(wf2);

			// 计划类别名称格式
			WritableCellFormat typeCf = new WritableCellFormat();
			// 设置边框
			typeCf.setBorder(Border.ALL, BorderLineStyle.THIN);
			// 垂直居中显示
			typeCf.setVerticalAlignment(VerticalAlignment.CENTRE);
			// 水平居中显示
			typeCf.setAlignment(Alignment.CENTRE);
			// 设置字体
			WritableFont wf3 = new WritableFont(WritableFont.createFont("宋体"), 10, WritableFont.NO_BOLD, false);
			typeCf.setFont(wf3);
			
			WritableSheet sh = outWorkBook.getSheet(0);
			
			sh.addCell(new Label(2, 2, "序号", headerCf));
			sh.addCell(new Label(3, 2, "专家姓名", headerCf));
			sh.addCell(new Label(4, 2, "参与项目数量", headerCf));
			sh.addCell(new Label(5, 2, "参加评审数量", headerCf));
			sh.addCell(new Label(6, 2, "参加验收数量", headerCf));
			sh.addCell(new Label(7, 2, "专家信誉等级", headerCf));
			
			for(int i=0; i<expertList.size(); i++){
				Texpert expert = expertList.get(i);
				
				sh.addCell(new Label(2, i + 3, String.valueOf(i + 1), numberCf));
				sh.addCell(new Label(3, i + 3, expert.getExpertName(), typeCf));
				sh.addCell(new Label(4, i + 3, expert.getExpertMajor1(), numberCf));
				sh.addCell(new Label(5, i + 3, expert.getExpertMajor2(), numberCf));
				sh.addCell(new Label(6, i + 3, expert.getExpertMajor3(), numberCf));
				sh.addCell(new Label(7, i + 3, expert.getExpertPrestige(), typeCf));
			}
			
			// ===========写入数据 end===========

			outWorkBook.write();
			out.flush();
			outWorkBook.close();
			wk.close();
			response.flushBuffer();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	// End wanglw	

	public String getExpertMajor1() {
		return expertMajor1;
	}

	public void setExpertMajor1(String expertMajor1) {
		this.expertMajor1 = expertMajor1;
	}

	public String getExpertPrestige() {
		return expertPrestige;
	}

	public void setExpertPrestige(String expertPrestige) {
		this.expertPrestige = expertPrestige;
	}

	public int getPageNo() {
		return pageNo;
	}

	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}

	public Texpert getTexpert() {
		return texpert;
	}

	public void setTexpert(Texpert texpert) {
		this.texpert = texpert;
	}

	public String getExpertName() {
		return expertName;
	}

	public void setExpertName(String expertName) {
		this.expertName = expertName;
	}


	public String getExpertId() {
		return expertId;
	}

	public String getRetUrl() {
		return retUrl;
	}

	public void setRetUrl(String retUrl) {
		this.retUrl = retUrl;
	}

	public void setExpertId(String expertId) {
		this.expertId = expertId;
	}

	public List<Mitem> getExpertMajor1List() {
		return expertMajor1List;
	}

	public void setExpertMajor1List(List<Mitem> expertMajor1List) {
		this.expertMajor1List = expertMajor1List;
	}

	public List<Mitem> getExpertPrestigeList() {
		return expertPrestigeList;
	}

	public void setExpertPrestigeList(List<Mitem> expertPrestigeList) {
		this.expertPrestigeList = expertPrestigeList;
	}

	public List<Mitem> getSchoolingList() {
		return schoolingList;
	}

	public void setSchoolingList(List<Mitem> schoolingList) {
		this.schoolingList = schoolingList;
	}

	public List<Mitem> getExpertdegreeList() {
		return expertdegreeList;
	}

	public void setExpertdegreeList(List<Mitem> expertdegreeList) {
		this.expertdegreeList = expertdegreeList;
	}

	public List<Mitem> getExpertjobList() {
		return expertjobList;
	}

	public void setExpertjobList(List<Mitem> expertjobList) {
		this.expertjobList = expertjobList;
	}

	public List<Mitem> getSkilljobList() {
		return skilljobList;
	}

	public void setSkilljobList(List<Mitem> skilljobList) {
		this.skilljobList = skilljobList;
	}

	public List<Mitem> getExpertMajor2List() {
		return expertMajor2List;
	}

	public void setExpertMajor2List(List<Mitem> expertMajor2List) {
		this.expertMajor2List = expertMajor2List;
	}

	public List<Mitem> getExpertMajor3List() {
		return expertMajor3List;
	}

	public void setExpertMajor3List(List<Mitem> expertMajor3List) {
		this.expertMajor3List = expertMajor3List;
	}

	public List<Mitem> getExpertprestigeList() {
		return expertprestigeList;
	}

	public void setExpertprestigeList(List<Mitem> expertprestigeList) {
		this.expertprestigeList = expertprestigeList;
	}

	public List<Mitem> getDepttypeList() {
		return depttypeList;
	}

	public void setDepttypeList(List<Mitem> depttypeList) {
		this.depttypeList = depttypeList;
	}

	public List<Mitem> getSexList() {
		return sexList;
	}

	public void setSexList(List<Mitem> sexList) {
		this.sexList = sexList;
	}
	
	public List<Mitem> getExpertTypeList() {
		return expertTypeList;
	}

	public void setExpertTypeList(List<Mitem> expertTypeList) {
		this.expertTypeList = expertTypeList;
	}

	public String getRetMsg() {
		return retMsg;
	}

	public void setRetMsg(String retMsg) {
		this.retMsg = retMsg;
	}

	public String getIsEdit() {
		return isEdit;
	}

	public void setIsEdit(String isEdit) {
		this.isEdit = isEdit;
	}

	public List<Mitem> getExpertMajorList() {
		return expertMajorList;
	}

	public void setExpertMajorList(List<Mitem> expertMajorList) {
		this.expertMajorList = expertMajorList;
	}
	
}
