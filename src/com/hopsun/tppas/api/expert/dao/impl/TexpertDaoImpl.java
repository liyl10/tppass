/*************** 版权声明***************
*
* Copyright (C) 2012 西安辉盛科技发展有限责任公司.
*
********************************************
*/
package com.hopsun.tppas.api.expert.dao.impl;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.hopsun.framework.base.bean.Finder;
import com.hopsun.framework.base.bean.Pager;
import com.hopsun.framework.base.dao.impl.BaseDaoImpl;
import com.hopsun.scenter.api.util.Constant;
import com.hopsun.tppas.api.expert.dao.TexpertDao;
import com.hopsun.tppas.common.CommonTool;
import com.hopsun.tppas.common.Constants;
import com.hopsun.tppas.entity.Mitem;
import com.hopsun.tppas.entity.Texpert;
import com.hopsun.tppas.entity.TgroupExpertRealtion;
/**
 * @comment 后台Dao实现类-主要用来实现专家库操作的接口
 * @author wanglw
 * @DATE: 2013-08-19 @TIME: 下午2:09:37
 * @Vsersion: 1.0
 */
@Repository
public class TexpertDaoImpl extends BaseDaoImpl<Texpert, String> implements TexpertDao {
	   
	// wanglw  Start
	/**
	 * @comments 取得继续添加的专家列表
	 * @param param
	 * @return
	 * @Version 1.0
	 */
	public List<Texpert> getAddAuditList(Map<String, Object> param, List<TgroupExpertRealtion> tgList, List<Mitem> schoolingList){
		
		String hql = this.createHql(param, tgList, schoolingList);
		
		List<Texpert> exList = super.createQueryList(hql, new String[]{});
		return exList; 
	}
	
	/**
	 * @comments 生成hql
	 * @param param
	 * @return;
	 * @Version 1.0
	 */
	private String createHql(Map<String, Object> param, List<TgroupExpertRealtion> tgList, List<Mitem> schoolingList){
		StringBuffer hql = new StringBuffer();
		
		// 生成hql
		hql.append(" from Texpert t ");
		
		hql.append(" where 1=1 ");
		
		String sex = (String) param.get("sex");
	    if (!isNullString(sex)) {
	    	
			hql.append(" and t.sex ='" + sex.trim() + "'");
		}
	    
	    String birthdayYear = (String) param.get("birthdayYear");
	    if (!isNullString(birthdayYear)) {
	    	
	    	if(birthdayYear.contains("<")){
	    		
	    		String [] birthday = birthdayYear.split("<");
	    		String birthdayTime = birthday[0] + "-01-01 00:00:00";
	    		hql.append(" and t.birthday  < TO_TIMESTAMP('"
 					+ Timestamp.valueOf(birthdayTime) +"','YYYY-MM-DD HH24:MI:SS:FF')");
	    	}
	    	else if(birthdayYear.contains("-")){
	    		
	    		String [] birthday = birthdayYear.split("-");
	    		String startTime = birthday[0] + "-01-01 00:00:00";
	    		String endTime = birthday[1] + "-01-01 00:00:00";
	    		hql.append(" and t.birthday  >= TO_TIMESTAMP('"
	 					+ Timestamp.valueOf(startTime) +"','YYYY-MM-DD HH24:MI:SS:FF')");
	    		hql.append(" and t.birthday  < TO_TIMESTAMP('"
	 					+ this.addYear(Timestamp.valueOf(endTime)) +"','YYYY-MM-DD HH24:MI:SS:FF')");
	    	}
	    	else if(birthdayYear.contains(">")){
	    		String [] birthday = birthdayYear.split(">");
	    		String birthdayTime = birthday[0] + "-01-01 00:00:00";
	    		hql.append(" and t.birthday  >= TO_TIMESTAMP('"
 					+ Timestamp.valueOf(birthdayTime) +"','YYYY-MM-DD HH24:MI:SS:FF')");
	    	}
			
		}
	    
	    String schoolingType = (String) param.get("schoolingType");
	    if (!isNullString(schoolingType)) {
	    	
	    	if(schoolingList != null && schoolingList.size() > 0){
	    		hql.append(" and t.schooling in (");
	    		for (int i=0;i<schoolingList.size(); i++) {
	    			hql.append("'" + schoolingList.get(i).getItemId() + "'");
	    			if(i < schoolingList.size() -1){
		    			hql.append(",");
		    		}
				}
	    		hql.append(") ");
	    	}
			// hql.append(" and t.schooling ='" + schoolingType.trim() + "'");
		}
	    
	    String skilljobType = (String) param.get("skilljobType");
	    if (!isNullString(skilljobType)) {
	    	
			hql.append(" and t.skillJob ='" + skilljobType.trim() + "'");
		}
	    
	    String expertmajorType = (String) param.get("expertmajorType");
	    if (!isNullString(expertmajorType)) {
	    	
			hql.append(" and t.expertMajor ='" + expertmajorType.trim() + "'");
		}
	    
	    String expertType = (String) param.get("expertType");
	    if (!isNullString(expertType)) {
	    	
			hql.append(" and t.expertType ='" + expertType.trim() + "'");
		}
	    
	    String expertJobType = (String) param.get("expertJobType");
	    if (!isNullString(expertJobType)) {
	    	
	    	if(Constants.EXPERT_JOB_TYPE1.equals(expertJobType)){
	    		hql.append(" and t.expertJob not is null ");
	    	}else{
	    		hql.append(" and t.expertJob is null");
	    	}
			
		}
	    
	    /*// 填表时间
 		Timestamp applicationDateFrm =  (Timestamp)param.get("applicationDateFrm");
 		if (applicationDateFrm != null) {
 			hql.append(" and d.applicationDate >= TO_TIMESTAMP('"
 					+ applicationDateFrm +"','YYYY-MM-DD HH24:MI:SS:FF')");
 		}*/
		
		String graduatedName = (String) param.get("graduatedName");
	    if (!isNullString(graduatedName)) {
	    	
			hql.append(" and t.graduateSchool ='" + graduatedName.trim() + "'");
		}
	    
	    String expertName = (String) param.get("expertName");
	    if (!isNullString(expertName)){
	    	
	    	hql.append(" and t.expertName like '%" + expertName + "%'");
	    }
	    
	    // 过滤已选择的专家
	    
	    if(tgList !=null && tgList.size() >0){
	    	hql.append(" and ");
	    	hql.append(" t.expertId not in (");
		    
	    	for(int i = 0; i< tgList.size(); i++) {
	    		hql.append("'"+tgList.get(i).getTexpert().getExpertId()+"'");
	    		if(i < tgList.size() -1){
	    			hql.append(",");
	    		}
			}
		    hql.append(" ) ");
	    }
	    
	    
	    hql.append(" and t.deleteFlag = '"+ Constant.DELETE_STATE_FALSE +"'");
		return hql.toString();
	}
	
	/**
	 * @comments 取得专家信息List
	 * @param property
	 * @return
	 * @Version 1.0
	 */
	@SuppressWarnings("unchecked")
	public List<Object> getProPertyList(String property){
		
		StringBuffer hql = new StringBuffer();
		
		hql.append(" select ");
		hql.append(" distinct t." + property);
		hql.append(" from ");
		hql.append(" T_EXPERT t ");
		hql.append(" where t.delete_Flag = 0 ");
		hql.append(" and t."+ property +" is not null");
		
		// 创建Query 对象
		Query query = getSession().createSQLQuery(hql.toString());
		
		// 接收返回结果
		List<Object> list = query.list();
		
		return list;
	}
	
	/**
	 * @comments 年+1
	 * @param timestamp
	 * @return
	 * @Version 1.0
	 */
	private Timestamp addYear(Timestamp timestamp){
		
		Calendar calendar = Calendar.getInstance();
    	
    	Date date = timestamp;
    	calendar.setTime(date);
    	calendar.add(Calendar.YEAR, 1);
    	Date utilDate = calendar.getTime();
    	
    	return  new java.sql.Timestamp(utilDate.getTime());
	}
	
	
	/**
	 * @comments 取得专家评审统计List
	 * @param param
	 * @param pageNo
	 * @param pageSize
	 * @return
	 * @Version 1.0
	 */
	public Pager getExpertStatisticList(Map<String, Object> param, int pageNo, int pageSize){
		
		Finder f = Finder.create(createStatisticHql(param));
		//排序条件
		f.append(" order by export.createTime desc");
		//查询、返回
		Pager p = super.find(f, pageNo, pageSize);
		return p;
	}
	
	/**
	 * @comments 取得专家评审统计List
	 * @param param
	 * @param pageNo
	 * @param pageSize
	 * @return
	 * @Version 1.0
	 */
	@SuppressWarnings("unchecked")
	public List<Texpert> getExpertExportList(Map<String, Object> param){
		
		Finder f = Finder.create(createStatisticHql(param));
		//查询、返回
		return super.find(f);
	}
	
	/**
	 * 查询hql
	 * @comments 
	 * @param param
	 * @return
	 * @version 1.0
	 */
	private String createStatisticHql(Map<String, Object> param){
		StringBuffer hql= new StringBuffer("from Texpert export where export.deleteFlag=0 ");
		String exportName=String.valueOf(param.get("exportName"));
		if(CommonTool.IsNotEmpty(exportName)){
			hql.append(" and export.expertName like '%"+exportName.trim()+"%'");
		}
		return hql.toString();
	}
	
	// wanglw End
	
	/**
	 * @comments 获取专家库信息
	 * @param param
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	public Pager queryExportByParams(Map<String, Object> param, int pageNo,int pageSize) {
		Finder f = Finder.create(createHql(param));
		//排序条件
		f.append(" order by export.createTime desc");
		//查询、返回
		Pager p = super.find(f, pageNo, pageSize);
		return p;
	}
	
	/**
	 * 查询hql
	 * @comments 
	 * @param param
	 * @return
	 * @version 1.0
	 */
	private String createHql(Map<String, Object> param){
		StringBuffer hql= new StringBuffer("from Texpert export where export.deleteFlag=0 ");
		String exportName=String.valueOf(param.get("exportName"));
		if(CommonTool.IsNotEmpty(exportName)){
			hql.append(" and export.expertName like '%"+exportName.trim()+"%'");
		}
		String exportMajor=String.valueOf(param.get("expertMajor1"));
		if(CommonTool.IsNotEmpty(exportMajor)){
			hql.append(" and export.expertMajor1='"+exportMajor+"'");
			hql.append(" or export.expertMajor2='"+exportMajor+"'");
			hql.append(" or export.expertMajor3='"+exportMajor+"'");
		}
		String expertPrestige=String.valueOf(param.get("expertPrestige"));
		if(CommonTool.IsNotEmpty(expertPrestige)){
			hql.append(" and export.expertPrestige='"+expertPrestige+"'");
		}
		return hql.toString();
	}
	
	/**
	 * @comments 类型判断
	 * @param valueStr
	 * @return
	 * @Version 1.0
	 */
	private boolean isNullString(String valueStr) {
		if (valueStr != null && valueStr.length() > 0) {
			return false;
		} else {
			return true;
		}
	}
}
