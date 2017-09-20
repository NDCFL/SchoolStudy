package com.ht.dao;

import com.ht.pojo.Orders;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Administrator on 2017/9/13.
 */
@Repository
public interface OrdersDAO extends  BaseDAO<String,Orders> {
    public List<Orders> pagelist(String id);
}
