package com.hopsun.tppas.api.acceptance.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.hopsun.framework.base.dao.impl.BaseDaoImpl;
import com.hopsun.tppas.api.acceptance.dao.TacceptanceFundsADao;
import com.hopsun.tppas.common.Constants;
import com.hopsun.tppas.entity.TacceptanceFundsA;

@Repository
public class TacceptanceFundsADaoImpl extends BaseDaoImpl<TacceptanceFundsA, String> implements TacceptanceFundsADao {
	/**
	 * 根据验收ID查询企业获得资金支持情况
	 *@param acceptanceId
	 *@return List
	 */
	public List<TacceptanceFundsA> getTacceptanceFundsAById(String acceptanceId) {
		// 创建查询对象
		StringBuffer hql = new StringBuffer(" from TacceptanceFundsA tfa where tfa.deleteFlag=?");
		hql.append(" and tfa.tacceptance.acceptanceId=?");
		
		String[] param = new String[]{Constants.COMMON_STATE_NOTDELETE, acceptanceId};
		
		return super.createQueryList(hql.toString(), param);
	}
}
