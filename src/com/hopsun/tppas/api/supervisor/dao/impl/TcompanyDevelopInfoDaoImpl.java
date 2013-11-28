/************************* 版权声明 *********************************
 *
 * Copyright (C) 2012 西安辉盛科技发展有限责任公司.
 *
 ******************************************************************/
package com.hopsun.tppas.api.supervisor.dao.impl;

import java.util.List;

import com.hopsun.tppas.api.supervisor.dao.TcompanyDevelopInfoDao;
import com.hopsun.framework.base.bean.Finder;
import com.hopsun.framework.base.dao.impl.BaseDaoImpl;
import com.hopsun.tppas.entity.TcompanyDevelopInfo;
import org.springframework.stereotype.Repository;

/**
 * @comments 企业发展情况
 * @author wangxiaodong
 * @date 2013-8-9
 * @version 1.0
 */
@Repository
public class TcompanyDevelopInfoDaoImpl extends BaseDaoImpl<TcompanyDevelopInfo, String> implements TcompanyDevelopInfoDao {
	   
	/**
	 * 通过监理ID查询该监理下的企业发展情况
	 * @comments 
	 * @param supervisorId
	 * @return
	 * @version 1.0
	 */
	@SuppressWarnings("unchecked")
	public TcompanyDevelopInfo getCompanyDevelopInfoBySupervisorId(String supervisorId) {
		Finder f = Finder.create("from TcompanyDevelopInfo c where c.tsupervisor.supervisorId=:supervisorId and c.deleteFlag = 0 ");
		f.setParam("supervisorId", supervisorId);
		List<TcompanyDevelopInfo> all =  super.find(f);
		if(all!=null&&all.size()>0){
			return all.get(0);
		}
		return new TcompanyDevelopInfo();
	}
}
