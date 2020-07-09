package com.atguigu.springboot.controller;

import com.atguigu.springboot.entitiy.User;
import com.atguigu.springboot.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    UserRepository userRepository;

    @GetMapping("/user/{id}")
    public User getUser(@PathVariable("id") Integer id){
        return userRepository.findById(id).get();
    }

    @GetMapping("/user")
    public User insertUser(User user){
        return userRepository.save(user);
    }
}
