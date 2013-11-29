/************************* 版权声明 *********************************
 *
 * Copyright (C) 2012 西安辉盛科技发展有限责任公司.
 *
 ******************************************************************
 */
package com.hopsun.tppas.api.acceptance.dao.impl;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.hopsun.framework.base.bean.Finder;
import com.hopsun.framework.base.bean.Pager;
import com.hopsun.framework.base.dao.impl.BaseDaoImpl;
import com.hopsun.tppas.api.acceptance.dao.TacceptanceDao;
import com.hopsun.tppas.common.Constants;
import com.hopsun.tppas.entity.Tacceptance;

/**
 * 
 * @comments 验收DAO实现类
 * @author liyilin
 * @date 2013-8-9
 * @version 1.0
 */
@Repository
public class TacceptanceDaoImpl extends BaseDaoImpl<Tacceptance, String> implements TacceptanceDao {

	@Override
	public Pager find(Map<String, Object> param, Integer pageNumber, Integer pageSize) {
		// 创建Finder查询对象
		Finder f = Finder.create(" from Tacceptance t where t.deleteFlag=:deleteFlag");
		
		// 项目名称
	    String projectName = (String) param.get("projectName");
	    if (!isNullString(projectName)) {
			f.append(" and t.tprojectApplication.projectName like '%" + projectName.trim() + "%'");
		}
	    // 承担单位
	    String applicationUnit = (String) param.get("applicationUnit");
	    if (!isNullString(applicationUnit)) {
			f.append(" and t.tprojectApplication.applicationUnit like '%" + applicationUnit.trim() + "%'");
		}
	    // 项目分类
	    String typeId2 = (String) param.get("typeId2");
	    if (!isNullString(typeId2)) {
			f.append(" and t.tprojectApplication.planFlag = '" + typeId2.trim() + "'");
		}
	    String typeId3 = (String) param.get("typeId3");
	    if (!isNullString(typeId3)) {
			f.append(" and t.tprojectApplication.typeId = '" + typeId3.trim() + "'");
		}
	    // 验收状态
	    String acceptanceStatus = (String) param.get("acceptanceStatus");
	    if (!isNullString(acceptanceStatus)) {
			f.append(" and t.acceptanceStatus = '" + acceptanceStatus.trim() + "'");
		} else {
			// 默认显示--验收状态 ≠ 可申请、填写中
			f.append(" and t.acceptanceStatus not in ('" + Constants.ACCEPTANCE_APPLY + "','" + Constants.ACCEPTANCE_WRITE + "')");
		}
		f.append(" order by t.createTime desc");
		
		f.setParam("deleteFlag", Constants.COMMON_STATE_NOTDELETE);
		
		return super.find(f, pageNumber, pageSize);
	}
	
	/**
	 * 查询待验收项目
	 * @param String acceptanceStatus
	 * 
	 */
	@Override
	public List<Tacceptance> queryTacceptanceByState(String acceptanceStatus) {
		String hql=" from Tacceptance t left join fetch t.tprojectApplication where t.acceptanceStatus=?";
		return createQueryList(hql, new String[]{acceptanceStatus});
	}
	
	/**
	 * 根据项目ID查询项目验收管理信息
	 *@param acceptanceId
	 *@return Tacceptance
	 */
	public Tacceptance getTacceptanceById(String acceptanceId) {
		//创建Finder查询对象
		StringBuffer hql = new StringBuffer(" from Tacceptance ta where ta.deleteFlag=?");
		hql.append(" and ta.acceptanceId=?");
		
		String[] param = new String[]{Constants.COMMON_STATE_NOTDELETE, acceptanceId};
		
		return super.createQueryObj(hql.toString(), param);
	}
	
	/**
	 * @comments 类型判断
	 * @param valueStr
	 * @return
	 * @Version 1.0
	 */
	private boolean isNullString(String valueStr) {
		if (valueStr != null && valueStr.length() > 0) {
			return false;
		} else {
			return true;
		}
	}
}
