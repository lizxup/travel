package com.example.service.impl;

import cn.hutool.core.date.DateUtil;
import com.example.entity.Article;
import com.example.mapper.ArticleMapper;
import com.example.service.ArticleService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ArticleServiceImpl implements ArticleService {
    @Autowired
    private ArticleMapper articleMapper;

    @Override
    public void add(Article article) {
        article.setDate(DateUtil.now());
        article.setReadCount(0);
        articleMapper.insert(article);
    }

    @Override
    public void updateById(Article article) {
        articleMapper.updateById(article);
    }
    @Override
    public void deleteById(Integer id) {
        articleMapper.deleteById(id);
    }
    @Override
    public void deleteBatch(List<Integer> ids) {
        for (Integer id : ids) {
            articleMapper.deleteById(id);
        }
    }
    @Override
    public Article selectById(Integer id) {
        return articleMapper.selectById(id);
    }
    @Override
    public List<Article> selectAll(Article article) {
        return articleMapper.selectAll(article);
    }
    @Override
    public PageInfo<Article> selectPage(Article article, Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<Article> list = articleMapper.selectAll(article);
        return PageInfo.of(list);
    }

    @Override
    public List<Article> selectRecommend() {
        List<Article> list = articleMapper.selectRecommend();
        return list;
    }
}
