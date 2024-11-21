package com.example.service;
import com.example.entity.Travels;
import com.github.pagehelper.PageInfo;

import java.util.List;


public interface TravelsService {

    public void add(Travels travels);

    public void updateById(Travels travels);

    public void deleteById(Integer id);

    public void deleteBatch(List<Integer> ids);

    public Travels selectById(Integer id);

    public List<Travels> selectAll(Travels travels);

    public PageInfo<Travels> selectPage(Travels travels, Integer pageNum, Integer pageSize);
}
