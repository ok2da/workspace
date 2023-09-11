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
//root-context.xml ����
/*
 * @Configuration
    1. �� Ŭ������ ���� Ŭ�������� �˷��ִ� �޼����Դϴ�.
    2. Ŭ������ �ϳ� �̻��� @Bean �޼ҵ带 �����ϰ� ��Ÿ�ӿ� �ش� �� ���� �� ���� �� ���� ��û�� �����ϱ� ���� 
 *    Spring �����̳ʿ� ���� ó���� �� ������ ��Ÿ���ϴ�. 
 */
@Configuration

//annotation ��� Ʈ����� ������ ��� �մϴ�.
@EnableTransactionManagement // <tx:annotation-driven>

//���� �������̽��� �ִ� ��Ű�� ��θ� �����մϴ�.
@MapperScan(basePackages= {"com.naver.myhome4.mybatis.mapper"})

@PropertySource(value ="classpath:/pro/mail.properties")
@PropertySource(value ="classpath:/pro/savefolder.properties")
public class RootConfig {
   /* ApplicationContext
    - ���ø����̼ǿ� ���� ������ �����ϴ�  �������̽���  ���� ���ҽ��� �ε��ϴ� ����� �ֽ��ϴ�.
    - ��뿹)
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
   
   //@Bean�� �����ڰ� ���� ��� �Ұ����� �ܺ� ���̺귯�� ���� �ڹ� ��ü�� ������� �� �� ���˴ϴ�.
   //DataSource�� �ڹ� ��ü(��)���� ����ϱ� ���ؼ��� DataSource�� ��ȯ�ϴ� �޼��带 �����
   //�޼��� ���� @Bean�� �ٿ��ݴϴ�.
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
      
      //���̹�Ƽ�� ���� ���� ��ġ �����մϴ�.
      factoryBean.setConfigLocation(
            applicationContext.getResource("classpath:/com/naver/myhome4/mybatis/config/mybatis-config.xml"));
      
      //��Ī���� ����� ��Ű���� ��θ� �����մϴ�.
      factoryBean.setTypeAliasesPackage("com.naver.myhome4.domain");
      
      //���� ������ ��ġ�� �����մϴ�.
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
       resolver.setMaxUploadSize(1024*1024*10);//10M - �� �� ��û�� ������ �� �ִ� �ִ� ũ��
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

   //Ʈ����� �Ŵ��� ���
   @Bean
   public DataSourceTransactionManager transactionManager() {
       return new DataSourceTransactionManager(dataSource());
   }
 
}