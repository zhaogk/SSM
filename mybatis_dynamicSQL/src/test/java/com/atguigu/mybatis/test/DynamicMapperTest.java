package com.atguigu.mybatis.test;

import com.atguigu.mybatis.mapper.DynamicSQLMapper;
import com.atguigu.mybatis.pojo.Emp;
import com.atguigu.mybatis.utils.SqlSessionUtils;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DynamicMapperTest {

    @Test
    public   void  testGetEmpByCondition(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        DynamicSQLMapper mapper = sqlSession.getMapper(DynamicSQLMapper.class);
        Emp emp  =new Emp(null,"" ,22,"");
        List<Emp> list = mapper.getEmpByCondition(emp);
        list.forEach(System.out::println);
    }

    @Test
    public   void  testGetEmpByChoose(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        DynamicSQLMapper mapper = sqlSession.getMapper(DynamicSQLMapper.class);
        Emp emp  =new Emp(null,"张三" ,22,"");
        List<Emp> list = mapper.getEmpByChoose(emp);
        list.forEach(System.out::println);
    }

    @Test
    public   void  testInsertMoreEmp(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        DynamicSQLMapper mapper = sqlSession.getMapper(DynamicSQLMapper.class);
        Emp emp1  =new Emp(null,"张三1" ,21,"男");
        Emp emp2  =new Emp(null,"张三2" ,22,"男");
        Emp emp3  =new Emp(null,"张三3" ,23,"男");
        Emp emp4  =new Emp(null,"张三4" ,24,"男");
        List<Emp> emps = Arrays.asList(emp1, emp2, emp3, emp4);
        mapper.insertMoreEmp(emps);
    }

    @Test
    public   void  testDeleteMoreEmp(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        DynamicSQLMapper mapper = sqlSession.getMapper(DynamicSQLMapper.class);
       Integer[] empIds = new Integer[]{5,6};
       mapper.deleteMoreEmp(empIds);
    }
}
