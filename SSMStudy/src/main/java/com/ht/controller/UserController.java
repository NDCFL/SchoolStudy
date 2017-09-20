package com.ht.controller;

import com.ht.pojo.User;
import com.ht.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Administrator on 2017/9/13.
 */
@Controller
@RequestMapping("/users")
public class UserController {
    @Resource
    private UserService userService;
    @RequestMapping("/usersList")
    public ModelAndView usersList() throws  Exception{
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("user/usersList");
        List<User> list = userService.pagelist();
        modelAndView.addObject("usersList",list);
        return modelAndView;
    }
    @RequestMapping("inituserAdd")
    public String initusersAdd() throws  Exception{
        return "user/usersAdd";
    }
    @RequestMapping("/userAddSave")
    public String addSaveUser(User user) throws  Exception {
        userService.add(user);
        return  "user/usersList";
    }
    @RequestMapping("/findUsers/{id}")
    public ModelAndView findUser(@PathVariable("id") String id){
        User user = userService.queryById(id);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("user/findUsers");
        modelAndView.addObject("users",user);
        return modelAndView;
    }
    @RequestMapping("/usersUpdateSave")
    public String updateUser(User user) throws  Exception{
        userService.update(user);
        return "user/usersAddSave";
    }
    @RequestMapping("/deleteManyUser/{id}")
    @ResponseBody
    public String deleteManyUser(@PathVariable("id") String id) throws  Exception{
        String str[] = id.split(",");
        for(int i=0;i< str.length;i++){
            userService.delete(str[i]);
        }
        return "deleteManyUser";
    }
    @RequestMapping("/deleteUser/{id}")
    @ResponseBody
    public String deleteUser(@PathVariable("id") String id) throws  Exception{
        userService.delete(id);
        return "addSaveUser";
    }
}
