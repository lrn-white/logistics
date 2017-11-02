package com.liu.service;

import com.liu.bean.User;
import com.liu.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author lrn
 * @Date 2017/11/2
 */
@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    public Integer addUser(User user){ return userMapper.addUser(user); }

    public Integer deleteUserById(Integer id){ return  userMapper.deleteUserById(id); }

    public List<User> queryUserByList(){ return userMapper.queryUserByList(); }
}
