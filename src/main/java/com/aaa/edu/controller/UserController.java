package com.aaa.edu.controller;

import com.aaa.edu.pojo.QueryInfo;
import com.aaa.edu.pojo.RespBean;
import com.aaa.edu.pojo.entity.User;
import com.aaa.edu.pojo.view.VStudent;
import com.aaa.edu.pojo.view.VTeacher;
import com.aaa.edu.service.UserService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@Api(tags = "用户控制器")
public class UserController {

    @Autowired
    UserService userService;

    @ApiOperation("管理员列表")
    @PostMapping("/user/admins")
    public RespBean getAdmins(@RequestBody QueryInfo info) {
        log.info(String.valueOf(info));
        IPage<User> users = userService.getUsers(info, 1);
        return RespBean.success(null, users);
    }

    @ApiOperation("教师列表")
    @PostMapping("/user/teachers")
    public RespBean getTeachers(@RequestBody QueryInfo info) {
        log.info(String.valueOf(info));
        IPage<User> users = userService.getUsers(info, 2);
        return RespBean.success(null, users);
    }

    @ApiOperation("学生列表")
    @PostMapping("/user/students")
    public RespBean getStudents(@RequestBody QueryInfo info) {
        log.info(String.valueOf(info));
        IPage<User> users = userService.getUsers(info, 3);
        return RespBean.success(null, users);
    }
    @ApiOperation("删除用户")
    @DeleteMapping("/user/{id}")
    public RespBean deleteUser(@PathVariable Integer id){
        Integer flag = userService.deleteUser(id);
        if(flag>0)return RespBean.success("删除用户成功");
        return RespBean.error("删除用户失败");
    }

    @ApiOperation("添加管理员")
    @PostMapping("/user/admin")
    public RespBean addAdmin(@RequestBody User user) {
        Integer flag = userService.addAdmin(user);
        if (flag > 0) {
            return RespBean.success("添加管理员成功");
        }
        return RespBean.error("添加管理员失败");
    }

    @ApiOperation("获取管理员信息")
    @GetMapping("/user/admin/{id}")
    public RespBean getAdmin(@PathVariable Integer id) {
        log.info(id + "============");
        User admin = userService.getAdmin(id);
        if (admin != null) {
            return RespBean.success(null, admin);
        }
        return RespBean.error("获取管理员失败");
    }

    @ApiOperation("更新管理员")
    @PutMapping("/user/admin")
    public RespBean updateAdmin(@RequestBody User user) {
        Integer flag = userService.updateUser(user);
        if (flag > 0) {
            return RespBean.success("修改用户成功");
        }
        return RespBean.error("修改用户失败");
    }

    @ApiOperation("添加教师")
    @PostMapping("/user/teacher")
    public RespBean addTeacher(@RequestBody VTeacher user) {
        Integer flag = userService.addTeacher(user);
        if (flag > 0) {
            return RespBean.success("添加教师成功");
        }
        return RespBean.error("添加教师失败");
    }
    @ApiOperation("获取教师")
    @GetMapping("/user/teacher/{id}")
    public RespBean getTeacher(Integer id) {
        log.info(id + "============");
        VTeacher teacher = userService.getTeacher(id);
        if (teacher != null) {
            return RespBean.success(null, teacher);
        }
        return RespBean.error("获取教师失败");
    }
    @ApiOperation("更新教师")
    @PutMapping("/user/teacher")
    public RespBean updateTeacher(@RequestBody VTeacher user) {
        Integer flag = userService.updateTeacher(user);
        if (flag > 0) {
            return RespBean.success("修改教师成功");
        }
        return RespBean.error("修改教师失败");
    }

    @ApiOperation("添加学生")
    @PostMapping("/user/student")
    public RespBean addStudent(@RequestBody VStudent user) {
        Integer flag = userService.addStudent(user);
        if (flag > 0) {
            return RespBean.success("添加学生成功");
        }
        return RespBean.error("添加学生失败");
    }

    @ApiOperation("修改学生")
    @PutMapping("/user/student")
    public RespBean updateStudent(@RequestBody VStudent user) {
        Integer flag = userService.updateStudent(user);
        if (flag > 0) {
            return RespBean.success("修改学生成功");
        }
        return RespBean.error("修改学生失败");
    }
    @ApiOperation("获取学生")
    @GetMapping("/user/student/{id}")
    public RespBean getStudent(@PathVariable Integer id) {
        VStudent student = userService.getStudent(id);
        if (student != null) {
            return RespBean.success(null, student);
        }
        return RespBean.error("获取学生失败");
    }

    @ApiOperation("修改用户状态")
    @GetMapping("/user/state/{uid}/{state}")
    public RespBean setUserState(@PathVariable("uid") Integer id, @PathVariable("state") Integer state) {
        Integer flag = userService.setUserState(id, state);
        if (flag > 0) {
            return RespBean.success(state == 1 ? "用户已开启" : "用户已禁用");
        }
        return RespBean.error("更新失败");
    }

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
