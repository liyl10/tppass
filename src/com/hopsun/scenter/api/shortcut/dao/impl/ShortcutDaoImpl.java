/************************* 版权声明 *********************************
 *
 * Copyright (C) 2012 西安辉盛科技发展有限责任公司.
 *
 ******************************************************************
 */

package com.hopsun.scenter.api.shortcut.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.hopsun.framework.base.bean.Finder;
import com.hopsun.framework.base.bean.Pager;
import com.hopsun.framework.base.dao.impl.BaseDaoImpl;
import com.hopsun.framework.util.StrutsUtil;
import com.hopsun.scenter.api.shortcut.dao.ShortcutDao;
import com.hopsun.scenter.entity.ScShortcut;
import com.hopsun.scenter.entity.ScUsers;
import com.hopsun.subgroups.paramconfig.bean.ParamConfigBean;

/**
 * @Comments:   Dao实现类 - 快捷方式管理管理，该实现从BaseDaoImpl继承，具备基础的持久化操作的所有方法，相对复杂的业务sql需要在实现中编写
 * @author dulei(dulei@hopsun.cn)
 * @date 2013-01-04 下午03:07:32
 * @version 1.0
 *
 */
@Repository
@SuppressWarnings("unchecked")
public class ShortcutDaoImpl extends BaseDaoImpl<ScShortcut, String> implements ShortcutDao {

	/**
	 * 根据用户、权限id查询用户是否有该快捷方式
	 * @param user authid
	 * @return boolean
	 */
	public boolean getShortcutByUserAuthid(ScUsers user,String authid){
		
		List<ScShortcut> list = new ArrayList<ScShortcut>();
		//查询sql
		String hql = "select s from ScShortcut s where s.scUsers.userId=? and s.scAuth.authId=?";
		//查询
		list = this.createQueryList(hql,  user.getUserId(), authid);
		
		return list.size()>0?true:false;
	}
	
	/**
	 * 根据用户、权限id查询该快捷方式
	 * @param user authid
	 * @return ScShortcut
	 */
	public ScShortcut getShortcutByUserAndAuthid(ScUsers user, String authid) {
		
		//sql
		Finder f = Finder.create("from ScShortcut s where s.scUsers.userId=:userId and s.scAuth.authId=:authId");
		f.setParam("userId", user.getUserId());
		f.setParam("authId", authid);
		//未删除的权限
		f.append(" and s.scAuth.deleteState=:deleteState");
		f.setParam("deleteState",((ParamConfigBean) StrutsUtil.getApplication().getAttribute("DEL_STATE")).getBeansByCode("enable").getValue());
		
		//查询
		List<ScShortcut> list = super.find(f);
		
		return list.size()>0?list.get(0):null;
	}
	
	/**
	 * 分页查询
	 *@param scShortcut user pageNo pageSize
	 *@return Pager
	 *
	 */
	public Pager find(ScShortcut scShortcut,ScUsers user, int pageNo, int pageSize) {
		
		//未删除
		String deleteState = ((ParamConfigBean) StrutsUtil.getApplication().getAttribute("DEL_STATE")).getBeansByCode("enable").getValue();
		//已启用
		String enableState = ((ParamConfigBean)StrutsUtil.getApplication().getAttribute("CONFIG_STATE")).getValueByCode("enable");
		//审核通过
		String verifyState = ((ParamConfigBean)StrutsUtil.getApplication().getAttribute("VERIFY_STATE")).getValueByCode("verifypass");
		
		//创建finder sql
		//设置参数
		//查询出用户的所有权限
		Finder f = Finder.create("select s from ScAuth as a ");
		f.append(" left join a.scShortcuts as s where s.scUsers.userId=:suserId ").setParam("suserId", user.getUserId());
		
		if(null != user.getScUsersesForParentUserId() && user.getScUsersesForParentUserId().size()>0){
			f.append("and a.authId in ( select a from ScUsers as u left join u.scRoles as r left join r.scAuths as a where ");
			f.append("u.userId=:userId ").setParam("userId", user.getUserId());
			f.append("and r.deleteState=:rdeleteState ").setParam("rdeleteState", deleteState);
			f.append("and r.enableState=:renableState ").setParam("renableState", enableState);
			f.append("and r.verifyState=:rverifyState )").setParam("rverifyState", verifyState);
		}
			
		f.append("and a.deleteState=:adeleteState ").setParam("adeleteState", deleteState);
		f.append("and a.enableState=:aenableState ").setParam("aenableState", enableState);
		f.append("and a.verifyState=:averifyState ").setParam("averifyState", verifyState);
		
		//查询条件
		if(null != scShortcut && null != scShortcut.getScAuth() && null != scShortcut.getScAuth().getAuthName() && !("").equals(scShortcut.getScAuth().getAuthName())){
			f.append(" and lower(a.authName) like lower(:authName)").setParam("authName", "%"+scShortcut.getScAuth().getAuthName().trim()+"%");
		}
		//排序
		f.append(" order by s.shorOrder desc,s.shorId desc");
		//查询返回
		return super.find(f, pageNo, pageSize);
	}

}