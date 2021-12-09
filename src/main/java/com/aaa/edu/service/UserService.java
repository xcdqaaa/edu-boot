package com.aaa.edu.service;

import java.util.List;

public interface UserService {
    Integer login(String account, String password);

    String getToken(Integer uId);

    List<String> getRole(String rId);
}
