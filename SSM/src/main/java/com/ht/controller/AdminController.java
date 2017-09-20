package com.ht.controller;

import com.ht.mapping.Admin;
import com.ht.mapping.ControllerResult;
import com.ht.service.AdminService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@Controller
@RequestMapping("/admin")
public class AdminController {


    @Resource
    private AdminService adminService;

    @GetMapping("reg_page")
    public String regPage() {
        return "admin/reg";
    }

    @PostMapping("reg")
    @ResponseBody
    public String reg(Admin admin){
        System.out.println(admin.getPhone()+","+admin.getPassword());
        return "{\"reg\":\"ok\"}";
    }

    @PostMapping("reg1")
    @ResponseBody
    public ControllerResult reg1(Admin admin){
        System.out.println(admin.getPhone()+","+admin.getPassword());
        adminService.save(admin);
        return ControllerResult.getSuccessResult("注册成功");
    }

    @GetMapping("phone/{phone}")
    @ResponseBody
    public Admin getByPhone(@PathVariable("phone") String phone) {
        return adminService.getByPhone(phone);
    }

}
