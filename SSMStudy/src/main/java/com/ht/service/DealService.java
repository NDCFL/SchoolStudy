package com.ht.service;

import com.ht.pojo.Deal;

import java.util.List;

/**
 * Created by Administrator on 2017/9/15.
 */
public interface DealService extends  BaseService<String,Deal> {
    List<Deal> findpagelist(String id);
}
