package com.rubato.report.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.rubato.member.domain.Member;
import com.rubato.report.domain.Report;
import com.rubato.report.service.ReportService;

@Controller
public class ReportController {

	@Autowired
	private ReportService rService;
	
	/*===================================================
	 * 신고 관리 기능 관련 - 신고접수
	 *===================================================*/
	
	@RequestMapping(value = "/report/writeView", method = RequestMethod.GET)
	public String reportWriteView(		// 신고 창 띄우기
			String boardCategory
			, int boardNo
			, String reportContent
			, Model model
			, HttpServletRequest request) {
		HttpSession session = request.getSession();
		Member member = (Member)session.getAttribute("loginUser");
		if(member == null ) {
			return "redirect:/member/login";
		}
		model.addAttribute("member", member);
		model.addAttribute("boardCategory", boardCategory);
		model.addAttribute("boardNo", boardNo);
		model.addAttribute("reportContent", reportContent);
		return "report/reportWrite";
	}
	
	@PostMapping("/report/writeView")
	public String reportWriteView2(		// 관리자 - 신고게시물 번호 클릭시 신고내용 볼 수 있음
			String boardCategory
			, int boardNo
			, String reportContent
			, Model model
			, HttpServletRequest request) {
		HttpSession session = request.getSession();
		Member member = (Member)session.getAttribute("loginUser");
		if(member == null ) {
			return "redirect:/member/login";
		}
		model.addAttribute("member", member);
		model.addAttribute("boardCategory", boardCategory);
		model.addAttribute("boardNo", boardNo);
		model.addAttribute("reportContent", reportContent);
		return "report/reportWrite";
	}
	
	@RequestMapping(value = "/report/write", method = RequestMethod.POST)
	public String reportWriteLogic(Report report) {		// 신고 글쓰기
		System.out.println(report);
		int result = rService.insertReport(report);
		
		return "redirect:/board/list";
	}
	
	@RequestMapping(value = "/report/updateCondition", method = RequestMethod.GET)
	public String reportUpdateCondition(
			@RequestParam("reportNo") Integer reportNo
			, Model model
			) {
		int result = rService.updateCondition(reportNo);
		if(result > 0) {
			return "redirect:/manager/reportBoard";
		}
		return "redirect:/manager/reportBoard";
	}
}
