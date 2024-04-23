package com.kh.mybatis.common.template;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class Template {
	// myBatis
	public static SqlSession getSqlSession() {
		// mybatis-config.xml 읽어들이기
		// 해당 db와 접속된 SqlSession 객체 생성해서 반환하기
		
		SqlSession sqlSession = null;
		
		//SqlSession 생성하기 위해서는 SqlSessionFactory가 필요하다.
		//SqlSessionFactory 생성하기 위해서는 => SqlSessionFactoryBuilder가 필요함
		
		String resource = "/mybatis-config.xml";
		InputStream inputStream;
		try {
			inputStream = Resources.getResourceAsStream(resource);
//			SqlSessionFactory sqlSession = new SqlSessionFactoryBuilder().build(inputStream);
//			sqlSession = sqlSessionFactory.openSession(false); // boolean autoCommit => 자동커밋여부(true면 자동커밋 false면 수동커밋)
			
			sqlSession = new SqlSessionFactoryBuilder().build(inputStream).openSession(false);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

		return sqlSession;
	}
}
