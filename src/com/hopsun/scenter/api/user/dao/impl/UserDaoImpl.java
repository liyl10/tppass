/************************* 版权声明 *********************************
 *
 * Copyright (C) 2012 西安辉盛科技发展有限责任公司.
 *
 ******************************************************************
 */

package com.hopsun.scenter.api.user.dao.impl;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.stereotype.Repository;

import com.hopsun.framework.base.bean.Finder;
import com.hopsun.framework.base.bean.Pager;
import com.hopsun.framework.base.dao.impl.BaseDaoImpl;
import com.hopsun.framework.util.StrutsUtil;
import com.hopsun.scenter.api.user.dao.UserDao;
import com.hopsun.scenter.entity.ScUsers;
import com.hopsun.subgroups.paramconfig.bean.ParamConfigBean;

/**
 * @Comments:   Dao实现类 - 管理员管理，该实现从BaseDaoImpl继承，具备基础的持久化操作的所有方法，相对复杂的业务sql需要在实现中编写
 * @author dulei(dulei@hopsun.cn)
 * @date 2012-12-24 14:41:32
 * @version 1.0
 *
 */
@Repository
@SuppressWarnings("unchecked")
public class UserDaoImpl extends BaseDaoImpl<ScUsers, String> implements UserDao {
	
	/**
	 * 根据用户名判断此用户是否存在（不区分大小写）
	 * @param username
	 * @return boolean
	 *
	 */
	@SuppressWarnings("unchecked")
	public boolean isExistByUsername(String username) {
		String hql = "from ScUsers user where user.userName = ?";
		ScUsers admin = (ScUsers) getSession().createQuery(hql).setParameter(0, username).uniqueResult();
		if (admin != null) {
			return true;
		} else {
			return false;
		}
	}
	
	/**
	 * 根据用户名获取管理员对象，若管理员不存在，则返回null（不区分大小写）
	 * @param username
	 * @return ScUsers
	 *
	 */
	@SuppressWarnings("unchecked")
	public ScUsers getUserByUsername(String username) {
		//String hql = "from ScUsers user where lower(user.userName) = lower(?) and lower(user.deleteState) = lower(?) and ";
		
		Finder f = Finder.create("from ScUsers u where u.userName=:userName").setParam("userName", username);
		
		//已启用
		f.append(" and u.enableState=:enableState").setParam("enableState", ((ParamConfigBean)StrutsUtil.getApplication().getAttribute("CONFIG_STATE")).getValueByCode("enable"));
		//审核通过
		f.append(" and u.verifyState=:verifyState").setParam("verifyState", ((ParamConfigBean)StrutsUtil.getApplication().getAttribute("VERIFY_STATE")).getValueByCode("verifypass"));
		//未删除
		f.append(" and u.deleteState=:deleteState").setParam("deleteState", ((ParamConfigBean)StrutsUtil.getApplication().getAttribute("DEL_STATE")).getValueByCode("enable"));
		
		f.append(" order by u.userId desc");
		
		//return (ScUsers) getSession().createQuery(hql).setParameter(0, username).uniqueResult();
		
		List<ScUsers> list = super.find(f);
		
		ScUsers user = null;
		
		if(list.size()>0){
			user = list.get(0);
		}
		
		return user;
	}
	/**
	 * 根据用户名获取管理员对象，若管理员不存在，则返回null（未删除状态）
	 * @param username
	 * @return ScUsers
	 *
	 */
	public ScUsers getUserByUsername2(String username) {
		//String hql = "from ScUsers user where lower(user.userName) = lower(?) and lower(user.deleteState) = lower(?) and ";
		
		Finder f = Finder.create("from ScUsers u where u.userName=:userName").setParam("userName", username);
		
		//已启用
		//f.append(" and u.enableState=:enableState").setParam("enableState", ((ParamConfigBean)StrutsUtil.getApplication().getAttribute("CONFIG_STATE")).getValueByCode("enable"));
		//审核通过
		//f.append(" and u.verifyState=:verifyState").setParam("verifyState", ((ParamConfigBean)StrutsUtil.getApplication().getAttribute("VERIFY_STATE")).getValueByCode("verifypass"));
		//未删除
		f.append(" and u.deleteState=:deleteState").setParam("deleteState", ((ParamConfigBean)StrutsUtil.getApplication().getAttribute("DEL_STATE")).getValueByCode("enable"));
		
		f.append(" order by u.userId desc");
		
		//return (ScUsers) getSession().createQuery(hql).setParameter(0, username).uniqueResult();
		
		List<ScUsers> list = super.find(f);
		
		ScUsers user = null;
		
		if(list.size()>0){
			user = list.get(0);
		}
		
		return user;
	}
	
	/**
	 * 根据参数分页查询用户信息
	 * 1.未删除 deleteState
	 * 2.用户名、用户昵称、部门、审核状态、请用状态
	 * 3.全局可见用户
	 * 4.仅自己可见（添加时指定的上级）
	 * 5.上级可见（添加时指定的上级以及上级的上级可见）
	 */
	public Pager find(ScUsers user,ScUsers optUser,Map<String,Object> condition,int pageNo, int pageSize) {
		
		Finder f = Finder.create("from ScUsers u");
		
		//未删除
		String deleteState = ((ParamConfigBean)StrutsUtil.getApplication().getAttribute("DEL_STATE")).getValueByCode("enable");
		f.append(" where u.deleteState=:deleteState").setParam("deleteState", deleteState);
		//排除超级管理员
		f.append(" and u.userId!=:adminUserId").setParam("adminUserId", "1");
		//
		if(null != user){
			//用户名称
			if(null != user.getUserName() && user.getUserName().trim().length()>0){
				f.append(" and lower(u.userName) like lower(:userName)").setParam("userName", "%" + user.getUserName().trim() + "%");
			}
			//真实姓名
			if(null != user.getUserRealname() && user.getUserRealname().trim().length()>0){
				f.append(" and lower(u.userRealname) like lower(:userRealname)").setParam("userRealname", "%" + user.getUserRealname().trim() + "%");
			}
			//部门
//			if(null != user.getScDept() && null != user.getScDept().getDeptId() && user.getScDept().getDeptId().trim().length()>0){
//				f.append(" and u.scDept.deptId =:deptId").setParam("deptId", user.getScDept().getDeptId());
//			}
			//审核状态
			if(null != user.getVerifyState() && user.getVerifyState().trim().length()>0){
				f.append(" and u.verifyState=:verifyState").setParam("verifyState", user.getVerifyState());
			}
			//启用状态
			if(null != user.getEnableState() && user.getEnableState().trim().length()>0){
				f.append(" and u.enableState=:enableState").setParam("enableState", user.getEnableState());
			}
			
		}
		 
		//查询optUser的直接下级
		//		Set<ScUsers> childSet = optUser.getScUsersesForChildUserId();
		//		if(null != childSet && childSet.size()>0){
		//			String ids = "";
		//			for (ScUsers u : childSet) {
		//				if(u.getDeleteState().equals(deleteState)){
		//					ids += "'"+u.getUserId()+"',";
		//				}
		//			}
		//			if(ids.endsWith(",")){
		//				ids = ids.substring(0,ids.length()-1);
		//			}
		//			if(ids.length()>0){
		//				f.append(" and u.userId in ( "+ ids +" )");
		//			}
		//		}else{
		//				f.append(" and 1!=1");
		//		}
			//查询所选部门及下级部门的用户
			if (condition!=null&&condition.get("childDeptSet") != null&&!"".equals(condition.get("childDeptSet"))) {
				 String strChildSet=condition.get("childDeptSet").toString();
				 f.append(" and (u.scDept.deptId in ("+strChildSet+"))");
			}
			//仅查询自己及下级用户创建的用户
			if (condition!=null&&condition.get("childSet") != null&&!"".equals(condition.get("childSet"))) {
				 String strChildSet=condition.get("childSet").toString();
				 f.append(" and (u.userId in ("+strChildSet+"))");
			}else{
				 f.append(" and 1!=1");
			}
		 
		f.append(" order by u.userId desc");
		
		return super.find(f, pageNo, pageSize);
	}
	
	/**
	 * 查询用户信息
	 * @param dept
	 * @return
	 */
	public List<ScUsers> findUser(ScUsers user) {

		Finder f = Finder.create("from ScUsers u ");
		
		//已启用
		f.append(" where u.enableState=:enableState").setParam("enableState", ((ParamConfigBean)StrutsUtil.getApplication().getAttribute("CONFIG_STATE")).getValueByCode("enable"));
		//审核通过
		f.append(" and u.verifyState=:verifyState").setParam("verifyState", ((ParamConfigBean)StrutsUtil.getApplication().getAttribute("VERIFY_STATE")).getValueByCode("verifypass"));
		//未删除
		f.append(" and u.deleteState=:deleteState").setParam("deleteState", ((ParamConfigBean)StrutsUtil.getApplication().getAttribute("DEL_STATE")).getValueByCode("enable"));
		//根据部门查询部门下用户
		if(null != user && null != user.getScDept() && null != user.getScDept().getDeptId()){
			f.append(" and u.scDept.deptId=:deptId").setParam("deptId", user.getScDept().getDeptId());
		}
		
		f.append(" order by u.userId desc");
		
		return super.find(f);
	}
	
	/**
	 * 根据条件查询用户列表
	 * @param condition
	 * @return
	 */
	public List<ScUsers> queryUserList(ScUsers user) {
		
		user = this.load(user.getUserId());
		
		Finder finder = Finder.create("from ScUsers u where u.deleteState=:deleteState");
		//未删除
		String deleteState = ((ParamConfigBean) StrutsUtil.getApplication().getAttribute("DEL_STATE")).getBeansByCode("enable").getValue();
		finder.setParam("deleteState", deleteState);
		//已启用
		String enableState = ((ParamConfigBean)StrutsUtil.getApplication().getAttribute("CONFIG_STATE")).getValueByCode("enable");
		finder.append(" and u.enableState=:enableState").setParam("enableState", enableState );
		//审核通过
		String verifyState = ((ParamConfigBean)StrutsUtil.getApplication().getAttribute("VERIFY_STATE")).getValueByCode("verifypass");
		finder.append(" and u.verifyState=:verifyState").setParam("verifyState", verifyState );
		
		String ids = "";
		
		if (null != user) {
			ids = "'"+user.getUserId()+"',";
			Set<ScUsers> childSet = user.getScUsersesForChildUserId();
			
			if(null != childSet && childSet.size()>0){
				for (ScUsers u : childSet) {
					if(u.getDeleteState().equals(deleteState) && u.getEnableState().equals(enableState) && u.getVerifyState().equals(verifyState)){
						ids += "'"+u.getUserId()+"',";
					}
				}
			}
		}
		if(ids.endsWith(",")){
			ids = ids.substring(0,ids.length()-1);
		}
		
		//id取值
		finder.append(" and u.userId in ( "+ids+" )");
		
		finder.append(" order by u.userId desc");
		 
		return super.find(finder);
	}
	/**
	 * 根据条件查询用户列表,根据condition
	 * @param condition
	 * @return
	 */
	public List<ScUsers> queryUserList(ScUsers user, Map<String, Object> condition) {
		Finder finder = Finder.create("from ScUsers u where u.deleteState=:deleteState");
		//未删除
		String deleteState = ((ParamConfigBean) StrutsUtil.getApplication().getAttribute("DEL_STATE")).getBeansByCode("enable").getValue();
		finder.setParam("deleteState", deleteState);
		//已启用
		String enableState = ((ParamConfigBean)StrutsUtil.getApplication().getAttribute("CONFIG_STATE")).getValueByCode("enable");
		finder.append(" and u.enableState=:enableState").setParam("enableState", enableState );
		//审核通过
		String verifyState = ((ParamConfigBean)StrutsUtil.getApplication().getAttribute("VERIFY_STATE")).getValueByCode("verifypass");
		finder.append(" and u.verifyState=:verifyState").setParam("verifyState", verifyState );
		
		//仅查询自己及下级用户创建的用户
		if (condition!=null&&condition.get("childSet") != null&&!"".equals(condition.get("childSet"))) {
			 String strChildSet=condition.get("childSet").toString();
			 finder.append(" and (u.userId in ("+strChildSet+"))");
		}else{
			 finder.append(" and 1!=1");
		}
		
		finder.append(" order by u.userId desc");
		return super.find(finder);
		
	}
	
	/**
	 * 根据userID取得user对象
	 * @param userId
	 * @return
	 */
	public ScUsers getUsersByUserId(String userId){
		
		StringBuffer hql = new StringBuffer();
		hql.append(" from ScUsers s ");
		hql.append(" where s.userId=? ");
		hql.append(" and s.deleteState = 0");
		
		return super.createQueryObj(hql.toString(), new String[]{userId});
	}

	@Override
	public List<ScUsers> getList() {
		Finder f = Finder.create("from ScUsers u where 1=1");
		
		//已启用
		f.append(" and u.enableState=:enableState").setParam("enableState", ((ParamConfigBean)StrutsUtil.getApplication().getAttribute("CONFIG_STATE")).getValueByCode("enable"));
		//审核通过
		f.append(" and u.verifyState=:verifyState").setParam("verifyState", ((ParamConfigBean)StrutsUtil.getApplication().getAttribute("VERIFY_STATE")).getValueByCode("verifypass"));
		//未删除
		f.append(" and u.deleteState=:deleteState").setParam("deleteState", ((ParamConfigBean)StrutsUtil.getApplication().getAttribute("DEL_STATE")).getValueByCode("enable"));
		
		f.append(" order by u.userNickname desc");
		
		return super.find(f);
	}

	/**
	 * 根据条件查询用户信息
	 * @comments 
	 * @param valueMap
	 * @return
	 * @version 1.0
	 */
	public List<ScUsers> getUserList(Map<String, Object> valueMap) {
		Finder f = Finder.create("from ScUsers u ");
		
		//已启用
		f.append(" where u.enableState=:enableState").setParam("enableState", ((ParamConfigBean)StrutsUtil.getApplication().getAttribute("CONFIG_STATE")).getValueByCode("enable"));
		//审核通过
		f.append(" and u.verifyState=:verifyState").setParam("verifyState", ((ParamConfigBean)StrutsUtil.getApplication().getAttribute("VERIFY_STATE")).getValueByCode("verifypass"));
		//未删除
		f.append(" and u.deleteState=:deleteState").setParam("deleteState", ((ParamConfigBean)StrutsUtil.getApplication().getAttribute("DEL_STATE")).getValueByCode("enable"));
		//根据部门查询部门下用户
		String deptId = (String) valueMap.get("deptId");
		if(deptId!=null && deptId.length()>0){
			f.append(" and u.scDept.deptId=:deptId").setParam("deptId", deptId);
		}
		
		f.append(" order by u.userId desc");
		
		return super.find(f);
	}

}