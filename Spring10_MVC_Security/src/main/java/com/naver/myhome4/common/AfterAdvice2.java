package com.naver.myhome4.common;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/* 
 * JoinPoint 인터페이스의 메서드
  1. Signature getSignature() : 호출되는 메서드에 대한 정보를 구합니다.
  2. Object getTarget() : 호출한 비즈니스 메서드를 포함하는 비즈니스 객체를 구합니다.
  3. getClass().getName(): 클래스 이름을 구합니다.
  4. proceeding.getSignature().getName() : 호출되는 메서드 이름을 구합니다.
 */

//공통으로 처리할 로직을 AfterAdvice 클래스에 AfterLog()메서드로 구현합니다.
//Advice : 횡단 관심에 해당하는 공통 기능을 의미하며 독립된 클래스의 메서드로 작성됩니다.
//대상 객체의 메소드를 실행하는 도중에 익셉션이 발생했는지의 여부에 상관없이 메서드 실행 후 공통 기능을 실행합니다.
//@Service
//@Aspect		//@Aspect가 설정된 클래스에는 Pointcut과 Advice를 결합하는 설정이 있어야 합니다.
public class AfterAdvice2 {
	   private static final Logger logger = LoggerFactory.getLogger(AfterAdvice2.class);
	   
	   @After("execution(* com.naver.myhome4..*Impl.get*(..))")
	   public void AfterLog(JoinPoint proceeding) {
	      logger.info("=========================================================================");
	      logger.info("[AfterAdvice2] : "
	    		  + proceeding.getTarget().getClass().getName() + "의 " 
	    		  + proceeding.getSignature().getName() + "() 호출 후 입니다.");
	      logger.info("[AfterAdvice2] : 비지니스 로직 수행 후 동작입니다.");
	      logger.info("=========================================================================");
	   }
}
