package com.example.service;

import com.example.entity.Account;
import com.example.entity.Admin;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 业务层
 */

public interface AdminService {

    public void add(Admin admin);
    public Admin selectById(Integer id);

    public List<Admin> selectAll(Admin admin);

    PageInfo<Admin> selectPage(Admin admin , Integer pageNum, Integer pageSize);

    void updateById(Admin admin);

    void deleteById(Integer id);

    void deleteBatch(List<Integer> ids);

    Account login(Account account);

    void updatePassword(Account account);
}
