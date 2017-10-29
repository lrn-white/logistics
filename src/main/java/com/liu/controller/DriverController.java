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
    public Object updateDriver(Driver driver) {
        return driverService.updateDriver(driver);
    }

    @RequestMapping("/deleteDriver")
    public Object deleteById(Integer id) {
        return driverService.deleteById(id);
    }

    @RequestMapping("/getById")
    public Object getById(Integer id) {
        return driverService.getById(id);
    }

    @RequestMapping("/getByName")
    public Object getByName(String name) {
        return driverService.getByName(name);
    }

    @RequestMapping("/getAll")
    public Object queryByList() {
        return driverService.queryByList();
    }
}
