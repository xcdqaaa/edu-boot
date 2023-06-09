package com.aaa.edu.pojo.view;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName("v_student")
public class VStudent {
    private String sId;
    @TableId
    private Integer uId;
    private String sName;
    private String sClass;
    private String sMajor;
    private String sCollege;
    private String cId;
    @TableField(exist = false)
    private String password;
}
