package com.jiyun.web;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jiyun.model.User;
import com.jiyun.model.UserRepository;

@Controller
@RequestMapping("/users")
public class UserController {
	
	@Autowired
	private UserRepository userRepository;
	
	//회원가입창 이동
	@GetMapping("/form")
	public String goUserJoin(){
		System.out.println("/user/form 탔다!");
		return "/user/form";
	}
	
	//회원가입 실행
	@PostMapping("/create")
	public String joinUser(User user){
		System.out.println("user = " + user);
		System.out.println("/user/create 탔다!");
		userRepository.save(user);
		return "redirect:/users";
	}
	
	//가입된 유저 리스트 보기
	@GetMapping("")
	public String showUserList(User user, Model model){
		System.out.println("user = " + user);
		System.out.println("/user/showUserList 탔다!");
		model.addAttribute("users", userRepository.findAll());
		return "/user/list";
	}
	
	//로그인 화면 이동하기
	@GetMapping("/login")
	public String goLoginPage(){
		return "/user/login";
	}
	
	//로그인 하기
	@PostMapping("/login")
	public String login(String userId, String password, HttpSession session){
		User dbUser = userRepository.findByUserId(userId);
		System.out.println("userId = " + userId);
		System.out.println("password = " + password);
		//1. userId로 찾는다.
		if(dbUser==null){
			return "redirect:/users/login";
		}
		
		//2. 비밀번호가 같은지?
		if(!dbUser.matchPassword(password)){
			return "redirect:/users/login";
		}
		
		session.setAttribute("loginUser", dbUser);
		
		return "redirect:/";
	}
}
