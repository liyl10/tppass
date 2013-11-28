/*************** 版权声明***************
*
* Copyright (C) 2012 西安辉盛科技发展有限责任公司.
*
********************************************
*/
package com.hopsun.tppas.api.expert.service.impl;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.hopsun.framework.base.bean.Pager;
import com.hopsun.framework.base.service.impl.BaseServiceImpl;
import com.hopsun.tppas.api.expert.dao.TtechnologyGainDao;
import com.hopsun.tppas.api.expert.service.TtechnologyGainService;
import com.hopsun.tppas.common.Constants;
import com.hopsun.tppas.entity.TtechnologyGain;
/**
 * @comment 后台service实现类-主要用来实现专家的成果信息的接口
 * @author yank
 * @DATE: 2013-08-19 @TIME: 下午2:09:37
 * @Vsersion: 1.0
 */
@Service
public class TtechnologyGainServiceImpl extends BaseServiceImpl<TtechnologyGain,String> implements TtechnologyGainService{
	
	@Resource
	private TtechnologyGainDao ttechnologyGainDao;
	
	@Resource
	public void setBaseDao(TtechnologyGainDao ttechnologyGainDao) {
		super.setBaseDao(ttechnologyGainDao);
	}
	
	/**
	 * 查询专家的成果信息
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	public Pager queryTechnologyGain(Map<String,String> map,int pageNo, int pageSize) {
		return ttechnologyGainDao.queryTechnologyGain(map,pageNo, pageSize);
	}

	/**
	 * 删除专家的成果信息
	 * @comments 
	 * @param gainId
	 * @version 1.0
	 */
	public void deleteTechnologyGain(String gainId) {
		TtechnologyGain TtechnologyGain = ttechnologyGainDao.get(gainId);
		TtechnologyGain.setDeleteFlag(Constants.COMMON_STATE_DELETE);	
	}
}
