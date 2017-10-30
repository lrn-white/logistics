package com.liu.service;

import com.liu.bean.Driver;
import com.liu.mapper.DriverMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author lrn
 * @Date 2017/10/10
 */
@Service
public class DriverService {

    @Autowired
    private DriverMapper driverMapper;

    public Integer addDriver(Driver driver) { return driverMapper.addDriver(driver); }

    public Integer updateDriver(Driver driver) { return driverMapper.updateDriver(driver); }

    public Integer deleteDriverById(Integer id) { return driverMapper.deleteDriverById(id); }

    public Driver getDriverById(Integer id) { return driverMapper.getDriverById(id); }

    public Driver getDriverByName(String name) {
        return driverMapper.getDriverByName(name);
    }

    public List<Driver> queryDriverByList() { return driverMapper.queryDriverByList(); }
}
