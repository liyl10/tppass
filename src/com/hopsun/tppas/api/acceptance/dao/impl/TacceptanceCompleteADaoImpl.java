package com.hopsun.tppas.api.acceptance.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.hopsun.framework.base.dao.impl.BaseDaoImpl;
import com.hopsun.tppas.api.acceptance.dao.TacceptanceCompleteADao;
import com.hopsun.tppas.common.Constants;
import com.hopsun.tppas.entity.TacceptanceCompleteA;

@Repository
public class TacceptanceCompleteADaoImpl extends BaseDaoImpl<TacceptanceCompleteA, String> implements TacceptanceCompleteADao {
	/**
	 * 根据验收ID查询对照合同项目任务完成情况
	 *@param acceptanceId
	 *@return List
	 */
	public List<TacceptanceCompleteA> getTacceptanceCompleteAById(String acceptanceId) {
		// 创建查询对象
		StringBuffer hql = new StringBuffer(" from TacceptanceCompleteA tca where tca.deleteFlag=?");
		hql.append(" and tca.tacceptance.acceptanceId=?");
		
		String[] param = new String[]{Constants.COMMON_STATE_NOTDELETE, acceptanceId};
		
		return super.createQueryList(hql.toString(), param);
	}
}
