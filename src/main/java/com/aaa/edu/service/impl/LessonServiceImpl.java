package com.aaa.edu.service.impl;

import com.aaa.edu.mapper.LessonMapper;
import com.aaa.edu.mapper.SubjectMapper;
import com.aaa.edu.pojo.QueryInfo;
import com.aaa.edu.pojo.RespBean;
import com.aaa.edu.pojo.view.VLesson;
import com.aaa.edu.pojo.view.VSubject;
import com.aaa.edu.service.LessonService;
import com.aaa.edu.service.SubjectService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LessonServiceImpl implements LessonService {
    @Autowired
    LessonMapper lessonMapper;

    @Override
    public IPage<VLesson> getLessons(QueryInfo info,String term) {
        IPage<VLesson> iPage = new Page<>();
        iPage.setCurrent(info.getPageNumber());
        iPage.setSize(info.getPageSize());
        IPage<VLesson> page = lessonMapper.getLessons(iPage, info.getQuery(),term);

        page.getRecords().forEach(vLesson -> {
            vLesson.setLClasses(lessonMapper.getLearn(vLesson.getLId()));
            vLesson.setLTeachers(lessonMapper.getTeach(vLesson.getLId()));
        });

        return page;
    }

    @Override
    public IPage<VLesson> getLessonsByCId(QueryInfo info, String term) {
        return null;
    }

    @Override
    public IPage<VLesson> getLessonsByTId(QueryInfo info, String term) {
        return null;
    }
}
