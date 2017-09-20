package com.ht.serviceimpl;

import com.ht.dao.StudentDAO;
import com.ht.log.CommonBusiness;
import com.ht.pojo.Student;
import com.ht.service.StudentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/9/9.
 */
@Service("StudentService")
public class StudentSericeimpl implements StudentService {

    @Resource
    private StudentDAO studentDAO;
    @Resource
    private CommonBusiness commonBusiness;

    public Student queryById(String id) {
        commonBusiness.log();
        return studentDAO.queryById(id);
    }

    public void update(Student student) {
        commonBusiness.log();
        studentDAO.update(student);
    }

    public void add(Student student) {
        commonBusiness.log();studentDAO.add(student);
    }

    public void delete(String id) {
        commonBusiness.log();
        studentDAO.delete(id);
    }

    public List<Student> pagelist() {
        commonBusiness.log();
        return studentDAO.pagelist();
    }

    @Override
    public void updateWithIf(Student student) {
       studentDAO.updateWithIf(student);
    }

    @Override
    public  List<Student> getStudentWithIf(String name, int age) {
        return studentDAO.getStudentWithIf(name,age);
    }

    public List <Student> pageStudent(int startPage, int pageSize) {
        return studentDAO.pageStudent(startPage,pageSize);
    }
    @Override
    public int count() {
        return studentDAO.count();
    }
}
