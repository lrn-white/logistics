package com.liu.bean;

import lombok.Data;

/**
 * @Author lrn
 * @Date 2017/10/10
 */
@Data
public class Driver {

    private Integer id;

    private String name;

    private String gender;

    private String photo;
//    驾驶证号
    private String licenseNumber;
//    0表示空闲，1表示运货途中
    private String state;
//    车牌号
    private String plateNumber;
}
