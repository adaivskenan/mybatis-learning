package com.adaivskenan.mybatis.learning01.mapper;

import com.adaivskenan.mybatis.learning01.model.QuerySysRoleUser;
import com.adaivskenan.mybatis.learning01.model.SysRole;
import com.adaivskenan.mybatis.learning01.model.SysUser;
import com.adaivskenan.mybatis.learning01.proxy.MyMapperProxy;
import com.adaivskenan.mybatis.learning01.proxy.UserMapper;
import org.apache.ibatis.session.SqlSession;
import org.junit.Assert;
import org.junit.Test;

import java.lang.reflect.Proxy;
import java.util.Date;
import java.util.List;

/**
 * <p>CountryMapperTest</p>
 *
 * <p>Copyright: 版权所有 (c) 2002 - 2102<br>
 * Company: adaivskenan</p>
 *
 * @author adaivskenan
 * @version Nov 26, 2017
 */

public class SysUserMapperTest extends BaseMapperTest{
	
	//////////////////////////////select//////////////////////////////

	@Test
	public void testSelectById(){
		try (SqlSession sqlSession = openSession()) {
			//使用了动态代理类
			SysUserMapper sysUserMapper = sqlSession.getMapper(SysUserMapper.class);
			SysUser sysUser = sysUserMapper.selectById(1L);
			Assert.assertNotNull(sysUser);
			Assert.assertEquals("admin", sysUser.getUserName());
		}
	}
	
	@Test
	public void testSelectAll(){
		try (SqlSession sqlSession = openSession()) {
			SysUserMapper sysUserMapper = sqlSession.getMapper(SysUserMapper.class);
			List<SysUser> sysUserList = sysUserMapper.selectAll();
			Assert.assertNotNull(sysUserList);
			Assert.assertTrue(sysUserList.size() > 0);
		}
	}
	
	@Test
	public void testSelectRolesByUserId(){
		try (SqlSession sqlSession = openSession()) {
			SysUserMapper sysUserMapper = sqlSession.getMapper(SysUserMapper.class);
			List<QuerySysRoleUser> roleList = sysUserMapper.selectRolesByUserId(1L);
			Assert.assertNotNull(roleList);
			Assert.assertTrue(roleList.size() > 0);
		}
	}
	
	//////////////////////////////insert//////////////////////////////
	
	@Test
	public void testInsert(){
		SqlSession sqlSession = openSession();
		try{
			SysUserMapper sysUserMapper = sqlSession.getMapper(SysUserMapper.class);
			SysUser sysUser = new SysUser();
			sysUser.setCreateTime(new Date());
			sysUser.setHeadImg(new byte[]{1,2,3,4,5});
//			sysUser.setId();
			sysUser.setUserEmail("adaivskenan@foxmail.com");
			sysUser.setUserInfo("I Love S");
			sysUser.setUserName("秦");
			sysUser.setUserPassword("1992");
			int result = sysUserMapper.insert(sysUser);
			Assert.assertEquals(1, result);
			Assert.assertNull(sysUser.getId());
			List<SysUser> sysUsers = sysUserMapper.selectAll();
			System.out.println(sysUsers);
		}
		finally{
			sqlSession.rollback();
			sqlSession.close();
		}
	}

	/**
	 * 通过功能返回数据库创建的主键
	 * org.apache.ibatis.session.Configuration#useGeneratedKeys
	 */
	@Test
	public void testInsert2(){
		SqlSession sqlSession = openSession();
		try{
			SysUserMapper sysUserMapper = sqlSession.getMapper(SysUserMapper.class);
			SysUser sysUser = new SysUser();
			sysUser.setCreateTime(new Date());
			sysUser.setHeadImg(new byte[]{1,2,3,4,5});
//			sysUser.setId();
			sysUser.setUserEmail("adaivskenan@foxmail.com");
			sysUser.setUserInfo("I Love S");
			sysUser.setUserName("Alex");
			sysUser.setUserPassword("1992");
			int result = sysUserMapper.insert2(sysUser);
			Assert.assertEquals(1, result);
			System.out.println(sysUser.getId());
		}
		finally{
			sqlSession.rollback();
			sqlSession.close();
		}
	}

	/**
	 * 通过selectKey方式生成数据库主键(某些数据库不支持主键自增，而是使用序列的方式得到一个值再赋值给id)
	 * selectKey也可以用于有主键自增功能的数据库
	 */
	@Test
	public void testInserBySelectKey(){
		SqlSession sqlSession = openSession();
		try{
			SysUserMapper sysUserMapper = sqlSession.getMapper(SysUserMapper.class);
			SysUser sysUser = new SysUser();
			sysUser.setCreateTime(new Date());
			sysUser.setHeadImg(new byte[]{1,2,3,4,5});
//			sysUser.setId();
			sysUser.setUserEmail("adaivskenan@foxmail.com");
			sysUser.setUserInfo("I Love S");
			sysUser.setUserName("Alex");
			sysUser.setUserPassword("1992");
			int result = sysUserMapper.insertBySelectKey(sysUser);
			Assert.assertEquals(1, result);
			System.out.println(sysUser.getId());
		}
		finally{
			sqlSession.rollback();
			sqlSession.close();
		}
	}

	//////////////////////////////update//////////////////////////////

	/**
	 * 根据主键更新
	 */
	@Test
	public void testUpdateById(){
		SqlSession sqlSession = openSession();
		try{
			SysUserMapper sysUserMapper = sqlSession.getMapper(SysUserMapper.class);
			SysUser sysUser = sysUserMapper.selectById(1L);
			sysUser.setUserEmail("adaivskenan_TEST@foxmail");
			int result = sysUserMapper.updateById(sysUser);
			System.out.println(result);
		}finally {
			sqlSession.rollback();
			sqlSession.close();
		}
	}

	
	//////////////////////////////delete//////////////////////////////

	/**
	 * 根据主键删除
	 */
	@Test
	public void testDeleteById(){
		SqlSession sqlSession = openSession();
		try {
			SysUserMapper mapper = sqlSession.getMapper(SysUserMapper.class);
			SysUser sysUser = mapper.selectById(1L);
			System.out.println(sysUser.getUserName());
			int result = mapper.deleteById(1L);
			System.out.println(result);
			sysUser = mapper.selectById(1L);
			Assert.assertNull(sysUser);
		}finally {
			sqlSession.rollback();
			sqlSession.close();
		}
	}

	/**
	 * 测试多参数查询
	 */
	@Test
	public void testSelectRolesByUserIdAndRoleEnabled(){
		try (SqlSession sqlSession = openSession()) {
			SysUserMapper mapper = sqlSession.getMapper(SysUserMapper.class);
			List<SysRole> sysRoles = mapper.selectRolesByUserIdAndRoleEnabled(1L, 1);
			Assert.assertNotNull(sysRoles);
			sysRoles.forEach(sysRole -> {
				System.out.println(sysRole.getRoleName());
			});
		}
	}

	/**
	 * 测试自定义代理
	 */
	@Test
	public void testSelectByMyProxy(){
		try(SqlSession sqlSession = openSession()) {
			MyMapperProxy<UserMapper> sysUserMyMapperProxy = new MyMapperProxy<>(UserMapper.class, sqlSession);
			UserMapper userMapper = (UserMapper) Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(),
					new Class[]{UserMapper.class}
					, sysUserMyMapperProxy);
			List<SysUser> sysUsers = userMapper.selectAll();
			sysUsers.forEach(sysUser -> {
				System.out.println(sysUser.getUserName());
			});
		}
	}


	//////////////////////////////if标签//////////////////////////////
	/**
	 * 测试根据用户信息查询，使用if标签
	 */
	@Test
	public void testSelectByUser(){
		try (SqlSession sqlSession = openSession()) {
			SysUserMapper sysUserMapper = sqlSession.getMapper(SysUserMapper.class);
			SysUser query = new SysUser();
			query.setUserName("adm");
			List<SysUser> sysUsers = sysUserMapper.selectByUser(query);
			Assert.assertNotNull(sysUsers);
			System.out.println(sysUsers);
			query = new SysUser();
			query.setUserEmail("adaivskenan@foxmail.com");
			sysUsers = sysUserMapper.selectByUser(query);
			Assert.assertFalse(sysUsers.isEmpty());
			System.out.println(sysUsers);
		}
	}

	/**
	 * 测试可选字段更新
	 */
	@Test
	public void testUpdateByIdSelective(){
		SqlSession sqlSession = openSession();
		try {
			SysUserMapper sysUserMapper = sqlSession.getMapper(SysUserMapper.class);
			SysUser sysUser = new SysUser();
			sysUser.setId(1L);
			sysUser.setUserEmail("adaivskenan@qq.com");
			int result = sysUserMapper.updateByIdSelective(sysUser);
			List<SysUser> sysUsers = sysUserMapper.selectByUser(sysUser);
			Assert.assertFalse(sysUsers.isEmpty());
			System.out.println(sysUsers);
		}finally {
			sqlSession.rollback();
			sqlSession.close();
		}
	}

	/**
	 * 测试根据条件部分插入
	 */
	@Test
	public void testInsertSelective(){
		SqlSession sqlSession = openSession();
		try {
			SysUserMapper sysUserMapper = sqlSession.getMapper(SysUserMapper.class);
			SysUser sysUser = new SysUser();
			sysUser.setUserName("alex");
			sysUser.setUserPassword("");
			sysUser.setUserEmail("sofia@rtx.com");
			sysUser.setUserInfo("");
			sysUser.setHeadImg(new byte[]{});
			sysUser.setCreateTime(new Date());

			int result = sysUserMapper.insertSelective(sysUser);
			List<SysUser> sysUsers = sysUserMapper.selectByUser(sysUser);
			Assert.assertFalse(sysUsers.isEmpty());
			System.out.println(sysUsers);
		} finally {
			sqlSession.rollback();
			sqlSession.close();
		}
	}
	
}
