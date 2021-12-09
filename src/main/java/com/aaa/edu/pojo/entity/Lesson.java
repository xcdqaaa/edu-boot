package com.aaa.edu.pojo.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName("t_lesson")
public class Lesson {
    @TableId(value = "l_id")
    private String lId;
    private String cId;
    private Date lDate;
    private String lPlace;
    private String lTime;
}
