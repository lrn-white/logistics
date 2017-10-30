package com.liu.mapper;

import com.liu.bean.Goods;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @Author lrn
 * @Date 2017/10/30
 */
@Mapper
public interface GoodsMapper {

    @Insert({"INSERT INTO goods (consignor, consignee, consignorPhone, consigneePhone, " +
            "consignorAdress, consigneeAdress, currentAddress) VALUES (#{consignor}, " +
            "#{consignee}, #{consignorPhone}, #{consigneePhone}, #{consignorAdress}, " +
            "#{consigneeAdress}, #{currentAddress})"})
    Integer addGoods(Goods goods);

    @Delete({"DELETE FROM goods WHERE id = #{arg1}"})
    Integer deleteGoodsById(Integer id);

    @Update({"UPDATE goods SET consignee = #{consignee}, consignorPhone = #{consignorPhone}, " +
            "consigneePhone = #{consigneePhone}, consignorAdress = #{consignorAdress}, " +
            "consigneeAdress = #{consigneeAdress}, currentAddress = #{currentAddress} " +
            "WHERE consignee = #{consignee}"})
    Integer updateGoods(Goods goods);

    @Select({"SELECT * FROM goods where id = #{arg1}"})
    Goods getGoodsById(Integer id);

    @Select({"SELECT * FROM goods where consignor = #{arg1}"})
    Goods getGoodsByConsignee(String consignee);

    @Select({"SELECT * FROM goods ORDER BY id"})
    List<Goods> queryGoodsByList();
}
