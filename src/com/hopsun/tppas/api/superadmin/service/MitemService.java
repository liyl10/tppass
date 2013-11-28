/************************* 版权声明 *********************************
 *
 * Copyright (C) 2012 西安辉盛科技发展有限责任公司.
 *
 ******************************************************************
 */
package com.hopsun.tppas.api.superadmin.service;

import java.util.List;
import java.util.Map;

import com.hopsun.framework.base.bean.Pager;
import com.hopsun.framework.base.service.BaseService;
import com.hopsun.tppas.entity.Mitem;

/**
 * @comment 代码表接口
 * @author liush
 * @DATE: 2013-5-29 @TIME: 上午11:06:34
 * @Vsersion: 1.0
 */
public interface MitemService extends BaseService<Mitem, String> {

	/**
	 * 分页查询
	 *@param pageNumber pageSize 
	 *@return Pager
	 */
	public Pager find(String masterType, Integer pageNumber, Integer pageSize);
	
	/**
	 * 取得Mitem对象对应数据库表的集合
	 * @param typeId
	 * @return
	 */
	public List<Mitem> getMitemListById(String typeId);
	
	/**
	 * 取得Mitem对象对应数据库表的集合
	 * 
	 * @param pId
	 * @return　list<Mitem>
	 */
	public List<Mitem> getMitemListByPId(String pId);
	
	/**
	 * 取得所有的Mitem
	 * @return
	 */
	public List<Mitem> getMitemListInfo();
	
	/**
	 * @comments 查询所有父itemId
	 * @param pitemId
	 * @return
	 * @Version 1.0
	 */
	public List<Object> getAllPitemId();
	
	/**
	 * @comments 应用初始化时根据typeID取得List<Mitem>
	 * @param typeId
	 * @return
	 * @Version 1.0
	 */
	public List<Mitem> loadListByTypeId(String typeId);
	
	/**
	 * @comments 应用初始化时根据pitemId取得List<Mitem>
	 * @param pitemId
	 * @return
	 * @Version 1.0
	 */
	public List<Mitem> loadMitemListByPId(String pitemId);
	
	/**
	 * 查询item信息
	 * @param itemId
	 * @return
	 */
	public String getMitemNameById(String itemId);
	
	/**
	 * 获取item下拉框数据
	 * @param typeId
	 * @return
	 */
	public Map<String, String> getMiteByTypeId(String typeId);
	
	/**
	 * @comments 根据typeID取得List<Mitem>
	 * @param typeId
	 * @return
	 * @Version 1.0
	 */
	public List<Mitem> getListByTypeId(String typeId);
	
	/**
	 * 
	 * @comments 根据Name取得List<Mitem>
	 * @param typeName
	 * @return
	 * @version 1.0
	 */
	public Mitem getListByItemName(String type,String Name,String pItemId);
	
	/**
	 * @comments 根据typeID取得List<Mitem>
	 * @param typeId
	 * @return
	 * @Version 1.0
	 */
	public List<Mitem> getListByTypeId(String typeId, String itemId);
	
	/**
	 * @comments 根据typeID取得List<Mitem>
	 * @param typeId
	 * @return
	 * @Version 1.0
	 */
	public List<Mitem> getListByTypeId(String typeId, String itemId,String itemId1);
	
	/**
	 * @comments 根据typeID取得批次List<Mitem>
	 * @param typeId
	 * @return
	 * @Version 1.0
	 */
	public List<Mitem> getBatchListByTypeId(String typeId);
}
