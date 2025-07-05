package com.yedam.app.depart.service;

import java.util.List;
import java.util.Map;

// 실제로 사용자에게 제공하는 기능: Business Layer 영역
public interface DepartService {
	// 전체 사원정보 조회
	public List<DepartVO> findAllList();
	// 사원정보 단건 조회
	public DepartVO findInfoById(DepartVO departVO);
	// 사원정보 단건 등록
	public int createInfo(DepartVO departVO);
	// 사원정보 단건 수정
	public Map<String, Object> modifyInfo(DepartVO departVO);
	// 사원정보 단건 삭제
	public Map<String, Object> removeInfo(int DepartId);
}
