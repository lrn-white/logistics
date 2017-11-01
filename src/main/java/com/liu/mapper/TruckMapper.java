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
    @Insert({"INSERT INTO truck (plateNumber, deadweight, state) VALUES (#{plateNumber}, " +
            "#{deadweight}, #{state})"})
    Integer addTruck(Truck truck);

    @Delete({"DELETE FROM truck WHERE id = #{arg1}"})
    Integer deleteTruckById(Integer id);

    @Update({"UPDATE truck SET deadweight = #{deadweight}, state = #{state}" +
            "WHERE plateNumber = #{plateNumber}"})
    Integer updateTruck(Truck truck);

    @Select({"SELECT * FROM truck where id = #{arg1}"})
    Truck getTruckById(Integer id);

    @Select({"SELECT * FROM truck where plateNumber = #{arg1}"})
    Truck getTruckByPlateNumber(String plateNumber);

    @Select({"SELECT * FROM truck ORDER BY id"})
    List<Truck> queryTruckByList();
}
