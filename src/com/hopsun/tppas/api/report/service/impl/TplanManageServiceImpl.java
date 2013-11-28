package com.hopsun.tppas.api.report.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.hopsun.framework.base.bean.Pager;
import com.hopsun.framework.base.service.impl.BaseServiceImpl;
import com.hopsun.tppas.api.report.dao.TplanManageDao;
import com.hopsun.tppas.api.report.dao.TprojectApplicationDao;
import com.hopsun.tppas.api.report.service.TplanManageService;
import com.hopsun.tppas.api.superadmin.dao.MitemDao;
import com.hopsun.tppas.common.Constants;
import com.hopsun.tppas.entity.Mitem;
import com.hopsun.tppas.entity.Tplan;
import com.hopsun.tppas.entity.TprojectApplication;
/**
 * @comments 分计划管理
 * @author wanglw
 * @date 2013-10-9 @time 上午9:28:12
 * @Version 1.0
 */
@Service
public class TplanManageServiceImpl extends BaseServiceImpl<Tplan,String> implements TplanManageService{
	
	@Resource
	private TplanManageDao tplanManageDao;
	@Resource
	public void setBaseDao(TplanManageDao tplanManageDao) {
		super.setBaseDao(tplanManageDao);
	}

	@Resource
	private MitemDao mitemDao;

	@Resource
	private TprojectApplicationDao tprojectApplicationDao;
	
	/**
	 * @comments 取得分计划List
	 * @param param
	 * @param pageNo
	 * @param pageSize
	 * @return
	 * @Version 1.0
	 */
	@SuppressWarnings("unchecked")
	public Pager getPlanList(Map<String, Object> param, int pageNo, int pageSize){
		Pager p = tplanManageDao.getPlanList(param, pageNo, pageSize);
		
		List<Tplan> plist = new ArrayList<Tplan>();
		if(p !=null && p.getList() != null && p.getList().size() >0){
			// 取得分计划List
			List<Tplan> planList = p.getList();
			// 封装数据
			for (Tplan tplan : planList) {
				// 计划批次
				String planBatch = mitemDao.getItemName(tplan.getPlanBatch());
				tplan.setPlanBatch(planBatch);
				// 计划状态
				String planStatusString = mitemDao.getItemName(tplan.getPlanState());
				tplan.setPlanStatusString(planStatusString);
				if(Constants.PLAN_APPLY.equals(tplan.getPlanState())){
					tplan.setPlanState("0");
				}
				else if(Constants.PLAN_ISSUED.equals(tplan.getPlanState())){
					tplan.setPlanState("1");
				}
				else{
					tplan.setPlanState("2");
				}
				// 项目分类
				tplan.setTypeName(tplan.getPlanFlagName() + Constants.STRING_LINK + tplan.getTypeName());
				// 包含项目数
				List<TprojectApplication> tpList = 
						tprojectApplicationDao.getList("tplan.planId", tplan.getPlanId());
				
				if(tpList != null){
					tplan.setProjectCount(tpList.size());
				}
				plist.add(tplan);
			}
			// 设定list集合
			p.setList(plist);
		}
		
		return p;
	}
	
	/**
	 * @comments 保存分计划 
	 * @param tplan
	 * @return
	 * @Version 1.0
	 */
	public String savePlan(Tplan tplan){
		
		// 计划状态
		tplan.setPlanState(Constants.PLAN_APPLY);
		
		// 创建时间
		tplan.setCreateTime(new java.sql.Timestamp(new java.util.Date().getTime()));
		
		// 删除区分
		tplan.setDeleteFlag("0");
		
		tplanManageDao.save(tplan);
		
		return tplan.getPlanId();
	}
	
	/**
	 * @comments 取得已创建的批次
	 * @param deptId
	 * @param ownFlag
	 * @return
	 * @Version 1.0
	 */
	public List<Mitem> getSelectedBatch(String projectTypeString, String planId){
		
		List<Tplan> planList = tplanManageDao.getSelectedBatch(projectTypeString, planId);
		
		String batchStr = "";
		if(planList != null && planList.size() > 0){
			
			for (Tplan tplan : planList) {
				batchStr = batchStr + tplan.getPlanBatch() +",";
			}
		}
		String batchs [] =  batchStr.split(",");
		List<Mitem>  mitemList = mitemDao.get(batchs);
		return mitemList;
	}
	
	/**
	 * @comments 保存选择的项目
	 * @Version 1.0
	 */
	public void saveSelectedProject(String planId, String selectProjectIds){
		
		// 创建关联关系
		Tplan plan = new Tplan();
		plan.setPlanId(planId);
		
		if(selectProjectIds != null && !"".equals(selectProjectIds)){
			
			String ids[] = selectProjectIds.split(",");
			for (String id : ids) {
				TprojectApplication tp = tprojectApplicationDao.get(id);
				// 分计划
				tp.setTplan(plan);
				// 选择状态
				tp.setExpertProofResearch(Constants.PLANSELECT_3);
				tprojectApplicationDao.update(tp);
			}
		}
	}
	
	/**
	 * @comments 删除分计划及更新所包含项目的选择状态
	 * @param planId
	 * @Version 1.0
	 */
	public void deletePlan(String planId){
		
		// 更新所包含项目的选择状态
		List<TprojectApplication> tpList = tprojectApplicationDao.getList("tplan.planId", planId);
		
		if(tpList != null && tpList.size() > 0){
			
			for (TprojectApplication tprojectApplication : tpList) {
				Tplan plan = new Tplan();
				plan.setPlanId("");
				// 分计划
				tprojectApplication.setTplan(plan);
				// 选择状态
				tprojectApplication.setExpertProofResearch("");
				
				tprojectApplicationDao.update(tprojectApplication);
				
				// tprojectApplicationDao.evict(tprojectApplication);
			}
		}
		
		// 删除分计划
		tplanManageDao.delete(planId);
	}
	
	/**
	 * @comments 提交分计划
	 * @param tplan
	 * @param proList
	 * @Version 1.0
	 */
	public void savePlan(Tplan tplan, List<TprojectApplication> proList){
		
		// 取得分计划
		Tplan tp = tplanManageDao.get(tplan.getPlanId());
		tplan.setDeleteFlag(tp.getDeleteFlag());
		tplan.setCreateTime(tp.getCreateTime());
		tplan.setPlanState(Constants.PLAN_APPLIED);
		tplan.setProjectCount(tplan.getProjectCount() - 1);
		tplanManageDao.evict(tp);
		tplanManageDao.update(tplan);
		
		
		if(proList !=null && proList.size() > 0){
			
			for (TprojectApplication tpr : proList) {
				if(tpr==null){
					continue;
				}
				TprojectApplication tpTemp = tprojectApplicationDao.get(tpr.getProjectId());
				tpTemp.setExpertProofResearch(tpr.getExpertProofResearch());
				tprojectApplicationDao.evict(tpr);
				tprojectApplicationDao.update(tpTemp);
			}
		}
	}
}
