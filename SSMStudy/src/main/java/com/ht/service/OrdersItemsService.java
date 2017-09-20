package com.ht.service;


import com.ht.pojo.OrdersItems;

import java.util.List;

/**
 * Created by Administrator on 2017/9/13.
 */
public interface OrdersItemsService extends BaseService<String,OrdersItems> {
    List<OrdersItems> pagelistbyorderid(String id);
    List<OrdersItems> pagelistbyuserid(String id);
}
