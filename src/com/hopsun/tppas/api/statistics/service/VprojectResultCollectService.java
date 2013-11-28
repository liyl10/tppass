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
import com.hopsun.tppas.view.VprojectResultCollect;

/**
 * 
 *@comments 项目结果汇总service接口
 *@author liyilin
 *@date 2013-8-22
 *@version 1.0
 */
public interface VprojectResultCollectService extends BaseService<VprojectResultCollect, String> {
	
	/**
	 * @comments 分页查询
	 * @param proId
	 * @param pageNo
	 * @param pageSize
	 * @return
	 * @Version 1.0
	 */
	public Pager find(Map<String,Object> param,int pageNo, int pageSize);
	
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

	/**
	 * 
	 * @comments 取得视图中的申报年度 
	 * @return
	 * @version 1.0
	 */
	public List<String> getReportYearList();

	/**
	 * 
	 * @comments 根据检索条件取得所有的查询结果
	 * @param params
	 * @return
	 * @version 1.0
	 */
	public Map<String, List<VprojectResultCollect>> getAllResultData(Map<String, Object> params);

	/**
	 * 
	 * @comments 查询条件只选择了一级项目分类时，查询该一级分类下的子分类个数 
	 * @param params
	 * @return
	 * @version 1.0
	 */
	public int getGroupCount(Map<String, Object> params);

	/**
	 * 
	 * @comments 查询子分类id
	 * @param params
	 * @return
	 * @version 1.0
	 */
	public List<String> getGroupInfo(Map<String, Object> params);

	/**
	 * 
	 * @comments 查询业务处部门ID
	 * @param params
	 * @return
	 * @version 1.0
	 */
	public List<String> getDeptList(Map<String, Object> params);
	/**
	 * 
	 * @comments 查询业务处部门下的计划类别
	 * @param params
	 * @return
	 * @version 1.0
	 */
	public List<String> getProjectTypeListByDeptId(Map<String, Object> params);
	
}
