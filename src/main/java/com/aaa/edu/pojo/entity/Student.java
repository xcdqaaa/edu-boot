package com.aaa.edu.pojo.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName("t_student")
public class Student {
//    @TableId(value = "s_id")
    private String sId;
    @TableId
    private Integer uId;
    private String sName;
    private String sClass;
}
