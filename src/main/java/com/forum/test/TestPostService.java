package com.forum.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.forum.entity.Post;
import com.forum.service.BoardService;
import com.forum.service.PostService;
import com.forum.service.UserService;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:Spring.xml", "classpath:Spring-Hibernate.xml"})
public class TestPostService {
	@Autowired
	private PostService postService;
	@Autowired
	private UserService userService;
	@Autowired
	private BoardService boardService;
	@Test
	public void test() {
		
		//postService.save(new Post(), boardService.getById(1),userService.getById(1));
	}

}
