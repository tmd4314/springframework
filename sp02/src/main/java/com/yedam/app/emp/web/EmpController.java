package com.yedam.app.emp.web;



import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yedam.app.emp.service.EmpService;
import com.yedam.app.emp.service.EmpVO;

import lombok.RequiredArgsConstructor;

@Controller  
// DispatherServlet이 활용한 정보를 등록하는 Bean
// route : 사용자의 요청(endpoint)와 그에 대한 처리
// URI + HTTP METHOD => Service => Response(View or Data)
@RequiredArgsConstructor
public class EmpController {
	// 해당 컨트롤러에서 제공하는 서비스 목록(테이블 분리해서 만들기)
	// 전통적인 방식에선 (AJAX)는 선택이다.
	private final EmpService empService;
	
	// GET : 조회, 빈페이지, 데이터 조작(삭제)
	// POST : 데이터 조작(등록, 수정, 삭제)
	
	// 전체조회 : GET 
	@GetMapping("empList") // 1) URI + METHOD
	public String empList(Model model) {
		// 2) 수행 기능 => Service
		List<EmpVO> list = empService.findAllList();
		// 2-1) View에 전달할 데이터 담기
		model.addAttribute("emps", list);
		// 3) 응답 형태
		return "emp.list";
		//classpath:/template/emp/list.html
		//prefix              return   suffix
	}
	
	// 단건조회 : GET => QueryString
	@GetMapping("empInfo")
	public String empInfo(EmpVO empVO, Model model) {
		EmpVO findVO = empService.findInfoById(empVO);
		model.addAttribute("emp", findVO);
		return "emp/info";
	}
	
	// 등록 - 페이지 : GET 
	@GetMapping("empinsert")
	public String empInsertForm() {
		return "emp/insert";
	}
	
	// 등록 - 처리  : POST(AJAX 사용 안함 중복 저장되서) => <form/> submint / QuertString 
	@PostMapping("empInsert")
	public String empUnsertProcess(EmpVO empVO) {
		int eid = empService.createInfo(empVO);
		String url = null;
		if(eid > -1) {
			//정상적으로 등록
			url = "redirect:empinfo?employeeId=" + eid;
		}else {
			// 등록되지 않은 경우
			url = "redirect:empList";
		}
		return url;
	}
	
	// 수정 - 페이지 : GET <=> 단건조회
	@GetMapping("empUpdate")
	public String empUpdateForm(EmpVO empVO, Model model) {
		EmpVO findVO = empService.findInfoById(empVO);
		model.addAttribute("emp", findVO);
		return "emp/update";
	}
	
	// 수정 - 처리   : POST + AJAX + JSON
	@PostMapping("emUpdate")
	@ResponseBody // AJAX=> model 사용하지 않음 		//JSON
	public Map<String, Object> empUpdateProcess(@RequestBody EmpVO empVO) {
		return empService.modifyInfo(empVO);
	}
	
	// 삭제 - 처리   : GET => QueryString 
	@GetMapping("empDelete")
	public String empDelete(Integer employeeId) {
		empService.removeInfo(employeeId);
		return "redirect:empList";
	}
}
