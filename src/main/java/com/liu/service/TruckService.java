package com.liu.service;

import com.liu.bean.Truck;
import com.liu.mapper.TruckMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author lrn
 * @Date 2017/11/1
 */
@Service
public class TruckService {

    @Autowired
    private TruckMapper truckMapper;

    public Integer addTruck(Truck truck) { return truckMapper.addTruck(truck); }

    public Integer deleteTruckById(Integer id) { return truckMapper.deleteTruckById(id); }

    public Integer updateTruck(Truck truck) {
        return truckMapper.updateTruck(truck);
    }

    public Truck getTruckById(Integer id) { return truckMapper.getTruckById(id); }

    public Truck getTruckByPlateNumber(String plateNumber) { return truckMapper.getTruckByPlateNumber(plateNumber); }

    public List<Truck> queryTruckByList() { return truckMapper.queryTruckByList(); }
}
