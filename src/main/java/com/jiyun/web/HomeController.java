package com.jiyun.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.jiyun.model.Qna;
import com.jiyun.model.QnaRepository;

@Controller
public class HomeController {
	
	@Autowired //이 '인터페이스를 이용하여 CRUD를 할 것이다'를 명시한다.
	private QnaRepository qnaRepository;
	
	@GetMapping("/")
	public String goIndex(Qna qna, Model model){
		
		model.addAttribute("qnas", qnaRepository.findAll());
		return "/index";
	}
	
}
