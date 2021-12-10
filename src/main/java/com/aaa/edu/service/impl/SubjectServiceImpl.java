package com.aaa.edu.service.impl;

import com.aaa.edu.mapper.StudentMapper;
import com.aaa.edu.mapper.SubjectMapper;
import com.aaa.edu.pojo.QueryInfo;
import com.aaa.edu.pojo.view.VStudent;
import com.aaa.edu.pojo.view.VSubject;
import com.aaa.edu.pojo.view.VTeacher;
import com.aaa.edu.service.SubjectService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SubjectServiceImpl implements SubjectService {
    @Autowired
    SubjectMapper subjectMapper;
    @Override
    public IPage<VSubject> getSubjects(QueryInfo info) {
        IPage<VSubject> iPage = new Page<>();
        iPage.setCurrent(info.getPageNumber());
        iPage.setSize(info.getPageSize());
        QueryWrapper<VSubject> wrapper = new QueryWrapper<>();
        wrapper.like("b_name",info.getQuery());

        return subjectMapper.selectPage(iPage, wrapper);


    }
}
