package com.naver.myhome4;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)   
@ContextConfiguration(locations={"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
public class _2MyBatisTest {
   
   private static final Logger logger = LoggerFactory.getLogger(_2MyBatisTest.class);
   
   @Autowired
   private SqlSessionFactory sqlSessionFactory;//SqlSessionFactoryBean에서 만든 
   
   @Test
   public void testSqlSessionFactory() {
      logger.info("~~~~~~~~~~~~sqlSessionFactory : "+ sqlSessionFactory);
      //sqlSessionFactory : org.apache.ibatis.session.defaults.DefaultSqlSessionFactory@16fb356
      //만약에 root-context.xml 파일에 설정한 SqlSessionFactory Bean 의 설정에 문제가 있다면
      //이 코드에서 문제가 발생할 것입니다.
   }

}