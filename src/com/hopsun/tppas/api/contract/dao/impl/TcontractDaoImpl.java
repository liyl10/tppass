package com.hopsun.tppas.api.contract.dao.impl;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.hopsun.framework.base.bean.Finder;
import com.hopsun.framework.base.bean.Pager;
import com.hopsun.framework.base.dao.impl.BaseDaoImpl;
import com.hopsun.tppas.api.contract.dao.TcontractDao;
import com.hopsun.tppas.entity.Tcontract;
import com.hopsun.tppas.common.Constants;
/**
 * @Comments:   后台Dao接口-主要用来实现项目合同操作的接口
 * @author  yk
 * @date 2013-08-09
 * @version 1.0
 *
 */
@Repository
public class TcontractDaoImpl extends BaseDaoImpl<Tcontract, String> implements TcontractDao {

	public List<Tcontract> queryTContractListByState(String contractStatus) {
		String hql=" FROM Tcontract contract  left join fetch contract.tprojectApplication where contract.contractStatus=? ";
		return createQueryList(hql, new String[]{contractStatus});
	}
	   
    /**
     * 
     * @comments 分页查询
     * @param param
     * @param pageNo
     * @param pageSize
     * @return
     * @version 1.0
     */
	public Pager find(Map<String, Object> param, int pageNo, int pageSize) {

		// HQL
		StringBuilder hql = new StringBuilder( " from Tcontract t where 1 = 1");
		
		hql.append(getSelectData(param));
		hql.append(" order by t.contractDate desc");

		// 创建Finder查询对象
		Finder f = Finder.create(hql.toString());

		Pager p = super.find(f, pageNo, pageSize);

		return p;
	}

    /**
     * 
     * @comments 查询条件
     * @param param
     * @return
     * @version 1.0
     */
	private StringBuilder getSelectData(Map<String, Object> param) {
		StringBuilder hql = new StringBuilder();

		// 项目名称
		String projectName = (String) param.get("projectName");
		if (isNotNullOrEmpty(projectName)) {
			hql.append(" and t.tprojectApplication.projectName like '%" + projectName + "%'");
		}
		// 申请单位
		String applicationUnit = (String) param.get("applicationUnit");
		if (isNotNullOrEmpty(applicationUnit)) {
			hql.append(" and t.tprojectApplication.applicationUnit like '%" + applicationUnit + "%'");
		}
		// 合同状态
		String contractStatus = (String) param.get("contractStatus");
		if (isNotNullOrEmpty(contractStatus)) {
			hql.append(" and t.contractStatus = '" + contractStatus + "'");
		}
		else{
			hql.append(" and t.contractStatus in ('" + Constants.CONTRACT_STATE_ISSUED + "',");
			hql.append(" '" + Constants.CONTRACT_STATE_NOISSUED + "')");
		}
	    // 项目分类
	    String typeId1 = (String) param.get("typeId1");
	    if (isNotNullOrEmpty(typeId1)){
		    if (isNotNullOrEmpty(typeId1)) {
		    	hql.append(" and t.tprojectApplication.planFlag = '" + typeId1.trim() + "'");
			}
		    String typeId2 = (String) param.get("typeId2");
		    if (isNotNullOrEmpty(typeId2)) {
		    	hql.append(" and t.tprojectApplication.tprojectType.typeId = '" + typeId2.trim() + "'");
			}
	    }
	    else{
	    	String jhlb = (String) param.get("jhlb");
	    	if (isNotNullOrEmpty(jhlb)){
	    		hql.append(" and t.tprojectApplication.tprojectType.typeId in(" + jhlb + ")");
	    	}
	    }
	    
//	    //部门
//	    String deptId = (String) param.get("deptId");
//	    if (isNotNullOrEmpty(deptId)) {
//	    	hql.append(" and t.tprojectApplication.tprojectType.departmentId = '" + deptId.trim() + "'");
//		}
		return hql;
	}
	
	/**
	 * 
	 * @comments 是否为空判断
	 * @param value
	 * @return
	 * @version 1.0
	 */
	public boolean isNotNullOrEmpty(String value){
		if (!"".equals(value) && value != null) {
			return true;
		}
		return false;
	}
}
