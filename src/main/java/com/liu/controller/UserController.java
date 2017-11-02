package com.liu.controller;

import com.liu.bean.User;
import com.liu.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author lrn
 * @Date 2017/11/2
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/addUser")
    public Object addUser(User user) {
        return userService.addUser(user);
    }

    @RequestMapping("/deleteUser")
    public Object deleteUserById(Integer id) {
        return userService.deleteUserById(id);
    }

    @RequestMapping("/getAll")
    public Object queryUserByList() {
        return userService.queryUserByList();
    }
}
