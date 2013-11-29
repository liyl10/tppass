package com.hopsun.tppas.api.acceptance.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.hopsun.framework.base.dao.impl.BaseDaoImpl;
import com.hopsun.tppas.api.acceptance.dao.TacceptanceDevelopingADao;
import com.hopsun.tppas.common.Constants;
import com.hopsun.tppas.entity.TacceptanceDevelopingA;

@Repository
public class TacceptanceDevelopingADaoImpl extends BaseDaoImpl<TacceptanceDevelopingA, String> implements TacceptanceDevelopingADao {
	/**
	 * 根据验收ID查询企业发展情况
	 *@param acceptanceId
	 *@return List
	 */
	public List<TacceptanceDevelopingA> getTacceptanceDevelopingAById(String acceptanceId) {
		// 创建查询对象
		StringBuffer hql = new StringBuffer(" from TacceptanceDevelopingA tda where tda.deleteFlag=?");
		hql.append(" and tda.tacceptance.acceptanceId=?");
		
		String[] param = new String[]{Constants.COMMON_STATE_NOTDELETE, acceptanceId};
		
		return super.createQueryList(hql.toString(), param);
	} 
}
