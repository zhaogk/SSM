package com.atguigu.mybatis.mapper;

import com.atguigu.mybatis.pojo.User;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface SelectMapper {
    /**
     * 根据id查询用户信息
     * @param id
     * @return
     */
    User getUserById(@Param("id") Integer id);

    /**
     * 查询所有的用户信息
     * @return
     */
    List<User>  getAllUser();

    /**
     * 查询用户总数
     * @return
     */
    Integer getCount();

    /**
     * 根据用户id查询为map集合
     * @param id
     * @return
     */
    Map<String,Object> getUserByIdToMap(@Param("id") Integer id);

    /**
     * 查询所有的用户信息
     * @return
     */
//    List<Map<String,Object>> getAllUserToMap();

    /**
     * 可以将每条数据转化的map集合放在一个大的map中，但是必须要通过@mapkey注解
     * 将查询的某个字段的值作为map的键
     * @return
     */
    @MapKey("id")
   Map<String,Object> getAllUserToMap();

}
