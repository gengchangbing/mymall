package com.atguigu.gmall.gmall_user_manage.mapper;

import com.atguigu.gmall.bean.UserInfo;
import tk.mybatis.mapper.common.Mapper;

public interface UserInfoMapper extends Mapper<UserInfo> {
    void insertSelective(UserInfo userInfo);
}
