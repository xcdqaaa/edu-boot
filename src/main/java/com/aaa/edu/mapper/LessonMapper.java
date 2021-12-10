package com.aaa.edu.mapper;

import com.aaa.edu.pojo.view.VLesson;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface LessonMapper extends BaseMapper<VLesson> {

    IPage<VLesson> getLessons(IPage<VLesson> page, @Param("info")String info);
}
