package com.forum.controller;

import javax.servlet.http.HttpSession;

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
	
	@RequestMapping(value="/register",method = RequestMethod.POST)
	@ResponseBody 
	public String register(User user)  {		
		logger.info(user.getNickname());
		
		if(userService.save(user)!=null)
			return "success";
		else return "fail";
	}
	
	@RequestMapping(value="/get")
	@ResponseBody 
	public User getById(String id){	
		return userService.getById(id);
	}
	
	
	public User loginWay(String str){
	
		if(str.matches("\\d{11}"))
			return  userService.getByPhonenumber(str);
		else if(str.matches("^[a-zA-Z\u4e00-\u9fa5][a-zA-Z0-9_\u4e00-\u9fa5]+$"))		
			return userService.getByNickname(str);
		else if(str.matches("^[a-zA-Z0-9_\\.]+@[a-zA-Z0-9_]+\\.\\w+"))
			return  userService.getByEmail(str);
		else return null;
	}
	
	@RequestMapping(value="/login")
	@ResponseBody 
	public boolean login(String str,String password,HttpSession session){
		logger.info("��������"+str+password);
		User user = this.loginWay(str);
		
		if((user!=null)&&password.equals(user.getPassword())){
			logger.info(user.getNickname());
			session.setAttribute("user", user);
			return true;
		}
		else return false;
	}
	
	
	
	@RequestMapping(value="/validate")
	@ResponseBody 
	public boolean validateNickname(String nickname){
		
		return (userService.getByNickname(nickname)==null);
	}
/*	@RequestMapping("/get")
	@ResponseBody
	public List<Board> get() {
		logger.info(userService.find());
		return userService.find();
	}*/
}
