package com.ht.service;

import com.ht.dao.UserDAO;
import com.ht.pojo.Orders;
import com.ht.pojo.OrdersItems;
import com.ht.pojo.Product;
import com.ht.pojo.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Administrator on 2017/9/13.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(value = {"classpath:/config/spring-applicationContext.xml", "classpath:/config/spring-mybatis.xml"})
public class OrdersServiceTest {
    @Resource
    private OrdersItemsService ordersItemsService;
    @Test
    public void testpagelist() throws  Exception{
        List<OrdersItems> ordersItemsList = ordersItemsService.pagelist();
        for (OrdersItems ordersItems: ordersItemsList) {
            System.out.println(ordersItems.getCount()+"订单明细：");
        }
    }
}
