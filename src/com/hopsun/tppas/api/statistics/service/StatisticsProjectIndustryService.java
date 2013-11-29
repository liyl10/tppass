/*************** 版权声明***************
*
* Copyright (C) 2012 西安辉盛科技发展有限责任公司.
*
********************************************
*/
package com.hopsun.tppas.api.statistics.service;

import java.util.List;
import java.util.Map;

import com.hopsun.framework.base.bean.Pager;
import com.hopsun.framework.base.service.BaseService;
import com.hopsun.tppas.view.VprojectInfoAll;

/**
 * @comments 产业处项目统计
 * @author wanglw
 * @date 2013-11-13 @time 下午2:02:00
 * @Version 1.0
 */
public interface StatisticsProjectIndustryService extends BaseService<VprojectInfoAll, String> {

	/**
	 * @comments 取得产业处项目列表
	 * @param param
	 * @param pageNo
	 * @param pageSize
	 * @return
	 * @Version 1.0
	 */
	public Pager getProjectList(Map<String, Object> param, int pageNo, int pageSize);
	
	/**
	 * @comments 取得列名
	 * @return
	 * @Version 1.0
	 */
	public List<Map<String, Object>> getColumnList();
	
	/**
	 * @comments 取得需要导出的列名
	 * @return
	 * @Version 1.0
	 */
	public List<Object> getColumnName(String columnName);
	
	/**
	 * @comments 取得项目列表
	 * @param param
	 * @param columnName
	 * @return
	 * @Version 1.0
	 */
	public List<Object> getProjectList(Map<String, Object> param, String columnName);
}

