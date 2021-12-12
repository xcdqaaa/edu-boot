package com.aaa.edu.pojo;

import lombok.Data;

import java.util.List;

@Data
public class Cascader {
    private String value;
    private String label;
    private List<Cascader> children;
}
