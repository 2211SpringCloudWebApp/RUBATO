package com.rubato.manager.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.rubato.manager.service.ManagerService;
import com.rubato.member.domain.Member;
import com.rubato.member.domain.PageInfo;
import com.rubato.member.domain.SearchMember;

@Controller
public class ManagerController {
	@Autowired
	private ManagerService managerService;
	PageInfo pi = null;
	
	
	@RequestMapping(value = "/manager/mainView", method = RequestMethod.GET)
	public String managerMainView() {		// 관리자 메인 View
		return "manager/managerMain";
	}
	/*===================================================
	 * 로그인 기능 관련
	 *===================================================*/
	
	
	@RequestMapping(value = "/manager/main", method=RequestMethod.POST)
	public String managerLoginLogic(		// 관리자 메인 Logic(로그인 기능)
		  HttpSession session
		, HttpServletRequest request
		, Model model
		, Member member) {
		
		if(member.getMemberId().equals("mngmt2023") && member.getMemberPwd().equals("1234")) {
			session = request.getSession();
			session.setAttribute("loginUser", member);
			return "redirect:/manager/main?page=1";
		}
		// 로그인 실패 시
//		(managerMain.jsp로 넘어가서 로그인 실패 모달창 실행)
		else {
			int fail = 0;
			model.addAttribute("loginUser", fail);
			return "manager/managerMain";
		} 
	}
	
	/*===================================================
	 * 회원 관리 기능 관련
	 *===================================================*/
	// 관리자 메인(회원 리스트)
	@RequestMapping(value = "/manager/main", method=RequestMethod.GET)
	public String managerMainLogic(		// 관리자 메인 Logic(로그인 후 회원 리스트 보여주는 기능)
		  HttpSession session
		, HttpServletRequest request
		, @RequestParam(value="page", required=false, defaultValue="1") Integer page
		, Model model) {
		int totalCount = managerService.getListCount();
		pi = this.getPageInfo(page, totalCount);
		if(session.getAttribute("loginUser")!=null) {
			List<Member> mList = managerService.selectMembers(pi);
			if(!mList.isEmpty()) {
				model.addAttribute("pi", pi);
				model.addAttribute("mList", mList);
			}
		}
		return "manager/managerMember";
	}
	
	// searchMember.jsp 에서 select로 검색하게 해주는 메소드
	@RequestMapping(value="/manager/searchMember", method=RequestMethod.GET)
	public String memberSearchLogic(		// 회원 검색 기능
			@ModelAttribute SearchMember searchMember,
			// @RequestParam("searchValue") String keyword
			//, @RequestParam(value="searchMemberCondition") String memberCondition
			 @RequestParam(value="page", required=false, defaultValue="1") Integer page
			, Model model) {
		int totalCount = managerService.getListCount(searchMember);
		pi = this.getPageInfo(page, totalCount);
		try {
			List<Member> searchList = managerService.selectListByKeyword(pi, searchMember);
			if(!searchList.isEmpty()) {
				model.addAttribute("searchMember", searchMember);
				model.addAttribute("pi", pi);
				model.addAttribute("sList", searchList);
				return "manager/searchMember";
			}else {
				return "manager/searchMember";
			}
			
		} catch (Exception e) {
			return "manager/searchMember";
		}
	}
	
	
	
	@RequestMapping(value = "/manager/memberOut", method = RequestMethod.GET)
	public String managerMemberOutLogic(		// 회원 탈퇴- 관리자
			@RequestParam("memberId") String memberId
			, Model model) {
		int result = managerService.deleteMember(memberId);
		if(result > 0) {
//			List<Member> mList = managerService.selectMembers(pi);
//			if(!mList.isEmpty()) {
//				model.addAttribute("pi", pi);
//				model.addAttribute("mList", mList);
//				return "manager/managerMember";
//			} else {
			return "redirect:/manager/main";
//			}
		} else {
			// 에러 페이지 이동으로 변경 필요
			return "redirect:/manager/main";
		}
	}
	
	
// 페이징 처리 메소드
	private PageInfo getPageInfo(int currentPage, int totalCount) {
		PageInfo pi = null;
		int boardLimit = 10; 	// 한 페이지 당 게시글 갯수
		int naviLimit = 5;		// 한 페이지 당 pageNavi 수
		int maxPage;			// 페이지의 마지막 번호
		int startNavi;			// pageNavi 시작값
		int endNavi;			// pageNavi 끝값
		
		maxPage = (int)((double)totalCount/boardLimit+0.9);
		startNavi = (((int)((double)currentPage/naviLimit+0.9))-1)*naviLimit+1;
		endNavi = startNavi + naviLimit - 1;
		if(endNavi > maxPage) {
			endNavi = maxPage;
		}
		pi = new PageInfo(currentPage, boardLimit, naviLimit, startNavi, endNavi, totalCount, maxPage);
		return pi;
	}


	// 로그아웃
	@RequestMapping(value = "/manager/logout", method = RequestMethod.GET)
	public String managerLogoutLogic(HttpSession session) {
		session.invalidate();
		return "redirect:/manager/mainView";
	}


	//	@RequestMapping(value = "/manager/memberView", method = RequestMethod.GET)
//	public String managerMemberView() {
//		return "manager/managerMember";
//	}
//	
	@RequestMapping(value = "/manager/Board", method = RequestMethod.GET)
	public String managerBoardView() {
		return "manager/managerBoard";
	}
	
	
	

}
