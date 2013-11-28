package com.hopsun.tppas.api.acceptance.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.hopsun.framework.base.bean.Finder;
import com.hopsun.framework.base.bean.Pager;
import com.hopsun.framework.base.dao.impl.BaseDaoImpl;
import com.hopsun.tppas.api.acceptance.dao.TacceptanceAccADao;
import com.hopsun.tppas.common.Constants;
import com.hopsun.tppas.entity.TacceptanceAccA;

@Repository
public class TacceptanceAccADaoImpl extends BaseDaoImpl<TacceptanceAccA, String> implements TacceptanceAccADao {
	/**
	 * 分页查询
	 *@param pageNumber pageSize acceptanceId
	 *@return Pager
	 */
	public Pager findByPager(Integer pageNumber, Integer pageSize, String acceptanceId){
		
		//创建Finder查询对象
		Finder f = Finder.create(" from TacceptanceAccA taa where taa.deleteFlag=:deleteFlag");
		f.append(" and taa.tacceptance.acceptanceId=:acceptanceId");
		f.append(" order by taa.createTime desc");
		
		f.setParam("deleteFlag", Constants.COMMON_STATE_NOTDELETE);
		f.setParam("acceptanceId", acceptanceId);
		
		return super.find(f, pageNumber, pageSize);
	}
	
	/**
	 * 根据验收ID查询验收小组人员信息
	 *@param acceptanceId
	 *@return List
	 */
	public List<TacceptanceAccA> getTacceptanceAccAById(String acceptanceId) {
		// 创建查询对象
		StringBuffer hql = new StringBuffer(" from TacceptanceAccA taa where taa.deleteFlag=?");
		hql.append(" and taa.tacceptance.acceptanceId=?");
		hql.append(" order by taa.createTime desc");
		
		String[] param = new String[]{Constants.COMMON_STATE_NOTDELETE, acceptanceId};
		
		return super.createQueryList(hql.toString(), param);
	}
}
