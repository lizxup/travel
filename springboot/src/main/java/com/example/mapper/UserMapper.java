package com.example.mapper;

import com.example.entity.User;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface UserMapper {


    int insert(User user);


    List<User> selectAll(User user);


    void updateById(User user);

    @Delete("delete from user where id = #{id}")
    void deleteById(Integer id);

    @Select("select * from user where id = #{id}")
    User selectById(Integer id);

    @Select("select * from user where username = #{username}")
    User selectByUsername( String username);
}
