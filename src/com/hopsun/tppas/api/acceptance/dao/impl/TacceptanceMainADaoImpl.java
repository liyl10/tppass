package com.hopsun.tppas.api.acceptance.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.hopsun.framework.base.bean.Finder;
import com.hopsun.framework.base.bean.Pager;
import com.hopsun.framework.base.dao.impl.BaseDaoImpl;
import com.hopsun.tppas.api.acceptance.dao.TacceptanceMainADao;
import com.hopsun.tppas.common.Constants;
import com.hopsun.tppas.entity.TacceptanceMainA;

@Repository
public class TacceptanceMainADaoImpl extends BaseDaoImpl<TacceptanceMainA, String> implements TacceptanceMainADao {
	/**
	 * 分页查询
	 *@param pageNumber pageSize acceptanceId
	 *@return Pager
	 */
	public Pager findByPager(Integer pageNumber, Integer pageSize, String acceptanceId){
		
		//创建Finder查询对象
		Finder f = Finder.create(" from TacceptanceMainA tma where tma.deleteFlag=:deleteFlag");
		f.append(" and tma.tacceptance.acceptanceId=:acceptanceId");
		f.append(" order by tma.createTime desc");
		
		f.setParam("deleteFlag", Constants.COMMON_STATE_NOTDELETE);
		f.setParam("acceptanceId", acceptanceId);
		
		return super.find(f, pageNumber, pageSize);
	}
	
	/**
	 * 根据验收ID查询项目主要参加人员信息
	 *@param acceptanceId
	 *@return List
	 */
	public List<TacceptanceMainA> getTacceptanceMainAById(String acceptanceId) {
		// 创建查询对象
		StringBuffer hql = new StringBuffer(" from TacceptanceMainA tma where tma.deleteFlag=?");
		hql.append(" and tma.tacceptance.acceptanceId=?");
		hql.append(" order by tma.createTime desc");
		
		String[] param = new String[]{Constants.COMMON_STATE_NOTDELETE, acceptanceId};
		
		return super.createQueryList(hql.toString(), param);
	}
}
