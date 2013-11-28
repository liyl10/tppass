package com.hopsun.tppas.api.report.service;

import java.util.List;
import java.util.Map;

import com.hopsun.framework.base.bean.Pager;
import com.hopsun.framework.base.service.BaseService;
import com.hopsun.tppas.entity.Mitem;
import com.hopsun.tppas.entity.Tplan;
import com.hopsun.tppas.entity.TprojectApplication;
/**
 * @comments 分计划管理
 * @author wanglw
 * @date 2013-10-9 @time 上午9:27:05
 * @Version 1.0
 */
public interface TplanManageService extends BaseService<Tplan, String> {
	
	/**
	 * @comments 取得分计划List
	 * @param param
	 * @param pageNo
	 * @param pageSize
	 * @return
	 * @Version 1.0
	 */
	public Pager getPlanList(Map<String, Object> param, int pageNo, int pageSize);
	
	/**
	 * @comments 保存分计划 
	 * @param tplan
	 * @return
	 * @Version 1.0
	 */
	public String savePlan(Tplan tplan);
	
	/**
	 * @comments 取得已创建的批次
	 * @param deptId
	 * @param ownFlag
	 * @return
	 * @Version 1.0
	 */
	public List<Mitem> getSelectedBatch(String deptId, String planId);
	
	/**
	 * 
	 * @comments 
	 * @Version 1.0
	 */
	public void saveSelectedProject(String planId, String selectProjectIds);
	
	/**
	 * @comments 删除分计划及更新所包含项目的选择状态
	 * @param planId
	 * @Version 1.0
	 */
	public void deletePlan(String planId);
	
	/**
	 * @comments 提交分计划
	 * @param tplan
	 * @param proList
	 * @Version 1.0
	 */
	public void savePlan(Tplan tplan, List<TprojectApplication> proList);
}
