/************************* 版权声明 *********************************
 *
 * Copyright (C) 2012 西安辉盛科技发展有限责任公司.
 *
 ******************************************************************
 */
package com.hopsun.scenter.api.dept.action;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;

import com.hopsun.framework.base.action.BaseAction;
import com.hopsun.framework.base.bean.Pager;
import com.hopsun.framework.util.StrutsUtil;
import com.hopsun.scenter.api.dept.service.DeptService;
import com.hopsun.scenter.entity.ScDept;
import com.hopsun.scenter.entity.ScUsers;
import com.hopsun.subgroups.logs.util.RequestUtil;
import com.hopsun.subgroups.paramconfig.bean.ParamConfigBean;
import com.hopsun.subgroups.paramconfig.util.ParamConfigUtil;

/**
 * 
 *@comments 后台Action类 - 主要用来做部门信息管理工作
 *@author dulei(dulei@hospun.com)
 *@date Jan 5, 2013 
 *@version 1.0
 *
 */
public class DeptAction extends BaseAction {

	private static final long serialVersionUID = 5488541105915460140L;
	public Map<String, Object> pro_result = new HashMap<String, Object>();
	//部门信息
	private ScDept dept; 
	//部门信息集合
	private List<ScDept> list; 
	//系统参数实体 - 是否启用
	private ParamConfigBean bean; 
	//系统参数实体 - 审核状态
	private ParamConfigBean verify;
	//部门名称
	private String deptname;
	//部门Code
	private String deptcode;
	//上级部门id
	private String parentid;
	//部门id
	private String deptId;
	// 查询条件
	public Map<String, Object> condition; 
	@Resource
	//部门信息服务接口
	private DeptService deptService; 
	//加载部门，返回json字符串
	public String supDeptListJson;
	
	/**
	 * 跳转到部门管理列表页面（根据条件搜索部门信息）
	 * @return String
	 * @version 1.0
	 */
	public String list(){
		
		if (pager == null) {
			pager = new Pager();
		}
		if(dept==null){
			dept=new ScDept();
		}
		condition = new HashMap<String, Object>(); // 页面查询条件，用于回显
		condition.put("verifyState", dept.getVerifyState());
		condition.put("enableState", dept.getEnableState());
		String verify_state=dept.getVerifyState();
		if (verify_state != null && !"".equals(verify_state)) {
			String verifyState = null;
			if ("3".equals(verify_state)) {
				verifyState = ((ParamConfigBean) StrutsUtil.getApplication().getAttribute("VERIFY_STATE")).getBeansByCode("notsubmit").getValue();// 未提交
			} else if ("1".equals(verify_state)) {
				verifyState = ((ParamConfigBean) StrutsUtil.getApplication().getAttribute("VERIFY_STATE")).getBeansByCode("verifypass").getValue();// 审核通过
			} else if ("2".equals(verify_state)) {
				verifyState = ((ParamConfigBean) StrutsUtil.getApplication().getAttribute("VERIFY_STATE")).getBeansByCode("verifyrefuse").getValue();// 审核不通过
			} else {
				verifyState = ((ParamConfigBean) StrutsUtil.getApplication().getAttribute("VERIFY_STATE")).getBeansByCode("submit").getValue();// 提交审核
			}
			dept.setVerifyState(verifyState);
		}
		String enable_state=dept.getEnableState();
		if (enable_state != null && !"".equals(enable_state)) {
			String enableState = null;
			if ("1".equals(enable_state)) {
				enableState = ((ParamConfigBean) StrutsUtil.getApplication().getAttribute("CONFIG_STATE")).getBeansByCode("enable").getValue();// 启用
			} else {
				enableState = ((ParamConfigBean) StrutsUtil.getApplication().getAttribute("CONFIG_STATE")).getBeansByCode("disable").getValue();// 禁用

			}
			dept.setEnableState(enableState);
		}
		
		pager = deptService.find(dept, pager.getPageNumber(), pager.getPageSize());
		
		//上级部门信息
		list = deptService.findDept(new ScDept());
		
		//是否启用
		bean = (ParamConfigBean)getApplication().getAttribute("CONFIG_STATE");
		
		//审核状态
		verify = (ParamConfigBean)getApplication().getAttribute("VERIFY_STATE");
		
		return "list";
	}
	
	/**
	 * 跳转到部门添加页面
	 * @return String
	 * @version 1.0
	 */
	public String insert(){
		
		//当前登录用户
		ScUsers user = (ScUsers)getSession().get("sysUser");
		
		//部门信息集合
		list = deptService.findDept(dept);
		//list = this.orderDept(list);
		
		//是否启用
		bean = (ParamConfigBean)getApplication().getAttribute("CONFIG_STATE");
		
		//加载用户部门树
		supDeptListJson=deptService.getDeptListJson(user,dept);
		
		return "insert";
	}
	
	public List<ScDept> orderDept(List<ScDept> list){
		List<ScDept> dList = new ArrayList<ScDept>();
		for(int i=0;i<list.size();i++){
			ScDept dept0 = list.get(0);
			dList.add(dept0);
			for(int j=1;j<list.size();j++){
				ScDept deptj = list.get(j);
				if(null != deptj.getScDept() && deptj.getScDept().getDeptId().equals(dept0.getDeptId())){
					deptj.setDeptName("&nbsp;&nbsp;"+deptj.getDeptName());
					dList.add(deptj);
				}
				for(int a=0;a<dList.size();a++){
					list.remove(dList.get(a));
				}
			}
		}
		return list;
	}
	
	/**
	 * 
	 * @comments ajax 根据部门名称查询部门信息，判断是否重名
	 * @version 1.0
	 */
	public void getDeptByName(){
		//根据部门名称查询部门信息
		ScDept dept = deptService.getDeptByDeptname(deptname,deptId,parentid);
		
		//boolean flag = null==dept?true:false;
		
		try {
			if(null!=dept){
				//部门名称已经存在
				String error = String.valueOf(ParamConfigUtil.getServletContext().getAttribute("validform.scenter.dept.deptName.exsit"));
				RequestUtil.getResponse().getWriter().write("{\"info\":\""+error+"\",\"status\":\"n\"}");
			}else{
				//恭喜您，部门名称不存在
				String error = String.valueOf(ParamConfigUtil.getServletContext().getAttribute("validform.scenter.dept.deptName.notexsit"));
				RequestUtil.getResponse().getWriter().write("{\"info\":\""+error+"\",\"status\":\"y\"}");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		//this.ajax(flag+"","text/html");
	}
	
	/**
	 * 
	 * @comments ajax 根据部门Code查询部门信息，判断是否重名
	 * @version 1.0
	 */
	public void getDeptByCode(){
		//根据部门名称查询部门信息
		ScDept dept = deptService.getDeptByDeptcode(deptcode,deptId,parentid);
		
		try {
			if(null != dept){
				//部门CODE已经存在
				String error = String.valueOf(ParamConfigUtil.getServletContext().getAttribute("validform.scenter.dept.deptCode.exsit"));
				RequestUtil.getResponse().getWriter().write("{\"info\":\""+error+"\",\"status\":\"n\"}");
			}else{
				//恭喜您，部门CODE不存在
				String error = String.valueOf(ParamConfigUtil.getServletContext().getAttribute("validform.scenter.dept.deptCode.notexsit"));
				RequestUtil.getResponse().getWriter().write("{\"info\":\""+error+"\",\"status\":\"y\"}");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		//boolean flag = null==dept?true:false;
		
		//this.ajax(flag+"","text/html");
	}
	
	/**
	 * 添加部门信息
	 * @return
	 * @version 1.0
	 */
	public String insertDept(){
		
		//系统当前用户
		ScUsers user = (ScUsers)getSession().get("sysUser");
		
		//根据部门名称查询部门信息，不允许重名部门信息
		if(null != deptService.getDeptByDeptname(dept.getDeptName(),null,dept.getScDept().getDeptId())){
			//提示信息
			//部门名称已经存在
			String error = String.valueOf(ParamConfigUtil.getServletContext().getAttribute("validform.scenter.dept.deptName.exsit"));
			addActionMessage(error);
			//跳转到错误提示页面
			return ERROR;
		//没有重名的部门信息
		}else {
			//添加人
			dept.setCreateUserName(user.getUserName());
			//添加时间
			dept.setCreateDate(new Date());
			//默认的审核状态
			dept.setVerifyState(((ParamConfigBean)getApplication().getAttribute("VERIFY_STATE")).getConfigDefault().getValue());
			//删除状态为未删除
			dept.setDeleteState(((ParamConfigBean)getApplication().getAttribute("DEL_STATE")).getBeansByCode("enable").getValue());
			//添加部门信息
			deptService.save(dept);
			
			return SUCCESS;
		}
	}
	
	/**
	 * 修改部门信息
	 * @return String
	 * @version 1.0
	 */
	public String updateDept(){
		//系统当前用户
		ScUsers user = (ScUsers)getSession().get("sysUser");
		//判断同部门下是否有同名部门信息
		//存在同名部门
		if(null != deptService.getDeptByDeptname(dept.getDeptName(),dept.getDeptId(),dept.getScDept().getDeptId())){
			//部门名称已经存在
			String error = String.valueOf(ParamConfigUtil.getServletContext().getAttribute("validform.scenter.dept.deptName.exsit"));
			addActionMessage(error);
			return ERROR;
		//不存在同名部门
		}else {
			String enableState = ((ParamConfigBean)StrutsUtil.getApplication().getAttribute("CONFIG_STATE")).getValueByCode("enable");
			//如果部门有下级，并且启用状态为禁用，则不允许修改
			
			if(!dept.getEnableState().equals(enableState)){
				ScDept scDept = deptService.get(dept.getDeptId());
				Set<ScDept> scDepts = scDept.getScDepts();
				Set<ScUsers> scUsers = scDept.getScUserses();
				if(null != scDepts && scDepts.size()>0){
					//此部门有下级部门，不允许禁用!
					String error = String.valueOf(ParamConfigUtil.getServletContext().getAttribute("validform.scenter.dept.modify.child.error"));
					addActionMessage(error);
					return ERROR;
				}
				if(null != scUsers && scUsers.size()>0){
					//此部门有用户，不允许禁用!
					String error = String.valueOf(ParamConfigUtil.getServletContext().getAttribute("validform.scenter.dept.modify.user.error"));
					addActionMessage(error);
					return ERROR;
				}
			}
			
			//修改人
			dept.setModifyUserName(user.getUserName());
			//修改日期
			dept.setModifyDate(new Date());
			deptService.clear();
			//跟心部门信息
			deptService.update(dept);
			
			//返回
			return SUCCESS;
			
		}
	}
	/**
	 * 启用状态设置为启用
	 * 
	 * @return
	 */
	public String enable() {
		String enableState = ((ParamConfigBean) StrutsUtil.getApplication().getAttribute("CONFIG_STATE")).getBeansByCode("enable").getValue();// 启用
		if (null == ids) {
			addActionMessage("请选择要操作的部门!");
			return ERROR;
		} else {
			int i = 0;
			int j = 0;
			for (String roleId : ids) {
				pro_result = deptService.updateDeptEnableState(roleId, enableState);
				if (pro_result != null && "1".equals(pro_result.get("msg"))) {
					i++;
				} else {
					j++;
				}
			}
			if (j != 0) {
				addActionMessage("信息不可被操作！请确认您是否属于该角色！");
				return ERROR;
			} else {
				addActionMessage(i + "条信息操作成功");
			}
			return SUCCESS;
		}
	}

	/**
	 * 启用状态设置为禁用
	 * 
	 * @return
	 */
	public String disable() {
		String enableState = ((ParamConfigBean) StrutsUtil.getApplication().getAttribute("CONFIG_STATE")).getBeansByCode("disable").getValue();// 启用
		if (id != null && !"".equals(id)) {
			pro_result = deptService.updateDeptEnableState(id, enableState);
			if (pro_result != null && "1".equals(pro_result.get("msg"))) {
				addActionMessage("操作完成！");
				return SUCCESS;
			} else if (pro_result != null && pro_result.get("info") != null && !"".equals(pro_result.get("info"))) {
				addActionMessage(pro_result.get("info").toString());
				return ERROR;
			} else {
				addActionMessage("操作失败！");
				return ERROR;
			}
		}
		if (null == ids) {
			addActionMessage("请选择要操作的角色!");
			return ERROR;
		} else {
			int i = 0;
			int j = 0;
			for (String deptId : ids) {
				boolean updateFlag=true;
				ScDept scDept = deptService.get(deptId);
				Set<ScDept> scDepts = scDept.getScDepts();
				Set<ScUsers> scUsers = scDept.getScUserses();
				if(null != scDepts && scDepts.size()>0){
					//此部门有下级部门，不允许禁用!
					updateFlag=false;
				}
				if(null != scUsers && scUsers.size()>0){
					//此部门有用户，不允许禁用!
					updateFlag=false;
				}
				if(updateFlag){
					pro_result = deptService.updateDeptEnableState(deptId, enableState);
					}
				
				if (pro_result != null && "1".equals(pro_result.get("msg"))) {
					i++;
				} else {
					j++;
				}
			}
			if (j != 0) {
				addActionMessage( "部分信息不可被操作！请确认所选部门无下级部门，并且所选部门无用户！");
				return ERROR;
			} else {
				addActionMessage(i + "条信息操作成功");
			}
			return SUCCESS;

		}
	}
	
	/**
	 * 跳转到部门信息修改页面
	 * @return String
	 * @version 1.0
	 */
	public String modify(){
		
		//根据部门id加载部门信息
		dept = deptService.load(dept.getDeptId());
		//部门信息
		list = deptService.findDept(dept);
		//list = this.orderDept(list);
		//是否启用
		bean = (ParamConfigBean)getApplication().getAttribute("CONFIG_STATE");
		
		//加载用户部门树
		supDeptListJson = deptService.getDeptListJson(null,dept);
		
		//跳转部门修改页面
		return "modify";
	}
	
	/**
	 * 跳转到部门信息审核页面
	 * @return String
	 * @version 1.0
	 */
	public String verify(){
		
		//根据部门id加载部门信息
		dept = deptService.load(dept.getDeptId());
		//部门信息
		list = deptService.findDept(dept);
		//是否启用
		bean = (ParamConfigBean)getApplication().getAttribute("CONFIG_STATE");
		//审核状态
		verify = (ParamConfigBean)getApplication().getAttribute("VERIFY_STATE");
		
		return "verify";
	}
	
	/**
	 * 跳转到部门信息审核页面
	 * @return String
	 * @version 1.0
	 */
	public String verifyDept(){
		
		//根据部门id加载部门信息
		ScDept scDept = deptService.load(dept.getDeptId());
		
		//如果部门有下级，并且启用状态为禁用，则不允许修改
		if(!dept.getVerifyState().equals("1")){
			Set<ScDept> scDepts = scDept.getScDepts();
			Set<ScUsers> scUsers = scDept.getScUserses();
			if(null != scDepts && scDepts.size()>0){
				//此部门有下级部门，不允许审核不通过!
				String error = String.valueOf(ParamConfigUtil.getServletContext().getAttribute("validform.scenter.dept.verify.child.error"));
				addActionMessage(error);
				return ERROR;
			}
			if(null != scUsers && scUsers.size()>0){
				//此部门有用户，不允许审核不通过!
				String error = String.valueOf(ParamConfigUtil.getServletContext().getAttribute("validform.scenter.dept.verify.user.error"));
				addActionMessage(error);
				return ERROR;
			}
		}
		
		//修改审核装填
		//scDept.setVerifyState(dept.getVerifyState());
		String verifyState = null;
		if ("1".equals(dept.getVerifyState())) {
			verifyState = ((ParamConfigBean) StrutsUtil.getApplication().getAttribute("VERIFY_STATE")).getBeansByCode("verifypass").getValue();// 审核通过
		} else if ("2".equals(dept.getVerifyState())) {
			verifyState = ((ParamConfigBean) StrutsUtil.getApplication().getAttribute("VERIFY_STATE")).getBeansByCode("verifyrefuse").getValue();// 审核不通过
		} else {
			verifyState = ((ParamConfigBean) StrutsUtil.getApplication().getAttribute("VERIFY_STATE")).getBeansByCode("submit").getValue();// 提交审核
		}
		scDept.setVerifyState(verifyState);
		scDept.setVerifyNote(dept.getVerifyNote());
		
		//更新部门信息
		deptService.update(scDept);
		
		return SUCCESS;
		
	}
	
	/**
	 * 跳转到部门信息详情页面
	 * @return String
	 * @version 1.0
	 */
	public String details(){
		
		//根据部门id加载部门信息
		dept = deptService.load(dept.getDeptId());
		//部门信息
		list = deptService.findDept(dept);
		//是否启用
		bean = (ParamConfigBean)getApplication().getAttribute("CONFIG_STATE");
		//审核状态
		verify = (ParamConfigBean)getApplication().getAttribute("VERIFY_STATE");
		
		return "details";
	}
	
	/**
	 * 删除部门信息
	 * @return String
	 * @version 1.0
	 */
	public String deleteDept(){
		
		//跳转页面
		//this.redirectUrl="/api/dept_list.action";
		//判断是否提交数据
		if(null == ids){
			//请选择要删除的数据!
			String error = String.valueOf(ParamConfigUtil.getServletContext().getAttribute("validform.scenter.dept.delete.data.error"));
			addActionMessage(error);
			return ERROR;
		}else {
			//deptService.delete(ids);  物理删除
			//逻辑删除，删除状态改为已删除
			
			int i = 0;
			int j = 0;
			String message = "";
			for(String id : ids){
				//根据部门id加载部门信息
				ScDept scDept = deptService.load(id);
				//设置删除状态
				//scDept.setDeleteState(((ParamConfigBean)getApplication().getAttribute("DEL_STATE")).getBeansByCode("disable").getValue());
				//更新部门信息
				//deptService.update(scDept);
				 Map<String, Object> pro_result  = deptService.updateDept(scDept);
				 if (pro_result != null && "1".equals(pro_result.get("msg"))) {
						i++;
					} else {
						j++;
						message += pro_result.get("msg").toString();
					}
			}
			if (j != 0) {
				addActionMessage(message + "不可被删除！");
				return ERROR;
			} else {
				return SUCCESS;
			}
		}
	}
	
	public ScDept getDept() {
		return dept;
	}

	public void setDept(ScDept dept) {
		this.dept = dept;
	}

	public List<ScDept> getList() {
		return list;
	}

	public void setList(List<ScDept> list) {
		this.list = list;
	}

	public ParamConfigBean getBean() {
		return bean;
	}

	public void setBean(ParamConfigBean bean) {
		this.bean = bean;
	}

	public ParamConfigBean getVerify() {
		return verify;
	}

	public void setDeptname(String deptname) {
		this.deptname = deptname;
	}

	public void setParentid(String parentid) {
		this.parentid = parentid;
	}

	public void setDeptId(String deptId) {
		this.deptId = deptId;
	}

	public String getDeptcode() {
		return deptcode;
	}

	public void setDeptcode(String deptcode) {
		this.deptcode = deptcode;
	}

	public String getSupDeptListJson() {
		return supDeptListJson;
	}

}
