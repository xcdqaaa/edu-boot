package com.aaa.edu.controller;

import com.aaa.edu.pojo.QueryInfo;
import com.aaa.edu.pojo.RespBean;
import com.aaa.edu.pojo.view.VLesson;
import com.aaa.edu.pojo.view.VSubject;
import com.aaa.edu.service.LessonService;
import com.aaa.edu.service.SubjectService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LessonController {
    @Autowired
    LessonService lessonService;

    @PostMapping("course/lessons")
    public RespBean getLessons(@RequestBody QueryInfo info) {
        IPage<VLesson> page = lessonService.getLessons(info);
        if(page!=null){
            return RespBean.success(null, page);
        }
        return RespBean.error("列表查询失败");
    }
}
