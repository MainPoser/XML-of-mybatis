package com.lovejava;



import com.lovejava.domain.Role;
import com.lovejava.mapper.RoleMapper;
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
import java.util.List;

/**
 * @author:tianyao
 * @date:2019-04-06 9:28
 */
public class RoleTest {
    private InputStream is;
    private SqlSession sqlSession;
    private RoleMapper mapper;
    @Before
    public void before(){
        try {
            //将主配值文件加载成流
            is = Resources.getResourceAsStream("SqlMapConfig.xml");
            //创建工厂
            SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
            SqlSessionFactory build = sqlSessionFactoryBuilder.build(is);
            //创建自动提交事务的sqlsession对象
            sqlSession = build.openSession(true);
            //创建代理对象
            mapper = sqlSession.getMapper(RoleMapper.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @After
    public void after(){
        try {
            is.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        sqlSession.close();
    }
    /**
     * 延迟查询
     * 测试懒加载
     * 一对一
     */
    @Test
    public void testFindRoles(){
        List<Role> role = mapper.findRole();
        for (Role role1 : role) {
            System.out.println(role1);
        }
    }
}
