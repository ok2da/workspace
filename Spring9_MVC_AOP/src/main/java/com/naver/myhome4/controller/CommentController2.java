package com.naver.myhome4.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.naver.myhome4.domain.Comment;
import com.naver.myhome4.service.CommentService;

@RestController		//@Controller + @ResponseBody
@RequestMapping(value="/comment")
public class CommentController2 {
	
	private CommentService commentService;
	
	@Autowired
	public CommentController2(CommentService commentservice) {
		this.commentService = commentservice;
	}
	
	   @ResponseBody
	   //@GetMapping(value = "/list")
	   //@PostMapping(value = "/list")
	   @RequestMapping("/list")
	   public Map<String, Object> CommentList(int board_num, int page) {
	      List<Comment> list = commentService.getCommentList(board_num, page);
	      int listcount = commentService.getListCount(board_num);
	      Map<String,Object> map = new HashMap<String, Object>();
	      map.put("list",list);
	      map.put("listcount",listcount);
	      return map;
	   }
	   
	   @ResponseBody
	   @PostMapping(value = "/add")
	   public int CommentAdd(Comment co) {
		   return commentService.commentsInsert(co);
	   }
	   
	   @ResponseBody
	   @PostMapping(value = "/update")
	   public int CommentUpdate(Comment co) {
		   return commentService.commentsUpdate(co);
	   }
	   
	   @ResponseBody
	   @PostMapping(value = "/delete")
	   public int CommentDelete(int num) {
		   return commentService.commentsDelete(num);
	   }
	   


}
