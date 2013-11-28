/************************* 版权声明 *********************************
 *
 * Copyright (C) 2012 西安辉盛科技发展有限责任公司.
 *
 ******************************************************************
 */
package com.hopsun.scenter.api.util;
/**
 * 常量配置
 * @author app_2006
 *
 */

public class Constant {
	/**
	 * 审核通过
	 */
	public static final String VERIFY_STATE_TRUE = "1";
	/**
	 * 审核不通过
	 */
	public static final String VERIFY_STATE_FALASE = "2";
	/**
	 * 审核中
	 */
	public static final String VERIFY_STATE_ONGOING = "0";
	/**
	 * 账号未激活
	 */
	public static final String IS_ACTIVE_FALASE = "0";
	/**
	 * 账号已激活
	 */
	public static final String IS_ACTIVE_TRUE = "1";
	/**
	 * 删除状态，已删除
	 */
	public static final String DELETE_STATE_TRUE = "1";
	/**
	 * 删除状态，未删除
	 */
	public static final String DELETE_STATE_FALSE = "0";
	/**
	 * 启用状态，启用
	 */
	public static final String ENABLE_STATE_TRUE="1";
	/**
	 * 启用状态，禁用
	 */
	public static final String ENABLE_STATE_FALSE="0";
	/**
	 * 权限删除方式，1：若存在子权限，则不能删除；不为1则删除所有子权限
	 */
	public static final String AUTH_DELETE_TYPE="2";
	/**
	 * 角色类型--全局可见
	 */
	public static final String ROLE_TYPE_GLOBE="1";
	/**
	 * 角色类型--上级可见
	 */
	public static final String ROLE_TYPE_PARNET="2";
	/**
	 * 角色类型--自己可见
	 */
	public static final String ROLE_TYPE_SELF="3";

}
