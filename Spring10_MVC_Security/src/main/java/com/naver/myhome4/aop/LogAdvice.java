package com.naver.myhome4.aop;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class LogAdvice {

//�������� ó���� ������ LogAdvice Ŭ������ beforeLog()�޼���� �����մϴ�.	
	private static final Logger logger = LoggerFactory.getLogger(LogAdvice.class);
	
	//LogAdvice Ŭ������ ���� �޼��带 aop���� Advice��� �մϴ�.
	public void beforeLog() {
		logger.info("[LogAdvice : ����޼��� �Դϴ�.]");
	}
}

