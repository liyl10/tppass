/************************* 版权声明 *********************************
 *
 * Copyright (C) 2012 西安辉盛科技发展有限责任公司.
 *
 ******************************************************************
 */
package com.hopsun.tppas.common;

import java.io.IOException;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.log4j.Logger;

/**
 * 发送短信和EMail
 *@comments
 *@author wangxiaodong
 *@date 2013-9-18
 *@version 1.0
 */
public class MessageSend implements java.io.Serializable{
	
	private static final long serialVersionUID = 1325023704469718705L;
	
	public final static Logger logger = Logger.getLogger(MessageSend.class.getName());
	
	/**
	 * 发送短信接口
	 * @comments 
	 * @param message
	 * @version 1.0
	 */
	public static void smsSend(Message message){
		//构造客户端
		String url = Constants.SEND_SMS_URL;
		HttpClient client = new HttpClient();
		PostMethod method = null;
		method = new UTF8PostMethod(url);
		method.addParameter("smsTheme",message.getMessageTheme());
		method.addParameter("smsContent",message.getMessageContent());
		method.addParameter("contractCode",Constants.SEND_SMS_CONTRACTCODE);
		//接收者为多个时，手机号格式如：13589562314,15896587412
		method.addParameter("mobile",message.getSendNumber());
		method.addParameter("userName",Constants.SEND_SMS_USERNAME);
		method.addParameter("passWord",Constants.SEND_SMS_PASSWORD);
		try {
			//发送
			client.executeMethod(method);
			logger.error(method.getResponseBodyAsString());
		} catch (HttpException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 发送邮件接口
	 * @comments 
	 * @param message
	 * @version 1.0
	 */
	public static void emailSend(Message message){
		//构造客户端
		String url = Constants.SEND_EMAIL_URL;
		HttpClient client = new HttpClient();
		PostMethod method = null;
		method = new UTF8PostMethod(url);
		method.addParameter("emailTheme",message.getMessageTheme());
		method.addParameter("emailContent",message.getMessageContent());
		method.addParameter("contractCode",Constants.SEND_EMAIL_CONTRACTCODE);
		method.addParameter("reciveEmail",message.getSendNumber());
		method.addParameter("userName",Constants.SEND_EMAIL_USERNAME);
		method.addParameter("passWord",Constants.SEND_EMAIL_PASSWORD);
		try {
			//发送
			client.executeMethod(method);
			logger.error(method.getResponseBodyAsString());
		} catch (HttpException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 接口发送站内信测试
	 */
	public static void msgSend(Message message){
		//构造客户端
		String url = "http://localhost:8080/mcenter/server_mcenter/receive/msg_send.jsp";
		HttpClient client = new HttpClient();
		PostMethod method = null;
		method = new UTF8PostMethod(url);
		method.addParameter("msgTheme","测试接口发送站内信");
		method.addParameter("msgContent","测试1111");
		method.addParameter("contractCode","wgp_test");
		method.addParameter("reciveCode","1111,2222");
		method.addParameter("platformCode","mcenter");
		method.addParameter("userName","wgp");
		method.addParameter("passWord","123");
		try {
			//发送
			client.executeMethod(method);
			logger.error(method.getResponseBodyAsString());
		} catch (HttpException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static class UTF8PostMethod extends PostMethod{
	    public UTF8PostMethod(String url){
	        super(url);
	    }
	    @Override
	    public String getRequestCharSet() {
	        //return super.getRequestCharSet();
	        return "UTF-8";
	    }
	}
}
