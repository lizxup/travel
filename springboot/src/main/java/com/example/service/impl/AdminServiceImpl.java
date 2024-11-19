package com.example.service.impl;
import cn.hutool.core.util.ObjectUtil;
import com.example.common.Constants;
import com.example.common.enums.ResultCodeEnum;
import com.example.common.enums.RoleEnum;
import com.example.entity.Account;
import com.example.entity.Admin;
import com.example.exception.CustomException;
import com.example.mapper.AdminMapper;
import com.example.service.AdminService;
import com.example.utils.TokenUtils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminMapper adminMapper;

    /**
     * 添加管理员
     * @param admin
     */
    @Override
    public void add(Admin admin){
        Admin dbAdmin = adminMapper.selectByUsername(admin.getUsername());
        if(ObjectUtil.isNotNull(dbAdmin)){
            throw new CustomException(ResultCodeEnum.USER_EXIST_ERROR);
        }
        if(ObjectUtil.isEmpty(admin.getPassword())){
            admin.setPassword(Constants.USER_DEFAULT_PASSWORD);
        }
        admin.setRole(RoleEnum.ADMIN.name());
        if(ObjectUtil.isEmpty(admin.getName())){
            admin.setName(admin.getUsername());
        }
        adminMapper.insert(admin);
    }

    /**
     * 分页查询
     * @param pageNum
     * @param pageSize
     * @return
     */


    @Override
    public void updateById(Admin admin) {
        adminMapper.updateById(admin);
    }

    @Override
    public void deleteById(Integer id) {
        adminMapper.deleteById(id);
    }

    @Override
    public void deleteBatch(List<Integer> ids) {
        for(Integer id : ids){
            deleteById(id);
        }
    }
    @Override
    public Admin selectById(Integer id) {
        return adminMapper.selectById(id);
    }

    @Override
    public List<Admin> selectAll(Admin admin) {

        //selectAll 包含了条件查询
        List<Admin> list = adminMapper.selectAll(admin);
        return list;
    }

    @Override
    public PageInfo<Admin> selectPage(Admin admin ,Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<Admin> list = this.selectAll(admin);
        return PageInfo.of(list);
    }

    @Override
    public Account login(Account account) {
        Admin dbAdmin = adminMapper.selectByUsername(account.getUsername());
        if (ObjectUtil.isNull(dbAdmin)) {
            throw new CustomException(ResultCodeEnum.USER_NOT_EXIST_ERROR);
        }
        if (!dbAdmin.getPassword().equals(account.getPassword())) {
            throw new CustomException(ResultCodeEnum.USER_ACCOUNT_ERROR);
        }
        // Create token
        String token = TokenUtils.createToken(dbAdmin.getId().toString() + "-" + dbAdmin.getRole(), dbAdmin.getPassword());
        dbAdmin.setToken(token);
        return dbAdmin;
    }
}
