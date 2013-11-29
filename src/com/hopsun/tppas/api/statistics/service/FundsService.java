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
import com.hopsun.tppas.entity.TappropriationSingle;

/**
 * 
 *@comments 项目结果汇总service接口
 *@author liyilin
 *@date 2013-8-22
 *@version 1.0
 */
public interface FundsService extends BaseService<TappropriationSingle, String> {
	
	/**
	 * @comments 分页查询
	 * @param proId
	 * @param pageNo
	 * @param pageSize
	 * @return
	 * @Version 1.0
	 */
	public Pager find(Map<String,Object> param,int pageNo, int pageSize,String deptId,Boolean isPlanningDept);
	
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
	public List<Object> getExportDatas(Map<String,Object> param,String deptId,Boolean isPlanningDept);
	
	/**
	 * 
	 * @comments 查询业务处部门下的计划类别
	 * @param params
	 * @return
	 * @version 1.0
	 */
	public List<String> getProjectTypeListByDeptId(Map<String, Object> params,String deptId);
	
	/**
	 * 查询处室
	 * @comments 
	 * @param params
	 * @return
	 * @version 1.0
	 */
	public List<String> getDeptList(Map<String, Object> params);
	
	/**
	 * 查询子分类
	 * @comments 
	 * @param params
	 * @return
	 * @version 1.0
	 */
	public List<String> getGroupInfo(Map<String, Object> params,String deptId);
	
	/**
	 * @comments 取得导出数据
	 * @param param
	 * @return
	 * @Version 1.0
	 */
	public Map<String, List<TappropriationSingle>> getAllResultData(Map<String,Object> param,String deptId,Boolean isPlanningDept);
	
}
