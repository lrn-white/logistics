package com.liu.mapper;

import com.liu.bean.Driver;
import com.liu.bean.Goods;
import com.liu.bean.Truck;
import com.liu.bean.Waybill;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @Author lrn
 * @Date 2017/11/15
 */
@Mapper
public interface WaybillMapper {

    @Select({"SELECT d.driverName, c.cityName FROM driver d\n" +
            "LEFT JOIN city c ON d.driverCity = c.id\n" +
            "WHERE d.driverState = '0'\n" +
            "ORDER BY c.cityName;"})
    List<Driver> queryDriver();

    @Select({"SELECT t.plateNumber, c.cityName FROM truck t\n" +
            "LEFT JOIN city c ON t.truckCity = c.id\n" +
            "WHERE t.truckState = '0'\n" +
            "ORDER BY c.cityName;"})
    List<Truck> queryTruck();

    @Select({"SELECT * FROM city"})
    List<Driver> queryCity();

    @Select({"SELECT * FROM goods WHERE state = '0';"})
    List<Goods> queryGoods();

    @Insert({"INSERT INTO waybill (truckID, driverID, goodsID, departureCity, arriveCity) " +
            "VALUES (#{truckID}, #{driverID}, #{goodsID}, #{departureCity}, #{arriveCity})"})
    Integer addWaybill(Waybill waybill);
}
