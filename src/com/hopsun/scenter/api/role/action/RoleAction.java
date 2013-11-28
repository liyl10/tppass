/************************* 版权声明 *********************************
 *
 * Copyright (C) 2012 西安辉盛科技发展有限责任公司.
 *
 ******************************************************************
 */
package com.hopsun.scenter.api.role.action;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.hopsun.framework.base.action.BaseAction;
import com.hopsun.framework.base.bean.Pager;
import com.hopsun.framework.util.StrutsUtil;
import com.hopsun.scenter.api.role.service.RoleService;
import com.hopsun.scenter.entity.ScUsers;
import com.hopsun.subgroups.paramconfig.bean.ParamConfigBean;
import com.hopsun.subgroups.paramconfig.util.HcspResource;

/**
 * @comments 角色管理
 * @author yinxy
 * @date Dec 26, 2012
 * @version 1.0
 */
public class RoleAction extends BaseAction {
	private static final long serialVersionUID = 1L;
	/**
	 * 返回结果
	 */
	public Map<String, Object> pro_result = new HashMap<String, Object>();
	public String nodesvee; // 权限树
	public Map<String, Object> condition; // 查询条件
	public ParamConfigBean enable_state_config; // 启用禁用类型
	public ParamConfigBean verify_state_config; // 审核状态类型
	public ParamConfigBean delete_state_config; // 删除状态类型
	public ParamConfigBean auth_type_config; // 角色可见范围类型
	/**
	 * 审核状态的值
	 */
	public String verifypass = ((ParamConfigBean) StrutsUtil.getApplication().getAttribute("VERIFY_STATE")).getBeansByCode("verifypass").getValue(); // 审核通过
	public String verifyrefuse = ((ParamConfigBean) StrutsUtil.getApplication().getAttribute("VERIFY_STATE")).getBeansByCode("verifyrefuse").getValue(); // 审核不通过
	public String submit = ((ParamConfigBean) StrutsUtil.getApplication().getAttribute("VERIFY_STATE")).getBeansByCode("submit").getValue(); // 提交审核
	// 审核状态

	//
	// private int pageNo; //页码
	/**
	 * 添加角色的参数
	 */
	private String role_name; // 角色名称
	private String role_desc; // 角色描述
	private String role_type; // 角色类型
	private String enable_state; // 可用状态
	private String role_order; // 角色排序
	/**
	 * 操作的角色主键id
	 */
	private String role_id; // 角色id
	private String id; // 操作id
	/**
	 * 查询条件
	 */
	private String verify_state;
	//审核备注
	private String verify_note;

	@Resource
	private RoleService roleService;

	/**
	 * 查询角色列表(带分页)
	 * 
	 * @return
	 * @throws Exception
	 */
	public String list() {
		ScUsers user = (ScUsers) getSession().get("sysUser");
		if (user == null) {
			addActionMessage("请登录！");
			return ERROR;
		}
		// 启用类型
		enable_state_config = (ParamConfigBean) getApplication().getAttribute("CONFIG_STATE");
		// 审核状态类型
		verify_state_config = (ParamConfigBean) getApplication().getAttribute("VERIFY_STATE");
		// 删除状态
		delete_state_config = (ParamConfigBean) getApplication().getAttribute("DEL_STATE");
		// 角色可见类型
		auth_type_config = (ParamConfigBean) getApplication().getAttribute("ROLE_TYPE");
		condition = new HashMap<String, Object>(); // 页面查询条件，用于回显
		condition.put("verifyState", verify_state);
		condition.put("enableState", enable_state);
		condition.put("roleName", role_name);

		Map<String, Object> condition2 = new HashMap<String, Object>();// 搜索查询条件
		//若为超级管理员
		if(user.getScUsersesForParentUserId()==null&&"1".equals(user.getUserId())){
			condition2.put("is_sup_admin", "true");
		}
		if (null == pager) {
			setPager(new Pager());
		}
		if (verify_state != null && !"".equals(verify_state)) {
			String verifyState = null;
			if ("1".equals(verify_state)) {
				verifyState = ((ParamConfigBean) StrutsUtil.getApplication().getAttribute("VERIFY_STATE")).getBeansByCode("verifypass").getValue();// 审核通过
			} else if ("2".equals(verify_state)) {
				verifyState = ((ParamConfigBean) StrutsUtil.getApplication().getAttribute("VERIFY_STATE")).getBeansByCode("verifyrefuse").getValue();// 审核不通过
			} else {
				verifyState = ((ParamConfigBean) StrutsUtil.getApplication().getAttribute("VERIFY_STATE")).getBeansByCode("submit").getValue();// 提交审核
			}
			condition2.put("verifyState", verifyState);
		}
		if (enable_state != null && !"".equals(enable_state)) {
			String enableState = null;
			if ("1".equals(enable_state)) {
				enableState = ((ParamConfigBean) StrutsUtil.getApplication().getAttribute("CONFIG_STATE")).getBeansByCode("enable").getValue();// 启用
			} else {
				enableState = ((ParamConfigBean) StrutsUtil.getApplication().getAttribute("CONFIG_STATE")).getBeansByCode("disable").getValue();// 禁用

			}
			condition2.put("enableState", enableState);
		}
		if (role_name != null && !"".equals(role_name)) {
			condition2.put("roleName", role_name);
		}
		condition2.put("userId", user.getUserId());
		pager = roleService.find(condition2, pager.getPageNumber(), pager.getPageSize());
		return "list";
	}

	/**
	 * 跳转至添加页
	 * 
	 * @return
	 */
	public String goadd() {
		// 启用类型
		enable_state_config = (ParamConfigBean) getApplication().getAttribute("CONFIG_STATE");
		// 审核状态类型
		verify_state_config = (ParamConfigBean) getApplication().getAttribute("VERIFY_STATE");
		// 删除状态
		delete_state_config = (ParamConfigBean) getApplication().getAttribute("DEL_STATE");
		 
		return "insert";
	}

	/**
	 * 添加角色信息
	 * 
	 * @return
	 */
	public String insert() {
		ScUsers user = (ScUsers) getSession().get("sysUser");
		String roleId = null;
		String roleName = role_name;
		String roleDesc = role_desc;
		 
		String enableState = enable_state;
		String roleOrder = role_order;
		String verifyState = null;
		String deleteState = null;
		String createUserName = user.getUserName();
		String createDate = null;
		String modifyUserName = null;
		String modifyDate = null;
		String userId = user.getUserId();
		if (enableState == null || "".equals(enableState)) {
			enableState = ((ParamConfigBean) StrutsUtil.getApplication().getAttribute("CONFIG_STATE")).getBeansByCode("enable").getValue();// 启用
		}
 
		if (role_name == null || "".equals(role_name)) {
			addActionMessage("角色名称不能为空！");
			return ERROR;
		}
		if (roleDesc.length() > 255) {
			addActionMessage("角色描述不能超过200字！");
			return ERROR;
		}
		pro_result = roleService.saveRole(roleId, roleName, roleDesc,  enableState, verifyState, deleteState, roleOrder, createUserName, createDate, modifyUserName, modifyDate, userId);
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

	/**
	 * 查看角色信息
	 * 
	 * @return
	 */
	public String view() {
		// 启用类型
		enable_state_config = (ParamConfigBean) getApplication().getAttribute("CONFIG_STATE");
		// 审核状态类型
		verify_state_config = (ParamConfigBean) getApplication().getAttribute("VERIFY_STATE");
		// 删除状态
		delete_state_config = (ParamConfigBean) getApplication().getAttribute("DEL_STATE");
	 
		role_id = id;
		if (role_id == null || "".equals(role_id)) {
			addActionMessage("操作失败，角色信息不正确！!");
			return ERROR;
		}
		pro_result = roleService.queryRoleById(role_id);
		if (!"1".equals(pro_result.get("msg")) || pro_result.get("objinfo") == null) {
			addActionMessage("操作失败，角色信息不正确！!");
			return ERROR;
		}

		return "view";
	}

	/**
	 * 审核角色信息
	 * 
	 * @return
	 */
	public String verify() {
		// 启用类型
		enable_state_config = (ParamConfigBean) getApplication().getAttribute("CONFIG_STATE");
		// 审核状态类型
		verify_state_config = (ParamConfigBean) getApplication().getAttribute("VERIFY_STATE");
		// 删除状态
		delete_state_config = (ParamConfigBean) getApplication().getAttribute("DEL_STATE");
	 

		if (id != null && !"".equals(id)) {
			pro_result = roleService.queryRoleById(id);
			return "verify";
		}
		if (null == ids) {
			addActionMessage("请选择要操作的角色!");
			return ERROR;
		} else {
			pro_result = roleService.queryRoleById(ids[0]);
			return "verify";
		}
	}

	/**
	 * 保存审核状态
	 * 
	 * @return
	 */
	public String verifysave() {
		String roleId = role_id;
		String verifyNote=verify_note;
		String verifyState = null;
		ScUsers user = (ScUsers) getSession().get("sysUser");
		String userId = user.getUserId();
		String userName=user.getUserName();
		if ("1".equals(verify_state)) {
			verifyState = ((ParamConfigBean) StrutsUtil.getApplication().getAttribute("VERIFY_STATE")).getBeansByCode("verifypass").getValue();// 审核通过
		} else if ("2".equals(verify_state)) {
			verifyState = ((ParamConfigBean) StrutsUtil.getApplication().getAttribute("VERIFY_STATE")).getBeansByCode("verifyrefuse").getValue();// 审核不通过
		} else {
			verifyState = ((ParamConfigBean) StrutsUtil.getApplication().getAttribute("VERIFY_STATE")).getBeansByCode("submit").getValue();// 提交审核
		}

		if (roleId != null && !"".equals(roleId)) {
			pro_result = roleService.updateVerifyState(userName,roleId, verifyState,verifyNote, userId);
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
		addActionMessage("角色信息不正确!");
		return ERROR;
	}

	/**
	 * 跳转至角色修改页
	 * 
	 * @return
	 */
	public String gomodify() {
		// 启用类型
		enable_state_config = (ParamConfigBean) getApplication().getAttribute("CONFIG_STATE");
		// 审核状态类型
		verify_state_config = (ParamConfigBean) getApplication().getAttribute("VERIFY_STATE");
		// 删除状态
		delete_state_config = (ParamConfigBean) getApplication().getAttribute("DEL_STATE");
		// 角色可见类型
		auth_type_config = (ParamConfigBean) getApplication().getAttribute("ROLE_TYPE");
		role_id = id;
		if (role_id == null || "".equals(role_id)) {
			addActionMessage("操作失败，角色信息不正确！");
			return ERROR;
		}
		pro_result = roleService.queryRoleById(role_id);
		if (!"1".equals(pro_result.get("msg")) || pro_result.get("objinfo") == null) {
			addActionMessage("操作失败，角色信息不正确！");
			return ERROR;
		}
		return "modify";
	}

	/**
	 * 修改保存
	 * 
	 * @return
	 */
	public String save() {
		ScUsers user = (ScUsers) getSession().get("sysUser");
		String roleId = role_id;
		String roleName = role_name;
		String roleDesc = role_desc;
		 
		String enableState = enable_state;
		String roleOrder = role_order;
		String verifyState = null;
		String deleteState = null;
		String createUserName = null;
		String createDate = null;
		String modifyUserName = user.getUserName();
		String modifyDate = null;
		if (role_id == null || "".equals(role_id)) {
			addActionMessage("操作失败，角色信息不正确！");
			return ERROR;
		}
		if (role_name == null || "".equals(role_name)) {
			addActionMessage("操作失败，角色名称不能为空！");
			return ERROR;
		}
		if (roleDesc.length() > 255) {
			addActionMessage("操作失败，角色描述不能超过200字！");
			return ERROR;
		}
		pro_result = roleService.updateRole(roleId, roleName, roleDesc,  enableState, verifyState, deleteState, roleOrder, createUserName, createDate, modifyUserName, modifyDate);
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

	/**
	 * 删除
	 * 
	 * @return
	 */
	public String delete() {
		ScUsers user = (ScUsers) getSession().get("sysUser");
		String userId = user.getUserId();
		if (id != null && !"".equals(id)) {
			pro_result = roleService.deleteRole(id, userId);
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
			addActionMessage("请选择要删除的角色!");
			return ERROR;
		} else {
			int i = 0;
			int j = 0;
			for (String roleId : ids) {
				pro_result = roleService.deleteRole(roleId, userId);
				if (pro_result != null && "1".equals(pro_result.get("msg"))) {
					i++;
				} else {
					j++;
				}
			}
			if (j != 0) {
				addActionMessage("信息不可被删除！请确认您是否属于该角色！");
				return ERROR;
			} else {
				addActionMessage(i + "条信息删除成功");
			}
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
		if (id != null && !"".equals(id)) {
			pro_result = roleService.updateRoleEnableState(id, enableState);
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
			for (String roleId : ids) {
				pro_result = roleService.updateRoleEnableState(roleId, enableState);
				if (pro_result != null && "1".equals(pro_result.get("msg"))) {
					i++;
				} else {
					j++;
				}
			}
			if (j != 0) {
				addActionMessage("部分信息不可被操作！请确认您不属于所选角色！");
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
		ScUsers user = (ScUsers) getSession().get("sysUser");
		String userId = user.getUserId();
		String enableState = ((ParamConfigBean) StrutsUtil.getApplication().getAttribute("CONFIG_STATE")).getBeansByCode("disable").getValue();// 启用
		if (id != null && !"".equals(id)) {
			pro_result = roleService.updateRoleEnableState(id, enableState, userId);
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
			for (String roleId : ids) {
				pro_result = roleService.updateRoleEnableState(roleId, enableState, userId);
				if (pro_result != null && "1".equals(pro_result.get("msg"))) {
					i++;
				} else {
					j++;
				}
			}
			if (j != 0) {
				addActionMessage( "部分信息不可被操作！请确认您是不属于所选角色！");
				return ERROR;
			} else {
				addActionMessage(i + "条信息操作成功");
			}
			return SUCCESS;

		}
	}

	/**
	 * 跳转至角色权限查看页
	 * 
	 * @return
	 */
	public String viewauth() {
		//ScUsers user = (ScUsers) getSession().get("sysUser");
		//String userId = user.getUserId();
		String roleId = id;
		if (roleId != null && !"".equals(roleId)) {
			pro_result = (HashMap<String, Object>) roleService.goViewAuthor(roleId);
		}
		if (null == ids) {
			addActionMessage("请选择角色!");
			return ERROR;
		} else {
			if (ids.length == 1) {
				pro_result = roleService.goViewAuthor(ids[0]);
			} else {
				addActionMessage("请选择一个角色!");
				return ERROR;
			}
		}
		if (pro_result == null || pro_result.get("nodesvee") == null || pro_result.get("objinfo") == null) {
			if (pro_result.get("info") != null) {
				addActionMessage(pro_result.get("info").toString());
			} else {
				addActionMessage("角色信息有误!");
			}
			return ERROR;
		}
		nodesvee = pro_result.get("nodesvee").toString();
		return "viewauth";
	}

	/**
	 * 角色授权
	 * 
	 * @return
	 */
	public String authorize() {
		ScUsers user = (ScUsers) getSession().get("sysUser");
		String userId = user.getUserId();
		String roleId = id;
		if (roleId != null && !"".equals(roleId)) {
			pro_result = (HashMap<String, Object>) roleService.goAuthor(roleId,userId);
		}
		if (null == ids) {
			addActionMessage("请选择角色!");
			return ERROR;
		} else {
			if (ids.length == 1) {
				pro_result = roleService.goAuthor(ids[0],userId);
			} else {
				addActionMessage("请选择一个角色!");
				return ERROR;
			}
		}
		if (pro_result == null || pro_result.get("nodesvee") == null || pro_result.get("objinfo") == null) {
			if (pro_result.get("info") != null) {
				addActionMessage(pro_result.get("info").toString());
			} else {
				addActionMessage("角色信息有误!");
			}
			return ERROR;
		}
		nodesvee = pro_result.get("nodesvee").toString();
		return "authorize";
	}

	/**
	 * 授权保存
	 * 
	 * @return
	 */
	public String authsave() {
		String roleId = role_id;
		if (roleId == null || "".equals(roleId)) {
			addActionMessage("角色信息不正确!");
			return ERROR;
		}
		pro_result = roleService.updateRoleAuthMap(roleId, ids);

		addActionMessage("操作完成!");
		return SUCCESS;
	}
	/**
	 * 检测角色名称是否可用
	 * @return
	 */
	public String ajaxCheckName(){
		HttpServletResponse response = null;
		response = ServletActionContext.getResponse();
		boolean isExistName=false;
		if(role_name!=null&&!"".equals(role_name)){
			isExistName=roleService.isExistName(role_name, role_id);
		}
		try {
			response.setContentType("text/html; charset=UTF-8");
			response.setHeader("Pragma", "No-cache");
			response.setHeader("Cache-Control", "no-cache");
			response.setDateHeader("Expires", 0);
			if (!isExistName) {
				response.getWriter().write("{\"status\":\"y\"}");
			}else{
				response.getWriter().write("{\"info\":"+HcspResource.VALID_SCENTER_ROLE_ROLENAME_EXSIT+",\"status\":\"n\"}");
			}
			response.getWriter().flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "ajaxresult";
	}
	
	public String getRole_name() {
		return role_name;
	}

	public void setRole_name(String role_name) {
		this.role_name = role_name;
	}

	public String getRole_desc() {
		return role_desc;
	}

	public void setRole_desc(String role_desc) {
		this.role_desc = role_desc;
	}

	public String getRole_type() {
		return role_type;
	}

	public void setRole_type(String role_type) {
		this.role_type = role_type;
	}

	public String getEnable_state() {
		return enable_state;
	}

	public void setEnable_state(String enable_state) {
		this.enable_state = enable_state;
	}

	public String getRole_order() {
		return role_order;
	}

	public void setRole_order(String role_order) {
		this.role_order = role_order;
	}

	public String getRole_id() {
		return role_id;
	}

	public void setRole_id(String role_id) {
		this.role_id = role_id;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public ParamConfigBean getAuth_type_config() {
		return auth_type_config;
	}

	public void setAuth_type_config(ParamConfigBean auth_type_config) {
		this.auth_type_config = auth_type_config;
	}

	public String getVerify_state() {
		return verify_state;
	}

	public void setVerify_state(String verify_state) {
		this.verify_state = verify_state;
	}

	public String getVerify_note() {
		return verify_note;
	}

	public void setVerify_note(String verify_note) {
		this.verify_note = verify_note;
	}

}
