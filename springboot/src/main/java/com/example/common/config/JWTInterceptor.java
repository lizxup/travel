package com.example.common.config;

import cn.hutool.core.util.ObjectUtil;
import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.example.common.Constants;
import com.example.common.enums.ResultCodeEnum;
import com.example.common.enums.RoleEnum;
import com.example.entity.Account;
import com.example.entity.Admin;
import com.example.exception.CustomException;
import com.example.service.AdminService;
import com.example.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

/**
 * JWT拦截器
 */
@Component
public class JWTInterceptor implements HandlerInterceptor {

    @Autowired
    private AdminService adminService;

    @Autowired
    private UserService userService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //1.从HTTP请求头中获得TOKEN
        String token = request.getHeader(Constants.TOKEN);
        //如果没有获得，去请求参数中尝试获取一次
        if(ObjectUtil.isNull(token)){
            request.getParameter(Constants.TOKEN);
        }
        //2.开始执行认证
        if(ObjectUtil.isNull(token) || token == ""){
            throw new CustomException(ResultCodeEnum.TOKEN_INVALID_ERROR);
        }
        Account account = null;
        try {
            String audience = JWT.decode(token).getAudience().get(0);
            String userId = audience.split("-")[0];
            String role = audience.split("-")[1];
            //根据用户额角色判断用户类型
            if(RoleEnum.ADMIN.name().equals(role)){
                account = adminService.selectById(Integer.valueOf(userId));
            }else if(RoleEnum.USER.name().equals(role)){
                account = userService.selectById(Integer.valueOf(userId));
            }
        }catch (CustomException e){
            throw new CustomException(ResultCodeEnum.TOKEN_CHECK_ERROR);
        }
        if(ObjectUtil.isNull(account)){
            //用户不存在
            throw new CustomException(ResultCodeEnum.USER_NOT_EXIST_ERROR);
        }
        try{
            //通过用户的密码作为密钥再次验证token的合法性
            JWTVerifier jwtVerifier = JWT.require(Algorithm.HMAC256(account.getPassword())).build();
            jwtVerifier.verify(token);
        }catch (JWTVerificationException e){
            throw new CustomException(ResultCodeEnum.TOKEN_CHECK_ERROR);
        }
        return true;
    }
}
