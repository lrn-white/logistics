package com.liu.service;

import com.liu.bean.Driver;
import com.liu.bean.Goods;
import com.liu.bean.Truck;
import com.liu.bean.Waybill;
import com.liu.mapper.DriverMapper;
import com.liu.mapper.TruckMapper;
import com.liu.mapper.WaybillMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Author lrn
 * @Date 2017/11/15
 */
@Service
public class WaybillService {

    @Autowired
    private WaybillMapper waybillMapper;

    @Autowired
    private DriverMapper driverMapper;

    @Autowired
    private TruckMapper truckMapper;

    public List<Driver> queryDriver() {return waybillMapper.queryDriver();}

    public List<Truck> queryTruck() {return waybillMapper.queryTruck();}

    public List<Driver> queryCity() {return waybillMapper.queryCity();}

    public List<Goods> queryGoods() {return waybillMapper.queryGoods();}

    @Transactional
    public Integer addWaybill(String departureCity, String arriveCity, String driverName, String plateNumber, Integer id){
        Integer driverID = driverMapper.getIdByDriverName(driverName);
        Integer truckID = truckMapper.getIdByPlateNumber(plateNumber);
        Integer goodsID = id;
        Waybill waybill = new Waybill();
        waybill.setDriverID(driverID);
        waybill.setArriveCity(arriveCity);
        waybill.setDepartureCity(departureCity);
        waybill.setGoodsID(goodsID);
        waybill.setTruckID(truckID);
        return waybillMapper.addWaybill(waybill);
    }
}
