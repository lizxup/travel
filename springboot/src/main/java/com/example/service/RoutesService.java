package com.example.service;
import com.example.entity.Routes;
import com.github.pagehelper.PageInfo;

import java.util.List;


public interface RoutesService {

    public void add(Routes routes);

    public void updateById(Routes routes);

    public void deleteById(Integer id);

    public void deleteBatch(List<Integer> ids);

    public Routes selectById(Integer id);

    public List<Routes> selectAll(Routes routes);

    public PageInfo<Routes> selectPage(Routes routes, Integer pageNum, Integer pageSize);
}
