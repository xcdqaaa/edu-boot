package com.aaa.edu.service;

import com.aaa.edu.pojo.QueryInfo;
import com.aaa.edu.pojo.entity.StudentInfo;
import com.aaa.edu.pojo.view.VStudent;
import com.baomidou.mybatisplus.core.metadata.IPage;

public interface StudentService {
    IPage<VStudent> getAllStudents(QueryInfo info, String cId);

    StudentInfo getStudentInfo(Integer uId);
}
