package com.rubato.member.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.rubato.board.domain.Board;
import com.rubato.board.domain.PageInfo;
import com.rubato.board.domain.Search;
import com.rubato.board.service.BoardService;
import com.rubato.common.MailSendService;
import com.rubato.market.domain.MarketPayment;
import com.rubato.market.domain.MarketSell;
import com.rubato.market.domain.SearchInfo;
import com.rubato.market.service.MarketService;
import com.rubato.member.domain.CategoryCount;
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

	@Autowired
	private BoardService bService;
	
	@Autowired
	private MarketService marketService;
	
	
	/*===================================================
	 * 로그인 기능 관련
	 *===================================================*/
	// 멤버 로그인
	@RequestMapping(value="/member/login", method=RequestMethod.GET)
	public String loginView() { // 로그인 페이지 View
		 return "member/login";
	 }
	
	@RequestMapping(value="/member/login", method=RequestMethod.POST)
	public String loginLogic(HttpServletRequest request
			, @RequestParam("memberId") String memberId
			, @RequestParam("memberPwd") String memberPwd
			, Model model) { // 로그인 기능 구현
		try {
			Member mParam = new Member(memberId, memberPwd);
			Member member = mService.selectIdPw(mParam);
			HttpSession session = request.getSession();
			if(member != null) {
				session.setAttribute("loginUser", member);
				return "redirect:/index.jsp";
			}else {
				model.addAttribute("msg", "로그인 정보가 존재하지 않습니다.");
				return "member/login";
			}
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("msg", e.getMessage());
			return "member/login";
		}
		
	}
	// 로그인 확인 ajax
	@PostMapping("/member/loginCheck")
	@ResponseBody
	public String loginCheckLogic(
			HttpServletRequest request
			, String memberId
			, String memberPwd) { 
		HttpSession session = request.getSession();
		Member mParam = new Member(memberId, memberPwd);
		Member member = mService.selectIdPw(mParam);
		if(member!=null) { // 로그인 확인
			session.setAttribute("loginUser", member);
			return "true";
		}
		else {
			return "false";
		}
	}
	
	// 아이디 찾기 뷰
	@RequestMapping(value= "/member/findId",method= RequestMethod.GET)
	public String memberFindIdView() {
		return "member/findId";
	}
	
	// 아이디 찾기
	@RequestMapping(value="/member/findId",  method = RequestMethod.POST)
	public String findId(HttpSession session
			, @RequestParam("memberName") String memberName
			, @RequestParam("memberEmail") String memberEmail
			, Model model) {
		try {
			Member mParam = new Member();
			mParam.setMemberName(memberName);
			mParam.setMemberEmail(memberEmail);
			Member member =  mService.findId(mParam);
			model.addAttribute("member", member);
			return "member/findIdAfter";
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("msg", e.getMessage());
			return "member/findIdAfter";
		}
	}
	
	// 비밀번호 찾기 뷰
	@RequestMapping(value="/member/findPwd", method = RequestMethod.GET)
	public String memberFindPwdView() {
		return "member/findPwd";
	}
	
	//비밀번호 찾기
	@RequestMapping(value="member/findPwd", method = RequestMethod.POST)
	public String findPwd(HttpSession session
			, @RequestParam("memberId") String memberId
			, @RequestParam("memberEmail") String memberEmail
			, Model model) {
		try {
			Member mParam = new Member();
			mParam.setMemberId(memberId);
			mParam.setMemberEmail(memberEmail);
			Member member = mService.findPwd(mParam);
			model.addAttribute("member", member);
			return "member/findPwdAfter";
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("msg", e.getMessage());
			return "member/findPwdAfter";
		}
	}
	
	// 멤버 로그아웃
	@RequestMapping(value="/member/logout", method = RequestMethod.GET)
	public String memberLogout(HttpSession session, Model model) {
		if(session != null) {
			session.invalidate();
			return "redirect:/index.jsp";
		}else {
			model.addAttribute("msg", "로그아웃을 완료하지 못했습니다.");
			return "common/error";
		}
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
	
 	


	/*===================================================
	 * 마이페이지 기능 관련
	 *===================================================*/
		// 마이페이지
	@RequestMapping(value="/member/mypage", method= RequestMethod.GET)
	public String myPage(HttpServletRequest request, HttpSession session, Model model) {
			if(session.getAttribute("loginUser")!=null) { //로그인 됐음
				Member mOne = (Member)session.getAttribute("loginUser");
				String memberId = (mOne).getMemberId();
				Member member = mService.selectMemberById(memberId); // 회원 정보 수정
				CategoryCount count = new CategoryCount();
				int boardWriterCount = mService.boardWriterCount(memberId);
				count.setBoardWriteCount(boardWriterCount); // 작성한 글 내역 카운트
				int boardCommentCount = mService.boardCommentCount(memberId);
				count.setboardCommentCount(boardCommentCount); // 댓글 작성 내역
				int lessonWriteCount = mService.lessonWriteCount(memberId);
				count.setLessonWriteCount(lessonWriteCount); // 레슨 등록 내역
				int lessonApplyCount = mService.lessonApplyCount(memberId);
				count.setLessonApplyCount(lessonApplyCount); // 레슨 신청 내역
				int sellWriteCount = mService.sellWriteCount(memberId);
				count.setSellWriteCount(sellWriteCount); // 판매 등록 내역
				int buyApplyCount = mService.buyApplyCount(memberId);
				count.setBuyApplyCount(buyApplyCount);
				model.addAttribute("count", count);
				model.addAttribute("member", member);
				return "/member/mypage";
			}
			else { //로그인 되지 않았음
				return "redirect:/index.jsp";
			}
			
			
			
		
		}
	
	// 회원 정보 불러오기
	@RequestMapping(value="/member/modify" , method = RequestMethod.GET)
	public String MypageInfo(HttpSession session, Model model) {
		Member member = (Member)session.getAttribute("loginUser");
		model.addAttribute("member", member);
		return "member/modify";
	}
	
	// 회원 정보 수정
	@RequestMapping(value="/member/modify1", method = RequestMethod.POST)
	public String memberModify(
			@ModelAttribute Member member
			, @RequestParam("memberAddr1") String memberAddr1
			, @RequestParam("memberAddr2") String memberAddr2
			, Model model) {
		try {
			member.setMemberAddr(memberAddr1 + "++" + memberAddr2);
			int result = mService.updateMember(member);
			if(result > 0) {
				
				model.addAttribute("member", member);
				return "member/mypage";
			}else {
				model.addAttribute("msg", "정보 수정이 되지 않았습니다.");
				return "member/aa";
			}
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("msg", e.getMessage());
				return "member/mypage";
		}
	}
	
	// 회원 탈퇴
	@RequestMapping(value = "/member/delete", method = RequestMethod.GET)
	public String memberRemove(
			@RequestParam("memberId") String memberId
			, Model model) {
		try {
			int result = mService.deleteMember(memberId);
			model.addAttribute("member", memberId);
			if(result > 0) {
				return "redirect:/member/logout";
			}else {
				model.addAttribute("msg", "탈퇴가 완료되지 않았습니다.");
				return "member/modify";
			}
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("msg", e.getMessage());
			return "member/modify";
		
		
	}
}
	
	// 마이페이지 내가 쓴 글
	@RequestMapping(value = "/board/mypageMyWrite", method = RequestMethod.GET)
	public String MypageWriteView(
			 @ModelAttribute Search search
			 , HttpSession session
			 , @RequestParam(value = "page", required = false, defaultValue = "1") Integer currentPage, Model model) {
		try {
			Member mOne = (Member)session.getAttribute("loginUser");
			String memberId = (mOne).getMemberId();
			List<Board> boardList = bService.selectListById(memberId);
			model.addAttribute("myList", boardList);
			return "/board/mypageMyWrite";
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("msg", e.getMessage());
			return "/board/mypageMyWrite";
		}
	}
	
	// 내가 쓴 글 상세화면
		@RequestMapping(value = "/board/mypageMyWritedetail", method = RequestMethod.GET)
		public String boardDetailView(@RequestParam("boardNo") int boardNo, Model model) {
			try {
				Board board = bService.selectOneByNo(boardNo);
				model.addAttribute("board", board);
				return "board/mypageMyWritedetail";
			} catch (Exception e) {
				e.printStackTrace();
				model.addAttribute("msg", e.getMessage());
				return "common/error";
			}
		}
	
	// 마이페이지 내가 쓴 댓글
		
	// 마이페이지 나의 판매 내역
		@GetMapping("/market/mypageSellListView")
		public String mypageSellListView(
					  SearchInfo searchInfo
				    , Model model
					, HttpSession session
					, @RequestParam(value="page", required=false, defaultValue="1") Integer page) { // 게시물 목록 View
			try {
				Member mOne = (Member)session.getAttribute("loginUser");
				String memberId = (mOne).getMemberId();
				List<MarketSell> sList = marketService.searchsellListById(memberId);
				model.addAttribute("sList", sList);
				return "/market/mypageSellListView";
			} catch (Exception e) {
				e.printStackTrace();
				model.addAttribute("mysellList", e.getMessage());
				return "/market/mypageSellListView";
			}
		}
		
	// 마이페이지 구매 신청 내역
		@GetMapping("/market/searchbuyListById")
		public String searchbuyListById(
					  SearchInfo searchInfo
				    , Model model
					, HttpSession session
					, @RequestParam(value="page", required=false, defaultValue="1") Integer page) { // 게시물 목록 View
			try {
				Member mOne = (Member)session.getAttribute("loginUser");
				String memberId = (mOne).getMemberId();
				List<MarketPayment> paymentList = marketService.searchbuyListById(memberId);
				model.addAttribute("paymentList", paymentList);
				return "/market/searchbuyListById";
			} catch (Exception e) {
				e.printStackTrace();
				model.addAttribute("paymentList", e.getMessage());
				return "/market/searchbuyListById";
			}
		}
}















