/**
 * @filename HcspResource.java
 * @author zzze
 * @date Dec 27, 2012
 * @vsersion 1.0
 * Copyright (C) 2012 辉盛科技发展责任有限公司
 */
package com.hopsun.subgroups.paramconfig.util;

/**
 * @description 系统资源类
 * @author zzze
 * @date 2012-7-25
 * @version 1.0
 * 
 */
public final class HcspResource {
	//系统参数-参数CODE实时验证成功提示
	public static final String VALID_SCENTER_CONFIG_PARAMCODE_SUCESS;
	//系统参数-参数CODE实时验证失败提示
	public static final String VALID_SCENTER_CONFIG_PARAMCODE_FAILURE;
	
	//角色管理-角色验证验证提示，角色名称是否存在
	public static final String VALID_SCENTER_ROLE_ROLENAME_EXSIT;
 
	
	static{
		//系统参数-参数CODE实时验证成功提示赋值
		VALID_SCENTER_CONFIG_PARAMCODE_SUCESS=String.valueOf(ParamConfigUtil.getServletContext().getAttribute("validform.scenter.config.paramCode.success"));
		//系统参数-参数CODE实时验证失败提示赋值
		VALID_SCENTER_CONFIG_PARAMCODE_FAILURE=String.valueOf(ParamConfigUtil.getServletContext().getAttribute("validform.scenter.config.paramCode.failure"));
		//角色管理-角色验证验证提示，角色名称是否存在赋值
		VALID_SCENTER_ROLE_ROLENAME_EXSIT=String.valueOf(ParamConfigUtil.getServletContext().getAttribute("validform.scenter.role.roleName.exsit"));
	}
}
