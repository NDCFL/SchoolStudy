package com.ht.controller;

import com.ht.pojo.Deal;
import com.ht.pojo.Money;
import com.ht.pojo.Plays;
import com.ht.pojo.Prop;
import com.ht.service.DealService;
import com.ht.service.MoneyService;
import com.ht.service.PlaysService;
import com.ht.service.PropService;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2017/9/15.
 */
@Controller
@RequestMapping("deal")
public class DealController  {
    @Resource
    private DealService dealService;
    @Resource
    private PropService propService;
    @Resource
    private MoneyService moneyService;
    @RequestMapping("/addDeal")
    public ModelAndView addDeal() throws  Exception {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("deal/addDeal");
        List<Prop> propList = propService.pagelist();
        modelAndView.addObject("propList",propList);
        return  modelAndView;
    }
    @GetMapping("/initAddDeal")
    public ModelAndView initAddDeal(HttpSession session) throws  Exception{
        Plays plays = (Plays) session.getAttribute("plays");
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("deal/dealAdd");
        List<Prop> propList = propService.pagelist();
        modelAndView.addObject("propList",propList);
        double summoney = moneyService.allMoney(plays.getPlayId());
        modelAndView.addObject("summoney",summoney);
        return modelAndView;
    }
    @RequestMapping("/addSaveDeal")
    public String addSaveDeal(Deal deal, HttpSession session) throws  Exception {
        Plays p = (Plays) session.getAttribute("plays");
        deal.setDealBill(System.currentTimeMillis()+"");
        deal.setDealCreatetime(new Date());
        deal.setPlayId(p.getPlayId());
        dealService.add(deal);
        Money money = new Money();
        money.setMoney(0-deal.getDealPrice());
        money.setPlayId(p.getPlayId());
        moneyService.add(money);
        return  "redirect:/dealList";
    }
    @RequestMapping("/deleteDeal/{id}")
    @ResponseBody
    public String deleteDeal(@PathVariable("id") String id) throws  Exception{
        dealService.delete(id);
        return "deal/deleteDeal";
    }
    @RequestMapping("/deleteManyDeal/{id}")
    @ResponseBody
    public String deleteManyDeal(@PathVariable("id") String id) throws  Exception{
        String str[] = id.split(",");
        for(int i=0;i< str.length;i++){
            dealService.delete(str[i]);
        }
        return "deal/deleteManyDeal";
    }
    @RequestMapping("/findDeal/{id}")
    public ModelAndView findStudent(@PathVariable("id") String id){
        Deal deal= dealService.queryById(id);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("deal/findDeal");
        modelAndView.addObject("deal",deal);
        return modelAndView;
    }
    @RequestMapping("/updateDeal")
    public String updateDeal(Deal deal) throws  Exception{
        dealService.update(deal);
        return "deal/updateDeal";
    }
    @RequestMapping("/dealList/{id}")
    public ModelAndView dealList(@PathVariable("id") String id) throws  Exception{
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("deal/dealList");
        List<Deal> list = dealService.findpagelist(id);
        modelAndView.addObject("dealList",list);
        return modelAndView;
    }
    @InitBinder
    public void initBinder(WebDataBinder binder) {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        dateFormat.setLenient(false);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
    }

}
