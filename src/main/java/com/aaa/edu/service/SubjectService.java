package com.aaa.edu.service;

import com.aaa.edu.pojo.QueryInfo;
import com.aaa.edu.pojo.view.VSubject;
import com.aaa.edu.pojo.view.VTeacher;
import com.baomidou.mybatisplus.core.metadata.IPage;

public interface SubjectService {
    IPage<VSubject> getSubjects(QueryInfo info);
}
