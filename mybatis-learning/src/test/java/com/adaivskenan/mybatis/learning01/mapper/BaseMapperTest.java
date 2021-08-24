package com.adaivskenan.mybatis.learning01.mapper;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.BeforeClass;

import java.io.IOException;
import java.io.Reader;
import java.util.TimeZone;

/**
 * <p>基础测试类BaseMapperTest</p>
 *
 * <p>Copyright: 版权所有 (c) 2002 - 2102<br>
 * Company: adaivskenan</p>
 *
 * @author adaivskenan
 * @version Dec 6, 2017
 */

public class BaseMapperTest{
	
	private static SqlSessionFactory sqlSessionFactory;

	@BeforeClass
	public static void init(){
		try{
			//统一时区的方式是需要设置时区为UTC,然后根据客户所在区域进行格式化
			TimeZone.setDefault(TimeZone.getTimeZone("GMT+8"));
			Reader reader = Resources.getResourceAsReader("com/adaivskenan/mybatis/learning01/config/mybatis-config.xml");
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
			reader.close();
		}
		catch(IOException e){
			e.printStackTrace();
		}
	}
	
	public SqlSession openSession(){
		return sqlSessionFactory.openSession();
	}
	

}
