/************************* 版权声明 *********************************
 *
 * Copyright (C) 2012 西安辉盛科技发展有限责任公司.
 *
 ******************************************************************
 */
package com.hopsun.tppas.api.supervisor.dao.impl;

import java.util.List;

import com.hopsun.tppas.api.supervisor.dao.TprojectCompleteInfoDao;
import com.hopsun.framework.base.bean.Finder;
import com.hopsun.framework.base.dao.impl.BaseDaoImpl;
import com.hopsun.tppas.entity.TprojectCompleteInfo;
import org.springframework.stereotype.Repository;

/**
 * @comments 对照合同项目任务完成情况
 * @author wangxiaodong
 * @date 2013-8-8
 * @version 1.0
 */
@Repository
public class TprojectCompleteInfoDaoImpl extends BaseDaoImpl<TprojectCompleteInfo, String> implements TprojectCompleteInfoDao {
	   
	/**
	 * 通过监理ID查询该监理下的对照合同项目任务完成情况
	 * @comments 
	 * @param supervisorId
	 * @return
	 * @version 1.0
	 */
	@SuppressWarnings("unchecked")
	public TprojectCompleteInfo getProjectCompleteInfoBySupervisorId(String supervisorId) {
		Finder f = Finder.create("from TprojectCompleteInfo p where p.tsupervisor.supervisorId=:supervisorId and p.deleteFlag = 0 ");
		f.setParam("supervisorId", supervisorId);
		List<TprojectCompleteInfo> all =  super.find(f);
		if(all!=null&&all.size()>0){
			return all.get(0);
		}
		return new TprojectCompleteInfo();
	}
}
