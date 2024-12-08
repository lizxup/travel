package com.example.controller;


import com.example.common.Result;
import com.example.common.enums.RoleEnum;
import com.example.entity.Account;
import com.example.entity.User;
import com.example.service.AdminService;
import com.example.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
public class WebController {


    @Autowired
    private AdminService adminService;

    @Autowired
    private UserService userService;

    /**
     * 默认请求接口
     * @return
     */
    @GetMapping("/")
    public Result  hello(){
        return Result.success();
    }


    /**
     * 登录
     */
    @PostMapping("/login")
    public Result login(@RequestBody Account account) {
        log.info("登录:{}",account);
        Account loginAccount = null;
        if (RoleEnum.ADMIN.name().equals(account.getRole())) {
            loginAccount = adminService.login(account);
        }
        else if (RoleEnum.USER.name().equals(account.getRole())) {
            loginAccount = userService.login(account);
        }
        return Result.success(loginAccount);
    }

    /**
     * 注册
     * @param user
     * @return
     */
    @PostMapping("/register")
    public Result register(@RequestBody User user) {
        userService.add(user);
        return Result.success();
    }


    /**
     * 修改密码
     */
    @PutMapping("/updatePassword")
    public Result updatePassword(@RequestBody Account account) {
        if (RoleEnum.ADMIN.name().equals(account.getRole())) {
            adminService.updatePassword(account);
        }else if(RoleEnum.USER.name().equals(account.getRole())) {
            userService.updatePassword(account);
        }
        return Result.success();
    }

}
