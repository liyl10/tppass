/************************* 版权声明 *********************************
 *
 * Copyright (C) 2012 西安辉盛科技发展有限责任公司.
 *
 ******************************************************************
 */
package com.hopsun.scenter.api.role.dao.impl;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.hopsun.framework.base.bean.Finder;
import com.hopsun.framework.base.bean.Pager;
import com.hopsun.framework.base.dao.impl.BaseDaoImpl;
import com.hopsun.framework.util.StrutsUtil;
import com.hopsun.scenter.api.role.dao.RoleDao;
import com.hopsun.scenter.entity.ScRole;
import com.hopsun.subgroups.paramconfig.bean.ParamConfigBean;

/**
 * @comments 角色管理dao实现类
 * @author yinxy
 * @date Dec 26, 2012
 * @version 1.0
 */

@Repository
@SuppressWarnings("unchecked")
public class RoleDaoImpl extends BaseDaoImpl<ScRole, String> implements RoleDao {

	/**
	 * 获取角色列表
	 * 
	 * @return
	 */
	public List<ScRole> getRoleList() {
		String hql = null;
		hql = "select sc_role from ScRole sc_role where sc_role.deleteState=?  order by sc_role.roleOrder desc,sc_role.roleId desc";
		return this.createQueryList(hql, ((ParamConfigBean) StrutsUtil.getApplication().getAttribute("DEL_STATE")).getBeansByCode("enable").getValue());

	}

	/**
	 * 根据条件查询角色列表
	 * 
	 * @param condition
	 * @return
	 */
	public List queryRoleList(Map<String, Object> condition) {
		Finder finder = Finder.create("from ScRole sc_role where sc_role.deleteState=:dele");
		finder.setParam("dele", ((ParamConfigBean) StrutsUtil.getApplication().getAttribute("DEL_STATE")).getBeansByCode("enable").getValue());
		if (condition != null && condition.size() > 0) {
			if (condition.get("enableState") != null) {
				finder.append(" and sc_role.enableState=:enableState");
				finder.setParam("enableState", condition.get("enableState").toString());
			}
			if (condition.get("verifyState") != null) {
				finder.append(" and sc_role.verifyState=:verifyState");
				finder.setParam("verifyState", condition.get("verifyState").toString());
			}
			 
			if (condition.get("userId") != null) {
				finder.append(" and sc_role.scUsers.userId=:userId");
				finder.setParam("userId", condition.get("userId").toString());
			}
			if (condition.get("roleName") != null) {
				finder.append(" and lower(sc_role.roleName)=lower(:roleName)");
				finder.setParam("roleName", condition.get("roleName").toString());
			}
			if (condition.get("is_sup_admin") != null && "true".equals(condition.get("is_sup_admin"))) {
				//若为超级管理员，则不判断下级条件
			} else {
				//仅查询自己及下级用户创建的角色
				if (condition.get("childSet") != null&&!"".equals(condition.get("childSet"))) {
					 String strChildSet=condition.get("childSet").toString();
					 finder.append(" and (sc_role.scUsers.userId in ("+strChildSet+"))");
				}
			}
		}
		finder.append(" order by sc_role.roleOrder desc,sc_role.roleId desc");
		return super.find(finder);
	}

	/**
	 * 根据条件查询角色
	 * 
	 * @param condition
	 * @return
	 */
	public Pager queryRoleList(Map<String, Object> condition, int pageNo, int pageSize) {
		Finder finder = Finder.create("from ScRole sc_role where sc_role.deleteState=:dele");
		finder.setParam("dele", ((ParamConfigBean) StrutsUtil.getApplication().getAttribute("DEL_STATE")).getBeansByCode("enable").getValue());
		if (condition != null && condition.size() > 0) {
			if (condition.get("enableState") != null) {
				finder.append(" and sc_role.enableState=:enableState");
				finder.setParam("enableState", condition.get("enableState").toString());
			}
			if (condition.get("verifyState") != null) {
				finder.append(" and sc_role.verifyState=:verifyState");
				finder.setParam("verifyState", condition.get("verifyState").toString());
			}
			if (condition.get("roleName") != null) {
				finder.append(" and lower(sc_role.roleName) like lower(:roleName)");
				finder.setParam("roleName", "%" + condition.get("roleName").toString() + "%");
			}
		}
		finder.append(" order by sc_role.roleOrder desc,sc_role.roleId desc");
		return super.find(finder, pageNo, pageSize);
	}

	/**
	 * 根据条件查询角色分页,后跟权限验证sql
	 * 
	 * @param condition
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	public Pager queryRoleListWithSql(Map<String, Object> condition, int pageNo, int pageSize) {
		Finder finder = Finder.create("select sc_role from ScRole sc_role where sc_role.deleteState=:dele");
		finder.setParam("dele",((ParamConfigBean) StrutsUtil.getApplication().getAttribute("DEL_STATE")).getBeansByCode("enable").getValue());
		if (condition != null && condition.size() > 0) {

			if (condition.get("enableState") != null) {
				finder.append(" and sc_role.enableState=:enableState");
				finder.setParam("enableState", condition.get("enableState").toString());
			}
			if (condition.get("verifyState") != null) {
				finder.append(" and sc_role.verifyState=:verifyState");
				finder.setParam("verifyState", condition.get("verifyState").toString());
			}
			if (condition.get("roleName") != null) {
				finder.append(" and lower(sc_role.roleName) like lower(:roleName)");
				finder.setParam("roleName", "%" + condition.get("roleName").toString() + "%");
			}
			if (condition.get("is_sup_admin") != null && "true".equals(condition.get("is_sup_admin"))) {
				//若为超级管理员，则不判断下级条件
			} else {
				//仅查询自己及下级用户创建的角色
				if (condition.get("childSet") != null&&!"".equals(condition.get("childSet"))) {
					 String strChildSet=condition.get("childSet").toString();
					 finder.append(" and (sc_role.scUsers.userId in ("+strChildSet+"))");
				}
			}
		}
		finder.append(" order by sc_role.roleOrder desc,sc_role.roleId desc");
		return super.find(finder, pageNo, pageSize);
	}
}
