package com.example.service.impl;

import com.example.entity.Praise;
import com.example.mapper.PraiseMapper;
import com.example.service.PraiseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class PraiseServiceImpl implements PraiseService {

    @Autowired
    private PraiseMapper praiseMapper;
    @Override
    public void add(Praise praise) {
        Praise dbPraise = praiseMapper.seleteByFidAndUserId(praise.getFid(),praise.getUserId());

        //点过赞了
        if(dbPraise != null){
//            取消点赞
            praiseMapper.deleteByFidAndUserId(praise.getFid(),praise.getUserId());
        }

        //点赞
        else{
            praiseMapper.insert(praise);
        }
    }
}
