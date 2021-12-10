package com.aaa.edu.pojo.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName("t_class")
@ApiModel("班级")
public class Class {
    @TableId(value = "c_id")
    private String cId;
    @ApiModelProperty("学科姓名")
    private String cName;
    private Integer cType;
    private String cTerm;
    private String mId;
}