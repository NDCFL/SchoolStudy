package com.ht.serviceimpl;

import com.ht.dao.StudentDAO;
import com.ht.pojo.Student;
import com.ht.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/9/6.
 */
@Service("StudentService")
public class StudentServiceimpl implements StudentService {
    @Autowired
    private StudentDAO studentDAO;

    public Student queryById(java.lang.String id) {
        return studentDAO.queryById(id);
    }

    public void update(Student student) {
        studentDAO.update(student);
    }

    public void add(Student student) {
        studentDAO.add(student);
    }

    public void delete(String id) { studentDAO.delete(id); }

    public List<Student> pagelist(Map<String,Object> map) { return studentDAO.pagelist(map);}
}
