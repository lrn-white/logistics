package com.liu.mapper;

import com.liu.bean.Goods;
import com.liu.bean.WaybillDto;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @Author lrn
 * @Date 2017/10/30
 */
@Mapper
public interface GoodsMapper {

    @Insert({"INSERT INTO goods (consignor, consignee, consignorPhone, consigneePhone, " +
            "consignorAdress, consigneeAdress, currentAddress, state) VALUES (#{consignor}, " +
            "#{consignee}, #{consignorPhone}, #{consigneePhone}, #{consignorAdress}, " +
            "#{consigneeAdress}, #{currentAddress}, #{state})"})
    Integer addGoods(Goods goods);

    @Delete({"DELETE FROM goods WHERE id = #{arg1}"})
    Integer deleteGoodsById(Integer id);

    @Update({"UPDATE goods SET consignee = #{consignee}, consignorPhone = #{consignorPhone}, " +
            "consigneePhone = #{consigneePhone}, consignorAdress = #{consignorAdress}, " +
            "consigneeAdress = #{consigneeAdress}, currentAddress = #{currentAddress}, state = #{state} " +
            "WHERE consignee = #{consignee}"})
    Integer updateGoods(Goods goods);

    @Select({"SELECT * FROM goods where id = #{arg1}"})
    Goods getGoodsById(Integer id);

    @Select({"SELECT * FROM goods where consignor = #{arg1}"})
    Goods getGoodsByConsignee(String consignee);

    @Select({"SELECT * FROM goods ORDER BY id"})
    List<Goods> queryGoodsByList();

    @Update({"UPDATE goods SET state = '1' where id = #{arg1}"})
    Integer changeGoodsState(Integer goodsID);

    @Update({"UPDATE goods SET state = '0' where id = #{arg1}"})
    Integer changeGoodsState0(Integer goodsID);

    @Update({"UPDATE goods SET state = '2' where id = #{arg1}"})
    Integer changeGoodsState2(Integer goodsID);

    @Update({"UPDATE goods SET currentAddress = #{currentAddress} where id = #{id} "})
    Integer changeCurrentAddress(Goods goods);
}
