package com.liu.mapper;

import com.liu.bean.Driver;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @Author lrn
 * @Date 2017/10/10
 */
@Mapper
public interface DriverMapper {

    @Insert({"INSERT INTO driver (name, gender, photo, licenseNumber, state, plateNumber) " +
            "VALUES (#{name}, #{gender}, #{photo}, #{licenseNumber}, #{state}, #{plateNumber})"})
    Integer addDriver(Driver driver);

    @Delete({"DELETE FROM driver WHERE id = #{arg1}"})
    Integer deleteDriverById(Integer id);

    @Update({"UPDATE driver SET gender = #{gender}, licenseNumber = #{licenseNumber}, state = #{state}," +
            "plateNumber = #{plateNumber} WHERE name = #{name}"})
    Integer updateDriver(Driver driver);

    @Select({"SELECT * FROM driver where id = #{arg1}"})
    Driver getDriverById(Integer id);

    @Select({"SELECT * FROM driver where name = #{arg1}"})
    Driver getDriverByName(String name);

    @Select({"SELECT * FROM driver ORDER BY id"})
    List<Driver> queryDriverByList();

}