package com.ht.serviceimpl;

import com.ht.dao.OrdersDAO;
import com.ht.pojo.Orders;
import com.ht.service.OrdersService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Administrator on 2017/9/13.
 */
@Service
public class OrdersServiceimpl implements OrdersService {
    @Resource
    private OrdersDAO ordersDAO;
    @Override
    public Orders queryById(String id) {
        return ordersDAO.queryById(id);
    }

    @Override
    public void update(Orders orders) {
        ordersDAO.update(orders);
    }

    @Override
    public void add(Orders orders) {
        ordersDAO.add(orders);
    }

    @Override
    public void delete(String id) {
        ordersDAO.delete(id);
    }

    @Override
    public List<Orders> pagelist() {
        return ordersDAO.pagelist();
    }

    @Override
    public List <Orders> pagelist(String id) {
        return  ordersDAO.pagelist(id);
    }
    @Override
    public int count() {
        return 0;
    }
}
