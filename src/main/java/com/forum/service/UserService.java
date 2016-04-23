package com.forum.service;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.forum.dao.UserDao;
import com.forum.entity.User;

@Service
public class UserService {
	
	@Autowired
	private UserDao userDao;
	
	public Serializable save(User user){
		return userDao.save(user);
	}
	
	public List<User> find() {
		return userDao.find("from User");
	}
}
