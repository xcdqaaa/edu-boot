package com.aaa.edu.controller;

import com.aaa.edu.pojo.QueryInfo;
import com.aaa.edu.pojo.RespBean;
import com.aaa.edu.pojo.entity.User;
import com.aaa.edu.service.UserService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/user/admins")
    public RespBean getAdmins(@RequestBody QueryInfo info) {
        log.info(String.valueOf(info));
        IPage<User> users = userService.getUsers(info, 1);
        return RespBean.success(null,users);
    }
    @PostMapping("/user/teachers")
    public RespBean getTeachers(@RequestBody QueryInfo info) {
        log.info(String.valueOf(info));
        IPage<User> users = userService.getUsers(info, 2);
        return RespBean.success(null,users);
    }
    @PostMapping("/user/students")
    public RespBean getStudents(@RequestBody QueryInfo info) {
        log.info(String.valueOf(info));
        IPage<User> users = userService.getUsers(info, 3);
        return RespBean.success(null,users);
    }
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
