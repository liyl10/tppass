/************************* 版权声明 *********************************
 *
 * Copyright (C) 2012 西安辉盛科技发展有限责任公司.
 *
 ******************************************************************
 */
package com.hopsun.tppas.api.supervisor.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.hopsun.framework.base.service.impl.BaseServiceImpl;
import com.hopsun.tppas.api.supervisor.dao.TprojectCompleteInfoDao;
import com.hopsun.tppas.api.supervisor.dao.TtechnicalCompleteInfoDao;
import com.hopsun.tppas.api.supervisor.service.TprojectCompleteInfoService;
import com.hopsun.tppas.entity.TprojectCompleteInfo;
import com.hopsun.tppas.entity.Tsupervisor;
import com.hopsun.tppas.entity.TtechnicalCompleteInfo;

/**
 * @comments 对照合同项目任务完成情况
 * @author wangxiaodong
 * @date 2013-9-22
 * @version 1.0
 */
@Service
public class TprojectCompleteInfoServiceImpl extends BaseServiceImpl<TprojectCompleteInfo,String> implements TprojectCompleteInfoService{
	
	@Resource
	private TprojectCompleteInfoDao tprojectCompleteInfoDao;
	
	@Resource
	private TtechnicalCompleteInfoDao ttechnicalCompleteInfoDao;
	
	@Resource
	public void setBaseDao(TprojectCompleteInfoDao tprojectCompleteInfoDao) {
		super.setBaseDao(tprojectCompleteInfoDao);
	}

	/**
	 * 通过监理ID查询该监理下的对照合同项目任务完成情况
	 * @comments 
	 * @param supervisorId
	 * @return
	 * @version 1.0
	 */
	public TprojectCompleteInfo getProjectCompleteInfoBySupervisorId(String supervisorId) {
		
		return tprojectCompleteInfoDao.getProjectCompleteInfoBySupervisorId(supervisorId);
	}

	/**
	 * 保存或修改对照合同项目任务完成情况
	 * @comments 
	 * @param supervisorId
	 * @param tprojectCompleteInfo
	 * @version 1.0
	 */
	public void saveOrUpdate(String supervisorId,TprojectCompleteInfo tprojectCompleteInfo,String[] selectedProjectStopReason,List<TtechnicalCompleteInfo> technicalList) {
		//监理信息
		Tsupervisor supervisor = new Tsupervisor();
		supervisor.setSupervisorId(supervisorId);
		tprojectCompleteInfo.setTsupervisor(supervisor);
		
		//封装影响项目进展原因
		StringBuffer tempSelectReason = new StringBuffer();
		for (int i = 0; i < selectedProjectStopReason.length; i++) {
			if (i != 0) {
				tempSelectReason.append(',');
			}
			tempSelectReason.append(selectedProjectStopReason[i]);
		}
		tprojectCompleteInfo.setProjectReason(tempSelectReason.toString());
		//修改
		if(tprojectCompleteInfo.getProjectCompleteInfoId()!=null&&tprojectCompleteInfo.getProjectCompleteInfoId().length()>0){
			tprojectCompleteInfo.setUpdateDate(new java.sql.Timestamp(new java.util.Date().getTime()));
			//tsupervisorFundB.setUpdateUser();
			tprojectCompleteInfoDao.update(tprojectCompleteInfo);
		}else{//添加
			tprojectCompleteInfo.setDeleteFlag("0");
			tprojectCompleteInfo.setCreateTime(new java.sql.Timestamp(new java.util.Date().getTime()));
			//tsupervisorFundB.setCreateUser();	
			tprojectCompleteInfoDao.save(tprojectCompleteInfo);
		}
		
		//保存技术指标完成情况
		if(technicalList!=null&&technicalList.size()>0){
			for(int i=0;i<technicalList.size();i++){
				TtechnicalCompleteInfo technicalCompleteInfo = technicalList.get(i);
				if(technicalCompleteInfo!=null){
					technicalCompleteInfo.setTsupervisor(supervisor);
					technicalCompleteInfo.setDeleteFlag("0");
					technicalCompleteInfo.setCreateTime(new java.sql.Timestamp(new java.util.Date().getTime()));
					if(technicalCompleteInfo.getTechnicalCompleteInfo()!=null&&technicalCompleteInfo.getTechnicalCompleteInfo().length()>0){
						ttechnicalCompleteInfoDao.update(technicalCompleteInfo);
					}else{
						ttechnicalCompleteInfoDao.save(technicalCompleteInfo);
					}
				}
			}
		}
	}
}
