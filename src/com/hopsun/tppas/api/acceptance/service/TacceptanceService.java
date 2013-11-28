package com.hopsun.tppas.api.acceptance.service;

import java.util.List;
import java.util.Map;

import com.hopsun.tppas.entity.Tacceptance;
import com.hopsun.framework.base.bean.Pager;
import com.hopsun.framework.base.service.BaseService;

public interface TacceptanceService extends BaseService<Tacceptance, String> {

	/**
	 * 
	 * @comments 查询验收项目一览
	 * @param param
	 * @param pageNumber
	 * @param pageSize
	 * @return
	 * @version 1.0
	 */
	Pager find(Map<String, Object> param, Integer pageNumber, Integer pageSize);
	
	/**
	 * 查询待验收项目
	 * @param acceptanceStatus
	 * @return
	 */
	public List<Tacceptance> queryTacceptanceByState(String acceptanceStatus);
	
	/**
	 * 根据项目ID查询项目验收管理信息
	 *@param acceptanceId
	 *@return Tacceptance
	 */
	public Tacceptance getTacceptanceById(String acceptanceId);
	
	
	/**
	 * @comments 高新处验收提交材料集合
	 * @param acceptanceId
	 * @return
	 * @Version 1.0
	 */
	public List<Map<String,Object>> getSubmitHighTechAcceptanceList(String acceptanceId);
	
	/**
	 * @comments 提交高新处验收
	 * @param submitFlag 
	 * @param acceptanceId
	 * @Version 1.0
	 */
	public void saveSubmitHighTechAcceptance(String submitFlag, String acceptanceId);
	
	/**
	 * @comments 打印高新处验收
	 * @param inputPath
	 * @param outputPash 
	 * @param acceptanceId
	 * @Version 1.0
	 */
	public String printHighTechAcceptance(String inputPath,String outputPash,String acceptanceId);
	
	/**
	 * @comments 非高新验收提交材料集合
	 * @param acceptanceId
	 * @return
	 * @Version 1.0
	 */
	public List<Map<String,Object>> getSubmitOtherAcceptanceList(String acceptanceId);
	
	/**
	 * @comments 提交非高新验收
	 * @param submitFlag 
	 * @param acceptanceId
	 * @Version 1.0
	 */
	public void saveSubmitOtherAcceptance(String submitFlag,String acceptanceId);
	
	/**
	 * @comments 打印非高新验收
	 * @param inputPath
	 * @param outputPash 
	 * @param acceptanceId
	 * @Version 1.0
	 */
	public String printOtherAcceptance(String inputPath,String outputPash,String acceptanceId);
}
