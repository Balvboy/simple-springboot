package com.example.demo.controller;

import com.example.demo.service.UserService;
import com.example.demo.util.RedisUtil;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;

@RequestMapping(value = "/api/test")
@RestController
@Data
public class TestController {

    @Autowired
    private UserService userService;

    @PostConstruct
    public void init(){
        System.out.println(userService);
    }



}
