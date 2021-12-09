package com.aaa.edu.controller;

import com.aaa.edu.pojo.RespBean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    @GetMapping("/hello")
    public RespBean getHello(){
        return RespBean.success("hello");
    }
}
