package com.rubato.manager.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.rubato.manager.service.ManagerService;
import com.rubato.member.domain.Member;

@Controller
public class ManagerController {
	@Autowired
	private ManagerService managerService;
	
	// 관리자 메인 보이게
	@RequestMapping(value = "/manager/mainView", method = RequestMethod.GET)
	public String managerMainView() {
		return "manager/managerMain";
	}
	
	// 관리자 메인(로그인, 회원 리스트)
	@RequestMapping(value = "/manager/main")
	public String managerMain(
		  HttpSession session
		, HttpServletRequest request
		, Model model
		, Member member     ) {
		
		// 세션이 있으면 바로 페이지 이동 
		// (첫 로그인은 세션이 없으므로 else if 실행)
		// (로그인 후 페이지 내에서 a태그 이동시 매개변수 member에 null이 들어가므로
		//   else if문에서 null로 된 세션 생성을 못하게 하기 위해) 
		if(session.getAttribute("loginUser")!=null) {
			List<Member> mList = managerService.selectMembers();
			if(!mList.isEmpty()) {
				model.addAttribute("mList", mList);
				return "manager/managerMember";
			}
			
			return "manager/managerMember";
		}
		// 로그인 성공하면 세션 생성 후 페이지 이동
		else if(member.getMemberId().equals("mngmt2023") && member.getMemberPwd().equals("1234")) {
			session = request.getSession();
			session.setAttribute("loginUser", member);
			List<Member> mList = managerService.selectMembers();
			if(!mList.isEmpty()) {
				model.addAttribute("mList", mList);
				return "manager/managerMember";
			} else {
				
				return "manager/managerMember";
			}
		}
		// 로그인 실패 시
		else {
			int fail = 0;
			model.addAttribute("loginUser", fail);
			return "manager/managerMain";
		} 
	}
	

	// 로그아웃
	@RequestMapping(value = "/manager/logout", method = RequestMethod.GET)
	public String managerLogout(HttpSession session) {
		session.invalidate();
		return "redirect:/manager/mainView";
	}
	
	// 회원 탈퇴- 관리자
	@RequestMapping(value = "/manager/memberOut", method = RequestMethod.GET)
	public String managerMemberOut(@RequestParam("memberId") String memberId, Model model) {
		int result = managerService.deleteMember(memberId);
		if(result > 0) {
			List<Member> mList = managerService.selectMembers();
			if(!mList.isEmpty()) {
				model.addAttribute("mList", mList);
				return "manager/managerMember";
			} else {
				return "manager/managerMember";
			}
		} else {
			return "manager/managerMember";
		}
	}
	
	
	
	
	
	@RequestMapping(value = "/manager/memberView", method = RequestMethod.GET)
	public String managerMemberView() {
		return "manager/managerMember";
	}
	
	@RequestMapping(value = "/manager/Board", method = RequestMethod.GET)
	public String managerBoardView() {
		return "manager/managerBoard";
	}
	
	
	

}
