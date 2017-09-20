package com.ht.pojo;

import org.springframework.jdbc.core.RowMapper;

import javax.swing.tree.TreePath;
import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Administrator on 2017/9/6.
 */
public class Student implements RowMapper<Student>,Serializable {
    private String id;
    private String name;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Student mapRow(ResultSet rs, int i) throws SQLException {
        Student student = new Student();
        student.setId(rs.getString("id"));
        student.setName(rs.getString("name"));
        return student;
    }
}
