package com.hopsun.tppas.api.acceptance.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.hopsun.framework.base.dao.impl.BaseDaoImpl;
import com.hopsun.tppas.api.acceptance.dao.TacceptanceAccFundsADao;
import com.hopsun.tppas.common.Constants;
import com.hopsun.tppas.entity.TacceptanceAccFundsA;

@Repository
public class TacceptanceAccFundsADaoImpl extends BaseDaoImpl<TacceptanceAccFundsA, String> implements TacceptanceAccFundsADao {
	/**
	 * 根据验收ID查询项目验收经费登记表
	 *@param acceptanceId
	 *@return List
	 */
	public List<TacceptanceAccFundsA> getTacceptanceAccFundsAById(String acceptanceId) {
		// 创建查询对象
		StringBuffer hql = new StringBuffer(" from TacceptanceAccFundsA tafa where tafa.deleteFlag=?");
		hql.append(" and tafa.tacceptance.acceptanceId=?");
		
		String[] param = new String[]{Constants.COMMON_STATE_NOTDELETE, acceptanceId};
		
		return super.createQueryList(hql.toString(), param);
	}
}
