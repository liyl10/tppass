package com.hopsun.tppas.api.report.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.hopsun.framework.base.bean.Finder;
import com.hopsun.framework.base.bean.Pager;
import com.hopsun.framework.base.dao.impl.BaseDaoImpl;
import com.hopsun.tppas.api.report.dao.TresearcherDao;
import com.hopsun.tppas.common.Constants;
import com.hopsun.tppas.entity.Tresearcher;

@Repository
public class TresearcherDaoImpl extends BaseDaoImpl<Tresearcher, String> implements TresearcherDao {
	/**
	 * @Comments 分页查询
	 * @param projectId
	 * @param pageNo
	 * @param pageSize
	 * @return
	 * @Vsersion: 1.0
	 */
	public Pager find(String projectId, int pageNo, int pageSize) {
		//创建Finder查询对象
		Finder f = Finder.create("from Tresearcher r where r.tprojectApplication.projectId =:projectId and r.deleteFlag = 0");
		// 根据用户id,未删除 deleteFlag=0
		f.setParam("projectId", projectId);
		f.append(" order by r.revealOrder desc");
		return super.find(f, pageNo, pageSize);
	}
	
	/**
	 * @comments 查询有效研究人员
	 * @param projectId
	 * @return
	 * @version 1.0
	 */
	public List<Tresearcher> getValidTresearchers(String projectId) {
		String hql = "from Tresearcher c where c.tprojectApplication.projectId =? and c.deleteFlag =? order by c.revealOrder desc";
		List<Tresearcher> tresearcherList = super.createQueryList(hql.toString(), new String[]{projectId,Constants.COMMON_STATE_NOTDELETE});
		return tresearcherList;
	}
}
