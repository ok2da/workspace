package com.naver.myhome4.common;

import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
/* 
 * JoinPoint 인터페이스의 메서드
  1. Signature getSignature() : 호출되는 메서드에 대한 정보를 구합니다.
  2. Object getTarget() : 호출한 비즈니스 메서드를 포함하는 비즈니스 객체를 구합니다.
  3. getClass().getName(): 클래스 이름을 구합니다.
  4. proceeding.getSignature().getName() : 호출되는 메서드 이름을 구합니다.
 */
import org.springframework.stereotype.Service;

/*
 * Advice : 횡단 관심에 해당하는 공통 기능을 의미하며 독립된 클래스의 메서드로 작성됩니다.
 * AfterReturningAdvice : 타겟 메소드가 성공적으로 결과값을 반환 후에 어드바이스 기능을 수행합니다.
 * 
 * BoardServiceImpl.java에서 getBoardList()안에
 * double i = 1/0;
 * 		추가합니다.
 */
@Service
@Aspect
public class AfterThrowingAdvice2 {

   private static final Logger logger = LoggerFactory.getLogger(AfterThrowingAdvice2.class);
   
   // throwing = "exp"의 exp와 Throwable exp의 매개변수 이름을 일치시켜야 합니다.
   @AfterThrowing(
		   pointcut = "execution(* com.naver.myhome4..*Impl.get*(..))",
		   throwing = "exp")
   public void afterThrowingLog(Throwable exp) {

      logger.info("=========================================================================");
      logger.info("[AfterThrowing2] : 비지니스 로직 수행 중 오류가 발생하면 동작입니다.");
      logger.info("ex : " + exp.toString());
      if (exp instanceof Exception) {
    	  logger.info("예외가 발생했습니다.");
      }
      logger.info("=========================================================================");
   }
}