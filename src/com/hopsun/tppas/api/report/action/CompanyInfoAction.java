/*************** 版权声明***************
*
* Copyright (C) 2012 西安辉盛科技发展有限责任公司.
*
********************************************
*/
package com.hopsun.tppas.api.report.action;

import java.rmi.RemoteException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.annotation.Resource;
import javax.xml.rpc.ServiceException;

import org.apache.axis.client.Call;
import org.apache.axis.client.Service;

import com.google.gson.Gson;
import com.hopsun.framework.base.action.BaseAction;
import com.hopsun.tppas.api.report.service.TprojectApplicationService;
import com.hopsun.tppas.api.reportbudget.service.TreportBudgetService;
import com.hopsun.tppas.entity.TreportBudget;
import com.hopsun.tppas.webservice.bean.basic.Type;
import com.hopsun.tppas.webservice.bean.company.Address;
import com.hopsun.tppas.webservice.bean.company.CompanyBasic;
import com.hopsun.tppas.webservice.bean.company.Stock;
import com.hopsun.tppas.webservice.bean.project.Project;

/** 
 * @comment 取得企业信息
 * @author liush
 * @DATE: 2013-9-23 @TIME: 上午11:41:37
 * @Vsersion: 1.0
 */
public class CompanyInfoAction extends BaseAction {
	
	private static final long serialVersionUID = -2228521761101611364L;
	@Resource
	private TprojectApplicationService tprojectApplicationService;
	@Resource
	private TreportBudgetService treportBudgetService;
	private List<TreportBudget> treportBudgetList;
	public String projectId;
	private Project project;
	private CompanyBasic orgInfo;
	private String technosphereName;
	private String busiTypeName;
	private String addrProvinceName;
	private String provinceName;
	private Set<Stock> personList;
	private List<Stock> viewList;
	private List<Stock> tempList;
	
	
	/**
	 * @Comments 通过webserivice取得企业信息
	 * @return
	 * @throws ServiceException
	 * @throws RemoteException
	 * @throws ParseException 
	 * @Vsersion: 1.0
	 */
	public String getCompanyInfo() throws ServiceException, RemoteException, ParseException {
    	String code = tprojectApplicationService.get(projectId).getTempProjectId();
		String endpoint = this.getText("webservice_url2");
		Service service = new Service();
		Call call = (Call)service.createCall();
		call.setOperationName("getProjectInfo");
		call.setTargetEndpointAddress(endpoint);
	    call.addParameter("projectId", org.apache.axis.encoding.XMLType.XSD_STRING,
                javax.xml.rpc.ParameterMode.IN);
	    call.setReturnType(org.apache.axis.encoding.XMLType.XSD_STRING);
	    String result = (String)call.invoke(new Object[]{code});
		Gson gson = new Gson();
		project = gson.fromJson(result, Project.class);
		
		// 判断是否取到信息
		technosphereName = "";
		busiTypeName = "";
		if (project != null) {
			orgInfo = project.getCompany().getCompanyBasic();
			personList = orgInfo.getStocks();
			Set<Type> techArea = orgInfo.getTechArea();
			Set<Type> industry = orgInfo.getIndustry();
			Address regAddress = orgInfo.getRegAddress();
			Address linkage = orgInfo.getLinkage();
			// 主营产品（服务）所属技术领域
			for (Type type:techArea) {
				technosphereName = technosphereName + type.getTypeName();
			}
		
			// 单位所属行业领域
			for (Type type:industry) {
				busiTypeName = busiTypeName + type.getTypeName();
			}
			
			// 注册地址
			if (regAddress != null) {
				addrProvinceName = regAddress.getCountryName()+regAddress.getProvinceName()+
						regAddress.getCityName()+regAddress.getCountyName()+regAddress.getAddress();
			}
			
			// 公司地址
			if (linkage != null) {
				provinceName = linkage.getCountryName()+linkage.getProvinceName()+
						linkage.getCityName()+linkage.getCountyName()+linkage.getAddress();
			}
			
			// 股权信息
			viewList = new ArrayList<Stock>();
			DateFormat dd=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			Date date1 = new Date();
			Date date2 = new Date();
			tempList = new ArrayList<Stock>();
			for (Stock s:personList) {
				tempList.add(s);
			}
			Stock tempStock = null;
			for (int i=0;i<tempList.size()-1;i++) {
				tempStock = tempList.get(i);
				for (int j =1+i;j <tempList.size();j++) {
					date1 = dd.parse(tempStock.getCreateDate());
					date2 = dd.parse(tempList.get(j).getCreateDate());
					if (StrToInter(tempStock.getStockDesc()) < StrToInter(tempList.get(j).getStockDesc())) {
						tempStock = tempList.get(j);
						Collections.swap(tempList, i, j);
					} else if (StrToInter(tempStock.getStockDesc()) == StrToInter(tempList.get(j).getStockDesc())) {
						if (date1.after(date2)) {
							tempStock = tempList.get(j);
							Collections.swap(tempList, i, j);
						}
					}

				}
				viewList.add(tempStock);
				tempStock = new Stock();
			}
			viewList.add(tempList.get(tempList.size()-1));
		}
		 
		return "company";
	}

	public TprojectApplicationService getTprojectApplicationService() {
		return tprojectApplicationService;
	}

	public void setTprojectApplicationService(
			TprojectApplicationService tprojectApplicationService) {
		this.tprojectApplicationService = tprojectApplicationService;
	}

	public String getProjectId() {
		return projectId;
	}

	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}

	public TreportBudgetService getTreportBudgetService() {
		return treportBudgetService;
	}

	public void setTreportBudgetService(TreportBudgetService treportBudgetService) {
		this.treportBudgetService = treportBudgetService;
	}

	public List<TreportBudget> getTreportBudgetList() {
		return treportBudgetList;
	}

	public void setTreportBudgetList(List<TreportBudget> treportBudgetList) {
		this.treportBudgetList = treportBudgetList;
	}

	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

	public void setOrgInfo(CompanyBasic orgInfo) {
		this.orgInfo = orgInfo;
	}

	public String getTechnosphereName() {
		return technosphereName;
	}

	public void setTechnosphereName(String technosphereName) {
		this.technosphereName = technosphereName;
	}

	public CompanyBasic getOrgInfo() {
		return orgInfo;
	}

	public String getBusiTypeName() {
		return busiTypeName;
	}

	public void setBusiTypeName(String busiTypeName) {
		this.busiTypeName = busiTypeName;
	}

	public String getAddrProvinceName() {
		return addrProvinceName;
	}

	public void setAddrProvinceName(String addrProvinceName) {
		this.addrProvinceName = addrProvinceName;
	}

	public String getProvinceName() {
		return provinceName;
	}

	public void setProvinceName(String provinceName) {
		this.provinceName = provinceName;
	}

	public Set<Stock> getPersonList() {
		return personList;
	}

	public void setPersonList(Set<Stock> personList) {
		this.personList = personList;
	}

	public List<Stock> getViewList() {
		return viewList;
	}

	public void setViewList(List<Stock> viewList) {
		this.viewList = viewList;
	}
	
	/**
	 * 字符串转化为数字
	 * @param str
	 * @return
	 */
	private int StrToInter(String str) {
		int ret = 0;
		if (str != null) {
			ret = Integer.valueOf(str);
		}
		return ret;
	}
}
