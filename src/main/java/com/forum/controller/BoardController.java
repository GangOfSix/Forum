package com.forum.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.forum.entity.Board;
import com.forum.service.BoardService;

@Controller
@RequestMapping("/board")
public class BoardController {
	
	@Autowired
	private BoardService boardService;
	Logger logger = Logger.getLogger(BoardController.class);
	
	
	@RequestMapping("/get")
	@ResponseBody
	public List<Board> get() {
		logger.info(boardService.find());
		return boardService.find();
	}
}
