package com.example.service;

import com.example.entity.Account;
import com.example.entity.User;
import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * 业务层
 */

public interface UserService {

    public void add(User user);
    public User selectById(Integer id);

    public List<User> selectAll(User user);

    PageInfo<User> selectPage(User user , Integer pageNum, Integer pageSize);

    void updateById(User user);

    void deleteById(Integer id);

    void deleteBatch(List<Integer> ids);

    Account login(Account account);

    void updatePassword(Account account);
}
