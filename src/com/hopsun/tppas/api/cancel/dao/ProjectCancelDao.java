package com.hopsun.tppas.api.cancel.dao;

import java.util.Map;

import com.hopsun.framework.base.bean.Pager;
import com.hopsun.framework.base.dao.BaseDao;
import com.hopsun.tppas.view.VprojectInfoAll;
/**
 * @Comments:   后台Dao接口-主要用来定义项目撤销操作的接口
 * @author  yk
 * @date 2013-08-01
 * @version 1.0
 *
 */

public interface ProjectCancelDao extends BaseDao<VprojectInfoAll, String>{
	/**
	 * @comments 项目查询
	 * @param param
	 * @param pageNo
	 * @param pageSize
	 * @return
	 * @Version 1.0
	 */
	public Pager queryProjectInfo(Map<String, Object> param, int pageNo, int pageSize);
	
}
