/*************** 版权声明***************
*
* Copyright (C) 2012 西安辉盛科技发展有限责任公司.
*
********************************************
*/
package com.hopsun.tppas.api.reportingunit.action;


import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import com.hopsun.framework.base.action.BaseAction;
import com.hopsun.framework.base.bean.Pager;
import com.hopsun.tppas.api.superadmin.service.MitemService;
import com.hopsun.tppas.common.Constants;
import com.hopsun.tppas.entity.Mitem;

/**
 * @comment 申报单位管理控制类
 * @author baij
 * @DATE: 2013-8-2 @TIME: 下午1:42:37
 * @Vsersion: 1.0
 */
public class TreportingUnitAction extends BaseAction{
	private static final long serialVersionUID = -2505595239945997631L;

	@Resource
	private MitemService mitemService;
	
	
	//分页number
	private int pageNo;
	//单位名称
	private String unitName;
	//单位性质
	private String unitNature;
	//单位性质List
	private List<Mitem> unitNatureList = new ArrayList<Mitem>(); 
	//企业所属技术领域List
	private List<Mitem> unitTechnology = new ArrayList<Mitem>();
	//行业领域1
	private List<Mitem> unitIndustries1 = new ArrayList<Mitem>();
	//行业领域2
	private List<Mitem> unitIndustries2 = new ArrayList<Mitem>();
	//行业领域3
	private List<Mitem> unitIndustries3 = new ArrayList<Mitem>();
	//行业领域4
	private List<Mitem> unitIndustries4 = new ArrayList<Mitem>();
	//行业领域1
	private String industries1;
	//行业领域2
	private String industries2;
	//行业领域3
	private String industries3;
	//行业领域4
	private String industries4;
	//企业单位地址(省)list
	private List<Mitem> address1List = new ArrayList<Mitem>();
	//企业单位地址(市)list
	private List<Mitem> address2List = new ArrayList<Mitem>();
	//企业单位地址(县)list
	private List<Mitem> address3List = new ArrayList<Mitem>();
	//企业单位地址（省）(查询条件)
	private String address1;
	//企业单位地址（市）(查询条件)
	private String address2;
	//企业单位地址（县）(查询条件)
	private String address3;
	//行政区域(省)list
	private List<Mitem> area1List = new ArrayList<Mitem>();
	//行政区域(市)list
	private List<Mitem> area2List = new ArrayList<Mitem>();
	//行政区域(县)list
	private List<Mitem> area3List = new ArrayList<Mitem>();
	//行政区域（省）(查询条件)
	private String area1;
	//行政区域（市）(查询条件)
	private String area2;
	//行政区域（县）(查询条件)
	private String area3;
	//通信地址(省)list
	private List<Mitem> mailingAddress1List = new ArrayList<Mitem>();
	//通信地址(市)list
	private List<Mitem> mailingAddress2List = new ArrayList<Mitem>();
	//通信地址(县)list
	private List<Mitem> mailingAddress3List = new ArrayList<Mitem>();
	//通信地址（省）(查询条件)
	private String mailingAddress1;
	//通信地址（市）(查询条件)
	private String mailingAddress2;
	//通信地址（县）(查询条件)
	private String mailingAddress3;
	
	/** 下拉列表联动返回字符串 */
	private String backStr;
	private String pitemId;
	//单位ID
	private String unitID;
	//项目ID
	private String projectID;
	//提示信息
	private String retMsg;
	//返回URL
	private String retUrl;
	/** 股权结构List */
	private List<Map<String,Object>> equityList = new ArrayList<Map<String,Object>>();
	


	/**
	 * @comments 申报单位初始化
	 * @return
	 * @throws Exception
	 * @Version 1.0
	 */
	public String list() throws UnsupportedEncodingException{
//		HttpSession session = this.getRequest().getSession();
//		// 设置令牌
//    	session.setAttribute(Constants.SESSION_CMDKEY, "reportingunit");

	   	// 单位性质
    	unitNatureList.addAll(mitemService.getMitemListById(Constants.TYPE_COMPANY_RETY));
    	
		return "list";
	}
	/**
	 * @comments 申报单位查询
	 * @return
	 * @throws Exception
	 * @Version 1.0
	 */
	public String getlist() throws UnsupportedEncodingException{
    	
		// 设置分页参数
    	if (pager == null && this.getPageNo() == 0) {
			pager = new Pager();
		}
    	else{
    		pager = new Pager();
    		pager.setPageNumber(this.getPageNo());
    	}
    	
    	//取得申报单位信息
    	//pager = ;
    	
		return "alllist";
	}
	/**
	 * @comments 页面查询条件
	 * @return
	 * @throws UnsupportedEncodingException 
	 * @throws Exception
	 * @Version 1.0
	 */
	/*private Map<String, Object> getCondition() throws UnsupportedEncodingException {

		Map<String, Object> param = new HashMap<String, Object>();
		param.put("unitName",  unitName);
		param.put("unitNature", unitNature);
		
		return param;
	}*/

	/**
	 * @comments 单位信息初始化
	 * @return
	 * @throws Exception
	 * @Version 1.0
	 */
	public String unitupdateInit()
	{
		this.setUnitID(unitID);
		
		//类型名称
		//企业所属技术领域
		unitTechnology.addAll(mitemService.getMitemListById(Constants.TYPE_TECHNICAL_FISLD));
		//经营性质
		//注册登记类型
		//行业领域
		unitIndustries1.addAll(mitemService.getMitemListById(Constants.TYPE_INDUSTRIES1));
//		setIndustries1(industries1);
//		setIndustries2(industries2);
//		setIndustries3(industries3);
//		unitIndustries2 = mitemService.getMitemListByPId(industries1);
//		unitIndustries3 = mitemService.getMitemListByPId(industries2);
//		unitIndustries4 = mitemService.getMitemListByPId(industries3);
		//注册地址
		address1List = mitemService.getMitemListById(Constants.TYPE_REGION_1);
		setAddress1(Constants.SHANNXI);
		setAddress2(Constants.XIAN);
		address2List = mitemService.getMitemListByPId(address1);
		address3List = mitemService.getMitemListByPId(address2);
		//行政区域
		area1List = mitemService.getMitemListById(Constants.TYPE_REGION_1);
		setArea1(Constants.SHANNXI);
		setArea2(Constants.XIAN);
		area2List = mitemService.getMitemListByPId(area1);
		area3List = mitemService.getMitemListByPId(area2);
		//通讯地址
		mailingAddress1List = mitemService.getMitemListById(Constants.TYPE_REGION_1);
		setMailingAddress1(Constants.SHANNXI);
		setMailingAddress2(Constants.XIAN);
		mailingAddress2List = mitemService.getMitemListByPId(mailingAddress1);
		mailingAddress3List = mitemService.getMitemListByPId(mailingAddress2);
		//企业上年度销售收入
		//投资者经济形态
		return "audit";
	}
	/**
	 * @comments 单位信息保存
	 * @return
	 * @throws Exception
	 * @Version 1.0
	 */
	public String unitInfoSave()
	{
		setRetMsg(this.getText("opt_update_suc"));
		setRetUrl(super.getRequest().getContextPath()
				+ "/api/reportingunit/TreportingUnitAction!list.action?now="
				+ new Date().getTime());
		return "systemInfoMain";
	}
	
	/**
	 * @comments 下拉列表联动
	 * @return
	 * @throws Exception
	 * @Version 1.0
	 */
	public String getSecondData() throws Exception {

		// 取得联动下拉列表数据List
		List<Mitem> dataList = mitemService.getMitemListByPId(pitemId);
		StringBuffer dataStr = new StringBuffer();

		if (dataList != null) {
			// 遍历下拉列表List 组成json字符串
			for (int i = 0; i < dataList.size(); i++) {
				dataStr.append(dataList.get(i).getItemId());
				dataStr.append(",");
				dataStr.append(dataList.get(i).getItemName());
				if (i != dataList.size() - 1) {
					dataStr.append(",");
				}
			}
		}
		this.backStr = dataStr.toString();
		return "getDataSuccess";
	}
	/**
	 * @comments 单位信誉度设置
	 * @return
	 * @throws Exception
	 * @Version 1.0
	 */
	public String creditInit()
	{
		this.setUnitID(unitID);
		
		// 设置分页参数
    	if (pager == null && this.getPageNo() == 0) {
			pager = new Pager();
		}
    	else{
    		pager = new Pager();
    		pager.setPageNumber(this.getPageNo());
    	}
    	
    	//取得单位项目集合
    	//pager = ;
		return "credit";
	}
	/**
	 * @comments 单位信誉度设置保存
	 * @return
	 * @throws Exception
	 * @Version 1.0
	 */
	public String creditInfoSave()
	{
		if ("".equals(unitID)) {
			this.setRetMsg(this.getText("opt_save_suc"));
		} else {
			this.setRetMsg(this.getText("opt_update_suc"));
		}
		setRetUrl(super.getRequest().getContextPath()
				+ "/api/reportingunit/TreportingUnitAction!list.action?now="
				+ new Date().getTime());
		return "systemInfoMain";
	}
	/**
	 * @comments 项目信息
	 * @return
	 * @throws Exception
	 * @Version 1.0
	 */
	public String projectInfo()
	{
		this.setProjectID(projectID);
		
		return "project";
	}
	
	
	public List<Mitem> getArea1List() {
		return area1List;
	}
	public void setArea1List(List<Mitem> area1List) {
		this.area1List = area1List;
	}
	public List<Mitem> getArea2List() {
		return area2List;
	}
	public void setArea2List(List<Mitem> area2List) {
		this.area2List = area2List;
	}
	public List<Mitem> getArea3List() {
		return area3List;
	}
	public void setArea3List(List<Mitem> area3List) {
		this.area3List = area3List;
	}
	public String getArea1() {
		return area1;
	}
	public void setArea1(String area1) {
		this.area1 = area1;
	}
	public String getArea2() {
		return area2;
	}
	public void setArea2(String area2) {
		this.area2 = area2;
	}
	public String getArea3() {
		return area3;
	}
	public void setArea3(String area3) {
		this.area3 = area3;
	}
	public int getPageNo() {
		return pageNo;
	}
	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}

	public MitemService getMitemService() {
		return mitemService;
	}
	public void setMitemService(MitemService mitemService) {
		this.mitemService = mitemService;
	}
	
	public List<Mitem> getUnitNatureList() {
		return unitNatureList;
	}
	public void setUnitNatureList(List<Mitem> unitNatureList) {
		this.unitNatureList = unitNatureList;
	}
	
	public List<Mitem> getUnitTechnology() {
		return unitTechnology;
	}
	public void setUnitTechnology(List<Mitem> unitTechnology) {
		this.unitTechnology = unitTechnology;
	}
	
	public List<Mitem> getAddress1List() {
		return address1List;
	}
	public void setAddress1List(List<Mitem> address1List) {
		this.address1List = address1List;
	}

	public List<Mitem> getAddress2List() {
		return address2List;
	}
	public void setAddress2List(List<Mitem> address2List) {
		this.address2List = address2List;
	}

	public List<Mitem> getAddress3List() {
		return address3List;
	}
	public void setAddress3List(List<Mitem> address3List) {
		this.address3List = address3List;
	}

	public String getAddress1() {
		return address1;
	}
	public void setAddress1(String address1) {
		this.address1 = address1;
	}

	public String getAddress2() {
		return address2;
	}
	public void setAddress2(String address2) {
		this.address2 = address2;
	}

	public String getAddress3() {
		return address3;
	}
	public void setAddress3(String address3) {
		this.address3 = address3;
	}
	
	public List<Mitem> getUnitIndustries1() {
		return unitIndustries1;
	}
	public void setUnitIndustries1(List<Mitem> unitIndustries1) {
		this.unitIndustries1 = unitIndustries1;
	}

	public List<Mitem> getUnitIndustries2() {
		return unitIndustries2;
	}
	public void setUnitIndustries2(List<Mitem> unitIndustries2) {
		this.unitIndustries2 = unitIndustries2;
	}

	public List<Mitem> getUnitIndustries3() {
		return unitIndustries3;
	}
	public void setUnitIndustries3(List<Mitem> unitIndustries3) {
		this.unitIndustries3 = unitIndustries3;
	}

	public List<Mitem> getUnitIndustries4() {
		return unitIndustries4;
	}
	public void setUnitIndustries4(List<Mitem> unitIndustries4) {
		this.unitIndustries4 = unitIndustries4;
	}

	public String getIndustries1() {
		return industries1;
	}
	public void setIndustries1(String industries1) {
		this.industries1 = industries1;
	}

	public String getIndustries2() {
		return industries2;
	}
	public void setIndustries2(String industries2) {
		this.industries2 = industries2;
	}

	public String getIndustries3() {
		return industries3;
	}
	public void setIndustries3(String industries3) {
		this.industries3 = industries3;
	}

	public String getIndustries4() {
		return industries4;
	}
	public void setIndustries4(String industries4) {
		this.industries4 = industries4;
	}
	
	public String getBackStr() {
		return backStr;
	}
	public void setBackStr(String backStr) {
		this.backStr = backStr;
	}

	public String getPitemId() {
		return pitemId;
	}
	public void setPitemId(String pitemId) {
		this.pitemId = pitemId;
	}
	
	public String getUnitName() {
		return unitName;
	}
	public void setUnitName(String unitName) {
		this.unitName = unitName;
	}
	
	public String getUnitNature() {
		return unitNature;
	}
	public void setUnitNature(String unitNature) {
		this.unitNature = unitNature;
	}
	
	public List<Mitem> getMailingAddress1List() {
		return mailingAddress1List;
	}
	public void setMailingAddress1List(List<Mitem> mailingAddress1List) {
		this.mailingAddress1List = mailingAddress1List;
	}
	public List<Mitem> getMailingAddress2List() {
		return mailingAddress2List;
	}
	public void setMailingAddress2List(List<Mitem> mailingAddress2List) {
		this.mailingAddress2List = mailingAddress2List;
	}
	public List<Mitem> getMailingAddress3List() {
		return mailingAddress3List;
	}
	public void setMailingAddress3List(List<Mitem> mailingAddress3List) {
		this.mailingAddress3List = mailingAddress3List;
	}
	public String getMailingAddress1() {
		return mailingAddress1;
	}
	public void setMailingAddress1(String mailingAddress1) {
		this.mailingAddress1 = mailingAddress1;
	}
	public String getMailingAddress2() {
		return mailingAddress2;
	}
	public void setMailingAddress2(String mailingAddress2) {
		this.mailingAddress2 = mailingAddress2;
	}
	public String getMailingAddress3() {
		return mailingAddress3;
	}
	public void setMailingAddress3(String mailingAddress3) {
		this.mailingAddress3 = mailingAddress3;
	}
	public String getRetMsg() {
		return retMsg;
	}
	public void setRetMsg(String retMsg) {
		this.retMsg = retMsg;
	}
	public String getRetUrl() {
		return retUrl;
	}
	public void setRetUrl(String retUrl) {
		this.retUrl = retUrl;
	}
	public String getUnitID() {
		return unitID;
	}
	public void setUnitID(String unitID) {
		this.unitID = unitID;
	}
	public String getProjectID() {
		return projectID;
	}
	public void setProjectID(String projectID) {
		this.projectID = projectID;
	}
	public List<Map<String, Object>> getEquityList() {
		return equityList;
	}
	public void setEquityList(List<Map<String, Object>> equityList) {
		this.equityList = equityList;
	}
}
	
