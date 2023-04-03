package com.atguigu.mybatis.mapper;

import com.atguigu.mybatis.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SpecialSQLMapper {
    /**
     * 通过用户名字模糊查询
     * @param mohu
     * @return
     */
    List<User> getUserByLike(@Param("mohu") String mohu);

    /**
     * 批量删除
     * @param ids
     */
    void  deleteMoreUser(@Param("ids") String ids);

    /**
     * 动态设置表名
     * @param tableName
     * @return
     */
    List<User> getUserList(@Param("tableName") String tableName);

    void insertUser(User user);


}
