package com.rubato.member.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.rubato.member.domain.Member;
import com.rubato.member.service.MemberService;

@Controller
public class MemberController {
	/** [필독] 
	// 1. Controller 메소드 구현 시, "기능명+View/Logic" 형태로 작성하도록 합니다.
	//       (ex) 1. 회원가입 기능
	//        - 회원가입 기능 페이지 이동 -> registerView()
	//        - 회원가입 기능 처리 -> registerLogic()
	// 2. 동일 기능 관련 메소드는 위에 아래 양식처럼 =======으로 대분류를 해주고,
	//    세부 메소드 기능에 대한 설명은 중괄호({}) 옆에 간단히 주석으로 표기해주도록 합니다.
	*/
	@Autowired
	private MemberService mService;
	
	
	/*===================================================
	 * 로그인 기능 관련
	 *===================================================*/
	@RequestMapping(value="/member/login", method=RequestMethod.GET)
	public String loginView() { // 로그인 페이지 View
		 return "";
	 }
	
	@RequestMapping(value="/member/login", method=RequestMethod.POST)
	public String loginLogic() { // 로그인 기능 구현
		return "";
	}
	
	/*===================================================
	 * 회원가입 기능 관련
	 *===================================================*/
	@RequestMapping(value="/member/register", method=RequestMethod.GET)
	public String registerView() {
		return "member/register";
	}
	@RequestMapping(value="/member/register", method=RequestMethod.POST)
	public String registerLogic() {
		return "";
	}
	
}
