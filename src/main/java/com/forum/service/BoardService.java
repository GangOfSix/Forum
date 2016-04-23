package com.forum.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.forum.dao.BoardDao;
import com.forum.entity.Board;

@Service
public class BoardService {
	
	@Autowired
	private BoardDao boardDao;
	
	public List<Board> find() {
		return boardDao.find();
	}
}
