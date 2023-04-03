package com.atguigu.mybatis.mapper;

import com.atguigu.mybatis.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.Map;

/**
 * #{}的本质就是占位符赋值，${}的本质就是字符串拼接  所以要加单引号
 * 1.mapper接口的犯法的参数为单一的字面类型
 * 此时可以通过#{}，${}任意内容获取参数值，
 * 2.mapper接口方法的参数为多个字面量类型
 * 此时mybatis会将参数放在map集合里面，以两种方式储存数据
 *(1).以arg0，arg1...为map集合的键，以参数为值
 *（2）。以param1，param2.。。为键，以参数为值
 *只需要通过#{}和${}访问map集合的键，就可以获取相对应的值
 *3.若mapper接口的方法参数为map集合类型的参数
 * 只需要通过#{}和${}访问map集合的键，就可以获取相对应的值
 *4.若mapper接口的方法的参数类型为实体类类型的参数
 * 只需要通过#{}与${}访问实体类的属性名(属性名只跟get与set方法有关，与成员变量无关)，就可以获取相对应的属性值
 *5.可以在mapper接口方法的参数上设置@param注解
 * 此时mybatis会将这些参数放在map中，一两种方式进行存储
 * （1）.以@param注解的value属性值为键
 * （2）.以param1，2为键，以参数为值
 *只需要通过#{}与${}访问实体类的属性名(属性名只跟get与set方法有关，与成员变量无关)，就可以获取相对应的属性值
 */


public interface UserMapper {
    /**
     *
     * @param username
     * @return
     */
    User getUserByUsername(String username);

    /**
     * 验证登录
     * @param username
     * @param password
     * @return
     */
    User chekLogin(String username,String password);

    /**
     *验证登录（以map集合为参数）
     * @param map
     * @return
     */
    User chekLoginByMap(Map<String,Object> map);

    /**
     * 添加用户信息
     * @param user
     */
    void insertUser(User user);

    /**
     * 验证登录使用注解
     * @param username
     * @param password
     * @return
     */
    User checkLoginByParam(@Param("username") String username, @Param("password") String password);
}
