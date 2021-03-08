package com.stragegic.oss.upload.service;

import cn.hutool.core.util.RandomUtil;
import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import com.aliyun.oss.model.PutObjectRequest;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

public class UploadService {
    @Value("${aliyun.accessKeyId}")
    private String accessKeyId;
    @Value("${aliyun.accessKeySecret}")
    private String accessKeySecret;
    @Test
    public void upload() throws  Exception{
        String[] title = {"订单ID", "流水号", "测试号"};
        //创建HSSF工作薄,文档对象HSSFWorkbook
        HSSFWorkbook workbook = new HSSFWorkbook();
        //创建一个Sheet页，HSSFSheet 表单对象
        HSSFSheet sheet = workbook.createSheet("sheet1");
        //创建第一行（一般是表头）
        HSSFRow row0 = sheet.createRow(0);//sheet1
        //创建列，HSSFCell列
        HSSFCell cell = null;
        //设置表头，
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

        // Endpoint以杭州为例，其它Region请按实际情况填写。
        String endpoint = "http://oss-cn-beijing.aliyuncs.com";
        // 阿里云主账号AccessKey拥有所有API的访问权限，风险很高。强烈建议您创建并使用RAM账号进行API访问或日常运维，请登录 https://ram.console.aliyun.com 创建RAM账号。

        // 创建OSSClient实例。
        OSS ossClient = new OSSClientBuilder().build(endpoint, accessKeyId, accessKeySecret);

        // 创建PutObjectRequest对象。设置缓冲
        ByteArrayOutputStream os = new ByteArrayOutputStream(1024000);
        workbook.write(os);
        byte[] bytes = os.toByteArray();
      
        // <yourObjectName>表示上传文件到OSS时需要指定包含文件后缀在内的完整路径，例如abc/efg/123.jpg。
        PutObjectRequest putObjectRequest = new PutObjectRequest("susuwan", "test.xls", new ByteArrayInputStream(bytes));
        ossClient.putObject(putObjectRequest);
          // 关闭OSSClient。
        ossClient.shutdown();
    }

}
