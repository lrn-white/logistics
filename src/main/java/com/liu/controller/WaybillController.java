package com.liu.controller;

import com.liu.bean.*;
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

    @RequestMapping("/getDistributive")
    public List<WaybillDto> queryDistributive() { return waybillService.queryDistributive(); }

    @RequestMapping("/getGoods")
    public List<Goods> queryGoods() { return waybillService.queryGoods(); }

    @RequestMapping("/addWaybill")
    public Integer addWaybill(String departureCity, String arriveCity, String driverName, String plateNumber, Integer id, String distributiveName) {
        return waybillService.addWaybill(departureCity, arriveCity, driverName, plateNumber, id, distributiveName);
    }

    @RequestMapping("/queryWaybill")
    public List<WaybillDto> queryWaybill(){ return waybillService.queryWaybill(); }

    @RequestMapping("/deleteWaybillByID")
    public void deleteWaybillByID(Integer id){
        waybillService.deleteWaybillByID(id);
    }

    @RequestMapping("/completeWaybillByID")
    public void completeWaybillByID(Integer id){
        waybillService.completeWaybillByID(id);
    }

    @RequestMapping("/getWaybillDtoByGoodsID")
    public WaybillDto getWaybillDtoByGoodsID(Integer id) {
        return waybillService.getWaybillDtoByGoodsID(id);
    }

    @RequestMapping("/updateWaybillDto")
    public Integer updateWaybillDto(WaybillDto waybillDto){
        return waybillService.updateWaybillDto(waybillDto);
    }

    @RequestMapping("/getWaybillDtoByConsignor")
    public WaybillDto getWaybillDtoByConsignor(String consignor) {
        return waybillService.getWaybillDtoByConsignor(consignor);
    }
}
