/*************** 版权声明***************
*
* Copyright (C) 2012 西安辉盛科技发展有限责任公司.
*
********************************************
*/
package com.hopsun.tppas.api.expert.action;

import com.hopsun.framework.base.action.BaseAction;

/**
 * @comment 专家评审管理
 * @author wangxiaodong
 * @DATE: 2013-08-27 @TIME: 下午10:09:37
 * @Vsersion: 1.0
 */
public class TexpertAuditAction extends BaseAction {

	private static final long serialVersionUID = 6156570821773822304L;

	
	/** 跳转路径**/
	private String retUrl;

	/** 翻页 */
	private int pageNo;
	
	/** 跳转页面massage**/
	private String retMsg;
	
	/**
	 * 得到专家审核列表
	 * @comments 
	 * @return
	 * @version 1.0
	 */
	public String getAuditList(){
		return "";
	}
	

	public int getPageNo() {
		return pageNo;
	}

	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}

	public String getRetUrl() {
		return retUrl;
	}

	public void setRetUrl(String retUrl) {
		this.retUrl = retUrl;
	}

	public String getRetMsg() {
		return retMsg;
	}

	public void setRetMsg(String retMsg) {
		this.retMsg = retMsg;
	}
}
