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

    public Integer updateDriver(Driver driver) { return driverMapper.update(driver); }

    public Integer deleteById(Integer id) {
        return driverMapper.deleteById(id);
    }


    public Driver getById(Integer id) {
        return driverMapper.getById(id);
    }

    public Driver getByName(String name) {
        return driverMapper.getByName(name);
    }

    public List<Driver> queryByList() {
        return driverMapper.queryByList();
    }
}
