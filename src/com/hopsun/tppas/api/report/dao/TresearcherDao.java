package com.hopsun.tppas.api.report.dao;

import java.util.List;

import com.hopsun.tppas.entity.Tresearcher;
import com.hopsun.framework.base.bean.Pager;
import com.hopsun.framework.base.dao.BaseDao;

public interface TresearcherDao extends BaseDao<Tresearcher, String>{
	/**
	 * @Comments 分页查询
	 * @param projectId
	 * @param pageNo
	 * @param pageSize
	 * @return
	 * @Vsersion: 1.0
	 */
	public Pager find(String projectId,int pageNo, int pageSize);
	
	/**
	 * @comments 查询有效研究人员
	 * @param projectId
	 * @return
	 * @version 1.0
	 */
	public List<Tresearcher> getValidTresearchers(String projectId);
}
