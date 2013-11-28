package com.hopsun.tppas.api.acceptance.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.hopsun.framework.base.dao.impl.BaseDaoImpl;
import com.hopsun.tppas.api.acceptance.dao.TacceptanceOpinionADao;
import com.hopsun.tppas.common.Constants;
import com.hopsun.tppas.entity.TacceptanceOpinionA;

@Repository
public class TacceptanceOpinionADaoImpl extends BaseDaoImpl<TacceptanceOpinionA, String> implements TacceptanceOpinionADao {
	/**
	 * 根据验收ID查询验收阶段意见
	 *@param acceptanceId
	 *@return List
	 */
	public List<TacceptanceOpinionA> getTacceptanceOpinionAById(String acceptanceId) {
		// 创建查询对象
		StringBuffer hql = new StringBuffer(" from TacceptanceOpinionA toa where toa.deleteFlag=?");
		hql.append(" and toa.tacceptance.acceptanceId=?");
		
		String[] param = new String[]{Constants.COMMON_STATE_NOTDELETE, acceptanceId};
		
		return super.createQueryList(hql.toString(), param);
	}
}
