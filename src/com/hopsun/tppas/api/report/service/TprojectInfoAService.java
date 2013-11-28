package com.hopsun.tppas.api.report.service;

import java.util.List;

import com.hopsun.tppas.entity.TprojectInfoA;
import com.hopsun.framework.base.service.BaseService;

public interface TprojectInfoAService extends BaseService<TprojectInfoA, String> {
	/**
	 * 根据项目ID查询项目基本信息表表
	 *@param projectId
	 *@return List
	 */
	public List<TprojectInfoA> getTprojectInfoAById(String projectId);
}
