package com.xtkj.test;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;

public class TestActivity {
	private SqlSession session;
	@Before
	public void before() throws IOException {
		System.out.println("beofre=====调用sqlsession====>");
		InputStream input = Resources.getResourceAsStream("mybatis-config.xml");
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(input);
		session = factory.openSession();
	}
	@After
	public void after() {
		session.close();
		System.out.println("关闭session======>");
	}
	
	
}
