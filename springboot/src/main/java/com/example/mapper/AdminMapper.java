package com.example.mapper;
import com.example.entity.Admin;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface AdminMapper {


    int insert(Admin admin);


    List<Admin> selectAll(Admin admin);


    void updateById(Admin admin);

    @Delete("delete from admin where id = #{id}")
    void deleteById(Integer id);

    @Select("select * from admin where id = #{id}")
    Admin selectById(Integer id);

    @Select("select * from admin where username = #{username}")
    Admin selectByUsername( String username);
}
