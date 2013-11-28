package com.hopsun.tppas.api.acceptance.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.hopsun.framework.base.dao.impl.BaseDaoImpl;
import com.hopsun.tppas.api.acceptance.dao.TacceptanceImplementationADao;
import com.hopsun.tppas.common.Constants;
import com.hopsun.tppas.entity.TacceptanceImplementationA;

@Repository
public class TacceptanceImplementationADaoImpl extends BaseDaoImpl<TacceptanceImplementationA, String> implements TacceptanceImplementationADao {
	/**
	 * 根据验收ID查询项目经费落实和使用情况
	 *@param acceptanceId
	 *@return List
	 */
	public List<TacceptanceImplementationA> getTacceptanceImplementationAById(String acceptanceId) {
		//创建查询对象
		StringBuffer hql = new StringBuffer(" from TacceptanceImplementationA tia where tia.deleteFlag=?");
		hql.append(" and tia.tacceptance.acceptanceId=?");
		
		String[] param = new String[]{Constants.COMMON_STATE_NOTDELETE, acceptanceId};
		
		return super.createQueryList(hql.toString(), param);
	}
}
