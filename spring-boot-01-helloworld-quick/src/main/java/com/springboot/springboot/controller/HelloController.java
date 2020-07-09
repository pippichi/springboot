package com.springboot.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

//这个类的所有方法返回的数据直接写给浏览器，如果是对象就转为json数据
//@ResponseBody
//@Controller
//或者直接@RestController,可以代替@ResponseBody和@Controller
@RestController
public class HelloController {

    @RequestMapping("/hello")
    public String hello(){
        return "hello world quick1";
    }

    //RESTAPI的方式
}
