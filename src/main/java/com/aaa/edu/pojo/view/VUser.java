package com.aaa.edu.pojo.view;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class VUser {
    private String account;
    private String password;
    private String name;
    private Integer perm;
}
