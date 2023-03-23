package com.atguigu.mybatis.mapper;

import com.atguigu.mybatis.pojo.User;

import java.util.List;

public interface UserMapper {
    //添加
    int insertUser();
    //修改
    void updateUser();
    //删除
    void deleteUser();
    //查询
    User getUserById();

    List<User> getAllUser();

}
