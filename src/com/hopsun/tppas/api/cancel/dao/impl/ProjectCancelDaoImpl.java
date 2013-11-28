package com.hopsun.tppas.api.cancel.dao.impl;

import java.util.Map;

import org.springframework.stereotype.Repository;

import com.hopsun.framework.base.bean.Finder;
import com.hopsun.framework.base.bean.Pager;
import com.hopsun.framework.base.dao.impl.BaseDaoImpl;
import com.hopsun.tppas.api.cancel.dao.ProjectCancelDao;
import com.hopsun.tppas.common.Constants;
import com.hopsun.tppas.view.VprojectInfoAll;
/**
 * @Comments:   后台Dao实现类-主要用来实现项目撤销操作的接口
 * @author  yk
 * @date 2013-08-01
 * @version 1.0
 *
 */
@Repository
public class ProjectCancelDaoImpl extends BaseDaoImpl<VprojectInfoAll, String> implements ProjectCancelDao {
	
	/**
	 * @comments 项目查询
	 * @param param
	 * @param pageNo
	 * @param pageSize
	 * @return
	 * @Version 1.0
	 */
	public Pager queryProjectInfo(Map<String, Object> param, int pageNo, int pageSize){
		//创建Finder查询对象
		Finder f = Finder.create(" from VprojectInfoAll vpi where vpi.deleteFlag=:deleteFlag");
		// 流程状态 ≠ 开始
		f.append(" and vpi.flowStatus not in ('" + Constants.FLOW_STATUS_START + "')");
		// 部门ID
		String planningFlag = (String) param.get("planningFlag");
	    if (!isNullString(planningFlag) && "1".equals(planningFlag)) {
	    	String typeId1 = (String) param.get("typeId1");
		    if (!isNullString(typeId1)) {
		    	f.append(" and vpi.deptId = '" + typeId1.trim() + "'");
		    }
		} else {
		    String deptId = (String) param.get("deptId");
		    if (!isNullString(deptId)) {
				f.append(" and vpi.deptId = '" + deptId.trim() + "'");
			}
		}
		// 项目名称
	    String projectName = (String) param.get("projectName");
	    if (!isNullString(projectName)) {
			f.append(" and vpi.projectName like '%" + projectName.trim() + "%'");
		}
	    // 承担单位
	    String applicationUnit = (String) param.get("applicationUnit");
	    if (!isNullString(applicationUnit)) {
			f.append(" and vpi.applicationUnit like '%" + applicationUnit.trim() + "%'");
		}
	    // 归口管理部门
	    String centralizedType = (String) param.get("centralizedType");
	    if (!isNullString(centralizedType)) {
			f.append(" and vpi.centralizedType = '" + centralizedType.trim() + "'");
		}
	    // 申报年度
	    String reportYear = (String) param.get("reportYear");
	    if (!isNullString(reportYear)) {
			f.append(" and vpi.reportYear = '" + reportYear.trim() + "'");
		}
	    // 项目分类
	    String typeId2 = (String) param.get("typeId2");
	    if (!isNullString(typeId2)) {
			f.append(" and vpi.planFlag = '" + typeId2.trim() + "'");
		}
	    String typeId3 = (String) param.get("typeId3");
	    if (!isNullString(typeId3)) {
			f.append(" and vpi.typeId = '" + typeId3.trim() + "'");
		}
	    // 所在区域
	    String regionId1 = (String) param.get("regionId1");
	    if (!isNullString(regionId1)) {
			f.append(" and vpi.regionId1 = '" + regionId1.trim() + "'");
		}
	    String regionId2 = (String) param.get("regionId2");
	    if (!isNullString(regionId2)) {
			f.append(" and vpi.regionId2 = '" + regionId2.trim() + "'");
		}
	    String regionId3 = (String) param.get("regionId3");
	    if (!isNullString(regionId3)) {
			f.append(" and vpi.regionId3 = '" + regionId3.trim() + "'");
		}
	    // 单位地址
	    String unitAddress = (String) param.get("unitAddress");
	    if (!isNullString(unitAddress)) {
			f.append(" and vpi.unitAddress like '%" + unitAddress.trim() + "%'");
		}
	    // 行业分类
	    String industries1 = (String) param.get("industries1");
	    if (!isNullString(industries1)) {
			f.append(" and vpi.industries1 = '" + industries1.trim() + "'");
		}
	    String industries2 = (String) param.get("industries2");
	    if (!isNullString(industries2)) {
			f.append(" and vpi.industries2 = '" + industries2.trim() + "'");
		}
	    String industries3 = (String) param.get("industries3");
	    if (!isNullString(industries3)) {
			f.append(" and vpi.industries3 = '" + industries3.trim() + "'");
		}
	    String industries4 = (String) param.get("industries4");
	    if (!isNullString(industries4)) {
			f.append(" and vpi.industries4 = '" + industries4.trim() + "'");
		}
	    // 单位性质
	    String unitProperties = (String) param.get("unitProperties");
	    if (!isNullString(unitProperties)) {
			f.append(" and vpi.unitProperties = '" + unitProperties.trim() + "'");
		}
	    // 项目主要协作单位
	    String assistUnit = (String) param.get("assistUnit");
	    if (!isNullString(assistUnit)) {
			f.append(" and vpi.assistUnit like '%" + assistUnit.trim() + "%'");
		}
	    // 单位所属行业领域
	    String technicalFisld = (String) param.get("technicalFisld");
	    if (!isNullString(technicalFisld)) {
			f.append(" and vpi.technicalFisld = '" + technicalFisld.trim() + "'");
		}
	    // 知识产权状况
	    String intellectualProperty = (String) param.get("intellectualProperty");
	    if (!isNullString(intellectualProperty)) {
			f.append(" and vpi.intellectualProperty = '" + intellectualProperty.trim() + "'");
		}
	    // 技术来源
	    String technologySource = (String) param.get("technologySource");
	    if (!isNullString(technologySource)) {
			f.append(" and vpi.technologySource = '" + technologySource.trim() + "'");
		}
		f.append(" order by vpi.createTime desc");
		
		f.setParam("deleteFlag", Constants.COMMON_STATE_NOTDELETE);
		
		return super.find(f, pageNo, pageSize);
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
