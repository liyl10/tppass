/**
 * @filename ConfigManageAction.java
 * @author zzze
 * @date Dec 27, 2012
 * @vsersion 1.0
 * Copyright (C) 2012 辉盛科技发展责任有限公司
 */
package com.hopsun.subgroups.paramconfig.action;


import java.io.IOException;
import java.util.Date;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;

import com.hopsun.framework.base.action.BaseAction;
import com.hopsun.framework.base.bean.Pager;
import com.hopsun.framework.util.StrutsUtil;
import com.hopsun.framework.util.Util;
import com.hopsun.subgroups.entity.UcParamConfig;
import com.hopsun.subgroups.logs.util.RequestUtil;
import com.hopsun.subgroups.paramconfig.service.ConfigService;
import com.hopsun.subgroups.paramconfig.util.HcspResource;
import com.hopsun.subgroups.paramconfig.util.ParamConfigUtil;
/**
 *@comment 系统参数配置管理类 
 *@author zzze
 *@date Dec 27, 2012
 *@version 1.0
 */
@Scope("prototype")
public class ConfigAction extends BaseAction{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public String param;//用于接收ajax传入的参数
	@Resource
	public transient ConfigService configService;
	public UcParamConfig config;
	public boolean exist;
	/**
	 * @comment 获取配置清单 
	 * @return
	 * @version: 1.0
	 */
	public String list(){
		if(Util.checkNull(pager)){
			pager = new Pager();
		}
		pager = configService.list(pager, config);
		this.setRedirectUrl(this.getRequest().getRequestURL().toString());
		return "list";
	}
	/**
	 * @comment 跳转到添加页 
	 * @return
	 * @version: 1.0
	 */
	public String goInsert(){
		//初始化系统参数配置
//		ParamConfigUtil.getParamConfigUtil().setConfigService(configService);
//		ParamConfigUtil.getParamConfigUtil().loadConfigXML("E:/softDev/apache-tomcat-6.0.24/webapps/root/resource/template/type_config.xml");
		return "goInsert";
	}
	/**
	 * @comment 配置添加方法 
	 * @return
	 * @version: 1.0
	 */
	public String insert(){
		config.setCreateDate(new Date());
//		config.setCreateUserName(((UcActInfo)RequestUtil.getRequest().getSession().getAttribute("member")).getUserCode());
		config.setModifyDate(new Date());
//		config.setModifyUserName(((UcActInfo)RequestUtil.getRequest().getSession().getAttribute("member")).getUserCode());
		config.setParamSource(ParamConfigUtil.getBeans("SOURCE","SCenter").getDesc());
		configService.save(config);
		//更新缓存中的配置
		ParamConfigUtil.loadConfigs(StrutsUtil.getApplication());
		return BaseAction.SUCCESS;
	}
	/**
	 * @comment 跳转到修改页 
	 * @return
	 * @version: 1.0
	 */
	public String goModify(){
		config = configService.get(config.getParamId());
		return "goModify";
	}
	/**
	 * @comment 修改方法 
	 * @return
	 * @version: 1.0
	 */
	public String modify(){
		config.setModifyDate(new Date());
//		config.setModifyUserName(((UcActInfo)RequestUtil.getRequest().getSession().getAttribute("member")).getUserCode());
		configService.update(config);
		//更新缓存中的配置
		ParamConfigUtil.loadConfigs(StrutsUtil.getApplication());
		return BaseAction.SUCCESS;
	}
	/**
	 * @comment 跳转到查看页 
	 * @return
	 * @version: 1.0
	 */
	public String goDetail(){
		config = configService.get(config.getParamId());
		return "goDetail";
	}
	/**
	 * @comment 删除方法 
	 * @return
	 * @version: 1.0
	 */
	public String delete(){
		for(String id : ids){
			config = configService.get(id);
			configService.delete(config);
		}
		//更新缓存中的配置
		ParamConfigUtil.loadConfigs(StrutsUtil.getApplication());
		return BaseAction.SUCCESS;
	}
	
	/**
	 * @comment 检查代码是否存在 
	 * @return
	 * @version: 1.0
	 */
	public String check(){
		exist = configService.getList("paramCode", param).size()>0;
		try {
			if(exist){
				System.out.println(HcspResource.VALID_SCENTER_CONFIG_PARAMCODE_FAILURE);
				RequestUtil.getResponse().getWriter().write("{\"info\":\""+HcspResource.VALID_SCENTER_CONFIG_PARAMCODE_FAILURE+"\",\"status\":\"n\"}");
			}else{
				RequestUtil.getResponse().getWriter().write("{\"info\":\""+HcspResource.VALID_SCENTER_CONFIG_PARAMCODE_SUCESS+"\",\"status\":\"y\"}");
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public boolean isExist() {
		return exist;
	}
	public void setExist(final boolean exist) {
		this.exist = exist;
	}
	public UcParamConfig getConfig() {
		return config;
	}
	public void setConfig(final UcParamConfig config) {
		this.config = config;
	}
	public String getParam() {
		return param;
	}
	public void setParam(String param) {
		this.param = param;
	}
}
