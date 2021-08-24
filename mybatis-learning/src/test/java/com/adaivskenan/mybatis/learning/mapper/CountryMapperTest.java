
/**============================================================
 * 版权： adaivskenan 版权所有 (c) 2002 - 2102
 * 包：
 * 修改记录：
 * 日期                作者           内容
 * =============================================================
 * Nov 26, 2017       adaivskenan
 * ============================================================*/

package com.adaivskenan.mybatis.learning.mapper;

import com.adaivskenan.mybatis.learning.model.Country;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

/**
 * <p>com.adaivskenan.mybatis.learning.mapper.CountryMapperTest</p>
 *
 * <p>Copyright: 版权所有 (c) 2002 - 2102<br>
 * Company: adaivskenan</p>
 *
 * @author adaivskenan
 * @version Nov 26, 2017
 */

public class CountryMapperTest {

	private static SqlSessionFactory sqlSessionFactory;

	@BeforeClass
	public static void init(){
		try{
			Reader reader = Resources.getResourceAsReader("com/adaivskenan/mybatis/learning/config/mybatis-config.xml");
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
			reader.close();
		}
		catch(IOException e){
			e.printStackTrace();
		}
	}

	@Test
	public void testSelectAll(){
		SqlSession sqlSession = sqlSessionFactory.openSession();
		try{
			List<Country> countryList = sqlSession.selectList("selectAll");
			printCountryList(countryList);
		}
		finally{
			/*
			 * 释放数据库连接
			 */
			sqlSession.close();
		}
	}

	private void printCountryList(List<Country> countryList){
		for(Country country : countryList){
			System.out.printf("%-4d%-5s%4s\n", country.getId(), country.getCountryName(), country.getCountryCode());
		}
	}

}
