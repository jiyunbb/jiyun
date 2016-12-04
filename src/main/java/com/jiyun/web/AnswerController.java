package com.jiyun.web;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jiyun.model.AnswerRepository;
import com.jiyun.model.User;

@Controller
@RequestMapping("/questions/{questionId}/answers")
//답변은 질문에게 완전히 종속되기 때문
public class AnswerController {
	
	@Autowired 
	private AnswerRepository answerRepository;
	
	// 댓글 저장하는 기능
	@PostMapping("")
	public String create(@PathVariable long questionId, String contents, HttpSession session){
		
//		Answer answer = new Answer(writer, contents);
//		User dbUser = HttpSession
		return null;
	}
	
	// 댓글을 가져오는 기능

}
