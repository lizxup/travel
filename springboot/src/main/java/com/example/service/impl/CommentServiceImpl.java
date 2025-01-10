package com.example.service.impl;

import cn.hutool.core.date.DateUtil;
import com.example.entity.Account;
import com.example.entity.Comment;
import com.example.mapper.CommentMapper;
import com.example.service.CommentService;
import com.example.service.CommentService;
import com.example.utils.TokenUtils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {
    @Autowired
    private CommentMapper commentMapper;

    @Override
    public void add(Comment comment) {
        comment.setTime(DateUtil.now());
        Account currentUser = TokenUtils.getCurrentUser();
        comment.setUserId(currentUser.getId());
        commentMapper.insert(comment);
    }

    @Override
    public void updateById(Comment comment) {
        commentMapper.updateById(comment);
    }
    @Override
    public void deleteById(Integer id) {
        commentMapper.deleteById(id);
    }
    @Override
    public void deleteBatch(List<Integer> ids) {
        for (Integer id : ids) {
            commentMapper.deleteById(id);
        }
    }
    @Override
    public Comment selectById(Integer id) {
        return commentMapper.selectById(id);
    }
    @Override
    public List<Comment> selectAll(Comment comment) {
        return commentMapper.selectAll(comment);
    }

    @Override
    public Integer selectCount(Integer fid) {
        return commentMapper.selectCount(fid);

    }

    @Override
    public PageInfo<Comment> selectPage(Comment comment, Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<Comment> list = commentMapper.selectAll(comment);
        return PageInfo.of(list);
    }
}
