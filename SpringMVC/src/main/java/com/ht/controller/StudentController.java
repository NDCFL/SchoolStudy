package com.ht.controller;

import com.ht.pojo.Student;
import com.ht.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/9/7.
 */
@Controller
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentService studentService;
    @RequestMapping("/addStudent")
    public String addStudent() throws  Exception {
        return  "addStudent";
    }
    @RequestMapping("/addSaveStudent")
    public String addSaveStudent(Student student) throws  Exception {
        studentService.add(student);
        return  "addSaveStudent";
    }
    @RequestMapping("/deleteStudent/{id}")
    public String deleteStudent(@PathVariable("id") String id) throws  Exception{
        studentService.delete(id);
        return "addSaveStudent";
    }
    @RequestMapping("/findStudent/{id}")
    public ModelAndView findStudent(@PathVariable("id") String id){
        Student student = studentService.queryById(id);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("findStudent");
        modelAndView.addObject("student",student);
        return modelAndView;
    }
    @RequestMapping("/studentList")
    public ModelAndView studentList(Map<String,Object> map) throws  Exception{
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("studentList");
        List<Student> list = studentService.pagelist(map);
        modelAndView.addObject("studentList",list);
        return modelAndView;
    }
}
