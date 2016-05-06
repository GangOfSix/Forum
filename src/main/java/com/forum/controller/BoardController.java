package com.forum.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
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
	
	@RequestMapping("/enter")
	public String enter(int id,HttpSession session) {
		logger.info(id);
		session.setAttribute("board",boardService.getById(id));
		return "redirect:/posts.html";
	}
}
