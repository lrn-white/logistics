package com.liu.bean;

import lombok.Data;

/**
 * @Author lrn
 * @Date 2017/10/10
 */
@Data
public class Driver {

    private Integer id;

    private String driverName;

    private String gender;

    private String photo;
//    驾驶证号
    private String licenseNumber;
//    0表示空闲，1表示运货途中
    private String driverState;

    private String driverCity;

    private String cityName;
}
