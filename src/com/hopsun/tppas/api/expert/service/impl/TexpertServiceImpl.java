/*************** 版权声明***************
*
* Copyright (C) 2012 西安辉盛科技发展有限责任公司.
*
********************************************
*/
package com.hopsun.tppas.api.expert.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.hopsun.framework.base.bean.Pager;
import com.hopsun.framework.base.service.impl.BaseServiceImpl;
import com.hopsun.scenter.api.util.Constant;
import com.hopsun.scenter.entity.ScUsers;
import com.hopsun.tppas.api.expert.dao.TexpertDao;
import com.hopsun.tppas.api.expert.dao.TexpertScoreDao;
import com.hopsun.tppas.api.expert.service.TexpertService;
import com.hopsun.tppas.api.report.dao.TgroupExpertRealtionDao;
import com.hopsun.tppas.api.superadmin.dao.MitemDao;
import com.hopsun.tppas.common.CommonTool;
import com.hopsun.tppas.common.Constants;
import com.hopsun.tppas.entity.Mitem;
import com.hopsun.tppas.entity.Texpert;
import com.hopsun.tppas.entity.TgroupExpertRealtion;
/**
 * @comment 后台service实现类-主要用来实现专家库操作的接口
 * @author wanglw
 * @DATE: 2013-08-19 @TIME: 下午2:09:37
 * @Vsersion: 1.0
 */
@Service
public class TexpertServiceImpl extends BaseServiceImpl<Texpert,String> implements TexpertService{
	
	@Resource
	private TexpertDao texpertDao;
	
	@Resource
	private TexpertScoreDao texpertScoreDao;
	
	@Resource
	private MitemDao mitemDao;
	
	@Resource
	private TgroupExpertRealtionDao tgroupExpertRealtionDao;
	
	@Resource
	public void setBaseDao(TexpertDao texpertDao) {
		super.setBaseDao(texpertDao);
	}
	
	// wanglw  Start
	
	/**
	 * @comments 取得继续添加的专家列表
	 * @param param
	 * @return
	 * @Version 1.0
	 */
	public List<Texpert> getAddAuditList(Map<String, Object> param){
		
		// 取得当前项目Id 
		String groupId = (String) param.get("groupId");
		
		List<TgroupExpertRealtion> tgList = tgroupExpertRealtionDao.getList("tprojectGroup.groupId", groupId);
		//List<TexpertScore> exScoreList = texpertScoreDao.getList("tprojectApplication.projectId", projectId);
		
		// 取得学历
		String schoolingType = (String) param.get("schoolingType");
		List<Mitem> schoolingTemp = new ArrayList<Mitem>();
		if(!isNullString(schoolingType)){
			List<Mitem> schoolingList = mitemDao.getListByTypeId(Constants.TYPE_PROJECT_PERSON_EDUCATION);
			schoolingTemp.addAll(schoolingList);
			for(int i=0; i< schoolingList.size(); i++){
				if(schoolingType.equals(schoolingList.get(i).getItemId())){
					break;
				}
				else{
					schoolingTemp.remove(schoolingList.get(i));
				}
			}
		}
		
		List<Texpert> expertList = texpertDao.getAddAuditList(param, tgList, schoolingTemp);
		
		List<Texpert> list = new ArrayList<Texpert>();
		
		if(expertList != null && expertList.size() > 0){
			
			for (Texpert texpert : expertList) {
				
				// 设置擅长专业1
				if(!"".equals(texpert.getExpertMajor1()) 
						&& texpert.getExpertMajor1() != null){
					// 取得擅长专业1
					String expertMajor1 = mitemDao.getItemName(texpert.getExpertMajor1());
					// 设置擅长专业1
					texpert.setExpertMajor1(expertMajor1);
				}
				
				// 设置擅长专业2
				if(!"".equals(texpert.getExpertMajor2()) 
						&& texpert.getExpertMajor2() != null){
					// 取得擅长专业2
					String expertMajor2 = mitemDao.getItemName(texpert.getExpertMajor2());
					// 设置擅长专业2
					texpert.setExpertMajor2(expertMajor2);
				}
				
				// 设置擅长专业3
				if(!"".equals(texpert.getExpertMajor3()) 
						&& texpert.getExpertMajor3() != null){
					// 取得擅长专业3
					String expertMajor3 = mitemDao.getItemName(texpert.getExpertMajor3());
					// 设置擅长专业3
					texpert.setExpertMajor3(expertMajor3);
				}
				
				// 设置信誉度等级
				if(!"".equals(texpert.getExpertPrestige()) 
						&& texpert.getExpertPrestige() != null){
					// 取得信誉度等级
					String expertPrestige = mitemDao.getItemName(texpert.getExpertPrestige());
					// 设置信誉度等级
					texpert.setExpertPrestige(expertPrestige);
				}
				
				// 设置专家类型
				if(!"".equals(texpert.getExpertType()) 
						&& texpert.getExpertType() !=null){
					// 取得专家类型
					String experttype = mitemDao.getItemName(texpert.getExpertType());
					// 设置专家类型
					texpert.setExpertType(experttype);
				}
				
				list.add(texpert);
			}
		}
		
		return list;
	}
	
	/**
	 * @comments 取得专家毕业院校集合
	 * @return
	 * @Version 1.0
	 */
	public List<Map<String, Object>> getGraduatedList(String showName, String property){
		
		// 初始化专家毕业院校List
		List<Map<String, Object>>  graduatedList = new ArrayList<Map<String, Object>>();
		
		// 取得专家库中所有的毕业院校
		List<Object> exList =  texpertDao.getProPertyList(property);
		
		// 遍历list集合
		if(exList != null && exList.size() > 0){
			for (Object graduateSchool : exList) {
				Map<String, Object> map = new HashMap<String, Object>();
				map.put(showName, graduateSchool);

				// 封装专家毕业院校信息 
				graduatedList.add(map);
			}
		}
		return graduatedList;
		
	}
	
	/**
	 * @comments 新增专家
	 * @param expert
	 * @param userId
	 * @Version 1.0
	 */
	public void saveAuditExpert(Texpert expert, String userId){
		
		// 设置创建者
		expert.setCreateUser(userId);
		
		// 设置创建时间
		expert.setCreateTime(new java.sql.Timestamp(new java.util.Date().getTime()));
		
		// 设置注册时间
		expert.setRegisterTime(new java.sql.Timestamp(new java.util.Date().getTime()));
		
		// 设置删除区分
		expert.setDeleteFlag(Constant.DELETE_STATE_FALSE);
		
		texpertDao.save(expert);
	}
	
	/**
	 * @comments 取得继续添加的专家列表(批量)
	 * @param param
	 * @return
	 * @Version 1.0
	 */
	public List<Texpert> getBatchAddAuditList(Map<String, Object> param){
		
		// 取得当前项目Id 
		String projectIds = (String) param.get("projectId");
		
		String projectId = "";
		
		if(projectIds != null && !"".equals(projectIds)){
			projectId = projectIds.split(",")[0];
		}
		
		//List<TexpertScore> exScoreList = texpertScoreDao.getList("tprojectApplication.projectId", projectId);
		List<TgroupExpertRealtion> tgList = tgroupExpertRealtionDao.getList("tprojectGroup.groupId", projectId);
		return texpertDao.getAddAuditList(param, tgList, null);
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
	public Pager getExpertStatisticList(Map<String, Object> param, int pageNo, int pageSize){
		Pager pager = texpertDao.getExpertStatisticList(param, pageNo, pageSize);
		List<Texpert> pagerList = new ArrayList<Texpert>();
		if(pager.getList()!=null&&pager.getList().size()>0){
			List<Texpert> all = pager.getList();
			for(int i=0;i<all.size();i++){
				Texpert expert = all.get(i);
				if(expert!=null){
					//信誉等级  EXPERT_PRESTIGE
					String expertPrestige = expert.getExpertPrestige();
					if(CommonTool.IsNotEmpty(expertPrestige)){
						expert.setExpertPrestige(mitemDao.getItemName(expertPrestige));
					}
					// 专家ID
					param.put("expertId", expert.getExpertId());
					
					// 评审项目数
					param.put("auditFlag", "0");
					int auditCount = texpertScoreDao.getExpertAuditCount(param);
					expert.setExpertMajor1(String.valueOf(auditCount));
					
					// 验收项目数
					param.put("auditFlag", "1");
					int acceptanceCount = texpertScoreDao.getExpertAuditCount(param);
					expert.setExpertMajor2(String.valueOf(acceptanceCount));
					
					// 参与项目数
					expert.setExpertMajor3(String.valueOf(auditCount + acceptanceCount));
				}
				pagerList.add(expert);
			}
		}
		pager.setList(pagerList);
		return pager;
	}
	
	/**
	 * @comments 取得专家评审统计List
	 * @param param
	 * @param pageNo
	 * @param pageSize
	 * @return
	 * @Version 1.0
	 */
	public List<Texpert> getExpertExportList(Map<String, Object> param){
		
		// 取得专家列表
		List<Texpert> pagerList = texpertDao.getExpertExportList(param);
		
		List<Texpert> expertList = new ArrayList<Texpert>();
		for(int i=0;i<pagerList.size();i++){
			Texpert expert = pagerList.get(i);
			if(expert!=null){
				//信誉等级  EXPERT_PRESTIGE
				String expertPrestige = expert.getExpertPrestige();
				if(CommonTool.IsNotEmpty(expertPrestige)){
					expert.setExpertPrestige(mitemDao.getItemName(expertPrestige));
				}
				// 专家ID
				param.put("expertId", expert.getExpertId());
				
				// 评审项目数
				param.put("auditFlag", "0");
				int auditCount = texpertScoreDao.getExpertAuditCount(param);
				expert.setExpertMajor1(String.valueOf(auditCount));
				
				// 验收项目数
				param.put("auditFlag", "1");
				int acceptanceCount = texpertScoreDao.getExpertAuditCount(param);
				expert.setExpertMajor2(String.valueOf(acceptanceCount));
				
				// 参与项目数
				expert.setExpertMajor3(String.valueOf(auditCount + acceptanceCount));
			}
			expertList.add(expert);
		}
		
		return expertList;
	}
	
	// wanglw End
	
	/**
	 * @comments 获取专家库信息
	 * @param param
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public Pager queryExportByParams(Map<String, Object> param, int pageNo,int pageSize){
		Pager pager = texpertDao.queryExportByParams(param, pageNo, pageSize);
		List<Texpert> pagerList = new ArrayList<Texpert>();
		if(pager.getList()!=null&&pager.getList().size()>0){
			List<Texpert> all = pager.getList();
			for(int i=0;i<all.size();i++){
				Texpert expert = all.get(i);
				if(expert!=null){
					//擅长专业1 EXPERT_MAJOR1
					String expertMajor1 = expert.getExpertMajor1();
					if(CommonTool.IsNotEmpty(expertMajor1)){
						expert.setExpertMajor1(mitemDao.getItemName(expertMajor1));
					}
					//擅长专业2 EXPERT_MAJOR2
					String expertMajor2 = expert.getExpertMajor2();
					if(CommonTool.IsNotEmpty(expertMajor2)){
						expert.setExpertMajor2(mitemDao.getItemName(expertMajor2));
					}
					//擅长专业3 EXPERT_MAJOR3
					String expertMajor3 = expert.getExpertMajor3();
					if(CommonTool.IsNotEmpty(expertMajor3)){
						expert.setExpertMajor3(mitemDao.getItemName(expertMajor3));
					}
					//职务 EXPERT_JOB
					String expertJob = expert.getExpertJob();
					if(CommonTool.IsNotEmpty(expertJob)){
						expert.setExpertJob(mitemDao.getItemName(expertJob));
					}
					//学位  EXPERT_DEGREE
					String expertDegree = expert.getExpertDegree();
					if(CommonTool.IsNotEmpty(expertDegree)){
						expert.setExpertDegree(mitemDao.getItemName(expertDegree));
					}
					//是否在职  EXPERT_INCUMBENCY
					String expertIncumbency = expert.getExpertIncumbency();
					if(CommonTool.IsNotEmpty(expertIncumbency)){
						if("1".equals(expertIncumbency)){
							expert.setExpertIncumbency(Constants.EXPERTINCUMBENCY_1);
						}else{
							expert.setExpertIncumbency(Constants.EXPERTINCUMBENCY_0);
						}
					}
					//信誉等级  EXPERT_PRESTIGE
					String expertPrestige = expert.getExpertPrestige();
					if(CommonTool.IsNotEmpty(expertPrestige)){
						expert.setExpertPrestige(mitemDao.getItemName(expertPrestige));
					}
				}
				pagerList.add(expert);
			}
		}
		pager.setList(pagerList);
		return pager;
	}


	/**
	 * 保存专家基本信息
	 * @comments 
	 * @param texpert
	 * @param user
	 * @version 1.0
	 */
	public void saveOrUpdate(Texpert texpert, ScUsers user) {
		//修改
		if(texpert.getExpertId()!=null&&texpert.getExpertId().length()>0){
			texpert.setUpdateDate(new java.sql.Timestamp(new java.util.Date().getTime()));
			texpert.setUpdateUser(user.getUserId());
			texpertDao.update(texpert);
		}else{//添加
			texpert.setDeleteFlag("0");
			texpert.setCreateTime(new java.sql.Timestamp(new java.util.Date().getTime()));
			texpert.setCreateUser(user.getUserId());
			texpert.setRegisterTime(new java.sql.Timestamp(new java.util.Date().getTime()));
			texpert.setUpdateDate(new java.sql.Timestamp(new java.util.Date().getTime()));
			texpertDao.save(texpert);
		}
		
	}


	/**
	 * 删除专家信息
	 * @comments 
	 * @param expertId
	 * @version 1.0
	 */
	public void deleteExpert(String expertId) {
		Texpert expert = texpertDao.get(expertId);
		expert.setDeleteFlag(Constants.COMMON_STATE_DELETE);
		//texpertDao.update(expert);
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
