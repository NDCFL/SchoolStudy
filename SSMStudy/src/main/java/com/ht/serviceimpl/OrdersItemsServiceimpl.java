package com.ht.serviceimpl;

import com.ht.dao.OrdersItemsDAO;
import com.ht.pojo.OrdersItems;
import com.ht.service.OrdersItemsService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Administrator on 2017/9/13.
 */
@Service
public class OrdersItemsServiceimpl implements OrdersItemsService {
    @Resource
    private OrdersItemsDAO ordersItemsDAO;
    @Override
    public OrdersItems queryById(String id) {
        return ordersItemsDAO.queryById(id);
    }

    @Override
    public void update(OrdersItems ordersItems) {
        ordersItemsDAO.update(ordersItems);
    }

    @Override
    public void add(OrdersItems ordersItems) {
        ordersItemsDAO.add(ordersItems);
    }

    @Override
    public void delete(String id) {
        ordersItemsDAO.delete(id);
    }

    @Override
    public List<OrdersItems> pagelist() {
        return ordersItemsDAO.pagelist();
    }

    @Override
    public List <OrdersItems> pagelistbyorderid(String id) {
        return ordersItemsDAO.pagelistbyorderid(id);
    }

    @Override
    public List <OrdersItems> pagelistbyuserid(String id) {
        return ordersItemsDAO.pagelistbyuserid(id);
    }
    @Override
    public int count() {
        return 0;
    }
}
