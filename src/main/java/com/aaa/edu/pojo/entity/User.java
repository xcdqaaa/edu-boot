package com.aaa.edu.pojo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName("t_user")
@ApiModel("用户")
public class User {
    @TableId(value = "u_id",type = IdType.AUTO)
    private Integer uId;
    private String account;
    private String password;
    private String head;
    private String email;
    private Integer role;
    private Integer state;
}
