package com.forum.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.forum.entity.Board;

@Repository
public class BoardDao extends BaseDao<Board>{
	public List<Board> find() {
		return this.find("from Board");
	}
}
