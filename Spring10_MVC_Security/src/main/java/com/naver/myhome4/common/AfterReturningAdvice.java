package com.naver.myhome4.common;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
/* 
 * JoinPoint �������̽��� �޼���
  1. Signature getSignature() : ȣ��Ǵ� �޼��忡 ���� ������ ���մϴ�.
  2. Object getTarget() : ȣ���� ����Ͻ� �޼��带 �����ϴ� ����Ͻ� ��ü�� ���մϴ�.
  3. getClass().getName(): Ŭ���� �̸��� ���մϴ�.
  4. proceeding.getSignature().getName() : ȣ��Ǵ� �޼��� �̸��� ���մϴ�.
 */

/*
 * Advice : Ⱦ�� ���ɿ� �ش��ϴ� ���� ����� �ǹ��ϸ� ������ Ŭ������ �޼���� �ۼ��˴ϴ�.
 * AfterReturningAdvice : Ÿ�� �޼ҵ尡 ���������� ������� ��ȯ �Ŀ� �����̽� ����� �����մϴ�.
 */
public class AfterReturningAdvice {

   private static final Logger logger = LoggerFactory.getLogger(AfterReturningAdvice.class);

   public void afterReturningLog(Object obj) {

      logger.info("=========================================================================");
      logger.info("[AfterReturningAdvice] obj : " + obj.toString());
      logger.info("=========================================================================");
   }
}