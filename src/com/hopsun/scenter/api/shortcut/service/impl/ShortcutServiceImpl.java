/************************* 版权声明 *********************************
 *
 * Copyright (C) 2012 西安辉盛科技发展有限责任公司.
 *
 ******************************************************************
 */

package com.hopsun.scenter.api.shortcut.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.hopsun.framework.base.bean.Pager;
import com.hopsun.framework.base.service.impl.BaseServiceImpl;
import com.hopsun.scenter.api.shortcut.dao.ShortcutDao;
import com.hopsun.scenter.api.shortcut.service.ShortcutService;
import com.hopsun.scenter.entity.ScShortcut;
import com.hopsun.scenter.entity.ScUsers;

/**
 * @Comments:   service接口实现- 快捷方式管理
 * @author dulei(dulei@hopsun.cn)
 * @date 2013-01-04 下午03:05:32
 * @version 1.0
 *
 */
@Service
public class ShortcutServiceImpl extends BaseServiceImpl<ScShortcut, String> implements ShortcutService {

	@Resource
	private ShortcutDao shortcutDao;
	
	@Resource
	public void setBaseDao(ShortcutDao shortcutDao) {
		super.setBaseDao(shortcutDao);
	}
	
	/**
	 * 根据用户、权限id查询用户是否有该快捷方式
	 * @param user authid
	 * @return boolean
	 */
	public boolean getShortcutByUserAuthid(ScUsers user,String authid){
		return shortcutDao.getShortcutByUserAuthid(user, authid);
	}
	
	/**
	 * 根据用户、权限id查询该快捷方式
	 * @param user authid
	 * @return ScShortcut
	 */
	public ScShortcut getShortcutByUserAndAuthid(ScUsers user, String authid) {
		return shortcutDao.getShortcutByUserAndAuthid(user, authid);
	}

	/**
	 * 分页查询
	 *@param scShortcut user pageNo pageSize
	 *@return Pager
	 *
	 */
	public Pager find(ScShortcut scShortcut,ScUsers user, int pageNo, int pageSize) {
		return shortcutDao.find(scShortcut, user, pageNo, pageSize);
	}
	
}