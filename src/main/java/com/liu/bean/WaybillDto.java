package com.liu.bean;

import lombok.Data;

/**
 * @Author lrn
 * @Date 2017/11/18
 */
@Data
public class WaybillDto {

    private Integer id;

    private String driverName;

    private String plateNumber;

    private String departureCity;

    private String arriveCity;

    private String state;

    private String currentAddress;

    private String consignor;

    private String consignee;

    private Integer truckID;

    private Integer driverID;

    private Integer goodsID;

    private String distributiveName;

    private String consignorAdress;
}
