package com.aaa.edu.controller;

import com.aaa.edu.pojo.QueryInfo;
import com.aaa.edu.pojo.RespBean;
import com.aaa.edu.pojo.view.VStudent;
import com.aaa.edu.pojo.view.VSubject;
import com.aaa.edu.service.StudentService;
import com.aaa.edu.service.SubjectService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SubjectController {
    @Autowired
    SubjectService subjectService;

    @PostMapping("course/subjects")
    public RespBean getSubjects(@RequestBody QueryInfo info) {
        IPage<VSubject> page = subjectService.getSubjects(info);
        if(page!=null){
            return RespBean.success(null, page);
        }
        return RespBean.error("列表查询失败");
    }
}
