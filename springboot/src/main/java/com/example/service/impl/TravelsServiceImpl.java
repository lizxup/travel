package com.example.service.impl;

import cn.hutool.core.date.DateUtil;
import com.example.common.enums.RoleEnum;
import com.example.entity.Account;
import com.example.entity.Travels;
import com.example.mapper.TravelsMapper;
import com.example.service.TravelsService;
import com.example.utils.TokenUtils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TravelsServiceImpl implements TravelsService {
    @Autowired
    private TravelsMapper travelsMapper;

    @Override
    public void add(Travels travels) {
        travels.setTime(DateUtil.now());
        travelsMapper.insert(travels);
    }

    @Override
    public void updateById(Travels travels) {
        travelsMapper.updateById(travels);
    }
    @Override
    public void deleteById(Integer id) {
        travelsMapper.deleteById(id);
    }
    @Override
    public void deleteBatch(List<Integer> ids) {
        for (Integer id : ids) {
            travelsMapper.deleteById(id);
        }
    }
    @Override
    public Travels selectById(Integer id) {
        return travelsMapper.selectById(id);
    }
    @Override
    public List<Travels> selectAll(Travels travels) {
        return travelsMapper.selectAll(travels);
    }
    @Override
    public PageInfo<Travels> selectPage(Travels travels, Integer pageNum, Integer pageSize) {
        Account currentUser = TokenUtils.getCurrentUser();
        if(RoleEnum.USER.name().equals(currentUser.getRole())){
            travels.setStatus("通过");
        }
        PageHelper.startPage(pageNum, pageSize);
        List<Travels> list = travelsMapper.selectAll(travels);
        return PageInfo.of(list);
    }
}
