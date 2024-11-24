package com.example.service;

import com.example.entity.Article;
import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * 业务层接口
 */

public interface ArticleService {
    public void add(Article article);

    public void updateById(Article article);

    public void deleteById(Integer id);

    public void deleteBatch(List<Integer> ids);

    public Article selectById(Integer id);

    public List<Article> selectAll(Article article);

    public PageInfo<Article> selectPage(Article article, Integer pageNum, Integer pageSize);

    List<Article> selectRecommend();
}
