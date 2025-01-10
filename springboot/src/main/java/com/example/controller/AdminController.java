package com.example.controller;
import com.example.common.Result;
import com.example.entity.Admin;
import com.example.service.impl.AdminServiceImpl;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * 前端请求接口
 */
@RestController
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private AdminServiceImpl adminService;


    /**
     * 新增
     * @param admin
     * @return
     */
    @PostMapping("/add")
    public Result add(@RequestBody Admin admin){
        adminService.add(admin);
        return Result.success();
    }


    /**
     * 修改
     * @param admin
     * @return
     */
    @PutMapping("/update")
    public Result update(@RequestBody Admin admin){
        adminService.updateById(admin);
        return Result.success();
    }

    /**
     * 单个删除
     * @param id
     * @return
     */
    @DeleteMapping("/delete/{id}")
    public Result delete(@PathVariable Integer id){
        adminService.deleteById(id);
        return Result.success();
    }

    /**
     * 批量删除
     * @param ids
     * @return
     */
    @DeleteMapping("/delete/batch")
    public Result deleteBatch(@RequestBody List<Integer> ids){
        adminService.deleteBatch(ids);
        return Result.success();
    }

    /**
     * 单个查询
     * @param id
     * @return
     */
    @GetMapping("/selectById{id}")
    public Result selectById(@PathVariable Integer id){
        Admin admin = adminService.selectById(id);
        return Result.success(admin);
    }


    /**
     * 查询所有
     * @param admin
     * @return
     */
    @GetMapping("/selectAll")
    public Result selectById(Admin admin){
        List<Admin> admins = adminService.selectAll(admin);
        return Result.success(admins);
    }


    /**
     * 分页查询
     * @param admin
     * @param pageNum
     * @param pageSize
     * @return
     */
    @GetMapping("/selectPage")
    public Result selectPage(Admin admin,
                             @RequestParam(defaultValue = "1") Integer pageNum,
                             @RequestParam(defaultValue = "10") Integer pageSize){
        PageInfo<Admin> pageInfo = adminService.selectPage(admin,pageNum , pageSize);
        return Result.success(pageInfo);
    }

}
