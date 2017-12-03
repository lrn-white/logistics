package com.liu.controller;

import com.liu.bean.Role;
import com.liu.service.RoleService;
import com.liu.service.WaybillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;


/**
 * @Author lrn
 * @Date 2017/10/30
 */
@Controller
@RequestMapping("/")
public class RoleController {

    @Autowired
    private RoleService roleService;

    @Autowired
    private WaybillService waybillService;

    @RequestMapping("/demo/outlookmenu/role")
    public String getRoleNameByAccountAndPassword(String account, String password) {
        String a = roleService.getRoleNameByAccountAndPassword(account, password);
        String b = "系统管理员";
        String c = "操作员";
        if (a != null) {
            if (a.equals(b) == true) {
                return "/demo/outlookmenu/menu.html";
            } else if (a.equals(c) == true) {
                return "/demo/outlookmenu/menuOperator.html";
            }
        }
        return "/demo/layout/loginLayout.html";
    }

    @RequestMapping("/role/setAsSystem")
    @ResponseBody
    public Integer setAsSystem(Integer id){ return roleService.setAsSystem(id); }

    @RequestMapping("/role/setAsOperator")
    @ResponseBody
    public Integer setAsOperator(Integer id){ return roleService.setAsOperator(id); }

    @RequestMapping("/role/getRoleName")
    @ResponseBody
    public List<Role> getRoleName() { return roleService.getRoleName(); }

    @RequestMapping("/role/getRoleByAccount")
    @ResponseBody
    public Role getRoleByAccount(String account) { return roleService.getRoleByAccount(account); }

    @RequestMapping("/role/setRoleByAccount")
    @ResponseBody
    public Integer setRoleByAccount(String account, Integer roleID) { return roleService.setRoleByAccount(account, roleID); }

    @RequestMapping("/changeDistributiveBywaybillID")
    @ResponseBody
    public String changeDistributiveBywaybillID(String distributiveID, Integer waybillID){
        waybillService.changeDistributiveBywaybillID(distributiveID, waybillID);
        return "/demo/sign/signEdit.html";
    }
}
