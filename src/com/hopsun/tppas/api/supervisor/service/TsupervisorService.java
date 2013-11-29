/*************** 版权声明***************
*
* Copyright (C) 2012 西安辉盛科技发展有限责任公司.
*
********************************************
*/
package com.hopsun.tppas.api.supervisor.service;

import java.util.List;
import java.util.Map;

import com.hopsun.tppas.entity.Tsupervisor;
import com.hopsun.framework.base.bean.Pager;
import com.hopsun.framework.base.service.BaseService;

/**
 * 项目监理
 *@comments
 *@author wxd
 *@date 2013-9-17
 *@version 1.0
 */
public interface TsupervisorService extends BaseService<Tsupervisor, String> {
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
	
	/**
	 * 
	 * @comments 得到其他项目监理提交信息列表 
	 * @param supervisorId
	 * @return
	 * @version 1.0
	 */
	public List<Map<String,Object>> getOtherSubmitInfoList(String supervisorId);
	
	/**
	 * 其它类监理申请提交
	 * @comments 
	 * @param pdfInputPath
	 * @param pdfOutputPath
	 * @param supervisorId
	 * @param companyId
	 * @version 1.0
	 */
	public void saveOtherSupervisor(String pdfInputPath,String pdfOutputPath,String supervisorId,String companyId);
	
	/**
	 * 项目监理申请审批
	 * @comments 
	 * @param valueMap
	 * @version 1.0
	 */
	public void saveSupervisorAudit(Map<String,Object> valueMap);
	
	/**
	 * 
	 * @comments 创建高新处PDF
	 * @param templatePath
	 * @param storagePath
	 * @param supervisorId
	 * @return
	 * @version 1.0
	 */
	public String creatPdf(String templatePath, String storagePath, String supervisorId);
}
