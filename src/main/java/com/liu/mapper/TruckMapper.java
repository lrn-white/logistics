package com.liu.mapper;

import com.liu.bean.Truck;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @Author lrn
 * @Date 2017/11/1
 */
@Mapper
public interface TruckMapper {
    @Insert({"INSERT INTO truck (plateNumber, truckState, truckCity) VALUES (#{plateNumber}, " +
            "#{truckState}, #{truckCity})"})
    Integer addTruck(Truck truck);

    @Delete({"DELETE FROM truck WHERE id = #{arg1}"})
    Integer deleteTruckById(Integer id);

    @Update({"UPDATE truck SET truckState = #{truckState}, truckCity = #{truckCity}" +
            "WHERE plateNumber = #{plateNumber}"})
    Integer updateTruck(Truck truck);

    @Select({"SELECT * FROM truck where id = #{arg1}"})
    Truck getTruckById(Integer id);

    @Select({"SELECT * FROM truck where plateNumber = #{arg1}"})
    Truck getTruckByPlateNumber(String plateNumber);

    @Select({"SELECT * FROM truck ORDER BY id"})
    List<Truck> queryTruckByList();

    @Select({"SELECT id FROM truck where plateNumber = #{arg1}"})
    Integer getIdByPlateNumber(String plateNumber);

    @Update({"UPDATE truck SET truckState = '1' where id = #{arg1}"})
    Integer changeTruckState(Integer truckID);

    @Update({"UPDATE truck SET truckState = '0' where id = #{arg1}"})
    Integer changeTruckState0(Integer truckID);
}
