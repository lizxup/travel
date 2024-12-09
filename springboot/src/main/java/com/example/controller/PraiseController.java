package com.example.controller;


import com.example.common.Result;
import com.example.entity.Praise;
import com.example.service.PraiseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/praise")
public class PraiseController {

    @Autowired
    private PraiseService praiseService;

    /**
     * 点赞或者取消点赞
     */
    @PostMapping("/add")
    public Result add(@RequestBody Praise praise){
        praiseService.add(praise);
        return Result.success();
    }
}
