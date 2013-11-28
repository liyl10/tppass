package com.hopsun.tppas.api.util;

import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import org.apache.log4j.Logger;
import org.springframework.web.context.support.WebApplicationContextUtils;
import com.hopsun.framework.util.Util;
import com.hopsun.tppas.entity.Mitem;
import com.hopsun.tppas.entity.Mtype;
import com.hopsun.tppas.api.superadmin.service.MitemService;
import com.hopsun.tppas.api.superadmin.service.MtypeService;
import com.hopsun.tppas.api.superadmin.service.TprojectTypeService;


/**
 *@comments 加载码表数据
 *@author wangxiaodong
 *@date 2013-5-22 下午1:18:13 
 *@version 1.0
 */
public final class LoadCacheUtil {
	
	public final static Logger LOGGER = Logger.getLogger(LoadCacheUtil.class.getName());
	
	private static LoadCacheUtil loadCacheUtil;
	
	private static ServletContext context;

	private LoadCacheUtil(){}
	
	public static LoadCacheUtil getInstance(){
		if(Util.checkNull(loadCacheUtil)){
			loadCacheUtil = new LoadCacheUtil();
		}
		return loadCacheUtil;
	}
	
	public static void setServletContext(final ServletContext context){
		LoadCacheUtil.context = context;
	}
	
	public static ServletContext getServletContext(){
		return LoadCacheUtil.context;
	}
	
	/**
	 * 加载码表数据
	 */
	public static void loadMitemDatas(ServletContext context) {
		final MitemService mitemService = (MitemService) WebApplicationContextUtils.getRequiredWebApplicationContext(context).getBean("apiMitemService");
		List<Mitem> all = mitemService.getMitemListInfo();
		if(all!=null&&all.size()>0){
			for(int i=0;i<all.size();i++){
				Mitem item = all.get(i);
				context.setAttribute(item.getItemId(), item);
			}
		}
	}
	
	/**
	 * @comments 通过类型加载各个类型下的码表数据
	 * @param context
	 * @version 1.0
	 */
	public static void loadMitemDatasByTypeId(ServletContext context){
		
		final MtypeService mtypeService = (MtypeService) WebApplicationContextUtils.getRequiredWebApplicationContext(context).getBean("apiMtypeService");
		final MitemService mitemService = (MitemService) WebApplicationContextUtils.getRequiredWebApplicationContext(context).getBean("apiMitemService");

		//得到所有类型 
		List<Mtype> typeList = mtypeService.getAll();
		if(typeList!=null&&typeList.size()>0){
			for(int i=0;i<typeList.size();i++){
				Mtype mtype = typeList.get(i);
				context.setAttribute(mtype.getTypeId(), mtype);
				List<Mitem> all = mitemService.loadListByTypeId(mtype.getTypeId());
				if(all!=null&&all.size()>0){
					context.setAttribute(mtype.getTypeId()+"typeId", all);
				}
			}
		}
	}
	
	/**
	 * @comments 通过类型加载各个类型下的码表数据
	 * @param context
	 * @version 1.0
	 */
	public static void loadMitemDatasByPitemId(ServletContext context){
		final MitemService mitemService = (MitemService) WebApplicationContextUtils.getRequiredWebApplicationContext(context).getBean("apiMitemService");
		//得到所有父ID
		List<Object> pitemIdList = mitemService.getAllPitemId();
		if(pitemIdList!=null&&pitemIdList.size()>0){
			for(int i=0;i<pitemIdList.size();i++){
				Object obj = pitemIdList.get(i);
				String pId = String.valueOf(obj);
				List<Mitem> all = mitemService.loadMitemListByPId(pId);
				if(all!=null&&all.size()>0){
					context.setAttribute(pId+"pId", all);
				}
			}
		}
	}
	
	/**
	 * @comments 加载所有的计划类别和对应的模板信息
	 * @param context
	 * @version 1.0
	 */
	public static void loadTprojectType(ServletContext context){
		final TprojectTypeService tprojectTypeService = (TprojectTypeService) WebApplicationContextUtils.getRequiredWebApplicationContext(context).getBean("apitprojectTypeService");
		Map<String,Object> all = tprojectTypeService.getAllProjectType();
		if(all!=null&&all.size()>0){
			for(Map.Entry<String,Object> entry : all.entrySet()) {
				context.setAttribute(entry.getKey(), entry.getValue());
			}
		}
	}
}
