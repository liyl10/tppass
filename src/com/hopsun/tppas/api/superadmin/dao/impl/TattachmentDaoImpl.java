/**
 * @filename 附件管理Dao实现类
 * @author wanglw
 * @date 2013-5-17
 * @version 1.0
 * Copyright (C) 2013 辉盛科技发展责任有限公司
 */
package com.hopsun.tppas.api.superadmin.dao.impl;

import java.lang.annotation.Annotation;
import java.util.List;
import java.util.Map;

import javax.persistence.Table;

import org.springframework.stereotype.Repository;

import com.hopsun.framework.base.bean.Finder;
import com.hopsun.framework.base.bean.Pager;
import com.hopsun.framework.base.dao.impl.BaseDaoImpl;
import com.hopsun.tppas.api.superadmin.dao.TattachmentDao;
import com.hopsun.tppas.common.CommonTool;
import com.hopsun.tppas.entity.Tattachment;

/**
 * @comments 附件管理Dao实现类
 * @author wanglw
 * @date 2013-5-17 @time 下午5:18:28
 * @Version 1.0
 */
@Repository("apiTattachmentDao")
public class TattachmentDaoImpl extends BaseDaoImpl<Tattachment, String> implements TattachmentDao {
 
	/**
	 * @comments 通过model获得对应的表名
	 * @param c
	 * @return
	 * @version 1.0
	 */
	public String getTableName(Class<?> c) {
		Annotation annotation = c.getAnnotation(Table.class);
		if(annotation!=null){
			Table d = (Table) annotation;
			return d.name();
		}else{
			return "";
		}
	}

	/**
	 * @comments 通过外键表信息获得附件集合
	 * @param valueMap 中存放的键值 
	 * Constants.FILE_UPLOAD_PRIM_CLASS	      附件对应model的Class
	 * Constants.FILE_UPLOAD_PRIM_KEY1	      附件对应model的主键1
	 * Constants.FILE_UPLOAD_PRIM_KEY2	      附件对应model的主键2
	 * Constants.FILE_UPLOAD_PRIM_KEY3	      附件对应model的主键3
	 * @version 1.0
	 */
	@SuppressWarnings("unchecked")
	public List<Tattachment> getAttachmentsByForeignKey(Map<String, Object> valueMap) {
		List<Tattachment> all = this.find(Finder.create(this.getQueryByForeingKey(valueMap)));
		return all;
	}

	/**
	 * @comments 删除附件
	 * valueMap.FILE_UPLOAD_PRIM_KEY1 有附件的类的主键
	 * valueMap.FILE_UPLOAD_PRIM_CLASS 有附件的类的class
	 * @param valueMap
	 * @version 1.0
	 */
	@SuppressWarnings("unchecked")
	public void removeByForeingKey(Map<String, Object> valueMap) {
		List<Tattachment> list = this.find(Finder.create(this.getQueryByForeingKey(valueMap)));
		if(list!=null && list.size()>0){
			for(int i=0;i<list.size();i++){
				Tattachment tattachment = list.get(i);
				this.delete(tattachment);
			}
		}
	}
	
	/**
	 * @comments 生成sql
	 * @param valueMap
	 * @return
	 * @Version 1.0
	 */
	private String getQueryByForeingKey(Map<String,Object> valueMap){
		StringBuffer hql = new StringBuffer("from Tattachment f where 1=1");
		if(valueMap.get("tableName")!=null){
			Class<?> clasz = (Class<?>)valueMap.get("tableName");
			String tableName = this.getTableName(clasz);
			hql.append(" and f.tableName='"+tableName+"'");
		}
		if(valueMap.get("key1")!=null){
			hql.append(" and f.key1='"+valueMap.get("key1")+"'");
		}else{
			hql.append(" and 1>2");
		}
		if(valueMap.get("key2")!=null){
			hql.append(" and f.key2='"+valueMap.get("key2")+"'");
		}
		if(valueMap.get("key3")!=null){
			hql.append(" and f.key3='"+valueMap.get("key3")+"'");
		}
		return hql.toString();
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
	public Pager find(String tableName,String dataId, int pageNo, int pageSize){
		//创建Finder查询对象
		Finder f = Finder.create("from Tattachment d where d.tableName =:tableName and d.key1 =:key1 ");
		//表明
		f.setParam("tableName", tableName);
		
		//业务数据Id
		f.setParam("key1", dataId);
		//排序条件
		f.append(" order by d.sequence, d.uploadTime desc");
		//查询、返回
		return super.find(f, pageNo, pageSize);
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
	public Pager findFKTableName(String tableName,String dataId, int pageNo, int pageSize){
		//创建Finder查询对象
		Finder f = Finder.create("from Tattachment d where d.key2 =:tableName and d.key1 =:key1 ");
		//表明
		f.setParam("tableName", tableName);
		
		//业务数据Id
		f.setParam("key1", dataId);
		//排序条件
		f.append(" order by d.sequence, d.uploadTime desc");
		//查询、返回
		return super.find(f, pageNo, pageSize);
	}
	

	/**
	 * @comments 附件序号
	 * @param tableName
	 * @param sequence
	 * @return
	 * @version 1.0
	 */
	public Tattachment getTattachment(String tableName, String dataId, String sequence) {

		StringBuffer hql = new StringBuffer();
		hql.append(" from Tattachment c ");
		hql.append(" where c.tableName =? ");
		hql.append(" and c.key1 = ? ");
		if(sequence!=null&&sequence.length()>0){
			hql.append(" and c.sequence = "+sequence);
		}
		Tattachment tattachment = (Tattachment)super.createQueryObj(hql.toString(),  new String[]{tableName, dataId});
		return tattachment;
	}
	
	/**
	 * @comments 根据主表名称取得附件信息
	 * @param tableName
	 * @param dataId
	 * @param projectTableName
	 * @return
	 * @version 1.0
	 */
	public Tattachment getTattachmentByPTN(String tableName, String dataId, String projectTableName) {

		StringBuffer hql = new StringBuffer();
		hql.append(" from Tattachment c ");
		hql.append(" where c.tableName =? ");
		hql.append(" and c.key1 = ? ");
		hql.append(" and c.key2 = ? ");
		Tattachment tattachment = (Tattachment)super.createQueryObj(hql.toString(),  new String[]{tableName, dataId, projectTableName});
		return tattachment;
	}
	
	/**
	 * @comments 取得最大序号+1
	 * @param tableName
	 * @param dataId
	 * @return
	 * @version 1.0
	 */
	public String getMaxSequence(String tableName, String dataId){
		StringBuffer hql = new StringBuffer();
		hql.append(" from Tattachment c ");
		hql.append(" where c.sequence =( ");
		hql.append(" select max(t.sequence) from Tattachment t ");
		hql.append(" where t.tableName = ? ");
		hql.append(" and t.key1 = ? ) ");
		hql.append(" and c.tableName = ? ");
		hql.append(" and c.key1 = ? ");
		Tattachment tattachment = (Tattachment)super.createQueryObj(hql.toString(),  new String[]{tableName, dataId, tableName, dataId});
		
		if(tattachment == null){
			return "1";
		}
		else{
			int sequence = tattachment.getSequence() + 1;
			if(sequence == 1000){
				sequence = 999;
			}
			return String.valueOf(sequence);
		}
	}

	
	public Tattachment getTattachmentByKY3(String tableName, String dataId,String projectTableName) {
		StringBuffer hql = new StringBuffer();
		hql.append(" from Tattachment c ");
		hql.append(" where c.tableName =? ");
		hql.append(" and c.key1 = ? ");
		hql.append(" and c.key3 = ? ");
		Tattachment tattachment = (Tattachment)super.createQueryObj(hql.toString(),  new String[]{tableName, dataId, projectTableName});
		return tattachment;
	}

	/**
	 * 通过查询条件查询出附件对象
	 * @comments 
	 * @param mapValue
	 * @return
	 * @version 1.0
	 */
	public Tattachment getTattachmentByCondition(Map<String, Object> mapValue) {
		StringBuffer hql = new StringBuffer(" from Tattachment c  where 1=1");
		//业务表主键
		String dataId = (String) mapValue.get("dataId");
		if(CommonTool.IsNotEmpty(dataId)){
			hql.append(" and c.key1 ='"+dataId+"'");
		}
		//业务表表名
		String tableName = (String)mapValue.get("tableMap");
		if(CommonTool.IsNotEmpty(tableName)){
			hql.append(" where c.tableName ='"+tableName+"'");
		}
		
		Tattachment tattachment = (Tattachment)super.createQueryObj(hql.toString(),new String[]{});
		return tattachment;
	}
}
