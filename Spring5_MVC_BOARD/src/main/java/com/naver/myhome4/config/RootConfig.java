package com.naver.myhome4.config;

import java.io.IOException;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.tomcat.dbcp.dbcp2.BasicDataSource;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
//root-context.xml 역할
/*
 * @Configuration
    1. 이 클래스가 설정 클래스임을 알려주는 메서드입니다.
    2. 클래스가 하나 이상의 @Bean 메소드를 선언하고 런타임에 해당 빈에 대한 빈 정의 및 서비스 요청을 생성하기 위해 
 *    Spring 컨테이너에 의해 처리될 수 있음을 나타냅니다. 
 */
@Configuration

//annotation 기반 트랜잭션 관리를 사용 합니다.
@EnableTransactionManagement // <tx:annotation-driven>

//매퍼 인터페이스가 있는 패키지 경로를 지정합니다.
@MapperScan(basePackages= {"com.naver.myhome4.mybatis.mapper"})

@PropertySource(value ="classpath:/pro/mail.properties")
@PropertySource(value ="classpath:/pro/savefolder.properties")
public class RootConfig {
   /* ApplicationContext
    - 애플리케이션에 대한 구성을 제공하는  인터페이스로  파일 리소스를 로드하는 기능이 있습니다.
    - 사용예)
        applicationContext.getResources("classpath:/com/naver/myhome4/mybatis/mapper/*.xml")
    */
   
   private ApplicationContext applicationContext;
   
   @Autowired
   public RootConfig(ApplicationContext applicationContext) {
      this.applicationContext = applicationContext;
   }
   
   @Value("${id}")
   private String id;
   
   @Value("${password}")
   private String password;
   
   //@Bean은 개발자가 직접 제어가 불가능한 외부 라이브러리 등을 자바 객체로 만들려고 할 때 사용됩니다.
   //DataSource를 자바 객체(빈)으로 등록하기 위해서는 DataSource를 반환하는 메서드를 만들고
   //메서드 위에 @Bean을 붙여줍니다.
   @Bean(destroyMethod="close")
   public DataSource dataSource() {
      BasicDataSource dataSource = new BasicDataSource();
      dataSource.setDriverClassName("oracle.jdbc.driver.OracleDriver");
      dataSource.setUrl("jdbc:oracle:thin:@localhost:1521:xe");
      dataSource.setUsername("scott");
      dataSource.setPassword("tiger");
      return dataSource;
   }

   @Bean
   public SqlSessionFactoryBean sqlSessionFactory(DataSource dataSource) throws IOException {
      SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
      factoryBean.setDataSource(dataSource);
      
      //마이바티스 설정 파일 위치 설정합니다.
      factoryBean.setConfigLocation(
            applicationContext.getResource("classpath:/com/naver/myhome4/mybatis/config/mybatis-config.xml"));
      
      //별칭으로 사용할 패키지의 경로를 지정합니다.
      factoryBean.setTypeAliasesPackage("com.naver.myhome4.domain");
      
      //매퍼 파일의 위치를 지정합니다.
      factoryBean.setMapperLocations(
            applicationContext.getResources("classpath:/com/naver/myhome4/mybatis/mapper/*.xml"));
      return factoryBean;
   }


    @Bean
    public SqlSessionTemplate sqlSession(SqlSessionFactory sqlSessionFactory) {
        return new SqlSessionTemplate(sqlSessionFactory);
    }
 
    @Bean(name="multipartResolver")
    public CommonsMultipartResolver getResolver() throws IOException{
       CommonsMultipartResolver resolver = new CommonsMultipartResolver();
       resolver.setMaxUploadSize(1024*1024*10);//10M - 한 번 요청시 전달할 수 있는 최대 크기
       return resolver;
    }
    
    @Bean(name="mailSender")
    public JavaMailSenderImpl getMailSender() throws IOException{
    	JavaMailSenderImpl mail = new JavaMailSenderImpl();
    	mail.setHost("smtp.naver.com");
    	mail.setPort(587);
    	mail.setUsername(id);
    	mail.setPassword(password);
    	
    	java.util.Properties p = new java.util.Properties();
    	p.put("mail.smtp.auth", "true");
    	mail.setJavaMailProperties(p);
    	return mail;
    }

   //트랜잭션 매니저 등록
   @Bean
   public DataSourceTransactionManager transactionManager() {
       return new DataSourceTransactionManager(dataSource());
   }
 
}