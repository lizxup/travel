package com.example.service.impl;

import cn.hutool.core.date.DateUtil;
import com.example.entity.Routes;
import com.example.mapper.RoutesMapper;
import com.example.service.RoutesService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class RoutesServiceImpl implements RoutesService {
    @Autowired
    private RoutesMapper routesMapper;

    @Override
    public void add(Routes routes) {
        routesMapper.insert(routes);
    }

    @Override
    public void updateById(Routes routes) {
        routesMapper.updateById(routes);
    }
    @Override
    public void deleteById(Integer id) {
        routesMapper.deleteById(id);
    }
    @Override
    public void deleteBatch(List<Integer> ids) {
        for (Integer id : ids) {
            routesMapper.deleteById(id);
        }
    }
    @Override
    public Routes selectById(Integer id) {
        return routesMapper.selectById(id);
    }
    @Override
    public List<Routes> selectAll(Routes routes) {
        return routesMapper.selectAll(routes);
    }
    @Override
    public PageInfo<Routes> selectPage(Routes routes, Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<Routes> list = routesMapper.selectAll(routes);
        return PageInfo.of(list);
    }
}
