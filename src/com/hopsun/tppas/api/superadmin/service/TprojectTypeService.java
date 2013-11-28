package com.hopsun.tppas.api.superadmin.service;

import java.util.List;
import java.util.Map;

import com.hopsun.framework.base.bean.Pager;
import com.hopsun.framework.base.service.BaseService;
import com.hopsun.tppas.entity.TprojectType;

public interface TprojectTypeService extends BaseService<TprojectType, String> {
	
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
	public Pager find(String realName, String showName,String hiddendepartmentId,String hiddenisShow,Integer pageNumber, Integer pageSize);
	
	/**
	 * @Comments 取得除过id的信息
	 * @param id
	 * @return
	 * @Vsersion: 1.0
	 */
	public List<TprojectType> getListExceptId(String id);

	/**
	 * 
	 * @comments 根据部门id取得属于该部门的项目父分类
	 * @param deptId
	 * @return
	 * @version 1.0
	 */
	public List<TprojectType> getFatherProjectTypeListByDeptId(String deptId);

	/**
	 * 
	 * @comments 根据父类型id取得项目子分类
	 * @param deptId
	 * @return
	 * @version 1.0
	 */
	public List<TprojectType> getSonProjectTypeListByDeptId(String parentTypeId);
	
	/**
	 * @comments 取得项目分类显示名称   父类名称-分类名称
	 * @param projectTypeId
	 * @return
	 * @Version 1.0
	 */
	public String getProjectTypeAllName(String projectTypeId);
	
	/**
	 * @comments 得到所有未删除的项目分类
	 * @return
	 * @Version 1.0
	 */
	public Map<String,Object> getAllProjectType();
	
	/**
	 * @comments 根据typeId取得项目类型名称
	 * @param projectTypeId
	 * @return
	 * @Version 1.0
	 */
	public String getProjectTypeName(String projectTypeId);
	
	/**
	 * @comments 取得项目分类
	 * @param projectTypeId
	 * @return
	 * @Version 1.0
	 */
	public String getProjectTypeShowName(String projectTypeId);
	
	/**
	 * @comments  是否显示
	 * @param projectId
	 * @return
	 * @Version 1.0
	 */
	public boolean getIsWrite(String projectId);
	
	/**
	 * @Comments 根据部门id查询列表排除自身
	 * @param id1
	 * @param id2
	 * @return
	 * @Vsersion: 1.0
	 */
	public List<TprojectType> getListByIdAndDepartId(String id1, String id2);
	
	/**
	 * 项目分类添加或修改后加入到缓存中
	 * @comments 
	 * @param projectTypeId
	 * @param addType 类型    save-添加    update-修改 delete-删除
	 * @version 1.0
	 */
	public void addProjectTypeCache(String projectTypeId,String addType);
}
