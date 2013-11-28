/************************* 版权声明 *********************************
 *
 * Copyright (C) 2012 西安辉盛科技发展有限责任公司.
 *
 ******************************************************************
 */
package com.hopsun.tppas.common;

/**
 * 发送短信和email信息类
 *@comments
 *@author wangxiaodong
 *@date 2013-9-18
 *@version 1.0
 */
public class Message implements java.io.Serializable{

	private static final long serialVersionUID = -1115519099678930925L;
	
	/**消息主题*/
	private String messageTheme;
	
	/**消息内容*/
	private String messageContent;
	
	/**消息发送的手机号或者email地址*/
	private String sendNumber;

	public String getMessageTheme() {
		return messageTheme;
	}

	public void setMessageTheme(String messageTheme) {
		this.messageTheme = messageTheme;
	}

	public String getMessageContent() {
		return messageContent;
	}

	public void setMessageContent(String messageContent) {
		this.messageContent = messageContent;
	}

	public String getSendNumber() {
		return sendNumber;
	}

	public void setSendNumber(String sendNumber) {
		this.sendNumber = sendNumber;
	}
}
