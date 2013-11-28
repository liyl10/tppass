package com.hopsun.tppas.api.contract.service;

import com.hopsun.tppas.entity.TappropriationSingle;
import com.hopsun.framework.base.bean.Pager;
import com.hopsun.framework.base.service.BaseService;

public interface TappropriationSingleService extends BaseService<TappropriationSingle, String> {
	
   /**
    * 查询拨款单列表
    * @comments 
    * @param tcontractId
    * @param pageNumber
    * @param pageSize
    * @return
    * @version 1.0
    */
   public Pager getTappropriationSingleList(String tcontractId, int pageNumber,int pageSize);
   
   /**
    * 新增拨款单
    * @comments 
    * @param tappropriationSingle
    * @param tcontractId
    * @version 1.0
    */
   public void savetappropriationSingle(TappropriationSingle tappropriationSingle,String tcontractId);
   
   /**
    * 修改拨款单
    * @comments 
    * @param tappropriationSingle
    * @param tcontractId
    * @version 1.0
    */
   public void updatetappropriationSingle(TappropriationSingle tappropriationSingle,String tcontractId);
   
   /**
    * 修改拨款单
    * @comments 
    * @param tappropriationSingle
    * @param tcontractId
    * @version 1.0
    */
   public void deletetappropriationSingle(String tappropriationSingleId);
   
}
