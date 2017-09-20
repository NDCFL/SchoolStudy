package com.ht.controller;

import com.ht.pojo.Page;
import com.ht.pojo.Student;
import com.ht.service.StudentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Administrator on 2017/9/9.
 */
@Controller
@RequestMapping("/student")
public class StudentController {
    //日志记录
    private Logger logget = LoggerFactory.getLogger(StudentController.class);
    @Resource
    private StudentService studentService;
    @RequestMapping("/addStudent")
    public String addStudent() throws  Exception {
        return  "addStudent";
    }
    @GetMapping("/initaddstudent")
    public String initaddstudent() throws  Exception{
        return "initaddstudent";
    }
    @RequestMapping("/addSaveStudent")
    public String addSaveStudent(Student student) throws  Exception {
        studentService.add(student);
        return  "redirect:/studentList";
    }
    @RequestMapping("/deleteStudent/{id}")
    @ResponseBody
    public String deleteStudent(@PathVariable("id") String id) throws  Exception{
        studentService.delete(id);
        return "addSaveStudent";
    }
    @RequestMapping("/deleteManyStudent/{id}")
    @ResponseBody
    public String deleteManyStudent(@PathVariable("id") String id) throws  Exception{
        String str[] = id.split(",");
        for(int i=0;i< str.length;i++){
            studentService.delete(str[i]);
        }
        return "deleteManyStudent";
    }
    @RequestMapping("/findStudent/{id}")
    public ModelAndView findStudent(@PathVariable("id") String id){
        Student student = studentService.queryById(id);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("findStudent");
        modelAndView.addObject("student",student);
        return modelAndView;
    }
    @RequestMapping("/updatestudent")
    public String updatestudent(Student student) throws  Exception{
        studentService.update(student);
        return "updatestudent";
    }
    @RequestMapping("/studentList")
    public ModelAndView studentList() throws  Exception{
        logget.info("查询学生的列表studentlist,地址为student/studentList");
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("studentList");
        List<Student> list = studentService.pagelist();
        modelAndView.addObject("studentList",list);
        return modelAndView;
    }
    @RequestMapping("/pageStudentList")
    @ResponseBody
    public Page<Student> pageStudentList(Integer pageindex,Integer pageSize){
        System.out.println(pageindex+"=================");
        if(pageindex==null){
            pageindex=1;
        }
        Page<Student> studentPage = new Page <Student>();
        List<Student> studentList = studentService.pageStudent((pageindex-1)*pageSize,pageSize);
        studentPage.setTotalCount(studentService.count());
        studentPage.setResult(studentList);
        return studentPage;
    }

    @GetMapping("updateWithIf")
    @ResponseBody
    public Student updateWithIf(){
        Student student = new Student();
        student.setName("条件修改");
        student.setSex(1);
        student.setClassno(4);
        student.setAge(12);
        student.setId("10");
        studentService.updateWithIf(student);
        return student;
    }
}
