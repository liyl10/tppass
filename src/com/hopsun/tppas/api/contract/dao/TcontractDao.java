package com.hopsun.tppas.api.contract.dao;

import java.util.List;
import java.util.Map;

import com.hopsun.tppas.entity.Tcontract;
import com.hopsun.framework.base.bean.Pager;
import com.hopsun.framework.base.dao.BaseDao;
/**
 * @Comments:   后台Dao接口-主要用来定义项目合同操作的接口
 * @author  yk
 * @date 2013-08-09
 * @version 1.0
 *
 */
public interface TcontractDao extends BaseDao<Tcontract, String>{
	/**
	 * 查询待审核的合同项目
	 * @param contractStatus
	 * @return
	 */
	public List<Tcontract> queryTContractListByState(String contractStatus) ;
	
    /**
     * 
     * @comments 分页查询
     * @param param
     * @param pageNo
     * @param pageSize
     * @return
     * @version 1.0
     */
   public Pager find(Map<String,Object> param, int pageNo, int pageSize);
	
}
