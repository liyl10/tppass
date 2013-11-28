package com.hopsun.tppas.api.contract.dao.impl;

import com.hopsun.tppas.api.contract.dao.TappropriationSingleDao;
import com.hopsun.tppas.common.Constants;
import com.hopsun.framework.base.bean.Finder;
import com.hopsun.framework.base.bean.Pager;
import com.hopsun.framework.base.dao.impl.BaseDaoImpl;
import com.hopsun.tppas.entity.TappropriationSingle;
import org.springframework.stereotype.Repository;

@Repository
public class TappropriationSingleDaoImpl extends BaseDaoImpl<TappropriationSingle, String> implements TappropriationSingleDao {
	   
	/**
	 * 查询拨款单信息
	 * @comments 
	 * @param tcontractId
	 * @param pageNumber
	 * @param pageSize
	 * @return
	 * @version 1.0
	 */
	public Pager find(String tcontractId,int pageNumber,int pageSize){
		//String company_id = this.Getcompanyid(user_id);
		Finder f = Finder.create(" from TappropriationSingle a  ");
		f.append(" where a.deleteFlag = '"
				+ Constants.COMMON_STATE_NOTDELETE 
				+ "' and a.tcontract.TContractId=:TContractId").setParam("TContractId", tcontractId);
		//排序
		f.append(" order by a.createTime desc");
		//查询返回
		return super.find(f, pageNumber, pageSize);
	}
}
