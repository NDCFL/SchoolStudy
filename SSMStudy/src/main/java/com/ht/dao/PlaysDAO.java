package com.ht.dao;

import com.ht.pojo.Plays;
import org.springframework.stereotype.Repository;

/**
 * Created by Administrator on 2017/9/15.
 */
@Repository
public interface PlaysDAO extends  BaseDAO<String,Plays> {

    Plays findplays(String playAccount);
}
