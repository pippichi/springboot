package com.atguigu.springboot.controller;

import com.atguigu.springboot.exception.UserNotExistException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class MyExcetionHandler {

    //1、浏览器客户端返回的都是json
//    @ResponseBody
//    @ExceptionHandler(UserNotExistException.class)
//    public Map<String,Object> handleException(Exception e){
//
//        Map<String,Object> map = new HashMap<>();
//        map.put("code","user.notexist");
//        map.put("massage",e.getMessage());
//        return map;
//    }
    @ExceptionHandler(UserNotExistException.class)
    public String handleException(Exception e, HttpServletRequest request){
        request.setAttribute("javax.servlet.error.status_code",500);
        Map<String,Object> map = new HashMap<>();
        map.put("code","user.notexist");
        map.put("massage",e.getMessage());

        request.setAttribute("mst",map);
        return "forward:/error";
    }
}
