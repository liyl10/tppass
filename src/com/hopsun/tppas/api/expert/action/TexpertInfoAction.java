/*************** 版权声明***************
*
* Copyright (C) 2012 西安辉盛科技发展有限责任公司.
*
********************************************
*/
package com.hopsun.tppas.api.expert.action;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import com.hopsun.framework.base.action.BaseAction;
import com.hopsun.framework.base.bean.Pager;
import com.hopsun.scenter.entity.ScUsers;
import com.hopsun.tppas.api.expert.service.TexpertService;
import com.hopsun.tppas.api.expert.service.TtechnologyGainService;
import com.hopsun.tppas.api.superadmin.service.MitemService;
import com.hopsun.tppas.common.CommonTool;
import com.hopsun.tppas.common.Constants;
import com.hopsun.tppas.entity.Mitem;
import com.hopsun.tppas.entity.Texpert;
import com.hopsun.tppas.entity.TtechnologyGain;
/**
 * @comment 专家信息维护
 * @author wangxiaodong
 * @DATE: 2013-08-27 @TIME: 下午10:09:37
 * @Vsersion: 1.0
 */
public class TexpertInfoAction extends BaseAction {

	private static final long serialVersionUID = -293172189099050506L;

	/**专家信息service*/
	@Resource
	private TexpertService texpertService;
	
	/**码表service*/
	@Resource
	private MitemService apiMitemService;
	
	/**专家专业技术研究成果类*/
	@Resource
	private TtechnologyGainService ttechnologyGainService;

	/**专家对象*/
	private  Texpert  texpert;
	
	/**专家对象ID*/
	private String expertId;
	
	/**专业技术研究成果对象*/
	private TtechnologyGain ttechnologyGain;
		
	/**专业技术研究成果ID*/
	private String gainId;
	
	/**擅长专业1集合*/
	private List<Mitem> expertMajor1List;
	
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
	
	/** 跳转页面massage**/
	private String retMsg;
	
	/**是保存还是下一步*/
	private String optType;
	
	/** 翻页 */
	private int pageNo;
	
	
	/**
	 * 专家基本信息维护
	 * @comments 
	 * @return
	 * @version 1.0
	 */
	public String expertManager(){
		HttpSession session = this.getRequest().getSession();
		ScUsers user = (ScUsers) session.getAttribute("sysUser");
		// 如果用户为空或者企业为空，退出系统
		if (user == null || ("").equals(user.getUserId())) {
			return "LogOut";
		}
		expertId = "402881d341b4a7110141b4e5d4580000";
		return "expertMenu";
	}
			

	/**
	 * 通过专家ID得到专家基本信息
	 * @comments 
	 * @return
	 * @version 1.0
	 */
	public String getExpertInfo(){
		HttpSession session = this.getRequest().getSession();
		ScUsers user = (ScUsers) session.getAttribute("sysUser");
		// 如果用户为空或者企业为空，退出系统
		if (user == null || ("").equals(user.getUserId())) {
			return "LogOut";
		}
		
		this.initDatas();
		if(CommonTool.IsNotEmpty(expertId)){
			texpert = texpertService.get(expertId);
		}else{
			texpert = new Texpert();
		}
		return "update";
	}


	
	/**
	 * 保存修改专家基本信息
	 * @comments 
	 * @return
	 * @version 1.0
	 */
	public String saveOrUpdateExpert(){
		HttpSession session = this.getRequest().getSession();
		ScUsers user = (ScUsers) session.getAttribute("sysUser");
		// 如果用户为空或者企业为空，退出系统
		if (user == null || ("").equals(user.getUserId())) {
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
    		this.setRetUrl(super.getRequest().getContextPath()+ "/api/expert/texpertInfoAction!getExpertInfo.action?expertId="+expertId+"&now="+ new Date().getTime());
    		return "systemInfo";
    	}else{
    		this.setRetUrl(super.getRequest().getContextPath()+ "/api/expert/texpertInfoAction!technologyGainList.action?expertId="+expertId+"&now="+ new Date().getTime());
    	}
    	
		return "systemInfoNext";
	}
	
	/**
	 * 专业技术研究成果列表
	 * @comments 
	 * @return
	 * @version 1.0
	 */
	public String technologyGainList(){
		HttpSession session = this.getRequest().getSession();
		ScUsers user = (ScUsers) session.getAttribute("sysUser");
		//如果用户为空退出系统
		if (user == null || ("").equals(user.getUserId())) {
			return "LogOut";
		}
		
		//分页
		if (pager == null && this.getPageNo() == 0) {
			pager = new Pager();
		} else {
			pager = new Pager();
			pager.setPageNumber(this.getPageNo());
		}
		
		Map<String, String> map=new HashMap<String, String>();
		map.put("expertId", expertId);
		pager=ttechnologyGainService.queryTechnologyGain(map,pager.getPageNumber(), pager.getPageSize());
		
		return "list";
	}
	
	/**
	 * 跳转到添加页面
	 * @comments 
	 * @return
	 * @version 1.0
	 */
	public String insertInit(){
		HttpSession session = this.getRequest().getSession();
		ScUsers user = (ScUsers) session.getAttribute("sysUser");
		// 如果用户为空退出系统
		if (user == null || ("").equals(user.getUserId())) {
			return "LogOut";
		}
		
		return "insert";
	}
	
	/**
	 * 保存专业技术研究成果
	 * @comments 
	 * @return
	 * @version 1.0
	 */
	public String saveTtechnologyGain(){
		HttpSession session = this.getRequest().getSession();
		ScUsers user = (ScUsers) session.getAttribute("sysUser");
		//如果用户为空退出系统
		if (user == null || ("").equals(user.getUserId())) {
			return "LogOut";
		}
		
		ttechnologyGain.setCreateTime(CommonTool.getTimestampTime());
		ttechnologyGain.setDeleteFlag(Constants.COMMON_STATE_NOTDELETE);
		ttechnologyGain.setCreateUser(user.getUserId());
		ttechnologyGainService.save(ttechnologyGain);
		
    	this.setRetMsg(this.getText("opt_save_suc"));
    	this.setRetUrl(super.getRequest().getContextPath()+ "/api/expert/texpertInfoAction!technologyGainList.action?expertId="+ttechnologyGain.getExpertId()+"&now="+ new Date().getTime());
    		
    	return "systemInfo";
	}
	
	/**
	 * 跳转到专业技术研究成果修改页面
	 * @comments 
	 * @return
	 * @version 1.0
	 */
	public String modifyInit(){
		HttpSession session = this.getRequest().getSession();
		session.setAttribute(Constants.SESSION_CMDKEY, "ttechnologyGainAction");
		ScUsers user = (ScUsers) session.getAttribute("sysUser");
		//如果用户为空退出系统
		if (user == null || ("").equals(user.getUserId())) {
			return "LogOut";
		}
		
		//得到专业技术研究成果信息
		if(CommonTool.IsNotEmpty(gainId)){
			ttechnologyGain = ttechnologyGainService.get(gainId);
		}else{
			ttechnologyGain = new TtechnologyGain();
		}
		
		return "modify";
	}
	
	/**
	 * 修改专业技术研究成果
	 * @comments 
	 * @return
	 * @version 1.0
	 */
	public String updateTtechnologyGain(){
		HttpSession session = this.getRequest().getSession();
		session.setAttribute(Constants.SESSION_CMDKEY, "ttechnologyGainAction");
		ScUsers user = (ScUsers) session.getAttribute("sysUser");
		//如果用户为空退出系统
		if (user == null || ("").equals(user.getUserId())) {
			return "LogOut";
		}
		
		ttechnologyGain.setUpdateDate(CommonTool.getTimestampTime());
		ttechnologyGain.setUpdateUser(user.getUserId());
		ttechnologyGainService.update(ttechnologyGain);
		
		this.setRetMsg(this.getText("opt_update_suc"));
    	this.setRetUrl(super.getRequest().getContextPath()+ "/api/expert/texpertInfoAction!technologyGainList.action?expertId="+ttechnologyGain.getExpertId()+"&isEdit=1&now="+ new Date().getTime());
    		
    	return "systemInfo";
			
	}
	
	/**
	 * 删除专业技术研究成果
	 * @comments 
	 * @return
	 * @version 1.0
	 */
	public String deleteTtechnologyGain(){
		HttpSession session = this.getRequest().getSession();
		session.setAttribute(Constants.SESSION_CMDKEY, "ttechnologyGainAction");
		ScUsers user = (ScUsers) session.getAttribute("sysUser");
		//如果用户为空退出系统
		if (user == null || ("").equals(user.getUserId())) {
			return "LogOut";
		}
		
		if(CommonTool.IsNotEmpty(gainId)){
			ttechnologyGainService.deleteTechnologyGain(gainId);
			this.setRetMsg(this.getText("opt_del_suc"));
		}else{
			this.setRetMsg(this.getText("opt_del_err"));
		}
    	this.setRetUrl(super.getRequest().getContextPath()+ "/api/expert/texpertInfoAction!technologyGainList.action?expertId="+expertId+"&now="+ new Date().getTime());
		
    	return "systemInfo";
	}
	
	/**
	 * 跳转到专业技术研究成果查看页面
	 * @comments 
	 * @return
	 * @version 1.0
	 */
	public String showInit(){
		HttpSession session = this.getRequest().getSession();
		session.setAttribute(Constants.SESSION_CMDKEY, "ttechnologyGainAction");
		ScUsers user = (ScUsers) session.getAttribute("sysUser");
		//如果用户为空退出系统
		if (user == null || ("").equals(user.getUserId())) {
			return "LogOut";
		}
		
		//得到专业技术研究成果信息
		if(CommonTool.IsNotEmpty(gainId)){
			ttechnologyGain = ttechnologyGainService.get(gainId);
		}else{
			ttechnologyGain = new TtechnologyGain();
		}
		
		return "show";
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

	public Texpert getTexpert() {
		return texpert;
	}

	public void setTexpert(Texpert texpert) {
		this.texpert = texpert;
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


	public String getOptType() {
		return optType;
	}


	public void setOptType(String optType) {
		this.optType = optType;
	}


	public int getPageNo() {
		return pageNo;
	}


	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}


	public TtechnologyGain getTtechnologyGain() {
		return ttechnologyGain;
	}


	public void setTtechnologyGain(TtechnologyGain ttechnologyGain) {
		this.ttechnologyGain = ttechnologyGain;
	}


	public String getGainId() {
		return gainId;
	}


	public void setGainId(String gainId) {
		this.gainId = gainId;
	}
}
