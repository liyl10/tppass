package com.hopsun.tppas.api.superadmin.dao.impl;

import java.util.ArrayList;
import java.util.List;

import com.hopsun.tppas.api.superadmin.dao.TprojectTypeDao;
import com.hopsun.tppas.common.Constants;
import com.hopsun.framework.base.bean.Finder;
import com.hopsun.framework.base.bean.Pager;
import com.hopsun.framework.base.dao.impl.BaseDaoImpl;
import com.hopsun.tppas.entity.TprojectType;
import org.springframework.stereotype.Repository;

@Repository
public class TprojectTypeDaoImpl extends BaseDaoImpl<TprojectType, String> implements TprojectTypeDao {
	   
	/**
	 * @Comments 分页查询
	 * @param sql
	 * @param pageNumber
	 * @param pageSize
	 * @return
	 * @Vsersion: 1.0
	 */
	public Pager find(String sql, Integer pageNumber, Integer pageSize) {
		Finder f = Finder.create(sql);	
		return super.find(f, pageNumber, pageSize);
	}
	
	/**
	 * @Comments 取得除过id的信息
	 * @param sql
	 * @return
	 * @Vsersion: 1.0
	 */
	public List<TprojectType> getListExceptId(String sql) {
		return super.createQueryList(sql, new String[]{});
	}

	/**
	 * 根据部门id取得属于该部门的项目父分类
	 */
	@Override
	public List<TprojectType> getFatherProjectTypeListByDeptId(String deptId) {
		
		List<TprojectType> tprojectTypeList = new ArrayList<TprojectType>();
		StringBuffer hql = new StringBuffer();
		hql.append(" from TprojectType t where t.deleteFlag = 0 ");
		hql.append(" and t.departmentId = ? ");
		hql.append(" and t.parentTypeId is null ");
		tprojectTypeList = super.createQueryList(hql.toString(), deptId);
		return tprojectTypeList;
	}

	/**
	 * 根据父类型id取得项目子分类
	 */
	@Override
	public List<TprojectType> getSonProjectTypeListByDeptId(String parentTypeId) {
		List<TprojectType> tprojectTypeList = new ArrayList<TprojectType>();
		StringBuffer hql = new StringBuffer();
		hql.append(" from TprojectType t where t.deleteFlag = 0 ");
		hql.append(" and t.parentTypeId = ? ");
		tprojectTypeList = super.createQueryList(hql.toString(), parentTypeId);
		return tprojectTypeList;
	}

	/**
	 * @comments 取得项目分类显示名称   父类名称-分类名称
	 * @param projectTypeId
	 * @return
	 * @Version 1.0
	 */
	public String getProjectTypeAllName(String projectTypeId) {
		String projectTypeName = "";
		String projectTypePaName = "";
		// 取得项目类型对象
		TprojectType tp = super.get(projectTypeId);
		if(tp != null){
			projectTypeName = tp.getTypeShowName();
			TprojectType tpa = super.get(tp.getParentTypeId());
			if(tpa != null){
				projectTypePaName = tpa.getTypeShowName();
			}
		}
		
		if(projectTypeName != null && !"".equals(projectTypeName)&& projectTypePaName != null && !"".equals(projectTypePaName)){
			return projectTypePaName + Constants.STRING_LINK + projectTypeName;
		}
		else{
			return "";
		}
	}
	
	/**
	 * @comments 得到所有未删除的项目分类
	 * @return
	 * @Version 1.0
	 */
	public List<TprojectType> getAllProjectType() {
		String hql = "from TprojectType p where p.deleteFlag=0";
		List<TprojectType> projectTypeList = super.createQueryList(hql);
		return projectTypeList;
	}

	/**
	 * @comments 得到所有未删除的所有计划类别
	 * @return
	 * @Version 1.0
	 */
	public List<TprojectType> getAllProjectTypeFirst() {
		List<TprojectType> tprojectTypeList = new ArrayList<TprojectType>();
		String hql = " from TprojectType t where t.deleteFlag = 0 and t.parentTypeId is null ";
		tprojectTypeList = super.createQueryList(hql.toString(), new String[]{});
		return tprojectTypeList;
	}
}

