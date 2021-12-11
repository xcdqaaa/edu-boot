package com.aaa.edu.service.impl;

import com.aaa.edu.mapper.UserMapper;
import com.aaa.edu.pojo.QueryInfo;
import com.aaa.edu.pojo.entity.User;
import com.aaa.edu.service.UserService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;
    @Override
    public Integer login(String account, String password) {
        User userByMessage = userMapper.getUserByMessage(account, password);
        if(userByMessage!=null)
            return userByMessage.getUId();
        return null;
    }
    @Override
    public String getToken(Integer uId){
        User user = userMapper.selectById(uId);
        String token = user.getUId()+","+getRole(user.getRole()+"")+","+user.getAvatar();
        return token;
    }

    @Override
    public String getRole(String rId) {
        String rFlag = "";
        if("1".equals(rId)) rFlag = "admin";
        else if("2".equals(rId)) rFlag = "teacher";
        else if("3".equals(rId)) rFlag = "student";
        return rFlag;
    }

    @Override
    public IPage<User> getUsers(QueryInfo info,Integer role) {
        IPage<User> userIPage = new Page<>();
        userIPage.setCurrent(info.getPageNumber());
        userIPage.setSize(info.getPageSize());
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.like("account",info.getQuery()).eq("state",1).eq("role",role);
        return userMapper.selectPage(userIPage, wrapper);
    }
}
