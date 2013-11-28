/**
 * @filename 附件管理service实现类
 * @author wanglw
 * @date 2013-5-17
 * @version 1.0
 * Copyright (C) 2013 辉盛科技发展责任有限公司
 */
package com.hopsun.tppas.api.superadmin.service.impl;


import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import com.hopsun.framework.base.bean.Pager;
import com.hopsun.framework.base.service.impl.BaseServiceImpl;
import com.hopsun.tppas.api.expert.dao.TexpertScoreDao;
import com.hopsun.tppas.api.superadmin.dao.TattachmentDao;
import com.hopsun.tppas.api.superadmin.service.TattachmentService;
import com.hopsun.tppas.common.CommonTool;
import com.hopsun.tppas.entity.Tattachment;
import com.hopsun.tppas.entity.TexpertScore;

/**
 * @comments 附件管理service实现类
 * @author wanglw
 * @date 2013-5-17 @time 下午5:21:26
 * @Version 1.0
 */ 
@Service("apiTattachmentService")
public class TattachmentServiceImpl extends BaseServiceImpl<Tattachment,String> implements TattachmentService{
	
	/**附件管理DAO*/
	@Resource
	private TattachmentDao tattachmentDao;
	
	/**专家审核DAO*/
	@Resource
	private TexpertScoreDao texpertScoreDao;
	
	@Resource
	public void setBaseDao(TattachmentDao tattachmentDao) {
		super.setBaseDao(tattachmentDao);
	}
	
	
	/**
	 * @comments 取得附件清单列表
	 * @param tableName 表名
	 * @param dataId 业务数据ID
	 * @param pageNo
	 * @param pageSize
	 * @return
	 * @version 1.0
	 */
	public Pager find(String tableName, String dataId, int startIndex, int pageNum){
		
		// 取得附件清单一览
		Pager pager = tattachmentDao.find(tableName, dataId, startIndex, pageNum);
		
		return pager;
	}
	
	/**
	 * @comments 取得附件清单列表
	 * @param tableName 关联表表名
	 * @param dataId 业务数据ID
	 * @param pageNo
	 * @param pageSize
	 * @return
	 * @version 1.0
	 */
	public Pager findFKTableName(String tableName, String dataId, int startIndex, int pageNum){
		
		// 取得附件清单一览
		Pager pager = tattachmentDao.findFKTableName(tableName, dataId, startIndex, pageNum);
		
		return pager;
	}
	
	/**
	 * @comments 通过model获得对应的表名
	 * @param c
	 * @return
	 * @version 1.0
	 */
	public String getTableName(Class<?> c){
		return tattachmentDao.getTableName(c);
	}
	
	/**
	 * @comments 附件序号
	 * @param tableName
	 * @param sequence
	 * @return
	 * @version 1.0
	 */
	public Tattachment getTattachment(String tableName, String dataId, int sequence){
		return tattachmentDao.getTattachment(tableName, dataId, String.valueOf(sequence));
	}
	
	/**
	 * @comments 根据主表名称取得附件信息
	 * @param tableName
	 * @param dataId
	 * @param projectTableName
	 * @return
	 * @version 1.0
	 */
	public Tattachment getTattachmentByPTN(String tableName, String dataId, String projectTableName){
		return tattachmentDao.getTattachmentByPTN(tableName, dataId, projectTableName);
	}
	
	/**
	 * @comments 取得最大序号+1
	 * @param tableName
	 * @param dataId
	 * @return
	 * @version 1.0
	 */
	public String getMaxSequence(String tableName, String dataId){
		return tattachmentDao.getMaxSequence(tableName, dataId);
	}
	
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
			String comment1, String comment2, String comment3,String status){
		Tattachment tattachment = new Tattachment();
		
		Tattachment ta = tattachmentDao.getTattachmentByKY3(tableName, dataId, projectTableName);
		if(ta !=null){
			
			// 附件顺序
			ta.setSequence(sequence);
			// 附件说明
			ta.setExplanation(explanation);
			// 上传时间
			ta.setUploadTime(new java.sql.Timestamp(new java.util.Date().getTime()));
			// 操作用户
			ta.setUserId(userId);
			// 文件地址
			ta.setAttachmentAddress(fileAdress);
			// 主表表名
			ta.setKey3(projectTableName);
			 
			tattachmentDao.update(ta);
		}
		else{
			// 表名
			tattachment.setTableName(tableName);
			// 业务数据Id
			tattachment.setKey1(dataId);
			// 附件名称
			tattachment.setAttachmentName(attachmentName);
			// 附件顺序
			tattachment.setSequence(sequence);
			// 附件说明
			tattachment.setExplanation(explanation);
			// 上传时间
			tattachment.setUploadTime(new java.sql.Timestamp(new java.util.Date().getTime()));
			// 操作用户
			tattachment.setUserId(userId);
			// 文件地址
			tattachment.setAttachmentAddress(fileAdress);
			// 主表表名
			tattachment.setKey3(projectTableName);
			
			// 保存附件信息
			tattachmentDao.save(tattachment);
		}
		
		// 如果是专家评审上传附件，更新专家审核表中是否评审状态
		if(CommonTool.IsNotEmpty(projectTableName) && tattachmentDao.getTableName(TexpertScore.class).equals(projectTableName)){
			TexpertScore texpertScore = texpertScoreDao.get(dataId);
			if(texpertScore != null){
				// 评审状态  0-未评审   1-评审
				texpertScore.setResultFlag("1");
				// 操作者
				texpertScore.setUpdateUser(userId);
				// 最后更新时间
				texpertScore.setUpdateDate(new java.sql.Timestamp(new java.util.Date().getTime()));
			}
		}
	}

	
	public Tattachment getTattachmentByKY3(String tableName, String dataId,String projectTableName) {
		return tattachmentDao.getTattachmentByKY3(tableName, dataId, projectTableName);
	}

	/**
	 * 通过查询条件查询出附件对象
	 * @comments 
	 * @param mapValue
	 * @return
	 * @version 1.0
	 */
	public Tattachment getTattachmentByCondition(Map<String, Object> mapValue) {
		
		return tattachmentDao.getTattachmentByCondition(mapValue);
	}

}
