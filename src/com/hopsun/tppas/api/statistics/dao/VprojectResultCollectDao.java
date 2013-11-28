/*************** 版权声明***************
*
* Copyright (C) 2012 西安辉盛科技发展有限责任公司.
*
********************************************
*/
package com.hopsun.tppas.api.statistics.dao;

import java.util.List;
import java.util.Map;

import com.hopsun.framework.base.bean.Pager;
import com.hopsun.framework.base.dao.BaseDao;
import com.hopsun.tppas.view.VprojectResultCollect;

/**
 * 
 *@comments 项目结果汇总Dao接口
 *@author liyilin
 *@date 2013-8-22
 *@version 1.0
 */
public interface VprojectResultCollectDao extends BaseDao<VprojectResultCollect, String> {

	/**
	 * @comments 分页查询
	 * @param hql
	 * @param pageNo
	 * @param pageSize
	 * @return
	 * @Version 1.0
	 */
	public Pager find(String hql, int pageNo, int pageSize);
	
	/**
	 * @comments 分页查询
	 * @param param
	 * @param pageNo
	 * @param pageSize
	 * @return
	 * @Version 1.0
	 */
	public Pager find(Map<String, Object> param, int pageNo, int pageSize);
	
	
	/**
     * @comments 通过SQL语句查询信息
     * @param sql
     * @param params
     * @return
     * @Version 1.0
     */
    public List<Object> queryInfoBySql(Object[] params);
    
    /**
     * @comments 查询信息
     * @param hql
     * @return
     * @Version 1.0
     */
    public List<Object> queryListinfo(String hql);

    /**
     * 
     * @comments 取得视图中存在的申报年度 
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
	public List<VprojectResultCollect> getAllResultData(Map<String, Object> params);

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
	 * @comments 取得业务部门的部门idList
	 * @param params
	 * @return
	 * @version 1.0
	 */
	public List<String> getDeptList(Map<String, Object> params);

	/**
	 * 
	 * @comments 取得业务部门的部门下计划类别List
	 * @param params
	 * @return
	 * @version 1.0
	 */
	public List<String> getProjectTypeListByDeptId(Map<String, Object> params);
}
