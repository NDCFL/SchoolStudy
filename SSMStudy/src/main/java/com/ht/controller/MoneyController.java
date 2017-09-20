package com.ht.controller;

import com.ht.pojo.Money;
import com.ht.pojo.Plays;
import com.ht.service.MoneyService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by Administrator on 2017/9/15.
 */
@Controller
@RequestMapping("money")
public class MoneyController {

    @Resource
    private MoneyService moneyService;
    @RequestMapping("/addMoney")
    public String addMoney() throws  Exception {
        return  "money/addMoney";
    }
    @GetMapping("/initAddMoney")
    public String initAddMoney() throws  Exception{
        return "money/initAddMoney";
    }
    @RequestMapping("/addSaveMoney")
    public String addSaveMoney(Money money, HttpSession session) throws  Exception {
        moneyService.add(money);
        return  "redirect:/moneyList";
    }
    @RequestMapping("/deleteMoney/{id}")
    @ResponseBody
    public String deleteMoney(@PathVariable("id") String id) throws  Exception{
        moneyService.delete(id);
        return "money/deleteMoney";
    }
    @RequestMapping("/deleteManyMoney/{id}")
    @ResponseBody
    public String deleteManyMoney(@PathVariable("id") String id) throws  Exception{
        String str[] = id.split(",");
        for(int i=0;i< str.length;i++){
            moneyService.delete(str[i]);
        }
        return "money/deleteManyMoney";
    }
    @RequestMapping("/findMoney/{id}")
    public ModelAndView findStudent(@PathVariable("id") String id){
        Money money= moneyService.queryById(id);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("money/findMoney");
        modelAndView.addObject("money",money);
        return modelAndView;
    }
    @RequestMapping("/updateMoney")
    public String updateMoney(Money money) throws  Exception{
        moneyService.update(money);
        return "money/updateMoney";
    }
    @RequestMapping("/moneyList/{id}")
    public ModelAndView moneyList(@PathVariable("id") String id) throws  Exception{
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("money/moneyList");
        List<Money> list = moneyService.findPageList(id);
        modelAndView.addObject("moneyList",list);
        return modelAndView;
    }

}
