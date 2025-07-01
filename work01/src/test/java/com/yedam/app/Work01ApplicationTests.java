package com.yedam.app;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;
import org.springframework.transaction.annotation.Transactional;

import com.yedam.app.depart.mapper.DepartMapper;
import com.yedam.app.depart.service.DepartVO;

@SpringBootTest
class Work01ApplicationTests {

	 @Autowired // 필드 주입 : 테스트용(사용 하지 말아야 하는 이유: private이 걸린 접근지시자를 무시해버림)
	    private DepartMapper departMapper;

	    @Test // 해당 메서드를 테스트하겠다고 선언
	    public void selectAll() {
	        List<DepartVO> list = departMapper.selectAll();
	        for(DepartVO emp : list) {
	            System.out.println(emp.getDepartmentName());
	        }
	        assertTrue(!list.isEmpty()); //단정 메서드, junit이 제공하는 메서드, 
	    }
	    
	    @Test
	    public void selectOne() {
	    	DepartVO emp = DepartVO.builder()
	    						.departmentId(100)
	    						.build();
	    	
	    	DepartVO findVO = departMapper.selectInfo(emp);
	    	System.out.println(findVO);
	    	assertEquals("Finance", findVO.getDepartmentName());
	    }
	    
	    @Test
	    @Transactional
	    @Commit
	    public void insertValue() {
	    	DepartVO emp = DepartVO.builder()
	    			 			.departmentId(1000)
	    			 			.departmentName("Kang")
	    			 			.managerId(100)
	    			 			.locationId(1700)
	    			 			.build();
	    	
	    	int result = departMapper.insertInfo(emp);
	    	assertEquals(1, result);
	    }
	    
	    @Test
	    @Transactional
	    @Commit
	    public void insertSelectKey() {
	    	DepartVO emp = DepartVO.builder()
	    					 .departmentName("Hong")
	    					 .managerId(205)
	    					 .locationId(1800)
	    					 .build();
	    	
	    	int result = departMapper.insertInfo(emp);
	    	System.out.println("사원번호 : " + emp.getDepartmentId());
	    	assertEquals(1, result);
	    }

}
