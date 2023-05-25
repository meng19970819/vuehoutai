package com.wetech.sys.mapper;

import com.wetech.sys.entity.Project02;
import com.wetech.sys.entity.Project02user;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.data.repository.query.Param;

import java.util.List;

@Mapper
public interface Project02userMapper{
    @Select("SELECT * FROM project02user WHERE usersname = #{usersname} AND userspassword = #{userspassword}")
    Project02user selectBy(@Param("usersname")String usersname,@Param("userspassword")String userspassword);
    @Select("SELECT * FROM project02user")
    List<Project02user> userselectAll();
}
