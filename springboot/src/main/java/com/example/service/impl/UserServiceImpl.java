package com.example.service.impl;
import cn.hutool.core.util.ObjectUtil;
import com.example.common.Constants;
import com.example.common.enums.ResultCodeEnum;
import com.example.common.enums.RoleEnum;
import com.example.entity.Account;
import com.example.entity.User;
import com.example.exception.CustomException;
import com.example.mapper.UserMapper;
import com.example.service.UserService;
import com.example.utils.TokenUtils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    /**
     * 添加管理员
     * @param user
     */
    @Override
    public void add(User user){
        User dbUser = userMapper.selectByUsername(user.getUsername());
        if(ObjectUtil.isNotNull(dbUser)){
            throw new CustomException(ResultCodeEnum.USER_EXIST_ERROR);
        }
        if(ObjectUtil.isEmpty(user.getPassword())){
            user.setPassword(Constants.USER_DEFAULT_PASSWORD);
        }
        user.setRole(RoleEnum.USER.name());
        if(ObjectUtil.isEmpty(user.getName())){
            user.setName(user.getUsername());
        }
        userMapper.insert(user);
    }

    /**
     * 分页查询
     * @param pageNum
     * @param pageSize
     * @return
     */


    @Override
    public void updateById(User user) {
        userMapper.updateById(user);
    }

    @Override
    public void deleteById(Integer id) {
        userMapper.deleteById(id);
    }

    @Override
    public void deleteBatch(List<Integer> ids) {
        for(Integer id : ids){
            deleteById(id);
        }
    }
    @Override
    public User selectById(Integer id) {
        return userMapper.selectById(id);
    }

    @Override
    public List<User> selectAll(User user) {

        //selectAll 包含了条件查询
        List<User> list = userMapper.selectAll(user);
        return list;
    }

    @Override
    public PageInfo<User> selectPage(User user ,Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<User> list = this.selectAll(user);
        return PageInfo.of(list);
    }

    @Override
    public Account login(Account account) {
        User dbUser = userMapper.selectByUsername(account.getUsername());
        if (ObjectUtil.isNull(dbUser)) {
            throw new CustomException(ResultCodeEnum.USER_NOT_EXIST_ERROR);
        }
        if (!dbUser.getPassword().equals(account.getPassword())) {
            throw new CustomException(ResultCodeEnum.USER_ACCOUNT_ERROR);
        }
        // Create token
        String token = TokenUtils.createToken(dbUser.getId().toString() + "-" + dbUser.getRole(), dbUser.getPassword());
        dbUser.setToken(token);
        return dbUser;
    }

    @Override
    public void updatePassword(Account account) {
        User dbUser = userMapper.selectByUsername(account.getUsername());
        if (ObjectUtil.isNull(dbUser)) {
            throw new CustomException(ResultCodeEnum.USER_NOT_EXIST_ERROR);
        }
        if (!account.getPassword().equals(dbUser.getPassword())) {
            throw new CustomException(ResultCodeEnum.PARAM_PASSWORD_ERROR);
        }
        dbUser.setPassword(account.getNewPassword());
        userMapper.updateById(dbUser);
    }
}
