package com.hopsun.tppas.api.statistics.service;

import java.util.List;
import java.util.Map;

import com.hopsun.framework.base.bean.Pager;
import com.hopsun.framework.base.service.BaseService;
import com.hopsun.tppas.view.VprojectInfoAll;
/**
 * @Comments:   后台Service接口-主要用来定义项目统计操作的接口
 * @author  lihf
 * @date 2013-08-01
 * @version 1.0
 *
 */
public interface StatisticsProjectService extends BaseService<VprojectInfoAll, String> {
	/**
	 * @comments 项目查询
	 * @param param
	 * @param pageNo
	 * @param pageSize
	 * @return
	 * @Version 1.0
	 */
	public Pager queryProjectInfo(Map<String, Object> param, int pageNo, int pageSize);
	
	/**
	 * @comments 取得表的属性
	 * @param tableName
	 * @return
	 * @Version 1.0
	 */
	public List<Object> getTableInfo(String[] tableName);
	
	/**
	 * @comments 取得导出数据
	 * @param param
	 * @return
	 * @Version 1.0
	 */
	public List<Object> getExportDatas(Map<String,Object> param);

}
