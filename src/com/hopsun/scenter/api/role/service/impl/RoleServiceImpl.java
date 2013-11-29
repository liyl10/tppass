/************************* 版权声明 *********************************
 *
 * Copyright (C) 2012 西安辉盛科技发展有限责任公司.
 *
 ******************************************************************
 */
package com.hopsun.scenter.api.role.service.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.hopsun.framework.base.bean.Pager;
import com.hopsun.framework.base.service.impl.BaseServiceImpl;
import com.hopsun.framework.util.StrutsUtil;
import com.hopsun.scenter.api.auth.dao.AuthDao;
import com.hopsun.scenter.api.role.dao.RoleDao;
import com.hopsun.scenter.api.role.service.RoleService;
import com.hopsun.scenter.api.user.dao.UserDao;
import com.hopsun.scenter.entity.ScAuth;
import com.hopsun.scenter.entity.ScRole;
import com.hopsun.scenter.entity.ScUsers;
import com.hopsun.subgroups.paramconfig.bean.ParamConfigBean;

/**
 * @comments 角色服务接口实现
 * @author yinxy
 * @date Dec 26, 2012
 * @version 1.0
 */
@Service
public class RoleServiceImpl extends BaseServiceImpl<ScRole, String> implements RoleService {

	@Resource
	private RoleDao roleDao;
	@Resource
	private AuthDao authDao;
	@Resource
	private UserDao userDao;

	@Resource
	public void setBaseDao(RoleDao roleDao) {
		super.setBaseDao(roleDao);
	}

	/**
	 * 添加角色
	 * 
	 * @param roleId
	 * @param roleName
	 * @param roleDesc
	 * @param enableState
	 * @param verifyState
	 * @param deleteState
	 * @param roleOrder
	 * @param createUserName
	 * @param createDate
	 * @param modifyUserName
	 * @param modifyDate
	 * @return
	 */
	public Map<String, Object> saveRole(String roleId, String roleName, String roleDesc, String enableState, String verifyState, String deleteState, String roleOrder, String createUserName, String createDate, String modifyUserName, String modifyDate, String userId) {
		Map<String, Object> result = new HashMap<String, Object>();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Long newRoleOrder = Long.parseLong("1");
		Date newCreateDate = new Date();
		String newDeleteState = ((ParamConfigBean) StrutsUtil.getApplication().getAttribute("DEL_STATE")).getBeansByCode("enable").getValue(); // 未删除
		String newEnableState = ((ParamConfigBean) StrutsUtil.getApplication().getAttribute("CONFIG_STATE")).getBeansByCode("enable").getValue();// 启用
		String newVerifyState = ((ParamConfigBean) StrutsUtil.getApplication().getAttribute("VERIFY_STATE")).getBeansByCode("submit").getValue();// 提交审核
		result.put("msg", "0");
		if (userId == null || "".equals(userId)) {
			return result;
		}
		// 获取所属用户
		ScUsers scUser = userDao.get(userId);
		if (scUser == null) {
			return result;
		}
		// 排序字符转为Long
		if (roleOrder != null && !("").equals(roleOrder)) {
			newRoleOrder = Long.parseLong(roleOrder);
		}
		// 创建日期转为Date型
		if (createDate != null && !("").equals(createDate)) {
			try {
				newCreateDate = sdf.parse(createDate);
			} catch (ParseException e) {
				return result;
			}
		}
		if (deleteState != null && !"".equals(deleteState)) {
			newDeleteState = deleteState;
		}
		if (enableState != null && !"".equals(enableState)) {
			newEnableState = enableState;
		}
		if (verifyState != null && !"".equals(verifyState)) {
			newVerifyState = verifyState;
		}

		// 判断角色名称是否重复
		Map<String, Object> condition = new HashMap<String, Object>();
		condition.put("enableState", ((ParamConfigBean) StrutsUtil.getApplication().getAttribute("CONFIG_STATE")).getValueByCode("enable"));
		condition.put("roleName", roleName);
		List<ScRole> list_query_role = (List<ScRole>) roleDao.queryRoleList(condition);
		if (list_query_role != null && list_query_role.size() > 0) {
			result.put("info", "角色名称已经存在，操作失败！");
			result.put("msg", "0");
			return result;
		}
		ScRole scRole = new ScRole();
		scRole.setRoleName(roleName);
		scRole.setRoleDesc(roleDesc);

		scRole.setRoleOrder(newRoleOrder);
		scRole.setDeleteState(newDeleteState);
		scRole.setVerifyState(newVerifyState);
		scRole.setEnableState(newEnableState);
		scRole.setCreateDate(newCreateDate);
		scRole.setCreateUserName(createUserName);
		scRole.setScUsers(scUser);
		roleDao.save(scRole);
		result.put("msg", "1");
		return result;
	}

	/**
	 * 获取角色列表
	 * 
	 * @return
	 */
	public Map<String, Object> getRoleList() {
		Map<String, Object> result = new HashMap<String, Object>();
		List<ScRole> roleList = roleDao.getRoleList();
		result.put("roleList", roleList);
		return result;
	}

	/**
	 * 根据条件分页查询角色 用户可以看到自己创建的角色及下级用户创建的角色 超级管理员可以看到所有用户创建的角色
	 * 
	 * @param condition
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */

	public Pager find(Map<String, Object> condition, int pageNo, int pageSize) {
		// 操作者
		ScUsers user;
		if (condition != null && condition.get("userId") != null && !"".equals(condition.get("userId"))) {
			// 获取自己的用户信息
			user = userDao.get(condition.get("userId").toString());
			if (user == null) {
				return null;
			}
		} else {
			return null;
		}

		// 存放自己及所有下级用户
		Set<ScUsers> user_available_childSet = new HashSet<ScUsers>();
		// 可管理的用户包含自己
		user_available_childSet.add(user);
		// 获取自己的下级
		getChildUser(user, user_available_childSet);
		//
		if (user_available_childSet != null && user_available_childSet.size() > 0) {
			StringBuffer childStr = new StringBuffer(""); // 存放所有节点数据
			for (ScUsers puser : user_available_childSet) {
				childStr.append("'" + puser.getUserId() + "',");
			}
			childStr.deleteCharAt(childStr.length() - 1); // 删除最后一个多余的逗号。
			condition.put("childSet", childStr.toString());
		}

		return roleDao.queryRoleListWithSql(condition, pageNo, pageSize);
	}

	/**
	 * 递归获取用户的所有下级用户
	 * 
	 * @return
	 */
	public void getChildUser(ScUsers user, Set<ScUsers> user_available_childSet) {
		if (user != null) {
			// 获取自己的下级
			Set<ScUsers> childSet = user.getScUsersesForChildUserId();
			if (childSet != null) {
				for (ScUsers perUser : childSet) {
					// 判断不重复包含
					if (!user_available_childSet.contains(perUser)) {
						// 下级删除状态为未删除
						if (perUser.getDeleteState().equals(((ParamConfigBean) StrutsUtil.getApplication().getAttribute("DEL_STATE")).getBeansByCode("enable").getValue())) {
							user_available_childSet.add(perUser);
							getChildUser(perUser, user_available_childSet);
						}
					}
				}
			}
		}
		return;
	}

	/**
	 * 根据id查询角色信息
	 * 
	 * @param roleId
	 * @return
	 */
	public Map<String, Object> queryRoleById(String roleId) {
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("msg", "0");
		if (roleId == null || "".equals(roleId)) {
			return result;
		}
		// 获取实体
		ScRole scRole = roleDao.get(roleId);
		if (scRole != null) {
			result.put("objinfo", scRole);
			result.put("msg", "1");
		}
		return result;
	}

	/**
	 * 更新角色
	 * 
	 * @param roleId
	 * @param roleName
	 * @param roleDesc
	 * @param enableState
	 * @param verifyState
	 * @param deleteState
	 * @param roleOrder
	 * @param createUserName
	 * @param createDate
	 * @param modifyUserName
	 * @param modifyDate
	 * @return
	 */
	public Map<String, Object> updateRole(String roleId, String roleName, String roleDesc, String enableState, String verifyState, String deleteState, String roleOrder, String createUserName, String createDate, String modifyUserName, String modifyDate) {
		Map<String, Object> result = new HashMap<String, Object>();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Long newRoleOrder = Long.parseLong("1");
		Date newModifyDate = new Date();
		// String newDeleteState = ((ParamConfigBean)
		// StrutsUtil.getApplication().getAttribute("DEL_STATE")).getBeansByCode("enable").getValue();
		// // 未删除
		String newEnableState = ((ParamConfigBean) StrutsUtil.getApplication().getAttribute("CONFIG_STATE")).getBeansByCode("enable").getValue();// 启用
		// String newVerifyState = ((ParamConfigBean)
		// StrutsUtil.getApplication().getAttribute("VERIFY_STATE")).getBeansByCode("submit").getValue();//
		// 提交审核
		result.put("msg", "0");
		if (roleId == null || "".equals(roleId)) {
			return result;
		}
		// 排序字符转为Long
		if (roleOrder != null && !("").equals(roleOrder)) {
			newRoleOrder = Long.parseLong(roleOrder);
		}
		// 创建日期转为Date型
		if (modifyDate != null && !("").equals(modifyDate)) {
			try {
				newModifyDate = sdf.parse(modifyDate);
			} catch (ParseException e) {
				return result;
			}
		}
		// if (deleteState != null && !"".equals(deleteState)) {
		// newDeleteState = deleteState;
		// }
		if (enableState != null && !"".equals(enableState)) {
			newEnableState = enableState;
		}
		// if (verifyState != null && !"".equals(verifyState)) {
		// newVerifyState = verifyState;
		// }
		ScRole scRole = roleDao.get(roleId);
		if (scRole != null) {
			// 判断角色名称是否重复
			Map<String, Object> condition = new HashMap<String, Object>();
			condition.put("enableState", ((ParamConfigBean) StrutsUtil.getApplication().getAttribute("CONFIG_STATE")).getValueByCode("enable"));
			condition.put("roleName", roleName);
			List<ScRole> list_query_role = roleDao.queryRoleList(condition);
			if (list_query_role != null && list_query_role.size() > 1) {
				result.put("info", "角色名称已经存在，操作失败！");
				result.put("msg", "0");
				return result;
			} else if (list_query_role != null && list_query_role.size() == 1) {
				ScRole scRole_select = (ScRole) list_query_role.get(0);
				if (!roleId.equals(scRole_select.getRoleId())) {
					result.put("info", "角色名称已经存在，操作失败！");
					result.put("msg", "0");
					return result;
				}
			}
			//
			scRole.setRoleName(roleName);
			scRole.setRoleDesc(roleDesc);
			scRole.setRoleOrder(newRoleOrder);
			scRole.setEnableState(newEnableState);
			scRole.setModifyDate(newModifyDate);
			scRole.setModifyUserName(modifyUserName);
			roleDao.update(scRole);
			result.put("msg", "1");
		}
		return result;
	}

	/**
	 * 删除一个角色。并且用户自己不在这个角色中
	 * 
	 * @param roleId
	 * @param userId
	 * @return
	 */
	public Map<String, Object> deleteRole(String roleId) {
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("msg", "0");
		if (roleId == null || "".equals(roleId)) {
			return result;
		}
		// 获取实体
		ScRole scRole = roleDao.get(roleId);
		if (scRole != null) {
			scRole.setDeleteState(((ParamConfigBean) StrutsUtil.getApplication().getAttribute("DEL_STATE")).getBeansByCode("disable").getValue());
			roleDao.update(scRole);
			result.put("info", "[{'info':'true'}]");
			result.put("msg", "1");
		}
		return result;
	}

	/**
	 * 跳转至角色权限分配页
	 * 
	 * @param roleId
	 * @return
	 */

	public Map<String, Object> goAuthor(String roleId, String userId) {
		boolean isSuperAdmin = false;
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("msg", "0");
		if (roleId == null || "".equals(roleId)) {
			return result;
		}
		if (userId == null || "".equals(userId)) {
			return result;
		}
		ScUsers scUser = userDao.get(userId);
		if (scUser == null) {
			return result;
		} else if (scUser.getScUsersesForParentUserId() == null || scUser.getScUsersesForParentUserId().size() < 1) {
			// 若无上级管理员则为超级管理员
			isSuperAdmin = true;
		}
		if (roleId == null || "".equals(roleId)) {
			return result;
		}
		ScRole scRole = roleDao.get(roleId);
		// 获取角色实体
		if (scRole != null) {
			// 获取角色已有的权限
			Set<ScAuth> roleAuthSet = scRole.getScAuths();

			// 获取所有权限列表
			Map<String, Object> condition = new HashMap<String, Object>();
			condition.put("enableState", ((ParamConfigBean) StrutsUtil.getApplication().getAttribute("CONFIG_STATE")).getBeansByCode("enable").getValue());
			List<ScAuth> authDataList = (List<ScAuth>) authDao.queryAllAuth();

			// 获取用户可用的权限
			Set<ScAuth> availableAuth = getUserAuth(scUser);

			// 对比所有权限及角色的权限，输出json格式字符串
			String nodesvee = null;
			if (authDataList != null && authDataList.size() > 0) {
				// 遍历查询出来的子节点
				StringBuffer strres = new StringBuffer(""); // 存放所有节点数据
				String checked = "false"; // 是否选中的标志。
				// String authid = null;
				String parentid = "";
				String open = "true"; // 是否展开标志
				String expand = "true";// 是否禁止展开标志
				String nocheck = "false";// 是否显示checkbox / radio，false为正常显示
				strres.append("[");

				int i = 0;
				for (ScAuth authDataA : authDataList) {
					// 若该权限可用，则设为可选
					if (isSuperAdmin) {
						nocheck = "false";
					} else {
						if (availableAuth.contains(authDataA)) {
							nocheck = "false";
						} else {
							nocheck = "true";
						}
					}
					expand = "true";
					// authid = authDataA.getAuthId();
					if (authDataA.getScAuth() != null && authDataA.getScAuth().getAuthId() != null) {
						parentid = authDataA.getScAuth().getAuthId();
					} else {
						parentid = "";
					}
					if (roleAuthSet.contains(authDataA)) {
						checked = "true";
					} else {
						checked = "false";
					}
					if (authDataA.getScAuth() == null) {
						open = "true";
						i++;
					} else {
						open = "false";
						i++;
					}
					if (authDataA.getEnableState().equals(((ParamConfigBean) StrutsUtil.getApplication().getAttribute("CONFIG_STATE")).getBeansByCode("disable").getValue())) {
						expand = "false"; // 禁止展开
						open = "false";
						nocheck = "true";
					}
					;
					strres.append("{id:'" + authDataA.getAuthId() + "',pId:'" + parentid + "',name:'" + authDataA.getAuthName().toString().replaceAll("\'", "\\\\'") + "',expand:" + expand + ",open:" + open + ",nocheck:" + nocheck + ",checked:" + checked + "},");
				}
				strres.deleteCharAt(strres.length() - 1); // 删除最后一个多余的逗号。
				strres.append("]");

				nodesvee = strres.toString();
			} else {
				nodesvee = null;
			}
			result.put("msg", "1");
			result.put("nodesvee", nodesvee);
			result.put("objinfo", scRole);

		}

		return result;
	}

	/**
	 * 获取用户的所有权限
	 * 
	 * @param user
	 * @return
	 */
	public Set<ScAuth> getUserAuth(ScUsers user) {
		Set<ScAuth> availableAuth = new HashSet<ScAuth>();
		// 普通用户则根据角色查询所有的权限
		Set<ScRole> roles = user.getScRoles();
		if (roles != null && roles.size() > 0) {
			for (ScRole rolePer : roles) {
				Set<ScAuth> authSet = rolePer.getScAuths();
				if (authSet != null && authSet.size() > 0) {
					for (ScAuth authPer : authSet) {
						if (!availableAuth.contains(authPer)) {
							availableAuth.add(authPer);
						}
					}
				}
			}
		}
		return availableAuth;
	}

	/**
	 * 跳转至角色权限查看页
	 * 
	 * @param roleId
	 * @return
	 */

	public Map<String, Object> goViewAuthor(String roleId) {
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("msg", "0");
		if (roleId == null || "".equals(roleId)) {
			return result;
		}
		ScRole scRole = roleDao.get(roleId);
		// 获取角色实体
		if (scRole != null) {
			// 获取角色已有的权限
			Set<ScAuth> roleAuthSet = scRole.getScAuths();

			// 获取所有权限列表
			// List<ScAuth> authDataList = (List<ScAuth>)
			// authDao.queryAllAuth();
			// 对比所有权限及角色的权限，输出json格式字符串
			String nodesvee = null;
			if (roleAuthSet != null && roleAuthSet.size() > 0) {
				// 遍历查询出来的子节点
				StringBuffer strres = new StringBuffer(""); // 存放所有节点数据
				String checked = "false"; // 是否选中的标志。
				// String authid = null;
				String parentid = "";
				String open = "true"; // 是否展开标志
				strres.append("[");
				int i = 0;
				for (ScAuth authDataA : roleAuthSet) {
					// authid = authDataA.getAuthId();
					if (authDataA.getScAuth() != null && authDataA.getScAuth().getAuthId() != null) {
						parentid = authDataA.getScAuth().getAuthId();
					} else {
						parentid = "";
					}

					if (authDataA.getScAuth() == null) {
						open = "true";
						i++;
					} else {
						open = "false";
						i++;
					}
					strres.append("{id:'" + authDataA.getAuthId() + "',pId:'" + parentid + "',name:'" + authDataA.getAuthName().toString().replaceAll("\'", "\\\\'") + "',open:" + open + ",checked:" + checked + "},");
				}
				strres.deleteCharAt(strres.length() - 1); // 删除最后一个多余的逗号。
				strres.append("]");

				nodesvee = strres.toString();
			} else {
				result.put("msg", "0");
				result.put("info", "该角色无授权信息！");
				result.put("objinfo", scRole);
				result.put("nodesvee", null);
				return result;
			}
			result.put("msg", "1");
			result.put("nodesvee", nodesvee);
			result.put("objinfo", scRole);

		}

		return result;
	}

	/**
	 * 更新角色的权限信息
	 * 
	 * @param roleId
	 * @return
	 */
	public Map<String, Object> updateRoleAuthMap(String roleId, String[] authIds) {
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("msg", "0");
		if (roleId == null || "".equals(roleId)) {
			return result;
		}
		ScRole scRole = roleDao.get(roleId);
		// 获取角色实体
		if (scRole != null) {
			Set<ScAuth> roleAuthSet = new HashSet<ScAuth>();
			if (authIds != null) {
				for (String id : authIds) {
					roleAuthSet.add(authDao.get(id));
				}
			}
			// 更新角色的权限信息
			scRole.setScAuths(roleAuthSet);
			roleDao.update(scRole);
		}
		result.put("msg", "1");
		return result;
	}

	/**
	 * 根据条件查询角色列表
	 */
	public Map<String, Object> queryRoleList(Map<String, Object> condition) {
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("msg", "0");
		List<ScRole> roleList = new ArrayList<ScRole>();

		roleList = roleDao.queryRoleList(condition);

		result.put("roleList", roleList);
		result.put("msg", "1");
		return result;
	}

	/**
	 * 更新审核状态
	 * 
	 * @param roleId
	 * @param verifyState
	 * @return
	 */
	public Map<String, Object> updateVerifyState(String userName, String roleId, String verifyState) {
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("msg", "0");
		if (roleId == null || "".equals(roleId)) {
			return result;
		}
		// 设置审核状态
		if (verifyState == null || "".equals(verifyState)) {
			verifyState = ((ParamConfigBean) StrutsUtil.getApplication().getAttribute("VERIFY_STATE")).getBeansByCode("submit").getValue();// 提交审核
		}
		ScRole scRole = roleDao.get(roleId);
		// 获取角色实体
		if (scRole != null) {
			scRole.setVerifyState(verifyState);
			scRole.setVerifyUserName(userName);
			scRole.setVerifyDate(new Date());
			roleDao.update(scRole);
			result.put("msg", "1");
		}
		return result;
	}

	/**
	 * 根据roleid数组，返回role的set集合
	 * 
	 * @param roleIds
	 * @return
	 */
	public Set<ScRole> getRoleSetById(String[] roleIds) {
		Set<ScRole> roleSet = new HashSet<ScRole>();
		if (roleIds != null) {
			for (String id : roleIds) {
				roleSet.add(roleDao.get(id));
			}
		}
		return roleSet;
	}

	/**
	 * 更改启用状态
	 * 
	 * @return
	 */
	public Map<String, Object> updateRoleEnableState(String roleId, String enableState) {
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("msg", "0");
		if (roleId == null || "".equals(roleId)) {
			return result;
		}
		// 获取实体
		ScRole scRole = roleDao.get(roleId);
		if (scRole != null) {
			scRole.setEnableState(enableState);
			roleDao.update(scRole);
			result.put("info", "[{'info':'true'}]");
			result.put("msg", "1");
		}
		return result;
	}

	/**
	 * 删除一个角色。并且用户自己不在这个角色中
	 * 
	 * @param roleId
	 * @param userId
	 * @return
	 */
	public Map<String, Object> deleteRole(String roleId, String userId) {
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("msg", "0");
		if (roleId == null || "".equals(roleId)) {
			result.put("info", "操作失败,角色信息不正确！");
			return result;
		}
		if (userId == null || "".equals(userId)) {
			result.put("info", "操作失败,用户信息不正确！");
			return result;
		}
		// 获取用户信息
		Set<ScRole> userRoles = new HashSet<ScRole>();
		ScUsers user = userDao.get(userId);
		if (user != null) {
			userRoles = user.getScRoles();
		}
		// 获取角色实体
		ScRole scRole = roleDao.get(roleId);
		if (scRole != null) {
			if (userRoles.contains(scRole)) {
				result.put("info", "您属于该角色，不能删除！");
				result.put("msg", "0");
				return result;
			} else {
				scRole.setDeleteState(((ParamConfigBean) StrutsUtil.getApplication().getAttribute("DEL_STATE")).getBeansByCode("disable").getValue());
				roleDao.update(scRole);
				// result.put("info", "[{'info':'true'}]");
				result.put("msg", "1");
				return result;
			}

		}
		return result;

	}

	/**
	 * 更改启用状态
	 * 
	 * @return
	 */
	public Map<String, Object> updateRoleEnableState(String roleId, String enableState, String userId) {
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("msg", "0");
		if (roleId == null || "".equals(roleId)) {
			return result;
		}
		if (userId == null || "".equals(userId)) {
			result.put("info", "操作失败,用户信息不正确！");
			return result;
		}
		// 获取用户信息
		Set<ScRole> userRoles = new HashSet<ScRole>();
		ScUsers user = userDao.get(userId);
		if (user != null) {
			userRoles = user.getScRoles();
		}
		// 获取实体
		ScRole scRole = roleDao.get(roleId);
		if (scRole != null) {
			if (userRoles.contains(scRole)) {
				result.put("info", "您属于该角色，不能修改该角色启用状态！");
				result.put("msg", "0");
				return result;
			}
			scRole.setEnableState(enableState);
			roleDao.update(scRole);
			// result.put("info", "[{'info':'true'}]");
			result.put("msg", "1");
		}
		return result;
	}

	/**
	 * 更改审核状态
	 * 
	 * @return
	 */
	public Map<String, Object> updateVerifyState(String userName, String roleId, String verifyState, String verifyNote, String userId) {
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("msg", "0");
		if (roleId == null || "".equals(roleId)) {
			return result;
		}
		// 设置审核状态
		if (verifyState == null || "".equals(verifyState)) {
			verifyState = ((ParamConfigBean) StrutsUtil.getApplication().getAttribute("VERIFY_STATE")).getBeansByCode("submit").getValue();// 提交审核
		}
		if (userId == null || "".equals(userId)) {
			result.put("info", "操作失败,用户信息不正确！");
			return result;
		}
		// 获取用户信息
		Set<ScRole> userRoles = new HashSet<ScRole>();
		ScUsers user = userDao.get(userId);
		if (user != null) {
			userRoles = user.getScRoles();
		}
		ScRole scRole = roleDao.get(roleId);
		// 获取角色实体
		if (scRole != null) {
			if (userRoles.contains(scRole)) {
				result.put("info", "您属于该角色，不能修改该角色审核状态！");
				result.put("msg", "0");
				return result;
			}
			scRole.setVerifyState(verifyState);
			scRole.setVerifyNote(verifyNote);
			scRole.setVerifyUserName(userName);
			scRole.setVerifyDate(new Date());
			roleDao.update(scRole);
			roleDao.update(scRole);
			result.put("msg", "1");
		}
		return result;
	}

	/**
	 * 判断角色名称是否重复
	 * 
	 * @return
	 */
	public boolean isExistName(String roleName, String roleId) {
		boolean isExist = false;
		// 判断角色名称是否重复
		if (roleId != null && !"".equals(roleId)) {
			//roleId不为空，则为修改
			ScRole scRole = roleDao.get(roleId);
			if (scRole != null) {
				Map<String, Object> condition = new HashMap<String, Object>();
				condition.put("enableState", ((ParamConfigBean) StrutsUtil.getApplication().getAttribute("CONFIG_STATE")).getValueByCode("enable"));
				condition.put("roleName", roleName);
				List<ScRole> list_query_role = roleDao.queryRoleList(condition);
				if (list_query_role != null && list_query_role.size() > 1) {
					isExist = true;
				} else if (list_query_role != null && list_query_role.size() == 1) {
					ScRole scRole_select = (ScRole) list_query_role.get(0);
					if (!roleId.equals(scRole_select.getRoleId())) {

						isExist = true;
					}
				}
			}
		}else{
			//新增
			Map<String, Object> condition = new HashMap<String, Object>();
			condition.put("enableState", ((ParamConfigBean) StrutsUtil.getApplication().getAttribute("CONFIG_STATE")).getValueByCode("enable"));
			condition.put("roleName", roleName);
			List<ScRole> list_query_role = roleDao.queryRoleList(condition);
			if (list_query_role != null && list_query_role.size() > 0) {
				isExist = true;
			}
		}
		//
		return isExist;
	}
}
