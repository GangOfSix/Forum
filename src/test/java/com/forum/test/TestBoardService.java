package com.forum.test;

import org.apache.log4j.Logger;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.forum.service.BoardService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:Spring.xml", "classpath:Spring-Hibernate.xml"})
public class TestBoardService {
	
	Logger logger = Logger.getLogger(TestBoardService.class);
	@Autowired
	private BoardService boardService;
	
	@Test
	public void testFind() {
		logger.info(boardService.find());
	}
}
