package com.adaivskenan.mybatis.learning01.mapper;

import com.adaivskenan.mybatis.learning01.model.SysRole;
import org.apache.ibatis.session.SqlSession;
import org.junit.Assert;
import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

/**
 * @description: SysRoleMapper测试类，使用注解方式操作
 * @author: adaivskenan
 * @date: 2021/7/2 8:24 AM
 */
public class SysRoleMapplerTest extends BaseMapperTest{

    private static final String ISO8601_PATTERN = "yyyy-MM-dd HH:mm:ss,SSS";

    /**
     * 根据id和注解sql方式查询
     */
    @Test
    public void testSelectById(){
        try (SqlSession sqlSession = openSession()) {
            SysRoleMapper sysRoleMapper = sqlSession.getMapper(SysRoleMapper.class);
            SysRole sysRole = sysRoleMapper.selectById(1L);
            System.out.println(sysRole);
        }
    }

    /**
     * 测试resultMap注解的映射配置方式
     */
    @Test
    public void testSelectById2(){
        try(SqlSession sqlSession = openSession()){
            SysRoleMapper sqlSessionMapper = sqlSession.getMapper(SysRoleMapper.class);
            SysRole sysRole = sqlSessionMapper.selectById2(1L);
            Assert.assertNotNull(sysRole);
            System.out.println(sysRole);
        }
    }

    /**
     * 测试resultMap关联方式
     */
    @Test
    public void testSelectAll(){
        try(SqlSession sqlSession = openSession()){
            SysRoleMapper sqlSessionMapper = sqlSession.getMapper(SysRoleMapper.class);
            List<SysRole> sysRoles = sqlSessionMapper.selctAll();
            Assert.assertNotNull(sysRoles);
            System.out.println(sysRoles);
        }
    }

    /**
     * 测试resultMap关联方式
     */
    @Test
    public void testInsert(){
        //修改默认时区，格式化时使用
        //默认时区取系统时区，程序最好强制指定。三个地方需要设置：
        /**
         * 1、java程序，用于格式化展示；
         * 2、数据库时区 timestamp可以存储时区，数据库时区改变时值会变。但是最多存储到2038年 datetime无显示但是无时区存储
         * 3、jdbc连接，用于驱动与数据库协调协议。比如传输的为UTC,数据库为GMT+8，则数据库根据时区调整存储结果
         *
         * TIMESTAMP & DATETIME
         * 1、TIMESTAMP 比数值型时间戳可读性更好
         *
         * 2、DATETIME 的存储上限为 9999-12-31 23:59:59，如果使用 TIMESTAMP，则 2038 年需要考虑解决方案
         *
         * 3、DATETIME 由于不需要时区转换，所以性能比 TIMESTAMP 好
         *
         * 4、如果需要将时间存储到毫秒，TIMESTAMP 要 7 个字节，和 DATETIME 8 字节差不太多
          */
        //统一时区的方式是需要设置时区为UTC,然后根据客户所在区域进行格式化
        TimeZone.setDefault(TimeZone.getTimeZone("GMT+8"));
        SqlSession sqlSession = openSession();
        try{
            SysRoleMapper sqlSessionMapper = sqlSession.getMapper(SysRoleMapper.class);
            SysRole sysRole = new SysRole();
            sysRole.setId(0L);//null，0时会自增；不冲突时插入指定值
            sysRole.setRoleName("测试");
            sysRole.setEnabled(false);
            sysRole.setCreateBy(0L);
            sysRole.setCreateTime(new Date());
            int result = sqlSessionMapper.insert(sysRole);
            Assert.assertEquals(1, result);
            List<SysRole> sysRoles = sqlSessionMapper.selctAll();
            System.out.println(sysRoles);
            SimpleDateFormat sf = new SimpleDateFormat(ISO8601_PATTERN);
            System.out.println(sf.getTimeZone());
            System.out.println(sf.format(sysRoles.get(2).getCreateTime()));
        }finally {
           sqlSession.rollback();
            sqlSession.close();
        }
    }

    /**
     * 测试插入返回自增主键
     */
    @Test
    public void testInsert2(){
        SqlSession sqlSession = openSession();
        try{
            SysRoleMapper sqlSessionMapper = sqlSession.getMapper(SysRoleMapper.class);
            SysRole sysRole = new SysRole();
            sysRole.setRoleName("测试");
            sysRole.setEnabled(false);
            sysRole.setCreateBy(0L);
            sysRole.setCreateTime(new Date());
            int result = sqlSessionMapper.insert2(sysRole);
            Assert.assertEquals(1, result);
            Assert.assertNotNull(sysRole.getId());
            System.out.println(sysRole);
        }finally {
            sqlSession.rollback();
            sqlSession.close();
        }
    }

    /**
     * 测试插入返回自增主键
     */
    @Test
    public void testInsertBySelectKey(){
        SqlSession sqlSession = openSession();
        try {
            SysRoleMapper sqlSessionMapper = sqlSession.getMapper(SysRoleMapper.class);
            SysRole sysRole = new SysRole();
            sysRole.setRoleName("测试");
            sysRole.setEnabled(false);
            sysRole.setCreateBy(0L);
            sysRole.setCreateTime(new Date());
            int result = sqlSessionMapper.insertBySelectKey(sysRole);
            Assert.assertEquals(1, result);
            Assert.assertNotNull(sysRole.getId());
            System.out.println(sysRole);
        } finally {
            sqlSession.commit();
//            sqlSession.rollback();
        }

    }

    /**
     * 测试更新操作
     */
    @Test
    public void testUpDateById(){
        SqlSession sqlSession = openSession();
        try {
            SysRoleMapper sqlSessionMapper = sqlSession.getMapper(SysRoleMapper.class);
            SysRole sysRole = sqlSessionMapper.selectById(2L);
            Assert.assertNotNull(sysRole);
            sysRole.setRoleName(sysRole.getRoleName()+"2");
            sqlSessionMapper.upDateById(sysRole);
        } finally {
            sqlSession.rollback();
            sqlSession.close();
        }
    }

    /**
     * 测试删除操作
     */
    @Test
    public void testDeleteById(){
        SqlSession sqlSession = openSession();
        try {
            SysRoleMapper sqlSessionMapper = sqlSession.getMapper(SysRoleMapper.class);
            SysRole sysRole = sqlSessionMapper.selectById(1L);
            Assert.assertNotNull(sysRole);
            int i = sqlSessionMapper.deleteById(1L);
            sysRole = sqlSessionMapper.selectById(1L);
            Assert.assertNull(sysRole);
        } finally {
            sqlSession.rollback();
            sqlSession.close();
        }
    }

}
