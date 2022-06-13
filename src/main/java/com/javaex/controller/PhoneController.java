package com.javaex.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.javaex.dao.PhoneDao;
import com.javaex.vo.PhoneVo;

@Controller
public class PhoneController {
	
	//필드
	
	
	//생성자
	
	
	//메소드-gs
	
	
	//메소드-일반
	//전화번호 리스트
	@RequestMapping(value="/list", method={RequestMethod.GET, RequestMethod.POST})
	public String list(Model model) {
		
		System.out.println("PhoneController>list()");
		
		//dao를 통해서 phonelist(주소)를 가져온다
		PhoneDao phoneDao = new PhoneDao();
		List<PhoneVo> phoneList = phoneDao.getPersonList();
		
		//ds 데이터 보내기 --> request attribute에 넣는다
		model.addAttribute("phoneList", phoneList);
		
		return "/WEB-INF/views/list.jsp";
		
	}
	
	//전화번호 등록
	@RequestMapping(value="/write", method={RequestMethod.GET, RequestMethod.POST})
	public String write(@ModelAttribute PhoneVo phoneVo) {
		
		System.out.println("PhoneController>write()");
		
		
		/* *** 디스페쳐 서블릿이 해주는 것들 ***
		//파라미터 꺼내기
		//System.out.println(name);
		//System.out.println(hp);
		//System.out.println(company);
		
		//vo로 묶기
		//PhoneVo phoneVo = new PhoneVo(name, hp, company);
		*/
		
		System.out.println(phoneVo);
		
		//dao로 저장하기
		PhoneDao phoneDao = new PhoneDao();
		int count = phoneDao.personInsert(phoneVo);
		System.out.println(count);
		
		return "redirect:http://localhost:8088/phonebook3/list";
		
	}
	
	//전화번호 등록
	@RequestMapping(value="/write2", method={RequestMethod.GET, RequestMethod.POST})
	public String write2(@RequestParam("name") String name,
						 @RequestParam("hp") String hp,
						 @RequestParam("company") String company) {
		
		System.out.println("PhoneController>write()");
		
		//파라미터 꺼내기
		//System.out.println(name);
		//System.out.println(hp);
		//System.out.println(company);
		
		//vo로 묶기
		PhoneVo phoneVo = new PhoneVo(name, hp, company);
		System.out.println(phoneVo);
		
		//dao로 저장하기
		PhoneDao phoneDao = new PhoneDao();
		int count = phoneDao.personInsert(phoneVo);
		System.out.println(count);
		
		return "redirect:http://localhost:8088/phonebook3/list";
		
	}
	
	//전화번호 등록폼
	@RequestMapping(value="/writeForm", method={RequestMethod.GET, RequestMethod.POST})
	public String writeForm() {
		
		System.out.println("PhoneController>writeForm()");
		
		return "/WEB-INF/views/writeForm.jsp";
		
	}
	
	//test메소드
	@RequestMapping(value="/test", method={RequestMethod.GET, RequestMethod.POST})
	public String test() {
		
		System.out.println("PhoneController>test()");
		
		//다오
		return "/WEB-INF/views/test.jsp";
		
	}
	
		//등록메소드
		//수정메소드
		//삭제메소드
		//리스트메소드
	

}
