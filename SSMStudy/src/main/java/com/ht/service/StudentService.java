package com.ht.service;

import com.ht.pojo.Student;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2017/9/9.
 */
public interface StudentService extends  BaseService<String,Student> {
    void updateWithIf(Student student);
    List<Student> getStudentWithIf(@Param("name") String name, @Param("age") int Age);
    List<Student> pageStudent(@Param("startPage") int startPage,int pageSize);
}
