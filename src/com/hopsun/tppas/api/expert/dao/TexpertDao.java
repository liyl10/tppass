/*************** 版权声明***************
*
* Copyright (C) 2012 西安辉盛科技发展有限责任公司.
*
********************************************
*/
package com.hopsun.tppas.api.expert.dao;

import java.util.List;
import java.util.Map;

import com.hopsun.framework.base.bean.Pager;
import com.hopsun.framework.base.dao.BaseDao;
import com.hopsun.tppas.entity.Mitem;
import com.hopsun.tppas.entity.Texpert;
import com.hopsun.tppas.entity.TgroupExpertRealtion;
/**
 * @comment 后台Dao接口-主要用来定义专家库操作的接口
 * @author yank
 * @DATE: 2013-08-19 @TIME: 下午2:09:37
 * @Vsersion: 1.0
 */
public interface TexpertDao extends BaseDao<Texpert, String>{
	
	// wanglw Start
	/**
	 * @comments 取得继续添加的专家列表
	 * @param param
	 * @return
	 * @Version 1.0
	 */
	public List<Texpert> getAddAuditList(Map<String, Object> param, List<TgroupExpertRealtion> tgList, List<Mitem> schoolingList);
	
	/**
	 * @comments 取得专家信息List
	 * @param property
	 * @return
	 * @Version 1.0
	 */
	public List<Object> getProPertyList(String property);
	
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
	 * @comments 取得专家评审统计导出List
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
	public Pager  queryExportByParams(Map<String, Object> param, int pageNo, int pageSize);
}
