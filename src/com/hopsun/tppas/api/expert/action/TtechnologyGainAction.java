/*************** 版权声明***************
*
* Copyright (C) 2012 西安辉盛科技发展有限责任公司.
*
********************************************
*/
package com.hopsun.tppas.api.expert.action;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import com.hopsun.framework.base.action.BaseAction;
import com.hopsun.framework.base.bean.Pager;
import com.hopsun.scenter.entity.ScUsers;
import com.hopsun.tppas.api.expert.service.TtechnologyGainService;
import com.hopsun.tppas.common.CommonTool;
import com.hopsun.tppas.common.Constants;
import com.hopsun.tppas.entity.TtechnologyGain;
/**
 * @comment 专业技术研究成果类
 * @author yank
 * @DATE: 2013-08-19 @TIME: 下午2:09:37
 * @Vsersion: 1.0
 */
public class TtechnologyGainAction extends BaseAction{
  
	private static final long serialVersionUID = 3702437182325214784L;
	
	@Resource
	private TtechnologyGainService ttechnologyGainService;
	
	/**专业技术研究成果对象*/
	private TtechnologyGain ttechnologyGain;
	
	/**专家ID*/
	private String expertId;
	
	/**专业技术研究成果ID*/
	private String gainId;
	
	/**是否可以修改*/
	private String isEdit = "1";
	
	/** 跳转路径**/
	private String retUrl;
	
	/** 跳转页面massage**/
	private String retMsg;
	
	/** 翻页 */
	private int pageNo;
	
	/**是显示还是修改*/
	private String isShow = "1";
	
	/**
	 *  专业技术研究成果列表
	 * @comments 
	 * @return
	 * @version 1.0
	 */
	public String list(){
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
    	this.setRetUrl(super.getRequest().getContextPath()+ "/api/expert/ttechnologyGainAction!list.action?expertId="+ttechnologyGain.getExpertId()+"&isEdit="+isEdit+"&now="+ new Date().getTime());
    		
    	return "systemInfo";
	}
	
	/**
	 * 跳转到修改页面
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
    	this.setRetUrl(super.getRequest().getContextPath()+ "/api/expert/ttechnologyGainAction!list.action?expertId="+ttechnologyGain.getExpertId()+"&isEdit=1&now="+ new Date().getTime());
    		
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
    	this.setRetUrl(super.getRequest().getContextPath()+ "/api/expert/ttechnologyGainAction!list.action?expertId="+expertId+"&now="+ new Date().getTime());
		
    	return "systemInfo";
	}
	
	/**
	 * 跳转到查看页面
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

	public int getPageNo() {
		return pageNo;
	}

	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}

	public String getExpertId() {
		return expertId;
	}

	public void setExpertId(String expertId) {
		this.expertId = expertId;
	}

	public String getGainId() {
		return gainId;
	}

	public void setGainId(String gainId) {
		this.gainId = gainId;
	}

	public String getIsEdit() {
		return isEdit;
	}

	public void setIsEdit(String isEdit) {
		this.isEdit = isEdit;
	}

	public TtechnologyGain getTtechnologyGain() {
		return ttechnologyGain;
	}

	public void setTtechnologyGain(TtechnologyGain ttechnologyGain) {
		this.ttechnologyGain = ttechnologyGain;
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

	public String getIsShow() {
		return isShow;
	}

	public void setIsShow(String isShow) {
		this.isShow = isShow;
	}
}
