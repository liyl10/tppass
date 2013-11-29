package com.hopsun.tppas.api.query.service;

import java.util.Map;

import com.hopsun.framework.base.bean.Pager;
import com.hopsun.framework.base.service.BaseService;
import com.hopsun.tppas.view.VprojectInfoAll;
/**
 * @Comments:   后台Service接口-主要用来定义项目申报操作的接口
 * @author  yk
 * @date 2013-08-01
 * @version 1.0
 *
 */
public interface ProjectQueryService extends BaseService<VprojectInfoAll, String> {
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
