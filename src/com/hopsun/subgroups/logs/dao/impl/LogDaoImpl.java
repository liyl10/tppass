/**
 * @filename LogDaoImpl.java
 * @author zzze
 * @date Dec 25, 2012
 * @vsersion 1.0
 * Copyright (C) 2012 辉盛科技发展责任有限公司
 */
package com.hopsun.subgroups.logs.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.hibernate.SQLQuery;
import org.hibernate.metadata.ClassMetadata;
import org.hibernate.persister.entity.AbstractEntityPersister;
import org.hibernate.transform.Transformers;
import org.hibernate.type.StandardBasicTypes;
import org.springframework.stereotype.Repository;

import com.hopsun.framework.base.bean.Finder;
import com.hopsun.framework.base.bean.Pager;
import com.hopsun.framework.base.dao.impl.BaseDaoImpl;
import com.hopsun.framework.util.Util;
import com.hopsun.subgroups.entity.UcLogs;
import com.hopsun.subgroups.logs.beans.UserTabCols;
import com.hopsun.subgroups.logs.beans.UserTabComments;
import com.hopsun.subgroups.logs.dao.LogDao;

/**
 * @comment 日志数据层实现类
 * @author zzze
 * @date 2012-5-25
 * @version 1.0
 */

@Repository
public class LogDaoImpl extends BaseDaoImpl<UcLogs, String> implements LogDao {

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.hopsun.framework.logs.dao.impl.TEst#add(com.hopsun.framework.logs.entity.Logs)
	 */
	public void add(final UcLogs log) {
		super.getSession().save(log);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.hopsun.framework.logs.dao.impl.TEst#list(com.hopsun.framework.logs.entity.Logs)
	 */
	public Pager list(final Pager pager,final UcLogs logs) {
		final StringBuilder builder = new StringBuilder("from UcLogs t where 1=1 ");
		if (logs != null) {
			if (Util.checkNotNull(logs.getLogObj())) {
				builder.append(" and logObj like '%" + logs.getLogObj() + "%' ");
			}
			if (Util.checkNotNull(logs.getOperaResult())) {
				builder.append(" and operaResult = '" + logs.getOperaResult() + "' ");
			}
			if (Util.checkNotNull(logs.getLogOpera())) {
				builder.append(" and logOpera = '" + logs.getLogOpera() + "' ");
			}
			if (Util.checkNotNull(logs.getLogSource())) {
				builder.append(" and logSource = '" + logs.getLogSource() + "' ");
			}
			if (Util.checkNotNull(logs.getCreateUserName())) {
				builder.append(" and createUserName like '%" + logs.getCreateUserName()
						+ "%' ");
			}
		}
		final Pager result = this.find(Finder.create(builder.toString()), pager.getPageNumber(), pager.getPageSize());
		pager.setList(result.getList());
		if(pager.getTotalCount()==0){
			pager.setTotalCount(result.getTotalCount());
			pager.setKeyword(result.getKeyword());
			pager.setOrderBy(result.getOrderBy());
			pager.setOrderType(result.getOrderType());
			pager.setPageCount(result.getPageCount());
			pager.setPageNumber(result.getPageNumber());
			pager.setPageSize(result.getPageSize());
			pager.setProperty(result.getProperty());
		}
		return pager;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.hopsun.framework.logs.dao.impl.TEst#getUserTabComments()
	 */
	@SuppressWarnings("unchecked")
	public Map<String,UserTabComments> getUserTabComments() {
		/**
		 *  获取表属性集合
		 */
		final SQLQuery query = super.getSession().createSQLQuery("select tab.TABLE_NAME as tableName,tab.TABLE_TYPE as tableType,tab.COMMENTS as comments from USER_TAB_COMMENTS tab");
		query.addScalar("tableName", StandardBasicTypes.STRING);
		query.addScalar("tableType", StandardBasicTypes.STRING);
		query.addScalar("comments", StandardBasicTypes.STRING);
		query.setResultTransformer(Transformers.aliasToBean(UserTabComments.class));
		
		final List<UserTabComments> tabCommentsList = query.list();
		/**
		 *  根据表属性获取字段属性和字段说明
		 */
		for (UserTabComments comments : tabCommentsList) {

			final List<UserTabCols> userTabCols = super
			.getSession()
			.createSQLQuery(
					"select cols.table_name as tableName,cols.column_name as columnName,cols.data_type as dataType,cols.data_type_mod as dataTypeMod,cols.data_type_owner as dataTypeOwner,cols.data_length as dataLength,cols.data_precision as dataPrecision,cols.data_Scale as dataScale,cols.nullable as nullable,cols.column_id as columnId,cols.default_length as defaultLength,cols.data_default as dataDefault,cols.num_distinct as numDistinct,cols.low_value as lowValue,cols.high_value as highValue,cols.density as density,cols.num_nulls as numNulls,cols.num_buckets as numBuckets,cols.last_analyzed as lastAnalyzed,cols.sample_size as sampleSize,cols.character_set_name as characterSetName,cols.char_col_decl_length as charColDeclLength,cols.global_stats as globalStats,cols.user_stats as userStats,cols.char_length as charLength,cols.char_used as charused,cols.v80_fmt_image as v80FmtImage,cols.data_upgraded as dataUpgraded,cols.histogram as histogram,comm.comments as comments from user_tab_columns cols ,user_col_comments comm where cols.Table_Name = comm.Table_Name and cols.column_name = comm.Column_Name and cols.table_name = '"
							+ comments.getTableName() + "'")
			.addScalar("tableName")
			.addScalar("columnName", StandardBasicTypes.STRING)
			.addScalar("dataType", StandardBasicTypes.STRING)
			.addScalar("dataTypeMod", StandardBasicTypes.STRING)
			.addScalar("dataTypeOwner", StandardBasicTypes.STRING)
			.addScalar("dataLength", StandardBasicTypes.LONG)
			.addScalar("dataPrecision", StandardBasicTypes.LONG)
			.addScalar("dataScale", StandardBasicTypes.LONG)
			.addScalar("nullable", StandardBasicTypes.STRING)
			.addScalar("columnId", StandardBasicTypes.LONG)
			.addScalar("defaultLength", StandardBasicTypes.LONG)
			.addScalar("dataDefault", StandardBasicTypes.STRING)
			.addScalar("numDistinct", StandardBasicTypes.LONG)
			.addScalar("lowValue", StandardBasicTypes.STRING)
			.addScalar("highValue", StandardBasicTypes.STRING)
			.addScalar("density", StandardBasicTypes.LONG)
			.addScalar("numNulls", StandardBasicTypes.LONG)
			.addScalar("numBuckets", StandardBasicTypes.LONG)
			.addScalar("lastAnalyzed", StandardBasicTypes.DATE)
			.addScalar("sampleSize", StandardBasicTypes.LONG)
			.addScalar("characterSetName", StandardBasicTypes.STRING)
			.addScalar("charColDeclLength", StandardBasicTypes.LONG)
			.addScalar("globalStats", StandardBasicTypes.STRING)
			.addScalar("userStats", StandardBasicTypes.STRING)
			.addScalar("charLength", StandardBasicTypes.LONG)
			.addScalar("charUsed", StandardBasicTypes.STRING)
			.addScalar("v80FmtImage", StandardBasicTypes.STRING)
			.addScalar("dataUpgraded", StandardBasicTypes.STRING)
			.addScalar("histogram", StandardBasicTypes.STRING)
			.addScalar("comments", StandardBasicTypes.STRING)
			.setResultTransformer(Transformers.aliasToBean(UserTabCols.class))
			.list();
			//封装columnName,key为数据库列名，value为实体对象entityName
			comments.setCols(getCols(userTabCols));
		}

		/**
		 * 更改表名为实体对象具体路径
		 */

		//封装tableName,key为数据库表名，value为实体对象qualifiedName
		//封装columnName,key为数据库列名，value为实体对象entityName
		final Map<String,String> tableMap = new HashMap<String, String>();//存储所有的tableName及entityName
        final Map<String, ClassMetadata> metaMap = super.getSession().getSessionFactory().getAllClassMetadata();//获取元数据
        saveTableToMap(tableMap, metaMap);//保存表到map中
        //更改返回结果中的tableName和columnName,比对替换
        for(UserTabComments comments : tabCommentsList){
    		comments.setTableName(tableMap.get(comments.getTableName().toLowerCase().trim()));
        }
	
		/**
		 * 转换为Map格式
		 */
		final Map<String,UserTabComments> result =  new HashMap<String, UserTabComments>();
		for(UserTabComments comm : tabCommentsList){
			if(comm.getTableName()!=null){
				result.put(comm.getTableName().trim(),comm);
			}
		}
		return result;
	}

	/**
	 * @comment 获取列 
	 * @param userTabCols
	 * @return
	 * @version: 1.0
	 * @param metaMap 
	 * @param columnsMap 
	 */
	private Map<String, UserTabCols> getCols( final List<UserTabCols> userTabCols) {
		final Map<String,String> columnsMap = new HashMap<String, String>();//存储所有的tableName及entityName
        final Map<String, ClassMetadata> metaMap = super.getSession().getSessionFactory().getAllClassMetadata();//获取元数据
		saveColsToMap(columnsMap, metaMap);
		final Map<String,UserTabCols> result = new HashMap<String, UserTabCols>();
		for(UserTabCols cols : userTabCols){
			if(cols.getColumnName()!=null){
				cols.setColumnName(columnsMap.get(cols.getColumnName().toLowerCase().trim()));
			}
			result.put(cols.getColumnName(),cols);
		}
		return result;
	}

	/**
	 * @comment 把列保存到map中 
	 * @param columnsMap
	 * @param metaMap
	 * @version: 1.0
	 */
	private void saveColsToMap(final Map<String, String> columnsMap,
			final Map<String, ClassMetadata> metaMap) {
		for (String key : (Set<String>) metaMap.keySet()) {
			for(String name :((AbstractEntityPersister) metaMap.get(key)).getPropertyNames()){
				//存放列
				columnsMap.put(((AbstractEntityPersister) metaMap.get(key)).getPropertyColumnNames(name).length>0?((AbstractEntityPersister) metaMap.get(key)).getPropertyColumnNames(name)[0].toLowerCase().trim():"",name.trim());
			}
		}
	}

	/**
	 * @comment 把表存到map中
	 * @param tableMap
	 * @param metaMap
	 * @version: 1.0
	 */
	private void saveTableToMap(final Map<String, String> tableMap,
			final Map<String, ClassMetadata> metaMap) {
		for (String key : (Set<String>) metaMap.keySet()) {
        	tableMap.put(((AbstractEntityPersister) metaMap.get(key)).getTableName().substring(((AbstractEntityPersister) metaMap.get(key)).getTableName().indexOf(".")+1).toLowerCase().trim(), key.trim());//存放表
        }
	}
}
