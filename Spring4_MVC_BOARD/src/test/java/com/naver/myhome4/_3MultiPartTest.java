package com.naver.myhome4;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)   
@ContextConfiguration(locations={"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
public class _3MultiPartTest {
   private static final Logger logger = LoggerFactory.getLogger(_3MultiPartTest.class);
   
   @Autowired
   org.springframework.web.multipart.commons.CommonsMultipartResolver multipart;
   
   @Test
   public void isMultipart() {
      logger.info("CommonsMutipartResolver ºó »ý¼º : " + multipart);
   }
   
   
}