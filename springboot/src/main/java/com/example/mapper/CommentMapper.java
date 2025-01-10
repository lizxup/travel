package com.example.mapper;

import com.example.entity.Admin;
import com.example.entity.Comment;
import com.example.entity.Comment;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface CommentMapper {

    int insert(Comment comment);

    void updateById(Comment comment);

    void deleteById(Integer id);

    Comment selectById(Integer id);

    List<Comment> selectAll(Comment comment);

    @Select("SELECT COUNT(*) FROM comment WHERE fid = #{fid}")
    Integer selectCount(Integer fid);


}
