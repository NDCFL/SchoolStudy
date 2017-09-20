package com.ht.controller;

import com.ht.pojo.Orders;
import com.ht.pojo.User;
import com.ht.service.OrdersService;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2017/9/13.
 */
@Controller
@RequestMapping("orders")
public class OrdersController {

    @Resource
    private OrdersService ordersService;
    @RequestMapping("orderList/{id}")
    public ModelAndView orderList(@PathVariable("id") String id){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("orders/ordersList");
        List<Orders> list = ordersService.pagelist(id);
        modelAndView.addObject("ordersList",list);
        modelAndView.addObject("userid",id);
        return modelAndView;
    }
    @RequestMapping("/initordersAdd/{id}")
    public ModelAndView initordersAdd(@PathVariable("id") String id) throws  Exception{
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("orders/ordersAdd");
        modelAndView.addObject("userid",id);
        return  modelAndView;
    }
    @RequestMapping("ordersAddSave")
    public String ordersAddSave(Orders orders) throws  Exception{
        try {
            System.out.println(orders.getUserId()+"=============");
            ordersService.add(orders);
        }catch (Exception e){
            e.printStackTrace();
        }
        return  "redirect:/orderList";
    }
    @RequestMapping("findOrders/{id}")
    public ModelAndView findOrders(@PathVariable("id") String id){
        Orders orders= ordersService.queryById(id);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("orders/findOrders");
        modelAndView.addObject("orders",orders);
        return modelAndView;
    }
    @RequestMapping("/ordersUpdateSave")
    public String ordersUpdateSave(Orders order) throws  Exception{
        ordersService.update(order);
        return "ordersUpdateSave";
    }
    @RequestMapping("deleteOrders/{id}")
    @ResponseBody
    public String deleteOrders(@PathVariable("id") String id) throws  Exception{
        ordersService.delete(id);
        return "deleteOrders";
    }
    @RequestMapping("/deleteManyOrders/{id}")
    @ResponseBody
    public String deleteManyProduct(@PathVariable("id") String id) throws  Exception{
        String str[] = id.split(",");
        for(int i=0;i< str.length;i++){
            ordersService.delete(str[i]);
        }
        return "deleteManyOrders";
    }
    @RequestMapping("/updateOrders")
    public String updateOrders(Orders orders) throws  Exception{
        System.out.println(orders.getCreateTime());
        User user = new User();
        user.setId(orders.getId());
        ordersService.update(orders);
        return "updateOrders";
    }
    @InitBinder
    public void initBinder(WebDataBinder binder) {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        dateFormat.setLenient(false);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
    }
}
