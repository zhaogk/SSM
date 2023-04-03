package com.atguigu.mybatis.test;

import com.atguigu.mybatis.mapper.SelectMapper;
import com.atguigu.mybatis.mapper.SpecialSQLMapper;
import com.atguigu.mybatis.pojo.User;
import com.atguigu.mybatis.utils.SqlSessionUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class SpecialSQLMapperTest {
    @Test
    public void testGetUserByLike(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        SpecialSQLMapper mapper = sqlSession.getMapper(SpecialSQLMapper.class);
        List<User> list = mapper.getUserByLike("oo");
        list.forEach(System.out::println);
    }

    @Test
    public void testDeleteMoreUser(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        SpecialSQLMapper mapper = sqlSession.getMapper(SpecialSQLMapper.class);
       mapper.deleteMoreUser("9,10");
    }


    @Test
    public void testGetUserList(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        SpecialSQLMapper mapper = sqlSession.getMapper(SpecialSQLMapper.class);
        List<User> list = mapper.getUserList("t_user");
        list.forEach(System.out::println);
    }


    @Test
    public void testInsertUser(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        SpecialSQLMapper mapper = sqlSession.getMapper(SpecialSQLMapper.class);
        User  user = new User(null,"root","1234",22,"男","12131@qqq.com");
        mapper.insertUser(user);
        System.out.println(user);
    }
}
