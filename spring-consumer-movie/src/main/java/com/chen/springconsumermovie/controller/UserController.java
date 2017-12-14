package com.chen.springconsumermovie.controller;

import com.chen.springconsumermovie.FeignInterface.UserFeignService;
import com.chen.springconsumermovie.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private UserFeignService userFeignService;


    @GetMapping("/user/{id}")
    public User getUser(@PathVariable("id") Long id){

        User user = userFeignService.getUser(id);
        return user;
    }

    @GetMapping("/test/port")
    public String getPort(){
        return userFeignService.getPort();
    }

}
