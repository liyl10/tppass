/*************** 版权声明***************
*
* Copyright (C) 2012 西安辉盛科技发展有限责任公司.
*
********************************************
*/
package com.hopsun.tppas.api.report.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.hopsun.framework.base.bean.Finder;
import com.hopsun.framework.base.dao.impl.BaseDaoImpl;
import com.hopsun.tppas.api.report.dao.TprojectGroupDao;
import com.hopsun.tppas.entity.TprojectGroup;
/**
 * @comments 项目分组
 * @author wanglw
 * @date 2013-9-10 @time 下午4:24:54
 * @Version 1.0
 */
@Repository
public class TprojectGroupDaoImpl extends BaseDaoImpl<TprojectGroup, String> implements TprojectGroupDao {
	   
	
	/**
	 * @comments 根据本门Id取得项目分组List
	 * @param deptId
	 * @return
	 * @Version 1.0
	 */
	public List<TprojectGroup> getProjectGroupListByDeptId(String deptId){
		
		List<TprojectGroup> list = new ArrayList<TprojectGroup>();
		
			StringBuffer hql = new StringBuffer();
			hql.append(" From TprojectGroup t where ");
			hql.append(" t.departmentId= ?");
			hql.append(" and  t.deleteFlag= 0");
			hql.append(" order by t.createTime desc");
			list = super.createQueryList(hql.toString(), new String[]{ deptId });
		
		return list;
	}

	/**
	 * 根据子分类ID取得项目分组List
	 */
	@Override
	public List<TprojectGroup> getProjectGroupListByTypeId(String typeId) {
		List<TprojectGroup> list = new ArrayList<TprojectGroup>();
		
		StringBuffer hql = new StringBuffer();
		hql.append(" From TprojectGroup t where ");
		hql.append(" t.typeId= ?");
		hql.append(" and  t.deleteFlag= 0");
		hql.append(" order by t.createTime desc");
		list = super.createQueryList(hql.toString(), new String[]{ typeId });
	
	return list;

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<TprojectGroup> getProjectGroupListByTypeStr(String typeStr) {
		List<TprojectGroup> list = new ArrayList<TprojectGroup>();

		StringBuffer hql = new StringBuffer();
		hql.append(" From TprojectGroup t where ");
		hql.append(" t.typeId in ( ");
		hql.append(typeStr);
		hql.append(" ) and  t.deleteFlag= 0");

		Finder f = Finder.create(hql.toString());
		f.append(" order by t.createTime desc");
		list = super.find(f);
		
		return list;
	}
	// weina start
	/**
	 * 
	 * @comments 根据子分类和锁定区分查询项目分组list
	 * @param typeStr
	 * @return
	 * @version 1.0
	 */
	@SuppressWarnings("unchecked")
	public List<TprojectGroup> getProjectGroupListByTypeStrClockFlag(
			String typeStr) {
		List<TprojectGroup> groupList = new ArrayList<TprojectGroup>();

		StringBuffer hql = new StringBuffer();
		hql.append(" From TprojectGroup t where ");
		hql.append(" t.typeId in ( ");
		hql.append(typeStr);
		hql.append(" ) and  t.deleteFlag= 0 and t.clockFlag = 1 ");

		Finder f = Finder.create(hql.toString());
		f.append(" order by t.createTime desc");
		groupList = super.find(f);
		
		return groupList;
	}
	// weina end
}
