package com.liu.mapper;

import com.liu.bean.Role;
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

    @Delete({"DELETE FROM userrole WHERE userID = #{arg1}"})
    Integer deleteUserRoleById(Integer id);

    @Select({"SELECT u.id, u.account, u.password, r.roleName FROM USER u\n" +
            "LEFT JOIN userrole ur ON u.id = ur.userID\n" +
            "LEFT JOIN role r ON ur.roleID = r.id;"})
    List<Role> queryUserByList();

    @Select({"SELECT id FROM user WHERE account = #{arg1}"})
    Integer getIDByAccount(String account);

    @Insert({"INSERT INTO userrole (userID, roleID) VALUES (#{arg1}, 2);"})
    Integer setUserAsOperator(Integer userID);
}
