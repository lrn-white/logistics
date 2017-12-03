package com.liu.controller;

import com.liu.bean.Excel;
import com.liu.service.WaybillService;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


/**
 * @Author lrn
 * @Date 2017/12/2
 */
@Controller
public class FileController {

    private static final Logger logger = LoggerFactory.getLogger(FileController.class);

    @Autowired
    private WaybillService waybillService;

    //文件上传相关代码
    @RequestMapping(value = "upload")
    public String upload(@RequestParam("test") MultipartFile file, String distributiveID) {
        if (file.isEmpty()) {
            return "文件为空";
        }
        // 获取文件名
        String fileName = file.getOriginalFilename();
        logger.info("上传的文件名为：" + fileName);
        // 获取文件的后缀名
        String suffixName = fileName.substring(fileName.lastIndexOf("."));
        logger.info("上传的后缀名为：" + suffixName);
        // 文件上传后的路径
        String filePath = "E://";
        // 解决中文问题，liunx下中文路径，图片显示问题
        // fileName = UUID.randomUUID() + suffixName;
        File dest = new File(filePath + fileName);
        // 检测是否存在目录
        if (!dest.getParentFile().exists()) {
            dest.getParentFile().mkdirs();
        }
        try {
            file.transferTo(dest);
            return "/readExcel?dest=" + dest;
        } catch (IllegalStateException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "上传失败";
    }

//    读取excel表中的内容
    @RequestMapping("/readExcel")
    @ResponseBody
    public String readExcel(String dest, String distributiveID) throws Exception{
        List<Excel> list = new ArrayList<>();

        HSSFWorkbook book = new HSSFWorkbook(new FileInputStream(ResourceUtils.getFile(dest)));

        HSSFSheet sheet = book.getSheetAt(0);

        for(int i=1; i<sheet.getLastRowNum()+1; i++) {
            HSSFRow row = sheet.getRow(i);
            String number = row.getCell(0).getStringCellValue(); //编号

            Integer goodsID = null;
            if (number != null){
                goodsID = Integer.valueOf(number);
            }

            waybillService.changeDistributiveBywaybillID(distributiveID, goodsID);
        }
        return "导入成功";
    }

}
