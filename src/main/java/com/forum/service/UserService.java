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
	
	public User getByNickname(String nickname) {
		String[] param = {nickname};
		return userDao.get("from User where nickname = ?", param);
	}

	public User getById(String id) {
		return userDao.get(User.class, id);
	}

	public User getByPhonenumber(String phoneNumber) {
		
		Object[] param = {Long.parseLong(phoneNumber)};
		return userDao.get("from User where phonenumber = ?", param);
		
	}
	public User getByEmail(String email) {
		String[] param = {email};
		return userDao.get("from User where email = ?", param);
		
	}
}
