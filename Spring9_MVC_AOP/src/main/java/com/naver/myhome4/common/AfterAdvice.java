package com.naver.myhome4.common;

import org.aspectj.lang.JoinPoint;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/* 
 * JoinPoint �������̽��� �޼���
  1. Signature getSignature() : ȣ��Ǵ� �޼��忡 ���� ������ ���մϴ�.
  2. Object getTarget() : ȣ���� ����Ͻ� �޼��带 �����ϴ� ����Ͻ� ��ü�� ���մϴ�.
  3. getClass().getName(): Ŭ���� �̸��� ���մϴ�.
  4. proceeding.getSignature().getName() : ȣ��Ǵ� �޼��� �̸��� ���մϴ�.
 */

//�������� ó���� ������ AfterAdvice Ŭ������ AfterLog()�޼���� �����մϴ�.
//Advice : Ⱦ�� ���ɿ� �ش��ϴ� ���� ����� �ǹ��ϸ� ������ Ŭ������ �޼���� �ۼ��˴ϴ�.
//��� ��ü�� �޼ҵ带 �����ϴ� ���߿� �ͼ����� �߻��ߴ����� ���ο� ������� �޼��� ���� �� ���� ����� �����մϴ�.
public class AfterAdvice {
	   private static final Logger logger = LoggerFactory.getLogger(AfterAdvice.class);
	   public void AfterLog(JoinPoint proceeding) {
	      logger.info("=========================================================================");
	      logger.info("[AfterAdvice] : �����Ͻ� ���� ���� �� �����Դϴ�.");
	      logger.info("[AfterAdvice] : "
	    		  + proceeding.getTarget().getClass().getName() + "�� " 
	    		  + proceeding.getSignature().getName() + "() ȣ���մϴ�.");
	      logger.info("=========================================================================");
	   }
}
