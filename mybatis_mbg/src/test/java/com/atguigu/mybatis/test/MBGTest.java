package com.atguigu.mybatis.test;

import com.atguigu.mybatis.mapper.EmpMapper;
import com.atguigu.mybatis.pojo.Emp;
import com.atguigu.mybatis.pojo.EmpExample;
import com.atguigu.mybatis.utils.SqlSessionUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class MBGTest {

    @Test
    public  void testMBG(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);
//        Emp emp = mapper.selectByPrimaryKey(1);
//        System.out.println(emp);

//        EmpExample example = new EmpExample();
//        example.createCriteria().andEmpNameEqualTo("张三").andAgeGreaterThanOrEqualTo(20);
//        example.or().andGenderEqualTo("男");
//        List<Emp> emps = mapper.selectByExample(example);
//        emps.forEach(System.out::println);
//        测试普通修改功能
        Emp emp = new Emp(1,"小黑",null,"女");
//        mapper.updateByPrimaryKey(emp);
//        测试选择性修改
        mapper.updateByPrimaryKeySelective(emp);
    }
}
