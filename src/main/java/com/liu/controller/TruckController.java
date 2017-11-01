package com.liu.controller;

import com.liu.bean.Truck;
import com.liu.service.TruckService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author lrn
 * @Date 2017/11/1
 */
@RestController
@RequestMapping("/truck")
public class TruckController {

    @Autowired
    private TruckService truckService;

    @RequestMapping("/addTruck")
    public Integer addTruck(Truck truck) {
        return truckService.addTruck(truck);
    }

    @RequestMapping("/updateTruck")
    public Integer updateTruck(Truck truck) {
        return truckService.updateTruck(truck);
    }

    @RequestMapping("/deleteTruck")
    public Integer deleteTruckById(Integer id) {
        return truckService.deleteTruckById(id);
    }

    @RequestMapping("/getTruckById")
    public Truck getTruckById(Integer id) {
        return truckService.getTruckById(id);
    }

    @RequestMapping("/getTruckByPlateNumber")
    public Truck getTruckByPlateNumber(String plateNumber) { return truckService.getTruckByPlateNumber(plateNumber); }

    @RequestMapping("/getAll")
    public List<Truck> queryTruckByList() {
        return truckService.queryTruckByList();
    }
}
