package com.liu.bean;

import lombok.Data;

/**
 * @Author lrn
 * @Date 2017/11/17
 */
@Data
public class Waybill {

    private Integer id;

    private Integer truckID;

    private Integer driverID;

    private Integer goodsID;

    private String departureCity;

    private String arriveCity;
}
