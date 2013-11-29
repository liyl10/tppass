/*************** 版权声明***************
*
* Copyright (C) 2012 西安辉盛科技发展有限责任公司.
*
********************************************
*/
package com.hopsun.tppas.api.expert.service;

import java.util.List;
import java.util.Map;

import com.hopsun.framework.base.bean.Pager;
import com.hopsun.framework.base.service.BaseService;
import com.hopsun.scenter.entity.ScUsers;
import com.hopsun.tppas.entity.Texpert;
/**
 * @comment 后台service接口类-主要用来定义专家库操作的接口
 * @author yank
 * @DATE: 2013-08-19 @TIME: 下午2:09:37
 * @Vsersion: 1.0
 */
public interface TexpertService extends BaseService<Texpert, String> {
	
	// wanglw Start
	/**
	 * @comments 取得继续添加的专家列表
	 * @param param
	 * @return
	 * @Version 1.0
	 */
	public List<Texpert> getAddAuditList(Map<String, Object> param);
	
	/**
	 * @comments 取得专家毕业院校集合
	 * @return
	 * @Version 1.0
	 */
	public List<Map<String, Object>> getGraduatedList(String showName, String property);
	
	/**
	 * @comments 新增专家
	 * @param expert
	 * @param userId
	 * @Version 1.0
	 */
	public void saveAuditExpert(Texpert expert, String userId);
	
	/**
	 * @comments 取得继续添加的专家列表(批量)
	 * @param param
	 * @return
	 * @Version 1.0
	 */
	public List<Texpert> getBatchAddAuditList(Map<String, Object> param);
	
	
	/**
	 * @comments 取得专家评审统计List
	 * @param param
	 * @param pageNo
	 * @param pageSize
	 * @return
	 * @Version 1.0
	 */
	public Pager getExpertStatisticList(Map<String, Object> param, int pageNo, int pageSize);
	
	/**
	 * @comments 取得专家评审统计List
	 * @param param
	 * @param pageNo
	 * @param pageSize
	 * @return
	 * @Version 1.0
	 */
	public List<Texpert> getExpertExportList(Map<String, Object> param);
	
	// wanglw End
	
	/**
	 * @comments 获取专家库信息
	 * @param param
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	public Pager queryExportByParams(Map<String, Object> param, int pageNo,int pageSize);
	
	/**
	 * 保存专家基本信息
	 * @comments 
	 * @param texpert
	 * @param user
	 * @version 1.0
	 */
	public void saveOrUpdate(Texpert texpert, ScUsers user);
	
	
	/**
	 * 删除专家信息
	 * @comments 
	 * @param expertId
	 * @version 1.0
	 */
	public void deleteExpert(String expertId);
	
}
