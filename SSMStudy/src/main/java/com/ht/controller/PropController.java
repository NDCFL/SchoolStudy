package com.ht.controller;

import com.ht.pojo.Prop;
import com.ht.pojo.Student;
import com.ht.service.PropService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Administrator on 2017/9/15.
 */
@Controller
@RequestMapping("prop")
public class PropController  {

    @Resource
    private PropService propService;
    @RequestMapping("/addProp")
    public String addProp() throws  Exception {
        return  "prop/addProp";
    }
    @GetMapping("/initAddProp")
    public String initAddProp() throws  Exception{
        return "prop/initAddProp";
    }
    @RequestMapping("/addSaveProp")
    public String addSaveProp(Prop prop) throws  Exception {
        propService.add(prop);
        return  "redirect:/propList";
    }
    @RequestMapping("/deleteProp/{id}")
    @ResponseBody
    public String deleteProp(@PathVariable("id") String id) throws  Exception{
        propService.delete(id);
        return "prop/deleteProp";
    }
    @RequestMapping("/deleteManyProp/{id}")
    @ResponseBody
    public String deleteManyProp(@PathVariable("id") String id) throws  Exception{
        String str[] = id.split(",");
        for(int i=0;i< str.length;i++){
            propService.delete(str[i]);
        }
        return "prop/deleteManyProp";
    }
    @RequestMapping("/findProp/{id}")
    public ModelAndView findStudent(@PathVariable("id") String id){
        Prop prop= propService.queryById(id);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("prop/findProp");
        modelAndView.addObject("prop",prop);
        return modelAndView;
    }
    @RequestMapping("/findTheProp/{id}")
    @ResponseBody
    public Prop findTheProp(@PathVariable("id") String id){
        Prop prop= propService.queryById(id);
        return prop;
    }
    @RequestMapping("/updateProp")
    public String updateProp(Prop prop) throws  Exception{
        propService.update(prop);
        return "prop/updateProp";
    }
    @RequestMapping("/propList")
    public ModelAndView propList() throws  Exception{
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("prop/propList");
        List<Prop> list = propService.pagelist();
        modelAndView.addObject("propList",list);
        return modelAndView;
    }
}
