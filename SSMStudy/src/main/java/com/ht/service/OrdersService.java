package com.ht.service;

import com.ht.pojo.Orders;

import java.util.List;

/**
 * Created by Administrator on 2017/9/13.
 */
public interface OrdersService extends BaseService<String,Orders>{
    public List<Orders> pagelist(String id);
}
