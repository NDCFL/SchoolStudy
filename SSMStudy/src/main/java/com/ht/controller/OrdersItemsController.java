package com.ht.controller;

import com.ht.pojo.OrdersItems;
import com.ht.pojo.Product;
import com.ht.service.OrdersItemsService;
import com.ht.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Administrator on 2017/9/9.
 */
@Controller
@RequestMapping("/ordersItems")
public class OrdersItemsController {
    @Resource
    private OrdersItemsService ordersItemsService;
    @GetMapping("/initAddProduct")
    public String initAddProduct() throws  Exception{
        return "ordersItems/initAddProduct";
    }
    @RequestMapping("/addSaveProduct")
    public String addSaveProduct(Product ordersItems) throws  Exception {
        return  "redirect:/ordersItemsList";
    }
    @RequestMapping("/deleteProduct/{id}")
    @ResponseBody
    public String deleteProduct(@PathVariable("id") String id) throws  Exception{
        ordersItemsService.delete(id);
        return "addSaveProduct";
    }
    @RequestMapping("/deleteManyProduct/{id}")
    @ResponseBody
    public String deleteManyProduct(@PathVariable("id") String id) throws  Exception{
        String str[] = id.split(",");
        for(int i=0;i< str.length;i++){
            ordersItemsService.delete(str[i]);
        }
        return "deleteManyProduct";
    }
    @RequestMapping("/findProduct/{id}")
    public ModelAndView findProduct(@PathVariable("id") String id){
        OrdersItems ordersItems = ordersItemsService.queryById(id);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("ordersItems/findProduct");
        modelAndView.addObject("ordersItems",ordersItems);
        return modelAndView;
    }
    @RequestMapping("/updateProduct")
    public String updateProduct(OrdersItems ordersItems) throws  Exception{
        ordersItemsService.update(ordersItems);
        return "updateProduct";
    }
    @RequestMapping("/pagelistbyuserid/{id}")
    public ModelAndView pagelistbyuserid(@PathVariable("id") String id) throws  Exception{
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("ordersitems/ordersItemsList");
        List<OrdersItems> list = ordersItemsService.pagelistbyuserid(id);
        modelAndView.addObject("ordersItemsList",list);
        return modelAndView;
    }
    @RequestMapping("/pagelistbyorderid/{id}")
    public ModelAndView pagelistbyorderid(@PathVariable("id") String id) throws  Exception{
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("ordersitems/ordersItemsList");
        List<OrdersItems> list = ordersItemsService.pagelistbyorderid(id);
        modelAndView.addObject("ordersItemsList",list);
        return modelAndView;
    }
}
