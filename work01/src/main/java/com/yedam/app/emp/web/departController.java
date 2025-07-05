package com.yedam.app.emp.web;



import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yedam.app.depart.service.DepartService;
import com.yedam.app.depart.service.DepartVO;

import lombok.RequiredArgsConstructor;

@Controller  
// DispatherServlet이 활용한 정보를 등록하는 Bean
// route : 사용자의 요청(endpoint)와 그에 대한 처리
// URI + HTTP METHOD => Service => Response(View or Data)
@RequiredArgsConstructor
public class departController {
	// 해당 컨트롤러에서 제공하는 서비스 목록(테이블 분리해서 만들기)
	// 전통적인 방식에선 (AJAX)는 선택이다.
	private final DepartService departService;
	
	// GET : 조회, 빈페이지, 데이터 조작(삭제)
	// POST : 데이터 조작(등록, 수정, 삭제)
	
	// 전체조회 : GET 
	@GetMapping("departList") // 1) URI + METHOD
	public String departList(Model model) {
		// 2) 수행 기능 => Service
		List<DepartVO> list = departService.findAllList();
		// 2-1) View에 전달할 데이터 담기
		model.addAttribute("departs", list);
		// 3) 응답 형태
		return "depart/list";
		//classpath:/template/emp/list.html
		//prefix              return   suffix
	}
	
	// 단건조회 : GET => QueryString
	@GetMapping("departInfo")
	public String departInfo(DepartVO departVO, Model model) {
		DepartVO findVO = departService.findInfoById(departVO);
		model.addAttribute("depart", findVO);
		return "emp/info";
	}
	
	// 등록 - 페이지 : GET 
	@GetMapping("departInsert")
	public String departInsertForm() {
		return "depart/insert";
	}
	
	// 등록 - 처리  : POST(AJAX 사용 안함 중복 저장되서) => <form/> submint / QuertString 
	@PostMapping("departInsert")
	public String departUnsertProcess(DepartVO departVO) {
		int departId = departService.createInfo(departVO);
		String url = null;
		if(departId > -1) {
			//정상적으로 등록
			url = "redirect:departInfo?departmentId=" + departId;
		}else {
			// 등록되지 않은 경우
			url = "redirect:departList";
		}
		return url;
	}
	
	// 수정 - 페이지 : GET <=> 단건조회
	@GetMapping("departUpdate")
	public String departUpdateForm(DepartVO departVO, Model model) {
		DepartVO findVO = departService.findInfoById(departVO);
		model.addAttribute("emp", findVO);
		return "depart/update";
	}
	
	// 수정 - 처리   : POST + AJAX + JSON
	@PostMapping("departUpdate")
	@ResponseBody // AJAX=> model 사용하지 않음 		//JSON
	public Map<String, Object> departUpdateProcess(@RequestBody DepartVO departVO) {
		return departService.modifyInfo(departVO);
	}
	
	// 삭제 - 처리   : GET => QueryString 
	@GetMapping("departDelete")
	public String departDelete(Integer departmentId) {
		departService.removeInfo(departmentId);
		return "redirect:departList";
	}
}
