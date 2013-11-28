package com.hopsun.tppas.api.contract.service;

import java.util.List;
import java.util.Map;

import com.hopsun.framework.base.bean.Pager;
import com.hopsun.framework.base.service.BaseService;
import com.hopsun.tppas.entity.Tcontract;

public interface TcontractService extends BaseService<Tcontract, String> {
	/**
	 * 查询待审核合同
	 * @param acceptanceStatus
	 * @return
	 */
	public List<Tcontract> queryTacceptanceByState(String acceptanceStatus);
	
	/**
	 * 根据条件查询数据
	 * @comments 
	 * @param param
	 * @param pageNo
	 * @param pageSize
	 * @return
	 * @version 1.0
	 */
	public Pager find(Map<String, Object> param, int pageNo, int pageSize);
	
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
    
	/**
	 * 下发合同
	 * @comments 
	 * @param tcontractId
	 * @param userId
	 * @param contractType
	 * @version 1.0
	 */
    public void	updateIssuedContract(String tcontractId,String userId,String contractType);

	/**
	 * 合同类型变更
	 * @comments 
	 * @param tcontractId
	 * @param userId
	 * @param contractType
	 * @version 1.0
	 */
    public void	updateType(String tcontractId,String userId,String contractType);
    
}
