package com.aaa.edu.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class UserController {

//    @Autowired
//    UserService userService;
//
//    @RequestMapping("/users")
//    public RespBean getAllUsers(@RequestBody QueryInfo info) {
//        log.info(String.valueOf(info));
//        return userService.getAllUsers(info);
//    }
//
//    @RequestMapping("/adduser")
//    public RespBean addUser(@RequestBody User user){
////        user.setState(1);
//        return userService.addUser(user);
//    }
//
//    @RequestMapping("getuser")
//    public RespBean getUser(Integer id){
//        log.info(id+"============");
//        return userService.getUser(id);
//    }
//
//    @RequestMapping("/userstate")
//    public RespBean setUserState(int id,int state){
//        return userService.setUserState(id,state);
//    }
//
//    @RequestMapping("/updateuser")
//    public RespBean updateUser(@RequestBody User user){
//        return userService.updateUser(user);
//    }
//
//    @RequestMapping(value = "/user",method = RequestMethod.DELETE)
//    public RespBean deleteUser(int id){
//        return userService.deleteUser(id);
//    }
//    @RequestMapping(value = "/user",method = RequestMethod.POST)
//    public RespBean addVUser(@RequestBody VUser vUser){
////        user.setState(1);
//        return userService.addVUser(vUser);
//    }
//
//    @RequestMapping("/users2")
//    public RespBean getAllUsers2() {
////        log.info(String.valueOf(info));
//        QueryInfo info = new QueryInfo("",1,10);
//        return userService.getAllUsers(info);
//    }

}
