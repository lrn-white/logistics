package com.liu.mapper;

import com.liu.bean.Role;
import org.apache.ibatis.annotations.*;

import java.util.List;


/**
 * @Author lrn
 * @Date 2017/10/30
 */
@Mapper
public interface RoleMapper {

    @Select({"SELECT roleName FROM role r\n" +
            "LEFT JOIN userrole ur ON ur.roleID = r.id\n" +
            "LEFT JOIN user u ON u.id = ur.userID\n" +
            "WHERE account = #{account} and password = #{password};"})
    String getRoleNameByAccountAndPassword(Role role);

    @Update({"UPDATE userrole SET roleID=1 WHERE userID = #{arg1};"})
    Integer setAsSystem(Integer id);

    @Update({"UPDATE userrole SET roleID=2 WHERE userID = #{arg1};"})
    Integer setAsOperator(Integer id);

    @Select({"SELECT id, roleName from role;"})
    List<Role> getRoleName();

    @Select({"SELECT roleName,account,password FROM role r\n" +
            "LEFT JOIN userrole ur ON ur.roleID = r.id\n" +
            "LEFT JOIN user u ON u.id = ur.userID\n" +
            "WHERE u.id = #{arg1}"})
    Role getRoleByID(Integer id);

    @Select({"SELECT id FROM user WHERE account = #{arg1}"})
    Integer getUserIDByAccount(String account);

    @Update({"UPDATE userrole SET roleID = #{arg1} WHERE userID = #{arg0}"})
    Integer setRoleByUserIDAndRoleID(Integer userID, Integer roleID);
}
