package com.aaa.edu.service;

import com.aaa.edu.pojo.QueryInfo;
import com.aaa.edu.pojo.view.VStudent;
import com.aaa.edu.pojo.view.VTeacher;
import com.baomidou.mybatisplus.core.metadata.IPage;

public interface StudentService {
    IPage<VStudent> getAllStudents(QueryInfo info);
}
