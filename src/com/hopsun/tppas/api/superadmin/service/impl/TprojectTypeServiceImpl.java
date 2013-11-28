/************************* 版权声明 *********************************
 *
 * Copyright (C) 2012 西安辉盛科技发展有限责任公司.
 *
 ******************************************************************
 */
package com.hopsun.tppas.api.superadmin.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import com.hopsun.framework.base.bean.Pager;
import com.hopsun.framework.base.service.impl.BaseServiceImpl;
import com.hopsun.framework.util.StrutsUtil;
import com.hopsun.scenter.api.dept.dao.DeptDao;
import com.hopsun.scenter.entity.ScDept;
import com.hopsun.tppas.api.report.dao.TprojectApplicationDao;
import com.hopsun.tppas.api.superadmin.dao.TprojectTypeDao;
import com.hopsun.tppas.api.superadmin.service.TprojectTypeService;
import com.hopsun.tppas.common.CommonTool;
import com.hopsun.tppas.common.Constants;
import com.hopsun.tppas.entity.TprojectAcceptanceTemplate;
import com.hopsun.tppas.entity.TprojectApplication;
import com.hopsun.tppas.entity.TprojectContractTemplate;
import com.hopsun.tppas.entity.TprojectReportTemplate;
import com.hopsun.tppas.entity.TprojectSupervisionTemplate;
import com.hopsun.tppas.entity.TprojectType;

/**
 * @Comments 项目分类
 * @author wangxiaodong
 * @date 2013-8-27 上午10:55:32
 * @version 1.0
 *
 */
@Service("apitprojectTypeService")
public class TprojectTypeServiceImpl extends BaseServiceImpl<TprojectType,String> implements TprojectTypeService{
	
	/**项目分类DAO*/
	@Resource
	private TprojectTypeDao tprojectTypeDao;
	
	/**部门DAO*/
	@Resource
	private DeptDao deptDao;
	
	/**项目申报DAO*/
	@Resource
	private TprojectApplicationDao tprojectApplicationDao;
	
	@Resource
	public void setBaseDao(TprojectTypeDao tprojectTypeDao) {
		super.setBaseDao(tprojectTypeDao);
	}
	
	/**
	 * @Comments 分页查询
	 * @param realName
	 * @param showName
	 * @param hiddendepartmentId
	 * @param hiddenisShow
	 * @param pageNumber
	 * @param pageSize
	 * @return
	 * @Vsersion: 1.0
	 */
	public Pager find(String realName, String showName,String hiddendepartmentId,String hiddenisShow,Integer pageNumber, Integer pageSize){
		StringBuffer str = new StringBuffer();
		str.append(" From TprojectType m where m.deleteFlag = '0' ");
		
		// 判断realName是否有值
		if (CommonTool.IsNotEmpty(realName)) {
			str.append(" and m.typeRealName like ");
			str.append("'%" + realName + "%'");
		}
		
		// 判断showName是否有值
		if (CommonTool.IsNotEmpty(showName)) {
			str.append(" and m.typeShowName like ");
			str.append("'%" + showName + "%'");
		}
		
		// 判断hiddendepartmentId是否有值
		if (CommonTool.IsNotEmpty(hiddendepartmentId)) {
			str.append(" and m.departmentId = '");
			str.append(hiddendepartmentId + "'");
		}
		
		// 判断hiddendepartmentId是否有值
		if (CommonTool.IsNotEmpty(hiddenisShow)) {
			str.append(" and m.isShow = '");
			str.append(hiddenisShow + "'");
		}
		str.append(" order by tprojectReportTemplate.reportTemplateId");
		Pager pager = tprojectTypeDao.find(str.toString(),pageNumber,pageSize);
		
		// 设计列表中的其他信息
		for (int i=0; i<pager.getList().size(); i++) {
			TprojectType tprojectType = (TprojectType) pager.getList().get(i);
			
			// 判断是否显示内容
			if (tprojectType.getIsShow() == 0) {
				tprojectType.setIsShowName("是"); 
			} else {
				tprojectType.setIsShowName("否");
			}
			//ScDept scdept = deptDao.getDeptByDeptcode(tprojectType.getDepartmentId(), "", "");
			ScDept scdept = deptDao.get(tprojectType.getDepartmentId());
			// 判断部门是否存在
			if (scdept != null) {
				tprojectType.setDepartmentName(scdept.getDeptName());
			}
			
			// 判断该数据是否有父节点
			if (CommonTool.IsNotEmpty(tprojectType.getParentTypeId())) {
				tprojectType.setParentTypeName(tprojectTypeDao.get(tprojectType.getParentTypeId()).getTypeShowName());
			}
		
		}
		return pager;
	}	
	
	/**
	 * @Comments 取得除过id的信息
	 * @param id
	 * @return
	 * @Vsersion: 1.0
	 */
	public List<TprojectType> getListExceptId(String id) {
		StringBuffer str = new StringBuffer();
		str.append(" From TprojectType m where m.deleteFlag = '0' ");
		str.append(" and m.parentTypeId is null ");
		// 判断ID是否为空
		if(CommonTool.IsNotEmpty(id)) {
			str.append(" and m.typeId <> ");
			str.append("'" + id + "'");
		}
		return tprojectTypeDao.getListExceptId(str.toString());
	}

	/**
	 * 根据部门id取得属于该部门的项目父分类
	 */
	@Override
	public List<TprojectType> getFatherProjectTypeListByDeptId(String deptId) {
		
		return tprojectTypeDao.getFatherProjectTypeListByDeptId(deptId);
	}

	/**
	 *  根据父类型id取得项目子分类
	 */
	@Override
	public List<TprojectType> getSonProjectTypeListByDeptId(String parentTypeId) {
		
		return tprojectTypeDao.getSonProjectTypeListByDeptId(parentTypeId);
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
		TprojectType tp = tprojectTypeDao.get(projectTypeId);
		if(tp != null){
			projectTypeName = tp.getTypeShowName();
			TprojectType tpa = tprojectTypeDao.get(tp.getParentTypeId());
			if(tpa != null){
				projectTypePaName = tpa.getTypeShowName();
			}
		}
		
		if(projectTypeName != null && !"".equals(projectTypeName)&& projectTypePaName != null && !"".equals(projectTypePaName)){
			return projectTypeName + Constants.STRING_LINK + projectTypeName;
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
	public Map<String, Object> getAllProjectType() {
		Map<String, Object> valueMap = new HashMap<String, Object>();
		List<TprojectType> all = tprojectTypeDao.getAllProjectType();
		if (all != null && all.size() > 0) {
			for (int i = 0; i < all.size(); i++) {
				TprojectType projectType = all.get(i);
				if (projectType != null) {
					// 项目申报模板
					TprojectReportTemplate tprojectReportTemplate = projectType.getTprojectReportTemplate();
					if (tprojectReportTemplate != null) {
						// SAVE_URL as 保存地址,
						valueMap.put(projectType.getTypeId() + "-sb-save",tprojectReportTemplate.getSaveUrl());
						// UPDATE_URL as 修改地址,
						valueMap.put(projectType.getTypeId() + "-sb-edit",tprojectReportTemplate.getUpdateUrl());
						// VIEW_URL as 查看地址,
						valueMap.put(projectType.getTypeId() + "-sb-view",tprojectReportTemplate.getViewUrl());
						// DELETE_URL as 删除地址,
						valueMap.put(projectType.getTypeId() + "-sb-delete",tprojectReportTemplate.getDeleteUrl());
						// TRIAL_URL as 初审地址,
						valueMap.put(projectType.getTypeId() + "-sb-trial",tprojectReportTemplate.getTrialUrl());
						// AUDIT_URL as 审核地址,
						valueMap.put(projectType.getTypeId() + "-sb-audit",tprojectReportTemplate.getAuditUrl());
						// EXPERT_AUDIT_URL as 专家评审地址,
						valueMap.put(projectType.getTypeId() + "-sb-expert-audit",tprojectReportTemplate.getExpertAuditUrl());
						// EXPERT_PROOF_URL as 专家论证地址,
						valueMap.put(projectType.getTypeId() + "-sb-expert-proof", tprojectReportTemplate.getExpertProofUrl());
						// LEADERSHIP_AUDIT_URL as 处长审核地址,
						valueMap.put(projectType.getTypeId() + "-sb-leadership",tprojectReportTemplate.getLeadershipAuditUrl());
						// MEETING_AUDIT_URL as 联席会审核地址,
						valueMap.put(projectType.getTypeId() + "-sb-meeting", tprojectReportTemplate.getMeetingAuditUrl());
					}
					// 项目合同模板
					TprojectContractTemplate tprojectContractTemplate = projectType.getTprojectContractTemplate();
					if (tprojectContractTemplate != null) {
						// SAVE_URL as 保存地址,
						valueMap.put(projectType.getTypeId() + "-ht-save",tprojectContractTemplate.getSaveUrl());
						// UPDATE_URL as 修改地址,
						valueMap.put(projectType.getTypeId() + "-ht-edit",tprojectContractTemplate.getUpdateUrl());
						// DELETE_URL as 删除地址,
						valueMap.put(projectType.getTypeId() + "-ht-delete",tprojectContractTemplate.getDeleteUrl());
						// VIEW_URL as 查看地址,
						valueMap.put(projectType.getTypeId() + "-ht-view",tprojectContractTemplate.getViewUrl());
						// AUDIT_URL as 审核地址,
						valueMap.put(projectType.getTypeId() + "-ht-audit",tprojectContractTemplate.getAuditUrl());
					}
					// 项目监理模板
					TprojectSupervisionTemplate tprojectSupervisionTemplate = projectType.getTprojectSupervisionTemplate();
					if (tprojectSupervisionTemplate != null) {
						// SAVE_URL as 保存地址,
						valueMap.put(projectType.getTypeId() + "-jl-save",tprojectSupervisionTemplate.getSaveUrl());
						// UPDATE_URL as 修改地址,
						valueMap.put(projectType.getTypeId() + "-jl-edit",tprojectSupervisionTemplate.getUpdateUrl());
						// DELETE_URL as 删除地址,
						valueMap.put(projectType.getTypeId() + "-jl-delete",tprojectSupervisionTemplate.getDeleteUrl());
						// VIEW_URL as 查看地址,
						valueMap.put(projectType.getTypeId() + "-jl-view",tprojectSupervisionTemplate.getViewUrl());
						// AUDIT_URL as 审核地址,
						valueMap.put(projectType.getTypeId() + "-jl-audit",tprojectSupervisionTemplate.getAuditUrl());
					}
					// 项目验收模板
					TprojectAcceptanceTemplate tprojectAcceptanceTemplate = projectType.getTprojectAcceptanceTemplate();
					if (tprojectAcceptanceTemplate != null) {
						// SAVE_URL as 保存地址,
						valueMap.put(projectType.getTypeId() + "-ys-save",tprojectAcceptanceTemplate.getSaveUrl());
						// UPDATE_URL as 修改地址,
						valueMap.put(projectType.getTypeId() + "-ys-edit",tprojectAcceptanceTemplate.getUpdateUrl());
						// DELETE_URL as 删除地址,
						valueMap.put(projectType.getTypeId() + "-ys-delete",tprojectAcceptanceTemplate.getDeleteUrl());
						// VIEW_URL as 查看地址,
						valueMap.put(projectType.getTypeId() + "-ys-view",tprojectAcceptanceTemplate.getViewUrl());
						// AUDIT_URL as 审核地址,
						valueMap.put(projectType.getTypeId() + "-ys-audit",tprojectAcceptanceTemplate.getAuditUrl());
					}
				}

			}
		}
		return valueMap;
	}
	
	/**
	 * @comments 根据typeId取得项目类型名称
	 * @param projectTypeId
	 * @return
	 * @Version 1.0
	 */
	public String getProjectTypeName(String projectTypeId){
		
		String projectTypeName = "";
		
		// 取得项目类型对象
		TprojectType tp = tprojectTypeDao.get(projectTypeId);
		
		if(tp !=null){
			
			// 设置项目类型显示名称
			projectTypeName = tp.getTypeShowName();
		}
		
		return projectTypeName;
	}
	
	/**
	 * @comments 取得项目分类
	 * @param projectTypeId
	 * @return
	 * @Version 1.0
	 */
	public String getProjectTypeShowName(String projectTypeId){
		
		String projectTypeName = "";
		
		String projectTypePaName = "";
		// 取得项目类型对象
		TprojectType tp = tprojectTypeDao.get(projectTypeId);
		if(tp != null){
			projectTypeName = tp.getTypeShowName();
			
			TprojectType tpa = tprojectTypeDao.get(tp.getParentTypeId());
			if(tpa != null){
				projectTypePaName = tpa.getTypeShowName();
			}
		}
		
		if(projectTypeName != null && !"".equals(projectTypeName)
				&& projectTypePaName != null && !"".equals(projectTypePaName)){
			return projectTypeName + Constants.STRING_LINK + projectTypeName;
		}
		else{
			return "";
		}
	}
	
	/**
	 * @comments  是否显示
	 * @param projectId
	 * @return
	 * @Version 1.0
	 */
	public boolean getIsWrite(String projectId){
		
		TprojectApplication tp = tprojectApplicationDao.get(projectId);
		
		if(tp !=null){
			
			Long isWrite = tp.getTprojectType().getIsWrite();
			if(isWrite == 0){
				return true;
			}
		}
		return false;
	}
	
	/**
	 * @Comments 根据部门id查询列表排除自身
	 * @param id1
	 * @param id2
	 * @return
	 * @Vsersion: 1.0
	 */
	public List<TprojectType> getListByIdAndDepartId(String id1, String id2) {
		StringBuffer str = new StringBuffer();
		str.append(" From TprojectType m where m.deleteFlag = '0' ");
		str.append("and m.departmentId = '" + id1 + "'");
		if (id2 != null && !"".equals(id2)) {
			str.append(" and m.typeId <> '" + id2 + "'");
		}
		return tprojectTypeDao.getListExceptId(str.toString());
	}

	/**
	 * 项目分类添加或修改后加入到缓存中
	 * @comments 
	 * @param projectTypeId
	 * @param addType 类型    save-添加    update-修改 delete-删除
	 * @version 1.0
	 */
	public void addProjectTypeCache(String projectTypeId,String addType) {
		Map<String,Object> valueMap = new HashMap<String,Object>();
		TprojectType tprojectType = tprojectTypeDao.get(projectTypeId);
		if (tprojectType != null) {
			// 项目申报模板
			TprojectReportTemplate tprojectReportTemplate = tprojectType.getTprojectReportTemplate();
			if (tprojectReportTemplate != null) {
				// SAVE_URL as 保存地址,
				valueMap.put(tprojectType.getTypeId() + "-sb-save",tprojectReportTemplate.getSaveUrl());
				// UPDATE_URL as 修改地址,
				valueMap.put(tprojectType.getTypeId() + "-sb-edit",tprojectReportTemplate.getUpdateUrl());
				// VIEW_URL as 查看地址,
				valueMap.put(tprojectType.getTypeId() + "-sb-view",tprojectReportTemplate.getViewUrl());
				// DELETE_URL as 删除地址,
				valueMap.put(tprojectType.getTypeId() + "-sb-delete",tprojectReportTemplate.getDeleteUrl());
				// TRIAL_URL as 初审地址,
				valueMap.put(tprojectType.getTypeId() + "-sb-trial",tprojectReportTemplate.getTrialUrl());
				// AUDIT_URL as 审核地址,
				valueMap.put(tprojectType.getTypeId() + "-sb-audit",tprojectReportTemplate.getAuditUrl());
				// EXPERT_AUDIT_URL as 专家评审地址,
				valueMap.put(tprojectType.getTypeId() + "-sb-expert-audit",tprojectReportTemplate.getExpertAuditUrl());
				// EXPERT_PROOF_URL as 专家论证地址,
				valueMap.put(tprojectType.getTypeId() + "-sb-expert-proof", tprojectReportTemplate.getExpertProofUrl());
				// LEADERSHIP_AUDIT_URL as 处长审核地址,
				valueMap.put(tprojectType.getTypeId() + "-sb-leadership",tprojectReportTemplate.getLeadershipAuditUrl());
				// MEETING_AUDIT_URL as 联席会审核地址,
				valueMap.put(tprojectType.getTypeId() + "-sb-meeting", tprojectReportTemplate.getMeetingAuditUrl());
			}
			// 项目合同模板
			TprojectContractTemplate tprojectContractTemplate = tprojectType.getTprojectContractTemplate();
			if (tprojectContractTemplate != null) {
				// SAVE_URL as 保存地址,
				valueMap.put(tprojectType.getTypeId() + "-ht-save",tprojectContractTemplate.getSaveUrl());
				// UPDATE_URL as 修改地址,
				valueMap.put(tprojectType.getTypeId() + "-ht-edit",tprojectContractTemplate.getUpdateUrl());
				// DELETE_URL as 删除地址,
				valueMap.put(tprojectType.getTypeId() + "-ht-delete",tprojectContractTemplate.getDeleteUrl());
				// VIEW_URL as 查看地址,
				valueMap.put(tprojectType.getTypeId() + "-ht-view",tprojectContractTemplate.getViewUrl());
				// AUDIT_URL as 审核地址,
				valueMap.put(tprojectType.getTypeId() + "-ht-audit",tprojectContractTemplate.getAuditUrl());
			}
			// 项目监理模板
			TprojectSupervisionTemplate tprojectSupervisionTemplate = tprojectType.getTprojectSupervisionTemplate();
			if (tprojectSupervisionTemplate != null) {
				// SAVE_URL as 保存地址,
				valueMap.put(tprojectType.getTypeId() + "-jl-save",tprojectSupervisionTemplate.getSaveUrl());
				// UPDATE_URL as 修改地址,
				valueMap.put(tprojectType.getTypeId() + "-jl-edit",tprojectSupervisionTemplate.getUpdateUrl());
				// DELETE_URL as 删除地址,
				valueMap.put(tprojectType.getTypeId() + "-jl-delete",tprojectSupervisionTemplate.getDeleteUrl());
				// VIEW_URL as 查看地址,
				valueMap.put(tprojectType.getTypeId() + "-jl-view",tprojectSupervisionTemplate.getViewUrl());
				// AUDIT_URL as 审核地址,
				valueMap.put(tprojectType.getTypeId() + "-jl-audit",tprojectSupervisionTemplate.getAuditUrl());
			}
			// 项目验收模板
			TprojectAcceptanceTemplate tprojectAcceptanceTemplate = tprojectType.getTprojectAcceptanceTemplate();
			if (tprojectAcceptanceTemplate != null) {
				// SAVE_URL as 保存地址,
				valueMap.put(tprojectType.getTypeId() + "-ys-save",tprojectAcceptanceTemplate.getSaveUrl());
				// UPDATE_URL as 修改地址,
				valueMap.put(tprojectType.getTypeId() + "-ys-edit",tprojectAcceptanceTemplate.getUpdateUrl());
				// DELETE_URL as 删除地址,
				valueMap.put(tprojectType.getTypeId() + "-ys-delete",tprojectAcceptanceTemplate.getDeleteUrl());
				// VIEW_URL as 查看地址,
				valueMap.put(tprojectType.getTypeId() + "-ys-view",tprojectAcceptanceTemplate.getViewUrl());
				// AUDIT_URL as 审核地址,
				valueMap.put(tprojectType.getTypeId() + "-ys-audit",tprojectAcceptanceTemplate.getAuditUrl());
			}
		}
		
		if(valueMap!=null&&valueMap.size()>0){
			for(Map.Entry<String,Object> entry : valueMap.entrySet()){
				//添加
				if("save".equals(addType)){
					StrutsUtil.getApplication().setAttribute(entry.getKey(), entry.getValue());
				}else if("update".equals(addType)){
				//修改
					StrutsUtil.getApplication().removeAttribute(entry.getKey());
					StrutsUtil.getApplication().setAttribute(entry.getKey(), entry.getValue());
				}else if("delete".equals(addType)){
				//删除
					StrutsUtil.getApplication().removeAttribute(entry.getKey());
				}	
			}
		}
	}
}
