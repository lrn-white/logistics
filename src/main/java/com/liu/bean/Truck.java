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
//    0表示空闲，1表示运货途中
    private String truckState;
//    货车当前所在城市
    private String truckCity;

    private String cityName;
}
