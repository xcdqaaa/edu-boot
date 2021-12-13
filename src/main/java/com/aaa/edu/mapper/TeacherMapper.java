package com.aaa.edu.mapper;


import com.aaa.edu.pojo.entity.TeacherInfo;
import com.aaa.edu.pojo.view.VTeacher;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

public interface TeacherMapper extends BaseMapper<VTeacher> {

    TeacherInfo getTeacherInfo(Integer uid);
}
