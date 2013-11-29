package com.hopsun.tppas.api.superadmin.dao.impl;


import java.util.List;

import com.hopsun.tppas.api.superadmin.dao.TexpertReviewCommentsDao;
import com.hopsun.tppas.common.Constants;
import com.hopsun.framework.base.bean.Finder;
import com.hopsun.framework.base.bean.Pager;
import com.hopsun.framework.base.dao.impl.BaseDaoImpl;
import com.hopsun.tppas.entity.TexpertReviewComments;

import org.springframework.stereotype.Repository;

@Repository
public class TexpertReviewCommentsDaoImpl extends BaseDaoImpl<TexpertReviewComments, String> implements TexpertReviewCommentsDao {
	   
	/**
	 * @Comments 分页查询
	 * @param sql
	 * @param pageNumber
	 * @param pageSize
	 * @return
	 * @Vsersion: 1.0
	 */
	public Pager find(String typeId, Integer pageNumber, Integer pageSize) {
		//创建Finder查询对象 p.userId =:userId
		Finder f = Finder.create("from TexpertReviewComments t where t.tprojectType.typeId =:typeId and t.deleteFlag = "+Constants.COMMON_STATE_NOTDELETE);
		f.setParam("typeId", typeId);
		// 排序
		f.append(" order by t.createTime desc");
		// 返回
		return super.find(f, pageNumber, pageSize);
	}
	/**
	 * 
	 * @comments 专家类型列表
	 * @param typeId
	 * @return
	 * @version 1.0
	 */
	@Override
	public List<TexpertReviewComments> getexpertReviewList(String typeId) {
		StringBuffer hql = new StringBuffer();
		hql.append("from TexpertReviewComments t where t.deleteFlag = "+Constants.COMMON_STATE_NOTDELETE+" and t.tprojectType.typeId = ? order by t.expertType )");
		List<TexpertReviewComments> expertReviewlist = super.createQueryList(hql.toString(),  new String[]{typeId});
		return expertReviewlist;
	}
	/**
	 * 
	 * @comments 取得要copy的项目分类列表 
	 * @return
	 * @version 1.0
	 */
	@SuppressWarnings("unchecked")
	public List<String> getCopyExpertReviewList(String typeId) {
		Finder f = Finder.create("select t.tprojectType.typeId from TexpertReviewComments t where t.deleteFlag=:deleteFlag group by t.tprojectType.typeId ");
		f.setParam("deleteFlag", Constants.COMMON_STATE_NOTDELETE);
		List<String> copyExpertReviewList = super.find(f);
		return copyExpertReviewList;
	}
	/**
	 * 
	 * @comments 被COPY的信息 
	 * @param typeId
	 * @param expertType
	 * @return
	 * @version 1.0
	 */
	public List<TexpertReviewComments> getCopyTexpertReviewCommen(String typeId,
			String expertType) {
		StringBuffer hql = new StringBuffer();
		hql.append("from TexpertReviewComments t where t.deleteFlag = "+Constants.COMMON_STATE_NOTDELETE+" and t.tprojectType.typeId = ? and t.expertType = ? )");
		List<TexpertReviewComments> expertReviewlist = super.createQueryList(hql.toString(),  new String[]{typeId,expertType});
		return expertReviewlist;
	}
	/**
	 * 
	 * @comments 分别判断技术和投资专家有没有对应的技术和投资模板
	 * @param groupId
	 * @param typeId
	 * @return
	 * @version 1.0
	 */
	@Override
	public List<TexpertReviewComments> gettexpertReviewCommentsByExpert(
			String expertType,String typeId) {
		StringBuffer hql = new StringBuffer();
		hql.append("from TexpertReviewComments t where t.deleteFlag = "+Constants.COMMON_STATE_NOTDELETE+" and t.expertType = ? and t.tprojectType.typeId = ? )");
		List<TexpertReviewComments> expertReviewlist = super.createQueryList(hql.toString(),  new String[]{expertType,typeId});
		return expertReviewlist;
	}
	
}

