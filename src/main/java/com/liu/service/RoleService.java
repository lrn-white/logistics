package com.liu.service;

import com.liu.bean.Role;
import com.liu.mapper.RoleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * @Author lrn
 * @Date 2017/10/30
 */
@Service
public class RoleService {

    @Autowired
    private RoleMapper roleMapper;

    public String getRoleNameByAccountAndPassword(String account, String password) {
        Role role = new Role();
        role.setAccount(account);
        role.setPassword(password);
        return roleMapper.getRoleNameByAccountAndPassword(role);
    }

    public Integer setAsSystem(Integer id){ return roleMapper.setAsSystem(id); }

    public Integer setAsOperator(Integer id){ return roleMapper.setAsOperator(id); }

    public List<Role> getRoleName(){ return roleMapper.getRoleName(); }

    public Role getRoleByAccount(String account) {
        Integer userID = roleMapper.getUserIDByAccount(account);
        return roleMapper.getRoleByID(userID);
    }

    public Integer setRoleByAccount(String account, Integer roleID) {
        Integer userID = roleMapper.getUserIDByAccount(account);
        return roleMapper.setRoleByUserIDAndRoleID(userID, roleID);
    }
}
