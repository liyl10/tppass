package com.hopsun.scenter.api.dept.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.hopsun.framework.base.bean.Finder;
import com.hopsun.framework.base.bean.Pager;
import com.hopsun.framework.base.dao.impl.BaseDaoImpl;
import com.hopsun.framework.util.StrutsUtil;
import com.hopsun.scenter.api.dept.dao.DeptDao;
import com.hopsun.scenter.entity.ScDept;
import com.hopsun.subgroups.paramconfig.bean.ParamConfigBean;

/**
 * @Comments:   Dao实现类 - 部门管理，该实现从BaseDaoImpl继承，具备基础的持久化操作的所有方法，相对复杂的业务sql需要在实现中编写
 * @author dulei(dulei@hopsun.cn)
 * @date 2012-12-26 16:52:32
 * @version 1.0
 *
 */
@Repository
@SuppressWarnings("unchecked")
public class DeptDaoImpl extends BaseDaoImpl<ScDept, String> implements DeptDao {

	/**
	 * 分页查询 根据部门名称、领导、联系人、审核状态、启用状态分页查询部门信息
	 *@param dept pageNo pageSize 
	 *@return Pager
	 *
	 */
	public Pager find(ScDept dept, int pageNo, int pageSize) {
		//创建Finder查询对象
		Finder f = Finder.create("from ScDept d where d.deleteState=:deleteState");
		//未删除
		f.setParam("deleteState", ((ParamConfigBean)StrutsUtil.getApplication().getAttribute("DEL_STATE")).getValueByCode("enable"));
		
		if(null != dept){
			//部门名称
			if(null != dept.getDeptName() && dept.getDeptName().trim().length()>0){
				f.append(" and lower(d.deptName) like lower(:deptName)").setParam("deptName", "%" + dept.getDeptName().trim() + "%");
			}
			//上级部门
			if(null != dept.getScDept() && dept.getScDept().getDeptId().trim().length()>0){
				f.append(" and d.scDept.deptId =:deptId").setParam("deptId", dept.getScDept().getDeptId().trim());
			}
			//部门领导
			if(null != dept.getDeptLeader() && dept.getDeptLeader().trim().length()>0){
				f.append(" and lower(d.deptLeader) like lower(:deptLeader)").setParam("deptLeader", "%" + dept.getDeptLeader() + "%");
			}
			//联系人
			if(null != dept.getDeptLinkman() && dept.getDeptLinkman().trim().length()>0){
				f.append(" and lower(d.deptLinkman) like lower(:deptLinkman)").setParam("deptLinkman", "%" + dept.getDeptLinkman() + "%");
			}
			//审核状态
			if(null != dept.getVerifyState() && dept.getVerifyState().trim().length()>0){
				f.append(" and d.verifyState =:verifyState").setParam("verifyState", dept.getVerifyState());
			}
			//启用状态
			if(null != dept.getEnableState() && dept.getEnableState().trim().length()>0){
				f.append(" and d.enableState=:enableState").setParam("enableState", dept.getEnableState());
			}
			
		}
		//排序条件
		f.append(" order by d.deptOrder desc, d.deptId desc, d.createDate desc");
		//查询、返回
		return super.find(f, pageNo, pageSize);
	}
	
	/**
	 * 
	 * @comments 查询所有未删除、审核通过、启用的部门信息 （已启用、审核通过、未删除）
	 * @param dept
	 * @return
	 * @version 1.0
	 */
	public List<ScDept> findDept(ScDept dept) {
		//创建Finder查询对象
		Finder f = Finder.create("from ScDept d where d.enableState=:enableState and d.verifyState=:verifyState and d.deleteState=:deleteState");
		
		//已启用
		f.setParam("enableState", ((ParamConfigBean)StrutsUtil.getApplication().getAttribute("CONFIG_STATE")).getValueByCode("enable"));
		//审核通过
		f.setParam("verifyState", ((ParamConfigBean)StrutsUtil.getApplication().getAttribute("VERIFY_STATE")).getValueByCode("verifypass"));
		//未删除
		f.setParam("deleteState", ((ParamConfigBean)StrutsUtil.getApplication().getAttribute("DEL_STATE")).getValueByCode("enable"));
		//不包括本身,以及自己的下级
		if(null != dept && null != dept.getDeptId() && !"".equals(dept.getDeptId())){
			String deptId = "'"+dept.getDeptId()+"',";
			deptId = getChildDept(deptId,dept);
			if(deptId.endsWith(",")){
				deptId = deptId.substring(0,deptId.length()-1);
			}
			f.append(" and d.deptId not in ( " + deptId + " )");
		}
		//f.append(" and d.scDept.deptId is null");
		//排序
		f.append(" order by d.scDept.deptId desc,d.createDate desc");
		
		return super.find(f);
	}
	
	/**
	 * 
	 * @comments 根据部门ID查出所有下级部门，以及下级的下级...
	 * @param deptIds
	 * @param dept
	 * @return String
	 * @version 1.0
	 */
	public String getChildDept(String deptIds,ScDept dept){
		
		if(null != dept){
			//创建Finder查询对象
			Finder f = Finder.create("from ScDept d where d.enableState=:enableState and d.verifyState=:verifyState and d.deleteState=:deleteState");
			//已启用
			f.setParam("enableState", ((ParamConfigBean)StrutsUtil.getApplication().getAttribute("CONFIG_STATE")).getValueByCode("enable"));
			//审核通过
			f.setParam("verifyState", ((ParamConfigBean)StrutsUtil.getApplication().getAttribute("VERIFY_STATE")).getValueByCode("verifypass"));
			//未删除
			f.setParam("deleteState", ((ParamConfigBean)StrutsUtil.getApplication().getAttribute("DEL_STATE")).getValueByCode("enable"));
			//上级ID
			f.append(" and d.scDept.deptId =:deptId").setParam("deptId", dept.getDeptId());
			//排序
			f.append(" order by d.createDate desc,d.deptId desc");
			
			List<ScDept> list = super.find(f);
			
			for(ScDept d : list){
				deptIds += "'"+d.getDeptId()+"',";
				deptIds = getChildDept(deptIds,d);
			}
		}
		
		return deptIds;
	}
	
	/**
	 * 根据部门名称获取部门对象，若不存在，则返回null（不区分大小写）
	 *@param deptname deptid parentid
	 *@return ScDept
	 *
	 */
	public ScDept getDeptByDeptname(String deptname,String deptid,String parentid) {
		
		//String hql = "from ScUsers user where lower(user.userName) = lower(?) and lower(user.deleteState) = lower(?) and ";
		//创建Finder查询对象
		Finder f = Finder.create("from ScDept d where  d.deleteState=:deleteState and d.deptName = :deptName").setParam("deptName", deptname);
		
		String deleteState = ((ParamConfigBean)StrutsUtil.getApplication().getAttribute("DEL_STATE")).getValueByCode("enable");
		
		f.setParam("deleteState", deleteState);
		
		//判断是添加还是修改（有deptid就是修改，反之则为添加）
		if(null != deptid && !("").equals(deptid)){
			f.append(" and d.deptId !=:deptId").setParam("deptId", deptid);
		}
		//判断上级id是否存
		if (null != parentid && !("").equals(parentid)) {
			f.append(" and d.scDept.deptId =:parentId").setParam("parentId", parentid);
		} else {
			f.append(" and d.scDept is null ").setParam("deleteState", deleteState);
		}
		
		//已启用
		//f.append(" and u.enableState=:enableState").setParam("enableState", ((ParamConfigBean)StrutsUtil.getApplication().getAttribute("CONFIG_STATE")).getValueByCode("enable"));
		//审核通过
		//f.append(" and u.verifyState=:verifyState").setParam("verifyState", ((ParamConfigBean)StrutsUtil.getApplication().getAttribute("VERIFY_STATE")).getValueByCode("verifypass"));
		//未删除
		//f.append(" and u.deleteState=:deleteState").setParam("deleteState", ((ParamConfigBean)StrutsUtil.getApplication().getAttribute("DEL_STATE")).getValueByCode("enable"));
		
		//return (ScUsers) getSession().createQuery(hql).setParameter(0, username).uniqueResult();
		
		//查询
		List<ScDept> list = super.find(f);
		
		ScDept dept = null;
		
		if(list.size()>0){
			dept = list.get(0);
		}
		
		return dept;
	}
	
	/**
	 * 根据部门CODE获取部门对象，若不存在，则返回null（不区分大小写）
	 *@param deptcode deptid parentid
	 *@return ScDept
	 *
	 */
	public ScDept getDeptByDeptcode(String deptcode,String deptid,String parentid){
		
		//创建Finder查询对象
		Finder f = Finder.create("from ScDept d where  d.deleteState=:deleteState and d.deptCode=:deptCode").setParam("deptCode", deptcode);
		
		f.setParam("deleteState", ((ParamConfigBean)StrutsUtil.getApplication().getAttribute("DEL_STATE")).getValueByCode("enable"));
		
		//判断是添加还是修改（有deptid就是修改，反之则为添加）
		if(null != deptid && !("").equals(deptid)){
			f.append(" and d.deptId !=:deptId").setParam("deptId", deptid);
		}
		//判断上级id是否存
//		if (null != parentid && !("").equals(parentid)) {
//			f.append(" and d.scDept.deptId =:parentId").setParam("parentId", parentid);
//		} else {
//			f.append(" and d.scDept is null");
//		}
		
		//查询
		List<ScDept> list = super.find(f);
		
		ScDept dept = null;
		
		if(list.size()>0){
			dept = list.get(0);
		}
		
		return dept;
	}

}
