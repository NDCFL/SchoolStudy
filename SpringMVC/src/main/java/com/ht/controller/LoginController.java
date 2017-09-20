package com.ht.controller;

import com.ht.pojo.Student;
import com.ht.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;

/**
 * Created by Administrator on 2017/9/5.
 */
@Controller
@RequestMapping("/lg")
public class LoginController {

    @Autowired
    private StudentService studentService;
    @RequestMapping(value = "/login")
    public String login() throws  Exception{
        return "login";
    }
    @RequestMapping(value = "/loginin")
    public String loginin() throws  Exception{
        return "loginin";
    }
    @RequestMapping(value="/logininto")
    public String logininto(@RequestParam("id")String id,@RequestParam("name")String name) throws  Exception{
        System.out.print("id:"+id+";name:"+name);
        //查询数据，返回一个javabean对象
//        Student student =  studentService.queryById("1");
//        System.out.println(student.getName()+"==========");
        Student student = new Student();
        student.setId(id);
        student.setName(name);
        studentService.add(student);
        return "logininto";
    }
}
