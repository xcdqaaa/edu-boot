package com.aaa.edu.service;

import com.aaa.edu.pojo.QueryInfo;
import com.aaa.edu.pojo.view.VLesson;
import com.aaa.edu.pojo.view.VSubject;
import com.baomidou.mybatisplus.core.metadata.IPage;

public interface LessonService {
    IPage<VLesson> getLessons(QueryInfo info,String term);

    IPage<VLesson> getLessonsByCId(QueryInfo info,String term);

    IPage<VLesson> getLessonsByTId(QueryInfo info,String term);
}
