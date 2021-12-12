package com.aaa.edu.service;

import com.aaa.edu.pojo.QueryInfo;
import com.aaa.edu.pojo.entity.User;
import com.aaa.edu.pojo.view.VStudent;
import com.aaa.edu.pojo.view.VTeacher;
import com.baomidou.mybatisplus.core.metadata.IPage;


public interface UserService {
    Integer login(String account, String password);

    String getToken(Integer uId);

    String getRole(String rId);

    IPage<User> getUsers(QueryInfo info, Integer role);

    Integer setUserState(Integer id, Integer state);

    Integer addAdmin(User user);

    Integer addTeacher(VTeacher teacher);

    Integer addStudent(VStudent student);

    Integer updateUser(User user);

    Integer updateTeacher(VTeacher teacher);

    Integer updateStudent(VStudent student);

    User getAdmin(Integer id);

    VTeacher getTeacher(Integer id);

    VStudent getStudent(Integer id);

    Integer deleteUser(Integer id);


}
