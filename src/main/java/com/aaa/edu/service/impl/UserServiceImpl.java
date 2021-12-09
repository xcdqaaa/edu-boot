package com.aaa.edu.service.impl;

import com.aaa.edu.mapper.UserMapper;
import com.aaa.edu.pojo.entity.User;
import com.aaa.edu.service.UserService;
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
        String token = user.getAccount()+","+user.getRole();
        return token;
    }

    @Override
    public List<String> getRole(String rId) {
        String rFlag = "";
        if("1".equals(rId)) rFlag = "admin";
        else if("2".equals(rId)) rFlag = "teacher";
        else if("3".equals(rId)) rFlag = "student";
        return Arrays.asList(rFlag);
    }
}
