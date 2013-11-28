package com.hopsun.tppas.common;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.http.HttpServletResponse;

/**
 * @comments 文件下载
 * @author wanglw
 * @date 2013-5-17 @time 下午3:57:37
 * @Version 1.0
 */
public class FileDownLoad {

	/**
	 * 文件全路径下载
	 * 
	 * @param response
	 * @param 文件路径
	 * @param 文件名称
	 * @return　void<Tcost>
	 */
	public void writeDownloadStream(HttpServletResponse response,
			String strFileFullPath, String strClientName) throws Exception {

		int iBufSize = 1024;

		InputStream inStream = null;
		OutputStream outStream = null;
		try {

			inStream = new BufferedInputStream(new FileInputStream(
					strFileFullPath));
			outStream = response.getOutputStream();

			strClientName = new String(strClientName.getBytes("GB2312"),
					"ISO8859_1");

			response.setContentType("application/octet-stream");
			response.setHeader("Content-Disposition", "attachment;filename="
					+ strClientName);
			int iData;
			byte[] b = new byte[iBufSize];

			while ((iData = inStream.read(b, 0, iBufSize)) != -1) {
				outStream.write(b, 0, iData);
			}
		} finally {
			if (inStream != null) {
				inStream.close();
			}
			if (outStream != null) {
				outStream.close();
			}
		}

	}
}
