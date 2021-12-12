package com.aaa.edu;

import com.aaa.edu.mapper.OptionListMapper;
import com.aaa.edu.pojo.beans.OClass;
import com.aaa.edu.pojo.beans.OCollege;
import com.aaa.edu.pojo.beans.OMajor;
import com.aaa.edu.pojo.beans.OPeriod;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class EduApplicationTests {
    @Autowired
    OptionListMapper optionListMapper;

    @Test
    void contextLoads() {
        List<OPeriod> periods = optionListMapper.getPeriods();
        periods.forEach(System.out::println);
        List<OCollege> colleges = optionListMapper.getColleges();
        colleges.forEach(System.out::println);
        List<OClass> classes = optionListMapper.getClasses();
        classes.forEach(System.out::println);
        List<OMajor> majorsByCollegeId = optionListMapper.getMajorsByCollegeId("1001");
        majorsByCollegeId.forEach(System.out::println);
    }

}
