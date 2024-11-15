package com.example.controller;

import com.example.common.Result;
import com.example.entity.Admin;
import com.example.service.AdminService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin")
public class AdminCotroller {


    @Resource
    private AdminService amdminService;

    @PostMapping("/add")
    public Result add(@RequestBody Admin admin){
        amdminService.add(admin);

        return Result.success();
    }
}
