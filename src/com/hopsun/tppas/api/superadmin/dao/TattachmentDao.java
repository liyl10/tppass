/**
 * @filename 附件管理Dao接口
 * @author wanglw
 * @date 2013-5-17
 * @version 1.0
 * Copyright (C) 2013 辉盛科技发展责任有限公司
 */
package com.hopsun.tppas.api.superadmin.dao;

import java.util.List;
import java.util.Map;

import com.hopsun.tppas.entity.Tattachment;
import com.hopsun.framework.base.bean.Pager;
import com.hopsun.framework.base.dao.BaseDao;

/**
 * @comments 附件管理Dao接口
 * @author wanglw
 * @date 2013-5-17 @time 下午5:18:28
 * @Version 1.0
 */
public interface TattachmentDao extends BaseDao<Tattachment, String>{
	
	/**
	 * @comments 通过model获得对应的表名
	 * @param c
	 * @return
	 * @version 1.0
	 */
	public String getTableName(Class<?> c);
	
	/**
	 * @comments 通过外键表信息获得附件集合
	 * @param valueMap 中存放的键值 
	 * Constants.FILE_UPLOAD_PRIM_CLASS	      附件对应model的Class
	 * Constants.FILE_UPLOAD_PRIM_KEY1	      附件对应model的主键1
	 * Constants.FILE_UPLOAD_PRIM_KEY2	      附件对应model的主键2
	 * Constants.FILE_UPLOAD_PRIM_KEY3	      附件对应model的主键3
	 * @version 1.0
	 */
	public List<Tattachment> getAttachmentsByForeignKey(Map<String,Object> valueMap);
	
	/**
	 * @comments 删除附件
	 * valueMap.FILE_UPLOAD_PRIM_KEY1 有附件的类的主键
	 * valueMap.FILE_UPLOAD_PRIM_CLASS 有附件的类的class
	 * @param valueMap
	 * @version 1.0
	 */
	public void removeByForeingKey(Map<String,Object> valueMap);
	

	/**
	 * @comments 取得附件清单列表
	 * @param tableName 表名
	 * @param dataId 业务数据ID
	 * @param pageNo
	 * @param pageSize
	 * @return
	 * @version 1.0
	 */
	public Pager find(String tableName,String dataId, int pageNo, int pageSize);
	
	/**
	 * @comments 取得附件清单列表
	 * @param tableName 关联表表名
	 * @param dataId 业务数据ID
	 * @param pageNo
	 * @param pageSize
	 * @return
	 * @version 1.0
	 */
	public Pager findFKTableName(String tableName,String dataId, int pageNo, int pageSize);
	
	/**
	 * @comments 附件序号
	 * @param tableName
	 * @param sequence
	 * @return
	 * @version 1.0
	 */
	public Tattachment getTattachment(String tableName, String dataId, String sequence);
	
	/**
	 * @comments 根据主表名称取得附件信息
	 * @param tableName
	 * @param dataId
	 * @param projectTableName
	 * @return
	 * @version 1.0
	 */
	public Tattachment getTattachmentByPTN(String tableName, String dataId, String projectTableName);
	/**
	 * 根据主表名称取得附件信息
	 * @param tableName
	 * @param dataId
	 * @param projectTableName
	 * @return
	 */
	public Tattachment getTattachmentByKY3(String tableName, String dataId, String projectTableName);
	
	/**
	 * @comments 取得最大序号+1
	 * @param tableName
	 * @param dataId
	 * @return
	 * @version 1.0
	 */
	public String getMaxSequence(String tableName, String dataId);
	
	/**
	 * 通过查询条件查询出附件对象
	 * @comments 
	 * @param mapValue
	 * @return
	 * @version 1.0
	 */
	public Tattachment getTattachmentByCondition(Map<String,Object> mapValue);
}
