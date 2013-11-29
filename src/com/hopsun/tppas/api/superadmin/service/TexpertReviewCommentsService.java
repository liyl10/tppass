package com.hopsun.tppas.api.superadmin.service;




import java.util.List;

import com.hopsun.framework.base.bean.Pager;
import com.hopsun.framework.base.service.BaseService;
import com.hopsun.tppas.entity.TexpertReviewComments;

public interface TexpertReviewCommentsService extends BaseService<TexpertReviewComments, String> {
	/**
	 * 
	 * @comments 分页查询 
	 * @param typeId
	 * @param pageNumber
	 * @param pageSize
	 * @return
	 * @version 1.0
	 */
	public Pager find(String typeShowName1,String typeId,Integer pageNumber, Integer pageSize);
	/**
	 * 
	 * @comments 新增、修改 
	 * @param userid
	 * @param texpertReviewComments
	 * @param typeId
	 * @version 1.0
	 */
	public void updateTexpertReview(String userid ,TexpertReviewComments texpertReviewComments,String typeId);
	/**
	 * 
	 * @comments 新增copy的信息
	 * @param userid
	 * @param texpertReviewComments
	 * @param typeId
	 * @version 1.0
	 */
	public void saveCopy(String userid,TexpertReviewComments texpertReviewComments,String typeId);
	/**
	 * 
	 * @comments 专家类型类别
	 * @param typeId
	 * @return
	 * @version 1.0
	 */
	public TexpertReviewComments getexpertReviewList(String typeId);
	/**
	 *
	 * @comments 获得技术专家评估表
	 * @param typeId
	 * @return
	 * @version 1.0
	 */
	public List<TexpertReviewComments> getexpertReview(String typeId);
	/**
	 * 
	 * @comments 专家评估列表 
	 * @param typeId
	 * @return
	 * @version 1.0
	 */
	public List<TexpertReviewComments> getExpertModelList(String typeId);
	/**
	 * 
	 * @comments 取得要copy的项目分类列表 
	 * @return
	 * @version 1.0
	 */
	public List<String> getCopyExpertReviewList(String typeId);
	/**
	 * 
	 * @comments 取得要copy的专家评估模板
	 * @param typeId
	 * @return
	 * @version 1.0
	 */
	public List<TexpertReviewComments> getCopyModelList(String typeId);
	/**
	 * 
	 * @comments 被COPY的信息 
	 * @param typeId
	 * @param expertType
	 * @return
	 * @version 1.0
	 */
	public TexpertReviewComments getCopyTexpertReviewCommen(String typeId,String expertType);
}
