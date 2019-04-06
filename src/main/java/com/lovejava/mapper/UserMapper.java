package com.lovejava.mapper;


import com.lovejava.domain.Role;
import com.lovejava.domain.User;

import java.util.List;

/**
 * @author:tianyao
 * @date:2019-04-04 14:35
 */
public interface UserMapper {
    /**
     * 查询用户信息
     */
    List<User> findUserByAddr(String s);
    /**
     * 查询用户信息，传入User对象
     */
    List<User> findUser(User user);
    /**
     * 传入参数是List集合类型
     */
    List<User> findByRang(List<Integer> list);
    /**
     * 用户角度1对多查询
     */
    List<User> findUserDemo(Integer id);
    /**
     * 延迟查询
     */
    List<User> getUserByUserId(Integer i);
}
