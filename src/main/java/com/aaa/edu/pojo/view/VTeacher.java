package com.aaa.edu.pojo.view;

import com.baomidou.mybatisplus.annotation.TableField;
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
@TableName("v_teacher")
@ApiModel("VTeacher")
public class VTeacher {

    @ApiModelProperty("t_id")
    private String tId;
    @TableId
    private Integer uId;
    private String tName;
    private String tCollege;
    private String gId;
    @TableField(exist = false)
    private String password;
}