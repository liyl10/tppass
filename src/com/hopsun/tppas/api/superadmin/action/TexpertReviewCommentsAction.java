/*************** 版权声明***************
*
* Copyright (C) 2012 西安辉盛科技发展有限责任公司.
*
********************************************
*/
package com.hopsun.tppas.api.superadmin.action;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.hopsun.framework.base.action.BaseAction;
import com.hopsun.framework.base.bean.Pager;
import com.hopsun.scenter.entity.ScUsers;
import com.hopsun.tppas.api.superadmin.service.MitemService;
import com.hopsun.tppas.api.superadmin.service.TexpertReviewCommentsService;
import com.hopsun.tppas.api.superadmin.service.TprojectTypeManagerService;
import com.hopsun.tppas.api.superadmin.service.TprojectTypeService;
import com.hopsun.tppas.common.Constants;
import com.hopsun.tppas.entity.Mitem;
import com.hopsun.tppas.entity.TexpertReviewComments;
import com.hopsun.tppas.entity.TprojectType;

/**
 * @comment 专家评审模板
 * @author weina
 * @DATE: 2013-10-28 @TIME: 下午1:49:55
 * @Vsersion: 1.0
 */
public class TexpertReviewCommentsAction extends BaseAction{
	private static final long serialVersionUID = 2776469794178490487L;
	public final static Logger LOGGER = Logger.getLogger(TexpertReviewCommentsAction.class.getName());
	/** 项目分类*/
	@Resource
	private TprojectTypeService tprojectTypeService;
	/** 专家评估模板*/
	@Resource
	private TexpertReviewCommentsService texpertReviewCommentsService;
	/** 码表*/
	@Resource
	private MitemService mitemService;
	/** 判断专员调用的Service*/
	@Resource
	private TprojectTypeManagerService tprojectTypeManagerService;
	/** 专家评估模板实体*/
	private TexpertReviewComments texpertReviewComments;
	/** 项目分类*/
	private TprojectType tprojectType;
	/** 专家评估ID*/
	private String expertReviewCommentsId;
	/** 模板id(技术、投资)*/
	private String expertType;
	/** 项目分类ID*/
	private String typeId;
	/** 大分类*/
	private String parentTypeId;
	/** 计划类别ID*/
	private String planFlagId;
	/** 专家评估模板列表*/
	private List<Mitem> expertReviewList;

	/** 项目分类对应的专家评估模板list*/
	private List<String> copyModelList;
	/** 封装项目分类对应的专家评估模板list*/
	private ArrayList<Map<String,String>> modelList = new ArrayList<Map<String,String>>();
	
	/** 有专家评估模板的项目分类list*/
	private List<String> copyExpertReviewList;
	/** 封装有专家评估模板的项目分类list*/
	private ArrayList<Map<String,String>> copyList = new ArrayList<Map<String,String>>();
	
	private String typeShowName1;
	private String expertTypeName;

	private String retMsg;
	private String retUrl;
	private Integer score1;
	private Integer score2;
	private Integer score3;
	private Integer score4;
	private Integer score5;
	private int pageNo;
	/** 下拉列表返回字符串 */
	private String backStr;
	/** 新增按钮是否显示*/
	private String addbtnFlaf;
	private String pitemId;

	/**
	 * @Comments 管理员操作-列表初始化
	 * @return
	 * @Vsersion: 1.0
	 */
	public String list(){
		
		HttpSession session = this.getRequest().getSession();
		session.setAttribute(Constants.SESSION_CMDKEY, "texpertReviewComments");
    	// 翻页
    	if (pager == null && this.getPageNo() == 0) {
			pager = new Pager();
		}
    	else{
    		pager = new Pager();
    		pager.setPageNumber(this.getPageNo());
    	}
    	// 取得项目分类信息
    	if(parentTypeId != null && !"".equals(parentTypeId)){
    		planFlagId = this.parentTypeId;
    	}
    	// 取得列表显示的项目分类名字
    	this.typeShowName1 = tprojectTypeService.getProjectTypeName(planFlagId)+ "-" + tprojectTypeService.getProjectTypeName(typeId);
		pager = texpertReviewCommentsService.find(typeShowName1,typeId,pager.getPageNumber(), pager.getPageSize());
		// 如果新增的专家模板大于2个。则不能再新增模板
		if(pager.getList().size() >= 2){
			this.addbtnFlaf = "1";
		}
		return "list";
	}
	/**
	 * 
	 * @comments 复制专家评审模板 初始化
	 * @return
	 * @version 1.0
	 */
	public String copyExpertreview(){
		HttpSession session = this.getRequest().getSession();
		String cmdkey = (String) session.getAttribute(Constants.SESSION_CMDKEY);
		//判断令牌
		if (cmdkey == null
				|| (!"texpertReviewComments".equals(cmdkey) && !"jointAudit".equals(cmdkey))) {
			LOGGER.error("令牌不正确");
			return "LogOut";
		}
		this.typeId = this.getTypeId();
	
		// 取得要copy的项目分类id列表
		copyExpertReviewList = texpertReviewCommentsService.getCopyExpertReviewList(this.typeId);
		copyList = new ArrayList<Map<String,String>>();
		if(copyExpertReviewList != null && copyExpertReviewList.size()>0){
			// 循环封装要copy的项目分类-初始显示
			for (int i=0;i<copyExpertReviewList.size();i++) {
				Map<String, String> map = new HashMap<String, String>();
				map.put("key", copyExpertReviewList.get(i));
				map.put("name", tprojectTypeService.getProjectTypeName(copyExpertReviewList.get(i)));
				copyList.add(map);
			}
			// 专家评估模板列表-初始显示
			if(copyExpertReviewList.get(0) != null){
				List<TexpertReviewComments> texpertReviewComments = (List<TexpertReviewComments>) texpertReviewCommentsService.getCopyModelList(copyExpertReviewList.get(0));
				for(int j=0;j<texpertReviewComments.size();j++){
					Map<String, String> map1 = new HashMap<String, String>();
					map1.put("key1", texpertReviewComments.get(j).getExpertType());
					map1.put("name1", mitemService.getMitemNameById(texpertReviewComments.get(j).getExpertType()));
					modelList.add(map1);
				}
			}
		}
		// 跳转到专员copy初始画面
		if("jointAudit".equals(cmdkey)){
			return "jointcopyexpertreview";
		}
		// 跳转到管理员copy初始画面
		else{
			return "copyexpertreview";
		}
	}
	/**
	 * 
	 * @comments 拷贝专家评估模板 
	 * @return
	 * @version 1.0
	 */
	public String copyTexpertReviewComments(){
		HttpSession session = this.getRequest().getSession();
		String cmdkey = (String) session.getAttribute(Constants.SESSION_CMDKEY);
		ScUsers user = (ScUsers) session.getAttribute("sysUser");
		//判断令牌
		if (cmdkey == null
				|| (!"texpertReviewComments".equals(cmdkey) && !"jointAudit".equals(cmdkey))) {
			LOGGER.error("令牌不正确");
			return "LogOut";
		}
		// 取得被copy的模板信息
		texpertReviewComments = texpertReviewCommentsService.getCopyTexpertReviewCommen(this.texpertReviewComments.getTypeId(),this.texpertReviewComments.getExpertType());
		// 保存复制的模板信息
		texpertReviewCommentsService.saveCopy(user.getUserId(),texpertReviewComments,typeId);
		// 设置提示信息
		this.setRetMsg(this.getText("opt_save_suc"));
		// 跳转到专员列表画面
		if("jointAudit".equals(cmdkey)){
			this.setRetUrl(super.getRequest().getContextPath()
					+ "/api/superadmin/texpertreviewcommentsaction!operateExpertScoreByGroupList.action?typeId="+typeId+"&planFlagId="+planFlagId+"&dd="
					+ new Date().getTime());
		}
		// 跳转到管理员列表画面
		else{
			this.setRetUrl(super.getRequest().getContextPath()
					+ "/api/superadmin/texpertreviewcommentsaction!list.action?typeId="+typeId+"&planFlagId="+planFlagId+"&dd="
					+ new Date().getTime());
		}
		return "systemInfoMain";
	}
	/**
	 * @comments 下拉列表联动
	 * @return
	 * @version 1.0
	 */
	public String getSecondData() throws Exception {
		try {
			// 取得联动专家评估模板的下拉列表数据List
			List<TexpertReviewComments> texpertReviewComments = (List<TexpertReviewComments>) texpertReviewCommentsService.getCopyModelList(pitemId);
			StringBuffer dataStr = new StringBuffer();

			if (texpertReviewComments != null) {
				// 遍历下拉列表List 组成json字符串
				for (int i = 0; i < texpertReviewComments.size(); i++) {
					dataStr.append(texpertReviewComments.get(i).getExpertType());
					dataStr.append(",");
					dataStr.append(mitemService.getMitemNameById(texpertReviewComments.get(i).getExpertType()));
					if (i != texpertReviewComments.size() - 1) {
						dataStr.append(",");
					}
				}
			}
			this.backStr = dataStr.toString();
			return "getDataSuccess";
		} catch (Exception e) {
			return "error";
		}
	}
	
	/**
	 * 添加页面初始化
	 * @return String
	 */
	public String insert(){
		HttpSession session = this.getRequest().getSession();
		String cmdkey = (String) session.getAttribute(Constants.SESSION_CMDKEY);
		//判断令牌
		if (cmdkey == null
				|| (!"texpertReviewComments".equals(cmdkey) && !"jointAudit".equals(cmdkey))) {
			LOGGER.error("令牌不正确");
			return "LogOut";
		}
		// 专家评估模板下拉值
    	this.expertReviewList = new ArrayList<Mitem>();
    	List<Mitem> expertReviewList1 = new ArrayList<Mitem>();
    	expertReviewList1 = mitemService.getListByTypeId(Constants.EXPERT_TYPE);
    	for(int i=0;i<expertReviewList1.size();i++){
    		texpertReviewComments = texpertReviewCommentsService.getexpertReviewList(typeId);
    		if(texpertReviewComments != null){
    			if(!expertReviewList1.get(i).getItemId().equals(texpertReviewComments.getExpertType()))
    			{
    				expertReviewList.add(expertReviewList1.get(i));
    			}
    		}else{
    			expertReviewList = mitemService.getListByTypeId(Constants.EXPERT_TYPE);
    		}
    	}
    	// 跳转到专员新增初始画面
    	if("jointAudit".equals(cmdkey)){
			return "jointinsert";
		}
    	// 跳转到管理员新增初始画面
    	else{
			return "insert";
		}
	}
	/**
	 * 修改页面初始化
	 * @return String
	 */
	public String modify(){
		HttpSession session = this.getRequest().getSession();
		String cmdkey = (String) session.getAttribute(Constants.SESSION_CMDKEY);
		//判断令牌
		if (cmdkey == null
				|| (!"texpertReviewComments".equals(cmdkey) && !"jointAudit".equals(cmdkey))) {
			LOGGER.error("令牌不正确");
			return "LogOut";
		}
		this.typeId = this.getTypeId();
		this.expertReviewCommentsId = this.getExpertReviewCommentsId();
		// 修改画面的信息
		if (this.expertReviewCommentsId != null && !Constants.STRING_EMPTY.equals(this.expertReviewCommentsId)) {
			texpertReviewComments = texpertReviewCommentsService.get(expertReviewCommentsId);
			texpertReviewComments.setExpertTypeName(mitemService.getMitemNameById(texpertReviewComments.getExpertType()));
		}
		// 跳转到专员修改初始画面
		if("jointAudit".equals(cmdkey)){
			return "jointmodify";
		}
		// 跳转到管理员修改初始画面
		else{
			return "modify";
		}
	}
	/**
	 * 
	 * @comments 新增、修改 
	 * @return
	 * @version 1.0
	 */
	public String insertTexpertReviewCommen(){

		HttpSession session = this.getRequest().getSession();
		String cmdkey = (String) session.getAttribute(Constants.SESSION_CMDKEY);
		ScUsers user = (ScUsers) session.getAttribute("sysUser");
		//判断令牌
		if (cmdkey == null
				|| (!"texpertReviewComments".equals(cmdkey) && !"jointAudit".equals(cmdkey))) {
			LOGGER.error("令牌不正确");
			return "LogOut";
		}
		texpertReviewCommentsService.updateTexpertReview(user.getUserId(),texpertReviewComments,typeId);
		// 设置提示信息
		this.setRetMsg(this.getText("opt_save_suc"));
		// 跳转到专员列表
		if("jointAudit".equals(cmdkey)){
			this.setRetUrl(super.getRequest().getContextPath()
					+ "/api/superadmin/texpertreviewcommentsaction!operateExpertScoreByGroupList.action?typeId="+typeId+"&planFlagId="+planFlagId+"&dd="
					+ new Date().getTime());
		}
		// 跳转到管理员列表
		else{
			this.setRetUrl(super.getRequest().getContextPath()
					+ "/api/superadmin/texpertreviewcommentsaction!list.action?typeId="+typeId+"&planFlagId="+planFlagId+"&dd="
					+ new Date().getTime());
		}
		return "systemInfoMain";	
		
	}
	/**
	 * @Comments 删除该信息
	 * @return
	 * @Vsersion: 1.0
	 */
	public String delete(){
		HttpSession session = this.getRequest().getSession();
		String cmdkey = (String) session.getAttribute(Constants.SESSION_CMDKEY);
		//判断令牌
		if (cmdkey == null
				|| (!"texpertReviewComments".equals(cmdkey) && !"jointAudit".equals(cmdkey))) {
			LOGGER.error("令牌不正确");
			return "LogOut";
		}
		texpertReviewComments = texpertReviewCommentsService.get(expertReviewCommentsId);
		// 设置删除flag
		texpertReviewComments.setDeleteFlag("1");
		texpertReviewCommentsService.update(texpertReviewComments);
		//更新缓存
		tprojectTypeService.evict(texpertReviewComments);

		this.setRetMsg(this.getText("opt_del_suc"));
		// 跳转到专员的列表
		if("jointAudit".equals(cmdkey)){
			this.setRetUrl(super.getRequest().getContextPath()
					+ "/api/superadmin/texpertreviewcommentsaction!operateExpertScoreByGroupList.action?typeId="+typeId+"&planFlagId="+planFlagId+"&dd="
					+ new Date().getTime());
		}
		// 跳转到管理员的列表
		else{
			this.setRetUrl(super.getRequest().getContextPath()
					+ "/api/superadmin/texpertreviewcommentsaction!list.action?typeId="+typeId+"&planFlagId="+planFlagId+"&dd="
					+ new Date().getTime());
		}
		return "systemInfoMain";		
	}
	/**
	 * 
	 * @comments 判断5个分值总分数是否超过100
	 * @return
	 * @version 1.0
	 */
	public String getScoreTotal(){
		// 总分数
		int scoreTotal = this.getScore1()+this.getScore2()+this.getScore3()+this.getScore4()+this.getScore5();
		if(scoreTotal > 100){
			this.backStr = "NotExist";
		}else{
			this.backStr = "Exist";
		}
		return "getDataSuccess";
	}
	/**
	 * 
	 * @comments 列表上有的模板类型就不能再复制了 
	 * @return
	 * @version 1.0
	 */
	public String checkExpertReview(){
		List<TexpertReviewComments> te = texpertReviewCommentsService.getExpertModelList(typeId);
		for(int i=0;i<te.size();i++){
			if(pitemId.equals(te.get(i).getExpertType())){
				this.backStr = "Exist";
			}else{
				this.backStr = "NotExist";
			}
		}
		return "getDataSuccess";
	}
	/**
	 * 
	 * @comments 专员登录操作，点击专家评估模板按钮-初始化画面 
	 * @return
	 * @version 1.0
	 */
	public String operateExpertScoreByGroupList(){
		HttpSession session = this.getRequest().getSession();
		ScUsers user = (ScUsers) session.getAttribute("sysUser");
		// 翻页
    	if (pager == null && this.getPageNo() == 0) {
			pager = new Pager();
		}
    	else{
    		pager = new Pager();
    		pager.setPageNumber(this.getPageNo());
    	}
    	// 通过user查询小分类
    	TprojectType projectType = tprojectTypeManagerService.getTprojectTypeByUser(user);
    	// 取得项目分类信息
    	this.typeId = projectType.getTypeId();
    	this.planFlagId = projectType.getParentTypeId();
    	// 取得列表显示的项目分类名字
    	this.typeShowName1 = tprojectTypeService.getProjectTypeName(planFlagId)+ "-" + tprojectTypeService.getProjectTypeName(typeId);
		pager = texpertReviewCommentsService.find(typeShowName1,projectType.getTypeId(),pager.getPageNumber(), pager.getPageSize());
		// 如果新增的专家模板大于2个。则不能再新增模板
		if(pager.getList().size() >= 2){
			this.addbtnFlaf = "1";
		}
		return "operateExpertScoreByGroupList";
	}
	
	
	public TprojectTypeManagerService getTprojectTypeManagerService() {
		return tprojectTypeManagerService;
	}
	public void setTprojectTypeManagerService(
			TprojectTypeManagerService tprojectTypeManagerService) {
		this.tprojectTypeManagerService = tprojectTypeManagerService;
	}
	public TprojectTypeService getTprojectTypeService() {
		return tprojectTypeService;
	}

	public void setTprojectTypeService(TprojectTypeService tprojectTypeService) {
		this.tprojectTypeService = tprojectTypeService;
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

	public int getPageNo() {
		return pageNo;
	}

	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}

	
	public TprojectType getTprojectType() {
		return tprojectType;
	}

	public void setTprojectType(TprojectType tprojectType) {
		this.tprojectType = tprojectType;
	}

	public String getTypeId() {
		return typeId;
	}

	public void setTypeId(String typeId) {
		this.typeId = typeId;
	}

	

	/**
	 * @return the backStr
	 */
	public String getBackStr() {
		return backStr;
	}

	/**
	 * @param backStr the backStr to set
	 */
	public void setBackStr(String backStr) {
		this.backStr = backStr;
	}
	public TexpertReviewCommentsService getTexpertReviewCommentsService() {
		return texpertReviewCommentsService;
	}
	public void setTexpertReviewCommentsService(
			TexpertReviewCommentsService texpertReviewCommentsService) {
		this.texpertReviewCommentsService = texpertReviewCommentsService;
	}
	public TexpertReviewComments getTexpertReviewComments() {
		return texpertReviewComments;
	}
	public void setTexpertReviewComments(TexpertReviewComments texpertReviewComments) {
		this.texpertReviewComments = texpertReviewComments;
	}
	public String getExpertReviewCommentsId() {
		return expertReviewCommentsId;
	}
	public void setExpertReviewCommentsId(String expertReviewCommentsId) {
		this.expertReviewCommentsId = expertReviewCommentsId;
	}
	public String getTypeShowName1() {
		return typeShowName1;
	}
	public void setTypeShowName1(String typeShowName1) {
		this.typeShowName1 = typeShowName1;
	}

	public String getAddbtnFlaf() {
		return addbtnFlaf;
	}

	public void setAddbtnFlaf(String addbtnFlaf) {
		this.addbtnFlaf = addbtnFlaf;
	}

	public Integer getScore1() {
		return score1;
	}

	public void setScore1(Integer score1) {
		this.score1 = score1;
	}

	public Integer getScore2() {
		return score2;
	}

	public void setScore2(Integer score2) {
		this.score2 = score2;
	}

	public Integer getScore3() {
		return score3;
	}

	public void setScore3(Integer score3) {
		this.score3 = score3;
	}

	public Integer getScore4() {
		return score4;
	}

	public void setScore4(Integer score4) {
		this.score4 = score4;
	}

	public Integer getScore5() {
		return score5;
	}

	public void setScore5(Integer score5) {
		this.score5 = score5;
	}

	public String getPitemId() {
		return pitemId;
	}

	public void setPitemId(String pitemId) {
		this.pitemId = pitemId;
	}


	public List<Mitem> getExpertReviewList() {
		return expertReviewList;
	}

	public void setExpertReviewList(List<Mitem> expertReviewList) {
		this.expertReviewList = expertReviewList;
	}

	public MitemService getMitemService() {
		return mitemService;
	}

	public void setMitemService(MitemService mitemService) {
		this.mitemService = mitemService;
	}

	public String getExpertType() {
		return expertType;
	}

	public void setExpertType(String expertType) {
		this.expertType = expertType;
	}

	public String getExpertTypeName() {
		return expertTypeName;
	}

	public void setExpertTypeName(String expertTypeName) {
		this.expertTypeName = expertTypeName;
	}

	public List<String> getCopyExpertReviewList() {
		return copyExpertReviewList;
	}
	public void setCopyExpertReviewList(List<String> copyExpertReviewList) {
		this.copyExpertReviewList = copyExpertReviewList;
	}
	
	public ArrayList<Map<String, String>> getCopyList() {
		return copyList;
	}
	public void setCopyList(ArrayList<Map<String, String>> copyList) {
		this.copyList = copyList;
	}
	public List<String> getCopyModelList() {
		return copyModelList;
	}
	public void setCopyModelList(List<String> copyModelList) {
		this.copyModelList = copyModelList;
	}
	public ArrayList<Map<String, String>> getModelList() {
		return modelList;
	}
	public void setModelList(ArrayList<Map<String, String>> modelList) {
		this.modelList = modelList;
	}
	public String getPlanFlagId() {
		return planFlagId;
	}
	public void setPlanFlagId(String planFlagId) {
		this.planFlagId = planFlagId;
	}
	public String getParentTypeId() {
		return parentTypeId;
	}
	public void setParentTypeId(String parentTypeId) {
		this.parentTypeId = parentTypeId;
	}

	
}
