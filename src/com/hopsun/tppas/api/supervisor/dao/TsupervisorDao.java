/*************** 版权声明***************
*
* Copyright (C) 2012 西安辉盛科技发展有限责任公司.
*
********************************************
*/
package com.hopsun.tppas.api.supervisor.dao;

import java.util.List;
import java.util.Map;

import com.hopsun.tppas.entity.Tsupervisor;
import com.hopsun.framework.base.bean.Pager;
import com.hopsun.framework.base.dao.BaseDao;
/**
 * @Comments:   后台Dao接口-主要用来定义项目监理操作的接口
 * @author  yk
 * @date 2013-08-09
 * @version 1.0
 *
 */
public interface TsupervisorDao extends BaseDao<Tsupervisor, String>{
	/**
	 * 查询待监理项目
	 * @param supervisorState
	 * @return
	 */
	public List<Tsupervisor> queryTsupervisorByState(String supervisorState);
	
	/**
	 * 项目监理列表
	 * @comments 
	 * @param param
	 * @param pageNo
	 * @param pageSize
	 * @return
	 * @version 1.0
	 */
	public Pager supervisorList(Map<String, Object> param, int pageNo,int pageSize);
}
