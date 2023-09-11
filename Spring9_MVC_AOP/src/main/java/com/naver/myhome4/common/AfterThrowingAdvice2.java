package com.naver.myhome4.common;

import org.aspectj.lang.annotation.AfterThrowing;
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
 * 
 * BoardServiceImpl.java���� getBoardList()�ȿ�
 * double i = 1/0;
 * 		�߰��մϴ�.
 */
@Service
@Aspect
public class AfterThrowingAdvice2 {

   private static final Logger logger = LoggerFactory.getLogger(AfterThrowingAdvice2.class);
   
   // throwing = "exp"�� exp�� Throwable exp�� �Ű����� �̸��� ��ġ���Ѿ� �մϴ�.
   @AfterThrowing(
		   pointcut = "execution(* com.naver.myhome4..*Impl.get*(..))",
		   throwing = "exp")
   public void afterThrowingLog(Throwable exp) {

      logger.info("=========================================================================");
      logger.info("[AfterThrowing2] : �����Ͻ� ���� ���� �� ������ �߻��ϸ� �����Դϴ�.");
      logger.info("ex : " + exp.toString());
      if (exp instanceof Exception) {
    	  logger.info("���ܰ� �߻��߽��ϴ�.");
      }
      logger.info("=========================================================================");
   }
}