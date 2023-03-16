package com.aaa.edu.service.impl;

import com.aaa.edu.mapper.StudentMapper;
import com.aaa.edu.mapper.TeacherMapper;
import com.aaa.edu.mapper.UserMapper;
import com.aaa.edu.pojo.QueryInfo;
import com.aaa.edu.pojo.entity.Teacher;
import com.aaa.edu.pojo.entity.User;
import com.aaa.edu.pojo.view.VStudent;
import com.aaa.edu.pojo.view.VTeacher;
import com.aaa.edu.service.UserService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;
    @Autowired
    TeacherMapper teacherMapper;
    @Autowired
    StudentMapper studentMapper;

    @Override
    public Integer login(String account, String password) {
        User userByMessage = userMapper.getUserByMessage(account, password);
        if (userByMessage != null)
            return userByMessage.getUId();
        return null;
    }

    @Override
    public String getToken(Integer uId) {
        User user = userMapper.selectById(uId);
        String token = user.getUId() + "," + getRole(user.getRole() + "") + "," + user.getAvatar();
        return token;
    }

    @Override
    public String getRole(String rId) {
        String rFlag = "";
        if ("1".equals(rId)) rFlag = "admin";
        else if ("2".equals(rId)) rFlag = "teacher";
        else if ("3".equals(rId)) rFlag = "student";
        return rFlag;
    }

    @Override
    public IPage<User> getUsers(QueryInfo info, Integer role) {
        IPage<User> userIPage = new Page<>();
        userIPage.setCurrent(info.getPageNumber());
        userIPage.setSize(info.getPageSize());
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.like("account", info.getQuery()).ge("state", 0).eq("role", role);
        return userMapper.selectPage(userIPage, wrapper);
    }

    @Override
    public Integer setUserState(Integer id, Integer state) {
        return userMapper.setUserState(id, state);
    }

    @Override
    public Integer addAdmin(User user) {
        user.setRole(1);
        return userMapper.insert(user);
    }

    @Override
    public Integer addTeacher(VTeacher teacher) {
        User user = new User();
        user.setAccount(teacher.getTId());
        user.setPassword(teacher.getPassword());
        user.setRole(2);
        userMapper.insert(user);
        Integer uId = user.getUId();
        VTeacher myTeacher = new VTeacher();
        myTeacher.setUId(uId);
        myTeacher.setTName(teacher.getTName());
        myTeacher.setGId(teacher.getGId());
        return teacherMapper.insert(myTeacher);
    }

    @Override
    public Integer addStudent(VStudent student) {
        User user = new User();
        user.setAccount(student.getSId());
        user.setPassword(student.getPassword());
        user.setRole(3);
        userMapper.insert(user);
        Integer uId = user.getUId();
        VStudent myStudent = new VStudent();
        myStudent.setUId(uId);
        myStudent.setSName(student.getSName());
        myStudent.setCId(student.getCId());
        return studentMapper.insert(myStudent);
    }

    @Override
    public Integer updateUser(User user) {
        return userMapper.updateById(user);
    }

    @Override
    public Integer updateTeacher(VTeacher teacher) {
        User user = new User();
        user.setUId(teacher.getUId());
        user.setAccount(teacher.getTId());
        user.setPassword(teacher.getPassword());
        user.setRole(2);
        userMapper.updateById(user);
        VTeacher myTeacher = new VTeacher();
        myTeacher.setUId(teacher.getUId());
        myTeacher.setTName(teacher.getTName());
        myTeacher.setGId(teacher.getGId());
        return teacherMapper.updateById(myTeacher);
    }

    @Override
    public Integer updateStudent(VStudent student) {
        User user = new User();
        user.setUId(student.getUId());
        user.setAccount(student.getSId());
        user.setPassword(student.getPassword());
        user.setRole(3);
        userMapper.updateById(user);
        VStudent myStudent = new VStudent();
        myStudent.setUId(student.getUId());
        myStudent.setSName(student.getSName());
        myStudent.setCId(student.getCId());
        return studentMapper.updateById(myStudent);
    }

    @Override
    public User getAdmin(Integer id) {
        return userMapper.selectById(id);
    }

    @Override
    public VTeacher getTeacher(Integer id) {
        return teacherMapper.selectById(id);
    }

    @Override
    public VStudent getStudent(Integer id) {
        return studentMapper.selectById(id);
    }

    @Override
    public Integer deleteUser(Integer id) {
        User user = userMapper.selectOne(new QueryWrapper<User>().eq("u_id", id));
        user.setState(-1);
        return userMapper.updateById(user);
    }
}
