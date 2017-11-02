package com.liu.mapper;

import com.liu.bean.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @Author lrn
 * @Date 2017/11/2
 */
@Mapper
public interface UserMapper {

    @Insert({"INSERT INTO user (account, password) VALUES (#{account}, #{password})"})
    Integer addUser(User user);

    @Delete({"DELETE FROM user WHERE id = #{arg1}"})
    Integer deleteUserById(Integer id);

    @Select({"SELECT * FROM user ORDER BY id"})
    List<User> queryUserByList();
}
