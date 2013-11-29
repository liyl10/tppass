package com.hopsun.tppas.common;

import java.io.OutputStream;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import jxl.Workbook;
import jxl.format.Alignment;
import jxl.format.Border;
import jxl.format.BorderLineStyle;
import jxl.format.Colour;
import jxl.format.UnderlineStyle;
import jxl.format.VerticalAlignment;
import jxl.write.Label;
import jxl.write.WritableCellFormat;
import jxl.write.WritableFont;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

/**
 *@comments Excel导出共用类
 *@author wangxiaodong
 *@date 2013-5-17 下午5:00:49 
 *@version 1.0
 */
public class ExcelIterator {

    /**
     * <p>
     * 输出Excel文件
     * </p>
     * 
     * @param exportFile 输出的文件名
     * @param datas 输出的文件数据
     * @param sheetName 页名
     * @param response response对象
     * @throws Exception 异常
     */
    public void exportExcel(String exportFileName,
            List<Object[]> datas, String sheetName, 
            HttpServletResponse response) throws Exception {
    	
    	if(null == datas || datas.size() <= 0) {
       	     throw new IllegalArgumentException("写excel需要数据参数!");
        }
    	
    	OutputStream out = null;
    	WritableWorkbook workbook = null;
        try {

        	// 清空输出流   
            response.reset();
            
            // 设定输出文件头   
            response.setHeader("Content-Disposition", "attachment; filename=\"" + 
                 new String(exportFileName.getBytes("GB2312"),"8859_1") + ".xls\"");
            
            // 定义输出类型 
            response.setContentType("application/vnd.ms-excel");
            
        	// 取得输出流   
        	out = response.getOutputStream();
        	
            // 建立excel文件 
            workbook = Workbook.createWorkbook(out);  
            
            // 写入页名
            WritableSheet ws = workbook.createSheet(sheetName, 0);
            //设置默认列宽度
            ws.getSettings().setDefaultColumnWidth(18);
            
            WritableFont wf2 = new WritableFont(WritableFont.createFont("宋体"), 10, WritableFont.BOLD, false);
            // 表头格式
 			WritableCellFormat headerCf = new WritableCellFormat();
 			// 设置边框
 			headerCf.setBorder(Border.ALL, BorderLineStyle.THIN);
 			// 垂直居中显示
 			headerCf.setVerticalAlignment(VerticalAlignment.CENTRE);
 			// headerCf.setBackground(Colour.ICE_BLUE);
 			// 设置自动换行
 			headerCf.setWrap(true);
 			headerCf.setFont(wf2);
 			// 水平居中显示
 			headerCf.setAlignment(Alignment.CENTRE);
 			
 			// 设置字体
 			WritableFont wf3 = new WritableFont(WritableFont.createFont("宋体"), 10, WritableFont.NO_BOLD, false);
			WritableCellFormat typeCf = new WritableCellFormat();
			// 设置边框
			typeCf.setBorder(Border.ALL, BorderLineStyle.THIN);
			// 垂直居中显示
			typeCf.setVerticalAlignment(VerticalAlignment.CENTRE);
			// 水平居中显示
			typeCf.setAlignment(Alignment.LEFT);

			typeCf.setFont(wf3);
            
            // 设置单元格的文字格式
            WritableFont wf = new WritableFont(WritableFont.ARIAL,10,WritableFont.NO_BOLD,false,UnderlineStyle.NO_UNDERLINE,Colour.BLUE);
            WritableCellFormat wcf = new WritableCellFormat(wf);
            wcf.setVerticalAlignment(VerticalAlignment.CENTRE); 
            wcf.setAlignment(Alignment.CENTRE); 
            ws.setRowView(0, 500);
            
            // 写入内容
            int rowNum = 0;
            
            // 循环着把数据写入Excel文件中。
            for(int i = 0; i < datas.size(); i++) {
            	
            	// 一行数据。
                Object[] cells = (Object[]) datas.get(i);
                // 写一行内容
                if (i == 0){
                	putRow(ws, rowNum, cells,headerCf);
                	ws.setRowView(i, 500);
                }
                else{
                	putRow(ws, rowNum, cells,typeCf);
                	ws.setRowView(i, 500);
                }
                
                rowNum++;
            }
            
            workbook.write();
            
            out.flush();
            response.flushBuffer(); 
        } catch (Exception e) {

            // 异常发生的场合，抛出异常。
            throw e;
        } finally {
        	if(null != workbook) {
                workbook.close();
        	}
        	if(null != out) {
                out.close();
        	}
        }
    }
    
    /**
     * <p>
     * 输出多页Excel文件
     * </p>
     * 
     * @param exportFile 输出的文件名
     * @param datas 输出的文件数据
     * @param sheetName 页名
     * @param response response对象
     * @throws Exception 异常
     */
    public void exportExcel(String exportFileName,
            List<List<Object[]>> datas, String[] sheetNames, 
            HttpServletResponse response) throws Exception {
    	
    	if(null == datas || datas.size() <= 0) {
       	     throw new IllegalArgumentException("写excel需要数据参数!");
        }
    	
    	OutputStream out = null;
    	WritableWorkbook workbook = null;
        try {

        	// 清空输出流   
            response.reset();
            
            // 设定输出文件头   
            response.setHeader("Content-Disposition", "attachment; filename=\"" + 
                 new String(exportFileName.getBytes("GB2312"),"8859_1") + ".xls\"");
            
            // 定义输出类型 
            response.setContentType("application/vnd.ms-excel");
            
        	// 取得输出流   
        	out = response.getOutputStream();
        	
            // 建立excel文件 
            workbook = Workbook.createWorkbook(out);  
            
            for (int i = 0; i < sheetNames.length; i++) {
            	
            	 // 写入页名
                WritableSheet ws = workbook.createSheet(sheetNames[i], 0);
                
                // 设置单元格的文字格式
                WritableFont wf = new WritableFont(WritableFont.ARIAL,10,WritableFont.NO_BOLD,false,
                        UnderlineStyle.NO_UNDERLINE,Colour.BLUE);
                WritableCellFormat wcf = new WritableCellFormat(wf);
                wcf.setVerticalAlignment(VerticalAlignment.CENTRE); 
                wcf.setAlignment(Alignment.CENTRE); 
                ws.setRowView(0, 500);
                
                // 写入内容
                int rowNum = 0;
                
                // 循环着把数据写入Excel文件中。
                List<Object[]> data = datas.get(i);
                for(int j = 0; j < data.size(); j++) {
                	
                	// 一行数据。
                    Object[] cells = (Object[]) data.get(j);
                    
                    // 写一行内容
                    putRow(ws, rowNum, cells);
                    rowNum++;
                }
            }

            workbook.write();           
            out.flush();
            response.flushBuffer(); 
        } catch (Exception e) {

            // 异常发生的场合，抛出异常。
            throw e;
        } finally {
        	if(null != workbook) {
                workbook.close();
        	}
        	if(null != out) {
                out.close();
        	}
        }
    }

    /**
     * <p>
     * 写一行数据。
     * </p>
     * 
     * @param ws Excel对象
     * @param rowNum 行
     * @param cells 行内容
     * @throws Exception 异常
     */
    private void putRow(WritableSheet ws, int rowNum, Object[] cells,WritableCellFormat cf) throws Exception {
        for(int j = 0; j < cells.length; j++) {//写一行
        	 Label cell = new Label(j, rowNum, ""+cells[j],cf);
             ws.addCell(cell);
        }
    }
    
    /**
     * <p>
     * 写一行数据。
     * </p>
     * 
     * @param ws Excel对象
     * @param rowNum 行
     * @param cells 行内容
     * @throws Exception 异常
     */
    private void putRow(WritableSheet ws, int rowNum, Object[] cells) throws Exception {
        for(int j = 0; j < cells.length; j++) {//写一行
        	 Label cell = new Label(j, rowNum, ""+cells[j]);
             ws.addCell(cell);
        }
    }
}
