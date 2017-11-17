package com.liu.controller;

import com.liu.bean.Driver;
import com.liu.bean.Goods;
import com.liu.bean.Truck;
import com.liu.bean.Waybill;
import com.liu.service.WaybillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author lrn
 * @Date 2017/11/15
 */
@RestController
@RequestMapping("/waybill")
public class WaybillController {

    @Autowired
    private WaybillService waybillService;

    @RequestMapping("/getDriver")
    public List<Driver> queryDriver() {
        return waybillService.queryDriver();
    }

    @RequestMapping("/getTruck")
    public List<Truck> queryTruck() { return waybillService.queryTruck(); }

    @RequestMapping("/getCity")
    public List<Driver> queryCity() { return waybillService.queryCity(); }

    @RequestMapping("/getGoods")
    public List<Goods> queryGoods() { return waybillService.queryGoods(); }

    @RequestMapping("/addWaybill")
    public Integer addWaybill(String departureCity, String arriveCity, String driverName, String plateNumber, Integer id) {
        return waybillService.addWaybill(departureCity, arriveCity, driverName, plateNumber, id);
    }
}
