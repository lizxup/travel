package com.example.service;

import cn.hutool.core.date.DateUtil;
import com.example.entity.Comment;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface CommentService {
     
    public void add(Comment comment);

     
    public void updateById(Comment Comment);
     
    public void deleteById(Integer id);
    public void deleteBatch(List<Integer> ids) ;
     
    public Comment selectById(Integer id) ;
     
    public List<Comment> selectAll(Comment Comment);

    public Integer selectCount(Integer fid);
     
    public PageInfo<Comment> selectPage(Comment Comment, Integer pageNum, Integer pageSize);
}
