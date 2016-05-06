package com.forum.service;

import java.io.Serializable;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.forum.dao.PostDao;
import com.forum.entity.Board;
import com.forum.entity.Post;
import com.forum.entity.User;

@Service
public class PostService {
	
	@Autowired
	private PostDao postDao;
	
	public Serializable save(Post post,Board board,User user){
		System.out.println("!");
		post.setBoard(board);
		//board.getPosts().add(post);
		System.out.println("!2");
		post.setUser(user);
		//user.getPosts().add(post);
		return postDao.save(post);
	}
	
	public List<Post> find() {
		return postDao.find("from Post");
	}
	
	public Post getByTitle(String title) {
		String[] param = {title};
		return postDao.get("from Post where title = ?", param);
	}

	public Post getById(String id) {
		return postDao.get(Post.class, id);
	}




}
