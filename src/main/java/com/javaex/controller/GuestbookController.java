package com.javaex.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.javaex.dao.GuestbookDao;
import com.javaex.vo.GuestbookVo;

@Controller
public class GuestbookController {
	//필드
	//생성자
	//메소드gs
	//메소드일반
	//리스트
	@RequestMapping(value="/list", method={RequestMethod.GET, RequestMethod.POST})
	public String list(Model model) {
		System.out.println("GuestbookController>list()");
		
		
		//Dao - getList꺼내오기
		GuestbookDao guestbookDao = new GuestbookDao();
		List<GuestbookVo> guestList = guestbookDao.getList();
		
		//Model을 통해, DispatcherServlet에게 데이터 보내기(request attribute에 넣는다)
		model.addAttribute("guestList", guestList);
		
		//포워드
		return "/WEB-INF/views/list.jsp";
	}
	
	//게스트북 등록
	@RequestMapping(value="/write", method={RequestMethod.GET, RequestMethod.POST})
	public String write(@ModelAttribute GuestbookVo guestbookVo) {
		System.out.println("GuestbookController>write()");
		
		//파라미터 꺼낼 필요 없어짐
		//파라미터들을 한꺼번에 personVo로 꺼냈음-> 개별의 파라미터들을 vo로 묶을 필요가 없음
		
		//dao로 저장하기
		GuestbookDao guestbookDao = new GuestbookDao();
		guestbookDao.insert(guestbookVo);
		
		return "redirect:/list";
	}
	
	//게스트북 삭제폼
	@RequestMapping(value="/deleteForm", method={RequestMethod.GET, RequestMethod.POST})
	public String deleteForm() {
		System.out.println("GuestbookController>deleteForm()");
		
		return "/WEB-INF/views/deleteForm.jsp";
	}
	
	//게스트북 삭제
	@RequestMapping(value="/delete", method={RequestMethod.GET, RequestMethod.POST})
	public String delete(@ModelAttribute GuestbookVo guestbookVo) {
		System.out.println("GuestbookController>delete()");
		
		//Dao로 처리하기(삭제)
		GuestbookDao guestbookDao = new GuestbookDao();
		int count = guestbookDao.delete(guestbookVo);
		
		return "redirect:/list";
	}
}