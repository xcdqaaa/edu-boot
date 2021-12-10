package com.aaa.edu.pojo.view;

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
    //    @TableId(value = "s_id")
    private String sId;
    @TableId
    private Integer uId;
    private String sName;
    private String sClass;
    private String sMajor;
    private String sCollege;
}
