package com.example.controller;
import com.example.common.Result;
import com.example.entity.User;
import com.example.service.impl.UserServiceImpl;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * 前端请求接口
 */
@RestController
@RequestMapping("/user")
public class UserCotroller {
    @Autowired
    private UserServiceImpl userService;


    /**
     * 新增
     * @param user
     * @return
     */
    @PostMapping("/add")
    public Result add(@RequestBody User user){
        userService.add(user);
        return Result.success();
    }


    /**
     * 修改
     * @param user
     * @return
     */
    @PutMapping("/update")
    public Result update(@RequestBody User user){
        userService.updateById(user);
        return Result.success();
    }

    /**
     * 单个删除
     * @param id
     * @return
     */
    @DeleteMapping("/delete/{id}")
    public Result delete(@PathVariable Integer id){
        userService.deleteById(id);
        return Result.success();
    }

    /**
     * 批量删除
     * @param ids
     * @return
     */
    @DeleteMapping("/delete/batch")
    public Result deleteBatch(@RequestBody List<Integer> ids){
        userService.deleteBatch(ids);
        return Result.success();
    }

    /**
     * 单个查询
     * @param id
     * @return
     */
    @GetMapping("/selectById{id}")
    public Result selectById(@PathVariable Integer id){
        User user = userService.selectById(id);
        return Result.success(user);
    }


    /**
     * 查询所有
     * @param user
     * @return
     */
    @GetMapping("/selectAll")
    public Result selectById(User user){
        List<User> users = userService.selectAll(user);
        return Result.success(users);
    }


    /**
     * 分页查询
     * @param user
     * @param pageNum
     * @param pageSize
     * @return
     */
    @GetMapping("/selectPage")
    public Result selectPage(User user,
                             @RequestParam(defaultValue = "1") Integer pageNum,
                             @RequestParam(defaultValue = "10") Integer pageSize){
        PageInfo<User> pageInfo = userService.selectPage(user,pageNum , pageSize);
        return Result.success(pageInfo);
    }

}
