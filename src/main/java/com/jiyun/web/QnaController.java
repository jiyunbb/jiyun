package com.jiyun.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jiyun.model.Qna;
import com.jiyun.model.QnaRepository;

@Controller
@RequestMapping("/qna")
public class QnaController {

	@Autowired
	private QnaRepository qnaRepository;
	
	//질문하기 페이지 이동
	@GetMapping("/form")
	public String formQuestion(){
		return "/qna/form";
	}
	
	//질문하기 버튼 눌러서 QNA 테이블에 INSERT가 되어야 하는 상황
	@PostMapping("/create")
	public String createQuestion(Qna qna){
		qnaRepository.save(qna);
		return "redirect:/";
	}
	
	//질문사항 자세히 보기(qna_Detail Show) --> index에서 타이틀을 눌렀을 때!
	@GetMapping("/{index}")
	public String qnaDetailShow(@PathVariable("index") int index, Model model){
		model.addAttribute("qna", qnaRepository.findOne(index));
		return "/qna/show";
	}
}
