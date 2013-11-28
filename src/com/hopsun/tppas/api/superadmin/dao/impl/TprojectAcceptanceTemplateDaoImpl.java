package com.hopsun.tppas.api.superadmin.dao.impl;

import com.hopsun.tppas.api.superadmin.dao.TprojectAcceptanceTemplateDao;
import com.hopsun.framework.base.bean.Finder;
import com.hopsun.framework.base.bean.Pager;
import com.hopsun.framework.base.dao.impl.BaseDaoImpl;
import com.hopsun.tppas.entity.TprojectAcceptanceTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class TprojectAcceptanceTemplateDaoImpl extends BaseDaoImpl<TprojectAcceptanceTemplate, String> implements TprojectAcceptanceTemplateDao {
	   
	/**
	 * 分页查询
	 *@param pageNumber pageSize 
	 *@return Pager
	 */
	public Pager findByPager(String name, Integer pageNumber, Integer pageSize){
		
		//创建Finder查询对象
		Finder f = Finder.create(" from TprojectAcceptanceTemplate d where d.deleteFlag=:deleteFlag");

		if (name !=null && !"".equals(name)  ) {
			f.append(" and d.acceptanceTemplateName like :acceptanceTemplateName");
			f.setParam("acceptanceTemplateName", "%"+name + "%");
		}
		f.setParam("deleteFlag", "0");
		return super.find(f, pageNumber, pageSize);
	}
}
