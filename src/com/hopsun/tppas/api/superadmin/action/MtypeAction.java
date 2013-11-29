/*************** 版权声明***************
*
* Copyright (C) 2012 西安辉盛科技发展有限责任公司.
*
********************************************
*/
package com.hopsun.tppas.api.superadmin.action;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import org.apache.log4j.Logger;
import com.hopsun.framework.base.action.BaseAction;
import com.hopsun.framework.base.bean.Pager;
import com.hopsun.scenter.entity.ScUsers;
import com.hopsun.tppas.api.superadmin.service.MtypeService;
import com.hopsun.tppas.common.CommonTool;
import com.hopsun.tppas.common.Constants;
import com.hopsun.tppas.entity.Mtype;

/**
 * @comment 操作类型表的实体类
 * @author liush
 * @DATE: 2013-5-23 @TIME: 下午2:12:08
 * @Vsersion: 1.0
 */
public class MtypeAction extends BaseAction{
  
	private static final long serialVersionUID = 3298635544607314628L;
	
	public final static Logger LOGGER = Logger.getLogger(MitemAction.class.getName());
	
	@Resource
	private MtypeService mtypeService;
	private Mtype mtype;
	private List<Mtype> resultList;
	/** 查询输出类型列表 */
	private List<Mtype> typeLst;
	/** 其他code表查询的类别 */
	private String masterTypeName;
	private String masterType;
	/** 跳转页数 */
	private int pageNo;
	/** 类型的编号 */
	private String typeId;	
	private String retMsg;
	private String retUrl;
	private String subPage;
	
	/**
	 * @Comments 代码类型配置画面初期化
	 * @return
	 * @throws Exception
	 * @Vsersion: 1.0
	 */
	public String initTypeSetting() {
		// 取得登录用户的信息
		HttpSession session = this.getRequest().getSession();
		ScUsers user = (ScUsers) session.getAttribute("sysUser");
    	session.setAttribute(Constants.SESSION_CMDKEY, "super_typeSetting");
		
    	// 判断是否失效
    	if (user == null || ("").equals(user.getUserId())) {
    		LOGGER.error("用户不存在！");
			return "LogOut";
		}
    	
		// 取得Type的码表设定
		typeLst = mtypeService.getInfoList();
		
		return "initTypeSetting";
	}

	/**
	 * @Comments 画面查询处理
	 * @return
	 * @throws Exception
	 * @Vsersion: 1.0
	 */
	@SuppressWarnings("unchecked")
	public String queryType() {
		// 取得登录用户的信息
		HttpSession session = this.getRequest().getSession();
		String cmdkey = (String) session.getAttribute(Constants.SESSION_CMDKEY);
		if (cmdkey == null || !"super_typeSetting".equals(cmdkey)) {
			LOGGER.error("错误的令牌！");
			return "LogOut";
		}

		// 得到数据总个数
		setPager(new Pager());
		pager = new Pager();
    	if (this.getPageNo() != 0) {
    		pager.setPageNumber(this.getPageNo());
    	}
    	// 检索条件
    	Map<String, Object> param = new HashMap<String, Object>();
    	param.put("masterType", masterType);
    	// 检索数据
		pager = mtypeService.find(param, pager.getPageNumber(), pager.getPageSize());
		
		List<Mtype> resultList = pager.getList();
		List<Mtype> tempList = mtypeService.getAll();

		// 循环设定父类型名（当有父类型时）
		for (Mtype type : resultList) {
			if ("1".equals(type.getPTypeFlag())) {
				for (Mtype ptype : tempList) {
					if (ptype.getTypeId().equals(type.getPTypeId())) {
						type.setPtypeName(ptype.getTypeName());
						break;
					}
				}
			}
		}
		
		return "queryType";
	}
	
	/**
	 * @Comments 新增的页面参数取得
	 * @return
	 * @throws Exception
	 * @Vsersion: 1.0
	 */
	public String initNewType() throws Exception {
		HttpSession session = this.getRequest().getSession();
		String cmdkey = (String) session.getAttribute(Constants.SESSION_CMDKEY);
		if (cmdkey == null
				|| !"super_typeSetting".equals(cmdkey)) {
			LOGGER.error("错误的令牌！");
			return "LogOut";
		}
		this.resultList = this.mtypeService.getInfoList();
		mtype = new Mtype();
		return "initTypeEditPage";
	}
	
	/**
	 * @Comments 代码值配置画面 初期化处理
	 * @return
	 * @throws Exception
	 * @Vsersion: 1.0
	 */
	public String initOtherSetting() throws Exception {
		HttpSession session = this.getRequest().getSession();
		session.setAttribute(Constants.SESSION_CMDKEY, "super_contractSetting");
		// 判断是否有选择查询条件
		if (CommonTool.IsNotEmpty(masterType)) {
			masterTypeName = masterType;
		}
		// 取得Type的码表设定
		typeLst = mtypeService.getInfoList();
		return "initOtherSetting";
	}

	/**
	 * @Comments 保存类型取得
	 * @return
	 * @throws Exception
	 * @Vsersion: 1.0
	 */
	public String saveType() throws Exception {
		HttpSession session = this.getRequest().getSession();
		String cmdkey = (String) session.getAttribute(Constants.SESSION_CMDKEY);
		if (cmdkey == null
				|| !"super_typeSetting".equals(cmdkey)) {
			LOGGER.error("错误的令牌！");
			return "LogOut";
		}
		// 判断是否有父节点
		if (mtype.getPTypeFlag() == null || "0".equals(mtype.getPTypeFlag())) {
			mtype.setPTypeFlag("0");
			mtype.setPTypeId(null);
		}

		// 判断更新还是插入
		if ("".equals(typeId)) {
			mtype.setTypeId(null);
			mtype.setCreateTime(new java.sql.Timestamp(new Date().getTime()));
			this.setRetMsg(this.getText("opt_save_suc"));
		} else {
			mtype.setTypeId(typeId);
			this.setRetMsg(this.getText("opt_update_suc"));
		}
		mtype.setUpdateTime(new java.sql.Timestamp(new Date().getTime()));
		mtype.setDelFlg("0");
		
		mtypeService.saveOrUpdate(mtype);

		this.setRetUrl(super.getRequest().getContextPath()
				+ "/api/superadmin/mtype!initTypeSetting.action?dd="
				+ new Date().getTime());
		return "systemInfoMain";
	}

	/**
	 * @Comments 修改的页面参数取得
	 * @return
	 * @throws Exception
	 * @Vsersion: 1.0
	 */
	public String initUpdateType() throws Exception {
		
		/** 取得Type的类别 */
		mtype = this.mtypeService.get(this.typeId);

		this.resultList = this.mtypeService.getInfoList();

		return "initTypeEditPage";
	}
	
	/**
	 * @Comments 画面 删除处理
	 * @return
	 * @throws Exception
	 * @Vsersion: 1.0
	 */
	public String deleteMtype() throws Exception {
		HttpSession session = this.getRequest().getSession();
		String cmdkey = (String) session.getAttribute(Constants.SESSION_CMDKEY);
		if (cmdkey == null
				|| !"super_typeSetting".equals(cmdkey)) {
			LOGGER.error("错误的令牌！");
			return "LogOut";
		}
		mtype = mtypeService.get(typeId);
		mtype.setDelFlg("1");
		mtypeService.saveOrUpdate(mtype);
		this.setRetMsg(this.getText("opt_del_suc"));
		this.setRetUrl(super.getRequest().getContextPath()
				+ "/api/superadmin/mtype!initTypeSetting.action?dd="
				+ new Date().getTime());
		return "systemInfoMain";
	}
	
	public MtypeService getMtypeService() {
		return mtypeService;
	}

	public void setMtypeService(MtypeService mtypeService) {
		this.mtypeService = mtypeService;
	}

	public int getPageNo() {
		return pageNo;
	}

	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}

	public List<Mtype> getResultList() {
		return resultList;
	}

	public void setResultList(List<Mtype> resultList) {
		this.resultList = resultList;
	}

	public String getTypeId() {
		return typeId;
	}

	public void setTypeId(String typeId) {
		this.typeId = typeId;
	}

	public Mtype getMtype() {
		return mtype;
	}

	public void setMtype(Mtype mtype) {
		this.mtype = mtype;
	}

	public List<Mtype> getTypeLst() {
		return typeLst;
	}

	public void setTypeLst(List<Mtype> typeLst) {
		this.typeLst = typeLst;
	}

	public String getRetMsg() {
		return retMsg;
	}

	public void setRetMsg(String retMsg) {
		this.retMsg = retMsg;
	}

	public String getRetUrl() {
		return retUrl;
	}

	public void setRetUrl(String retUrl) {
		this.retUrl = retUrl;
	}

	public String getMasterType() {
		return masterType;
	}

	public void setMasterType(String masterType) {
		this.masterType = masterType;
	}

	public String getSubPage() {
		return subPage;
	}

	public void setSubPage(String subPage) {
		this.subPage = subPage;
	}

	public String getMasterTypeName() {
		return masterTypeName;
	}

	public void setMasterTypeName(String masterTypeName) {
		this.masterTypeName = masterTypeName;
	}

	

}
