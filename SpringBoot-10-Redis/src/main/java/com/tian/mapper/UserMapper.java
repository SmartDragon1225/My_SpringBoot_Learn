package com.tian.mapper;

import com.tian.pojo.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface UserMapper {

    @Select("select * from user")
    List<User> listAll();

    @Select("select * from user where id = #{id}")
    User selectById(int id);

    @Insert("insert into user value(id,username,password)")
    int add(User user);

    @Update("update user set username=#{username},password=#{passsword} where id=#{id}")
    int update(User user);

    @Delete("delete from user where id=#{id}")
    int delete(int id);
}
