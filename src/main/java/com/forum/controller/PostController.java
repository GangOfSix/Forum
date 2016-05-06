package com.forum.controller;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.forum.entity.Board;
import com.forum.entity.Post;
import com.forum.entity.User;
import com.forum.service.PostService;

@Controller
@RequestMapping("/post")
public class PostController {
	
	@Autowired
	private PostService postService;
	Logger logger = Logger.getLogger(PostController.class);
	
	@RequestMapping(value="/posting",method = RequestMethod.POST)
	@ResponseBody 
	public String posting(Post post,HttpSession session)  {		
		logger.info(post.getTitle());
		
		Board board = (Board)session.getAttribute("board");
		User user = (User)session.getAttribute("user");
		if(postService.save(post,board,user)!=null)
			return "success";
		else return "fail";
	}
	
	@RequestMapping(value="/get")
	@ResponseBody 
	public Post getById(String id){	
		return postService.getById(id);
	}
	
	

	
	@RequestMapping(value="/update")
	@ResponseBody
	public void update(){
		
	}
	@RequestMapping(value="/ban")
	@ResponseBody
	public void ban(){
		
	}
	
}
