package com.ht.service;

import com.ht.pojo.Student;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

/**
 * Created by Administrator on 2017/9/13.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(value = {"classpath:/config/spring-applicationContext.xml", "classpath:/config/spring-mybatis.xml"})

public class StudentServiceTest {

    @Resource
    private StudentService studentService;
    @Test
    public void testadd() throws  Exception{
        Student student = new Student();
        student.setName("测试");
        student.setSex(1);
        student.setClassno(4);
        student.setAge(12);
        studentService.add(student);
    }
}
