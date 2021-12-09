package com.aaa.edu.pojo.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName("t_teacher")
public class Teacher {

    @ApiModelProperty("tid")
    private String tId;
    @TableId
    private Integer uId;
    private String tName;
    private String tCollege;
}
