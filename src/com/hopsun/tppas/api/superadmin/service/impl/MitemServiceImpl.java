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
import com.hopsun.tppas.api.superadmin.dao.MitemDao;
import com.hopsun.tppas.api.superadmin.service.MitemService;
import com.hopsun.tppas.common.Constants;
import com.hopsun.tppas.entity.Mitem;
import com.hopsun.tppas.entity.Mtype;

/**
 * @comment 代码表实现类
 * @author liush
 * @DATE: 2013-5-29 @TIME: 上午11:07:35
 * @Vsersion: 1.0
 */
@Service("apiMitemService")
public class MitemServiceImpl extends BaseServiceImpl<Mitem,String> implements MitemService{
	
	@Resource
	private MitemDao mitemDao;
	
	@Resource
	public void setBaseDao(MitemDao mitemDao) {
		super.setBaseDao(mitemDao);
	}
	
	/**
	 * 分页查询
	 *@param pageNumber pageSize 
	 *@return Pager
	 */
	public Pager find(String masterType, Integer pageNumber, Integer pageSize) {
		return mitemDao.findByPager(masterType, pageNumber, pageSize);
	}
	
	/**
	 * 取得Mitem对象对应数据库表的集合
	 * @param typeId
	 * @return
	 */
	public List<Mitem> getMitemListById(String typeId){
		return mitemDao.getMitemListById(typeId);
	}
	
	/**
	 * 取得Mitem对象对应数据库表的集合
	 * 
	 * @param pId
	 * @return　list<Mitem>
	 */
	public List<Mitem> getMitemListByPId(String pId){
		return mitemDao.getMitemListByPId(pId);
	}
	
	/**
	 * 取得所有Mitem对象对应数据库表的集合
	 * @return　list<Mitem>
	 */
	public List<Mitem> getMitemListInfo(){
		return mitemDao.getMitemListInfo();
	}
	
	/**
	 * @comments 得到所有父itemId
	 * @param 
	 * @return
	 * @Version 1.0
	 */
	public List<Object> getAllPitemId() {
		return mitemDao.getAllPitemId();
	}
	
	/**
	 * @comments 应用初始化时根据typeID取得List<Mitem>
	 * @param typeId
	 * @return
	 * @Version 1.0
	 */
	public List<Mitem> loadListByTypeId(String typeId){
		return mitemDao.loadListByTypeId(typeId);
	}
	
	/**
	 * @comments 应用初始化时根据pitemId取得List<Mitem>
	 * @param pitemId
	 * @return
	 * @Version 1.0
	 */
	public List<Mitem> loadMitemListByPId(String pitemId){
		return mitemDao.loadMitemListByPId(pitemId);
	}
	
	/**
	 * @comments 添加或修改Mitem对象，修改ServletContext里面的缓存
	 * @param mitem
	 * @return
	 * @Version 1.0
	 */
	@SuppressWarnings("unchecked")
	public void saveOrUpdate(Mitem mitem){
		boolean flag = true;
		if(mitem.getItemId()==null){
			flag = false;
		}
		mitemDao.saveOrUpdate(mitem);
		//如果是修改就删除之前ServletContext里的对象缓存
		if(flag){
			StrutsUtil.getApplication().removeAttribute(mitem.getItemId());
		}
		//添加对象到ServletContext
		if(mitem.getDelFlg().equals(Constants.COMMON_STATE_NOTDELETE)){
			StrutsUtil.getApplication().setAttribute(mitem.getItemId(), mitem);
		}
		
		Mtype mtype = mitem.getMtype();
		if(mtype!=null){
			List<Mitem> mitemList = (List<Mitem>) StrutsUtil.getApplication().getAttribute(mtype.getTypeId()+"typeId");
			if(mitemList!=null&&mitemList.size()>0){
				StrutsUtil.getApplication().removeAttribute(mtype.getTypeId()+"typeId");
			}
			List<Mitem> list = mitemDao.loadListByTypeId(mtype.getTypeId());
			StrutsUtil.getApplication().setAttribute(mtype.getTypeId()+"typeId", list);
		}
		
		String pId = mitem.getPItemId();
		if(pId!=null&&pId.length()>0){
			List<Mitem> childList = (List<Mitem>) StrutsUtil.getApplication().getAttribute(pId+"pId");
			if(childList!=null&&childList.size()>0){
				StrutsUtil.getApplication().removeAttribute(pId+"pId");
			}
			List<Mitem> all = mitemDao.loadMitemListByPId(pId);
			StrutsUtil.getApplication().setAttribute(pId+"pId", all);
		}
	}
	/**
	 * 查询item信息
	 * @param itemId
	 * @return
	 */
	@Override
	public String getMitemNameById(String itemId) {
		Mitem mitem=mitemDao.get(itemId);
		if(mitem!=null)
			return mitem.getItemName();
		return null;
	}
	/**
	 * 获取item下拉框数据
	 * @param typeId
	 * @return
	 */
	@Override
	public Map<String, String> getMiteByTypeId(String typeId) {
		Map<String, String> map=new HashMap<String, String>();
		try{
			List<Mitem> listResult=loadListByTypeId(typeId);
			if(listResult!=null&&listResult.size()>0){
				for(int i=0;i<listResult.size();i++){
					Mitem mitem=listResult.get(i);
					map.put(mitem.getItemId(), mitem.getItemName());
				}
			}
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
		
		return map;
	}
	
	/**
	 * @comments 根据typeID取得List<Mitem>
	 * @param typeId
	 * @return
	 * @Version 1.0
	 */
	public List<Mitem> getListByTypeId(String typeId){
		return mitemDao.getListByTypeId(typeId);
	}
	
	/**
	 * @comments 根据typeID取得List<Mitem>
	 * @param typeId
	 * @return
	 * @Version 1.0
	 */
	public List<Mitem> getListByTypeId(String typeId, String itemId){
		return mitemDao.getListByTypeId(typeId, itemId);
	}
	
	/**
	 * @comments 根据typeID取得List<Mitem>
	 * @param typeId
	 * @return
	 * @Version 1.0
	 */
	public List<Mitem> getListByTypeId(String typeId, String itemId,String itemId1){
		return mitemDao.getListByTypeId(typeId, itemId, itemId1);
	}
	
	/**
	 * 
	 * @comments 根据Name取得List<Mitem>
	 * @param typeName
	 * @return
	 * @version 1.0
	 */
	public Mitem getListByItemName(String type, String Name, String pItemId) {
		return mitemDao.getListByItemName(type,Name,pItemId);
	}
	
	/**
	 * @comments 根据typeID取得批次List<Mitem>
	 * @param typeId
	 * @return
	 * @Version 1.0
	 */
	public List<Mitem> getBatchListByTypeId(String typeId){
		return mitemDao.getBatchListByTypeId(typeId);
	}
}
