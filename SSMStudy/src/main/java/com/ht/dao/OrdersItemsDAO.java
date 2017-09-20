package com.ht.dao;

import com.ht.pojo.OrdersItems;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Administrator on 2017/9/13.
 */
@Repository
public interface OrdersItemsDAO extends  BaseDAO<String,OrdersItems> {
    List<OrdersItems> pagelistbyorderid(String id);
    List<OrdersItems> pagelistbyuserid(String id);
}
