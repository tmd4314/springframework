package com.yedam.app.board.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.yedam.app.board.mapper.BoardMapper;
import com.yedam.app.board.service.BoardService;
import com.yedam.app.board.service.BoardVO;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService {

	private final BoardMapper boardMapper;
	
	@Override
	public List<BoardVO> findAll() {
		message();
		return boardMapper.selectAll();
	}
	
	private void message() {
		System.out.println("구현 클래스 메서드");
	}

	@Override
	public int createInfo(BoardVO boardVO) {
		int result = boardMapper.insertInfo(boardVO);
		return result == 1 ? boardVO.getBno() : -1;
	}

}
