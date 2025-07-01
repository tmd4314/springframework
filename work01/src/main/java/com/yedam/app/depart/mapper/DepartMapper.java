package com.yedam.app.depart.mapper;

import java.util.List;

import com.yedam.app.depart.service.DepartVO;

public interface DepartMapper {
	// 전체조회
	public List<DepartVO> selectAll();
	
	//단건조회
	public DepartVO selectInfo(DepartVO departVO);
	
	// 등록
	public int insertInfo(DepartVO departVO);
	
	
}
