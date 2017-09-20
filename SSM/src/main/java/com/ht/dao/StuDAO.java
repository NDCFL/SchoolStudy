package com.ht.dao;

import com.ht.mapping.Stu;

import java.util.List;

public interface StuDAO {

    //新增
    public void addStu(Stu stu);
    //删除
    public void delStu(String stuId);
    //修改
    public void updateStu(Stu stu);
    //通过id查询
    public Stu getStuById(String stuId);
    //分页
    public List<Stu> getStuList();
}
