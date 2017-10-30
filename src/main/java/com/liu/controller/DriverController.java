package com.liu.controller;

import com.liu.bean.Driver;
import com.liu.service.DriverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * @Author lrn
 * @Date 2017/10/10
 */
@RestController
@RequestMapping("/driver")
public class DriverController {

    @Autowired
    private DriverService driverService;

    @RequestMapping("/addDriver")
    public Object addDriver(Driver driver) {
        return driverService.addDriver(driver);
    }

    @RequestMapping("/updateDriver")
    public Object updateDriver(Driver driver) { return driverService.updateDriver(driver); }

    @RequestMapping("/deleteDriver")
    public Object deleteDriverById(Integer id) {
        return driverService.deleteDriverById(id);
    }

    @RequestMapping("/getById")
    public Object getDriverById(Integer id) {
        return driverService.getDriverById(id);
    }

    @RequestMapping("/getByName")
    public Object getDriverByName(String name) {
        return driverService.getDriverByName(name);
    }

    @RequestMapping("/getAll")
    public Object queryDriverByList() {
        return driverService.queryDriverByList();
    }
}
