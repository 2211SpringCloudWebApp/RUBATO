package com.rubato.member.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.rubato.common.MailSendService;
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
	
	@Autowired
	private MailSendService mailSendService;
	
	
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
	@GetMapping("/member/register")
	public String registerView() {  // 회원가입 페이지 View
		return "member/register";
	}
	@PostMapping("/member/register")
	public String registerLogic(Member member, String memberEmail1, String memberEmail2, String memberAddr1, String memberAddr2) { // 회원가입 기능 구현
		String memberEmail = memberEmail1+"@"+memberEmail2;
		String memberAddr = memberAddr1+"++"+memberAddr2;
		member.setMemberEmail(memberEmail);
		member.setMemberAddr(memberAddr);
		int result = mService.insertMember(member);
		if(result>0) {
			return "redirect:/";
		}
		else {
			System.out.println("회원가입 실패");
			return "";
		}
	}
	
	@GetMapping("/member/register/idCheck")
	@ResponseBody
	public String idCheckLogic(String memberId) { // 아이디 중복체크 ajax
		Member member = mService.selectMemberById(memberId);
		if(member!=null) { // 아이디 존재
			return "false";
		}
		else {
			return "true";
		}
	}
	
	@GetMapping("/member/register/nickCheck")
	@ResponseBody
	public String nickCheckLogic(String memberNickname) { // 닉네임 중복체크 ajax
		Member member = mService.selectMemberByNickname(memberNickname);
		if(member!=null) { // 닉네임 존재
			return "false";
		}
		else {
			return "true";
		}
	}
	
	@GetMapping("/member/register/mailAuth")
	@ResponseBody
	public String mailAuthLogic(String email) { // 이메일 인증 ajax
		String code = mailSendService.registerEmail(email);
		return code;
	}
	
}
