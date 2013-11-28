package com.hopsun.tppas.common;

import java.sql.Timestamp;
import java.util.Date;

/**
 * @comment 工具类
 * @author liush
 * @DATE: 2013-8-7 @TIME: 上午10:10:06
 * @Vsersion: 1.0
 */
public class CommonTool {
	
	/**
	 * @Comments 判断是否为空
	 * @param name
	 * @return
	 * @Vsersion: 1.0
	 */
	public static boolean IsEmpty(String name) {
		if ("".equals(name) || name == null) {
			return true;
		}
		return false;
	}
	
	/**
	 * @Comments 判断是否不为空
	 * @param name
	 * @return
	 * @Vsersion: 1.0
	 */
	public static boolean IsNotEmpty(String name) {
		if ("".equals(name) || name == null) {
			return false;
		}
		return true;
	}

	/**
	 * @Comments 取得系统时间
	 * @return
	 * @Vsersion: 1.0
	 */
	public static Timestamp getTimestampTime() {
		return new java.sql.Timestamp(new Date().getTime());
	}
}
