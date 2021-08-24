package com.adaivskenan.mybatis.learning01.mapper;

import com.adaivskenan.mybatis.learning01.model.SysPrivilege;
import org.apache.ibatis.session.SqlSession;
import org.junit.Assert;
import org.junit.Test;

/**
 * @description: 测试*Provider的写法
 * @author: adaivskenan
 * @time: 2021/7/6 9:28 PM
 */
public class SysPrivilegeMapperTest extends BaseMapperTest{

    /**
     * 测试Provider方式查询
     */
    @Test
    public void testSelectById(){
        try(SqlSession sqlSession = openSession()) {
            SysPrivilegeMapper sqlSessionMapper = sqlSession.getMapper(SysPrivilegeMapper.class);
            SysPrivilege sysPrivilege = sqlSessionMapper.selectById(1L);
            Assert.assertNotNull(sysPrivilege);
            System.out.println(sysPrivilege);
        }
    }

}
