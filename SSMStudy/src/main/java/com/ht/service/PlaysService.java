package com.ht.service;

import com.ht.pojo.Plays;

/**
 * Created by Administrator on 2017/9/15.
 */
public interface PlaysService extends  BaseService<String,Plays> {

    Plays findplays(String playAccount);
}
