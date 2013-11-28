package com.hopsun.tppas.api.contract.service;

import java.util.List;
import java.util.Map;

import com.hopsun.framework.base.service.BaseService;
import com.hopsun.tppas.entity.Tcontract;
/**
 * 
 * @comments 合同管理
 * @author Leo
 * @date 2013-8-2
 * @version 1.0
 */
public interface TcontractHighTechService extends BaseService<Tcontract, String> {

    /**
     * 获取合同管理表信息
     * @comments 
     * @param TcontractId
     * @return
     * @version 1.0
     */
    public Tcontract getTcontract(String TcontractId);
    
	/**
	 * 
	 * @comments 更新合同状态
	 * @param TcontractId
	 * @return
	 * @version 1.0
	 */
    public void updateStatus(String tcontractId,String userId);    
	
	/**
	 * 
	 * @comments 合同提交时得到材料列表
	 * @param TcontractId
	 * @return
	 * @version 1.0
	 */
	public List<Map<String,Object>> getSubmitInfo(String contractId);
	
	/**
	 * 合同签订
	 * @comments 
	 * @param tcontractId
	 * @param userId
	 * @param approvalOpinion
	 * @version 1.0
	 */
    public void	updateStatusOk(String tcontractId,String userId,String approvalOpinion);

	/**
	 * 合同不通过（可修改）
	 * @comments 
	 * @param tcontractId
	 * @param userId
	 * @param approvalOpinion
	 * @version 1.0
	 */
    public void	updateStatusNo(String tcontractId,String userId,String approvalOpinion);
    
	/**
	 * 合同不通过（不可修改）
	 * @comments 
	 * @param tcontractId
	 * @param userId
	 * @param approvalOpinion
	 * @version 1.0
	 */
    public void	updateStatusNoModify(String tcontractId,String userId,String approvalOpinion);
	
}
