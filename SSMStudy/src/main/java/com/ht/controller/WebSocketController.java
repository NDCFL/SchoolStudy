package com.ht.controller;

import javax.servlet.http.HttpSession;

import com.ht.socket.SpringWebSocketHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.socket.TextMessage;
@Controller
public class WebSocketController {
    @Bean
    public SpringWebSocketHandler infoHandler() {
        return new SpringWebSocketHandler();
    }
    @RequestMapping("/websocket/login")
    public ModelAndView login(String username, HttpSession session) throws Exception {
        System.out.println(username+"登录");
        session.setAttribute("SESSION_USERNAME", username);
        return new ModelAndView("websocket");
    }

    @RequestMapping("/websocket/send")
    @ResponseBody
    public String send(String username) {
        System.out.println("============================");
        infoHandler().sendMessageToUser(username, new TextMessage("你好，测试！！！！"));
        return null;
    }
}