package com.atguigu.mybatis.test;

import com.atguigu.mybatis.mapper.UserMapper;
import com.atguigu.mybatis.pojo.User;
import com.atguigu.mybatis.utils.SqlSessionUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.sql.SQLOutput;

public class ParameterTest {

    @Test
    public void testGetUserByUsername(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = mapper.getUserByUsername("dome");
        System.out.println(user);
    }

    @Test
    public void testcheckLogin(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User root = mapper.chekLogin("dome", "123456");
        System.out.println(root);
    }

}
