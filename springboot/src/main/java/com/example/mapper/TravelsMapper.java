package com.example.mapper;

import com.example.entity.Travels;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface TravelsMapper {
    int insert(Travels travels);

    void updateById(Travels travels);

    void deleteById(Integer id);

    @Select("select * from `travels` where id = #{id}")
    Travels selectById(Integer id);

    List<Travels> selectAll(Travels travels);
}
