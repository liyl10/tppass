/**
 * @filename 附件管理service接口
 * @author wanglw
 * @date 2013-5-17
 * @version 1.0
 * Copyright (C) 2013 辉盛科技发展责任有限公司
 */
package com.hopsun.tppas.api.superadmin.service;

import java.util.Map;

import com.hopsun.framework.base.bean.Pager;
import com.hopsun.framework.base.service.BaseService;
import com.hopsun.tppas.entity.Tattachment;

/**
 * @comments 附件管理service接口
 * @author wanglw
 * @date 2013-5-17 @time 下午5:21:26
 * @Version 1.0
 */
public interface TattachmentService extends BaseService<Tattachment, String> {
	
	/**
	 * @comments 取得附件清单列表
	 * @param tableName 表名
	 * @param dataId 业务数据ID
	 * @param pageNo
	 * @param pageSize
	 * @return
	 * @version 1.0
	 */
	public Pager find(String tableName, String dataId, int startIndex, int pageNum);
	
	/**
	 * @comments 取得附件清单列表
	 * @param tableName 关联表表名
	 * @param dataId 业务数据ID
	 * @param pageNo
	 * @param pageSize
	 * @return
	 * @version 1.0
	 */
	public Pager findFKTableName(String tableName, String dataId, int startIndex, int pageNum);
	
	/**
	 * @comments 通过model获得对应的表名
	 * @param c
	 * @return
	 * @version 1.0
	 */
	public String getTableName(Class<?> c);
	
	/**
	 * @comments 附件序号
	 * @param tableName
	 * @param sequence
	 * @return
	 * @version 1.0
	 */
	public Tattachment getTattachment(String tableName, String dataId, int sequence);
	
	
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
	 * @comments 保存附件及关联表
	 * @param tableName
	 * @param dataId
	 * @param attachmentName
	 * @param userId
	 * @param projectTableName
	 * @param sequence
	 * @param explanation
	 * @param fileAdress
	 * @param fileName
	 * @param comment1
	 * @param comment2
	 * @Version 1.0
	 */
	public void updateTattachmentAndOtherTable(String tableName, String dataId, String attachmentName, String userId, 
			String projectTableName, int sequence, String explanation, String fileAdress, 
			String comment1, String comment2, String comment3, String status);
	
	/**
	 * 通过查询条件查询出附件对象
	 * @comments 
	 * @param mapValue
	 * @return
	 * @version 1.0
	 */
	public Tattachment getTattachmentByCondition(Map<String,Object> mapValue);
}