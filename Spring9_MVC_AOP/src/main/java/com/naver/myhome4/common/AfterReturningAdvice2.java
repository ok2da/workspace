package com.naver.myhome4.common;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
/* 
 * JoinPoint �������̽��� �޼���
  1. Signature getSignature() : ȣ��Ǵ� �޼��忡 ���� ������ ���մϴ�.
  2. Object getTarget() : ȣ���� ����Ͻ� �޼��带 �����ϴ� ����Ͻ� ��ü�� ���մϴ�.
  3. getClass().getName(): Ŭ���� �̸��� ���մϴ�.
  4. proceeding.getSignature().getName() : ȣ��Ǵ� �޼��� �̸��� ���մϴ�.
 */
import org.springframework.stereotype.Service;

/*
 * Advice : Ⱦ�� ���ɿ� �ش��ϴ� ���� ����� �ǹ��ϸ� ������ Ŭ������ �޼���� �ۼ��˴ϴ�.
 * AfterReturningAdvice : Ÿ�� �޼ҵ尡 ���������� ������� ��ȯ �Ŀ� �����̽� ����� �����մϴ�.
 */
//@Service
//@Aspect
public class AfterReturningAdvice2 {

   private static final Logger logger = LoggerFactory.getLogger(AfterReturningAdvice2.class);
   
   @AfterReturning(pointcut="execution(* com.naver.myhome4..*Impl.get*(..))",returning="obj")
   public void afterReturningLog(Object obj) {

      logger.info("=========================================================================");
      logger.info("[AfterReturningAdvice2] obj : " + obj.toString());
      logger.info("=========================================================================");
   }
}