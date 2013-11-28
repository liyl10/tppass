/************************* 版权声明 *********************************
 *
 * Copyright (C) 2012 西安辉盛科技发展有限责任公司.
 *
 ******************************************************************
 */
package com.hopsun.tppas.api.superadmin.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.hopsun.framework.base.bean.Finder;
import com.hopsun.framework.base.bean.Pager;
import com.hopsun.framework.base.dao.impl.BaseDaoImpl;
import com.hopsun.framework.util.StrutsUtil;
import com.hopsun.tppas.api.superadmin.dao.MitemDao;
import com.hopsun.tppas.entity.Mitem;

/**
 * @comment 代码表DAO层实现类
 * @author liush
 * @DATE: 2013-5-29 @TIME: 上午11:12:04
 * @Vsersion: 1.0
 */
@Repository
public class MitemDaoImpl extends BaseDaoImpl<Mitem, String> implements MitemDao {
	
	/**
	 * 分页查询
	 *@param pageNumber pageSize 
	 *@return Pager
	 */
	public Pager findByPager(String masterType, Integer pageNumber, Integer pageSize){
		
		//创建Finder查询对象
		Finder f = Finder.create(" from Mitem d where d.delFlg=:delFlg");
		f.setParam("delFlg", "0");
		if (masterType !=null && !"".equals(masterType)) {
			f.append(" and d.mtype.typeId=:masterType");
			f.setParam("masterType", masterType);
		}
		f.append(" order by d.mtype.createTime desc,d.mtype.typeName desc, d.itemOrd asc");
		return super.find(f, pageNumber, pageSize);
	}
	
	/**
	 * 取得Mitem对象对应数据库表的集合
	 * @param typeId
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<Mitem> getMitemListById(String typeId) {
		List<Mitem> mitemList = (List<Mitem>) StrutsUtil.getApplication().getAttribute(typeId+"typeId");
		if(mitemList==null){
			StringBuffer hql = new StringBuffer();
			hql.append(" From Mitem m where ");
			hql.append(" m.mtype.typeId= ?");
			hql.append(" and  m.delFlg= 0");
			hql.append(" order by m.itemOrd asc ,itemId asc");
			mitemList = super.createQueryList(hql.toString(), new String[]{ typeId });
			StrutsUtil.getApplication().setAttribute(typeId+"typeId", mitemList);
		}
		return mitemList;
	}
	
	/**
	 * 取得Mitem对象对应数据库表的集合
	 * 
	 * @param pId
	 * @return　list<Mitem>
	 */
	@SuppressWarnings("unchecked")
	public List<Mitem> getMitemListByPId(String pId) {
		List<Mitem> mitemList = (List<Mitem>) StrutsUtil.getApplication().getAttribute(pId+"pId");
		if(mitemList==null){
			StringBuffer hql = new StringBuffer();
			hql.append("From Mitem m where ");
			hql.append("m.PItemId = ?");
			hql.append(" and  m.delFlg= 0");
			hql.append(" order by m.itemOrd asc ,itemId asc");
			mitemList = super.createQueryList(hql.toString(),new String[] { pId });
			StrutsUtil.getApplication().setAttribute(pId+"pId", mitemList);
		}
		return mitemList;
	}
	
	/**
	 * 取得ItemName
	 * @param itemId
	 * @return
	 */
	public String getItemName(String itemId){
		if(itemId == null || "".equals(itemId)){
			return "";
		}
		Mitem mitem = (Mitem) StrutsUtil.getApplication().getAttribute(itemId);
		if(mitem==null){
			mitem = super.get(itemId);
			StrutsUtil.getApplication().setAttribute(itemId, mitem);
		}
		if(mitem !=null){
			return mitem.getItemName();
		}else{
			return "";
		}
	}
	
	/**
	 * 取得Mitem对象对应数据库表的集合
	 * @return　list<Mitem>
	 */
	public List<Mitem> getMitemListInfo(){
		List<Mitem> mitemList = new ArrayList<Mitem>();
		StringBuffer hql = new StringBuffer();
		hql.append(" From Mitem m ");
		hql.append(" where m.delFlg= 0");
		hql.append(" order by m.itemOrd asc ,itemId asc");
		mitemList = super.createQueryList(hql.toString());
		return mitemList;
	}
	
	/**
	 * @comments 通过主键得到码表对象
	 * @param itemId
	 * @return
	 * @Version 1.0
	 */
	public Mitem get(String itemId){
		Mitem mitem = (Mitem) StrutsUtil.getApplication().getAttribute(itemId);
		if(mitem==null){
			mitem = super.get(itemId);
			StrutsUtil.getApplication().setAttribute(itemId, mitem);
		}
		return mitem;
	}

	/**
	 * @comments 得到所有父itemId
	 * @param 
	 * @return
	 * @Version 1.0
	 */
	@SuppressWarnings("unchecked")
	public List<Object> getAllPitemId() {
		String hql = "select t.PItemId from Mitem t group by t.PItemId";
		Query queryObject = createQuery(hql, new Object[]{});
		List<Object> all = queryObject.list();
		return all;
	}
	
	/**
	 * @comments 应用初始化时根据typeID取得List<Mitem>
	 * @param typeId
	 * @return
	 * @Version 1.0
	 */
	@SuppressWarnings("unchecked")
	public List<Mitem> loadListByTypeId(String typeId){
		List<Mitem> mitemList = (List<Mitem>) StrutsUtil.getApplication().getAttribute(typeId+"typeId");
		if(mitemList==null){
			StringBuffer hql = new StringBuffer();
			hql.append(" from Mitem m ");
			hql.append(" where m.mtype.typeId =? ");
			hql.append(" and m.delFlg = 0 ");
			hql.append(" order by m.itemOrd asc");
			
			mitemList = super.createQueryList(hql.toString(), new String[]{typeId});
			
			StrutsUtil.getApplication().setAttribute(typeId+"typeId", mitemList);
		}
		
		return mitemList;
	}
	
	
	/**
	 * @comments 应用初始化时根据pitemId取得List<Mitem>
	 * @param pitemId
	 * @return
	 * @Version 1.0
	 */
	@SuppressWarnings("unchecked")
	public List<Mitem> loadMitemListByPId(String pitemId){
		List<Mitem> mitemList = (List<Mitem>) StrutsUtil.getApplication().getAttribute(pitemId+"pId");
		if(mitemList==null){
			StringBuffer hql = new StringBuffer();
			hql.append(" from Mitem m ");
			hql.append(" where m.PItemId =? ");
			hql.append(" and m.delFlg = 0 ");
			hql.append(" order by m.itemOrd asc");
			
			mitemList = super.createQueryList(hql.toString(), new String[]{pitemId});
			StrutsUtil.getApplication().setAttribute(pitemId+"pId", mitemList);
		}
		
		return mitemList;
	}
	
	/**
	 * @comments 根据typeID取得List<Mitem>
	 * @param typeId
	 * @return
	 * @Version 1.0
	 */
	@SuppressWarnings("unchecked")
	public List<Mitem> getListByTypeId(String typeId){
		List<Mitem> mitemList = (List<Mitem>) StrutsUtil.getApplication().getAttribute(typeId+"typeId");
		if(mitemList==null){
			StringBuffer hql = new StringBuffer();
			hql.append(" from Mitem m ");
			hql.append(" where m.mtype.typeId =? ");
			hql.append(" and m.delFlg = 0 ");
			hql.append(" order by m.itemOrd asc");
			mitemList = super.createQueryList(hql.toString(), new String[]{typeId});
			StrutsUtil.getApplication().setAttribute(typeId+"typeId", mitemList);
		}
		
		return mitemList;
	}
	
	/**
	 * @comments 根据typeID取得List<Mitem>
	 * @param typeId
	 * @param itemId
	 * @return
	 * @Version 1.0
	 */
	@SuppressWarnings("unchecked")
	public List<Mitem> getListByTypeId(String typeId, String itemId){
		List<Mitem> mitemList = (List<Mitem>) StrutsUtil.getApplication().getAttribute(typeId+"typeId");
		if(mitemList==null){
			StringBuffer hql = new StringBuffer();
			hql.append(" from Mitem m ");
			hql.append(" where m.mtype.typeId =? ");
			hql.append(" and m.itemId !=? ");
			hql.append(" and m.delFlg = 0 ");
			hql.append(" order by m.itemOrd asc");
			mitemList = super.createQueryList(hql.toString(), new String[]{typeId, itemId});
			//StrutsUtil.getApplication().setAttribute(typeId+"typeId", mitemList);
		}
		
		return mitemList;
	}

	
	/**
	 * @comments 根据typeID取得List<Mitem>
	 * @param typeId
	 * @param itemId
	 * @param itemId1
	 * @return
	 * @Version 1.0
	 */
	public List<Mitem> getListByTypeId(String typeId, String itemId,String itemId1){
		StringBuffer hql = new StringBuffer();
		hql.append(" from Mitem m ");
		hql.append(" where m.mtype.typeId =? ");
		hql.append(" and m.itemId !=? ");
		hql.append(" and m.itemId !=? ");
		hql.append(" and m.delFlg = 0 ");
		hql.append(" order by m.itemOrd asc");
		List<Mitem> mitemList = super.createQueryList(hql.toString(), new String[]{typeId, itemId, itemId1});
		
		return mitemList;
	}
	
	/**
	 * @comments 根据name取得List<Mitem>
	 * @param pitemId
	 * @return
	 * @Version 1.0
	 */
	public Mitem getListByItemName(String type, String Name, String pItemId) {
		Mitem mitem = new Mitem();
		StringBuffer hql = new StringBuffer();
		hql.append(" from Mitem m ");
		hql.append(" where m.mtype.typeId =? ");
		hql.append(" and m.itemName = ? ");
		if(pItemId!=null&&pItemId.length()>0){
			hql.append(" and m.PItemId ='"+pItemId+"'");
		}
		hql.append(" and m.delFlg = 0 ");
		hql.append(" order by m.itemOrd asc");
		
		mitem = super.createQueryObj(hql.toString(), new String[]{type,Name});
		
		return mitem;
	}
	
	/**
	 * @comments 根据typeID取得批次List<Mitem>
	 * @param typeId
	 * @return
	 * @Version 1.0
	 */
	public List<Mitem> getBatchListByTypeId(String typeId){
		List<Mitem> mitemList = new ArrayList<Mitem>();
		StringBuffer hql = new StringBuffer();
		hql.append(" from Mitem m ");
		hql.append(" where m.mtype.typeId =? ");
		hql.append(" and m.delFlg = 0 ");
		hql.append(" order by m.itemOrd asc");
		mitemList = super.createQueryList(hql.toString(), new String[]{typeId});
		
		return mitemList;
	}
}
