package com.atguigu.mybatis.test;

import com.atguigu.mybatis.mapper.SelectMapper;
import com.atguigu.mybatis.pojo.User;
import com.atguigu.mybatis.utils.SqlSessionUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.sql.SQLOutput;
import java.util.List;
import java.util.Map;

public class SelectMapperTest {

    @Test
    public void testGetUserById(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        SelectMapper mapper = sqlSession.getMapper(SelectMapper.class);
        User user = mapper.getUserById(2);
        System.out.println(user);
    }

    @Test
    public void testGetAllUser(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        SelectMapper mapper = sqlSession.getMapper(SelectMapper.class);
        List<User> list = mapper.getAllUser();
        list.forEach(System.out::println);
    }

    @Test
    public void testGetCount(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        SelectMapper mapper = sqlSession.getMapper(SelectMapper.class);
        Integer count = mapper.getCount();
        System.out.println(count);
    }


    @Test
    public void testGetUserByIdToMap(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        SelectMapper mapper = sqlSession.getMapper(SelectMapper.class);
        Map<String, Object> objectMap = mapper.getUserByIdToMap(1);
        System.out.println(objectMap);
    }


    @Test
    public void testGetAllUserIdToMap(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        SelectMapper mapper = sqlSession.getMapper(SelectMapper.class);
//        List<Map<String , Object>> allUserToMap = mapper.getAllUserToMap();
        Map<String, Object> allUserToMap = mapper.getAllUserToMap();
        System.out.println(allUserToMap);
    }
}
