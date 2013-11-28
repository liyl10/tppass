/************************* 版权声明 *********************************
 *
 * Copyright (C) 2012 西安辉盛科技发展有限责任公司.
 *
 ******************************************************************
 */

package com.hopsun.scenter.api.dept.service.impl;


import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.hopsun.framework.base.bean.Pager;
import com.hopsun.framework.base.service.impl.BaseServiceImpl;
import com.hopsun.framework.util.StrutsUtil;
import com.hopsun.scenter.api.dept.dao.DeptDao;
import com.hopsun.scenter.api.dept.service.DeptService;
import com.hopsun.scenter.entity.ScDept;
import com.hopsun.scenter.entity.ScUsers;
import com.hopsun.subgroups.paramconfig.bean.ParamConfigBean;
import com.hopsun.subgroups.paramconfig.util.ParamConfigUtil;

/**
 * @Comments:   Service实现类 - 管理员
 * @author dulei(dulei@hopsun.cn)
 * @date 2012-11-25 15:56:32
 * @version 1.0
 *
 */
@Service
public class DeptServiceImpl extends BaseServiceImpl<ScDept, String> implements DeptService {
	
	@Resource
	private DeptDao deptDao;

	@Resource
	public void setBaseDao(DeptDao deptDao) {
		super.setBaseDao(deptDao);
	}
	
	/**
	 * 分页查询
	 *@param dept pageNo pageSize 
	 *@return Pager
	 *
	 */
	public Pager find(ScDept dept,int pageNo, int pageSize){
		return deptDao.find(dept, pageNo, pageSize);
	};
	
	/**
	 * 
	 * @comments 查询所有未删除、审核通过、启用的部门信息
	 * @param dept
	 * @return
	 * @version 1.0
	 */
	public List<ScDept> findDept(ScDept dept){
		return deptDao.findDept(dept);
	}

	/**
	 * 根据部门名称获取部门对象，若不存在，则返回null（不区分大小写）
	 *@param deptname deptid parentid
	 *@return ScDept
	 *
	 */
	public ScDept getDeptByDeptname(String deptname,String deptid,String parentid) {
		return deptDao.getDeptByDeptname(deptname, deptid, parentid);
	}
	
	/**
	 * 根据部门CODE获取部门对象，若不存在，则返回null（不区分大小写）
	 *@param deptcode deptid parentid
	 *@return ScDept
	 *
	 */
	public ScDept getDeptByDeptcode(String deptcode,String deptid,String parentid){
		return deptDao.getDeptByDeptcode(deptcode, deptid, parentid);
	}

	/**
	 * 查询所有未删除、审核通过、启用的部门信息,返回json格式字符串
	 * @return
	 */
	public String getDeptListJson(ScUsers user,ScDept dept) {
		String nodesvee = null;
		ScDept selectedDept=null;
		if(user!=null){
			selectedDept = user.getScDept();
		}else {
			selectedDept = dept.getScDept();
		}
		List<ScDept> dept_available=deptDao.findDept(dept);;
		if(dept_available!=null && dept_available.size()>0){
			StringBuffer strres = new StringBuffer(""); // 存放所有节点数据
			String checked = "false"; // 是否选中的标志。
			String parentid = "";
			String open = "true"; // 是否展开标志
			strres.append("[");
			//int i = 0;
			for(ScDept perdept:dept_available){
				if (perdept.getScDept()!= null && perdept.getScDept().getDeptId()!= null) {
					parentid = perdept.getScDept().getDeptId();
				} else {
					parentid = "";
				}
				if (perdept.equals(selectedDept)) {
					checked = "true";
				} else {
					checked = "false";
				}
//				if (perUser.getScUserses()!= null && i<2) {
//					open = "true";
//					i++;
//				} else {
//					open = "false";
//					i++;
//				}
				 
				
				strres.append("{id:'" + perdept.getDeptId() + "',pId:'" + parentid + "',name:'" + perdept.getDeptName().replaceAll("\'", "\\\\'") + "',open:" + open + ",checked:" + checked + "},");
			}
			strres.deleteCharAt(strres.length() - 1); // 删除最后一个多余的逗号。
			strres.append("]");
			nodesvee = strres.toString();
		}
		return nodesvee;
	}
	
	/**
	 * 更新部门信息
	 * @return
	 */
	public Map<String,Object> updateDept(ScDept scDept) {
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("msg", "1");
		
		//若部门下存在未删除的用户，则不能删除部门
		Set<ScUsers> scUserses =scDept.getScUserses();
		Set<ScDept> scDepts =scDept.getScDepts();
		
		String deleteState = ((ParamConfigBean)StrutsUtil.getApplication().getAttribute("DEL_STATE")).getValueByCode("enable");
		//部门中存在用户
		if(scUserses!=null && scUserses.size()>0){
			for(ScUsers user:scUserses){
				if (user.getDeleteState().equals(deleteState)){
					//部门中存在用户，
					String error = String.valueOf(ParamConfigUtil.getServletContext().getAttribute("validform.scenter.dept.delete.user.error"));
					result.put("msg", scDept.getDeptName() + error);
					scDept.setDeleteState(deleteState);
					return result;
				}
			}
		}
		//部门有下级部门
		if(null!=scDepts && scDepts.size()>0){
			for(ScDept dept : scDepts){
				if (dept.getDeleteState().equals(deleteState)){
					//部门中存在下级部门，
					String error = String.valueOf(ParamConfigUtil.getServletContext().getAttribute("validform.scenter.dept.delete.child.error"));
					result.put("msg", scDept.getDeptName() + error);
					scDept.setDeleteState(deleteState);
					return result;
				}
			}
		}
		scDept.setDeleteState(((ParamConfigBean)StrutsUtil.getApplication().getAttribute("DEL_STATE")).getBeansByCode("disable").getValue());
		deptDao.update(scDept);
		
		return result;
	}
		 
	 
	/**
	 * 更改启用状态
	 * 
	 * @return
	 */
	public Map<String, Object> updateDeptEnableState(String deptId, String enableState) {
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("msg", "0");
		if (deptId == null || "".equals(deptId)) {
			return result;
		}
		// 获取实体
		ScDept scDept = deptDao.get(deptId);
		if (scDept != null) {
			scDept.setEnableState(enableState);
			deptDao.update(scDept);
			result.put("info", "[{'info':'true'}]");
			result.put("msg", "1");
		}
		return result;
	}


}