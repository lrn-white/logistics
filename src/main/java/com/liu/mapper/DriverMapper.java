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

    @Insert({"INSERT INTO driver (driverName, gender, licenseNumber, driverState, driverCity) " +
            "VALUES (#{driverName}, #{gender}, #{licenseNumber}, #{driverState}, #{driverCity})"})
    Integer addDriver(Driver driver);

    @Delete({"DELETE FROM driver WHERE id = #{arg1}"})
    Integer deleteDriverById(Integer id);

    @Update({"UPDATE driver SET gender = #{gender}, licenseNumber = #{licenseNumber}, driverState = #{driverState}," +
            "driverCity = #{driverCity} WHERE driverName = #{driverName}"})
    Integer updateDriver(Driver driver);

    @Select({"SELECT * FROM driver where id = #{arg1}"})
    Driver getDriverById(Integer id);

    @Select({"SELECT * FROM driver where driverName = #{arg1}"})
    Driver getDriverByName(String name);

    @Select({"SELECT * FROM driver ORDER BY id"})
    List<Driver> queryDriverByList();

    @Select({"SELECT id FROM driver where driverName = #{arg1}"})
    Integer getIdByDriverName(String driverName);

    @Update({"UPDATE driver SET driverState = '1' where id = #{arg1}"})
    Integer changeDriverState(Integer driverID);

    @Update({"UPDATE driver SET driverState = '0' where id = #{arg1}"})
    Integer changeDriverState0(Integer driverID);
}