package com.aaa.edu.mapper;


import com.aaa.edu.pojo.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMapper extends BaseMapper<User> {
    User getUserByMessage(@Param("account") String account,
                          @Param("password") String password);

    Integer setUserState(@Param("u_id") Integer id, @Param("state") Integer state);
}
