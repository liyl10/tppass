/************************* 版权声明 *********************************
 *
 * Copyright (C) 2012 西安辉盛科技发展有限责任公司.
 *
 ******************************************************************
 */
package com.hopsun.tppas.api.supervisor.dao.impl;

import java.util.List;

import com.hopsun.tppas.api.supervisor.dao.TprojectManagementInfoDao;
import com.hopsun.framework.base.bean.Finder;
import com.hopsun.framework.base.dao.impl.BaseDaoImpl;
import com.hopsun.tppas.entity.TprojectManagementInfo;
import org.springframework.stereotype.Repository;

/**
 * @comments 项目实施管理情况
 * @author wangxiaodong
 * @date 2013-9-22
 * @version 1.0
 */
@Repository
public class TprojectManagementInfoDaoImpl extends BaseDaoImpl<TprojectManagementInfo, String> implements TprojectManagementInfoDao {
	   
	/**
	 * 通过监理ID查询该监理下的项目实施管理情况
	 * @comments 
	 * @param supervisorId
	 * @return
	 * @version 1.0
	 */
	@SuppressWarnings("unchecked")
	public TprojectManagementInfo getProjectManagementInfoBySupervisorId(String supervisorId) {
		Finder f = Finder.create("from TprojectManagementInfo m where m.tsupervisor.supervisorId=:supervisorId and m.deleteFlag = 0 ");
		f.setParam("supervisorId", supervisorId);
		List<TprojectManagementInfo> all =  super.find(f);
		if(all!=null&&all.size()>0){
			return all.get(0);
		}
		return new TprojectManagementInfo();
	}
}
