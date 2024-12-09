package com.example.service.impl;

import cn.hutool.core.date.DateUtil;
import com.example.common.enums.RoleEnum;
import com.example.entity.Account;
import com.example.entity.Travels;
import com.example.mapper.PraiseMapper;
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

    @Autowired
    private PraiseMapper praiseMapper;

    @Override
    public void add(Travels travels) {
        travels.setReadCount(0);
        travels.setTime(DateUtil.now());
        travels.setStatus("待审核");
        Account account = TokenUtils.getCurrentUser();
        travels.setUserId(account.getId());
        travelsMapper.insert(travels);
    }

    @Override
    public void updateById(Travels travels) {
        Account currentUser = TokenUtils.getCurrentUser();
        //用户编辑游记的时候才会更新游记状态设置为待审核
        if(RoleEnum.USER.name().equals(currentUser.getRole())){
            travels.setStatus("待审核");
        }
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
        Travels travels = travelsMapper.selectById(id);
        setTravelData(travels);
        return travels;
    }
    @Override
    public List<Travels> selectAll(Travels travels) {
        return travelsMapper.selectAll(travels);
    }


    /**
     * 游记所有者可见
     * @param travels
     * @param pageNum
     * @param pageSize
     * @return
     */
    @Override
    public PageInfo<Travels> selectPage(Travels travels, Integer pageNum, Integer pageSize) {
        Account currentUser = TokenUtils.getCurrentUser();
        if(RoleEnum.USER.name().equals(currentUser.getRole())){
            travels.setUserId(currentUser.getId());
        }
        PageHelper.startPage(pageNum, pageSize);
        List<Travels> list = travelsMapper.selectAll(travels);
        return PageInfo.of(list);
    }

    /**
     * 所有用户可见的游记
     * @param travels
     * @param pageNum
     * @param pageSize
     * @return
     */
    @Override
    public PageInfo<Travels> selectFrontPage(Travels travels, Integer pageNum, Integer pageSize) {
        travels.setStatus("通过");
        PageHelper.startPage(pageNum, pageSize);
        List<Travels> list = travelsMapper.selectAll(travels);
        for(Travels t:list){
            setTravelData(t);
        }
        return PageInfo.of(list);
    }

    @Override
    public void updateReadCount(Integer id) {
        travelsMapper.updateReadCount(id);
    }

    private void setTravelData(Travels travels){
        travels.setPraiseCount(praiseMapper.selectCount(travels.getId()));
    }
}
