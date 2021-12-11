package com.aaa.edu.mapper;

import com.aaa.edu.pojo.beans.BClass;
import com.aaa.edu.pojo.view.VLesson;
import com.aaa.edu.pojo.view.VTeacher;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface LessonMapper extends BaseMapper<VLesson> {

    IPage<VLesson> getLessons(IPage<VLesson> page, @Param("info") String info);

    IPage<VLesson> getLessonsByTId(IPage<VLesson> page, @Param("u_id") String tId);

    IPage<VLesson> getLessonsBySId(IPage<VLesson> page, @Param("u_id") String sId);

    IPage<VLesson> getReLessonsBySId(IPage<VLesson> page, @Param("u_id") String sId);

    IPage<VLesson> getSeLessonsBySId(IPage<VLesson> page, @Param("u_id") String sId);

    List<BClass> getLearn(@Param("l_id") String lId);

    List<VTeacher> getTeach(@Param("l_id") String lId);
}