package com.liu.bean;

/**
 * @Author lrn
 * @Date 2017/12/2
 */
public class Excel {

    private String number;

    public Excel(String number) {
        this.number = number;
    }

    public Excel() {}

    @Override
    public String toString() {
        return "Excel{" +
                "number=" + number +
                '}';
    }
}
