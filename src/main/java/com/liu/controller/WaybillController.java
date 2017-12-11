package com.liu.controller;

import com.liu.bean.*;
import com.liu.service.WaybillService;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author lrn
 * @Date 2017/11/15
 */
@RestController
@RequestMapping("/waybill")
public class WaybillController {

    private static final Logger logger = LoggerFactory.getLogger(FileController.class);

    @Autowired
    private WaybillService waybillService;

    @RequestMapping("/getDriver")
    public List<Driver> queryDriver() {
        return waybillService.queryDriver();
    }

    @RequestMapping("/getTruck")
    public List<Truck> queryTruck() {
        return waybillService.queryTruck();
    }

    @RequestMapping("/getCity")
    public List<Driver> queryCity() {
        return waybillService.queryCity();
    }

    @RequestMapping("/getDistributive")
    public List<WaybillDto> queryDistributive() {
        return waybillService.queryDistributive();
    }

    @RequestMapping("/getGoods")
    public List<Goods> queryGoods() {
        return waybillService.queryGoods();
    }

//    @RequestMapping("/addWaybill")
//    public String addWaybill(@RequestParam("FileUpload") MultipartFile file) {
//        if (file.isEmpty()) {
//            return "文件为空";
//        }
//        // 获取文件名
//        String fileName = file.getOriginalFilename();
//        logger.info("上传的文件名为：" + fileName);
//        // 获取文件的后缀名
//        String suffixName = fileName.substring(fileName.lastIndexOf("."));
//        logger.info("上传的后缀名为：" + suffixName);
//        // 文件上传后的路径
//        String filePath = "E://";
//        // 解决中文问题，liunx下中文路径，图片显示问题
//        // fileName = UUID.randomUUID() + suffixName;
//        File dest = new File(filePath + fileName);
//        // 检测是否存在目录
//        if (!dest.getParentFile().exists()) {
//            dest.getParentFile().mkdirs();
//        }
//        try {
//            file.transferTo(dest);
//            return "/waybill/readExcelWaybill?dest=" + dest;
//        } catch (IllegalStateException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        return "上传失败";
//    }
//
//    //    读取excel表中的内容
//    @RequestMapping("/readExcelWaybill")
//    @ResponseBody
//    public Integer readExcel(String dest, String departureCity, String arriveCity, String driverName, String plateNumber,
//                             String distributiveName) throws Exception {
//        List<Excel> list = new ArrayList<>();
//
//        HSSFWorkbook book = new HSSFWorkbook(new FileInputStream(ResourceUtils.getFile(dest)));
//
//        HSSFSheet sheet = book.getSheetAt(0);
//
//        for (int i = 1; i < sheet.getLastRowNum() + 1; i++) {
//            HSSFRow row = sheet.getRow(i);
//            String number = row.getCell(0).getStringCellValue(); //编号
//
//            Integer goodsID = null;
//            if (number != null) {
//                goodsID = Integer.valueOf(number);
//            }
//
//            return waybillService.addWaybill(departureCity, arriveCity, driverName, plateNumber, goodsID, distributiveName);
//        }
////        return "导入成功";
//        return 0;
//    }

    @RequestMapping("/queryWaybill")
    public List<WaybillDto> queryWaybill() {
        return waybillService.queryWaybill();
    }

    @RequestMapping("/deleteWaybillByID")
    public void deleteWaybillByID(Integer id) {
        waybillService.deleteWaybillByID(id);
    }

    @RequestMapping("/completeWaybillByID")
    public void completeWaybillByID(Integer id) {
        waybillService.completeWaybillByID(id);
    }

    @RequestMapping("/getWaybillDtoByGoodsID")
    public WaybillDto getWaybillDtoByGoodsID(Integer id) {
        return waybillService.getWaybillDtoByGoodsID(id);
    }

    @RequestMapping("/updateWaybillDto")
    public Integer updateWaybillDto(WaybillDto waybillDto) {
        return waybillService.updateWaybillDto(waybillDto);
    }

    @RequestMapping("/getWaybillDtoByConsignor")
    public WaybillDto getWaybillDtoByConsignor(String consignor) {
        return waybillService.getWaybillDtoByConsignor(consignor);
    }
}
