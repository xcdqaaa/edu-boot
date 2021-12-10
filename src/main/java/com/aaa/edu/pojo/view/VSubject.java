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
@TableName("v_subject")
@ApiModel("v_subject")
public class VSubject {
    @TableId
    private String bId;
    private String bName;
    private Double bCrs;
    private String bCollege;
    private String bPeriod;
}
