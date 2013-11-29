package com.hopsun.tppas.api.superadmin.dao.impl;

import com.hopsun.tppas.api.superadmin.dao.TprojectContractTemplateDao;
import com.hopsun.framework.base.bean.Finder;
import com.hopsun.framework.base.bean.Pager;
import com.hopsun.framework.base.dao.impl.BaseDaoImpl;
import com.hopsun.tppas.entity.TprojectContractTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class TprojectContractTemplateDaoImpl extends BaseDaoImpl<TprojectContractTemplate, String> implements TprojectContractTemplateDao {
	
	/**
	 * 分页查询
	 *@param pageNumber pageSize 
	 *@return Pager
	 */
	public Pager findByPager(String name, Integer pageNumber, Integer pageSize){
		
		//创建Finder查询对象
		Finder f = Finder.create(" from TprojectContractTemplate d where d.deleteFlag=:deleteFlag");

		if (name !=null && !"".equals(name)  ) {
			f.append(" and d.contractTemplateName like :contractTemplateName");
			f.setParam("contractTemplateName", "%"+name + "%");
		}
		f.setParam("deleteFlag", "0");
		return super.find(f, pageNumber, pageSize);
	}
}
