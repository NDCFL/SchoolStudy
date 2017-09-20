package com.ht.daoimpl;

import com.ht.dao.StudentDAO;
import com.ht.pojo.Student;
import com.sun.org.apache.xpath.internal.SourceTree;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/9/6.
 */
@Repository("StudentDAO")
public class StudentDAOimpl implements StudentDAO {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
    public List<Student> pagelist(Map<String,Object> map) {
        String sql = "select * from student";
        RowMapper<Student> rowMapper=new BeanPropertyRowMapper<Student>(Student.class);
        List<Student> studentList = jdbcTemplate.query(sql,rowMapper);
        map.put("studentList",studentList);
        return studentList;
    }
    public Student queryById(String id) {
        String sql = "select * from student where id=?";
        Student student = jdbcTemplate.queryForObject(sql,new Student(),new Object[]{id});
        return student;
    }
    public void update(Student student) {

    }
    public void add(Student student) {
        String sql = "INSERT INTO student(id,name) VALUES(:id,:name)";
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("id", student.getId());
        paramSource.addValue("name", student.getName());
        namedParameterJdbcTemplate.update(sql, paramSource);
    }
    public void delete(java.lang.String id) {
        String sql = "delete from  student where id=?";
        jdbcTemplate.update(sql,id);
    }
}
