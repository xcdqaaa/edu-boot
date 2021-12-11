package com.aaa.edu.controller;

import com.aaa.edu.pojo.RespBean;
import com.aaa.edu.pojo.entity.User;
import com.aaa.edu.pojo.view.Info;
import com.aaa.edu.service.UserService;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

@Slf4j
@CrossOrigin
@RestController
public class LoginController {

    @Autowired
    UserService userService;

    @ApiOperation("登录")
    @PostMapping("/login")
    public RespBean login(@RequestBody User user){
        Integer uId = userService.login(user.getAccount(), user.getPassword());
        if(uId!=null)return RespBean.success("欢迎登陆",userService.getToken(uId));
        return RespBean.error("登陆失败，账号或密码错误");
    }

    @ApiOperation("角色")
    @GetMapping("/role")
    public RespBean getRole(@RequestHeader(value = "token")String token){
        String[] infos = token.split(",");
        List<String> roles = Collections.singletonList(userService.getRole(infos[1]));
//        if(StringUtils.hasText(role))return RespBean.success(null,role);
        return RespBean.success(null,roles);
    }

    @ApiOperation("info")
    @GetMapping("/info")
    public RespBean getInfo(String token){
        log.info(token);
        String[] tokens = token.split(",");
        Info info = new Info();
        info.setName(tokens[0]);
        info.setRoles(new String[]{tokens[1]});
        if(Objects.equals(tokens[2], "null")){
            info.setAvatar("http://localhost:8888/files/avatar");
        }else {
            info.setAvatar("http://localhost:8888/files/"+tokens[2]);
        }

        return RespBean.success(null,info);
    }


    @ApiOperation("logout")
    @PostMapping("/logout")
    public RespBean logout(){
        return RespBean.success(null);
    }


}
