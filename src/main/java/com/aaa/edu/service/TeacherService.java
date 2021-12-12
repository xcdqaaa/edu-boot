package com.aaa.edu.service;

import com.aaa.edu.pojo.QueryInfo;
import com.aaa.edu.pojo.entity.TeacherInfo;
import com.aaa.edu.pojo.view.VTeacher;
import com.baomidou.mybatisplus.core.metadata.IPage;

public interface TeacherService {
    IPage<VTeacher> getAllTeachers(QueryInfo info,String college);

    TeacherInfo getTeacherInfo(Integer uId);
}
