package com.lovejava;

import com.lovejava.domain.User;
import com.lovejava.mapper.UserMapper;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * @author:tianyao
 * @date:2019-04-04 14:40
 */
public class DemoTest {
    private InputStream is;
    private SqlSession sqlSession;
    private UserMapper mapper;

    @Before
    public void before() {
        try {
            //将主配值文件加载成流
            is = Resources.getResourceAsStream("SqlMapConfig.xml");
            //创建工厂
            SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
            SqlSessionFactory build = sqlSessionFactoryBuilder.build(is);
            //创建自动提交事务的sqlsession对象
            sqlSession = build.openSession(true);
            //创建dialing对象
            mapper = sqlSession.getMapper(UserMapper.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @After
    public void after() {
        try {
            is.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        sqlSession.close();
    }

    /**
     * 通过地址查询用户
     */
    @Test
    public void findUserByAddr() {
        String s = "向往太阳";
        List<User> users = mapper.findUserByAddr(s);
        System.out.println(users);
    }

    /**
     * 通过不确定的User对象查询对象
     */
    @Test
    public void findUser() {
        User user = new User();
        user.setSex("男");
        /*user.setAddress("祭祀场");*/
        List<User> user1 = mapper.findUser(user);
        System.out.println(user1);
    }

    /**
     * 参数是集合的查询方法
     */
    @Test
    public void findByRang() {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        List<User> users = mapper.findByRang(list);
        System.out.println(users);
    }

    /**
     * 1对多
     */
    @Test
    public void findUserDemo() {
        Integer i = 6;
        List<User> userDemo = mapper.findUserDemo(i);
        System.out.println(userDemo);

    }

}
