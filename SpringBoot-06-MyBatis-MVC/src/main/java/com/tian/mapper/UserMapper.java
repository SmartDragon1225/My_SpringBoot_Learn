package com.tian.mapper;

import com.tian.pojo.User;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
@Mapper
public interface UserMapper {

    //分页查询全部用户
    @Select("select * from user")
    List<User> listAll();

    //根据id查询
    @Select("select * from user where id = #{id}")
    User selectById(@Param("id") int id);

    //添加用户
    @Insert("insert into user value (#{id},#{username},#{password})")
    int add(User user);

    //根据id删除用户
    @Delete("delete from user where id = #{id}")
    int delete(@Param("id") int id);

    //更新用户信息
    @Update("update user set username=#{username},password=#{password} where id = #{id}")
    int updata(User user);
}
