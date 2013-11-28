/*************** 版权声明***************
*
* Copyright (C) 2012 西安辉盛科技发展有限责任公司.
*
********************************************
*/
package com.hopsun.tppas.api.statistics.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.hopsun.framework.base.bean.Pager;
import com.hopsun.framework.base.service.impl.BaseServiceImpl;
import com.hopsun.tppas.api.statistics.dao.StatisticsProjectIndustryDao;
import com.hopsun.tppas.api.statistics.service.StatisticsProjectIndustryService;
import com.hopsun.tppas.view.VprojectInfoAll;

/**
 * @comments 产业处项目统计
 * @author wanglw
 * @date 2013-11-13 @time 下午2:01:51
 * @Version 1.0
 */
@Service
public class StatisticsProjectIndustryServiceImpl extends BaseServiceImpl<VprojectInfoAll,String> implements StatisticsProjectIndustryService{

	@Resource
	private StatisticsProjectIndustryDao statisticsProjectIndustryDao;
	
	/**
	 * @comments 取得产业处项目列表
	 * @param param
	 * @param pageNo
	 * @param pageSize
	 * @return
	 * @Version 1.0
	 */
	public Pager getProjectList(Map<String, Object> param, int pageNo, int pageSize){
		
		return statisticsProjectIndustryDao.getProjectList(param, pageNo, pageSize);
	}
	
	
	/**
	 * @comments 取得列名
	 * @return
	 * @Version 1.0
	 */
	public List<Map<String, Object>> getColumnList(){
		List<Object> list = statisticsProjectIndustryDao.queryInfoBySql();
		
		List<Map<String, Object>> columnList = new ArrayList<Map<String, Object>>();
		
		if(list != null && list.size() >0){
			for(int i=0; i < list.size(); i++){
				Object [] obj = (Object [])list.get(i);
				Map<String, Object> map = new HashMap<String, Object>();
				map.put("columnId", obj[0]);
				map.put("columnName", obj[1]);
				columnList.add(map);
			}
		}
		return columnList;
	}
	
	/**
	 * @comments 取得需要导出的列名
	 * @return
	 * @Version 1.0
	 */
	public List<Object> getColumnName(String columnName){
		
		return statisticsProjectIndustryDao.getColumnName(columnName);
	}
	
	/**
	 * @comments 取得项目列表
	 * @param param
	 * @param columnName
	 * @return
	 * @Version 1.0
	 */
	public List<Object> getProjectList(Map<String, Object> param, String columnName){
		return statisticsProjectIndustryDao.getProjectList(param, columnName);
	}
}

