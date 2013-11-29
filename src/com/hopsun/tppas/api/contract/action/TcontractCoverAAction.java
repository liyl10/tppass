package com.hopsun.tppas.api.contract.action;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.hopsun.framework.base.action.BaseAction;
import com.hopsun.scenter.entity.ScUsers;
import com.hopsun.tppas.api.contract.service.TcontractCoverAService;
import com.hopsun.tppas.api.contract.service.TcontractService;
import com.hopsun.tppas.api.superadmin.service.MitemService;
import com.hopsun.tppas.api.superadmin.service.TattachmentService;
import com.hopsun.tppas.api.superadmin.service.TprojectTypeService;
import com.hopsun.tppas.common.Constants;
import com.hopsun.tppas.entity.Mitem;
import com.hopsun.tppas.entity.Tcontract;
import com.hopsun.tppas.entity.TcontractCoverA;
import com.hopsun.tppas.entity.TprojectType;

public class TcontractCoverAAction extends BaseAction{
	public final static Logger logger = Logger.getLogger(TcontractCoverAAction.class.getName());
  
	private static final long serialVersionUID = 832534929573849126L;
	@Resource
	private TcontractCoverAService tcontractCoverAService;
	
	@Resource
	private TcontractService tcontractService;
	
	@Resource
	private TattachmentService tattachmentService;
	
	@Resource
	private MitemService mitemService;
	
	@Resource
	private TprojectTypeService tprojectTypeService;

	//分页nomber
	private int pageNo;
	//合同id
	private String tcontractId;
	//合同管理
	private Tcontract tcontract;
	//合同封皮表
	private TcontractCoverA tcontractCover;
	//合同填报步骤
	private List<Map<String, String>> contractStep;
	//合同类型
	private String contractType;
	//模板类型
	private String modelType;
	//合同状态
	private String contractStatus;
	//归口管理单位名称
	private String centralizedManagement;
	private List<Mitem> address1List;
	
	private List<Mitem> address2List;
	
	private List<Mitem> address3List;
	//计划类别
	private String type;
	private String retUrl;
	
	private String retMsg;
	//按钮是否显示标记
	private String Flag;
	/** 表名 */
	private String tableName;
	/** 文件类型 */
	private String fileType;
	/** 附件顺序 */
	private String sequence;
	/** 下拉列表联动返回字符串 */
	private String backStr;
	private String pitemId;
	/**委托单位*/
	private String entrustmentCompany;
	/**合同封皮备注*/
	private String contractComment;
	
	/**
	 * @comments 取得封皮页面需要的信息
	 * @return
	 * @throws Exception
	 * @version 1.0
	 */
	public String importCover() throws Exception{
		// 取得登录用户的信息
    	HttpSession session = this.getRequest().getSession();
    	 // 设置令牌
    	session.setAttribute(Constants.SESSION_CMDKEY, "contractCover");
    	// 初始化省市区list
		this.address1List = new ArrayList<Mitem>();
		this.address2List = new ArrayList<Mitem>();
		this.address3List = new ArrayList<Mitem>();
		//获取合同封皮信息
		tcontractCover = tcontractCoverAService.getTcontractCover(this.tcontractId);
		//获取合同管理表信息
		tcontract = tcontractService.get(this.tcontractId);
		//this.entrustmentCompany = mitemService.get(Constants.ENTRUSTMENT_COMPANY).getItemDesc();
		
		if(tcontractCover!=null){
			
			// 取得省级信息
			this.address1List = mitemService.getListByTypeId(Constants.TYPE_REGION_1);
			if(tcontractCover.getAddress1() !=null 
					&& !"".equals(tcontractCover.getAddress1())){
				this.address2List = mitemService.getMitemListByPId(tcontractCover.getAddress1());
				this.address3List = mitemService.getMitemListByPId(tcontractCover.getAddress2());
			}
			else{
				// 初始化选择陕西省西安市
				tcontractCover.setAddress1(Constants.SHANNXI);
				tcontractCover.setAddress2(Constants.XIAN);
				this.address2List = mitemService.getMitemListByPId(tcontractCover.getAddress1());
				this.address3List = mitemService.getMitemListByPId(tcontractCover.getAddress2());
			}
			// 委托单位（甲方）从合同表中取得 liyl  2013/6/21 edit
			this.entrustmentCompany = tcontractCover.getAuthorized();
			// 合同封皮备注信息取得
			this.contractComment = tcontractCover.getContractComment();
			
			if (tcontract.getTprojectApplication() != null){
				// 归口管理单位的名称
				if (tcontract.getTprojectApplication().getCentralizedType() != null){
					this.centralizedManagement = mitemService.get((tcontract.getTprojectApplication().getCentralizedType())).getItemName();
				}
				//计划类别
				TprojectType tprojectType = tprojectTypeService.get(tcontract.getTprojectApplication().getTprojectType().getParentTypeId());
				this.type = tprojectType.getTypeShowName(); 
			}
			}
    		
		return "init";
	}
	  
	/**
	 * 
	 * @comments 下拉列表联动
	 * @return
	 * @throws Exception
	 * @version 1.0
	 */
    public String getSecondData() throws Exception
    {
    	try{
    		// 取得联动下拉列表数据List
    		List<Mitem> dataList = mitemService.getMitemListByPId(pitemId);
    		StringBuffer dataStr = new StringBuffer();
    		
    		if(dataList != null){
    			// 遍历下拉列表List 组成json字符串
    			for(int i=0; i<dataList.size();i++){
    				dataStr.append(dataList.get(i).getItemId());
    				dataStr.append(",");
    				dataStr.append(dataList.get(i).getItemName());
    				if(i != dataList.size() -1){
    					dataStr.append(",");
    				}
    			}
    		}
    		this.backStr = dataStr.toString();
    		return "getDataSuccess";
    	}
    	catch (Exception e) {
            return "error";
        }
    }

	
	/**
	 * 
	 * @comments 封皮信息保存 
	 * @return
	 * @throws Exception
	 * @version 1.0
	 */
    public String updatecontractCover() throws Exception{
		// 取得登录用户的信息
		HttpSession session = this.getRequest().getSession();
		// 取得令牌信息
	  	  String cmdkey = (String) session.getAttribute(Constants.SESSION_CMDKEY);
		ScUsers user = (ScUsers) session.getAttribute("sysUser");
		// 判断是否失效
    	if (user == null || ("").equals(user.getUserId())
    			|| !"contractCover".equals(cmdkey)) {
    		logger.error("用户不存在！");
			return "LogOut";
		}
	  	tcontractCoverAService.updatecontractCover(this.tcontractCover,this.tcontractId);
		this.setRetMsg(this.getText("opt_save_suc"));
		this.setRetUrl(super.getRequest().getContextPath()
				+ "/api/contract/tcontractCover!importCover.action?tcontractId="+ this.tcontractId 
				+"&Flag="+this.Flag
				+ "&contractStatus=" +contractStatus 
				+ "&modelType="+ modelType 
				+ "&now=" +  new Date().getTime());
    	return "systemInfo";
    }
	/**
	 * @comments 封皮信息下一步操作
	 * @return
	 * @version 1.0
	 */
	public String next(){
		// 取得登录用户的信息
		HttpSession session = this.getRequest().getSession();
		// 取得令牌信息
	  	  String cmdkey = (String) session.getAttribute(Constants.SESSION_CMDKEY);
		ScUsers user = (ScUsers) session.getAttribute("sysUser");
		// 判断是否失效
    	if (user == null || ("").equals(user.getUserId())
    			|| !"contractCover".equals(cmdkey)) {
    		logger.error("用户不存在！");
			return "LogOut";
		}
		// 取得页面提交的合同封皮信息
		this.tcontract = this.getTcontract();
		tcontractCoverAService.updatecontractCover(this.tcontractCover,this.tcontractId);
		this.setRetMsg(this.getText("opt_save_suc"));
		this.setRetUrl(super.getRequest().getContextPath()
				+ "/api/contract/tcontractContentsB!initContents.action?&Flag="+Flag
				+ "&tcontractId="+ tcontractId 
				+"&contractStatus="+contractStatus
				+"&modelType="+ modelType 
				+"&now=" + new Date().getTime());
        return "systemInfoNext";
	}
	
	public String list(){
		
		return "list";
	}
	
	/**
	 * 跳转到添加页面
	 * @return String
	 */
	public String insert(){
		
		return "insert";
	}
	
	/**
	 * 修改信息
	 * @return String
	 */
	public String updateDept(){
		
		return SUCCESS;
			
	}
	
	/**
	 * 跳转到修改页面
	 * @return String
	 */
	public String modify(){
		return "modify";
	}

	public TcontractCoverAService getTcontractCoverAService() {
		return tcontractCoverAService;
	}

	public void setTcontractCoverAService(
			TcontractCoverAService tcontractCoverAService) {
		this.tcontractCoverAService = tcontractCoverAService;
	}

	public TcontractService getTcontractService() {
		return tcontractService;
	}

	public void setTcontractService(TcontractService tcontractService) {
		this.tcontractService = tcontractService;
	}

	public TattachmentService getTattachmentService() {
		return tattachmentService;
	}

	public void setTattachmentService(TattachmentService tattachmentService) {
		this.tattachmentService = tattachmentService;
	}

	public MitemService getMitemService() {
		return mitemService;
	}

	public void setMitemService(MitemService mitemService) {
		this.mitemService = mitemService;
	}

	public TprojectTypeService getTprojectTypeService() {
		return tprojectTypeService;
	}

	public void setTprojectTypeService(TprojectTypeService tprojectTypeService) {
		this.tprojectTypeService = tprojectTypeService;
	}

	public int getPageNo() {
		return pageNo;
	}

	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}

	public String getTcontractId() {
		return tcontractId;
	}

	public void setTcontractId(String tcontractId) {
		this.tcontractId = tcontractId;
	}

	public Tcontract getTcontract() {
		return tcontract;
	}

	public void setTcontract(Tcontract tcontract) {
		this.tcontract = tcontract;
	}

	public TcontractCoverA getTcontractCover() {
		return tcontractCover;
	}

	public void setTcontractCover(TcontractCoverA tcontractCover) {
		this.tcontractCover = tcontractCover;
	}

	public List<Map<String, String>> getContractStep() {
		return contractStep;
	}

	public void setContractStep(List<Map<String, String>> contractStep) {
		this.contractStep = contractStep;
	}

	public String getContractType() {
		return contractType;
	}

	public void setContractType(String contractType) {
		this.contractType = contractType;
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

	public String getCentralizedManagement() {
		return centralizedManagement;
	}

	public void setCentralizedManagement(String centralizedManagement) {
		this.centralizedManagement = centralizedManagement;
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

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
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

	public String getTableName() {
		return tableName;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

	public String getFileType() {
		return fileType;
	}

	public void setFileType(String fileType) {
		this.fileType = fileType;
	}

	public String getSequence() {
		return sequence;
	}

	public void setSequence(String sequence) {
		this.sequence = sequence;
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

	public String getEntrustmentCompany() {
		return entrustmentCompany;
	}

	public void setEntrustmentCompany(String entrustmentCompany) {
		this.entrustmentCompany = entrustmentCompany;
	}

	public String getContractComment() {
		return contractComment;
	}

	public void setContractComment(String contractComment) {
		this.contractComment = contractComment;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
