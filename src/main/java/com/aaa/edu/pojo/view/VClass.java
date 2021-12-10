package com.aaa.edu.pojo.view;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName("v_class")
@ApiModel("v_class")
public class VClass {
    @TableId
    private String cId;
    private String cName;
    private Integer cType;
    private String bCollege;
    private String bPeriod;
}
