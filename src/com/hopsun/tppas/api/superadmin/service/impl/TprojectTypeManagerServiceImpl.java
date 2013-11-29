/************************* 版权声明 *********************************
 *
 * Copyright (C) 2012 西安辉盛科技发展有限责任公司.
 *
 ******************************************************************
 */
package com.hopsun.tppas.api.superadmin.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import com.hopsun.framework.base.service.impl.BaseServiceImpl;
import com.hopsun.scenter.entity.ScDept;
import com.hopsun.scenter.entity.ScUsers;
import com.hopsun.tppas.api.superadmin.dao.TprojectTypeDao;
import com.hopsun.tppas.api.superadmin.dao.TprojectTypeManagerDao;
import com.hopsun.tppas.api.superadmin.service.TprojectTypeManagerService;
import com.hopsun.tppas.common.CommonTool;
import com.hopsun.tppas.common.Constants;
import com.hopsun.tppas.entity.TprojectType;
import com.hopsun.tppas.entity.TprojectTypeManager;

/**
 * @comments 计划类别管理专员
 * @author wangxiaodong
 * @date 2013-10-23
 * @version 1.0
 */
@Service
public class TprojectTypeManagerServiceImpl extends BaseServiceImpl<TprojectTypeManager,String> implements TprojectTypeManagerService{
	
	/**计划类别管理专员DAO*/
	@Resource
	private TprojectTypeManagerDao tprojectTypeManagerDao;
	
	/**计划类别DAO**/
	@Resource
	private TprojectTypeDao tprojectTypeDao;
	
	@Resource
	public void setBaseDao(TprojectTypeManagerDao tprojectTypeManagerDao) {
		super.setBaseDao(tprojectTypeManagerDao);
	}


	/**
	 *通过条件查询计划类别管理专员
	 * @comments 
	 * @param valueMap
	 * @return
	 * @version 1.0
	 */
	public TprojectTypeManager getTprojectTypeManager(Map<String, Object> valueMap) {
		TprojectTypeManager tprojectTypeManager = new TprojectTypeManager();
		List<TprojectTypeManager> all = tprojectTypeManagerDao.getTprojectTypeManager(valueMap);
		if(all!=null&&all.size()>0){
			tprojectTypeManager = all.get(0);
		}
		return tprojectTypeManager;
	}


	/**
	 * 保存计划类别管理专员信息
	 * @comments 
	 * @param user
	 * @param tprojectTypeManager
	 * @version 1.0
	 */
	public void saveTprojectTypeManager(ScUsers user, TprojectTypeManager tprojectTypeManager) {
		//修改
		if(tprojectTypeManager.getTypeManagerId()!=null&&tprojectTypeManager.getTypeManagerId().length()>0){
			//如果没有选择专员，就删除计划类别专员的信息
			if(CommonTool.IsEmpty(tprojectTypeManager.getUserId())){
				tprojectTypeManagerDao.delete(tprojectTypeManager);
			}else{
				//如果选择了专员，就更新计划类别专员的信息
				tprojectTypeManager.setUpdateDate(new java.sql.Timestamp(new java.util.Date().getTime()));
				tprojectTypeManager.setUpdateUser(user.getUserId());
				tprojectTypeManagerDao.update(tprojectTypeManager);
			}
		}else{//添加
			tprojectTypeManager.setDeleteFlag(Constants.COMMON_STATE_NOTDELETE);
			tprojectTypeManager.setCreateTime(new java.sql.Timestamp(new java.util.Date().getTime()));
			tprojectTypeManager.setCreateUser(user.getUserId());	
			tprojectTypeManagerDao.save(tprojectTypeManager);
		}		
	}
	
	/**
	 * 通过用户得到用户对应的计划类别字符串  例如：1,2,3
	 * @comments 
	 * @param user
	 * @return
	 * @version 1.0
	 */
	public String getProjectTypeStrByUser(ScUsers user){
		String ProjectTypeS = "";
		StringBuffer projectTypeStr = new StringBuffer();
		//用户所属部门
		ScDept dept = user.getScDept();
		
		/***********************计财处*********************************/
		if(dept!=null){
			if(Constants.PLANNING_DEPARTMENT.equals(dept.getDeptId())){
				return ProjectTypeS;
			}
		}
		
		/************************其它处室*******************************/
		//用户ID
		String userId = user.getUserId();
		Map<String,Object> valueMap = new HashMap<String,Object>();
		valueMap.put("userId", userId);
		//用户是否是计划类别的管理专员
		List<TprojectTypeManager> projectTypeManagerList = tprojectTypeManagerDao.getTprojectTypeManager(valueMap);
		if(projectTypeManagerList!=null&&projectTypeManagerList.size()>0){
			for(TprojectTypeManager tprojectTypeManager : projectTypeManagerList){
				if(tprojectTypeManager!=null){
					String typeId = tprojectTypeManager.getTypeId();
					//List<TprojectType> tprojectTypeList = tprojectTypeDao.getSonProjectTypeListByDeptId(typeId);
					//if(tprojectTypeList!=null&&tprojectTypeList.size()>0){
						//for(TprojectType tprojectType : tprojectTypeList){
							projectTypeStr.append("'");
							projectTypeStr.append(typeId);
							projectTypeStr.append("',");
							//projectTypeStr.append(",");
						//}
					//}
				}
			}
			ProjectTypeS = projectTypeStr.toString();
			if (ProjectTypeS != null && ProjectTypeS.length() > 0) {
				ProjectTypeS = ProjectTypeS.substring(0, ProjectTypeS.length() - 1);
			}
		}else{
			if(dept!=null){
				List<TprojectType> projectTypeList = tprojectTypeDao.getList("departmentId", dept.getDeptId());
				for (TprojectType tprojectType : projectTypeList) {
					//排除一级分类
					if(tprojectType.getParentTypeId()!=null&&tprojectType.getParentTypeId().length()>0){
						projectTypeStr.append("'");
						projectTypeStr.append(tprojectType.getTypeId());
						projectTypeStr.append("',");
						//projectTypeStr.append(",");
					}
				}
				
				ProjectTypeS = projectTypeStr.toString();
				if (ProjectTypeS != null && ProjectTypeS.length() > 0) {
					ProjectTypeS = ProjectTypeS.substring(0, ProjectTypeS.length() - 1);
				}
			}
	
		}
		return ProjectTypeS;
	}


	/**
	 * 通过用户得到用户对应的计划类别集合
	 * @comments 
	 * @param user
	 * @return
	 * @version 1.0
	 */
	public List<TprojectType> getProjectTypeListByUser(ScUsers user) {
		List<TprojectType> TprojectTypeList = new ArrayList<TprojectType>();
		
		//用户所属部门
		ScDept dept = user.getScDept();
		
		/***********************计财处*********************************/
		if(dept!=null){
			if(Constants.PLANNING_DEPARTMENT.equals(dept.getDeptId())){
				List<TprojectType> projectTypeListFirst = tprojectTypeDao.getAllProjectTypeFirst();
				if(projectTypeListFirst!=null&&projectTypeListFirst.size()>0){
					TprojectTypeList.addAll(projectTypeListFirst);
				}
				return TprojectTypeList;
			}
		}
		
		/************************其它处室*******************************/
		//用户ID
		String userId = user.getUserId();
		Map<String,Object> valueMap = new HashMap<String,Object>();
		valueMap.put("userId", userId);
		//用户是否是计划类别的管理专员
		List<TprojectTypeManager> projectTypeManagerList = tprojectTypeManagerDao.getTprojectTypeManager(valueMap);
		if(projectTypeManagerList!=null&&projectTypeManagerList.size()>0){
			for(TprojectTypeManager tprojectTypeManager : projectTypeManagerList){
				if(tprojectTypeManager!=null){
					String typeId = tprojectTypeManager.getTypeId();
					TprojectType projectType = tprojectTypeDao.get(typeId);
					TprojectTypeList.add(projectType);
				}
			}
		}else{
			if(dept!=null){
				List<TprojectType> projectTypeList = tprojectTypeDao.getFatherProjectTypeListByDeptId(dept.getDeptId());
				if(projectTypeList!=null&&projectTypeList.size()>0){
					TprojectTypeList.addAll(projectTypeList);
				}
			}
	
		}
		return TprojectTypeList;
	}


	/**
	 * 判断用户是项目分类专员还是部门管理员
	 * @comments 
	 * @param user
	 * @return
	 * @version 1.0
	 */
	public boolean getManagerPurview(ScUsers user) {
		boolean flag = true;
		//用户所属部门
		ScDept dept = user.getScDept();
		//用户ID
		String userId = user.getUserId();
		Map<String,Object> valueMap = new HashMap<String,Object>();
		valueMap.put("userId", userId);
		
		/***********************计财处*********************************/
		if(dept!=null){
			if(Constants.PLANNING_DEPARTMENT.equals(dept.getDeptId())){
				return true;
			}
		}
		
		/************************其它处室*******************************/
		//用户是否是计划类别的管理专员
		List<TprojectTypeManager> projectTypeManagerList = tprojectTypeManagerDao.getTprojectTypeManager(valueMap);
		if(projectTypeManagerList!=null&&projectTypeManagerList.size()>0){
			flag = false;
		}else{
			if(dept!=null){
				List<TprojectType> projectTypeList = tprojectTypeDao.getList("departmentId", dept.getDeptId());
				if(projectTypeList!=null&&projectTypeList.size()>0){
					flag = true;
				}
			}
	
		}
		return flag;
	}
	
	/**
	 * 得到专员用户管理的项目分类对象
	 * @comments 
	 * @param user
	 * @return
	 * @version 1.0
	 */
	public TprojectType getTprojectTypeByUser(ScUsers user){
		TprojectType tprojectType = new TprojectType();
		Map<String,Object> valueMap = new HashMap<String,Object>();
		valueMap.put("userId", user.getUserId());
		List<TprojectTypeManager> all = tprojectTypeManagerDao.getTprojectTypeManager(valueMap);
		if(all!=null&&all.size()>0){
			TprojectTypeManager tprojectTypeManager = all.get(0);
			if(tprojectTypeManager!=null){
				tprojectType = tprojectTypeDao.get(tprojectTypeManager.getTypeId());
			}
		}
		
		return tprojectType;
	}
	
}
