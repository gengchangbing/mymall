package com.atguigu.gmall.gmall_user_manage.service.impl;

import com.atguigu.gmall.bean.UserInfo;
import com.atguigu.gmall.gmall_user_manage.mapper.UserInfoMapper;
import com.atguigu.gmall.service.UserManageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

@Service

public class UserManageServiceImpl implements UserManageService {
    @Autowired
    UserInfoMapper userInfoMapper;

    @Override
    public List<UserInfo> getUserImfolistAll() {
        return userInfoMapper.selectAll();
    }

    @Override
    public void addUser(UserInfo userInfo) {

        userInfoMapper.insertSelective(userInfo);
    }

    @Override
    public void updateUser(UserInfo userInfo) {
      userInfoMapper.updateByPrimaryKeySelective(userInfo);
    }

    @Override
    public void updateUserByName(String name, UserInfo userInfo) {
        Example example=new Example(UserInfo.class);
        example.createCriteria().andEqualTo("name",name);
        userInfoMapper.updateByExample(userInfo,example);
    }

    @Override
    public void delUser(String id) {
      userInfoMapper.deleteByPrimaryKey(id);
    }

    @Override
    public UserInfo getuserInfo(String id) {
        UserInfo userInfo = userInfoMapper.selectByPrimaryKey(id);
        return userInfo;
    }
}
