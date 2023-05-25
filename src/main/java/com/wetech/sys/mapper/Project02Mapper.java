package com.wetech.sys.mapper;
import com.wetech.sys.entity.Project02;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.data.repository.query.Param;

import java.util.List;
//
//@Mapper
//public interface Project02Mapper {
//@Select("SELECT * FROM project02")
//List<Project02> selectAll();
//}
@Mapper
public interface Project02Mapper {
  @Select("SELECT * FROM project02 WHERE username = #{username} AND password = #{password}")
    Project02 selectByUsernameAndPassword(@Param("username") String username, @Param("password") String password);
  @Select("SELECT * FROM project02")
    List<Project02> selectAll();
}