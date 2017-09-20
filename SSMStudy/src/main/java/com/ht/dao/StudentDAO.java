package com.ht.dao;

import com.ht.pojo.Student;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by Administrator on 2017/9/9.
 */
public interface StudentDAO extends BaseDAO<String,Student> {

    void updateWithIf(Student student);
    List<Student> getStudentWithIf(@Param("name") String name, @Param("age") int Age);
    List<Student> pageStudent(@Param("startPage") int startPage,@Param("pageSize")int pageSize);
}
