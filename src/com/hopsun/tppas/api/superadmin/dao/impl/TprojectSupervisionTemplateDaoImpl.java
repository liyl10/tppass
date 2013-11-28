package com.hopsun.tppas.api.superadmin.dao.impl;

import com.hopsun.tppas.api.superadmin.dao.TprojectSupervisionTemplateDao;
import com.hopsun.framework.base.bean.Finder;
import com.hopsun.framework.base.bean.Pager;
import com.hopsun.framework.base.dao.impl.BaseDaoImpl;
import com.hopsun.tppas.entity.TprojectSupervisionTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class TprojectSupervisionTemplateDaoImpl extends BaseDaoImpl<TprojectSupervisionTemplate, String> implements TprojectSupervisionTemplateDao {
	   
	/**
	 * 分页查询
	 *@param pageNumber pageSize 
	 *@return Pager
	 */
	public Pager findByPager(String name, Integer pageNumber, Integer pageSize){
		
		//创建Finder查询对象
		Finder f = Finder.create(" from TprojectSupervisionTemplate d where d.deleteFlag=:deleteFlag");

		if (name !=null && !"".equals(name)  ) {
			f.append(" and d.supervisionTemplateName like :supervisionTemplateName");
			f.setParam("supervisionTemplateName", "%"+name + "%");
		}
		f.setParam("deleteFlag", "0");
		return super.find(f, pageNumber, pageSize);
	}
}
