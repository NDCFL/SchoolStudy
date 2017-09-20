package com.ht.controller;

import com.ht.pojo.Product;
import com.ht.service.ProductService;
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
@RequestMapping("/product")
public class ProductController {
    @Resource
    private ProductService productService;
    @GetMapping("/initAddProduct")
    public String initAddProduct() throws  Exception{
        return "product/initAddProduct";
    }
    @RequestMapping("/addSaveProduct")
    public String addSaveProduct(Product product) throws  Exception {
        productService.add(product);
        return  "redirect:/productList";
    }
    @RequestMapping("/deleteProduct/{id}")
    @ResponseBody
    public String deleteProduct(@PathVariable("id") String id) throws  Exception{
        productService.delete(id);
        return "addSaveProduct";
    }
    @RequestMapping("/deleteManyProduct/{id}")
    @ResponseBody
    public String deleteManyProduct(@PathVariable("id") String id) throws  Exception{
        String str[] = id.split(",");
        for(int i=0;i< str.length;i++){
            productService.delete(str[i]);
        }
        return "deleteManyProduct";
    }
    @RequestMapping("/findProduct/{id}")
    public ModelAndView findProduct(@PathVariable("id") String id){
        Product product = productService.queryById(id);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("product/findProduct");
        modelAndView.addObject("product",product);
        return modelAndView;
    }
    @RequestMapping("/updateProduct")
    public String updateProduct(Product product) throws  Exception{
        productService.update(product);
        return "updateProduct";
    }
    @RequestMapping("/productList")
    public ModelAndView productList() throws  Exception{
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("product/productList");
        List<Product> list = productService.pagelist();
        modelAndView.addObject("productList",list);
        return modelAndView;
    }
}
