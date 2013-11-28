/************************* 版权声明 *********************************
 *
 * Copyright (C) 2012 西安辉盛科技发展有限责任公司.
 *
 ******************************************************************
 */
package com.hopsun.tppas.api.supervisor.dao.impl;

import java.util.List;

import com.hopsun.tppas.api.supervisor.dao.TprojectAchievementInfoDao;
import com.hopsun.framework.base.bean.Finder;
import com.hopsun.framework.base.dao.impl.BaseDaoImpl;
import com.hopsun.tppas.entity.TprojectAchievementInfo;
import org.springframework.stereotype.Repository;

/**
 * @comments 项目取得成果情况
 * @author wangxiaodong
 * @date 2013-9-22
 * @version 1.0
 */
@Repository
public class TprojectAchievementInfoDaoImpl extends BaseDaoImpl<TprojectAchievementInfo, String> implements TprojectAchievementInfoDao {
	   
	/**
	 * 通过监理ID查询该监理下的项目取得成果情况
	 * @comments 
	 * @param supervisorId
	 * @return
	 * @version 1.0
	 */
	@SuppressWarnings("unchecked")
	public TprojectAchievementInfo getProjectAchievementInfoBySupervisorId(String supervisorId) {
		Finder f = Finder.create("from TprojectAchievementInfo a where a.tsupervisor.supervisorId=:supervisorId and a.deleteFlag = 0 ");
		f.setParam("supervisorId", supervisorId);
		List<TprojectAchievementInfo> all =  super.find(f);
		if(all!=null&&all.size()>0){
			return all.get(0);
		}
		return new TprojectAchievementInfo();
	}
}
