package com.hopsun.tppas.api.contract.action;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.hopsun.framework.base.action.BaseAction;
import com.hopsun.scenter.entity.ScUsers;
import com.hopsun.tppas.api.contract.service.TcontractService;
import com.hopsun.tppas.api.contract.service.TfundingPlanBService;
import com.hopsun.tppas.common.Constants;
import com.hopsun.tppas.entity.Mitem;
import com.hopsun.tppas.entity.Tcontract;
import com.hopsun.tppas.entity.TfundingPlanB;

public class TfundingPlanBAction extends BaseAction {
	public final static Logger logger = Logger.getLogger(TfundingPlanBAction.class.getName());

	private static final long serialVersionUID = -1535544819120704177L;
	@Resource
	private TfundingPlanBService tfundingPlanBService;

	@Resource
	private TcontractService tcontractService;

	// 合同管理
	private Tcontract tcontract;
	// 合同id
	private String tcontractId;
	// 合同填报步骤
	private List<Map<String, String>> contractStep;
	// 模板类型
	private String modelType;
	// 合同状态
	private String contractStatus;

	private String retUrl;

	private String retMsg;
	// 按钮是否显示标记
	private String Flag;
	/** 菜单List */
	private List<Mitem> menuList;
	// 近一年
	private int year1;
	// 近两年
	private int year2;
	// 近三年
	private int year3;
	// 年份标志
	private String yearFlag;

	/**
	 * 项目经费计划表
	 */
	private TfundingPlanB tfundingPlanB;

	public String execute() {
		// 取得登录用户的信息
		HttpSession session = this.getRequest().getSession();
		// 设置令牌
		session.setAttribute(Constants.SESSION_CMDKEY, "tfundingPlanB");
		tfundingPlanB = tfundingPlanBService.get("tcontract.TContractId", tcontractId);
		tcontract = tcontractService.get(tcontractId);
		String startTime = null;
		String endTime = null;
		String startYear = null;
		String endYear = null;
		if (tcontract.getTprojectApplication() != null) {
			if (tcontract.getTprojectApplication().getStartTime() != null) {
				startTime = String.valueOf(tcontract.getTprojectApplication().getStartTime());
				endTime = String.valueOf(tcontract.getTprojectApplication().getEndTime());
			}
		}
		if (startTime != null && endTime != null) {
			startYear = startTime.substring(0, 4);
			endYear = endTime.substring(0, 4);
			int sum = Integer.valueOf(endYear) - Integer.valueOf(startYear);
			if (sum == 1) {
				year1 = Integer.valueOf(startYear);
				year2 = Integer.valueOf(endYear);
				year3 = Integer.valueOf(endYear) + 1;
				this.yearFlag = "0";
			} else {
				year1 = Integer.valueOf(startYear);
				year2 = Integer.valueOf(startYear) + 1;
				year3 = Integer.valueOf(endYear);
				this.yearFlag = "1";
			}
		}
		return "init";
	}

	/**
	 * 
	 * @comments 项目经费计划保存
	 * @return
	 * @throws Exception
	 * @version 1.0
	 */
	public String updatetfundingPlanB() throws Exception {
		// 取得登录用户的信息
		HttpSession session = this.getRequest().getSession();
		// 取得令牌信息
		String cmdkey = (String) session.getAttribute(Constants.SESSION_CMDKEY);
		ScUsers user = (ScUsers) session.getAttribute("sysUser");
		// 判断是否失效
		if (user == null || ("").equals(user.getUserId()) || !"tfundingPlanB".equals(cmdkey)) {
			logger.error("用户不存在！");
			return "LogOut";
		}
		tfundingPlanBService.updatetfundingPlanB(this.tfundingPlanB, this.tcontractId);
		this.setRetMsg(this.getText("opt_save_suc"));
		this.setRetUrl(super.getRequest().getContextPath() + "/api/contract/tfundingPlanB!execute.action?tcontractId=" + this.tcontractId + "&Flag=" + this.Flag + "&contractStatus=" + contractStatus
				+ "&modelType=" + modelType + "&now=" + new Date().getTime());
		return "systemInfo";
	}

	/**
	 * @comments 项目经费计划下一步操作
	 * @return
	 * @version 1.0
	 */
	public String next() {
		// 取得登录用户的信息
		HttpSession session = this.getRequest().getSession();
		// 取得令牌信息
		String cmdkey = (String) session.getAttribute(Constants.SESSION_CMDKEY);
		ScUsers user = (ScUsers) session.getAttribute("sysUser");
		// 判断是否失效
		if (user == null || ("").equals(user.getUserId()) || !"tfundingPlanB".equals(cmdkey)) {
			logger.error("用户不存在！");
			return "LogOut";
		}
		// 取得页面提交的合同封皮信息
		this.tcontract = this.getTcontract();
		tfundingPlanBService.updatetfundingPlanB(this.tfundingPlanB, this.tcontractId);
		this.setRetMsg(this.getText("opt_save_suc"));
		this.setRetUrl(super.getRequest().getContextPath() + "/api/contract/tcontractContentsB!initObligation.action?&Flag=" + Flag + "&tcontractId=" + tcontractId + "&contractStatus="
				+ contractStatus + "&modelType=" + modelType + "&now=" + new Date().getTime());
		return "systemInfoNext";
	}

	public TfundingPlanBService getTfundingPlanBService() {
		return tfundingPlanBService;
	}

	public void setTfundingPlanBService(TfundingPlanBService tfundingPlanBService) {
		this.tfundingPlanBService = tfundingPlanBService;
	}

	public TcontractService getTcontractService() {
		return tcontractService;
	}

	public void setTcontractService(TcontractService tcontractService) {
		this.tcontractService = tcontractService;
	}

	public Tcontract getTcontract() {
		return tcontract;
	}

	public void setTcontract(Tcontract tcontract) {
		this.tcontract = tcontract;
	}

	public String getTcontractId() {
		return tcontractId;
	}

	public void setTcontractId(String tcontractId) {
		this.tcontractId = tcontractId;
	}

	public List<Map<String, String>> getContractStep() {
		return contractStep;
	}

	public void setContractStep(List<Map<String, String>> contractStep) {
		this.contractStep = contractStep;
	}

	public String getModelType() {
		return modelType;
	}

	public void setModelType(String modelType) {
		this.modelType = modelType;
	}

	public String getContractStatus() {
		return contractStatus;
	}

	public void setContractStatus(String contractStatus) {
		this.contractStatus = contractStatus;
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

	public String getFlag() {
		return Flag;
	}

	public void setFlag(String flag) {
		Flag = flag;
	}

	public List<Mitem> getMenuList() {
		return menuList;
	}

	public void setMenuList(List<Mitem> menuList) {
		this.menuList = menuList;
	}

	public int getYear1() {
		return year1;
	}

	public void setYear1(int year1) {
		this.year1 = year1;
	}

	public int getYear2() {
		return year2;
	}

	public void setYear2(int year2) {
		this.year2 = year2;
	}

	public int getYear3() {
		return year3;
	}

	public void setYear3(int year3) {
		this.year3 = year3;
	}

	public String getYearFlag() {
		return yearFlag;
	}

	public void setYearFlag(String yearFlag) {
		this.yearFlag = yearFlag;
	}

	public TfundingPlanB getTfundingPlanB() {
		return tfundingPlanB;
	}

	public void setTfundingPlanB(TfundingPlanB tfundingPlanB) {
		this.tfundingPlanB = tfundingPlanB;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
