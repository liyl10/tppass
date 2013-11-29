package com.hopsun.tppas.api.report.dao.impl;

import java.util.Map;

import org.springframework.stereotype.Repository;

import com.hopsun.framework.base.bean.Finder;
import com.hopsun.framework.base.bean.Pager;
import com.hopsun.framework.base.dao.impl.BaseDaoImpl;
import com.hopsun.tppas.api.report.dao.TplanCollectDao;
import com.hopsun.tppas.entity.TplanCollect;

@Repository
public class TplanCollectDaoImpl extends BaseDaoImpl<TplanCollect, String>
		implements TplanCollectDao {

	@Override
	public Pager getPlanList(Map<String, Object> param, Integer pageNumber,
			Integer pageSize) {
		// 创建Finder查询对象
		String hql = this.createPlanHql(param);

		Finder f = Finder.create(hql);

		// 排序条件
		f.append(" order by t.createTime desc");

		Pager p = super.find(f, pageNumber, pageSize);

		// 查询、返回
		return p;
	}
	
	/**
	 * @comments 生成sql
	 * @param param
	 * @return
	 * @Version 1.0
	 */
	private String createPlanHql(Map<String, Object> param) {
		StringBuffer hql = new StringBuffer();

		// 生成hql
		hql.append(" from TplanCollect t where 1 = 1 ");

		// 分计划名称
		String planCollectName = (String) param.get("planCollectionName");
		if (!isNullString(planCollectName)) {
			hql.append(" and t.planCollectName like '%" + planCollectName.trim() + "%'");
		}

		// 计划年度
		String planCollectYear = (String) param.get("planYear");
		if (!isNullString(planCollectYear)) {
			hql.append(" and t.planCollectYear = '" + planCollectYear.trim() + "'");
		}

		// 批次
		String planCollectBatch = (String) param.get("planBatch");
		if (!isNullString(planCollectBatch)) {
			hql.append(" and t.planCollectBatch = '" + planCollectBatch.trim() + "'");
		}
		
		// 删除区分
		hql.append(" and t.deleteFlag = '0'");

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
