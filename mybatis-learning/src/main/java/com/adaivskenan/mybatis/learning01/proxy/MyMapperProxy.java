package com.adaivskenan.mybatis.learning01.proxy;

import org.apache.ibatis.session.SqlSession;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.List;

/**
 * @description: 自定义myBatis Mappe代理
 * @author: adaivskenan
 * @date: 2021/7/1 10:18 AM
 */
public class MyMapperProxy<T> implements InvocationHandler {

    private Class<T> mapperInterface;
    private SqlSession sqlSession;

    public MyMapperProxy(Class<T> mapperInterface, SqlSession sqlSession) {
        this.mapperInterface = mapperInterface;
        this.sqlSession = sqlSession;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        String statement = mapperInterface.getCanonicalName() + '.' + method.getName();
        //针对不同sql类型，需要调用不同的SqlSession方法
        List<Object> selectList = sqlSession.selectList(statement);
        //通过sqlSession查询Mapper文件映射出来的xml
        System.out.println(statement);
        return selectList;
    }
}
