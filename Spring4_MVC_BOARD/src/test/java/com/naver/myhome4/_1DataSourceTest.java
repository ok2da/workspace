package com.naver.myhome4;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/*
 	-- Junit�̶�?
 	
 	1. Junit �̶� Java���� ������ �����׽�Ʈ�� �������ִ� �����ӿ�ũ�Դϴ�.
 	
 	2. Test Runner�� Junit �����ӿ�ũ���� �׽�Ʈ Ŭ���� ���� �����ϴ� ������ �׽�Ʈ �޼��� ������ ����ϰ� �ִ� Ŭ�����Դϴ�.
 		Junit�� ����� �⺻ Test Runner�� BlockJunit4ClassRunner �Դϴ�.
 		
 	3. @RunWith�� JUnit �����ӿ�ũ�� �׽�Ʈ �������� Ȯ���� �� ����ϴ� �ֳ����̼��Դϴ�.
 		@RunWith�� Runner Ŭ������ �����ϸ� JUnit�� ����� Runner ��� �� Ŭ������ �����մϴ�.
 		���⼭�� ������ �׽�Ʈ�� ���ؼ� SpringJUnit4ClassRunner��� Runner Ŭ������ ������ �ݴϴ�.
 	
 	4. @Runwith(SpringJUnit4ClassRunner.class)
 		SpringJUnit4ClassRunner��� JUnit�� �׽�Ʈ ���ؽ�Ʈ �����ӿ�ũ Ȯ�� Ŭ������ ������ �ָ� JUnit��
 		�׽�Ʈ�� �����ϴ� �߿� �׽�Ʈ�� ����� ���ø����̼� ���ؽ�Ʈ�� ����� �����ϴ� �۾��� ������ �ݴϴ�.
 		
 	5. @ContextConfiguration�� �ڵ����� ������� ���ø����̼� ���ؽ�Ʈ�� ���������� ��ġ�� ������ �� ����մϴ�.
 		@ContextConfiguration(location={"file:src/main/webapp/WEB-INF/spring/root-context.xml"})	
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= {"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
public class _1DataSourceTest {
	/*
	 1. ���� org.slf4j ��Ű���� Logger, LoggerFactory Ŭ������ import �մϴ�.
	 	import org.slf4j.Logger;
	 	import org.slf4j.LoggerFactory;
	 2. LoggerFactory Ŭ������ getLogger �޼ҵ带 ���� Logger ��ü�� �����մϴ�.
	 */
	private static final Logger logger = LoggerFactory.getLogger(_1DataSourceTest.class);
	
	@Autowired
	private DataSource dataSource; //root-context.xml �� ������ DataSource�� �ڵ����� �������ݴϴ�.
	
	@Test // ���� �޼��带 �׽�Ʈ ������� �����ϴ� �ֳ����̼��Դϴ�. (org.junit.Test)
	public void testConnection() {
		try(Connection conn = dataSource.getConnection()){
			logger.info("Ȯ�ο� conn : " + conn);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
