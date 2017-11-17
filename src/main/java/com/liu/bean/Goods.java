package com.liu.bean;

import lombok.Data;

/**
 * @Author lrn
 * @Date 2017/10/10
 */
@Data
public class Goods {

    private Integer id;

//    发货人
    private String consignor;
//    收货人
    private String consignee;
//    发货人电话
    private String consignorPhone;
//    收货人电话
    private String consigneePhone;
//    发货地址
    private String consignorAdress;
//    收货地址
    private String consigneeAdress;
//    当前地址
    private String currentAddress;
//    货物状态：0为未发，1为运送中，2为已接收
    private String state;
}
