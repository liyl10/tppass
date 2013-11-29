/*************** 版权声明***************
*
* Copyright (C) 2012 西安辉盛科技发展有限责任公司.
*
********************************************
*/
package com.hopsun.tppas.api.supervisor.dao.impl;

import java.util.List;
import java.util.Map;

import com.hopsun.tppas.api.supervisor.dao.TsupervisorDao;
import com.hopsun.tppas.common.CommonTool;
import com.hopsun.tppas.common.Constants;
import com.hopsun.framework.base.bean.Finder;
import com.hopsun.framework.base.bean.Pager;
import com.hopsun.framework.base.dao.impl.BaseDaoImpl;
import com.hopsun.tppas.entity.Tsupervisor;
import org.springframework.stereotype.Repository;
/**
 * @Comments:   后台Dao接口-主要用来实现项目监理操作的接口
 * @author  yk
 * @date 2013-08-09
 * @version 1.0
 *
 */
@Repository
public class TsupervisorDaoImpl extends BaseDaoImpl<Tsupervisor, String> implements TsupervisorDao {
	
	/**
	 * 查询待验收项目
	 * @param supervisorState
	 * @return
	 */   
	public List<Tsupervisor> queryTsupervisorByState(String supervisorState) {
		String hql=" from  Tsupervisor supervisor left" +
				" join fetch supervisor.tprojectApplication where supervisor.supervisorState=?";
		return createQueryList(hql, new String[]{supervisorState});
	}

	/**
	 * 项目监理列表
	 * @comments 
	 * @param param
	 * @param pageNo
	 * @param pageSize
	 * @return
	 * @version 1.0
	 */
	public Pager supervisorList(Map<String, Object> param,int pageNo, int pageSize) {
		StringBuffer hql = new StringBuffer(" from Tsupervisor t where 1=1");
		//项目名称
		String projectName = (String) param.get("projectName");
		if(CommonTool.IsNotEmpty(projectName)){
			hql.append(" and t.tprojectApplication.projectName like '%"+projectName+"%'");
		}
		//申报单位
		String applicationUnit = (String) param.get("applicationUnit");
		if(CommonTool.IsNotEmpty(applicationUnit)){
			hql.append(" and t.tprojectApplication.applicationUnit like '%"+applicationUnit+"%'");
		}
		//项目分类一级
		String planFlag = (String) param.get("planFlag");
		if(CommonTool.IsNotEmpty(planFlag)){
			hql.append(" and t.tprojectApplication.planFlag= '"+planFlag+"'");
		}
		//项目分类二级
		String typeId = (String) param.get("typeId");
		if(CommonTool.IsNotEmpty(typeId)){
			hql.append(" and t.tprojectApplication.tprojectType.typeId= '"+typeId+"'");
		}
		//监理状态
		String supervisorState = (String) param.get("supervisorState");
		if(CommonTool.IsNotEmpty(supervisorState)){
			hql.append(" and t.supervisorState= '"+supervisorState+"'");
		}
		//所属部门项目分类字符串
		String typeIdStr = (String)param.get("typeIdStr");
		if(CommonTool.IsNotEmpty(typeIdStr)){
			hql.append(" and t.tprojectApplication.tprojectType.typeId in ( "+typeIdStr+")");
		}
		//默认查询未删除
		hql.append(" and t.deleteFlag="+Constants.COMMON_STATE_NOTDELETE);
		//排序
		hql.append(" order by t.createTime desc ");
		
		Finder f = Finder.create(hql.toString());
		return super.find(f, pageNo, pageSize);
	}
}
