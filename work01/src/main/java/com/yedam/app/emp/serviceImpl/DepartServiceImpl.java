package com.yedam.app.emp.serviceImpl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yedam.app.depart.mapper.DepartMapper;
import com.yedam.app.depart.service.DepartService;
import com.yedam.app.depart.service.DepartVO;

@Service // AOP(공통 기능)에 대해 지원이 가능한 Bean 
		 // 예를 들어, @Transactional
public class DepartServiceImpl implements DepartService {

	private DepartMapper departMapper;
	
	@Autowired // DI : 생성자 주입
	public DepartServiceImpl(DepartMapper departMapper) {
		this.departMapper = departMapper;
	}
	
	@Override
	public List<DepartVO> findAllList() {
		return departMapper.selectAll();
	}

	@Override
	public DepartVO findInfoById(DepartVO departVO) {
		return departMapper.selectInfo(departVO);
	}

	@Override
	public int createInfo(DepartVO departVO) {
		int result = departMapper.insertInfo(departVO); 
		return result == 1 ? departVO.getDepartmentId() : -1;
	}

	@Override
	public Map<String, Object> modifyInfo(DepartVO departVO) {
		Map<String, Object> map = new HashMap<>();
		boolean isSuccessed = false;
		
		int result = departMapper.updateInfo(departVO.getDepartmentId(), departVO);
		
		if(result == 1) {
			isSuccessed = true;
		}
		
		map.put("result", isSuccessed);
		map.put("target", departVO);
		return map;
	}

	@Override
	public Map<String, Object> removeInfo(int departId) {
		Map<String, Object> map = new HashMap<>();
		
		int result = departMapper.deleteInfo(departId);
				
		if(result == 1) {
			map.put("departmentId", departId);
		}
		
		return map;
	}

}
