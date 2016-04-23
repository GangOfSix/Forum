package com.forum.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.forum.entity.User;
import com.forum.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	Logger logger = Logger.getLogger(UserController.class);
	
	@RequestMapping(value="/userRegister",method = RequestMethod.POST)
	@ResponseBody 
	public String userRegister(User user)  {		
		logger.info(user.getNickname());
		
		if(userService.save(user)!=null)
			return "success";
		else return "fail";
	}
/*	@RequestMapping("/get")
	@ResponseBody
	public List<Board> get() {
		logger.info(userService.find());
		return userService.find();
	}*/
}
