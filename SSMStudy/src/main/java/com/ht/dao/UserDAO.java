package com.ht.dao;

import com.ht.pojo.User;
import org.springframework.stereotype.Repository;

/**
 * Created by Administrator on 2017/9/13.
 */
@Repository
public interface UserDAO extends  BaseDAO<String,User> {
}
