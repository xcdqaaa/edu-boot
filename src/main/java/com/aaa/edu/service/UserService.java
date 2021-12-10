package com.aaa.edu.service;

import com.aaa.edu.pojo.QueryInfo;
import com.aaa.edu.pojo.entity.User;
import com.baomidou.mybatisplus.core.metadata.IPage;

import java.util.List;

public interface UserService {
    Integer login(String account, String password);

    String getToken(Integer uId);

    List<String> getRole(String rId);

    IPage<User> getUsers(QueryInfo info,Integer role);
}
