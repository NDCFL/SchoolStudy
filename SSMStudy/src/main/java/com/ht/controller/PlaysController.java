package com.ht.controller;

import com.ht.pojo.Message;
import com.ht.pojo.Plays;
import com.ht.pojo.Student;
import com.ht.service.PlaysService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

/**
 * Created by Administrator on 2017/9/15.
 */
@Controller
@RequestMapping("plays")
public class PlaysController {

    @Resource
    private PlaysService playsService;
    @RequestMapping("login")
    public String login() throws  Exception{
        return "login";
    }
    @RequestMapping
    public String reg() throws  Exception{
        return "reg";
    }
    @RequestMapping("findPlays/{id}")
    public ModelAndView findPlays(@PathVariable("id") String id){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("findPly");
        Plays plays =playsService.queryById(id);
        return modelAndView;
    }
    @RequestMapping("/addSavePlays")
    @ResponseBody
    public Message addSavePlays(Plays plays) throws  Exception {
        playsService.add(plays);
        return new Message("success","新增成功!");
    }
    @RequestMapping("success")
    public String success(String playsAccount) throws  Exception{

        return "redirt:/index";
    }

    @RequestMapping("loginIn")
    @ResponseBody
    public Message loginIn(Plays plays, HttpSession session) throws  Exception{
        Plays plays1 = playsService.findplays(plays.getPlayAccount());
        if(plays1==null){
            return new Message("success","玩家不存在!");
        }else{
            if(!plays.getPlayAccount().equals(plays1.getPlayAccount())){
                return Message.fail("账号不存在");
            }else if(!plays.getPlayPassword().equals(plays1.getPlayPassword())){
                return Message.fail("密码错误!");
            }else{
                session.setAttribute("plays",plays1);
                return Message.success("成功!");
            }
        }
    }
    @RequestMapping("exit")
    @ResponseBody
    public String exit(HttpSession session){
        session.invalidate();
        return "ok";
    }
}
