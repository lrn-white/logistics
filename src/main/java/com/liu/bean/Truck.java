package com.liu.bean;

import lombok.Data;

/**
 * @Author lrn
 * @Date 2017/11/1
 */
@Data
public class Truck {

    private Integer id;
//    车牌号
    private String plateNumber;
//    车重
    private String deadweight;
//    0表示空闲，1表示运货途中
    private String truckState;

    private String truckCity;

    private String cityName;
}
