package com.atguigu.mybatis.mapper;

import com.atguigu.mybatis.pojo.User;

/**
 * #{}的本质就是占位符赋值，${}的本质就是字符串拼接  所以要加单引号
 * 1.mapper接口的犯法的参数为单一的字面类型
 * 此时可以通过#{}，${}任意内容获取参数值，
 * 2.mapper接口方法的参数为多个字面量类型
 * 此时mybatis会将参数放在map集合里面，以两种方式储存数据
 *(1).以arg0，arg1...为map集合的键，以参数为值
 *（2）。以param1，param2.。。为键，以参数为值
 *只需要通过#{}和${}访问map集合的键，就可以获取相对应的值
 *
 */


public interface UserMapper {
    /**
     *
     * @param username
     * @return
     */
    User getUserByUsername(String username);
    User chekLogin(String username,String password);
}
