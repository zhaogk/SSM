package com.atguigu.mybatis.test;

import com.atguigu.mybatis.mapper.EmpMapper;
import com.atguigu.mybatis.pojo.Emp;
import com.atguigu.mybatis.utils.SqlSessionUtils;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class PageTest {

    @Test
    public void testPage() {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);
        //        查询功能之前开启分页功能
        Page<Object> page = PageHelper.startPage(1, 4);
        List<Emp> emps = mapper.selectByExample(null);
        emps.forEach(System.out::println);
        System.out.println(page);
    }
}
