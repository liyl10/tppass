/************************* 版权声明 *********************************
 *
 * Copyright (C) 2012 西安辉盛科技发展有限责任公司.
 *
 ******************************************************************
 */

package com.hopsun.scenter.api.user.service.impl;

import java.util.ArrayList;
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
import com.hopsun.scenter.api.role.dao.RoleDao;
import com.hopsun.scenter.api.user.dao.UserDao;
import com.hopsun.scenter.api.user.service.UserService;
import com.hopsun.scenter.entity.ScDept;
import com.hopsun.scenter.entity.ScRole;
import com.hopsun.scenter.entity.ScUsers;
import com.hopsun.subgroups.paramconfig.bean.ParamConfigBean;
import com.hopsun.subgroups.paramconfig.util.ParamConfigUtil;

/**
 * @Comments: Service实现类 - 管理员
 * @author dulei(dulei@hopsun.cn)
 * @date 2012-11-24 14:32:32
 * @version 1.0
 * 
 */
@Service
@SuppressWarnings("unchecked")
public class UserServiceImpl extends BaseServiceImpl<ScUsers, String> implements UserService {

	@Resource
	private UserDao userDao;

	@Resource
	private RoleDao roleDao;

	/**
	 * 根据用户名获取管理员对象，若管理员不存在，则返回null（不区分大小写）
	 * 
	 * @param username
	 * @return ScUsers
	 * 
	 */
	public ScUsers getUserByUsername(String username) {
		return userDao.getUserByUsername(username);
	}

	/**
	 * 根据用户名获取管理员对象，若管理员不存在，则返回null（未删除）
	 * 
	 * @param username
	 * @return ScUsers
	 * 
	 */
	public ScUsers getUserByUsername2(String username) {
		return userDao.getUserByUsername2(username);
	}

	@Resource
	public void setBaseDao(UserDao userDao) {
		super.setBaseDao(userDao);
	}

	/**
	 * 分页查询
	 * 
	 * @param user
	 *            pageNo pageSize
	 * @return Pager
	 * 
	 */
	public Pager find(ScUsers user, String optuserid, int pageNo, int pageSize) {
		Map<String, Object> condition = new HashMap<String, Object>();
		// 操作的目标用户
		ScUsers optUser = null;
		if (optuserid != null && !"".equals(optuserid)) {
			optUser = userDao.get(optuserid);
		}
		// 若操作的用户不为空，则查询操作用户；否则查询登录的用户
		
		// 存放自己及所有下级用户
		Set<ScUsers> user_available_childSet = new HashSet<ScUsers>();
		// 获取自己的下级
		getChildUser(optUser, user_available_childSet);
		//
		if (user_available_childSet != null && user_available_childSet.size() > 0) {
			StringBuffer childStr = new StringBuffer(""); // 存放所有节点数据
			for (ScUsers puser : user_available_childSet) {
				childStr.append("'" + puser.getUserId() + "',");
			}
			childStr.deleteCharAt(childStr.length() - 1); // 删除最后一个多余的逗号。
			condition.put("childSet", childStr.toString());
		}
		if(user.getScDept()!=null){
			ScDept optDept =user.getScDept();
			// 获取查询条件的部门，查询选择部门级下级部门的成员
			Set<ScDept> dept_available_childSet = new HashSet<ScDept>();
			dept_available_childSet.add(optDept);
			//获取所选部门的下级部门
			getChildDept(optDept, dept_available_childSet);
			if (dept_available_childSet != null && dept_available_childSet.size() > 0) {
				StringBuffer childStr = new StringBuffer(""); // 存放所有节点数据
				for (ScDept pDept : dept_available_childSet) {
					childStr.append("'" + pDept.getDeptId() + "',");
				}
				childStr.deleteCharAt(childStr.length() - 1); // 删除最后一个多余的逗号。
				condition.put("childDeptSet", childStr.toString());
			}
		}
		return userDao.find(user, optUser,condition, pageNo, pageSize);
	}
	/**
	 * 递归获取部门的所有下级部门
	 * 
	 * @return
	 */
	public void getChildDept(ScDept selectDept, Set<ScDept> dept_available_childSet) {
		if (selectDept != null) {
			// 获取自己的下级
			Set<ScDept> childSet = selectDept.getScDepts();
			if (childSet != null) {
				for (ScDept perDept: childSet) {
					// 判断不重复包含
					if (!dept_available_childSet.contains(perDept)) {
						dept_available_childSet.add(perDept);
						getChildDept(perDept, dept_available_childSet);
					}
				}
			}
		}
		return;
	}

	/**
	 * 查询用户信息
	 * 
	 * @param dept
	 * @return List<ScUsers>
	 */
	public List<ScUsers> findUser(ScUsers user) {
		return userDao.findUser(user);
	};

	/**
	 * 根据用户信息查询可用的角色list
	 */
	public List getRoleListByUserId(String userId) {
		Map<String, Object> condition = new HashMap<String, Object>();
		if (userId == null || "".equals(userId)) {
			return null;
		}
		// 获取用户信息
		ScUsers scUser = userDao.get(userId);
		if (scUser == null) {
			return null;
		}
		// 可用的角色
		List<ScRole> role_available = new ArrayList<ScRole>();

		// 存放自己及所有下级用户
		Set<ScUsers> user_available_childSet = new HashSet<ScUsers>();
		// 可管理的用户包含自己
		user_available_childSet.add(scUser);
		// 获取自己的下级
		getChildUser(scUser, user_available_childSet);
		//
		if (user_available_childSet != null && user_available_childSet.size() > 0) {
			StringBuffer childStr = new StringBuffer(""); // 存放所有节点数据
			for (ScUsers puser : user_available_childSet) {
				childStr.append("'" + puser.getUserId() + "',");
			}
			childStr.deleteCharAt(childStr.length() - 1); // 删除最后一个多余的逗号。
			condition.put("childSet", childStr.toString());
		}

		// 获取自己创建的仅自己可见的角色
		condition.put("enableState", ((ParamConfigBean) StrutsUtil.getApplication().getAttribute("CONFIG_STATE")).getBeansByCode("enable").getValue());
		condition.put("verifyState", ((ParamConfigBean) StrutsUtil.getApplication().getAttribute("VERIFY_STATE")).getBeansByCode("verifypass").getValue());
		//condition.put("userId", userId);
		role_available = roleDao.queryRoleList(condition);
		return role_available;
	};

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
						user_available_childSet.add(perUser);
						getChildUser(perUser, user_available_childSet);
					}
				}
			}
		}
		return;
	}

	/**
	 * 获取可用角色列表，并带有是否选中属性
	 * 
	 * @param userId
	 * @param targetUserId
	 * @return
	 */

	public List getRoleListWithSelected(String userId, String targetUserId) {

		if (userId == null || "".equals(userId)) {
			return null;
		}
		if (targetUserId == null || "".equals(targetUserId)) {
			return null;
		}
		List resultList = new ArrayList();
		List<ScRole> role_available = getRoleListByUserId(userId);

		// 确认哪些角色，所要操作的用户已选中
		// 获取操作目标用户信息
		ScUsers scUserTarget = userDao.get(targetUserId);
		if (scUserTarget != null) {
			Set<ScRole> setScUserTarget = scUserTarget.getScRoles();
			if (role_available != null && role_available.size() > 0) {

				for (ScRole role1 : role_available) {
					Map roleMap = new HashMap();
					roleMap.put("role", role1);
					if (setScUserTarget != null && setScUserTarget.contains(role1)) {
						roleMap.put("selected", "true");
					} else {
						roleMap.put("selected", "false");
					}
					resultList.add(roleMap);
				}
			}
		}
		return resultList;
	}

	/**
	 * 根据用户id查询可用的上级用户id
	 * 
	 * @param userId
	 * @return
	 */
	public List<ScUsers> getSupUserListByUserId(ScUsers user) {

		return userDao.queryUserList(user);

	}

	/**
	 * 根据用户查询其下级用户
	 * 
	 * @param userId
	 * @return
	 */
	public List<ScUsers> getSupUserListByUserIdB(ScUsers scUser) {
		Map<String, Object> condition = new HashMap<String, Object>();
		// 存放自己及所有下级用户
		Set<ScUsers> user_available_childSet = new HashSet<ScUsers>();
		// 获取自己的下级
		getChildUser(scUser, user_available_childSet);
		//
		if (user_available_childSet != null && user_available_childSet.size() > 0) {
			StringBuffer childStr = new StringBuffer(""); // 存放所有节点数据
			for (ScUsers puser : user_available_childSet) {
				childStr.append("'" + puser.getUserId() + "',");
			}
			childStr.deleteCharAt(childStr.length() - 1); // 删除最后一个多余的逗号。
			condition.put("childSet", childStr.toString());
		}
		return userDao.queryUserList(scUser, condition);
	}
	/**
	 * 根据用户id查询可用的上级用户id，返回json数据。（包括自己）
	 * 
	 * @param userId
	 * @return
	 */
	public String getSupUserListJsonByUserId(String userId, String targetUserId) {
		String nodesvee = null;
		Set<ScUsers> selectedParentUser = new HashSet();
		// 获取用户信息
		ScUsers scUser = userDao.get(userId);
		if (scUser == null) {
			return null;
		}
		List<ScUsers> user_available = getSupUserListByUserIdB(scUser);
		if (user_available == null) {
			user_available = new ArrayList();
		}
		// 若自己不在可用列表中则，将自己也添入可用列表
		if (!user_available.contains(scUser)) {
			// 并且不是操作自己的信息
			if (!userId.equals(targetUserId)) {
				user_available.add(scUser);
			}
		}

		// 获取所要操作的用户信息
		if (targetUserId != null && !"".equals(targetUserId)) {
			ScUsers targetUser = userDao.get(targetUserId);
			if (targetUser != null) {
				selectedParentUser = targetUser.getScUsersesForParentUserId();
				// 若操作的目标用户在可用列表中，则从列表中删除。即用户的上级不能是用户自己
				if (user_available.contains(targetUser)) {
					user_available.remove(targetUser);
				}

				// 将目标用户的子集，从可用列表删除。
				List<ScUsers> lista = new ArrayList();
				lista.addAll(user_available);

				// 获取操作目标用户的所有子级用户
				// 存放自己及所有下级用户
				Set<ScUsers> user_available_childSet = new HashSet<ScUsers>();
				// 获取操作目标的下级
				getChildUser(targetUser, user_available_childSet);
				for (ScUsers user : lista) {
					if (user_available_childSet.contains(user)) {
						user_available.remove(user);
					}
				}
			}
		}

		// 如果上级用户为空，则选中当前用户
		if (selectedParentUser == null || selectedParentUser.size() < 1) {
			selectedParentUser.add(scUser);
		}
		//
		if (user_available != null && user_available.size() > 0) {
			//Map nodeUserMap = new HashMap();
			// 生成树节点
			List<Map> nodeUser = new ArrayList();
			getMultParentNodeList(user_available, nodeUser);
			
			if (nodeUser != null && nodeUser.size() > 0) {
				StringBuffer strres = new StringBuffer(""); // 存放所有节点数据
				
				// String authid = null;
				String parentid = "";
				String open = "true"; // 是否展开标志
				String strname = ""; // 节点显示名称
				String strtitle = ""; // 节点显示的标题
				strres.append("[");
				int i = 0;
				for (Map perUserMap : nodeUser) {
					String checked = "false"; // 是否选中的标志。
					parentid = perUserMap.get("pid").toString();
					for (ScUsers userT : selectedParentUser) {
						if (userT.getUserId().equals(perUserMap.get("src_id").toString())) {
							checked = "true";
							break;
						}  
					}

					 if (i<2) {
					 open = "true";
					 i++;
					 } else {
					 open = "false";
					 i++;
					 }
					if (perUserMap.get("realName") != null && !"".equals(perUserMap.get("realName"))) {
						strname = perUserMap.get("realName").toString() + "-" + perUserMap.get("name").toString();
						strtitle = strname;
						// strname=perUserMap.get("realName").toString();
						if (strname.length() > 30) {
							strname = strname.substring(0, 27);
							strname = strname + "...";
						}
					} else {
						strname = "-" + perUserMap.get("name").toString();
						strtitle = strname;
						// strname=perUserMap.get("realName").toString();
						if (strname.length() > 30) {
							strname = strname.substring(0, 27);
							strname = strname + "...";
						}
					}
					//					if (perUserMap.get("scDept") != null) {
					//						strtitle = perUserMap.get("scDept").toString();
					//					}

					strres.append("{id:'" + perUserMap.get("id").toString() + "',pId:'" + parentid + "',name:'" + strname.replaceAll("\'", "\\\\'") + "',title:'" + strtitle + "',open:" + open + ",checked:" + checked + "},");
				}
				strres.deleteCharAt(strres.length() - 1); // 删除最后一个多余的逗号。
				strres.append("]");
				nodesvee = strres.toString();
			}
		}
		return nodesvee;
	}

	/**
	 * 递归查询多上级用户,并处理成ztree可用的json串
	 */
	public void getMultParentNodeList(List<ScUsers> user_available, List<Map> nodeUser) {
		int id = 0;
		if (nodeUser==null){
			nodeUser=new ArrayList<Map>();
		}
		Map nodeUserMap = new HashMap();
		while (user_available != null && user_available.size() > 0) {
			boolean needremove = false;
			ScUsers removeuser = null;
			for(ScUsers peruser : user_available) {
				 
				needremove = false;
				
				// 上级用户集合
				Set<ScUsers> parentUsers = peruser.getScUsersesForParentUserId();
				if (parentUsers != null && parentUsers.size() > 0) {
					// 本级别中是否是顶级用户
					boolean isMaxUser = true;
					// 若该用户有上级用户,则判断上级是否在原始列表中
					id++;
					for (ScUsers peruserB : user_available){
						if(parentUsers.contains(peruserB)){
							isMaxUser=false;
							break;
						}
					}
					if(isMaxUser){
						//如果是原始列表中最高级的用户，则继续判断是否是新列表中的用其上级
						boolean nodeUserHave = false;
						List<Map> rightList = new ArrayList<Map>();
						for (Map userTMap : nodeUser) {
							for(ScUsers peruserT : parentUsers){
								if (peruserT.getUserId().equals(userTMap.get("src_id").toString())) {
									// 如果存在于处理后的列表中，则将其也移至处理后的列表中，并设上下级关系
									id++;
									nodeUserHave = true;
									nodeUserMap = new HashMap();
									nodeUserMap.put("id", id + "#" + peruser.getUserId());
									nodeUserMap.put("src_id", peruser.getUserId());
									nodeUserMap.put("pid", userTMap.get("id"));
									nodeUserMap.put("realName", peruser.getUserRealname());
									nodeUserMap.put("name", peruser.getUserName());
									rightList.add(nodeUserMap);
								}
							}
							
						}
						if (nodeUserHave) {
							//若新列表中该用户的上级
							nodeUser.addAll(rightList);
						} else {
							//若无该用户的上级
							id++;
							nodeUserMap = new HashMap();
							nodeUserMap.put("id", id + "#" + peruser.getUserId());
							nodeUserMap.put("src_id", peruser.getUserId());
							nodeUserMap.put("pid", "");
							nodeUserMap.put("realName", peruser.getUserRealname());
							nodeUserMap.put("name", peruser.getUserName());
							nodeUser.add(nodeUserMap);
						} 
						removeuser = peruser;
						needremove = true;
						
					}else{
						continue;
					}
				} else {
					// 无上级则为顶级用户
					id++;
					nodeUserMap = new HashMap();
					nodeUserMap.put("id", id+"#"+peruser.getUserId());
					nodeUserMap.put("src_id", peruser.getUserId());
					nodeUserMap.put("pid", "");
					nodeUserMap.put("name", peruser.getUserName());
					nodeUserMap.put("realName", peruser.getUserRealname());
					nodeUser.add(nodeUserMap);
					// user_available.remove(peruser);
					removeuser = peruser;
					needremove = true;
					// break;
				}
				if (needremove) {
					break;
				}
			}
			if (needremove) {
				user_available.remove(removeuser);
			}
		}
	}
	/**
	 * 更新用户信息
	 * @param user
	 * @return
	 */
	public Map<String, Object> updateUsers(ScUsers user) {
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("msg", "0");
		boolean hasChildren =false;
		ScUsers newUserInfo=userDao.get(user.getUserId());
		newUserInfo.setScRoles(user.getScRoles());  //角色
		newUserInfo.setModifyDate(user.getModifyDate());
		newUserInfo.setModifyUserName(user.getModifyUserName());
		newUserInfo.setUserPwd(user.getUserPwd());
		newUserInfo.setUserRealname(user.getUserRealname());
		newUserInfo.setUserEmail(user.getUserEmail());
		newUserInfo.setScDept(user.getScDept());  //部门
		newUserInfo.setUserName(user.getUserName());
		newUserInfo.setUserAgent(user.getUserAgent());
		newUserInfo.setUserNickname(user.getUserNickname());
		newUserInfo.setUserPhone(user.getUserPhone());
		newUserInfo.setUserType(user.getUserType());
		//若禁用则判断
		if(user.getEnableState().equals(((ParamConfigBean) StrutsUtil.getApplication().getAttribute("CONFIG_STATE")).getBeansByCode("disable").getValue())){
			ScUsers newUserInfoT=userDao.get(user.getUserId());
			//查询未删除的下级用户
			hasChildren=isHasChildrenUser(newUserInfoT);		 
			if(!hasChildren){
			//查询未删除的角色
			hasChildren=isCreateRoles(user);
			//若无下级用户,也无创建的角色
				if(!hasChildren){
					newUserInfo.setEnableState(user.getEnableState());
					//必须重新把set里的自关联对象加载一遍。
					Set<ScUsers> parentUserA = user.getScUsersesForParentUserId();
					Set<ScUsers> parentUser = new HashSet<ScUsers>();
					if(parentUserA!=null&& parentUserA.size()>0){
						for(ScUsers userA:parentUserA){
							ScUsers userT=userDao.get(userA.getUserId());
							parentUser.add(userT);
						}
					}
					newUserInfo.setScUsersesForParentUserId(parentUser);
					userDao.update(newUserInfo);
					result.put("msg", "1");
				}else {
					//有下创建的角色，不能禁用！
					String error = String.valueOf(ParamConfigUtil.getServletContext().getAttribute("validform.scenter.user.role.disable.error"));
					result.put("msg", user.getUserName()+error);
				}
			}else{
				//有下级用户，不能禁用！
				String error = String.valueOf(ParamConfigUtil.getServletContext().getAttribute("validform.scenter.user.child.disable.error"));
				result.put("msg", user.getUserName()+error);
			}
			
		} else{
			newUserInfo.setEnableState(((ParamConfigBean) StrutsUtil.getApplication().getAttribute("CONFIG_STATE")).getBeansByCode("enable").getValue());
			//必须重新把set里的自关联对象加载一遍。
			Set<ScUsers> parentUserA = user.getScUsersesForParentUserId();
			Set<ScUsers> parentUser = new HashSet<ScUsers>();
			if(parentUserA!=null&& parentUserA.size()>0){
				for(ScUsers userA:parentUserA){
					ScUsers userT=userDao.get(userA.getUserId());
					parentUser.add(userT);
				}
			}
			newUserInfo.setScUsersesForParentUserId(parentUser);
			userDao.update(newUserInfo);
			result.put("msg", "1");
		}
		return result;
	}
	/**
	 * 删除用户信息
	 * @param user
	 * @return
	 */
	public Map<String, Object> deleteUser(String optUserId) {
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("msg", "1");
		boolean hasChildren =false;
		if (optUserId == null || "".equals(optUserId)) {
			//操作失败,用户信息不正确！
			String error = String.valueOf(ParamConfigUtil.getServletContext().getAttribute("validform.scenter.user.delete.info.error"));
			result.put("info", error);
			return result;
		}
		ScUsers optUsers=userDao.get(optUserId);
		if(optUsers!=null){
			//查询未删除的下级用户
			hasChildren=isHasChildrenUser(optUsers);		 
			if(!hasChildren){
				//查询未删除的角色
				hasChildren=isCreateRoles(optUsers);
				//若无下级用户,也无创建的角色
				if(!hasChildren){
					optUsers.setDeleteState(((ParamConfigBean)StrutsUtil.getApplication().getAttribute("DEL_STATE")).getValueByCode("disable"));
					return result;
				}else {
					optUsers.setDeleteState(((ParamConfigBean)StrutsUtil.getApplication().getAttribute("DEL_STATE")).getValueByCode("enable"));
					//操作失败,用户信息不正确！
					String error = String.valueOf(ParamConfigUtil.getServletContext().getAttribute("validform.scenter.user.delete.child.error"));
					result.put("msg", optUsers.getUserName()+error);
					return result;
				}
			}else {
				optUsers.setDeleteState(((ParamConfigBean)StrutsUtil.getApplication().getAttribute("DEL_STATE")).getValueByCode("enable"));
				//操作失败,用户信息不正确！
				String error = String.valueOf(ParamConfigUtil.getServletContext().getAttribute("validform.scenter.user.delete.role.error"));
				result.put("msg", optUsers.getUserName()+error);
				return result;
			}
			
		}else{
			//操作失败,用户信息不正确！
			String error = String.valueOf(ParamConfigUtil.getServletContext().getAttribute("validform.scenter.user.delete.info.error"));
			result.put("info", error);
		}
		
		return result;
	}
	/**
	 * 判断用户下是否有下级用户
	 * @param optUsers
	 * @return
	 */
	public boolean isHasChildrenUser(ScUsers optUsers){
		boolean hasChildren=false;
		Set<ScUsers> childuser= optUsers.getScUsersesForChildUserId();
		if(childuser!=null&& childuser.size()>0){
			for(ScUsers userT:childuser){
				//查询未删除的下级用户
				if(userT.getDeleteState().equals(((ParamConfigBean)StrutsUtil.getApplication().getAttribute("DEL_STATE")).getValueByCode("enable"))){
					hasChildren=true;
					break;
				}
			}
		}
		return hasChildren;
	}
	/**
	 * 判断用户是否有创建的角色
	 * @param optUsers
	 * @return
	 */
	public boolean isCreateRoles(ScUsers optUsers){
		boolean hasChildren=false;
		//查询未删除的角色
		Set<ScRole> createRoles=optUsers.getScRoles_1();
		if(createRoles!=null&&createRoles.size()>0){
			for(ScRole roleT:createRoles){
				if(roleT.getDeleteState().equals(((ParamConfigBean)StrutsUtil.getApplication().getAttribute("DEL_STATE")).getValueByCode("enable"))){
					hasChildren=true;
					break;
				}	
			}
		}
		return hasChildren;
	}
	/**
	 * 更新用户审核状态
	 * @param user
	 * @return
	 */
	public Map<String, Object> updateVerifyState(ScUsers user) {
		boolean hasChildren =false;
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("msg", "1");
		//若审核不通过则判断
		String verifypass = ((ParamConfigBean) StrutsUtil.getApplication().getAttribute("VERIFY_STATE")).getBeansByCode("verifypass").getValue();
		if(!(user.getVerifyState().equals(verifypass))){
			//查询未删除的下级用户
			hasChildren=isHasChildrenUser(user);		 
			if(!hasChildren){
				//查询未删除的角色
				hasChildren=isCreateRoles(user);
				if(!hasChildren){
					super.update(user);
				}else {
					//有未删除的角色，不能审核不通过
					String error = String.valueOf(ParamConfigUtil.getServletContext().getAttribute("validform.scenter.user.verify.role.error"));
					result.put("msg", user.getUserName()+error);
					user.setVerifyState(verifypass);
				}
			}else {
				//有下级用户，不能审核不通过
				String error = String.valueOf(ParamConfigUtil.getServletContext().getAttribute("validform.scenter.user.verify.child.error"));
				result.put("msg", user.getUserName()+error);
				user.setVerifyState(verifypass);
			}
		}else {
			super.update(user);
		}
		
		return result;
	}
	/**
	 * 更新用户的启用状态
	 * @param user
	 * @return
	 */
	public Map<String, Object> updateEnableState(ScUsers user) {
		boolean hasChildren =false;
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("msg", "1");
		//若启用状态的为禁用，则判断
		String enable = ((ParamConfigBean) StrutsUtil.getApplication().getAttribute("CONFIG_STATE")).getBeansByCode("enable").getValue();
		if(!user.getEnableState().equals(enable)){
			//查询未删除的下级用户
			hasChildren=isHasChildrenUser(user);		 
			if(!hasChildren){
				//查询未删除的角色
				hasChildren=isCreateRoles(user);
				if(!hasChildren){
					super.update(user);
				}else {
					//有未删除的角色，
					String error = String.valueOf(ParamConfigUtil.getServletContext().getAttribute("validform.scenter.user.delete.child.error"));
					result.put("msg", user.getUserName()+error);
					user.setEnableState(enable);
				}
			}else {
				//有未删除的下级用户，
				String error = String.valueOf(ParamConfigUtil.getServletContext().getAttribute("validform.scenter.user.delete.child.error"));
				result.put("msg", user.getUserName()+error);
				user.setEnableState(enable);
			}
		}else{
			super.update(user);
		}
		return result;
	}

	@Override
	public List<ScUsers> getList() {
		
		return userDao.getList();
	}

	/**
	 * 根据条件查询用户信息
	 * @comments 
	 * @param valueMap
	 * @return
	 * @version 1.0
	 */
	public List<ScUsers> getUserList(Map<String, Object> valueMap) {

		return userDao.getUserList(valueMap);
	}
}