package com.naver.myhome4;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.naver.myhome4.domain.Comment;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= {"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
public class _3MyBatisTestDAO_Comment {
   
   private static final Logger logger = LoggerFactory.getLogger(_3MyBatisTestDAO_Comment.class);
   
   @Autowired
   private SqlSessionTemplate sqlsession;
   
   //@Test
   public void count() {
      int board_num = 1;
      int result=sqlsession.selectOne("Comments.count", board_num);
      logger.info("게시판 글번호 " + board_num + "에 " + result + "개 댓글이 있습니다. ==========");
   }
   
   //@Test
   public void list() {
	   int board_num=4;
	   Map<String,Integer> map = new HashMap<String,Integer>();
	   map.put("board_num", board_num);
	   map.put("start", 1);
	   map.put("end", 3);
	   
	   List<Comment> list = sqlsession.selectList("Comments.list", map);
	   logger.info("list size() ===> " + list.size() + "개");
	   
	   for(Comment comment : list) {
		   logger.info("댓글 번호:" + comment.getNum());
		   logger.info("작성자:" + comment.getId());
		   logger.info("내용:" + comment.getContent());
		   logger.info("날짜:" + comment.getReg_date());
		   logger.info("=====================================================");
	   }
   }
   
   @Test
   public void add() {
	   int board_num = 4;
	   Comment c = new Comment();
	   c.setBoard_num(board_num);
	   c.setContent("jUnit 에서 보내요");
	   c.setId("admin");
	   int result = sqlsession.insert("Comments.insert", c);
	   logger.info("삽입한 갯수 : " + result);
   }
   
}