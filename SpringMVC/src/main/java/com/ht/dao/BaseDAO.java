package com.ht.dao;

import com.ht.pojo.Student;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/9/6.
 */
public interface BaseDAO<PK,T> {

    public T queryById(PK id);

    public void update(T t);

    public void add(T t);

    public void delete(String id);

    public List<Student> pagelist(Map<String,Object> map);

}
