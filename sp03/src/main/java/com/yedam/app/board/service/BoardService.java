package com.yedam.app.board.service;

import java.util.List;

public interface BoardService {
	// 전체조회
	public List<BoardVO> findAll();
	
	// 등록
	public int createInfo(BoardVO boardVO);
}
