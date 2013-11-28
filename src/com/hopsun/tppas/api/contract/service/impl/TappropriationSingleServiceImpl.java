package com.hopsun.tppas.api.contract.service.impl;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;

import com.hopsun.framework.base.bean.Pager;
import com.hopsun.framework.base.service.impl.BaseServiceImpl;
import com.hopsun.tppas.common.Constants;
import com.hopsun.tppas.entity.TappropriationSingle;
import com.hopsun.tppas.entity.Tcontract;
import com.hopsun.tppas.api.contract.service.TappropriationSingleService;
import com.hopsun.tppas.api.contract.dao.TappropriationSingleDao;
import com.hopsun.tppas.api.contract.dao.TcontractDao;

@Service
public class TappropriationSingleServiceImpl extends BaseServiceImpl<TappropriationSingle,String> implements TappropriationSingleService{
	
	@Resource
	private TappropriationSingleDao tappropriationSingleDao;
	
	@Resource
	private TcontractDao tcontractDao;
	
	@Resource
	public void setBaseDao(TappropriationSingleDao tappropriationSingleDao) {
		super.setBaseDao(tappropriationSingleDao);
	}
	
   /**
    * 查询拨款单列表
    * @comments 
    * @param tcontractId
    * @param pageNumber
    * @param pageSize
    * @return
    * @version 1.0
    */
	public Pager getTappropriationSingleList(String tcontractId, int pageNumber,int pageSize){
		
		Pager pager =  tappropriationSingleDao.find(tcontractId, pageNumber, pageSize);
		Tcontract tcontract = tcontractDao.get(tcontractId);
		String projectName = "";
		String cddw = "";
		if (tcontract != null){
			projectName = tcontract.getTprojectApplication().getProjectName();
			cddw = tcontract.getTprojectApplication().getApplicationUnit();
		}
		if(pager !=null && pager.getList() !=null && pager.getList().size() >0){
			for(int i=0; i< pager.getList().size(); i++){
				TappropriationSingle tappropriationSingle = (TappropriationSingle)pager.getList().get(i);
				
				if(tappropriationSingle!=null){
					// 根据拨款单ID取得拨款单信息
					tappropriationSingle.setTasksEntrusted(projectName);
					tappropriationSingle.setUndertaker(cddw);
				}
			}
		}
		return pager; 
	}
	
	   /**
	    * 新增拨款单
	    * @comments 
	    * @param tappropriationSingle
	    * @param tcontractId
	    * @version 1.0
	    */
	   public void savetappropriationSingle(TappropriationSingle tappropriationSingle,String tcontractId){
		    tappropriationSingle.setDeleteFlag(Constants.COMMON_STATE_NOTDELETE);
			Tcontract tcontract = tcontractDao.get(tcontractId);
			tappropriationSingle.setTcontract(tcontract);
			tappropriationSingle.setCreateTime(new java.sql.Timestamp(new java.util.Date().getTime()));
			tappropriationSingle.setCreateUser("");
			tappropriationSingleDao.save(tappropriationSingle);
	   }
	   
	   /**
	    * 修改拨款单
	    * @comments 
	    * @param tappropriationSingle
	    * @param tcontractId
	    * @version 1.0
	    */
	   public void updatetappropriationSingle(TappropriationSingle tappropriationSingle,String tcontractId){
		   TappropriationSingle tappropriationSingle1 = new TappropriationSingle();
		   	if (tappropriationSingle != null){
		   		tappropriationSingle1 = tappropriationSingleDao.get(tappropriationSingle.getAppropriationSingleId());
		   		tappropriationSingle.setCreateTime(tappropriationSingle1.getCreateTime());
		   		tappropriationSingle.setCreateUser(tappropriationSingle1.getCreateUser());
		   	}
		   	tappropriationSingleDao.evict(tappropriationSingle1);
		   	if (tappropriationSingle != null){
			    tappropriationSingle.setDeleteFlag(Constants.COMMON_STATE_NOTDELETE);
				Tcontract tcontract = tcontractDao.get(tcontractId);
				tappropriationSingle.setTcontract(tcontract);
				tappropriationSingle.setUpdateTime(new java.sql.Timestamp(new java.util.Date().getTime()));
				tappropriationSingle.setUpdateUser("");
				tappropriationSingleDao.update(tappropriationSingle);
		   	}
	   }
	   
	   /**
	    * 删除拨款单
	    * @comments 
	    * @param tappropriationSingle
	    * @param tcontractId
	    * @version 1.0
	    */
	   public void deletetappropriationSingle(String tappropriationSingleId){
		   TappropriationSingle tappropriationSingle = tappropriationSingleDao.get(tappropriationSingleId);
		   if (tappropriationSingle != null){
			   tappropriationSingle.setDeleteFlag(Constants.COMMON_STATE_DELETE);
			   tappropriationSingleDao.update(tappropriationSingle);
		   }
	   }
	   
}
