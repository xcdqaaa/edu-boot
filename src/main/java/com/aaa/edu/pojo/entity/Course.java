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
@TableName("t_course")
@ApiModel("学科")
public class Course {
    @TableId(value = "c_id")
    @ApiModelProperty("学科id")
    private String cId;
    @ApiModelProperty("学科姓名")
    private String cName;
    private Double crs;
    private String cTime;
}
