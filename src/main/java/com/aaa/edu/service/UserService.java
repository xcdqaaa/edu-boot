package com.aaa.edu.service;

public interface UserService {
    Integer login(String account, String password);

    String getToken(Integer uId);

    String getRole(String rId);
}
