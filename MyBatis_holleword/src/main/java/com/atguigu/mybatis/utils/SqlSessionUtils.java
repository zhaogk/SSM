package com.atguigu.mybatis.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class SqlSessionUtils {
    public static SqlSession getSqlSession(){
        SqlSession sqlSession =null;
        try {
            InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
            //获取sqlSessionFactoryBuilder对象
            SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
            SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(is);
            //获取sqlsession对象
            sqlSession  = sqlSessionFactory.openSession(true);

        } catch (IOException e) {
            e.printStackTrace();
        }
        return sqlSession;
    }
}
