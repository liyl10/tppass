/*************** 版权声明***************
*
* Copyright (C) 2012 西安辉盛科技发展有限责任公司.
*
********************************************
*/
package com.hopsun.tppas.api.superadmin.action;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import com.hopsun.framework.base.action.BaseAction;
import com.hopsun.framework.base.bean.Pager;
import com.hopsun.tppas.api.superadmin.service.MitemService;
import com.hopsun.tppas.api.superadmin.service.MtypeService;
import com.hopsun.tppas.common.Constants;
import com.hopsun.tppas.entity.Mitem;
import com.hopsun.tppas.entity.Mtype;

/**
 * @comment 类型详细内容的实例
 * @author liush
 * @DATE: 2013-5-23 @TIME: 下午2:16:09
 * @Vsersion: 1.0
 */
public class MitemAction extends BaseAction{
	public final static Logger LOGGER = Logger.getLogger(MitemAction.class.getName());
	private static final long serialVersionUID = 805589034295922091L;
	@Resource
	private MitemService mitemService;
	@Resource
	private MtypeService mtypeService;
	
	/** 其他code表查询的类别 */
	private String masterTypeName;
	/** 跳转页数 */
	private int pageNo;
	private String itemType;
	private Mitem mitem;
	private Mtype mtype;
	private List<Mitem> pitemLst;
	private String itemId;
	private String typeId;
	private String retMsg;
	private String retUrl;
	private List<Mitem> resultList;
	private List<String> itemIdLst;
	private List<String> itemValueLst;
	private String subPage;
	/** 下拉列表父级Id */
	private String pitemId;
	/** 下拉列表返回字符串 */
	private String backStr;
	/** 其他code表查询的类别 */
	private String masterType;

	/**
	 * @Comments 画面 初期化处理
	 * @return
	 * @Vsersion: 1.0
	 */
	public String init() {
		return "initMitem";
	}
	
	/**
	 * @Comments 修改信息
	 * @return
	 * @Vsersion: 1.0
	 */
	public String updateDept(){
		HttpSession session = this.getRequest().getSession();
		String cmdkey = (String) session.getAttribute(Constants.SESSION_CMDKEY);
		if (cmdkey == null
				|| !"super_contractSetting".equals(cmdkey)) {
			LOGGER.error("令牌不正确");
			return "LogOut";
		}
		Mitem newMitem = mitemService.get(this.itemId);
		newMitem.setDelFlg("1");
		mitemService.saveOrUpdate(newMitem);
		this.setRetMsg(this.getText("opt_del_suc"));
		this.setRetUrl(super.getRequest().getContextPath()
				+ "/api/superadmin/mtype!initOtherSetting.action?dd="
				+ new Date().getTime() + "&masterType="+this.masterType);
		return "systemInfoMain";		
	}
		
	/**
	 * @Comments 代码值配置画面查询列表处理
	 * @return
	 * @throws Exception
	 * @Vsersion: 1.0
	 */
	public String queryOtherList() throws Exception {
		HttpSession session = this.getRequest().getSession();
		session.setAttribute(Constants.SESSION_CMDKEY, "super_contractSetting");
		//得到数据总个数
		setPager(new Pager());
		pager = new Pager();
    	if (this.getPageNo() != 0) {
    		pager.setPageNumber(this.getPageNo());
    	}
		pager = mitemService.find(masterType ,pager.getPageNumber(), pager.getPageSize());

		// 返回
		return "initOtherList";
	}

	/**
	 * @Comments 代码值配置画面追加处理 初期化处理
	 * @return
	 * @throws Exception
	 * @Vsersion: 1.0
	 */
	public String initNewOtherItem() throws Exception {
		HttpSession session = this.getRequest().getSession();
		session.setAttribute(Constants.SESSION_CMDKEY, "super_contractSetting");
		if (!StringUtils.isEmpty(masterTypeName)) {
			masterTypeName = new String(masterTypeName.getBytes("ISO8859-1"),
					"UTF-8");
		}
		// 取得类型信息
		mtype = (Mtype) mtypeService.get("typeId", this.itemType);
		pitemLst = new ArrayList<Mitem>();
		// 判断是否读取父条目列表
		if ("1".equals(mtype.getPTypeFlag())) {
			pitemLst = (List<Mitem>) mitemService.getList("mtype.typeId", mtype.getPTypeId());
		}
		// 判断是新增条目还是修改条目
		if (itemId != null && !"".equals(itemId)) {
			mitem = this.mitemService.get(itemId);
		}else{
			mitem = new Mitem();
		}

		return "initAddOtherSetting";
	}
	
	/**
	 * @Comments 跳转到修改页面
	 * @return
	 * @Vsersion: 1.0
	 */
	public String modify(){
		HttpSession session = this.getRequest().getSession();
		String cmdkey = (String) session.getAttribute(Constants.SESSION_CMDKEY);
		//判断令牌
		if (cmdkey == null
				|| !"super_contractSetting".equals(cmdkey)) {
			LOGGER.error("令牌不正确");
			return "LogOut";
		}
		mitem.setDelFlg("0");
		//追加代码值配置
		if ("".equals(itemId)) {
			mitem.setItemId(null);
			this.setRetMsg(this.getText("opt_save_suc"));
		} else {
			mitem.setItemId(itemId);
			this.setRetMsg(this.getText("opt_update_suc"));
		}
		Mtype newMtype = mtypeService.get(typeId);
		mitem.setMtype(newMtype);
		mitemService.saveOrUpdate(mitem);
		this.setRetUrl(super.getRequest().getContextPath()
				+ "/api/superadmin/mtype!initOtherSetting.action?dd="
				+ new Date().getTime() + "&masterType="+this.masterType);
		return "systemInfoMain";
	}

	/**
	 * @Comments 系统参数设定画面 初期化处理
	 * @return
	 * @throws Exception
	 * @Vsersion: 1.0
	 */
	public String initContractSetting() throws Exception {
 		HttpSession session = this.getRequest().getSession();
		session.setAttribute(Constants.SESSION_CMDKEY, "super_contractSetting");
		resultList = (List<Mitem>) mitemService.getList("mtype.typeId", Constants.SYSTEM_SETTING);
		return "initContractSetting";
	}
	
	/**
	 * @Comments 系统参数画面 保存
	 * @return
	 * @throws Exception
	 * @Vsersion: 1.0
	 */
	public String saveContractSetting() throws Exception {
		HttpSession session = this.getRequest().getSession();
		String cmdkey = (String) session.getAttribute(Constants.SESSION_CMDKEY);
		//判断令牌
		if (cmdkey == null
				|| !"super_contractSetting".equals(cmdkey)) {
			LOGGER.error("错误的令牌！");
			return "LogOut";
		}

		for (int i = 0; i < itemIdLst.size(); i++) {
			String itemId = itemIdLst.get(i);
			String itemDesc = new String(itemValueLst.get(i).getBytes(
					"ISO8859-1"), "UTF-8");

			Mitem mitemA = mitemService.get(itemId);
			mitemA.setItemDesc(itemDesc);
			mitemService.update(mitemA);
		}

		// 系统参数画面
		this.setRetMsg(this.getText("opt_update_suc"));
		this.setRetUrl(super.getRequest().getContextPath()
				+ "/api/superadmin/mitem!initContractSetting.action?dd="
				+ new Date().getTime());
		return "systemInfoMain";
	}

	/**
	 * @comments 下拉列表联动
	 * @return
	 * @version 1.0
	 */
	public String getSecondData() throws Exception {
		try {
			// 取得联动下拉列表数据List
			List<Mitem> dataList = mitemService.getMitemListByPId(pitemId);
			StringBuffer dataStr = new StringBuffer();

			if (dataList != null) {
				// 遍历下拉列表List 组成json字符串
				for (int i = 0; i < dataList.size(); i++) {
					dataStr.append(dataList.get(i).getItemId());
					dataStr.append(",");
					dataStr.append(dataList.get(i).getItemName());
					if (i != dataList.size() - 1) {
						dataStr.append(",");
					}
				}
			}
			this.backStr = dataStr.toString();
			return "getDataSuccess";
		} catch (Exception e) {
			return "error";
		}
	}
	
	public int getPageNo() {
		return pageNo;
	}

	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}

	public String getMasterTypeName() {
		return masterTypeName;
	}

	public void setMasterTypeName(String masterTypeName) {
		this.masterTypeName = masterTypeName;
	}

	public String getItemType() {
		return itemType;
	}

	public void setItemType(String itemType) {
		this.itemType = itemType;
	}

	public Mitem getMitem() {
		return mitem;
	}

	public void setMitem(Mitem mitem) {
		this.mitem = mitem;
	}

	public Mtype getMtype() {
		return mtype;
	}

	public void setMtype(Mtype mtype) {
		this.mtype = mtype;
	}

	public List<Mitem> getPitemLst() {
		return pitemLst;
	}

	public void setPitemLst(List<Mitem> pitemLst) {
		this.pitemLst = pitemLst;
	}

	public String getItemId() {
		return itemId;
	}

	public void setItemId(String itemId) {
		this.itemId = itemId;
	}

	public MtypeService getMtypeService() {
		return mtypeService;
	}

	public void setMtypeService(MtypeService mtypeService) {
		this.mtypeService = mtypeService;
	}

	public String getTypeId() {
		return typeId;
	}

	public void setTypeId(String typeId) {
		this.typeId = typeId;
	}

	public String getMasterType() {
		return masterType;
	}

	public void setMasterType(String masterType) {
		this.masterType = masterType;
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

	public List<Mitem> getResultList() {
		return resultList;
	}

	public void setResultList(List<Mitem> resultList) {
		this.resultList = resultList;
	}

	public List<String> getItemIdLst() {
		return itemIdLst;
	}

	public void setItemIdLst(List<String> itemIdLst) {
		this.itemIdLst = itemIdLst;
	}

	public List<String> getItemValueLst() {
		return itemValueLst;
	}

	public void setItemValueLst(List<String> itemValueLst) {
		this.itemValueLst = itemValueLst;
	}

	public String getSubPage() {
		return subPage;
	}

	public void setSubPage(String subPage) {
		this.subPage = subPage;
	}

	/**
	 * @return the mitemService
	 */
	public MitemService getMitemService() {
		return mitemService;
	}

	/**
	 * @param mitemService the mitemService to set
	 */
	public void setMitemService(MitemService mitemService) {
		this.mitemService = mitemService;
	}

	/**
	 * @return the pitemId
	 */
	public String getPitemId() {
		return pitemId;
	}

	/**
	 * @param pitemId the pitemId to set
	 */
	public void setPitemId(String pitemId) {
		this.pitemId = pitemId;
	}

	/**
	 * @return the backStr
	 */
	public String getBackStr() {
		return backStr;
	}

	/**
	 * @param backStr the backStr to set
	 */
	public void setBackStr(String backStr) {
		this.backStr = backStr;
	}
	
}
