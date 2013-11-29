package com.hopsun.tppas.api.superadmin.dao;



import java.util.List;

import com.hopsun.tppas.entity.TexpertReviewComments;
import com.hopsun.framework.base.bean.Pager;
import com.hopsun.framework.base.dao.BaseDao;

public interface TexpertReviewCommentsDao extends BaseDao<TexpertReviewComments, String>{
	
	/**
	 * @Comments 分页查询
	 * @param sql
	 * @param pageNumber
	 * @param pageSize
	 * @return
	 * @Vsersion: 1.0
	 */
	public Pager find(String typeId, Integer pageNumber, Integer pageSize);
	/**
	 * 
	 * @comments 专家类型列表 
	 * @param typeId
	 * @return
	 * @version 1.0
	 */
	public List<TexpertReviewComments> getexpertReviewList(String typeId);
	/**
	 * 
	 * @comments 分别判断技术和投资专家有没有对应的技术和投资模板
	 * @param groupId
	 * @param typeId
	 * @return
	 * @version 1.0
	 */
	public List<TexpertReviewComments> gettexpertReviewCommentsByExpert(String expertType,String typeId);
	
	/**
	 * 
	 * @comments 取得要copy的项目分类列表 
	 * @return
	 * @version 1.0
	 */
	public List<String> getCopyExpertReviewList(String typeId);
	/**
	 * 
	 * @comments 被COPY的信息 
	 * @param typeId
	 * @param expertType
	 * @return
	 * @version 1.0
	 */
	public List<TexpertReviewComments> getCopyTexpertReviewCommen(String typeId,String expertType);
}
