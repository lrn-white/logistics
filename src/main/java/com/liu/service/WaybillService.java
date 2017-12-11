package com.liu.service;

import com.liu.bean.*;
import com.liu.mapper.DriverMapper;
import com.liu.mapper.GoodsMapper;
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

    @Autowired
    private GoodsMapper goodsMapper;

    public List<Driver> queryDriver() {
        return waybillMapper.queryDriver();
    }

    public List<Truck> queryTruck() {
        return waybillMapper.queryTruck();
    }

    public List<Driver> queryCity() {
        return waybillMapper.queryCity();
    }

    public List<WaybillDto> queryDistributive() {
        return waybillMapper.queryDistributive();
    }

    public List<Goods> queryGoods() {
        return waybillMapper.queryGoods();
    }

    @Transactional
    public Integer addWaybill(String departureCity, String arriveCity, String driverName, String plateNumber,
                              Integer goodsID, String distributiveName) {
        Integer driverID = driverMapper.getIdByDriverName(driverName);
        Integer truckID = truckMapper.getIdByPlateNumber(plateNumber);
//        Integer goodsID = waybillMapper.getGoodsIDByID(id);
        Goods goods = new Goods();
        goods.setCurrentAddress(distributiveName);
        goods.setId(goodsID);
        goodsMapper.changeCurrentAddress(goods);

        driverMapper.changeDriverState(driverID);
        truckMapper.changeTruckState(truckID);
        goodsMapper.changeGoodsState(goodsID);
        Waybill waybill = new Waybill();
        waybill.setDriverID(driverID);
        waybill.setArriveCity(arriveCity);
        waybill.setDepartureCity(departureCity);
        waybill.setGoodsID(goodsID);
        waybill.setTruckID(truckID);
        return waybillMapper.addWaybill(waybill);
    }

    public List<WaybillDto> queryWaybill() {
        return waybillMapper.queryWaybill();
    }

    @Transactional
    public void deleteWaybillByID(Integer id) {
        WaybillDto waybillDto = waybillMapper.getWaybillDtoById(id);
        Integer driverID = waybillDto.getDriverID();
        Integer truckID = waybillDto.getTruckID();
        Integer goodsID = waybillDto.getGoodsID();
        driverMapper.changeDriverState0(driverID);
        truckMapper.changeTruckState0(truckID);
        goodsMapper.changeGoodsState0(goodsID);
        waybillMapper.deleteWaybill(id);
    }

    public WaybillDto getWaybillDtoByGoodsID(Integer id) {
        return waybillMapper.getWaybillDtoByGoodsID(id);
    }

    public WaybillDto getWaybillDtoByConsignor(String consignor) {
        return waybillMapper.getWaybillDtoByConsignor(consignor);
    }

    public Integer updateWaybillDto(WaybillDto waybillDto) {
        return waybillMapper.updateWaybill(waybillDto);
    }

    @Transactional
    public void completeWaybillByID(Integer id){
        WaybillDto waybillDto = waybillMapper.getWaybillDtoById(id);
        Integer driverID = waybillDto.getDriverID();
        Integer truckID = waybillDto.getTruckID();
        Integer goodsID = waybillDto.getGoodsID();
        driverMapper.changeDriverState0(driverID);
        truckMapper.changeTruckState0(truckID);
        goodsMapper.changeGoodsState2(goodsID);
    }

    public void changeDistributiveBywaybillID(String distributiveID, Integer goodsID){
//        Integer goodsID = waybillMapper.getGoodsIDByWaybillID(waybillID);
        Goods goods = new Goods();
        goods.setCurrentAddress(distributiveID);
        goods.setId(goodsID);
        waybillMapper.updateCurrentAddressByID(goods);
    }

    public void waybillCompleteBygoodsID(Integer goodsID){
        WaybillDto waybillDto = waybillMapper.getIdByGoodsID(goodsID);
        Integer driverID = waybillDto.getDriverID();
        Integer truckID = waybillDto.getTruckID();
        driverMapper.changeDriverState0(driverID);
        truckMapper.changeTruckState0(truckID);
        goodsMapper.changeGoodsState2(goodsID);
    }
}
