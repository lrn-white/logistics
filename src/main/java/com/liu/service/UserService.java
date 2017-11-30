package com.liu.service;

import com.liu.bean.Role;
import com.liu.bean.User;
import com.liu.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Author lrn
 * @Date 2017/11/2
 */
@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    @Transactional
    public Integer addUser(User user) {
        userMapper.addUser(user);
        String a = user.getAccount();
        Integer b = userMapper.getIDByAccount(a);
        return userMapper.setUserAsOperator(b);
    }

    @Transactional
    public Integer deleteUserById(Integer id) {
        userMapper.deleteUserById(id);
        return userMapper.deleteUserRoleById(id);
    }

    public List<Role> queryUserByList() {
        return userMapper.queryUserByList();
    }
}
