package com.liu.mapper;

import com.liu.bean.*;
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

    @Select({"SELECT * FROM distributive"})
    List<WaybillDto> queryDistributive();

    @Select({"SELECT * FROM goods WHERE state = '0';"})
    List<Goods> queryGoods();

    @Insert({"INSERT INTO waybill (truckID, driverID, goodsID, departureCity, arriveCity) " +
            "VALUES (#{truckID}, #{driverID}, #{goodsID}, #{departureCity}, #{arriveCity})"})
    Integer addWaybill(Waybill waybill);

    @Update({"UPDATE goods g\n" +
            "SET g.currentAddress = #{currentAddress}\n" +
            "WHERE g.id=(\n" +
            "SELECT w.goodsID FROM waybill w WHERE w.id= #{id});"})
    Integer updateWaybill(WaybillDto waybillDto);

    @Select({"SELECT d.driverName,t.plateNumber,g.state,w.arriveCity,w.departureCity, g.consignee, \n" +
            "g.consignor,g.currentAddress,w.id FROM waybill w\n" +
            "LEFT JOIN driver d ON d.id = w.driverID\n" +
            "LEFT JOIN truck t ON t.id = w.truckID\n" +
            "LEFT JOIN goods g ON g.id = w.goodsID;"})
    List<WaybillDto> queryWaybill();

    @Delete({"DELETE from waybill where id = #{arg1}"})
    Integer deleteWaybill(Integer id);

    @Select({"SELECT d.driverName,t.plateNumber,g.state,w.arriveCity,w.departureCity, g.consignee, \n" +
            "g.consignor,g.currentAddress,w.driverID,w.goodsID,w.truckID FROM waybill w\n" +
            "LEFT JOIN driver d ON d.id = w.driverID\n" +
            "LEFT JOIN truck t ON t.id = w.truckID\n" +
            "LEFT JOIN goods g ON g.id = w.goodsID\n" +
            "WHERE w.id = #{arg1};"})
    WaybillDto getWaybillDtoById(Integer id);

    @Select({"SELECT w.id,d.driverName,t.plateNumber,g.state,w.arriveCity,w.departureCity, g.consignee,\n" +
            "g.consignor,g.currentAddress,w.driverID,w.goodsID,w.truckID,g.consignorAdress\n" +
            "FROM waybill w\n" +
            "LEFT JOIN goods g ON g.id = w.goodsID\n" +
            "LEFT JOIN truck t ON t.id = w.truckID\n" +
            "LEFT JOIN driver d ON d.id = w.driverID\n" +
            "WHERE g.consignor = #{arg1};"})
    WaybillDto getWaybillDtoByConsignor(String consignor);

    @Select({"SELECT w.id,d.driverName,t.plateNumber,g.state,w.arriveCity,w.departureCity, g.consignee,\n" +
            "g.consignor,g.currentAddress,w.driverID,w.goodsID,w.truckID,g.consignorAdress\n" +
            "FROM waybill w\n" +
            "LEFT JOIN goods g ON g.id = w.goodsID\n" +
            "LEFT JOIN truck t ON t.id = w.truckID\n" +
            "LEFT JOIN driver d ON d.id = w.driverID\n" +
            "WHERE w.id = #{arg1};"})
    WaybillDto getWaybillDtoByGoodsID(Integer id);

    @Select({"SELECT goodsID FROM waybill WHERE id = #{arg1};"})
    Integer getGoodsIDByWaybillID(Integer waybillID);

    @Update({"UPDATE goods SET currentAddress = #{currentAddress} WHERE id = #{id};"})
    void updateCurrentAddressByID(Goods goods);
}
