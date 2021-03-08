package com.stragegic.oss.upload.service;

import cn.hutool.core.util.RandomUtil;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.junit.jupiter.api.Test;

import java.io.*;

public class ExcelDemo {

    @Test
    public void ExcelDemo() throws Exception {
        String[] title = {"订单ID", "流水号", "测试号"};
        //创建HSSF工作薄,文档对象HSSFWorkbook
        HSSFWorkbook workbook = new HSSFWorkbook();
        //创建一个Sheet页，HSSFSheet 表单对象,需要几个sheet页自己看着修改即可
        HSSFSheet sheet = workbook.createSheet("sheet1");
        HSSFSheet sheet2 = workbook.createSheet("sheet2");
        //创建第一行（一般是表头）
        HSSFRow row0 = sheet.createRow(0);//sheet1
        HSSFRow row2 = sheet2.createRow(0);//sheet2
        //创建列，HSSFCell列
        HSSFCell cell = null;
        //设置表头，循环上面的数组，希望朋友不要忘记数组是length,集合是size();
        for (int i = 0; i < title.length; i++) {
            cell = row0.createCell(i);
            cell.setCellValue(title[i]);
        }
        //填充20行数据
        for (int i = 1; i < 20; i++) {
            HSSFRow row = sheet.createRow(i);//新建第一行
            HSSFCell cell1 = row.createCell(0);//新建第一个单元格
            cell1.setCellValue(RandomUtil.randomString(3));
            HSSFCell cell2 = row.createCell(1);//新建第二个单元格
            cell2.setCellValue(RandomUtil.randomString(3));
            HSSFCell cell3 = row.createCell(2);//新建第三个单元格
            cell3.setCellValue(RandomUtil.randomString(3));
        }


        ByteArrayOutputStream os = new ByteArrayOutputStream(1024000);
        workbook.write(os);
        byte[] bytes = os.toByteArray();

        FileOutputStream outputStream = new FileOutputStream( new File("D://test.xls"));
        outputStream.write(bytes);

/*      File file = new File("D://test.xls");
        FileOutputStream outputStream = new FileOutputStream(file);
        //将Excel写入输出流中
        workbook.write(outputStream);
        outputStream.flush();
        outputStream.close();*/

    }
}

