package com.hopsun.tppas.api.report.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.hopsun.framework.base.bean.Pager;
import com.hopsun.framework.base.service.impl.BaseServiceImpl;
import com.hopsun.tppas.api.report.dao.TplanCollectDao;
import com.hopsun.tppas.api.report.dao.TplanDao;
import com.hopsun.tppas.api.report.service.TplanCollectService;
import com.hopsun.tppas.api.superadmin.dao.MitemDao;
import com.hopsun.tppas.common.Constants;
import com.hopsun.tppas.entity.Tplan;
import com.hopsun.tppas.entity.TplanCollect;

@Service
public class TplanCollectServiceImpl extends BaseServiceImpl<TplanCollect,String> implements TplanCollectService{
	
	@Resource
	private MitemDao mitemDao;
	@Resource
	private TplanCollectDao tplanCollectDao;
	@Resource
	private TplanDao tplanDao;
	
	@Resource
	public void setBaseDao(TplanCollectDao tplanCollectDao) {
		super.setBaseDao(tplanCollectDao);
	}

	/**
	 * 取得计划汇总一览信息
	 */
	@Override
	public Pager getPlanList(Map<String, Object> param, Integer pageNumber,
			Integer pageSize) {
		Pager p = tplanCollectDao.getPlanList(param, pageNumber, pageSize);
		if(p.getList() !=null && p.getList().size() > 0){
			List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
			for (int i = 0; i < p.getList().size(); i++) {
				TplanCollect t1 = (TplanCollect) p.getList().get(i);
				// 列表信息Map
				Map<String, Object> valueMap = new HashMap<String, Object>();
				
				// 计划汇总ID	
				valueMap.put("planCollectId", t1.getPlanCollectId().trim());
				// 计划汇总名称
				valueMap.put("planCollectName", t1.getPlanCollectName());
				// 年度
				valueMap.put("planCollectYear", t1.getPlanCollectYear());	
				// 状态   
				String planState ="";
				if (!isNullString(t1.getPlanCollectState())){
					planState = mitemDao.getItemName(t1.getPlanCollectState());
				}
				valueMap.put("planCollectState", planState);

				// 批次
				String planBatch ="";
				if (!isNullString(t1.getPlanCollectBatch())){
					planBatch = mitemDao.getItemName(t1.getPlanCollectBatch());
				}
				valueMap.put("planCollectBatch", planBatch);
				
				list.add(valueMap);
			}
			
			// 设定list集合
			p.setList(list);
		}
		return p;
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

	/**
	 * 删除计划汇总
	 */
	@Override
	public void deletePlanCollect(Map<String, Object> param) {
		
		TplanCollect t = tplanCollectDao.get((String) param.get("planCollectId"));
		if(t != null){
			if(param.containsKey("deleteFlag")){
				// 删除区分
				t.setDeleteFlag(param.get("deleteFlag").toString());
			}
			// 更新时间
			t.setUpdateDate((new java.sql.Timestamp(new java.util.Date().getTime())));
			// 更新者
			t.setUpdateUser(param.get("updateUser").toString());
			tplanCollectDao.update(t);
			
			// 更新汇总分计划下的分计划，将分计划中的汇总分计划id设为null
			List<Tplan> planList = tplanDao.getPlanListByCollectId(param);
			
			if(planList != null && planList.size()>0){
				for (Tplan tplan : planList) {
					tplan.setTplanCollect(null);
					tplan.setUpdateUser(param.get("updateUser").toString());
					tplan.setUpdateDate((new java.sql.Timestamp(new java.util.Date().getTime())));
					tplan.setPlanState(Constants.PLAN_APPLIED);
					tplanDao.update(tplan);
				}
			}
		}
	}

	/**
	 * 选择分计划提交处理
	 */
	@Override
	public void updateSelectedPlan(Map<String, Object> param) {
		// 取得planId
		String planIsStr = param.get("planIdStr").toString();
		String[] planIdArr = planIsStr.substring(0, planIsStr.length()-1).split(",");
		// 取得planCollect对象
		TplanCollect pc = tplanCollectDao.get(param.get("planCollectId").toString());
		if(pc == null) 
			return;
		for (String string : planIdArr) {
			Tplan p = tplanDao.get(string);
			if(p != null){
				p.setTplanCollect(pc);
				p.setUpdateUser(param.get("updateUser").toString());
				p.setUpdateDate((new java.sql.Timestamp(new java.util.Date().getTime())));
				// 更新分计划状态，将分计划的状态改为：分计划汇总完成
				p.setPlanState(Constants.PLAN_FINISH);
				tplanDao.update(p);
			}
		}
		
	}
}
