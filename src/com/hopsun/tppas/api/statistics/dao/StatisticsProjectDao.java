package com.hopsun.tppas.api.statistics.dao;

import java.util.List;
import java.util.Map;

import com.hopsun.framework.base.bean.Pager;
import com.hopsun.framework.base.dao.BaseDao;
import com.hopsun.tppas.view.VprojectInfoAll;
/**
 * @Comments:   后台Dao接口-主要用来定义项目统计操作的接口
 * @author  lihf
 * @date 2013-08-01
 * @version 1.0
 *
 */

public interface StatisticsProjectDao extends BaseDao<VprojectInfoAll, String>{
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
	public List<Object> getTableInfo(Object[] params);
	
    /**
     * @comments 查询信息
     * @param hql
     * @return
     * @Version 1.0
     */
    public List<Object> queryListinfo(Map<String, Object> param);
	
}
