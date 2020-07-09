package com.atguigu.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.thymeleaf.util.StringUtils;

import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
public class LoginController {

//    @GetMapping
//    @PutMapping
//    @DeleteMapping
//    @RequestMapping
    @PostMapping(value = "/user/login")
//    @RequestMapping(value = "/user/login",method = RequestMethod.POST)
    public String login(@RequestParam("username") String username,
                        @RequestParam("password") String password,
                        Map<String,Object> map, HttpSession session){
        if(!StringUtils.isEmpty(username)&&"123456".equals(password)){
            session.setAttribute("loginUser",username);
            //登陆成功
            return "redirect:/main.html";
        }else{
            //登陆失败
            map.put("msg","用户名密码错误");
            return "login";
        }
    }
}
